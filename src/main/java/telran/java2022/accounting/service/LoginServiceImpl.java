package telran.java2022.accounting.service;

import org.mindrot.jbcrypt.BCrypt;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import telran.java2022.accounting.dao.UserRepository;
import telran.java2022.accounting.dto.AddRoleDto;
import telran.java2022.accounting.dto.CreateUserDto;
import telran.java2022.accounting.dto.UpdateNameDto;
import telran.java2022.accounting.dto.UserDto;
import telran.java2022.accounting.dto.exception.UserAlreadyExistException;
import telran.java2022.accounting.dto.exception.UserNotFoundException;
import telran.java2022.accounting.model.User;

@Service
@RequiredArgsConstructor
public class LoginServiceImpl implements LoginService {

	final UserRepository userRepository;
	final ModelMapper modelMapper;

	@Override
	public UserDto addNewUser(CreateUserDto createUserDto) {
		boolean userExist = userRepository.findById(createUserDto.getLogin()).isEmpty();
		if (!userExist) {
			throw new UserAlreadyExistException(createUserDto.getLogin());
		}
		User user = modelMapper.map(createUserDto, User.class);
		String password  = BCrypt.hashpw(createUserDto.getPassword(), BCrypt.gensalt());
		user.setPassword(password);
		user.addRole("USER");
		user = userRepository.save(user);

		return modelMapper.map(user, UserDto.class);
	}

	@Override
	public UserDto loginUser(String login) {
		User user = userRepository.findById(login).orElseThrow(() -> new UserNotFoundException(login));
		return modelMapper.map(user, UserDto.class);
	}

	@Override
	public UserDto removeUser(String login) {
		User user = userRepository.findById(login).orElseThrow(() -> new UserNotFoundException(login));
		userRepository.delete(user);
		return modelMapper.map(user, UserDto.class);
	}

	@Override
	public UserDto updateUser(String login, UpdateNameDto updateNameDto) {
		User user = userRepository.findById(login).orElseThrow(() -> new UserNotFoundException(login));
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
		User user = userRepository.findById(login).orElseThrow(() -> new UserNotFoundException(login));
		user.addRole(role);
		userRepository.save(user);
		return modelMapper.map(user, AddRoleDto.class);
	}

	@Override
	public AddRoleDto removeRole(String login, String role) {
		User user = userRepository.findById(login).orElseThrow(() -> new UserNotFoundException(login));
		user.removeRole(role);
		userRepository.save(user);
		return modelMapper.map(user, AddRoleDto.class);
	}

	@Override
	public void updatePassword(String login, String newPassword) {
		User user = userRepository.findById(login)
				.orElseThrow(() -> new UserNotFoundException(login));
		String password  = BCrypt.hashpw(newPassword, BCrypt.gensalt());
		user.setPassword(password);
		userRepository.save(user);
	}
	

}
