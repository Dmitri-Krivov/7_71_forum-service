package telran.java2022.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import telran.java2022.model.UserComment;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class ForumDto {
	String id;
	String title;
	String content;
	String author;
	LocalDateTime dateCreated;
	ArrayList<String> tags;
	Integer likes;
	ArrayList<UserComment> comments;
}
