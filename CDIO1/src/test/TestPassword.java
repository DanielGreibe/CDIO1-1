package test;

import static org.junit.Assert.*;
import data.UserDTO;

import org.junit.Test;

public class TestPassword {

	@Test
	public void test() {
		
		UserDTO dto = new UserDTO();
		UserDTO.passWord pass = dto.new passWord();
		
		System.out.println(pass.generatePassWord());
		
		
	}

}
