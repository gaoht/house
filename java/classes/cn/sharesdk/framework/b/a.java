package cn.sharesdk.framework.b;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.text.TextUtils;
import android.util.Base64;
import cn.sharesdk.framework.b.b.f;
import cn.sharesdk.framework.b.b.f.a;
import com.mob.MobSDK;
import com.mob.tools.log.NLog;
import com.mob.tools.utils.BitmapHelper;
import com.mob.tools.utils.Data;
import com.mob.tools.utils.DeviceHelper;
import com.mob.tools.utils.ResHelper;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.GZIPOutputStream;

public class a
{
  private static a a;
  private c b = new c();
  private DeviceHelper c = DeviceHelper.getInstance(MobSDK.getContext());
  private cn.sharesdk.framework.b.a.e d = cn.sharesdk.framework.b.a.e.a();
  private boolean e = true;
  
  public static a a()
  {
    if (a == null) {
      a = new a();
    }
    return a;
  }
  
  private String a(Bitmap paramBitmap, b paramb)
    throws Throwable
  {
    File localFile = File.createTempFile("bm_tmp", ".png");
    FileOutputStream localFileOutputStream = new FileOutputStream(localFile);
    paramBitmap.compress(Bitmap.CompressFormat.PNG, 100, localFileOutputStream);
    localFileOutputStream.flush();
    localFileOutputStream.close();
    return a(localFile.getAbsolutePath(), paramb);
  }
  
  private String a(String paramString, b paramb)
    throws Throwable
  {
    if ((TextUtils.isEmpty(paramString)) || (!new File(paramString).exists())) {}
    do
    {
      return null;
      localObject = this.c.getNetworkType();
    } while (("none".equals(localObject)) || (TextUtils.isEmpty((CharSequence)localObject)));
    Object localObject = BitmapHelper.getBmpFormat(paramString);
    float f = 200.0F;
    if (paramb == b.b) {
      f = 600.0F;
    }
    paramb = new BitmapFactory.Options();
    paramb.inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramString, paramb);
    paramb.inJustDecodeBounds = false;
    int i = paramb.outWidth;
    int j = paramb.outHeight;
    if ((i >= j) && (j > f)) {}
    for (i = (int)Math.ceil(paramb.outHeight / f);; i = (int)Math.ceil(paramb.outWidth / f))
    {
      j = i;
      if (i <= 0) {
        j = 1;
      }
      paramb = new BitmapFactory.Options();
      paramb.inSampleSize = j;
      paramb.inPurgeable = true;
      paramb.inInputShareable = true;
      paramString = BitmapFactory.decodeFile(paramString, paramb);
      paramString.getHeight();
      paramString.getWidth();
      paramb = File.createTempFile("bm_tmp2", "." + ((Bitmap.CompressFormat)localObject).name().toLowerCase());
      FileOutputStream localFileOutputStream = new FileOutputStream(paramb);
      paramString.compress((Bitmap.CompressFormat)localObject, 80, localFileOutputStream);
      localFileOutputStream.flush();
      localFileOutputStream.close();
      return d(paramb.getAbsolutePath());
      if ((i >= j) || (i <= f)) {
        break;
      }
    }
    return d(paramString);
  }
  
  private String a(String paramString1, String paramString2, int paramInt, String paramString3)
    throws Throwable
  {
    if (TextUtils.isEmpty(paramString1)) {}
    Object localObject2;
    String str;
    do
    {
      do
      {
        return paramString1;
        localObject1 = new ArrayList();
        paramString2 = Pattern.compile(paramString2);
        localObject2 = paramString2.matcher(paramString1);
        while (((Matcher)localObject2).find())
        {
          str = ((Matcher)localObject2).group();
          if ((str != null) && (str.length() > 0)) {
            ((ArrayList)localObject1).add(str);
          }
        }
      } while (((ArrayList)localObject1).size() == 0);
      paramString3 = this.b.a(paramString1, (ArrayList)localObject1, paramInt, paramString3);
    } while ((paramString3 == null) || (paramString3.size() <= 0) || (!paramString3.containsKey("data")));
    Object localObject1 = (ArrayList)paramString3.get("data");
    paramString3 = new HashMap();
    localObject1 = ((ArrayList)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (HashMap)((Iterator)localObject1).next();
      str = String.valueOf(((HashMap)localObject2).get("surl"));
      paramString3.put(String.valueOf(((HashMap)localObject2).get("source")), str);
    }
    paramString2 = paramString2.matcher(paramString1);
    localObject1 = new StringBuilder();
    for (paramInt = 0; paramString2.find(); paramInt = paramString2.end())
    {
      ((StringBuilder)localObject1).append(paramString1.substring(paramInt, paramString2.start()));
      ((StringBuilder)localObject1).append((String)paramString3.get(paramString2.group()));
    }
    ((StringBuilder)localObject1).append(paramString1.substring(paramInt, paramString1.length()));
    paramString1 = ((StringBuilder)localObject1).toString();
    cn.sharesdk.framework.utils.e.b().i("> SERVER_SHORT_LINK_URL content after replace link ===  %s", new Object[] { paramString1 });
    return paramString1;
  }
  
  private void a(cn.sharesdk.framework.b.b.b paramb)
    throws Throwable
  {
    boolean bool = this.d.d();
    String str = paramb.c;
    if ((bool) && (!TextUtils.isEmpty(str)))
    {
      paramb.c = Data.Base64AES(str, paramb.f.substring(0, 16));
      return;
    }
    paramb.d = null;
    paramb.c = null;
  }
  
  private void a(f paramf)
    throws Throwable
  {
    int k = 0;
    int i = this.d.f();
    boolean bool = this.d.d();
    f.a locala = paramf.d;
    int j;
    String str;
    if ((i == 1) || ((i == 0) && (this.e)))
    {
      if ((locala == null) || (locala.e == null)) {}
      for (i = 0;; i = locala.e.size())
      {
        j = 0;
        while (j < i)
        {
          str = a((String)locala.e.get(j), b.a);
          if (!TextUtils.isEmpty(str)) {
            locala.d.add(str);
          }
          j += 1;
        }
      }
      if ((locala == null) || (locala.f == null))
      {
        i = 0;
        j = k;
      }
    }
    while (j < i)
    {
      str = a((Bitmap)locala.f.get(j), b.a);
      if (!TextUtils.isEmpty(str)) {
        locala.d.add(str);
      }
      j += 1;
      continue;
      i = locala.f.size();
      j = k;
      continue;
      paramf.d = null;
    }
    if (!bool) {
      paramf.m = null;
    }
  }
  
  private boolean a(String paramString, boolean paramBoolean)
    throws Throwable
  {
    return this.b.a(paramString, paramBoolean);
  }
  
  private String d(String paramString)
    throws Throwable
  {
    paramString = this.b.c(paramString);
    if ((paramString == null) || (paramString.size() <= 0)) {}
    while ((!paramString.containsKey("status")) || (ResHelper.parseInt(String.valueOf(paramString.get("status"))) != 200) || (!paramString.containsKey("url"))) {
      return null;
    }
    return (String)paramString.get("url");
  }
  
  private String e(String paramString)
    throws Throwable
  {
    paramString = new ByteArrayInputStream(paramString.getBytes());
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    Object localObject = new GZIPOutputStream(localByteArrayOutputStream);
    byte[] arrayOfByte = new byte['Ѐ'];
    for (;;)
    {
      int i = paramString.read(arrayOfByte, 0, 1024);
      if (i == -1) {
        break;
      }
      ((GZIPOutputStream)localObject).write(arrayOfByte, 0, i);
    }
    ((GZIPOutputStream)localObject).flush();
    ((GZIPOutputStream)localObject).close();
    localObject = localByteArrayOutputStream.toByteArray();
    localByteArrayOutputStream.flush();
    localByteArrayOutputStream.close();
    paramString.close();
    return Base64.encodeToString((byte[])localObject, 2);
  }
  
  public String a(Bitmap paramBitmap)
  {
    if (!this.d.i()) {
      return null;
    }
    try
    {
      paramBitmap = a(paramBitmap, b.b);
      return paramBitmap;
    }
    catch (Throwable paramBitmap)
    {
      cn.sharesdk.framework.utils.e.b().d(paramBitmap);
    }
    return null;
  }
  
  public String a(String paramString1, int paramInt, boolean paramBoolean, String paramString2)
  {
    try
    {
      if (this.d.i())
      {
        if (!this.d.e()) {
          return paramString1;
        }
        String str = this.c.getNetworkType();
        if ((!"none".equals(str)) && (!TextUtils.isEmpty(str)))
        {
          if (paramBoolean)
          {
            str = a(paramString1, "<a[^>]*?href[\\s]*=[\\s]*[\"']?([^'\">]+?)['\"]?>", paramInt, paramString2);
            if ((str != null) && (!str.equals(paramString1))) {
              return str;
            }
          }
          paramString2 = a(paramString1, "(http://|https://){1}[\\w\\.\\-/:\\?&%=,;\\[\\]\\{\\}`~!@#\\$\\^\\*\\(\\)_\\+\\\\\\|]+", paramInt, paramString2);
          if (paramString2 != null)
          {
            paramBoolean = paramString2.equals(paramString1);
            if (!paramBoolean) {
              return paramString2;
            }
          }
        }
      }
    }
    catch (Throwable paramString2)
    {
      cn.sharesdk.framework.utils.e.b().d(paramString2);
    }
    return paramString1;
  }
  
  public void a(cn.sharesdk.framework.b.b.c paramc)
  {
    for (;;)
    {
      try
      {
        if (!this.d.i()) {
          return;
        }
        if ((paramc instanceof cn.sharesdk.framework.b.b.b))
        {
          a((cn.sharesdk.framework.b.b.b)paramc);
          if (!this.d.c()) {
            paramc.l = null;
          }
          long l2 = this.d.b();
          long l1 = l2;
          if (l2 == 0L) {
            l1 = this.b.b();
          }
          paramc.e = (System.currentTimeMillis() - l1);
          this.b.a(paramc);
          return;
        }
      }
      catch (Throwable paramc)
      {
        cn.sharesdk.framework.utils.e.b().d(paramc);
        return;
      }
      if ((paramc instanceof f)) {
        a((f)paramc);
      }
    }
  }
  
  public void a(String paramString)
  {
    if ((this.b != null) && (!TextUtils.isEmpty(paramString))) {
      this.b.a(paramString);
    }
  }
  
  public void a(HashMap<String, Object> paramHashMap)
  {
    try
    {
      this.b.b(paramHashMap);
      return;
    }
    catch (Throwable paramHashMap)
    {
      cn.sharesdk.framework.utils.e.b().d(paramHashMap);
    }
  }
  
  public String b(String paramString)
  {
    if (!this.d.i()) {
      return null;
    }
    try
    {
      paramString = a(paramString, b.b);
      return paramString;
    }
    catch (Throwable paramString)
    {
      cn.sharesdk.framework.utils.e.b().d(paramString);
    }
    return null;
  }
  
  public void b()
  {
    for (;;)
    {
      try
      {
        Object localObject = this.c.getNetworkType();
        if ("none".equals(localObject)) {
          break;
        }
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          return;
        }
        long l1 = this.d.j().longValue();
        long l2 = System.currentTimeMillis();
        localObject = Calendar.getInstance();
        ((Calendar)localObject).setTimeInMillis(l1);
        int i = ((Calendar)localObject).get(5);
        ((Calendar)localObject).setTimeInMillis(l2);
        int j = ((Calendar)localObject).get(5);
        if ((l2 - l1 < 86400000L) && (i == j)) {
          break;
        }
        localObject = this.b.a();
        if (((HashMap)localObject).containsKey("res"))
        {
          bool = "true".equals(String.valueOf(((HashMap)localObject).get("res")));
          this.d.a(bool);
          if ((localObject == null) || (((HashMap)localObject).size() <= 0)) {
            break;
          }
          this.d.b(System.currentTimeMillis());
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        cn.sharesdk.framework.utils.e.b().d(localThrowable);
        return;
      }
      boolean bool = true;
    }
  }
  
  public HashMap<String, Object> c(String paramString)
  {
    try
    {
      paramString = this.b.d(paramString);
      return paramString;
    }
    catch (Throwable paramString)
    {
      cn.sharesdk.framework.utils.e.b().d(paramString);
    }
    return null;
  }
  
  public void c()
  {
    try
    {
      Object localObject1 = this.c.getNetworkType();
      if ("none".equals(localObject1)) {
        return;
      }
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        return;
      }
      if (!this.d.i()) {
        return;
      }
      this.d.a(System.currentTimeMillis());
      localObject1 = this.b.c();
      if ((((HashMap)localObject1).containsKey("status")) && (ResHelper.parseInt(String.valueOf(((HashMap)localObject1).get("status"))) == 65336))
      {
        cn.sharesdk.framework.utils.e.b().d((String)((HashMap)localObject1).get("error"), new Object[0]);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      cn.sharesdk.framework.utils.e.b().d(localThrowable);
      return;
    }
    if (localThrowable.containsKey("timestamp"))
    {
      long l1 = ResHelper.parseLong(String.valueOf(localThrowable.get("timestamp")));
      long l2 = System.currentTimeMillis();
      this.d.a("service_time", Long.valueOf(l2 - l1));
    }
    Object localObject5;
    Object localObject3;
    Object localObject4;
    String str;
    if (localThrowable.containsKey("switchs"))
    {
      localObject5 = (HashMap)localThrowable.get("switchs");
      if (localObject5 != null)
      {
        localObject3 = String.valueOf(((HashMap)localObject5).get("device"));
        localObject4 = String.valueOf(((HashMap)localObject5).get("share"));
        str = String.valueOf(((HashMap)localObject5).get("auth"));
        localObject5 = String.valueOf(((HashMap)localObject5).get("backflow"));
        this.d.b((String)localObject3);
        this.d.d((String)localObject4);
        this.d.c(str);
        this.d.a((String)localObject5);
      }
    }
    if (localThrowable.containsKey("serpaths"))
    {
      localObject3 = (HashMap)localThrowable.get("serpaths");
      if (localObject3 != null)
      {
        Object localObject2 = String.valueOf(((HashMap)localObject3).get("defhost"));
        localObject4 = String.valueOf(((HashMap)localObject3).get("defport"));
        if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (!TextUtils.isEmpty((CharSequence)localObject4))) {
          this.b.b("http://" + (String)localObject2 + ":" + (String)localObject4);
        }
        localObject2 = new HashMap();
        if (((HashMap)localObject3).containsKey("assigns"))
        {
          localObject3 = (HashMap)((HashMap)localObject3).get("assigns");
          if ((localObject3 == null) || (((HashMap)localObject3).size() == 0))
          {
            this.b.a(null);
            return;
          }
          localObject4 = ((HashMap)localObject3).keySet().iterator();
          while (((Iterator)localObject4).hasNext())
          {
            str = (String)((Iterator)localObject4).next();
            Object localObject6 = (HashMap)((HashMap)localObject3).get(str);
            localObject5 = String.valueOf(((HashMap)localObject6).get("host"));
            localObject6 = String.valueOf(((HashMap)localObject6).get("port"));
            if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty((CharSequence)localObject5)) && (!TextUtils.isEmpty((CharSequence)localObject6))) {
              ((HashMap)localObject2).put(str, "http://" + (String)localObject5 + ":" + (String)localObject6);
            }
          }
          this.b.a((HashMap)localObject2);
        }
      }
    }
  }
  
  public void d()
  {
    for (;;)
    {
      int i;
      try
      {
        Object localObject = this.c.getNetworkType();
        if (!"none".equals(localObject))
        {
          if (TextUtils.isEmpty((CharSequence)localObject)) {
            return;
          }
          if (this.d.i())
          {
            localObject = this.b.e();
            i = 0;
            if (i < ((ArrayList)localObject).size())
            {
              cn.sharesdk.framework.b.a.c localc = (cn.sharesdk.framework.b.a.c)((ArrayList)localObject).get(i);
              if (localc.b.size() == 1)
              {
                bool = a(localc.a, false);
                if (!bool) {
                  break label133;
                }
                this.b.a(localc.b);
                break label133;
              }
              boolean bool = a(e(localc.a), true);
              continue;
            }
          }
        }
        return;
      }
      catch (Throwable localThrowable)
      {
        cn.sharesdk.framework.utils.e.b().d(localThrowable);
      }
      label133:
      i += 1;
    }
  }
  
  public HashMap<String, Object> e()
  {
    try
    {
      HashMap localHashMap = this.b.f();
      return localHashMap;
    }
    catch (Throwable localThrowable)
    {
      cn.sharesdk.framework.utils.e.b().d(localThrowable);
    }
    return new HashMap();
  }
  
  public HashMap<String, Object> f()
  {
    if ((!this.d.i()) && (this.d.k())) {
      return new HashMap();
    }
    try
    {
      HashMap localHashMap = this.b.d();
      this.d.b(true);
      return localHashMap;
    }
    catch (Throwable localThrowable)
    {
      this.d.b(false);
      cn.sharesdk.framework.utils.e.b().d(localThrowable);
    }
    return new HashMap();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/sharesdk/framework/b/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */