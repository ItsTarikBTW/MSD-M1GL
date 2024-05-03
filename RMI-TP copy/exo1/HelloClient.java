package exo1;
import java.rmi.Naming;

public class HelloClient {

    public static void main(String[] args) {
        try {
            HelloInterface hello = (HelloInterface) Naming.lookup("rmi://localhost:1099/Hello");
            System.out.println(hello.say());
        } catch (Exception e) {
            System.out.println("Client failed: " + e);
        }
    }
}