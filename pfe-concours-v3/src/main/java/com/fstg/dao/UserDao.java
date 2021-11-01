package com.fstg.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fstg.bean.TypeDiplome;
import com.fstg.bean.User;

@Repository
public interface UserDao extends JpaRepository<User, Long> {

	public User findByLogin(String login);

}
