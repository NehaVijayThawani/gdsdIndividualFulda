package com.gdsd.sellpurchase;

import java.net.UnknownHostException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

@Configuration
public class AppConfig {

    @Bean
    public MongoDbFactory mongoDbFactory() throws UnknownHostException {
	return new SimpleMongoDbFactory(new MongoClient("localhost", 27017), "spring_boot_examples");
//        MongoClientURI uri = new MongoClientURI("mongodb://khan:lelouchzer0@ds159634.mlab.com:59634/mydb");
//        MongoClient client = new MongoClient(uri);
      //  return new SimpleMongoDbFactory(client, "mydb");
    }

//        mongodb://<dbuser>:<dbpassword>@ds159634.mlab.com:59634/mydb
    @Bean
    public MongoOperations mongoOperations() throws UnknownHostException {
        return new MongoTemplate(mongoDbFactory());
    }
}
