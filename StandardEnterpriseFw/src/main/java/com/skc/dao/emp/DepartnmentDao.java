package com.skc.dao.emp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.skc.domain.Departnment;

@Repository("deptDao")
public class DepartnmentDao {
	
	@PersistenceContext(unitName="myUnit")
	EntityManager manager;
	
	@Transactional("transactionManager")
	public void save(Departnment departnment){
		manager.persist(departnment);
		System.out.println(departnment);
	}
	
	public List<Departnment> fetchAllDepartnment(){
		TypedQuery<Departnment> query = manager.createNamedQuery("from Departnment",Departnment.class);
		return query.getResultList();
	}
	
	public List<Departnment> fetchDepartnmentById(Long id){
		TypedQuery<Departnment> query = manager.createNamedQuery("from Departnment d where d.id=:id",Departnment.class);
		query.setParameter("id", id);
		return query.getResultList();
	}
}
