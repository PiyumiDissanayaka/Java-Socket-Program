import java.util.*;
import java.net.*;
import java.io.*;

public class Server{

    public static void main(String[] args) throws Exception{

        ServerSocket ss= new ServerSocket(5000);
        System.out.println("Server is running....");

        Map<String,Double> priceMap= new HashMap<>();

        priceMap.put("Mt001",2500.00);
        priceMap.put("mt003",1200.00);

        Map<String,Double> discountMap= new HashMap<>();

        discountMap.put("Mt001",5.00);
        discountMap.put("Mt003",2.5);

        while(true) {

            Socket s= ss.accept();
            BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
            PrintWriter pw= new PrintWriter(s.getOutputStream(),true);

            String code= br.readLine();

            if(code.equalsIgnoreCase("bye")){
                System.out.println("close");
                s.close();
                continue;
            }

            double initial= priceMap.get(code);
            double discount= discountMap.get(code);
            double finalprice= initial - (initial* discount/100);

            pw.println(initial + ","+ discount+","+finalprice);
        }

    }
}