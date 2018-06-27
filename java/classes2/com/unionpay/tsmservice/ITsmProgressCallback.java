package com.unionpay.tsmservice;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public abstract interface ITsmProgressCallback
  extends IInterface
{
  public abstract void onProgress(int paramInt)
    throws RemoteException;
  
  public static abstract class Stub
    extends Binder
    implements ITsmProgressCallback
  {
    public Stub()
    {
      attachInterface(this, "com.unionpay.tsmservice.ITsmProgressCallback");
    }
    
    public static ITsmProgressCallback asInterface(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.unionpay.tsmservice.ITsmProgressCallback");
      if ((localIInterface != null) && ((localIInterface instanceof ITsmProgressCallback))) {
        return (ITsmProgressCallback)localIInterface;
      }
      return new a(paramIBinder);
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
        paramParcel2.writeString("com.unionpay.tsmservice.ITsmProgressCallback");
        return true;
      }
      paramParcel1.enforceInterface("com.unionpay.tsmservice.ITsmProgressCallback");
      onProgress(paramParcel1.readInt());
      paramParcel2.writeNoException();
      return true;
    }
    
    private static final class a
      implements ITsmProgressCallback
    {
      private IBinder a;
      
      a(IBinder paramIBinder)
      {
        this.a = paramIBinder;
      }
      
      public final IBinder asBinder()
      {
        return this.a;
      }
      
      public final void onProgress(int paramInt)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.unionpay.tsmservice.ITsmProgressCallback");
          localParcel1.writeInt(paramInt);
          this.a.transact(1, localParcel1, localParcel2, 0);
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


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/tsmservice/ITsmProgressCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */