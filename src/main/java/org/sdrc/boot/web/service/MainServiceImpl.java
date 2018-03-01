package org.sdrc.boot.web.service;

import java.util.ArrayList;
import java.util.List;

import org.sdrc.boot.web.domain.MstUser;
import org.sdrc.boot.web.model.UserModel;
import org.sdrc.boot.web.repository.MstUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MainServiceImpl implements MainService {

	@Autowired
	private MstUserRepository mstUserRepository;

	@Override
	public List<MstUser> getUsers() {

		List<MstUser> userModels = new ArrayList<>();
		Iterable<MstUser> mstUsers = mstUserRepository.findAll();
		mstUsers.forEach(userModels::add);
		return userModels;
	}

	@Override
	@Transactional
	public MstUser saveUser(UserModel userModel) {

		MstUser mstuser = new MstUser();
		mstuser.setUserFirstName(userModel.getUserFirstName());
		mstuser.setUserName(userModel.getUserName());

		MstUser savedMstuser = mstUserRepository.save(mstuser);
		return savedMstuser;
	}

	@Override
	public UserModel findActiveUserById(Integer userId) throws DataAccessException {

		MstUser mst_User = mstUserRepository.findOne((long) userId);

		UserModel user = new UserModel();
		user.setUserID(mst_User.getUserID());
//		user.setPassword(mst_User.getPassword());
		user.setUserFirstName(mst_User.getUserFirstName());
//		user.setUserMiddleName(mst_User.getUserMiddleName());
//		user.setUserLastName(mst_User.getUserLastName());
//		user.setEmailID(mst_User.getEmailID());
//		user.setContactNumber(mst_User.getContactNumber());
		return user;
	}

	@Override
	public MstUser findByName(String userName) throws DataAccessException {

		MstUser mst_User = mstUserRepository.findByUserName(userName);

		return mst_User;
	}

}
