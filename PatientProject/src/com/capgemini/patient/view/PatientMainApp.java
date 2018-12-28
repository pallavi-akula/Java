package com.capgemini.patient.view;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Logger;

import org.apache.log4j.PropertyConfigurator;

import com.capgemini.patient.exception.PatientException;
//import com.capgemini.patient.view.Logger;
import com.capgemini.patient.service.PatientServiceImpl;
import com.capgemini.tcc.bean.Patient;
import com.capgemini.patient.service.IPatientService;

public class PatientMainApp {

	
		static Scanner sc = new Scanner(System.in);
		static IPatientService patientService = null;
		static PatientServiceImpl patientServiceImpl = null;
		static Logger logger = Logger.getRootLogger();

		public static void main(String[] args) throws Exception {
			PropertyConfigurator.configure("resources//log4j.properties");
			Patient patient = null;

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

						while (patient  == null) {
							patient = populatePatient();
							 System.out.println(patient);
						}

						try {
							patientService = new PatientServiceImpl();
							patient_id = patientService.addPatientDetails(patient);

							System.out.println("cust details  has been successfully registered ");
							System.out.println("cust  ID Is: " + patient_id);

						} catch (PatientException patientException) {
							logger.error("exception occured", patientException);
							System.out.println("ERROR : "
									+ patientException.getMessage());
						} finally {
							patient_id = null;
							patientService = null;
							patient = null;
						}

						break;


					case 2:

						System.out.print("Exit Trust Application");
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

		private static Patient populatePatient() throws Exception {

			// Reading and setting the values for the donorBean
			
			Patient patient= new Patient();

			System.out.println("\n Patient Details");

			System.out.println("Enter  name: ");
			patient.setName(sc.next());
			System.out.println("Enter age: ");
			patient.setAge(sc.next());
			System.out.println("Enter phone: ");
			patient.setPhoneNumber(sc.next());
			System.out.println("Enter Description int: ");
			patient.setDescription(sc.next());
			
		
			
			patientServiceImpl = new PatientServiceImpl();
	//System.out.println("After creating customer service impl object");

			try {
				patientServiceImpl.validatePatient(patient);
				
				System.out.println("after validate customer");
				return patient;
			} catch (PatientException patientException) {
				logger.error("exception occured", patientException);
				System.err.println("Invalid data:");
				System.err.println(patientException.getMessage() + " \n Try again..");
				System.exit(0);

			}
			return null;

		}

	}


