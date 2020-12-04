# master interview by Armando Ibarra
> Code refactor for the Spotify properties service!

## Table of contents
* [General info](#general-info)
* [Setup](#setup)
* [Testing](#testing)

## General info

* I've added some frameworks like spring-boot for real time application testing
* Unit testing for the service filtering
* Application is meant to be Restfull, but still need the other cruds
* Layered Architecture was implemented
* Microservices Architecture tries to be 
	
## Setup

Compile the project
````
mvn clean package
````
Does not have  IDE's? no problem, just run
````
mvn spring-boot:run
```` 
Wait, still doest not have time to set up your mvn? no problem, just
````
cd .CheckItOut/
rename master-interview-0.0.1-SNAPSHOT.change-this-to-jar to master-interview-0.0.1-SNAPSHOT.jar
java -jar master-interview-0.0.1-SNAPSHOT.jar
```` 
##Testing
Once you have deployed the application visit and provide the payload to test.

````
http://localhost:8080/master-interview/swagger-ui
````