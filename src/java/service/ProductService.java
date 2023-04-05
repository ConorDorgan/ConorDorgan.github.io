/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.ProductDAO;
import dao.UserDAO;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Product;
import model.User;
import org.apache.tomcat.util.codec.binary.Base64;
import servlets.productgetter;
import utils.DBManager;

/**
 *
 * @author be_me
 */
public class ProductService {

  
    
    
public ArrayList<Product> gettype(String[] selectedCategories) throws UnsupportedEncodingException{
    ProductDAO pDao = new ProductDAO();
    return pDao.getByType(selectedCategories);
}
 
 
 
    
    //Get Specific Products
    public Product getProductByID(int prodid) throws UnsupportedEncodingException{
        
        Product prod = null;
        DBManager dm = new DBManager();
        Connection con = dm.getConnection();
        int productId = 0;
        String name = null;
        String description = null ;
        float price = 0;
        byte[] image = null;
        String category = null;
        String query = "SELECT * FROM PRODUCTS WHERE PRODUCT_ID_ID =" + prodid ;
        
        try {
            PreparedStatement stmt = con.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
          
            while (rs.next()) {
            
                 productId = (rs.getInt(1));
                name = (rs.getString(2));
                description = (rs.getString(3));
                price = (rs.getFloat(4));
                image = (rs.getBytes(5));
                category = (rs.getString(6));
                Product product = new Product();
                product.setId(productId);
                product.setName(name);
                product.setDescription(description);
                product.setPrice(price);
                product.setImage(image);
                product.setCategory(category);
                byte[] encodeBase64 = Base64.encodeBase64(image);
                String base64Encoded = new String(encodeBase64, "UTF-8");
                product.setBase64EncodedImage(base64Encoded);
                prod = product;

            }
       
        }   catch (SQLException ex) {
                Logger.getLogger(productgetter.class.getName()).log(Level.SEVERE, null, ex);
            }
        return prod;
    
        
    
}
    
    
    
    
    public void deleteProduct(int productId){
        ProductDAO pDao = new ProductDAO();
        pDao.deleteProduct(productId);
        return;
        
    }
}
    
