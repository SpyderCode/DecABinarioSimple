
import static javax.swing.JOptionPane.showMessageDialog;

import java.util.Scanner;

public class DecABinarioSimple {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Inserte un numero: ");
		String numero = in.nextLine();

		if (Double.parseDouble(numero) % 1 == 0 && Double.parseDouble(numero) < 0) {
			ComplementoDos(Double.parseDouble(numero));
		} else if (Double.parseDouble(numero) % 1 != 0 || Double.parseDouble(numero) >= 0) {

			System.out.println("Cuantos bits despues del '.'?");
			int bits = in.nextInt();
			System.out.println(binario(numero, bits));
		}

	}

	private static void ComplementoDos(double num) {
		// Esta funcion ya lo hace a complemento a dos :v
		try {
			System.out.println(Integer.toBinaryString((int) num));
		} catch (Exception ex) {
			showMessageDialog(null, "Valor no valido");

		}

	}

	public static String binario(String numero, int bits) {
		String salida = ""; // cadena vacia
		// parte entera
		try {
			double value = Double.parseDouble(numero);
			double x = (value % 1);
			String number = "" + (int) (value - x);

			long n = Long.parseLong(number);
			long cociente, residuo;
			cociente = n;
			do {
				residuo = cociente % 2;
				cociente = cociente / 2;
				salida = residuo + salida;
			} while (cociente != 0);

			String frac = "";
			while (x > 0 && bits > 0) {
				bits--;
				double r = x * 2;
				if (r >= 1) {
					frac += "1";
					x = r - 1;
				} else {
					frac += "0";
					x = r;
				}
			}

			return salida + "." + frac;
		} catch (Exception ex) {
			showMessageDialog(null, "Valor no valido");
			return null;
		}
	}
}
