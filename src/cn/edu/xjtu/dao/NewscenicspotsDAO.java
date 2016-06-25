package cn.edu.xjtu.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.edu.xjtu.pojo.Newscenicspots;

/**
 * A data access object (DAO) providing persistence and search support for
 * Newscenicspots entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see cn.edu.xjtu.pojo.Newscenicspots
 * @author MyEclipse Persistence Tools
 */
public class NewscenicspotsDAO extends HibernateDaoSupport {
	private static final Log log = LogFactory.getLog(NewscenicspotsDAO.class);
	// property constants
	public static final String SCENICNAME = "scenicname";
	public static final String SUMMARY = "summary";
	public static final String LONGITUDE = "longitude";
	public static final String LATITUDE = "latitude";
	public static final String PICTURE = "picture";
	public static final String LOCATION = "location";

	protected void initDao() {
		// do nothing
	}

	public void save(Newscenicspots transientInstance) {
		log.debug("saving Newscenicspots instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Newscenicspots persistentInstance) {
		log.debug("deleting Newscenicspots instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Newscenicspots findById(java.lang.Integer id) {
		log.debug("getting Newscenicspots instance with id: " + id);
		try {
			Newscenicspots instance = (Newscenicspots) getHibernateTemplate()
					.get("cn.edu.xjtu.pojo.Newscenicspots", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Newscenicspots instance) {
		log.debug("finding Newscenicspots instance by example");
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
		log.debug("finding Newscenicspots instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from Newscenicspots as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByScenicname(Object scenicname) {
		return findByProperty(SCENICNAME, scenicname);
	}

	public List findBySummary(Object summary) {
		return findByProperty(SUMMARY, summary);
	}

	public List findByLongitude(Object longitude) {
		return findByProperty(LONGITUDE, longitude);
	}

	public List findByLatitude(Object latitude) {
		return findByProperty(LATITUDE, latitude);
	}

	public List findByPicture(Object picture) {
		return findByProperty(PICTURE, picture);
	}

	public List findByLocation(Object location) {
		return findByProperty(LOCATION, location);
	}

	public List findAll() {
		log.debug("finding all Newscenicspots instances");
		try {
			String queryString = "from Newscenicspots";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Newscenicspots merge(Newscenicspots detachedInstance) {
		log.debug("merging Newscenicspots instance");
		try {
			Newscenicspots result = (Newscenicspots) getHibernateTemplate()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Newscenicspots instance) {
		log.debug("attaching dirty Newscenicspots instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Newscenicspots instance) {
		log.debug("attaching clean Newscenicspots instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static NewscenicspotsDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (NewscenicspotsDAO) ctx.getBean("NewscenicspotsDAO");
	}

	/**
	 * @param longitude2
	 * @param latitude2
	 */
	public List<Newscenicspots> getNearBySpots(double longitude2,
			double latitude2, int limit) {
		return getSession()
				.createSQLQuery(
						"select * from newscenicspots ORDER BY (POWER(MOD(ABS(longitude -"
								+ longitude2
								+ "),360),2) + POWER(ABS(latitude -"
								+ latitude2 + "),2)) LIMIT " + limit)
				.addEntity(Newscenicspots.class).list();
	}

	/**
	 * @param offset
	 * @param limit
	 * @return
	 */
	public List<Newscenicspots> getTopSpots(Integer offset, Integer limit) {
		return getSession()
				.createSQLQuery(
						"select * from newscenicspots order by starCount DESC limit "
								+ limit + " offset " + offset)
				.addEntity(Newscenicspots.class).list();
	}

	/**
	 * @param offset
	 * @param limit
	 * @return
	 */
	public List<Newscenicspots> getTopCommentSpots(Integer offset, Integer limit) {
		return getSession()
				.createSQLQuery(
						"select * from newscenicspots order by commentCount DESC limit "
								+ limit + " offset " + offset)
				.addEntity(Newscenicspots.class).list();

	}

	/**
	 * @param id
	 * @return
	 */
	public List<Newscenicspots> getSpotsByUserId(Integer id) {
		return getSession()
				.createSQLQuery(
						"select * from newscenicspots where userid=" + id)
				.addEntity(Newscenicspots.class).list();
	}
}