package telran.java2022.forum.dto;

import java.util.Set;

import lombok.Getter;

@Getter
public class PostCreateDto {
	String title;
	String content;
	Set<String> tags;
}
