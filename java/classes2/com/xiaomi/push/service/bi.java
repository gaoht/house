package com.xiaomi.push.service;

import android.content.SharedPreferences;
import java.util.ArrayList;

class bi
  implements aw.b
{
  bi(XMPushService paramXMPushService) {}
  
  private String a(String paramString)
  {
    if ("com.xiaomi.xmsf".equals(paramString)) {
      return "1000271";
    }
    return this.a.getSharedPreferences("pref_registered_pkg_names", 0).getString(paramString, null);
  }
  
  public void a(ArrayList<av.b> paramArrayList)
  {
    this.a.a(new bj(this, 4, paramArrayList));
  }
  
  public boolean a(av.b paramb)
  {
    return a(this.a.getPackageName()) != null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/xiaomi/push/service/bi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */