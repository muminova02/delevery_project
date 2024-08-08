package uz.doublem.delevery_for_exam.contrloller.utilConfig;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import uz.doublem.delevery_for_exam.entity.Role;
import uz.doublem.delevery_for_exam.entity.Users;
import uz.doublem.delevery_for_exam.repository.UserRepository;


import java.io.IOException;
import java.util.Base64;
import java.util.Optional;

import static uz.doublem.delevery_for_exam.contrloller.utilConfig.Utils.getCookie;

@WebFilter("/*")
public class Config implements Filter {
    UserRepository userRepository = UserRepository.getInstance();

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;

        Cookie identity = getCookie(req, "identity");
        if (req.getRequestURI().contains("/admin") ) {
            if (identity != null){
                Optional<Users> optionalUser = userRepository.getUserById(new String(Base64.getDecoder().decode(identity.getValue().getBytes())));
                if (optionalUser.isPresent() && optionalUser.get().getRole().equals(Role.ADMIN)) {
                    filterChain.doFilter(servletRequest, servletResponse);
                    return;
                }
            }

            throw new RuntimeException("401 unauthorized");
        }
        System.out.println("here is users ip => " + servletRequest.getRemoteAddr());
        System.out.println(req.getRequestURI());
        System.out.println("-------------");
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
