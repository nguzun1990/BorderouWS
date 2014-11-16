package md.usarb.borderou.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import md.usarb.borderou.entities.licenta.PlanStudii;
import md.usarb.borderou.entities.licenta.Promotia;
import md.usarb.borderou.entities.licenta.Semestru;
import md.usarb.borderou.entities.licenta.Specialitate;
import md.usarb.borderou.exception.DaoException;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.StatelessSession;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PlanStudiiDao implements BaseDao {

	private static final Logger log = Logger.getLogger(PlanStudiiDao.class
			.getName());

	@Autowired
	private SessionFactory sessionFactory;

	public Collection<String> getDistinctPromotii() throws DaoException {
		Collection<String> list;
		try {
			StatelessSession session = this.sessionFactory.openStatelessSession();			
			
			Criteria criteria = session.createCriteria(PlanStudii.class);
			criteria.addOrder(Order.desc("promotia"));
			criteria.setProjection(Projections.distinct(Projections.property("promotia")));
			list = criteria.list();
			
		} catch (Exception ex) {
			throw new DaoException("PlanStudii DAO Exception" + ex.getMessage(), log);
		}
		
		return list;

	}

}
