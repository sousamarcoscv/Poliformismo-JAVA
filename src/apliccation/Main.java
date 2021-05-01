package apliccation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Employee;
import entities.OutsourcedEmployee;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		List <Employee> emp = new ArrayList<>();

		System.out.print("Enter the number of employes: ");
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
				double valuePerHour = sc.nextDouble();
				Employee outemployee = new OutsourcedEmployee(name, hours, perhours, valuePerHour);
				emp.add(outemployee);
			} else {
				Employee employee = new Employee(name,hours, perhours);
				emp.add(employee);
			}

		}
		sc.close();
		System.out.println("");
		System.out.println("Payments:");
		for(Employee c:emp) {
			System.out.println(c.getName()+" - $ "+String.format("%.2f",c.payment()));
		}
	}
}
