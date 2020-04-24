package com.story.code.helper.crypto;

import com.google.common.base.Charsets;
import com.story.code.helper.Base64Helper;
import com.story.code.helper.StringHelper;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Signature;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;

/**
 * RSA加解密工具类
 *
 * @author storys.zhang@gmail.com
 * <p>
 * Created at 2020/4/23 by Storys.Zhang
 */
public final class RsaHelper {

    private final static String KEY_ALGORITHM = "RSA";
    private final static String SECURE_RANDOM_ALGORITHM = "SHA1PRNG";
    private final static String SIGNATURE_ALGORITHM = "SHA256withRSA";


    /**
     * 私钥加密
     *
     * @param privateKeyText
     * @param text
     * @return
     * @throws Exception
     */
    public static String encrypt(String privateKeyText, String text) throws Exception {
        PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(Base64Helper.decode(privateKeyText));
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        PrivateKey privateKey = keyFactory.generatePrivate(pkcs8EncodedKeySpec);
        Cipher cipher = Cipher.getInstance(KEY_ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, privateKey);
        byte[] result = cipher.doFinal(text.getBytes());
        return Base64Helper.encode(result);
    }

    /**
     * 公钥解密
     *
     * @param publicKeyText
     * @param text
     * @return
     * @throws Exception
     */
    public static String decrypt(String publicKeyText, String text) throws Exception {
        X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(Base64Helper.decode(publicKeyText));
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        PublicKey publicKey = keyFactory.generatePublic(x509EncodedKeySpec);
        Cipher cipher = Cipher.getInstance(KEY_ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, publicKey);
        byte[] result = cipher.doFinal(Base64Helper.decode(text));
        return new String(result);
    }

    /**
     * 私钥签名
     *
     * @param privateKeyText
     * @param plainText
     * @return
     * @throws Exception
     */
    public static String sign(String privateKeyText, String plainText) throws Exception {
        PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(Base64Helper.decode(privateKeyText));
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        PrivateKey privateKey = keyFactory.generatePrivate(pkcs8EncodedKeySpec);
        
        Signature privateSignature = Signature.getInstance(SIGNATURE_ALGORITHM);
        privateSignature.initSign(privateKey);
        privateSignature.update(plainText.getBytes(Charsets.UTF_8));
        byte[] signature = privateSignature.sign();
        return Base64Helper.encode(signature);
    }

    public static boolean verify(String plainText, String signature, String publicKeyText) throws Exception {
        X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(Base64Helper.decode(publicKeyText));
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        PublicKey publicKey = keyFactory.generatePublic(x509EncodedKeySpec);

        Signature publicSignature = Signature.getInstance(SIGNATURE_ALGORITHM);
        publicSignature.initVerify(publicKey);
        publicSignature.update(plainText.getBytes(Charsets.UTF_8));
        return publicSignature.verify(Base64Helper.decode(signature));
    }

    /**
     * 生成随机秘钥对
     *
     * @return
     * @throws NoSuchAlgorithmException
     */
    public static RsaKeyPair generateKeyPair() throws NoSuchAlgorithmException {
        return generateKeyPair(null);
    }

    /**
     * 生成固定秘钥对
     *
     * @param seed
     * @return
     * @throws NoSuchAlgorithmException
     */
    public static RsaKeyPair generateKeyPair(String seed) throws NoSuchAlgorithmException {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(KEY_ALGORITHM);

        if (StringHelper.isNotBlank(seed)) {
            SecureRandom secureRandom = SecureRandom.getInstance(SECURE_RANDOM_ALGORITHM);
            secureRandom.setSeed(seed.getBytes());

            keyPairGenerator.initialize(1024, secureRandom);
        } else {
            keyPairGenerator.initialize(1024);
        }
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        RSAPublicKey rsaPublicKey = (RSAPublicKey) keyPair.getPublic();
        RSAPrivateKey rsaPrivateKey = (RSAPrivateKey) keyPair.getPrivate();
        String publicKeyString = Base64Helper.encode(rsaPublicKey.getEncoded());
        String privateKeyString = Base64Helper.encode(rsaPrivateKey.getEncoded());
        RsaKeyPair rsaKeyPair = new RsaKeyPair(publicKeyString, privateKeyString);
        return rsaKeyPair;
    }

    public static class RsaKeyPair {

        private String publicKey;
        private String privateKey;

        public RsaKeyPair(String publicKey, String privateKey) {
            this.publicKey = publicKey;
            this.privateKey = privateKey;
        }

        public String getPublicKey() {
            return publicKey;
        }

        public String getPrivateKey() {
            return privateKey;
        }
    }
}
