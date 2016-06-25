package cn.edu.xjtu.pojo;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import cn.edu.xjtu.util.JSONUtil;

/**
 * Newscenicspots entity. @author MyEclipse Persistence Tools
 */

public class Newscenicspots implements java.io.Serializable {

	// Fields

	private Integer scenicid;
	private User user;
	private String scenicname;
	private String summary;
	private Double longitude;
	private Double latitude;
	private Timestamp datetime;
	private String picture;
	private String location;
	private Integer starCount;
	private Integer commentCount;
	private Set starses = new HashSet(0);
	private Set commentses = new HashSet(0);
	private Set travelnotespictures = new HashSet(0);
	private Integer scanCount;

	// Constructors

	/** default constructor */
	public Newscenicspots() {
	}

	public Newscenicspots(Integer scenicid, User user, String scenicname,
			String summary, Double longitude, Double latitude,
			Timestamp datetime, String picture, String location,
			Integer starCount, Integer commentCount, Set starses,
			Set commentses, Set travelnotespictures, Integer scanCount) {
		super();
		this.scenicid = scenicid;
		this.user = user;
		this.scenicname = scenicname;
		this.summary = summary;
		this.longitude = longitude;
		this.latitude = latitude;
		this.datetime = datetime;
		this.picture = picture;
		this.location = location;
		this.starCount = starCount;
		this.commentCount = commentCount;
		this.starses = starses;
		this.commentses = commentses;
		this.travelnotespictures = travelnotespictures;
		this.scanCount = scanCount;
	}

	// Property accessors

	public Integer getScenicid() {
		return this.scenicid;
	}

	public void setScenicid(Integer scenicid) {
		this.scenicid = scenicid;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getScenicname() {
		return this.scenicname;
	}

	public void setScenicname(String scenicname) {
		this.scenicname = scenicname;
	}

	public String getSummary() {
		return this.summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
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

	public String getPicture() {
		return this.picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getLocation() {
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Set getStarses() {
		return this.starses;
	}

	public void setStarses(Set starses) {
		this.starses = starses;
	}

	public Set getCommentses() {
		return this.commentses;
	}

	public void setCommentses(Set commentses) {
		this.commentses = commentses;
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

	public Timestamp getDatetime() {
		return datetime;
	}

	public void setDatetime(Timestamp datetime) {
		this.datetime = datetime;
	}

	public Set getTravelnotespictures() {
		return travelnotespictures;
	}

	public void setTravelnotespictures(Set travelnotespictures) {
		this.travelnotespictures = travelnotespictures;
	}

	public Integer getScanCount() {
		return scanCount;
	}

	public void setScanCount(Integer scanCount) {
		this.scanCount = scanCount;
	}

	@Override
	public String toString() {
		return "{\"scenicid\":\"" + scenicid + "\",\"userName\":\""
				+ user.getName() + "\",\"userid\":\"" + user.getId()
				+ "\",\"scenicname\":\"" + scenicname + "\",\"summary\":\""
				+ summary + "\",\"datetime\":\"" + datetime
				+ "\",\"longitude\":\"" + longitude + "\",\"latitude\":\""
				+ latitude + "\",\"picture\":\"" + picture
				+ "\",\"location\":\"" + location + "\",\"starCount\":\""
				+ starCount + "\",\"commentCount\":\"" + commentCount
				+ "\",\"scanCount\":\"" + scanCount + "\",\"starses\":"
				+ JSONUtil.toStarJSON(starses) + ",\"travlenotespictures\":"
				+ JSONUtil.toPicJSON(travelnotespictures) + ",\"commentses\":"
				+ JSONUtil.toCommentJSON(commentses) + "}";
		// ["{\"commentId\":\"5\",\"content\":\"nice啊\",\"fromUserId\":\"1203\",\"datetime\
		// ":\"null\"}"]
	}
}