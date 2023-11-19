package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reserva;

public class Programa {

	public static void main(String[] args) throws ParseException {

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Número do Quarto: ");
		int numero = sc.nextInt();
		System.out.print("Data de Check-in: ");
		Date checkIn = sdf.parse(sc.next());
		System.out.print("Data de Check-out: ");
		Date checkOut = sdf.parse(sc.next());
		
		if (!checkOut.after(checkIn)) {
			System.out.println("ERRO NA RESERVA: A data de check-out tem que ser depois da data de check-in.");
		}
		else {
			Reserva reserva = new Reserva(numero, checkIn, checkOut);
			System.out.println("Reserva: " + reserva);
			
			System.out.println();
			System.out.println("Entre com os dados para atualizar a reserva.");
			System.out.print("Data de Check-in: ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Data de Check-out: ");
			checkOut = sdf.parse(sc.next());
			
			Date agora = new Date();
			if (checkIn.before(checkOut) || checkOut.before(checkIn)) {
				System.out.println("ERRO NA RESERVA: As datas de reserva para atualizar tem que ser datas futuras");
			}
			else if (!checkOut.after(checkIn)) {
				System.out.println("ERRO NA RESERVA: A data de check-out tem que ser depois da data de check-in.");
			}
			else {
				reserva.atualizar(checkIn, checkOut);
				System.out.println("Reserva: " + reserva);
			}
		}
				
		sc.close();
	}
}
