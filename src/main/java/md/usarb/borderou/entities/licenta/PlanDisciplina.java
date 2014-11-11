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
@Table(name = "PlanDisciplina")
public class PlanDisciplina {
	
	@Id
	@Column(name = "Id")
	private Integer id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "IdPlan", nullable = false)
    private PlanStudii planStudii;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "IdDisciplina", nullable = false)
    private Disciplina disciplina;
	
	@Column(name = "Semestrul")
	private Integer semestrul;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "planDisciplina")
	private Set<PlanStudent> planStudentList = new HashSet<PlanStudent>(0);
	
	public PlanDisciplina() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public PlanStudii getPlanStudii() {
		return planStudii;
	}

	public void setPlanStudii(PlanStudii planStudii) {
		this.planStudii = planStudii;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public Integer getSemestrul() {
		return semestrul;
	}

	public void setSemestrul(Integer semestrul) {
		this.semestrul = semestrul;
	}

	public Set<PlanStudent> getPlanStudentList() {
		return planStudentList;
	}

	public void setPlanStudentList(Set<PlanStudent> planStudentList) {
		this.planStudentList = planStudentList;
	}
 
	
	
}
