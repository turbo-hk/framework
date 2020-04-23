package com.story.code.helper;

import com.story.code.helper.crypto.RsaHelper;
import com.story.code.helper.crypto.RsaHelper.RsaKeyPair;
import java.security.NoSuchAlgorithmException;
import org.junit.Test;

/**
 * @author storys.zhang@gmail.com
 * <p>
 * Created at 2020/4/23 by Storys.Zhang
 */
public class RsaTest {

    @Test
    public void testKeyPair() throws NoSuchAlgorithmException {
        RsaKeyPair rsaKeyPair = RsaHelper.generateKeyPair();
        System.out.println(rsaKeyPair.getPrivateKey());
        System.out.println(rsaKeyPair.getPublicKey());
        RsaKeyPair rsaKeyPair2 = RsaHelper.generateKeyPair();
        System.out.println(rsaKeyPair2.getPrivateKey());
        System.out.println(rsaKeyPair2.getPublicKey());

        RsaKeyPair rsaKeyPair3 = RsaHelper.generateKeyPair("hdzfw");
        System.out.println(rsaKeyPair3.getPrivateKey());
        System.out.println(rsaKeyPair3.getPublicKey());
        RsaKeyPair rsaKeyPair4 = RsaHelper.generateKeyPair("hdzfw");
        System.out.println(rsaKeyPair4.getPrivateKey());
        System.out.println(rsaKeyPair4.getPublicKey());

        System.out.println(rsaKeyPair.getPrivateKey().equals(rsaKeyPair2.getPrivateKey()));
        System.out.println(rsaKeyPair3.getPrivateKey().equals(rsaKeyPair4.getPrivateKey()));

    }
}
