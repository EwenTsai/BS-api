package tk.ewentsai.model.vo;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class registerInfoVo {

    private String uname;

    private String pwd;

    private String rePwd;

    private String kaptchaCode;
}
