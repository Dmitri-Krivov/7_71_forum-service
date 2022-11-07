package telran.java2022.forum.service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import telran.java2022.forum.dto.PostCreateDto;
import telran.java2022.forum.dto.PostDto;
import telran.java2022.forum.dto.PostFindPeriodDto;
import telran.java2022.forum.dto.PostMessageDto;
import telran.java2022.forum.dto.PostUpdateDto;
import telran.java2022.forum.dto.exceptions.PostNotFoundException;
import telran.java2022.forum.model.Post;
import telran.java2022.forum.model.UserComment;
import telran.java2022.forum.repository.ForumRepository;

@Service
@RequiredArgsConstructor
public class ForumServiceImpl implements ForumService {

	final ForumRepository forumRepository;
	final ModelMapper modelMapper;

	@Override
	public PostDto addPost(String author, PostCreateDto postCreateDto) {
		Post post = new Post(postCreateDto.getTitle(), postCreateDto.getContent(), author, postCreateDto.getTags());
		forumRepository.save(post);
		return modelMapper.map(post, PostDto.class);
	}

	@Override
	public PostDto findPost(String id) {
		Post post = forumRepository.findById(id).orElseThrow(() -> new PostNotFoundException(id));
		return modelMapper.map(post, PostDto.class);
	}

	@Override
	public void addLike(String id) {
		Post post = forumRepository.findById(id).orElseThrow(() -> new PostNotFoundException(id));
		post.addLike();
		forumRepository.save(post);
	}

	@Override
	public List<PostDto> findPostByAuthor(String author) {
		return forumRepository.findByAuthorIgnoreCase(author).collect(Collectors.toList());
	}

	@Override
	public PostDto addComment(String id, String user, PostMessageDto messageDto) {
		Post post = forumRepository.findById(id).orElseThrow(() -> new PostNotFoundException(id));
		UserComment userComment = new UserComment(user, messageDto.getMessage());
		post.addComments(userComment);
		forumRepository.save(post);
		return modelMapper.map(post, PostDto.class);
	}

	@Override
	public PostDto deletePost(String id) {
		Post post = forumRepository.findById(id).orElseThrow(() -> new PostNotFoundException(id));
		forumRepository.delete(post);
		return modelMapper.map(post, PostDto.class);
	}

	@Override
	public List<PostDto> findPostsByTags(List<String> tags) {
		return forumRepository.findByTagsInIgnoreCase(tags).collect(Collectors.toList());
	}

	@Override
	public List<PostDto> findPostsByPeriod(PostFindPeriodDto postFindPeriodDto) {
		return forumRepository.findByDateCreatedBetween(postFindPeriodDto.getDateFrom(), postFindPeriodDto.getDateTo())
				.collect(Collectors.toList());
	}

	@Override
	public PostDto updatePost(String id, PostUpdateDto postUpdateDto) {
		Post post = forumRepository.findById(id).orElseThrow(() -> new PostNotFoundException(id));
		String title = postUpdateDto.getTitle();
		if (title != null) {
			post.setTitle(title);
		}
		Set<String> tags = postUpdateDto.getTags();
		if (tags != null) {
			post.addTags(tags);
		}
		forumRepository.save(post);
		return modelMapper.map(post, PostDto.class);
	}

}
