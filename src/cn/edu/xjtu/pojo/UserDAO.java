package cn.edu.xjtu.pojo;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.edu.xjtu.pojo.User;

/**
 	* A data access object (DAO) providing persistence and search support for User entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see cn.edu.xjtu.pojo.User
  * @author MyEclipse Persistence Tools 
 */
public class UserDAO extends HibernateDaoSupport  {
		 private static final Log log = LogFactory.getLog(UserDAO.class);
		//property constants
	public static final String NAME = "name";
	public static final String PASSWORD = "password";
	public static final String FOCUS_COUNT = "focusCount";
	public static final String IS_FOCUS_COUNT = "isFocusCount";
	public static final String FRIENDS_COUNT = "friendsCount";
	public static final String PROFILE_PHOTO = "profilePhoto";
	public static final String NICKNAME = "nickname";
	public static final String EMAIL = "email";
	public static final String REGION = "region";
	public static final String GENDER = "gender";
	public static final String SIGNATURE = "signature";



	protected void initDao() {
		//do nothing
	}
    
    public void save(User transientInstance) {
        log.debug("saving User instance");
        try {
            getHibernateTemplate().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(User persistentInstance) {
        log.debug("deleting User instance");
        try {
            getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public User findById( java.lang.Integer id) {
        log.debug("getting User instance with id: " + id);
        try {
            User instance = (User) getHibernateTemplate()
                    .get("cn.edu.xjtu.pojo.User", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(User instance) {
        log.debug("finding User instance by example");
        try {
            List results = getHibernateTemplate().findByExample(instance);
            log.debug("find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }    
    
    public List findByProperty(String propertyName, Object value) {
      log.debug("finding User instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from User as model where model." 
         						+ propertyName + "= ?";
		 return getHibernateTemplate().find(queryString, value);
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByName(Object name
	) {
		return findByProperty(NAME, name
		);
	}
	
	public List findByPassword(Object password
	) {
		return findByProperty(PASSWORD, password
		);
	}
	
	public List findByFocusCount(Object focusCount
	) {
		return findByProperty(FOCUS_COUNT, focusCount
		);
	}
	
	public List findByIsFocusCount(Object isFocusCount
	) {
		return findByProperty(IS_FOCUS_COUNT, isFocusCount
		);
	}
	
	public List findByFriendsCount(Object friendsCount
	) {
		return findByProperty(FRIENDS_COUNT, friendsCount
		);
	}
	
	public List findByProfilePhoto(Object profilePhoto
	) {
		return findByProperty(PROFILE_PHOTO, profilePhoto
		);
	}
	
	public List findByNickname(Object nickname
	) {
		return findByProperty(NICKNAME, nickname
		);
	}
	
	public List findByEmail(Object email
	) {
		return findByProperty(EMAIL, email
		);
	}
	
	public List findByRegion(Object region
	) {
		return findByProperty(REGION, region
		);
	}
	
	public List findByGender(Object gender
	) {
		return findByProperty(GENDER, gender
		);
	}
	
	public List findBySignature(Object signature
	) {
		return findByProperty(SIGNATURE, signature
		);
	}
	

	public List findAll() {
		log.debug("finding all User instances");
		try {
			String queryString = "from User";
		 	return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public User merge(User detachedInstance) {
        log.debug("merging User instance");
        try {
            User result = (User) getHibernateTemplate()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(User instance) {
        log.debug("attaching dirty User instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(User instance) {
        log.debug("attaching clean User instance");
        try {
                      	getHibernateTemplate().lock(instance, LockMode.NONE);
                        log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static UserDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (UserDAO) ctx.getBean("UserDAO");
	}
}