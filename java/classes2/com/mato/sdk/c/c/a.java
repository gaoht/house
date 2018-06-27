package com.mato.sdk.c.c;

import com.mato.sdk.b.e;
import com.mato.sdk.b.g;
import com.mato.sdk.b.l;
import com.mato.sdk.b.l.a;
import com.mato.sdk.c.c.b;
import com.mato.sdk.g.b;
import com.mato.sdk.g.j;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;

public final class a
  implements l.a<com.mato.sdk.c.a>
{
  private static final String a = g.b("");
  private final String b = UUID.randomUUID().toString();
  private final String c;
  private final String d;
  private final String e;
  private final l<com.mato.sdk.c.a> f;
  
  public a(String paramString1, String paramString2)
  {
    this.d = paramString1;
    this.c = paramString2;
    this.e = String.valueOf(System.currentTimeMillis());
    this.f = new l();
    this.f.a(this);
  }
  
  private static Map<String, String> a(String paramString1, String paramString2)
  {
    e locale = com.mato.sdk.proxy.a.a();
    String str = j.a(locale.e(), "80dee591a993ea01e51a766134f7827d");
    HashMap localHashMap = new HashMap();
    localHashMap.put("packageName", locale.j());
    localHashMap.put("imei", str);
    localHashMap.put("mid", paramString1);
    localHashMap.put("timestamp", paramString2);
    localHashMap.put("platform", e.c());
    localHashMap.toString();
    return localHashMap;
  }
  
  private void a(com.mato.sdk.c.a parama, final String paramString)
  {
    parama.a(new c.b()
    {
      public final void a()
      {
        a.b();
        String str = paramString;
        a.a(a.this).a(paramString);
      }
      
      public final void b() {}
    });
    parama.a();
  }
  
  private void a(File paramFile, final String paramString1, String paramString2)
  {
    if (!paramFile.exists()) {
      paramFile.getAbsolutePath();
    }
    do
    {
      return;
      if (paramFile.length() <= 0L)
      {
        paramFile.getAbsolutePath();
        return;
      }
      paramFile = b.a(a(paramFile, paramString1));
    } while (paramFile == null);
    final com.mato.sdk.c.a locala = new com.mato.sdk.c.a();
    locala.b(paramString2);
    locala.c("gzip");
    locala.a(paramString1);
    paramString2 = this.b;
    String str1 = this.e;
    e locale = com.mato.sdk.proxy.a.a();
    String str2 = j.a(locale.e(), "80dee591a993ea01e51a766134f7827d");
    HashMap localHashMap = new HashMap();
    localHashMap.put("packageName", locale.j());
    localHashMap.put("imei", str2);
    localHashMap.put("mid", paramString2);
    localHashMap.put("timestamp", str1);
    localHashMap.put("platform", e.c());
    localHashMap.toString();
    locala.a(localHashMap);
    locala.a(paramFile);
    locala.a(new c.b()
    {
      public final void a()
      {
        a.b();
        String str = paramString1;
        a.a(a.this).a(paramString1);
      }
      
      public final void b()
      {
        a.b();
        a.a(a.this).a(paramString1, locala, 6, 120000);
      }
    });
    locala.a();
  }
  
  private static byte[] a(File paramFile, String paramString)
  {
    try
    {
      int i;
      if (paramString.contains("debug"))
      {
        i = 1048576;
        if (paramFile.length() < 1048576L) {
          return b.d(paramFile);
        }
      }
      else
      {
        i = 524288;
        if (paramFile.length() < 524288L) {
          return b.d(paramFile);
        }
      }
      paramString = new byte[i];
      RandomAccessFile localRandomAccessFile = new RandomAccessFile(paramFile, "r");
      localRandomAccessFile.readFully(paramString, 0, i);
      localRandomAccessFile.close();
      return paramString;
    }
    catch (FileNotFoundException paramString)
    {
      paramFile.getAbsolutePath();
      return null;
    }
    catch (IOException paramFile) {}
    return null;
  }
  
  private static String b(String paramString)
  {
    int i = paramString.indexOf("_");
    if (i == -1) {
      return "0";
    }
    return paramString.substring(i + 1);
  }
  
  public final void a()
  {
    try
    {
      String str = this.c;
      a(new File(this.c), "debug.gzip", "maa-debug-one");
      File[] arrayOfFile = new File(this.d).getParentFile().listFiles(new FilenameFilter()
      {
        public final boolean accept(File paramAnonymousFile, String paramAnonymousString)
        {
          return paramAnonymousString.startsWith("access.log");
        }
      });
      if (arrayOfFile == null) {
        return;
      }
      int j = Math.min(3, arrayOfFile.length);
      int i = 0;
      for (;;)
      {
        if (i < j)
        {
          File localFile = arrayOfFile[i];
          localFile.getAbsolutePath();
          Locale localLocale = Locale.US;
          str = localFile.getName();
          int k = str.indexOf("_");
          if (k == -1) {}
          for (str = "0";; str = str.substring(k + 1))
          {
            str = String.format(localLocale, "accesslog_%s.gzip", new Object[] { str });
            switch (i)
            {
            }
          }
          a(localFile, str, "maa-debug-two");
          break label216;
          a(localFile, str, "maa-debug-three");
          break label216;
          a(localFile, str, "maa-debug-four");
        }
        else
        {
          return;
        }
        label216:
        i += 1;
      }
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  public final void a(String paramString)
  {
    this.f.a(paramString);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/mato/sdk/c/c/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */