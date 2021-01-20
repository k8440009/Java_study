package JavaStandard.Chapter13.ex13_6;

import javax.swing.JOptionPane;

public class ThreadEx6 {
	public static long startTime = System.currentTimeMillis();
	public static void main(String[] args) throws Exception{
		String input = JOptionPane.showInputDialog("아무 값이나 입력하세요.");
		System.out.println("입력 하신 값은 " + input + "입니다. ");
		
		for (int i = 10; i > 0; i--){
			System.out.println(i);
			try{
				Thread.sleep(1000); // 1초간 시간을 지연한다.
			} catch (Exception e){}
		}
		System.out.println("소요 시간 : " + (System.currentTimeMillis() - startTime));
	}	
}
