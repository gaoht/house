package android.support.v7.widget;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.database.DataSetObservable;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;
import android.util.Xml;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.xmlpull.v1.XmlSerializer;

class c
  extends DataSetObservable
{
  static final String a = c.class.getSimpleName();
  private static final Object e = new Object();
  private static final Map<String, c> f = new HashMap();
  final Context b;
  final String c;
  boolean d = true;
  private final Object g = new Object();
  private final List<a> h = new ArrayList();
  private final List<d> i = new ArrayList();
  private Intent j;
  private b k = new c();
  private int l = 50;
  private boolean m = false;
  private boolean n = true;
  private boolean o = false;
  private e p;
  
  private c(Context paramContext, String paramString)
  {
    this.b = paramContext.getApplicationContext();
    if ((!TextUtils.isEmpty(paramString)) && (!paramString.endsWith(".xml")))
    {
      this.c = (paramString + ".xml");
      return;
    }
    this.c = paramString;
  }
  
  private void a()
  {
    if (!this.m) {
      throw new IllegalStateException("No preceding call to #readHistoricalData");
    }
    if (!this.n) {}
    do
    {
      return;
      this.n = false;
    } while (TextUtils.isEmpty(this.c));
    new f().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Object[] { new ArrayList(this.i), this.c });
  }
  
  private boolean a(d paramd)
  {
    boolean bool = this.i.add(paramd);
    if (bool)
    {
      this.n = true;
      f();
      a();
      c();
      notifyChanged();
    }
    return bool;
  }
  
  private void b()
  {
    boolean bool1 = d();
    boolean bool2 = e();
    f();
    if ((bool1 | bool2))
    {
      c();
      notifyChanged();
    }
  }
  
  private boolean c()
  {
    if ((this.k != null) && (this.j != null) && (!this.h.isEmpty()) && (!this.i.isEmpty()))
    {
      this.k.sort(this.j, this.h, Collections.unmodifiableList(this.i));
      return true;
    }
    return false;
  }
  
  private boolean d()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.o)
    {
      bool1 = bool2;
      if (this.j != null)
      {
        this.o = false;
        this.h.clear();
        List localList = this.b.getPackageManager().queryIntentActivities(this.j, 0);
        int i2 = localList.size();
        int i1 = 0;
        while (i1 < i2)
        {
          ResolveInfo localResolveInfo = (ResolveInfo)localList.get(i1);
          this.h.add(new a(localResolveInfo));
          i1 += 1;
        }
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private boolean e()
  {
    if ((this.d) && (this.n) && (!TextUtils.isEmpty(this.c)))
    {
      this.d = false;
      this.m = true;
      g();
      return true;
    }
    return false;
  }
  
  private void f()
  {
    int i2 = this.i.size() - this.l;
    if (i2 <= 0) {}
    for (;;)
    {
      return;
      this.n = true;
      int i1 = 0;
      while (i1 < i2)
      {
        d locald = (d)this.i.remove(0);
        i1 += 1;
      }
    }
  }
  
  /* Error */
  private void g()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 100	android/support/v7/widget/c:b	Landroid/content/Context;
    //   4: aload_0
    //   5: getfield 126	android/support/v7/widget/c:c	Ljava/lang/String;
    //   8: invokevirtual 225	android/content/Context:openFileInput	(Ljava/lang/String;)Ljava/io/FileInputStream;
    //   11: astore_2
    //   12: invokestatic 231	android/util/Xml:newPullParser	()Lorg/xmlpull/v1/XmlPullParser;
    //   15: astore_3
    //   16: aload_3
    //   17: aload_2
    //   18: ldc -23
    //   20: invokeinterface 239 3 0
    //   25: iconst_0
    //   26: istore_1
    //   27: iload_1
    //   28: iconst_1
    //   29: if_icmpeq +18 -> 47
    //   32: iload_1
    //   33: iconst_2
    //   34: if_icmpeq +13 -> 47
    //   37: aload_3
    //   38: invokeinterface 242 1 0
    //   43: istore_1
    //   44: goto -17 -> 27
    //   47: ldc -12
    //   49: aload_3
    //   50: invokeinterface 247 1 0
    //   55: invokevirtual 250	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   58: ifne +53 -> 111
    //   61: new 219	org/xmlpull/v1/XmlPullParserException
    //   64: dup
    //   65: ldc -4
    //   67: invokespecial 253	org/xmlpull/v1/XmlPullParserException:<init>	(Ljava/lang/String;)V
    //   70: athrow
    //   71: astore_3
    //   72: getstatic 55	android/support/v7/widget/c:a	Ljava/lang/String;
    //   75: new 116	java/lang/StringBuilder
    //   78: dup
    //   79: invokespecial 117	java/lang/StringBuilder:<init>	()V
    //   82: ldc -1
    //   84: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: aload_0
    //   88: getfield 126	android/support/v7/widget/c:c	Ljava/lang/String;
    //   91: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   97: aload_3
    //   98: invokestatic 260	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   101: pop
    //   102: aload_2
    //   103: ifnull +7 -> 110
    //   106: aload_2
    //   107: invokevirtual 265	java/io/FileInputStream:close	()V
    //   110: return
    //   111: aload_0
    //   112: getfield 79	android/support/v7/widget/c:i	Ljava/util/List;
    //   115: astore 4
    //   117: aload 4
    //   119: invokeinterface 187 1 0
    //   124: aload_3
    //   125: invokeinterface 242 1 0
    //   130: istore_1
    //   131: iload_1
    //   132: iconst_1
    //   133: if_icmpne +14 -> 147
    //   136: aload_2
    //   137: ifnull -27 -> 110
    //   140: aload_2
    //   141: invokevirtual 265	java/io/FileInputStream:close	()V
    //   144: return
    //   145: astore_2
    //   146: return
    //   147: iload_1
    //   148: iconst_3
    //   149: if_icmpeq -25 -> 124
    //   152: iload_1
    //   153: iconst_4
    //   154: if_icmpeq -30 -> 124
    //   157: ldc_w 267
    //   160: aload_3
    //   161: invokeinterface 247 1 0
    //   166: invokevirtual 250	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   169: ifne +56 -> 225
    //   172: new 219	org/xmlpull/v1/XmlPullParserException
    //   175: dup
    //   176: ldc_w 269
    //   179: invokespecial 253	org/xmlpull/v1/XmlPullParserException:<init>	(Ljava/lang/String;)V
    //   182: athrow
    //   183: astore_3
    //   184: getstatic 55	android/support/v7/widget/c:a	Ljava/lang/String;
    //   187: new 116	java/lang/StringBuilder
    //   190: dup
    //   191: invokespecial 117	java/lang/StringBuilder:<init>	()V
    //   194: ldc -1
    //   196: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   199: aload_0
    //   200: getfield 126	android/support/v7/widget/c:c	Ljava/lang/String;
    //   203: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   206: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   209: aload_3
    //   210: invokestatic 260	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   213: pop
    //   214: aload_2
    //   215: ifnull -105 -> 110
    //   218: aload_2
    //   219: invokevirtual 265	java/io/FileInputStream:close	()V
    //   222: return
    //   223: astore_2
    //   224: return
    //   225: aload 4
    //   227: new 15	android/support/v7/widget/c$d
    //   230: dup
    //   231: aload_3
    //   232: aconst_null
    //   233: ldc_w 271
    //   236: invokeinterface 275 3 0
    //   241: aload_3
    //   242: aconst_null
    //   243: ldc_w 277
    //   246: invokeinterface 275 3 0
    //   251: invokestatic 283	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   254: aload_3
    //   255: aconst_null
    //   256: ldc_w 285
    //   259: invokeinterface 275 3 0
    //   264: invokestatic 291	java/lang/Float:parseFloat	(Ljava/lang/String;)F
    //   267: invokespecial 294	android/support/v7/widget/c$d:<init>	(Ljava/lang/String;JF)V
    //   270: invokeinterface 156 2 0
    //   275: pop
    //   276: goto -152 -> 124
    //   279: astore_3
    //   280: aload_2
    //   281: ifnull +7 -> 288
    //   284: aload_2
    //   285: invokevirtual 265	java/io/FileInputStream:close	()V
    //   288: aload_3
    //   289: athrow
    //   290: astore_2
    //   291: return
    //   292: astore_2
    //   293: goto -5 -> 288
    //   296: astore_2
    //   297: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	298	0	this	c
    //   26	129	1	i1	int
    //   11	130	2	localFileInputStream	java.io.FileInputStream
    //   145	74	2	localIOException1	IOException
    //   223	62	2	localIOException2	IOException
    //   290	1	2	localIOException3	IOException
    //   292	1	2	localIOException4	IOException
    //   296	1	2	localFileNotFoundException	FileNotFoundException
    //   15	35	3	localXmlPullParser	org.xmlpull.v1.XmlPullParser
    //   71	90	3	localXmlPullParserException	org.xmlpull.v1.XmlPullParserException
    //   183	72	3	localIOException5	IOException
    //   279	10	3	localObject	Object
    //   115	111	4	localList	List
    // Exception table:
    //   from	to	target	type
    //   12	25	71	org/xmlpull/v1/XmlPullParserException
    //   37	44	71	org/xmlpull/v1/XmlPullParserException
    //   47	71	71	org/xmlpull/v1/XmlPullParserException
    //   111	124	71	org/xmlpull/v1/XmlPullParserException
    //   124	131	71	org/xmlpull/v1/XmlPullParserException
    //   157	183	71	org/xmlpull/v1/XmlPullParserException
    //   225	276	71	org/xmlpull/v1/XmlPullParserException
    //   140	144	145	java/io/IOException
    //   12	25	183	java/io/IOException
    //   37	44	183	java/io/IOException
    //   47	71	183	java/io/IOException
    //   111	124	183	java/io/IOException
    //   124	131	183	java/io/IOException
    //   157	183	183	java/io/IOException
    //   225	276	183	java/io/IOException
    //   218	222	223	java/io/IOException
    //   12	25	279	finally
    //   37	44	279	finally
    //   47	71	279	finally
    //   72	102	279	finally
    //   111	124	279	finally
    //   124	131	279	finally
    //   157	183	279	finally
    //   184	214	279	finally
    //   225	276	279	finally
    //   106	110	290	java/io/IOException
    //   284	288	292	java/io/IOException
    //   0	12	296	java/io/FileNotFoundException
  }
  
  public static c get(Context paramContext, String paramString)
  {
    synchronized (e)
    {
      c localc2 = (c)f.get(paramString);
      c localc1 = localc2;
      if (localc2 == null)
      {
        localc1 = new c(paramContext, paramString);
        f.put(paramString, localc1);
      }
      return localc1;
    }
  }
  
  public Intent chooseActivity(int paramInt)
  {
    synchronized (this.g)
    {
      if (this.j == null) {
        return null;
      }
      b();
      Object localObject2 = (a)this.h.get(paramInt);
      localObject2 = new ComponentName(((a)localObject2).a.activityInfo.packageName, ((a)localObject2).a.activityInfo.name);
      Intent localIntent1 = new Intent(this.j);
      localIntent1.setComponent((ComponentName)localObject2);
      if (this.p != null)
      {
        Intent localIntent2 = new Intent(localIntent1);
        if (this.p.onChooseActivity(this, localIntent2)) {
          return null;
        }
      }
      a(new d((ComponentName)localObject2, System.currentTimeMillis(), 1.0F));
      return localIntent1;
    }
  }
  
  public ResolveInfo getActivity(int paramInt)
  {
    synchronized (this.g)
    {
      b();
      ResolveInfo localResolveInfo = ((a)this.h.get(paramInt)).a;
      return localResolveInfo;
    }
  }
  
  public int getActivityCount()
  {
    synchronized (this.g)
    {
      b();
      int i1 = this.h.size();
      return i1;
    }
  }
  
  public int getActivityIndex(ResolveInfo paramResolveInfo)
  {
    for (;;)
    {
      int i1;
      synchronized (this.g)
      {
        b();
        List localList = this.h;
        int i2 = localList.size();
        i1 = 0;
        if (i1 < i2)
        {
          if (((a)localList.get(i1)).a == paramResolveInfo) {
            return i1;
          }
        }
        else {
          return -1;
        }
      }
      i1 += 1;
    }
  }
  
  public ResolveInfo getDefaultActivity()
  {
    synchronized (this.g)
    {
      b();
      if (!this.h.isEmpty())
      {
        ResolveInfo localResolveInfo = ((a)this.h.get(0)).a;
        return localResolveInfo;
      }
      return null;
    }
  }
  
  public int getHistoryMaxSize()
  {
    synchronized (this.g)
    {
      int i1 = this.l;
      return i1;
    }
  }
  
  public int getHistorySize()
  {
    synchronized (this.g)
    {
      b();
      int i1 = this.i.size();
      return i1;
    }
  }
  
  public Intent getIntent()
  {
    synchronized (this.g)
    {
      Intent localIntent = this.j;
      return localIntent;
    }
  }
  
  public void setActivitySorter(b paramb)
  {
    synchronized (this.g)
    {
      if (this.k == paramb) {
        return;
      }
      this.k = paramb;
      if (c()) {
        notifyChanged();
      }
      return;
    }
  }
  
  public void setDefaultActivity(int paramInt)
  {
    for (;;)
    {
      synchronized (this.g)
      {
        b();
        a locala1 = (a)this.h.get(paramInt);
        a locala2 = (a)this.h.get(0);
        if (locala2 != null)
        {
          f1 = locala2.b - locala1.b + 5.0F;
          a(new d(new ComponentName(locala1.a.activityInfo.packageName, locala1.a.activityInfo.name), System.currentTimeMillis(), f1));
          return;
        }
      }
      float f1 = 1.0F;
    }
  }
  
  public void setHistoryMaxSize(int paramInt)
  {
    synchronized (this.g)
    {
      if (this.l == paramInt) {
        return;
      }
      this.l = paramInt;
      f();
      if (c()) {
        notifyChanged();
      }
      return;
    }
  }
  
  public void setIntent(Intent paramIntent)
  {
    synchronized (this.g)
    {
      if (this.j == paramIntent) {
        return;
      }
      this.j = paramIntent;
      this.o = true;
      b();
      return;
    }
  }
  
  public void setOnChooseActivityListener(e parame)
  {
    synchronized (this.g)
    {
      this.p = parame;
      return;
    }
  }
  
  public static final class a
    implements Comparable<a>
  {
    public final ResolveInfo a;
    public float b;
    
    public a(ResolveInfo paramResolveInfo)
    {
      this.a = paramResolveInfo;
    }
    
    public int compareTo(a parama)
    {
      return Float.floatToIntBits(parama.b) - Float.floatToIntBits(this.b);
    }
    
    public boolean equals(Object paramObject)
    {
      if (this == paramObject) {}
      do
      {
        return true;
        if (paramObject == null) {
          return false;
        }
        if (getClass() != paramObject.getClass()) {
          return false;
        }
        paramObject = (a)paramObject;
      } while (Float.floatToIntBits(this.b) == Float.floatToIntBits(((a)paramObject).b));
      return false;
    }
    
    public int hashCode()
    {
      return Float.floatToIntBits(this.b) + 31;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[");
      localStringBuilder.append("resolveInfo:").append(this.a.toString());
      localStringBuilder.append("; weight:").append(new BigDecimal(this.b));
      localStringBuilder.append("]");
      return localStringBuilder.toString();
    }
  }
  
  public static abstract interface b
  {
    public abstract void sort(Intent paramIntent, List<c.a> paramList, List<c.d> paramList1);
  }
  
  private static final class c
    implements c.b
  {
    private final Map<ComponentName, c.a> a = new HashMap();
    
    public void sort(Intent paramIntent, List<c.a> paramList, List<c.d> paramList1)
    {
      paramIntent = this.a;
      paramIntent.clear();
      int j = paramList.size();
      int i = 0;
      Object localObject;
      while (i < j)
      {
        localObject = (c.a)paramList.get(i);
        ((c.a)localObject).b = 0.0F;
        paramIntent.put(new ComponentName(((c.a)localObject).a.activityInfo.packageName, ((c.a)localObject).a.activityInfo.name), localObject);
        i += 1;
      }
      i = paramList1.size();
      float f1 = 1.0F;
      i -= 1;
      if (i >= 0)
      {
        localObject = (c.d)paramList1.get(i);
        c.a locala = (c.a)paramIntent.get(((c.d)localObject).a);
        if (locala == null) {
          break label195;
        }
        float f2 = locala.b;
        locala.b = (((c.d)localObject).c * f1 + f2);
        f1 = 0.95F * f1;
      }
      label195:
      for (;;)
      {
        i -= 1;
        break;
        Collections.sort(paramList);
        return;
      }
    }
  }
  
  public static final class d
  {
    public final ComponentName a;
    public final long b;
    public final float c;
    
    public d(ComponentName paramComponentName, long paramLong, float paramFloat)
    {
      this.a = paramComponentName;
      this.b = paramLong;
      this.c = paramFloat;
    }
    
    public d(String paramString, long paramLong, float paramFloat)
    {
      this(ComponentName.unflattenFromString(paramString), paramLong, paramFloat);
    }
    
    public boolean equals(Object paramObject)
    {
      if (this == paramObject) {}
      do
      {
        return true;
        if (paramObject == null) {
          return false;
        }
        if (getClass() != paramObject.getClass()) {
          return false;
        }
        paramObject = (d)paramObject;
        if (this.a == null)
        {
          if (((d)paramObject).a != null) {
            return false;
          }
        }
        else if (!this.a.equals(((d)paramObject).a)) {
          return false;
        }
        if (this.b != ((d)paramObject).b) {
          return false;
        }
      } while (Float.floatToIntBits(this.c) == Float.floatToIntBits(((d)paramObject).c));
      return false;
    }
    
    public int hashCode()
    {
      if (this.a == null) {}
      for (int i = 0;; i = this.a.hashCode()) {
        return ((i + 31) * 31 + (int)(this.b ^ this.b >>> 32)) * 31 + Float.floatToIntBits(this.c);
      }
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[");
      localStringBuilder.append("; activity:").append(this.a);
      localStringBuilder.append("; time:").append(this.b);
      localStringBuilder.append("; weight:").append(new BigDecimal(this.c));
      localStringBuilder.append("]");
      return localStringBuilder.toString();
    }
  }
  
  public static abstract interface e
  {
    public abstract boolean onChooseActivity(c paramc, Intent paramIntent);
  }
  
  private final class f
    extends AsyncTask<Object, Void, Void>
  {
    f() {}
    
    public Void doInBackground(Object... paramVarArgs)
    {
      int i = 0;
      List localList = (List)paramVarArgs[0];
      Object localObject2 = (String)paramVarArgs[1];
      for (;;)
      {
        try
        {
          paramVarArgs = c.this.b.openFileOutput((String)localObject2, 0);
          localObject2 = Xml.newSerializer();
          int j;
          c.d locald;
          ((XmlSerializer)localObject2).endTag(null, "historical-records");
        }
        catch (FileNotFoundException paramVarArgs)
        {
          try
          {
            ((XmlSerializer)localObject2).setOutput(paramVarArgs, null);
            ((XmlSerializer)localObject2).startDocument("UTF-8", Boolean.valueOf(true));
            ((XmlSerializer)localObject2).startTag(null, "historical-records");
            j = localList.size();
            if (i >= j) {
              break label213;
            }
            locald = (c.d)localList.remove(0);
            ((XmlSerializer)localObject2).startTag(null, "historical-record");
            ((XmlSerializer)localObject2).attribute(null, "activity", locald.a.flattenToString());
            ((XmlSerializer)localObject2).attribute(null, "time", String.valueOf(locald.b));
            ((XmlSerializer)localObject2).attribute(null, "weight", String.valueOf(locald.c));
            ((XmlSerializer)localObject2).endTag(null, "historical-record");
            i += 1;
            continue;
            paramVarArgs = paramVarArgs;
            Log.e(c.a, "Error writing historical record file: " + (String)localObject2, paramVarArgs);
          }
          catch (IllegalArgumentException localIllegalArgumentException)
          {
            Log.e(c.a, "Error writing historical record file: " + c.this.c, localIllegalArgumentException);
            c.this.d = true;
            if (paramVarArgs == null) {
              continue;
            }
            try
            {
              paramVarArgs.close();
              return null;
            }
            catch (IOException paramVarArgs)
            {
              return null;
            }
          }
          catch (IllegalStateException localIllegalStateException)
          {
            Log.e(c.a, "Error writing historical record file: " + c.this.c, localIllegalStateException);
            c.this.d = true;
            if (paramVarArgs == null) {
              continue;
            }
            try
            {
              paramVarArgs.close();
              return null;
            }
            catch (IOException paramVarArgs)
            {
              return null;
            }
          }
          catch (IOException localIOException)
          {
            Log.e(c.a, "Error writing historical record file: " + c.this.c, localIOException);
            c.this.d = true;
            if (paramVarArgs == null) {
              continue;
            }
            try
            {
              paramVarArgs.close();
              return null;
            }
            catch (IOException paramVarArgs)
            {
              return null;
            }
          }
          finally
          {
            c.this.d = true;
            if (paramVarArgs == null) {
              break label441;
            }
          }
          return null;
        }
        label213:
        ((XmlSerializer)localObject2).endDocument();
        c.this.d = true;
        if (paramVarArgs != null) {
          try
          {
            paramVarArgs.close();
            return null;
          }
          catch (IOException paramVarArgs)
          {
            return null;
          }
        }
      }
      try
      {
        paramVarArgs.close();
        label441:
        throw ((Throwable)localObject1);
      }
      catch (IOException paramVarArgs)
      {
        for (;;) {}
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/android/support/v7/widget/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */