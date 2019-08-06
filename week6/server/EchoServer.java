import java.net.*;
import java.io.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

public class EchoServer{

    private ServerSocket serverSocket;
    private ExecutorService pool = Executors.newFixedThreadPool(3);

    public void start(int port){
        try{
            serverSocket = new ServerSocket(port);
            while(true){
                pool.execute(new EchoClientHandler(serverSocket.accept()));
            }
        } catch(IOException e){
            pool.shutdown();
        }
    }

    public void stop(){
        try{
            serverSocket.close();
        } catch(IOException e){}
    }

    private static class EchoClientHandler implements Runnable {
        private Socket clientSocket;
        private PrintWriter out;
        private BufferedReader in;

        public EchoClientHandler(Socket socket){
            this.clientSocket = socket;
        }

        public void run(){
            try{
                out = new PrintWriter(clientSocket.getOutputStream(), true);
                in = new BufferedReader(
                    new InputStreamReader(clientSocket.getInputStream()));
                
                String inputLine;
                while((inputLine = in.readLine()) != null){
                    if(inputLine.equals(".")){
                        out.println("bye");
                        break;
                    }
                    out.println(inputLine);
                }

                in.close();
                out.close();
                clientSocket.close();
            } catch(IOException e){
                System.out.println("Fuck");
            }
        }
    }

    public static void main(String[] args){
        EchoServer server = new EchoServer();
        server.start(6666);
    }
}