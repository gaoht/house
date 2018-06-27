package com.xiaomi.smack.packet;

import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.xiaomi.smack.util.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class a
  implements e
{
  private String a;
  private String b;
  private String[] c = null;
  private String[] d = null;
  private String e;
  private List<a> f = null;
  
  public a(String paramString1, String paramString2, String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramArrayOfString1;
    this.d = paramArrayOfString2;
  }
  
  public a(String paramString1, String paramString2, String[] paramArrayOfString1, String[] paramArrayOfString2, String paramString3, List<a> paramList)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramArrayOfString1;
    this.d = paramArrayOfString2;
    this.e = paramString3;
    this.f = paramList;
  }
  
  public static a a(Bundle paramBundle)
  {
    int j = 0;
    String str1 = paramBundle.getString("ext_ele_name");
    String str2 = paramBundle.getString("ext_ns");
    String str3 = paramBundle.getString("ext_text");
    Object localObject1 = paramBundle.getBundle("attributes");
    Object localObject2 = ((Bundle)localObject1).keySet();
    String[] arrayOfString1 = new String[((Set)localObject2).size()];
    String[] arrayOfString2 = new String[((Set)localObject2).size()];
    localObject2 = ((Set)localObject2).iterator();
    int i = 0;
    while (((Iterator)localObject2).hasNext())
    {
      String str4 = (String)((Iterator)localObject2).next();
      arrayOfString1[i] = str4;
      arrayOfString2[i] = ((Bundle)localObject1).getString(str4);
      i += 1;
    }
    if (paramBundle.containsKey("children"))
    {
      localObject2 = paramBundle.getParcelableArray("children");
      localObject1 = new ArrayList(localObject2.length);
      int k = localObject2.length;
      i = j;
      for (;;)
      {
        paramBundle = (Bundle)localObject1;
        if (i >= k) {
          break;
        }
        ((List)localObject1).add(a((Bundle)localObject2[i]));
        i += 1;
      }
    }
    paramBundle = null;
    return new a(str1, str2, arrayOfString1, arrayOfString2, str3, paramBundle);
  }
  
  public static Parcelable[] a(List<a> paramList)
  {
    return a((a[])paramList.toArray(new a[paramList.size()]));
  }
  
  public static Parcelable[] a(a[] paramArrayOfa)
  {
    if (paramArrayOfa == null) {
      return null;
    }
    Parcelable[] arrayOfParcelable = new Parcelable[paramArrayOfa.length];
    int i = 0;
    while (i < paramArrayOfa.length)
    {
      arrayOfParcelable[i] = paramArrayOfa[i].f();
      i += 1;
    }
    return arrayOfParcelable;
  }
  
  public String a()
  {
    return this.a;
  }
  
  public String a(String paramString)
  {
    if (paramString == null) {
      throw new IllegalArgumentException();
    }
    if (this.c != null)
    {
      int i = 0;
      while (i < this.c.length)
      {
        if (paramString.equals(this.c[i])) {
          return this.d[i];
        }
        i += 1;
      }
    }
    return null;
  }
  
  public String b()
  {
    return this.b;
  }
  
  public void b(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      this.e = d.a(paramString);
      return;
    }
    this.e = paramString;
  }
  
  public String c()
  {
    if (!TextUtils.isEmpty(this.e)) {
      return d.b(this.e);
    }
    return this.e;
  }
  
  public String d()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<").append(this.a);
    if (!TextUtils.isEmpty(this.b)) {
      localStringBuilder.append(" ").append("xmlns=").append("\"").append(this.b).append("\"");
    }
    if ((this.c != null) && (this.c.length > 0))
    {
      int i = 0;
      while (i < this.c.length)
      {
        if (!TextUtils.isEmpty(this.d[i])) {
          localStringBuilder.append(" ").append(this.c[i]).append("=\"").append(d.a(this.d[i])).append("\"");
        }
        i += 1;
      }
    }
    if (!TextUtils.isEmpty(this.e)) {
      localStringBuilder.append(">").append(this.e).append("</").append(this.a).append(">");
    }
    for (;;)
    {
      return localStringBuilder.toString();
      if ((this.f != null) && (this.f.size() > 0))
      {
        localStringBuilder.append(">");
        Iterator localIterator = this.f.iterator();
        while (localIterator.hasNext()) {
          localStringBuilder.append(((a)localIterator.next()).d());
        }
        localStringBuilder.append("</").append(this.a).append(">");
      }
      else
      {
        localStringBuilder.append("/>");
      }
    }
  }
  
  public Bundle e()
  {
    Bundle localBundle1 = new Bundle();
    localBundle1.putString("ext_ele_name", this.a);
    localBundle1.putString("ext_ns", this.b);
    localBundle1.putString("ext_text", this.e);
    Bundle localBundle2 = new Bundle();
    if ((this.c != null) && (this.c.length > 0))
    {
      int i = 0;
      while (i < this.c.length)
      {
        localBundle2.putString(this.c[i], this.d[i]);
        i += 1;
      }
    }
    localBundle1.putBundle("attributes", localBundle2);
    if ((this.f != null) && (this.f.size() > 0)) {
      localBundle1.putParcelableArray("children", a(this.f));
    }
    return localBundle1;
  }
  
  public Parcelable f()
  {
    return e();
  }
  
  public String toString()
  {
    return d();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/xiaomi/smack/packet/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */