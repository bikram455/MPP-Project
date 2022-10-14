package business;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

final public class LibraryMember extends Person implements Serializable {
	private String memberId;
	private List<Checkout> checkouts;
	
	public LibraryMember(String memberId, String fname, String lname, String tel,Address add) {
		super(fname,lname, tel, add);
		this.memberId = memberId;		
		this.checkouts = new ArrayList<>();
	}
	public void setCheckouts(List<Checkout> checkouts) {
		this.checkouts = checkouts;
	}
	public List<Checkout> getCheckouts() {
		return checkouts;
	}
	
	public String getMemberId() {
		return memberId;
	}

	
	
	@Override
	public String toString() {
		return "Member Info: " + "ID: " + memberId + ", name: " + getFirstName() + " " + getLastName() + 
				", " + getTelephone() + " " + getAddress();
	}

	private static final long serialVersionUID = -2226197306790714013L;
	
	public void addCheckout(Checkout ch) {
		if(checkouts == null) checkouts = new ArrayList<>();
		checkouts.add(ch);
	}
}
