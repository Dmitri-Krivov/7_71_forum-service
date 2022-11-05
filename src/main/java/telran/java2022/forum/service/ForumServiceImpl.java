package telran.java2022.forum.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import telran.java2022.forum.dto.PostCreateDto;
import telran.java2022.forum.dto.PostDto;
import telran.java2022.forum.dto.PostFindPeriodDto;
import telran.java2022.forum.dto.PostUpdateDto;
import telran.java2022.forum.model.Post;
import telran.java2022.forum.repository.ForumRepository;
@Service
@RequiredArgsConstructor
public class ForumServiceImpl implements ForumService {

		final ForumRepository forumRepository;
		final ModelMapper modelMapper;
	@Override
	public Post addPost(String author, PostCreateDto postCreateDto) {
//		if(forumRepository.findById(postCreateDto.getId()).isPresent()) {
//			return null;
//		}
		Post post = new Post( postCreateDto.getTitle(), postCreateDto.getContent(), author, postCreateDto.getTags());
//		Post post = modelMapper.map(postCreateDto, Post.class);

		forumRepository.save(post);
		return post;
	}

	@Override
	public PostDto findPost(String id) {
		
		return null;
	}

	@Override
	public void addLike(String id) {
		// TODO Auto-generated method stub

	}

	@Override
	public ArrayList<PostDto> findPostByAuthor(String author) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PostDto addComment(String id, String author) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PostDto deletePost(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<PostDto> findPostByTags(List<String> tags) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<PostDto> findPostByPeriod(PostFindPeriodDto postFindPeriodDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PostDto updatePost(PostUpdateDto postUpdateDto) {
		// TODO Auto-generated method stub
		return null;
	}

}
