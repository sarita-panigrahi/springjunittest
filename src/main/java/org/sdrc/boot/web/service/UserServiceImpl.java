package org.sdrc.boot.web.service;

import org.sdrc.boot.web.domain.MstUser;
import org.sdrc.boot.web.model.UserModel;
import org.sdrc.boot.web.repository.MstUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private MstUserRepository mstUserRepository;

	@Override
	public UserModel findByUserNameAndPassword(String userName, String password) {

		MstUser mstUser = mstUserRepository.findByUserNameAndPassword(userName, password);

		if(null!=mstUser){
			UserModel user = new UserModel();
			user.setUserID(mstUser.getUserID());
			user.setPassword(mstUser.getPassword());
			user.setUserFirstName(mstUser.getUserFirstName());
			user.setUserName(mstUser.getUserName());
			return user;
		}
		else
			return null;
		
	}
}
