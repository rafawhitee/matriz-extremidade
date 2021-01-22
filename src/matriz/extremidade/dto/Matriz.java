package matriz.extremidade.dto;

public class Matriz {

	private int linhas;
	private int colunas;
	private int[][] matriz;
	
	public Matriz(int linhas, int colunas) {
		this.linhas = linhas;
		this.colunas = colunas;
		matriz = new int[linhas][colunas];
	}
	
	public Matriz(int[][] matriz) {
		this.matriz = matriz;
	}

	public int[][] getMatriz() {
		return matriz;
	}

	public void setMatriz(int[][] matriz) {
		this.matriz = matriz;
	}

	public int getLinhas() {
		return linhas;
	}

	public void setLinhas(int linhas) {
		this.linhas = linhas;
	}

	public int getColunas() {
		return colunas;
	}

	public void setColunas(int colunas) {
		this.colunas = colunas;
	}
	
}