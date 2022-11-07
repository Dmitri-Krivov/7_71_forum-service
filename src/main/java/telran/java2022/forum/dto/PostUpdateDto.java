package telran.java2022.forum.dto;

import java.util.Set;

import lombok.Getter;

@Getter
public class PostUpdateDto {
	String title;
	Set<String> tags;
}
