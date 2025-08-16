package uz.pdp.omnborxona.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import uz.pdp.omnborxona.model.dto.CategoryCreateDto;
import uz.pdp.omnborxona.model.dto.CategoryUpdateDto;
import uz.pdp.omnborxona.service.CategoryService;

import java.io.IOException;

@WebServlet("/categories")
public class CategoryServlet extends HttpServlet {

    private final CategoryService service = new CategoryService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if ("edit".equals(action)) {
            String id = req.getParameter("id");
            req.setAttribute("category", service.get(id));
            req.getRequestDispatcher("/category/edit.jsp").forward(req, resp);
        } else {
            req.setAttribute("categories", service.getAll());
            req.getRequestDispatcher("/category/list.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String action = req.getParameter("action");

        if ("create".equals(action)) {
            String name = req.getParameter("name");
            String description = req.getParameter("description");
            service.create(new CategoryCreateDto(name, description));
        } else if ("update".equals(action)) {
            String id = req.getParameter("id");
            String name = req.getParameter("name");
            String description = req.getParameter("description");
            service.update(new CategoryUpdateDto(id, name, description));
        } else if ("delete".equals(action)) {
            String id = req.getParameter("id");
            service.delete(id);
        }

        resp.sendRedirect("/categories");
    }
}
