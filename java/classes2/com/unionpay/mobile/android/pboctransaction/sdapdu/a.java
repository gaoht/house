package com.unionpay.mobile.android.pboctransaction.sdapdu;

import android.content.Context;
import android.util.Log;
import com.unionpay.mobile.android.pboctransaction.AppIdentification;
import com.unionpay.mobile.android.pboctransaction.d;
import com.unionpay.mobile.android.pboctransaction.e;
import com.unionpay.mobile.android.utils.j;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;

public final class a
  implements com.unionpay.mobile.android.pboctransaction.c
{
  NativeSDWriter a = null;
  private Context b = null;
  private boolean c = false;
  
  private static ArrayList<com.unionpay.mobile.android.model.c> b(d paramd)
  {
    if (paramd.a() == null)
    {
      Log.e("uppay", " select UPCard failed!!!!");
      return null;
    }
    Object localObject = paramd.c();
    if (localObject == null)
    {
      Log.e("uppay", " getBankCardFileEntry failed!!!!");
      return null;
    }
    localObject = e.a((String)localObject);
    int m = (localObject[0] & 0xFF) << 24 | (localObject[1] & 0xFF) << 16;
    int k = Integer.MIN_VALUE;
    int i = 0;
    int j = 0;
    if (j < 10)
    {
      if ((k & m) != 0) {
        break label292;
      }
      i += 1;
    }
    label289:
    label292:
    for (;;)
    {
      k >>>= 1;
      j += 1;
      break;
      if (i <= 0) {
        return null;
      }
      ArrayList localArrayList = new ArrayList(i);
      k = Integer.MIN_VALUE;
      j = 1;
      for (;;)
      {
        if ((j > i) || (j >= 11)) {
          break label289;
        }
        String str2;
        if ((m & k) == 0)
        {
          str2 = paramd.a(j, com.unionpay.mobile.android.utils.c.a());
          if ((str2 != null) && (str2.length() > 0)) {
            localObject = e.d(str2.substring(0, 40));
          }
        }
        try
        {
          str1 = new String(e.a((String)localObject), "gbk");
          localObject = str1;
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException)
        {
          for (;;)
          {
            String str1;
            localUnsupportedEncodingException.printStackTrace();
          }
        }
        str1 = str2.substring(40, 60);
        localArrayList.add(new com.unionpay.mobile.android.model.a(8, Integer.toString(j), (String)localObject, e.c(str1), 2));
        j.c("uppay", j + "----" + str1);
        k >>>= 1;
        j += 1;
      }
      return localArrayList;
    }
  }
  
  public final String a(String paramString)
  {
    return "";
  }
  
  public final ArrayList<com.unionpay.mobile.android.model.c> a(d paramd)
  {
    Object localObject2 = null;
    j.c("uppay", "SDEngine.readList() +++");
    if (!this.c) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    String str = paramd.a(new AppIdentification("A0000003330101", "1.0"));
    Object localObject1 = localObject2;
    if (str != null)
    {
      localObject1 = localObject2;
      if (str.length() > 0)
      {
        localObject1 = new ArrayList(1);
        ((ArrayList)localObject1).add(new com.unionpay.mobile.android.model.a(8, "A0000003330101", "", e.c(str), 1));
        j.c("uppay", "A0000003330101" + "----" + str);
      }
    }
    if ((localObject1 != null) && (((ArrayList)localObject1).size() > 0)) {
      localArrayList.addAll((Collection)localObject1);
    }
    paramd = b(paramd);
    if ((paramd != null) && (paramd.size() > 0)) {
      localArrayList.addAll(paramd);
    }
    j.c("uppay", "SDEngine.readList() ---");
    return localArrayList;
  }
  
  public final void a() {}
  
  public final void a(com.unionpay.mobile.android.pboctransaction.b paramb, Context paramContext)
  {
    this.b = paramContext;
    if (paramb != null) {
      paramb.a();
    }
  }
  
  public final byte[] a(byte[] paramArrayOfByte, int paramInt)
  {
    String str = "";
    if (this.a != null) {
      str = this.a.a(e.a(paramArrayOfByte));
    }
    return e.a(str);
  }
  
  public final void b()
  {
    Object localObject = this.b;
    this.a = new NativeSDWriter();
    localObject = this.b;
    b.a();
    localObject = new ArrayList();
    String[] arrayOfString = b.a;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      ((ArrayList)localObject).add(arrayOfString[i]);
      i += 1;
    }
    this.c = this.a.a((ArrayList)localObject);
  }
  
  public final void c()
  {
    if (this.a != null) {
      this.a.a();
    }
  }
  
  public final void d() {}
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/mobile/android/pboctransaction/sdapdu/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */