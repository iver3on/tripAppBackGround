package cn.edu.xjtu.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.edu.xjtu.pojo.Detailtravelnotes;

/**
 * A data access object (DAO) providing persistence and search support for
 * Detailtravelnotes entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see cn.edu.xjtu.pojo.Detailtravelnotes
 * @author MyEclipse Persistence Tools
 */
public class DetailtravelnotesDAO extends HibernateDaoSupport {
	private static final Log log = LogFactory
			.getLog(DetailtravelnotesDAO.class);
	// property constants
	public static final String CONTENT = "content";
	public static final String LONGITUDE = "longitude";
	public static final String LATITUDE = "latitude";
	public static final String LOCATION = "location";
	public static final String STAR_COUNT = "starCount";
	public static final String COMMENT_COUNT = "commentCount";

	protected void initDao() {
		// do nothing
	}

	public void save(Detailtravelnotes transientInstance) {
		log.debug("saving Detailtravelnotes instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Detailtravelnotes persistentInstance) {
		log.debug("deleting Detailtravelnotes instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Detailtravelnotes findById(Integer id) {
		log.debug("getting Detailtravelnotes instance with id: " + id);
		try {
			Detailtravelnotes instance = (Detailtravelnotes) getHibernateTemplate()
					.get("cn.edu.xjtu.pojo.Detailtravelnotes", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
		// return (Detailtravelnotes)
		// getSession().createSQLQuery("select * from detailtravelnotes where detailTravelNotesId="+id).addEntity(Detailtravelnotes.class).list().get(0);
	}

	public List findByExample(Detailtravelnotes instance) {
		log.debug("finding Detailtravelnotes instance by example");
		try {
			List results = getHibernateTemplate().findByExample(instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Detailtravelnotes instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from Detailtravelnotes as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByContent(Object content) {
		return findByProperty(CONTENT, content);
	}

	public List findByLongitude(Object longitude) {
		return findByProperty(LONGITUDE, longitude);
	}

	public List findByLatitude(Object latitude) {
		return findByProperty(LATITUDE, latitude);
	}

	public List findByLocation(Object location) {
		return findByProperty(LOCATION, location);
	}

	public List findByStarCount(Object starCount) {
		return findByProperty(STAR_COUNT, starCount);
	}

	public List findByCommentCount(Object commentCount) {
		return findByProperty(COMMENT_COUNT, commentCount);
	}

	public List findAll() {
		log.debug("finding all Detailtravelnotes instances");
		try {
			String queryString = "from Detailtravelnotes";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Detailtravelnotes merge(Detailtravelnotes detachedInstance) {
		log.debug("merging Detailtravelnotes instance");
		try {
			Detailtravelnotes result = (Detailtravelnotes) getHibernateTemplate()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Detailtravelnotes instance) {
		log.debug("attaching dirty Detailtravelnotes instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Detailtravelnotes instance) {
		log.debug("attaching clean Detailtravelnotes instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static DetailtravelnotesDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (DetailtravelnotesDAO) ctx.getBean("DetailtravelnotesDAO");
	}

	/**
	 * @param offset
	 * @param limit
	 * @return
	 */
	public List<Detailtravelnotes> findTopStar(Integer offset, Integer limit) {
		return getSession()
				.createSQLQuery(
						"select * from detailtravelnotes order by starCount DESC limit "
								+ limit + " offset " + offset)
				.addEntity(Detailtravelnotes.class).list();
	}

	/**
	 * @param userid
	 * @param longitude2
	 * @param latitude2
	 * @param limit
	 * @return
	 */
	public List<Detailtravelnotes> getNotesOfMyfriends(int userid,
			double longitude2, double latitude2, int limit) {
		return getSession()
				.createSQLQuery(
						"select * from detailtravelnotes where userid in (select attention_userid from userattentions where userId="
								+ userid
								+ ") ORDER BY (POWER(MOD(ABS(longitude -"
								+ longitude2
								+ "),360),2) + POWER(ABS(latitude -"
								+ latitude2 + "),2)) LIMIT " + limit)
				.addEntity(Detailtravelnotes.class).list();
	}

	/**
	 * @param id
	 * @return
	 */
	public List<Detailtravelnotes> findByUserId(Integer id) {
		return getSession()
				.createSQLQuery(
						"select * from detailtravelnotes where userid=" + id)
				.addEntity(Detailtravelnotes.class).list();
	}
}