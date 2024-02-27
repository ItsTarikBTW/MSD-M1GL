package root.carnet.Model;

public class Adress {
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
