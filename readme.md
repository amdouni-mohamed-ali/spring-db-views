# Spring DataBase views example

This is a simple example of how to use spring data jpa with database views.

## Prerequisites

To create your development environment, you will need to :

- install java 8 (or above)
- install maven
- install git to clone the project
- you favorite IDE (i'm using intellij) 

## Installing

To clone the project, run this command :

```bash
$ git clone https://github.com/amdouni-mohamed-ali/spring-db-views.git
$ cd spring-db-views
```

And run this command to package the project and run test :

```
    $ mvn clean package
```

If everything turns out alright, you should end up with this result :

```log
[INFO]
[INFO] Results:
[INFO]
[INFO] Tests run: 3, Failures: 0, Errors: 0, Skipped: 0
[INFO]
[INFO]
[INFO] --- maven-jar-plugin:3.1.2:jar (default-jar) @ spring-db-views ---
[INFO] Building jar: D:\github\spring-db-views\target\spring-db-views-0.0.1-SNAPSHOT.jar
[INFO]
[INFO] --- spring-boot-maven-plugin:2.2.4.RELEASE:repackage (repackage) @ spring-db-views ---
[INFO] Replacing main artifact with repackaged archive
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  16.679 s
[INFO] Finished at: 2020-02-01T15:13:25+01:00
[INFO] ------------------------------------------------------------------------
```

## Running the tests

We are using a travis job to run tests before merging branches. Each tme we create a merge request, travis will download our code and run the tests after.

You can check the travis file to know more or just check this link :

- https://docs.travis-ci.com/user/languages/java/#examples

For unit tests, you gonna find them in each module + some explanations in the source code also.

## Built With

* Java - oracle jdk "1.8.0_101"
* [Maven](https://maven.apache.org/) - Dependency Management (version 3.6.0)
* [Intellij](https://www.jetbrains.com/) - IDE (version 2018.3.3)
* [Spring Boot](https://spring.io/projects/spring-boot) - (v2.2.4.RELEASE)


## Authors

* **Amdouni Mohamed Ali** [[github](https://github.com/amdouni-mohamed-ali)]

![Spring_framework-1](https://user-images.githubusercontent.com/16627692/72637378-7671c580-3961-11ea-8d00-3f5624480783.png)
