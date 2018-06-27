package com.freelxl.baselibrary.webview;

import android.webkit.WebView;
import com.maa.android.agent.instrumentation.Instrumented;
import com.mato.sdk.instrumentation.WebviewInstrumentation;

@Instrumented
public class b
{
  /* Error */
  public static String assetFile2Str(android.content.Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aload_0
    //   3: invokevirtual 22	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   6: aload_1
    //   7: invokevirtual 28	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   10: astore_0
    //   11: aload_0
    //   12: astore_1
    //   13: new 30	java/io/BufferedReader
    //   16: dup
    //   17: new 32	java/io/InputStreamReader
    //   20: dup
    //   21: aload_0
    //   22: invokespecial 35	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   25: invokespecial 38	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   28: astore_2
    //   29: aload_0
    //   30: astore_1
    //   31: new 40	java/lang/StringBuilder
    //   34: dup
    //   35: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   38: astore 4
    //   40: aload_0
    //   41: astore_1
    //   42: aload_2
    //   43: invokevirtual 45	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   46: astore 5
    //   48: aload 5
    //   50: ifnull +25 -> 75
    //   53: aload_0
    //   54: astore_1
    //   55: aload 5
    //   57: ldc 47
    //   59: invokevirtual 53	java/lang/String:matches	(Ljava/lang/String;)Z
    //   62: ifne +13 -> 75
    //   65: aload_0
    //   66: astore_1
    //   67: aload 4
    //   69: aload 5
    //   71: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: pop
    //   75: aload 5
    //   77: ifnonnull -37 -> 40
    //   80: aload_0
    //   81: astore_1
    //   82: aload_2
    //   83: invokevirtual 60	java/io/BufferedReader:close	()V
    //   86: aload_0
    //   87: astore_1
    //   88: aload_0
    //   89: invokevirtual 63	java/io/InputStream:close	()V
    //   92: aload_0
    //   93: astore_1
    //   94: aload 4
    //   96: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   99: astore_2
    //   100: aload_2
    //   101: astore_1
    //   102: aload_1
    //   103: astore_2
    //   104: aload_0
    //   105: ifnull +9 -> 114
    //   108: aload_0
    //   109: invokevirtual 63	java/io/InputStream:close	()V
    //   112: aload_1
    //   113: astore_2
    //   114: aload_2
    //   115: areturn
    //   116: astore_2
    //   117: aconst_null
    //   118: astore_0
    //   119: aload_0
    //   120: astore_1
    //   121: aload_2
    //   122: invokevirtual 69	java/lang/Exception:printStackTrace	()V
    //   125: aload_3
    //   126: astore_2
    //   127: aload_0
    //   128: ifnull -14 -> 114
    //   131: aload_0
    //   132: invokevirtual 63	java/io/InputStream:close	()V
    //   135: aconst_null
    //   136: areturn
    //   137: astore_0
    //   138: aconst_null
    //   139: areturn
    //   140: astore_0
    //   141: aconst_null
    //   142: astore_1
    //   143: aload_1
    //   144: ifnull +7 -> 151
    //   147: aload_1
    //   148: invokevirtual 63	java/io/InputStream:close	()V
    //   151: aload_0
    //   152: athrow
    //   153: astore_0
    //   154: aload_1
    //   155: areturn
    //   156: astore_1
    //   157: goto -6 -> 151
    //   160: astore_0
    //   161: goto -18 -> 143
    //   164: astore_2
    //   165: goto -46 -> 119
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	168	0	paramContext	android.content.Context
    //   0	168	1	paramString	String
    //   28	87	2	localObject1	Object
    //   116	6	2	localException1	Exception
    //   126	1	2	localObject2	Object
    //   164	1	2	localException2	Exception
    //   1	125	3	localObject3	Object
    //   38	57	4	localStringBuilder	StringBuilder
    //   46	30	5	str	String
    // Exception table:
    //   from	to	target	type
    //   2	11	116	java/lang/Exception
    //   131	135	137	java/io/IOException
    //   2	11	140	finally
    //   108	112	153	java/io/IOException
    //   147	151	156	java/io/IOException
    //   13	29	160	finally
    //   31	40	160	finally
    //   42	48	160	finally
    //   55	65	160	finally
    //   67	75	160	finally
    //   82	86	160	finally
    //   88	92	160	finally
    //   94	100	160	finally
    //   121	125	160	finally
    //   13	29	164	java/lang/Exception
    //   31	40	164	java/lang/Exception
    //   42	48	164	java/lang/Exception
    //   55	65	164	java/lang/Exception
    //   67	75	164	java/lang/Exception
    //   82	86	164	java/lang/Exception
    //   88	92	164	java/lang/Exception
    //   94	100	164	java/lang/Exception
  }
  
  public static String getDataFromReturnUrl(String paramString)
  {
    if (paramString.startsWith("yy://return/_fetchQueue/")) {
      return paramString.replace("yy://return/_fetchQueue/", "");
    }
    paramString = paramString.replace("yy://return/", "").split("/");
    if (paramString.length >= 2)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      int i = 1;
      while (i < paramString.length)
      {
        localStringBuilder.append(paramString[i]);
        i += 1;
      }
      return localStringBuilder.toString();
    }
    return null;
  }
  
  public static String getFunctionFromReturnUrl(String paramString)
  {
    paramString = paramString.replace("yy://return/", "").split("/");
    if (paramString.length >= 1) {
      return paramString[0];
    }
    return null;
  }
  
  public static String parseFunctionName(String paramString)
  {
    return paramString.replace("javascript:WebViewJavascriptBridge.", "").replaceAll("\\(.*\\);", "");
  }
  
  public static void webViewLoadJs(WebView paramWebView, String paramString)
  {
    paramString = "var newscript = document.createElement(\"script\");" + "newscript.src=\"" + paramString + "\";";
    paramString = paramString + "document.scripts[0].parentNode.insertBefore(newscript,document.scripts[0]);";
    paramString = "javascript:" + paramString;
    if (!(paramWebView instanceof WebView))
    {
      paramWebView.loadUrl(paramString);
      return;
    }
    WebviewInstrumentation.loadUrl((WebView)paramWebView, paramString);
  }
  
  public static void webViewLoadLocalJs(WebView paramWebView, String paramString)
  {
    paramString = assetFile2Str(paramWebView.getContext(), paramString);
    paramString = "javascript:" + paramString;
    if (!(paramWebView instanceof WebView))
    {
      paramWebView.loadUrl(paramString);
      return;
    }
    WebviewInstrumentation.loadUrl((WebView)paramWebView, paramString);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/freelxl/baselibrary/webview/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */