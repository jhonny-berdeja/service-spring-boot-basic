Execute curl https://start.spring.io/starter.tgz -d dependencies=web -d language=java -d groupId=com.jberdeja -d artifactId=project-springboot-basic -d type=maven-project | tar -xzvf -  
Execute mvn exec:java -Dexec.mainClass="com.jberdeja.project_springboot_basic.DemoApplication"  
In browser navigate to http://localhost:8080/  
package com.jberdeja.project_springboot_basic;  


import org.springframework.web.bind.annotation.GetMapping;  
import org.springframework.web.bind.annotation.RestController;  


@RestController  
public class Controller {  


   @GetMapping("/hello")  
   public String sayHello(){  
       return "Hello, World!";  
   }  
  
}  


In browser navigate to http://localhost:8080/hello  

