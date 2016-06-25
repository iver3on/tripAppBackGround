package cn.edu.xjtu.pojo;

/**
 * Friendrelation entity. @author MyEclipse Persistence Tools
 */

public class Friendrelation implements java.io.Serializable {

	// Fields

	private Integer userfriendId;
	private Integer userid;
	private Integer friendid;

	// Constructors

	/** default constructor */
	public Friendrelation() {
	}

	/** full constructor */
	public Friendrelation(Integer userid, Integer friendid) {
		this.userid = userid;
		this.friendid = friendid;
	}

	// Property accessors

	public Integer getUserfriendId() {
		return this.userfriendId;
	}

	public void setUserfriendId(Integer userfriendId) {
		this.userfriendId = userfriendId;
	}

	public Integer getUserid() {
		return this.userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public Integer getFriendid() {
		return this.friendid;
	}

	public void setFriendid(Integer friendid) {
		this.friendid = friendid;
	}

}