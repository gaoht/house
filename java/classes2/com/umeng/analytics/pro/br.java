package com.umeng.analytics.pro;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.io.IOException;
import java.util.concurrent.LinkedBlockingQueue;

public class br
{
  public static String a(Context paramContext)
  {
    try
    {
      paramContext = b(paramContext);
      if (paramContext == null) {
        return null;
      }
      paramContext = a.a(paramContext);
      return paramContext;
    }
    catch (Exception paramContext) {}
    return null;
  }
  
  private static a b(Context paramContext)
    throws Exception
  {
    try
    {
      paramContext.getPackageManager().getPackageInfo("com.android.vending", 0);
      b localb = new b(null);
      Object localObject1 = new Intent("com.google.android.gms.ads.identifier.service.START");
      ((Intent)localObject1).setPackage("com.google.android.gms");
      if (paramContext.bindService((Intent)localObject1, localb, 1)) {}
      throw new IOException("Google Play connection failed");
    }
    catch (Exception paramContext)
    {
      try
      {
        localObject1 = new c(localb.a());
        localObject1 = new a(((c)localObject1).a(), ((c)localObject1).a(true));
        return (a)localObject1;
      }
      catch (Exception localException)
      {
        throw localException;
      }
      finally
      {
        paramContext.unbindService(localb);
      }
      paramContext = paramContext;
      throw paramContext;
    }
  }
  
  private static final class a
  {
    private final String a;
    private final boolean b;
    
    a(String paramString, boolean paramBoolean)
    {
      this.a = paramString;
      this.b = paramBoolean;
    }
    
    private String b()
    {
      return this.a;
    }
    
    public boolean a()
    {
      return this.b;
    }
  }
  
  private static final class b
    implements ServiceConnection
  {
    boolean a = false;
    private final LinkedBlockingQueue<IBinder> b = new LinkedBlockingQueue(1);
    
    public IBinder a()
      throws InterruptedException
    {
      if (this.a) {
        throw new IllegalStateException();
      }
      this.a = true;
      return (IBinder)this.b.take();
    }
    
    public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
    {
      try
      {
        this.b.put(paramIBinder);
        return;
      }
      catch (InterruptedException paramComponentName) {}
    }
    
    public void onServiceDisconnected(ComponentName paramComponentName) {}
  }
  
  private static final class c
    implements IInterface
  {
    private IBinder a;
    
    public c(IBinder paramIBinder)
    {
      this.a = paramIBinder;
    }
    
    public String a()
      throws RemoteException
    {
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
        this.a.transact(1, localParcel1, localParcel2, 0);
        localParcel2.readException();
        String str = localParcel2.readString();
        return str;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
    }
    
    /* Error */
    public boolean a(boolean paramBoolean)
      throws RemoteException
    {
      // Byte code:
      //   0: iconst_1
      //   1: istore_3
      //   2: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
      //   5: astore 4
      //   7: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
      //   10: astore 5
      //   12: aload 4
      //   14: ldc 30
      //   16: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
      //   19: iload_1
      //   20: ifeq +56 -> 76
      //   23: iconst_1
      //   24: istore_2
      //   25: aload 4
      //   27: iload_2
      //   28: invokevirtual 55	android/os/Parcel:writeInt	(I)V
      //   31: aload_0
      //   32: getfield 18	com/umeng/analytics/pro/br$c:a	Landroid/os/IBinder;
      //   35: iconst_2
      //   36: aload 4
      //   38: aload 5
      //   40: iconst_0
      //   41: invokeinterface 40 5 0
      //   46: pop
      //   47: aload 5
      //   49: invokevirtual 43	android/os/Parcel:readException	()V
      //   52: aload 5
      //   54: invokevirtual 59	android/os/Parcel:readInt	()I
      //   57: istore_2
      //   58: iload_2
      //   59: ifeq +22 -> 81
      //   62: iload_3
      //   63: istore_1
      //   64: aload 5
      //   66: invokevirtual 49	android/os/Parcel:recycle	()V
      //   69: aload 4
      //   71: invokevirtual 49	android/os/Parcel:recycle	()V
      //   74: iload_1
      //   75: ireturn
      //   76: iconst_0
      //   77: istore_2
      //   78: goto -53 -> 25
      //   81: iconst_0
      //   82: istore_1
      //   83: goto -19 -> 64
      //   86: astore 6
      //   88: aload 5
      //   90: invokevirtual 49	android/os/Parcel:recycle	()V
      //   93: aload 4
      //   95: invokevirtual 49	android/os/Parcel:recycle	()V
      //   98: aload 6
      //   100: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	101	0	this	c
      //   0	101	1	paramBoolean	boolean
      //   24	54	2	i	int
      //   1	62	3	bool	boolean
      //   5	89	4	localParcel1	Parcel
      //   10	79	5	localParcel2	Parcel
      //   86	13	6	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   12	19	86	finally
      //   25	58	86	finally
    }
    
    public IBinder asBinder()
    {
      return this.a;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/umeng/analytics/pro/br.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */