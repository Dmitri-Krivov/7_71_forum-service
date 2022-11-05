package telran.java2022.forum.model;

import java.time.LocalDateTime;

import lombok.Getter;

@Getter
public class UserComment {
	String user;
	String message;
	LocalDateTime dateCreated;
	Integer likes;

	public UserComment(String user, String message) {
		this.user = user;
		this.message = message;
		dateCreated = LocalDateTime.now();
		likes = 0;
	}

}
