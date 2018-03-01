package org.sdrc.boot.web.service;

import org.sdrc.boot.web.model.UserModel;
import org.springframework.dao.DataAccessException;

public interface UserService {

	UserModel findByUserNameAndPassword(String userName, String password) throws DataAccessException;

}
