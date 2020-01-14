package tk.ewentsai.model.pojo;

import lombok.Data;
@Data
public class User {
	private int uid;
	private String uname;
	private String pwd;
	private String age;
	private String birthday;
	private String imageAdress;
	private String role;
	private int state;
}
