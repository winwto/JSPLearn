package filter;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "authority", urlPatterns = "/login.jsp",
        initParams ={@WebInitParam(name="encoding", value = "GBK"),
                    @WebInitParam(name="loginPage", value = "/login.jsp"),
                    @WebInitParam(name="proLogin", value = "/proLogin.jsp")})
public class AuthorityFilter implements Filter {

    FilterConfig filterConfig;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String encoding = filterConfig.getInitParameter("encoding");
        String loginPage = filterConfig.getInitParameter("loginPage");
        String proLogin = filterConfig.getInitParameter("proLogin");
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        servletRequest.setCharacterEncoding(encoding);
        String requestPath = httpServletRequest.getServletPath();
        HttpSession httpSession = httpServletRequest.getSession(true);
        if(httpSession.getAttribute("user") == null && !requestPath.endsWith(loginPage) && !requestPath.endsWith(proLogin)){
            httpServletRequest.setAttribute("tip", "您还没有登录");
            httpServletRequest.getRequestDispatcher(loginPage).forward(servletRequest,servletResponse);
        } else {
            filterChain.doFilter(servletRequest,servletResponse);
        }
    }

    @Override
    public void destroy() {
        filterConfig = null;
    }
}
