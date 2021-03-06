package md.usarb.borderou.factory;

import java.lang.reflect.Method;

import md.usarb.borderou.dao.BaseDao;

import org.apache.log4j.Logger;


public class DaoFactory {
	
	private static final Logger log = Logger.getLogger(DaoFactory.class.getName());
	
	public static  <T extends BaseDao> T buildObject(Class<T> className) {
		try {

			Method getInstanceMethod = className.getMethod("getInstance");
			@SuppressWarnings("unchecked")
			T newInstance = (T) getInstanceMethod.invoke(null);
			return newInstance;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		return null;
	}

}
