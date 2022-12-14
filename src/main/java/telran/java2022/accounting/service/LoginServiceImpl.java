package telran.java2022.accounting.service;

import org.mindrot.jbcrypt.BCrypt;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import telran.java2022.accounting.dao.UserRepository;
import telran.java2022.accounting.dto.AddRoleDto;
import telran.java2022.accounting.dto.CreateUserDto;
import telran.java2022.accounting.dto.UpdateNameDto;
import telran.java2022.accounting.dto.UserDto;
import telran.java2022.accounting.dto.exception.UserAlreadyExistException;
import telran.java2022.accounting.dto.exception.UserNotFoundException;
import telran.java2022.accounting.model.UserAccount;

@Service
@RequiredArgsConstructor
public class LoginServiceImpl implements LoginService, CommandLineRunner {

	final UserRepository userRepository;
	final ModelMapper modelMapper;

	@Override
	public UserDto addNewUser(CreateUserDto createUserDto) {
		boolean userExist = userRepository.findById(createUserDto.getLogin()).isEmpty();
		if (!userExist) {
			throw new UserAlreadyExistException(createUserDto.getLogin());
		}
		UserAccount user = modelMapper.map(createUserDto, UserAccount.class);
		String password  = BCrypt.hashpw(createUserDto.getPassword(), BCrypt.gensalt());
		user.setPassword(password);
		user.addRole("USER");
		user = userRepository.save(user);

		return modelMapper.map(user, UserDto.class);
	}

	@Override
	public UserDto loginUser(String login) {
		UserAccount user = userRepository.findById(login).orElseThrow(() -> new UserNotFoundException(login));
		return modelMapper.map(user, UserDto.class);
	}

	@Override
	public UserDto removeUser(String login) {
		UserAccount user = userRepository.findById(login).orElseThrow(() -> new UserNotFoundException(login));
		userRepository.delete(user);
		return modelMapper.map(user, UserDto.class);
	}

	@Override
	public UserDto updateUser(String login, UpdateNameDto updateNameDto) {
		UserAccount user = userRepository.findById(login).orElseThrow(() -> new UserNotFoundException(login));
		String firstName = updateNameDto.getFirstName();
		if (firstName != null) {
			user.setFirstName(updateNameDto.getFirstName());
		}
		String lastName = updateNameDto.getLastName();
		if (lastName != null) {
			user.setLastName(lastName);
		}
		userRepository.save(user);
		return modelMapper.map(user, UserDto.class);
	}

	@Override
	public AddRoleDto addRole(String login, String role) {
		UserAccount user = userRepository.findById(login).orElseThrow(() -> new UserNotFoundException(login));
		user.addRole(role);
		userRepository.save(user);
		return modelMapper.map(user, AddRoleDto.class);
	}

	@Override
	public AddRoleDto removeRole(String login, String role) {
		UserAccount user = userRepository.findById(login).orElseThrow(() -> new UserNotFoundException(login));
		user.removeRole(role);
		userRepository.save(user);
		return modelMapper.map(user, AddRoleDto.class);
	}

	@Override
	public void updatePassword(String login, String newPassword) {
		UserAccount user = userRepository.findById(login)
				.orElseThrow(() -> new UserNotFoundException(login));
		String password  = BCrypt.hashpw(newPassword, BCrypt.gensalt());
		user.setPassword(password);
		userRepository.save(user);
	}

	@Override
	public void run(String... args) throws Exception {
		if (!userRepository.existsById("admin")) {
			String password = BCrypt.hashpw("admin", BCrypt.gensalt());
			UserAccount user = new UserAccount("admin", password, "", "");
			user.addRole("USER");
			user.addRole("MODERATOR");
			user.addRole("ADMINISTRATOR");

			userRepository.save(user);
		}
	}
	

}
