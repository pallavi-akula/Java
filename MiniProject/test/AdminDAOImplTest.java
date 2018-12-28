import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.cg.project.dao.AdminDAO;
import com.cg.project.dao.AdminDAOImpl;
import com.cg.project.exception.UASException;


public class AdminDAOImplTest {

private AdminDAO adminRef;
	
	@Before
	public void setup(){
		System.out.println("DAO instantiated");
		adminRef = new AdminDAOImpl();
	}
	
	@After
	public void tearDown(){
		System.out.println("DAO cleaned");
		adminRef = null;
	}
	@Test
	public void testloginverification()throws UASException{
		String role= "ADMIN";
		String role1=adminRef.loginverification("IN100", "capgemini");
		Assert.assertNull(role1);
		Assert.assertEquals(role, role1);
	}
	
	
	
}
