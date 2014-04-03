package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import vm.MerchantInfo;

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

	@RequestMapping(method = RequestMethod.GET, value = "/edit")
	public String edit() {
		return "merchant/edit";
	}

	@RequestMapping(method = RequestMethod.GET, value = "/publishedproducts")
	public String published() {
		return "merchant/publishedproducts";
	}

	@RequestMapping(method = RequestMethod.GET, value = "/deletedproducts")
	public String deleted() {
		return "merchant/deletedproducts";
	}

	@RequestMapping(method = RequestMethod.GET, value = "/account/detail")
	public String accountDetail(Model model) {
		MerchantInfo merchantInfo = new MerchantInfo();
		merchantInfo.setName("merchant name");
		merchantInfo.setAddress("merchant address");
		merchantInfo.setEmail("merchant email");
		merchantInfo.setAppId("merchant appid");
		merchantInfo.setAppKey("merchant appkey");
		merchantInfo.setPublished(true);
				
		model.addAttribute("merchant", merchantInfo);
		return "merchant/accountdetail";
	}

}
