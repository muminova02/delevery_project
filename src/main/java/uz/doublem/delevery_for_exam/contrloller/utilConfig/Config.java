package uz.doublem.delevery_for_exam.contrloller.utilConfig;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import uz.doublem.delevery_for_exam.entity.Role;
import uz.doublem.delevery_for_exam.entity.Users;
import uz.doublem.delevery_for_exam.repository.UserRepository;

import java.io.IOException;
import java.util.Optional;

@WebFilter("/*")
public class Config implements Filter {
    UserRepository userRepository = UserRepository.getInstance();

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        String requestURI = req.getRequestURI();

        HttpSession session = req.getSession();

        String userId = (String) session.getAttribute("userId");

        if (userId == null) {
            if (!requestURI.contains("/user/")||requestURI.contains("/auth/")) {
                filterChain.doFilter(servletRequest, servletResponse);
            }else {
                req.setAttribute("exists",false);
                req.setAttribute("message","Iltimos avval ro'yxatdan o'tsangiz");
                req.getRequestDispatcher("/views/authPage.jsp").forward(servletRequest, servletResponse);
            }
            return;
        }

        Optional<Users> optionalUser = userRepository.getUserById(userId);
        if (optionalUser.isPresent()) {
            Users user = optionalUser.get();
            Context.setUser(user);
            if (requestURI.contains("/admin")) {
                if (user.getRole().equals(Role.ADMIN)) {
                    filterChain.doFilter(servletRequest, servletResponse);
                    return;
                }
            } else {
                filterChain.doFilter(servletRequest, servletResponse);
                return;
            }
        }
        req.setAttribute("message","something went wrong with credentials");
        req.getRequestDispatcher("/views/error-page.jsp").forward(servletRequest, servletResponse);
    }
}
