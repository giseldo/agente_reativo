public class Agente {

	char[] percepcao;

	public char[] getPercepcao() {
		return percepcao;
	}

	public void setPercepcao(char[] percepcao) {
		this.percepcao = percepcao;
	}
	
	/**
	 * Age sobre o ambiente:
	 * (a) Limpa o quadrado em que est� e
	 * (b) Move para o pr�ximo quadrado sujo, seguindo a regra de prioridade:
	 * Norte, Sul,Leste e Oeste
	 * @param ambiente O agente age/atua sobre o ambiente
	 */
	public void acao(Ambiente ambiente) {
		
		PosXY posXY = ambiente.getAgentePosXY(); // retorna a posi�o atual do agente
		int posX = posXY.getPosX();
		int posY = posXY.getPosY();

		for (int i = 0; i < percepcao.length; i++) { // loop nas percep�es
			if (percepcao[i] == EstadoQuadrado.SUJO) {
				if (i == PontosCardeais.NORTE) { 
					ambiente.limparPosicaoTabuleiro(posX, posY);
					ambiente.setPosicaoAgenteTabuleiro(new PosXY(posX - 1, posY));
					return;
				} else if (i == PontosCardeais.SUL) { 
					ambiente.limparPosicaoTabuleiro(posX, posY);
					ambiente.setPosicaoAgenteTabuleiro(new PosXY(posX + 1, posY));
					return;
				} else if (i == PontosCardeais.LESTE) {
					ambiente.limparPosicaoTabuleiro(posX, posY);
					ambiente.setPosicaoAgenteTabuleiro(new PosXY(posX, posY - 1));
					return;
				} else if (i == PontosCardeais.OESTE) { 
					ambiente.limparPosicaoTabuleiro(posX, posY);
					ambiente.setPosicaoAgenteTabuleiro(new PosXY(posX, posY + 1));
					return;
				}
			}
		}

	}

}
