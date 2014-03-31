package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
// @RequestMapping("/merchant/")
public class MerchantController extends BaseController {

	@RequestMapping(method = RequestMethod.GET, value = "/merchant/index")
	public String index() {
		return "merchant/index";
	}

	@ModelAttribute("who")
	@RequestMapping(method = RequestMethod.GET, value = "/merchant/hello")
	public String hello() {
		return "merchant/hello";
	}

}
