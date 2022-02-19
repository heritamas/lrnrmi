package server;

import api.KVStore;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class KVServer {

    public static void main(String[] args) {
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }

        KVStore<String, String> kvs = new KVStoreImpl();
        try {
            KVStore<String, String> stub = (KVStore<String, String>) UnicastRemoteObject.exportObject(kvs, 0);
            Registry registry = LocateRegistry.getRegistry();
            registry.rebind("KVStore", stub);
            System.out.println("KVStore bound");
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
