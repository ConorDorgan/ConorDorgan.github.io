/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import utils.DBManager;

/**
 *
 * @author BEmerson
 */
@MultipartConfig
public class UploadServlet extends HttpServlet {

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
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

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
