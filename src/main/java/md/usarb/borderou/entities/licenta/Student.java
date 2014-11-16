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
@Table(name = "Student")
public class Student implements EntityInterface {

	
	@Id
	@Column(name = "Id")
	private Integer id;
	
	@Column(name = "Nume")
	public  String nume;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IdSpecialitate", nullable = false)
    private Facultate specialitate;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IdGrupa", nullable = false)
    private Grupa grupa;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "student")
	private Set<PlanStudent> planStudentList = new HashSet<PlanStudent>(0);
	
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


	@JsonIgnore
	public Facultate getSpecialitate() {
		return specialitate;
	}



	public void setSpecialitate(Facultate specialitate) {
		this.specialitate = specialitate;
	}


	@JsonIgnore
	public Grupa getGrupa() {
		return grupa;
	}



	public void setGrupa(Grupa grupa) {
		this.grupa = grupa;
	}


	 
	public Set<PlanStudent> getPlanStudentList() {
		return planStudentList;
	}



	public void setPlanStudentList(Set<PlanStudent> planStudentList) {
		this.planStudentList = planStudentList;
	}


	public PlanStudent getPlanStudent() {
		Set<PlanStudent> planStudentSet =  this.getPlanStudentList();
		
		return planStudentSet.iterator().next();
		
	}
		
	
}
