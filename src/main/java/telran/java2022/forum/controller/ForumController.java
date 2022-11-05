package telran.java2022.forum.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import telran.java2022.forum.dto.PostCreateDto;
import telran.java2022.forum.dto.PostDto;
import telran.java2022.forum.dto.PostFindPeriodDto;
import telran.java2022.forum.dto.PostMessageDto;
import telran.java2022.forum.dto.PostUpdateDto;
import telran.java2022.forum.service.ForumService;

@RestController
@RequiredArgsConstructor
public class ForumController {
	final ForumService forumService;

	@PostMapping("/forum/post/{author}")
	public PostDto addPost(@PathVariable String author, @RequestBody PostCreateDto postCreateDto) {
		return forumService.addPost(author, postCreateDto);
	}

	@GetMapping("/forum/post/{id}")
	public PostDto findPost(@PathVariable String id) {
		return forumService.findPost(id);
	}

	@PutMapping("/forum/post/{id}/like")
	public void addLikeOnPost(@PathVariable String id) {
		forumService.addLike(id);
	}

	@GetMapping("/forum/posts/author/{author}")
	public List<PostDto> findPostsByAuthor(@PathVariable String author) {
		return forumService.findPostByAuthor(author);
	}

	@PutMapping("/forum/post/{id}/comment/{user}")
	public PostDto addCommentOnPost(@PathVariable String id, @PathVariable String user,
			@RequestBody PostMessageDto messageDto) {
		return forumService.addComment(id, user, messageDto);
	}

	@DeleteMapping("/forum/post/{id}")
	public PostDto addCommentOnPost(@PathVariable String id) {
		return forumService.deletePost(id);
	}

	@PostMapping("/forum/posts/tags")
	public List<PostDto> findPostsByTegs(@RequestBody List<String> tags) {
		return forumService.findPostsByTags(tags);
	}

	@PostMapping("/forum/posts/period")
	public List<PostDto> findPostsByPeriod(@RequestBody PostFindPeriodDto postFindPeriodDto) {
		return forumService.findPostsByPeriod(postFindPeriodDto);
	}

	@PutMapping("/forum/post/{id}")
	public PostDto updatePost(@PathVariable String id, @RequestBody PostUpdateDto postUpdateDto) {
		return forumService.updatePost(id, postUpdateDto);
	}

}
