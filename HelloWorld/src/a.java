class a{
void process() throws Exception { throw new Exception(); }
}
 class B extends a {
 void process() { System.out.println("B"); }
 
 public static void main(String[] args) {
 new B().process();
 }
}