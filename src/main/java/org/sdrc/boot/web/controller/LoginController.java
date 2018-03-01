package org.sdrc.boot.web.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.sdrc.boot.web.config.ConfigProperties;
import org.sdrc.boot.web.model.UserModel;
import org.sdrc.boot.web.service.UserService;
import org.sdrc.boot.web.util.StateManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.encoding.MessageDigestPasswordEncoder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * @author Sarita Panigrahi
 *
 */
@Controller
public class LoginController implements AuthenticationProvider {

	private final StateManager stateManager;

	@Autowired
	private MessageDigestPasswordEncoder passwordEncoder;

	@Autowired
	private UserService userService;

	@Autowired
	private ConfigProperties configProperties;

	@Autowired
	public LoginController(StateManager stateManager) {
		this.stateManager = stateManager;
	}

	@GetMapping("/login")
	public String authorize(HttpServletRequest request, RedirectAttributes redirectAttributes,
			@RequestParam("username") String username, @RequestParam("password") String password) {
		try {
			UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, password);
			token.setDetails(new WebAuthenticationDetails(request));
			Authentication authentication = this.authenticate(token);
			SecurityContextHolder.getContext().setAuthentication(authentication);
		} catch (BadCredentialsException e) {
			SecurityContextHolder.getContext().setAuthentication(null);
			redirectAttributes.addFlashAttribute("formError", configProperties.getInvalidCredentials());
			return "redirect:/";
		}

		redirectAttributes.addFlashAttribute("formSucess", configProperties.getValidCredentials());
		return "redirect:/";
	}

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {

		String encodedPassword = passwordEncoder.encodePassword(authentication.getName(),
				(String) authentication.getCredentials());
		UserModel userModel = userService.findByUserNameAndPassword(authentication.getName(), encodedPassword);

		if (userModel == null || !userModel.getPassword().equals(encodedPassword))
			throw new BadCredentialsException("Invalid User!");

		stateManager.setValue(configProperties.getUserPrincipal(), userModel);

		userModel = (UserModel) stateManager.getValue(configProperties.getUserPrincipal());
		stateManager.setValue(configProperties.getUserPrincipal(), userModel);

		return new UsernamePasswordAuthenticationToken(authentication.getName(),
				(String) authentication.getCredentials(), null);
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return false;
	}

	@GetMapping("/logout")
	public String logout(HttpServletRequest request, HttpServletResponse resp) throws ServletException {

		HttpSession session = request.getSession(false);
		if (session != null) {
			stateManager.setValue(configProperties.getUserPrincipal(), null);
			request.getSession().setAttribute(configProperties.getUserPrincipal(), null);
			request.getSession().invalidate();
			ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
			attr.getRequest().getSession(true).removeAttribute(configProperties.getUserPrincipal());
			attr.getRequest().getSession(true).invalidate();

			request.logout();

			return "redirect:/home?isLoggedIn=" + true;
		} else {
			request.getSession().invalidate();
			return "redirect:/";
		}
	}
}
