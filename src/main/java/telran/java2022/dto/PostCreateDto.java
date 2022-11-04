package telran.java2022.dto;

import java.util.ArrayList;

import lombok.Getter;

@Getter
public class PostCreateDto {
	String title;
	String content;
	ArrayList<String> tags;
}
