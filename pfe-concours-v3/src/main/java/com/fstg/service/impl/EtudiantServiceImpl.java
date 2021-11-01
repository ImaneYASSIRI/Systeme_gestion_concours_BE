package com.fstg.service.impl;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.fstg.bean.Etudiant;
import com.fstg.bean.Filiere;
import com.fstg.bean.Inscription;
import com.fstg.bean.TypeDiplome;
import com.fstg.dao.EtudiantDao;
import com.fstg.service.facade.EtudiantService;
import com.fstg.service.facade.InscriptionService;
import com.fstg.service.facade.TypeDiplomeService;
import com.fstg.service.util.HashUtil;
import com.fstg.service.util.PasswordRandomUtil;

@Service
public class EtudiantServiceImpl implements EtudiantService {
	@Autowired
	private EtudiantDao etudiantDao;

	@Autowired
	private InscriptionService inscriptionService;

	@Autowired
	private TypeDiplomeService typeDiplomeService;

	@Autowired
	private JavaMailSender javaMailSender;

	@Override
	public Etudiant findByCne(String cne) {
		return etudiantDao.findByCne(cne);
	}

	@Override
	public List<Etudiant> findAll() {
		return etudiantDao.findAll();
	}

	/*
	 * @Override public int save(Etudiant etudiant) { Etudiant loadedEtudiant =
	 * findByCne(etudiant.getCne()); TypeDiplome loadedTypeDiplome =
	 * typeDiplomeService.findByLibelle(etudiant.getTypeDiplome().getLibelle()); if
	 * (loadedEtudiant != null) { return -1; } if (loadedTypeDiplome == null) {
	 * return -2; } else { etudiant.setTypeDiplome(loadedTypeDiplome);
	 * etudiantDao.save(etudiant); inscriptionService.save(etudiant,
	 * etudiant.getInscriptions()); } return 0; }
	 */

	@Override
	public List<Etudiant> findByInscriptionsConcoursReference(String reference) {
		return etudiantDao.findByInscriptionsConcoursReference(reference);
	}

	@Override
	@Transactional
	public int deleteByTypeDiplomeLibelle(String libelle) {
		return etudiantDao.deleteByTypeDiplomeLibelle(libelle);
	}

	void sendEmailWithAttachment(String to, String subject, String message) throws MessagingException, IOException {
		MimeMessage msg = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(msg, true);
		helper.setTo(to);
		helper.setSubject(subject);
		helper.setText("<h1>" + message + "</h1>", true);
		javaMailSender.send(msg);
	}

	public int register(Etudiant etudiant) {
		if (findByCne(etudiant.getCne()) != null) {
			return -1;
		} else {
			etudiant.setPassword(PasswordRandomUtil.generateRandomString(8));

			try {
				sendEmailWithAttachment(etudiant.getEmail(), "Création de votre compte FSTG Concours",
						"Bonjour/Bonsoir " + etudiant.getNom() + " " + etudiant.getPrenom()
								+ ". <br> Votre compte FSTG Concours a été créé avec succès. <br> Pour effectuer votre préinscription, "
								+ "veuillez vous connecter. <br> Voici vos coordonnées :" + "<br> Votre login (CNE) : "
								+ etudiant.getCne() + "<br> Votre mot de passe : " + etudiant.getPassword() + ".");
			} catch (MessagingException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} // ("ha login " + user.getLogin() + " o ha pass " + user.getPassword());
			etudiant.setPassword(HashUtil.hash(etudiant.getPassword()));
			etudiant.setNbrTentativeRestant(5);
			etudiant.setTypeDiplome(null);
			etudiantDao.save(etudiant);
			return 1;
		}
	}

	@Override
	public int saveEtudiant(Etudiant etudiant) {
		Etudiant loadedEtudiant = findByCne(etudiant.getCne());
		TypeDiplome loadedTypeDiplome = typeDiplomeService.findByLibelle(etudiant.getTypeDiplome().getLibelle());
		if (loadedEtudiant != null) {
			return -1;
		}
		if (loadedTypeDiplome == null) {
			return -2;
		}
		/*
		 * if (loadedEtudiant.getInscriptions() != null) { return -3; }
		 */else {
			etudiant.setTypeDiplome(loadedTypeDiplome);
			etudiant.setMoyenne((etudiant.getNoteS1() + etudiant.getNoteS2() + etudiant.getNoteS3()) / 3);
			etudiantDao.save(etudiant);
			inscriptionService.save(etudiant, etudiant.getInscriptions());
		}
		return 0;
	}

	@Override
	public int seConnecter(Etudiant etudiant) {
		Etudiant loadedEtudiant = findByCne(etudiant.getCne());
		if (loadedEtudiant == null) {
			return -1;
		} else if (!loadedEtudiant.getPassword().equalsIgnoreCase(HashUtil.hash(etudiant.getPassword()))) {
			loadedEtudiant.setNbrTentativeRestant(loadedEtudiant.getNbrTentativeRestant() - 1);
			if (loadedEtudiant.getNbrTentativeRestant() == 0) {
				loadedEtudiant.setBloqued(true);
				loadedEtudiant.setDateBloquage(new Date());
				etudiantDao.save(loadedEtudiant);
				return -2;
			} else {
				etudiantDao.save(loadedEtudiant);
				return -3;
			}
		} else {
			return 1;
		}
	}

	@Override
	public Etudiant updateEtudiant(Long id, String cin, String cne, String nom, String prenom, String email,
			TypeDiplome typeDiplome, List<Inscription> inscriptions) {
		Etudiant foundedEtudiant = findByCne(cne);
		foundedEtudiant.setCin(cin);
		Etudiant updatedEtudiant = etudiantDao.save(foundedEtudiant);
		return updatedEtudiant;
	}

	// ghadi nl9aw wahd letudiant(BE etudiant) b cne(FE etudiant2) ghadi nbdlou cin
	// dyalou bjdid
	@Override
	public Etudiant updateNew(String cne, Etudiant etudiant2) {
		Etudiant etudiant = etudiantDao.findByCne(cne);
		etudiant.setCin(etudiant2.getCin());
		etudiant.setDateNaissance(etudiant2.getDateNaissance());
		etudiant.setMoyenneBac(etudiant2.getMoyenneBac());
		etudiant.setNoteS1(etudiant2.getNoteS1());
		etudiant.setNoteS2(etudiant2.getNoteS2());
		etudiant.setNoteS3(etudiant2.getNoteS3());
		etudiant.setNoteS4(etudiant2.getNoteS4());
		etudiant.setTelephone(etudiant2.getTelephone());
		etudiant.setAnneeBac(etudiant2.getAnneeBac());
		etudiant.setTypeDiplome(etudiant2.getTypeDiplome());
		etudiant.setImageBac(etudiant2.getImageBac());
		etudiant.setImageS1(etudiant2.getImageS1());
		etudiant.setImageS2(etudiant2.getImageS2());
		etudiant.setImageS3(etudiant2.getImageS3());
		etudiant.setImageS4(etudiant2.getImageS4());
		etudiant.setMoyenne((etudiant2.getNoteS1() + etudiant2.getNoteS2() + etudiant2.getNoteS3()) / 3);
		inscriptionService.deleteByEtudiantCne(etudiant.getCne());
		Etudiant updatedEtudiant = etudiantDao.save(etudiant);
		inscriptionService.save(etudiant, etudiant2.getInscriptions());
		return updatedEtudiant;
	}

	@Override
	public Etudiant update(Long id, String cne, String nom, String prenom, String email) {
		Etudiant foundedEtudiant = findById(id);
		foundedEtudiant.setCne(cne);
		foundedEtudiant.setNom(nom);
		foundedEtudiant.setPrenom(prenom);
		foundedEtudiant.setEmail(email);
		// foundedUser.setPassword(password);
		foundedEtudiant.setPassword(PasswordRandomUtil.generateRandomString(8));

		try {
			sendEmailWithAttachment(foundedEtudiant.getEmail(), "Modification de votre compte FSTG Concours",
					"Bonjour/Bonsoir " + foundedEtudiant.getNom() + " " + foundedEtudiant.getPrenom()
							+ ". <br> Votre compte FSTG Concours a été modifié avec succès. <br> Voici vos nouvelles coordonnées :"
							+ "<br> Votre login (CNE) : " + foundedEtudiant.getCne() + "<br> Votre mot de passe : "
							+ foundedEtudiant.getPassword() + ".");
		} catch (MessagingException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		foundedEtudiant.setPassword(HashUtil.hash(foundedEtudiant.getPassword()));
		foundedEtudiant.setNbrTentativeRestant(5);
		Etudiant updatedEtudiant = etudiantDao.save(foundedEtudiant);

		return updatedEtudiant;
	}

	public Etudiant findById(Long id) {
		return etudiantDao.getOne(id);
	}

	@Override
	public List<Etudiant> findByMoyenne(double seuil) {
		return etudiantDao.findByMoyenne(seuil);
	}

	@Override
	public List<Etudiant> findByTypeDiplomeLibelle(String libelle) {
		return etudiantDao.findByTypeDiplomeLibelle(libelle);
	}

}
