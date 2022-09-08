package DAO;

import java.util.List;

import javax.persistence.EntityManager;

import entidades.Questao;

//DAO da perguntas
public class PerguntaDao {
	
	private EntityManager em;
	
	public PerguntaDao(EntityManager em) {
		this.em=em;
	}


	public List<Questao> listaQuestoes(){
		String  jpql= "SELECT q FROM Questao q";
		return  em.createQuery(jpql,Questao.class).getResultList();
	}
	

}
