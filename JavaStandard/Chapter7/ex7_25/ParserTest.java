package JavaStandard.Chapter7.ex7_25;

interface Parseable {
	// 구문 분석 작업을 수행한다.
	public abstract void parse(String fileName);
}

class ParserManger {
	// 리턴 타입이 Parseable한 인터페이스이다.
	public static Parseable getParser(String type){
		if (type.equals("XML")){
			return new XMLParser();
		} else{
			Parseable p = new HTMLParser();
			return p;
		}
	}
}

class XMLParser implements Parseable{
	public void parse(String fileName){
		/* 구문 분석 작업을 수행하는 코드를 적는다. */
		System.out.println(fileName + "- XML parsing completed.");
	}
}

class HTMLParser implements Parseable{
	public void parse(String fileName){
		/* 구문 분석작업을 수행하는 코드를 적는다. */
		System.out.println(fileName + "-HTML parsing completed.");
	}
}

class ParserTest {
	public static void main(String[] args) {
		Parseable parser = ParserManger.getParser("XML");
		parser.parse("document.xml");
		parser = ParserManger.getParser("HTML");
		parser.parse("document2.xml");
	}
}
