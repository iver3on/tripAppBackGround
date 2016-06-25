package cn.edu.xjtu.pojo;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import cn.edu.xjtu.util.JSONUtil;

/**
 * Detailtravelnotes entity. @author MyEclipse Persistence Tools
 */

public class Detailtravelnotes implements java.io.Serializable {

	// Fields

	private Integer detailTravelNotesId;
	private User user;
	private Timestamp createTime;
	private String content;
	private Double longitude;
	private Double latitude;
	private String location;
	private Integer starCount;
	private Integer commentCount;
	private Set starses = new HashSet(0);
	private Set travelnotespictures = new HashSet(0);
	private Set commentses = new HashSet(0);
	private Integer rightType;
	private Integer scanCount;

	// Constructors

	/** default constructor */
	public Detailtravelnotes() {
	}

	public Detailtravelnotes(Integer detailTravelNotesId, User user,
			Timestamp createTime, String content, Double longitude,
			Double latitude, String location, Integer starCount,
			Integer commentCount, Set starses, Set travelnotespictures,
			Set commentses, Integer rightType, Integer scanCount) {
		super();
		this.detailTravelNotesId = detailTravelNotesId;
		this.user = user;
		this.createTime = createTime;
		this.content = content;
		this.longitude = longitude;
		this.latitude = latitude;
		this.location = location;
		this.starCount = starCount;
		this.commentCount = commentCount;
		this.starses = starses;
		this.travelnotespictures = travelnotespictures;
		this.commentses = commentses;
		this.rightType = rightType;
		this.scanCount = scanCount;
	}

	// Property accessors

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

	public Integer getDetailTravelNotesId() {
		return this.detailTravelNotesId;
	}

	public void setDetailTravelNotesId(Integer detailTravelNotesId) {
		this.detailTravelNotesId = detailTravelNotesId;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
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

	public String getLocation() {
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Integer getStarCount() {
		return this.starCount;
	}

	public void setStarCount(Integer starCount) {
		this.starCount = starCount;
	}

	public Integer getCommentCount() {
		return this.commentCount;
	}

	public void setCommentCount(Integer commentCount) {
		this.commentCount = commentCount;
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

	public Set getCommentses() {
		return this.commentses;
	}

	public void setCommentses(Set commentses) {
		this.commentses = commentses;
	}

	@Override
	public String toString() {
		return "{\"detailTravelNotesId\":\"" + detailTravelNotesId
				+ "\",\"userId\":\"" + user.getId() + "\",\"discription\":\""
				+ content + "\",\"location\":\"" + location
				+ "\",\"datetime\":\"" + createTime + "\",\"longitude\":\""
				+ longitude + "\",\"latitude\":\"" + latitude
				+ "\",\"starCount\":\"" + starCount + "\",\"scanCount\":\""
				+ scanCount + "\",\"rightType\":\"" + rightType
				+ "\",\"commentCount\":\"" + commentCount + "\""
				+ ",\"travlenotespictures\":"
				+ JSONUtil.toPicJSON(travelnotespictures) + ",\"stars\":"
				+ JSONUtil.toStarJSON(starses) + "," + "\"commentses\":"
				+ JSONUtil.toCommentJSON(commentses) + "}";
	}

}