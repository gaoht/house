package com.unionpay.mobile.android.hce.service;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public abstract interface a
  extends IInterface
{
  public abstract String a(String paramString1, String paramString2, b paramb)
    throws RemoteException;
  
  public abstract void a(String paramString1, String paramString2, String paramString3, b paramb)
    throws RemoteException;
  
  public static abstract class a
    extends Binder
    implements a
  {
    public static a a(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.unionpay.mobile.android.hce.service.IHCEBankService");
      if ((localIInterface != null) && ((localIInterface instanceof a))) {
        return (a)localIInterface;
      }
      return new a(paramIBinder);
    }
    
    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
      throws RemoteException
    {
      switch (paramInt1)
      {
      default: 
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      case 1598968902: 
        paramParcel2.writeString("com.unionpay.mobile.android.hce.service.IHCEBankService");
        return true;
      case 1: 
        paramParcel1.enforceInterface("com.unionpay.mobile.android.hce.service.IHCEBankService");
        paramParcel1 = a(paramParcel1.readString(), paramParcel1.readString(), b.a.a(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        paramParcel2.writeString(paramParcel1);
        return true;
      }
      paramParcel1.enforceInterface("com.unionpay.mobile.android.hce.service.IHCEBankService");
      a(paramParcel1.readString(), paramParcel1.readString(), paramParcel1.readString(), b.a.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    }
    
    private static final class a
      implements a
    {
      private IBinder a;
      
      a(IBinder paramIBinder)
      {
        this.a = paramIBinder;
      }
      
      /* Error */
      public final String a(String paramString1, String paramString2, b paramb)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore 4
        //   5: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   8: astore 5
        //   10: aload 4
        //   12: ldc 29
        //   14: invokevirtual 33	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   17: aload 4
        //   19: aload_1
        //   20: invokevirtual 36	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   23: aload 4
        //   25: aload_2
        //   26: invokevirtual 36	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   29: aload_3
        //   30: ifnull +55 -> 85
        //   33: aload_3
        //   34: invokeinterface 42 1 0
        //   39: astore_1
        //   40: aload 4
        //   42: aload_1
        //   43: invokevirtual 45	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   46: aload_0
        //   47: getfield 17	com/unionpay/mobile/android/hce/service/a$a$a:a	Landroid/os/IBinder;
        //   50: iconst_1
        //   51: aload 4
        //   53: aload 5
        //   55: iconst_0
        //   56: invokeinterface 51 5 0
        //   61: pop
        //   62: aload 5
        //   64: invokevirtual 54	android/os/Parcel:readException	()V
        //   67: aload 5
        //   69: invokevirtual 58	android/os/Parcel:readString	()Ljava/lang/String;
        //   72: astore_1
        //   73: aload 5
        //   75: invokevirtual 61	android/os/Parcel:recycle	()V
        //   78: aload 4
        //   80: invokevirtual 61	android/os/Parcel:recycle	()V
        //   83: aload_1
        //   84: areturn
        //   85: aconst_null
        //   86: astore_1
        //   87: goto -47 -> 40
        //   90: astore_1
        //   91: aload 5
        //   93: invokevirtual 61	android/os/Parcel:recycle	()V
        //   96: aload 4
        //   98: invokevirtual 61	android/os/Parcel:recycle	()V
        //   101: aload_1
        //   102: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	103	0	this	a
        //   0	103	1	paramString1	String
        //   0	103	2	paramString2	String
        //   0	103	3	paramb	b
        //   3	94	4	localParcel1	Parcel
        //   8	84	5	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   10	29	90	finally
        //   33	40	90	finally
        //   40	73	90	finally
      }
      
      /* Error */
      public final void a(String paramString1, String paramString2, String paramString3, b paramb)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore 5
        //   5: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   8: astore 6
        //   10: aload 5
        //   12: ldc 29
        //   14: invokevirtual 33	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   17: aload 5
        //   19: aload_1
        //   20: invokevirtual 36	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   23: aload 5
        //   25: aload_2
        //   26: invokevirtual 36	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   29: aload 5
        //   31: aload_3
        //   32: invokevirtual 36	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   35: aload 4
        //   37: ifnull +49 -> 86
        //   40: aload 4
        //   42: invokeinterface 42 1 0
        //   47: astore_1
        //   48: aload 5
        //   50: aload_1
        //   51: invokevirtual 45	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   54: aload_0
        //   55: getfield 17	com/unionpay/mobile/android/hce/service/a$a$a:a	Landroid/os/IBinder;
        //   58: iconst_2
        //   59: aload 5
        //   61: aload 6
        //   63: iconst_0
        //   64: invokeinterface 51 5 0
        //   69: pop
        //   70: aload 6
        //   72: invokevirtual 54	android/os/Parcel:readException	()V
        //   75: aload 6
        //   77: invokevirtual 61	android/os/Parcel:recycle	()V
        //   80: aload 5
        //   82: invokevirtual 61	android/os/Parcel:recycle	()V
        //   85: return
        //   86: aconst_null
        //   87: astore_1
        //   88: goto -40 -> 48
        //   91: astore_1
        //   92: aload 6
        //   94: invokevirtual 61	android/os/Parcel:recycle	()V
        //   97: aload 5
        //   99: invokevirtual 61	android/os/Parcel:recycle	()V
        //   102: aload_1
        //   103: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	104	0	this	a
        //   0	104	1	paramString1	String
        //   0	104	2	paramString2	String
        //   0	104	3	paramString3	String
        //   0	104	4	paramb	b
        //   3	95	5	localParcel1	Parcel
        //   8	85	6	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   10	35	91	finally
        //   40	48	91	finally
        //   48	75	91	finally
      }
      
      public final IBinder asBinder()
      {
        return this.a;
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/mobile/android/hce/service/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */