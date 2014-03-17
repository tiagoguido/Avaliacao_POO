package br.edu.ifpi.poo.tiago.examefinal.util;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class JPAUtil {
private static EntityManager em;
	
	
	public static EntityManager getEntityManager(){
		if(em == null){
			em = Persistence.createEntityManagerFactory("cliente-jpa").createEntityManager();
		}
		return em;
	}

}
