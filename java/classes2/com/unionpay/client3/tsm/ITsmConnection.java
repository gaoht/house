package com.unionpay.client3.tsm;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public abstract interface ITsmConnection
  extends IInterface
{
  public abstract void closeChannel(int paramInt1, int paramInt2)
    throws RemoteException;
  
  public abstract SeAppInfo[] getSeApps(int paramInt)
    throws RemoteException;
  
  public abstract String sendApdu(int paramInt1, String paramString, int paramInt2)
    throws RemoteException;
  
  public static abstract class Stub
    extends Binder
    implements ITsmConnection
  {
    private static final String DESCRIPTOR = "com.unionpay.client3.tsm.ITsmConnection";
    static final int TRANSACTION_closeChannel = 2;
    static final int TRANSACTION_getSeApps = 3;
    static final int TRANSACTION_sendApdu = 1;
    
    public Stub()
    {
      attachInterface(this, "com.unionpay.client3.tsm.ITsmConnection");
    }
    
    public static ITsmConnection asInterface(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.unionpay.client3.tsm.ITsmConnection");
      if ((localIInterface != null) && ((localIInterface instanceof ITsmConnection))) {
        return (ITsmConnection)localIInterface;
      }
      return new Proxy(paramIBinder);
    }
    
    public IBinder asBinder()
    {
      return this;
    }
    
    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
      throws RemoteException
    {
      switch (paramInt1)
      {
      default: 
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      case 1598968902: 
        paramParcel2.writeString("com.unionpay.client3.tsm.ITsmConnection");
        return true;
      case 1: 
        paramParcel1.enforceInterface("com.unionpay.client3.tsm.ITsmConnection");
        paramParcel1 = sendApdu(paramParcel1.readInt(), paramParcel1.readString(), paramParcel1.readInt());
        paramParcel2.writeNoException();
        paramParcel2.writeString(paramParcel1);
        return true;
      case 2: 
        paramParcel1.enforceInterface("com.unionpay.client3.tsm.ITsmConnection");
        closeChannel(paramParcel1.readInt(), paramParcel1.readInt());
        paramParcel2.writeNoException();
        return true;
      }
      paramParcel1.enforceInterface("com.unionpay.client3.tsm.ITsmConnection");
      paramParcel1 = getSeApps(paramParcel1.readInt());
      paramParcel2.writeNoException();
      paramParcel2.writeTypedArray(paramParcel1, 1);
      return true;
    }
    
    private static class Proxy
      implements ITsmConnection
    {
      private IBinder mRemote;
      
      Proxy(IBinder paramIBinder)
      {
        this.mRemote = paramIBinder;
      }
      
      public IBinder asBinder()
      {
        return this.mRemote;
      }
      
      public void closeChannel(int paramInt1, int paramInt2)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.unionpay.client3.tsm.ITsmConnection");
          localParcel1.writeInt(paramInt1);
          localParcel1.writeInt(paramInt2);
          this.mRemote.transact(2, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public String getInterfaceDescriptor()
      {
        return "com.unionpay.client3.tsm.ITsmConnection";
      }
      
      public SeAppInfo[] getSeApps(int paramInt)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.unionpay.client3.tsm.ITsmConnection");
          localParcel1.writeInt(paramInt);
          this.mRemote.transact(3, localParcel1, localParcel2, 0);
          localParcel2.readException();
          SeAppInfo[] arrayOfSeAppInfo = (SeAppInfo[])localParcel2.createTypedArray(SeAppInfo.CREATOR);
          return arrayOfSeAppInfo;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public String sendApdu(int paramInt1, String paramString, int paramInt2)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.unionpay.client3.tsm.ITsmConnection");
          localParcel1.writeInt(paramInt1);
          localParcel1.writeString(paramString);
          localParcel1.writeInt(paramInt2);
          this.mRemote.transact(1, localParcel1, localParcel2, 0);
          localParcel2.readException();
          paramString = localParcel2.readString();
          return paramString;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/client3/tsm/ITsmConnection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */