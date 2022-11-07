package telran.java2022.forum.service;

import java.util.List;

import telran.java2022.forum.dto.PostCreateDto;
import telran.java2022.forum.dto.PostDto;
import telran.java2022.forum.dto.PostFindPeriodDto;
import telran.java2022.forum.dto.PostMessageDto;
import telran.java2022.forum.dto.PostUpdateDto;

public interface ForumService {
	PostDto addPost(String author, PostCreateDto postCreateDto);

	PostDto findPost(String id);

	void addLike(String id);

	Iterable<PostDto> findPostByAuthor(String author);

	PostDto addComment(String id, String author, PostMessageDto messageDto);

	PostDto deletePost(String id);

	Iterable<PostDto> findPostsByTags(List<String> tags);

	Iterable<PostDto> findPostsByPeriod(PostFindPeriodDto postFindPeriodDto);

	PostDto updatePost(String id, PostUpdateDto postUpdateDto);

}
