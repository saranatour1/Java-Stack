### Folder Structure
This is the folder Structure for the Java Stack Submissions, This will be updated each week/day: 
> what I used to create this is [tree](https://tree.nathanfriend.io/) 
<br> try this command in the cmd in the same directory of the folder.   
 ```bash 
 tree /A > tree.txt
 ```
 

```bash
.
├── .gitignore
├── README.md
├── here.txt
├── Java Fundamentals
│   ├── Day 48
│   │   ├── 0-First java program
│   │   ├── 1-Cafe java
│   │   └── 2-Alfred bot
│   └── Day 49
│       ├── 0-Cafe Business Logic
│       ├── 1-Puzzling
│       ├── 2-Map of the Hashmatique
│       └── 3-Lists of Exceptions
├── Java OOP
│   ├── Java OOP
│   │   ├── 0-Orders & Items
│   │   ├── 1-Barista's Challenge
│   │   ├── 2-BankAccount Assignment
│   │   └── 3-Coffeedore 64
│   └── Java OOP advanced
│       ├── Day 51
│       ├── Day 52
│       │   ├── 0-Zoo Keeper 1
│       │   └── 1-CareSoft Interfaces
│       └── Day 53
│           ├── 0-Calculator I
│           └── 1-Calculator II
└── Java Spring
│    ├── Day 54
│    │   ├── 0-Daikichi Routes
│    │   ├── 1-Hello Human
│    │   └── 2-Daikichi Path Variables
│    └── Day 55
│    │    ├── 0-Hopper's Receipt
│    │    ├── 1-Display Date
│    │    ├── 2-Fruity Loops
│    │    ├── 3-Counter
│    │    └── Day 55-
│    │        ├── 0-Omikuki Form
│    │        └── 1-Ninja Gold Game
│    ├── Day 56
│    │   └── 0-Omikuki Form
│    ├── spring MVC
│    │   ├── Day 58
│    │   │   └── Summary.md
│    │   ├── Day 59
│    │   │   ├── 0- Books API
│    │   │   ├── 1- Rendering Books
│    │   │   └── 2- All Books
│    └── spring adding one to many
│        └── Day 60
│            └── 0-Dojos and ninjas



```


# Java Spring +Boot

---

This is a small summary of the project documentation for using jsp and java projects in general. 

### Overview

Why spring? Frameworks in general are supposed to make your life 10x times easier as a developer, this is where spring comes into play as explained on there website:

**[Why Spring](https://spring.io/why-spring)**

- [Microservices](https://spring.io/microservices)
- [Reactive](https://spring.io/reactive)
- [Event Driven](https://spring.io/event-driven)
- [Cloud](https://spring.io/cloud)
- [Web Applications](https://spring.io/web-applications)
- [Serverless](https://spring.io/serverless)
- [Batch](https://spring.io/batch)

What I currently relate with is having microservices , building web applications, and serverless applications, Although I will be mainly using for building web applications only. 

### Configuration

So, After assuming that You have downloaded spring boot suite from their GitHub repo, and it has been installed correctly, we’ll move to creating a project. 

- Note :
    
    I have downloaded ‘dark-darkest’ mode, this is why my dashboard looks like this. 
    

### Creating a new project

1. Choose a new folder directory to place your project in, then
2. create a new java project by going to file →  new → java project,
3. untick the add module thingy.
4. add a package to the src , call it ‘com.’domain’.hello’  or whatever , and  add a class ,
5. Work on your classes like normal and you should be good. 

### Creating a new project on spring

<aside>
📢 Apache Maven is a popular build automation tool and project management tool for Java-based projects. It simplifies the build process by managing the project's dependencies and providing a standardized approach to build configuration.

</aside>

************Steps:************ 

1. Create  a Spring boot starter project  
 ![123](https://user-images.githubusercontent.com/77834808/235228279-17c5b946-26a9-4fba-af2f-477b5bd1f21d.png)

2. Check maven as type, and choose Packaging type as War:   
![1231](https://user-images.githubusercontent.com/77834808/235228546-cc3c82fc-bca5-4eeb-b8bd-0cdfe12b520d.png)

3. after that, add dev tools, spring web.    
![1232](https://user-images.githubusercontent.com/77834808/235228653-a6b05d2a-6841-46be-9b8a-54c5605a35eb.png)

4. Then, You will have a bunch of Generated folders, where one really important file is the ‘pom.xml’ which holds all the dependencies    
![123](https://user-images.githubusercontent.com/77834808/235228768-f4dcb520-8e33-4f2e-a55d-36bdc2252d6a.png)

5. 1. To start using this application we have a few things to discuss:  
- src/main/java holds your java packages and files, so when you are creating a new class, always think about how to manage the packages, and make sure to import that class withing the place you are working in.
- the src/main/resourcses holds the static files.
- src/ holds the templates with the ‘.jsp’ file format.
1. **************************Actual steps to creating a working app:**************************
- in the main java file, create a new class file, this will be our main controller.
- depending on what type of information you want to return on the web page, you can use `@RestController` to return json or XML data, think of it as if they were Strings for now, or `@Controller` to return views, So starting with the restcontroller:

give the main public class the `@RestController` annotation, and press `ctrl + shift + O` to import the restcontroller package automatically **Do not abuse this.**  
![123](https://user-images.githubusercontent.com/77834808/235229047-a2c8b89d-7357-47af-8b84-42da55e59ccc.png) 
<br>
Next, create a path that your website will go to, using the @RequestMapping("/path_here"),for instance:  
![123](https://user-images.githubusercontent.com/77834808/235229161-50ac1f73-9f68-4667-9b9b-d64d267724cc.png)


to run the project, right Click on the project in the folder Explorer, and run it as a spring boot app: 

Note: Common error that usually occurs is having the port live somewhere, the fix this is to find where the port is working on your local host and killing it, the best fix i could find is this :   
[killing port](https://stackoverflow.com/questions/56499928/web-server-failed-to-start-port-8080-was-already-in-use-spring-boot-microservi)
After that, Yes,  the expected output is the string:   

![123](https://user-images.githubusercontent.com/77834808/235229801-40cbb0bf-dbc4-4c83-8a2d-988db64c170a.png)  
The next tricky concept is rendering views!  the steps are super tricky and they need to be maintained! I’ll work on top of the file I’m in:    

Let’s work on the folder structure:  

- in order to the views to be rendered we need to place a dependency in the pom.xml file for maven to understand what we are talking about,   

```xml
<dependency>
      <groupId>org.apache.tomcat.embed</groupId>
      <artifactId>tomcat-embed-jasper</artifactId>
</dependency> 
```

Note :  groupId = organization , artfactId: name of the library . docs::: [Tom Cat](https://tomcat.apache.org/)  

after placing that, go to the \src\main\webapp and create a new .jsp file    
![123](https://user-images.githubusercontent.com/77834808/235230933-839865c1-d443-4fbd-a85d-1cc4c53a555e.png)

the controller java file should look something like this :    
![123](https://user-images.githubusercontent.com/77834808/235231029-744ec1ae-f965-4a08-bae4-e92fc2a6b8ad.png)  
as simple as this :    
![123](https://user-images.githubusercontent.com/77834808/235231142-5857b521-fd33-488d-b12a-7ca8caadd43a.png)  

Note : the ISO-8859-1 is the standard html 4 pages encoding system, changing it to UTF-8 encoding would be a good idea :

```xml
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
```

adding static files: 

1. Create the `src/main/webapp` folder if it does not exist
2. Create the `src/main/webapp/WEB-INF` folder
3. Edit the `src/main/resources/applications.properties` file to contain the following code:

```bash
spring.mvc.view.prefix=/WEB-INF/
```

**************dependency:************** 

```xml
<dependency>
        <groupId>org.apache.tomcat.embed</groupId>
        <artifactId>tomcat-embed-jasper</artifactId>
    </dependency>
    <dependency>
        <groupId>jakarta.servlet.jsp.jstl</groupId>
        <artifactId>jakarta.servlet.jsp.jstl-api</artifactId>
    </dependency>
    <dependency>
        <groupId>org.glassfish.web</groupId>
        <artifactId>jakarta.servlet.jsp.jstl</artifactId>
    </dependency>
```

to use jstl: 

```xml
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- New line below to use the JSP Standard Tag Library -->
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
```

to include bootstrap : 

in the .jsp file: 

```xml
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
```

****************************Dependancy :**************************** 

```xml
    <dependency>
        <groupId>org.webjars</groupId>
        <artifactId>webjars-locator</artifactId>
        <version>0.46</version>
    </dependency>

    <!-- BOOTSTRAP DEPENDENCIES -->
    <dependency>
        <groupId>org.webjars</groupId>
        <artifactId>bootstrap</artifactId>
        <version>5.2.3</version>
    </dependency>
```

do not change anything 

for static files , link these in the head as well: 

```xml
<link rel="stylesheet" type="text/css" href="/css/style.css">
	<script type="text/javascript" src="/js/app.js"></script>
```

this is all for now! 

---

### Using Vscode for the spring dashboard:
You need to install the Spring pack extentions from VScode market [Spring for VSCode](https://code.visualstudio.com/docs/java/java-spring-boot)  

From their words in the link: 

'To install, launch VS Code and from the Extensions view (Ctrl+Shift+X), search for vscode-spring-initializr.'


'Once you have the extension installed, open the Command Palette (Ctrl+Shift+P) and type Spring Initializr to start generating a Maven or Gradle project and then follow the wizard.'  

Follow the normal steps that we took before and you should be good to go, you can start the app from the dashboard.

I also downloaded the spring CLI which feels like fun.

---------------------------

# List of dependencies and usable things

## application.properties file:

```
# Where are jsp files? HERE!
spring.mvc.view.prefix=/WEB-INF/
# Data Persistence
spring.datasource.url=jdbc:mysql://localhost:3306/<<YOUR_SCHEMA_NAME>>
spring.datasource.username=root
spring.datasource.password=root
spring.jpa.hibernate.ddl-auto=update
# For Update and Delete method hidden inputs
spring.mvc.hiddenmethod.filter.enabled=true
```

## Dependencies to add to pom.xml file:

```xml
        <!-- DEPENDENCIES FOR STARTING SPRING PROJECTS-->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-devtools</artifactId>
            <scope>runtime</scope>
            <optional>true</optional>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-tomcat</artifactId>
            <scope>provided</scope>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
        <!-- DEPENDENCIES FOR DISPLAYING JSPS AND USING JSTL TAGS -->
        <dependency>
            <groupId>org.apache.tomcat.embed</groupId>
            <artifactId>tomcat-embed-jasper</artifactId>
        </dependency>
        <dependency>
            <groupId>jakarta.servlet.jsp.jstl</groupId>
            <artifactId>jakarta.servlet.jsp.jstl-api</artifactId>
        </dependency>
        <dependency>
            <groupId>org.glassfish.web</groupId>
            <artifactId>jakarta.servlet.jsp.jstl</artifactId>
        </dependency>
        <!-- DEPENDENCIES FOR INTEGRATING SQL DATABASE AND USING JPA -->
        <!-- Note: Project will not run until a schema has been created and the 
            proper settings in application properties are present for 
            connecting to a database. -->
        <dependency>
            <groupId>com.mysql</groupId>
            <artifactId>mysql-connector-j</artifactId>
            <scope>runtime</scope>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-jpa</artifactId>
        </dependency>
        <!-- DEPENDENCY FOR USING VALIDATION ANNOTATIONS -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-validation</artifactId>
        </dependency>
        <!-- DEPENDENCY FOR USING BCRYPT  -->
        <dependency>
            <groupId>org.mindrot</groupId>
            <artifactId>jbcrypt</artifactId>
            <version>0.4</version>
        </dependency>
        <!-- DEPENDENCIES FOR BOOTSTRAP -->
        <dependency>
            <groupId>org.webjars</groupId>
            <artifactId>webjars-locator</artifactId>
            <version>0.46</version>
        </dependency>
        <dependency>
            <groupId>org.webjars</groupId>
            <artifactId>bootstrap</artifactId>
            <version>5.2.3</version>
        </dependency>
```

## JSP tag library imports, settings, external styling

```html
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!-- Formatting (dates) --> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Tacos</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/app.js"></script><!-- change to match your file/naming structure -->
</head>
<body>
   
</body>
</html>


```

Last words : weeeeeee