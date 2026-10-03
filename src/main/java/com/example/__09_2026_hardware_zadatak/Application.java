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


//zadatak:
//Proširiti rješenje iz četvrte vježbe te umjesto H2 baze podataka koristiti MSSQL bazu podataka.
//Napisati skripte koje će kreirati tablice „Hardware" i „Type" te "INSERT" skripte koje će dodati podatke u bazu podataka.
//U "pom.xml" datoteci dodati biblioteku za MSSQL bazu podataka:
//
//<dependency>  
//<groupId>com.microsoft.sqlserver</groupId>  
//<artifactId>mssql-jdbc</artifactId>  
//<scope>runtime</scope>
//</dependency>
//
//Istestirati funkcionalnosti aplikacije s novom bazom podataka (mora sve funkcionirati kako je funkcioniralo u aplikaciji s H2 bazom podataka).


//Proširiti rješenje iz četvrte ili pete vježbe te umjesto JdbcTemplate klase kod pristupa bazi podataka koristiti SpringDataJpa sučelje.
//U "pom.xml" datoteci dodati sljedeću Maven biblioteku:
//
//
//
//<dependency>
//<groupId>org.springframework.boot</groupId>
//<artifactId>spring-boot-starter-data-jpa</artifactId>
//</dependency>
//
//
//Doraditi na klasu „Type” na način da ima vlastitu tablicu u bazi podataka te strani ključ za klasu „Hardware”.
//Prilikom implementacije relacijskih veza i entiteta koristiti Hibernate anotacije.
//Kreirati nove klase „SpringDataHardwareRepository” i „SpringDataTypeRepository” na način da nasljeđuju sučelje „JpaRepository”.
//Doraditi klasu „HardwareServiceImpl” kako bi umjesto „JdbcTemplate” repozitorija koristila nove „SpringData” repozitorij klase.

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
