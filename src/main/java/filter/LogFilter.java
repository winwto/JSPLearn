package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(filterName = "log", urlPatterns = "/*")
public class LogFilter implements Filter {

    private FilterConfig filterConfig;
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        ServletContext servletContext = this.filterConfig.getServletContext();
        long before = System.currentTimeMillis();
        System.out.println("开始过滤...");
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        System.out.println("Filter已经截获到用户请求的URL" + httpServletRequest.getServletPath());

        filterChain.doFilter(servletRequest,servletResponse);

        long after = System.currentTimeMillis();
        System.out.println("过滤结束");
        System.out.println("请求被定位到" + httpServletRequest.getRequestURI() + "所花时间为：" + (after - before));
    }

    public void destroy() {
        this.filterConfig = null;
    }
}
