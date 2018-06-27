package com.megvii.zhimasdk.b.a.i.a;

import com.megvii.zhimasdk.b.a.a.i;
import com.megvii.zhimasdk.b.a.ae;
import com.megvii.zhimasdk.b.a.c;
import com.megvii.zhimasdk.b.a.k;
import com.megvii.zhimasdk.b.a.k.p;
import com.megvii.zhimasdk.b.a.q;
import java.io.IOException;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.Principal;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class d
  extends m
{
  private static final char[] a = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };
  private boolean b = false;
  private String c;
  private long d;
  private String e;
  private String f;
  private String g;
  
  public d()
  {
    this(c.b);
  }
  
  public d(Charset paramCharset)
  {
    super(paramCharset);
  }
  
  static String a(byte[] paramArrayOfByte)
  {
    int j = paramArrayOfByte.length;
    char[] arrayOfChar = new char[j * 2];
    int i = 0;
    while (i < j)
    {
      int k = paramArrayOfByte[i];
      int m = paramArrayOfByte[i];
      arrayOfChar[(i * 2)] = a[((m & 0xF0) >> 4)];
      arrayOfChar[(i * 2 + 1)] = a[(k & 0xF)];
      i += 1;
    }
    return new String(arrayOfChar);
  }
  
  private com.megvii.zhimasdk.b.a.e b(com.megvii.zhimasdk.b.a.a.m paramm, q paramq)
  {
    String str2 = a("uri");
    String str3 = a("realm");
    String str4 = a("nonce");
    String str1 = a("opaque");
    String str6 = a("methodname");
    Object localObject2 = a("algorithm");
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "MD5";
    }
    HashSet localHashSet = new HashSet(8);
    int i = -1;
    localObject2 = a("qop");
    if (localObject2 != null)
    {
      localObject3 = new StringTokenizer((String)localObject2, ",");
      while (((StringTokenizer)localObject3).hasMoreTokens()) {
        localHashSet.add(((StringTokenizer)localObject3).nextToken().trim().toLowerCase(Locale.ENGLISH));
      }
      if (((paramq instanceof com.megvii.zhimasdk.b.a.l)) && (localHashSet.contains("auth-int"))) {
        i = 1;
      }
    }
    while (i == -1)
    {
      throw new i("None of the qop methods is supported: " + (String)localObject2);
      if (localHashSet.contains("auth"))
      {
        i = 2;
        continue;
        i = 0;
      }
    }
    Object localObject3 = a("charset");
    localObject2 = localObject3;
    if (localObject3 == null) {
      localObject2 = "ISO-8859-1";
    }
    if (((String)localObject1).equalsIgnoreCase("MD5-sess")) {}
    for (localObject3 = "MD5";; localObject3 = localObject1)
    {
      for (;;)
      {
        MessageDigest localMessageDigest;
        String str5;
        StringBuilder localStringBuilder;
        String str7;
        int j;
        boolean bool;
        try
        {
          localMessageDigest = b((String)localObject3);
          str5 = paramm.a().getName();
          paramm = paramm.b();
          if (str4.equals(this.c))
          {
            this.d += 1L;
            localStringBuilder = new StringBuilder(256);
            localObject3 = new Formatter(localStringBuilder, Locale.US);
            ((Formatter)localObject3).format("%08x", new Object[] { Long.valueOf(this.d) });
            ((Formatter)localObject3).close();
            localObject3 = localStringBuilder.toString();
            if (this.e == null) {
              this.e = f();
            }
            this.f = null;
            this.g = null;
            if (!((String)localObject1).equalsIgnoreCase("MD5-sess")) {
              break label1016;
            }
            localStringBuilder.setLength(0);
            localStringBuilder.append(str5).append(':').append(str3).append(':').append(paramm);
            paramm = a(localMessageDigest.digest(com.megvii.zhimasdk.b.a.o.e.a(localStringBuilder.toString(), (String)localObject2)));
            localStringBuilder.setLength(0);
            localStringBuilder.append(paramm).append(':').append(str4).append(':').append(this.e);
            this.f = localStringBuilder.toString();
            str7 = a(localMessageDigest.digest(com.megvii.zhimasdk.b.a.o.e.a(this.f, (String)localObject2)));
            if (i != 2) {
              break label1061;
            }
            this.g = (str6 + ':' + str2);
            paramq = a(localMessageDigest.digest(com.megvii.zhimasdk.b.a.o.e.a(this.g, (String)localObject2)));
            if (i != 0) {
              break label1272;
            }
            localStringBuilder.setLength(0);
            localStringBuilder.append(str7).append(':').append(str4).append(':').append(paramq);
            paramm = localStringBuilder.toString();
            paramm = a(localMessageDigest.digest(com.megvii.zhimasdk.b.a.o.e.a(paramm)));
            paramq = new com.megvii.zhimasdk.b.a.o.d(128);
            if (!e()) {
              break label1363;
            }
            paramq.a("Proxy-Authorization");
            paramq.a(": Digest ");
            localObject2 = new ArrayList(20);
            ((List)localObject2).add(new com.megvii.zhimasdk.b.a.k.l("username", str5));
            ((List)localObject2).add(new com.megvii.zhimasdk.b.a.k.l("realm", str3));
            ((List)localObject2).add(new com.megvii.zhimasdk.b.a.k.l("nonce", str4));
            ((List)localObject2).add(new com.megvii.zhimasdk.b.a.k.l("uri", str2));
            ((List)localObject2).add(new com.megvii.zhimasdk.b.a.k.l("response", paramm));
            if (i != 0)
            {
              if (i != 1) {
                break label1373;
              }
              paramm = "auth-int";
              ((List)localObject2).add(new com.megvii.zhimasdk.b.a.k.l("qop", paramm));
              ((List)localObject2).add(new com.megvii.zhimasdk.b.a.k.l("nc", (String)localObject3));
              ((List)localObject2).add(new com.megvii.zhimasdk.b.a.k.l("cnonce", this.e));
            }
            ((List)localObject2).add(new com.megvii.zhimasdk.b.a.k.l("algorithm", (String)localObject1));
            if (str1 != null) {
              ((List)localObject2).add(new com.megvii.zhimasdk.b.a.k.l("opaque", str1));
            }
            i = 0;
            if (i >= ((List)localObject2).size()) {
              break;
            }
            paramm = (com.megvii.zhimasdk.b.a.k.l)((List)localObject2).get(i);
            if (i > 0) {
              paramq.a(", ");
            }
            localObject1 = paramm.a();
            if ((!"nc".equals(localObject1)) && (!"qop".equals(localObject1)) && (!"algorithm".equals(localObject1))) {
              break label1379;
            }
            j = 1;
            localObject1 = com.megvii.zhimasdk.b.a.k.e.b;
            if (j != 0) {
              break label1385;
            }
            bool = true;
            ((com.megvii.zhimasdk.b.a.k.e)localObject1).a(paramq, paramm, bool);
            i += 1;
            continue;
          }
          this.d = 1L;
        }
        catch (n paramm)
        {
          throw new i("Unsuppported digest algorithm: " + (String)localObject3);
        }
        this.e = null;
        this.c = str4;
        continue;
        label1016:
        localStringBuilder.setLength(0);
        localStringBuilder.append(str5).append(':').append(str3).append(':').append(paramm);
        this.f = localStringBuilder.toString();
        continue;
        label1061:
        if (i == 1)
        {
          paramm = null;
          if ((paramq instanceof com.megvii.zhimasdk.b.a.l)) {
            paramm = ((com.megvii.zhimasdk.b.a.l)paramq).c();
          }
          if ((paramm != null) && (!paramm.d()))
          {
            if (localHashSet.contains("auth"))
            {
              i = 2;
              this.g = (str6 + ':' + str2);
            }
            else
            {
              throw new i("Qop auth-int cannot be used with a non-repeatable entity");
            }
          }
          else
          {
            paramq = new g(localMessageDigest);
            if (paramm != null) {}
            try
            {
              paramm.a(paramq);
              paramq.close();
              this.g = (str6 + ':' + str2 + ':' + a(paramq.a()));
            }
            catch (IOException paramm)
            {
              throw new i("I/O error reading entity content", paramm);
            }
          }
        }
        else
        {
          this.g = (str6 + ':' + str2);
          continue;
          label1272:
          localStringBuilder.setLength(0);
          localObject2 = localStringBuilder.append(str7).append(':').append(str4).append(':').append((String)localObject3).append(':').append(this.e).append(':');
          if (i == 1) {}
          for (paramm = "auth-int";; paramm = "auth")
          {
            ((StringBuilder)localObject2).append(paramm).append(':').append(paramq);
            paramm = localStringBuilder.toString();
            break;
          }
          label1363:
          paramq.a("Authorization");
          continue;
          label1373:
          paramm = "auth";
          continue;
          label1379:
          j = 0;
          continue;
          label1385:
          bool = false;
        }
      }
      return new p(paramq);
    }
  }
  
  private static MessageDigest b(String paramString)
  {
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance(paramString);
      return localMessageDigest;
    }
    catch (Exception localException)
    {
      throw new n("Unsupported algorithm in HTTP Digest authentication: " + paramString);
    }
  }
  
  public static String f()
  {
    SecureRandom localSecureRandom = new SecureRandom();
    byte[] arrayOfByte = new byte[8];
    localSecureRandom.nextBytes(arrayOfByte);
    return a(arrayOfByte);
  }
  
  @Deprecated
  public com.megvii.zhimasdk.b.a.e a(com.megvii.zhimasdk.b.a.a.m paramm, q paramq)
  {
    return a(paramm, paramq, new com.megvii.zhimasdk.b.a.n.a());
  }
  
  public com.megvii.zhimasdk.b.a.e a(com.megvii.zhimasdk.b.a.a.m paramm, q paramq, com.megvii.zhimasdk.b.a.n.e parame)
  {
    com.megvii.zhimasdk.b.a.o.a.a(paramm, "Credentials");
    com.megvii.zhimasdk.b.a.o.a.a(paramq, "HTTP request");
    if (a("realm") == null) {
      throw new i("missing realm in challenge");
    }
    if (a("nonce") == null) {
      throw new i("missing nonce in challenge");
    }
    h().put("methodname", paramq.h().a());
    h().put("uri", paramq.h().c());
    if (a("charset") == null) {
      h().put("charset", a(paramq));
    }
    return b(paramm, paramq);
  }
  
  public String a()
  {
    return "digest";
  }
  
  public void a(com.megvii.zhimasdk.b.a.e parame)
  {
    super.a(parame);
    this.b = true;
  }
  
  public boolean c()
  {
    return false;
  }
  
  public boolean d()
  {
    if ("true".equalsIgnoreCase(a("stale"))) {
      return false;
    }
    return this.b;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DIGEST [complete=").append(this.b).append(", nonce=").append(this.c).append(", nc=").append(this.d).append("]");
    return localStringBuilder.toString();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/megvii/zhimasdk/b/a/i/a/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */