package com.example.__09_2026_hardware_zadatak;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


//Kreirati klasu Hardware koji sadrži podatke o nazivu, šifri, cijeni, tipu (CPU, GPU, MBO, RAM, STORAGE ili OTHER) te količinu artikala na stanju.
//Napisati sučelja repozitorija i servisa koje će sadržavati metode za dohvat svih artikala hardvera i jednog artikla po šifri te ih implementirati.
//Napisati REST Controller klasu s dvije GET metode koje će pozivati metode iz servisne klase.
//Testirati funkcionalnost REST API metoda korištenjem Postman alata.
//
//
//Proširiti rješenje zadatka iz prvog dijela na način da se implementiraju podatkovni i servisni sloj te sloj controllera koji će implementirati dohvat podataka putem REST API sučelja.
//Podaci koji se dohvaćaju moraju biti vezani definiranje podatke o artiklima hardvera.
//Napisati klasu „HardwareDTO” koja će sadržavati samo one podatke koje ima smisla prikazivati korisnicima.
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
