package tk.ewentsai.pojo.vo;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class loginInfoVo {

    @NotNull(message = "用户名不允许为空")
    private String uname;

    @NotNull(message = "密码不允许为空")
    private String pwd;

    @NotNull(message = "验证吗不允许为空")
    private String vaildateCode;
}
