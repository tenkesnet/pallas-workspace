import java.util.Calendar;
import java.util.GregorianCalendar;

public class Csomag1 {
	public static void main(String[] args) {
		float x = 2.1f;
		double y = Math.ceil(x);

		System.out.println(String.format("Az x=%s,y=%s", x, y));
		int[] szamok = { 2, 4, 6, 8, 10 };
		try {
//			for (int i = 0; i < szamok.length + 1; i++) {
//				System.out.println(szamok[i]);
//			}
			for (String  arg : args) {
				System.out.println(arg);
			}
		} catch (Exception e) {
			System.err.println("Hiba!");
			// TODO: handle exception
		}

		GregorianCalendar gc = new GregorianCalendar();

		System.out.println(String.format("A dátum: %s/%s/%s %s:%02d:%02d", gc.get(Calendar.YEAR),
				gc.get(Calendar.MONTH) + 1, gc.get(Calendar.DAY_OF_MONTH), gc.get(Calendar.HOUR_OF_DAY),
				gc.get(Calendar.MINUTE), gc.get(Calendar.SECOND)));
		System.out.println("A dátum: " + gc.get(Calendar.YEAR) + "/" + (gc.get(Calendar.MONTH) + 1) + "/"
				+ gc.get(Calendar.DAY_OF_MONTH));

	}
}
