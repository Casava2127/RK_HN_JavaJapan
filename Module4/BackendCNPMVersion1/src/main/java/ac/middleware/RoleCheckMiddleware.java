package ac.middleware;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class RoleCheckMiddleware implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // Implement role checking logic here
        // For example, check if the user has the required role to access the resource
        String role = request.getHeader("Role"); // Example of getting role from request header

        if (role == null || !role.equals("ADMIN")) { // Replace "ADMIN" with the required role
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            return false; // User does not have permission
        }

        return true; // User has permission
    }
}