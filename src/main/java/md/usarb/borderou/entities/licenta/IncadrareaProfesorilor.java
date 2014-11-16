package md.usarb.borderou.entities.licenta;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


 
@Entity
@Table(name = "IncadrareaProfesorilor")
public class IncadrareaProfesorilor implements EntityInterface {

	
	@Id
	@Column(name = "Id")
	private Integer id;
	
	@Column(name = "IdProfesor")
	public Integer idProfesor;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "IdDisciplina", nullable = false)
    private Disciplina disciplina;

	
	public IncadrareaProfesorilor() {
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Integer getIdProfesor() {
		return idProfesor;
	}


	public void setIdProfesor(Integer idProfesor) {
		this.idProfesor = idProfesor;
	}


	public Disciplina getDisciplina() {
		return disciplina;
	}


	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}
 
	
}
