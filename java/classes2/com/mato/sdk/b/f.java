package com.mato.sdk.b;

import android.text.TextUtils;

public final class f
{
  private final String a;
  private final String b;
  
  public f(String paramString1, String paramString2)
  {
    this.a = paramString1;
    this.b = paramString2;
  }
  
  public final String a()
  {
    return this.b;
  }
  
  public final String b()
  {
    return this.a;
  }
  
  public final boolean c()
  {
    return (!TextUtils.isEmpty(this.a)) && (!TextUtils.isEmpty(this.b));
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2 = localStringBuilder1.append("host=");
    if (this.a == null)
    {
      str = "";
      localStringBuilder2.append(str);
      localStringBuilder2 = localStringBuilder1.append("ip=");
      if (this.b != null) {
        break label67;
      }
    }
    label67:
    for (String str = "";; str = this.b)
    {
      localStringBuilder2.append(str);
      return localStringBuilder1.toString();
      str = this.a;
      break;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/mato/sdk/b/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */