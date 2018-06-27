package com.tencent.smtt.sdk;

import android.text.TextUtils;
import com.tencent.smtt.export.external.DexLoader;
import java.util.Map;

class ah
{
  public boolean a = false;
  public boolean b = false;
  private Map<String, String> c = null;
  
  public void a(int paramInt, String paramString)
  {
    try
    {
      Object localObject = bg.b();
      if (((bg)localObject).c())
      {
        this.c.put("is_first_init_tbs", String.valueOf(this.b));
        this.c.put("is_first_init_x5", String.valueOf(this.a));
        this.c.put("x5_webview_id", Integer.toString(paramInt));
        this.c.put("current_url", paramString);
        paramString = ((bg)localObject).d().b();
        localObject = Integer.TYPE;
        Map localMap = this.c;
        paramString.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "setTbsInitPerformanceData", new Class[] { localObject, Map.class }, new Object[] { Integer.valueOf(paramInt), localMap });
      }
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void a(String paramString, byte paramByte)
  {
    for (;;)
    {
      try
      {
        boolean bool = TextUtils.isEmpty(paramString);
        if (bool) {
          return;
        }
        str = "";
        if (paramByte == 1)
        {
          str = "_begin";
          this.c.put(paramString + str, String.valueOf(System.currentTimeMillis()));
          continue;
        }
        if (paramByte != 2) {
          continue;
        }
      }
      finally {}
      String str = "_end";
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/tencent/smtt/sdk/ah.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */