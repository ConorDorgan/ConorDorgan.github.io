/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import dao.ProductDAO;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.OutputStream;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import model.Product;
import model.User;
import service.ProductService;
import service.UserService;
import utils.DBManager;


@MultipartConfig
public class productAdminServlet extends HttpServlet {

   

   protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        String action = request.getParameter("action");
        ProductService pServ = new ProductService();
        ProductDAO pdao = new ProductDAO();
        String url = null;
        if (action == null) {
            action = "listProducts";
            
                
        }
        
        switch (action) {
            case "listProducts":
                ArrayList<Product> products = pdao.getTopProducts();
                setProductsAsAttribute(request, products);
                request.getRequestDispatcher("productAdmin.jsp").forward(request, response);
                break;
            case "add":
                request.getRequestDispatcher("addProduct.jsp").forward(request, response);
                break;
            case "delete":
                deleteProduct(request,response);
                products = pdao.getTopProducts();
                setProductsAsAttribute(request, products);
                request.getRequestDispatcher("productAdmin.jsp").forward(request, response);
                break;
            case "insertProduct":
                try {
            String imgpath = request.getParameter("file");
            Part filePart = request.getPart("file");  
            String fileName = getFileName(filePart);
            String name = request.getParameter("name");
            String description = request.getParameter("description");
            float price = Float.parseFloat(request.getParameter("price"));
            String category = request.getParameter("category");
            DBManager mngr = new DBManager();
            Connection con = mngr.getConnection(); 
            InputStream iptStream = filePart.getInputStream();
            PreparedStatement psmnt = null;

            psmnt = con.prepareStatement("insert into PRODUCTS(NAME,DESCRIPTION,PRICE,IMAGE_LOCATION,CATEGORY)" + "values(?,?,?,?,?)");

            psmnt.setString(1, name);
            psmnt.setString(2, description);
            psmnt.setFloat(3, price);
            psmnt.setBinaryStream(4, (InputStream) iptStream);
            psmnt.setString(5, category);
            int flag = psmnt.executeUpdate();
            
        } catch (IOException | NumberFormatException | SQLException | ServletException e) {
            out.print(e);
        }
                products = pdao.getTopProducts();
                setProductsAsAttribute(request, products);
                request.getRequestDispatcher("productAdmin.jsp").forward(request, response);
                break;
            case "updateCompleteProduct":
                try {
            String imgpath = request.getParameter("file");
            Part filePart = request.getPart("file");  
            String fileName = getFileName(filePart);
            int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            String description = request.getParameter("description");
            float price = Float.parseFloat(request.getParameter("price"));
            String category = request.getParameter("category");
            DBManager mngr = new DBManager();
            Connection con = mngr.getConnection(); 
            InputStream iptStream = filePart.getInputStream();
            PreparedStatement psmnt = null;

            psmnt = con.prepareStatement("UPDATE PRODUCTS SET NAME=?, DESCRIPTION=?, PRICE=?, IMAGE_LOCATION=?, CATEGORY=? WHERE PRODUCT_ID_ID=?");
            psmnt.setString(1, name);
            psmnt.setString(2, description);
            psmnt.setFloat(3, price);
            psmnt.setBinaryStream(4, iptStream);
            psmnt.setString(5, category);
            psmnt.setInt(6, id);
            
            int flag = psmnt.executeUpdate();
            
        } catch (Exception e) {
            out.print(e);
        }
                products = pdao.getTopProducts();
                setProductsAsAttribute(request, products);
                request.getRequestDispatcher("productAdmin.jsp").forward(request, response);
                break;
            case "edit":
                String productId = request.getParameter("id");
                if (productId == null) {
                    request.getRequestDispatcher("Home").forward(request, response);
                } else {
                    int pId = Integer.parseInt(productId);
                    pServ = new ProductService();
                    Product oldProduct = pServ.getProductByID(pId);
                    request.setAttribute("oldProduct", oldProduct);
                    request.getRequestDispatcher("editProduct.jsp").forward(request, response);
                }
                break;
            default:
                request.getRequestDispatcher("index.jsp").forward(request, response);
                break;
        }
}

private void setProductsAsAttribute(HttpServletRequest request, ArrayList<Product> products) {
    request.setAttribute("products", products);
}


    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       try {
           processRequest(request,response);
       } catch (SQLException ex) {
           Logger.getLogger(productAdminServlet.class.getName()).log(Level.SEVERE, null, ex);
       }
       
    }
private void insertProduct(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, SQLException{         
        try {
            String imgpath = request.getParameter("file");
            Part filePart = request.getPart("file");  
            String fileName = getFileName(filePart);
            String name = request.getParameter("name");
            String description = request.getParameter("description");
            float price = Float.parseFloat(request.getParameter("price"));
            String category = request.getParameter("category");
            DBManager mngr = new DBManager();
            Connection con = mngr.getConnection(); 
            InputStream iptStream = filePart.getInputStream();
            PreparedStatement psmnt = null;

            psmnt = con.prepareStatement("insert into PRODUCTS(NAME,DESCRIPTION,PRICE,IMAGE_LOCATION,CATEGORY)" + "values(?,?,?,?,?)");

            psmnt.setString(1, name);
            psmnt.setString(2, description);
            psmnt.setFloat(3, price);
            psmnt.setBinaryStream(4, (InputStream) iptStream);
            psmnt.setString(5, category);
            int flag = psmnt.executeUpdate();
            
        } catch (Exception e) {
            out.print(e);
        }
        
        
        
         
        
    }
    private String getFileName(final Part part) {  
        // get header(content-disposition) from the part  
        final String partHeader = part.getHeader("content-disposition");  
        
          
        // code to get file name from the header  
        for (String content : part.getHeader("content-disposition").split(";")) {  
            if (content.trim().startsWith("filename")) {  
                return content.substring(content.indexOf('=') + 1).trim().replace("\"", "");  
            }  
        }  
        // it will return null when it doesn't get file name in the header   
        return null; 
     }
    private void updateProduct(HttpServletRequest request, HttpServletResponse response){
        
        
        
        
        
    }
    
    private void deleteProduct(HttpServletRequest request, HttpServletResponse response){
        
        int productId = Integer.parseInt(request.getParameter("id"));
        ProductService pServ = new ProductService();
        pServ.deleteProduct(productId);
    
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       try {
           processRequest(request, response);
       } catch (SQLException ex) {
           Logger.getLogger(productAdminServlet.class.getName()).log(Level.SEVERE, null, ex);
       }
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
