package client;

import api.KVStore;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class KVClient {

    public static void main(String[] args) {
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }
        try {
            Registry registry = LocateRegistry.getRegistry("localhost");
            KVStore<String, String> store = (KVStore<String, String>) registry.lookup("KVStore");

            if ("put".equals(args[0])) {
                System.out.printf("%s%n", store.put(args[1], args[2]));
            } else if ("delete".equals(args[0])) {
                System.out.printf("%s%n", store.delete(args[1]));
            } else if ("get".equals(args[0])) {
                System.out.printf("%s%n", store.get(args[1]));
            }

        } catch (RemoteException | NotBoundException e) {
            e.printStackTrace();
        }

    }
}
