package com.unionpay.mobile.tsm.connect;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public abstract interface IInitCallback
  extends IInterface
{
  public abstract void initFailed()
    throws RemoteException;
  
  public abstract void initSucceed()
    throws RemoteException;
  
  public static abstract class Stub
    extends Binder
    implements IInitCallback
  {
    private static final String DESCRIPTOR = "com.unionpay.mobile.tsm.connect.IInitCallback";
    static final int TRANSACTION_initFailed = 2;
    static final int TRANSACTION_initSucceed = 1;
    
    public Stub()
    {
      attachInterface(this, "com.unionpay.mobile.tsm.connect.IInitCallback");
    }
    
    public static IInitCallback asInterface(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.unionpay.mobile.tsm.connect.IInitCallback");
      if ((localIInterface != null) && ((localIInterface instanceof IInitCallback))) {
        return (IInitCallback)localIInterface;
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
        paramParcel2.writeString("com.unionpay.mobile.tsm.connect.IInitCallback");
        return true;
      case 1: 
        paramParcel1.enforceInterface("com.unionpay.mobile.tsm.connect.IInitCallback");
        initSucceed();
        paramParcel2.writeNoException();
        return true;
      }
      paramParcel1.enforceInterface("com.unionpay.mobile.tsm.connect.IInitCallback");
      initFailed();
      paramParcel2.writeNoException();
      return true;
    }
    
    private static class Proxy
      implements IInitCallback
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
      
      public String getInterfaceDescriptor()
      {
        return "com.unionpay.mobile.tsm.connect.IInitCallback";
      }
      
      public void initFailed()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.unionpay.mobile.tsm.connect.IInitCallback");
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
      
      public void initSucceed()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.unionpay.mobile.tsm.connect.IInitCallback");
          this.mRemote.transact(1, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
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


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/mobile/tsm/connect/IInitCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */