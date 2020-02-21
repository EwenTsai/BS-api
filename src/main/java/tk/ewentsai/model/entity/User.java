package tk.ewentsai.model.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "users")
public class User {
	@Id
	private int uid;
	private String uname;
	private String pwd;
	private String sex;
	private String age;
	private String birthday;
	private String imageAdress;
	private String role;
	private int state;
}
