package com.growingio.android.sdk.utils;

import android.annotation.TargetApi;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.c;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebView;
import java.lang.reflect.Method;

public class ClassExistHelper
{
  public static Class sCRVClass;
  public static Method sCRVGetChildAdapterPositionMethod;
  public static Method sCRVGetLayoutManager;
  public static boolean sHasCustomRecyclerView;
  public static boolean sHasFragmentActivity;
  public static boolean sHasRecyclerViewClass = true;
  public static boolean sHasRecyclerViewGetChildAdapterPositionMethod = true;
  public static boolean sHasSupportFragment;
  public static boolean sHasSwipeRefreshLayoutView;
  public static boolean sHasV7AlertDialog;
  public static boolean sHasViewPager = true;
  public static boolean sHasX5WebView;
  public static Class sSwipeRefreshLayoutView;
  
  /* Error */
  static
  {
    // Byte code:
    //   0: iconst_1
    //   1: putstatic 28	com/growingio/android/sdk/utils/ClassExistHelper:sHasRecyclerViewClass	Z
    //   4: iconst_1
    //   5: putstatic 30	com/growingio/android/sdk/utils/ClassExistHelper:sHasRecyclerViewGetChildAdapterPositionMethod	Z
    //   8: iconst_1
    //   9: putstatic 32	com/growingio/android/sdk/utils/ClassExistHelper:sHasViewPager	Z
    //   12: iconst_0
    //   13: putstatic 34	com/growingio/android/sdk/utils/ClassExistHelper:sHasCustomRecyclerView	Z
    //   16: iconst_0
    //   17: putstatic 36	com/growingio/android/sdk/utils/ClassExistHelper:sHasSwipeRefreshLayoutView	Z
    //   20: iconst_1
    //   21: putstatic 38	com/growingio/android/sdk/utils/ClassExistHelper:sHasX5WebView	Z
    //   24: iconst_1
    //   25: putstatic 40	com/growingio/android/sdk/utils/ClassExistHelper:sHasV7AlertDialog	Z
    //   28: iconst_1
    //   29: putstatic 42	com/growingio/android/sdk/utils/ClassExistHelper:sHasFragmentActivity	Z
    //   32: iconst_1
    //   33: putstatic 44	com/growingio/android/sdk/utils/ClassExistHelper:sHasSupportFragment	Z
    //   36: ldc 46
    //   38: invokestatic 52	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   41: ldc 54
    //   43: iconst_1
    //   44: anewarray 48	java/lang/Class
    //   47: dup
    //   48: iconst_0
    //   49: ldc 56
    //   51: aastore
    //   52: invokevirtual 60	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   55: pop
    //   56: ldc 62
    //   58: invokestatic 52	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   61: putstatic 64	com/growingio/android/sdk/utils/ClassExistHelper:sSwipeRefreshLayoutView	Ljava/lang/Class;
    //   64: iconst_1
    //   65: putstatic 36	com/growingio/android/sdk/utils/ClassExistHelper:sHasSwipeRefreshLayoutView	Z
    //   68: ldc 66
    //   70: invokestatic 52	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   73: pop
    //   74: ldc 68
    //   76: invokestatic 52	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   79: pop
    //   80: ldc 70
    //   82: invokestatic 52	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   85: pop
    //   86: ldc 72
    //   88: invokestatic 52	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   91: pop
    //   92: ldc 74
    //   94: invokestatic 52	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   97: pop
    //   98: return
    //   99: astore_0
    //   100: iconst_0
    //   101: putstatic 28	com/growingio/android/sdk/utils/ClassExistHelper:sHasRecyclerViewClass	Z
    //   104: iconst_0
    //   105: putstatic 30	com/growingio/android/sdk/utils/ClassExistHelper:sHasRecyclerViewGetChildAdapterPositionMethod	Z
    //   108: goto -52 -> 56
    //   111: astore_0
    //   112: iconst_0
    //   113: putstatic 30	com/growingio/android/sdk/utils/ClassExistHelper:sHasRecyclerViewGetChildAdapterPositionMethod	Z
    //   116: goto -60 -> 56
    //   119: astore_0
    //   120: iconst_0
    //   121: putstatic 32	com/growingio/android/sdk/utils/ClassExistHelper:sHasViewPager	Z
    //   124: goto -50 -> 74
    //   127: astore_0
    //   128: iconst_0
    //   129: putstatic 38	com/growingio/android/sdk/utils/ClassExistHelper:sHasX5WebView	Z
    //   132: goto -52 -> 80
    //   135: astore_0
    //   136: iconst_0
    //   137: putstatic 40	com/growingio/android/sdk/utils/ClassExistHelper:sHasV7AlertDialog	Z
    //   140: aload_0
    //   141: invokestatic 80	com/growingio/android/sdk/utils/LogUtil:d	(Ljava/lang/Throwable;)V
    //   144: goto -58 -> 86
    //   147: astore_0
    //   148: iconst_0
    //   149: putstatic 42	com/growingio/android/sdk/utils/ClassExistHelper:sHasFragmentActivity	Z
    //   152: aload_0
    //   153: invokestatic 80	com/growingio/android/sdk/utils/LogUtil:d	(Ljava/lang/Throwable;)V
    //   156: goto -64 -> 92
    //   159: astore_0
    //   160: iconst_0
    //   161: putstatic 44	com/growingio/android/sdk/utils/ClassExistHelper:sHasSupportFragment	Z
    //   164: aload_0
    //   165: invokestatic 80	com/growingio/android/sdk/utils/LogUtil:d	(Ljava/lang/Throwable;)V
    //   168: return
    //   169: astore_0
    //   170: goto -102 -> 68
    // Local variable table:
    //   start	length	slot	name	signature
    //   99	1	0	localClassNotFoundException1	ClassNotFoundException
    //   111	1	0	localNoSuchMethodException	NoSuchMethodException
    //   119	1	0	localClassNotFoundException2	ClassNotFoundException
    //   127	1	0	localClassNotFoundException3	ClassNotFoundException
    //   135	6	0	localClassNotFoundException4	ClassNotFoundException
    //   147	6	0	localClassNotFoundException5	ClassNotFoundException
    //   159	6	0	localClassNotFoundException6	ClassNotFoundException
    //   169	1	0	localClassNotFoundException7	ClassNotFoundException
    // Exception table:
    //   from	to	target	type
    //   36	56	99	java/lang/ClassNotFoundException
    //   36	56	111	java/lang/NoSuchMethodException
    //   68	74	119	java/lang/ClassNotFoundException
    //   74	80	127	java/lang/ClassNotFoundException
    //   80	86	135	java/lang/ClassNotFoundException
    //   86	92	147	java/lang/ClassNotFoundException
    //   92	98	159	java/lang/ClassNotFoundException
    //   56	68	169	java/lang/ClassNotFoundException
  }
  
  private static Class<?> a(Class<?> paramClass)
  {
    for (;;)
    {
      if ((paramClass != null) && (!paramClass.equals(ViewGroup.class))) {}
      try
      {
        sCRVGetChildAdapterPositionMethod = paramClass.getDeclaredMethod("getChildAdapterPosition", new Class[] { View.class });
        if (sCRVGetChildAdapterPositionMethod == null) {}
        try
        {
          sCRVGetChildAdapterPositionMethod = paramClass.getDeclaredMethod("getChildPosition", new Class[] { View.class });
          if (sCRVGetChildAdapterPositionMethod != null) {
            return paramClass;
          }
          paramClass = paramClass.getSuperclass();
          continue;
          return null;
        }
        catch (NoSuchMethodException localNoSuchMethodException1)
        {
          for (;;) {}
        }
      }
      catch (NoSuchMethodException localNoSuchMethodException2)
      {
        for (;;) {}
      }
    }
  }
  
  @TargetApi(9)
  public static void checkCustomRecyclerView(Class<?> paramClass, String paramString)
  {
    if ((!sHasRecyclerViewClass) || ((!paramClass.equals(RecyclerView.class)) && (!sHasCustomRecyclerView) && (paramString.contains("RecyclerView")))) {}
    try
    {
      paramString = a(paramClass);
      if ((paramString != null) && (sCRVGetChildAdapterPositionMethod != null))
      {
        sCRVGetLayoutManager = paramString.getDeclaredMethod("getLayoutManager", new Class[0]);
        sCRVClass = paramClass;
        sHasCustomRecyclerView = true;
      }
      return;
    }
    catch (NoSuchMethodException paramClass)
    {
      paramClass.printStackTrace();
      return;
    }
    catch (NullPointerException paramClass)
    {
      paramClass.printStackTrace();
    }
  }
  
  public static boolean instanceOfFragmentActivity(Object paramObject)
  {
    return (sHasFragmentActivity) && ((paramObject instanceof FragmentActivity));
  }
  
  public static boolean instanceOfRecyclerView(Object paramObject)
  {
    return ((sHasRecyclerViewClass) && ((paramObject instanceof RecyclerView))) || ((sHasCustomRecyclerView) && (paramObject.getClass() == sCRVClass));
  }
  
  public static boolean instanceOfSupportFragment(Object paramObject)
  {
    return (sHasSupportFragment) && ((paramObject instanceof Fragment));
  }
  
  public static boolean instanceOfSwipeRefreshLayout(Object paramObject)
  {
    return (sHasSwipeRefreshLayoutView) && ((paramObject instanceof SwipeRefreshLayout));
  }
  
  public static boolean instanceOfV7AlertDialog(Object paramObject)
  {
    return (sHasV7AlertDialog) && ((paramObject instanceof c));
  }
  
  public static boolean instanceOfViewPager(Object paramObject)
  {
    return (sHasViewPager) && ((paramObject instanceof ViewPager));
  }
  
  public static boolean instanceOfX5ChromeClient(Object paramObject)
  {
    return (sHasX5WebView) && ((paramObject instanceof WebChromeClient));
  }
  
  public static boolean instanceOfX5WebView(Object paramObject)
  {
    return (sHasX5WebView) && ((paramObject instanceof WebView));
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/growingio/android/sdk/utils/ClassExistHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */