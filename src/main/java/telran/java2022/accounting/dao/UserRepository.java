package telran.java2022.accounting.dao;

import org.springframework.data.repository.CrudRepository;

import telran.java2022.login.model.User;

public interface UserRepository extends CrudRepository<User, String> {

}
