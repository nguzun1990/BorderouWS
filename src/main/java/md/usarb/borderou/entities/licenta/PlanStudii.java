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
@Table(name = "PlanStudii")
public class PlanStudii implements EntityInterface {

	
	@Id
	@Column(name = "Id")
	private Integer id;
	
	@Column(name = "Promotia", columnDefinition = "nchar", length = 4)
	public String promotia;
	
	@Column(name = "LimbaDeStudiu")
	private String limbaDeStudiu;


	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "IdSpecialitate", nullable = false)
    private Specialitate specialitate;

	
	public PlanStudii() {
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getPromotia() {
		return promotia;
	}


	public void setPromotia(String promotia) {
		this.promotia = promotia;
	}


	public String getLimbaDeStudiu() {
		return limbaDeStudiu;
	}


	public void setLimbaDeStudiu(String limbaDeStudiu) {
		this.limbaDeStudiu = limbaDeStudiu;
	}


	public Specialitate getSpecialitate() {
		return specialitate;
	}


	public void setSpecialitate(Specialitate specialitate) {
		this.specialitate = specialitate;
	}
	
	
 
}
