package com.baidu.trace;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.baidu.trace.model.TraceLocation;

public abstract interface IService
  extends IInterface
{
  public abstract void handleExtendedOperate(int paramInt)
    throws RemoteException;
  
  public abstract boolean handleLocalFence(int paramInt, long paramLong, String paramString)
    throws RemoteException;
  
  public abstract boolean queryRealTimeLoc(TraceLocation paramTraceLocation)
    throws RemoteException;
  
  public abstract void registerListener(IListener paramIListener)
    throws RemoteException;
  
  public abstract boolean setCacheSize(int paramInt)
    throws RemoteException;
  
  public abstract boolean setInterval(int paramInt1, int paramInt2)
    throws RemoteException;
  
  public abstract boolean setLocTimeOffset(int paramInt)
    throws RemoteException;
  
  public abstract boolean setLocationMode(int paramInt)
    throws RemoteException;
  
  public abstract boolean setProtocolType(int paramInt)
    throws RemoteException;
  
  public abstract int startGather()
    throws RemoteException;
  
  public abstract int stopGather()
    throws RemoteException;
  
  public abstract void stopTrace(long paramLong, String paramString)
    throws RemoteException;
  
  public abstract void unregisterListener()
    throws RemoteException;
  
  public static abstract class Stub
    extends Binder
    implements IService
  {
    private static final String DESCRIPTOR = "com.baidu.trace.IService";
    static final int TRANSACTION_handleExtendedOperate = 11;
    static final int TRANSACTION_handleLocalFence = 10;
    static final int TRANSACTION_queryRealTimeLoc = 6;
    static final int TRANSACTION_registerListener = 12;
    static final int TRANSACTION_setCacheSize = 4;
    static final int TRANSACTION_setInterval = 3;
    static final int TRANSACTION_setLocTimeOffset = 5;
    static final int TRANSACTION_setLocationMode = 2;
    static final int TRANSACTION_setProtocolType = 1;
    static final int TRANSACTION_startGather = 8;
    static final int TRANSACTION_stopGather = 9;
    static final int TRANSACTION_stopTrace = 7;
    static final int TRANSACTION_unregisterListener = 13;
    
    public Stub()
    {
      attachInterface(this, "com.baidu.trace.IService");
    }
    
    public static IService asInterface(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.baidu.trace.IService");
      if ((localIInterface != null) && ((localIInterface instanceof IService))) {
        return (IService)localIInterface;
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
      int j = 0;
      int k = 0;
      int m = 0;
      int n = 0;
      int i1 = 0;
      int i2 = 0;
      int i = 0;
      boolean bool;
      switch (paramInt1)
      {
      default: 
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      case 1598968902: 
        paramParcel2.writeString("com.baidu.trace.IService");
        return true;
      case 1: 
        paramParcel1.enforceInterface("com.baidu.trace.IService");
        bool = setProtocolType(paramParcel1.readInt());
        paramParcel2.writeNoException();
        paramInt1 = i;
        if (bool) {
          paramInt1 = 1;
        }
        paramParcel2.writeInt(paramInt1);
        return true;
      case 2: 
        paramParcel1.enforceInterface("com.baidu.trace.IService");
        bool = setLocationMode(paramParcel1.readInt());
        paramParcel2.writeNoException();
        paramInt1 = j;
        if (bool) {
          paramInt1 = 1;
        }
        paramParcel2.writeInt(paramInt1);
        return true;
      case 3: 
        paramParcel1.enforceInterface("com.baidu.trace.IService");
        bool = setInterval(paramParcel1.readInt(), paramParcel1.readInt());
        paramParcel2.writeNoException();
        paramInt1 = k;
        if (bool) {
          paramInt1 = 1;
        }
        paramParcel2.writeInt(paramInt1);
        return true;
      case 4: 
        paramParcel1.enforceInterface("com.baidu.trace.IService");
        bool = setCacheSize(paramParcel1.readInt());
        paramParcel2.writeNoException();
        paramInt1 = m;
        if (bool) {
          paramInt1 = 1;
        }
        paramParcel2.writeInt(paramInt1);
        return true;
      case 5: 
        paramParcel1.enforceInterface("com.baidu.trace.IService");
        bool = setLocTimeOffset(paramParcel1.readInt());
        paramParcel2.writeNoException();
        paramInt1 = n;
        if (bool) {
          paramInt1 = 1;
        }
        paramParcel2.writeInt(paramInt1);
        return true;
      case 6: 
        paramParcel1.enforceInterface("com.baidu.trace.IService");
        paramParcel1 = new TraceLocation();
        bool = queryRealTimeLoc(paramParcel1);
        paramParcel2.writeNoException();
        paramInt1 = i1;
        if (bool) {
          paramInt1 = 1;
        }
        paramParcel2.writeInt(paramInt1);
        paramParcel2.writeInt(1);
        paramParcel1.writeToParcel(paramParcel2, 1);
        return true;
      case 7: 
        paramParcel1.enforceInterface("com.baidu.trace.IService");
        stopTrace(paramParcel1.readLong(), paramParcel1.readString());
        paramParcel2.writeNoException();
        return true;
      case 8: 
        paramParcel1.enforceInterface("com.baidu.trace.IService");
        paramInt1 = startGather();
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 9: 
        paramParcel1.enforceInterface("com.baidu.trace.IService");
        paramInt1 = stopGather();
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 10: 
        paramParcel1.enforceInterface("com.baidu.trace.IService");
        bool = handleLocalFence(paramParcel1.readInt(), paramParcel1.readLong(), paramParcel1.readString());
        paramParcel2.writeNoException();
        paramInt1 = i2;
        if (bool) {
          paramInt1 = 1;
        }
        paramParcel2.writeInt(paramInt1);
        return true;
      case 11: 
        paramParcel1.enforceInterface("com.baidu.trace.IService");
        handleExtendedOperate(paramParcel1.readInt());
        paramParcel2.writeNoException();
        return true;
      case 12: 
        paramParcel1.enforceInterface("com.baidu.trace.IService");
        registerListener(IListener.Stub.asInterface(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      }
      paramParcel1.enforceInterface("com.baidu.trace.IService");
      unregisterListener();
      paramParcel2.writeNoException();
      return true;
    }
    
    static class Proxy
      implements IService
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
        return "com.baidu.trace.IService";
      }
      
      public void handleExtendedOperate(int paramInt)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.baidu.trace.IService");
          localParcel1.writeInt(paramInt);
          this.mRemote.transact(11, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public boolean handleLocalFence(int paramInt, long paramLong, String paramString)
        throws RemoteException
      {
        boolean bool = false;
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.baidu.trace.IService");
          localParcel1.writeInt(paramInt);
          localParcel1.writeLong(paramLong);
          localParcel1.writeString(paramString);
          this.mRemote.transact(10, localParcel1, localParcel2, 0);
          localParcel2.readException();
          paramInt = localParcel2.readInt();
          if (paramInt != 0) {
            bool = true;
          }
          return bool;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public boolean queryRealTimeLoc(TraceLocation paramTraceLocation)
        throws RemoteException
      {
        boolean bool = false;
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.baidu.trace.IService");
          this.mRemote.transact(6, localParcel1, localParcel2, 0);
          localParcel2.readException();
          if (localParcel2.readInt() != 0) {
            bool = true;
          }
          if (localParcel2.readInt() != 0) {
            paramTraceLocation.readFromParcel(localParcel2);
          }
          return bool;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      /* Error */
      public void registerListener(IListener paramIListener)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 36	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_2
        //   4: invokestatic 36	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore_3
        //   8: aload_2
        //   9: ldc 26
        //   11: invokevirtual 40	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   14: aload_1
        //   15: ifnull +43 -> 58
        //   18: aload_1
        //   19: invokeinterface 83 1 0
        //   24: astore_1
        //   25: aload_2
        //   26: aload_1
        //   27: invokevirtual 86	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   30: aload_0
        //   31: getfield 19	com/baidu/trace/IService$Stub$Proxy:mRemote	Landroid/os/IBinder;
        //   34: bipush 12
        //   36: aload_2
        //   37: aload_3
        //   38: iconst_0
        //   39: invokeinterface 49 5 0
        //   44: pop
        //   45: aload_3
        //   46: invokevirtual 52	android/os/Parcel:readException	()V
        //   49: aload_3
        //   50: invokevirtual 55	android/os/Parcel:recycle	()V
        //   53: aload_2
        //   54: invokevirtual 55	android/os/Parcel:recycle	()V
        //   57: return
        //   58: aconst_null
        //   59: astore_1
        //   60: goto -35 -> 25
        //   63: astore_1
        //   64: aload_3
        //   65: invokevirtual 55	android/os/Parcel:recycle	()V
        //   68: aload_2
        //   69: invokevirtual 55	android/os/Parcel:recycle	()V
        //   72: aload_1
        //   73: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	74	0	this	Proxy
        //   0	74	1	paramIListener	IListener
        //   3	66	2	localParcel1	Parcel
        //   7	58	3	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   8	14	63	finally
        //   18	25	63	finally
        //   25	49	63	finally
      }
      
      public boolean setCacheSize(int paramInt)
        throws RemoteException
      {
        boolean bool = false;
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.baidu.trace.IService");
          localParcel1.writeInt(paramInt);
          this.mRemote.transact(4, localParcel1, localParcel2, 0);
          localParcel2.readException();
          paramInt = localParcel2.readInt();
          if (paramInt != 0) {
            bool = true;
          }
          return bool;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public boolean setInterval(int paramInt1, int paramInt2)
        throws RemoteException
      {
        boolean bool = false;
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.baidu.trace.IService");
          localParcel1.writeInt(paramInt1);
          localParcel1.writeInt(paramInt2);
          this.mRemote.transact(3, localParcel1, localParcel2, 0);
          localParcel2.readException();
          paramInt1 = localParcel2.readInt();
          if (paramInt1 != 0) {
            bool = true;
          }
          return bool;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public boolean setLocTimeOffset(int paramInt)
        throws RemoteException
      {
        boolean bool = false;
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.baidu.trace.IService");
          localParcel1.writeInt(paramInt);
          this.mRemote.transact(5, localParcel1, localParcel2, 0);
          localParcel2.readException();
          paramInt = localParcel2.readInt();
          if (paramInt != 0) {
            bool = true;
          }
          return bool;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public boolean setLocationMode(int paramInt)
        throws RemoteException
      {
        boolean bool = false;
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.baidu.trace.IService");
          localParcel1.writeInt(paramInt);
          this.mRemote.transact(2, localParcel1, localParcel2, 0);
          localParcel2.readException();
          paramInt = localParcel2.readInt();
          if (paramInt != 0) {
            bool = true;
          }
          return bool;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      /* Error */
      public boolean setProtocolType(int paramInt)
        throws RemoteException
      {
        // Byte code:
        //   0: iconst_1
        //   1: istore_2
        //   2: invokestatic 36	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   5: astore_3
        //   6: invokestatic 36	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   9: astore 4
        //   11: aload_3
        //   12: ldc 26
        //   14: invokevirtual 40	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   17: aload_3
        //   18: iload_1
        //   19: invokevirtual 43	android/os/Parcel:writeInt	(I)V
        //   22: aload_0
        //   23: getfield 19	com/baidu/trace/IService$Stub$Proxy:mRemote	Landroid/os/IBinder;
        //   26: iconst_1
        //   27: aload_3
        //   28: aload 4
        //   30: iconst_0
        //   31: invokeinterface 49 5 0
        //   36: pop
        //   37: aload 4
        //   39: invokevirtual 52	android/os/Parcel:readException	()V
        //   42: aload 4
        //   44: invokevirtual 69	android/os/Parcel:readInt	()I
        //   47: istore_1
        //   48: iload_1
        //   49: ifeq +14 -> 63
        //   52: aload 4
        //   54: invokevirtual 55	android/os/Parcel:recycle	()V
        //   57: aload_3
        //   58: invokevirtual 55	android/os/Parcel:recycle	()V
        //   61: iload_2
        //   62: ireturn
        //   63: iconst_0
        //   64: istore_2
        //   65: goto -13 -> 52
        //   68: astore 5
        //   70: aload 4
        //   72: invokevirtual 55	android/os/Parcel:recycle	()V
        //   75: aload_3
        //   76: invokevirtual 55	android/os/Parcel:recycle	()V
        //   79: aload 5
        //   81: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	82	0	this	Proxy
        //   0	82	1	paramInt	int
        //   1	64	2	bool	boolean
        //   5	71	3	localParcel1	Parcel
        //   9	62	4	localParcel2	Parcel
        //   68	12	5	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   11	48	68	finally
      }
      
      public int startGather()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.baidu.trace.IService");
          this.mRemote.transact(8, localParcel1, localParcel2, 0);
          localParcel2.readException();
          int i = localParcel2.readInt();
          return i;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public int stopGather()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.baidu.trace.IService");
          this.mRemote.transact(9, localParcel1, localParcel2, 0);
          localParcel2.readException();
          int i = localParcel2.readInt();
          return i;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public void stopTrace(long paramLong, String paramString)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.baidu.trace.IService");
          localParcel1.writeLong(paramLong);
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
      
      public void unregisterListener()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.baidu.trace.IService");
          this.mRemote.transact(13, localParcel1, localParcel2, 0);
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


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/trace/IService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */