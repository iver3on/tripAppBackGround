package cn.edu.xjtu.pojo;

/**
 * Travelnotespicture entity. @author MyEclipse Persistence Tools
 */

public class Travelnotespicture implements java.io.Serializable,
		Comparable<Travelnotespicture> {

	// Fields

	private Integer pictureid;
	private Newscenicspots newscenicspots;
	private Travelnotes travelnotes;
	private Detailtravelnotes detailtravelnotes;
	private Double longitude;
	private Double latitude;
	private String url;
	private String summary;
	private Integer type;
	private Integer position;

	// Constructors

	/** default constructor */
	public Travelnotespicture() {
	}

	public Travelnotespicture(Integer pictureid, Newscenicspots newscenicspots,
			Travelnotes travelnotes, Detailtravelnotes detailtravelnotes,
			Double longitude, Double latitude, String url, String summary,
			Integer type, Integer position) {
		super();
		this.pictureid = pictureid;
		this.newscenicspots = newscenicspots;
		this.travelnotes = travelnotes;
		this.detailtravelnotes = detailtravelnotes;
		this.longitude = longitude;
		this.latitude = latitude;
		this.url = url;
		this.summary = summary;
		this.type = type;
		this.position = position;
	}

	public Integer getPictureid() {
		return this.pictureid;
	}

	public void setPictureid(Integer pictureid) {
		this.pictureid = pictureid;
	}

	public Newscenicspots getNewscenicspots() {
		return this.newscenicspots;
	}

	public void setNewscenicspots(Newscenicspots newscenicspots) {
		this.newscenicspots = newscenicspots;
	}

	public Travelnotes getTravelnotes() {
		return this.travelnotes;
	}

	public void setTravelnotes(Travelnotes travelnotes) {
		this.travelnotes = travelnotes;
	}

	public Detailtravelnotes getDetailtravelnotes() {
		return this.detailtravelnotes;
	}

	public void setDetailtravelnotes(Detailtravelnotes detailtravelnotes) {
		this.detailtravelnotes = detailtravelnotes;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getSummary() {
		return this.summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public Integer getType() {
		return this.type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getPosition() {
		return position;
	}

	public void setPosition(Integer position) {
		this.position = position;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	// type 专属 复杂游记的 附件类型的区别。
	@Override
	public String toString() {
		return "{\"pictureid\":\"" + pictureid + "\",\"url\":\"" + url
				+ "\",\"summary\":\"" + summary + "\",\"longitude\":\""
				+ longitude + "\",\"latitude\":\"" + latitude
				+ "\",\"type\":\"" + type + "\",\"position\":\"" + position
				+ "\"}";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(Travelnotespicture other) {
		if (position < other.position) // 这里比较的是什么 sort方法实现的就是按照此比较的东西从小到大排列
			return -1;
		if (position > other.position)
			return 1;
		return 0;
	}

}