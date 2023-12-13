/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ta;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 *
 * @author Muhammad Heriyanto
 */
public class Koneksi {
    public static Connection con;
    
    public static Statement stn;
    
    public void koneksimysql(){
        try{
            String url = "jdbc:mysql://localhost:3306/jajanan_buely";
            
            String user = "root";
            
            String psw = "";
            
            Class.forName("com.mysql.jdbc.Driver");
            
            con = (Connection) DriverManager.getConnection(url, user, psw);
            
            stn = (Statement) con.createStatement();
            
            System.out.println("terhubung");
            
        }
        catch (Exception e){
            System.out.println("Koneksi Gagal" );
        }
        
    }
    
    public static void main(String arga[]){
        
        }
    }
    

