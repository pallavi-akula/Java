package com.capgemini.tcc.ui;

import java.util.InputMismatchException;
import java.util.Scanner;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.capgemini.tcc.bean.PatientBean;
import com.capgemini.tcc.exception.PatientException;
import com.capgemini.tcc.service.IPatientService;
import com.capgemini.tcc.service.PatientService;



public class Client  {

	static Scanner sc = new Scanner(System.in);
	static IPatientService Patientservice = null;
	static PatientService PatientService = null;
	static Logger logger = Logger.getRootLogger();

	public static void main(String[] args) throws Exception {
		PropertyConfigurator.configure("resources//log4j.properties");
		PatientBean patientbean = null;

		String patient_id=null;
		int option = 0;

		while (true) {

			// show menu
			System.out.println();
			System.out.println();
			System.out.println("  TakeCare Clinic Software Application");
			System.out.println("___________________________________________\n");

			System.out.println("1.Add Patient ");
			System.out.println("2.Patient by ID");
			System.out.println("3.Exit");
			System.out.println("____________________________________________");
			System.out.println("Select an option:");
			// accept option
//1.Add Patient
			try {
				option = sc.nextInt();

				switch (option) {

				case 1:

					while (patientbean  == null) {
						patientbean  = populatePatientbean();
						 System.out.println(patientbean);
					}

					try {
						PatientService = new PatientService();
						patient_id = PatientService.addPatientDetails(patientbean);

						System.out.println("cust details  has been successfully registered ");
						System.out.println("cust  ID Is: " + patient_id);

					} catch (PatientException patientsException) {
						logger.error("exception occured", patientsException);
						System.out.println("ERROR : "
								+ patientsException.getMessage());
					} finally {
						patient_id = null;
						PatientService = null;
						patientbean = null;
					}

					break;
					//2.Patient by ID
				case 2:

					PatientService = new PatientService();

					System.out.println("Enter numeric patient id:");
					patient_id = sc.next();

					while (true) {
						if (PatientService.validatePatientId(patient_id)) {
							break;
						} else {
							System.err
									.println("Please enter numeric donor id only, try again");
							patient_id= sc.next();
						}
					}

					patientbean = getPatientDetails(patient_id);

					if (patientbean != null) {
						System.out.println("Patient Id            :"
								+ patientbean.getPatient_id());
						System.out.println("Patient Name             :"
								+ patientbean.getPatient_name());
						System.out.println("Age         :"
								+ patientbean.getAge());
						System.out.println("Phone Number     :"
								+ patientbean.getPhone());
						System.out.println("Description       :"
								+ patientbean.getDescription());
						System.out.println("Consultation_Date  :"
								+ patientbean.getConsultation_Date());
					} else {
						System.err
								.println("There are no Patient details associated with donor id "
										+ patient_id);
					}

					break;

//3.Exit
				case 3:

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
	private static PatientBean getPatientDetails(String patient_id) {
		PatientBean patientBean = null;
		PatientService = new PatientService();

		try {
			
			patientBean = PatientService.viewPatientDetails(patient_id);
		} catch (PatientException patientException) {
			logger.error("exception occured ", patientException);
			System.out.println("ERROR : " + patientException.getMessage());
		}

		PatientService = null;
		return patientBean;
	}


	private static PatientBean populatePatientbean() throws Exception {


		
		PatientBean patientbean = new PatientBean();;

		System.out.println("\n Enter Details");
		System.out.println("Enter  name: ");
		patientbean.setPatient_name(sc.next());
		System.out.println("Enter age: ");
		patientbean.setAge(sc.next());
		System.out.println("Enter phone: ");
		patientbean.setPhone(sc.next());
		System.out.println("Enter Description: ");
		patientbean.setDescription(sc.next());
		
		PatientService = new PatientService();

		try {
			PatientService.validatePatient(patientbean);
			return patientbean;
		} catch (PatientException patientsException)  {
			logger.error("exception occured", patientsException);
			System.err.println("Invalid data:");
			System.err.println(patientsException.getMessage() + " \n Try again..");
			System.exit(0);

		}
		return patientbean;

	}
}

