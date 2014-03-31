package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/product")
public class ProductController extends BaseController {
	// root page for product controller.
	@RequestMapping(method = RequestMethod.GET, value = "")
	public String layout() {
		
		return "layout";
	}
	@RequestMapping(method = RequestMethod.GET, value = "/create")
	public String create() {
		return "product/create";
	}
	@RequestMapping(method = RequestMethod.GET, value = "/list")
	public String list() {
		return "product/list";
	}
	
}
