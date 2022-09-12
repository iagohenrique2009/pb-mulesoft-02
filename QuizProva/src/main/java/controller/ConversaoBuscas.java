package controller;


import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import DAO.PerguntaDao;
import DAO.ResultadoDao;
import entidades.Questao;
import entidades.Resultado;
import util.JPAutil;

//Pega o resultado de um busca e transforma em String
public class ConversaoBuscas {
	
	EntityManager em = JPAutil.getEntityManager();
	PerguntaDao perguntaDao = new PerguntaDao(em);
	ResultadoDao resultadoDao= new ResultadoDao(em);
	AtivarDesativar ativar = new AtivarDesativar();

	
	public void listaPlacar(){
		
		List<Resultado> todoPlacar= resultadoDao.buscarResultadoMaiorAoMenor();
		
		
			todoPlacar.forEach(tp -> System.out.println("JOGADOR: "+tp.getNomeJogador()+
					"  ACERTOS: "+tp.getAcertos()+
					"  DATA: "+tp.getDataDaJogada()
					.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))
				)); 
		
		
	}
	
	public List<String> listaQuestoes() {
		
		List<Questao> listaquestoes =perguntaDao.listaQuestoes();
		List<String> perguntas= new ArrayList<>();
		listaquestoes.forEach(p ->perguntas.add(p.getPergunta()));
		return perguntas;
		
		
	}
	
	public  boolean[] listaRespostas() {
		
		List<Questao> todasRespostas =perguntaDao.listaQuestoes();
		boolean[] respostas = new boolean[todasRespostas.size()];
		for(int i=0;i<todasRespostas.size();i++) {
			respostas[i]=todasRespostas.get(i).getResposta();
			ativar.ativaQuestoes(todasRespostas.get(i));
		}
		
		return respostas;
	}
	

	
	

}
