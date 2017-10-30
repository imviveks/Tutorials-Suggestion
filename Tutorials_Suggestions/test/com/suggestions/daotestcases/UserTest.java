/**
 * 
 */
package com.suggestions.daotestcases;

import static org.junit.Assert.*;

import org.junit.Test;

import com.suggestions.bean.User;
import com.suggestions.dao.UserDAO;
import com.suggetions.entity.UserEO;

/**
 * @author User
 *This Test class of User, tests get user and get list of users methods.
 */
public class UserTest {
	
	UserEO userEo = new UserEO();
	User user1 = new User();
	
	@Test
	public void testGetUser(){
		
		user1 = userEo.getUser(1);
		assertNotNull(user1);
	}

}
