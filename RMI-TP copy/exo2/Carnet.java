package exo2;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.HashMap;

public interface Carnet extends Remote {
    void enregistrer(String name, Adresse adresse) throws RemoteException;
    void effacer(String name) throws RemoteException;
    Adresse chercher(String name) throws RemoteException;
    HashMap<String, Adresse> lister() throws RemoteException;
}