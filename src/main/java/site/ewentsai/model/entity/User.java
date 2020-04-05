package site.ewentsai.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "users")
@NoArgsConstructor
@ToString
public class User {
	@Id
	@GeneratedValue
	private int uid;
	private String uname;
	private String pwd;
	private String salt;
	private String sex;
	private String age;
	private String birthday;
	private String imageAdress;
	private int state;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "user_role", joinColumns = { @JoinColumn(name = "uid") }, inverseJoinColumns = {
			@JoinColumn(name = "rid") })
	private List<SysRole> roles;

	public String getCredentialsSalt(){ return uname+salt; }
}
