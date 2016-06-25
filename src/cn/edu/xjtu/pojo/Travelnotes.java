package cn.edu.xjtu.pojo;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import cn.edu.xjtu.util.JSONUtil;

/**
 * Travelnotes entity. @author MyEclipse Persistence Tools
 */

public class Travelnotes implements java.io.Serializable {

	// Fields

	private Integer travelNotesid;
	private User user;
	private String discription;
	private String location;
	private Timestamp datetime;
	private Double longitude;
	private Double latitude;
	private Set commentses = new HashSet(0);
	private Set starses = new HashSet(0);
	private Set travelnotespictures = new HashSet(0);
	private Integer starCount;
	private Integer commentCount;
	private Integer rightType;
	private Integer scanCount;

	// Constructors

	/** default constructor */
	public Travelnotes() {
	}

	/** minimal constructor */
	public Travelnotes(User user) {
		this.user = user;
	}

	/** full constructor */
	public Travelnotes(User user, String discription, String location,
			Timestamp datetime, Double longitude, Double latitude,
			Integer rightType, Set commentses, Set starses,
			Set travelnotespictures, Integer starCount, Integer commentCount,
			Integer scanCount) {
		this.user = user;
		this.discription = discription;
		this.location = location;
		this.datetime = datetime;
		this.longitude = longitude;
		this.latitude = latitude;
		this.commentses = commentses;
		this.rightType = rightType;
		this.starses = starses;
		this.travelnotespictures = travelnotespictures;
		this.starCount = starCount;
		this.commentCount = commentCount;
		this.scanCount = scanCount;
	}

	// Property accessors

	public Integer getTravelNotesid() {
		return this.travelNotesid;
	}

	public Integer getRightType() {
		return rightType;
	}

	public void setRightType(Integer rightType) {
		this.rightType = rightType;
	}

	public Integer getScanCount() {
		return scanCount;
	}

	public void setScanCount(Integer scanCount) {
		this.scanCount = scanCount;
	}

	public void setTravelNotesid(Integer travelNotesid) {
		this.travelNotesid = travelNotesid;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getDiscription() {
		return this.discription;
	}

	public void setDiscription(String discription) {
		this.discription = discription;
	}

	public String getLocation() {
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Timestamp getDatetime() {
		return this.datetime;
	}

	public void setDatetime(Timestamp datetime) {
		this.datetime = datetime;
	}

	public Double getLongitude() {
		return this.longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public Double getLatitude() {
		return this.latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Set getCommentses() {
		return this.commentses;
	}

	public void setCommentses(Set commentses) {
		this.commentses = commentses;
	}

	public Set getStarses() {
		return this.starses;
	}

	public void setStarses(Set starses) {
		this.starses = starses;
	}

	public Set getTravelnotespictures() {
		return this.travelnotespictures;
	}

	public void setTravelnotespictures(Set travelnotespictures) {
		this.travelnotespictures = travelnotespictures;
	}

	public Integer getStarCount() {
		return starCount;
	}

	public void setStarCount(Integer starCount) {
		this.starCount = starCount;
	}

	public Integer getCommentCount() {
		return commentCount;
	}

	public void setCommentCount(Integer commentCount) {
		this.commentCount = commentCount;
	}

	@Override
	public String toString() {
		return "{\"travelNotesid\":\"" + travelNotesid + "\",\"userId\":\""
				+ user.getId() + "\",\"discription\":\"" + discription
				+ "\",\"location\":\"" + location + "\",\"datetime\":\""
				+ datetime + "\",\"longitude\":\"" + longitude
				+ "\",\"latitude\":\"" + latitude + "\",\"starCount\":\""
				+ starCount + "\",\"scanCount\":\"" + scanCount
				+ "\",\"rightType\":\"" + rightType + "\",\"commentCount\":\""
				+ commentCount + "\"" + ",\"travlenotespictures\":"
				+ JSONUtil.toPicJSON(travelnotespictures) + ",\"stars\":"
				+ JSONUtil.toStarJSON(starses) + "," + "\"commentses\":"
				+ JSONUtil.toCommentJSON(commentses) + "}";
	}
}