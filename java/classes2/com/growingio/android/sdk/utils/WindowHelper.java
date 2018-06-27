package com.growingio.android.sdk.utils;

import android.annotation.TargetApi;
import android.app.Activity;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import com.growingio.android.sdk.collection.AppState;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class WindowHelper
{
  static Object a;
  static Field b;
  static Class c;
  static Class d;
  static boolean e = false;
  static boolean f = false;
  public static Comparator<View> g = new Comparator()
  {
    public int a(View paramAnonymousView1, View paramAnonymousView2)
    {
      return paramAnonymousView2.getWidth() * paramAnonymousView2.getHeight() - paramAnonymousView1.getWidth() * paramAnonymousView1.getHeight();
    }
  };
  private static Class<?> h;
  private static Method i;
  private static Class<?> j;
  private static Method k;
  private static boolean l = false;
  
  public static String a(View paramView)
  {
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    if ((localLayoutParams != null) && ((localLayoutParams instanceof WindowManager.LayoutParams)))
    {
      int m = ((WindowManager.LayoutParams)localLayoutParams).type;
      if (m == 1) {
        return "/MainWindow";
      }
      if ((m < 99) && (paramView.getClass() == c)) {
        return "/DialogWindow";
      }
      if ((m < 1999) && (paramView.getClass() == d)) {
        return "/PopupWindow";
      }
      if (m < 2999) {
        return "/CustomWindow";
      }
    }
    paramView = paramView.getClass();
    if (paramView == c) {
      return "/DialogWindow";
    }
    if (paramView == d) {
      return "/PopupWindow";
    }
    return "/CustomWindow";
  }
  
  /* Error */
  public static void a()
  {
    // Byte code:
    //   0: getstatic 30	com/growingio/android/sdk/utils/WindowHelper:l	Z
    //   3: ifeq +4 -> 7
    //   6: return
    //   7: getstatic 83	android/os/Build$VERSION:SDK_INT	I
    //   10: bipush 17
    //   12: if_icmplt +161 -> 173
    //   15: ldc 85
    //   17: astore_1
    //   18: aload_1
    //   19: invokestatic 91	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   22: astore_2
    //   23: getstatic 83	android/os/Build$VERSION:SDK_INT	I
    //   26: bipush 17
    //   28: if_icmplt +151 -> 179
    //   31: ldc 93
    //   33: astore_1
    //   34: aload_2
    //   35: ldc 95
    //   37: invokevirtual 99	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   40: putstatic 101	com/growingio/android/sdk/utils/WindowHelper:b	Ljava/lang/reflect/Field;
    //   43: aload_2
    //   44: aload_1
    //   45: invokevirtual 99	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   48: astore_1
    //   49: getstatic 101	com/growingio/android/sdk/utils/WindowHelper:b	Ljava/lang/reflect/Field;
    //   52: iconst_1
    //   53: invokevirtual 107	java/lang/reflect/Field:setAccessible	(Z)V
    //   56: getstatic 101	com/growingio/android/sdk/utils/WindowHelper:b	Ljava/lang/reflect/Field;
    //   59: invokevirtual 110	java/lang/reflect/Field:getType	()Ljava/lang/Class;
    //   62: ldc 112
    //   64: if_acmpne +129 -> 193
    //   67: iconst_1
    //   68: putstatic 32	com/growingio/android/sdk/utils/WindowHelper:e	Z
    //   71: aload_1
    //   72: iconst_1
    //   73: invokevirtual 107	java/lang/reflect/Field:setAccessible	(Z)V
    //   76: aload_1
    //   77: aconst_null
    //   78: invokevirtual 116	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   81: putstatic 118	com/growingio/android/sdk/utils/WindowHelper:a	Ljava/lang/Object;
    //   84: ldc 120
    //   86: invokestatic 91	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   89: putstatic 122	com/growingio/android/sdk/utils/WindowHelper:h	Ljava/lang/Class;
    //   92: ldc 124
    //   94: invokestatic 91	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   97: ldc 126
    //   99: iconst_0
    //   100: anewarray 87	java/lang/Class
    //   103: invokevirtual 130	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   106: putstatic 132	com/growingio/android/sdk/utils/WindowHelper:i	Ljava/lang/reflect/Method;
    //   109: ldc -122
    //   111: invokestatic 91	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   114: putstatic 136	com/growingio/android/sdk/utils/WindowHelper:j	Ljava/lang/Class;
    //   117: ldc -118
    //   119: invokestatic 91	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   122: ldc 126
    //   124: iconst_0
    //   125: anewarray 87	java/lang/Class
    //   128: invokevirtual 130	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   131: putstatic 140	com/growingio/android/sdk/utils/WindowHelper:k	Ljava/lang/reflect/Method;
    //   134: getstatic 83	android/os/Build$VERSION:SDK_INT	I
    //   137: istore_0
    //   138: iload_0
    //   139: bipush 23
    //   141: if_icmplt +146 -> 287
    //   144: ldc -114
    //   146: invokestatic 91	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   149: putstatic 62	com/growingio/android/sdk/utils/WindowHelper:c	Ljava/lang/Class;
    //   152: getstatic 83	android/os/Build$VERSION:SDK_INT	I
    //   155: bipush 23
    //   157: if_icmplt +141 -> 298
    //   160: ldc -112
    //   162: invokestatic 91	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   165: putstatic 66	com/growingio/android/sdk/utils/WindowHelper:d	Ljava/lang/Class;
    //   168: iconst_1
    //   169: putstatic 30	com/growingio/android/sdk/utils/WindowHelper:l	Z
    //   172: return
    //   173: ldc -110
    //   175: astore_1
    //   176: goto -158 -> 18
    //   179: getstatic 83	android/os/Build$VERSION:SDK_INT	I
    //   182: bipush 13
    //   184: if_icmplt +133 -> 317
    //   187: ldc -108
    //   189: astore_1
    //   190: goto -156 -> 34
    //   193: getstatic 101	com/growingio/android/sdk/utils/WindowHelper:b	Ljava/lang/reflect/Field;
    //   196: invokevirtual 110	java/lang/reflect/Field:getType	()Ljava/lang/Class;
    //   199: ldc -106
    //   201: if_acmpne -130 -> 71
    //   204: iconst_1
    //   205: putstatic 34	com/growingio/android/sdk/utils/WindowHelper:f	Z
    //   208: goto -137 -> 71
    //   211: astore_1
    //   212: aload_1
    //   213: invokestatic 155	com/growingio/android/sdk/utils/LogUtil:d	(Ljava/lang/Throwable;)V
    //   216: goto -132 -> 84
    //   219: astore_1
    //   220: aload_1
    //   221: invokestatic 155	com/growingio/android/sdk/utils/LogUtil:d	(Ljava/lang/Throwable;)V
    //   224: goto -140 -> 84
    //   227: astore_1
    //   228: aload_1
    //   229: invokestatic 155	com/growingio/android/sdk/utils/LogUtil:d	(Ljava/lang/Throwable;)V
    //   232: goto -148 -> 84
    //   235: astore_1
    //   236: aload_1
    //   237: invokestatic 155	com/growingio/android/sdk/utils/LogUtil:d	(Ljava/lang/Throwable;)V
    //   240: goto -131 -> 109
    //   243: astore_1
    //   244: aload_1
    //   245: invokestatic 155	com/growingio/android/sdk/utils/LogUtil:d	(Ljava/lang/Throwable;)V
    //   248: goto -139 -> 109
    //   251: astore_1
    //   252: aload_1
    //   253: invokestatic 155	com/growingio/android/sdk/utils/LogUtil:d	(Ljava/lang/Throwable;)V
    //   256: goto -122 -> 134
    //   259: astore_1
    //   260: aload_1
    //   261: invokestatic 155	com/growingio/android/sdk/utils/LogUtil:d	(Ljava/lang/Throwable;)V
    //   264: goto -130 -> 134
    //   267: astore_1
    //   268: ldc -99
    //   270: invokestatic 91	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   273: putstatic 62	com/growingio/android/sdk/utils/WindowHelper:c	Ljava/lang/Class;
    //   276: goto -124 -> 152
    //   279: astore_1
    //   280: aload_1
    //   281: invokestatic 155	com/growingio/android/sdk/utils/LogUtil:d	(Ljava/lang/Throwable;)V
    //   284: goto -132 -> 152
    //   287: ldc -97
    //   289: invokestatic 91	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   292: putstatic 62	com/growingio/android/sdk/utils/WindowHelper:c	Ljava/lang/Class;
    //   295: goto -143 -> 152
    //   298: ldc -95
    //   300: invokestatic 91	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   303: putstatic 66	com/growingio/android/sdk/utils/WindowHelper:d	Ljava/lang/Class;
    //   306: goto -138 -> 168
    //   309: astore_1
    //   310: aload_1
    //   311: invokestatic 155	com/growingio/android/sdk/utils/LogUtil:d	(Ljava/lang/Throwable;)V
    //   314: goto -146 -> 168
    //   317: ldc -93
    //   319: astore_1
    //   320: goto -286 -> 34
    // Local variable table:
    //   start	length	slot	name	signature
    //   137	5	0	m	int
    //   17	173	1	localObject	Object
    //   211	2	1	localNoSuchFieldException	NoSuchFieldException
    //   219	2	1	localIllegalAccessException	IllegalAccessException
    //   227	2	1	localClassNotFoundException1	ClassNotFoundException
    //   235	2	1	localClassNotFoundException2	ClassNotFoundException
    //   243	2	1	localNoSuchMethodException1	NoSuchMethodException
    //   251	2	1	localClassNotFoundException3	ClassNotFoundException
    //   259	2	1	localNoSuchMethodException2	NoSuchMethodException
    //   267	1	1	localClassNotFoundException4	ClassNotFoundException
    //   279	2	1	localClassNotFoundException5	ClassNotFoundException
    //   309	2	1	localClassNotFoundException6	ClassNotFoundException
    //   319	1	1	str	String
    //   22	22	2	localClass	Class
    // Exception table:
    //   from	to	target	type
    //   18	31	211	java/lang/NoSuchFieldException
    //   34	71	211	java/lang/NoSuchFieldException
    //   71	84	211	java/lang/NoSuchFieldException
    //   179	187	211	java/lang/NoSuchFieldException
    //   193	208	211	java/lang/NoSuchFieldException
    //   18	31	219	java/lang/IllegalAccessException
    //   34	71	219	java/lang/IllegalAccessException
    //   71	84	219	java/lang/IllegalAccessException
    //   179	187	219	java/lang/IllegalAccessException
    //   193	208	219	java/lang/IllegalAccessException
    //   18	31	227	java/lang/ClassNotFoundException
    //   34	71	227	java/lang/ClassNotFoundException
    //   71	84	227	java/lang/ClassNotFoundException
    //   179	187	227	java/lang/ClassNotFoundException
    //   193	208	227	java/lang/ClassNotFoundException
    //   84	109	235	java/lang/ClassNotFoundException
    //   84	109	243	java/lang/NoSuchMethodException
    //   109	134	251	java/lang/ClassNotFoundException
    //   109	134	259	java/lang/NoSuchMethodException
    //   144	152	267	java/lang/ClassNotFoundException
    //   134	138	279	java/lang/ClassNotFoundException
    //   268	276	279	java/lang/ClassNotFoundException
    //   287	295	279	java/lang/ClassNotFoundException
    //   152	168	309	java/lang/ClassNotFoundException
    //   298	306	309	java/lang/ClassNotFoundException
  }
  
  public static View[] a(View[] paramArrayOfView)
  {
    int i2 = 0;
    int i3 = paramArrayOfView.length;
    int m = 0;
    int i1;
    for (int n = 0; m < i3; n = i1)
    {
      i1 = n;
      if (paramArrayOfView[m] == null) {
        i1 = n + 1;
      }
      m += 1;
    }
    View[] arrayOfView = paramArrayOfView;
    if (n > 0)
    {
      arrayOfView = new View[paramArrayOfView.length - n];
      n = 0;
      m = i2;
      while ((m < paramArrayOfView.length) && (n < arrayOfView.length))
      {
        i1 = n;
        if (paramArrayOfView[m] != null)
        {
          arrayOfView[n] = paramArrayOfView[m];
          i1 = n + 1;
        }
        m += 1;
        n = i1;
      }
    }
    return arrayOfView;
  }
  
  public static boolean b(View paramView)
  {
    paramView = paramView.getClass();
    return (paramView == c) || (paramView == d);
  }
  
  public static View[] b()
  {
    arrayOfView2 = new View[0];
    if (a == null)
    {
      localObject = AppState.l().i();
      if (localObject != null)
      {
        arrayOfView2 = new View[1];
        arrayOfView2[0] = ((Activity)localObject).getWindow().getDecorView();
      }
      return arrayOfView2;
    }
    Object localObject = null;
    for (;;)
    {
      try
      {
        if (!e) {
          continue;
        }
        localObject = (View[])((ArrayList)b.get(a)).toArray(arrayOfView2);
        if (localObject == null) {
          continue;
        }
      }
      catch (Exception localException)
      {
        LogUtil.d(localException);
        View[] arrayOfView1 = arrayOfView2;
        continue;
      }
      return a((View[])localObject);
      if (f) {
        localObject = (View[])b.get(a);
      }
    }
  }
  
  public static Object c(View paramView)
  {
    if (paramView.getClass() == h) {
      return i.invoke(paramView, new Object[0]);
    }
    if (paramView.getClass() == j) {
      return k.invoke(paramView, new Object[0]);
    }
    return null;
  }
  
  @TargetApi(9)
  public static View[] c()
  {
    View[] arrayOfView2 = b();
    View[] arrayOfView1 = arrayOfView2;
    if (arrayOfView2.length > 1)
    {
      arrayOfView1 = (View[])Arrays.copyOf(arrayOfView2, arrayOfView2.length);
      Arrays.sort(arrayOfView1, g);
    }
    return arrayOfView1;
  }
  
  public static String d()
  {
    return "/MainWindow";
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/growingio/android/sdk/utils/WindowHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */