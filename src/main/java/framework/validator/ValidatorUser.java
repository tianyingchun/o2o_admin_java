package framework.validator;

import java.io.IOException;

import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.validation.Validator;

import org.w3c.dom.ls.LSResourceResolver;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;

public class ValidatorUser extends Validator {
	@Override
	public ErrorHandler getErrorHandler() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LSResourceResolver getResourceResolver() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void reset() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setErrorHandler(ErrorHandler arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setResourceResolver(LSResourceResolver arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void validate(Source arg0, Result arg1) throws SAXException,
			IOException {
		// TODO Auto-generated method stub
		
	} 
}
