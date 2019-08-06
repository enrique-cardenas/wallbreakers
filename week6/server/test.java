import java.util.Scanner;

public class test{
    public static void main(String[] args){
        EchoClient client = new EchoClient();
        client.startConnection("127.0.0.1", 6666);
        Scanner scanner = new Scanner(System.in);

        String text;
        while(true){
            text = scanner.nextLine();
            String serverResponse = client.sendMessage(text);
            System.out.println("Server response: " + serverResponse);
            if(text.equals(".")) break;
        }

        client.stopConnection();
    }
}