/**
 * 
 */
package com.hugo.api.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hugo.api.persistence.UserPersistence;
import com.hugo.api.persistence.bean.MongoUser;
import com.hugo.api.services.ConnectionService;

/**
 * @author Hugo
 *
 */
@Service
public class ConnectionServiceImpl implements ConnectionService{
	
	@Autowired
	UserPersistence userPersistence;
	@Override
	public String tryConnect(String userName, String hashPassword) {
		MongoUser user = userPersistence.findUser(userName);
		/**
		 * TODO création du token
		 */
		String token = "";
		if(user != null && hashPassword.equals(user.getHashPassword())){
			return token;
		}
		return null;
	}

}
