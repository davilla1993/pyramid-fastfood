package test;

import com.fastfood.security.HashGenerationException;
import com.fastfood.security.HashGeneratorUtils;

public class HashPasswordTest {

	public static void main(String[] args) throws HashGenerationException {
		
		String pwd = "test";
		String password = HashGeneratorUtils.generateSHA256(pwd);
		System.out.println(password);
	}

}
