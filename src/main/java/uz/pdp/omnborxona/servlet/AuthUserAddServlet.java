package uz.pdp.omnborxona.servlet;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import uz.pdp.omnborxona.model.dto.AuthUserCreateDto;
import uz.pdp.omnborxona.service.AuthUserService;

import java.io.IOException;

@WebServlet("/auth-users/add")
public class AuthUserAddServlet extends HttpServlet {
    @Inject
    private AuthUserService service;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/auth-user/add.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        AuthUserCreateDto dto = new AuthUserCreateDto(
                req.getParameter("username"),
                req.getParameter("password"),
                req.getParameter("firstName"),
                req.getParameter("lastName"),
                Boolean.parseBoolean(req.getParameter("superAdmin")),
                req.getParameter("phone"),
                req.getParameter("imageUrl"),
                req.getParameter("warehouseId")
        );
        service.create(dto);
        resp.sendRedirect(req.getContextPath() + "/auth-users");
    }
}
