# Univerly
BotsCrew Junior Java Developer Test Task

## Built with

* [Maven](https://maven.apache.org) - Software project management and comprehension tool.
* [Spring Framework](https://spring.io/) - Provides configuration model for modern Java-based applications.
* [Hibernate](https://hibernate.org/) - Framework for mapping an object-oriented model to a relational database.

**NOTE!**
As far as Spring and Hibernate are massive frameworks with their own library set, the whole list of used libs can be found in ```pom.xml```

## Getting started

First of all, you need to run your MySQL server and provide credentials in ```FactoryUtil.java``` in ```config``` package

The database model is located in the ```SQL``` folder. Just run ```University.sql``` on your server.

Test data is located in ```Insertions.sql```. You may also run this on your server to fill the database.

Now build project with the folowing command
```
mvn clean install
```
Now you are ready to go.

## Usage

- To get the list of available commands type:
```
> help
```

- To get the head of certain department use
```
> Who is the head of department {department_name}
```
where ```{department_name}``` is the name of given department.
                
- To the department statistic use
```
> Show {department_name} statistic                
```
where ```{department_name}``` is the name of given department.

- To get the average salary of employees in given department use
```
> Show the average salary for department {department_name}
```
where ```{department_name}``` is the name of given department.

- To get the amount of employee use                    
```
> Show count of employee for {department_name}
```
where ```{department_name}``` is the name of given department.
- To search of certain lectors by certain name template use
```
> Global search by {template}
```
where ```{template}``` is the name template.

- To exit use
```
> exit
```

## Contribution

If you find any problem, bug etc., please open an issue.

## Author

- [Roman Korostenskyi](https://github.com/korostenskyiHub) 