package org.sdrc.boot.web.repository;

import org.sdrc.boot.web.domain.MstUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MstUserRepository extends JpaRepository<MstUser, Long>  {
	
	MstUser findByUserName(String userName);
	
	MstUser  findByUserNameAndPassword(String userName, String password);
}
