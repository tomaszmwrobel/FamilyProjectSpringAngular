# FamilyProjectSpringAngular
SpringBoot and Angular6


# Baza Danych
1. Skrypty tworzące baze danych znajdują się w katalogu /databaseScript
przy tworzeniu korzystałem z bazy MySQL, w przypadku innej bazy należy zmienić sterownik jdbc

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