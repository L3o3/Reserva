package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reserva;
import model.exceptions.DomainException;

public class Programa {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			System.out.print("Número do Quarto: ");
			int numero = sc.nextInt();
			System.out.print("Data de Check-in: ");
			Date checkIn = sdf.parse(sc.next());
			System.out.print("Data de Check-out: ");
			Date checkOut = sdf.parse(sc.next());
					
			Reserva reserva = new Reserva(numero, checkIn, checkOut);
			System.out.println("Reserva: " + reserva);
			
			System.out.println();
			System.out.println("Entre com os dados para atualizar a reserva.");
			System.out.print("Data de Check-in: ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Data de Check-out: ");
			checkOut = sdf.parse(sc.next());
			
			reserva.atualizar(checkIn, checkOut);
			System.out.println("Reserva: " + reserva);
		}
		catch (ParseException e) {
			System.out.println("Formado de data inválido");
		}
		//Em caso de bloco ser uma 'RuntimeException', não posso tirar esse bloco
		catch (DomainException e) {
			System.out.println("Erro na reseva: " + e.getMessage());
		}
		catch (RuntimeException e) {
			System.out.println("Erro inesperado");
		}
												
		sc.close();
	}
}
