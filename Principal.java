public class Principal {

	/**
	 * Tarefa: Verifique se este agente reativo pode entrar em loop inifinito e
	 * deixar algum quadrado sujo. Em outras palavras ele sempre deixar� o
	 * tabuleiro limpo? Sim ou n�o. Dica: aumente o tamanho e o posicione em outro
	 * local
	 */
	public static void main(String[] args) throws InterruptedException {
		// cria um agente
		Agente agente = new Agente();
		int tamanhoAmbiente = 4;
		// cria um ambiente do tipo matriz/tabuleiro (tamanho x tamanho)
		Ambiente ambiente = new Ambiente(tamanhoAmbiente);
		// posiciona no ambiente o agente em uma posi�o especifica
		PosXY posicaoAgente = new PosXY(2, 2);
		ambiente.setNovaPosicaoAgenteTabuleiro(posicaoAgente);

		Util.exibir(ambiente, agente);
		
		// loop infinito
		while (true) {
			// agente recebe a percep�o do ambiente
			agente.setPercepcao(ambiente.getPercepcoesAdjacentesAoAgente());
			// age sobre o ambiente
			agente.acao(ambiente);
			// exibe o ambiente para o usuario acompanhar o que esta acontecendo
			Util.exibir(ambiente, agente);
		}

	}
}
