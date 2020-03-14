package by.parsing.model.entity.result;

public class ParsingShopResult {
	private String name;
	private Double price;
	private String image;
	private String link;
	private String shop;

	public ParsingShopResult() {

	}

	public ParsingShopResult(String name, Double price, String image, String link, String shop) {
		this.name = name;
		this.price = price;
		this.image = image;
		this.link = link;
		this.shop = shop;
	}

	public ParsingShopResult(String name, Double price, String shop) {
		this.name = name;
		this.price = price;
		this.shop = shop;
	}

	public ParsingShopResult(String name, Double price, String link, String shop) {
		this.name = name;
		this.price = price;
		this.link = link;
		this.shop = shop;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getShop() {
		return shop;
	}

	public void setShop(String shop) {
		this.shop = shop;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((image == null) ? 0 : image.hashCode());
		result = prime * result + ((link == null) ? 0 : link.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + ((shop == null) ? 0 : shop.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ParsingShopResult other = (ParsingShopResult) obj;
		if (image == null) {
			if (other.image != null)
				return false;
		} else if (!image.equals(other.image))
			return false;
		if (link == null) {
			if (other.link != null)
				return false;
		} else if (!link.equals(other.link))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (shop == null) {
			if (other.shop != null)
				return false;
		} else if (!shop.equals(other.shop))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ParsingShopResult [name=" + name + ", price=" + price + ", image=" + image + ", link=" + link
				+ ", shop=" + shop + "]";
	}
	
	

}
