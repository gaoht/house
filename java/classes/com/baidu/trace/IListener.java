package com.baidu.trace;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.HashMap;
import java.util.Map;

public abstract interface IListener
  extends IInterface
{
  public abstract void extendedOperationCallback(int paramInt, String paramString)
    throws RemoteException;
  
  public abstract Map gatherAttribute(long paramLong)
    throws RemoteException;
  
  public abstract void pushCallback(byte paramByte, String paramString)
    throws RemoteException;
  
  public abstract void startGatherCallback(int paramInt)
    throws RemoteException;
  
  public abstract void startTraceCallback(int paramInt)
    throws RemoteException;
  
  public abstract void stopGatherCallback(int paramInt)
    throws RemoteException;
  
  public abstract void stopTraceCallback(int paramInt)
    throws RemoteException;
  
  public static abstract class Stub
    extends Binder
    implements IListener
  {
    private static final String DESCRIPTOR = "com.baidu.trace.IListener";
    static final int TRANSACTION_extendedOperationCallback = 7;
    static final int TRANSACTION_gatherAttribute = 5;
    static final int TRANSACTION_pushCallback = 6;
    static final int TRANSACTION_startGatherCallback = 3;
    static final int TRANSACTION_startTraceCallback = 1;
    static final int TRANSACTION_stopGatherCallback = 4;
    static final int TRANSACTION_stopTraceCallback = 2;
    
    public Stub()
    {
      attachInterface(this, "com.baidu.trace.IListener");
    }
    
    public static IListener asInterface(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.baidu.trace.IListener");
      if ((localIInterface != null) && ((localIInterface instanceof IListener))) {
        return (IListener)localIInterface;
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
        paramParcel2.writeString("com.baidu.trace.IListener");
        return true;
      case 1: 
        paramParcel1.enforceInterface("com.baidu.trace.IListener");
        startTraceCallback(paramParcel1.readInt());
        paramParcel2.writeNoException();
        return true;
      case 2: 
        paramParcel1.enforceInterface("com.baidu.trace.IListener");
        stopTraceCallback(paramParcel1.readInt());
        paramParcel2.writeNoException();
        return true;
      case 3: 
        paramParcel1.enforceInterface("com.baidu.trace.IListener");
        startGatherCallback(paramParcel1.readInt());
        paramParcel2.writeNoException();
        return true;
      case 4: 
        paramParcel1.enforceInterface("com.baidu.trace.IListener");
        stopGatherCallback(paramParcel1.readInt());
        paramParcel2.writeNoException();
        return true;
      case 5: 
        paramParcel1.enforceInterface("com.baidu.trace.IListener");
        paramParcel1 = gatherAttribute(paramParcel1.readLong());
        paramParcel2.writeNoException();
        paramParcel2.writeMap(paramParcel1);
        return true;
      case 6: 
        paramParcel1.enforceInterface("com.baidu.trace.IListener");
        pushCallback(paramParcel1.readByte(), paramParcel1.readString());
        paramParcel2.writeNoException();
        return true;
      }
      paramParcel1.enforceInterface("com.baidu.trace.IListener");
      extendedOperationCallback(paramParcel1.readInt(), paramParcel1.readString());
      paramParcel2.writeNoException();
      return true;
    }
    
    static class Proxy
      implements IListener
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
      
      public void extendedOperationCallback(int paramInt, String paramString)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.baidu.trace.IListener");
          localParcel1.writeInt(paramInt);
          localParcel1.writeString(paramString);
          this.mRemote.transact(7, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public Map gatherAttribute(long paramLong)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.baidu.trace.IListener");
          localParcel1.writeLong(paramLong);
          this.mRemote.transact(5, localParcel1, localParcel2, 0);
          localParcel2.readException();
          HashMap localHashMap = localParcel2.readHashMap(getClass().getClassLoader());
          return localHashMap;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public String getInterfaceDescriptor()
      {
        return "com.baidu.trace.IListener";
      }
      
      public void pushCallback(byte paramByte, String paramString)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.baidu.trace.IListener");
          localParcel1.writeByte(paramByte);
          localParcel1.writeString(paramString);
          this.mRemote.transact(6, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public void startGatherCallback(int paramInt)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.baidu.trace.IListener");
          localParcel1.writeInt(paramInt);
          this.mRemote.transact(3, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public void startTraceCallback(int paramInt)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.baidu.trace.IListener");
          localParcel1.writeInt(paramInt);
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
      
      public void stopGatherCallback(int paramInt)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.baidu.trace.IListener");
          localParcel1.writeInt(paramInt);
          this.mRemote.transact(4, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public void stopTraceCallback(int paramInt)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.baidu.trace.IListener");
          localParcel1.writeInt(paramInt);
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
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/trace/IListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */