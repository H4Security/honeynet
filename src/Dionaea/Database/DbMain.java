/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Dionaea.Database;

import Dionaea.Data.Honeypot;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.ArrayList;
import java.util.List;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lap
 */
public class DbMain {
    public DbMain()
    {
       
        try {
            Class.forName("org.sqlite.JDBC");
            connMain = DriverManager.getConnection("jdbc:sqlite:"+Db_name);
            //connHoneypot = DriverManager.getConnection("jdbc:sqlite:"+honeypotDp);
            statMain = connMain.createStatement();
            //statHoneypot = connHoneypot.createStatement();
            
            statMain.executeQuery("PRAGMA foreign_keys = ON;");
            
        } catch (SQLException ex) {
            Logger.getLogger(DbMain.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DbMain.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        
    }
    public void max()
    {
        maxConnection = 0;
        maxMysql = 0;
        sip_command=0;
        ResultSet rs;
        try {
            rs = statMain.executeQuery("select max(connection) from connections;");
            maxConnection = rs.getInt("max(connection)");
           
            rs = statMain.executeQuery("select max(mysql_command) from mysql_commands;");
            maxMysql = rs.getInt("max(mysql_command)");
            
            rs = statMain.executeQuery("select max(sip_command) from sip_commands;");
            sip_command = rs.getInt("max(sip_command)");
        } catch (SQLException ex) {
            Logger.getLogger(DbMain.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        
    }
    public ArrayList<Honeypot> getListOfHoneypot()
    {
        ArrayList<Honeypot> list = new ArrayList<Honeypot>();
        
        
        try {
            ResultSet rs = statMain.executeQuery("select * from honeypots;");
             while (rs.next())
                    {
                        Honeypot honeypot = new Honeypot();
                        honeypot.setIp(rs.getString("ip"));
                        honeypot.setName(rs.getString("name"));
                        honeypot.setPassword(rs.getString("password"));
                        honeypot.setPort(rs.getInt("port"));
                        honeypot.setUsername(rs.getString("username"));
                        honeypot.setType(rs.getString("type"));
                        honeypot.setId(rs.getInt("id"));
                        list.add(honeypot);
                  }
        } catch (SQLException ex) {
            Logger.getLogger(DbMain.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    public int addHoneypot(Honeypot Hnew) throws SQLException
    {
        try {
            PreparedStatement prep = connMain.prepareStatement("insert into honeypots(name,ip,port,username,password,type) values(?,?,?,?,?,?)");
            prep.setString(1,Hnew.getName());
            prep.setString(2,Hnew.getIp());
            prep.setInt(3,Hnew.getPort());
            prep.setString(4,Hnew.getUsername());
            prep.setString(5,Hnew.getPassword());
            prep.setString(6,Hnew.getType());
            prep.addBatch();
            connMain.setAutoCommit(false);
            prep.executeBatch();
            connMain.setAutoCommit(true);
           
            
        } catch (SQLException ex) {
            Logger.getLogger(DbMain.class.getName()).log(Level.SEVERE, null, ex);
        }
        ResultSet rs;
        
        rs = statMain.executeQuery("select id from honeypots where name=\""+Hnew.getName()+"\";");
        return rs.getInt("id");
          
    }
    public void addConn(ResultSet re,int id )
    {
        try {
           // ResultSet re = statHoneypot.executeQuery("select * from connection;");
            PreparedStatement prep = connMain.prepareStatement("insert into connections values (?,?,?,?,?,?,?,?,?,?,?,?,?)");
            while(re.next())
            {
                    int i = re.getInt("connection")+maxConnection;
                    prep.setInt(1, i);
                    prep.setString(2,re.getString("connection_type"));
                    prep.setString(3, re.getString("connection_transport"));
                    prep.setString(4, re.getString("connection_protocol"));
                    prep.setInt(5, re.getInt("connection_timestamp"));
                    prep.setInt(6, re.getInt("connection_root"));
                    prep.setInt(7, re.getInt("connection_parent"));
                    prep.setString(8, re.getString("local_host"));
                    prep.setInt(9, re.getInt("local_port"));
                    prep.setString(10,re.getString( "remote_host"));
                    prep.setString(11,re.getString( "remote_hostname"));
                    prep.setInt(12, re.getInt("remote_port"));
                    prep.setInt(13,id);
                    prep.addBatch();
            
            }
            connMain.setAutoCommit(false);
            prep.executeBatch();
            connMain.setAutoCommit(true);
            
        } catch (SQLException ex) {
            Logger.getLogger(DbMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void addDcerpcbinds(ResultSet re) throws SQLException
    {
        PreparedStatement prep = connMain.prepareStatement("insert into Dcerpcbinds values (?,?,?)");
        while(re.next())
            {
                    //prep.setString(1,re.getString("dcerpcbind"));
                    int i = re.getInt("connection")+maxConnection;
                    prep.setInt(1, i);
                    prep.setString(2,re.getString("dcerpcbind_uuid"));
                    prep.setString(3,re.getString("dcerpcbind_transfersyntax"));
                    prep.addBatch();
                    
            }
        connMain.setAutoCommit(false);
        prep.executeBatch();
        connMain.setAutoCommit(true);
        
        
    }
    public void  addDcerpcrequests(ResultSet re ) throws SQLException
    {
        PreparedStatement prep = connMain.prepareStatement("insert into Dcerpcrequests values (?,?,?)");
        while(re.next())
            {
                    //prep.setString(1,re.getString("Dcerpcrequest"));
                    int i = re.getInt("connection")+maxConnection;
                    prep.setInt(1, i);
                    prep.setString(2,re.getString("Dcerpcrequest_uuid"));
                    prep.setString(3,re.getString("dcerpcrequest_opnum"));
                    prep.addBatch();
                    
            }
        connMain.setAutoCommit(false);
        prep.executeBatch();
        connMain.setAutoCommit(true);
    }
    
      public void  addDownloads(ResultSet re) throws SQLException
    {
        PreparedStatement prep = connMain.prepareStatement("insert into Downloads values (?,?,?)");
        while(re.next())
            {
                   // prep.setString(1,re.getString("Download"));
                    int i = re.getInt("connection")+maxConnection;
                    prep.setInt(1, i);
                    prep.setString(2,re.getString("download_url"));
                    prep.setString(3,re.getString("download_md5_hash"));
                    prep.addBatch();
                    
            }
        connMain.setAutoCommit(false);
        prep.executeBatch();
        connMain.setAutoCommit(true);
    }
      public void  addEmuProfile(ResultSet re ) throws SQLException
    {
        PreparedStatement prep = connMain.prepareStatement("insert into emu_profiles values (?,?)");
        while(re.next())
            {
                   // prep.setString(1,re.getString("emu_profile"));
                    int i = re.getInt("connection")+maxConnection;
                    prep.setInt(1, i);
                    prep.setString(2,re.getString("emu_profile_json"));
                    prep.addBatch();
                    
            }
        connMain.setAutoCommit(false);
        prep.executeBatch();
        connMain.setAutoCommit(true);
    }
       public void  addEmuServices(ResultSet re ) throws SQLException
    {
        PreparedStatement prep = connMain.prepareStatement("insert into emu_services values (?,?)");
        while(re.next())
            {
                    //prep.setString(1,re.getString("emu_serivce"));
                    int i = re.getInt("connection")+maxConnection;
                    prep.setInt(1, i);
                    prep.setString(2,re.getString("emu_service_url"));
                    prep.addBatch();
                    
            }
        connMain.setAutoCommit(false);
        prep.executeBatch();
        connMain.setAutoCommit(true);
    }
       
        public void  addLogins(ResultSet re ) throws SQLException
    {
        PreparedStatement prep = connMain.prepareStatement("insert into logins values (?,?,?)");
        while(re.next())
            {
                    //prep.setString(1,re.getString("login"));
                    int i = re.getInt("connection")+maxConnection;
                    prep.setInt(1, i);
                    prep.setString(2,re.getString("login_username"));
                    prep.setString(3,re.getString("login_password"));
                    prep.addBatch();
                    
            }
        connMain.setAutoCommit(false);
        prep.executeBatch();
        connMain.setAutoCommit(true);
    }
        
        public void  addMssql_commands(ResultSet re ) throws SQLException
    {
        PreparedStatement prep = connMain.prepareStatement("insert into  Mssql_commands values(?,?,?)");
        while(re.next())
            {
                   // prep.setString(1,re.getString("Mssql_command"));
                    int i = re.getInt("connection")+maxConnection;
                    prep.setInt(1, i);
                    prep.setString(2,re.getString("mssql_command_status"));
                    prep.setString(3,re.getString("mssql_command_cmd"));
                    prep.addBatch();
                    
            }
        connMain.setAutoCommit(false);
        prep.executeBatch();
        connMain.setAutoCommit(true);
    }
        public void  addMssql_fingerprints(ResultSet re ) throws SQLException
    {
        PreparedStatement prep = connMain.prepareStatement("insert into  mssql_fingerprints values(?,?,?,?)");
        while(re.next())
            {
                    //prep.setString(1,re.getString("mssql_fingerprint"));
                    int i = re.getInt("connection")+maxConnection;
                    prep.setInt(1, i);
                    prep.setString(2,re.getString("mssql_fingerprint_hostname"));
                    prep.setString(3,re.getString("mssql_fingerprint_appname"));
                    prep.setString(4,re.getString("mssql_fingerprint_cltintname"));
                    
                    prep.addBatch();
                    
            }
        connMain.setAutoCommit(false);
        prep.executeBatch();
        connMain.setAutoCommit(true);
    }
        
         public void  addMysqlCommands(ResultSet re ) throws SQLException
    {
        PreparedStatement prep = connMain.prepareStatement("insert into  mysql_commands values(?,?,?)");
         int i;
        while(re.next())
            {
                    i = re.getInt("mysql_command")+maxMysql;
                    prep.setInt(1,i);
                    i = re.getInt("connection")+maxConnection;
                    prep.setInt(2, i);
                    prep.setString(3,re.getString("mysql_command_cmd"));
                    
                    prep.addBatch();
                    
            }
        connMain.setAutoCommit(false);
        prep.executeBatch();
        connMain.setAutoCommit(true);
    }
          public void  addMysqlCommandArgs(ResultSet re ) throws SQLException
    {
        PreparedStatement prep = connMain.prepareStatement("insert into  mysql_command_args values(?,?,?)");
         int i;
        while(re.next())
            {
                    i = re.getInt("mysql_command")+maxMysql;
                    prep.setInt(1,i);
                    prep.setInt(2,re.getInt("mysql_command_arg_index"));
                    prep.setString(3,re.getString("mysql_command_arg_data"));
                    
                    prep.addBatch();
                    
            }
        connMain.setAutoCommit(false);
        prep.executeBatch();
        connMain.setAutoCommit(true);
    }
           public void  addP0fs(ResultSet re ) throws SQLException
    {
        PreparedStatement prep = connMain.prepareStatement("insert into  p0fs values(?,?,?,?,?,?,?,?,?)");
         int i;
        while(re.next())
            {
                    i = re.getInt("connection")+maxConnection;
                    prep.setInt(1,i);
                    prep.setString(2,re.getString("p0f_genre"));
                    prep.setString(3,re.getString("p0f_link"));
                    prep.setString(4,re.getString("p0f_detail"));
                    prep.setInt(5,re.getInt("p0f_uptime"));
                    prep.setString(6,re.getString("p0f_tos"));
                    prep.setInt(7,re.getInt("p0f_dist"));
                    prep.setInt(8,re.getInt("p0f_nat"));
                    prep.setInt(9,re.getInt("p0f_fw"));
                    prep.addBatch();
                    
            }
        connMain.setAutoCommit(false);
        prep.executeBatch();
        connMain.setAutoCommit(true);
    }
           
           public void  addSipCommands(ResultSet re ) throws SQLException
    {
        PreparedStatement prep = connMain.prepareStatement("insert into  sip_commands values(?,?,?,?,?,?)");
         int i;
        while(re.next())
            {
                    prep.setInt(1,re.getInt("sip_command")+sip_command);
                    i = re.getInt("connection")+maxConnection;
                    prep.setInt(2,i);
                    prep.setString(3,re.getString("sip_command_method"));
                    prep.setString(4,re.getString("sip_command_call_id"));
                    prep.setString(5,re.getString("sip_command_user_agent"));
                    prep.setInt(6,re.getInt("sip_command_allow"));
                    prep.addBatch();
                    
            }
        connMain.setAutoCommit(false);
        prep.executeBatch();
        connMain.setAutoCommit(true);
    }
            
   public void  addSipAddrs(ResultSet re ) throws SQLException
    {
        PreparedStatement prep = connMain.prepareStatement("insert into  sip_addrs values(?,?,?,?,?,?,?,?)");
         int i;
        while(re.next())
            {
                    prep.setInt(1,re.getInt("sip_command")+sip_command);
                    prep.setString(2,re.getString("sip_addr_type"));
                    prep.setString(3,re.getString("sip_addr_display_name"));
                    prep.setString(4,re.getString("sip_addr_uri_scheme"));
                    prep.setString(5,re.getString("sip_addr_uri_user"));
                    prep.setString(6,re.getString("sip_addr_uri_password"));
                    prep.setString(7,re.getString("sip_addr_uri_host"));
                    prep.setString(8,re.getString("sip_addr_uri_port"));

                    prep.addBatch();
                    
                    
            }
        connMain.setAutoCommit(false);
        prep.executeBatch();
        connMain.setAutoCommit(true);
    }
   
   public void  addSipSdpConnectiondatas(ResultSet re ) throws SQLException
    {
        PreparedStatement prep = connMain.prepareStatement("insert into  sip_Sdp_connectiondatas values(?,?,?,?,?,?)");
         int i;
        while(re.next())
            {
                    prep.setInt(1,re.getInt("sip_command")+sip_command);
                    prep.setString(2,re.getString("sip_sdp_connectiondata_nettype"));
                    prep.setString(3,re.getString("sip_sdp_connectiondata_addrtype"));
                    prep.setString(4,re.getString("sip_sdp_connectiondata_connection_address"));
                    prep.setString(5,re.getString("sip_sdp_connectiondata_ttl"));
                    prep.setString(6,re.getString("sip_sdp_connectiondata_number_of_addresses"));

                    prep.addBatch();
                    
                    
            }
        connMain.setAutoCommit(false);
        prep.executeBatch();
        connMain.setAutoCommit(true);
    }
   
   public void  addSipSdpMedia(ResultSet re ) throws SQLException
    {
        PreparedStatement prep = connMain.prepareStatement("insert into  sip_sdp_medias values(?,?,?,?,?)");
         int i;
        while(re.next())
            {
                    prep.setInt(1,re.getInt("sip_command")+sip_command);
                    prep.setString(2,re.getString("sip_sdp_media_media"));
                    prep.setString(3,re.getString("sip_sdp_media_port"));
                    prep.setString(4,re.getString("sip_sdp_media_number_of_ports"));
                    prep.setString(5,re.getString("sip_sdp_media_proto"));
                   // prep.setString(6,re.getString("sip_sdp_media_fmt"));
                    //prep.setString(7,re.getString("sip_sdp_media_attributes"));


                    prep.addBatch();
                   
                    
            }
        connMain.setAutoCommit(false);
        prep.executeBatch();
        connMain.setAutoCommit(true);
    }
   
   public void  addSipSdpOrigins(ResultSet re ) throws SQLException
    {
        PreparedStatement prep = connMain.prepareStatement("insert into  sip_sdp_origins values(?,?,?,?,?,?,?)");
         int i;
        while(re.next())
            {
                    prep.setInt(1,re.getInt("sip_command")+sip_command);
                    prep.setString(2,re.getString("sip_sdp_origin_username"));
                    prep.setString(3,re.getString("sip_sdp_origin_sess_id"));
                    prep.setString(4,re.getString("sip_sdp_origin_sess_version"));
                    prep.setString(5,re.getString("sip_sdp_origin_nettype"));
                    prep.setString(6,re.getString("sip_sdp_origin_addrtype"));
                    prep.setString(7,re.getString("sip_sdp_origin_unicast_address"));


                    prep.addBatch();
                    
                    
            }
        connMain.setAutoCommit(false);
        prep.executeBatch();
        connMain.setAutoCommit(true);
    }
   
   public void  addSipVias(ResultSet re ) throws SQLException
    {
        PreparedStatement prep = connMain.prepareStatement("insert into  sip_vias values(?,?,?,?)");
         
        while(re.next())
            {
                    prep.setInt(1,re.getInt("sip_command")+sip_command);
                    prep.setString(2,re.getString("sip_via_protocol"));
                    prep.setString(3,re.getString("sip_via_address"));
                    prep.setString(4,re.getString("sip_via_port"));



                    prep.addBatch();
                    
                    
            }
        connMain.setAutoCommit(false);
        prep.executeBatch();
        connMain.setAutoCommit(true);
    }
   public void addHoneyd(String nameOfFile,int id) throws IOException, ParseException
   {
      // ReadFile file = new ReadFile(nameOfFile);
       SimpleDateFormat dateFormat;
       dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss.SSS");
       java.util.Date date;
       java.sql.Timestamp ts1;
       Path path = Paths.get(nameOfFile);
       List<String> list = Files.readAllLines(path, StandardCharsets.UTF_8);
      
       String [] temp;
       String s;
        try {
            PreparedStatement prep = connMain.prepareStatement("insert into  connections(connection ,"
                    + "connection_protocol,connection_timestamp,local_host,local_port,"
                    + "remote_host,remote_port,honeypot) values(?,?,?,?,?,?,?,?)");
            int j =1;
       for(int i = 0;i<list.size();i++)
       {
           s =list.get(i);
           if(s == null)
           {
               System.out.println(i);
               break;
           }
           temp = s.split(" ");
           if(temp.length <6)
               continue;
           date = dateFormat.parse(temp[0]);
           ts1 = new java.sql.Timestamp(date.getTime());
           long tsTime1 = ts1.getTime()/1000;
           prep.setInt(1,j+maxConnection);
           j++;
           prep.setString(2,temp[1]);
           
           prep.setLong(3, tsTime1); 
           prep.setString(4,temp[5]);
           prep.setString(5, temp[6].substring(0,temp[6].length()-1));
           prep.setString(6,temp[3]);
           prep.setString(7,temp[4]);
           prep.setInt(8,id);
           prep.addBatch();
       }
       connMain.setAutoCommit(false);
        prep.executeBatch();
        connMain.setAutoCommit(true);
        } catch (SQLException ex) {
            Logger.getLogger(DbMain.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       
       
   }
   public ResultSet exec(String s)
   {
        
       ResultSet rs = null;
        try {
            rs = statMain.executeQuery(s);
        } catch (SQLException ex) {
            Logger.getLogger(DbMain.class.getName()).log(Level.SEVERE, null, ex);
        }
       return rs;
   }
    private String Db_name = "logfiles11";
    private Connection connMain;
    private int maxConnection,maxMysql,sip_command;
    Statement statMain;
}
