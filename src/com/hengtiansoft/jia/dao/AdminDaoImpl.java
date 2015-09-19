package com.hengtiansoft.jia.dao;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hengtiansoft.jia.entity.Admin;
@Service("adminDao")
public class AdminDaoImpl  implements AdminDao {
	@Autowired
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory){
		this.sessionFactory=sessionFactory;
	}

	@Override
	public Admin isExist(String name, String pwd) {
		
		String hql="from Admin a where a.name=? and a.password=?";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, name);
		query.setString(1, pwd);
		
		return (Admin) query.uniqueResult();
	}

}
