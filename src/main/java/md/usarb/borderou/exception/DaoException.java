package md.usarb.borderou.exception;

import org.apache.log4j.Logger;


public class DaoException extends Exception {


   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DaoException() {
   }

   public DaoException(String message, Logger log) {
       log.error(message);
   }

   public DaoException(String message, Throwable rootCause, Logger log) {
       log.error(message, rootCause);
   }

   public DaoException(Throwable rootCause, Logger log) {
       log.error(rootCause);
   }
}