package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Controller
public class AdminController extends BaseController {
	@RequestMapping(method = RequestMethod.GET, value = "/admin")
	public String handleRequest() {
		return "welcome";
	}
}
