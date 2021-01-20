package ia;

public class Ambiente {

	private int tamanhoAmbiente;

	private char tabuleiro[][];

	/**
	 * Construtor do ambiente, inicializa um tabuleiro com todas as posições sujas
	 * 
	 * @param tamanhoAmbiente, ex: 2 -> Será criado uma Matriz 2 x 2
	 */
	public Ambiente(int tamanhoAmbiente) {
		this.tamanhoAmbiente = tamanhoAmbiente;
		// inicializa o tabuleiro com todos os quadrados sujo
		this.tabuleiro = new char[tamanhoAmbiente][tamanhoAmbiente];
		for (int i = 0; i < this.tabuleiro.length; i++) {
			for (int j = 0; j < this.tabuleiro.length; j++) {
				this.tabuleiro[i][j] = EstadoQuadrado.SUJO;
			}
		}
	}

	/**
	 * Faz uma busca no tabuleiro pela posiçao XY do agente
	 * 
	 * @return Retorna a posição X, Y do Agente no tabuleiro
	 */
	public PosXY getAgentePosXY() {
		int posXAgente = -1, posYAgente = -1;
		for (int i = 0; i < this.tabuleiro.length; i++) {
			for (int j = 0; j < this.tabuleiro.length; j++) {
				if (this.tabuleiro[i][j] == EstadoQuadrado.AGENTE) {
					posXAgente = i;
					posYAgente = j;
					break;
				}
			}
		}
		return new PosXY(posXAgente, posYAgente);
	}

	/**
	 * Altera a posição do agente no tabuleiro
	 * 
	 * @param posX posicao X
	 * @param posY posicao Y
	 */
	public void setPosicaoAgenteTabuleiro(PosXY posXY) {
		this.tabuleiro[posXY.getPosX()][posXY.getPosY()] = EstadoQuadrado.AGENTE;
	}

	/**
	 * Retorna o tabuleiro completo
	 * 
	 * @return
	 */
	public char[][] getTabuleiro() {
		return this.tabuleiro;
	}

	/**
	 * Retorna uma lista com as posições(se sujo, ou limpo) adjacentes ao agente, o
	 * tabuleiro sabe onde o agente está, sabe se tem sujeira. Ex: [S,S,L,S]
	 * equivale a Norte Sujo, Sul Sujo, Leste Limpo, Oeste Sujo
	 * 
	 * @return Uma lista com as posições, Norte, Sul, Leste e Oeste a partir do
	 *         agente informando se tem sujeira ou se está limpo, se está nas bordas
	 *         do tabuleiro e não há nada retorna V (Vazio).
	 */
	public char[] getPercepcoesAdjacentesAoAgente() {
		
		char[] adjacentes = new char[4];
		for (int i = 0; i < adjacentes.length; i++)
			adjacentes[i] = EstadoQuadrado.VAZIO;

		PosXY posXYAgente = getAgentePosXY();
		int posX = posXYAgente.posX;
		int posY = posXYAgente.posY;

		if (posX - 1 >= 0) // pode mover para norte?
			adjacentes[PontosCardeais.NORTE] = this.tabuleiro[posX - 1][posY];
		if (posX + 1 < tamanhoAmbiente) // pode mover para sul?
			adjacentes[PontosCardeais.SUL] = this.tabuleiro[posX + 1][posY];
		if (posY - 1 >= 0) // pode mover para leste?
			adjacentes[PontosCardeais.LESTE] = this.tabuleiro[posX][posY - 1];
		if (posY + 1 < tamanhoAmbiente) // pode mover para oeste?
			adjacentes[PontosCardeais.OESTE] = this.tabuleiro[posX][posY + 1];

		return adjacentes;
	}

	/**
	 * Limpa uma posição do tabuleiro
	 * 
	 * @param posX Posição X
	 * @param posY Posição Y
	 */
	public void limparPosicaoTabuleiro(int posX, int posY) {
		this.tabuleiro[posX][posY] = EstadoQuadrado.LIMPO;
	}

}
