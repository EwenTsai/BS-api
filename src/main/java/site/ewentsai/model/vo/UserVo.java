package site.ewentsai.model.vo;

import lombok.Data;

import java.util.Date;

@Data
public class UserVo {

    private String uid;
    private String uname;
    private String age;
    private String sex;
    private String birthday;
    private String imageAdress;
    private boolean isAdmin;

}
