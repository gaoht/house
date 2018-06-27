package com.megvii.zhimasdk.d;

import com.megvii.zhimasdk.a.d;
import com.megvii.zhimasdk.a.e;
import org.json.JSONException;
import org.json.JSONObject;

public class a
{
  private static String a;
  private static com.megvii.zhimasdk.c.c b;
  
  public static String a(int paramInt, String paramString)
  {
    return "PASS_" + paramInt + "_" + paramString;
  }
  
  public static String a(i parami)
  {
    return "FAIL_ZMCERT: " + parami.j + "";
  }
  
  public static void a(i parami, final String paramString)
  {
    if (b == null) {
      b = new com.megvii.zhimasdk.c.c(0, 3, 3, 5);
    }
    b.a(new Runnable()
    {
      public void run()
      {
        try
        {
          String str = this.a.h;
          int i = this.a.k;
          Object localObject = new JSONObject();
          ((JSONObject)localObject).put("t", System.currentTimeMillis() / 1000L);
          ((JSONObject)localObject).put("id", str);
          ((JSONObject)localObject).put("r", i);
          ((JSONObject)localObject).put("a", paramString);
          str = ((JSONObject)localObject).toString();
          g.a("buriedPoint: log", str);
          g.a("projectName", a.a());
          localObject = new com.megvii.zhimasdk.a.c("cn-beijing.log.aliyuncs.com", "LTAI97c2nIqQ6dOs", "gxJhx45FpVmOEHHEK44D3RVJeMnU5S", a.a());
          e locale = new e();
          com.megvii.zhimasdk.a.a locala = new com.megvii.zhimasdk.a.a();
          locala.a("m", str);
          locale.a(locala);
          ((com.megvii.zhimasdk.a.c)localObject).a(locale, "behavior");
          return;
        }
        catch (d locald)
        {
          locald.printStackTrace();
          g.a("LogException: ", "");
          return;
        }
        catch (JSONException localJSONException)
        {
          localJSONException.printStackTrace();
        }
      }
    }, false);
  }
  
  public static void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      a = "zhima-prod";
      return;
    }
    a = "zhima-test";
  }
  
  public static String b(int paramInt, String paramString)
  {
    return "FAIL_" + paramInt + "_" + paramString;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/megvii/zhimasdk/d/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */