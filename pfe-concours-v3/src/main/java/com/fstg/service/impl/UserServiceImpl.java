package com.fstg.service.impl;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.fstg.bean.Etudiant;
import com.fstg.bean.TypeDiplome;
import com.fstg.bean.User;
import com.fstg.dao.UserDao;
import com.fstg.service.facade.UserService;
import com.fstg.service.util.HashUtil;
import com.fstg.service.util.PasswordRandomUtil;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;

	@Autowired
	private JavaMailSender javaMailSender;

	void sendEmailWithAttachment(String to, String subject, String message) throws MessagingException, IOException {
		MimeMessage msg = javaMailSender.createMimeMessage();
		// true = multipart message
		MimeMessageHelper helper = new MimeMessageHelper(msg, true);
		helper.setTo(to);
		helper.setSubject(subject);
		// default = text/plain
		// helper.setText("Check attachment for image!");
		// true = text/html
		helper.setText("<h1>" + message + "</h1>", true);
		// hard coded a file path
		// FileSystemResource file = new FileSystemResource(new
		// File("path/android.png"));
		// helper.addAttachment("my_photo.png", new ClassPathResource("android.png"));
		javaMailSender.send(msg);
	}

	@Override
	public int seConnecter(User user) {
		User loadedUser = findByLogin(user.getLogin());
		if (loadedUser == null) {
			return -1;
		} else if (!loadedUser.getPassword().equalsIgnoreCase(user.getPassword())) {
			loadedUser.setNbrTentativeRestant(loadedUser.getNbrTentativeRestant() - 1);
			if (loadedUser.getNbrTentativeRestant() == 0) {
				loadedUser.setBloqued(true);
				loadedUser.setDateBloquage(new Date());
				userDao.save(loadedUser);
				return -2;
			} else {
				userDao.save(loadedUser);
				return -3;
			}
		} else {
			return 1;
		}
	}

	@Override
	public int register(User user) {
		if (findByLogin(user.getLogin()) != null) {
			return -1;
		} else {
			user.setNbrTentativeRestant(5);
			userDao.save(user);
			return 1;
		}
	}

	@Override
	public User findByLogin(String login) {
		return userDao.findByLogin(login);
	}

	@Override
	public List<User> findAll() {
		return userDao.findAll();
	}

	@Override
	public User update(Long id, String login, String nom, String prenom, String email) {
		User foundedUser = findById(id);
		foundedUser.setLogin(login);
		// foundedUser.setPassword(password);
		foundedUser.setPassword(PasswordRandomUtil.generateRandomString(8));
		foundedUser.setPassword(HashUtil.hash(foundedUser.getPassword()));
		foundedUser.setNbrTentativeRestant(5);
		User updatedUser = userDao.save(foundedUser);

		return updatedUser;
	}

	public User findById(Long id) {
		return userDao.getOne(id);
	}

}
