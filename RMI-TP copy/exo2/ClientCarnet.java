package exo2;
import java.rmi.Naming;

public class ClientCarnet {

    public static void main(String[] args) {
        try {

            Carnet carnet1 = (Carnet) Naming.lookup("rmi://localhost:1099/Carnet1");
            Carnet carnet2 = (Carnet) Naming.lookup("rmi://localhost:1099/Carnet2");

        
            Adresse a1 = new Adresse("Oladziri Number 111","Ghazaouet");
            Adresse a2 = new Adresse("Birouana Number 10", "Tlemcen");

            carnet1.enregistrer("tarik", a1);
            carnet2.enregistrer("John", a2);
            
            // list them all 
            System.out.println("Client 1 : " + carnet1.lister());
            System.out.println("Client 2 : " + carnet2.lister());

            System.out.println("Search : " + carnet1.chercher("tarik").getRue());
            System.out.println("Search : " + carnet2.chercher("John").getRue());
            
            // Use the carnet objects
        } catch (Exception e) {
            System.out.println("Client failed: " + e);
        }
    }
}