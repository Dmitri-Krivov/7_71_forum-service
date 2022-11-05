package telran.java2022.forum.service;

import java.util.List;

import telran.java2022.forum.dto.PostCreateDto;
import telran.java2022.forum.dto.PostFindPeriodDto;
import telran.java2022.forum.dto.PostMessageDto;
import telran.java2022.forum.dto.PostUpdateDto;
import telran.java2022.forum.model.Post;

public interface ForumService {
	Post addPost(String author, PostCreateDto postCreateDto);

	Post findPost(String id);

	void addLike(String id);

	List<Post> findPostByAuthor(String author);

	Post addComment(String id, String author, PostMessageDto messageDto);

	Post deletePost(String id);

	List<Post> findPostsByTags(List<String> tags);

	List<Post> findPostsByPeriod(PostFindPeriodDto postFindPeriodDto);

	Post updatePost(String id, PostUpdateDto postUpdateDto);

}
