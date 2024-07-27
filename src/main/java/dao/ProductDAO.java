package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import helper.DBHelper;
import models.Product;

public class ProductDAO {
	public List<Product> getAllProducts() {
		List<Product> products = new ArrayList<>();

		String query = "SELECT * FROM products LIMIT 100";
		Connection con = DBHelper.getInstance().getConn();
		PreparedStatement stmt = null;
		ResultSet set = null;

		try {
			stmt = con.prepareStatement(query);
			set = stmt.executeQuery();
			while (set.next()) {
				products.add(new Product(set.getInt("id"), set.getInt("cat_id"), set.getInt("price"),
						set.getString("name"), set.getString("description"), set.getString("image")));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DBHelper.closeConn(con, stmt, set);

		return products;
	}

	public Product getSingleProduct(int id) {
		Product product = null;

		String query = "SELECT * FROM products WHERE id = ?";
		Connection con = DBHelper.getInstance().getConn();
		PreparedStatement stmt = null;
		ResultSet set = null;

		try {
			stmt = con.prepareStatement(query);
			stmt.setInt(1, id);
			set = stmt.executeQuery();
			while (set.next()) {
				product = new Product(set.getInt("id"), set.getInt("cat_id"), set.getInt("price"),
						set.getString("name"), set.getString("description"), set.getString("image"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DBHelper.closeConn(con, stmt, set);
		return product;
	}
	
	public boolean deleteProductById(int id) {
		Boolean bol = false;
		String query = "DELETE FROM products WHERE id = ?";
		Connection con = DBHelper.getInstance().getConn();
		PreparedStatement stmt = null;
		
		try {
			stmt = con.prepareStatement(query);
			stmt.setInt(1, id);
			int result = stmt.executeUpdate();
			if (result == 1) {
				bol = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DBHelper.closeConn(con, stmt);
		return bol;
	}
	
	public boolean storeProduct(Product product) {
		boolean bol = false;
		String query = "INSERT INTO products (cat_id, price, name, description, image) VALUES (?, ?, ?, ?, ?)";
		Connection con = DBHelper.getInstance().getConn();
		PreparedStatement stmt = null;
		
		try {
			stmt = con.prepareStatement(query);
			stmt.setInt(1, product.getCat_id());
			stmt.setInt(2, product.getPrice());
			stmt.setString(3, product.getName());
			stmt.setString(4, product.getDescription());
			stmt.setString(5, product.getImage());
			int result = stmt.executeUpdate();
			if (result == 1) {
				bol = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBHelper.closeConn(con, stmt);
		return bol;
	}
	
	public boolean updateProduct(Product product) {
		boolean bol = false;
		String query = "UPDATE products SET cat_id = ?, price = ?, name = ?, description = ?, image = ? WHERE id = ?";
		Connection con = DBHelper.getInstance().getConn();
		PreparedStatement stmt = null;
		try {
			stmt = con.prepareStatement(query);
			stmt.setInt(1, product.getCat_id());
			stmt.setInt(2, product.getPrice());
			stmt.setString(3, product.getName());
			stmt.setString(4, product.getDescription());
			stmt.setString(5, product.getImage());
			stmt.setInt(6, product.getId());
			int result = stmt.executeUpdate();
			if (result == 1) {
				bol = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBHelper.closeConn(con, stmt);
		return bol;
	}
}
