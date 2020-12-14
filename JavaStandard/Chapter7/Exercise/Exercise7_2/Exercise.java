package JavaStandard.Chapter7.Exercise.Exercise7_2;

class SutdaCard{
	private int num;
	private boolean isKwang;

	SutdaCard(){
		this(1, true);
	}

	SutdaCard(int num, boolean isKwang){
		this.num = num;
		this.isKwang = isKwang;
	}
	// info()대신 Object클래스의 toString()을 오버라이딩했다.
	public String toString(){
		return this.num + (this.isKwang ? "K" : "");
	}
}

class SutdaDeck{
	final int CARD_NUM = 20;
	SutdaCard[] cards = new SutdaCard[CARD_NUM];

	/*
		섯다 카드 배열 초기화
	*/
	SutdaDeck(){
		for (int i = 0; i < cards.length; i++){
			int num = i % 10 + 1;
			boolean isKwang = (i < 10) && (num == 1 || num == 3 || num == 8);

			cards[i] = new SutdaCard(num, isKwang);
		}
	}

	/*
		shuffle
		배열 cards에 담긴 카드의 위치를 뒤섞는다.(Math.random()사용)
	*/
	void shuffle(){
		for (int i = 0; i < CARD_NUM; i++){
			SutdaCard tmp;
			int j = (int)Math.floor(Math.random() * (CARD_NUM));
			
			tmp = cards[i];
			cards[i] = cards[j];
			cards[j] = tmp;
		}
	}
	/*
		pick
		배열 cards에서 지정된 위치의 SutdaCard를 반환한다.
	*/
	SutdaCard pick(int index){
		if (index < -1 || index >= CARD_NUM)
			return null;
		return cards[index];
	}
	/*
		pick
		배열 card에서 임의의 위치 Sutdacard를 반환한다.
	*/
	SutdaCard pick(){
		double randomNum = Math.random();
		int index = (int)Math.floor(randomNum * (CARD_NUM));
		return cards[index];
	}
}


class Exercise {
	public static void main(String[] args) {
		SutdaDeck deck = new SutdaDeck();

		System.out.println(deck.pick(0));
		System.out.println(deck.pick());
		deck.shuffle();

		for (int i = 0; i < deck.cards.length; i++)
			System.out.print(deck.cards[i]+",");
		System.out.println();
		System.out.println(deck.pick(0));
	}
}

