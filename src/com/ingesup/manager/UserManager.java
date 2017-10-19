package com.ingesup.manager;

import javax.persistence.Query;
import org.hibernate.HibernateException;
import com.ingesup.hibernate.HibernateUtil;
import com.ingesup.model.Users;

public class UserManager {
	
	public static Users get(Users user) {
		
		try {
			
			Query query = HibernateUtil.getSession().createQuery("from User where username=:username and password=:password");
			query.setParameter("username", user.getEmail().toLowerCase());
			query.setParameter("password", user.getPassword());
			
			Users aliveUser = null;
			
			try {
				aliveUser = (Users) query.getSingleResult();
			} catch (Exception e){
				e.printStackTrace();
			}

			return aliveUser;
		} catch (HibernateException e){
			e.printStackTrace();
			return null;
		}
	}

}
