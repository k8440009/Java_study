package JavaStandard.Chapter7.ex7_17;

public class InstanceofTest {
	public static void main(String[] args) {
		FireEngine fe = new FireEngine();

		if (fe instanceof FireEngine){
			System.out.println("This is a FireEngine instance");
		}

		if (fe instanceof Car){
			System.out.println("This is a Car instance");
		}

		if (fe instanceof Object){
			System.out.println("This is an Object instance");
		}
		System.out.println(fe.getClass().getName()); // 클래스 이름 출력
	}
}

class Car{}
class FireEngine extends Car{}
