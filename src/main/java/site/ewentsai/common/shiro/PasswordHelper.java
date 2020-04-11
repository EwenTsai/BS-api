package site.ewentsai.common.shiro;

import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import site.ewentsai.model.entity.User;

public class PasswordHelper {
    private static RandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator();
    public static final String ALGORITHM_NAME = "md5"; // 基础散列算法
    public static final int HASH_ITERATIONS = 2; // 自定义散列次数

    public static void encryptPassword(User user) {
        // 随机字符串作为salt因子，实际参与运算的salt我们还引入其它干扰因子
        user.setSalt(randomNumberGenerator.nextBytes().toHex());
        String newPassword = new SimpleHash(ALGORITHM_NAME, user.getPwd(),
                ByteSource.Util.bytes(user.getCredentialsSalt()), HASH_ITERATIONS).toHex();
        user.setPwd(newPassword);
    }

    public static String getEncryptPassword(String username,String salt,String password){
        return new SimpleHash(ALGORITHM_NAME, password,
                ByteSource.Util.bytes(username+salt), HASH_ITERATIONS).toHex();
    }
}
