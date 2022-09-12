package entidades;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="resultados")
//entidade resultado
public class Resultado {
	
	@Id
	@GeneratedValue
	private int id;
	
	@Column(name="jogador")
	private String nomeJogador;
	
	@Column(name="acertos")
	private int acertos;
	
	@Column(name="erros")
	private int erros; 
	
	@Column(name="data_da_partida")
	private LocalDate dataDaJogada;

	public Resultado() {};
	
	public Resultado(String nome,int acertos,int erros,LocalDate data) {
		
		this.nomeJogador=nome;
		this.acertos=acertos;
		this.erros=erros;
		this.dataDaJogada=data;
		
	}
	
	public String getNomeJogador() {
		return nomeJogador;
	}
	
	public void setNomeJogador(String nomeJogador) {
		this.nomeJogador = nomeJogador;
	}
	
	public int getAcertos() {
		return acertos;
	}
	
	public void setAcertos(int acertos) {
		this.acertos = acertos;
	}
	
	public int getErros() {
		return erros;
	}
	
	public void setErros(int erros) {
		this.erros = erros;
	}
	
	public LocalDate getDataDaJogada() {
		return dataDaJogada;
	}
	
	public void setDataDaJogada(LocalDate dataDaJogada) {
		this.dataDaJogada = dataDaJogada;
	}
	

}
