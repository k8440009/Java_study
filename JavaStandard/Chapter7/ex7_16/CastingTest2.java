package JavaStandard.Chapter7.ex7_16;

public class CastingTest2 {
	public static void main(String[] args) {
		//Car car = new Car();
		Car car = new FireEngine();
		Car car2 = null;
		FireEngine fe = null;

		car.drive();
		fe = (FireEngine)car;
		fe.drive();
		car2 = fe;
		car2.drive();
	}
}

class Car{
	String color;
	int door;

	void drive(){	// 운전하는 기능
		System.out.println("drive, Brrrr~");
	}
	void stop(){	// 멈추는 기능
		System.out.println("stop!!!");
	}
}

class FireEngine extends Car{ // 소방차
	void water(){
		System.out.println("water!!!");
	}
}

class Ambulance extends Car{	// 앰뷸런스
	void siren(){ // 사이렌 울리는 기능
		System.out.println("siren~~");
	}
}