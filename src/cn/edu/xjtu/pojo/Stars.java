package cn.edu.xjtu.pojo;

/**
 * Stars entity. @author MyEclipse Persistence Tools
 */

public class Stars implements java.io.Serializable {

	// Fields

	private Integer starId;
	private Detailtravelnotes detailtravelnotes;
	private Newscenicspots newscenicspots;
	private Travelnotes travelnotes;
	private User user;
	private Integer topicType;

	// Constructors

	/** default constructor */
	public Stars() {
	}

	/** full constructor */
	public Stars(Detailtravelnotes detailtravelnotes,
			Newscenicspots newscenicspots, Travelnotes travelnotes, User user,
			Integer topicType) {
		this.detailtravelnotes = detailtravelnotes;
		this.newscenicspots = newscenicspots;
		this.travelnotes = travelnotes;
		this.user = user;
		this.topicType = topicType;
	}

	// Property accessors

	public Integer getStarId() {
		return this.starId;
	}

	public void setStarId(Integer starId) {
		this.starId = starId;
	}

	public Detailtravelnotes getDetailtravelnotes() {
		return this.detailtravelnotes;
	}

	public void setDetailtravelnotes(Detailtravelnotes detailtravelnotes) {
		this.detailtravelnotes = detailtravelnotes;
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

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Integer getTopicType() {
		return this.topicType;
	}

	public void setTopicType(Integer topicType) {
		this.topicType = topicType;
	}

	@Override
	public String toString() {
		return "{\"starId\":\"" + starId + "\",\"detailtravelnotesId\":\""
				+ detailtravelnotes.getDetailTravelNotesId()
				+ "\",\"newscenicspotsId\":\"" + newscenicspots.getScenicid()
				+ "\",\"travelnotes\":\"" + travelnotes.getTravelNotesid()
				+ "\",\"useriD\":\"" + user.getId() + "\",\"topicType\":\""
				+ topicType + "\"}";
		//
	}
}