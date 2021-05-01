package entities.relatorio;

public class Composer {
	public String name;
	public String hour;
	public String valuePerHour;
	public String additional;
	public String payment;
	
	
	public Composer(String name, double hour, double valuePerHour, double additional) {
		
		this.name = name;
		this.hour = String.format("%.0f",hour);
		this.valuePerHour = "R$ "+ String.format("%.2f",valuePerHour);
		double payment = additional * 1.10;
		this.payment = "R$ "+ String.format("%.2f",payment+(hour*valuePerHour));
	}
	
	public Composer(String name, double hour, double valuePerHour) {

		this.name = name;
		this.hour = String.format("%.0f",hour);
		this.valuePerHour = "R$ "+ String.format("%.2f",valuePerHour);
		this.payment =  "R$ "+ String.format("%.2f",hour*valuePerHour);
		
	}

	public void setNome(String name) {
		this.name = name;
	}
	
	public void setHour(double hour) {
		this.hour = Double.toString(hour);
	}
	
	public void setValuePerHour ( double setValuePerHour ) {
		this.valuePerHour = Double.toString(setValuePerHour);
	}
	
	public void payment (double payment) {
		this.payment = Double.toString(payment);
	}

	public String getName() {
		return name;
	}

	public String getHour() {
		return hour;
	}

	public String getValuePerHour() {
		return valuePerHour;
	}

	public String getPayment() {
		return payment;
	}


	
	
}
