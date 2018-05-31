package com.cibfintech.cloud.test;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;


public class Server2 {
	
	public static final int PORT = 3901;//监听的端口号     
	      
	    public static void main(String[] args) {    
	        System.out.println("服务器启动...\n");    
	        Server2 server = new Server2();    
	        server.init();    
	    }    
	   
	    public void init() {    
	        try {    
	           ServerSocket serverSocket = new ServerSocket(PORT);    
	          while (true) {    
	               // 一旦有堵塞, 则表示服务器与客户端获得了连接    
	                Socket client = serverSocket.accept();    
	                // 处理这次连接    
	                new HandlerThread(client);    
	            }    
	        } catch (Exception e) {    
	            System.out.println("服务器异常: " + e.getMessage());    
	        }    
	    }    
	   
	    private class HandlerThread implements Runnable {    
	        private Socket socket;    
	        public HandlerThread(Socket client) {    
	            socket = client;    
	            new Thread(this).start();    
	        }    
	    
	        public void run() {    
	            try {    
	                // 读取客户端数据    
	               DataInputStream input = new DataInputStream(socket.getInputStream());  
	               /*InputStream input = socket.getInputStream(); 
	            byte[] cliRevice = new byte[1024]; 
	   			int len;
	   			StringBuffer ss = new StringBuffer();  
	   			System.out.println(input.read());
	   			while ((len = input.read(cliRevice)) != -1) {
	   				ss.append(new String(cliRevice, 0, len,"GBK"));
	   			}
	   			
	   			System.out.println("接收客户端数据："+ ss.toString());*/
	             // 读取字节  
	   			byte[] b = new byte[500];  
                input.read(b);  
                System.out.println("客户端发过来的内容:" + new String(b, 0, 200));        

	                //String clientInputStr = input.readUTF();//这里要注意和客户端输出流的写方法对应,否则会抛 EOFException  
	                // 处理客户端数据    
	               // System.out.println("客户端发过来的内容:" + clientInputStr);    
	    
	               // 向客户端回复信息    
	                DataOutputStream out = new DataOutputStream(socket.getOutputStream());    
	                /*System.out.print("请输入:\t");    
	                // 发送键盘输入的一行    
	                String s = new BufferedReader(new InputStreamReader(System.in)).readLine();  */ 
	                
	               out.write("宁夏".getBytes());  
	               System.out.println("发送返回报文成功");
	                  
	                out.close();    
	                input.close();    
	            } catch (Exception e) {    
	                System.out.println("服务器 run 异常: " + e.getMessage());    
	            } finally {    
	                if (socket != null) {    
	                    try {    
	                        socket.close();    
	                    } catch (Exception e) {    
	                        socket = null;    
	                        System.out.println("服务端 finally 异常:" + e.getMessage());    
	                    }    
	                }    
	            }   
	        }    

	
	    }
}
