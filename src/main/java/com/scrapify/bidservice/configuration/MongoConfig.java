package com.scrapify.bidservice.configuration;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.MongoCredential;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.scrapify.bidservice.util.Constants;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "com.scrapify.bidservice.repository")
public class MongoConfig extends AbstractMongoClientConfiguration {
    @Override
    protected String getDatabaseName() {
        return Constants.DBNAME;
    }

    @Override
    public MongoClient mongoClient() {
        final ConnectionString connectionString = new ConnectionString(System.getenv(Constants.URL));
//        MongoCredential credential = MongoCredential.createCredential(System.getenv(Constants.USER_NAME), getDatabaseName(), System.getenv(Constants.PASSWORD).toCharArray());
        final MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
//                .credential(credential)
                .build();
        return MongoClients.create(mongoClientSettings);
    }

}
