package com.example.base64_encrypt_decrypt;
import android.util.Base64;
public class base64 {
    
    public static byte[] decryptBase64(String key) throws Exception{
        return Base64.decode( key, Base64.DEFAULT );
    }

    public static String ecryptBase64(byte[] key) throws Exception{
        return Base64.encodeToString( key, Base64.DEFAULT );
    }

}
