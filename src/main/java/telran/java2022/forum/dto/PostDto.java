package telran.java2022.forum.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import telran.java2022.forum.model.UserComment;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class PostDto {
	String id;
	String title;
	String content;
	String author;
	@JsonFormat(pattern = "yyy-MM-dd'T'HH:mm:ss")
	LocalDateTime dateCreated;
	Set<String> tags;
	Integer likes;
	ArrayList<UserComment> comments;
}
