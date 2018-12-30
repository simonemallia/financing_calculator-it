/*           Coded
 *                 by
 *                    Simone Mallia
 */

import java.util.InputMismatchException;
import java.util.Scanner;

public class Struttura {
	
	private int numerorate;
	private double prezzorata;
	private int ratepagate;
	public Scanner tastiera = new Scanner (System.in);
	
	
	
	public void setNumeroRate(int n) {
		numerorate = n;
	}
	
	public void setPrezzoRata (double p) {
		prezzorata = p ;
	}
	
	public void setRatePagate (int r) {
		ratepagate = r;
	}
	
	public int getRateMancanti() {
		return numerorate - ratepagate;
	}
	
	public double getMancanzaSoldi() {
		return getRateMancanti() * prezzorata;
	}
	
	public void intro() throws InterruptedException {
		
		System.out.println("Benvenuto in Calcolatore di finanziamenti!");
        System.out.println("Inserisci qui i dati del tuo finanziamento e ti calcolerò quanto hai pagato e quanto ti manca!");
		Thread.sleep(1000);
		
		while(true) {
		
		try {
		System.out.println("Inserisci il numero di rate totali del tuo finanziamento ");
		setNumeroRate(tastiera.nextInt());
		System.out.println("Inserisci il prezzo della tua rata, avendo cura di inserire la virgola e non il punto se il prezzo contiene un decimale: ");
		setPrezzoRata(tastiera.nextDouble());
		System.out.println("Inserisci il numero di rate pagate del tuo finanziamento: ");
		setRatePagate(tastiera.nextInt());
		
		if (getRateMancanti() < 0) {
			System.out.println("Numero non valido. Riprova");
			Thread.sleep(1000);
			continue;
		}
		
		else if (getRateMancanti() == 0) {
			System.out.println("Complimenti hai compleatato il tuo finanziamento!");
			break;
		}
		
		else if (getRateMancanti() > 0) {
		System.out.println("Ti mancano da pagare " + getRateMancanti() + " rate.");
		System.out.println("Ti manca ancora da pagare " +getMancanzaSoldi() + " euro.");
		break;
		}
		
		}catch (InputMismatchException e) {
			System.out.println("Input non riconosciuto. Riprova");
			Thread.sleep(1000);
			tastiera.nextLine();
			continue;
		}
		
		
	}
	}

}
