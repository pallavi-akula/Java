package com.capgemini.pi;

import java.util.InputMismatchException;

import java.util.Scanner;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.capgemini.bean.Patientbean;
import com.capgemini.exception.PatientsException;
import com.capgemini.service.PatientServiceImpl;
import com.capgemini.service.IPatientService;
//import com.capgemini.dao;
import java.lang.NullPointerException;

@SuppressWarnings("unused")
public class PatientMain  {

	static Scanner sc = new Scanner(System.in);
	static IPatientService patientService = null;
	static PatientServiceImpl patientServiceImpl = null;
	static Logger logger = Logger.getRootLogger();

	public static void main(String[] args) throws Exception {
		PropertyConfigurator.configure("resources//log4j.properties");
		Patientbean patientbean = null;

		String patient_id = null;
		int option = 0;

		while (true) {

			// show menu
			System.out.println();
			System.out.println();
			System.out.println("   Patient Application ");
			System.out.println("_______________________________\n");

			System.out.println("1.Add Patient ");
			System.out.println("2.Exit");
			System.out.println("________________________________");
			System.out.println("Select an option:");
			// accept option

			try {
				option = sc.nextInt();

				switch (option) {

				case 1:

					while (patientbean  == null) {
						patientbean   = populatePatientbean ();
						 System.out.println(patientbean);
					}

					try {
						patientService = new PatientServiceImpl();
						patient_id = patientService.addPatientDetails(patientbean);

						System.out.println("Patient details  has been successfully registered ");
						System.out.println("Patient  ID Is: " + patient_id);

					} catch (PatientsException patientsException) {
						logger.error("exception occured", patientsException);
						System.out.println("ERROR : "
								+ patientsException.getMessage());
					} finally {
						patient_id = null;
						patientService = null;
						patientbean = null;
					}

					break;


				case 2:

					System.out.print("Exit Patient Application");
					System.exit(0);
					break;
				default:
					System.out.println("Enter a valid option[1-4]");
				}// end of switch
			}

			catch (InputMismatchException e) {
				sc.nextLine();
				System.err.println("Please enter a numeric value, try again");
		}

		}// end of while
	}

	private static Patientbean populatePatientbean() throws Exception {

		
		Patientbean patientbean = new Patientbean();

		System.out.println("\n Patient Details");

		System.out.println("Enter  name: ");
		patientbean.setName(sc.next());
		System.out.println("Enter age: ");
		patientbean.setAge(sc.next());
		System.out.println("Enter phone: ");
		patientbean.setPhoneNumber(sc.next());
		System.out.println("Enter Description: ");
		patientbean.setDescription(sc.next());
		
	
		
        patientServiceImpl = new PatientServiceImpl();
//System.out.println("After creating patient service impl object");

		try {
			patientServiceImpl.validatePatient(patientbean);
			
			System.out.println("after validate patient");
			return patientbean ;
		} catch (PatientsException patientsException) {
			logger.error("exception occured", patientsException);
			System.err.println("Invalid data:");
			System.err.println(patientsException.getMessage() + " \n Try again..");
			System.exit(0);

		}
		return null;

	}
}
