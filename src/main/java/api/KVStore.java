package api;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface KVStore<K, V> extends Remote {
    V put(K key, V value) throws RemoteException;
    V delete(K key) throws RemoteException;
    V get(K key) throws RemoteException;
}
