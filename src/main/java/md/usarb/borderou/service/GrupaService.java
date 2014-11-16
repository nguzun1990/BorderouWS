package md.usarb.borderou.service;

import java.util.Collection;

import md.usarb.borderou.common.FormatedList;
import md.usarb.borderou.dao.GrupaDao;
import md.usarb.borderou.entities.licenta.Grupa;
import md.usarb.borderou.exception.DaoException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GrupaService {
		
	@Autowired
	GrupaDao dao;
	
	
	public FormatedList<Grupa> getListGrupa(int idSpecialitate) {
		Collection<Grupa> list;
		FormatedList<Grupa> formatedList = new FormatedList<Grupa>();
		try {
			list = dao.getListGrupa(idSpecialitate);
			formatedList.setList(list);
			formatedList.setSuccess(true);
		} catch (DaoException e) {
			formatedList.setSuccess(false);
		}
		
		 return formatedList;
	}


}
