package com.example;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.example.entity.Role;
import com.example.entity.User;
import com.example.repository.RoleRepository;
import com.example.repository.UserRepository;

@Component
public class Initializer implements ApplicationListener<ContextRefreshedEvent> {
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		
		Role role = new Role();
		
		role.setName("Admin");
		role.setStatus(StatusRoleEnum.ATIVO);
		
		Role role2 = new Role();
		role2.setStatus(StatusRoleEnum.INATIVO);
		
		role2.setName("Aluno");
		
		this.roleRepository.save(role);
		this.roleRepository.save(role2);
		
		User user = new User();
		
		user.setName("Nataniel");
		user.setEmail("nataniel.paiva@gmail.com");
		user.setRole(role);
		
		this.userRepository.save(user);
		
		User user2 = new User();
		
		user2.setEmail("asdasdasd");
		user2.setName("qualquer coisa");
		user2.setRole(role);
		
		this.userRepository.save(user2);
		
		List<Role> roles = this.roleRepository.findByStatus(StatusRoleEnum.ATIVO);
		
		roles.forEach(x -> System.out.println(x.getName()));
	}

}
