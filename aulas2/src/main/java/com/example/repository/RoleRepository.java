package com.example.repository;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.StatusRoleEnum;
import com.example.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>  {
	List<Role> findByStatus(StatusRoleEnum status);
	
	Page<Role> findAll(Pageable pageable);
}
