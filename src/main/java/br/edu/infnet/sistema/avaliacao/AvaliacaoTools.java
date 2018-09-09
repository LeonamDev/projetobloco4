/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.infnet.sistema.avaliacao;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.apache.tomcat.util.codec.binary.Base64;

/**
 *
 * @author leonam
 */
public class AvaliacaoTools {

    private static final String key = "cryptocurrency77";
    private static final String initVector = "encryptionIntVec";

    /**
     *
     * @return current date time
     */
    public static java.sql.Timestamp getCurrentTime() {
        return Timestamp.from(LocalDateTime.now()
                .atZone(ZoneId.of("GMT-3")).toInstant());

    }

    /**
     *
     * @param long value
     * @return long value encrypted
     */
    public static String encrypt(Long value) {
        try {
            IvParameterSpec iv = new IvParameterSpec(initVector.getBytes("UTF-8"));
            SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);

            byte[] encrypted = cipher.doFinal(value.toString().getBytes());
            return Base64.encodeBase64String(encrypted);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    /**
     *
     * @param string encrypted
     * @return long decrypted
     */
    public static Long decrypt(String encrypted) {
        try {
            IvParameterSpec iv = new IvParameterSpec(initVector.getBytes("UTF-8"));
            SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);

            byte[] original = cipher.doFinal(Base64.decodeBase64(encrypted));
            return Long.valueOf(new String(original));
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return null;
    }

}
