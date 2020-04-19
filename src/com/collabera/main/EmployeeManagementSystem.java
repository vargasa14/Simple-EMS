package com.collabera.main;


import com.collabera.model.Employee;
import com.collabera.type.Department;

import java.util.*;

public class EmployeeManagementSystem {

	public static void main(String[] args)
	{
		int choice = 0;
		int dept = 0;
		int tempID = 0;
		Department tempDep;
		Employee tempEmployee;
		Scanner scanner = new Scanner(System.in);

		TreeMap <Integer, Employee > storeEmployee = new TreeMap<>();

		while (choice != 5)
		{
			try {
				System.out.println("   MENU  ");
				System.out.println("----------");
				System.out.println("1. ADD");
				System.out.println("2. REMOVE");
				System.out.println("3. MODIFY");
				System.out.println("4. PRINT");
				System.out.println("5. EXIT");

				choice = scanner.nextInt();
				switch (choice) {

				case 1:

					System.out.println("Enter Employee ID:");
					int id = scanner.nextInt();

					if (storeEmployee.containsKey(id)) {
						System.out.println("ID already exists! Please try again.\n");
					} else {

						System.out.println("Enter First Name:");
						String firstName = scanner.next();
						System.out.println("Enter Last Name:");
						String lastName = scanner.next();

						tempDep = null;

						System.out.print("Enter a department:\n1. Accounting\n2. HR\n3. Development\n4. Sales\n");

						dept = scanner.nextInt();
						switch (dept) {

						case 1: tempDep = Department.ACCOUNTING;
						break;
						case 2: tempDep = Department.HR;
						break;
						case 3: tempDep = Department.DEVELOPMENT;
						break;
						case 4: tempDep = Department.SALES;
						break;
						}
						storeEmployee.put(id, new Employee(id, firstName, lastName, tempDep));
						System.out.println("Employee Added: " + storeEmployee.get(id));
						System.out.println("---------------------------------------------------------------------------------------------------");
					}
					break;

				case 2:

					if (storeEmployee.isEmpty()) {
						System.out.println("No entries to remove! Please try again.\n");
					} else {
					
					System.out.println("Enter an ID to remove from the system");

					tempID = scanner.nextInt();

					if (storeEmployee.containsKey(tempID)) {
						tempEmployee = storeEmployee.remove(tempID);
						System.out.println("Employee removed: " + tempEmployee );
					} else {
						System.out.println("Employee not found! Please try again.\n");
						}
					}
					break;

				case 3:
					
					if (storeEmployee.isEmpty()) {
						System.out.println("No entries to modify! Please try again.\n");
					} else {
					
					System.out.println("Enter an Employee ID to modify.");
					id = scanner.nextInt();

					if (storeEmployee.containsKey(id)) {
						
						tempEmployee = storeEmployee.get(id); //employee key
						System.out.print("Enter a new department:\n1. Accounting\n2. HR\n3. Development\n4. Sales");

						switch (scanner.nextInt()) {

						case 1: tempEmployee.setDepartment(Department.ACCOUNTING);
						break;
						case 2: tempEmployee.setDepartment(Department.HR);
						break;
						case 3: tempEmployee.setDepartment(Department.DEVELOPMENT);
						break;
						case 4: tempEmployee.setDepartment(Department.SALES);
						break;
						}

						System.out.println("Department changed:" + tempEmployee);
					} 
					else {
						System.out.println("Employee not found!");
					}
				}
					break;

				case 4:

					if (storeEmployee.isEmpty()) {
						System.out.println("No entries to display! Please try again.\n");
					} else {
						for (Map.Entry<Integer, Employee> entry : storeEmployee.entrySet() )
							System.out.println(entry.getValue());
							System.out.println(" ");
					}
					break;

				default: System.out.println("Thank you for using the Employee Management System.");
				scanner.close();
				} 
			}//ends try block
			catch (InputMismatchException e) {
				System.out.println("Input Mismatch! " + e.getMessage());
				System.out.println(" ");
				scanner.nextLine();
			}
		}//ends while loop
	}//ends main method
}//ends EMS class