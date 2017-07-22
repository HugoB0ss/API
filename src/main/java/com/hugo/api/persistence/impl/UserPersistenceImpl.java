package com.hugo.api.persistence.impl;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.hugo.api.persistence.UserPersistence;
import com.hugo.api.persistence.bean.MongoUser;
import com.mongodb.MongoClient;

@Repository
@Configuration
@PropertySource("classpath:/mongoConfig.properties")
public class UserPersistenceImpl implements UserPersistence {
	MongoTemplate mongoTemplate;
	@Autowired
	Environment environment; 
	/**
	 * init the Template after constructor getting infos in properties file
	 */
	@PostConstruct
	protected void init() {
		checkProperties();
		MongoClient mongo = new MongoClient(environment.getProperty("mongo.host"),
				Integer.parseInt(environment.getProperty("mongo.port")));
		mongoTemplate = new MongoTemplate(mongo, environment.getProperty("mongo.database"));

	}
	/**
	 * check if properties are well set
	 * @return boolean
	 */
	private void checkProperties(){
		if(environment.getProperty("mongo.host") == null || environment.getProperty("mongo.port") == null || environment.getProperty("mongo.database") == null){
			throw new IllegalArgumentException("At least one property missing");
		}
	}
	
	@Override
	public MongoUser findUser(String userName) {
		if(userName == null || userName.length() < 6){
			throw new IllegalArgumentException("UUID null");
		}
		return mongoTemplate.findOne(new Query(Criteria.where("userName").is(userName)), MongoUser.class);		
	}

	@Override
	public boolean insertUser(MongoUser user) {
		// TODO Auto-generated method stub
		return false;
	}

}
