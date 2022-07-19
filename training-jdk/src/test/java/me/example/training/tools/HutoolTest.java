package me.example.training.tools;

import cn.hutool.core.codec.Base64;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.symmetric.AES;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author zhoujialiang9
 * @date 2022/7/18 16:35
 **/
@Slf4j
@SpringBootTest
public class HutoolTest {

    private final static String TOKEN_SECRET_KEY = "Iaa6qy7C4F3QIAjgHR4j7Q==";

    @Test
    public void test1(){

        String data = "zhyx|99channel";

        AES aes = SecureUtil.aes(Base64.decode(TOKEN_SECRET_KEY));

        log.info("encryptBase64={}, encryptHex={}", aes.encryptBase64(data), aes.encryptHex(data));

        log.info("decryptStr={}, decryptStr={}", aes.decryptStr(aes.encryptBase64(data)), aes.decryptStr(aes.encryptHex(data)));

        log.info("decrypt err={}", aes.decryptStr("tMGno2VbKB7ylmmC+iGlzw=="));

    }



}
