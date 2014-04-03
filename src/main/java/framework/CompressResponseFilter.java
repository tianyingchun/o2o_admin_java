package framework;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import com.googlecode.htmlcompressor.compressor.HtmlCompressor;

@WebFilter(filterName = "CompressResponseFilter", urlPatterns = { "/merchant/*","/order/*","/admin/*" })
public class CompressResponseFilter implements Filter {
	private HtmlCompressor compressor;

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {

		CharResponseWrapper responseWrapper = new CharResponseWrapper(
				(HttpServletResponse) resp);

		chain.doFilter(req, responseWrapper);

		String servletResponse = new String(responseWrapper.toString());
		resp.getWriter().write(compressor.compress(servletResponse));
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		compressor = new HtmlCompressor();
		compressor.setCompressCss(true);
		compressor.setCompressJavaScript(true);
	}

	@Override
	public void destroy() {
	}

}
