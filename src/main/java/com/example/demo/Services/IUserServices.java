package com.example.demo.Services;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.demo.model.APFUSER;
@Component
public interface IUserServices {

	List<String> getEcranOfUser(String login);
	
	 APFUSER  searchUserBylogin(String userlogin);

}
