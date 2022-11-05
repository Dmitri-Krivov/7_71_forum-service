package telran.java2022.forum.model;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.springframework.data.annotation.Id;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
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
	ArrayList<String> tags = new ArrayList<>();
	Integer likes;
	ArrayList<UserComment> comments = new ArrayList<>();

	public Post(String title, String content, String author, ArrayList<String> tags) {
		this.title = title;
		this.content = content;
		this.author = author;
		this.dateCreated = LocalDateTime.now();
		this.tags = tags;
		likes = 0;
	}

	public void addTags(ArrayList<String> nTegs) {
		tags.addAll(nTegs);
	}

	public void addLike() {
		likes++;
	}

	public void addComments(UserComment messageDto) {
		comments.add(messageDto);
	}

}
