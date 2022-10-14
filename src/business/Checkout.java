package business;

import java.io.Serializable;
import java.time.LocalDate;

public class Checkout implements Serializable{
	private LocalDate checkoutDate;
	private String copyId;
	private LocalDate dueDate;
	
	public Checkout(String copyId, LocalDate checkoutDate, LocalDate dueDate) {
		this.copyId = copyId;
		this.checkoutDate = checkoutDate;
		this.dueDate = dueDate;
	}
}
