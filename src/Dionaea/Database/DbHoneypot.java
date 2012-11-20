/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Dionaea.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lap
 */
public class DbHoneypot {
     private String honeypotDp;
     private Connection conn;
     private Statement stat;
     
     public DbHoneypot(String s)
     {
         honeypotDp = s;
         try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:"+honeypotDp);
            stat = conn.createStatement();
         }catch (SQLException ex) {
            Logger.getLogger(DbMain.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DbMain.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
     }
     public ResultSet  resultOfConn()
    {
        try {
            ResultSet re = stat.executeQuery("select * from connections;");
            return re;
           
        } catch (SQLException ex) {
            Logger.getLogger(DbMain.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
     public ResultSet  resultOfConnDcerpcbinds()
    {
        try {
            ResultSet re = stat.executeQuery("select * from Dcerpcbinds;");
            return re;
           
        } catch (SQLException ex) {
            Logger.getLogger(DbMain.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public ResultSet dcerpcrequests ()
    {
        try {
            ResultSet re = stat.executeQuery("select * from dcerpcrequests;");
            return re;
           
        } catch (SQLException ex) {
            Logger.getLogger(DbMain.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public ResultSet downloads ()
    {
        try {
            ResultSet re = stat.executeQuery("select * from downloads;");
            return re;
           
        } catch (SQLException ex) {
            Logger.getLogger(DbMain.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public ResultSet offers ()
    {
        try {
            ResultSet re = stat.executeQuery("select connection ,offer_url  from offers where connection not in (select connection from downloads);");
            return re;
           
        } catch (SQLException ex) {
            Logger.getLogger(DbMain.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
     public ResultSet emuProfile ()
    {
        try {
            ResultSet re = stat.executeQuery("select * from emu_profiles;");
            return re;
           
        } catch (SQLException ex) {
            Logger.getLogger(DbMain.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
     
   public ResultSet emu_serivces()
    {
        try {
            ResultSet re = stat.executeQuery("select * from emu_services;");
            return re;
           
        } catch (SQLException ex) {
            Logger.getLogger(DbMain.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
   public ResultSet logins()
    {
        try {
            ResultSet re = stat.executeQuery("select * from logins;");
            return re;
           
        } catch (SQLException ex) {
            Logger.getLogger(DbMain.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
   
   public ResultSet mssql_command()
    {
        try {
            ResultSet re = stat.executeQuery("select * from mssql_commands;");
            return re;
           
        } catch (SQLException ex) {
            Logger.getLogger(DbMain.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
   
  public ResultSet mssql_fingerprint()
    {
        try {
            ResultSet re = stat.executeQuery("select * from mssql_fingerprints;");
            return re;
           
        } catch (SQLException ex) {
            Logger.getLogger(DbMain.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
  public ResultSet mysqlCommands()
    {
        try {
            ResultSet re = stat.executeQuery("select * from mysql_commands;");
            return re;
           
        } catch (SQLException ex) {
            Logger.getLogger(DbMain.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
  
  public ResultSet mysqlCommandsArgs()
    {
        try {
            ResultSet re = stat.executeQuery("select * from mysql_command_args;");
            return re;
           
        } catch (SQLException ex) {
            Logger.getLogger(DbMain.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
  
  public ResultSet p0fs()
    {
        try {
            ResultSet re = stat.executeQuery("select * from p0fs;");
            return re;
           
        } catch (SQLException ex) {
            Logger.getLogger(DbMain.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
  
  public ResultSet sip_commands()
    {
        try {
            ResultSet re = stat.executeQuery("select * from sip_commands;");
            return re;
           
        } catch (SQLException ex) {
            Logger.getLogger(DbMain.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
  
  public ResultSet sip_addrs()
    {
        try {
            ResultSet re = stat.executeQuery("select * from sip_addrs;");
            return re;
           
        } catch (SQLException ex) {
            Logger.getLogger(DbMain.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
  
  public ResultSet sip_sdp_connectiondatas()
    {
        try {
            ResultSet re = stat.executeQuery("select * from sip_sdp_connectiondatas;");
            return re;
           
        } catch (SQLException ex) {
            Logger.getLogger(DbMain.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
  
  public ResultSet sip_sdp_medias()
    {
        try {
            ResultSet re = stat.executeQuery("select * from sip_sdp_medias;");
            return re;
           
        } catch (SQLException ex) {
            Logger.getLogger(DbMain.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
  
  public ResultSet sip_sdp_origins()
    {
        try {
            ResultSet re = stat.executeQuery("select * from sip_sdp_origins;");
            return re;
           
        } catch (SQLException ex) {
            Logger.getLogger(DbMain.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
  
  public ResultSet sip_vias()
    {
        try {
            ResultSet re = stat.executeQuery("select * from sip_vias;");
            return re;
           
        } catch (SQLException ex) {
            Logger.getLogger(DbMain.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
  
  
  
  
}
