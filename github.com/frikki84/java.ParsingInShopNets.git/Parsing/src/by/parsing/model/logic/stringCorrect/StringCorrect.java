package by.parsing.model.logic.stringCorrect;

public class StringCorrect {
	
	//the method to convert prices with rubles 
	public static String priceRubCorrection(String price) {
		String value = "�";
		if (price.contains(value)) {
			int index = price.indexOf(value);
			price = price.substring(0, index).trim();
		}
		return price;
	}

	//the method to convert prices with cents
	public static String priceCentCorrection(String price) {
		String value = "�.";
		if (price.contains(value)) {
			int index = price.indexOf(value);
			price = price.substring(0, index).trim();
		}
		return price;
	}

	//the method to convert taken response from a shop to a common format 
	public static String stringCorrectForParsing(String msg) {
		msg = msg.toLowerCase();
		String[] mass = { ".", "+", ",", "'", "\'", "\"", "�", "�", "\\", "|", "(", ")", "��� ��������� � �������",
				"��� ������", "��� ������", "��� ������������� ", "��� ���������","��� �������", "��� ������ �����", "��� ���������� �����",
				"��� ������ �����", "��� ���������� �����", "��� ����� �����", "��� ���������� � ������������ �����",
				" ������������ �����", "��� ����� ������������", "��� �����", "/������������", "�����", "�����", "�����",
				"��� ����� ������������", "�/������������", "������������", "�������", "��� �������� �������",
				"���������������", "�����������", "����������", "���������", "duo", "single", "������������"};
		for (int i = 0; i < mass.length; i++) {
			if (msg.contains(mass[i])) {
				msg = msg.replace(mass[i], "");
			}
		}
		msg = msg.replace("  ", " ");
		msg = msg.replace("   ", " ");
		msg = msg.replace("    ", " ");
		msg = msg.replace("0 ��", "0��");
		msg = msg.replace(" ��", "��");
		msg = msg.replace(" ��", "��");
		msg = msg.replace(" ��", "��");
		msg = msg.replace(" �", "�");
		msg = msg.replace("�/", "��� ");
		msg = msg.replace("������� ������", "������");
		msg = msg.replace("������", "BELITA");
		msg = msg.replace("������ ", "������������� ");
		msg = msg.replace(" � ", " ");
		

		msg = msg.trim().toUpperCase();

		return msg;
	}

}
