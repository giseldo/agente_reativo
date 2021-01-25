import java.util.Random;

public class Agente {

	char[] percepcao;

	public int qtdQuadradosForamLimpos = 1;

	public char[] getPercepcao() {
		return percepcao;
	}

	public void setPercepcao(char[] percepcao) {
		this.percepcao = percepcao;
	}

	/**
	 * Age sobre o ambiente: (a) Limpa o quadrado em que est� e (b) Move para o
	 * pr�ximo quadrado sujo, seguindo a regra de prioridade: Norte, Sul,Leste e
	 * Oeste
	 * 
	 * @param ambiente O agente age/atua sobre o ambiente
	 */
	public void acao(Ambiente ambiente) {

		PosXY posXY = ambiente.getAgentePosXY(); // retorna a posi�o atual do agente
		int posX = posXY.getPosX();
		int posY = posXY.getPosY();

		for (int i = 0; i < percepcao.length; i++) { // loop nas percep�es
			if (percepcao[i] == EstadoQuadrado.SUJO) {
				// ele se move so quando o prox quadrado esta sujo entao incremente
				// a quantidade de quadrados que foram limpos
				qtdQuadradosForamLimpos = qtdQuadradosForamLimpos + 1;
				ambiente.limparPosicaoTabuleiroSeEstiverSujo(posX, posY);
				if (i == PontosCardeais.NORTE) {
					ambiente.setNovaPosicaoAgenteTabuleiro(new PosXY(posX - 1, posY));
					return;
				} else if (i == PontosCardeais.SUL) {
					ambiente.setNovaPosicaoAgenteTabuleiro(new PosXY(posX + 1, posY));
					return;
				} else if (i == PontosCardeais.LESTE) {
					ambiente.setNovaPosicaoAgenteTabuleiro(new PosXY(posX, posY - 1));
					return;
				} else if (i == PontosCardeais.OESTE) {
					ambiente.setNovaPosicaoAgenteTabuleiro(new PosXY(posX, posY + 1));
					return;
				}
			}
		}

		/**
		 mover aleatoriamente o agente
		 
		Random gerador = new Random();
		int num = gerador.nextInt(4);
		switch (num) {
			case 0: {
				ambiente.limparPosicaoTabuleiroSeEstiverSujo(posX, posY);
				ambiente.setNovaPosicaoAgenteTabuleiro(new PosXY(posX - 1, posY));
			}
			case 1: {
				ambiente.limparPosicaoTabuleiroSeEstiverSujo(posX, posY);
				ambiente.setNovaPosicaoAgenteTabuleiro(new PosXY(posX + 1, posY));
			}
			case 2: {
				ambiente.limparPosicaoTabuleiroSeEstiverSujo(posX, posY);
				ambiente.setNovaPosicaoAgenteTabuleiro(new PosXY(posX, posY - 1));
			}
			case 3: {
				ambiente.limparPosicaoTabuleiroSeEstiverSujo(posX, posY);
				ambiente.setNovaPosicaoAgenteTabuleiro(new PosXY(posX, posY + 1));
			}
		}
		*/

	}

}
