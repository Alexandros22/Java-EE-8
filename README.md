# This is a Java EE 8 Web application project that uses RESTful EndPoints.

This project developed in Apache NetBeans 11 IDE with GlassFish 5.1 server, Java SE Platform (JDK 12)
and Java Development Kit (JDK) 1.8.0_212.

To execute this application you have to install GlassFish server 5+ or another server of your choice that 
implements Java EE 8 and upload to the server the m1.war file, which is located in folder target. There are
many pages in the web showing how to install GlassFish server, for example:

https://www.youtube.com/watch?v=4VCkWvQcF4w

You can download GlassFish server here:

https://javaee.github.io/glassfish/download

When the application runs you are able to see the following jsp page in this URL: http://localhost:8080/m1/


### Welcome to my Java EE 8 app!  
### My name is Alexandros and this is version 1.  
### Press here to return the hole list.  

Then you can open a testing REST client like Postman or Insomnia and execute REST API requests in a beautiful
and elegant interface. The body of the requests should be in JSON format because the application consumes and
produces JSON. 

The application has an object-entity with the following attributes:

Variable | Purpose
------------ | -------------
creator | the name of the user which creates the object, should not be more than 50 characters and not null
dateCreated | the date which the object is created (format:"05-06-2019"), must be in the present or future and not null, is generated in init before the object persist in database
id | the id of the object in the database, it generated automatically
isCompleted | a boolean variable (true or false), should not be null is generated in init before the object persist in database
lastmod | the name of the user which modify the object last

We use the RESTful EndPoints (URLs) to communicate with the database and perform the following actions:

> http://localhost:8080/m1/list/new  Method: POST

which creates a new object in the database. The body should contain something like:

{
	"creator" : "Alex",
	"lastmod" : "Sofia"
}

and the response should be:

{
  "creator": "Alex",
  "dateCreated": "05-06-2019",
  "id": 1,
  "isCompleted": false,
  "lastmod": "Sofia"
}


> http://localhost:8080/m1/list/status?id=1  Method: POST

which responds with the content of variable isCompleted: true or false
We should put the id (x) of the object that we want to see (if it isCompleted) in the URL
(http://localhost:8080/m1/list/status?id=x)


> http://localhost:8080/m1/list/1  Method: GET

which responds with the hole list object like this:

{
  "creator": "Alex",
  "dateCreated": "05-06-2019",
  "id": 1,
  "isCompleted": false,
  "lastmod": "Sofia"
}

We should put the id (x) of the object that we want to see in the URL
http://localhost:8080/m1/list/x


> http://localhost:8080/m1/list/upd  Method: PUT

which updates an object in the database. The body should contain something like:

{
	 "creator" : "Alex",
   "dateCreated": "05-06-2019",
   "id": 1,
	 "isCompleted": true,
   "lastmod": "Alex"
  }

and the response should be:

{
  "creator": "Alex",
  "dateCreated": "05-06-2019",
  "id": 1,
  "isCompleted": true,
  "lastmod": "Alex"
}

We should put the id of the object that we want to update


> http://localhost:8080/m1/list/all  Method: GET

which responds with all objects that we have in the database like:

{
    "creator": "Alex",
    "dateCreated": "05-06-2019",
    "id": 1,
    "isCompleted": true,
    "lastmod": "Alex"
  },
  {
    "creator": "Alex",
    "dateCreated": "05-06-2019",
    "id": 2,
    "isCompleted": false,
    "lastmod": "Sofia"
  }

we can do the same (see all objects) from the jsp page if we press:
###### Press here to return the hole list.

