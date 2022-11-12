package telran.java2022.accounting.dto;

import lombok.Getter;

@Getter
public class CreateUserDto {

	String login;
	String password;
	String firstName;
	String lastName;
}
