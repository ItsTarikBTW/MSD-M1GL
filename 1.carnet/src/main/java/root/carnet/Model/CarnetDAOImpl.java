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
            //if adress not exist
            PreparedStatement checkAdress = connection.prepareStatement("select * from adress where nom = ?");
            checkAdress.setString(1, adress.nom);
            ResultSet rs = checkAdress.executeQuery();
            if (!rs.next()) {
            PreparedStatement psAdress = connection.prepareStatement("insert into adress (nom, numRue, ville) values (?, ?, ?)");
            psAdress.setString(1, adress.nom);
            psAdress.setInt(2, adress.numRue);
            psAdress.setString(3, adress.ville);
            psAdress.executeUpdate();
            }
            //if personne not exist
            PreparedStatement checkPersonne = connection.prepareStatement("select * from personne where nom = ?");
            checkPersonne.setString(1, personne.nom);
            ResultSet rsPersonne = checkPersonne.executeQuery();
            if (!rsPersonne.next()) {
            PreparedStatement psPersonne = connection.prepareStatement("insert into personne (nom) values (?)");
            psPersonne.setString(1, personne.nom);
            psPersonne.executeUpdate();
            }

            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateEnsemble(String id, Personne personne, Adress adress) {
        try {
            //select old carnet
            PreparedStatement psOld = connection.prepareStatement("select * from carnet where id = ?");
            psOld.setString(1, id);
            ResultSet rsOld = psOld.executeQuery();
            rsOld.next();
            String oldAdress = rsOld.getString("adress");
            String oldName = rsOld.getString("nom");

            PreparedStatement PS_UpdateAdress = connection.prepareStatement("update adress set nom = ?, numRue = ?, ville = ? where nom = ?");
            PS_UpdateAdress.setString(1, adress.nom);
            PS_UpdateAdress.setInt(2, adress.numRue);
            PS_UpdateAdress.setString(3, adress.ville);
            PS_UpdateAdress.setString(4, oldAdress);
            PS_UpdateAdress.executeUpdate();

            PreparedStatement PS_UpdatePersonne = connection.prepareStatement("update personne set nom = ? where nom = ?");
            PS_UpdatePersonne.setString(1, personne.nom);
            PS_UpdatePersonne.setString(2, oldName);
            PS_UpdatePersonne.executeUpdate();

            PreparedStatement ps = connection.prepareStatement("update carnet set nom = ?, adress = ? where id = ?");
            ps.setString(1, personne.nom);
            ps.setString(2, adress.nom);
            ps.setString(3, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteEnsemble(String nom) {
        try {
            PreparedStatement ps = connection.prepareStatement("delete from carnet where id = ?");
            ps.setString(1, nom);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}