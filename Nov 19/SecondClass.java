package nov19;
public class SecondClass {
	public static void main(String[] args) {
		Staff1 s1=new Staff1();
		s1.bike();
		Staff2 s2=new Staff2();
		s2.bike();
		s2.oldBike();
		s2.oldBike1();
	}
}
class Dean{
	void oldBike1(){
		System.out.println("Royal Enfield 1978");
	}
}
class HOD extends Dean{
	void oldBike(){
		System.out.println("Royal Enfield Classic 350");
	}
}
class Staff1 extends HOD{
	void bike(){
		System.out.println("TVS Jupiter");
	}
}
class Staff2 extends HOD{
	void bike(){
		System.out.println("Bajaj CT 100");
	}
}