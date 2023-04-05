/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import jdk.internal.jimage.ImageLocation;
import model.Product;
import model.User;
import org.apache.tomcat.util.codec.binary.Base64;
import utils.DBManager;

/**
 *
 * @author be_me
 */
public class ProductDAO {
    
    /* Gets number of top products specified */
    /* we are gonna fake this one */
    public ArrayList<String> getDistinctTypes(){
       ArrayList<String> entries = new ArrayList<>();
        DBManager dm = new DBManager();
        Connection con = dm.getConnection();
        String query = "SELECT DISTINCT CATEGORY FROM PRODUCTS";
      try {
            PreparedStatement stmt = con.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String name = (rs.getString(1));
                entries.add(name);
                
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return entries;
        
    }
    public ArrayList<Product> getTopProducts() throws UnsupportedEncodingException{
        
        
        DBManager dm = new DBManager();
        Connection con = dm.getConnection();
        int productId = 0;
        String name = null;
        String description = null ;
        float price = 0;
        byte[] image = null;
        String category = null;
      

        ArrayList<Product> productData = new ArrayList();

        String query = "SELECT * FROM PRODUCTS";
        try {
            PreparedStatement stmt = con.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            int productCount = 0;
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
                productData.add(product);
                productCount++;
            }

        } catch (Exception e) {
            e.printStackTrace();
        } 

      
        return productData;
        
        
         
        
    }
    public ArrayList<Product> getAjaxProducts(String Query) throws UnsupportedEncodingException{
        
        if(Query == ""){
            return null;
        }
        DBManager dm = new DBManager();
        Connection con = dm.getConnection();
        int productId = 0;
        String name = null;
        String description = null ;
        float price = 0;
        byte[] image = null;
        String category = null;

        ArrayList<Product> productData = new ArrayList();

        String query = "SELECT * FROM PRODUCTS WHERE NAME LIKE ?";
        try {
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1, Query + "%");
            ResultSet rs = stmt.executeQuery();
            int productCount = 0;
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
                productData.add(product);
                productCount++;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

      
        return productData;
        
         
        
    }
    
    
 public ArrayList<Product> getByType(String[] selectedCategories) throws UnsupportedEncodingException {
    ArrayList<Product> producttypes = new ArrayList<>();
    DBManager dm = new DBManager();
        Connection con = dm.getConnection();
        int productId = 0;
        String name = null;
        String description = null ;
        float price = 0;
        byte[] image = null;
        String category = null;

    StringBuilder sb = new StringBuilder("SELECT * FROM PRODUCTS WHERE");
    for (int i = 0; i < selectedCategories.length; i++) {
        if (i == 0) {
            sb.append(" CATEGORY=?");
        } else {
            sb.append(" OR CATEGORY=?");
        }
    }

    try {
        PreparedStatement stmt = con.prepareStatement(sb.toString());
        for (int i = 0; i < selectedCategories.length; i++) {
            stmt.setString(i + 1, selectedCategories[i]);
        }

        ResultSet rs = stmt.executeQuery();
        int productCount = 0;
        while (rs.next()) {
            if (productCount >= 9)
                break;
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
                producttypes.add(product);
                productCount++;
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return producttypes;
}

  
  
  
  public void deleteProduct(int productId){
        
        DBManager dmbgr = new DBManager();
        Connection con = dmbgr.getConnection();
        Statement stmt = null;
        
        try {
        
            stmt = con.createStatement();
            String sql = String.format("DELETE FROM PRODUCTS WHERE PRODUCT_ID_ID=%d",productId);
            stmt.executeUpdate(sql);
        }
        catch (SQLException e){
            e.printStackTrace();
         }finally {
            try {
                stmt.close();
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
    }

    
    
    
    
}
