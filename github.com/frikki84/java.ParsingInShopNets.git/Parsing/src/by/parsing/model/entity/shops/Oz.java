package by.parsing.model.entity.shops;

import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import by.parsing.model.entity.request.Request;
import by.parsing.model.entity.result.ParsingShopResult;
import by.parsing.model.logic.stringCorrect.StringCorrect;

public class Oz extends ShopNet{
    public static final String OZ_NAME = "Oz.by";

    public static final String OZ_URL = "https://oz.by";

    public static final String OZ_START = "https://oz.by/search/?q=";
    public static final String OZ_FINISH = "";

    public static final String OZ_COMMON = "viewer-type-card__li ";

    public static final String OZ_NO_PRODUCTS = "Оставить";

    public Oz() {
        this.setShopName(OZ_NAME);
        this.setMainUrl(OZ_URL);
        this.setUrlStart(OZ_START);
        this.setUrlFinish(OZ_FINISH);
        this.setItemCommon(OZ_COMMON);
    }


    @Override
    public ArrayList<ParsingShopResult> searchProduct(Request request) {
		ArrayList<ParsingShopResult> container = new ArrayList<ParsingShopResult>();

        String urlRequest = getUrlStart() + request.getRequest() + getUrlFinish();
        try {
            Document document = Jsoup.connect(urlRequest).get();

            Elements elements = document.select("li[class = " + getItemCommon() + "]");

            String name;
			Double price;
			String image;
			String link;

            for (Element element : elements) {
                String itemUrl = getMainUrl() + element.select("div[class = item-type-card__inner] > a").attr("href");
                Document itemDocument = Jsoup.connect(itemUrl).get();

                String itemName = itemDocument.select("div[class = b-product-title__heading]").text();
                String itemProducer = itemDocument.select("div[class = b-product-title__author] > a").text();


                String priceRub = itemDocument.select("div[class = b-product-control__row]").text();
              
                if (priceRub.contains(OZ_NO_PRODUCTS)) {
                    continue;

                } else {
                    
                    String midPrice = StringCorrect.priceRubCorrection(priceRub);
                    price = new Double(midPrice);
                    

                    name = itemName + " " + itemProducer;
                    
                    name = StringCorrect.stringCorrectForParsing(name);

                    image = itemDocument.select("div[class = b-product-photo__picture-self] " +
                            "> figure > a").attr("href");

                    link = itemUrl;


                    ParsingShopResult result = new ParsingShopResult(name, price, image, link, OZ_NAME);

					container.add(result);
            }
        }


        } catch (Exception e) {
            e.printStackTrace();
        }
        return container;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}