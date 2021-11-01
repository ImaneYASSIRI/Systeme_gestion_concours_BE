package com.fstg.ws;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fstg.bean.Etudiant;
import com.fstg.service.facade.EtudiantService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api("Cet Endpoint permet de gérer les demandes du document")
@CrossOrigin(origins = { "http://localhost:4200" })
@RequestMapping("pfe-concours-v3-api/file-uploader")
@RestController
public class FileUploader {

	List<String> files = new ArrayList<String>();
	@Autowired
	public EtudiantService etudiantService;
	// Path to save the file
	private final Path rootLocationBac = Paths.get("C:/Users/hp/Desktop/scanns/scanns-baccalauréat");
	private final Path rootLocationS1 = Paths.get("C:/Users/hp/Desktop/scanns/scanns-S1");
	private final Path rootLocationS2 = Paths.get("C:/Users/hp/Desktop/scanns/scanns-S2");
	private final Path rootLocationS3 = Paths.get("C:/Users/hp/Desktop/scanns/scanns-S3");
	private final Path rootLocationS4 = Paths.get("C:/Users/hp/Desktop/scanns/scanns-S4");

	@ApiOperation("Cette méthode de télécharger un fichier")
	@PostMapping("/savefileBac/cne/{cne}")
	public ResponseEntity<String> handleFileUploadBac(@RequestParam("file") MultipartFile file, @PathVariable String cne) {
		String message;
		try {
			try {
				Files.copy(file.getInputStream(),
						this.rootLocationBac.resolve(etudiantService.findByCne(cne).getCne() + "_bac" + ".png"));
				// Files.copy(file.getInputStream(), this.rootLocation.resolve(etudiant.getCne()
				// + ".png"));
			} catch (Exception e) {
				throw new RuntimeException("FAIL!");
			}
			files.add(file.getOriginalFilename());

			message = "Successfully uploaded!";
			return ResponseEntity.status(HttpStatus.OK).body(message);
		} catch (Exception e) {
			message = "Failed to upload!";
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
		}
	}
	
	@ApiOperation("Cette méthode de télécharger un fichier")
	@PostMapping("/savefileS1/cne/{cne}")
	public ResponseEntity<String> handleFileUploadS1(@RequestParam("file") MultipartFile file, @PathVariable String cne) {
		String message;
		try {
			try {
				Files.copy(file.getInputStream(),
						this.rootLocationS1.resolve(etudiantService.findByCne(cne).getCne() + "_S1" + ".png"));
				// Files.copy(file.getInputStream(), this.rootLocation.resolve(etudiant.getCne()
				// + ".png"));
			} catch (Exception e) {
				throw new RuntimeException("FAIL!");
			}
			files.add(file.getOriginalFilename());

			message = "Successfully uploaded!";
			return ResponseEntity.status(HttpStatus.OK).body(message);
		} catch (Exception e) {
			message = "Failed to upload!";
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
		}
	}
	
	@ApiOperation("Cette méthode de télécharger un fichier")
	@PostMapping("/savefileS2/cne/{cne}")
	public ResponseEntity<String> handleFileUploadS2(@RequestParam("file") MultipartFile file, @PathVariable String cne) {
		String message;
		try {
			try {
				Files.copy(file.getInputStream(),
						this.rootLocationS2.resolve(etudiantService.findByCne(cne).getCne() + "_S2" + ".png"));
				// Files.copy(file.getInputStream(), this.rootLocation.resolve(etudiant.getCne()
				// + ".png"));
			} catch (Exception e) {
				throw new RuntimeException("FAIL!");
			}
			files.add(file.getOriginalFilename());

			message = "Successfully uploaded!";
			return ResponseEntity.status(HttpStatus.OK).body(message);
		} catch (Exception e) {
			message = "Failed to upload!";
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
		}
	}
	
	@ApiOperation("Cette méthode de télécharger un fichier")
	@PostMapping("/savefileS3/cne/{cne}")
	public ResponseEntity<String> handleFileUploadS3(@RequestParam("file") MultipartFile file, @PathVariable String cne) {
		String message;
		try {
			try {
				Files.copy(file.getInputStream(),
						this.rootLocationS3.resolve(etudiantService.findByCne(cne).getCne() + "_S3" + ".png"));
				// Files.copy(file.getInputStream(), this.rootLocation.resolve(etudiant.getCne()
				// + ".png"));
			} catch (Exception e) {
				throw new RuntimeException("FAIL!");
			}
			files.add(file.getOriginalFilename());

			message = "Successfully uploaded!";
			return ResponseEntity.status(HttpStatus.OK).body(message);
		} catch (Exception e) {
			message = "Failed to upload!";
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
		}
	}
	
	@ApiOperation("Cette méthode de télécharger un fichier")
	@PostMapping("/savefileS4/cne/{cne}")
	public ResponseEntity<String> handleFileUploadS4(@RequestParam("file") MultipartFile file, @PathVariable String cne) {
		String message;
		try {
			try {
				Files.copy(file.getInputStream(),
						this.rootLocationS4.resolve(etudiantService.findByCne(cne).getCne() + "_S4" + ".png"));
				// Files.copy(file.getInputStream(), this.rootLocation.resolve(etudiant.getCne()
				// + ".png"));
			} catch (Exception e) {
				throw new RuntimeException("FAIL!");
			}
			files.add(file.getOriginalFilename());

			message = "Successfully uploaded!";
			return ResponseEntity.status(HttpStatus.OK).body(message);
		} catch (Exception e) {
			message = "Failed to upload!";
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
		}
	}
	
}