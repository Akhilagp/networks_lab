import java.io.*;
import java.net.*;
public class Charcount_Client
{
  public static void main(String[] args) throws Exception
  {
     Socket sock = new Socket("127.0.0.1", 3000);
                               // reading from keyboard (keyRead object)
     BufferedReader keyRead = new BufferedReader(new InputStreamReader(System.in));
                              // sending to client (pwrite object)
     OutputStream ostream = sock.getOutputStream(); 
     PrintWriter pwrite = new PrintWriter(ostream, true);
 
                              // receiving from server ( receiveRead  object)
     InputStream istream = sock.getInputStream();
     BufferedReader receiveRead = new BufferedReader(new InputStreamReader(istream));
 
     System.out.println("Start the chitchat, type and press Enter key");
 
     String receiveMessage, sendMessage;               
     while(true)
     {
        sendMessage = keyRead.readLine();  // keyboard reading
        pwrite.println(sendMessage);       // sending to server
        pwrite.flush();          
	String r1=receiveRead.readLine();
	String r2=receiveRead.readLine();
          // flush the data
        if((r1 != null) && (r2!=null)) //receive from server
        {
            System.out.println("U sent: "+sendMessage+ "Number of characters "+r1 + "Number of lines: "+r2); // displaying at DOS prompt
        }         
      }               
    }                    
}                
