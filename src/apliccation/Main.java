package apliccation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Employee;
import entities.OutsourcedEmployee;
import entities.relatorio.Composer;
import entities.relatorio.Report;
import net.sf.jasperreports.engine.JRException;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		List<Employee> emp = new ArrayList<>();
		List<Composer> rel = new ArrayList<>();


		System.out.print("Enter the number of employees: ");
		int n;
		n = sc.nextInt();

		for (int c = 1; c <= n; c++) {
			System.out.println("Employee #" + c + " data:");
			System.out.print("Outsourced (y/n) ? ");
			char question = sc.next().charAt(0);
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Hours: ");
			int hours = sc.nextInt();
			System.out.print("Value per hour: ");
			double perhours = sc.nextDouble();
			if (question == 'y') {
				System.out.print("Additional charge: ");
				double Additional = sc.nextDouble();
				Employee outemployee = new OutsourcedEmployee(name, hours, perhours, Additional);
				Composer comp1 = new Composer(name, hours, perhours, Additional);
				emp.add(outemployee);
				rel.add(comp1);
			} else {
				Employee employee = new Employee(name, hours, perhours);
				Composer comp2 = new Composer(name, hours, perhours);
				emp.add(employee);
				rel.add(comp2);
			}

		}
		sc.close();
		Report relatorio = new Report();
		
		try {
			
			relatorio.gerarRelatorio(rel);
		} catch(JRException e) {
			e.printStackTrace();
		}
		
		
		System.out.println("");
		System.out.println("Payments:");
		for (Employee c : emp) {
			System.out.println(c.getName() + " - $ " + String.format("%.2f", c.payment()));
		}
		
		
	}
}
