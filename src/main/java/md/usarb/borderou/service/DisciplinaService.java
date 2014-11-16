package md.usarb.borderou.service;

import java.util.Collection;

import md.usarb.borderou.common.FormatedList;
import md.usarb.borderou.dao.DisciplinaDao;
import md.usarb.borderou.entities.licenta.Disciplina;
import md.usarb.borderou.exception.DaoException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DisciplinaService {
		
	@Autowired
	DisciplinaDao dao;
	
	
	public FormatedList<Disciplina> getListDisciplina(int idSpecialitatea, int semestrul, int idGrupa, String promotia, int idProfesor) {
		Collection<Disciplina> list;
		FormatedList<Disciplina> formatedList = new FormatedList<Disciplina>();
		try {
			list = dao.getListDisciplina(idSpecialitatea, semestrul, idGrupa, promotia, idProfesor);
			formatedList.setList(list);
			formatedList.setSuccess(true);
		} catch (DaoException e) {
			formatedList.setSuccess(false);
		}
		
		 return formatedList;
	}


}
