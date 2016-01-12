package ar.com.templateit.prueba;

import java.util.Calendar;

public class Principal {

	public static void main(String[] args) {
		String valor ="13";
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, +Integer.parseInt(valor));
		System.out.println(cal.getTime());
	}
}
