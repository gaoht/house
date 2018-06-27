package com.umeng.analytics.social;

import android.content.Context;
import android.os.AsyncTask;
import android.text.TextUtils;
import org.json.JSONObject;

public abstract class UMSocialService
{
  private static void a(Context paramContext, b paramb, String paramString, UMPlatformData... paramVarArgs)
  {
    int i = 0;
    if (paramVarArgs != null) {}
    for (;;)
    {
      try
      {
        int j = paramVarArgs.length;
        if (i < j)
        {
          if (!paramVarArgs[i].isValid()) {
            throw new a("parameter is not valid.");
          }
        }
        else
        {
          new a(e.a(paramContext, paramString, paramVarArgs), paramb, paramVarArgs).execute(new Void[0]);
          return;
        }
      }
      catch (Exception paramContext)
      {
        return;
      }
      i += 1;
    }
  }
  
  public static void share(Context paramContext, String paramString, UMPlatformData... paramVarArgs)
  {
    a(paramContext, null, paramString, paramVarArgs);
  }
  
  public static void share(Context paramContext, UMPlatformData... paramVarArgs)
  {
    a(paramContext, null, null, paramVarArgs);
  }
  
  private static class a
    extends AsyncTask<Void, Void, c>
  {
    String a = paramArrayOfString[0];
    String b = paramArrayOfString[1];
    UMSocialService.b c;
    UMPlatformData[] d;
    
    public a(String[] paramArrayOfString, UMSocialService.b paramb, UMPlatformData[] paramArrayOfUMPlatformData)
    {
      this.c = paramb;
      this.d = paramArrayOfUMPlatformData;
    }
    
    protected c a(Void... paramVarArgs)
    {
      if (TextUtils.isEmpty(this.b)) {
        paramVarArgs = b.a(this.a);
      }
      label121:
      for (;;)
      {
        try
        {
          Object localObject = new JSONObject(paramVarArgs);
          int i = ((JSONObject)localObject).optInt("st");
          if (i != 0) {
            break label121;
          }
          i = 65132;
          paramVarArgs = new c(i);
          String str = ((JSONObject)localObject).optString("msg");
          if (!TextUtils.isEmpty(str)) {
            paramVarArgs.a(str);
          }
          localObject = ((JSONObject)localObject).optString("data");
          if (!TextUtils.isEmpty((CharSequence)localObject)) {
            paramVarArgs.b((String)localObject);
          }
          return paramVarArgs;
        }
        catch (Exception paramVarArgs)
        {
          return new c(-99, paramVarArgs);
        }
        paramVarArgs = b.a(this.a, this.b);
      }
    }
    
    protected void a(c paramc)
    {
      if (this.c != null) {
        this.c.a(paramc, this.d);
      }
    }
    
    protected void onPreExecute()
    {
      if (this.c != null) {
        this.c.a();
      }
    }
  }
  
  public static abstract interface b
  {
    public abstract void a();
    
    public abstract void a(c paramc, UMPlatformData... paramVarArgs);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/umeng/analytics/social/UMSocialService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */