package JavaStandard.Chapter7.ex7_15;

public class CastingTest1 {
	public static void main(String[] args) {
		Car car = null;
		FireEngine fe = new FireEngine();
		FireEngine fe2 = null;

		fe.water();
		car = fe; // car = (Car)fe 형변환이 생략
		// car.water(); // 컴파일 에러 Car 타입의 참조 변수로는 water()를 호출할 수 없다.
		fe2 = (FireEngine)car; // 자손타입 -> 조상타입
		fe2.water();
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