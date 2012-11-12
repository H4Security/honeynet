/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Dionaea.Data;
import java.io.*;

import javax.net.ssl.*;
import com.sun.net.ssl.*;
import com.sun.net.ssl.internal.ssl.Provider;
import java.security.Security;

/**
 * @author Joe Prasanna Kumar
 * This program simulates a client socket program which communicates with the SSL Server
 * 
 * Algorithm:
 * 1. Determine the SSL Server Name and port in which the SSL server is listening
 * 2. Register the JSSE provider
 * 3. Create an instance of SSLSocketFactory
 * 4. Create an instance of SSLSocket
 * 5. Create an OutputStream object to write to the SSL Server
 * 6. Create an InputStream object to receive messages back from the SSL Server
 * 
 */ 

public class SslConnection {

	/**
	 * @param args
	 */
	public boolean connection(String ip,int port,String username,char[] pass,String path ) throws Exception{
		String strServerName = ip; // SSL Server Name
		int intSSLport = port; // Port where the SSL Server is listening
		PrintWriter out = null;
                BufferedReader in = null;
                System.setProperty("javax.net.ssl.trustStore", "/home/lap/NetBeansProjects/Dionaea-001/testkeystore.ks");
                
                String ps = new String(pass) ;
                System.out.println(ps);
                 

		{
			// Registering the JSSE provider
			Security.addProvider(new Provider());
		}

		try {
			// Creating Client Sockets
			SSLSocketFactory sslsocketfactory = (SSLSocketFactory)SSLSocketFactory.getDefault();
			SSLSocket sslSocket = (SSLSocket)sslsocketfactory.createSocket(strServerName,intSSLport);

         	// Initializing the streams for Communication with the Server
         	out = new PrintWriter(sslSocket.getOutputStream(), true);
         	in = new BufferedReader(new InputStreamReader(sslSocket.getInputStream()));

			
			String userInput;
			

				out.println(username+":"+ps );
				userInput = in.readLine();
				if(userInput.equals("Ok"))
				{
					InputStream bis =  sslSocket.getInputStream() ;
					FileOutputStream bos = new FileOutputStream(path) ;
					 int i;
					 while( (i = bis.read() ) !=-1)
					 {
						 bos.write(i);
					 }
                                         bis.close();
                                         bos.close();
                                         out.close();
                                         in.close();
                                         sslSocket.close();
                                         return true;
				}
				System.out.println(userInput);
				out.close();
				in.close();
				
				sslSocket.close();
                                
		}

		catch(Exception exp)
		{
			System.out.println(" Exception occurred .... " +exp);
			exp.printStackTrace();
		}
                return false;

	}

}