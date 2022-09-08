package DAO;

import java.util.List;
import javax.persistence.EntityManager;
import entidades.Resultado;

//DAO do resultado
public class ResultadoDao {
	
private EntityManager em;
	
	public ResultadoDao(EntityManager em) {
		
		this.em=em;
		
	}
	
	public List<Resultado> buscarResultadoMaiorAoMenor(){

		String  jpql= "SELECT r FROM Resultado r ORDER BY acertos DESC";
		return  em.createQuery(jpql,Resultado.class).getResultList();
		
	}

}
