package cn.edu.xjtu.pojo;

import java.sql.Timestamp;

/**
 * Comments entity. @author MyEclipse Persistence Tools
 */

public class Comments implements java.io.Serializable {

	// Fields

	private Integer commentId;
	private Detailtravelnotes detailtravelnotes;
	private User userByToUid;
	private User userByFromUid;
	private Newscenicspots newscenicspots;
	private Travelnotes travelnotes;
	private Integer topicType;
	private String content;
	private int starCount;
	private int commentCount;
	private Timestamp datetime;

	// Constructors

	/** default constructor */
	public Comments() {
	}

	/** full constructor */
	public Comments(Detailtravelnotes detailtravelnotes, User userByToUid,
			User userByFromUid, Newscenicspots newscenicspots,
			Travelnotes travelnotes, Integer topicType, String content,
			Timestamp datetime) {
		this.detailtravelnotes = detailtravelnotes;
		this.userByToUid = userByToUid;
		this.userByFromUid = userByFromUid;
		this.newscenicspots = newscenicspots;
		this.travelnotes = travelnotes;
		this.topicType = topicType;
		this.content = content;
		this.datetime = datetime;
	}

	// Property accessors

	public Integer getCommentId() {
		return this.commentId;
	}

	public int getStarCount() {
		return starCount;
	}

	public void setStarCount(int starCount) {
		this.starCount = starCount;
	}

	public int getCommentCount() {
		return commentCount;
	}

	public void setCommentCount(int commentCount) {
		this.commentCount = commentCount;
	}

	public Timestamp getDatetime() {
		return datetime;
	}

	public void setDatetime(Timestamp datetime) {
		this.datetime = datetime;
	}

	public void setCommentId(Integer commentId) {
		this.commentId = commentId;
	}

	public Detailtravelnotes getDetailtravelnotes() {
		return this.detailtravelnotes;
	}

	public void setDetailtravelnotes(Detailtravelnotes detailtravelnotes) {
		this.detailtravelnotes = detailtravelnotes;
	}

	public User getUserByToUid() {
		return this.userByToUid;
	}

	public void setUserByToUid(User userByToUid) {
		this.userByToUid = userByToUid;
	}

	public User getUserByFromUid() {
		return this.userByFromUid;
	}

	public void setUserByFromUid(User userByFromUid) {
		this.userByFromUid = userByFromUid;
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

	public Integer getTopicType() {
		return this.topicType;
	}

	public void setTopicType(Integer topicType) {
		this.topicType = topicType;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		if (userByToUid != null) {
			return "{\"commentId\":\"" + commentId + "\",\"content\":\""
					+ content + "\",\"fromUserId\":\"" + userByFromUid.getId()
					+ "\",\"toUserId\":\"" + userByToUid.getId()
					+ "\",\"datetime\":\"" + datetime + "\"}";
		} else
			return "{\"commentId\":\"" + commentId + "\",\"content\":\""
					+ content + "\",\"fromUserId\":\"" + userByFromUid.getId()
					+ "\",\"datetime\":\"" + datetime + "\"}";

	}
}