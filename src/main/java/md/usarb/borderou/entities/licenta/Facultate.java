package md.usarb.borderou.entities.licenta;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "D_Facultate")
public class Facultate {

	
	@Id
	@Column(name = "Id")
	private Integer id;
	
	@Column(name = "Denumire")
	public  String denumirea;
	
	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getDenumirea() {
		return denumirea;
	}



	public void setDenumirea(String denumirea) {
		this.denumirea = denumirea;
	}



	public String getPrescurtare() {
		return prescurtare;
	}



	public void setPrescurtare(String prescurtare) {
		this.prescurtare = prescurtare;
	}



	public Integer getCodUniversitar() {
		return codUniversitar;
	}



	public void setCodUniversitar(Integer codUniversitar) {
		this.codUniversitar = codUniversitar;
	}



	public String getDecan() {
		return decan;
	}



	public void setDecan(String decan) {
		this.decan = decan;
	}



	public String getEngleza() {
		return engleza;
	}



	public void setEngleza(String engleza) {
		this.engleza = engleza;
	}



	public Set<Specialitate> getSpecialitates() {
		return Specialitates;
	}



	public void setSpecialitates(Set<Specialitate> specialitates) {
		Specialitates = specialitates;
	}



	@Column(name = "Prescurtare")
	private String prescurtare;
	
	@Column(name = "CodUniversitar")
	private Integer codUniversitar;
	
	@Column(name = "Decan")
	private String decan;
	
	@Column(name = "Engleza")
	private String engleza;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "facultate")
	private Set<Specialitate> Specialitates = new HashSet<Specialitate>(0);
	
	
	
	public Facultate() {
	}
 
}
