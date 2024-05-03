package root.carnet.Model;
import java.io.Serializable;
public class Personne implements Serializable {
    public String nom;

    public Personne(String nom){
        this.nom=nom;
    }
}
