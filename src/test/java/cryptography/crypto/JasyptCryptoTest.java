package cryptography.crypto;

import org.jasypt.encryption.StringEncryptor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class JasyptCryptoTest {

    @Autowired
    JasyptCrypto jasyptCrypto;

    @Test
    public void whenConfiguredCryptorUsed() {
        StringEncryptor stringEncryptor = jasyptCrypto.getStringEncryptor();
        String password = "Password #1";

        String encryptPassword = stringEncryptor.encrypt(password);
        String decryptPassword = stringEncryptor.decrypt(encryptPassword);

        System.out.println("Encrypt password: " + encryptPassword);
        System.out.println("Decrypt password: " + decryptPassword);

        assertEquals(password, decryptPassword);
    }
}
