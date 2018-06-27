package com.unionpay.mobile.android.pboctransaction.remoteapdu;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import com.unionpay.mobile.android.pboctransaction.AppIdentification;
import com.unionpay.mobile.android.pboctransaction.d;
import com.unionpay.mobile.android.pboctransaction.e;
import com.unionpay.mobile.android.utils.j;
import com.unionpay.mobile.tsm.connect.IInitCallback.Stub;
import com.unionpay.mobile.tsm.connect.IRemoteApdu;
import java.util.ArrayList;
import java.util.Iterator;

public final class a
  implements com.unionpay.mobile.android.pboctransaction.c
{
  com.unionpay.mobile.android.pboctransaction.b a;
  private IRemoteApdu b = null;
  private boolean c = false;
  private Context d = null;
  private final ServiceConnection e = new b(this);
  private final IInitCallback.Stub f = new c(this);
  
  public final String a(String paramString)
  {
    return "";
  }
  
  public final ArrayList<com.unionpay.mobile.android.model.c> a(d paramd)
  {
    AppIdentification localAppIdentification = null;
    j.a("plugin-tsm", "RemoteApduEngine.readList() +++");
    Object localObject3;
    for (;;)
    {
      try
      {
        if (!this.c) {
          continue;
        }
        localObject1 = "D15600010100016111000000B0004101";
        j.a("plugin-tsm", "sid=" + (String)localObject1);
        localObject3 = this.b.writeApdu("00a4040010" + (String)localObject1, 0);
        localObject1 = localObject3;
        if (localObject3 != null)
        {
          localObject1 = localObject3;
          if (((String)localObject3).equalsIgnoreCase("9000")) {
            localObject1 = this.b.writeApdu("80CA2F0000", 0);
          }
        }
        localObject1 = e.b((String)localObject1);
      }
      catch (Exception localException)
      {
        Object localObject1;
        String str;
        localException.printStackTrace();
        j.c("plugin-tsm", localException.getMessage());
        Object localObject2 = null;
        continue;
        j.a("plugin-tsm", "RemoteApduEngine.readList() ---");
      }
      localObject3 = localAppIdentification;
      if (localObject1 == null) {
        continue;
      }
      localObject3 = localAppIdentification;
      if (((ArrayList)localObject1).size() <= 0) {
        continue;
      }
      localObject3 = new ArrayList();
      localObject1 = ((ArrayList)localObject1).iterator();
      if (!((Iterator)localObject1).hasNext()) {
        continue;
      }
      localAppIdentification = (AppIdentification)((Iterator)localObject1).next();
      if ((localAppIdentification.c()) && (!"06".equalsIgnoreCase(localAppIdentification.b())))
      {
        str = e.c(paramd.a(localAppIdentification));
        if ((str != null) && (str.length() > 0))
        {
          ((ArrayList)localObject3).add(new com.unionpay.mobile.android.model.a(4, localAppIdentification.a(), "", str, 1));
          continue;
          localObject1 = "D15600010100016111000000B0004001";
        }
      }
    }
    return (ArrayList<com.unionpay.mobile.android.model.c>)localObject3;
  }
  
  public final void a()
  {
    d();
    if (this.d != null)
    {
      Context localContext = this.d;
      j.a("plugin-tsm", "unbindTSMService() ++");
      new Intent("com.unionpay.mobile.tsm.PBOCService").setPackage("com.unionpay.mobile.tsm");
      localContext.unbindService(this.e);
    }
  }
  
  public final void a(com.unionpay.mobile.android.pboctransaction.b paramb, Context paramContext)
  {
    this.a = paramb;
    this.d = paramContext;
    paramb = new Intent("com.unionpay.mobile.tsm.PBOCService");
    paramb.setPackage("com.unionpay.mobile.tsm");
    paramContext.startService(paramb);
    if ((!paramContext.bindService(paramb, this.e, 1)) && (this.a != null))
    {
      j.a("plugin-tsm", "startTSMService.initFailed()");
      this.a.b();
    }
  }
  
  public final void a(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
  
  public final byte[] a(byte[] paramArrayOfByte, int paramInt)
  {
    Object localObject = null;
    if (paramArrayOfByte == null) {
      return null;
    }
    paramArrayOfByte = e.a(paramArrayOfByte);
    j.a("plugin-tsm", "[---->]" + paramArrayOfByte);
    try
    {
      paramArrayOfByte = this.b.writeApdu(paramArrayOfByte, paramInt);
      j.a("plugin-tsm", "[<----]" + paramArrayOfByte);
      return e.a(paramArrayOfByte);
    }
    catch (Exception paramArrayOfByte)
    {
      for (;;)
      {
        paramArrayOfByte.printStackTrace();
        paramArrayOfByte = (byte[])localObject;
      }
    }
  }
  
  public final void b() {}
  
  public final void c()
  {
    d();
  }
  
  public final void d()
  {
    if (this.b != null) {}
    try
    {
      this.b.closeChannel(0);
      this.b.closeChannel(1);
      this.b.closeChannel(2);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/mobile/android/pboctransaction/remoteapdu/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */