package telran.java2022.forum.model;

import java.time.LocalDateTime;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@EqualsAndHashCode(of = {"user", "dateCreated"})
public class UserComment {
	@Setter
	String user;
	@Setter
	String message;
	LocalDateTime dateCreated;
	Integer likes;

	public UserComment(String user, String message) {
		this();
		this.user = user;
		this.message = message;
		dateCreated = LocalDateTime.now();
		likes = 0;
	}
	public UserComment() {
		dateCreated = LocalDateTime.now();
	}
	public void addLike() {
		likes++;
	}

}
