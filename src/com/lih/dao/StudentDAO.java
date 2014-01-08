package com.lih.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lih.entity.Marks;

@Repository
@Transactional
public class StudentDAO {
	
	@Autowired
    private SessionFactory sessionFactory;

	public boolean addStudentEntry(Marks mark) {
		//int id = Integer.parseInt((String) this.sessionFactory.getCurrentSession().save(mark));
		Integer id  =(Integer) this.sessionFactory.getCurrentSession().save(mark);
		
		if(id >= 0){
			System.out.println(id);
			return true;
		}
		return false;
	}
	
	public boolean addRollbackEntry(Marks mark1,Marks mark2){
		Session session= (Session) this.sessionFactory.getCurrentSession();
		Integer id = (Integer) session.save(mark1);
		System.out.println(id);
		mark2.setStudId(id);
		id = (Integer) session.save(mark2);
		System.out.println(id);
		return true;
		
	}
}
