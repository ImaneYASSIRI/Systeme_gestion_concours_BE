package com.fstg.service.facade;

import java.util.List;

import com.fstg.bean.Concours;
import com.fstg.bean.Etudiant;
import com.fstg.bean.TypeDiplome;
import com.fstg.bean.User;

public interface UserService {

	User findByLogin(String login);

	int seConnecter(User user);

	public List<User> findAll();

	public User update(Long id, String login, String nom, String prenom, String email);

	int register(User user);

}
