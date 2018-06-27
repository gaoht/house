package com.unionpay.mobile.android.pboctransaction.icfcc;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.RemoteException;
import com.unionpay.mobile.android.pboctransaction.AppIdentification;
import com.unionpay.mobile.android.pboctransaction.d;
import com.unionpay.mobile.android.pboctransaction.e;
import com.unionpay.mobile.android.utils.j;
import java.util.ArrayList;

public final class a
  implements com.unionpay.mobile.android.pboctransaction.c
{
  private String a = null;
  private String b = "A0000003334355502D4D4F42494C45";
  private cn.a.a.a.a.a.a.a.a.a c;
  private com.unionpay.mobile.android.pboctransaction.b d;
  private Context e;
  private ServiceConnection f = new b(this);
  
  private byte[] a(byte[] paramArrayOfByte)
  {
    localObject = null;
    for (;;)
    {
      try
      {
        str = e.a(paramArrayOfByte);
        paramArrayOfByte = (byte[])localObject;
        if (b(str))
        {
          if (!str.contains(this.a)) {
            continue;
          }
          j.c("icfcc", "pbocAID = " + this.a);
          paramArrayOfByte = this.c.a(e.a(this.a), "00");
        }
      }
      catch (Exception paramArrayOfByte)
      {
        String str;
        paramArrayOfByte = (byte[])localObject;
        continue;
      }
      j.c("icfcc", " openSEChannel result=" + e.a(paramArrayOfByte));
      return paramArrayOfByte;
      paramArrayOfByte = (byte[])localObject;
      if (str.contains(this.b))
      {
        j.c("icfcc", "upcardAID = " + this.b);
        paramArrayOfByte = this.c.a(e.a(this.b), "01");
      }
    }
  }
  
  private static boolean b(String paramString)
  {
    return (paramString.startsWith("00A40400")) || (paramString.startsWith("01A40400")) || (paramString.startsWith("02A40400"));
  }
  
  public final String a(String paramString)
  {
    return "";
  }
  
  public final ArrayList<com.unionpay.mobile.android.model.c> a(d paramd)
  {
    if (this.c == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    try
    {
      Object localObject = c.a(e.a(this.c.a(e.a("325041592e5359532e4444463031"), "00")), "4F");
      j.c("icfcc", "aid =" + (String)localObject);
      if (localObject != null)
      {
        this.a = ((String)localObject);
        localObject = new AppIdentification((String)localObject, "");
        paramd = e.c(paramd.a((AppIdentification)localObject));
        if ((paramd != null) && (paramd.length() > 0))
        {
          j.c("icfcc", "  " + paramd);
          localArrayList.add(new com.unionpay.mobile.android.model.a(8, ((AppIdentification)localObject).a(), "", paramd, 1));
        }
      }
      try
      {
        this.c.b("00");
        return localArrayList;
      }
      catch (RemoteException paramd)
      {
        for (;;)
        {
          paramd.printStackTrace();
        }
      }
      try
      {
        this.c.b("00");
        throw paramd;
      }
      catch (RemoteException localRemoteException)
      {
        for (;;)
        {
          localRemoteException.printStackTrace();
        }
      }
    }
    catch (Exception paramd)
    {
      paramd = paramd;
      try
      {
        this.c.b("00");
        return null;
      }
      catch (RemoteException paramd)
      {
        for (;;)
        {
          paramd.printStackTrace();
        }
      }
    }
    finally {}
  }
  
  public final void a()
  {
    d();
    if (this.c != null) {}
    try
    {
      this.c.a();
      if (this.e != null)
      {
        new Intent("com.unionpay.mobile.tsm.PBOCService");
        this.e.unbindService(this.f);
      }
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        localRemoteException.printStackTrace();
      }
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  public final void a(com.unionpay.mobile.android.pboctransaction.b paramb, Context paramContext)
  {
    this.d = paramb;
    this.e = paramContext;
    Intent localIntent = new Intent("cn.gov.pbc.tsm.client.mobile.android.bank.service");
    localIntent.setPackage("cn.gov.pbc.tsm.client.mobile.andorid");
    paramContext.startService(localIntent);
    if ((!paramContext.bindService(localIntent, this.f, 1)) && (paramb != null))
    {
      j.a("icfcc", "startTSMService.initFailed()");
      paramb.b();
    }
  }
  
  public final byte[] a(byte[] paramArrayOfByte, int paramInt)
  {
    Object localObject = null;
    String str = e.a(paramArrayOfByte);
    j.c("icfcc", "====>" + str);
    if (this.c == null) {
      return null;
    }
    if (b(str)) {
      return a(paramArrayOfByte);
    }
    try
    {
      paramArrayOfByte = this.c.b(paramArrayOfByte);
      j.c("icfcc", "<====" + e.a(paramArrayOfByte));
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte)
    {
      for (;;)
      {
        paramArrayOfByte = (byte[])localObject;
      }
    }
    catch (RemoteException paramArrayOfByte)
    {
      for (;;)
      {
        paramArrayOfByte = (byte[])localObject;
      }
    }
  }
  
  public final void b() {}
  
  public final void c() {}
  
  public final void d()
  {
    if (this.c != null) {}
    try
    {
      this.c.b("00");
      this.c.b("01");
      return;
    }
    catch (RemoteException localRemoteException)
    {
      localRemoteException.printStackTrace();
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/mobile/android/pboctransaction/icfcc/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */