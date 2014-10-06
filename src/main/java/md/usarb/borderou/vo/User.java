package md.usarb.borderou.vo;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
 
@Entity
@Table(name = "D_User")
public class User {
 
	private int id;
	
	private String username;
	private String password;
 
	public User() {
	}
 
	public User(String username, String password, int id) {
		this.username = username;
		this.password = password;
		this.id = id;
	}
 

	@Column(name = "Login")
	public String getUsername() {
		return this.username;
	}
 
	public void setUsername(String username) {
		this.username = username;
	}
 
	@Column(name = "Password")
	public String getPassword() {
		return this.password;
	}
 
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Id
	@Column(name = "Id")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
 
}
