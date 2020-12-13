package JavaStandard.Chapter6.Exercise;

class Student {
	String name;
	int ban;
	int no;
	int kor;
	int eng;
	int math;

	int getTotal(){
		return this.kor + this.math + this.eng;
	}

	float getAverage(){
		return (int)(getTotal() / 3f * 10 + 0.5f) / 10f;
		// return ((int)((getTotal() / 3f) * 100) + 5) / 100f;
		// return (float)((int)(((float)getTotal() / 3) * 100) + 5) / 100;
	}
}

class Exercise6_4 {
	public static void main(String args[]) {
		Student s = new Student(); 
		s.name = "홍길동";
		s.ban = 1;
		s.no = 1;
		s.kor = 100; 
		s.eng = 60; 
		s.math = 76;
		System.out.println("이름:"+s.name); 
		System.out.println("총점:"+s.getTotal()); 
		System.out.println("평균:"+s.getAverage());
	}
}