package com.nwsuaf.rain;

import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.CosNaming.*;
import org.omg.CORBA.*;
/**
 * Created by rain on 2017/3/31.
 */
public class SysPropClient {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        try
        {
            org.omg.CORBA.Object objRef;
            SysProp syspropRef;
            ORB orb = ORB.init(args, null);

        	objRef = orb.resolve_initial_references("NameService");
        	System.out.println(orb.object_to_string(objRef));
        	NamingContext ncRef = NamingContextHelper.narrow(objRef);

        	NameComponent nc =new NameComponent("SysProp","");

        	NameComponent path[] = {nc};

        	syspropRef = SysPropHelper.narrow(ncRef.resolve(path));

            System.out.println("Using");

            syspropRef.CreateTable("stu");
            syspropRef.Insert("rain",90);
            int score = syspropRef.GetScore("rain");
            System.out.println(score);

        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }

}
