package entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="questoes")
//entidade questao
public class Questao {
	
	public Questao() {
		
	}
	
	@Id
	@GeneratedValue
	private int id;
	
	@Column(name="pergunta")
	private String pergunta;
	
	@Column(name="resposta")
	private boolean resposta;
	
	@Column(name="ativa")
	private boolean atual_questao;
	
	
	public Questao(String pergunta,boolean resposta) {
		this.pergunta=pergunta;
		this.resposta=resposta;
	}
	

	public String getPergunta() {
		return pergunta;
	}
	
	public void setPergunta(String pergunta) {
		this.pergunta = pergunta;
	}
	
	public boolean isResposta() {
		return resposta;
	}
	
	public void setResposta(boolean resposta) {
		this.resposta = resposta;
	}
	
	public boolean isAtual_questao() {
		return atual_questao;
	}
	
	public void setAtual_questao(boolean atual_questao) {
		this.atual_questao = atual_questao;
	}

}
