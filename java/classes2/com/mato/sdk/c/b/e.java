package com.mato.sdk.c.b;

import android.text.TextUtils;
import com.mato.android.matoid.service.mtunnel.a.a;
import com.mato.android.matoid.service.mtunnel.a.c;
import com.mato.android.matoid.service.mtunnel.a.k;
import com.mato.sdk.proxy.l;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import org.json.JSONException;
import org.json.JSONObject;

public class e
{
  private static final int d = 1;
  private static final int e = 2;
  private static final int f = 3;
  private static final int g = 4;
  private static final int h = 5;
  private static final int i = 6;
  private static final int j = 7;
  private static final int k = 8;
  private static final int l = 1;
  private static final int m = 2;
  private static final int n = 3;
  private static final int o = 4;
  private static final int p = 5;
  private static final int q = 6;
  private static final int r = 7;
  private String a;
  private String b;
  private String c;
  
  public e() {}
  
  private e(String paramString)
  {
    this.a = "";
    this.b = "";
    this.c = "";
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    int i1 = paramString.indexOf("\n");
    if (i1 != -1) {}
    for (this.a = paramString.substring(0, i1);; this.a = paramString)
    {
      this.b = paramString;
      paramString = this.a;
      return;
    }
  }
  
  public e(String paramString1, String paramString2)
  {
    this.a = "";
    this.b = "";
    this.c = "";
    this.a = paramString1;
    this.b = paramString2;
  }
  
  public e(Throwable paramThrowable)
  {
    this.a = "";
    this.b = "";
    this.c = "";
    Object localObject = paramThrowable.getClass().getName();
    if (paramThrowable.getMessage() != null) {}
    for (this.a = ((String)localObject + ": " + paramThrowable.getMessage());; this.a = ((String)localObject))
    {
      localObject = new StringWriter();
      PrintWriter localPrintWriter = new PrintWriter((Writer)localObject);
      paramThrowable.printStackTrace(localPrintWriter);
      localPrintWriter.close();
      localObject = localObject.toString();
      paramThrowable = (Throwable)localObject;
      if (((String)localObject).length() > 20480) {
        paramThrowable = ((String)localObject).substring(0, 20480);
      }
      this.b = paramThrowable;
      if (this.b == null) {
        this.b = "";
      }
      return;
    }
  }
  
  public static a.a a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return a.a.a;
    case 2: 
      return a.a.c;
    case 3: 
      return a.a.d;
    case 4: 
      return a.a.e;
    case 5: 
      return a.a.f;
    case 6: 
      return a.a.g;
    case 7: 
      return a.a.h;
    }
    return a.a.i;
  }
  
  public static a.k a(int paramInt1, int paramInt2)
  {
    switch (paramInt1)
    {
    default: 
      return a.k.a;
    case 1: 
    case 2: 
    case 3: 
    case 4: 
      return a.k.a;
    }
    return l.e(paramInt2);
  }
  
  public static e a(JSONObject paramJSONObject)
  {
    e locale = new e(paramJSONObject.optString("summary"), paramJSONObject.optString("stack", ""));
    locale.c = paramJSONObject.optString("extra", "");
    return locale;
  }
  
  private static String a(Throwable paramThrowable)
  {
    Object localObject = new StringWriter();
    PrintWriter localPrintWriter = new PrintWriter((Writer)localObject);
    paramThrowable.printStackTrace(localPrintWriter);
    localPrintWriter.close();
    localObject = localObject.toString();
    paramThrowable = (Throwable)localObject;
    if (((String)localObject).length() > 20480) {
      paramThrowable = ((String)localObject).substring(0, 20480);
    }
    return paramThrowable;
  }
  
  public static a.c b(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return a.c.a;
    case 1: 
      return a.c.a;
    case 2: 
    case 5: 
      return a.c.b;
    case 3: 
    case 6: 
      return a.c.c;
    }
    return a.c.d;
  }
  
  public static e b(String paramString)
  {
    String str;
    if (!TextUtils.isEmpty(paramString))
    {
      int i1 = paramString.indexOf("\n");
      if (i1 != -1) {
        str = paramString.substring(0, i1);
      }
    }
    for (;;)
    {
      return new e(str, paramString);
      str = paramString;
      continue;
      paramString = "";
      str = "";
    }
  }
  
  public final String a()
  {
    return this.b;
  }
  
  public final void a(String paramString)
  {
    this.c = paramString;
  }
  
  public final String b()
  {
    return this.c;
  }
  
  public final String c()
  {
    return this.a;
  }
  
  public final JSONObject d()
    throws JSONException
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("summary", this.a);
    if (!TextUtils.isEmpty(this.c)) {
      localJSONObject.put("extra", this.c);
    }
    localJSONObject.put("stack", this.b);
    return localJSONObject;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/mato/sdk/c/b/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */