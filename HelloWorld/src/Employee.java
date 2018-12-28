
class EmployeeDemo{
	private int rollNumber;
	private String name;
	public int getRollNumber() {
		return rollNumber;
	}
	public void setRollNumber(int rollNumber) {
		this.rollNumber = rollNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
public class Employee {

	public static void main(String[] args) {
		EmployeeDemo emp = new EmployeeDemo();
		emp.setRollNumber(101);
		emp.setName("Sachin");
		}
}
