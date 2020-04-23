package com.story.code.boot.security;

import java.util.Base64;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author storys.zhang@gmail.com
 * <p>
 * Created at 2020/4/21 by Storys.Zhang
 */
@Slf4j
public class LoginPasswordEncoder implements PasswordEncoder {

    @Override
    public String encode(CharSequence cs) {
        try {
            byte[] result = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA512")
                .generateSecret(new PBEKeySpec(cs.toString().toCharArray(), "handongzhengfawei".getBytes(),
                    31, 512))
                .getEncoded();
            String s = Base64.getEncoder().encodeToString(result);
            log.debug("cs:{}, s:{}", cs, s);
            return s;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public boolean matches(CharSequence cs, String string) {
        log.debug("cs:{}, str:{}", cs, string);
        return encode(cs).equals(string);
    }

}
