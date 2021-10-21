package com.corba;

import com.corba.MyApp.My;
import com.corba.MyApp.MyHelper;
import org.omg.CORBA.*;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;

public class Client {

    static My helloImpl;

    public static void main(String args[])
    {
        try{
            // create and initialize the ORB
            ORB orb = ORB.init(args, null);

            // get the root naming context
            org.omg.CORBA.Object objRef =
                    orb.resolve_initial_references("NameService");
            // Use NamingContextExt instead of NamingContext. This is
            // part of the Interoperable naming Service.
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

            // resolve the Object Reference in Naming
            String name = "Hello";
            helloImpl = MyHelper.narrow(ncRef.resolve_str(name));

            System.out.println("Obtained a handle on server object: " + helloImpl);
            System.out.println(helloImpl.sayHi());
            helloImpl.shutdown();

        } catch (Exception e) {
            System.out.println("ERROR : " + e) ;
            e.printStackTrace(System.out);
        }
    }


}
