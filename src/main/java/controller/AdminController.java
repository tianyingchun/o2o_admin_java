package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Controller
@RequestMapping("/admin")
// maps to the /admin/* request URL
public class AdminController extends BaseController {
	@RequestMapping(method = RequestMethod.GET, value = {"","/index**"})
	public String index() {
		return "admin/index";
	}
	@RequestMapping(method = RequestMethod.GET, value = "/merchant/list")
	public String merchantList() {
		return "admin/index";
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/merchant/edit")
	public String merchantEdit(){
		return "admin/merchantedit";
	}
	@RequestMapping(method = RequestMethod.GET, value = "/merchant/create")
	public String merchantAdd(){
		return "admin/merchantcreate";
	}
	@RequestMapping(method = RequestMethod.GET, value = "/login")
	public String merchantLogin(){
		return "admin/login";
	}
}
