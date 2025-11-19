package nov19;
public class FirstClass {
	void AMG(){
		System.out.println("King Car");
	}
	public static void main(String[] args) {

		People1 k= new People1();
		k.bike();
		System.out.println(k.name_people1);
		FirstClass king=new FirstClass();
		king.AMG();
	}
}
class People1{
	String name_people1="Gopi";
	void car(){
		System.out.println("Hyundai Asta");
	}
	void bike(){
		System.out.println("TVS Raider");
	}
}
class People2{
	String name_people1="Mahesh";
	void car(){
		System.out.println("Mahindra Scorpio");
	}
}