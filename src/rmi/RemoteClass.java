package rmi;

import java.rmi.RemoteException;

public class RemoteClass implements HelloInterface {
    @Override
    public String greetMe() throws RemoteException {
        return "Hello World!";
    }
}
