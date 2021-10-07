package rmi;

import java.rmi.RemoteException;

public class ObjImpl implements MyInterface {
    @Override
    public String greetMe() throws RemoteException {
        return "Hello World!";
    }
}
