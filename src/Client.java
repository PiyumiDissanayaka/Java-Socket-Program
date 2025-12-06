import  java.util.*;
import  java.net.*;
import java.io.*;

public class Client{

    public static void main(String[] args) throws Exception{
        Socket s= new Socket("localhost",5000);

        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw= new PrintWriter(s.getOutputStream(),true);
        BufferedReader sr= new BufferedReader(new InputStreamReader(s.getInputStream()));

        System.out.println("enter code");
        String code= br.readLine();

        pw.println(code);

        String responce= sr.readLine();
        String[] arr= responce.split(",");

        System.out.println("Intial: "+arr[0]);
        System.out.println("discount: "+arr[1]+"%");
        System.out.println("finalPrice:  "+arr[2]);

        s.close();
    }
}