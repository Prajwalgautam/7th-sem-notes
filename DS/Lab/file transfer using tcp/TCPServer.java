import java.net.*;
import java.io.*;

public class TCPServer
{
	public static void main(String[] args) {
		try{
			int serverPort=7896;
			ServerSocket listenSocket = new ServerSocket(serverPort);
			while (true) {
				Thread.sleep(5000);
				Socket clientSocket= listenSocket.accept();
				Connection c = new Connection(clientSocket);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}
}

class Connection extends Thread
{
	FileInputStream fis;
	File file;
	BufferedInputStream bis;
	Socket clientSocket;
	BufferedOutputStream bos;
	public Connection(Socket aClientSocket)
	{
		try{
			clientSocket = aClientSocket;
			file = new File("a.txt");
			fis = new FileInputStream(file);
			bis = new BufferedInputStream(fis);
			bos= new BufferedOutputStream(clientSocket.getOutputStream());
			this.start();

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public void run()
	{
		byte buffer[];
		try
		{
			buffer = new byte[10000];
			// long fileLength = file.length(); 
			while(bis.read(buffer,0,10000)!=-1)
			{
				System.out.println("Sending File..");
				bos.write(buffer);
			}
			System.out.println("File Sucessfully sent");

		}
		catch(Exception e){
			e.printStackTrace();
		}

	}
}