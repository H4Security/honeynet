/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Dionaea.Database;

/**
 *
 * @author lap
 */
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;


public class ReadFile {
	
	FileInputStream fstream;
	FileOutputStream wstream;
	DataInputStream in ;
	BufferedReader br ;
	File file;
	ReadFile(String s)
	{
		file = new File(s);
	}
	
	public boolean IsExists()
	{
		return file.exists();
	}
	public ArrayList<String> read() throws IOException
	{
            ArrayList<String> s = new ArrayList<String>();
		if (IsExists()){
                    wstream = new FileOutputStream("copyhoneyd");
				PrintStream print = new PrintStream(wstream);
                                
                                   
                    fstream = new FileInputStream(file);
			DataInputStream in = new DataInputStream(fstream);
			  BufferedReader br = new BufferedReader(new InputStreamReader(in));
                    while(br.readLine() != null) {
                         print.println(br.readLine());
                    }
                    return s;
			
		}
		
			return null;
	}
        
}
