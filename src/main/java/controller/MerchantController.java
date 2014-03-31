package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/merchant")
public class MerchantController extends BaseController {

	@RequestMapping(method = RequestMethod.GET, value = "/index")
	public String index() {
		return "merchant/index";
	}
	@RequestMapping(method = RequestMethod.GET, value = "/create")
	public String creat() {
		return "merchant/create";
	}
	@RequestMapping(method = RequestMethod.GET, value = "/publishedproducts")
	public String published() {
		return "merchant/publishedproducts";
	}
	@RequestMapping(method = RequestMethod.GET, value = "/deletedproducts")
	public String deleted() {
		return "merchant/deletedproducts";
	}

}
