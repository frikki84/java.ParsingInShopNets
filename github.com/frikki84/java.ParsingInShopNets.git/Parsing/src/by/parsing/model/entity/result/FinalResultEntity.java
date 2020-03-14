package by.parsing.model.entity.result;

import java.util.HashMap;
import java.util.TreeMap;

public class FinalResultEntity implements Comparable<FinalResultEntity>{
	private int id;
	private String name;
	private HashMap<String, Double> priceHash;
	private HashMap<String, String> imageHash;
	private HashMap<String, String> linkHash;

	public FinalResultEntity() {
		priceHash = new HashMap<>();
		imageHash = new HashMap<>();
		linkHash = new HashMap<>();
	}
	
	

	public FinalResultEntity(String name, HashMap<String, Double> priceHash, HashMap<String, String> imageHash,
			HashMap<String, String> linkHash) {
		this.name = name;
		this.priceHash = priceHash;
		this.imageHash = imageHash;
		this.linkHash = linkHash;
	}



	public FinalResultEntity(int id, String name, HashMap<String, Double> priceHash, HashMap<String, String> imageHash,
			HashMap<String, String> linkHash) {
		this.id = id;
		this.name = name;
		this.priceHash = priceHash;
		this.imageHash = imageHash;
		this.linkHash = linkHash;
	}

	public FinalResultEntity(String name) {
		this.name = name;
		priceHash = new HashMap<>();
		imageHash = new HashMap<>();
		linkHash = new HashMap<>();
	}

	public FinalResultEntity(FinalResultEntity f) {
		this.name = f.name;
		this.priceHash = f.priceHash;
		this.imageHash = f.imageHash;
		this.linkHash = f.linkHash;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public HashMap<String, Double> getPriceHash() {
		return priceHash;
	}

	public void setPriceHash(HashMap<String, Double> priceHash) {
		this.priceHash = priceHash;
	}

	public HashMap<String, String> getImageHash() {
		return imageHash;
	}

	public void setImageHash(HashMap<String, String> imageHash) {
		this.imageHash = imageHash;
	}

	public HashMap<String, String> getLinkHash() {
		return linkHash;
	}

	public void setLinkHash(HashMap<String, String> linkHash) {
		this.linkHash = linkHash;
	}

	@Override
	public String toString() {
		return "FinalResultEntity name=" + name + ", priceHash=" + priceHash + "]\n";
	}

	@Override
	public int compareTo(FinalResultEntity o) {
		int i = this.getName().compareTo(o.getName());
		return i;
		
	}

}
