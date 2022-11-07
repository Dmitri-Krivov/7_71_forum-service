package telran.java2022.forum.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@EqualsAndHashCode(of = {"id"})
@Document(collection = "Posts")
public class Post {
	@Id
	String id;
	@Setter
	String title;
	@Setter
	String content;
	@Setter
	String author;
	@Setter
	LocalDateTime dateCreated;
	Set<String> tags;
	int likes;
	List<UserComment> comments;
	
	public Post() {
		dateCreated = LocalDateTime.now();
		comments = new ArrayList<>();
	}

	public Post(String title, String content, String author, Set<String> tags) {
		this();
		this.title = title;
		this.content = content;
		this.author = author;
		this.dateCreated = LocalDateTime.now();
		this.tags = tags;
		likes = 0;
	}

	public void addTags(Set<String> nTegs) {
		tags.addAll(nTegs);
	}

	public void addLike() {
		likes++;
	}

	public void addComments(UserComment messageDto) {
		comments.add(messageDto);
	}

}
