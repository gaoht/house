package com.unionpay.mobile.android.pboctransaction.samsung;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Handler.Callback;
import com.unionpay.client3.tsm.ITsmConnection;
import com.unionpay.mobile.android.pboctransaction.e;
import com.unionpay.mobile.android.utils.j;

public final class b
  implements com.unionpay.mobile.android.pboctransaction.c
{
  private Context a;
  private com.unionpay.mobile.android.pboctransaction.b b;
  private ITsmConnection c;
  private int d = 0;
  private Handler.Callback e = new c(this);
  private Handler f = new Handler(this.e);
  
  private void a(boolean paramBoolean)
  {
    if (this.b != null)
    {
      if (paramBoolean) {
        this.b.a();
      }
    }
    else {
      return;
    }
    this.b.b();
  }
  
  public final String a(String paramString)
  {
    return "";
  }
  
  /* Error */
  public final java.util.ArrayList<com.unionpay.mobile.android.model.c> a(com.unionpay.mobile.android.pboctransaction.d paramd)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore 6
    //   6: aconst_null
    //   7: astore 5
    //   9: aload 4
    //   11: astore_1
    //   12: aload_0
    //   13: getfield 43	com/unionpay/mobile/android/pboctransaction/samsung/b:c	Lcom/unionpay/client3/tsm/ITsmConnection;
    //   16: ifnull +170 -> 186
    //   19: aload_0
    //   20: getfield 43	com/unionpay/mobile/android/pboctransaction/samsung/b:c	Lcom/unionpay/client3/tsm/ITsmConnection;
    //   23: aload_0
    //   24: getfield 24	com/unionpay/mobile/android/pboctransaction/samsung/b:d	I
    //   27: invokeinterface 69 2 0
    //   32: astore 7
    //   34: aload 4
    //   36: astore_1
    //   37: aload 7
    //   39: ifnull +147 -> 186
    //   42: aload 4
    //   44: astore_1
    //   45: aload 7
    //   47: arraylength
    //   48: ifle +138 -> 186
    //   51: new 71	java/util/ArrayList
    //   54: dup
    //   55: invokespecial 72	java/util/ArrayList:<init>	()V
    //   58: astore_1
    //   59: iconst_0
    //   60: istore_2
    //   61: iload_2
    //   62: aload 7
    //   64: arraylength
    //   65: if_icmpge +150 -> 215
    //   68: aload 7
    //   70: iload_2
    //   71: aaload
    //   72: invokevirtual 78	com/unionpay/client3/tsm/SeAppInfo:getAppAid	()Ljava/lang/String;
    //   75: astore 4
    //   77: aload 4
    //   79: ifnull +90 -> 169
    //   82: aload 4
    //   84: ldc 80
    //   86: invokevirtual 86	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   89: ifeq +80 -> 169
    //   92: aload 7
    //   94: iload_2
    //   95: aaload
    //   96: invokevirtual 78	com/unionpay/client3/tsm/SeAppInfo:getAppAid	()Ljava/lang/String;
    //   99: astore 4
    //   101: aload 4
    //   103: ifnull +107 -> 210
    //   106: aload 4
    //   108: invokevirtual 90	java/lang/String:length	()I
    //   111: bipush 16
    //   113: if_icmple +97 -> 210
    //   116: ldc 92
    //   118: aload 4
    //   120: bipush 14
    //   122: bipush 16
    //   124: invokevirtual 96	java/lang/String:substring	(II)Ljava/lang/String;
    //   127: invokevirtual 99	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   130: ifne +80 -> 210
    //   133: iconst_0
    //   134: istore_3
    //   135: iload_3
    //   136: ifne +33 -> 169
    //   139: aload_1
    //   140: new 101	com/unionpay/mobile/android/model/a
    //   143: dup
    //   144: iconst_1
    //   145: aload 7
    //   147: iload_2
    //   148: aaload
    //   149: invokevirtual 78	com/unionpay/client3/tsm/SeAppInfo:getAppAid	()Ljava/lang/String;
    //   152: ldc 58
    //   154: aload 7
    //   156: iload_2
    //   157: aaload
    //   158: invokevirtual 104	com/unionpay/client3/tsm/SeAppInfo:getPan	()Ljava/lang/String;
    //   161: iconst_1
    //   162: invokespecial 107	com/unionpay/mobile/android/model/a:<init>	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V
    //   165: invokevirtual 111	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   168: pop
    //   169: iload_2
    //   170: iconst_1
    //   171: iadd
    //   172: istore_2
    //   173: goto -112 -> 61
    //   176: astore 4
    //   178: aload 5
    //   180: astore_1
    //   181: aload 4
    //   183: invokevirtual 114	android/os/RemoteException:printStackTrace	()V
    //   186: aload_1
    //   187: areturn
    //   188: astore 4
    //   190: aload 6
    //   192: astore_1
    //   193: aload 4
    //   195: invokevirtual 115	java/lang/Exception:printStackTrace	()V
    //   198: aload_1
    //   199: areturn
    //   200: astore 4
    //   202: goto -9 -> 193
    //   205: astore 4
    //   207: goto -26 -> 181
    //   210: iconst_1
    //   211: istore_3
    //   212: goto -77 -> 135
    //   215: aload_1
    //   216: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	217	0	this	b
    //   0	217	1	paramd	com.unionpay.mobile.android.pboctransaction.d
    //   60	113	2	i	int
    //   134	78	3	j	int
    //   1	118	4	str	String
    //   176	6	4	localRemoteException1	android.os.RemoteException
    //   188	6	4	localException1	Exception
    //   200	1	4	localException2	Exception
    //   205	1	4	localRemoteException2	android.os.RemoteException
    //   7	172	5	localObject1	Object
    //   4	187	6	localObject2	Object
    //   32	123	7	arrayOfSeAppInfo	com.unionpay.client3.tsm.SeAppInfo[]
    // Exception table:
    //   from	to	target	type
    //   19	34	176	android/os/RemoteException
    //   45	59	176	android/os/RemoteException
    //   19	34	188	java/lang/Exception
    //   45	59	188	java/lang/Exception
    //   61	77	200	java/lang/Exception
    //   82	101	200	java/lang/Exception
    //   106	133	200	java/lang/Exception
    //   139	169	200	java/lang/Exception
    //   61	77	205	android/os/RemoteException
    //   82	101	205	android/os/RemoteException
    //   106	133	205	android/os/RemoteException
    //   139	169	205	android/os/RemoteException
  }
  
  public final void a() {}
  
  public final void a(com.unionpay.mobile.android.pboctransaction.b paramb, Context paramContext)
  {
    this.b = paramb;
    this.a = paramContext;
    paramb = new Intent();
    paramb.setAction("com.unionpay.client3.action.TSM_MODEL");
    paramb.setPackage("com.unionpay");
    paramContext.startService(paramb);
    if (!paramContext.bindService(paramb, new d(this), 1))
    {
      j.a("plugin-clientV3", "startSamsungService() failed!!!");
      a(false);
      return;
    }
    paramb = this.f.obtainMessage(1);
    this.f.sendMessageDelayed(paramb, 5000L);
  }
  
  public final byte[] a(byte[] paramArrayOfByte, int paramInt)
  {
    byte[] arrayOfByte = null;
    if (this.c != null) {}
    try
    {
      j.a("plugin-clientV3", "--->" + e.a(paramArrayOfByte));
      paramArrayOfByte = this.c.sendApdu(this.d, e.a(paramArrayOfByte), paramInt);
      j.a("plugin-clientV3", "<---" + paramArrayOfByte);
      arrayOfByte = e.a(paramArrayOfByte);
      return arrayOfByte;
    }
    catch (Exception paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return null;
  }
  
  public final void b() {}
  
  public final void c() {}
  
  public final void d() {}
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/mobile/android/pboctransaction/samsung/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */