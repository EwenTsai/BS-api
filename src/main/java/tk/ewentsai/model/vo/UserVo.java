package tk.ewentsai.model.vo;

import lombok.Data;

import java.util.Date;

@Data
public class UserVo {
    private int id;
    private String uname;
    private String age;
    private String sex;
    private Date birthday;
    private String imageAdress;
}
