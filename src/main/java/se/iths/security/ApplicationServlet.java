package se.iths.security;

import javax.inject.Inject;
import javax.security.enterprise.SecurityContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@ServletSecurity(@HttpConstraint(rolesAllowed = "user"))
@WebServlet("/app")
public class ApplicationServlet extends HttpServlet {

    @Inject
    SecurityContext securityContext;

    public ApplicationServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.getWriter().append("Welcome to the application, ")
                .append(securityContext.getCallerPrincipal().getName());
    }
}
