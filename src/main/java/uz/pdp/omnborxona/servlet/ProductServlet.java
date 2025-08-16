package uz.pdp.omnborxona.servlet;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import uz.pdp.omnborxona.model.dto.ProductCreateDto;
import uz.pdp.omnborxona.model.dto.ProductDto;
import uz.pdp.omnborxona.model.dto.ProductUpdateDto;
import uz.pdp.omnborxona.model.entity.Product;
import uz.pdp.omnborxona.service.ProductService;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

@WebServlet("/product")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB threshold
        maxFileSize = 1024 * 1024 * 10,      // 10MB max file size
        maxRequestSize = 1024 * 1024 * 50)   // 50MB max request size
public class ProductServlet extends HttpServlet {

    @Inject
    private ProductService service; // ProductService'ni inyeksiya qilish

    // Uploads jildining yo'li
    private static final String UPLOAD_DIR = "uploads";
    private String getUploadPath(HttpServletRequest req) {
        // Serverdagi uploads jildining to'liq yo'lini olish
        return req.getServletContext().getRealPath("") + File.separator + UPLOAD_DIR;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String action = req.getParameter("action"); // Action parametrini olish
            String id = req.getParameter("id"); // ID parametrini olish

            if ("add".equals(action)) {
                // Yangi mahsulot qo'shish sahifasini ochish
                req.getRequestDispatcher("/product/add.jsp").forward(req, resp);
            } else if ("update".equals(action) && id != null) {
                // Mahsulotni yangilash sahifasini ochish
                ProductDto product = service.get(id);
                if (product == null) {
                    req.setAttribute("error", "Product with ID " + id + " not found");
                    req.getRequestDispatcher("/product/error.jsp").forward(req, resp);
                    return;
                }
                req.setAttribute("product", product);
                req.getRequestDispatcher("/product/update.jsp").forward(req, resp);
            } else if ("delete".equals(action) && id != null) {
                // Mahsulotni o'chirish
                try {
                    service.delete(id);
                } catch (Exception e) {
                    req.setAttribute("error", "Failed to delete product: " + e.getMessage());
                    req.getRequestDispatcher("/product/error.jsp").forward(req, resp);
                    return;
                }
                resp.sendRedirect("/product");
            } else if (id != null) {
                // Bitta mahsulot ma'lumotlarini ko'rsatish
                ProductDto product = service.get(id);
                if (product == null) {
                    req.setAttribute("error", "Product with ID " + id + " not found");
                    req.getRequestDispatcher("/product/error.jsp").forward(req, resp);
                    return;
                }
                req.setAttribute("product", product);
                req.getRequestDispatcher("/product/info.jsp").forward(req, resp);
            } else {
                // Barcha mahsulotlarni ro'yxat sifatida ko'rsatish
                List<ProductDto> products = service.getAll();
                req.setAttribute("products", products);
                req.getRequestDispatcher("/product/list.jsp").forward(req, resp);
            }
        } catch (Exception e) {
            req.setAttribute("error", "An error occurred: " + e.getMessage());
            req.getRequestDispatcher("/product/error.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String action = req.getParameter("action");

            // Uploads jildini yaratish
            String uploadPath = getUploadPath(req);
            File uploadDir = new File(uploadPath);
            if (!uploadDir.exists()) {
                uploadDir.mkdirs(); // Jild yo'q bo'lsa, yaratish
            }

            if ("add".equals(action)) {
                // Yangi mahsulot qo'shish
                ProductCreateDto dto = new ProductCreateDto();
                dto.setName(req.getParameter("name"));
                dto.setDescription(req.getParameter("description"));
                try {
                    dto.setPrice(Double.parseDouble(req.getParameter("price")));
                } catch (NumberFormatException e) {
                    throw new ServletException("Invalid price format");
                }
                try {
                    dto.setQuantity(Integer.parseInt(req.getParameter("quantity")));
                } catch (NumberFormatException e) {
                    throw new ServletException("Invalid quantity format");
                }
                dto.setWarehouseId(req.getParameter("warehouseId"));
                dto.setCategoryId(req.getParameter("categoryId"));

                // Rasm faylini qayta ishlash
                Part filePart = req.getPart("image"); // Faylni olish
                if (filePart != null && filePart.getSize() > 0) {
                    String fileName = UUID.randomUUID().toString() + "_" + Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
                    String filePath = uploadPath + File.separator + fileName;
                    filePart.write(filePath); // Faylni serverga saqlash
                    dto.setImage("/" + UPLOAD_DIR + "/" + fileName); // Yo'lni DTO'ga o'rnatish
                }

                service.create(dto); // Service orqali saqlash
                resp.sendRedirect("/product");
            } else if ("update".equals(action)) {
                // Mahsulotni yangilash
                String id = req.getParameter("id");
                ProductUpdateDto dto = new ProductUpdateDto();
                dto.setName(req.getParameter("name"));
                dto.setDescription(req.getParameter("description"));
                try {
                    dto.setPrice(Double.parseDouble(req.getParameter("price")));
                } catch (NumberFormatException e) {
                    throw new ServletException("Invalid price format");
                }
                try {
                    dto.setQuantity(Integer.parseInt(req.getParameter("quantity")));
                } catch (NumberFormatException e) {
                    throw new ServletException("Invalid quantity format");
                }
                dto.setWarehouseId(req.getParameter("warehouseId"));
                dto.setCategoryId(req.getParameter("categoryId"));

                // Rasm faylini qayta ishlash
                Part filePart = req.getPart("image");
                if (filePart != null && filePart.getSize() > 0) {
                    String fileName = UUID.randomUUID().toString() + "_" + Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
                    String filePath = uploadPath + File.separator + fileName;
                    filePart.write(filePath);
                    dto.setImage("/" + UPLOAD_DIR + "/" + fileName);
                } else {
                    // Agar yangi rasm yuklanmasa, eski rasm yo'lini saqlash
                    ProductDto existing = service.get(id);
                    dto.setImage(existing.getImage());
                }

                service.update(dto, id); // Service orqali yangilash
                resp.sendRedirect("/product");
            } else {
                req.setAttribute("error", "Invalid action specified");
                req.getRequestDispatcher("/product/error.jsp").forward(req, resp);
            }
        } catch (Exception e) {
            req.setAttribute("error", "An error occurred: " + e.getMessage());
            req.getRequestDispatcher("/product/error.jsp").forward(req, resp);
        }
    }
}



