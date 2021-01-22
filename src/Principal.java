import matriz.extremidade.factory.MatrizUtil;

public class Principal {

	public static void main(String[] args) {
		MatrizUtil matrizUtil = new MatrizUtil(2, 4, 6, 3);
		matrizUtil.somar();
		matrizUtil.imprimir();
	}

}
