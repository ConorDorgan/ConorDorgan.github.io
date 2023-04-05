package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ImageUploader {

void insert() throws SQLException, FileNotFoundException, IOException{
            
    DBManager dmbgr = new DBManager();

        Connection con = dmbgr.getConnection();
       
            String insertSql = "INSERT INTO PRODUCTS(NAME,DESCRIPTION,PRICE,IMAGE_LOCATION,CATEGORY) VALUES(?,?,?,?,?)";
            PreparedStatement stmt = con.prepareStatement(insertSql);

            // Example image file paths
            String[] imageFilePaths = {"C:\\Users\\WinUser\\Desktop\\javaprojectworking\\waaaaaaa\\images\\goldpen.png", "C:\\Users\\WinUser\\Desktop\\javaprojectworking\\waaaaaaa\\images\\bic20pack.jpg",
                "C:\\Users\\WinUser\\Desktop\\javaprojectworking\\waaaaaaa\\images\\bicblack.png", "C:\\Users\\WinUser\\Desktop\\javaprojectworking\\waaaaaaa\\images\\smartnotebook.png", "C:\\Users\\WinUser\\Desktop\\javaprojectworking\\waaaaaaa\\images\\a5notepad.png",
                "C:\\Users\\WinUser\\Desktop\\javaprojectworking\\waaaaaaa\\images\\3packa4.png", "C:\\Users\\WinUser\\Desktop\\javaprojectworking\\waaaaaaa\\images\\dualhighlighter.png", "C:\\Users\\WinUser\\Desktop\\javaprojectworking\\waaaaaaa\\images\\4packhigh.png",
                "C:\\Users\\WinUser\\Desktop\\javaprojectworking\\waaaaaaa\\images\\griphigh.png"};

            // Example product details
            String[] names = {"Tech 2 Silver Ballpoint Pen", "BIC Multicolour 20pk Pens", "BIC Black Ballpoint Pen 5 Pack",
                "Huion Note", "Q-Connect Spiral Pad", "Black n Red A4", "BIC Intensity Dual Highlighter", "Niceday HC1-5",
                "BIC Grip Highlighter"};
            String[] descriptions = {"High quality metal tipped fountain pen with optimised ink flow of office work",
                "BIC multicolour pens in a 20 pack best selling pen amoungst students and creatives alike",
                "The classic BIC Cristal Original pen is the worlds best-selling ballpoint pen",
                "A smart notebook to digitalize your handwriting. Great for note-taking and sketching.",
                "Executive A5 - 160 Pages, 80 Leaves, Ruled Feint And Margin",
                "Wirebound Project Book Polypropylene Cover 200 pages Pack 3",
                "Pastel Assorted Felt Tip 0.8 mm Pack of 6 with varying colours",
                "Highlighter Yellow Broad Chisel 1-5 mm Pack of 4",
                "Assorted Bright & Pastel Medium Chisel Pack of 12"};
            double[] prices = {11.99, 5.99, 3.99, 124.99, 16.99, 40.99, 7.99, 2.99, 17.99};
            String[] categories = {"Pen", "Pen", "Pen", "Notepad", "Notepad", "Notepad", "Highlighter", "Highlighter",
                "Highlighter"};

            for (int i = 0; i < imageFilePaths.length; i++) {
                File imageFile = new File(imageFilePaths[i]);
                FileInputStream fis = new FileInputStream(imageFile);
                stmt.setString(1, names[i]);
                stmt.setString(2, descriptions[i]);
                stmt.setDouble(3, prices[i]);
                stmt.setBinaryStream(4, fis);
                stmt.setString(5, categories[i]);
                stmt.executeUpdate();
                fis.close();
            }

            System.out.println("Images uploaded successfully");

        }
}

   
                    
    

