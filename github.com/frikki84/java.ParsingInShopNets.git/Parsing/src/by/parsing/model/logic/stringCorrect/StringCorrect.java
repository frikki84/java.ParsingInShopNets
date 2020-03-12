package by.parsing.model.logic.stringCorrect;


public class StringCorrect {
    public  static final int INDEX_IN_BUSLIK_DELETE_OT_FROM_PRICE = 3;

    public static String priceRubCorrection(String price) {
        String value = "�";
        if (price.contains(value)) {
            int index = price.indexOf(value);
            price = price.substring(0, index).trim();
        }
        return price;
    }

    public static String priceCorrectionFrom_OT(String price) {
        String value = "�� "; // "�� 25 ���"
        if (price.contains(value)) {
            price = price.substring(INDEX_IN_BUSLIK_DELETE_OT_FROM_PRICE).trim();
        }
        return price;
    }

    public static String priceCorrectionWildberries(String price) {
        String value = " �. "; // "�� 25 ���"
        if (price.contains(value)) {
            price = price.replace(" �. ", ".");
            price = price.replace(" �.", "");
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

    public static String stringCorrectForParsing(String msg) {
        msg = msg.toLowerCase();
        msg = msg.replace(" ���� ", " gold ");
        msg = msg.replace("�������.", "������������� ");
        msg = msg.replace("�������. ", "�������������� ");
        msg = msg.replace("�����. ", "���������� ");
        msg = msg.replace("��� ����� ������ � ������������� �������", "��� ������������� �����");
        msg = msg.replace("���������� ������� ", "�������� ");
        msg = msg.replace("����� ", "makfa ");
        msg = msg.replace("������� ", "������� ");
        msg = msg.replace("\"", " ");
        msg = msg.replace("0 ��", "0�");
        msg = msg.replace(" c ", " � ");
        msg = msg.replace(" ��� ", " ");




        String[] mass = {"(�)", ".", "+", ",", "/","'", "\'", "\"", "�", "�", "*", "\\", "|", "(", ")",
                ":", "��� ��������� � ������� ", "��� ������ ", "��� ������ ", "��� ������������� "
                , "��� ����� ", "��� ������ ����� ", "��� ���������� ����� ", "��� ���������� � ������ ����� "
                ,"��� ���� ����� ����� ","������������ ", "��� ������ ����� ", "��� ���������� ����� "
                , "��� ����� ����� ", "� �������������", " � ��������", " � 6 �������"
                , "��� ���������� � ������������ �����", "��� ������������ �����",
                " ������������ ����� ", "��� ����� ������������ ", "��� �����/������������ ����� "
                ,"��� ����� ", "/������������ ", "����� ", "����� ", "����� ", "��� ����� ������������ "
                , "�/������������ ", "������� ", "��� �������� ������� ",
                "��������������� ", "����������� ", "����������e ", "���������", "duo ", "single "
                , "������������ ", "���88508", "���88509", "���81408", "��� ��������� "
        , "��� �����.����� ", " ���.", "��� ����� �����", "��� ��������� �������", " � ������������", " � ���"};
        for (int i = 0; i < mass.length; i++) {
            if (msg.contains(mass[i])) {
                msg = msg.replace(mass[i], "");
            }
        }
        msg = msg.replace("  ", " ");
        msg = msg.replace("   ", " ");
        msg = msg.replace("    ", " ");
        msg = msg.replace("     ", " ");
        msg = msg.replace("0 ��", "0��");
        msg = msg.replace(" ��", "��");
        msg = msg.replace(" ��", "��");
        msg = msg.replace(" ��", "��");
        msg = msg.replace("�/", "��� ");
        msg = msg.replace("������� ������", "������");
        msg = msg.replace("������", "BELITA");
        msg = msg.replace("������ ", "������������� ");
        msg = msg.replace(" � ", " ");
        msg = msg.replace("sos-", "sos ");
        msg = msg.replace("�������������", "�����������");
        msg = msg.replace("garnier fructis", "fructis");
        msg = msg.replace("���� ������� ", "���� ����������� ������� ");
        msg = msg.replace(" prodom ", " prodomo ");
        msg = msg.replace("�������-����������", "�������");
        msg = msg.replace("����������-�������", "�������");
        msg = msg.replace("������� ������������� ", "������� ");


        msg = msg.trim().toUpperCase();

        return msg;
    }

}
