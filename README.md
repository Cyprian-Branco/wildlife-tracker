# Hero Squad

This is a java application that uses database to track endangered wildlife animals. 
heroku live link https://wildlifetracker4.herokuapp.com/
## Author

* **Cyprian Bowen** 

## Getting Started

Clone this repository to your local machine to get Started

Github:[https://github.com/Cyprian-Branco/wildlife-tracker](https://github.com/Cyprian-Branco/wildlife-tracker)

### Prerequisites

You need the following installed on your machine
- java
- JDK - Java Development Kit
- Spark
- Gradle
- An IDE - Intellij
-postgresql



To confirm run the following command on linux
```
$ java --version       //java version
$ mvn --version        //maven version
$ gradle --version     //gradle version
```

## Installing

After cloning to your local machine navigate to the folder you cloned into and open it with intellij.
* Navigate into the ``` src/main/java/App.java ``` and click run in intellij.
* Go to your browser and type ``` localhost:4567 ```
In PSQL:
 * CREATE DATABASE to_do;
 * CREATE TABLE animals (name varchar, age varchar, type varchar, id serial PRIMARY KEY);
 * CREATE TABLE sightings (ranger varchar, animalId int, location varchar, seenDate timestamp, id serial PRIMARY KEY);

## Built With

* [Java](https://www.java.com/) - The language used
* [Intellij Idea](https://www.jetbrains.com/idea/) - Intergated development
* [Spark]() - Framework


## Contributing
If you want to put out a pull request you first have to send us the sample code that you want to add to our repository for cross-checking before we allow the pull.

## License

This project is licensed under the MIT License. 
