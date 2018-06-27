package com.xiaomi.smack.packet;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class h
{
  private int a;
  private String b;
  private String c;
  private String d;
  private String e;
  private List<a> f = null;
  
  public h(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, List<a> paramList)
  {
    this.a = paramInt;
    this.b = paramString1;
    this.d = paramString2;
    this.c = paramString3;
    this.e = paramString4;
    this.f = paramList;
  }
  
  public h(Bundle paramBundle)
  {
    this.a = paramBundle.getInt("ext_err_code");
    if (paramBundle.containsKey("ext_err_type")) {
      this.b = paramBundle.getString("ext_err_type");
    }
    this.c = paramBundle.getString("ext_err_cond");
    this.d = paramBundle.getString("ext_err_reason");
    this.e = paramBundle.getString("ext_err_msg");
    paramBundle = paramBundle.getParcelableArray("ext_exts");
    if (paramBundle != null)
    {
      this.f = new ArrayList(paramBundle.length);
      int j = paramBundle.length;
      int i = 0;
      while (i < j)
      {
        a locala = a.a((Bundle)paramBundle[i]);
        if (locala != null) {
          this.f.add(locala);
        }
        i += 1;
      }
    }
  }
  
  public h(a parama)
  {
    a(parama);
    this.e = null;
  }
  
  private void a(a parama)
  {
    this.c = a.a(parama);
  }
  
  public Bundle a()
  {
    Bundle localBundle1 = new Bundle();
    if (this.b != null) {
      localBundle1.putString("ext_err_type", this.b);
    }
    localBundle1.putInt("ext_err_code", this.a);
    if (this.d != null) {
      localBundle1.putString("ext_err_reason", this.d);
    }
    if (this.c != null) {
      localBundle1.putString("ext_err_cond", this.c);
    }
    if (this.e != null) {
      localBundle1.putString("ext_err_msg", this.e);
    }
    Bundle[] arrayOfBundle;
    if (this.f != null)
    {
      arrayOfBundle = new Bundle[this.f.size()];
      Iterator localIterator = this.f.iterator();
      int i = 0;
      if (localIterator.hasNext())
      {
        Bundle localBundle2 = ((a)localIterator.next()).e();
        if (localBundle2 == null) {
          break label175;
        }
        int j = i + 1;
        arrayOfBundle[i] = localBundle2;
        i = j;
      }
    }
    label175:
    for (;;)
    {
      break;
      localBundle1.putParcelableArray("ext_exts", arrayOfBundle);
      return localBundle1;
    }
  }
  
  public String b()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<error code=\"").append(this.a).append("\"");
    if (this.b != null)
    {
      localStringBuilder.append(" type=\"");
      localStringBuilder.append(this.b);
      localStringBuilder.append("\"");
    }
    if (this.d != null)
    {
      localStringBuilder.append(" reason=\"");
      localStringBuilder.append(this.d);
      localStringBuilder.append("\"");
    }
    localStringBuilder.append(">");
    if (this.c != null)
    {
      localStringBuilder.append("<").append(this.c);
      localStringBuilder.append(" xmlns=\"urn:ietf:params:xml:ns:xmpp-stanzas\"/>");
    }
    if (this.e != null)
    {
      localStringBuilder.append("<text xml:lang=\"en\" xmlns=\"urn:ietf:params:xml:ns:xmpp-stanzas\">");
      localStringBuilder.append(this.e);
      localStringBuilder.append("</text>");
    }
    Iterator localIterator = c().iterator();
    while (localIterator.hasNext()) {
      localStringBuilder.append(((e)localIterator.next()).d());
    }
    localStringBuilder.append("</error>");
    return localStringBuilder.toString();
  }
  
  /* Error */
  public List<a> c()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 23	com/xiaomi/smack/packet/h:f	Ljava/util/List;
    //   6: ifnonnull +11 -> 17
    //   9: invokestatic 169	java/util/Collections:emptyList	()Ljava/util/List;
    //   12: astore_1
    //   13: aload_0
    //   14: monitorexit
    //   15: aload_1
    //   16: areturn
    //   17: aload_0
    //   18: getfield 23	com/xiaomi/smack/packet/h:f	Ljava/util/List;
    //   21: invokestatic 173	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   24: astore_1
    //   25: goto -12 -> 13
    //   28: astore_1
    //   29: aload_0
    //   30: monitorexit
    //   31: aload_1
    //   32: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	33	0	this	h
    //   12	13	1	localList	List
    //   28	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	13	28	finally
    //   17	25	28	finally
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (this.c != null) {
      localStringBuilder.append(this.c);
    }
    localStringBuilder.append("(").append(this.a).append(")");
    if (this.e != null) {
      localStringBuilder.append(" ").append(this.e);
    }
    return localStringBuilder.toString();
  }
  
  public static class a
  {
    public static final a a = new a("internal-server-error");
    public static final a b = new a("forbidden");
    public static final a c = new a("bad-request");
    public static final a d = new a("conflict");
    public static final a e = new a("feature-not-implemented");
    public static final a f = new a("gone");
    public static final a g = new a("item-not-found");
    public static final a h = new a("jid-malformed");
    public static final a i = new a("not-acceptable");
    public static final a j = new a("not-allowed");
    public static final a k = new a("not-authorized");
    public static final a l = new a("payment-required");
    public static final a m = new a("recipient-unavailable");
    public static final a n = new a("redirect");
    public static final a o = new a("registration-required");
    public static final a p = new a("remote-server-error");
    public static final a q = new a("remote-server-not-found");
    public static final a r = new a("remote-server-timeout");
    public static final a s = new a("resource-constraint");
    public static final a t = new a("service-unavailable");
    public static final a u = new a("subscription-required");
    public static final a v = new a("undefined-condition");
    public static final a w = new a("unexpected-request");
    public static final a x = new a("request-timeout");
    private String y;
    
    public a(String paramString)
    {
      this.y = paramString;
    }
    
    public String toString()
    {
      return this.y;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/xiaomi/smack/packet/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */