package mk.ukim.finki.dianswineryappwip.web.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mk.ukim.finki.dianswineryappwip.model.User;
import mk.ukim.finki.dianswineryappwip.service.AuthService;

import java.io.IOException;

@WebFilter
public class LoginFilter implements Filter {
    private final AuthService authService;

    public LoginFilter(AuthService authService) {
        this.authService = authService;
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
        authService.register("wm", "wm123", "wm123", "Wine", "Mapper");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        User user = (User) request.getSession().getAttribute("user");
        String path = request.getServletPath();

        if (!"/login".equals(path)
                && !"/register".equals(path)
                && !path.endsWith(".css")
                && user == null) {
            response.sendRedirect("/login");
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }

    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
