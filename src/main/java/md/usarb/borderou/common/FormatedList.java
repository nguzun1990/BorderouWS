package md.usarb.borderou.common;

import java.util.Collection;

import org.springframework.stereotype.Component;

import md.usarb.borderou.entities.licenta.EntityInterface;

public class FormatedList<T extends EntityInterface> {
	
	private boolean success;
	
	private Collection<T> list;

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public Collection<T> getList() {
		return list;
	}

	public void setList(Collection<T> list) {
		this.list = list;
	}
	
	

}
