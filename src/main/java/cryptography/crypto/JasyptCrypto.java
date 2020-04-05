package cryptography.crypto;

import org.jasypt.encryption.StringEncryptor;
import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class JasyptCrypto {

    @Value("${cryptoSettings.password:password}")
    private String password;

    @Value("${cryptoSettings.algorithm:PBEWithMD5AndDES}")
    private String algorithm;

    @Value("${cryptoSettings.obtentionIterations:1000}")
    private String obtentionIterations;

    @Value("${cryptoSettings.outputType:base64}")
    private String outputType;

    public StringEncryptor getStringEncryptor() {
        PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();
        SimpleStringPBEConfig config = new SimpleStringPBEConfig();
        config.setPassword(password);
        config.setAlgorithm(algorithm);
        config.setKeyObtentionIterations(obtentionIterations);
        config.setPoolSize("1");
        config.setProviderName("SunJCE");
        config.setSaltGeneratorClassName("org.jasypt.salt.RandomSaltGenerator");
        config.setStringOutputType(outputType);
        encryptor.setConfig(config);
        return encryptor;
    }

}
