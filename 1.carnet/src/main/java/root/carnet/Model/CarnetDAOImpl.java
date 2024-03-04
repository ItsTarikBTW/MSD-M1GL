package root.carnet.Model;

import root.carnet.jdbc.SingletonConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class CarnetDAOImpl implements CarnetDAO {
    private final Connection connection = SingletonConnection.getConnection();

    @Override
    public ArrayList<Carnet> listCarnet() {
        ArrayList<Carnet> list = new ArrayList<Carnet>();
        try {
            PreparedStatement ps = connection.prepareStatement("select * from carnet");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String nom = rs.getString("nom");
                String adressKey = rs.getString("adress");

                PreparedStatement psAdress = connection.prepareStatement("select * from adress where nom = ?");
                psAdress.setString(1, adressKey);
                ResultSet rsAdress = psAdress.executeQuery();

                if (rsAdress.next()) {
                    String nomAdress = rsAdress.getString("nom");
                    int numRue = rsAdress.getInt("numRue");
                    String ville = rsAdress.getString("ville");
                    Adress x = new Adress(nomAdress, numRue, ville);

                    Carnet carnet = new Carnet(id + "");
                    carnet.enregistrer(new Personne(nom), x);
                    list.add(carnet);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void addEnsemble(Personne personne, Adress adress) {
        try {
            PreparedStatement ps = connection.prepareStatement("insert into carnet (nom, adress) values (?, ?)");
            ps.setString(1, personne.nom);
            ps.setString(2, adress.nom);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteEnsemble(String nom) {
        try {
            PreparedStatement ps = connection.prepareStatement("delete from carnet where nom = ?");
            ps.setString(1, nom);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}