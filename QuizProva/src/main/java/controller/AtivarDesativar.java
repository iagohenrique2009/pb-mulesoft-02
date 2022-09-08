package controller;

import java.util.List;

import javax.persistence.EntityManager;

import DAO.PerguntaDao;
import entidades.Questao;
import util.JPAutil;

//Ativa ou desativa as questoes
public class AtivarDesativar {
	
	EntityManager em =JPAutil.getEntityManager();
	PerguntaDao perguntaDao = new PerguntaDao(em);
	
	public void ativaQuestoes(Questao q) {
	
	
	em.getTransaction().begin();
	
		q=em.merge(q);
		q.setAtual_questao(true);
		em.getTransaction().commit();
		
	}
	
	public void desativaQuestoes() {
	
		List<Questao> todasQuestoes= perguntaDao.listaQuestoes();
		em.clear();
		Questao questaolAtual = new Questao();
		em.getTransaction().begin();
		
		for(int i=0;i<todasQuestoes.size();i++) {
			
			questaolAtual=em.merge(todasQuestoes.get(i));
			questaolAtual.setAtual_questao(false);
			
		}
		em.getTransaction().commit();
		
	}

}
