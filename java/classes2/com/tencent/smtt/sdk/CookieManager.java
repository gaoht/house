package com.tencent.smtt.sdk;

import android.os.Build.VERSION;
import com.tencent.smtt.export.external.DexLoader;
import com.tencent.smtt.utils.u;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class CookieManager
{
  private static CookieManager b;
  ArrayList<a> a;
  
  public static CookieManager getInstance()
  {
    if (b == null) {}
    try
    {
      if (b == null) {
        b = new CookieManager();
      }
      return b;
    }
    finally {}
  }
  
  void a()
  {
    for (;;)
    {
      try
      {
        if (this.a != null)
        {
          int i = this.a.size();
          if (i != 0) {}
        }
        else
        {
          return;
        }
        Object localObject1 = bg.b();
        if ((localObject1 == null) || (!((bg)localObject1).c())) {
          continue;
        }
        localObject1 = this.a.iterator();
        if (!((Iterator)localObject1).hasNext()) {
          break label131;
        }
        a locala = (a)((Iterator)localObject1).next();
        switch (locala.a)
        {
        case 1: 
          setCookie(locala.b, locala.c, locala.d);
          break;
        case 2: 
          setCookie(locala.b, locala.c);
        }
      }
      finally {}
      continue;
      label131:
      this.a.clear();
    }
  }
  
  public boolean acceptCookie()
  {
    bg localbg = bg.b();
    if ((localbg != null) && (localbg.c())) {
      return localbg.d().d();
    }
    return android.webkit.CookieManager.getInstance().acceptCookie();
  }
  
  /* Error */
  public boolean acceptThirdPartyCookies(WebView paramWebView)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 34	com/tencent/smtt/sdk/bg:b	()Lcom/tencent/smtt/sdk/bg;
    //   5: astore_3
    //   6: aload_3
    //   7: ifnull +70 -> 77
    //   10: aload_3
    //   11: invokevirtual 38	com/tencent/smtt/sdk/bg:c	()Z
    //   14: ifeq +63 -> 77
    //   17: aload_3
    //   18: invokevirtual 77	com/tencent/smtt/sdk/bg:d	()Lcom/tencent/smtt/sdk/bh;
    //   21: invokevirtual 93	com/tencent/smtt/sdk/bh:b	()Lcom/tencent/smtt/export/external/DexLoader;
    //   24: astore_3
    //   25: aload_1
    //   26: invokevirtual 99	com/tencent/smtt/sdk/WebView:getView	()Landroid/view/View;
    //   29: astore_1
    //   30: aload_3
    //   31: ldc 101
    //   33: ldc 103
    //   35: iconst_1
    //   36: anewarray 105	java/lang/Class
    //   39: dup
    //   40: iconst_0
    //   41: ldc 4
    //   43: aastore
    //   44: iconst_1
    //   45: anewarray 4	java/lang/Object
    //   48: dup
    //   49: iconst_0
    //   50: aload_1
    //   51: aastore
    //   52: invokevirtual 111	com/tencent/smtt/export/external/DexLoader:invokeStaticMethod	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    //   55: astore_1
    //   56: aload_1
    //   57: ifnull +15 -> 72
    //   60: aload_1
    //   61: checkcast 113	java/lang/Boolean
    //   64: invokevirtual 116	java/lang/Boolean:booleanValue	()Z
    //   67: istore_2
    //   68: aload_0
    //   69: monitorexit
    //   70: iload_2
    //   71: ireturn
    //   72: iconst_1
    //   73: istore_2
    //   74: goto -6 -> 68
    //   77: getstatic 121	android/os/Build$VERSION:SDK_INT	I
    //   80: bipush 21
    //   82: if_icmpge +8 -> 90
    //   85: iconst_1
    //   86: istore_2
    //   87: goto -19 -> 68
    //   90: invokestatic 86	android/webkit/CookieManager:getInstance	()Landroid/webkit/CookieManager;
    //   93: astore_3
    //   94: aload_1
    //   95: invokevirtual 99	com/tencent/smtt/sdk/WebView:getView	()Landroid/view/View;
    //   98: astore_1
    //   99: aload_3
    //   100: ldc 122
    //   102: iconst_1
    //   103: anewarray 105	java/lang/Class
    //   106: dup
    //   107: iconst_0
    //   108: ldc 124
    //   110: aastore
    //   111: iconst_1
    //   112: anewarray 4	java/lang/Object
    //   115: dup
    //   116: iconst_0
    //   117: aload_1
    //   118: aastore
    //   119: invokestatic 129	com/tencent/smtt/utils/u:a	(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    //   122: astore_1
    //   123: aload_1
    //   124: ifnull +14 -> 138
    //   127: aload_1
    //   128: checkcast 113	java/lang/Boolean
    //   131: invokevirtual 116	java/lang/Boolean:booleanValue	()Z
    //   134: istore_2
    //   135: goto -67 -> 68
    //   138: iconst_0
    //   139: istore_2
    //   140: goto -72 -> 68
    //   143: astore_1
    //   144: aload_0
    //   145: monitorexit
    //   146: aload_1
    //   147: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	148	0	this	CookieManager
    //   0	148	1	paramWebView	WebView
    //   67	73	2	bool	boolean
    //   5	95	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	6	143	finally
    //   10	56	143	finally
    //   60	68	143	finally
    //   77	85	143	finally
    //   90	123	143	finally
    //   127	135	143	finally
  }
  
  public void flush()
  {
    bg localbg = bg.b();
    if ((localbg != null) && (localbg.c())) {
      localbg.d().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_flush", new Class[0], new Object[0]);
    }
    while (Build.VERSION.SDK_INT < 21) {
      return;
    }
    u.a(android.webkit.CookieManager.getInstance(), "flush", new Class[0], new Object[0]);
  }
  
  public String getCookie(String paramString)
  {
    bg localbg = bg.b();
    if ((localbg != null) && (localbg.c())) {
      return localbg.d().a(paramString);
    }
    return android.webkit.CookieManager.getInstance().getCookie(paramString);
  }
  
  public boolean hasCookies()
  {
    bg localbg = bg.b();
    if ((localbg != null) && (localbg.c())) {
      return localbg.d().h();
    }
    return android.webkit.CookieManager.getInstance().hasCookies();
  }
  
  public void removeAllCookie()
  {
    bg localbg = bg.b();
    if ((localbg != null) && (localbg.c()))
    {
      localbg.d().e();
      return;
    }
    android.webkit.CookieManager.getInstance().removeAllCookie();
  }
  
  public void removeAllCookies(ValueCallback<Boolean> paramValueCallback)
  {
    bg localbg = bg.b();
    if ((localbg != null) && (localbg.c())) {
      localbg.d().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_removeAllCookies", new Class[] { android.webkit.ValueCallback.class }, new Object[] { paramValueCallback });
    }
    while (Build.VERSION.SDK_INT < 21) {
      return;
    }
    u.a(android.webkit.CookieManager.getInstance(), "removeAllCookies", new Class[] { android.webkit.ValueCallback.class }, new Object[] { paramValueCallback });
  }
  
  public void removeExpiredCookie()
  {
    bg localbg = bg.b();
    if ((localbg != null) && (localbg.c()))
    {
      localbg.d().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_removeExpiredCookie", new Class[0], new Object[0]);
      return;
    }
    android.webkit.CookieManager.getInstance().removeExpiredCookie();
  }
  
  public void removeSessionCookie()
  {
    bg localbg = bg.b();
    if ((localbg != null) && (localbg.c()))
    {
      localbg.d().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_removeSessionCookie", new Class[0], new Object[0]);
      return;
    }
    android.webkit.CookieManager.getInstance().removeSessionCookie();
  }
  
  public void removeSessionCookies(ValueCallback<Boolean> paramValueCallback)
  {
    bg localbg = bg.b();
    if ((localbg != null) && (localbg.c())) {
      localbg.d().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_removeSessionCookies", new Class[] { android.webkit.ValueCallback.class }, new Object[] { paramValueCallback });
    }
    while (Build.VERSION.SDK_INT < 21) {
      return;
    }
    u.a(android.webkit.CookieManager.getInstance(), "removeSessionCookies", new Class[] { android.webkit.ValueCallback.class }, new Object[] { paramValueCallback });
  }
  
  /* Error */
  public void setAcceptCookie(boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 34	com/tencent/smtt/sdk/bg:b	()Lcom/tencent/smtt/sdk/bg;
    //   5: astore_2
    //   6: aload_2
    //   7: ifnull +49 -> 56
    //   10: aload_2
    //   11: invokevirtual 38	com/tencent/smtt/sdk/bg:c	()Z
    //   14: ifeq +42 -> 56
    //   17: aload_2
    //   18: invokevirtual 77	com/tencent/smtt/sdk/bg:d	()Lcom/tencent/smtt/sdk/bh;
    //   21: invokevirtual 93	com/tencent/smtt/sdk/bh:b	()Lcom/tencent/smtt/export/external/DexLoader;
    //   24: ldc 101
    //   26: ldc -78
    //   28: iconst_1
    //   29: anewarray 105	java/lang/Class
    //   32: dup
    //   33: iconst_0
    //   34: getstatic 182	java/lang/Boolean:TYPE	Ljava/lang/Class;
    //   37: aastore
    //   38: iconst_1
    //   39: anewarray 4	java/lang/Object
    //   42: dup
    //   43: iconst_0
    //   44: iload_1
    //   45: invokestatic 186	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   48: aastore
    //   49: invokevirtual 111	com/tencent/smtt/export/external/DexLoader:invokeStaticMethod	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    //   52: pop
    //   53: aload_0
    //   54: monitorexit
    //   55: return
    //   56: invokestatic 86	android/webkit/CookieManager:getInstance	()Landroid/webkit/CookieManager;
    //   59: iload_1
    //   60: invokevirtual 188	android/webkit/CookieManager:setAcceptCookie	(Z)V
    //   63: goto -10 -> 53
    //   66: astore_2
    //   67: aload_0
    //   68: monitorexit
    //   69: aload_2
    //   70: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	71	0	this	CookieManager
    //   0	71	1	paramBoolean	boolean
    //   5	13	2	localbg	bg
    //   66	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	6	66	finally
    //   10	53	66	finally
    //   56	63	66	finally
  }
  
  /* Error */
  public void setAcceptThirdPartyCookies(WebView paramWebView, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 34	com/tencent/smtt/sdk/bg:b	()Lcom/tencent/smtt/sdk/bg;
    //   5: astore_3
    //   6: aload_3
    //   7: ifnull +69 -> 76
    //   10: aload_3
    //   11: invokevirtual 38	com/tencent/smtt/sdk/bg:c	()Z
    //   14: ifeq +62 -> 76
    //   17: aload_3
    //   18: invokevirtual 77	com/tencent/smtt/sdk/bg:d	()Lcom/tencent/smtt/sdk/bh;
    //   21: invokevirtual 93	com/tencent/smtt/sdk/bh:b	()Lcom/tencent/smtt/export/external/DexLoader;
    //   24: astore_3
    //   25: getstatic 182	java/lang/Boolean:TYPE	Ljava/lang/Class;
    //   28: astore 4
    //   30: aload_1
    //   31: invokevirtual 99	com/tencent/smtt/sdk/WebView:getView	()Landroid/view/View;
    //   34: astore_1
    //   35: aload_3
    //   36: ldc 101
    //   38: ldc -64
    //   40: iconst_2
    //   41: anewarray 105	java/lang/Class
    //   44: dup
    //   45: iconst_0
    //   46: ldc 4
    //   48: aastore
    //   49: dup
    //   50: iconst_1
    //   51: aload 4
    //   53: aastore
    //   54: iconst_2
    //   55: anewarray 4	java/lang/Object
    //   58: dup
    //   59: iconst_0
    //   60: aload_1
    //   61: aastore
    //   62: dup
    //   63: iconst_1
    //   64: iload_2
    //   65: invokestatic 186	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   68: aastore
    //   69: invokevirtual 111	com/tencent/smtt/export/external/DexLoader:invokeStaticMethod	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    //   72: pop
    //   73: aload_0
    //   74: monitorexit
    //   75: return
    //   76: getstatic 121	android/os/Build$VERSION:SDK_INT	I
    //   79: bipush 21
    //   81: if_icmplt -8 -> 73
    //   84: invokestatic 86	android/webkit/CookieManager:getInstance	()Landroid/webkit/CookieManager;
    //   87: astore_3
    //   88: getstatic 182	java/lang/Boolean:TYPE	Ljava/lang/Class;
    //   91: astore 4
    //   93: aload_1
    //   94: invokevirtual 99	com/tencent/smtt/sdk/WebView:getView	()Landroid/view/View;
    //   97: astore_1
    //   98: aload_3
    //   99: ldc -63
    //   101: iconst_2
    //   102: anewarray 105	java/lang/Class
    //   105: dup
    //   106: iconst_0
    //   107: ldc 124
    //   109: aastore
    //   110: dup
    //   111: iconst_1
    //   112: aload 4
    //   114: aastore
    //   115: iconst_2
    //   116: anewarray 4	java/lang/Object
    //   119: dup
    //   120: iconst_0
    //   121: aload_1
    //   122: aastore
    //   123: dup
    //   124: iconst_1
    //   125: iload_2
    //   126: invokestatic 186	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   129: aastore
    //   130: invokestatic 129	com/tencent/smtt/utils/u:a	(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    //   133: pop
    //   134: goto -61 -> 73
    //   137: astore_1
    //   138: aload_0
    //   139: monitorexit
    //   140: aload_1
    //   141: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	142	0	this	CookieManager
    //   0	142	1	paramWebView	WebView
    //   0	142	2	paramBoolean	boolean
    //   5	94	3	localObject	Object
    //   28	85	4	localClass	Class
    // Exception table:
    //   from	to	target	type
    //   2	6	137	finally
    //   10	73	137	finally
    //   76	134	137	finally
  }
  
  /* Error */
  public void setCookie(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 34	com/tencent/smtt/sdk/bg:b	()Lcom/tencent/smtt/sdk/bg;
    //   5: astore_3
    //   6: aload_3
    //   7: ifnull +54 -> 61
    //   10: aload_3
    //   11: invokevirtual 38	com/tencent/smtt/sdk/bg:c	()Z
    //   14: ifeq +47 -> 61
    //   17: aload_3
    //   18: invokevirtual 77	com/tencent/smtt/sdk/bg:d	()Lcom/tencent/smtt/sdk/bh;
    //   21: invokevirtual 93	com/tencent/smtt/sdk/bh:b	()Lcom/tencent/smtt/export/external/DexLoader;
    //   24: ldc 101
    //   26: ldc -61
    //   28: iconst_2
    //   29: anewarray 105	java/lang/Class
    //   32: dup
    //   33: iconst_0
    //   34: ldc -59
    //   36: aastore
    //   37: dup
    //   38: iconst_1
    //   39: ldc -59
    //   41: aastore
    //   42: iconst_2
    //   43: anewarray 4	java/lang/Object
    //   46: dup
    //   47: iconst_0
    //   48: aload_1
    //   49: aastore
    //   50: dup
    //   51: iconst_1
    //   52: aload_2
    //   53: aastore
    //   54: invokevirtual 111	com/tencent/smtt/export/external/DexLoader:invokeStaticMethod	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    //   57: pop
    //   58: aload_0
    //   59: monitorexit
    //   60: return
    //   61: invokestatic 86	android/webkit/CookieManager:getInstance	()Landroid/webkit/CookieManager;
    //   64: aload_1
    //   65: aload_2
    //   66: invokevirtual 198	android/webkit/CookieManager:setCookie	(Ljava/lang/String;Ljava/lang/String;)V
    //   69: invokestatic 34	com/tencent/smtt/sdk/bg:b	()Lcom/tencent/smtt/sdk/bg;
    //   72: invokevirtual 200	com/tencent/smtt/sdk/bg:e	()Z
    //   75: ifne -17 -> 58
    //   78: new 6	com/tencent/smtt/sdk/CookieManager$a
    //   81: dup
    //   82: aload_0
    //   83: invokespecial 203	com/tencent/smtt/sdk/CookieManager$a:<init>	(Lcom/tencent/smtt/sdk/CookieManager;)V
    //   86: astore_3
    //   87: aload_3
    //   88: iconst_2
    //   89: putfield 54	com/tencent/smtt/sdk/CookieManager$a:a	I
    //   92: aload_3
    //   93: aload_1
    //   94: putfield 57	com/tencent/smtt/sdk/CookieManager$a:b	Ljava/lang/String;
    //   97: aload_3
    //   98: aload_2
    //   99: putfield 59	com/tencent/smtt/sdk/CookieManager$a:c	Ljava/lang/String;
    //   102: aload_3
    //   103: aconst_null
    //   104: putfield 63	com/tencent/smtt/sdk/CookieManager$a:d	Lcom/tencent/smtt/sdk/ValueCallback;
    //   107: aload_0
    //   108: getfield 23	com/tencent/smtt/sdk/CookieManager:a	Ljava/util/ArrayList;
    //   111: ifnonnull +14 -> 125
    //   114: aload_0
    //   115: new 25	java/util/ArrayList
    //   118: dup
    //   119: invokespecial 204	java/util/ArrayList:<init>	()V
    //   122: putfield 23	com/tencent/smtt/sdk/CookieManager:a	Ljava/util/ArrayList;
    //   125: aload_0
    //   126: getfield 23	com/tencent/smtt/sdk/CookieManager:a	Ljava/util/ArrayList;
    //   129: aload_3
    //   130: invokevirtual 208	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   133: pop
    //   134: goto -76 -> 58
    //   137: astore_1
    //   138: aload_0
    //   139: monitorexit
    //   140: aload_1
    //   141: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	142	0	this	CookieManager
    //   0	142	1	paramString1	String
    //   0	142	2	paramString2	String
    //   5	125	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	6	137	finally
    //   10	58	137	finally
    //   61	125	137	finally
    //   125	134	137	finally
  }
  
  /* Error */
  public void setCookie(String paramString1, String paramString2, ValueCallback<Boolean> paramValueCallback)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 34	com/tencent/smtt/sdk/bg:b	()Lcom/tencent/smtt/sdk/bg;
    //   5: astore 4
    //   7: aload 4
    //   9: ifnull +65 -> 74
    //   12: aload 4
    //   14: invokevirtual 38	com/tencent/smtt/sdk/bg:c	()Z
    //   17: ifeq +57 -> 74
    //   20: aload 4
    //   22: invokevirtual 77	com/tencent/smtt/sdk/bg:d	()Lcom/tencent/smtt/sdk/bh;
    //   25: invokevirtual 93	com/tencent/smtt/sdk/bh:b	()Lcom/tencent/smtt/export/external/DexLoader;
    //   28: ldc 101
    //   30: ldc -61
    //   32: iconst_3
    //   33: anewarray 105	java/lang/Class
    //   36: dup
    //   37: iconst_0
    //   38: ldc -59
    //   40: aastore
    //   41: dup
    //   42: iconst_1
    //   43: ldc -59
    //   45: aastore
    //   46: dup
    //   47: iconst_2
    //   48: ldc -99
    //   50: aastore
    //   51: iconst_3
    //   52: anewarray 4	java/lang/Object
    //   55: dup
    //   56: iconst_0
    //   57: aload_1
    //   58: aastore
    //   59: dup
    //   60: iconst_1
    //   61: aload_2
    //   62: aastore
    //   63: dup
    //   64: iconst_2
    //   65: aload_3
    //   66: aastore
    //   67: invokevirtual 111	com/tencent/smtt/export/external/DexLoader:invokeStaticMethod	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    //   70: pop
    //   71: aload_0
    //   72: monitorexit
    //   73: return
    //   74: invokestatic 34	com/tencent/smtt/sdk/bg:b	()Lcom/tencent/smtt/sdk/bg;
    //   77: invokevirtual 200	com/tencent/smtt/sdk/bg:e	()Z
    //   80: ifne +65 -> 145
    //   83: new 6	com/tencent/smtt/sdk/CookieManager$a
    //   86: dup
    //   87: aload_0
    //   88: invokespecial 203	com/tencent/smtt/sdk/CookieManager$a:<init>	(Lcom/tencent/smtt/sdk/CookieManager;)V
    //   91: astore 4
    //   93: aload 4
    //   95: iconst_1
    //   96: putfield 54	com/tencent/smtt/sdk/CookieManager$a:a	I
    //   99: aload 4
    //   101: aload_1
    //   102: putfield 57	com/tencent/smtt/sdk/CookieManager$a:b	Ljava/lang/String;
    //   105: aload 4
    //   107: aload_2
    //   108: putfield 59	com/tencent/smtt/sdk/CookieManager$a:c	Ljava/lang/String;
    //   111: aload 4
    //   113: aload_3
    //   114: putfield 63	com/tencent/smtt/sdk/CookieManager$a:d	Lcom/tencent/smtt/sdk/ValueCallback;
    //   117: aload_0
    //   118: getfield 23	com/tencent/smtt/sdk/CookieManager:a	Ljava/util/ArrayList;
    //   121: ifnonnull +14 -> 135
    //   124: aload_0
    //   125: new 25	java/util/ArrayList
    //   128: dup
    //   129: invokespecial 204	java/util/ArrayList:<init>	()V
    //   132: putfield 23	com/tencent/smtt/sdk/CookieManager:a	Ljava/util/ArrayList;
    //   135: aload_0
    //   136: getfield 23	com/tencent/smtt/sdk/CookieManager:a	Ljava/util/ArrayList;
    //   139: aload 4
    //   141: invokevirtual 208	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   144: pop
    //   145: getstatic 121	android/os/Build$VERSION:SDK_INT	I
    //   148: bipush 21
    //   150: if_icmplt -79 -> 71
    //   153: invokestatic 86	android/webkit/CookieManager:getInstance	()Landroid/webkit/CookieManager;
    //   156: ldc -47
    //   158: iconst_3
    //   159: anewarray 105	java/lang/Class
    //   162: dup
    //   163: iconst_0
    //   164: ldc -59
    //   166: aastore
    //   167: dup
    //   168: iconst_1
    //   169: ldc -59
    //   171: aastore
    //   172: dup
    //   173: iconst_2
    //   174: ldc -99
    //   176: aastore
    //   177: iconst_3
    //   178: anewarray 4	java/lang/Object
    //   181: dup
    //   182: iconst_0
    //   183: aload_1
    //   184: aastore
    //   185: dup
    //   186: iconst_1
    //   187: aload_2
    //   188: aastore
    //   189: dup
    //   190: iconst_2
    //   191: aload_3
    //   192: aastore
    //   193: invokestatic 129	com/tencent/smtt/utils/u:a	(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    //   196: pop
    //   197: goto -126 -> 71
    //   200: astore_1
    //   201: aload_0
    //   202: monitorexit
    //   203: aload_1
    //   204: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	205	0	this	CookieManager
    //   0	205	1	paramString1	String
    //   0	205	2	paramString2	String
    //   0	205	3	paramValueCallback	ValueCallback<Boolean>
    //   5	135	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	200	finally
    //   12	71	200	finally
    //   74	135	200	finally
    //   135	145	200	finally
    //   145	197	200	finally
  }
  
  public void setCookies(Map<String, String[]> paramMap)
  {
    Object localObject = bg.b();
    if ((localObject != null) && (((bg)localObject).c())) {}
    for (boolean bool = ((bg)localObject).d().a(paramMap);; bool = false)
    {
      if (!bool)
      {
        localObject = paramMap.keySet().iterator();
        while (((Iterator)localObject).hasNext())
        {
          String str = (String)((Iterator)localObject).next();
          String[] arrayOfString = (String[])paramMap.get(str);
          int j = arrayOfString.length;
          int i = 0;
          while (i < j)
          {
            setCookie(str, arrayOfString[i]);
            i += 1;
          }
        }
      }
      return;
    }
  }
  
  class a
  {
    int a;
    String b;
    String c;
    ValueCallback<Boolean> d;
    
    a() {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/tencent/smtt/sdk/CookieManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */