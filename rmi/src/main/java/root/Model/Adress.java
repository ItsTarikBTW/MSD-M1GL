package root.Model;
import java.io.Serializable;
public class Adress implements Serializable {
    public String nom;
    public int numRue;
    public String ville;

    public Adress(String nom,int numRue,String ville){
        this.nom=nom;
        this.numRue=numRue;
        this.ville=ville;
    }

    public String toString(){
        return this.nom + " " + this.numRue + " " + this.ville;
    }

    public void print(){
        System.out.println(this);
    }
}
