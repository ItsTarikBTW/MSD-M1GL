package root.carnet.Model;

import java.util.ArrayList;

public interface CarnetDAO {
    public void addEnsemble(Personne personne, Adress adress);
    public void updateEnsemble(String id, Personne personne, Adress adress);
    public void deleteEnsemble(String nom);
    public ArrayList<Carnet> listCarnet();
    
}
