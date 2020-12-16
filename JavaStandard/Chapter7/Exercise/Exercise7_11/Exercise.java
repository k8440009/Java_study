package JavaStandard.Chapter7.Exercise.Exercise7_11;

class MyTv2 {
	private boolean isPowerOn;
	private int channel;
	private int volume;
	private int prevChannel;

	private final int MAX_VOLUME = 100;
	private final int MIN_VOLUME = 0;
	private final int MAX_CHANNEL = 100;
	private final int MIN_CHANNEL = 100;


	public boolean isIsPowerOn() {
		return this.isPowerOn;
	}

	public void setIsPowerOn(boolean isPowerOn) {
		this.isPowerOn = isPowerOn;
	}

	public int getChannel() {
		return this.channel;
	}

	public void setChannel(int channel) {
		if (channel > MAX_CHANNEL || channel < MIN_CHANNEL)
			return ;

		this.prevChannel = this.channel;
		this.channel = channel;
	}

	public int getVolume() {
		return this.volume;
	}

	public void setVolume(int volume) {
		if (volume > MAX_VOLUME || volume < MIN_VOLUME)
			return ;

		this.volume = volume;
	}

	public void gotoPrevChannel(){
		setChannel(prevChannel);
	}

}

class Exercise {
	public static void main(String[] args) {
		MyTv2 t = new MyTv2();

		t.setChannel(10);
		System.out.println("CH:"+t.getChannel());
		t.setChannel(20);
		System.out.println("CH:"+t.getChannel());
		t.gotoPrevChannel();
		System.out.println("CH:"+t.getChannel());
		t.gotoPrevChannel();
		System.out.println("CH:"+t.getChannel());
	}
}
