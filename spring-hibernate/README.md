# Hibernate

## What is Hibernate?
- A framework for persisting / saving Java objects in a database


## Benefits of Hibernate
- handles all of the low-level SQL
- minimizes the amount of JDBC code
- provides the Object-to-Relational Mapping (ORM)


## Relation between Hibernate & JDBC
- Hibernate uses JDBC for all database communications


## Setting up the development environment

### MySQL
 
assuming you already have docker installed. Now runt the following command:

```
docker run --name=test-mysql --hostname=f6ed9544662c --env=PATH=/usr/local/sbin:/usr/local/bin:/usr/sbin:/usr/bin:/sbin:/bin --volume=/var/lib/mysql -p 3301:3306 --expose=33060 --restart=no --detach=true mysql/mysql-server:5.7.25 mysqld
```
Run the following command and copy the password.
```
docker logs test-mysql 2>&1 | grep GENERATED
```
Then enter into the mysql server using the copied password:
```
docker exec -it test-mysql mysql -uroot -p
```
On the mysql,
```
ALTER USER 'root'@'localhost' IDENTIFIED BY '123456789';
```
```
CREATE USER 'hbstudent'@'%' IDENTIFIED BY 'hbstudent';
```
```
GRANT ALL PRIVILEGES ON * . * TO 'hbstudent'@'%';
```

to create the db and tables:

```sql
CREATE DATABASE  IF NOT EXISTS `hb_student_tracker`;
USE `hb_student_tracker`;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;

CREATE TABLE `student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;
```



## BuzzWords
- HQL: Hibernate Query Language