package controllers;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ProductDAO;
import helper.DBHelper;
import models.Product;

@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ProductServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductDAO productDao = new ProductDAO();
//		List<Product> products = productDao.getAllProducts();
//		HttpSession session = request.getSession();
//		session.setAttribute("products", products);
//		request.getRequestDispatcher("/index.jsp").forward(request, response);

//		int id = Integer.parseInt(request.getParameter("id"));
//		Product product = productDao.getSingleProduct(id);
//		response.getWriter().write("Name : " + product.getName() + ", Image : " + product.getImage());
		
//		boolean bol = productDao.deleteProductById(1301);
//		if (bol) {
//			response.getWriter().write("Delete successful");
//		} else {
//			response.getWriter().write("Delete failed");
//		}
		
		String description = "The iPhone 15 represents the latest evolution in Apple's iconic smartphone lineup, blending cutting-edge technology with sleek design to deliver an unparalleled user experience. Here’s an overview of its key features:\r\n"
				+ "\r\n"
				+ "Design and Build\r\n"
				+ "Materials: The iPhone 15 features a premium construction with aerospace-grade aluminum edges and a ceramic shield front cover, providing enhanced durability and a refined look.\r\n"
				+ "Colors: Available in an array of new colors, including Midnight Black, Starlight White, Blue Mist, Sunset Gold, and Forest Green.\r\n"
				+ "Display: It boasts a stunning 6.1-inch Super Retina XDR display with ProMotion technology, offering a 120Hz refresh rate for smoother scrolling and more responsive touch interactions.";
		String image = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRok4C4EzP8aHCxrf4SQm93SsIlcmqX6tytGg&s";
		
//		ADD NEW PRODUCT
//		Product product = new Product(5, 1000, "Iphone 15", description, image);
//		boolean bol = productDao.storeProduct(product);
//		if (bol) {
//			response.getWriter().write("Product added successful");
//		} else {
//			response.getWriter().write("Product add failed");
//		}
		
//		UPDATE PRODUCT
		Product product = new Product(1301, 8, 999, "Iphone 15 Pro", description, image);
		boolean bol = productDao.updateProduct(product);
		if (bol) {
			response.getWriter().write("Product update successful");
		} else {
			response.getWriter().write("Product update failed");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
