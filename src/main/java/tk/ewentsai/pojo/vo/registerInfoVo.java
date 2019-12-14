package tk.ewentsai.pojo.vo;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class registerInfoVo {

    @NotNull(message = "注册帐户不能为空")
    private String uname;

    @NotNull(message = "注册密码不能为空")
    private String pwd;

    @NotNull(message = "注册密码不能为空")
    private String rePwd;

    @NotNull(message = "注册验证码不能为空")
    private String vaildateCode;
}
