package by.parsing.model.logic.stringCorrect;

public class StringCorrect {
	
	//the method to convert prices with rubles 
	public static String priceRubCorrection(String price) {
		String value = "р";
		if (price.contains(value)) {
			int index = price.indexOf(value);
			price = price.substring(0, index).trim();
		}
		return price;
	}

	//the method to convert prices with cents
	public static String priceCentCorrection(String price) {
		String value = "к.";
		if (price.contains(value)) {
			int index = price.indexOf(value);
			price = price.substring(0, index).trim();
		}
		return price;
	}

	//the method to convert taken response from a shop to a common format 
	public static String stringCorrectForParsing(String msg) {
		msg = msg.toLowerCase();
		String[] mass = { ".", "+", ",", "'", "\'", "\"", "«", "»", "\\", "|", "(", ")", "для мальчиков и девочек",
				"для мужчин", "для женщин", "для новорожденных ", "для мальчиков","для девочек", "для тонких волос", "для нормальных волос",
				"для жирных волос", "для окрашенных волос", "для сухих волос", "для окрашенных и поврежденных волос",
				" поврежденных волос", "для сухих повреждволос", "для сухих", "/повреждволос", "новый", "новая", "новое",
				"для сухих повреждволос", "д/повреждволос", "многослойные", "детские", "для детского питания",
				"восстановленный", "осветленный", "осветленны", "полнорацс", "duo", "single", "ультратонкие"};
		for (int i = 0; i < mass.length; i++) {
			if (msg.contains(mass[i])) {
				msg = msg.replace(mass[i], "");
			}
		}
		msg = msg.replace("  ", " ");
		msg = msg.replace("   ", " ");
		msg = msg.replace("    ", " ");
		msg = msg.replace("0 мл", "0мл");
		msg = msg.replace(" мл", "мл");
		msg = msg.replace(" кг", "кг");
		msg = msg.replace(" шт", "шт");
		msg = msg.replace(" г", "г");
		msg = msg.replace("д/", "для ");
		msg = msg.replace("мужской бритвы", "бритья");
		msg = msg.replace("белита", "BELITA");
		msg = msg.replace("гигиен ", "гигиенические ");
		msg = msg.replace(" и ", " ");
		

		msg = msg.trim().toUpperCase();

		return msg;
	}

}
