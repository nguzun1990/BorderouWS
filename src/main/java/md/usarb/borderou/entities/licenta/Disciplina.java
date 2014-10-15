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
@Table(name = "D_Disciplini")
public class Disciplina {

	
	@Id
	@Column(name = "Id")
	private Integer id;
	
	@Column(name = "Denumire")
	public String denumirea;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "disciplina")
	private Set<PlanDisciplina> planDisciplinaList = new HashSet<PlanDisciplina>(0);
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "disciplina")
	private Set<IncadrareaProfesorilor> incadrareaProfesorilorList = new HashSet<IncadrareaProfesorilor>(0);
	
	public Disciplina() {
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
	
	
 
}
