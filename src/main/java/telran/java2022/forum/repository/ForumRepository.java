package telran.java2022.forum.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.data.repository.CrudRepository;

import telran.java2022.forum.dto.PostDto;
import telran.java2022.forum.model.Post;

public interface ForumRepository extends CrudRepository<Post, String> {
	Stream<PostDto> findByAuthorIgnoreCase(String author);

	Stream<PostDto> findByTagsInIgnoreCase(List<String> tags);

	Stream<PostDto> findByDateCreatedBetween(LocalDate from, LocalDate to);

}
