package JavaStandard.Chapter7.Exercise.Exercise7_5;

class Product {
	int price;
	int bonusPoint;

	Product(){}

	Product(int price){
		this.price = price;
		bonusPoint = (int)(price / 10.0);
	}
}

class Tv extends Product{

	Tv(){}

	public String toString(){
		return "Tv";
	}
}

class Exercise {
	public static void main(String[] args) {
		Tv t = new Tv();
	}
}
