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
public class PlanStudii {

	
	@Id
	@Column(name = "Id")
	private Integer id;
	
	@Column(name = "Promotia")
	public String promotia;
	
	@Column(name = "LimbaDeStudiu")
	private Integer limbaDeStudiu;


	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "IdSpecialitate", nullable = false)
    private Specialitate specialitate;

	
	public PlanStudii() {
	}
 
}
