package com.xiaomi.metok.geofencing;

import android.app.PendingIntent;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import java.util.List;

public abstract interface c
  extends IInterface
{
  public abstract String a();
  
  public abstract void a(double paramDouble1, double paramDouble2, float paramFloat, long paramLong, PendingIntent paramPendingIntent, String paramString1, String paramString2);
  
  public abstract void a(double paramDouble1, double paramDouble2, float paramFloat, long paramLong, String paramString1, String paramString2, String paramString3);
  
  public abstract void a(PendingIntent paramPendingIntent);
  
  public abstract void a(String paramString);
  
  public abstract void a(String paramString1, String paramString2);
  
  public abstract void a(List<String> paramList, String paramString);
  
  public abstract int b();
  
  public abstract List<String> b(String paramString);
  
  public static abstract class a
    extends Binder
    implements c
  {
    public static c a(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.xiaomi.metok.geofencing.IGeoFencing");
      if ((localIInterface != null) && ((localIInterface instanceof c))) {
        return (c)localIInterface;
      }
      return new a(paramIBinder);
    }
    
    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
    {
      switch (paramInt1)
      {
      default: 
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      case 1598968902: 
        paramParcel2.writeString("com.xiaomi.metok.geofencing.IGeoFencing");
        return true;
      case 1: 
        paramParcel1.enforceInterface("com.xiaomi.metok.geofencing.IGeoFencing");
        a(paramParcel1.createStringArrayList(), paramParcel1.readString());
        return true;
      case 2: 
        paramParcel1.enforceInterface("com.xiaomi.metok.geofencing.IGeoFencing");
        a(paramParcel1.readString());
        return true;
      case 3: 
        paramParcel1.enforceInterface("com.xiaomi.metok.geofencing.IGeoFencing");
        paramParcel1 = a();
        paramParcel2.writeNoException();
        paramParcel2.writeString(paramParcel1);
        return true;
      case 4: 
        paramParcel1.enforceInterface("com.xiaomi.metok.geofencing.IGeoFencing");
        paramParcel1 = b(paramParcel1.readString());
        paramParcel2.writeNoException();
        paramParcel2.writeStringList(paramParcel1);
        return true;
      case 5: 
        paramParcel1.enforceInterface("com.xiaomi.metok.geofencing.IGeoFencing");
        paramInt1 = b();
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 6: 
        paramParcel1.enforceInterface("com.xiaomi.metok.geofencing.IGeoFencing");
        a(paramParcel1.readDouble(), paramParcel1.readDouble(), paramParcel1.readFloat(), paramParcel1.readLong(), paramParcel1.readString(), paramParcel1.readString(), paramParcel1.readString());
        return true;
      case 7: 
        paramParcel1.enforceInterface("com.xiaomi.metok.geofencing.IGeoFencing");
        double d1 = paramParcel1.readDouble();
        double d2 = paramParcel1.readDouble();
        float f = paramParcel1.readFloat();
        long l = paramParcel1.readLong();
        if (paramParcel1.readInt() != 0) {}
        for (paramParcel2 = (PendingIntent)PendingIntent.CREATOR.createFromParcel(paramParcel1);; paramParcel2 = null)
        {
          a(d1, d2, f, l, paramParcel2, paramParcel1.readString(), paramParcel1.readString());
          return true;
        }
      case 8: 
        paramParcel1.enforceInterface("com.xiaomi.metok.geofencing.IGeoFencing");
        a(paramParcel1.readString(), paramParcel1.readString());
        return true;
      }
      paramParcel1.enforceInterface("com.xiaomi.metok.geofencing.IGeoFencing");
      if (paramParcel1.readInt() != 0) {}
      for (paramParcel1 = (PendingIntent)PendingIntent.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
      {
        a(paramParcel1);
        return true;
      }
    }
    
    private static class a
      implements c
    {
      private IBinder a;
      
      a(IBinder paramIBinder)
      {
        this.a = paramIBinder;
      }
      
      public String a()
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.xiaomi.metok.geofencing.IGeoFencing");
          this.a.transact(3, localParcel1, localParcel2, 0);
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
      public void a(double paramDouble1, double paramDouble2, float paramFloat, long paramLong, PendingIntent paramPendingIntent, String paramString1, String paramString2)
      {
        // Byte code:
        //   0: invokestatic 25	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore 11
        //   5: aload 11
        //   7: ldc 27
        //   9: invokevirtual 31	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   12: aload 11
        //   14: dload_1
        //   15: invokevirtual 51	android/os/Parcel:writeDouble	(D)V
        //   18: aload 11
        //   20: dload_3
        //   21: invokevirtual 51	android/os/Parcel:writeDouble	(D)V
        //   24: aload 11
        //   26: fload 5
        //   28: invokevirtual 55	android/os/Parcel:writeFloat	(F)V
        //   31: aload 11
        //   33: lload 6
        //   35: invokevirtual 59	android/os/Parcel:writeLong	(J)V
        //   38: aload 8
        //   40: ifnull +53 -> 93
        //   43: aload 11
        //   45: iconst_1
        //   46: invokevirtual 63	android/os/Parcel:writeInt	(I)V
        //   49: aload 8
        //   51: aload 11
        //   53: iconst_0
        //   54: invokevirtual 69	android/app/PendingIntent:writeToParcel	(Landroid/os/Parcel;I)V
        //   57: aload 11
        //   59: aload 9
        //   61: invokevirtual 72	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   64: aload 11
        //   66: aload 10
        //   68: invokevirtual 72	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   71: aload_0
        //   72: getfield 17	com/xiaomi/metok/geofencing/c$a$a:a	Landroid/os/IBinder;
        //   75: bipush 7
        //   77: aload 11
        //   79: aconst_null
        //   80: iconst_1
        //   81: invokeinterface 37 5 0
        //   86: pop
        //   87: aload 11
        //   89: invokevirtual 46	android/os/Parcel:recycle	()V
        //   92: return
        //   93: aload 11
        //   95: iconst_0
        //   96: invokevirtual 63	android/os/Parcel:writeInt	(I)V
        //   99: goto -42 -> 57
        //   102: astore 8
        //   104: aload 11
        //   106: invokevirtual 46	android/os/Parcel:recycle	()V
        //   109: aload 8
        //   111: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	112	0	this	a
        //   0	112	1	paramDouble1	double
        //   0	112	3	paramDouble2	double
        //   0	112	5	paramFloat	float
        //   0	112	6	paramLong	long
        //   0	112	8	paramPendingIntent	PendingIntent
        //   0	112	9	paramString1	String
        //   0	112	10	paramString2	String
        //   3	102	11	localParcel	Parcel
        // Exception table:
        //   from	to	target	type
        //   5	38	102	finally
        //   43	57	102	finally
        //   57	87	102	finally
        //   93	99	102	finally
      }
      
      public void a(double paramDouble1, double paramDouble2, float paramFloat, long paramLong, String paramString1, String paramString2, String paramString3)
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.xiaomi.metok.geofencing.IGeoFencing");
          localParcel.writeDouble(paramDouble1);
          localParcel.writeDouble(paramDouble2);
          localParcel.writeFloat(paramFloat);
          localParcel.writeLong(paramLong);
          localParcel.writeString(paramString1);
          localParcel.writeString(paramString2);
          localParcel.writeString(paramString3);
          this.a.transact(6, localParcel, null, 1);
          return;
        }
        finally
        {
          localParcel.recycle();
        }
      }
      
      /* Error */
      public void a(PendingIntent paramPendingIntent)
      {
        // Byte code:
        //   0: invokestatic 25	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_2
        //   4: aload_2
        //   5: ldc 27
        //   7: invokevirtual 31	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   10: aload_1
        //   11: ifnull +34 -> 45
        //   14: aload_2
        //   15: iconst_1
        //   16: invokevirtual 63	android/os/Parcel:writeInt	(I)V
        //   19: aload_1
        //   20: aload_2
        //   21: iconst_0
        //   22: invokevirtual 69	android/app/PendingIntent:writeToParcel	(Landroid/os/Parcel;I)V
        //   25: aload_0
        //   26: getfield 17	com/xiaomi/metok/geofencing/c$a$a:a	Landroid/os/IBinder;
        //   29: bipush 9
        //   31: aload_2
        //   32: aconst_null
        //   33: iconst_1
        //   34: invokeinterface 37 5 0
        //   39: pop
        //   40: aload_2
        //   41: invokevirtual 46	android/os/Parcel:recycle	()V
        //   44: return
        //   45: aload_2
        //   46: iconst_0
        //   47: invokevirtual 63	android/os/Parcel:writeInt	(I)V
        //   50: goto -25 -> 25
        //   53: astore_1
        //   54: aload_2
        //   55: invokevirtual 46	android/os/Parcel:recycle	()V
        //   58: aload_1
        //   59: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	60	0	this	a
        //   0	60	1	paramPendingIntent	PendingIntent
        //   3	52	2	localParcel	Parcel
        // Exception table:
        //   from	to	target	type
        //   4	10	53	finally
        //   14	25	53	finally
        //   25	40	53	finally
        //   45	50	53	finally
      }
      
      public void a(String paramString)
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.xiaomi.metok.geofencing.IGeoFencing");
          localParcel.writeString(paramString);
          this.a.transact(2, localParcel, null, 1);
          return;
        }
        finally
        {
          localParcel.recycle();
        }
      }
      
      public void a(String paramString1, String paramString2)
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.xiaomi.metok.geofencing.IGeoFencing");
          localParcel.writeString(paramString1);
          localParcel.writeString(paramString2);
          this.a.transact(8, localParcel, null, 1);
          return;
        }
        finally
        {
          localParcel.recycle();
        }
      }
      
      public void a(List<String> paramList, String paramString)
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.xiaomi.metok.geofencing.IGeoFencing");
          localParcel.writeStringList(paramList);
          localParcel.writeString(paramString);
          this.a.transact(1, localParcel, null, 1);
          return;
        }
        finally
        {
          localParcel.recycle();
        }
      }
      
      public IBinder asBinder()
      {
        return this.a;
      }
      
      public int b()
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.xiaomi.metok.geofencing.IGeoFencing");
          this.a.transact(5, localParcel1, localParcel2, 0);
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
      
      public List<String> b(String paramString)
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.xiaomi.metok.geofencing.IGeoFencing");
          localParcel1.writeString(paramString);
          this.a.transact(4, localParcel1, localParcel2, 0);
          localParcel2.readException();
          paramString = localParcel2.createStringArrayList();
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


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/xiaomi/metok/geofencing/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */