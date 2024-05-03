package exo2;

import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
import java.util.HashMap;

public class CarnetImpl extends UnicastRemoteObject implements Carnet {
    private HashMap<String, Adresse> carnet;

    public CarnetImpl() throws RemoteException {
        carnet = new HashMap<>();
    }

    public void enregistrer(String name, Adresse adresse) throws RemoteException {
        carnet.put(name, adresse);
    }

    public void effacer(String name) throws RemoteException {
        carnet.remove(name);
    }

    public Adresse chercher(String name) throws RemoteException {
        return carnet.get(name);
    }

    public HashMap<String, Adresse> lister() throws RemoteException {
        return carnet;
    }
}