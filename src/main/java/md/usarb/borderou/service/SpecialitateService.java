package md.usarb.borderou.service;

import java.util.Collection;

import md.usarb.borderou.common.FormatedList;
import md.usarb.borderou.dao.SpecialitateDao;
import md.usarb.borderou.entities.licenta.Semestru;
import md.usarb.borderou.entities.licenta.Specialitate;
import md.usarb.borderou.exception.DaoException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SpecialitateService {
		
	@Autowired
	SpecialitateDao dao;
	
	
	public FormatedList<Specialitate> getListSpecialitate(int idFacultate) {
		Collection<Specialitate> list;
		FormatedList<Specialitate> formatedList = new FormatedList<Specialitate>();
		try {
			list = dao.getListSpecialitate(idFacultate);
			formatedList.setList(list);
			formatedList.setSuccess(true);
		} catch (DaoException e) {
			formatedList.setSuccess(false);
		}
		
		 return formatedList;
	}
	
	public FormatedList<Semestru> getListSemestre(int idSpecialitate) {
		Collection<Semestru> list;
		FormatedList<Semestru> formatedList = new FormatedList<Semestru>();
		try {
			list = dao.getSemestre(idSpecialitate);
			formatedList.setList(list);
			formatedList.setSuccess(true);
		} catch (DaoException e) {
			formatedList.setSuccess(false);
		}
		
		 return formatedList;
	}


}
