package com.controllers;

import java.util.ArrayList;
import java.util.Scanner;

import com.pojo.Patient;
import com.service.PatientServiceImpl;

public class PatientController {
	public static void main(String[] args) {
		PatientServiceImpl pp = new PatientServiceImpl();

		Scanner sc = new Scanner(System.in);
		int n=0;
		do
		{
			System.out.println("\nEnter 1 for registration \nEnter 2 to check Entry \nEnter 3 to update details "
					+ "\nEnter 4 to delete patient entry \nEnter 5 to read the all data \nEnter 6 to fetch all patient entries "
					+ "\nEnter 7 to fetch ID wise patient entry \nEnter 8 to exit the program");
			n=sc.nextInt();
			
			switch (n) {
			case 1:
				
				System.out.println("Enter Patients id,name,age,gender");
				Patient p = new Patient(sc.nextInt(), sc.next(), sc.nextInt(), sc.next());
				pp.regiter(p);
				break;
				
			case 2:
				System.out.println("Enter Patients id");
				Patient p1 = new Patient(sc.nextInt());
				if (pp.IsRegisted(p1)) {
					System.out.println("Patient is already exist!!!");
					
				} else {
					System.out.println("Patient is already exist!!!");
					System.out.println("Enter Patients id,name,age,gender");
					Patient p2 = new Patient(sc.nextInt(), sc.next(), sc.nextInt(), sc.next());
					pp.regiter(p2);

				}
				break;
				
			case 3:
				System.out.println("Enter what you want to update (name,age,gender):");
				String a=sc.next();
				System.out.println("Enter patient id and after enter new value:");
				int b=sc.nextInt();
				String c=sc.next();
				pp.updateDetails(a,b,c);
				break;
				
			case 4:
				System.out.println("Enter Patients id");
				Patient p2 = new Patient(sc.nextInt());
				pp.deleteEntry(p2);
				break;
				
			case 5:
				pp.viewData();
				break;
				
			case 6:
				ArrayList<Patient> ap=pp.fetchData();
				for (Patient patient : ap) {
					System.out.println(patient);
				}
				break;
				
			case 7:
				System.out.println("Enter Patients id");
				Patient p4 = new Patient(sc.nextInt());
				ArrayList<Patient> ap1=pp.fetchDataIdWise(p4);
				for (Patient patient : ap1) {
					System.out.println(patient);
				}
				
				break;
				
			case 8:
				System.out.println("Exiting te program!");
				break;
				
			default:
				System.out.println("Enter correct choice");
				break;
			}
		}while(n!=8);

	}
}
