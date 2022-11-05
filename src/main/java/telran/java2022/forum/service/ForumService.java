package telran.java2022.forum.service;

import java.util.ArrayList;
import java.util.List;

import telran.java2022.forum.dto.PostCreateDto;
import telran.java2022.forum.dto.PostDto;
import telran.java2022.forum.dto.PostFindPeriodDto;
import telran.java2022.forum.dto.PostUpdateDto;
import telran.java2022.forum.model.Post;

public interface ForumService {
	Post addPost(String author, PostCreateDto postCreateDto);
	PostDto findPost(String id);
	void addLike(String id);
	ArrayList<PostDto> findPostByAuthor(String author);
	PostDto addComment(String id,  String author);
	PostDto deletePost(String id);
	ArrayList<PostDto> findPostByTags(List<String> tags);
	ArrayList<PostDto> findPostByPeriod(PostFindPeriodDto postFindPeriodDto);
	PostDto updatePost(PostUpdateDto postUpdateDto);
	
}
