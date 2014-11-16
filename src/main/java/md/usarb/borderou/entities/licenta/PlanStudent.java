package md.usarb.borderou.entities.licenta;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


 
@Entity
@Table(name = "PlanStudent")
public class PlanStudent implements EntityInterface {
	
	@Id
	@Column(name = "Id")
	private Integer id;
	
	@Column(name = "NotaCurenta", columnDefinition="decimal")
	private BigDecimal notaCurenta;
	
	@Column(name = "NotaExamen", columnDefinition="decimal")
	private BigDecimal notaExamen;
	
	@Column(name = "NotaFinala", columnDefinition="decimal")
	private BigDecimal notaFinala;
	
	@Column(name = "IdProfesor")
	private Integer idProfesor;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "IdStudent", nullable = false)
    private Student student;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "IdPlanDisciplina", nullable = false)
    private PlanDisciplina planDisciplina;
	
	public PlanStudent() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	@JsonIgnore
	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	@JsonIgnore
	public PlanDisciplina getPlanDisciplina() {
		return planDisciplina;
	}

	public void setPlanDisciplina(PlanDisciplina planDisciplina) {
		this.planDisciplina = planDisciplina;
	}

	public BigDecimal getNotaCurenta() {
		return notaCurenta;
	}

	public void setNotaCurenta(BigDecimal notaCurenta) {
		this.notaCurenta = notaCurenta;
	}

	public BigDecimal getNotaExamen() {
		return notaExamen;
	}

	public void setNotaExamen(BigDecimal notaExamen) {
		this.notaExamen = notaExamen;
	}

	public BigDecimal getNotaFinala() {
		return notaFinala;
	}

	public void setNotaFinala(BigDecimal notaFinala) {
		this.notaFinala = notaFinala;
	}

	public Integer getIdProfesor() {
		return idProfesor;
	}

	public void setIdProfesor(Integer idProfesor) {
		this.idProfesor = idProfesor;
	}
	
	
 
}
