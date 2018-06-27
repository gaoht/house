package com.growingio.android.sdk.utils;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Process;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.LruCache;
import android.util.SparseArray;
import android.view.View;
import android.widget.AbsSeekBar;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import com.growingio.android.sdk.collection.GConfig;
import com.growingio.android.sdk.models.b;
import com.growingio.android.sdk.models.h;
import com.maa.android.agent.instrumentation.Instrumented;
import com.mato.sdk.instrumentation.WebviewInstrumentation;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;

@TargetApi(12)
@Instrumented
public class Util
{
  public static final Matcher a = Pattern.compile("#[\\+\\.a-zA-Z0-9_-]+").matcher("");
  private static SparseArray<String> b;
  private static Set<Integer> c;
  private static LruCache<Class, String> d = new LruCache(100);
  
  public static int a(Context paramContext, float paramFloat)
  {
    return (int)(paramContext.getResources().getDisplayMetrics().density * paramFloat + 0.5F);
  }
  
  public static int a(List paramList, int paramInt)
  {
    return paramInt % paramList.size();
  }
  
  public static Bundle a(Context paramContext)
  {
    String str = paramContext.getPackageName();
    try
    {
      Bundle localBundle = paramContext.getPackageManager().getApplicationInfo(str, 128).metaData;
      paramContext = localBundle;
      if (localBundle == null) {
        paramContext = new Bundle();
      }
      return paramContext;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      throw new RuntimeException("Can't configure GrowingIO whit package name " + str, paramContext);
    }
  }
  
  public static String a(View paramView, String paramString)
  {
    Object localObject2 = "";
    Object localObject1 = paramView.getTag(84159244);
    if (localObject1 != null)
    {
      localObject2 = String.valueOf(localObject1);
      return a((String)localObject2);
    }
    if ((paramView instanceof EditText))
    {
      localObject1 = ((EditText)paramView).getHint();
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        break label397;
      }
      localObject1 = ((CharSequence)localObject1).toString();
    }
    for (;;)
    {
      localObject2 = localObject1;
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        break;
      }
      if (paramString != null)
      {
        localObject2 = paramString;
        break;
        if ((paramView instanceof RatingBar))
        {
          localObject1 = String.valueOf(((RatingBar)paramView).getRating());
          continue;
        }
        if ((paramView instanceof Spinner))
        {
          localObject1 = ((Spinner)paramView).getSelectedItem();
          if ((localObject1 instanceof String))
          {
            localObject1 = (String)localObject1;
            continue;
          }
          localObject3 = ((Spinner)paramView).getSelectedView();
          localObject1 = localObject2;
          if (!(localObject3 instanceof TextView)) {
            continue;
          }
          localObject1 = localObject2;
          if (((TextView)localObject3).getText() == null) {
            continue;
          }
          localObject1 = ((TextView)localObject3).getText().toString();
          continue;
        }
        if ((paramView instanceof SeekBar))
        {
          localObject1 = String.valueOf(((SeekBar)paramView).getProgress());
          continue;
        }
        if ((paramView instanceof RadioGroup))
        {
          localObject1 = (RadioGroup)paramView;
          localObject3 = ((RadioGroup)localObject1).findViewById(((RadioGroup)localObject1).getCheckedRadioButtonId());
          localObject1 = localObject2;
          if (localObject3 == null) {
            continue;
          }
          localObject1 = localObject2;
          if (!(localObject3 instanceof RadioButton)) {
            continue;
          }
          localObject1 = localObject2;
          if (((RadioButton)localObject3).getText() == null) {
            continue;
          }
          localObject1 = ((RadioButton)localObject3).getText().toString();
          continue;
        }
        if ((paramView instanceof TextView))
        {
          localObject1 = localObject2;
          if (((TextView)paramView).getText() == null) {
            continue;
          }
          localObject1 = ((TextView)paramView).getText().toString();
          continue;
        }
        if (((paramView instanceof ImageView)) && (!TextUtils.isEmpty(paramString)))
        {
          localObject1 = paramString;
          continue;
        }
        if ((paramView instanceof android.webkit.WebView))
        {
          localObject3 = ((android.webkit.WebView)paramView).getUrl();
          localObject1 = localObject2;
          if (localObject3 == null) {
            continue;
          }
          localObject1 = localObject3;
          continue;
        }
        localObject1 = localObject2;
        if (!ClassExistHelper.instanceOfX5WebView(paramView)) {
          continue;
        }
        Object localObject3 = ((com.tencent.smtt.sdk.WebView)paramView).getUrl();
        localObject1 = localObject2;
        if (localObject3 == null) {
          continue;
        }
        localObject1 = localObject3;
        continue;
      }
      localObject2 = localObject1;
      if (paramView.getContentDescription() == null) {
        break;
      }
      localObject2 = paramView.getContentDescription().toString();
      break;
      label397:
      localObject1 = "";
    }
  }
  
  public static String a(View paramView, boolean paramBoolean)
  {
    Object localObject = paramView.getTag(84159242);
    if ((localObject != null) && ((localObject instanceof String))) {
      localObject = (String)localObject;
    }
    int i;
    String str;
    do
    {
      return (String)localObject;
      if (paramBoolean) {
        return null;
      }
      if (b == null) {
        b = new SparseArray();
      }
      if (c == null) {
        c = new HashSet();
      }
      i = paramView.getId();
      if ((i <= 2130706432) || (c.contains(Integer.valueOf(i)))) {
        break;
      }
      str = (String)b.get(i);
      localObject = str;
    } while (str != null);
    try
    {
      paramView = paramView.getResources().getResourceEntryName(i);
      b.put(i, paramView);
      return paramView;
    }
    catch (Exception paramView)
    {
      c.add(Integer.valueOf(i));
    }
    return null;
  }
  
  public static String a(Class paramClass)
  {
    String str2 = (String)d.get(paramClass);
    String str1 = str2;
    if (TextUtils.isEmpty(str2))
    {
      str2 = paramClass.getSimpleName();
      str1 = str2;
      if (TextUtils.isEmpty(str2)) {
        str1 = "Anonymous";
      }
      d.put(paramClass, str1);
      ClassExistHelper.checkCustomRecyclerView(paramClass, str1);
    }
    return str1;
  }
  
  public static String a(String paramString)
  {
    String str;
    if (paramString == null) {
      str = "";
    }
    do
    {
      do
      {
        return str;
        str = paramString;
      } while (TextUtils.isEmpty(paramString));
      str = paramString;
    } while (paramString.length() <= 50);
    return paramString.substring(0, 50);
  }
  
  public static void a(Handler paramHandler, int paramInt, Object... paramVarArgs)
  {
    if (paramHandler != null) {
      paramHandler.obtainMessage(paramInt, paramVarArgs).sendToTarget();
    }
  }
  
  public static void a(View paramView, Rect paramRect, boolean paramBoolean)
  {
    a(paramView, paramRect, paramBoolean, null);
  }
  
  public static void a(View paramView, Rect paramRect, boolean paramBoolean, int[] paramArrayOfInt)
  {
    if (paramBoolean)
    {
      paramView.getGlobalVisibleRect(paramRect);
      return;
    }
    int[] arrayOfInt;
    if (paramArrayOfInt != null)
    {
      arrayOfInt = paramArrayOfInt;
      if (paramArrayOfInt.length == 2) {}
    }
    else
    {
      arrayOfInt = new int[2];
    }
    paramView.getLocationOnScreen(arrayOfInt);
    paramRect.set(0, 0, paramView.getWidth(), paramView.getHeight());
    paramRect.offset(arrayOfInt[0], arrayOfInt[1]);
  }
  
  @TargetApi(19)
  public static void a(View paramView, String paramString, Object... paramVarArgs)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("javascript:try{(function(){");
    localStringBuilder.append(paramString);
    localStringBuilder.append("(");
    paramString = "";
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      Object localObject = paramVarArgs[i];
      localStringBuilder.append(paramString);
      paramString = ",";
      if ((localObject instanceof String)) {
        localStringBuilder.append("'");
      }
      localStringBuilder.append(localObject);
      if ((localObject instanceof String)) {
        localStringBuilder.append("'");
      }
      i += 1;
    }
    localStringBuilder.append(");})()}catch(ex){console.log(ex);}");
    try
    {
      if ((paramView instanceof android.webkit.WebView))
      {
        paramView = (android.webkit.WebView)paramView;
        paramString = localStringBuilder.toString();
        if (!(paramView instanceof android.webkit.WebView))
        {
          paramView.loadUrl(paramString);
          return;
        }
        WebviewInstrumentation.loadUrl((android.webkit.WebView)paramView, paramString);
        return;
      }
    }
    catch (Exception paramView)
    {
      LogUtil.d("WebView", "call javascript failed ", paramView);
      return;
    }
    if (ClassExistHelper.instanceOfX5WebView(paramView))
    {
      paramView = (com.tencent.smtt.sdk.WebView)paramView;
      paramString = localStringBuilder.toString();
      if (!(paramView instanceof android.webkit.WebView))
      {
        paramView.loadUrl(paramString);
        return;
      }
      WebviewInstrumentation.loadUrl((android.webkit.WebView)paramView, paramString);
    }
  }
  
  /* Error */
  @TargetApi(9)
  public static void a(byte[] paramArrayOfByte, String paramString)
  {
    // Byte code:
    //   0: new 361	java/io/File
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 363	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore_2
    //   9: aload_2
    //   10: invokevirtual 367	java/io/File:getParentFile	()Ljava/io/File;
    //   13: astore_1
    //   14: aload_1
    //   15: invokevirtual 371	java/io/File:isDirectory	()Z
    //   18: ifne +10 -> 28
    //   21: aload_1
    //   22: invokevirtual 374	java/io/File:mkdirs	()Z
    //   25: ifeq +31 -> 56
    //   28: new 376	java/io/FileOutputStream
    //   31: dup
    //   32: aload_2
    //   33: invokespecial 379	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   36: astore_1
    //   37: aload_1
    //   38: aload_0
    //   39: invokevirtual 383	java/io/FileOutputStream:write	([B)V
    //   42: aload_1
    //   43: ifnull +13 -> 56
    //   46: aload_1
    //   47: invokevirtual 386	java/io/FileOutputStream:close	()V
    //   50: aload_2
    //   51: iconst_1
    //   52: invokevirtual 390	java/io/File:setReadable	(Z)Z
    //   55: pop
    //   56: return
    //   57: astore_0
    //   58: aload_0
    //   59: invokevirtual 393	java/io/IOException:printStackTrace	()V
    //   62: goto -12 -> 50
    //   65: astore_0
    //   66: aconst_null
    //   67: astore_1
    //   68: aload_1
    //   69: ifnull +13 -> 82
    //   72: aload_1
    //   73: invokevirtual 386	java/io/FileOutputStream:close	()V
    //   76: aload_2
    //   77: iconst_1
    //   78: invokevirtual 390	java/io/File:setReadable	(Z)Z
    //   81: pop
    //   82: aload_0
    //   83: athrow
    //   84: astore_1
    //   85: aload_1
    //   86: invokevirtual 393	java/io/IOException:printStackTrace	()V
    //   89: goto -13 -> 76
    //   92: astore_0
    //   93: goto -25 -> 68
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	96	0	paramArrayOfByte	byte[]
    //   0	96	1	paramString	String
    //   8	69	2	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   46	50	57	java/io/IOException
    //   28	37	65	finally
    //   72	76	84	java/io/IOException
    //   37	42	92	finally
  }
  
  public static boolean a(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, long paramLong1, long paramLong2)
  {
    paramDouble1 = Math.abs(paramDouble1 - paramDouble3) + Math.abs(paramDouble2 - paramDouble4);
    if (paramDouble1 == 0.0D) {
      return false;
    }
    return (paramDouble1 > 0.05D) || (paramLong1 - paramLong2 > 300000L);
  }
  
  @TargetApi(11)
  public static boolean a(int paramInt)
  {
    paramInt &= 0xFFF;
    return (paramInt == 129) || (paramInt == 225) || (paramInt == 18) || (paramInt == 145);
  }
  
  public static boolean a(View paramView)
  {
    return ((paramView instanceof AdapterView)) || (ClassExistHelper.instanceOfRecyclerView(paramView)) || (ClassExistHelper.instanceOfViewPager(paramView));
  }
  
  public static boolean a(b paramb, ArrayList<h> paramArrayList)
  {
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      h localh = (h)paramArrayList.next();
      if ((!localh.i) && ((localh.a == null) || (a(localh.a, paramb.a))) && ((localh.e == null) || (localh.e.equals(String.valueOf(paramb.c)))) && ((localh.c == null) || (localh.c.equals(paramb.d)))) {
        return true;
      }
    }
    return false;
  }
  
  public static boolean a(String paramString, double paramDouble)
  {
    if (paramDouble <= 0.0D) {
      return false;
    }
    if (paramDouble >= 0.9999D) {
      return true;
    }
    paramString = b(paramString).toCharArray();
    long l2 = ((1.0F / (float)100000L + paramDouble) * 100000L);
    long l1 = 1L;
    int i = paramString.length - 1;
    while (i >= 0)
    {
      l1 = (l1 * 256L + paramString[i]) % 100000L;
      i -= 1;
    }
    return l1 < l2;
  }
  
  public static boolean a(String paramString1, String paramString2)
  {
    if (paramString1.charAt(0) == '*') {
      if (GConfig.USE_ID) {}
    }
    do
    {
      do
      {
        return false;
        return paramString2.endsWith(paramString1.substring(1));
      } while (paramString1.charAt(0) != '/');
      if (!GConfig.USE_ID) {
        break;
      }
      try
      {
        boolean bool = paramString1.equals(a.reset(paramString2).replaceAll(""));
        return bool;
      }
      catch (Exception paramString1) {}
    } while (!GConfig.DEBUG);
    paramString1.printStackTrace();
    return false;
    return paramString1.equals(paramString2);
  }
  
  public static boolean a(JSONObject paramJSONObject, ArrayList<h> paramArrayList, String paramString)
  {
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      h localh = (h)paramArrayList.next();
      if ((localh.i) && (localh.d.equals(paramString)) && ((localh.a == null) || (a(localh.a, paramJSONObject.getString("x")))) && ((localh.e == null) || (localh.e.equals(String.valueOf(paramJSONObject.optInt("idx", -1))))) && ((localh.c == null) || (localh.c.equals(paramJSONObject.optString("v")))) && ((localh.g == null) || ((localh.g.equals(paramJSONObject.optString("h"))) && ((localh.f == null) || (localh.f.equals(paramJSONObject.optString("q"))))))) {
        return true;
      }
    }
    return false;
  }
  
  public static int b(Context paramContext, float paramFloat)
  {
    return (int)(paramContext.getResources().getDisplayMetrics().scaledDensity * paramFloat + 0.5F);
  }
  
  public static String b(Context paramContext)
  {
    Object localObject = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses();
    if (localObject == null) {
      return "";
    }
    int i = Process.myPid();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next();
      if (localRunningAppProcessInfo.pid == i)
      {
        if (paramContext.getPackageName().equals(localRunningAppProcessInfo.processName)) {
          return "";
        }
        return localRunningAppProcessInfo.processName + ".";
      }
    }
    return "";
  }
  
  @TargetApi(9)
  public static String b(String paramString)
  {
    try
    {
      Object localObject = MessageDigest.getInstance("MD5");
      ((MessageDigest)localObject).update(paramString.getBytes(Charset.forName("US-ASCII")), 0, paramString.length());
      paramString = ((MessageDigest)localObject).digest();
      localObject = new BigInteger(1, paramString);
      paramString = String.format("%0" + (paramString.length << 1) + "x", new Object[] { localObject });
      return paramString;
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
    }
    return "";
  }
  
  public static boolean b(View paramView)
  {
    return paramView.getTag(84159248) != null;
  }
  
  public static boolean c(View paramView)
  {
    return (paramView.isClickable()) || ((paramView instanceof RadioGroup)) || ((paramView instanceof Spinner)) || ((paramView instanceof AbsSeekBar)) || ((paramView.getParent() != null) && ((paramView.getParent() instanceof AdapterView)) && (((AdapterView)paramView.getParent()).isClickable()));
  }
  
  public static boolean c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return paramString.startsWith("http://");
  }
  
  public static boolean d(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return paramString.startsWith("https://");
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/growingio/android/sdk/utils/Util.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */