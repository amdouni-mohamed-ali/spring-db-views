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

## Overview

In this example we will create our jpa entities model for ou views. First of all, check our database model below :

![db-diagram](https://user-images.githubusercontent.com/16627692/73593645-9dee9380-4506-11ea-9f6d-f2050edc0e13.jpg)

As we can see, a customer can have one or more account but only one address. And now have a look of our model views :

* Customer view :
```sql
CREATE VIEW view_customer
AS
SELECT id, first_name, last_name, email, phone_number FROM customer;
```

* Address view :
```sql
CREATE VIEW view_address
AS
SELECT c.id as identifier, first_name, building, street, country FROM customer c INNER JOIN address a WHERE c.id = a.customer_id;
```

* Account view :
```sql
CREATE VIEW view_account
AS
SELECT c.id as identifier, first_name, balance, account_name, date_opened FROM customer c INNER JOIN account a WHERE c.id = a.customer_id;
```

As jpa treats views as tables, it's easy to implement these views as java classes and add the @Entity annotation to them. Well, that's not the case here because
this model contains a lot of issues that prevent use from using jpa as it is.

The customer view is awesome because it contains a unique id (the customer id), but that's not the case for the address and account views. These views does not contains
ids. 

For the address view, If we decide to make the customer id a primary key we can't be sure if an address can be shared between two customers.

The same issue for the account view, we can't make the customer id a primary key because a customer can have many accounts so the primary key is not unique.

The solution is to modify the views by :
- adding the address pk and the accounts pk so we can make composite keys (customer pk, address pk) for the address view and (customer pk, account pk) for the accounts
- or we can add our custom pk. The row number for example can be a pk (if you are using oracle as database). check this article for more details :
https://tuhrig.de/using-spring-data-for-database-views-without-an-id/

But as we can't modify the views, we will use a third solution. But in my opinion, if you can modify the views use one of the last solution because this one is a little
complicated. The solution is to use the @Embeddable and @Embedded annotations in the customer entity.

So we will make the account and the address entities embeddable and we will embed them in the customer entity. Please check the entity package to see the example
and check this article to know more about these annotations :

- https://en.wikibooks.org/wiki/Java_Persistence/Embeddables

## Built With

* Java - oracle jdk "1.8.0_101"
* [Maven](https://maven.apache.org/) - Dependency Management (version 3.6.0)
* [Intellij](https://www.jetbrains.com/) - IDE (version 2018.3.3)
* [Spring Boot](https://spring.io/projects/spring-boot) - (v2.2.4.RELEASE)


## Authors

* **Amdouni Mohamed Ali** [[github](https://github.com/amdouni-mohamed-ali)]

![Spring_framework-1](https://user-images.githubusercontent.com/16627692/72637378-7671c580-3961-11ea-8d00-3f5624480783.png)
