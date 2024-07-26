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
		
		boolean bol = productDao.deleteProductById(1301);
		if (bol) {
			response.getWriter().write("Delete successful");
		} else {
			response.getWriter().write("Delete failed");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
