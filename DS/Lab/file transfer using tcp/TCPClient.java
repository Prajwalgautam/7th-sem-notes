import java.net.*;
import java.io.*;

public class TCPClient
{
	
	public static void main(String args[])
	{
		File file;
		Socket s=null;
		try
		{
			String serverIp = "192.168.0.213";
			int serverPort = 7896;

			s=new Socket(serverIp,serverPort);
			file = new File("b.txt");
			FileOutputStream fos = new FileOutputStream(file);
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			BufferedInputStream bis = new BufferedInputStream(s.getInputStream());
			byte []buffer = new byte[10000];
			int bytesRead=0;
			while((bytesRead=bis.read(buffer))!=-1)
			{
				
				// System.out.println("Receiving file");
				bos.write(buffer,0,bytesRead);
				System.out.println("Receiving file");
			}
			System.out.println("File received");
			

			// String data =in.readUTF();
			// System.out.println("Received:"+ data);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally{
			if(s!=null)
			{
				// s.close();
			}
		}
	}
}