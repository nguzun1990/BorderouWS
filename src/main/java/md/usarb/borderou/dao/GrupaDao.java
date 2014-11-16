package md.usarb.borderou.dao;

import java.util.Collection;

import md.usarb.borderou.entities.licenta.Grupa;
import md.usarb.borderou.exception.DaoException;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.StatelessSession;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class GrupaDao implements BaseDao{
	
	private static final Logger log = Logger.getLogger(GrupaDao.class.getName());
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public Collection<Grupa> getListGrupa(int idSpecialitate) throws DaoException {
 		Collection<Grupa> list;
		try {
			StatelessSession session = this.sessionFactory.openStatelessSession();
			Criteria criteria = session.createCriteria(Grupa.class, "grupa");
			criteria.createAlias("grupa.specialitate", "specialitate");
			criteria.add(Restrictions.eq("specialitate.id", idSpecialitate));
//			criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
			list = criteria.list();
		} catch (Exception ex) {
			throw new DaoException("Grupa DAO Exception" + ex.getMessage(), log);
		}
		return list;
		
	}

}
