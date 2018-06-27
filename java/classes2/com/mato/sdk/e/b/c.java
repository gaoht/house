package com.mato.sdk.e.b;

import android.content.Context;
import android.text.TextUtils;
import com.mato.sdk.b.f;
import com.mato.sdk.g.i;
import java.io.File;
import java.util.Locale;

public final class c
{
  private static final String g = "netdiagnosis.log";
  public final String a;
  public final String b;
  public final String c;
  public final String d;
  public f e;
  public final int f;
  private String h;
  
  private c(String paramString1, String paramString2, int paramInt)
  {
    this.a = paramString2;
    this.f = paramInt;
    this.b = (paramString1 + File.separator + "netdiagnosis.log");
    this.c = (paramString1 + File.separator + "access.log");
    this.d = (paramString1 + File.separator + "debug.log");
  }
  
  public static c a(Context paramContext, int paramInt)
  {
    int i;
    Object localObject1;
    label39:
    Object localObject2;
    if (paramInt == 1)
    {
      i = 1;
      localObject1 = i.n(paramContext);
      if (localObject1 != null) {
        break label159;
      }
      localObject1 = new StringBuilder(i.c(paramContext)).append(File.separator).append("com.maa.sdk");
      paramContext = i.l(paramContext);
      if (!TextUtils.isEmpty(paramContext)) {
        ((StringBuilder)localObject1).append(File.separator).append(paramContext);
      }
      localObject2 = ((StringBuilder)localObject1).append(File.separator);
      if (i == 0) {
        break label195;
      }
      paramContext = "netdiagnosis";
      label79:
      ((StringBuilder)localObject2).append(paramContext);
      paramContext = new File(((StringBuilder)localObject1).toString());
      paramContext.mkdirs();
      localObject1 = paramContext.getAbsolutePath();
      localObject2 = Locale.US;
      if (i == 0) {
        break label201;
      }
    }
    label159:
    label195:
    label201:
    for (paramContext = "manual";; paramContext = "auto")
    {
      return new c((String)localObject1, String.format((Locale)localObject2, "%s_%d", new Object[] { paramContext, Long.valueOf(System.currentTimeMillis()) }), paramInt);
      i = 0;
      break;
      localObject1 = new StringBuilder((String)localObject1).append(File.separator).append("com.maa.sdk").append(File.separator).append(i.g(paramContext));
      break label39;
      paramContext = "netdiagnosis_auto";
      break label79;
    }
  }
  
  private static String a(Context paramContext, boolean paramBoolean)
  {
    Object localObject = i.n(paramContext);
    StringBuilder localStringBuilder;
    if (localObject == null)
    {
      localObject = new StringBuilder(i.c(paramContext)).append(File.separator).append("com.maa.sdk");
      paramContext = i.l(paramContext);
      if (!TextUtils.isEmpty(paramContext)) {
        ((StringBuilder)localObject).append(File.separator).append(paramContext);
      }
      localStringBuilder = ((StringBuilder)localObject).append(File.separator);
      if (!paramBoolean) {
        break label135;
      }
    }
    label135:
    for (paramContext = "netdiagnosis";; paramContext = "netdiagnosis_auto")
    {
      localStringBuilder.append(paramContext);
      paramContext = new File(((StringBuilder)localObject).toString());
      paramContext.mkdirs();
      return paramContext.getAbsolutePath();
      localObject = new StringBuilder((String)localObject).append(File.separator).append("com.maa.sdk").append(File.separator).append(i.g(paramContext));
      break;
    }
  }
  
  public final void a(f paramf)
  {
    this.e = paramf;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/mato/sdk/e/b/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */