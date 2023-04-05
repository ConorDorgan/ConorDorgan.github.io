/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;
import com.sun.source.tree.Tree;
import dao.ProductDAO;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Product;
import service.ProductService;

/**
 *
 * @author WinUser
 */
public class FilterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        
         ProductDAO pdao = new ProductDAO();
         ArrayList<String> entries = pdao.getDistinctTypes();
        
        String[] selectedCategories = request.getParameterValues("category");
        if (selectedCategories == null){
             
        ArrayList<Product> topProducts = pdao.getTopProducts();
       
        request.setAttribute("entries", entries);
        request.setAttribute("products", topProducts);
        request.getRequestDispatcher("/products.jsp").forward(request, response);
        
        }else{
        ProductService pServ = new ProductService();
        ArrayList<Product> topProducts = pServ.gettype(selectedCategories);
       
        request.setAttribute("entries", entries);
        request.setAttribute("products", topProducts);
        request.getRequestDispatcher("/products.jsp").forward(request, response);
        }
}


}
