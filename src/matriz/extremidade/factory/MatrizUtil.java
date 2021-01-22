package matriz.extremidade.factory;

import java.util.ArrayList;
import java.util.List;

import matriz.extremidade.dto.Matriz;

public class MatrizUtil {

	private int valorAtual;
	private int valorInicial;
	private int somador;
	private List<Matriz> matrizes;

	public MatrizUtil(int valorInicial, int somador, int linhas, int colunas) {
		this.valorAtual = valorInicial;
		this.valorInicial = valorInicial;
		this.somador = somador;
		Matriz matriz = new Matriz(linhas, colunas);
		matrizes = new ArrayList<Matriz>();
		matrizes.add(matriz);
	}

	public void imprimir() {
		for (Matriz matriz : matrizes) {
			int indexMaisUm = matrizes.indexOf(matriz) + 1;
			int[][] matrizNumerica = matriz.getMatriz();
			int linhas = matriz.getLinhas();
			int colunas = matriz.getColunas();
			System.out.println("Matriz " + indexMaisUm + " com " + matriz.getLinhas() + " linhas e "
					+ matriz.getColunas() + " colunas.");
			for (int i = 0; i < linhas; i++) {
				for (int j = 0; j < colunas; j++) {
					int valor = matrizNumerica[i][j];
					String valorStr = retornaValorComEspacos(valor);
					System.out.print(valorStr + "   ");
				}
				// Para pular as linhas da Matriz Atual
				System.out.println("");
			}
			// Para começar uma nova matriz com espaço
			System.out.println("");
			System.out.println("*****************");
			System.out.println("");
		}
	}

	public int getTamanhoValorTotal() {
		String strValorTotal = String.valueOf(valorAtual);
		return strValorTotal.length();
	}

	private String retornaValorComEspacos(Integer valor) {
		return retornaValorComEspacos(valor.toString());
	}

	private String retornaValorComEspacos(String valorStr) {
		int total = getTamanhoValorTotal();
		int tamanhoValor = valorStr.length();
		if (tamanhoValor < total) {
			for (int i = tamanhoValor; i < total; i++)
				valorStr += " ";
		}
		return valorStr;
	}

	public void somar() {
		somar(matrizes.get(0));
	}

	public void somar(Matriz matriz) {
		int[][] matrizInt = matriz.getMatriz();

		// Soma a Primeira Linha até o final
		Integer primeiraLinha;
		for (primeiraLinha = 0; primeiraLinha < matriz.getColunas(); primeiraLinha++) {
			matrizInt[0][primeiraLinha] = valorAtual;
			valorAtual += somador;
		}

		// Soma a Ultima Coluna (não contando o ultimo registro da primeira linha)
		int indexUltimaColuna = matriz.getColunas() - 1;
		Integer ultimaColuna;
		for (ultimaColuna = 1; ultimaColuna < matriz.getLinhas(); ultimaColuna++) {
			matrizInt[ultimaColuna][indexUltimaColuna] = valorAtual;
			valorAtual += somador;
		}

		// Soma a Ultima Linha (não contando o ultimo registro da ultima coluna)
		// Mas só soma a última linha se a Matriz atual tiver mais de uma linha
		// Pois se for uma única linha ela é primeira e última, logo vai sobrescrever o
		// somatório da outra
		if (matriz.getLinhas() > 1) {
			int indexUltimaLinha = matriz.getLinhas() - 1;
			Integer ultimaLinha;
			for (ultimaLinha = (indexUltimaColuna - 1); ultimaLinha > -1; ultimaLinha--) {
				matrizInt[indexUltimaLinha][ultimaLinha] = valorAtual;
				valorAtual += somador;
			}
		}

		// Soma a Primeira Coluna (não contando o primeiro registro da ultima linha)
		// Mas só soma a primeira coluna se a Matriz atual tiver mais de uma coluna
		// Pois se for uma única coluna ela é primeira e última, logo vai sobrescrever o
		// somatório da outra
		if (matriz.getColunas() > 1) {
			Integer primeiraColuna;
			for (primeiraColuna = (matriz.getLinhas() - 2); primeiraColuna > 0; primeiraColuna--) {
				matrizInt[primeiraColuna][0] = valorAtual;
				valorAtual += somador;
			}
		}

		boolean temMatrizInterna = matriz.getLinhas() > 2;
		if (temMatrizInterna) {
			int linhaMatrizInterna = matriz.getLinhas() - 2;
			int colunaMatrizInterna = matriz.getColunas() - 2;
			if (linhaMatrizInterna > 0 && colunaMatrizInterna > 0) {
				Matriz interna = new Matriz(linhaMatrizInterna, colunaMatrizInterna);
				matrizes.add(interna);
				somar(interna);
			}
		}
	}

	public List<Matriz> getMatrizes() {
		return matrizes;
	}

	public void setMatrizes(List<Matriz> matrizes) {
		this.matrizes = matrizes;
	}

	public int getValorInicial() {
		return valorInicial;
	}

	public void setValorInicial(int valorInicial) {
		this.valorInicial = valorInicial;
	}

	public int getSomador() {
		return somador;
	}

	public void setSomador(int somador) {
		this.somador = somador;
	}

	public int getValorAtual() {
		return valorAtual;
	}

	public void setValorAtual(int valorAtual) {
		this.valorAtual = valorAtual;
	}

}