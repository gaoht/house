package com.unionpay.mobile.android.pboctransaction.simapdu;

import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.text.TextUtils;
import android.util.Log;
import com.unionpay.mobile.android.model.a;
import com.unionpay.mobile.android.pboctransaction.AppIdentification;
import com.unionpay.mobile.android.pboctransaction.d;
import com.unionpay.mobile.android.pboctransaction.e;
import com.unionpay.mobile.android.utils.j;
import com.unionpay.mobile.android.utils.k;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import org.simalliance.openmobileapi.Channel;
import org.simalliance.openmobileapi.Reader;
import org.simalliance.openmobileapi.SEService;
import org.simalliance.openmobileapi.Session;

public final class b
  implements com.unionpay.mobile.android.pboctransaction.c
{
  private static b d = new b();
  private SEService a = null;
  private Channel[] b = new Channel[3];
  private com.unionpay.mobile.android.pboctransaction.b c;
  private Handler.Callback e = new c(this);
  private Handler f = new Handler(this.e);
  
  private String a(String paramString, int paramInt)
    throws a.a
  {
    String str = null;
    byte[] arrayOfByte = null;
    int j = 0;
    if (paramString == null)
    {
      paramString = arrayOfByte;
      return paramString;
    }
    for (;;)
    {
      int i;
      try
      {
        j.a("plugin-sim", "====>" + paramString);
        paramString = paramString.toUpperCase(Locale.CHINA);
        i = paramInt;
        if (paramInt > this.b.length) {
          i = 0;
        }
        if ((paramString.startsWith("00A40400")) || (paramString.startsWith("01A40400"))) {
          break label268;
        }
        paramInt = j;
        if (paramString.startsWith("02A40400")) {
          break label268;
        }
        if (paramInt != 0)
        {
          a(i);
          str = b(e.a(paramString.substring(10, (Integer.parseInt(paramString.substring(8, 9), 16) * 16 + Integer.parseInt(paramString.substring(9, 10), 16)) * 2 + 10)), i);
          paramString = str;
          if (!TextUtils.isEmpty(str)) {
            break;
          }
          j.c("plugin-sim", " writeApdu openchannel exception!!!");
          throw new a.a();
        }
      }
      finally {}
      try
      {
        arrayOfByte = e.a(paramString);
        paramString = str;
        if (arrayOfByte != null) {
          paramString = e.a(this.b[i].transmit(arrayOfByte));
        }
      }
      catch (IOException paramString)
      {
        paramString.printStackTrace();
        throw new a.a();
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          paramString.printStackTrace();
          paramString = str;
        }
      }
      j.a("plugin-sim", "<====" + paramString);
      break;
      label268:
      paramInt = 1;
    }
  }
  
  private void a(int paramInt)
  {
    j.a("plugin-sim", "closeChannel(int) +++");
    if ((this.b[paramInt] != null) && (paramInt <= this.b.length)) {}
    try
    {
      this.b[paramInt].close();
      this.b[paramInt] = null;
      j.a("plugin-sim", "closeChannel(int) ---");
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        j.a("plugin-sim", " mChannel[channel].close() exception!!!");
      }
    }
  }
  
  private String b(byte[] paramArrayOfByte, int paramInt)
  {
    try
    {
      Reader[] arrayOfReader = this.a.getReaders();
      if (arrayOfReader.length > 0)
      {
        paramArrayOfByte = arrayOfReader[0].openSession().openLogicalChannel(paramArrayOfByte);
        if (paramArrayOfByte != null)
        {
          this.b[paramInt] = paramArrayOfByte;
          paramArrayOfByte = e.a(paramArrayOfByte.getSelectResponse());
          return paramArrayOfByte;
        }
      }
    }
    catch (Throwable paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return "";
  }
  
  public static b e()
  {
    try
    {
      b localb = d;
      return localb;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final String a(String paramString)
  {
    return "";
  }
  
  public final ArrayList<com.unionpay.mobile.android.model.c> a(d paramd)
  {
    ArrayList localArrayList = null;
    Object localObject1 = null;
    j.c("plugin-sim", " SIMEngine.readList() +++");
    for (;;)
    {
      try
      {
        Object localObject2 = new ArrayList(1);
        String str = paramd.a("A0000003330101");
        j.c("plugin-sim", "full AID:" + str);
        if (str == null) {
          break;
        }
        if (str.length() < 16) {
          return null;
        }
        ((ArrayList)localObject2).add(new AppIdentification(str, null));
        if (((ArrayList)localObject2).size() <= 0) {
          continue;
        }
        localArrayList = new ArrayList();
        try
        {
          localObject1 = ((ArrayList)localObject2).iterator();
          if (!((Iterator)localObject1).hasNext()) {
            continue;
          }
          localObject2 = (AppIdentification)((Iterator)localObject1).next();
          if ("06".equalsIgnoreCase(((AppIdentification)localObject2).b())) {
            continue;
          }
          str = e.c(paramd.a((AppIdentification)localObject2));
          j.a("nfcphone", " cardNumber=" + str);
          if ((str == null) || (str.length() <= 0)) {
            continue;
          }
          localArrayList.add(new a(16, ((AppIdentification)localObject2).a(), "", str, 1));
          j.a("nfcphone", " valid Number= " + str);
          continue;
          Log.e("plugin-sim", " SimEngine Exception = " + ((Throwable)localObject1).getMessage());
        }
        catch (Throwable paramd)
        {
          localObject1 = paramd;
          paramd = localArrayList;
        }
      }
      catch (Throwable localThrowable)
      {
        paramd = (d)localObject1;
        localObject1 = localThrowable;
        continue;
      }
      j.c("plugin-sim", " SIMEngine.readList() ---");
      return paramd;
      paramd = localArrayList;
      continue;
      Log.e("plugin-sim", " SIMEngine --- there has no PBOC aids!!!");
      paramd = localArrayList;
    }
    return null;
  }
  
  public final void a()
  {
    j.c("plugin-sim", "SIMEngine.destroy() +++ ");
    j.c("plugin-sim", " mSEService = " + this.a);
    d();
    if ((this.a != null) && (this.a.isConnected()))
    {
      j.a("TAG", " mSEService.isConnected() = " + this.a.isConnected());
      j.c("plugin-sim", " mSEService.shutdown() ");
      this.a.shutdown();
    }
    j.c("plugin-sim", "SIMEngine.destroy() --- ");
  }
  
  public final void a(com.unionpay.mobile.android.pboctransaction.b paramb, Context paramContext)
  {
    this.c = paramb;
    try
    {
      new k();
      if ((k.a() != null) && (k.a().isConnected()))
      {
        this.a = k.a();
        this.f.sendEmptyMessage(1);
        return;
      }
      this.f.sendEmptyMessage(2);
      return;
    }
    catch (Throwable paramb)
    {
      paramb.printStackTrace();
      Log.e("plugin-sim", " service ERROR!!!");
      this.f.sendEmptyMessage(2);
    }
  }
  
  public final byte[] a(byte[] paramArrayOfByte, int paramInt)
  {
    j.c("plugin-sim", " SIMEngine.sendApdu() +++");
    Object localObject = null;
    try
    {
      paramArrayOfByte = e.a(a(e.a(paramArrayOfByte), paramInt));
      j.c("plugin-sim", " SIMEngine.sendApdu() ---");
      return paramArrayOfByte;
    }
    catch (a.a paramArrayOfByte)
    {
      for (;;)
      {
        paramArrayOfByte.printStackTrace();
        j.c("plugin-sim", " " + paramArrayOfByte.getMessage());
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
    j.a("plugin-sim", "closeChannels() +++");
    int i = 0;
    while (i < this.b.length)
    {
      a(i);
      i += 1;
    }
    j.a("plugin-sim", "closeChannels() ---");
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/mobile/android/pboctransaction/simapdu/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */