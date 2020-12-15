package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.CarRental;
import model.entities.Vehicle;
import model.services.BrazilTaxService;
import model.services.RentalService;

public class Program {

	public static void main(String[] args) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:ss");
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter rental data: ");
		System.out.print("Car model: ");
		String carModel = sc.nextLine();

		System.out.print("Pickup (dd/mm/yyyy hh:ss): ");
		Date start = sdf.parse(sc.nextLine());

		System.out.print("Return (dd/mm/yyyy hh:ss): ");
		Date finish = sdf.parse(sc.nextLine());
		
		CarRental car = new CarRental(start, finish, new Vehicle(carModel));

		System.out.print("Enter price per hour: ");
		double pricePerHour = sc.nextDouble();
		System.out.print("Enter price per day: ");
		double pricePerDay = sc.nextDouble();
		
		RentalService rental = new RentalService(pricePerHour, pricePerDay, new BrazilTaxService());
		rental.processInvoice(car);
		
		System.out.println();
		System.out.println("INVOICE:");
		System.out.println("Basic payment: " +String.format("%.2f", car.getInvoice().getBasicPayment()));
		System.out.println("Tax payment: " +String.format("%.2f", car.getInvoice().getTax()));
		System.out.println("Total payment: " +String.format("%.2f", car.getInvoice().getTotalPayment()));
		
		
		sc.close();
	}

}
