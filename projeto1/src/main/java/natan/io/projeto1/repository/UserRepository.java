package natan.io.projeto1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import natan.io.projeto1.entity.User;

public interface UserRepository extends JpaRepository<User, Long > {
	@Query("select u from User u where name like %?1%")	
	User findByQualquerCoisa(String name);
	
	User findByName(String name);
	
	User findByNameIgnoreCase(String name);
}
