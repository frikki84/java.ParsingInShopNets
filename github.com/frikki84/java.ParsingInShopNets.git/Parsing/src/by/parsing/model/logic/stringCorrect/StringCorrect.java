package by.parsing.model.logic.stringCorrect;


public class StringCorrect {
    public  static final int INDEX_IN_BUSLIK_DELETE_OT_FROM_PRICE = 3;

    public static String priceRubCorrection(String price) {
        String value = "р";
        if (price.contains(value)) {
            int index = price.indexOf(value);
            price = price.substring(0, index).trim();
        }
        price = price.replace(",", ".");
        return price;
    }

    public static String priceCorrectionFrom_OT(String price) {
        String value = "от "; // "от 25 руб"
        if (price.contains(value)) {
            price = price.substring(INDEX_IN_BUSLIK_DELETE_OT_FROM_PRICE).trim();
        }
        return price;
    }

    public static String priceCorrectionWildberries(String price) {
        String value = " р. "; // "от 25 руб"
        if (price.contains(value)) {
            price = price.replace(" р. ", ".");
            price = price.replace(" к.", "");
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

    public static String stringCorrectForParsing(String msg) {
        msg = msg.toLowerCase();
        msg = msg.replace(" голд ", " gold ");
        msg = msg.replace("посудом.", "посудомоечных ");
        msg = msg.replace("ополаск. ", "ополаскиватель ");
        msg = msg.replace("окраш. ", "окрашенных ");
        msg = msg.replace("дл€ мыть€ посуды в посудомоечных машинах", "дл€ посудомоечных машин");
        msg = msg.replace("макаронные издели€ ", "макароны ");
        msg = msg.replace("макфа ", "makfa ");
        msg = msg.replace("спираль ", "спирали ");
        msg = msg.replace("\"", " ");
        msg = msg.replace("0 гр", "0г");
        msg = msg.replace(" c ", " с ");
        msg = msg.replace(" фас ", " ");





        String[] mass = {"(м)", ".", "+", ",", "/","'", "\'", "\"", "Ђ", "ї", "*", "\\", "|", "(", ")",
                ":", "дл€ мальчиков и девочек ", "дл€ мужчин ", "дл€ женщин ", "дл€ новорожденных "
                , "дл€ детей ", "дл€ тонких волос ", "дл€ нормальных волос ", "дл€ нормальных и жирных волос "
                ,"дл€ всех типов волос ","многослойные ", "дл€ жирных волос ", "дл€ окрашенных волос "
                , "дл€ сухих волос ", "с ухажпротеином", " с рождени€", " с 6 мес€цев"
                , "дл€ окрашенных и поврежденных волос", "дл€ поврежденных волос",
                " поврежденных волос ", "дл€ сухих повреждволос ", "дл€ сухих/поврежденных волос "
                ,"дл€ сухих ", "/повреждволос ", "новый ", "нова€ ", "новое ", "дл€ сухих повреждволос "
                , "д/повреждволос ", "детские ", "дл€ детского питани€ ",
                "восстановленный ", "осветленный ", "осветленныe ", "полнорацс", "duo ", "single "
                , "ультратонкие ", "арт88508", "арт88509", "арт81408", "дл€ секущихс€ "
        , "дл€ окраш.волос ", " фас.", "дл€ мальч девоч", "дл€ мальчиков девочек", " в ассортименте", " в асс"};
        for (int i = 0; i < mass.length; i++) {
            if (msg.contains(mass[i])) {
                msg = msg.replace(mass[i], "");
            }
        }
        msg = msg.replace("  ", " ");
        msg = msg.replace("   ", " ");
        msg = msg.replace("    ", " ");
        msg = msg.replace("     ", " ");
        msg = msg.replace("0 мл", "0мл");
        msg = msg.replace(" мл", "мл");
        msg = msg.replace(" кг", "кг");
        msg = msg.replace(" шт", "шт");
        msg = msg.replace("д/", "дл€ ");
        msg = msg.replace("мужской бритвы", "брить€");
        msg = msg.replace("белита", "BELITA");
        msg = msg.replace("гигиен ", "гигиенические ");
        msg = msg.replace(" и ", " ");
        msg = msg.replace("sos-", "sos ");
        msg = msg.replace("экстрапитание", "питательна€");
        msg = msg.replace("garnier fructis", "fructis");
        msg = msg.replace("кофе молотый ", "кофе натуральный молотый ");
        msg = msg.replace(" prodom ", " prodomo ");
        msg = msg.replace("трусики-подгузники", "трусики");
        msg = msg.replace("подгузники-трусики", "трусики");
        msg = msg.replace("семечки подсолнечника ", "семечки ");
        msg = msg.replace("мыло хоз€йственное классическое 72% твердое", "мыло хоз€йственное классическое 72%");
        msg = msg.replace("зубна€ паста colgate optic white мгновенный", "зубна€ паста colgate optic white");
        msg = msg.replaceAll("юниор", "junior");
        msg = msg.trim().toUpperCase();

        return msg;
    }

}
