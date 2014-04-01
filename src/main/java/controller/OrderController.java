package controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/merchant")
public class OrderController extends BaseController{
	@RequestMapping(method = RequestMethod.GET, value = "/orderlist")
	public String orderlist() {
		return "merchant/orderlist";
	}
}	
