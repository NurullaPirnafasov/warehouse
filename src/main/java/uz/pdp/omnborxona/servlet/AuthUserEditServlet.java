package uz.pdp.omnborxona.servlet;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import uz.pdp.omnborxona.model.dto.AuthUserUpdateDto;
import uz.pdp.omnborxona.service.AuthUserService;

import java.io.IOException;

@WebServlet("/auth-users/edit")
public class AuthUserEditServlet extends HttpServlet {
    @Inject
    private AuthUserService service;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        req.setAttribute("user", service.get(id));
        req.getRequestDispatcher("/auth-user/edit.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        AuthUserUpdateDto dto = new AuthUserUpdateDto(
                req.getParameter("id"),
                req.getParameter("username"),
                req.getParameter("password"),
                req.getParameter("firstName"),
                req.getParameter("lastName"),
                Boolean.parseBoolean(req.getParameter("superAdmin")),
                req.getParameter("phone"),
                req.getParameter("imageUrl"),
                req.getParameter("warehouseId")
        );
        service.update(dto, dto.getId());
        resp.sendRedirect(req.getContextPath() + "/auth-users");
    }
}
