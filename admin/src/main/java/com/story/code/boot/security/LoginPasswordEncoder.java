package com.story.code.boot.security;

import com.story.code.helper.StringHelper;
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
        return encode(cs, StringHelper.EMPTY);
    }

    public String encode(CharSequence cs, String salt) {
        log.debug("password encode , salt={} , password={} ", salt, cs);
        try {
            byte[] result = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA512")
                .generateSecret(new PBEKeySpec(cs.toString().toCharArray(), StringHelper.nullToEmpty(salt).getBytes(),
                    31, 512))
                .getEncoded();
            String s = Base64.getEncoder().encodeToString(result);
            return s;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public boolean matches(CharSequence cs, String string) {
        return encode(cs).equals(string);
    }

    public boolean matches(CharSequence cs, String string, String salt) {
        log.debug("cs:{}, str:{}, salt:{}", cs, string, salt);
        return encode(cs, salt).equals(string);
    }

}
