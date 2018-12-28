package com.cg.learning.webservice;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

/**
 * The annotation @WebService signals that this is the SEI (Service Endpoint
 * Interface). @WebMethod signals that each method is a service operation.
 *
 * The @SOAPBinding annotation impacts the under-the-hood construction of the
 * service contract, the WSDL (Web Services Definition Language) document.
 * Style.RPC simplifies the contract and makes deployment easier.
 */

@WebService
@SOAPBinding(style = Style.RPC)
public interface CalculatorServer {
	@WebMethod
	int addition(int param1, int param2);

	@WebMethod
	int subtraction(int param1, int param2);

	@WebMethod
	int multiplication(int param1, int param2);

	@WebMethod
	int division(int param1, int param2);

	@WebMethod
	int modulus(int param1, int param2);
}
