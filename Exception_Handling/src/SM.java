public class SM
{
    public String checkIt(String s)
    {
	if(s.length() == 0 || s == null)
	{
	    return "EMPTY";
	}
	else return "NOT EMPTY";
    }
    
    public static void main(String[] args)
    {
	SM a = new SM();
	a.checkIt("");
    }
   
}
