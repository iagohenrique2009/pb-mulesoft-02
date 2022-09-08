package controller;


import java.time.format.DateTimeFormatter;
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

	
	public String[] listaPlacar(){
		
		List<Resultado> todoPlacar= resultadoDao.buscarResultadoMaiorAoMenor();
		String[] lista= new String[todoPlacar.size()];
		
		for(int i=0;i<todoPlacar.size();i++) {
			
			lista[i]="JOGADOR: "+todoPlacar.get(i).getNomeJogador()+
					"  ACERTOS: "+todoPlacar.get(i).getAcertos()+
					"  DATA: "+todoPlacar.get(i).getDataDaJogada().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
		}
		
		return lista;
	}
	
	public String[] listaQuestoes() {
		
		List<Questao> todasQuestoes= perguntaDao.listaQuestoes();
		String[] lista= new String[todasQuestoes.size()]; 
		
		for(int i=0;i<todasQuestoes.size();i++) {
			lista[i]=todasQuestoes.get(i).getPergunta();
			
		}
		return lista;
	}
	
	public boolean[] listaRespostas() {
		
		List<Questao> todasRespostas =perguntaDao.listaQuestoes();
		boolean[] lista = new boolean[todasRespostas.size()];
		
		for(int i=0;i<todasRespostas.size();i++) {
			
			lista[i]=todasRespostas.get(i).isResposta();
			ativar.ativaQuestoes(todasRespostas.get(i));
			
		}
		return lista;
	}
	

	
	

}
