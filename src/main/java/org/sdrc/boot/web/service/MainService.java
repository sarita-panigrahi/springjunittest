package org.sdrc.boot.web.service;

import java.util.List;

import org.sdrc.boot.web.domain.MstUser;
import org.sdrc.boot.web.model.UserModel;
import org.springframework.dao.DataAccessException;

public interface MainService {

	List<MstUser> getUsers();

	MstUser saveUser(UserModel userModel);

	UserModel findActiveUserById(Integer userId) throws DataAccessException;

	MstUser findByName(String userName) throws DataAccessException;

}
