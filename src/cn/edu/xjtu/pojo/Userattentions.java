package cn.edu.xjtu.pojo;

import java.sql.Timestamp;

/**
 * Userattentions entity. @author MyEclipse Persistence Tools
 */

public class Userattentions implements java.io.Serializable {

	// Fields

	private Integer userattentionId;
	private User userByAttentionUserid;
	private User userByUserId;
	private Timestamp createDate;
	private Timestamp updateDate;

	// Constructors

	/** default constructor */
	public Userattentions() {
	}

	/** full constructor */
	public Userattentions(User userByAttentionUserid, User userByUserId,
			Timestamp createDate, Timestamp updateDate) {
		this.userByAttentionUserid = userByAttentionUserid;
		this.userByUserId = userByUserId;
		this.createDate = createDate;
		this.updateDate = updateDate;
	}

	// Property accessors

	public Integer getUserattentionId() {
		return this.userattentionId;
	}

	public void setUserattentionId(Integer userattentionId) {
		this.userattentionId = userattentionId;
	}

	public User getUserByAttentionUserid() {
		return this.userByAttentionUserid;
	}

	public void setUserByAttentionUserid(User userByAttentionUserid) {
		this.userByAttentionUserid = userByAttentionUserid;
	}

	public User getUserByUserId() {
		return this.userByUserId;
	}

	public void setUserByUserId(User userByUserId) {
		this.userByUserId = userByUserId;
	}

	public Timestamp getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	public Timestamp getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Timestamp updateDate) {
		this.updateDate = updateDate;
	}

	@Override
	public String toString() {
		return "{\"userattentionId\":\"" + userattentionId
				+ "\",\"userByAttentionUserid\":\"" + userByAttentionUserid
				+ "\",\"userByUserId\":\"" + userByUserId
				+ "\",\"createDate\":\"" + createDate + "\",\"updateDate\":\""
				+ updateDate + "\"}";
	}
}