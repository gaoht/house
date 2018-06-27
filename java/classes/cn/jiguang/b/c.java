package cn.jiguang.b;

import android.os.IBinder;
import android.os.Parcel;

final class c
  implements a
{
  private static final String z;
  private IBinder a;
  
  static
  {
    Object localObject1 = "2\rz\r\b6\0265\t\006\002:\003\023>\n0I(\025\002 \00629\002&\002".toCharArray();
    int j = localObject1.length;
    int m = 0;
    int i = 0;
    Object localObject2 = localObject1;
    int k = j;
    label30:
    int n;
    if (j <= 1)
    {
      m = i;
      k = i;
      localObject2 = localObject1;
      n = localObject2[k];
      switch (m % 5)
      {
      default: 
        i = 97;
      }
    }
    for (;;)
    {
      localObject2[k] = ((char)(i ^ n));
      m += 1;
      if (j == 0)
      {
        k = j;
        break label30;
      }
      k = j;
      localObject2 = localObject1;
      localObject1 = localObject2;
      j = k;
      i = m;
      if (k > m) {
        break;
      }
      z = new String((char[])localObject2).intern();
      return;
      i = 81;
      continue;
      i = 99;
      continue;
      i = 84;
      continue;
      i = 103;
    }
  }
  
  c(IBinder paramIBinder)
  {
    this.a = paramIBinder;
  }
  
  public final int a(String paramString, int paramInt)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken(z);
      localParcel1.writeString(paramString);
      localParcel1.writeInt(paramInt);
      this.a.transact(2, localParcel1, localParcel2, 0);
      localParcel2.readException();
      paramInt = localParcel2.readInt();
      return paramInt;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public final long a(String paramString, long paramLong)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken(z);
      localParcel1.writeString(paramString);
      localParcel1.writeLong(paramLong);
      this.a.transact(4, localParcel1, localParcel2, 0);
      localParcel2.readException();
      paramLong = localParcel2.readLong();
      return paramLong;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public final String a(String paramString1, String paramString2)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken(z);
      localParcel1.writeString(paramString1);
      localParcel1.writeString(paramString2);
      this.a.transact(8, localParcel1, localParcel2, 0);
      localParcel2.readException();
      paramString1 = localParcel2.readString();
      return paramString1;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  /* Error */
  public final void a(int paramInt, long paramLong, boolean paramBoolean, float paramFloat, double paramDouble, String paramString)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 9
    //   3: invokestatic 43	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   6: astore 10
    //   8: invokestatic 43	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   11: astore 11
    //   13: aload 10
    //   15: getstatic 30	cn/jiguang/b/c:z	Ljava/lang/String;
    //   18: invokevirtual 47	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   21: aload 10
    //   23: iload_1
    //   24: invokevirtual 54	android/os/Parcel:writeInt	(I)V
    //   27: aload 10
    //   29: lload_2
    //   30: invokevirtual 75	android/os/Parcel:writeLong	(J)V
    //   33: iload 4
    //   35: ifeq +65 -> 100
    //   38: iload 9
    //   40: istore_1
    //   41: aload 10
    //   43: iload_1
    //   44: invokevirtual 54	android/os/Parcel:writeInt	(I)V
    //   47: aload 10
    //   49: fload 5
    //   51: invokevirtual 88	android/os/Parcel:writeFloat	(F)V
    //   54: aload 10
    //   56: dload 6
    //   58: invokevirtual 92	android/os/Parcel:writeDouble	(D)V
    //   61: aload 10
    //   63: aload 8
    //   65: invokevirtual 50	android/os/Parcel:writeString	(Ljava/lang/String;)V
    //   68: aload_0
    //   69: getfield 36	cn/jiguang/b/c:a	Landroid/os/IBinder;
    //   72: iconst_1
    //   73: aload 10
    //   75: aload 11
    //   77: iconst_0
    //   78: invokeinterface 60 5 0
    //   83: pop
    //   84: aload 11
    //   86: invokevirtual 63	android/os/Parcel:readException	()V
    //   89: aload 11
    //   91: invokevirtual 70	android/os/Parcel:recycle	()V
    //   94: aload 10
    //   96: invokevirtual 70	android/os/Parcel:recycle	()V
    //   99: return
    //   100: iconst_0
    //   101: istore_1
    //   102: goto -61 -> 41
    //   105: astore 8
    //   107: aload 11
    //   109: invokevirtual 70	android/os/Parcel:recycle	()V
    //   112: aload 10
    //   114: invokevirtual 70	android/os/Parcel:recycle	()V
    //   117: aload 8
    //   119: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	120	0	this	c
    //   0	120	1	paramInt	int
    //   0	120	2	paramLong	long
    //   0	120	4	paramBoolean	boolean
    //   0	120	5	paramFloat	float
    //   0	120	6	paramDouble	double
    //   0	120	8	paramString	String
    //   1	38	9	i	int
    //   6	107	10	localParcel1	Parcel
    //   11	97	11	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   13	33	105	finally
    //   41	89	105	finally
  }
  
  public final boolean a()
  {
    boolean bool = false;
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken(z);
      this.a.transact(10, localParcel1, localParcel2, 0);
      localParcel2.readException();
      int i = localParcel2.readInt();
      if (i != 0) {
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
  public final boolean a(String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 4
    //   3: invokestatic 43	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   6: astore 5
    //   8: invokestatic 43	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   11: astore 6
    //   13: aload 5
    //   15: getstatic 30	cn/jiguang/b/c:z	Ljava/lang/String;
    //   18: invokevirtual 47	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   21: aload 5
    //   23: aload_1
    //   24: invokevirtual 50	android/os/Parcel:writeString	(Ljava/lang/String;)V
    //   27: iload_2
    //   28: ifeq +58 -> 86
    //   31: iconst_1
    //   32: istore_3
    //   33: aload 5
    //   35: iload_3
    //   36: invokevirtual 54	android/os/Parcel:writeInt	(I)V
    //   39: aload_0
    //   40: getfield 36	cn/jiguang/b/c:a	Landroid/os/IBinder;
    //   43: bipush 6
    //   45: aload 5
    //   47: aload 6
    //   49: iconst_0
    //   50: invokeinterface 60 5 0
    //   55: pop
    //   56: aload 6
    //   58: invokevirtual 63	android/os/Parcel:readException	()V
    //   61: aload 6
    //   63: invokevirtual 67	android/os/Parcel:readInt	()I
    //   66: istore_3
    //   67: iload_3
    //   68: ifeq +23 -> 91
    //   71: iload 4
    //   73: istore_2
    //   74: aload 6
    //   76: invokevirtual 70	android/os/Parcel:recycle	()V
    //   79: aload 5
    //   81: invokevirtual 70	android/os/Parcel:recycle	()V
    //   84: iload_2
    //   85: ireturn
    //   86: iconst_0
    //   87: istore_3
    //   88: goto -55 -> 33
    //   91: iconst_0
    //   92: istore_2
    //   93: goto -19 -> 74
    //   96: astore_1
    //   97: aload 6
    //   99: invokevirtual 70	android/os/Parcel:recycle	()V
    //   102: aload 5
    //   104: invokevirtual 70	android/os/Parcel:recycle	()V
    //   107: aload_1
    //   108: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	109	0	this	c
    //   0	109	1	paramString	String
    //   0	109	2	paramBoolean	boolean
    //   32	56	3	i	int
    //   1	71	4	bool	boolean
    //   6	97	5	localParcel1	Parcel
    //   11	87	6	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   13	27	96	finally
    //   33	67	96	finally
  }
  
  public final IBinder asBinder()
  {
    return this.a;
  }
  
  public final void b(String paramString, int paramInt)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken(z);
      localParcel1.writeString(paramString);
      localParcel1.writeInt(paramInt);
      this.a.transact(3, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public final void b(String paramString, long paramLong)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken(z);
      localParcel1.writeString(paramString);
      localParcel1.writeLong(paramLong);
      this.a.transact(5, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public final void b(String paramString1, String paramString2)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken(z);
      localParcel1.writeString(paramString1);
      localParcel1.writeString(paramString2);
      this.a.transact(9, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public final void b(String paramString, boolean paramBoolean)
  {
    int i = 0;
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken(z);
      localParcel1.writeString(paramString);
      if (paramBoolean) {
        i = 1;
      }
      localParcel1.writeInt(i);
      this.a.transact(7, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public final IBinder c(String paramString1, String paramString2)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken(z);
      localParcel1.writeString(paramString1);
      localParcel1.writeString(paramString2);
      this.a.transact(11, localParcel1, localParcel2, 0);
      localParcel2.readException();
      paramString1 = localParcel2.readStrongBinder();
      return paramString1;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/jiguang/b/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */