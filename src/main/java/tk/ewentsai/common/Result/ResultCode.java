package tk.ewentsai.common.Result;

public enum  ResultCode {
    /**
     * 成功
     */
    SUCCESS(200),
    /**
     * 失败
     */
    FAIL(400),
    /**
     * 未认证
     */
    UNAUTHORIZED(401),
    /**
     * 接口不存在
     */
    NOT_FOUND(404);

    public int code;

    ResultCode(int code) {
        this.code = code;
    }
}
