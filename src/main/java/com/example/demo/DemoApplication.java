package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.security.KeyStore;
import java.security.cert.Certificate;
import java.security.PrivateKey;

@SpringBootApplication
@RestController
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@RequestMapping("/")
	String sayHello() {
		try {
		KeyStore ks = KeyStore.getInstance("Windows-MY");
        ks.load(null, null); 
        Certificate cert = ks.getCertificate("contoso.net");
        PrivateKey privKey = (PrivateKey) ks.getKey("contoso.net", ("1234").toCharArray());
		return privKey.toString();
		} catch (Exception e)
		{
		  return e.toString();
		}
	}
}
