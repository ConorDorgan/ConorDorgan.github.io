/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import dao.ProductDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import model.Product;


/**
 *
 * @author BEmerson
 */
public class DBCreationRunner extends HttpServlet{

    @Override
    public void init() throws ServletException {
        super.init();
        SetupDb sdb = new SetupDb();
        
        sdb.createTables();
        ImageUploader img = new ImageUploader();
        try {
            img.insert();
        } catch (SQLException | IOException ex) {
            Logger.getLogger(DBCreationRunner.class.getName()).log(Level.SEVERE, null, ex);
        }
        sdb.insertSetupData(); //To change body of generated methods, choose Tools | Templates.
        sdb.showData();// Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
        
    }


    
    
    
      
  

}
