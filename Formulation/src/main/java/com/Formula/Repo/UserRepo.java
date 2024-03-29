package com.Formula.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Formula.Entity.UserRequest;

public interface UserRepo extends JpaRepository<UserRequest, Integer> 
{
	public UserRequest findByEmail(String email);

	public UserRequest findByUserId(int userId);

	public UserRequest findRoleByEmail(String role);

}
