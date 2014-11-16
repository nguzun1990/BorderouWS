package md.usarb.borderou.service;

import java.util.Collection;
import md.usarb.borderou.common.FormatedList;
import md.usarb.borderou.dao.FacultateDao;
import md.usarb.borderou.entities.licenta.Facultate;
import md.usarb.borderou.exception.DaoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FacultateService {
		
	@Autowired
	FacultateDao facultateDao;
	
	
	public FormatedList<Facultate> getListFacultate() {
		Collection<Facultate> list;
		FormatedList<Facultate> formatedList = new FormatedList<Facultate>();
		try {
			list = facultateDao.getListFacultate();
			formatedList.setList(list);
			formatedList.setSuccess(true);
		} catch (DaoException e) {
			formatedList.setSuccess(false);
		}
		
		 return formatedList;
	}


}
