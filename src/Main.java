// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
/* CLIENT */
import java.io.*;
import java.net.*;
public class Main {
    public static void main(String[] args) {
        Socket client = null;

        // Default port number we are going to use
        int portnumber = 1234;
        if (args.length >= 1){
            portnumber = Integer.parseInt(args[0]);
        }
        for (int i=0 ;i<10; i++){
            try{
                String msg="";
                client = new Socket(InetAddress.getLocalHost(), portnumber);
                System.out.println("Client socket is created " + client);
                OutputStream clientOut = client.getOutputStream();
                PrintWriter pw = new PrintWriter(clientOut,true);
                InputStream clientIn= client.getInputStream();
                BufferedReader br = new BufferedReader(new InputStreamReader(clientIn));
                BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
                System.out.println("enter your name ,Type bye to exit");
                msg = stdIn.readLine().trim();
                pw.println(msg);
                System.out.println("Message returned from the server = " + br.readLine());

                pw.close();
                br.close();
                client.close();

                if (msg.equalsIgnoreCase("bye")){
                    break;
                }
            }

                catch (IOException ie){
                    System.out.println("I/O ERROR" + ie);
                }


        }


    }
}