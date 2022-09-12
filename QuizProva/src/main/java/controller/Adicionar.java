package controller;

import javax.persistence.EntityManager;

import DAO.ResultadoDao;
import entidades.Resultado;
import util.JPAutil;

//Adiciona placar ao banco de dados
public class Adicionar {
	
	EntityManager em = JPAutil.getEntityManager();
	ResultadoDao resultadoDao= new ResultadoDao(em);
	
	
	public void adicionarPontuacaoJogador(Resultado r) {
		
		this.em.getTransaction().begin();
		r = this.em.merge(r);
		this.em.persist(r);
		this.em.getTransaction().commit();
		
		
	}

}
