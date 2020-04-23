package com.story.code.boot.security;

import java.util.Collection;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

/**
 * @author storys.zhang@gmail.com
 * <p>
 * Created at 2020/4/23 by Storys.Zhang
 */
@EqualsAndHashCode(callSuper = true)
public class TokenAuthentication extends UsernamePasswordAuthenticationToken {

    @Setter
    @Getter
    private String token;

    public TokenAuthentication(String token, Object principal, Object credentials) {
        super(principal, credentials);
        this.token = token;
    }

    public TokenAuthentication(String token, Object principal, Object credentials, Collection<? extends GrantedAuthority> authorities) {
        super(principal, credentials, authorities);
        this.token = token;
    }
}
