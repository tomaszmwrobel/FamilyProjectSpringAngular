# Family Project Spring Angular
SpringBoot API and Angular6 
#PL (ENG description bottom)
Technologie:
API: SpringBoot (Java 8)
Interfejs użytkownika: Angulra 6 (TypeScript)

Opis działania:
Aplikacja realizuje proces biznesowy polegający na obsłudze bazy danych rodzin
Rodzina składa się z ojca (IMIĘ, NAZWISKO, DATA URODZENIA, PESEL) oraz dzieci (IMIĘ, NAZWISKO, PŁEĆ, PESEL, DATA URODZENIA).
Do bazy danych można wprowadzać rodziny: Tworząc ojca, a następnie dodawać dzieci.
Aplikacja umożliwa wyszukiwanie dzieci po określonych parametrach.

# Baza Danych
1. Skrypty tworzące baze danych znajdują się w katalogu /databaseScript przy tworzeniu korzystałem z bazy MySQL. 
	
	(*) W przypadku innej bazy należy zmienić sterownik jdbc

2. Konfiguracja
	pliki konfiguracyjne :
	/springbootapi/src/main/resources/application.properties
	
	należy ustawić login, haslo, adres bazy danych

# SPRING BOOT
Staruje na localhost:8080/

	mvn clean package
	cd springbootapi / target
	java - jar springbootapi-1.0.jar

# ANGULAR
Start na localhost:4200/
Api na localhost8080/

	1. npm install --only=dev 

			(*)jeśli automatycznie nie zainstaluje bootstrapa, to należy ręcznie dołączyć
			npm install --save @ng-bootstrap/ng-bootstrap

	2. ng serve

#ENG
Tools:
API: SpringBoot (Java 8)
User Interface: Angular 6 (Type script)

Description:
Application show business process, Using of Families Database.
Every Family has Father (Name, Surname, BirthDate, PESEL) and Children (Name, Surname, Sex, PESEL, BirhtDate). PESEL - Polish ID number.
You can add famiies to database: Create Father and next add children to family.
Application can looking for children by parameters.


# Database
1. Location of MySQL scripts directory : /databaseScript I am use MySQL database. 

	(*) In case of use other database you should change jdbc driver.

2. Configuration
	Config files :
	/springbootapi/src/main/resources/application.properties
	
	set login, password, database address

# SPRING BOOT
Start url localhost:8080/

	mvn clean package
	cd springbootapi / target
	java - jar springbootapi-1.0.jar

# ANGULAR
Start url localhost:4200/
API url localhost8080/

	1. npm install --only=dev 

			(*) If bootstrap won't install automatically, you should add it:
			npm install --save @ng-bootstrap/ng-bootstrap

	2. ng serve