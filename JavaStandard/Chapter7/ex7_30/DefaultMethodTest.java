package JavaStandard.Chapter7.ex7_30;

public class DefaultMethodTest {
	public static void main(String[] args) {
		Child c = new Child();
		c.method1();
		c.method2();
		MyInterface.staticMethod();
		MyInterface2.staticMethod();
	}
}

class Parent{
	public void method2(){
		System.out.println("method2() in Parent");
	}
}

interface MyInterface{
	default void method1(){
		System.out.println("method1() in MyInterface");
	}
	default void method2(){
		System.out.println("method2() in MyInterface");
	}
	static void staticMethod(){
		System.out.println("statcMethod() in MyInterface");
	}
}

interface MyInterface2{
	default void method1(){
		System.out.println("method1() in MyInterface2");
	}
	static void staticMethod(){
		System.out.println("statcMethod() in MyInterface2");
	}
}

class Child extends Parent implements MyInterface, MyInterface2{
	public void method1(){
		System.out.println("method1() in child");	// 오버 라이딩
	}
}