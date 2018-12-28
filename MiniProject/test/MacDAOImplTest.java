

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.cg.project.dao.MacDAO;
import com.cg.project.dao.MacDAOImpl;
import com.cg.project.dto.Applicant;
import com.cg.project.exception.UASException;

public class MacDAOImplTest {
	
	
private MacDAO macRef;
	
	@Before
	public void setup(){
		System.out.println("DAO instantiated");
		macRef = new MacDAOImpl();
	}
	
	@After
	public void tearDown(){
		System.out.println("DAO cleaned");
		macRef = null;
	}
	
	
	@Test
	public void testcreateapplicant() throws UASException{
		
	Applicant appl = new Applicant( "RAGHAVENDRA","09-03-1997","12th",91,"Masters","t.sai.ragha@gmail.com","P0001","Applied","10-08-2018");
		boolean appl1 = macRef.createapplicant(appl);
		

		Assert.assertTrue(appl1);

	}
	
	
	@Test
	public void testretrieveapplicants(String id) throws UASException
	{
		boolean b;
		b= macRef.retrieveapplications(id);
		Assert.assertTrue(b);
	}

}
