package tk.ewentsai.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Data
@Entity
@Table(name = "users")
@NoArgsConstructor
@ToString
public class User {
	@Id
	private String uid;
	private String uname;
	private String pwd;
	private String sex;
	private String age;
	private String birthday;
	private String imageAdress;
	private String role;
	private int state;
}
