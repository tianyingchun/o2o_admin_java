package controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SecurityController extends BaseController {
	// Login form
	@RequestMapping("/login")
	public String login(Model model,@RequestParam(value="error", required=false) boolean error) {
		if (error) {
			model.addAttribute("loginError", true);
		}
		return "login";
	}
	@RequestMapping("/logout")
	public String logout() {
		return "login";
	}
	// Login form with error
	@RequestMapping("/login-error")
	public String loginError(Model model) {
		model.addAttribute("loginError", true);
		return "login";
	}

	/** Error page. */
	@RequestMapping("/error")
	public String error(HttpServletRequest request, Model model) {
		model.addAttribute(
				"errorCode",
				"Error "
						+ request
								.getAttribute("javax.servlet.error.status_code"));
		Throwable throwable = (Throwable) request
				.getAttribute("javax.servlet.error.exception");
		StringBuilder errorMessage = new StringBuilder();
		errorMessage.append("<ul>");
		while (throwable != null) {
			errorMessage.append("<li>")
					.append(escapeTags(throwable.getMessage())).append("</li>");
			throwable = throwable.getCause();
		}
		errorMessage.append("</ul>");
		model.addAttribute("errorMessage", errorMessage.toString());
		return "error";
	}

	/** Substitute 'less than' and 'greater than' symbols by its HTML entities. */
	private String escapeTags(String text) {
		if (text == null) {
			return null;
		}
		return text.replaceAll("<", "&lt;").replaceAll(">", "&gt;");
	}
}
