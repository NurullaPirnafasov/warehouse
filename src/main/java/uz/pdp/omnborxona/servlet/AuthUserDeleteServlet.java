package uz.pdp.omnborxona.servlet;

import jakarta.inject.Inject;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import uz.pdp.omnborxona.service.AuthUserService;

import java.io.IOException;

@WebServlet("/auth-users/delete")
public class AuthUserDeleteServlet extends HttpServlet {
    @Inject
    private AuthUserService service;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        service.delete(req.getParameter("id"));
        resp.sendRedirect(req.getContextPath() + "/auth-users");
    }
}
