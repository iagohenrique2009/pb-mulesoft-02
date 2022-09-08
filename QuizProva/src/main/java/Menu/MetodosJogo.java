package Menu;

import java.time.LocalDate;
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

					String[] questoes = busca.listaQuestoes();
					boolean[] respostas = busca.listaRespostas();
					jogo(questoes, respostas, sc);
					mensagens();
					

				}

				else if (opcao == '2') {

					String[] placarJogadores = busca.listaPlacar();
					placar(placarJogadores);
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
	public static void jogo(String[] questoes, boolean[] respostas, Scanner sc) {
		int pontuacaoAcertos = 0, pontuacaoErros = 0;
		LocalDate diaHoje = LocalDate.now();

		System.out.println("Digite o seu nome: ");
		String nome = sc.nextLine();

		for (int i = 0; i < questoes.length; i++) {

			System.out.println("Questao " + (i + 1) + ": " + questoes[i]);
			System.out.println("Respoda com S ou N: ");
			char resposta = sc.next().toLowerCase().charAt(0);
			
			if (acertoOuErro(resposta, respostas[i])) {
				
				pontuacaoAcertos += 1;
				System.out.println("Você Acertou!");
				
			} else {
				
				pontuacaoErros += 1;
				System.out.println("Você errou!");
				
			}

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
	public static boolean acertoOuErro(char c, boolean respostaPergunta) {
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
		
		if (respostaUsuario == respostaPergunta) {
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
