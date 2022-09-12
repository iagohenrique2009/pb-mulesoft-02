package Menu;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import controller.Adicionar;
import controller.AtivarDesativar;
import controller.ConversaoBuscas;
import entidades.Resultado;

//Metodos do jogo que servem para funcionar o menu principal

public class MetodosJogo {
	
	//menu e opcoes
	public static void menu() {
		
		boolean continuar = true;
		char opcao;
		ConversaoBuscas busca = new ConversaoBuscas();
		AtivarDesativar ativarDesativar = new AtivarDesativar();

		mensagens();
		ativarDesativar.desativaQuestoes();
		try (Scanner sc = new Scanner(System.in)) {
			do {

				opcao = sc.next().charAt(0);
				sc.nextLine();

				if (opcao == '1') {

					List<String> questoes = busca.listaQuestoes();
					boolean[] respostas = busca.listaRespostas();
					jogo(questoes, respostas, sc);
					mensagens();
					

				}

				else if (opcao == '2') {

					busca.listaPlacar();
					mensagens();

				}

				else if (opcao == '0') {

					continuar = false;

				}

				else {

					System.out.println("Opcao Incorreta!");

				}

			} while (continuar);

		}
		ativarDesativar.desativaQuestoes();
	}
	//mensagens padroes
	public static void mensagens() {

		System.out.println("Bem-vindo ao Quiz!");
		System.out.println("Escolha uma das opcoes: ");
		System.out.println("1-Jogar\n2-Ver Placar\n0-Sair");

	}
	//Perguntas do quiz
	public static void jogo(List<String> questoes, boolean[] respostas, Scanner sc) {
		int pontuacaoAcertos = 0, pontuacaoErros = 0;
		LocalDate diaHoje = LocalDate.now();
		int questaoCont=0;

		System.out.println("Digite o seu nome: ");
		String nome;
		do {
			nome = sc.nextLine();
		}while(nome.isBlank());
		

		for(String questao : questoes) {

			System.out.println("Questao " + (questaoCont) + ": " + questao);
			System.out.println("Respoda com S ou N: ");
			char resposta = sc.next().toLowerCase().charAt(0);
			
			if (acertoOuErro(resposta, respostas[questaoCont])) {
				
				pontuacaoAcertos += 1;
				System.out.println("Você Acertou!");
				
			} else {
				
				pontuacaoErros += 1;
				System.out.println("Você errou!");
				
			}
			questaoCont++;
		}
		System.out.println("Sua pontuação " + nome + " foi: ");

		System.out.println("Acertos: " + pontuacaoAcertos);
		System.out.println("Erros: " + pontuacaoErros);
		System.out.println("Total: " + (pontuacaoAcertos + pontuacaoErros));

		adicionaResultado(nome, pontuacaoAcertos, pontuacaoErros, diaHoje);

	}
	//Imprime o placar dos jogadores
	public static void placar(String[] placarJogadores) {
		
		System.out.println("Placar: ");
		
		for (int i = 0; i < placarJogadores.length; i++) {
			System.out.println(placarJogadores[i]);
		}

	}
	//Metodo para saber se a pessoa acertou ou errou
	public static boolean acertoOuErro(char c, boolean respostas) {
		boolean respostaUsuario;
		
		if (c == 's') {
			
			respostaUsuario = true;
		}
		else if(c =='n') {
			respostaUsuario=false;
		}
		else {
			System.out.println("Valor incorreto!");
			return false;
		}
		
		if (respostas==respostaUsuario) {
			return true;
		}
		
		return false;

	}
	//Adiciona o resultado do jogador ao banco de dados
	public static void adicionaResultado(String nome, int pontuacaoAcertos, int pontuacaoErros, LocalDate data) {
		
		Resultado resultadoJogador = new Resultado(nome, pontuacaoAcertos, pontuacaoErros, data);
		Adicionar adicionaPontuacao = new Adicionar();
		adicionaPontuacao.adicionarPontuacaoJogador(resultadoJogador);
	
	}
	

}
