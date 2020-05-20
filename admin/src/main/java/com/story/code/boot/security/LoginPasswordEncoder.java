package com.story.code.boot.security;

import com.story.code.helper.StringHelper;
import com.story.code.helper.crypto.LoginPasswordHelper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
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
            return LoginPasswordHelper.loginPassword(cs, salt);
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

    public String randomSalt() {
        return RandomStringUtils.random(6, "ABCDEFGHJKLMNPQRSTUVWXYZ0123456789");
    }

}
