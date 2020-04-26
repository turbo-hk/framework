package com.story.code.helper.crypto;

import com.story.code.helper.Base64Helper;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

/**
 * 登录密码帮助类
 *
 * @author storys.zhang@gmail.com
 * <p>
 * Created at 2020/4/26 by Storys.Zhang
 */
public final class LoginPasswordHelper {

    private final static String ALGORITHM = "PBKDF2WithHmacSHA512";

    /**
     * 登录密码（PBKDF2WithHmacSHA512加密）
     *
     * @param cs             密码
     * @param salt           密码盐
     * @param iterationCount 重复加密次数
     * @param keyLength
     * @return
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeySpecException
     */
    public static String loginPassword(CharSequence cs, String salt, int iterationCount, int keyLength) throws NoSuchAlgorithmException, InvalidKeySpecException {
        byte[] result = SecretKeyFactory.getInstance(ALGORITHM)
            .generateSecret(new PBEKeySpec(cs.toString().toCharArray(), salt.getBytes(),
                iterationCount, keyLength))
            .getEncoded();
        return Base64Helper.encode(result);
    }

    /**
     * 登录密码（PBKDF2WithHmacSHA512加密）
     *
     * @param cs   密码
     * @param salt 密码盐
     * @return
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeySpecException
     */
    public static String loginPassword(CharSequence cs, String salt) throws NoSuchAlgorithmException, InvalidKeySpecException {
        return loginPassword(cs, salt, 31, 512);
    }


}
