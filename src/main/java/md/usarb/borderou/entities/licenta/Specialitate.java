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
@Table(name = "D_Specialitate")
public class Specialitate {

	
	@Id
	@Column(name = "Id")
	private Integer id;
	
	@Column(name = "IdCatedra")
	private Integer idCatedra;
	
	@Column(name = "Denumire")
	public String denumirea;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "IdFacultate", nullable = false)
    private Facultate facultate;

	
	public Specialitate() {
	}
	
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Integer getIdCatedra() {
		return idCatedra;
	}


	public void setIdCatedra(Integer idCatedra) {
		this.idCatedra = idCatedra;
	}


	public String getDenumirea() {
		return denumirea;
	}


	public void setDenumirea(String denumirea) {
		this.denumirea = denumirea;
	}


	public Facultate getFacultate() {
		return facultate;
	}


	public void setFacultate(Facultate facultate) {
		this.facultate = facultate;
	}
 
}
