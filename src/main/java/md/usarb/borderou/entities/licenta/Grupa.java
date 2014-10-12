package md.usarb.borderou.entities.licenta;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


 
@Entity
@Table(name = "Grupa")
public class Grupa {

	
	@Id
	@Column(name = "Id")
	private Integer id;
	
	@Column(name = "Denumire")
	public String denumirea;
	
	@Column(name = "Cursul")
	private Integer cursul;


	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "IdSpecialitate", nullable = false)
    private Specialitate specialitate;

	
	public Grupa() {
	}


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


	public Integer getCursul() {
		return cursul;
	}


	public void setCursul(Integer cursul) {
		this.cursul = cursul;
	}


	public Specialitate getSpecialitate() {
		return specialitate;
	}


	public void setSpecialitate(Specialitate specialitate) {
		this.specialitate = specialitate;
	}
	
	
 
}
