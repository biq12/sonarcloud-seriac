package com.example.demo.Services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.Repository.APFUSERRepository;
import com.example.demo.model.APFUSER;
import com.example.demo.model.Apfecran;

@Component
public class ImplIuserServices implements IUserServices {
	@Autowired
	APFUSERRepository apfuserRepository;
	

	
	@Override
	public List<String> getEcranOfUser(String login) {
		APFUSER  entity=apfuserRepository.findByUserlogin(login);
		List<String> listEcrans=new ArrayList<>();
		Collection<Apfecran> list= entity.getScrens();
		for (Apfecran apfecran : list) {
			listEcrans.add(apfecran.getEcranname());
		}
		return listEcrans;
	}


	@Override
	public APFUSER searchUserBylogin(String userlogin) {
		APFUSER appUser=apfuserRepository.findByUserlogin(userlogin);
		return appUser;
	}

}
