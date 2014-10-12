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
public class IncadrareaProfesorilor {

	
	@Id
	@Column(name = "Id")
	private Integer id;
	
	@Column(name = "IdProfesor")
	public String idProfesor;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "IdDisciplina", nullable = false)
    private Diciplina diciplina;

	
	public IncadrareaProfesorilor() {
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getIdProfesor() {
		return idProfesor;
	}


	public void setIdProfesor(String idProfesor) {
		this.idProfesor = idProfesor;
	}


	public Diciplina getDiciplina() {
		return diciplina;
	}


	public void setDiciplina(Diciplina diciplina) {
		this.diciplina = diciplina;
	}
 
	
}
