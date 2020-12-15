package model.entities;

import java.util.Date;

public class CarRental {
	
	private Date Start;
	private Date finish;
	
	private Vehicle vehicle;
	private Invoice invoice;
	
	public CarRental() {
	}

	public CarRental(Date start, Date finish, Vehicle vehicle) {
		Start = start;
		this.finish = finish;
		this.vehicle = vehicle;
	}

	public Date getStart() {
		return Start;
	}

	public void setStart(Date star) {
		Start = star;
	}

	public Date getFinish() {
		return finish;
	}

	public void setFinish(Date finish) {
		this.finish = finish;
	}
	
	public Invoice getInvoice() {
		return invoice;
	}
	
	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}
	
}
