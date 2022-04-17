package d.d;

import cn.hutool.core.util.CharsetUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.asymmetric.KeyType;
import cn.hutool.crypto.asymmetric.RSA;
import org.junit.Assert;
import org.junit.Test;

public class RsaTest {

	@Test
	public void test(){
		String privateKey = "MIIBUwIBADANBgkqhkiG9w0BAQEFAASCAT0wggE5AgEAAkEA0vfvyTdGJkdbHkB8\n" +
				"mp0f3FE0GYP3AYPaJF7jUd1M0XxFSE2ceK3k2kw20YvQ09NJKk+OMjWQl9WitG9p\n" +
				"B6tSCQIDAQABAkA2SimBrWC2/wvauBuYqjCFwLvYiRYqZKThUS3MZlebXJiLB+Ue\n" +
				"/gUifAAKIg1avttUZsHBHrop4qfJCwAI0+YRAiEA+W3NK/RaXtnRqmoUUkb59zsZ\n" +
				"UBLpvZgQPfj1MhyHDz0CIQDYhsAhPJ3mgS64NbUZmGWuuNKp5coY2GIj/zYDMJp6\n" +
				"vQIgUueLFXv/eZ1ekgz2Oi67MNCk5jeTF2BurZqNLR3MSmUCIFT3Q6uHMtsB9Eha\n" +
				"4u7hS31tj1UWE+D+ADzp59MGnoftAiBeHT7gDMuqeJHPL4b+kC+gzV4FGTfhR9q3\n" +
				"tTbklZkD2A==";
		String publicKey = "MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBANL378k3RiZHWx5AfJqdH9xRNBmD9wGD\n" +
				"2iRe41HdTNF8RUhNnHit5NpMNtGL0NPTSSpPjjI1kJfVorRvaQerUgkCAwEAAQ==";
		RSA rsad = SecureUtil.rsa(privateKey, null);

		RSA rsae = new RSA(null,publicKey);
		String hello = rsae.encryptBase64("Teleinfo-88", KeyType.PublicKey);
		System.out.println(hello);

		hello= "tsgUtey3D7xx3Vl2bnZ0k8Tpjp5+8Z5LqetMbWeeSQvx8e2PXN7z9GvhU/2gZjsK5w7vh0T1AxyZ/7WLKAXKLQ==";
		System.out.println(rsad.decryptStr(hello, KeyType.PrivateKey));

		String s2 = "tZVWbVzstaTKw2ar6Yw1TBVRQ5UgNk8Z/9tcIXO3OqFMw6Y/sAJ1ynG0axsrCXzyxcHYucmNZ0Vunv6O6qG3fA==";
		System.out.println(rsad.decryptStr(s2, KeyType.PrivateKey));

		String s1 = "wJAjILSKbibzhvWBH9uyNUDWY5kMN81eMjyYvjAkIBzEbMPe01+YVOegS8wy7OxEmB7PXf9apPIb3mh4kzpUpg==";
		System.out.println(rsad.decryptStr(s1, KeyType.PrivateKey));

		for (int i = 0; i < 10; i++) {
			System.out.println(rsae.encryptBase64("Hello", KeyType.PublicKey));

		}

	}

	@Test
	public void test1(){
		RSA rsa = new RSA();

		//获得私钥
		rsa.getPrivateKey();
		System.out.println("rsa.getPrivateKeyBase64() = " + rsa.getPrivateKeyBase64());
		//获得公钥
		rsa.getPublicKey();
		System.out.println("rsa.getPublicKeyBase64() = " + rsa.getPublicKeyBase64());

		//公钥加密，私钥解密
		byte[] encrypt = rsa.encrypt(StrUtil.bytes("我是一段测试aaaa", CharsetUtil.CHARSET_UTF_8), KeyType.PublicKey);
		byte[] decrypt = rsa.decrypt(encrypt, KeyType.PrivateKey);
		Assert.assertEquals("我是一段测试aaaa", StrUtil.str(decrypt, CharsetUtil.CHARSET_UTF_8));

		//私钥加密，公钥解密
		byte[] encrypt2 = rsa.encrypt(StrUtil.bytes("我是一段测试aaaa", CharsetUtil.CHARSET_UTF_8), KeyType.PrivateKey);
		byte[] decrypt2 = rsa.decrypt(encrypt2, KeyType.PublicKey);
		Assert.assertEquals("我是一段测试aaaa", StrUtil.str(decrypt2, CharsetUtil.CHARSET_UTF_8));
	}
}
