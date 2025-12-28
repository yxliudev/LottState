package com.yxldev.lottstate.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
@RequiredArgsConstructor
public class MongoDbConfig {

    @Bean(name = "lottoMongoProperties")
    @ConfigurationProperties(prefix = "spring.data.mongodb")
    public MongoProperties lottoMongoProperties() {
        return new MongoProperties();
    }

    @Bean
    public MongoDatabaseFactory lottoMongoDatabaseFactory(@Qualifier("lottoMongoProperties") MongoProperties mongo) {
        return new SimpleMongoClientDatabaseFactory(mongo.getUri());
    }

    @Bean(name = "lottoMongoTemplate")
    public MongoTemplate lottoMongoTemplate() throws Exception {
        return new MongoTemplate(lottoMongoDatabaseFactory(lottoMongoProperties()));
    }

}
