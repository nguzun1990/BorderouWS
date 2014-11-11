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

import com.fasterxml.jackson.annotation.JsonIgnore;


 
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
	
	@Column(name = "NrAniStudiu")
	private Integer nrAniStudiu;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "IdFacultate", nullable = false)
    private Facultate facultate;
	
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "specialitate")
	private Set<Grupa> grupaList = new HashSet<Grupa>(0);

	
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
 
	public Integer getNrAniStudiu() {
		return nrAniStudiu;
	}

	public void setNrAniStudiu(Integer nrAniStudiu) {
		this.nrAniStudiu = nrAniStudiu;
	}

	@JsonIgnore 
	public Set<Grupa> getGrupaList() {
		return grupaList;
	}

	public void setGrupaList(Set<Grupa> grupaList) {
		this.grupaList = grupaList;
	}
}
