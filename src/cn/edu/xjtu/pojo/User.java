package cn.edu.xjtu.pojo;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;


/**
 * User entity. @author MyEclipse Persistence Tools
 */

public class User  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String name;
     private String password;
     private Integer focusCount;
     private Integer isFocusCount;
     private Integer friendsCount;
     private String profilePhoto;
     private String nickname;
     private String email;
     private String region;
     private String gender;
     private String pushtoken;
     private Date birthday;
     private String signature;
     private Set starses = new HashSet(0);
     private Set commentsesForToUid = new HashSet(0);
     private Set userattentionsesForAttentionUserid = new HashSet(0);
     private Set newscenicspotses = new HashSet(0);
     private Set commentsesForFromUid = new HashSet(0);
     private Set userattentionsesForUserId = new HashSet(0);
     private Set detailtravelnoteses = new HashSet(0);
     private Set travelnoteses = new HashSet(0);


    // Constructors

    /** default constructor */
    public User() {
    }

  

   
    public User(Integer id, String name, String password, Integer focusCount,
			Integer isFocusCount, Integer friendsCount, String profilePhoto,
			String nickname, String email, String region, String gender,
			String pushtoken, Date birthday, String signature, Set starses,
			Set commentsesForToUid, Set userattentionsesForAttentionUserid,
			Set newscenicspotses, Set commentsesForFromUid,
			Set userattentionsesForUserId, Set detailtravelnoteses,
			Set travelnoteses) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.focusCount = focusCount;
		this.isFocusCount = isFocusCount;
		this.friendsCount = friendsCount;
		this.profilePhoto = profilePhoto;
		this.nickname = nickname;
		this.email = email;
		this.region = region;
		this.gender = gender;
		this.pushtoken = pushtoken;
		this.birthday = birthday;
		this.signature = signature;
		this.starses = starses;
		this.commentsesForToUid = commentsesForToUid;
		this.userattentionsesForAttentionUserid = userattentionsesForAttentionUserid;
		this.newscenicspotses = newscenicspotses;
		this.commentsesForFromUid = commentsesForFromUid;
		this.userattentionsesForUserId = userattentionsesForUserId;
		this.detailtravelnoteses = detailtravelnoteses;
		this.travelnoteses = travelnoteses;
	}




	// Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getFocusCount() {
        return this.focusCount;
    }
    
    public void setFocusCount(Integer focusCount) {
        this.focusCount = focusCount;
    }

    public Integer getIsFocusCount() {
        return this.isFocusCount;
    }
    
    public void setIsFocusCount(Integer isFocusCount) {
        this.isFocusCount = isFocusCount;
    }

    public Integer getFriendsCount() {
        return this.friendsCount;
    }
    
    public void setFriendsCount(Integer friendsCount) {
        this.friendsCount = friendsCount;
    }

    public String getProfilePhoto() {
        return this.profilePhoto;
    }
    
    public void setProfilePhoto(String profilePhoto) {
        this.profilePhoto = profilePhoto;
    }

    public String getNickname() {
        return this.nickname;
    }
    
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }

    public String getRegion() {
        return this.region;
    }
    
    public void setRegion(String region) {
        this.region = region;
    }

    public String getGender() {
        return this.gender;
    }
    
    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return this.birthday;
    }
    
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getSignature() {
        return this.signature;
    }
    
    public void setSignature(String signature) {
        this.signature = signature;
    }

    public Set getStarses() {
        return this.starses;
    }
    
    public void setStarses(Set starses) {
        this.starses = starses;
    }

    public Set getCommentsesForToUid() {
        return this.commentsesForToUid;
    }
    
    public void setCommentsesForToUid(Set commentsesForToUid) {
        this.commentsesForToUid = commentsesForToUid;
    }

    public Set getUserattentionsesForAttentionUserid() {
        return this.userattentionsesForAttentionUserid;
    }
    
    public void setUserattentionsesForAttentionUserid(Set userattentionsesForAttentionUserid) {
        this.userattentionsesForAttentionUserid = userattentionsesForAttentionUserid;
    }

    public Set getNewscenicspotses() {
        return this.newscenicspotses;
    }
    
    public void setNewscenicspotses(Set newscenicspotses) {
        this.newscenicspotses = newscenicspotses;
    }

    public Set getCommentsesForFromUid() {
        return this.commentsesForFromUid;
    }
    
    public void setCommentsesForFromUid(Set commentsesForFromUid) {
        this.commentsesForFromUid = commentsesForFromUid;
    }

    public Set getUserattentionsesForUserId() {
        return this.userattentionsesForUserId;
    }
    
    public void setUserattentionsesForUserId(Set userattentionsesForUserId) {
        this.userattentionsesForUserId = userattentionsesForUserId;
    }

    public Set getDetailtravelnoteses() {
        return this.detailtravelnoteses;
    }
    
    public void setDetailtravelnoteses(Set detailtravelnoteses) {
        this.detailtravelnoteses = detailtravelnoteses;
    }

    public Set getTravelnoteses() {
        return this.travelnoteses;
    }
    
    public void setTravelnoteses(Set travelnoteses) {
        this.travelnoteses = travelnoteses;
    }

    
	public String getPushtoken() {
		return pushtoken;
	}

	public void setPushtoken(String pushtoken) {
		this.pushtoken = pushtoken;
	}




	public String toJSON() {
		return "{\"id\":\"" + id + "\",\"name\":\"" + name
				+ "\",\"password\":\"" + password + "\",\"focusCount\":\""
				+ focusCount + "\",\"isFocusCount\":\"" + isFocusCount
				+ "\",\"friendsCount\":\"" + friendsCount
				+ "\",\"profilePhoto\":\"" + profilePhoto
				+ "\",\"nickname\":\"" + nickname + "\",\"email\":\"" + email
				+ "\",\"region\":\"" + region + "\",\"gender\":\"" + gender
				+ "\",\"birthday\":\"" + birthday + "\",\"signature\":\""
				+ signature + "\"}";
	}
}