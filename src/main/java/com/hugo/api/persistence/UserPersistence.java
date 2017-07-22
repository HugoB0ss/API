/**
 * 
 */
package com.hugo.api.persistence;

import com.hugo.api.persistence.bean.MongoUser;

/**
 * @author Hugo
 *
 */
public interface UserPersistence{
	
	MongoUser findUser(String userName);
	boolean insertUser(MongoUser user);
	

}
