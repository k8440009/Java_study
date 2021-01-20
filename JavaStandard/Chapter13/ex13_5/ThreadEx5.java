package JavaStandard.Chapter13.ex13_5;

public class ThreadEx5 {
	static long startTime = 0;
	public static void main(String[] args) {
		ThreadEx5_1 th1 = new ThreadEx5_1();
		th1.start();

		startTime = System.currentTimeMillis();
		for (int i = 0; i < 300; i++)
			System.out.printf("%s", new String("-"));
		System.out.println();
		System.out.println("소요 시간 1 : " + (System.currentTimeMillis() - startTime));
	}
}

class ThreadEx5_1 extends Thread{
	public void run(){
		for (int i = 0; i < 300; i++)
			System.out.printf("%s", new String("|"));
			System.out.println();
		System.out.println("소요 시간 2 : " + (System.currentTimeMillis() - ThreadEx5.startTime));
	}
}