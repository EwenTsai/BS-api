package site.ewentsai.model.vo;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class loginInfoVo {

    private String uname;

    private String pwd;

    private String kaptchaCode;
}
