package uz.pdp.omnborxona.servlet;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import uz.pdp.omnborxona.model.dto.ProductCreateDto;
import uz.pdp.omnborxona.model.dto.ProductUpdateDto;
import uz.pdp.omnborxona.service.ProductService;

import java.io.IOException;

@WebServlet("/products")
public class ProductServlet extends HttpServlet {
    @Inject
    private ProductService service;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        if ("edit".equals(action)) {
            String id = req.getParameter("id");
            req.setAttribute("product", service.get(id));
            req.getRequestDispatcher("/product/edit.jsp").forward(req, resp);
        } else {
            req.setAttribute("products", service.getAll());
            req.getRequestDispatcher("/product/list.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String name = req.getParameter("name");
        String description = req.getParameter("description");
        Double price = Double.valueOf(req.getParameter("price"));
        String image = req.getParameter("image");
        Integer quantity = Integer.valueOf(req.getParameter("quantity"));
        String warehouseId = req.getParameter("warehouseId");
        String categoryId = req.getParameter("categoryId");

        ProductCreateDto dto = new ProductCreateDto();
        dto.setName(name);
        dto.setDescription(description);
        dto.setPrice(price);
        dto.setImage(image);
        dto.setQuantity(quantity);
        dto.setWarehouseId(warehouseId);
        dto.setCategoryId(categoryId);

        try {
            service.create(dto);
            resp.sendRedirect(req.getContextPath() + "/products");
        } catch (Exception e) {
            req.setAttribute("error", e.getMessage());
            req.getRequestDispatcher("/WEB-INF/views/product/create.jsp").forward(req, resp);
        }
    }
}
