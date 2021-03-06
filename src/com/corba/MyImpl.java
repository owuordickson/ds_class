package com.corba;

import com.corba.MyApp.MyPOA;
import org.omg.CORBA.ORB;

public class MyImpl extends MyPOA {
    private ORB orb;

    public void setORB(ORB orb_val) {
        orb = orb_val;
    }

    // implement sayHi() method
    public String sayHi() {
        return "Hello World!\n";
    }

    // implement shutdown() method
    public void shutdown() {
        orb.shutdown(false);
    }
}