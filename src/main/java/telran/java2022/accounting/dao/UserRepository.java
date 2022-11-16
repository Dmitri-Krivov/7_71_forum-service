package telran.java2022.accounting.dao;

import org.springframework.data.repository.CrudRepository;

import telran.java2022.accounting.model.UserAccount;

public interface UserRepository extends CrudRepository<UserAccount, String> {

}
