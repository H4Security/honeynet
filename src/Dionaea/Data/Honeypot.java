/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Dionaea.Data;

/**
 *
 * @author lap
 */
public class Honeypot {
    private String ip;
    private int port;
    private String name;
    private String username;
    private String password;
    private String type;
    private int id;
    public void setId(int i)
    {
        id =i;
    }
    public int getId()
    {
        return id;
    }
    
    public void setIp(String s)
    {
        ip =s;
    }
    public String getIp()
    {
        return ip;
    }
    public void setPort(int s)
    {
        port = s;
    }
    public int getPort()
    {
        return port;
    }
    public void setName(String s)
    {
        name =s;
    }
    public String getName()
    {
        return name;
    }
    public void setUsername(String s)
    {
        username = s;
    }
    public String getUsername()
    {
        return username;
    }
    public void setPassword(String s)
    {
        password= s;
    }
    public String getPassword()
    {
        return password;
    }
    public void setType(String s)
    {
        type=s;
    }
    public String getType()
    {
        return type;
    }
    
}
