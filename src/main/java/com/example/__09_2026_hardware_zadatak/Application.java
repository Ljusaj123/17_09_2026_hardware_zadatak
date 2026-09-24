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


//Proširiti rješenje iz druge vježbe te implementirati sve preostale metode REST API sučelja kako je demonstrirano: GET, POST, PUT i DELETE.
//Dodati sve potrebne ovisnosti u "pom.xml" kao što je "spring-boot-starter-validation" u "pom.xml" datoteku.
//Proširiti HardwareDTO klasu s validacijskim anotacijama kako bi se validirala ispravnost poslanih podataka.
//        Napisati POST, PUT i DELETE metode koje će upravljati podacima entiteta.
//Dodatne metode potrebno je implementirati po sva tri sloja aplikacije: "controller", "service" i "repository".



//Proširiti rješenje iz treće vježbe te umjesto "MockHardwareRepository" implementacije dodati novu implementaciju repozitorija koja će koristiti JdbcTemplate te H2 "in memory" baze podataka.
//Pomoću anotacije "@Primary" potrebno je proglasiti novu implementaciju repozitorija primarnim.
//        U "pom.xml" dodati ovisnosti o "spring-boot-starter-jdbc" i "h2"
//Domensku klasu "Hardware" proširiti s dodatnim identifikatorom "Long id" koji će generirati baza podataka.
//Kreirati datoteke "data.sql" i "schema.sql" i u nju dodati SQL naredbe koje će kreirati table u bazi podataka te spremiti podatke u odgovarajuće tablice.

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
