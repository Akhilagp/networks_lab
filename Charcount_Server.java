import java.io.*;
import java.net.*;
public class Charcount_Server
{
  public static void main(String[] args) throws Exception
  {
      ServerSocket sersock = new ServerSocket(3000);
      System.out.println("Server  ready for chatting");
      Socket sock = sersock.accept( );                          
      BufferedReader keyRead = new BufferedReader(new InputStreamReader(System.in));
      OutputStream ostream = sock.getOutputStream(); 
      PrintWriter pwrite = new PrintWriter(ostream, true);
 
                              // receiving from server ( receiveRead  object)
      InputStream istream = sock.getInputStream();
      BufferedReader receiveRead = new BufferedReader(new InputStreamReader(istream));
 
      String receiveMessage, sendMessage;               
      while(true)
      {
        if((receiveMessage = receiveRead.readLine()) != null)  
        {
	char[] str_input = receiveMessage.toCharArray();	
	int le=receiveMessage.length();
	int cnt=0;
	for(int i=0;i<=le-1;i++)
	{
	if (str_input[i]=='.')
	{
		cnt=cnt+1;
	}//int count = StringUtils.countMatches(receiveMessage, ".");
        }
	pwrite.println(le-cnt);
	pwrite.println(cnt);             
        pwrite.flush();

        }  
      }               
    }                    
}                        
