package cn.testin.analysis;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.Base64;
import android.util.Log;
import android.util.LruCache;
import android.util.Pair;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;

@TargetApi(14)
public class an
{
  private static LruCache<String, Drawable> e;
  private Context a;
  private File b;
  private final fk c;
  private final MessageDigest d;
  private Set<String> f;
  
  public an(Context paramContext, String paramString)
  {
    this(paramContext, "Image" + paramString, new fj());
  }
  
  public an(Context paramContext, String paramString, fk paramfk)
  {
    this.a = paramContext;
    this.b = new File(am.a(paramContext) + "/" + paramString);
    if ((this.b != null) && (!this.b.exists())) {
      this.b.mkdirs();
    }
    this.c = paramfk;
    try
    {
      paramContext = MessageDigest.getInstance("SHA1");
      this.d = paramContext;
      if (e != null) {}
    }
    catch (NoSuchAlgorithmException paramContext)
    {
      for (;;)
      {
        try
        {
          if (e == null) {
            e = new ao(this, (int)(Runtime.getRuntime().maxMemory() / 1024L) / 10);
          }
          return;
        }
        finally {}
        paramContext = paramContext;
        Log.w("ImageStore", "Images won't be stored because this platform doesn't supply a SHA1 hash function");
        paramContext = null;
      }
    }
  }
  
  private static Drawable a(File paramFile, Pair<Integer, Integer> paramPair)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramFile.getAbsolutePath(), localOptions);
    if (localOptions.outHeight * localOptions.outWidth > b()) {
      throw new ap("Do not have enough memory for the image");
    }
    int i;
    int j;
    if ((paramPair != null) && (((Integer)paramPair.first).intValue() > 0) && (((Integer)paramPair.second).intValue() > 0))
    {
      i = ((Integer)paramPair.first).intValue();
      j = ((Integer)paramPair.second).intValue();
      int k = Math.max(localOptions.outWidth / i, localOptions.outHeight / j);
      if (k >= 1)
      {
        paramPair = new BitmapFactory.Options();
        paramPair.inSampleSize = k;
        paramPair = BitmapFactory.decodeFile(paramFile.getAbsolutePath(), paramPair);
      }
    }
    while (paramPair == null)
    {
      paramFile.delete();
      throw new ap("Bitmap on disk can't be opened or was corrupt");
      Bitmap localBitmap = BitmapFactory.decodeFile(paramFile.getAbsolutePath());
      float f1 = Math.min(i / localOptions.outWidth, j / localOptions.outHeight);
      paramPair = new Matrix();
      paramPair.postScale(f1, f1);
      paramPair = Bitmap.createBitmap(localBitmap, 0, 0, localOptions.outWidth, localOptions.outHeight, paramPair, true);
      if ((localBitmap != null) && (!localBitmap.isRecycled())) {
        localBitmap.recycle();
      }
      continue;
      paramPair = BitmapFactory.decodeFile(paramFile.getAbsolutePath());
    }
    return new BitmapDrawable(Resources.getSystem(), paramPair);
  }
  
  @TargetApi(21)
  private Drawable a(String paramString1, String paramString2)
  {
    int i = this.a.getResources().getIdentifier(paramString1, paramString2, this.a.getPackageName());
    if (i == 0) {
      throw new ap("can not find resource id");
    }
    try
    {
      if (Build.VERSION.SDK_INT >= 21) {
        return this.a.getDrawable(i);
      }
      paramString1 = this.a.getResources().getDrawable(i);
      return paramString1;
    }
    catch (Resources.NotFoundException paramString1)
    {
      throw new ap("can not find the image resource");
    }
  }
  
  public static void a(String paramString, Drawable paramDrawable)
  {
    if (c(paramString) == null) {
      synchronized (e)
      {
        e.put(paramString, paramDrawable);
        return;
      }
    }
  }
  
  private static float b()
  {
    Runtime localRuntime = Runtime.getRuntime();
    float f1 = (float)(localRuntime.totalMemory() - localRuntime.freeMemory());
    return (float)localRuntime.maxMemory() - f1;
  }
  
  public static Drawable c(String paramString)
  {
    synchronized (e)
    {
      paramString = (Drawable)e.get(paramString);
      return paramString;
    }
  }
  
  public static void d(String paramString)
  {
    synchronized (e)
    {
      e.remove(paramString);
      return;
    }
  }
  
  private Drawable e(String paramString)
  {
    try
    {
      paramString = this.a.getAssets().open(paramString);
      paramString = new BitmapDrawable(Resources.getSystem(), BitmapFactory.decodeStream(paramString));
      return paramString;
    }
    catch (IOException paramString)
    {
      throw new ap("decode assets's image err!");
    }
  }
  
  private List<String> f(String paramString)
  {
    Object localObject1 = this.a.getPackageName() + ".R$" + paramString;
    Object localObject3 = new ArrayList();
    try
    {
      Field[] arrayOfField = Class.forName((String)localObject1).getFields();
      if (arrayOfField != null)
      {
        localObject1 = new ArrayList();
        int j;
        int i;
        return (List<String>)localObject3;
      }
    }
    catch (ClassNotFoundException localClassNotFoundException1)
    {
      try
      {
        j = arrayOfField.length;
        i = 0;
        for (;;)
        {
          localObject3 = localObject1;
          if (i >= j) {
            break;
          }
          localObject3 = arrayOfField[i];
          ((List)localObject1).add("@" + paramString + "/" + ((Field)localObject3).getName());
          i += 1;
        }
        localClassNotFoundException1 = localClassNotFoundException1;
        paramString = (String)localObject3;
      }
      catch (ClassNotFoundException localClassNotFoundException2)
      {
        for (;;)
        {
          paramString = localClassNotFoundException1;
          Object localObject2 = localClassNotFoundException2;
        }
      }
      localClassNotFoundException1.printStackTrace();
      localObject3 = paramString;
    }
    return localClassNotFoundException2;
  }
  
  private File g(String paramString)
  {
    if ((this.b == null) || (this.d == null)) {
      return null;
    }
    paramString = this.d.digest(paramString.getBytes());
    paramString = "TESTIN_IMG_" + Base64.encodeToString(paramString, 10);
    return new File(this.b, paramString);
  }
  
  public Drawable a(String paramString, Pair<Integer, Integer> paramPair)
  {
    return a(paramString, true, true, paramPair);
  }
  
  /* Error */
  public Drawable a(String paramString, boolean paramBoolean1, boolean paramBoolean2, Pair<Integer, Integer> paramPair)
  {
    // Byte code:
    //   0: aload 4
    //   2: ifnonnull +78 -> 80
    //   5: aload_1
    //   6: astore 7
    //   8: iload_2
    //   9: ifeq +136 -> 145
    //   12: aload 7
    //   14: invokestatic 246	cn/testin/analysis/an:c	(Ljava/lang/String;)Landroid/graphics/drawable/Drawable;
    //   17: astore 5
    //   19: aload 5
    //   21: astore 6
    //   23: aload 5
    //   25: ifnonnull +52 -> 77
    //   28: aload 5
    //   30: astore 6
    //   32: iload_3
    //   33: ifeq +44 -> 77
    //   36: aload 5
    //   38: astore 6
    //   40: ldc_w 352
    //   43: invokestatic 356	cn/testin/analysis/ar:f	(Ljava/lang/String;)V
    //   46: aload 5
    //   48: astore 6
    //   50: aload_0
    //   51: aload_1
    //   52: aload 4
    //   54: invokevirtual 358	cn/testin/analysis/an:c	(Ljava/lang/String;Landroid/util/Pair;)Landroid/graphics/drawable/Drawable;
    //   57: astore_1
    //   58: aload_1
    //   59: astore 6
    //   61: iload_2
    //   62: ifeq +15 -> 77
    //   65: aload_1
    //   66: astore 6
    //   68: aload 7
    //   70: aload_1
    //   71: invokestatic 360	cn/testin/analysis/an:a	(Ljava/lang/String;Landroid/graphics/drawable/Drawable;)V
    //   74: aload_1
    //   75: astore 6
    //   77: aload 6
    //   79: areturn
    //   80: new 25	java/lang/StringBuilder
    //   83: dup
    //   84: invokespecial 28	java/lang/StringBuilder:<init>	()V
    //   87: aload_1
    //   88: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: ldc_w 362
    //   94: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: aload 4
    //   99: getfield 150	android/util/Pair:first	Ljava/lang/Object;
    //   102: invokevirtual 365	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   105: ldc_w 367
    //   108: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: aload 4
    //   113: getfield 159	android/util/Pair:second	Ljava/lang/Object;
    //   116: invokevirtual 365	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   119: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   122: astore 7
    //   124: goto -116 -> 8
    //   127: astore_1
    //   128: aload_1
    //   129: athrow
    //   130: astore_1
    //   131: aconst_null
    //   132: astore 6
    //   134: aload_1
    //   135: invokestatic 370	cn/testin/analysis/ar:a	(Ljava/lang/Throwable;)V
    //   138: aload 6
    //   140: areturn
    //   141: astore_1
    //   142: goto -8 -> 134
    //   145: aconst_null
    //   146: astore 5
    //   148: goto -129 -> 19
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	151	0	this	an
    //   0	151	1	paramString	String
    //   0	151	2	paramBoolean1	boolean
    //   0	151	3	paramBoolean2	boolean
    //   0	151	4	paramPair	Pair<Integer, Integer>
    //   17	130	5	localDrawable	Drawable
    //   21	118	6	localObject	Object
    //   6	117	7	str	String
    // Exception table:
    //   from	to	target	type
    //   12	19	127	cn/testin/analysis/ap
    //   40	46	127	cn/testin/analysis/ap
    //   50	58	127	cn/testin/analysis/ap
    //   68	74	127	cn/testin/analysis/ap
    //   80	124	127	cn/testin/analysis/ap
    //   12	19	130	java/lang/Exception
    //   80	124	130	java/lang/Exception
    //   40	46	141	java/lang/Exception
    //   50	58	141	java/lang/Exception
    //   68	74	141	java/lang/Exception
  }
  
  public List<String> a()
  {
    this.f = new HashSet();
    this.f.add("jpg");
    this.f.add("png");
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(f("drawable"));
    localArrayList.addAll(f("mipmap"));
    JSONArray localJSONArray = new JSONArray();
    Iterator localIterator = localArrayList.iterator();
    while (localIterator.hasNext()) {
      localJSONArray.put((String)localIterator.next());
    }
    return localArrayList;
  }
  
  /* Error */
  public void a(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aconst_null
    //   3: astore 4
    //   5: aload_0
    //   6: aload_1
    //   7: invokespecial 422	cn/testin/analysis/an:g	(Ljava/lang/String;)Ljava/io/File;
    //   10: astore 5
    //   12: aload 5
    //   14: ifnull +11 -> 25
    //   17: aload 5
    //   19: invokevirtual 68	java/io/File:exists	()Z
    //   22: ifne +77 -> 99
    //   25: ldc_w 424
    //   28: invokestatic 429	javax/net/ssl/SSLContext:getInstance	(Ljava/lang/String;)Ljavax/net/ssl/SSLContext;
    //   31: astore_3
    //   32: aload_3
    //   33: aconst_null
    //   34: aconst_null
    //   35: aconst_null
    //   36: invokevirtual 433	javax/net/ssl/SSLContext:init	([Ljavax/net/ssl/KeyManager;[Ljavax/net/ssl/TrustManager;Ljava/security/SecureRandom;)V
    //   39: aload_3
    //   40: invokevirtual 437	javax/net/ssl/SSLContext:getSocketFactory	()Ljavax/net/ssl/SSLSocketFactory;
    //   43: astore_3
    //   44: aload_0
    //   45: getfield 73	cn/testin/analysis/an:c	Lcn/testin/analysis/fk;
    //   48: aload_1
    //   49: aconst_null
    //   50: aload_3
    //   51: invokeinterface 442 4 0
    //   56: astore_3
    //   57: aload_3
    //   58: ifnull +41 -> 99
    //   61: aload 5
    //   63: ifnull +36 -> 99
    //   66: aload_3
    //   67: arraylength
    //   68: ldc_w 443
    //   71: if_icmpge +28 -> 99
    //   74: new 445	java/io/FileOutputStream
    //   77: dup
    //   78: aload 5
    //   80: invokespecial 448	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   83: astore_1
    //   84: aload_1
    //   85: astore_2
    //   86: aload_1
    //   87: aload_3
    //   88: invokevirtual 454	java/io/OutputStream:write	([B)V
    //   91: aload_1
    //   92: ifnull +7 -> 99
    //   95: aload_1
    //   96: invokevirtual 457	java/io/OutputStream:close	()V
    //   99: aload 5
    //   101: ifnull +11 -> 112
    //   104: aload 5
    //   106: invokevirtual 68	java/io/File:exists	()Z
    //   109: ifne +136 -> 245
    //   112: new 141	cn/testin/analysis/ap
    //   115: dup
    //   116: ldc_w 459
    //   119: invokespecial 144	cn/testin/analysis/ap:<init>	(Ljava/lang/String;)V
    //   122: athrow
    //   123: astore_1
    //   124: new 141	cn/testin/analysis/ap
    //   127: dup
    //   128: ldc_w 461
    //   131: aload_1
    //   132: invokespecial 464	cn/testin/analysis/ap:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   135: athrow
    //   136: astore_1
    //   137: new 141	cn/testin/analysis/ap
    //   140: dup
    //   141: ldc_w 466
    //   144: aload_1
    //   145: invokespecial 464	cn/testin/analysis/ap:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   148: athrow
    //   149: astore_1
    //   150: aload_1
    //   151: invokevirtual 467	java/security/NoSuchAlgorithmException:printStackTrace	()V
    //   154: aconst_null
    //   155: astore_3
    //   156: goto -99 -> 57
    //   159: astore_1
    //   160: aload_1
    //   161: invokevirtual 468	java/security/KeyManagementException:printStackTrace	()V
    //   164: aconst_null
    //   165: astore_3
    //   166: goto -109 -> 57
    //   169: astore_1
    //   170: ldc 104
    //   172: ldc_w 470
    //   175: aload_1
    //   176: invokestatic 473	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   179: pop
    //   180: goto -81 -> 99
    //   183: astore_3
    //   184: aconst_null
    //   185: astore_1
    //   186: aload_1
    //   187: astore_2
    //   188: new 141	cn/testin/analysis/ap
    //   191: dup
    //   192: ldc_w 475
    //   195: aload_3
    //   196: invokespecial 464	cn/testin/analysis/ap:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   199: athrow
    //   200: astore_1
    //   201: aload_2
    //   202: ifnull +7 -> 209
    //   205: aload_2
    //   206: invokevirtual 457	java/io/OutputStream:close	()V
    //   209: aload_1
    //   210: athrow
    //   211: astore_1
    //   212: aload 4
    //   214: astore_2
    //   215: new 141	cn/testin/analysis/ap
    //   218: dup
    //   219: ldc_w 459
    //   222: aload_1
    //   223: invokespecial 464	cn/testin/analysis/ap:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   226: athrow
    //   227: astore_1
    //   228: goto -27 -> 201
    //   231: astore_2
    //   232: ldc 104
    //   234: ldc_w 470
    //   237: aload_2
    //   238: invokestatic 473	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   241: pop
    //   242: goto -33 -> 209
    //   245: return
    //   246: astore_3
    //   247: aload_1
    //   248: astore_2
    //   249: aload_3
    //   250: astore_1
    //   251: goto -36 -> 215
    //   254: astore_3
    //   255: goto -69 -> 186
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	258	0	this	an
    //   0	258	1	paramString	String
    //   1	214	2	localObject1	Object
    //   231	7	2	localIOException1	IOException
    //   248	1	2	str	String
    //   31	135	3	localObject2	Object
    //   183	13	3	localFileNotFoundException1	java.io.FileNotFoundException
    //   246	4	3	localIOException2	IOException
    //   254	1	3	localFileNotFoundException2	java.io.FileNotFoundException
    //   3	210	4	localObject3	Object
    //   10	95	5	localFile	File
    // Exception table:
    //   from	to	target	type
    //   25	57	123	java/io/IOException
    //   25	57	136	cn/testin/analysis/fl
    //   25	57	149	java/security/NoSuchAlgorithmException
    //   25	57	159	java/security/KeyManagementException
    //   95	99	169	java/io/IOException
    //   74	84	183	java/io/FileNotFoundException
    //   86	91	200	finally
    //   188	200	200	finally
    //   74	84	211	java/io/IOException
    //   74	84	227	finally
    //   215	227	227	finally
    //   205	209	231	java/io/IOException
    //   86	91	246	java/io/IOException
    //   86	91	254	java/io/FileNotFoundException
  }
  
  public Drawable b(String paramString, Pair<Integer, Integer> paramPair)
  {
    Object localObject = null;
    if (paramString.startsWith("@"))
    {
      if (paramString.startsWith("@assets/")) {
        paramPair = e(paramString.replaceFirst("@assets/", ""));
      }
      do
      {
        return paramPair;
        if (paramString.startsWith("@drawable/")) {
          return a(paramString.replaceFirst("@drawable/", ""), "drawable");
        }
        paramPair = (Pair<Integer, Integer>)localObject;
      } while (!paramString.startsWith("@mipmap/"));
      return a(paramString.replaceFirst("@mipmap/", ""), "mipmap");
    }
    return a(paramString, paramPair);
  }
  
  public void b(String paramString)
  {
    File localFile = g(paramString);
    if (localFile != null)
    {
      localFile.delete();
      d(paramString);
    }
  }
  
  public Drawable c(String paramString, Pair<Integer, Integer> paramPair)
  {
    paramString = g(paramString);
    if ((paramString != null) && (paramString.exists())) {
      return a(paramString, paramPair);
    }
    return null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/testin/analysis/an.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */