package com.corba.MyApp;


/**
* MyApp/MyHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from My.idl
* Thursday, October 21, 2021 10:27:32 PM EAT
*/

abstract public class MyHelper
{
  private static String  _id = "IDL:MyApp/My:1.0";

  public static void insert (org.omg.CORBA.Any a, My that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static My extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = org.omg.CORBA.ORB.init ().create_interface_tc (MyHelper.id (), "My");
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static My read (org.omg.CORBA.portable.InputStream istream)
  {
    return narrow (istream.read_Object (_MyStub.class));
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, My value)
  {
    ostream.write_Object ((org.omg.CORBA.Object) value);
  }

  public static My narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof My)
      return (My)obj;
    else if (!obj._is_a (id ()))
      throw new org.omg.CORBA.BAD_PARAM ();
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      _MyStub stub = new _MyStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

  public static My unchecked_narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof My)
      return (My)obj;
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      _MyStub stub = new _MyStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

}
