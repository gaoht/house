package android.support.v4.graphics;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.FontVariationAxis;
import android.support.v4.content.res.FontResourcesParserCompat.FontFamilyFilesResourceEntry;
import android.support.v4.content.res.FontResourcesParserCompat.FontFileResourceEntry;
import android.util.Log;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;

public class TypefaceCompatApi26Impl
  extends TypefaceCompatApi21Impl
{
  private static final String ABORT_CREATION_METHOD = "abortCreation";
  private static final String ADD_FONT_FROM_ASSET_MANAGER_METHOD = "addFontFromAssetManager";
  private static final String ADD_FONT_FROM_BUFFER_METHOD = "addFontFromBuffer";
  private static final String CREATE_FROM_FAMILIES_WITH_DEFAULT_METHOD = "createFromFamiliesWithDefault";
  private static final String FONT_FAMILY_CLASS = "android.graphics.FontFamily";
  private static final String FREEZE_METHOD = "freeze";
  private static final int RESOLVE_BY_FONT_TABLE = -1;
  private static final String TAG = "TypefaceCompatApi26Impl";
  private static final Method sAbortCreation;
  private static final Method sAddFontFromAssetManager;
  private static final Method sAddFontFromBuffer;
  private static final Method sCreateFromFamiliesWithDefault;
  private static final Class sFontFamily;
  private static final Constructor sFontFamilyCtor;
  private static final Method sFreeze;
  
  static
  {
    Object localObject3 = null;
    try
    {
      localClass = Class.forName("android.graphics.FontFamily");
      localConstructor = localClass.getConstructor(new Class[0]);
      localMethod1 = localClass.getMethod("addFontFromAssetManager", new Class[] { AssetManager.class, String.class, Integer.TYPE, Boolean.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, FontVariationAxis[].class });
      localObject4 = localClass.getMethod("addFontFromBuffer", new Class[] { ByteBuffer.class, Integer.TYPE, FontVariationAxis[].class, Integer.TYPE, Integer.TYPE });
      localObject5 = localClass.getMethod("freeze", new Class[0]);
      localObject1 = localClass.getMethod("abortCreation", new Class[0]);
      Method localMethod2 = Typeface.class.getDeclaredMethod("createFromFamiliesWithDefault", new Class[] { Array.newInstance(localClass, 1).getClass(), Integer.TYPE, Integer.TYPE });
      localMethod2.setAccessible(true);
      localObject3 = localObject5;
      localObject5 = localObject4;
      localObject4 = localObject3;
      localObject3 = localObject1;
      localObject1 = localMethod2;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      for (;;)
      {
        Object localObject1;
        Log.e("TypefaceCompatApi26Impl", "Unable to collect necessary methods for class " + localClassNotFoundException.getClass().getName(), localClassNotFoundException);
        Object localObject2 = null;
        Object localObject4 = null;
        Object localObject5 = null;
        Method localMethod1 = null;
        Constructor localConstructor = null;
        Class localClass = null;
      }
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      for (;;) {}
    }
    sFontFamilyCtor = localConstructor;
    sFontFamily = localClass;
    sAddFontFromAssetManager = localMethod1;
    sAddFontFromBuffer = (Method)localObject5;
    sFreeze = (Method)localObject4;
    sAbortCreation = (Method)localObject3;
    sCreateFromFamiliesWithDefault = (Method)localObject1;
  }
  
  private static boolean abortCreation(Object paramObject)
  {
    try
    {
      boolean bool = ((Boolean)sAbortCreation.invoke(paramObject, new Object[0])).booleanValue();
      return bool;
    }
    catch (IllegalAccessException paramObject)
    {
      throw new RuntimeException((Throwable)paramObject);
    }
    catch (InvocationTargetException paramObject)
    {
      for (;;) {}
    }
  }
  
  private static boolean addFontFromAssetManager(Context paramContext, Object paramObject, String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    try
    {
      boolean bool = ((Boolean)sAddFontFromAssetManager.invoke(paramObject, new Object[] { paramContext.getAssets(), paramString, Integer.valueOf(0), Boolean.valueOf(false), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), null })).booleanValue();
      return bool;
    }
    catch (IllegalAccessException paramContext)
    {
      throw new RuntimeException(paramContext);
    }
    catch (InvocationTargetException paramContext)
    {
      for (;;) {}
    }
  }
  
  private static boolean addFontFromBuffer(Object paramObject, ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, int paramInt3)
  {
    try
    {
      boolean bool = ((Boolean)sAddFontFromBuffer.invoke(paramObject, new Object[] { paramByteBuffer, Integer.valueOf(paramInt1), null, Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) })).booleanValue();
      return bool;
    }
    catch (IllegalAccessException paramObject)
    {
      throw new RuntimeException((Throwable)paramObject);
    }
    catch (InvocationTargetException paramObject)
    {
      for (;;) {}
    }
  }
  
  private static Typeface createFromFamiliesWithDefault(Object paramObject)
  {
    try
    {
      Object localObject = Array.newInstance(sFontFamily, 1);
      Array.set(localObject, 0, paramObject);
      paramObject = (Typeface)sCreateFromFamiliesWithDefault.invoke(null, new Object[] { localObject, Integer.valueOf(-1), Integer.valueOf(-1) });
      return (Typeface)paramObject;
    }
    catch (IllegalAccessException paramObject)
    {
      throw new RuntimeException((Throwable)paramObject);
    }
    catch (InvocationTargetException paramObject)
    {
      for (;;) {}
    }
  }
  
  private static boolean freeze(Object paramObject)
  {
    try
    {
      boolean bool = ((Boolean)sFreeze.invoke(paramObject, new Object[0])).booleanValue();
      return bool;
    }
    catch (IllegalAccessException paramObject)
    {
      throw new RuntimeException((Throwable)paramObject);
    }
    catch (InvocationTargetException paramObject)
    {
      for (;;) {}
    }
  }
  
  private static boolean isFontFamilyPrivateAPIAvailable()
  {
    if (sAddFontFromAssetManager == null) {
      Log.w("TypefaceCompatApi26Impl", "Unable to collect necessary private methods.Fallback to legacy implementation.");
    }
    return sAddFontFromAssetManager != null;
  }
  
  private static Object newFamily()
  {
    try
    {
      Object localObject = sFontFamilyCtor.newInstance(new Object[0]);
      return localObject;
    }
    catch (InstantiationException localInstantiationException)
    {
      throw new RuntimeException(localInstantiationException);
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      for (;;) {}
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      for (;;) {}
    }
  }
  
  public Typeface createFromFontFamilyFilesResourceEntry(Context paramContext, FontResourcesParserCompat.FontFamilyFilesResourceEntry paramFontFamilyFilesResourceEntry, Resources paramResources, int paramInt)
  {
    if (!isFontFamilyPrivateAPIAvailable()) {
      return super.createFromFontFamilyFilesResourceEntry(paramContext, paramFontFamilyFilesResourceEntry, paramResources, paramInt);
    }
    paramResources = newFamily();
    paramFontFamilyFilesResourceEntry = paramFontFamilyFilesResourceEntry.getEntries();
    int j = paramFontFamilyFilesResourceEntry.length;
    paramInt = 0;
    while (paramInt < j)
    {
      Object localObject = paramFontFamilyFilesResourceEntry[paramInt];
      String str = ((FontResourcesParserCompat.FontFileResourceEntry)localObject).getFileName();
      int k = ((FontResourcesParserCompat.FontFileResourceEntry)localObject).getWeight();
      if (((FontResourcesParserCompat.FontFileResourceEntry)localObject).isItalic()) {}
      for (int i = 1; !addFontFromAssetManager(paramContext, paramResources, str, 0, k, i); i = 0)
      {
        abortCreation(paramResources);
        return null;
      }
      paramInt += 1;
    }
    if (!freeze(paramResources)) {
      return null;
    }
    return createFromFamiliesWithDefault(paramResources);
  }
  
  /* Error */
  public Typeface createFromFontInfo(Context paramContext, android.os.CancellationSignal paramCancellationSignal, android.support.v4.provider.FontsContractCompat.FontInfo[] paramArrayOfFontInfo, int paramInt)
  {
    // Byte code:
    //   0: aload_3
    //   1: arraylength
    //   2: iconst_1
    //   3: if_icmpge +7 -> 10
    //   6: aconst_null
    //   7: astore_2
    //   8: aload_2
    //   9: areturn
    //   10: invokestatic 196	android/support/v4/graphics/TypefaceCompatApi26Impl:isFontFamilyPrivateAPIAvailable	()Z
    //   13: ifne +128 -> 141
    //   16: aload_0
    //   17: aload_3
    //   18: iload 4
    //   20: invokevirtual 236	android/support/v4/graphics/TypefaceCompatApi26Impl:findBestInfo	([Landroid/support/v4/provider/FontsContractCompat$FontInfo;I)Landroid/support/v4/provider/FontsContractCompat$FontInfo;
    //   23: astore 9
    //   25: aload_1
    //   26: invokevirtual 240	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   29: astore_1
    //   30: aload_1
    //   31: aload 9
    //   33: invokevirtual 246	android/support/v4/provider/FontsContractCompat$FontInfo:getUri	()Landroid/net/Uri;
    //   36: ldc -8
    //   38: aload_2
    //   39: invokevirtual 254	android/content/ContentResolver:openFileDescriptor	(Landroid/net/Uri;Ljava/lang/String;Landroid/os/CancellationSignal;)Landroid/os/ParcelFileDescriptor;
    //   42: astore_3
    //   43: aconst_null
    //   44: astore_2
    //   45: new 256	android/graphics/Typeface$Builder
    //   48: dup
    //   49: aload_3
    //   50: invokevirtual 262	android/os/ParcelFileDescriptor:getFileDescriptor	()Ljava/io/FileDescriptor;
    //   53: invokespecial 265	android/graphics/Typeface$Builder:<init>	(Ljava/io/FileDescriptor;)V
    //   56: aload 9
    //   58: invokevirtual 266	android/support/v4/provider/FontsContractCompat$FontInfo:getWeight	()I
    //   61: invokevirtual 270	android/graphics/Typeface$Builder:setWeight	(I)Landroid/graphics/Typeface$Builder;
    //   64: aload 9
    //   66: invokevirtual 271	android/support/v4/provider/FontsContractCompat$FontInfo:isItalic	()Z
    //   69: invokevirtual 275	android/graphics/Typeface$Builder:setItalic	(Z)Landroid/graphics/Typeface$Builder;
    //   72: invokevirtual 279	android/graphics/Typeface$Builder:build	()Landroid/graphics/Typeface;
    //   75: astore_1
    //   76: aload_1
    //   77: astore_2
    //   78: aload_3
    //   79: ifnull -71 -> 8
    //   82: iconst_0
    //   83: ifeq +18 -> 101
    //   86: aload_3
    //   87: invokevirtual 282	android/os/ParcelFileDescriptor:close	()V
    //   90: aload_1
    //   91: areturn
    //   92: astore_1
    //   93: new 284	java/lang/NullPointerException
    //   96: dup
    //   97: invokespecial 285	java/lang/NullPointerException:<init>	()V
    //   100: athrow
    //   101: aload_3
    //   102: invokevirtual 282	android/os/ParcelFileDescriptor:close	()V
    //   105: aload_1
    //   106: areturn
    //   107: astore_2
    //   108: aload_2
    //   109: athrow
    //   110: astore_1
    //   111: aload_3
    //   112: ifnull +11 -> 123
    //   115: aload_2
    //   116: ifnull +18 -> 134
    //   119: aload_3
    //   120: invokevirtual 282	android/os/ParcelFileDescriptor:close	()V
    //   123: aload_1
    //   124: athrow
    //   125: astore_3
    //   126: aload_2
    //   127: aload_3
    //   128: invokevirtual 288	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   131: goto -8 -> 123
    //   134: aload_3
    //   135: invokevirtual 282	android/os/ParcelFileDescriptor:close	()V
    //   138: goto -15 -> 123
    //   141: aload_1
    //   142: aload_3
    //   143: aload_2
    //   144: invokestatic 294	android/support/v4/provider/FontsContractCompat:prepareFontData	(Landroid/content/Context;[Landroid/support/v4/provider/FontsContractCompat$FontInfo;Landroid/os/CancellationSignal;)Ljava/util/Map;
    //   147: astore_1
    //   148: invokestatic 200	android/support/v4/graphics/TypefaceCompatApi26Impl:newFamily	()Ljava/lang/Object;
    //   151: astore 9
    //   153: iconst_0
    //   154: istore 4
    //   156: aload_3
    //   157: arraylength
    //   158: istore 6
    //   160: iconst_0
    //   161: istore 5
    //   163: iload 5
    //   165: iload 6
    //   167: if_icmpge +97 -> 264
    //   170: aload_3
    //   171: iload 5
    //   173: aaload
    //   174: astore 10
    //   176: aload_1
    //   177: aload 10
    //   179: invokevirtual 246	android/support/v4/provider/FontsContractCompat$FontInfo:getUri	()Landroid/net/Uri;
    //   182: invokeinterface 300 2 0
    //   187: checkcast 75	java/nio/ByteBuffer
    //   190: astore_2
    //   191: aload_2
    //   192: ifnonnull +12 -> 204
    //   195: iload 5
    //   197: iconst_1
    //   198: iadd
    //   199: istore 5
    //   201: goto -38 -> 163
    //   204: aload 10
    //   206: invokevirtual 303	android/support/v4/provider/FontsContractCompat$FontInfo:getTtcIndex	()I
    //   209: istore 8
    //   211: aload 10
    //   213: invokevirtual 266	android/support/v4/provider/FontsContractCompat$FontInfo:getWeight	()I
    //   216: istore 7
    //   218: aload 10
    //   220: invokevirtual 271	android/support/v4/provider/FontsContractCompat$FontInfo:isItalic	()Z
    //   223: ifeq +29 -> 252
    //   226: iconst_1
    //   227: istore 4
    //   229: aload 9
    //   231: aload_2
    //   232: iload 8
    //   234: iload 7
    //   236: iload 4
    //   238: invokestatic 305	android/support/v4/graphics/TypefaceCompatApi26Impl:addFontFromBuffer	(Ljava/lang/Object;Ljava/nio/ByteBuffer;III)Z
    //   241: ifne +17 -> 258
    //   244: aload 9
    //   246: invokestatic 222	android/support/v4/graphics/TypefaceCompatApi26Impl:abortCreation	(Ljava/lang/Object;)Z
    //   249: pop
    //   250: aconst_null
    //   251: areturn
    //   252: iconst_0
    //   253: istore 4
    //   255: goto -26 -> 229
    //   258: iconst_1
    //   259: istore 4
    //   261: goto -66 -> 195
    //   264: iload 4
    //   266: ifne +11 -> 277
    //   269: aload 9
    //   271: invokestatic 222	android/support/v4/graphics/TypefaceCompatApi26Impl:abortCreation	(Ljava/lang/Object;)Z
    //   274: pop
    //   275: aconst_null
    //   276: areturn
    //   277: aload 9
    //   279: invokestatic 224	android/support/v4/graphics/TypefaceCompatApi26Impl:freeze	(Ljava/lang/Object;)Z
    //   282: ifne +5 -> 287
    //   285: aconst_null
    //   286: areturn
    //   287: aload 9
    //   289: invokestatic 226	android/support/v4/graphics/TypefaceCompatApi26Impl:createFromFamiliesWithDefault	(Ljava/lang/Object;)Landroid/graphics/Typeface;
    //   292: areturn
    //   293: astore_1
    //   294: goto -183 -> 111
    //   297: astore_1
    //   298: aconst_null
    //   299: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	300	0	this	TypefaceCompatApi26Impl
    //   0	300	1	paramContext	Context
    //   0	300	2	paramCancellationSignal	android.os.CancellationSignal
    //   0	300	3	paramArrayOfFontInfo	android.support.v4.provider.FontsContractCompat.FontInfo[]
    //   0	300	4	paramInt	int
    //   161	39	5	i	int
    //   158	10	6	j	int
    //   216	19	7	k	int
    //   209	24	8	m	int
    //   23	265	9	localObject	Object
    //   174	45	10	localFontInfo	android.support.v4.provider.FontsContractCompat.FontInfo
    // Exception table:
    //   from	to	target	type
    //   86	90	92	java/lang/Throwable
    //   45	76	107	java/lang/Throwable
    //   108	110	110	finally
    //   119	123	125	java/lang/Throwable
    //   45	76	293	finally
    //   30	43	297	java/io/IOException
    //   86	90	297	java/io/IOException
    //   93	101	297	java/io/IOException
    //   101	105	297	java/io/IOException
    //   119	123	297	java/io/IOException
    //   123	125	297	java/io/IOException
    //   126	131	297	java/io/IOException
    //   134	138	297	java/io/IOException
  }
  
  public Typeface createFromResourcesFontFile(Context paramContext, Resources paramResources, int paramInt1, String paramString, int paramInt2)
  {
    if (!isFontFamilyPrivateAPIAvailable()) {
      return super.createFromResourcesFontFile(paramContext, paramResources, paramInt1, paramString, paramInt2);
    }
    paramResources = newFamily();
    if (!addFontFromAssetManager(paramContext, paramResources, paramString, 0, -1, -1))
    {
      abortCreation(paramResources);
      return null;
    }
    if (!freeze(paramResources)) {
      return null;
    }
    return createFromFamiliesWithDefault(paramResources);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/android/support/v4/graphics/TypefaceCompatApi26Impl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */