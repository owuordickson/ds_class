package com.rmi;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server {

    public static void main(String[] args) {

        try {
            ImplObj obj = new ImplObj();
            MyInterface skeleton = (MyInterface) UnicastRemoteObject.exportObject(obj, 0);

            // Bind the remote object's skeleton in the registry
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.bind("Obj1", skeleton);

            System.err.println("Server ready");
        } catch (Exception e) {
            System.err.println("Server exception: " + e);
            e.printStackTrace();
        }
    }

}
