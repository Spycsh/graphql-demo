# GraphQL demo

This demo project shows how to use GraphQL Java and Springboot to establish a minimal server to handle API requests.

To use it, open `gradle` view in IntelliJ IDEA and load the project, and then run the GraphqlDemoApplication, and then access `localhost:8090` to execute a query. To learn the grammar of the query, please refer to [doc](https://www.graphql-java.com/documentation/v16/execution/).

One sample can be following:

![](query_sample.png)


# GraphQL with Spring Boot Client

The client module is a son spring boot application. It uses httpclient to request from server.
You can run ClientApplication and then request localhost:8091 to see HelloWorld when it is running.

localhost:8091/list: return all employee list. The request is executed 100 - 1000 times, and the 
response time in milliseconds are printed in console.

localhost:8091/listId: return id of all employee.
The response time is also printed in console.
