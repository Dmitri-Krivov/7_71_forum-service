package telran.java2022.forum.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import telran.java2022.forum.dto.PostCreateDto;
import telran.java2022.forum.dto.PostDto;
import telran.java2022.forum.model.Post;
import telran.java2022.forum.service.ForumService;

@RestController
@RequiredArgsConstructor
public class ForumController {
	final ForumService forumService;

	@PostMapping("/forum/post/{author}")
	public Post addPost(@PathVariable String author, @RequestBody PostCreateDto postCreateDto) {
		return forumService.addPost(author, postCreateDto);
	}

	@GetMapping("/forum/post/{id}")
	public Post findPost(@PathVariable String id) {
		return forumService.findPost(id);
	}

//	@PutMapping("/forum/post/{id}/like")
//	public void addLikeOnPost(@PathVariable String id) {
//		forumService.addLikeOnPost(id);
//	}
//
//	@GetMapping("/forum/posts/author/{author}")
//	public ArrayList<PostDto> findPostsByAuthor(@PathVariable String author) {
//		return forumService.findPostsByAuthor(author);
//	}
//
//	@PutMapping("/forum/post/{id}/comment/{commentator}")
//	public PostDto addCommentOnPost(@PathVariable String id, @PathVariable String author) {
//		return forumService.addCommentOnPost(id, author);
//	}
//
//	@DeleteMapping("/forum/post/{id}")
//	public PostDto addCommentOnPost(@PathVariable String id) {
//		return forumService.deletePost(id);
//	}
//
//	@PostMapping("/forum/posts/tags")
//	public ArrayList<PostDto> findPostsByTeg(@RequestBody List<String> tags) {
//		return forumService.findPostsByTeg(tags);
//	}
//
//	@PostMapping("/forum/posts/period")
//	public ArrayList<PostDto> findPostsByPeriod(@RequestBody PostFindPeriodDto postFindPeriodDto) {
//		return forumService.findPostsByPeriod;
//	}
//
//	@PutMapping("/forum/post/{id}")
//	public PostDto updatePost(@PathVariable String id, @RequestBody PostUpdateDto postUpdateDto) {
//		return forumService.updatePost(id, postUpdateDto);
//	}

}
