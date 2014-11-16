package md.usarb.borderou.service;

import java.util.ArrayList;
import java.util.Collection;

import md.usarb.borderou.common.FormatedList;
import md.usarb.borderou.dao.PlanStudiiDao;
import md.usarb.borderou.dao.SpecialitateDao;
import md.usarb.borderou.entities.licenta.PlanStudii;
import md.usarb.borderou.entities.licenta.Promotia;
import md.usarb.borderou.entities.licenta.Semestru;
import md.usarb.borderou.entities.licenta.Specialitate;
import md.usarb.borderou.exception.DaoException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlanStudiiService {
		
	@Autowired
	PlanStudiiDao dao;
	
	
	public FormatedList<Promotia> getListPromotii() {
		Collection<Promotia> list = new ArrayList<Promotia>();
		FormatedList<Promotia> formatedList = new FormatedList<Promotia>();
		try {
			Collection<String> listPromotii = dao.getDistinctPromotii();
			for(String promotiaValue: listPromotii) {
				Promotia promotia = new Promotia(promotiaValue);
				list.add(promotia);
			}
			formatedList.setList(list);
			formatedList.setSuccess(true);
		} catch (DaoException e) {
			formatedList.setSuccess(false);
		}
		
		 return formatedList;
	}
	
}
