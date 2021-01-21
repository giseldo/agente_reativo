public class Principal {
	
	/**
	 * Tarefa: Verifique se este agente reativo pode entrar em loop inifinito  
	 * e deixar algum quadrado sujo. Em outras palavras ele sempre deixar� o 
	 * tabuleiro limpo? Sim ou n�o.
	 * Dica: aumente o tamanho e o posicione em outro local
	 */
	public static void main(String[] args) throws InterruptedException {
		// cria um agente
		Agente agente = new Agente();
		int tamanhoAmbiente = 4;
		// cria um ambiente do tipo matriz/tabuleiro (tamanho x tamanho) 
		Ambiente ambiente = new Ambiente(tamanhoAmbiente);
		// posiciona no ambiente o agente em uma posi�o especifica
		PosXY posicaoAgente = new PosXY(2, 2);
		ambiente.setPosicaoAgenteTabuleiro(posicaoAgente);
		
    // 
    int contador = 0;
		// exibe o ambiente para o usuario acompanhar o que esta acontecendo
		Util.exibir(ambiente);
		// loop infinito
		while (true) {
      
      // agente recebe a percep�o do ambiente
			agente.setPercepcao(ambiente.getPercepcoesAdjacentesAoAgente());
			// age sobre o ambiente
 			agente.acao(ambiente);
 		    // exibe o ambiente para o usuario acompanhar o que esta acontecendo
			Util.exibir(ambiente);
      // adicionei essa saída loop para ele nao ficar em loop inifinito
      contador++;
			if (contador > 100) break;
		}

	}
}
