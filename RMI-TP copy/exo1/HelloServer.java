package exo1;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class HelloServer {

    public static void main(String[] args) {
        try {
            Hello hello = new Hello("Hello, world!");
            LocateRegistry.createRegistry(1099);
            Naming.rebind("rmi://localhost:1099/Hello", hello);
            System.out.println("Server is ready.");
        } catch (Exception e) {
            System.out.println("Server failed: " + e);
        }
    }
}