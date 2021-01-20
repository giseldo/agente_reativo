package ia;

public class Util {

	public static void exibir(Ambiente ambiente) throws InterruptedException {
		char tabuleiro[][] = ambiente.getTabuleiro();
		for (int i = 0; i < tabuleiro.length; i++) {
			for (int j = 0; j < tabuleiro.length; j++) {
				System.out.print("| " + tabuleiro[i][j] + " |");
			}
			System.out.println("");
		}
		Thread.sleep(1500);
		System.out.println("");
	}

}
