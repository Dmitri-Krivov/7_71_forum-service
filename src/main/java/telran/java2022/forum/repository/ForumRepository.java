package telran.java2022.forum.repository;

import org.springframework.data.repository.CrudRepository;

import telran.java2022.forum.model.Post;

public interface ForumRepository extends CrudRepository<Post, String>{

}
