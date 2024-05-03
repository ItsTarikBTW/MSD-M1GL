package exo2;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ServeurCarnet {

    
    public static void main(String[] args) {
        try {
            CarnetImpl c1 = new CarnetImpl();
            CarnetImpl c2 = new CarnetImpl();

            Registry r= LocateRegistry.createRegistry(1099);
            Naming.rebind("rmi://localhost:1099/Carnet1", c1);
            Naming.rebind("rmi://localhost:1099/Carnet2", c2);

            String [] bount=r.list();
            for (String string : bount) {
                System.out.println(string);
            }
            System.out.println("Server is ready.");
        } catch (Exception e) {
            System.out.println("Server failed: " + e);
        }
    }
}