package md.usarb.borderou.entities.licenta;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Student")
public class Student {

	
	@Id
	@Column(name = "Id")
	private Integer id;
	
	@Column(name = "Nume")
	public  String nume;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "IdSpecialitate", nullable = false)
    private Facultate specialitate;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "IdGrupa", nullable = false)
    private Grupa grupa;
	
	
	
	public Student() {
	}



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getNume() {
		return nume;
	}



	public void setNume(String nume) {
		this.nume = nume;
	}



	public Facultate getSpecialitate() {
		return specialitate;
	}



	public void setSpecialitate(Facultate specialitate) {
		this.specialitate = specialitate;
	}



	public Grupa getGrupa() {
		return grupa;
	}



	public void setGrupa(Grupa grupa) {
		this.grupa = grupa;
	}
	
	
 
}
