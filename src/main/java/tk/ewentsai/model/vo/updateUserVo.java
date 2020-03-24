package tk.ewentsai.model.vo;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
public class updateUserVo {

    private String uid;
    private String uname;
    private String pwd;
    private String sex;
    private String birthday;

}
