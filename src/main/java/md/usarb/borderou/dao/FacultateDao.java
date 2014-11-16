package md.usarb.borderou.dao;

import java.util.Collection;

import md.usarb.borderou.entities.licenta.Facultate;
import md.usarb.borderou.exception.DaoException;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.StatelessSession;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class FacultateDao implements BaseDao {

	private static final Logger log = Logger.getLogger(FacultateDao.class.getName());
	
	@Autowired
	private SessionFactory sessionFactory;
	

	public Collection<Facultate> getListFacultate() throws DaoException {
		Collection<Facultate> list;
		try {
			StatelessSession session = this.sessionFactory.openStatelessSession();

			Criteria criteria = session.createCriteria(Facultate.class,	"facultate");
			criteria.add(Restrictions.isNotNull("facultate.codUniversitar"));
			list = criteria.list();
		} catch (Exception ex) {
			throw new DaoException("Facultatea DAO Exception" + ex.getMessage(), log);
		}
		return list;

	}

}
