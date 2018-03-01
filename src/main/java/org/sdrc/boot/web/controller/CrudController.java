package org.sdrc.boot.web.controller;

import java.util.List;

import org.sdrc.boot.web.domain.MstUser;
import org.sdrc.boot.web.model.UserModel;
import org.sdrc.boot.web.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CrudController {

	@Autowired
	private MainService mainService;

	@GetMapping("/getUsersView")
	public ModelAndView getUserView() {
		return new ModelAndView("userProfile.jsp");
	}

//	@GetMapping("/getUsers")
//	@ResponseBody
//	public ResponseEntity<List<MstUser>> getUsers() {
//
//		return ResponseEntity.ok().body(mainService.getUsers());
//	}
	
	@GetMapping("/getUsers")
	@ResponseBody public List<MstUser> getUsers() {
		return mainService.getUsers();
	}

	// with path variable
	@PostMapping(value = "/saveUser/{userName}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<MstUser> createByUserName(@PathVariable String userName) {

		UserModel userModel = new UserModel();
		userModel.setUserName(userName);
		userModel.setUserFirstName("Sarita");

		MstUser savedUserModel = mainService.saveUser(userModel);
		return ResponseEntity.ok().body(savedUserModel);
	}

	// with request param
	@PostMapping(value = "/saveUser", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<MstUser> create(@RequestParam("userName") String userName,
			@RequestParam("name") String name) {

		UserModel userModel = new UserModel();
		userModel.setUserName(userName);
		userModel.setUserFirstName(name);

		MstUser savedUserModel = mainService.saveUser(userModel);
		return ResponseEntity.ok().body(savedUserModel);
	}
}
