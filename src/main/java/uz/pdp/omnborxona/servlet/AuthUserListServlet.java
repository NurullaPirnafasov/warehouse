package uz.pdp.omnborxona.servlet;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import uz.pdp.omnborxona.service.AuthUserService;

import java.io.IOException;

@WebServlet("/auth-users")
public class AuthUserListServlet extends HttpServlet {
    @Inject
    private AuthUserService service;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("users", service.getAll());
        req.getRequestDispatcher("/auth-user/list.jsp").forward(req, resp);
    }
}
