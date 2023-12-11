package fr.afpa.pompey.cda22045.sparadrap;

import fr.afpa.pompey.cda22045.sparadrap.frame.AccueilFrame;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SparadrapApplication {

	public static void main(String[] args) {
		AccueilFrame.designAccueil();
		SpringApplication.run(SparadrapApplication.class, args);
	}
}
