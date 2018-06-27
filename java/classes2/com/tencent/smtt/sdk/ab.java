package com.tencent.smtt.sdk;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import com.maa.android.agent.instrumentation.Instrumented;
import com.mato.sdk.instrumentation.HttpInstrumentation;
import com.tencent.smtt.utils.Apn;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.a;
import com.tencent.smtt.utils.b;
import com.tencent.smtt.utils.j;
import com.tencent.smtt.utils.z;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.URL;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Instrumented
class ab
{
  private static int d = 5;
  private static int e = 1;
  private static final String[] f = { "tbs_downloading_com.tencent.mtt", "tbs_downloading_com.tencent.mm", "tbs_downloading_com.tencent.mobileqq", "tbs_downloading_com.tencent.x5sdk.demo", "tbs_downloading_com.qzone" };
  private Set<String> A;
  private int B = d;
  private boolean C;
  String a;
  String[] b = null;
  int c = 0;
  private Context g;
  private String h;
  private String i;
  private String j;
  private File k;
  private long l;
  private int m = 30000;
  private int n = 20000;
  private boolean o;
  private int p;
  private int q;
  private boolean r;
  private boolean s;
  private HttpURLConnection t;
  private String u;
  private TbsLogReport v;
  private String w;
  private int x;
  private boolean y;
  private Handler z;
  
  public ab(Context paramContext)
  {
    this.g = paramContext.getApplicationContext();
    this.v = TbsLogReport.a(this.g);
    this.A = new HashSet();
    this.u = ("tbs_downloading_" + this.g.getPackageName());
    ai.a();
    this.k = ai.i(this.g);
    if (this.k == null) {
      throw new NullPointerException("TbsCorePrivateDir is null!");
    }
    e();
    this.w = null;
    this.x = -1;
  }
  
  private long a(long paramLong1, long paramLong2)
  {
    long l1 = System.currentTimeMillis();
    this.v.c(l1 - paramLong1);
    this.v.d(paramLong2);
    return l1;
  }
  
  @TargetApi(8)
  static File a(Context paramContext)
  {
    for (;;)
    {
      try
      {
        if (Build.VERSION.SDK_INT >= 8)
        {
          paramContext = new File(j.a(paramContext, 4));
          if ((paramContext != null) && (!paramContext.exists()) && (!paramContext.isDirectory())) {
            paramContext.mkdirs();
          }
          return paramContext;
        }
      }
      catch (Exception paramContext)
      {
        paramContext.printStackTrace();
        TbsLog.e("TbsDownload", "[TbsApkDownloader.backupApkPath] Exception is " + paramContext.getMessage());
        return null;
      }
      paramContext = null;
    }
  }
  
  private static File a(Context paramContext, int paramInt)
  {
    File localFile = new File(j.a(paramContext, paramInt));
    if ((localFile == null) || (!localFile.exists()) || (!localFile.isDirectory())) {
      return null;
    }
    if (TbsDownloader.getOverSea(paramContext)) {}
    for (paramContext = "x5.oversea.tbs.org";; paramContext = "x5.tbs.org")
    {
      paramContext = new File(localFile, paramContext);
      if ((paramContext == null) || (!paramContext.exists())) {
        break;
      }
      return localFile;
    }
    return null;
  }
  
  private String a(Throwable paramThrowable)
  {
    String str = Log.getStackTraceString(paramThrowable);
    paramThrowable = str;
    if (str.length() > 1024) {
      paramThrowable = str.substring(0, 1024);
    }
    return paramThrowable;
  }
  
  private String a(URL paramURL)
  {
    try
    {
      paramURL = InetAddress.getByName(paramURL.getHost()).getHostAddress();
      return paramURL;
    }
    catch (Exception paramURL)
    {
      paramURL.printStackTrace();
      return "";
    }
    catch (Error paramURL)
    {
      paramURL.printStackTrace();
    }
    return "";
  }
  
  private void a(int paramInt, String paramString, boolean paramBoolean)
  {
    if ((paramBoolean) || (this.p > this.B))
    {
      this.v.h(paramInt);
      this.v.e(paramString);
    }
  }
  
  private void a(long paramLong)
  {
    this.p += 1;
    long l1 = paramLong;
    if (paramLong <= 0L) {}
    try
    {
      l1 = m();
      Thread.sleep(l1);
      return;
    }
    catch (Exception localException) {}
  }
  
  private void a(Closeable paramCloseable)
  {
    if (paramCloseable != null) {}
    try
    {
      paramCloseable.close();
      return;
    }
    catch (IOException paramCloseable) {}
  }
  
  public static void a(File paramFile, Context paramContext)
  {
    if ((paramFile == null) || (!paramFile.exists())) {}
    for (;;)
    {
      return;
      try
      {
        File localFile = a(paramContext);
        if (localFile == null) {
          continue;
        }
        if (TbsDownloader.getOverSea(paramContext)) {}
        for (paramContext = "x5.oversea.tbs.org";; paramContext = "x5.tbs.org")
        {
          paramContext = new File(localFile, paramContext);
          paramContext.delete();
          j.b(paramFile, paramContext);
          return;
        }
        return;
      }
      catch (Exception paramFile) {}
    }
  }
  
  private void a(String paramString)
  {
    paramString = new URL(paramString);
    if (this.t != null) {}
    try
    {
      this.t.disconnect();
      if (!(paramString instanceof URL))
      {
        paramString = paramString.openConnection();
        this.t = ((HttpURLConnection)paramString);
        this.t.setRequestProperty("User-Agent", TbsDownloader.a(this.g));
        this.t.setRequestProperty("Accept-Encoding", "identity");
        this.t.setRequestMethod("GET");
        this.t.setInstanceFollowRedirects(false);
        this.t.setConnectTimeout(this.n);
        this.t.setReadTimeout(this.m);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        TbsLog.e("TbsDownload", "[initHttpRequest] mHttpRequest.disconnect() Throwable:" + localThrowable.toString());
        continue;
        paramString = HttpInstrumentation.openConnection((URL)paramString);
      }
    }
  }
  
  @TargetApi(8)
  static File b(Context paramContext)
  {
    try
    {
      if (Build.VERSION.SDK_INT >= 8)
      {
        Object localObject2 = a(paramContext, 4);
        Object localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = a(paramContext, 3);
        }
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = a(paramContext, 2);
        }
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = a(paramContext, 1);
        }
        return (File)localObject1;
      }
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
      TbsLog.e("TbsDownload", "[TbsApkDownloader.backupApkPath] Exception is " + paramContext.getMessage());
      return null;
    }
    return null;
  }
  
  private boolean b(boolean paramBoolean1, boolean paramBoolean2)
  {
    long l2 = 0L;
    TbsLog.i("TbsDownload", "[TbsApkDownloader.verifyTbsApk] isTempFile=" + paramBoolean1);
    Object localObject2 = this.k;
    Object localObject1;
    if (!paramBoolean1)
    {
      localObject1 = "x5.tbs";
      localObject1 = new File((File)localObject2, (String)localObject1);
      if (((File)localObject1).exists()) {
        break label74;
      }
    }
    label74:
    Object localObject3;
    do
    {
      return false;
      localObject1 = "x5.tbs.temp";
      break;
      localObject2 = TbsDownloadConfig.getInstance(this.g).mPreferences.getString("tbs_apk_md5", null);
      localObject3 = a.a((File)localObject1);
      if ((localObject2 != null) && (((String)localObject2).equals(localObject3))) {
        break label164;
      }
      TbsLog.i("TbsDownload", "[TbsApkDownloader.verifyTbsApk] isTempFile=" + paramBoolean1 + " md5 failed");
    } while (!paramBoolean1);
    this.v.d("fileMd5 not match");
    return false;
    label164:
    TbsLog.i("TbsDownload", "[TbsApkDownloader.verifyTbsApk] md5(" + (String)localObject3 + ") successful!");
    long l1 = l2;
    long l3;
    if (paramBoolean1)
    {
      l3 = TbsDownloadConfig.getInstance(this.g).mPreferences.getLong("tbs_apkfilesize", 0L);
      if ((localObject1 == null) || (!((File)localObject1).exists())) {
        break label743;
      }
      l1 = l2;
      if (l3 > 0L)
      {
        l1 = ((File)localObject1).length();
        if (l3 == l1) {}
      }
    }
    for (;;)
    {
      TbsLog.i("TbsDownload", "[TbsApkDownloader.verifyTbsApk] isTempFile=" + paramBoolean1 + " filelength failed");
      this.v.d("fileLength:" + l1 + ",contentLength:" + l3);
      return false;
      TbsLog.i("TbsDownload", "[TbsApkDownloader.verifyTbsApk] length(" + l1 + ") successful!");
      int i1 = -1;
      if (paramBoolean2)
      {
        int i2 = a.a(this.g, (File)localObject1);
        int i3 = TbsDownloadConfig.getInstance(this.g).mPreferences.getInt("tbs_download_version", 0);
        i1 = i2;
        if (i3 != i2)
        {
          TbsLog.i("TbsDownload", "[TbsApkDownloader.verifyTbsApk] isTempFile=" + paramBoolean1 + " versionCode failed");
          if (!paramBoolean1) {
            break;
          }
          this.v.d("fileVersion:" + i2 + ",configVersion:" + i3);
          return false;
        }
      }
      TbsLog.i("TbsDownload", "[TbsApkDownloader.verifyTbsApk] tbsApkVersionCode(" + i1 + ") successful!");
      if (paramBoolean2)
      {
        String str = b.a(this.g, (File)localObject1);
        if (!"3082023f308201a8a00302010202044c46914a300d06092a864886f70d01010505003064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f301e170d3130303732313036313835305a170d3430303731333036313835305a3064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f30819f300d06092a864886f70d010101050003818d0030818902818100c209077044bd0d63ea00ede5b839914cabcc912a87f0f8b390877e0f7a2583f0d5933443c40431c35a4433bc4c965800141961adc44c9625b1d321385221fd097e5bdc2f44a1840d643ab59dc070cf6c4b4b4d98bed5cbb8046e0a7078ae134da107cdf2bfc9b440fe5cb2f7549b44b73202cc6f7c2c55b8cfb0d333a021f01f0203010001300d06092a864886f70d010105050003818100b007db9922774ef4ccfee81ba514a8d57c410257e7a2eba64bfa17c9e690da08106d32f637ac41fbc9f205176c71bde238c872c3ee2f8313502bee44c80288ea4ef377a6f2cdfe4d3653c145c4acfedbfbadea23b559d41980cc3cdd35d79a68240693739aabf5c5ed26148756cf88264226de394c8a24ac35b712b120d4d23a".equals(str))
        {
          TbsLog.i("TbsDownload", "[TbsApkDownloader.verifyTbsApk] isTempFile=" + paramBoolean1 + " signature failed");
          if (!paramBoolean1) {
            break;
          }
          localObject2 = this.v;
          localObject3 = new StringBuilder().append("signature:");
          if (str == null) {}
          for (localObject1 = "null";; localObject1 = Integer.valueOf(str.length()))
          {
            ((TbsLogReport)localObject2).d(localObject1);
            return false;
          }
        }
      }
      TbsLog.i("TbsDownload", "[TbsApkDownloader.verifyTbsApk] signature successful!");
      if (paramBoolean1)
      {
        try
        {
          paramBoolean1 = ((File)localObject1).renameTo(new File(this.k, "x5.tbs"));
          localObject1 = null;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            paramBoolean1 = false;
          }
        }
        paramBoolean2 = paramBoolean1;
        if (paramBoolean1) {
          break label710;
        }
        a(109, a((Throwable)localObject1), true);
        return false;
      }
      paramBoolean2 = false;
      label710:
      TbsLog.i("TbsDownload", "[TbsApkDownloader.verifyTbsApk] rename(" + paramBoolean2 + ") successful!");
      return true;
      label743:
      l1 = 0L;
    }
  }
  
  public static void c(Context paramContext)
  {
    try
    {
      ai.a();
      File localFile = ai.i(paramContext);
      new File(localFile, "x5.tbs").delete();
      new File(localFile, "x5.tbs.temp").delete();
      paramContext = a(paramContext);
      if (paramContext != null)
      {
        new File(paramContext, "x5.tbs.org").delete();
        new File(paramContext, "x5.oversea.tbs.org").delete();
      }
      return;
    }
    catch (Exception paramContext) {}
  }
  
  private void c(boolean paramBoolean)
  {
    z.a(this.g);
    Object localObject2 = TbsDownloadConfig.getInstance(this.g);
    ((TbsDownloadConfig)localObject2).a.put("request_full_package", Boolean.valueOf(false));
    ((TbsDownloadConfig)localObject2).a.put("tbs_needdownload", Boolean.valueOf(false));
    ((TbsDownloadConfig)localObject2).a.put("tbs_download_interrupt_code_reason", Integer.valueOf(-123));
    ((TbsDownloadConfig)localObject2).commit();
    Object localObject1 = QbSdk.j;
    File localFile;
    label152:
    int i2;
    if (paramBoolean)
    {
      i1 = 100;
      ((TbsListener)localObject1).onDownloadFinish(i1);
      i1 = ((TbsDownloadConfig)localObject2).mPreferences.getInt("tbs_responsecode", 0);
      if ((i1 != 3) && (i1 <= 10000)) {
        break label352;
      }
      localFile = a(this.g);
      if (localFile == null) {
        break label324;
      }
      if (!TbsDownloader.getOverSea(this.g)) {
        break label311;
      }
      localObject1 = "x5.oversea.tbs.org";
      localFile = new File(localFile, (String)localObject1);
      i2 = a.a(this.g, localFile);
      localObject1 = new File(this.k, "x5.tbs");
      if (!((File)localObject1).exists()) {
        break label318;
      }
    }
    label311:
    label318:
    for (localObject1 = ((File)localObject1).getAbsolutePath();; localObject1 = null)
    {
      int i3 = ((TbsDownloadConfig)localObject2).mPreferences.getInt("tbs_download_version", 0);
      localObject2 = new Bundle();
      ((Bundle)localObject2).putInt("operation", i1);
      ((Bundle)localObject2).putInt("old_core_ver", i2);
      ((Bundle)localObject2).putInt("new_core_ver", i3);
      ((Bundle)localObject2).putString("old_apk_location", localFile.getAbsolutePath());
      ((Bundle)localObject2).putString("new_apk_location", (String)localObject1);
      ((Bundle)localObject2).putString("diff_file_location", (String)localObject1);
      ai.a().b(this.g, (Bundle)localObject2);
      return;
      i1 = 120;
      break;
      localObject1 = "x5.tbs.org";
      break label152;
    }
    label324:
    c();
    ((TbsDownloadConfig)localObject2).a.put("tbs_needdownload", Boolean.valueOf(true));
    ((TbsDownloadConfig)localObject2).commit();
    return;
    label352:
    int i1 = ((TbsDownloadConfig)localObject2).mPreferences.getInt("tbs_download_version", 0);
    ai.a().a(this.g, new File(this.k, "x5.tbs").getAbsolutePath(), i1);
    a(new File(this.k, "x5.tbs"), this.g);
  }
  
  private boolean d(boolean paramBoolean)
  {
    TbsLog.i("TbsDownload", "[TbsApkDownloader.deleteFile] isApk=" + paramBoolean);
    if (paramBoolean) {}
    for (File localFile = new File(this.k, "x5.tbs");; localFile = new File(this.k, "x5.tbs.temp"))
    {
      boolean bool = true;
      paramBoolean = bool;
      if (localFile != null)
      {
        paramBoolean = bool;
        if (localFile.exists()) {
          paramBoolean = localFile.delete();
        }
      }
      return paramBoolean;
    }
  }
  
  private void e()
  {
    this.p = 0;
    this.q = 0;
    this.l = -1L;
    this.j = null;
    this.o = false;
    this.r = false;
    this.s = false;
    this.y = false;
  }
  
  private void f()
  {
    TbsLog.i("TbsDownload", "[TbsApkDownloader.closeHttpRequest]");
    if (this.t != null) {
      if (!this.r) {
        this.v.b(a(this.t.getURL()));
      }
    }
    try
    {
      this.t.disconnect();
      this.t = null;
      int i1 = this.v.a;
      if ((!this.r) && (this.y))
      {
        this.v.a(System.currentTimeMillis());
        String str2 = Apn.getApnInfo(this.g);
        String str1 = str2;
        if (str2 == null) {
          str1 = "";
        }
        int i2 = Apn.getApnType(this.g);
        this.v.c(str1);
        this.v.e(i2);
        if ((i2 != this.x) || (!str1.equals(this.w))) {
          this.v.g(0);
        }
        if (((this.v.a == 0) || (this.v.a == 107)) && (this.v.c() == 0))
        {
          if (!Apn.isNetworkAvailable(this.g)) {
            a(101, null, true);
          }
        }
        else
        {
          this.v.a(TbsLogReport.EventType.TYPE_DOWNLOAD);
          if (i1 != 100) {
            QbSdk.j.onDownloadFinish(i1);
          }
          return;
        }
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        TbsLog.e("TbsDownload", "[closeHttpRequest] mHttpRequest.disconnect() Throwable:" + localThrowable.toString());
        continue;
        if (!l()) {
          a(101, null, true);
        }
      }
      TbsDownloader.a = false;
    }
  }
  
  private boolean g()
  {
    try
    {
      File localFile1 = new File(this.k, "x5.tbs");
      File localFile2 = a(this.g);
      if (localFile2 != null)
      {
        if (TbsDownloader.getOverSea(this.g)) {}
        for (Object localObject = "x5.oversea.tbs.org";; localObject = "x5.tbs.org")
        {
          localObject = new File(localFile2, (String)localObject);
          localFile1.delete();
          j.b((File)localObject, localFile1);
          break;
        }
      }
      return true;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      TbsLog.e("TbsDownload", "[TbsApkDownloader.copyTbsApkFromBackupToInstall] Exception is " + localException.getMessage());
      return false;
    }
  }
  
  private boolean h()
  {
    String str = j.a(this.g, 4);
    if (TbsDownloader.getOverSea(this.g)) {}
    for (Object localObject = "x5.oversea.tbs.org";; localObject = "x5.tbs.org")
    {
      localObject = new File(str, (String)localObject);
      int i2 = TbsDownloadConfig.getInstance(this.g).mPreferences.getInt("use_backup_version", 0);
      int i1 = i2;
      if (i2 == 0) {
        i1 = TbsDownloadConfig.getInstance(this.g).mPreferences.getInt("tbs_download_version", 0);
      }
      return a.a(this.g, (File)localObject, 0L, i1);
    }
  }
  
  private void i()
  {
    try
    {
      String str = j.a(this.g, 4);
      if (TbsDownloader.getOverSea(this.g)) {}
      for (Object localObject = "x5.oversea.tbs.org";; localObject = "x5.tbs.org")
      {
        localObject = new File(str, (String)localObject);
        if ((localObject == null) || (!((File)localObject).exists())) {
          break;
        }
        ((File)localObject).delete();
        return;
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private boolean j()
  {
    boolean bool2 = false;
    File localFile = new File(this.k, "x5.tbs.temp");
    boolean bool1 = bool2;
    if (localFile != null)
    {
      bool1 = bool2;
      if (localFile.exists()) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private long k()
  {
    long l2 = 0L;
    File localFile = new File(this.k, "x5.tbs.temp");
    long l1 = l2;
    if (localFile != null)
    {
      l1 = l2;
      if (localFile.exists()) {
        l1 = localFile.length();
      }
    }
    return l1;
  }
  
  /* Error */
  private boolean l()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: aconst_null
    //   4: astore 8
    //   6: aconst_null
    //   7: astore 9
    //   9: invokestatic 611	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   12: astore 5
    //   14: aload 5
    //   16: new 103	java/lang/StringBuilder
    //   19: dup
    //   20: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   23: ldc_w 613
    //   26: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: ldc_w 615
    //   32: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   38: invokevirtual 619	java/lang/Runtime:exec	(Ljava/lang/String;)Ljava/lang/Process;
    //   41: invokevirtual 625	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   44: astore 5
    //   46: new 627	java/io/InputStreamReader
    //   49: dup
    //   50: aload 5
    //   52: invokespecial 630	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   55: astore 7
    //   57: new 632	java/io/BufferedReader
    //   60: dup
    //   61: aload 7
    //   63: invokespecial 635	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   66: astore 6
    //   68: iconst_0
    //   69: istore_1
    //   70: aload 6
    //   72: invokevirtual 638	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   75: astore 8
    //   77: iload 4
    //   79: istore_3
    //   80: aload 8
    //   82: ifnull +29 -> 111
    //   85: aload 8
    //   87: ldc_w 640
    //   90: invokevirtual 644	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   93: ifne +16 -> 109
    //   96: aload 8
    //   98: ldc_w 646
    //   101: invokevirtual 644	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   104: istore_3
    //   105: iload_3
    //   106: ifeq +25 -> 131
    //   109: iconst_1
    //   110: istore_3
    //   111: aload_0
    //   112: aload 5
    //   114: invokespecial 648	com/tencent/smtt/sdk/ab:a	(Ljava/io/Closeable;)V
    //   117: aload_0
    //   118: aload 7
    //   120: invokespecial 648	com/tencent/smtt/sdk/ab:a	(Ljava/io/Closeable;)V
    //   123: aload_0
    //   124: aload 6
    //   126: invokespecial 648	com/tencent/smtt/sdk/ab:a	(Ljava/io/Closeable;)V
    //   129: iload_3
    //   130: ireturn
    //   131: iload_1
    //   132: iconst_1
    //   133: iadd
    //   134: istore_2
    //   135: iload_2
    //   136: istore_1
    //   137: iload_2
    //   138: iconst_5
    //   139: if_icmplt -69 -> 70
    //   142: iload 4
    //   144: istore_3
    //   145: goto -34 -> 111
    //   148: astore 7
    //   150: aconst_null
    //   151: astore 5
    //   153: aconst_null
    //   154: astore 6
    //   156: aload 9
    //   158: astore 8
    //   160: aload 7
    //   162: invokevirtual 649	java/lang/Throwable:printStackTrace	()V
    //   165: aload_0
    //   166: aload 6
    //   168: invokespecial 648	com/tencent/smtt/sdk/ab:a	(Ljava/io/Closeable;)V
    //   171: aload_0
    //   172: aload 8
    //   174: invokespecial 648	com/tencent/smtt/sdk/ab:a	(Ljava/io/Closeable;)V
    //   177: aload_0
    //   178: aload 5
    //   180: invokespecial 648	com/tencent/smtt/sdk/ab:a	(Ljava/io/Closeable;)V
    //   183: iconst_0
    //   184: ireturn
    //   185: astore 6
    //   187: aconst_null
    //   188: astore 7
    //   190: aconst_null
    //   191: astore 5
    //   193: aload_0
    //   194: aload 5
    //   196: invokespecial 648	com/tencent/smtt/sdk/ab:a	(Ljava/io/Closeable;)V
    //   199: aload_0
    //   200: aload 7
    //   202: invokespecial 648	com/tencent/smtt/sdk/ab:a	(Ljava/io/Closeable;)V
    //   205: aload_0
    //   206: aload 8
    //   208: invokespecial 648	com/tencent/smtt/sdk/ab:a	(Ljava/io/Closeable;)V
    //   211: aload 6
    //   213: athrow
    //   214: astore 6
    //   216: aconst_null
    //   217: astore 7
    //   219: goto -26 -> 193
    //   222: astore 6
    //   224: goto -31 -> 193
    //   227: astore 9
    //   229: aload 6
    //   231: astore 8
    //   233: aload 9
    //   235: astore 6
    //   237: goto -44 -> 193
    //   240: astore 10
    //   242: aload 6
    //   244: astore 9
    //   246: aload 8
    //   248: astore 7
    //   250: aload 10
    //   252: astore 6
    //   254: aload 5
    //   256: astore 8
    //   258: aload 9
    //   260: astore 5
    //   262: goto -69 -> 193
    //   265: astore 7
    //   267: aconst_null
    //   268: astore 8
    //   270: aload 5
    //   272: astore 6
    //   274: aload 8
    //   276: astore 5
    //   278: aload 9
    //   280: astore 8
    //   282: goto -122 -> 160
    //   285: astore 10
    //   287: aconst_null
    //   288: astore 9
    //   290: aload 7
    //   292: astore 8
    //   294: aload 5
    //   296: astore 6
    //   298: aload 10
    //   300: astore 7
    //   302: aload 9
    //   304: astore 5
    //   306: goto -146 -> 160
    //   309: astore 10
    //   311: aload 7
    //   313: astore 8
    //   315: aload 5
    //   317: astore 9
    //   319: aload 10
    //   321: astore 7
    //   323: aload 6
    //   325: astore 5
    //   327: aload 9
    //   329: astore 6
    //   331: goto -171 -> 160
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	334	0	this	ab
    //   69	68	1	i1	int
    //   134	6	2	i2	int
    //   79	66	3	bool1	boolean
    //   1	142	4	bool2	boolean
    //   12	314	5	localObject1	Object
    //   66	101	6	localBufferedReader	java.io.BufferedReader
    //   185	27	6	localObject2	Object
    //   214	1	6	localObject3	Object
    //   222	8	6	localObject4	Object
    //   235	95	6	localObject5	Object
    //   55	64	7	localInputStreamReader	java.io.InputStreamReader
    //   148	13	7	localThrowable1	Throwable
    //   188	61	7	localObject6	Object
    //   265	26	7	localThrowable2	Throwable
    //   300	22	7	localObject7	Object
    //   4	310	8	localObject8	Object
    //   7	150	9	localObject9	Object
    //   227	7	9	localObject10	Object
    //   244	84	9	localObject11	Object
    //   240	11	10	localObject12	Object
    //   285	14	10	localThrowable3	Throwable
    //   309	11	10	localThrowable4	Throwable
    // Exception table:
    //   from	to	target	type
    //   14	46	148	java/lang/Throwable
    //   14	46	185	finally
    //   46	57	214	finally
    //   57	68	222	finally
    //   70	77	227	finally
    //   85	105	227	finally
    //   160	165	240	finally
    //   46	57	265	java/lang/Throwable
    //   57	68	285	java/lang/Throwable
    //   70	77	309	java/lang/Throwable
    //   85	105	309	java/lang/Throwable
  }
  
  private long m()
  {
    switch (this.p)
    {
    default: 
      return 20000L * 10L;
    case 1: 
    case 2: 
      return 20000L * this.p;
    }
    return 20000L * 5L;
  }
  
  /* Error */
  private boolean n()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: aconst_null
    //   4: astore 6
    //   6: iconst_1
    //   7: istore 4
    //   9: iconst_0
    //   10: istore 5
    //   12: aload_0
    //   13: getfield 89	com/tencent/smtt/sdk/ab:g	Landroid/content/Context;
    //   16: invokestatic 570	com/tencent/smtt/utils/Apn:getApnType	(Landroid/content/Context;)I
    //   19: iconst_3
    //   20: if_icmpne +292 -> 312
    //   23: iconst_1
    //   24: istore_3
    //   25: ldc -69
    //   27: new 103	java/lang/StringBuilder
    //   30: dup
    //   31: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   34: ldc_w 657
    //   37: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: iload_3
    //   41: invokevirtual 338	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   44: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   47: invokestatic 340	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   50: iload 5
    //   52: istore_2
    //   53: iload_3
    //   54: ifeq +157 -> 211
    //   57: aload_0
    //   58: getfield 89	com/tencent/smtt/sdk/ab:g	Landroid/content/Context;
    //   61: invokestatic 660	com/tencent/smtt/utils/Apn:getWifiSSID	(Landroid/content/Context;)Ljava/lang/String;
    //   64: astore 6
    //   66: ldc -69
    //   68: new 103	java/lang/StringBuilder
    //   71: dup
    //   72: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   75: ldc_w 662
    //   78: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: aload 6
    //   83: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   89: invokestatic 340	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   92: new 231	java/net/URL
    //   95: dup
    //   96: ldc_w 664
    //   99: invokespecial 281	java/net/URL:<init>	(Ljava/lang/String;)V
    //   102: astore 7
    //   104: aload 7
    //   106: instanceof 231
    //   109: ifne +208 -> 317
    //   112: aload 7
    //   114: invokevirtual 292	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   117: astore 7
    //   119: aload 7
    //   121: checkcast 285	java/net/HttpURLConnection
    //   124: astore 7
    //   126: aload 7
    //   128: iconst_0
    //   129: invokevirtual 313	java/net/HttpURLConnection:setInstanceFollowRedirects	(Z)V
    //   132: aload 7
    //   134: sipush 10000
    //   137: invokevirtual 316	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   140: aload 7
    //   142: sipush 10000
    //   145: invokevirtual 319	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   148: aload 7
    //   150: iconst_0
    //   151: invokevirtual 667	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   154: aload 7
    //   156: invokevirtual 668	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   159: pop
    //   160: aload 7
    //   162: invokevirtual 671	java/net/HttpURLConnection:getResponseCode	()I
    //   165: istore_1
    //   166: ldc -69
    //   168: new 103	java/lang/StringBuilder
    //   171: dup
    //   172: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   175: ldc_w 673
    //   178: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   181: iload_1
    //   182: invokevirtual 416	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   185: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   188: invokestatic 340	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   191: iload_1
    //   192: sipush 204
    //   195: if_icmpne +135 -> 330
    //   198: iload 4
    //   200: istore_2
    //   201: aload 7
    //   203: ifnull +216 -> 419
    //   206: aload 7
    //   208: invokevirtual 288	java/net/HttpURLConnection:disconnect	()V
    //   211: iload_2
    //   212: ifne +68 -> 280
    //   215: aload 6
    //   217: invokestatic 678	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   220: ifne +60 -> 280
    //   223: aload_0
    //   224: getfield 101	com/tencent/smtt/sdk/ab:A	Ljava/util/Set;
    //   227: aload 6
    //   229: invokeinterface 682 2 0
    //   234: ifne +46 -> 280
    //   237: aload_0
    //   238: getfield 101	com/tencent/smtt/sdk/ab:A	Ljava/util/Set;
    //   241: aload 6
    //   243: invokeinterface 685 2 0
    //   248: pop
    //   249: aload_0
    //   250: invokespecial 687	com/tencent/smtt/sdk/ab:o	()V
    //   253: aload_0
    //   254: getfield 689	com/tencent/smtt/sdk/ab:z	Landroid/os/Handler;
    //   257: sipush 150
    //   260: aload 6
    //   262: invokevirtual 695	android/os/Handler:obtainMessage	(ILjava/lang/Object;)Landroid/os/Message;
    //   265: astore 7
    //   267: aload_0
    //   268: getfield 689	com/tencent/smtt/sdk/ab:z	Landroid/os/Handler;
    //   271: aload 7
    //   273: ldc2_w 696
    //   276: invokevirtual 701	android/os/Handler:sendMessageDelayed	(Landroid/os/Message;J)Z
    //   279: pop
    //   280: iload_2
    //   281: ifeq +29 -> 310
    //   284: aload_0
    //   285: getfield 101	com/tencent/smtt/sdk/ab:A	Ljava/util/Set;
    //   288: aload 6
    //   290: invokeinterface 682 2 0
    //   295: ifeq +15 -> 310
    //   298: aload_0
    //   299: getfield 101	com/tencent/smtt/sdk/ab:A	Ljava/util/Set;
    //   302: aload 6
    //   304: invokeinterface 704 2 0
    //   309: pop
    //   310: iload_2
    //   311: ireturn
    //   312: iconst_0
    //   313: istore_3
    //   314: goto -289 -> 25
    //   317: aload 7
    //   319: checkcast 231	java/net/URL
    //   322: invokestatic 327	com/mato/sdk/instrumentation/HttpInstrumentation:openConnection	(Ljava/net/URL;)Ljava/net/URLConnection;
    //   325: astore 7
    //   327: goto -208 -> 119
    //   330: iconst_0
    //   331: istore_2
    //   332: goto -131 -> 201
    //   335: astore 7
    //   337: goto -126 -> 211
    //   340: astore 8
    //   342: aconst_null
    //   343: astore 7
    //   345: aload 8
    //   347: invokevirtual 649	java/lang/Throwable:printStackTrace	()V
    //   350: aload 7
    //   352: ifnull +61 -> 413
    //   355: aload 7
    //   357: invokevirtual 288	java/net/HttpURLConnection:disconnect	()V
    //   360: iload 5
    //   362: istore_2
    //   363: goto -152 -> 211
    //   366: astore 7
    //   368: iload 5
    //   370: istore_2
    //   371: goto -160 -> 211
    //   374: astore 6
    //   376: aload 8
    //   378: astore 7
    //   380: aload 7
    //   382: ifnull +8 -> 390
    //   385: aload 7
    //   387: invokevirtual 288	java/net/HttpURLConnection:disconnect	()V
    //   390: aload 6
    //   392: athrow
    //   393: astore 7
    //   395: goto -5 -> 390
    //   398: astore 6
    //   400: goto -20 -> 380
    //   403: astore 6
    //   405: goto -25 -> 380
    //   408: astore 8
    //   410: goto -65 -> 345
    //   413: iload 5
    //   415: istore_2
    //   416: goto -205 -> 211
    //   419: goto -208 -> 211
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	422	0	this	ab
    //   165	31	1	i1	int
    //   52	364	2	bool1	boolean
    //   24	290	3	bool2	boolean
    //   7	192	4	bool3	boolean
    //   10	404	5	bool4	boolean
    //   4	299	6	str	String
    //   374	17	6	localObject1	Object
    //   398	1	6	localObject2	Object
    //   403	1	6	localObject3	Object
    //   102	224	7	localObject4	Object
    //   335	1	7	localException1	Exception
    //   343	13	7	localObject5	Object
    //   366	1	7	localException2	Exception
    //   378	8	7	localThrowable1	Throwable
    //   393	1	7	localException3	Exception
    //   1	1	8	localObject6	Object
    //   340	37	8	localThrowable2	Throwable
    //   408	1	8	localThrowable3	Throwable
    // Exception table:
    //   from	to	target	type
    //   206	211	335	java/lang/Exception
    //   92	119	340	java/lang/Throwable
    //   119	126	340	java/lang/Throwable
    //   317	327	340	java/lang/Throwable
    //   355	360	366	java/lang/Exception
    //   92	119	374	finally
    //   119	126	374	finally
    //   317	327	374	finally
    //   385	390	393	java/lang/Exception
    //   126	191	398	finally
    //   345	350	403	finally
    //   126	191	408	java/lang/Throwable
  }
  
  private void o()
  {
    if (this.z == null) {
      this.z = new ac(this, ag.a().getLooper());
    }
  }
  
  public int a()
  {
    File localFile = a(this.g);
    if (localFile == null) {
      return 0;
    }
    Context localContext = this.g;
    if (TbsDownloader.getOverSea(this.g)) {}
    for (String str = "x5.oversea.tbs.org";; str = "x5.tbs.org") {
      return a.a(localContext, new File(localFile, str));
    }
  }
  
  public void a(int paramInt)
  {
    try
    {
      File localFile = new File(this.k, "x5.tbs");
      int i1 = a.a(this.g, localFile);
      if ((-1 == i1) || ((paramInt > 0) && (paramInt == i1))) {
        localFile.delete();
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  /* Error */
  public void a(boolean paramBoolean)
  {
    // Byte code:
    //   0: invokestatic 124	com/tencent/smtt/sdk/ai:a	()Lcom/tencent/smtt/sdk/ai;
    //   3: aload_0
    //   4: getfield 89	com/tencent/smtt/sdk/ab:g	Landroid/content/Context;
    //   7: invokevirtual 719	com/tencent/smtt/sdk/ai:a	(Landroid/content/Context;)Z
    //   10: ifeq +25 -> 35
    //   13: iload_1
    //   14: ifne +21 -> 35
    //   17: iconst_0
    //   18: putstatic 596	com/tencent/smtt/sdk/TbsDownloader:a	Z
    //   21: aload_0
    //   22: getfield 89	com/tencent/smtt/sdk/ab:g	Landroid/content/Context;
    //   25: invokestatic 350	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   28: sipush 65214
    //   31: invokevirtual 722	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   34: return
    //   35: aload_0
    //   36: getfield 89	com/tencent/smtt/sdk/ab:g	Landroid/content/Context;
    //   39: invokestatic 350	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   42: getfield 354	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   45: ldc_w 493
    //   48: iconst_0
    //   49: invokeinterface 409 3 0
    //   54: istore_2
    //   55: iload_2
    //   56: iconst_1
    //   57: if_icmpeq +13 -> 70
    //   60: iload_2
    //   61: iconst_2
    //   62: if_icmpeq +8 -> 70
    //   65: iload_2
    //   66: iconst_4
    //   67: if_icmpne +21 -> 88
    //   70: iconst_1
    //   71: istore 6
    //   73: aload_0
    //   74: iload_1
    //   75: iload 6
    //   77: invokevirtual 724	com/tencent/smtt/sdk/ab:a	(ZZ)Z
    //   80: ifeq +14 -> 94
    //   83: iconst_0
    //   84: putstatic 596	com/tencent/smtt/sdk/TbsDownloader:a	Z
    //   87: return
    //   88: iconst_0
    //   89: istore 6
    //   91: goto -18 -> 73
    //   94: aload_0
    //   95: iload_1
    //   96: putfield 726	com/tencent/smtt/sdk/ab:C	Z
    //   99: aload_0
    //   100: aload_0
    //   101: getfield 89	com/tencent/smtt/sdk/ab:g	Landroid/content/Context;
    //   104: invokestatic 350	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   107: getfield 354	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   110: ldc_w 728
    //   113: aconst_null
    //   114: invokeinterface 362 3 0
    //   119: putfield 730	com/tencent/smtt/sdk/ab:h	Ljava/lang/String;
    //   122: aload_0
    //   123: getfield 89	com/tencent/smtt/sdk/ab:g	Landroid/content/Context;
    //   126: invokestatic 350	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   129: getfield 354	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   132: ldc_w 732
    //   135: aconst_null
    //   136: invokeinterface 362 3 0
    //   141: astore 25
    //   143: ldc -69
    //   145: new 103	java/lang/StringBuilder
    //   148: dup
    //   149: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   152: ldc_w 734
    //   155: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   158: aload 25
    //   160: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   166: iconst_1
    //   167: invokestatic 737	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   170: aload_0
    //   171: aconst_null
    //   172: putfield 79	com/tencent/smtt/sdk/ab:b	[Ljava/lang/String;
    //   175: aload_0
    //   176: iconst_0
    //   177: putfield 81	com/tencent/smtt/sdk/ab:c	I
    //   180: iload_1
    //   181: ifne +36 -> 217
    //   184: aload 25
    //   186: ifnull +31 -> 217
    //   189: ldc -11
    //   191: aload 25
    //   193: invokevirtual 740	java/lang/String:trim	()Ljava/lang/String;
    //   196: invokevirtual 371	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   199: ifne +18 -> 217
    //   202: aload_0
    //   203: aload 25
    //   205: invokevirtual 740	java/lang/String:trim	()Ljava/lang/String;
    //   208: ldc_w 742
    //   211: invokevirtual 746	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   214: putfield 79	com/tencent/smtt/sdk/ab:b	[Ljava/lang/String;
    //   217: ldc -69
    //   219: new 103	java/lang/StringBuilder
    //   222: dup
    //   223: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   226: ldc_w 748
    //   229: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   232: aload_0
    //   233: getfield 730	com/tencent/smtt/sdk/ab:h	Ljava/lang/String;
    //   236: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   239: ldc_w 750
    //   242: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   245: aload 25
    //   247: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   250: ldc_w 752
    //   253: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   256: aload_0
    //   257: getfield 539	com/tencent/smtt/sdk/ab:j	Ljava/lang/String;
    //   260: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   263: ldc_w 754
    //   266: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   269: aload_0
    //   270: getfield 543	com/tencent/smtt/sdk/ab:r	Z
    //   273: invokevirtual 338	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   276: ldc_w 756
    //   279: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   282: aload_0
    //   283: getfield 283	com/tencent/smtt/sdk/ab:t	Ljava/net/HttpURLConnection;
    //   286: invokevirtual 436	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   289: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   292: invokestatic 340	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   295: aload_0
    //   296: getfield 730	com/tencent/smtt/sdk/ab:h	Ljava/lang/String;
    //   299: ifnonnull +34 -> 333
    //   302: aload_0
    //   303: getfield 539	com/tencent/smtt/sdk/ab:j	Ljava/lang/String;
    //   306: ifnonnull +27 -> 333
    //   309: getstatic 486	com/tencent/smtt/sdk/QbSdk:j	Lcom/tencent/smtt/sdk/TbsListener;
    //   312: bipush 110
    //   314: invokeinterface 491 2 0
    //   319: aload_0
    //   320: getfield 89	com/tencent/smtt/sdk/ab:g	Landroid/content/Context;
    //   323: invokestatic 350	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   326: sipush 65234
    //   329: invokevirtual 722	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   332: return
    //   333: aload_0
    //   334: getfield 283	com/tencent/smtt/sdk/ab:t	Ljava/net/HttpURLConnection;
    //   337: ifnull +34 -> 371
    //   340: aload_0
    //   341: getfield 543	com/tencent/smtt/sdk/ab:r	Z
    //   344: ifne +27 -> 371
    //   347: getstatic 486	com/tencent/smtt/sdk/QbSdk:j	Lcom/tencent/smtt/sdk/TbsListener;
    //   350: bipush 110
    //   352: invokeinterface 491 2 0
    //   357: aload_0
    //   358: getfield 89	com/tencent/smtt/sdk/ab:g	Landroid/content/Context;
    //   361: invokestatic 350	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   364: sipush 65233
    //   367: invokevirtual 722	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   370: return
    //   371: iload_1
    //   372: ifne +54 -> 426
    //   375: aload_0
    //   376: getfield 101	com/tencent/smtt/sdk/ab:A	Ljava/util/Set;
    //   379: aload_0
    //   380: getfield 89	com/tencent/smtt/sdk/ab:g	Landroid/content/Context;
    //   383: invokestatic 660	com/tencent/smtt/utils/Apn:getWifiSSID	(Landroid/content/Context;)Ljava/lang/String;
    //   386: invokeinterface 682 2 0
    //   391: ifeq +35 -> 426
    //   394: ldc -69
    //   396: ldc_w 758
    //   399: invokestatic 340	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   402: getstatic 486	com/tencent/smtt/sdk/QbSdk:j	Lcom/tencent/smtt/sdk/TbsListener;
    //   405: bipush 110
    //   407: invokeinterface 491 2 0
    //   412: aload_0
    //   413: getfield 89	com/tencent/smtt/sdk/ab:g	Landroid/content/Context;
    //   416: invokestatic 350	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   419: sipush 65232
    //   422: invokevirtual 722	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   425: return
    //   426: aload_0
    //   427: invokespecial 138	com/tencent/smtt/sdk/ab:e	()V
    //   430: ldc -69
    //   432: ldc_w 760
    //   435: iconst_1
    //   436: invokestatic 737	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   439: aload_0
    //   440: getfield 89	com/tencent/smtt/sdk/ab:g	Landroid/content/Context;
    //   443: invokestatic 350	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   446: invokevirtual 763	com/tencent/smtt/sdk/TbsDownloadConfig:getDownloadMaxflow	()J
    //   449: lstore 23
    //   451: iconst_0
    //   452: istore_3
    //   453: aload_0
    //   454: getfield 89	com/tencent/smtt/sdk/ab:g	Landroid/content/Context;
    //   457: invokestatic 350	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   460: getfield 354	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   463: ldc_w 765
    //   466: lconst_0
    //   467: invokeinterface 387 4 0
    //   472: lstore 9
    //   474: iload_1
    //   475: ifeq +216 -> 691
    //   478: aload_0
    //   479: getstatic 52	com/tencent/smtt/sdk/ab:e	I
    //   482: putfield 77	com/tencent/smtt/sdk/ab:B	I
    //   485: aload_0
    //   486: getfield 249	com/tencent/smtt/sdk/ab:p	I
    //   489: aload_0
    //   490: getfield 77	com/tencent/smtt/sdk/ab:B	I
    //   493: if_icmple +208 -> 701
    //   496: iload_3
    //   497: istore 4
    //   499: aload_0
    //   500: getfield 543	com/tencent/smtt/sdk/ab:r	Z
    //   503: ifne +183 -> 686
    //   506: iload 4
    //   508: istore_1
    //   509: aload_0
    //   510: getfield 545	com/tencent/smtt/sdk/ab:s	Z
    //   513: ifeq +102 -> 615
    //   516: iload 4
    //   518: istore_1
    //   519: aload_0
    //   520: getfield 79	com/tencent/smtt/sdk/ab:b	[Ljava/lang/String;
    //   523: ifnonnull +19 -> 542
    //   526: iload 4
    //   528: istore_1
    //   529: iload 4
    //   531: ifne +11 -> 542
    //   534: aload_0
    //   535: iconst_1
    //   536: iload 6
    //   538: invokespecial 767	com/tencent/smtt/sdk/ab:b	(ZZ)Z
    //   541: istore_1
    //   542: aload_0
    //   543: getfield 96	com/tencent/smtt/sdk/ab:v	Lcom/tencent/smtt/sdk/TbsLogReport;
    //   546: astore 25
    //   548: iload_1
    //   549: ifeq +5525 -> 6074
    //   552: iconst_1
    //   553: istore_2
    //   554: aload 25
    //   556: iload_2
    //   557: invokevirtual 769	com/tencent/smtt/sdk/TbsLogReport:d	(I)V
    //   560: iload 6
    //   562: ifne +5522 -> 6084
    //   565: aload_0
    //   566: getfield 96	com/tencent/smtt/sdk/ab:v	Lcom/tencent/smtt/sdk/TbsLogReport;
    //   569: astore 25
    //   571: iload_1
    //   572: ifeq +5507 -> 6079
    //   575: iconst_1
    //   576: istore_2
    //   577: aload 25
    //   579: iload_2
    //   580: invokevirtual 771	com/tencent/smtt/sdk/TbsLogReport:b	(I)V
    //   583: iload_1
    //   584: ifeq +5511 -> 6095
    //   587: aload_0
    //   588: iconst_1
    //   589: invokespecial 773	com/tencent/smtt/sdk/ab:c	(Z)V
    //   592: aload_0
    //   593: getfield 89	com/tencent/smtt/sdk/ab:g	Landroid/content/Context;
    //   596: invokestatic 350	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   599: sipush 65219
    //   602: invokevirtual 722	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   605: aload_0
    //   606: bipush 100
    //   608: ldc_w 775
    //   611: iconst_1
    //   612: invokespecial 452	com/tencent/smtt/sdk/ab:a	(ILjava/lang/String;Z)V
    //   615: aload_0
    //   616: getfield 89	com/tencent/smtt/sdk/ab:g	Landroid/content/Context;
    //   619: invokestatic 350	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   622: astore 25
    //   624: iload_1
    //   625: ifeq +5492 -> 6117
    //   628: aload 25
    //   630: getfield 354	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   633: ldc_w 777
    //   636: iconst_0
    //   637: invokeinterface 409 3 0
    //   642: istore_2
    //   643: aload 25
    //   645: getfield 461	com/tencent/smtt/sdk/TbsDownloadConfig:a	Ljava/util/Map;
    //   648: ldc_w 777
    //   651: iload_2
    //   652: iconst_1
    //   653: iadd
    //   654: invokestatic 442	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   657: invokeinterface 474 3 0
    //   662: pop
    //   663: aload 25
    //   665: invokevirtual 481	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   668: aload_0
    //   669: getfield 96	com/tencent/smtt/sdk/ab:v	Lcom/tencent/smtt/sdk/TbsLogReport;
    //   672: astore 25
    //   674: iload_1
    //   675: ifeq +5503 -> 6178
    //   678: iconst_1
    //   679: istore_2
    //   680: aload 25
    //   682: iload_2
    //   683: invokevirtual 779	com/tencent/smtt/sdk/TbsLogReport:f	(I)V
    //   686: aload_0
    //   687: invokespecial 781	com/tencent/smtt/sdk/ab:f	()V
    //   690: return
    //   691: aload_0
    //   692: getstatic 50	com/tencent/smtt/sdk/ab:d	I
    //   695: putfield 77	com/tencent/smtt/sdk/ab:B	I
    //   698: goto -213 -> 485
    //   701: aload_0
    //   702: getfield 533	com/tencent/smtt/sdk/ab:q	I
    //   705: bipush 8
    //   707: if_icmple +30 -> 737
    //   710: aload_0
    //   711: bipush 123
    //   713: aconst_null
    //   714: iconst_1
    //   715: invokespecial 452	com/tencent/smtt/sdk/ab:a	(ILjava/lang/String;Z)V
    //   718: aload_0
    //   719: getfield 89	com/tencent/smtt/sdk/ab:g	Landroid/content/Context;
    //   722: invokestatic 350	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   725: sipush 65230
    //   728: invokevirtual 722	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   731: iload_3
    //   732: istore 4
    //   734: goto -235 -> 499
    //   737: invokestatic 149	java/lang/System:currentTimeMillis	()J
    //   740: lstore 21
    //   742: lload 9
    //   744: lstore 7
    //   746: iload_1
    //   747: ifne +441 -> 1188
    //   750: iload_3
    //   751: istore 4
    //   753: lload 9
    //   755: lstore 13
    //   757: lload 9
    //   759: lstore 11
    //   761: lload 21
    //   763: aload_0
    //   764: getfield 89	com/tencent/smtt/sdk/ab:g	Landroid/content/Context;
    //   767: invokestatic 350	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   770: getfield 354	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   773: ldc_w 783
    //   776: lconst_0
    //   777: invokeinterface 387 4 0
    //   782: lsub
    //   783: ldc2_w 784
    //   786: lcmp
    //   787: ifle +246 -> 1033
    //   790: iload_3
    //   791: istore 4
    //   793: lload 9
    //   795: lstore 13
    //   797: lload 9
    //   799: lstore 11
    //   801: ldc -69
    //   803: ldc_w 787
    //   806: invokestatic 340	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   809: iload_3
    //   810: istore 4
    //   812: lload 9
    //   814: lstore 13
    //   816: lload 9
    //   818: lstore 11
    //   820: aload_0
    //   821: getfield 89	com/tencent/smtt/sdk/ab:g	Landroid/content/Context;
    //   824: invokestatic 350	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   827: getfield 461	com/tencent/smtt/sdk/TbsDownloadConfig:a	Ljava/util/Map;
    //   830: ldc_w 783
    //   833: lload 21
    //   835: invokestatic 792	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   838: invokeinterface 474 3 0
    //   843: pop
    //   844: iload_3
    //   845: istore 4
    //   847: lload 9
    //   849: lstore 13
    //   851: lload 9
    //   853: lstore 11
    //   855: aload_0
    //   856: getfield 89	com/tencent/smtt/sdk/ab:g	Landroid/content/Context;
    //   859: invokestatic 350	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   862: getfield 461	com/tencent/smtt/sdk/TbsDownloadConfig:a	Ljava/util/Map;
    //   865: ldc_w 765
    //   868: lconst_0
    //   869: invokestatic 792	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   872: invokeinterface 474 3 0
    //   877: pop
    //   878: iload_3
    //   879: istore 4
    //   881: lload 9
    //   883: lstore 13
    //   885: lload 9
    //   887: lstore 11
    //   889: aload_0
    //   890: getfield 89	com/tencent/smtt/sdk/ab:g	Landroid/content/Context;
    //   893: invokestatic 350	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   896: invokevirtual 481	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   899: lconst_0
    //   900: lstore 7
    //   902: lload 7
    //   904: lstore 9
    //   906: iload_3
    //   907: istore 5
    //   909: lload 7
    //   911: lstore 11
    //   913: aload_0
    //   914: getfield 89	com/tencent/smtt/sdk/ab:g	Landroid/content/Context;
    //   917: invokestatic 794	com/tencent/smtt/utils/j:b	(Landroid/content/Context;)Z
    //   920: ifne +268 -> 1188
    //   923: lload 7
    //   925: lstore 9
    //   927: iload_3
    //   928: istore 5
    //   930: lload 7
    //   932: lstore 11
    //   934: ldc -69
    //   936: ldc_w 796
    //   939: iconst_1
    //   940: invokestatic 737	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   943: lload 7
    //   945: lstore 9
    //   947: iload_3
    //   948: istore 5
    //   950: lload 7
    //   952: lstore 11
    //   954: aload_0
    //   955: bipush 105
    //   957: aconst_null
    //   958: iconst_1
    //   959: invokespecial 452	com/tencent/smtt/sdk/ab:a	(ILjava/lang/String;Z)V
    //   962: lload 7
    //   964: lstore 9
    //   966: iload_3
    //   967: istore 5
    //   969: lload 7
    //   971: lstore 11
    //   973: aload_0
    //   974: getfield 89	com/tencent/smtt/sdk/ab:g	Landroid/content/Context;
    //   977: invokestatic 350	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   980: sipush 65228
    //   983: invokevirtual 722	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   986: iload_3
    //   987: istore 4
    //   989: iload_1
    //   990: ifne -491 -> 499
    //   993: aload_0
    //   994: getfield 89	com/tencent/smtt/sdk/ab:g	Landroid/content/Context;
    //   997: invokestatic 350	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1000: getfield 461	com/tencent/smtt/sdk/TbsDownloadConfig:a	Ljava/util/Map;
    //   1003: ldc_w 765
    //   1006: lload 7
    //   1008: invokestatic 792	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1011: invokeinterface 474 3 0
    //   1016: pop
    //   1017: aload_0
    //   1018: getfield 89	com/tencent/smtt/sdk/ab:g	Landroid/content/Context;
    //   1021: invokestatic 350	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1024: invokevirtual 481	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   1027: iload_3
    //   1028: istore 4
    //   1030: goto -531 -> 499
    //   1033: iload_3
    //   1034: istore 4
    //   1036: lload 9
    //   1038: lstore 13
    //   1040: lload 9
    //   1042: lstore 11
    //   1044: ldc -69
    //   1046: new 103	java/lang/StringBuilder
    //   1049: dup
    //   1050: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   1053: ldc_w 798
    //   1056: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1059: lload 9
    //   1061: invokevirtual 396	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1064: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1067: invokestatic 340	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1070: lload 9
    //   1072: lload 23
    //   1074: lcmp
    //   1075: iflt +5354 -> 6429
    //   1078: iload_3
    //   1079: istore 4
    //   1081: lload 9
    //   1083: lstore 13
    //   1085: lload 9
    //   1087: lstore 11
    //   1089: ldc -69
    //   1091: ldc_w 800
    //   1094: iconst_1
    //   1095: invokestatic 737	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   1098: iload_3
    //   1099: istore 4
    //   1101: lload 9
    //   1103: lstore 13
    //   1105: lload 9
    //   1107: lstore 11
    //   1109: aload_0
    //   1110: bipush 112
    //   1112: aconst_null
    //   1113: iconst_1
    //   1114: invokespecial 452	com/tencent/smtt/sdk/ab:a	(ILjava/lang/String;Z)V
    //   1117: iload_3
    //   1118: istore 4
    //   1120: lload 9
    //   1122: lstore 13
    //   1124: lload 9
    //   1126: lstore 11
    //   1128: aload_0
    //   1129: getfield 89	com/tencent/smtt/sdk/ab:g	Landroid/content/Context;
    //   1132: invokestatic 350	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1135: sipush 65229
    //   1138: invokevirtual 722	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   1141: iload_3
    //   1142: istore 4
    //   1144: iload_1
    //   1145: ifne -646 -> 499
    //   1148: aload_0
    //   1149: getfield 89	com/tencent/smtt/sdk/ab:g	Landroid/content/Context;
    //   1152: invokestatic 350	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1155: getfield 461	com/tencent/smtt/sdk/TbsDownloadConfig:a	Ljava/util/Map;
    //   1158: ldc_w 765
    //   1161: lload 9
    //   1163: invokestatic 792	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1166: invokeinterface 474 3 0
    //   1171: pop
    //   1172: aload_0
    //   1173: getfield 89	com/tencent/smtt/sdk/ab:g	Landroid/content/Context;
    //   1176: invokestatic 350	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1179: invokevirtual 481	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   1182: iload_3
    //   1183: istore 4
    //   1185: goto -686 -> 499
    //   1188: iload_3
    //   1189: istore 4
    //   1191: lload 7
    //   1193: lstore 13
    //   1195: lload 7
    //   1197: lstore 11
    //   1199: aload_0
    //   1200: iconst_1
    //   1201: putfield 547	com/tencent/smtt/sdk/ab:y	Z
    //   1204: iload_3
    //   1205: istore 4
    //   1207: lload 7
    //   1209: lstore 13
    //   1211: lload 7
    //   1213: lstore 11
    //   1215: aload_0
    //   1216: getfield 539	com/tencent/smtt/sdk/ab:j	Ljava/lang/String;
    //   1219: ifnull +846 -> 2065
    //   1222: iload_3
    //   1223: istore 4
    //   1225: lload 7
    //   1227: lstore 13
    //   1229: lload 7
    //   1231: lstore 11
    //   1233: aload_0
    //   1234: getfield 539	com/tencent/smtt/sdk/ab:j	Ljava/lang/String;
    //   1237: astore 25
    //   1239: iload_3
    //   1240: istore 4
    //   1242: lload 7
    //   1244: lstore 13
    //   1246: lload 7
    //   1248: lstore 11
    //   1250: ldc -69
    //   1252: new 103	java/lang/StringBuilder
    //   1255: dup
    //   1256: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   1259: ldc_w 802
    //   1262: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1265: aload 25
    //   1267: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1270: ldc_w 804
    //   1273: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1276: aload_0
    //   1277: getfield 249	com/tencent/smtt/sdk/ab:p	I
    //   1280: invokevirtual 416	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1283: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1286: iconst_1
    //   1287: invokestatic 737	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   1290: iload_3
    //   1291: istore 4
    //   1293: lload 7
    //   1295: lstore 13
    //   1297: lload 7
    //   1299: lstore 11
    //   1301: aload 25
    //   1303: aload_0
    //   1304: getfield 806	com/tencent/smtt/sdk/ab:i	Ljava/lang/String;
    //   1307: invokevirtual 371	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1310: ifne +23 -> 1333
    //   1313: iload_3
    //   1314: istore 4
    //   1316: lload 7
    //   1318: lstore 13
    //   1320: lload 7
    //   1322: lstore 11
    //   1324: aload_0
    //   1325: getfield 96	com/tencent/smtt/sdk/ab:v	Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1328: aload 25
    //   1330: invokevirtual 808	com/tencent/smtt/sdk/TbsLogReport:a	(Ljava/lang/String;)V
    //   1333: iload_3
    //   1334: istore 4
    //   1336: lload 7
    //   1338: lstore 13
    //   1340: lload 7
    //   1342: lstore 11
    //   1344: aload_0
    //   1345: aload 25
    //   1347: putfield 806	com/tencent/smtt/sdk/ab:i	Ljava/lang/String;
    //   1350: iload_3
    //   1351: istore 4
    //   1353: lload 7
    //   1355: lstore 13
    //   1357: lload 7
    //   1359: lstore 11
    //   1361: aload_0
    //   1362: aload 25
    //   1364: invokespecial 809	com/tencent/smtt/sdk/ab:a	(Ljava/lang/String;)V
    //   1367: lconst_0
    //   1368: lstore 9
    //   1370: iload_3
    //   1371: istore 4
    //   1373: lload 7
    //   1375: lstore 13
    //   1377: lload 7
    //   1379: lstore 11
    //   1381: aload_0
    //   1382: getfield 541	com/tencent/smtt/sdk/ab:o	Z
    //   1385: ifne +163 -> 1548
    //   1388: iload_3
    //   1389: istore 4
    //   1391: lload 7
    //   1393: lstore 13
    //   1395: lload 7
    //   1397: lstore 11
    //   1399: aload_0
    //   1400: invokespecial 811	com/tencent/smtt/sdk/ab:k	()J
    //   1403: lstore 9
    //   1405: iload_3
    //   1406: istore 4
    //   1408: lload 7
    //   1410: lstore 13
    //   1412: lload 7
    //   1414: lstore 11
    //   1416: ldc -69
    //   1418: new 103	java/lang/StringBuilder
    //   1421: dup
    //   1422: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   1425: ldc_w 813
    //   1428: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1431: lload 9
    //   1433: invokevirtual 396	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1436: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1439: invokestatic 340	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1442: iload_3
    //   1443: istore 4
    //   1445: lload 7
    //   1447: lstore 13
    //   1449: lload 7
    //   1451: lstore 11
    //   1453: aload_0
    //   1454: getfield 537	com/tencent/smtt/sdk/ab:l	J
    //   1457: lconst_0
    //   1458: lcmp
    //   1459: ifgt +626 -> 2085
    //   1462: iload_3
    //   1463: istore 4
    //   1465: lload 7
    //   1467: lstore 13
    //   1469: lload 7
    //   1471: lstore 11
    //   1473: ldc -69
    //   1475: new 103	java/lang/StringBuilder
    //   1478: dup
    //   1479: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   1482: ldc_w 815
    //   1485: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1488: lload 9
    //   1490: invokevirtual 396	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1493: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1496: iconst_1
    //   1497: invokestatic 737	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   1500: iload_3
    //   1501: istore 4
    //   1503: lload 7
    //   1505: lstore 13
    //   1507: lload 7
    //   1509: lstore 11
    //   1511: aload_0
    //   1512: getfield 283	com/tencent/smtt/sdk/ab:t	Ljava/net/HttpURLConnection;
    //   1515: ldc_w 817
    //   1518: new 103	java/lang/StringBuilder
    //   1521: dup
    //   1522: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   1525: ldc_w 819
    //   1528: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1531: lload 9
    //   1533: invokevirtual 396	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1536: ldc_w 821
    //   1539: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1542: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1545: invokevirtual 300	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   1548: iload_3
    //   1549: istore 4
    //   1551: lload 7
    //   1553: lstore 13
    //   1555: lload 7
    //   1557: lstore 11
    //   1559: aload_0
    //   1560: getfield 96	com/tencent/smtt/sdk/ab:v	Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1563: astore 25
    //   1565: lload 9
    //   1567: lconst_0
    //   1568: lcmp
    //   1569: ifne +800 -> 2369
    //   1572: iconst_0
    //   1573: istore_2
    //   1574: iload_3
    //   1575: istore 4
    //   1577: lload 7
    //   1579: lstore 13
    //   1581: lload 7
    //   1583: lstore 11
    //   1585: aload 25
    //   1587: iload_2
    //   1588: invokevirtual 823	com/tencent/smtt/sdk/TbsLogReport:c	(I)V
    //   1591: iload_3
    //   1592: istore 4
    //   1594: lload 7
    //   1596: lstore 13
    //   1598: lload 7
    //   1600: lstore 11
    //   1602: aload_0
    //   1603: getfield 89	com/tencent/smtt/sdk/ab:g	Landroid/content/Context;
    //   1606: invokestatic 570	com/tencent/smtt/utils/Apn:getApnType	(Landroid/content/Context;)I
    //   1609: istore_2
    //   1610: iload_3
    //   1611: istore 4
    //   1613: lload 7
    //   1615: lstore 13
    //   1617: lload 7
    //   1619: lstore 11
    //   1621: aload_0
    //   1622: getfield 89	com/tencent/smtt/sdk/ab:g	Landroid/content/Context;
    //   1625: invokestatic 566	com/tencent/smtt/utils/Apn:getApnInfo	(Landroid/content/Context;)Ljava/lang/String;
    //   1628: astore 25
    //   1630: iload_3
    //   1631: istore 4
    //   1633: lload 7
    //   1635: lstore 13
    //   1637: lload 7
    //   1639: lstore 11
    //   1641: aload_0
    //   1642: getfield 140	com/tencent/smtt/sdk/ab:w	Ljava/lang/String;
    //   1645: ifnonnull +729 -> 2374
    //   1648: iload_3
    //   1649: istore 4
    //   1651: lload 7
    //   1653: lstore 13
    //   1655: lload 7
    //   1657: lstore 11
    //   1659: aload_0
    //   1660: getfield 142	com/tencent/smtt/sdk/ab:x	I
    //   1663: iconst_m1
    //   1664: if_icmpne +710 -> 2374
    //   1667: iload_3
    //   1668: istore 4
    //   1670: lload 7
    //   1672: lstore 13
    //   1674: lload 7
    //   1676: lstore 11
    //   1678: aload_0
    //   1679: aload 25
    //   1681: putfield 140	com/tencent/smtt/sdk/ab:w	Ljava/lang/String;
    //   1684: iload_3
    //   1685: istore 4
    //   1687: lload 7
    //   1689: lstore 13
    //   1691: lload 7
    //   1693: lstore 11
    //   1695: aload_0
    //   1696: iload_2
    //   1697: putfield 142	com/tencent/smtt/sdk/ab:x	I
    //   1700: iload_3
    //   1701: istore 4
    //   1703: lload 7
    //   1705: lstore 13
    //   1707: lload 7
    //   1709: lstore 11
    //   1711: aload_0
    //   1712: getfield 249	com/tencent/smtt/sdk/ab:p	I
    //   1715: iconst_1
    //   1716: if_icmplt +28 -> 1744
    //   1719: iload_3
    //   1720: istore 4
    //   1722: lload 7
    //   1724: lstore 13
    //   1726: lload 7
    //   1728: lstore 11
    //   1730: aload_0
    //   1731: getfield 283	com/tencent/smtt/sdk/ab:t	Ljava/net/HttpURLConnection;
    //   1734: ldc_w 825
    //   1737: aload_0
    //   1738: getfield 730	com/tencent/smtt/sdk/ab:h	Ljava/lang/String;
    //   1741: invokevirtual 828	java/net/HttpURLConnection:addRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   1744: iload_3
    //   1745: istore 4
    //   1747: lload 7
    //   1749: lstore 13
    //   1751: lload 7
    //   1753: lstore 11
    //   1755: aload_0
    //   1756: getfield 283	com/tencent/smtt/sdk/ab:t	Ljava/net/HttpURLConnection;
    //   1759: invokevirtual 671	java/net/HttpURLConnection:getResponseCode	()I
    //   1762: istore_2
    //   1763: iload_3
    //   1764: istore 4
    //   1766: lload 7
    //   1768: lstore 13
    //   1770: lload 7
    //   1772: lstore 11
    //   1774: ldc -69
    //   1776: new 103	java/lang/StringBuilder
    //   1779: dup
    //   1780: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   1783: ldc_w 830
    //   1786: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1789: iload_2
    //   1790: invokevirtual 416	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1793: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1796: invokestatic 340	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1799: iload_3
    //   1800: istore 4
    //   1802: lload 7
    //   1804: lstore 13
    //   1806: lload 7
    //   1808: lstore 11
    //   1810: aload_0
    //   1811: getfield 96	com/tencent/smtt/sdk/ab:v	Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1814: iload_2
    //   1815: invokevirtual 832	com/tencent/smtt/sdk/TbsLogReport:a	(I)V
    //   1818: iload_1
    //   1819: ifne +157 -> 1976
    //   1822: iload_3
    //   1823: istore 4
    //   1825: lload 7
    //   1827: lstore 13
    //   1829: lload 7
    //   1831: lstore 11
    //   1833: aload_0
    //   1834: getfield 89	com/tencent/smtt/sdk/ab:g	Landroid/content/Context;
    //   1837: invokestatic 205	com/tencent/smtt/sdk/TbsDownloader:getOverSea	(Landroid/content/Context;)Z
    //   1840: ifne +136 -> 1976
    //   1843: iload_3
    //   1844: istore 4
    //   1846: lload 7
    //   1848: lstore 13
    //   1850: lload 7
    //   1852: lstore 11
    //   1854: aload_0
    //   1855: getfield 89	com/tencent/smtt/sdk/ab:g	Landroid/content/Context;
    //   1858: invokestatic 570	com/tencent/smtt/utils/Apn:getApnType	(Landroid/content/Context;)I
    //   1861: iconst_3
    //   1862: if_icmpeq +20 -> 1882
    //   1865: iload_3
    //   1866: istore 4
    //   1868: lload 7
    //   1870: lstore 13
    //   1872: lload 7
    //   1874: lstore 11
    //   1876: invokestatic 835	com/tencent/smtt/sdk/QbSdk:getDownloadWithoutWifi	()Z
    //   1879: ifeq +24 -> 1903
    //   1882: iload_3
    //   1883: istore 4
    //   1885: lload 7
    //   1887: lstore 13
    //   1889: lload 7
    //   1891: lstore 11
    //   1893: aload_0
    //   1894: getfield 89	com/tencent/smtt/sdk/ab:g	Landroid/content/Context;
    //   1897: invokestatic 570	com/tencent/smtt/utils/Apn:getApnType	(Landroid/content/Context;)I
    //   1900: ifne +76 -> 1976
    //   1903: iload_3
    //   1904: istore 4
    //   1906: lload 7
    //   1908: lstore 13
    //   1910: lload 7
    //   1912: lstore 11
    //   1914: aload_0
    //   1915: invokevirtual 837	com/tencent/smtt/sdk/ab:b	()V
    //   1918: iload_3
    //   1919: istore 4
    //   1921: lload 7
    //   1923: lstore 13
    //   1925: lload 7
    //   1927: lstore 11
    //   1929: getstatic 486	com/tencent/smtt/sdk/QbSdk:j	Lcom/tencent/smtt/sdk/TbsListener;
    //   1932: ifnull +24 -> 1956
    //   1935: iload_3
    //   1936: istore 4
    //   1938: lload 7
    //   1940: lstore 13
    //   1942: lload 7
    //   1944: lstore 11
    //   1946: getstatic 486	com/tencent/smtt/sdk/QbSdk:j	Lcom/tencent/smtt/sdk/TbsListener;
    //   1949: bipush 111
    //   1951: invokeinterface 491 2 0
    //   1956: iload_3
    //   1957: istore 4
    //   1959: lload 7
    //   1961: lstore 13
    //   1963: lload 7
    //   1965: lstore 11
    //   1967: ldc -69
    //   1969: ldc_w 839
    //   1972: iconst_0
    //   1973: invokestatic 737	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   1976: iload_3
    //   1977: istore 4
    //   1979: lload 7
    //   1981: lstore 13
    //   1983: lload 7
    //   1985: lstore 11
    //   1987: aload_0
    //   1988: getfield 543	com/tencent/smtt/sdk/ab:r	Z
    //   1991: ifeq +523 -> 2514
    //   1994: iload_3
    //   1995: istore 4
    //   1997: lload 7
    //   1999: lstore 13
    //   2001: lload 7
    //   2003: lstore 11
    //   2005: aload_0
    //   2006: getfield 89	com/tencent/smtt/sdk/ab:g	Landroid/content/Context;
    //   2009: invokestatic 350	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2012: sipush 65227
    //   2015: invokevirtual 722	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   2018: iload_3
    //   2019: istore 4
    //   2021: iload_1
    //   2022: ifne -1523 -> 499
    //   2025: aload_0
    //   2026: getfield 89	com/tencent/smtt/sdk/ab:g	Landroid/content/Context;
    //   2029: invokestatic 350	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2032: getfield 461	com/tencent/smtt/sdk/TbsDownloadConfig:a	Ljava/util/Map;
    //   2035: ldc_w 765
    //   2038: lload 7
    //   2040: invokestatic 792	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2043: invokeinterface 474 3 0
    //   2048: pop
    //   2049: aload_0
    //   2050: getfield 89	com/tencent/smtt/sdk/ab:g	Landroid/content/Context;
    //   2053: invokestatic 350	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2056: invokevirtual 481	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   2059: iload_3
    //   2060: istore 4
    //   2062: goto -1563 -> 499
    //   2065: iload_3
    //   2066: istore 4
    //   2068: lload 7
    //   2070: lstore 13
    //   2072: lload 7
    //   2074: lstore 11
    //   2076: aload_0
    //   2077: getfield 730	com/tencent/smtt/sdk/ab:h	Ljava/lang/String;
    //   2080: astore 25
    //   2082: goto -843 -> 1239
    //   2085: iload_3
    //   2086: istore 4
    //   2088: lload 7
    //   2090: lstore 13
    //   2092: lload 7
    //   2094: lstore 11
    //   2096: ldc -69
    //   2098: new 103	java/lang/StringBuilder
    //   2101: dup
    //   2102: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   2105: ldc_w 841
    //   2108: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2111: lload 9
    //   2113: invokevirtual 396	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2116: ldc_w 843
    //   2119: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2122: aload_0
    //   2123: getfield 537	com/tencent/smtt/sdk/ab:l	J
    //   2126: invokevirtual 396	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2129: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2132: iconst_1
    //   2133: invokestatic 737	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   2136: iload_3
    //   2137: istore 4
    //   2139: lload 7
    //   2141: lstore 13
    //   2143: lload 7
    //   2145: lstore 11
    //   2147: aload_0
    //   2148: getfield 283	com/tencent/smtt/sdk/ab:t	Ljava/net/HttpURLConnection;
    //   2151: ldc_w 817
    //   2154: new 103	java/lang/StringBuilder
    //   2157: dup
    //   2158: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   2161: ldc_w 819
    //   2164: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2167: lload 9
    //   2169: invokevirtual 396	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2172: ldc_w 821
    //   2175: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2178: aload_0
    //   2179: getfield 537	com/tencent/smtt/sdk/ab:l	J
    //   2182: invokevirtual 396	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2185: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2188: invokevirtual 300	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   2191: goto -643 -> 1548
    //   2194: astore 25
    //   2196: iload 4
    //   2198: istore 5
    //   2200: lload 13
    //   2202: lstore 11
    //   2204: aload 25
    //   2206: instanceof 845
    //   2209: ifeq +3753 -> 5962
    //   2212: iload_1
    //   2213: ifne +3749 -> 5962
    //   2216: lload 13
    //   2218: lstore 11
    //   2220: aload_0
    //   2221: getfield 79	com/tencent/smtt/sdk/ab:b	[Ljava/lang/String;
    //   2224: ifnull +3738 -> 5962
    //   2227: lload 13
    //   2229: lstore 11
    //   2231: aload_0
    //   2232: iconst_0
    //   2233: invokevirtual 847	com/tencent/smtt/sdk/ab:b	(Z)Z
    //   2236: ifeq +3726 -> 5962
    //   2239: lload 13
    //   2241: lstore 11
    //   2243: ldc -69
    //   2245: new 103	java/lang/StringBuilder
    //   2248: dup
    //   2249: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   2252: ldc_w 849
    //   2255: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2258: aload_0
    //   2259: getfield 539	com/tencent/smtt/sdk/ab:j	Ljava/lang/String;
    //   2262: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2265: ldc_w 851
    //   2268: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2271: aload 25
    //   2273: invokevirtual 322	java/lang/Throwable:toString	()Ljava/lang/String;
    //   2276: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2279: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2282: invokestatic 197	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   2285: lload 13
    //   2287: lstore 11
    //   2289: aload_0
    //   2290: bipush 125
    //   2292: aconst_null
    //   2293: iconst_1
    //   2294: invokespecial 452	com/tencent/smtt/sdk/ab:a	(ILjava/lang/String;Z)V
    //   2297: lload 13
    //   2299: lstore 11
    //   2301: aload_0
    //   2302: getfield 89	com/tencent/smtt/sdk/ab:g	Landroid/content/Context;
    //   2305: invokestatic 350	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2308: sipush 65220
    //   2311: invokevirtual 722	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   2314: iload 5
    //   2316: istore_3
    //   2317: lload 13
    //   2319: lstore 9
    //   2321: iload_1
    //   2322: ifne -1837 -> 485
    //   2325: aload_0
    //   2326: getfield 89	com/tencent/smtt/sdk/ab:g	Landroid/content/Context;
    //   2329: invokestatic 350	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2332: getfield 461	com/tencent/smtt/sdk/TbsDownloadConfig:a	Ljava/util/Map;
    //   2335: ldc_w 765
    //   2338: lload 13
    //   2340: invokestatic 792	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2343: invokeinterface 474 3 0
    //   2348: pop
    //   2349: aload_0
    //   2350: getfield 89	com/tencent/smtt/sdk/ab:g	Landroid/content/Context;
    //   2353: invokestatic 350	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2356: invokevirtual 481	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   2359: iload 5
    //   2361: istore_3
    //   2362: lload 13
    //   2364: lstore 9
    //   2366: goto -1881 -> 485
    //   2369: iconst_1
    //   2370: istore_2
    //   2371: goto -797 -> 1574
    //   2374: iload_3
    //   2375: istore 4
    //   2377: lload 7
    //   2379: lstore 13
    //   2381: lload 7
    //   2383: lstore 11
    //   2385: iload_2
    //   2386: aload_0
    //   2387: getfield 142	com/tencent/smtt/sdk/ab:x	I
    //   2390: if_icmpne +26 -> 2416
    //   2393: iload_3
    //   2394: istore 4
    //   2396: lload 7
    //   2398: lstore 13
    //   2400: lload 7
    //   2402: lstore 11
    //   2404: aload 25
    //   2406: aload_0
    //   2407: getfield 140	com/tencent/smtt/sdk/ab:w	Ljava/lang/String;
    //   2410: invokevirtual 371	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2413: ifne -713 -> 1700
    //   2416: iload_3
    //   2417: istore 4
    //   2419: lload 7
    //   2421: lstore 13
    //   2423: lload 7
    //   2425: lstore 11
    //   2427: aload_0
    //   2428: getfield 96	com/tencent/smtt/sdk/ab:v	Lcom/tencent/smtt/sdk/TbsLogReport;
    //   2431: iconst_0
    //   2432: invokevirtual 576	com/tencent/smtt/sdk/TbsLogReport:g	(I)V
    //   2435: iload_3
    //   2436: istore 4
    //   2438: lload 7
    //   2440: lstore 13
    //   2442: lload 7
    //   2444: lstore 11
    //   2446: aload_0
    //   2447: aload 25
    //   2449: putfield 140	com/tencent/smtt/sdk/ab:w	Ljava/lang/String;
    //   2452: iload_3
    //   2453: istore 4
    //   2455: lload 7
    //   2457: lstore 13
    //   2459: lload 7
    //   2461: lstore 11
    //   2463: aload_0
    //   2464: iload_2
    //   2465: putfield 142	com/tencent/smtt/sdk/ab:x	I
    //   2468: goto -768 -> 1700
    //   2471: astore 25
    //   2473: iload_1
    //   2474: ifne +37 -> 2511
    //   2477: aload_0
    //   2478: getfield 89	com/tencent/smtt/sdk/ab:g	Landroid/content/Context;
    //   2481: invokestatic 350	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2484: getfield 461	com/tencent/smtt/sdk/TbsDownloadConfig:a	Ljava/util/Map;
    //   2487: ldc_w 765
    //   2490: lload 11
    //   2492: invokestatic 792	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2495: invokeinterface 474 3 0
    //   2500: pop
    //   2501: aload_0
    //   2502: getfield 89	com/tencent/smtt/sdk/ab:g	Landroid/content/Context;
    //   2505: invokestatic 350	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2508: invokevirtual 481	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   2511: aload 25
    //   2513: athrow
    //   2514: iload_2
    //   2515: sipush 200
    //   2518: if_icmpeq +10 -> 2528
    //   2521: iload_2
    //   2522: sipush 206
    //   2525: if_icmpne +2250 -> 4775
    //   2528: iload_3
    //   2529: istore 4
    //   2531: lload 7
    //   2533: lstore 13
    //   2535: lload 7
    //   2537: lstore 11
    //   2539: aload_0
    //   2540: aload_0
    //   2541: getfield 283	com/tencent/smtt/sdk/ab:t	Ljava/net/HttpURLConnection;
    //   2544: invokevirtual 854	java/net/HttpURLConnection:getContentLength	()I
    //   2547: i2l
    //   2548: lload 9
    //   2550: ladd
    //   2551: putfield 537	com/tencent/smtt/sdk/ab:l	J
    //   2554: iload_3
    //   2555: istore 4
    //   2557: lload 7
    //   2559: lstore 13
    //   2561: lload 7
    //   2563: lstore 11
    //   2565: ldc -69
    //   2567: new 103	java/lang/StringBuilder
    //   2570: dup
    //   2571: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   2574: ldc_w 856
    //   2577: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2580: aload_0
    //   2581: getfield 537	com/tencent/smtt/sdk/ab:l	J
    //   2584: invokevirtual 396	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2587: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2590: invokestatic 340	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   2593: iload_3
    //   2594: istore 4
    //   2596: lload 7
    //   2598: lstore 13
    //   2600: lload 7
    //   2602: lstore 11
    //   2604: aload_0
    //   2605: getfield 96	com/tencent/smtt/sdk/ab:v	Lcom/tencent/smtt/sdk/TbsLogReport;
    //   2608: aload_0
    //   2609: getfield 537	com/tencent/smtt/sdk/ab:l	J
    //   2612: invokevirtual 858	com/tencent/smtt/sdk/TbsLogReport:b	(J)V
    //   2615: iload_3
    //   2616: istore 4
    //   2618: lload 7
    //   2620: lstore 13
    //   2622: lload 7
    //   2624: lstore 11
    //   2626: aload_0
    //   2627: getfield 89	com/tencent/smtt/sdk/ab:g	Landroid/content/Context;
    //   2630: invokestatic 350	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2633: getfield 354	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   2636: ldc_w 383
    //   2639: lconst_0
    //   2640: invokeinterface 387 4 0
    //   2645: lstore 15
    //   2647: lload 15
    //   2649: lconst_0
    //   2650: lcmp
    //   2651: ifeq +396 -> 3047
    //   2654: iload_3
    //   2655: istore 4
    //   2657: lload 7
    //   2659: lstore 13
    //   2661: lload 7
    //   2663: lstore 11
    //   2665: aload_0
    //   2666: getfield 537	com/tencent/smtt/sdk/ab:l	J
    //   2669: lload 15
    //   2671: lcmp
    //   2672: ifeq +375 -> 3047
    //   2675: iload_3
    //   2676: istore 4
    //   2678: lload 7
    //   2680: lstore 13
    //   2682: lload 7
    //   2684: lstore 11
    //   2686: ldc -69
    //   2688: new 103	java/lang/StringBuilder
    //   2691: dup
    //   2692: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   2695: ldc_w 860
    //   2698: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2701: lload 15
    //   2703: invokevirtual 396	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2706: ldc_w 862
    //   2709: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2712: aload_0
    //   2713: getfield 537	com/tencent/smtt/sdk/ab:l	J
    //   2716: invokevirtual 396	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2719: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2722: iconst_1
    //   2723: invokestatic 737	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   2726: iload_1
    //   2727: ifne +272 -> 2999
    //   2730: iload_3
    //   2731: istore 4
    //   2733: lload 7
    //   2735: lstore 13
    //   2737: lload 7
    //   2739: lstore 11
    //   2741: aload_0
    //   2742: invokespecial 330	com/tencent/smtt/sdk/ab:n	()Z
    //   2745: ifne +41 -> 2786
    //   2748: iload_3
    //   2749: istore 4
    //   2751: lload 7
    //   2753: lstore 13
    //   2755: lload 7
    //   2757: lstore 11
    //   2759: invokestatic 835	com/tencent/smtt/sdk/QbSdk:getDownloadWithoutWifi	()Z
    //   2762: ifeq +237 -> 2999
    //   2765: iload_3
    //   2766: istore 4
    //   2768: lload 7
    //   2770: lstore 13
    //   2772: lload 7
    //   2774: lstore 11
    //   2776: aload_0
    //   2777: getfield 89	com/tencent/smtt/sdk/ab:g	Landroid/content/Context;
    //   2780: invokestatic 581	com/tencent/smtt/utils/Apn:isNetworkAvailable	(Landroid/content/Context;)Z
    //   2783: ifeq +216 -> 2999
    //   2786: iload_3
    //   2787: istore 4
    //   2789: lload 7
    //   2791: lstore 13
    //   2793: lload 7
    //   2795: lstore 11
    //   2797: aload_0
    //   2798: getfield 79	com/tencent/smtt/sdk/ab:b	[Ljava/lang/String;
    //   2801: ifnull +75 -> 2876
    //   2804: iload_3
    //   2805: istore 4
    //   2807: lload 7
    //   2809: lstore 13
    //   2811: lload 7
    //   2813: lstore 11
    //   2815: aload_0
    //   2816: iconst_0
    //   2817: invokevirtual 847	com/tencent/smtt/sdk/ab:b	(Z)Z
    //   2820: istore 5
    //   2822: iload 5
    //   2824: ifeq +52 -> 2876
    //   2827: lload 7
    //   2829: lstore 9
    //   2831: iload_1
    //   2832: ifne -2347 -> 485
    //   2835: aload_0
    //   2836: getfield 89	com/tencent/smtt/sdk/ab:g	Landroid/content/Context;
    //   2839: invokestatic 350	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2842: getfield 461	com/tencent/smtt/sdk/TbsDownloadConfig:a	Ljava/util/Map;
    //   2845: ldc_w 765
    //   2848: lload 7
    //   2850: invokestatic 792	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2853: invokeinterface 474 3 0
    //   2858: pop
    //   2859: aload_0
    //   2860: getfield 89	com/tencent/smtt/sdk/ab:g	Landroid/content/Context;
    //   2863: invokestatic 350	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2866: invokevirtual 481	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   2869: lload 7
    //   2871: lstore 9
    //   2873: goto -2388 -> 485
    //   2876: iload_3
    //   2877: istore 4
    //   2879: lload 7
    //   2881: lstore 13
    //   2883: lload 7
    //   2885: lstore 11
    //   2887: aload_0
    //   2888: bipush 113
    //   2890: new 103	java/lang/StringBuilder
    //   2893: dup
    //   2894: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   2897: ldc_w 864
    //   2900: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2903: lload 15
    //   2905: invokevirtual 396	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2908: ldc_w 862
    //   2911: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2914: aload_0
    //   2915: getfield 537	com/tencent/smtt/sdk/ab:l	J
    //   2918: invokevirtual 396	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2921: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2924: iconst_1
    //   2925: invokespecial 452	com/tencent/smtt/sdk/ab:a	(ILjava/lang/String;Z)V
    //   2928: iload_3
    //   2929: istore 4
    //   2931: lload 7
    //   2933: lstore 13
    //   2935: lload 7
    //   2937: lstore 11
    //   2939: aload_0
    //   2940: getfield 89	com/tencent/smtt/sdk/ab:g	Landroid/content/Context;
    //   2943: invokestatic 350	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2946: sipush 65226
    //   2949: invokevirtual 722	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   2952: iload_3
    //   2953: istore 4
    //   2955: iload_1
    //   2956: ifne -2457 -> 499
    //   2959: aload_0
    //   2960: getfield 89	com/tencent/smtt/sdk/ab:g	Landroid/content/Context;
    //   2963: invokestatic 350	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2966: getfield 461	com/tencent/smtt/sdk/TbsDownloadConfig:a	Ljava/util/Map;
    //   2969: ldc_w 765
    //   2972: lload 7
    //   2974: invokestatic 792	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2977: invokeinterface 474 3 0
    //   2982: pop
    //   2983: aload_0
    //   2984: getfield 89	com/tencent/smtt/sdk/ab:g	Landroid/content/Context;
    //   2987: invokestatic 350	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2990: invokevirtual 481	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   2993: iload_3
    //   2994: istore 4
    //   2996: goto -2497 -> 499
    //   2999: iload_3
    //   3000: istore 4
    //   3002: lload 7
    //   3004: lstore 13
    //   3006: lload 7
    //   3008: lstore 11
    //   3010: aload_0
    //   3011: bipush 101
    //   3013: ldc_w 866
    //   3016: iconst_1
    //   3017: invokespecial 452	com/tencent/smtt/sdk/ab:a	(ILjava/lang/String;Z)V
    //   3020: iload_3
    //   3021: istore 4
    //   3023: lload 7
    //   3025: lstore 13
    //   3027: lload 7
    //   3029: lstore 11
    //   3031: aload_0
    //   3032: getfield 89	com/tencent/smtt/sdk/ab:g	Landroid/content/Context;
    //   3035: invokestatic 350	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   3038: sipush 65232
    //   3041: invokevirtual 722	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   3044: goto -92 -> 2952
    //   3047: aconst_null
    //   3048: astore 29
    //   3050: aconst_null
    //   3051: astore 25
    //   3053: aconst_null
    //   3054: astore 27
    //   3056: iload_3
    //   3057: istore 4
    //   3059: lload 7
    //   3061: lstore 13
    //   3063: lload 7
    //   3065: lstore 11
    //   3067: ldc -69
    //   3069: ldc_w 868
    //   3072: invokestatic 340	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   3075: aload_0
    //   3076: getfield 283	com/tencent/smtt/sdk/ab:t	Ljava/net/HttpURLConnection;
    //   3079: invokevirtual 668	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   3082: astore 26
    //   3084: aload 26
    //   3086: ifnull +3334 -> 6420
    //   3089: aload_0
    //   3090: getfield 283	com/tencent/smtt/sdk/ab:t	Ljava/net/HttpURLConnection;
    //   3093: invokevirtual 871	java/net/HttpURLConnection:getContentEncoding	()Ljava/lang/String;
    //   3096: astore 25
    //   3098: aload 25
    //   3100: ifnull +240 -> 3340
    //   3103: aload 25
    //   3105: ldc_w 873
    //   3108: invokevirtual 644	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   3111: ifeq +229 -> 3340
    //   3114: new 875	java/util/zip/GZIPInputStream
    //   3117: dup
    //   3118: aload 26
    //   3120: invokespecial 876	java/util/zip/GZIPInputStream:<init>	(Ljava/io/InputStream;)V
    //   3123: astore 25
    //   3125: sipush 8192
    //   3128: newarray <illegal type>
    //   3130: astore 27
    //   3132: new 878	java/io/FileOutputStream
    //   3135: dup
    //   3136: new 166	java/io/File
    //   3139: dup
    //   3140: aload_0
    //   3141: getfield 129	com/tencent/smtt/sdk/ab:k	Ljava/io/File;
    //   3144: ldc_w 344
    //   3147: invokespecial 210	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   3150: iconst_1
    //   3151: invokespecial 881	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   3154: astore 28
    //   3156: invokestatic 149	java/lang/System:currentTimeMillis	()J
    //   3159: lstore 13
    //   3161: lload 9
    //   3163: lstore 19
    //   3165: lload 9
    //   3167: lstore 11
    //   3169: lload 7
    //   3171: lstore 15
    //   3173: lload 7
    //   3175: lstore 17
    //   3177: aload_0
    //   3178: getfield 543	com/tencent/smtt/sdk/ab:r	Z
    //   3181: ifeq +376 -> 3557
    //   3184: lload 7
    //   3186: lstore 15
    //   3188: lload 7
    //   3190: lstore 17
    //   3192: ldc -69
    //   3194: ldc_w 883
    //   3197: iconst_1
    //   3198: invokestatic 737	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   3201: lload 7
    //   3203: lstore 15
    //   3205: lload 7
    //   3207: lstore 17
    //   3209: aload_0
    //   3210: getfield 89	com/tencent/smtt/sdk/ab:g	Landroid/content/Context;
    //   3213: invokestatic 350	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   3216: sipush 65227
    //   3219: invokevirtual 722	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   3222: iconst_0
    //   3223: istore_2
    //   3224: iload_3
    //   3225: istore 5
    //   3227: iload_2
    //   3228: ifeq +1010 -> 4238
    //   3231: iload 5
    //   3233: istore 4
    //   3235: lload 7
    //   3237: lstore 13
    //   3239: lload 7
    //   3241: lstore 11
    //   3243: aload_0
    //   3244: aload 28
    //   3246: invokespecial 648	com/tencent/smtt/sdk/ab:a	(Ljava/io/Closeable;)V
    //   3249: iload 5
    //   3251: istore 4
    //   3253: lload 7
    //   3255: lstore 13
    //   3257: lload 7
    //   3259: lstore 11
    //   3261: aload_0
    //   3262: aload 25
    //   3264: invokespecial 648	com/tencent/smtt/sdk/ab:a	(Ljava/io/Closeable;)V
    //   3267: iload 5
    //   3269: istore 4
    //   3271: lload 7
    //   3273: lstore 13
    //   3275: lload 7
    //   3277: lstore 11
    //   3279: aload_0
    //   3280: aload 26
    //   3282: invokespecial 648	com/tencent/smtt/sdk/ab:a	(Ljava/io/Closeable;)V
    //   3285: iload 5
    //   3287: istore_3
    //   3288: lload 7
    //   3290: lstore 9
    //   3292: iload_1
    //   3293: ifne -2808 -> 485
    //   3296: aload_0
    //   3297: getfield 89	com/tencent/smtt/sdk/ab:g	Landroid/content/Context;
    //   3300: invokestatic 350	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   3303: getfield 461	com/tencent/smtt/sdk/TbsDownloadConfig:a	Ljava/util/Map;
    //   3306: ldc_w 765
    //   3309: lload 7
    //   3311: invokestatic 792	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   3314: invokeinterface 474 3 0
    //   3319: pop
    //   3320: aload_0
    //   3321: getfield 89	com/tencent/smtt/sdk/ab:g	Landroid/content/Context;
    //   3324: invokestatic 350	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   3327: invokevirtual 481	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   3330: iload 5
    //   3332: istore_3
    //   3333: lload 7
    //   3335: lstore 9
    //   3337: goto -2852 -> 485
    //   3340: aload 25
    //   3342: ifnull +208 -> 3550
    //   3345: aload 25
    //   3347: ldc_w 885
    //   3350: invokevirtual 644	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   3353: ifeq +197 -> 3550
    //   3356: new 887	java/util/zip/InflaterInputStream
    //   3359: dup
    //   3360: aload 26
    //   3362: new 889	java/util/zip/Inflater
    //   3365: dup
    //   3366: iconst_1
    //   3367: invokespecial 891	java/util/zip/Inflater:<init>	(Z)V
    //   3370: invokespecial 894	java/util/zip/InflaterInputStream:<init>	(Ljava/io/InputStream;Ljava/util/zip/Inflater;)V
    //   3373: astore 25
    //   3375: goto -250 -> 3125
    //   3378: astore 30
    //   3380: aload 26
    //   3382: astore 25
    //   3384: aload 29
    //   3386: astore 28
    //   3388: aload 30
    //   3390: astore 26
    //   3392: iload_3
    //   3393: istore 5
    //   3395: aload 26
    //   3397: invokevirtual 895	java/io/IOException:printStackTrace	()V
    //   3400: aload 26
    //   3402: instanceof 897
    //   3405: ifne +11 -> 3416
    //   3408: aload 26
    //   3410: instanceof 899
    //   3413: ifeq +968 -> 4381
    //   3416: aload_0
    //   3417: ldc_w 900
    //   3420: putfield 73	com/tencent/smtt/sdk/ab:m	I
    //   3423: aload_0
    //   3424: lconst_0
    //   3425: invokespecial 901	com/tencent/smtt/sdk/ab:a	(J)V
    //   3428: aload_0
    //   3429: bipush 103
    //   3431: aload_0
    //   3432: aload 26
    //   3434: invokespecial 450	com/tencent/smtt/sdk/ab:a	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   3437: iconst_0
    //   3438: invokespecial 452	com/tencent/smtt/sdk/ab:a	(ILjava/lang/String;Z)V
    //   3441: iload 5
    //   3443: istore 4
    //   3445: lload 7
    //   3447: lstore 13
    //   3449: lload 7
    //   3451: lstore 11
    //   3453: aload_0
    //   3454: aload 28
    //   3456: invokespecial 648	com/tencent/smtt/sdk/ab:a	(Ljava/io/Closeable;)V
    //   3459: iload 5
    //   3461: istore 4
    //   3463: lload 7
    //   3465: lstore 13
    //   3467: lload 7
    //   3469: lstore 11
    //   3471: aload_0
    //   3472: aload 27
    //   3474: invokespecial 648	com/tencent/smtt/sdk/ab:a	(Ljava/io/Closeable;)V
    //   3477: iload 5
    //   3479: istore 4
    //   3481: lload 7
    //   3483: lstore 13
    //   3485: lload 7
    //   3487: lstore 11
    //   3489: aload_0
    //   3490: aload 25
    //   3492: invokespecial 648	com/tencent/smtt/sdk/ab:a	(Ljava/io/Closeable;)V
    //   3495: iload 5
    //   3497: istore_3
    //   3498: lload 7
    //   3500: lstore 9
    //   3502: iload_1
    //   3503: ifne -3018 -> 485
    //   3506: aload_0
    //   3507: getfield 89	com/tencent/smtt/sdk/ab:g	Landroid/content/Context;
    //   3510: invokestatic 350	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   3513: getfield 461	com/tencent/smtt/sdk/TbsDownloadConfig:a	Ljava/util/Map;
    //   3516: ldc_w 765
    //   3519: lload 7
    //   3521: invokestatic 792	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   3524: invokeinterface 474 3 0
    //   3529: pop
    //   3530: aload_0
    //   3531: getfield 89	com/tencent/smtt/sdk/ab:g	Landroid/content/Context;
    //   3534: invokestatic 350	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   3537: invokevirtual 481	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   3540: iload 5
    //   3542: istore_3
    //   3543: lload 7
    //   3545: lstore 9
    //   3547: goto -3062 -> 485
    //   3550: aload 26
    //   3552: astore 25
    //   3554: goto -429 -> 3125
    //   3557: lload 7
    //   3559: lstore 15
    //   3561: lload 7
    //   3563: lstore 17
    //   3565: aload 25
    //   3567: aload 27
    //   3569: iconst_0
    //   3570: sipush 8192
    //   3573: invokevirtual 907	java/io/InputStream:read	([BII)I
    //   3576: istore_2
    //   3577: iload_2
    //   3578: ifgt +140 -> 3718
    //   3581: lload 7
    //   3583: lstore 15
    //   3585: lload 7
    //   3587: lstore 17
    //   3589: aload_0
    //   3590: getfield 79	com/tencent/smtt/sdk/ab:b	[Ljava/lang/String;
    //   3593: ifnull +70 -> 3663
    //   3596: lload 7
    //   3598: lstore 15
    //   3600: lload 7
    //   3602: lstore 17
    //   3604: aload_0
    //   3605: iconst_1
    //   3606: iload 6
    //   3608: invokespecial 767	com/tencent/smtt/sdk/ab:b	(ZZ)Z
    //   3611: ifne +52 -> 3663
    //   3614: iload_1
    //   3615: ifne +27 -> 3642
    //   3618: lload 7
    //   3620: lstore 15
    //   3622: lload 7
    //   3624: lstore 17
    //   3626: aload_0
    //   3627: iconst_0
    //   3628: invokevirtual 847	com/tencent/smtt/sdk/ab:b	(Z)Z
    //   3631: ifeq +11 -> 3642
    //   3634: iconst_1
    //   3635: istore_2
    //   3636: iload_3
    //   3637: istore 5
    //   3639: goto -412 -> 3227
    //   3642: lload 7
    //   3644: lstore 15
    //   3646: lload 7
    //   3648: lstore 17
    //   3650: aload_0
    //   3651: iconst_1
    //   3652: putfield 545	com/tencent/smtt/sdk/ab:s	Z
    //   3655: iconst_0
    //   3656: istore 5
    //   3658: iconst_0
    //   3659: istore_2
    //   3660: goto -433 -> 3227
    //   3663: lload 7
    //   3665: lstore 15
    //   3667: lload 7
    //   3669: lstore 17
    //   3671: aload_0
    //   3672: iconst_1
    //   3673: putfield 545	com/tencent/smtt/sdk/ab:s	Z
    //   3676: lload 7
    //   3678: lstore 15
    //   3680: lload 7
    //   3682: lstore 17
    //   3684: aload_0
    //   3685: getfield 79	com/tencent/smtt/sdk/ab:b	[Ljava/lang/String;
    //   3688: astore 27
    //   3690: aload 27
    //   3692: ifnull +2725 -> 6417
    //   3695: iconst_1
    //   3696: istore_3
    //   3697: aload_0
    //   3698: getfield 89	com/tencent/smtt/sdk/ab:g	Landroid/content/Context;
    //   3701: invokestatic 350	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   3704: sipush 65225
    //   3707: invokevirtual 722	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   3710: iconst_0
    //   3711: istore_2
    //   3712: iload_3
    //   3713: istore 5
    //   3715: goto -488 -> 3227
    //   3718: lload 7
    //   3720: lstore 15
    //   3722: lload 7
    //   3724: lstore 17
    //   3726: aload 28
    //   3728: aload 27
    //   3730: iconst_0
    //   3731: iload_2
    //   3732: invokevirtual 911	java/io/FileOutputStream:write	([BII)V
    //   3735: lload 7
    //   3737: lstore 15
    //   3739: lload 7
    //   3741: lstore 17
    //   3743: aload 28
    //   3745: invokevirtual 914	java/io/FileOutputStream:flush	()V
    //   3748: lload 7
    //   3750: lstore 9
    //   3752: iload_1
    //   3753: ifne +235 -> 3988
    //   3756: lload 7
    //   3758: iload_2
    //   3759: i2l
    //   3760: ladd
    //   3761: lstore 7
    //   3763: lload 7
    //   3765: lload 23
    //   3767: lcmp
    //   3768: iflt +96 -> 3864
    //   3771: lload 7
    //   3773: lstore 15
    //   3775: lload 7
    //   3777: lstore 17
    //   3779: ldc -69
    //   3781: ldc_w 800
    //   3784: iconst_1
    //   3785: invokestatic 737	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   3788: lload 7
    //   3790: lstore 15
    //   3792: lload 7
    //   3794: lstore 17
    //   3796: aload_0
    //   3797: bipush 112
    //   3799: new 103	java/lang/StringBuilder
    //   3802: dup
    //   3803: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   3806: ldc_w 916
    //   3809: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3812: lload 7
    //   3814: invokevirtual 396	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3817: ldc_w 918
    //   3820: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3823: lload 23
    //   3825: invokevirtual 396	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3828: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3831: iconst_1
    //   3832: invokespecial 452	com/tencent/smtt/sdk/ab:a	(ILjava/lang/String;Z)V
    //   3835: lload 7
    //   3837: lstore 15
    //   3839: lload 7
    //   3841: lstore 17
    //   3843: aload_0
    //   3844: getfield 89	com/tencent/smtt/sdk/ab:g	Landroid/content/Context;
    //   3847: invokestatic 350	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   3850: sipush 65229
    //   3853: invokevirtual 722	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   3856: iconst_0
    //   3857: istore_2
    //   3858: iload_3
    //   3859: istore 5
    //   3861: goto -634 -> 3227
    //   3864: lload 7
    //   3866: lstore 9
    //   3868: lload 7
    //   3870: lstore 15
    //   3872: lload 7
    //   3874: lstore 17
    //   3876: aload_0
    //   3877: getfield 89	com/tencent/smtt/sdk/ab:g	Landroid/content/Context;
    //   3880: invokestatic 794	com/tencent/smtt/utils/j:b	(Landroid/content/Context;)Z
    //   3883: ifne +105 -> 3988
    //   3886: lload 7
    //   3888: lstore 15
    //   3890: lload 7
    //   3892: lstore 17
    //   3894: ldc -69
    //   3896: ldc_w 920
    //   3899: iconst_1
    //   3900: invokestatic 737	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   3903: lload 7
    //   3905: lstore 15
    //   3907: lload 7
    //   3909: lstore 17
    //   3911: aload_0
    //   3912: bipush 105
    //   3914: new 103	java/lang/StringBuilder
    //   3917: dup
    //   3918: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   3921: ldc_w 922
    //   3924: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3927: invokestatic 924	com/tencent/smtt/utils/z:a	()J
    //   3930: invokevirtual 396	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3933: ldc_w 926
    //   3936: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3939: aload_0
    //   3940: getfield 89	com/tencent/smtt/sdk/ab:g	Landroid/content/Context;
    //   3943: invokestatic 350	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   3946: invokevirtual 929	com/tencent/smtt/sdk/TbsDownloadConfig:getDownloadMinFreeSpace	()J
    //   3949: invokevirtual 396	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3952: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3955: iconst_1
    //   3956: invokespecial 452	com/tencent/smtt/sdk/ab:a	(ILjava/lang/String;Z)V
    //   3959: lload 7
    //   3961: lstore 15
    //   3963: lload 7
    //   3965: lstore 17
    //   3967: aload_0
    //   3968: getfield 89	com/tencent/smtt/sdk/ab:g	Landroid/content/Context;
    //   3971: invokestatic 350	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   3974: sipush 65228
    //   3977: invokevirtual 722	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   3980: iconst_0
    //   3981: istore_2
    //   3982: iload_3
    //   3983: istore 5
    //   3985: goto -758 -> 3227
    //   3988: iload_2
    //   3989: i2l
    //   3990: lstore 7
    //   3992: aload_0
    //   3993: lload 21
    //   3995: lload 7
    //   3997: invokespecial 931	com/tencent/smtt/sdk/ab:a	(JJ)J
    //   4000: lstore 21
    //   4002: invokestatic 149	java/lang/System:currentTimeMillis	()J
    //   4005: lstore 17
    //   4007: iload_2
    //   4008: i2l
    //   4009: lload 19
    //   4011: ladd
    //   4012: lstore 15
    //   4014: lload 17
    //   4016: lload 13
    //   4018: lsub
    //   4019: ldc2_w 932
    //   4022: lcmp
    //   4023: ifle +2383 -> 6406
    //   4026: ldc -69
    //   4028: new 103	java/lang/StringBuilder
    //   4031: dup
    //   4032: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   4035: ldc_w 935
    //   4038: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4041: lload 15
    //   4043: invokevirtual 396	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4046: ldc_w 843
    //   4049: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4052: aload_0
    //   4053: getfield 537	com/tencent/smtt/sdk/ab:l	J
    //   4056: invokevirtual 396	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4059: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4062: iconst_1
    //   4063: invokestatic 737	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   4066: getstatic 486	com/tencent/smtt/sdk/QbSdk:j	Lcom/tencent/smtt/sdk/TbsListener;
    //   4069: ifnull +27 -> 4096
    //   4072: lload 15
    //   4074: l2d
    //   4075: aload_0
    //   4076: getfield 537	com/tencent/smtt/sdk/ab:l	J
    //   4079: l2d
    //   4080: ddiv
    //   4081: ldc2_w 936
    //   4084: dmul
    //   4085: d2i
    //   4086: istore_2
    //   4087: getstatic 486	com/tencent/smtt/sdk/QbSdk:j	Lcom/tencent/smtt/sdk/TbsListener;
    //   4090: iload_2
    //   4091: invokeinterface 940 2 0
    //   4096: lload 11
    //   4098: lstore 7
    //   4100: iload_1
    //   4101: ifne +114 -> 4215
    //   4104: lload 11
    //   4106: lstore 7
    //   4108: lload 15
    //   4110: lload 11
    //   4112: lsub
    //   4113: ldc2_w 941
    //   4116: lcmp
    //   4117: ifle +98 -> 4215
    //   4120: aload_0
    //   4121: getfield 89	com/tencent/smtt/sdk/ab:g	Landroid/content/Context;
    //   4124: invokestatic 205	com/tencent/smtt/sdk/TbsDownloader:getOverSea	(Landroid/content/Context;)Z
    //   4127: ifne +84 -> 4211
    //   4130: aload_0
    //   4131: getfield 89	com/tencent/smtt/sdk/ab:g	Landroid/content/Context;
    //   4134: invokestatic 570	com/tencent/smtt/utils/Apn:getApnType	(Landroid/content/Context;)I
    //   4137: iconst_3
    //   4138: if_icmpeq +9 -> 4147
    //   4141: invokestatic 835	com/tencent/smtt/sdk/QbSdk:getDownloadWithoutWifi	()Z
    //   4144: ifeq +13 -> 4157
    //   4147: aload_0
    //   4148: getfield 89	com/tencent/smtt/sdk/ab:g	Landroid/content/Context;
    //   4151: invokestatic 570	com/tencent/smtt/utils/Apn:getApnType	(Landroid/content/Context;)I
    //   4154: ifne +57 -> 4211
    //   4157: aload_0
    //   4158: invokevirtual 837	com/tencent/smtt/sdk/ab:b	()V
    //   4161: getstatic 486	com/tencent/smtt/sdk/QbSdk:j	Lcom/tencent/smtt/sdk/TbsListener;
    //   4164: ifnull +13 -> 4177
    //   4167: getstatic 486	com/tencent/smtt/sdk/QbSdk:j	Lcom/tencent/smtt/sdk/TbsListener;
    //   4170: bipush 111
    //   4172: invokeinterface 491 2 0
    //   4177: ldc -69
    //   4179: ldc_w 944
    //   4182: iconst_0
    //   4183: invokestatic 737	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   4186: aload_0
    //   4187: getfield 89	com/tencent/smtt/sdk/ab:g	Landroid/content/Context;
    //   4190: invokestatic 350	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   4193: sipush 65232
    //   4196: invokevirtual 722	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   4199: iconst_0
    //   4200: istore_2
    //   4201: lload 9
    //   4203: lstore 7
    //   4205: iload_3
    //   4206: istore 5
    //   4208: goto -981 -> 3227
    //   4211: lload 15
    //   4213: lstore 7
    //   4215: lload 17
    //   4217: lstore 11
    //   4219: lload 11
    //   4221: lstore 13
    //   4223: lload 7
    //   4225: lstore 11
    //   4227: lload 9
    //   4229: lstore 7
    //   4231: lload 15
    //   4233: lstore 19
    //   4235: goto -1066 -> 3169
    //   4238: iload 5
    //   4240: istore_3
    //   4241: lload 7
    //   4243: lstore 9
    //   4245: iload_3
    //   4246: istore 5
    //   4248: lload 7
    //   4250: lstore 11
    //   4252: aload_0
    //   4253: aload 28
    //   4255: invokespecial 648	com/tencent/smtt/sdk/ab:a	(Ljava/io/Closeable;)V
    //   4258: lload 7
    //   4260: lstore 9
    //   4262: iload_3
    //   4263: istore 5
    //   4265: lload 7
    //   4267: lstore 11
    //   4269: aload_0
    //   4270: aload 25
    //   4272: invokespecial 648	com/tencent/smtt/sdk/ab:a	(Ljava/io/Closeable;)V
    //   4275: lload 7
    //   4277: lstore 9
    //   4279: iload_3
    //   4280: istore 5
    //   4282: lload 7
    //   4284: lstore 11
    //   4286: aload_0
    //   4287: aload 26
    //   4289: invokespecial 648	com/tencent/smtt/sdk/ab:a	(Ljava/io/Closeable;)V
    //   4292: lload 7
    //   4294: lstore 9
    //   4296: iload_3
    //   4297: istore 5
    //   4299: lload 7
    //   4301: lstore 11
    //   4303: aload_0
    //   4304: getfield 545	com/tencent/smtt/sdk/ab:s	Z
    //   4307: ifne +27 -> 4334
    //   4310: lload 7
    //   4312: lstore 9
    //   4314: iload_3
    //   4315: istore 5
    //   4317: lload 7
    //   4319: lstore 11
    //   4321: aload_0
    //   4322: getfield 89	com/tencent/smtt/sdk/ab:g	Landroid/content/Context;
    //   4325: invokestatic 350	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   4328: sipush 65217
    //   4331: invokevirtual 722	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   4334: iload_3
    //   4335: istore 4
    //   4337: iload_1
    //   4338: ifne -3839 -> 499
    //   4341: aload_0
    //   4342: getfield 89	com/tencent/smtt/sdk/ab:g	Landroid/content/Context;
    //   4345: invokestatic 350	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   4348: getfield 461	com/tencent/smtt/sdk/TbsDownloadConfig:a	Ljava/util/Map;
    //   4351: ldc_w 765
    //   4354: lload 7
    //   4356: invokestatic 792	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   4359: invokeinterface 474 3 0
    //   4364: pop
    //   4365: aload_0
    //   4366: getfield 89	com/tencent/smtt/sdk/ab:g	Landroid/content/Context;
    //   4369: invokestatic 350	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   4372: invokevirtual 481	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   4375: iload_3
    //   4376: istore 4
    //   4378: goto -3879 -> 499
    //   4381: iload_1
    //   4382: ifne +177 -> 4559
    //   4385: aload_0
    //   4386: getfield 89	com/tencent/smtt/sdk/ab:g	Landroid/content/Context;
    //   4389: invokestatic 794	com/tencent/smtt/utils/j:b	(Landroid/content/Context;)Z
    //   4392: ifne +167 -> 4559
    //   4395: aload_0
    //   4396: bipush 105
    //   4398: new 103	java/lang/StringBuilder
    //   4401: dup
    //   4402: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   4405: ldc_w 922
    //   4408: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4411: invokestatic 924	com/tencent/smtt/utils/z:a	()J
    //   4414: invokevirtual 396	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4417: ldc_w 926
    //   4420: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4423: aload_0
    //   4424: getfield 89	com/tencent/smtt/sdk/ab:g	Landroid/content/Context;
    //   4427: invokestatic 350	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   4430: invokevirtual 929	com/tencent/smtt/sdk/TbsDownloadConfig:getDownloadMinFreeSpace	()J
    //   4433: invokevirtual 396	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4436: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4439: iconst_1
    //   4440: invokespecial 452	com/tencent/smtt/sdk/ab:a	(ILjava/lang/String;Z)V
    //   4443: aload_0
    //   4444: getfield 89	com/tencent/smtt/sdk/ab:g	Landroid/content/Context;
    //   4447: invokestatic 350	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   4450: sipush 65228
    //   4453: invokevirtual 722	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   4456: iload 5
    //   4458: istore 4
    //   4460: lload 7
    //   4462: lstore 13
    //   4464: lload 7
    //   4466: lstore 11
    //   4468: aload_0
    //   4469: aload 28
    //   4471: invokespecial 648	com/tencent/smtt/sdk/ab:a	(Ljava/io/Closeable;)V
    //   4474: iload 5
    //   4476: istore 4
    //   4478: lload 7
    //   4480: lstore 13
    //   4482: lload 7
    //   4484: lstore 11
    //   4486: aload_0
    //   4487: aload 27
    //   4489: invokespecial 648	com/tencent/smtt/sdk/ab:a	(Ljava/io/Closeable;)V
    //   4492: iload 5
    //   4494: istore 4
    //   4496: lload 7
    //   4498: lstore 13
    //   4500: lload 7
    //   4502: lstore 11
    //   4504: aload_0
    //   4505: aload 25
    //   4507: invokespecial 648	com/tencent/smtt/sdk/ab:a	(Ljava/io/Closeable;)V
    //   4510: iload 5
    //   4512: istore 4
    //   4514: iload_1
    //   4515: ifne -4016 -> 499
    //   4518: aload_0
    //   4519: getfield 89	com/tencent/smtt/sdk/ab:g	Landroid/content/Context;
    //   4522: invokestatic 350	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   4525: getfield 461	com/tencent/smtt/sdk/TbsDownloadConfig:a	Ljava/util/Map;
    //   4528: ldc_w 765
    //   4531: lload 7
    //   4533: invokestatic 792	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   4536: invokeinterface 474 3 0
    //   4541: pop
    //   4542: aload_0
    //   4543: getfield 89	com/tencent/smtt/sdk/ab:g	Landroid/content/Context;
    //   4546: invokestatic 350	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   4549: invokevirtual 481	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   4552: iload 5
    //   4554: istore 4
    //   4556: goto -4057 -> 499
    //   4559: aload_0
    //   4560: lconst_0
    //   4561: invokespecial 901	com/tencent/smtt/sdk/ab:a	(J)V
    //   4564: aload_0
    //   4565: invokespecial 946	com/tencent/smtt/sdk/ab:j	()Z
    //   4568: ifne +125 -> 4693
    //   4571: aload_0
    //   4572: bipush 106
    //   4574: aload_0
    //   4575: aload 26
    //   4577: invokespecial 450	com/tencent/smtt/sdk/ab:a	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   4580: iconst_0
    //   4581: invokespecial 452	com/tencent/smtt/sdk/ab:a	(ILjava/lang/String;Z)V
    //   4584: iload 5
    //   4586: istore 4
    //   4588: lload 7
    //   4590: lstore 13
    //   4592: lload 7
    //   4594: lstore 11
    //   4596: aload_0
    //   4597: aload 28
    //   4599: invokespecial 648	com/tencent/smtt/sdk/ab:a	(Ljava/io/Closeable;)V
    //   4602: iload 5
    //   4604: istore 4
    //   4606: lload 7
    //   4608: lstore 13
    //   4610: lload 7
    //   4612: lstore 11
    //   4614: aload_0
    //   4615: aload 27
    //   4617: invokespecial 648	com/tencent/smtt/sdk/ab:a	(Ljava/io/Closeable;)V
    //   4620: iload 5
    //   4622: istore 4
    //   4624: lload 7
    //   4626: lstore 13
    //   4628: lload 7
    //   4630: lstore 11
    //   4632: aload_0
    //   4633: aload 25
    //   4635: invokespecial 648	com/tencent/smtt/sdk/ab:a	(Ljava/io/Closeable;)V
    //   4638: iload 5
    //   4640: istore_3
    //   4641: lload 7
    //   4643: lstore 9
    //   4645: iload_1
    //   4646: ifne -4161 -> 485
    //   4649: aload_0
    //   4650: getfield 89	com/tencent/smtt/sdk/ab:g	Landroid/content/Context;
    //   4653: invokestatic 350	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   4656: getfield 461	com/tencent/smtt/sdk/TbsDownloadConfig:a	Ljava/util/Map;
    //   4659: ldc_w 765
    //   4662: lload 7
    //   4664: invokestatic 792	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   4667: invokeinterface 474 3 0
    //   4672: pop
    //   4673: aload_0
    //   4674: getfield 89	com/tencent/smtt/sdk/ab:g	Landroid/content/Context;
    //   4677: invokestatic 350	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   4680: invokevirtual 481	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   4683: iload 5
    //   4685: istore_3
    //   4686: lload 7
    //   4688: lstore 9
    //   4690: goto -4205 -> 485
    //   4693: aload_0
    //   4694: bipush 104
    //   4696: aload_0
    //   4697: aload 26
    //   4699: invokespecial 450	com/tencent/smtt/sdk/ab:a	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   4702: iconst_0
    //   4703: invokespecial 452	com/tencent/smtt/sdk/ab:a	(ILjava/lang/String;Z)V
    //   4706: goto -122 -> 4584
    //   4709: astore 29
    //   4711: iload 5
    //   4713: istore_3
    //   4714: aload 25
    //   4716: astore 26
    //   4718: aload 27
    //   4720: astore 25
    //   4722: aload 29
    //   4724: astore 27
    //   4726: lload 7
    //   4728: lstore 9
    //   4730: aload_0
    //   4731: aload 28
    //   4733: invokespecial 648	com/tencent/smtt/sdk/ab:a	(Ljava/io/Closeable;)V
    //   4736: lload 7
    //   4738: lstore 9
    //   4740: aload_0
    //   4741: aload 25
    //   4743: invokespecial 648	com/tencent/smtt/sdk/ab:a	(Ljava/io/Closeable;)V
    //   4746: lload 7
    //   4748: lstore 9
    //   4750: aload_0
    //   4751: aload 26
    //   4753: invokespecial 648	com/tencent/smtt/sdk/ab:a	(Ljava/io/Closeable;)V
    //   4756: lload 7
    //   4758: lstore 9
    //   4760: aload 27
    //   4762: athrow
    //   4763: astore 25
    //   4765: iload_3
    //   4766: istore 5
    //   4768: lload 7
    //   4770: lstore 13
    //   4772: goto -2572 -> 2200
    //   4775: iload_2
    //   4776: sipush 300
    //   4779: if_icmplt +229 -> 5008
    //   4782: iload_2
    //   4783: sipush 307
    //   4786: if_icmpgt +222 -> 5008
    //   4789: iload_3
    //   4790: istore 4
    //   4792: lload 7
    //   4794: lstore 13
    //   4796: lload 7
    //   4798: lstore 11
    //   4800: aload_0
    //   4801: getfield 283	com/tencent/smtt/sdk/ab:t	Ljava/net/HttpURLConnection;
    //   4804: ldc_w 948
    //   4807: invokevirtual 952	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   4810: astore 25
    //   4812: iload_3
    //   4813: istore 4
    //   4815: lload 7
    //   4817: lstore 13
    //   4819: lload 7
    //   4821: lstore 11
    //   4823: aload 25
    //   4825: invokestatic 678	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4828: ifne +90 -> 4918
    //   4831: iload_3
    //   4832: istore 4
    //   4834: lload 7
    //   4836: lstore 13
    //   4838: lload 7
    //   4840: lstore 11
    //   4842: aload_0
    //   4843: aload 25
    //   4845: putfield 539	com/tencent/smtt/sdk/ab:j	Ljava/lang/String;
    //   4848: iload_3
    //   4849: istore 4
    //   4851: lload 7
    //   4853: lstore 13
    //   4855: lload 7
    //   4857: lstore 11
    //   4859: aload_0
    //   4860: aload_0
    //   4861: getfield 533	com/tencent/smtt/sdk/ab:q	I
    //   4864: iconst_1
    //   4865: iadd
    //   4866: putfield 533	com/tencent/smtt/sdk/ab:q	I
    //   4869: lload 7
    //   4871: lstore 9
    //   4873: iload_1
    //   4874: ifne -4389 -> 485
    //   4877: aload_0
    //   4878: getfield 89	com/tencent/smtt/sdk/ab:g	Landroid/content/Context;
    //   4881: invokestatic 350	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   4884: getfield 461	com/tencent/smtt/sdk/TbsDownloadConfig:a	Ljava/util/Map;
    //   4887: ldc_w 765
    //   4890: lload 7
    //   4892: invokestatic 792	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   4895: invokeinterface 474 3 0
    //   4900: pop
    //   4901: aload_0
    //   4902: getfield 89	com/tencent/smtt/sdk/ab:g	Landroid/content/Context;
    //   4905: invokestatic 350	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   4908: invokevirtual 481	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   4911: lload 7
    //   4913: lstore 9
    //   4915: goto -4430 -> 485
    //   4918: iload_3
    //   4919: istore 4
    //   4921: lload 7
    //   4923: lstore 13
    //   4925: lload 7
    //   4927: lstore 11
    //   4929: aload_0
    //   4930: bipush 124
    //   4932: aconst_null
    //   4933: iconst_1
    //   4934: invokespecial 452	com/tencent/smtt/sdk/ab:a	(ILjava/lang/String;Z)V
    //   4937: iload_3
    //   4938: istore 4
    //   4940: lload 7
    //   4942: lstore 13
    //   4944: lload 7
    //   4946: lstore 11
    //   4948: aload_0
    //   4949: getfield 89	com/tencent/smtt/sdk/ab:g	Landroid/content/Context;
    //   4952: invokestatic 350	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   4955: sipush 65224
    //   4958: invokevirtual 722	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   4961: iload_3
    //   4962: istore 4
    //   4964: iload_1
    //   4965: ifne -4466 -> 499
    //   4968: aload_0
    //   4969: getfield 89	com/tencent/smtt/sdk/ab:g	Landroid/content/Context;
    //   4972: invokestatic 350	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   4975: getfield 461	com/tencent/smtt/sdk/TbsDownloadConfig:a	Ljava/util/Map;
    //   4978: ldc_w 765
    //   4981: lload 7
    //   4983: invokestatic 792	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   4986: invokeinterface 474 3 0
    //   4991: pop
    //   4992: aload_0
    //   4993: getfield 89	com/tencent/smtt/sdk/ab:g	Landroid/content/Context;
    //   4996: invokestatic 350	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   4999: invokevirtual 481	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   5002: iload_3
    //   5003: istore 4
    //   5005: goto -4506 -> 499
    //   5008: iload_3
    //   5009: istore 4
    //   5011: lload 7
    //   5013: lstore 13
    //   5015: lload 7
    //   5017: lstore 11
    //   5019: aload_0
    //   5020: bipush 102
    //   5022: iload_2
    //   5023: invokestatic 955	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   5026: iconst_0
    //   5027: invokespecial 452	com/tencent/smtt/sdk/ab:a	(ILjava/lang/String;Z)V
    //   5030: iload_2
    //   5031: sipush 416
    //   5034: if_icmpne +185 -> 5219
    //   5037: iload_3
    //   5038: istore 4
    //   5040: lload 7
    //   5042: lstore 13
    //   5044: lload 7
    //   5046: lstore 11
    //   5048: aload_0
    //   5049: iconst_1
    //   5050: iload 6
    //   5052: invokespecial 767	com/tencent/smtt/sdk/ab:b	(ZZ)Z
    //   5055: ifeq +76 -> 5131
    //   5058: iconst_1
    //   5059: istore 4
    //   5061: iconst_1
    //   5062: istore_3
    //   5063: lload 7
    //   5065: lstore 13
    //   5067: lload 7
    //   5069: lstore 11
    //   5071: aload_0
    //   5072: getfield 89	com/tencent/smtt/sdk/ab:g	Landroid/content/Context;
    //   5075: invokestatic 350	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5078: sipush 65322
    //   5081: invokevirtual 722	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   5084: iload_3
    //   5085: istore 4
    //   5087: iload_1
    //   5088: ifne -4589 -> 499
    //   5091: aload_0
    //   5092: getfield 89	com/tencent/smtt/sdk/ab:g	Landroid/content/Context;
    //   5095: invokestatic 350	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5098: getfield 461	com/tencent/smtt/sdk/TbsDownloadConfig:a	Ljava/util/Map;
    //   5101: ldc_w 765
    //   5104: lload 7
    //   5106: invokestatic 792	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   5109: invokeinterface 474 3 0
    //   5114: pop
    //   5115: aload_0
    //   5116: getfield 89	com/tencent/smtt/sdk/ab:g	Landroid/content/Context;
    //   5119: invokestatic 350	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5122: invokevirtual 481	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   5125: iload_3
    //   5126: istore 4
    //   5128: goto -4629 -> 499
    //   5131: iload_3
    //   5132: istore 4
    //   5134: lload 7
    //   5136: lstore 13
    //   5138: lload 7
    //   5140: lstore 11
    //   5142: aload_0
    //   5143: iconst_0
    //   5144: invokespecial 957	com/tencent/smtt/sdk/ab:d	(Z)Z
    //   5147: pop
    //   5148: iload_3
    //   5149: istore 4
    //   5151: lload 7
    //   5153: lstore 13
    //   5155: lload 7
    //   5157: lstore 11
    //   5159: aload_0
    //   5160: getfield 89	com/tencent/smtt/sdk/ab:g	Landroid/content/Context;
    //   5163: invokestatic 350	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5166: sipush 65223
    //   5169: invokevirtual 722	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   5172: iload_3
    //   5173: istore 4
    //   5175: iload_1
    //   5176: ifne -4677 -> 499
    //   5179: aload_0
    //   5180: getfield 89	com/tencent/smtt/sdk/ab:g	Landroid/content/Context;
    //   5183: invokestatic 350	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5186: getfield 461	com/tencent/smtt/sdk/TbsDownloadConfig:a	Ljava/util/Map;
    //   5189: ldc_w 765
    //   5192: lload 7
    //   5194: invokestatic 792	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   5197: invokeinterface 474 3 0
    //   5202: pop
    //   5203: aload_0
    //   5204: getfield 89	com/tencent/smtt/sdk/ab:g	Landroid/content/Context;
    //   5207: invokestatic 350	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5210: invokevirtual 481	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   5213: iload_3
    //   5214: istore 4
    //   5216: goto -4717 -> 499
    //   5219: iload_2
    //   5220: sipush 403
    //   5223: if_icmpeq +10 -> 5233
    //   5226: iload_2
    //   5227: sipush 406
    //   5230: if_icmpne +96 -> 5326
    //   5233: iload_3
    //   5234: istore 4
    //   5236: lload 7
    //   5238: lstore 13
    //   5240: lload 7
    //   5242: lstore 11
    //   5244: aload_0
    //   5245: getfield 537	com/tencent/smtt/sdk/ab:l	J
    //   5248: ldc2_w 534
    //   5251: lcmp
    //   5252: ifne +74 -> 5326
    //   5255: iload_3
    //   5256: istore 4
    //   5258: lload 7
    //   5260: lstore 13
    //   5262: lload 7
    //   5264: lstore 11
    //   5266: aload_0
    //   5267: getfield 89	com/tencent/smtt/sdk/ab:g	Landroid/content/Context;
    //   5270: invokestatic 350	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5273: sipush 65222
    //   5276: invokevirtual 722	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   5279: iload_3
    //   5280: istore 4
    //   5282: iload_1
    //   5283: ifne -4784 -> 499
    //   5286: aload_0
    //   5287: getfield 89	com/tencent/smtt/sdk/ab:g	Landroid/content/Context;
    //   5290: invokestatic 350	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5293: getfield 461	com/tencent/smtt/sdk/TbsDownloadConfig:a	Ljava/util/Map;
    //   5296: ldc_w 765
    //   5299: lload 7
    //   5301: invokestatic 792	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   5304: invokeinterface 474 3 0
    //   5309: pop
    //   5310: aload_0
    //   5311: getfield 89	com/tencent/smtt/sdk/ab:g	Landroid/content/Context;
    //   5314: invokestatic 350	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5317: invokevirtual 481	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   5320: iload_3
    //   5321: istore 4
    //   5323: goto -4824 -> 499
    //   5326: iload_2
    //   5327: sipush 202
    //   5330: if_icmpne +52 -> 5382
    //   5333: lload 7
    //   5335: lstore 9
    //   5337: iload_1
    //   5338: ifne -4853 -> 485
    //   5341: aload_0
    //   5342: getfield 89	com/tencent/smtt/sdk/ab:g	Landroid/content/Context;
    //   5345: invokestatic 350	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5348: getfield 461	com/tencent/smtt/sdk/TbsDownloadConfig:a	Ljava/util/Map;
    //   5351: ldc_w 765
    //   5354: lload 7
    //   5356: invokestatic 792	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   5359: invokeinterface 474 3 0
    //   5364: pop
    //   5365: aload_0
    //   5366: getfield 89	com/tencent/smtt/sdk/ab:g	Landroid/content/Context;
    //   5369: invokestatic 350	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5372: invokevirtual 481	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   5375: lload 7
    //   5377: lstore 9
    //   5379: goto -4894 -> 485
    //   5382: iload_3
    //   5383: istore 4
    //   5385: lload 7
    //   5387: lstore 13
    //   5389: lload 7
    //   5391: lstore 11
    //   5393: aload_0
    //   5394: getfield 249	com/tencent/smtt/sdk/ab:p	I
    //   5397: aload_0
    //   5398: getfield 77	com/tencent/smtt/sdk/ab:B	I
    //   5401: if_icmpge +176 -> 5577
    //   5404: iload_2
    //   5405: sipush 503
    //   5408: if_icmpne +169 -> 5577
    //   5411: iload_3
    //   5412: istore 4
    //   5414: lload 7
    //   5416: lstore 13
    //   5418: lload 7
    //   5420: lstore 11
    //   5422: aload_0
    //   5423: aload_0
    //   5424: getfield 283	com/tencent/smtt/sdk/ab:t	Ljava/net/HttpURLConnection;
    //   5427: ldc_w 959
    //   5430: invokevirtual 952	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   5433: invokestatic 963	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   5436: invokespecial 901	com/tencent/smtt/sdk/ab:a	(J)V
    //   5439: iload_3
    //   5440: istore 4
    //   5442: lload 7
    //   5444: lstore 13
    //   5446: lload 7
    //   5448: lstore 11
    //   5450: aload_0
    //   5451: getfield 543	com/tencent/smtt/sdk/ab:r	Z
    //   5454: ifeq +74 -> 5528
    //   5457: iload_3
    //   5458: istore 4
    //   5460: lload 7
    //   5462: lstore 13
    //   5464: lload 7
    //   5466: lstore 11
    //   5468: aload_0
    //   5469: getfield 89	com/tencent/smtt/sdk/ab:g	Landroid/content/Context;
    //   5472: invokestatic 350	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5475: sipush 65227
    //   5478: invokevirtual 722	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   5481: iload_3
    //   5482: istore 4
    //   5484: iload_1
    //   5485: ifne -4986 -> 499
    //   5488: aload_0
    //   5489: getfield 89	com/tencent/smtt/sdk/ab:g	Landroid/content/Context;
    //   5492: invokestatic 350	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5495: getfield 461	com/tencent/smtt/sdk/TbsDownloadConfig:a	Ljava/util/Map;
    //   5498: ldc_w 765
    //   5501: lload 7
    //   5503: invokestatic 792	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   5506: invokeinterface 474 3 0
    //   5511: pop
    //   5512: aload_0
    //   5513: getfield 89	com/tencent/smtt/sdk/ab:g	Landroid/content/Context;
    //   5516: invokestatic 350	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5519: invokevirtual 481	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   5522: iload_3
    //   5523: istore 4
    //   5525: goto -5026 -> 499
    //   5528: lload 7
    //   5530: lstore 9
    //   5532: iload_1
    //   5533: ifne -5048 -> 485
    //   5536: aload_0
    //   5537: getfield 89	com/tencent/smtt/sdk/ab:g	Landroid/content/Context;
    //   5540: invokestatic 350	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5543: getfield 461	com/tencent/smtt/sdk/TbsDownloadConfig:a	Ljava/util/Map;
    //   5546: ldc_w 765
    //   5549: lload 7
    //   5551: invokestatic 792	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   5554: invokeinterface 474 3 0
    //   5559: pop
    //   5560: aload_0
    //   5561: getfield 89	com/tencent/smtt/sdk/ab:g	Landroid/content/Context;
    //   5564: invokestatic 350	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5567: invokevirtual 481	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   5570: lload 7
    //   5572: lstore 9
    //   5574: goto -5089 -> 485
    //   5577: iload_3
    //   5578: istore 4
    //   5580: lload 7
    //   5582: lstore 13
    //   5584: lload 7
    //   5586: lstore 11
    //   5588: aload_0
    //   5589: getfield 249	com/tencent/smtt/sdk/ab:p	I
    //   5592: aload_0
    //   5593: getfield 77	com/tencent/smtt/sdk/ab:B	I
    //   5596: if_icmpge +185 -> 5781
    //   5599: iload_2
    //   5600: sipush 408
    //   5603: if_icmpeq +24 -> 5627
    //   5606: iload_2
    //   5607: sipush 504
    //   5610: if_icmpeq +17 -> 5627
    //   5613: iload_2
    //   5614: sipush 502
    //   5617: if_icmpeq +10 -> 5627
    //   5620: iload_2
    //   5621: sipush 408
    //   5624: if_icmpne +157 -> 5781
    //   5627: iload_3
    //   5628: istore 4
    //   5630: lload 7
    //   5632: lstore 13
    //   5634: lload 7
    //   5636: lstore 11
    //   5638: aload_0
    //   5639: lconst_0
    //   5640: invokespecial 901	com/tencent/smtt/sdk/ab:a	(J)V
    //   5643: iload_3
    //   5644: istore 4
    //   5646: lload 7
    //   5648: lstore 13
    //   5650: lload 7
    //   5652: lstore 11
    //   5654: aload_0
    //   5655: getfield 543	com/tencent/smtt/sdk/ab:r	Z
    //   5658: ifeq +74 -> 5732
    //   5661: iload_3
    //   5662: istore 4
    //   5664: lload 7
    //   5666: lstore 13
    //   5668: lload 7
    //   5670: lstore 11
    //   5672: aload_0
    //   5673: getfield 89	com/tencent/smtt/sdk/ab:g	Landroid/content/Context;
    //   5676: invokestatic 350	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5679: sipush 65227
    //   5682: invokevirtual 722	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   5685: iload_3
    //   5686: istore 4
    //   5688: iload_1
    //   5689: ifne -5190 -> 499
    //   5692: aload_0
    //   5693: getfield 89	com/tencent/smtt/sdk/ab:g	Landroid/content/Context;
    //   5696: invokestatic 350	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5699: getfield 461	com/tencent/smtt/sdk/TbsDownloadConfig:a	Ljava/util/Map;
    //   5702: ldc_w 765
    //   5705: lload 7
    //   5707: invokestatic 792	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   5710: invokeinterface 474 3 0
    //   5715: pop
    //   5716: aload_0
    //   5717: getfield 89	com/tencent/smtt/sdk/ab:g	Landroid/content/Context;
    //   5720: invokestatic 350	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5723: invokevirtual 481	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   5726: iload_3
    //   5727: istore 4
    //   5729: goto -5230 -> 499
    //   5732: lload 7
    //   5734: lstore 9
    //   5736: iload_1
    //   5737: ifne -5252 -> 485
    //   5740: aload_0
    //   5741: getfield 89	com/tencent/smtt/sdk/ab:g	Landroid/content/Context;
    //   5744: invokestatic 350	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5747: getfield 461	com/tencent/smtt/sdk/TbsDownloadConfig:a	Ljava/util/Map;
    //   5750: ldc_w 765
    //   5753: lload 7
    //   5755: invokestatic 792	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   5758: invokeinterface 474 3 0
    //   5763: pop
    //   5764: aload_0
    //   5765: getfield 89	com/tencent/smtt/sdk/ab:g	Landroid/content/Context;
    //   5768: invokestatic 350	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5771: invokevirtual 481	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   5774: lload 7
    //   5776: lstore 9
    //   5778: goto -5293 -> 485
    //   5781: iload_3
    //   5782: istore 4
    //   5784: lload 7
    //   5786: lstore 13
    //   5788: lload 7
    //   5790: lstore 11
    //   5792: aload_0
    //   5793: invokespecial 811	com/tencent/smtt/sdk/ab:k	()J
    //   5796: lconst_0
    //   5797: lcmp
    //   5798: ifgt +93 -> 5891
    //   5801: iload_3
    //   5802: istore 4
    //   5804: lload 7
    //   5806: lstore 13
    //   5808: lload 7
    //   5810: lstore 11
    //   5812: aload_0
    //   5813: getfield 541	com/tencent/smtt/sdk/ab:o	Z
    //   5816: ifne +75 -> 5891
    //   5819: iload_2
    //   5820: sipush 410
    //   5823: if_icmpeq +68 -> 5891
    //   5826: iload_3
    //   5827: istore 4
    //   5829: lload 7
    //   5831: lstore 13
    //   5833: lload 7
    //   5835: lstore 11
    //   5837: aload_0
    //   5838: iconst_1
    //   5839: putfield 541	com/tencent/smtt/sdk/ab:o	Z
    //   5842: lload 7
    //   5844: lstore 9
    //   5846: iload_1
    //   5847: ifne -5362 -> 485
    //   5850: aload_0
    //   5851: getfield 89	com/tencent/smtt/sdk/ab:g	Landroid/content/Context;
    //   5854: invokestatic 350	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5857: getfield 461	com/tencent/smtt/sdk/TbsDownloadConfig:a	Ljava/util/Map;
    //   5860: ldc_w 765
    //   5863: lload 7
    //   5865: invokestatic 792	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   5868: invokeinterface 474 3 0
    //   5873: pop
    //   5874: aload_0
    //   5875: getfield 89	com/tencent/smtt/sdk/ab:g	Landroid/content/Context;
    //   5878: invokestatic 350	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5881: invokevirtual 481	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   5884: lload 7
    //   5886: lstore 9
    //   5888: goto -5403 -> 485
    //   5891: iload_3
    //   5892: istore 4
    //   5894: lload 7
    //   5896: lstore 13
    //   5898: lload 7
    //   5900: lstore 11
    //   5902: aload_0
    //   5903: getfield 89	com/tencent/smtt/sdk/ab:g	Landroid/content/Context;
    //   5906: invokestatic 350	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5909: sipush 65221
    //   5912: invokevirtual 722	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   5915: iload_3
    //   5916: istore 4
    //   5918: iload_1
    //   5919: ifne -5420 -> 499
    //   5922: aload_0
    //   5923: getfield 89	com/tencent/smtt/sdk/ab:g	Landroid/content/Context;
    //   5926: invokestatic 350	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5929: getfield 461	com/tencent/smtt/sdk/TbsDownloadConfig:a	Ljava/util/Map;
    //   5932: ldc_w 765
    //   5935: lload 7
    //   5937: invokestatic 792	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   5940: invokeinterface 474 3 0
    //   5945: pop
    //   5946: aload_0
    //   5947: getfield 89	com/tencent/smtt/sdk/ab:g	Landroid/content/Context;
    //   5950: invokestatic 350	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5953: invokevirtual 481	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   5956: iload_3
    //   5957: istore 4
    //   5959: goto -5460 -> 499
    //   5962: lload 13
    //   5964: lstore 11
    //   5966: aload 25
    //   5968: invokevirtual 649	java/lang/Throwable:printStackTrace	()V
    //   5971: lload 13
    //   5973: lstore 11
    //   5975: aload_0
    //   5976: lconst_0
    //   5977: invokespecial 901	com/tencent/smtt/sdk/ab:a	(J)V
    //   5980: lload 13
    //   5982: lstore 11
    //   5984: aload_0
    //   5985: bipush 107
    //   5987: aload_0
    //   5988: aload 25
    //   5990: invokespecial 450	com/tencent/smtt/sdk/ab:a	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   5993: iconst_0
    //   5994: invokespecial 452	com/tencent/smtt/sdk/ab:a	(ILjava/lang/String;Z)V
    //   5997: lload 13
    //   5999: lstore 11
    //   6001: aload_0
    //   6002: getfield 543	com/tencent/smtt/sdk/ab:r	Z
    //   6005: ifeq -3708 -> 2297
    //   6008: lload 13
    //   6010: lstore 11
    //   6012: aload_0
    //   6013: getfield 89	com/tencent/smtt/sdk/ab:g	Landroid/content/Context;
    //   6016: invokestatic 350	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   6019: sipush 65227
    //   6022: invokevirtual 722	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   6025: iload 5
    //   6027: istore 4
    //   6029: iload_1
    //   6030: ifne -5531 -> 499
    //   6033: aload_0
    //   6034: getfield 89	com/tencent/smtt/sdk/ab:g	Landroid/content/Context;
    //   6037: invokestatic 350	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   6040: getfield 461	com/tencent/smtt/sdk/TbsDownloadConfig:a	Ljava/util/Map;
    //   6043: ldc_w 765
    //   6046: lload 13
    //   6048: invokestatic 792	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   6051: invokeinterface 474 3 0
    //   6056: pop
    //   6057: aload_0
    //   6058: getfield 89	com/tencent/smtt/sdk/ab:g	Landroid/content/Context;
    //   6061: invokestatic 350	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   6064: invokevirtual 481	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   6067: iload 5
    //   6069: istore 4
    //   6071: goto -5572 -> 499
    //   6074: iconst_0
    //   6075: istore_2
    //   6076: goto -5522 -> 554
    //   6079: iconst_2
    //   6080: istore_2
    //   6081: goto -5504 -> 577
    //   6084: aload_0
    //   6085: getfield 96	com/tencent/smtt/sdk/ab:v	Lcom/tencent/smtt/sdk/TbsLogReport;
    //   6088: iconst_0
    //   6089: invokevirtual 771	com/tencent/smtt/sdk/TbsLogReport:b	(I)V
    //   6092: goto -5509 -> 583
    //   6095: aload_0
    //   6096: getfield 89	com/tencent/smtt/sdk/ab:g	Landroid/content/Context;
    //   6099: invokestatic 350	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   6102: sipush 65218
    //   6105: invokevirtual 722	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   6108: aload_0
    //   6109: iconst_0
    //   6110: invokespecial 957	com/tencent/smtt/sdk/ab:d	(Z)Z
    //   6113: pop
    //   6114: goto -5499 -> 615
    //   6117: aload 25
    //   6119: getfield 354	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   6122: ldc_w 965
    //   6125: iconst_0
    //   6126: invokeinterface 409 3 0
    //   6131: istore_2
    //   6132: aload 25
    //   6134: getfield 461	com/tencent/smtt/sdk/TbsDownloadConfig:a	Ljava/util/Map;
    //   6137: astore 26
    //   6139: iload_2
    //   6140: iconst_1
    //   6141: iadd
    //   6142: istore_2
    //   6143: aload 26
    //   6145: ldc_w 965
    //   6148: iload_2
    //   6149: invokestatic 442	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   6152: invokeinterface 474 3 0
    //   6157: pop
    //   6158: iload_2
    //   6159: aload 25
    //   6161: invokevirtual 968	com/tencent/smtt/sdk/TbsDownloadConfig:getDownloadFailedMaxRetrytimes	()I
    //   6164: if_icmpne -5501 -> 663
    //   6167: aload_0
    //   6168: getfield 96	com/tencent/smtt/sdk/ab:v	Lcom/tencent/smtt/sdk/TbsLogReport;
    //   6171: iconst_2
    //   6172: invokevirtual 823	com/tencent/smtt/sdk/TbsLogReport:c	(I)V
    //   6175: goto -5512 -> 663
    //   6178: iconst_0
    //   6179: istore_2
    //   6180: goto -5500 -> 680
    //   6183: astore 25
    //   6185: lload 9
    //   6187: lstore 11
    //   6189: goto -3716 -> 2473
    //   6192: astore 25
    //   6194: lload 11
    //   6196: lstore 13
    //   6198: goto -3998 -> 2200
    //   6201: astore 27
    //   6203: aconst_null
    //   6204: astore 25
    //   6206: aconst_null
    //   6207: astore 26
    //   6209: aconst_null
    //   6210: astore 28
    //   6212: goto -1486 -> 4726
    //   6215: astore 27
    //   6217: aconst_null
    //   6218: astore 25
    //   6220: aconst_null
    //   6221: astore 28
    //   6223: goto -1497 -> 4726
    //   6226: astore 27
    //   6228: aconst_null
    //   6229: astore 28
    //   6231: goto -1505 -> 4726
    //   6234: astore 27
    //   6236: goto -1510 -> 4726
    //   6239: astore 27
    //   6241: lload 15
    //   6243: lstore 7
    //   6245: goto -1519 -> 4726
    //   6248: astore 27
    //   6250: goto -1524 -> 4726
    //   6253: astore 27
    //   6255: lload 9
    //   6257: lstore 7
    //   6259: goto -1533 -> 4726
    //   6262: astore 26
    //   6264: iload_3
    //   6265: istore 5
    //   6267: aload 29
    //   6269: astore 28
    //   6271: goto -2876 -> 3395
    //   6274: astore 27
    //   6276: aload 26
    //   6278: astore 28
    //   6280: iload_3
    //   6281: istore 5
    //   6283: aload 27
    //   6285: astore 26
    //   6287: aload 25
    //   6289: astore 27
    //   6291: aload 28
    //   6293: astore 25
    //   6295: aload 29
    //   6297: astore 28
    //   6299: goto -2904 -> 3395
    //   6302: astore 27
    //   6304: aload 26
    //   6306: astore 29
    //   6308: iload_3
    //   6309: istore 5
    //   6311: aload 27
    //   6313: astore 26
    //   6315: aload 25
    //   6317: astore 27
    //   6319: aload 29
    //   6321: astore 25
    //   6323: goto -2928 -> 3395
    //   6326: astore 27
    //   6328: aload 26
    //   6330: astore 29
    //   6332: lload 17
    //   6334: lstore 7
    //   6336: aload 27
    //   6338: astore 26
    //   6340: iload_3
    //   6341: istore 5
    //   6343: aload 25
    //   6345: astore 27
    //   6347: aload 29
    //   6349: astore 25
    //   6351: goto -2956 -> 3395
    //   6354: astore 27
    //   6356: aload 26
    //   6358: astore 29
    //   6360: aload 27
    //   6362: astore 26
    //   6364: iload_3
    //   6365: istore 5
    //   6367: aload 25
    //   6369: astore 27
    //   6371: aload 29
    //   6373: astore 25
    //   6375: goto -2980 -> 3395
    //   6378: astore 27
    //   6380: aload 26
    //   6382: astore 29
    //   6384: lload 9
    //   6386: lstore 7
    //   6388: iload_3
    //   6389: istore 5
    //   6391: aload 27
    //   6393: astore 26
    //   6395: aload 25
    //   6397: astore 27
    //   6399: aload 29
    //   6401: astore 25
    //   6403: goto -3008 -> 3395
    //   6406: lload 11
    //   6408: lstore 7
    //   6410: lload 13
    //   6412: lstore 11
    //   6414: goto -2195 -> 4219
    //   6417: goto -2720 -> 3697
    //   6420: aconst_null
    //   6421: astore 25
    //   6423: aconst_null
    //   6424: astore 28
    //   6426: goto -2185 -> 4241
    //   6429: lload 9
    //   6431: lstore 7
    //   6433: goto -5531 -> 902
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	6436	0	this	ab
    //   0	6436	1	paramBoolean	boolean
    //   54	6126	2	i1	int
    //   452	5937	3	bool1	boolean
    //   497	5573	4	bool2	boolean
    //   907	5483	5	bool3	boolean
    //   71	4980	6	bool4	boolean
    //   744	5688	7	l1	long
    //   472	5958	9	l2	long
    //   759	5654	11	l3	long
    //   755	5656	13	l4	long
    //   2645	3597	15	l5	long
    //   3175	3158	17	l6	long
    //   3163	1071	19	l7	long
    //   740	3261	21	l8	long
    //   449	3375	23	l9	long
    //   141	1940	25	localObject1	Object
    //   2194	254	25	localThrowable1	Throwable
    //   2471	41	25	localObject2	Object
    //   3051	1691	25	localObject3	Object
    //   4763	1	25	localThrowable2	Throwable
    //   4810	1350	25	str	String
    //   6183	1	25	localObject4	Object
    //   6192	1	25	localThrowable3	Throwable
    //   6204	218	25	localObject5	Object
    //   3082	3126	26	localObject6	Object
    //   6262	15	26	localIOException1	IOException
    //   6285	109	26	localIOException2	IOException
    //   3054	1707	27	localObject7	Object
    //   6201	1	27	localObject8	Object
    //   6215	1	27	localObject9	Object
    //   6226	1	27	localObject10	Object
    //   6234	1	27	localObject11	Object
    //   6239	1	27	localObject12	Object
    //   6248	1	27	localObject13	Object
    //   6253	1	27	localObject14	Object
    //   6274	10	27	localIOException3	IOException
    //   6289	1	27	localObject15	Object
    //   6302	10	27	localIOException4	IOException
    //   6317	1	27	localObject16	Object
    //   6326	11	27	localIOException5	IOException
    //   6345	1	27	localObject17	Object
    //   6354	7	27	localIOException6	IOException
    //   6369	1	27	localObject18	Object
    //   6378	14	27	localIOException7	IOException
    //   6397	1	27	localObject19	Object
    //   3154	3271	28	localObject20	Object
    //   3048	337	29	localObject21	Object
    //   4709	1587	29	localObject22	Object
    //   6306	94	29	localObject23	Object
    //   3378	11	30	localIOException8	IOException
    // Exception table:
    //   from	to	target	type
    //   761	790	2194	java/lang/Throwable
    //   801	809	2194	java/lang/Throwable
    //   820	844	2194	java/lang/Throwable
    //   855	878	2194	java/lang/Throwable
    //   889	899	2194	java/lang/Throwable
    //   1044	1070	2194	java/lang/Throwable
    //   1089	1098	2194	java/lang/Throwable
    //   1109	1117	2194	java/lang/Throwable
    //   1128	1141	2194	java/lang/Throwable
    //   1199	1204	2194	java/lang/Throwable
    //   1215	1222	2194	java/lang/Throwable
    //   1233	1239	2194	java/lang/Throwable
    //   1250	1290	2194	java/lang/Throwable
    //   1301	1313	2194	java/lang/Throwable
    //   1324	1333	2194	java/lang/Throwable
    //   1344	1350	2194	java/lang/Throwable
    //   1361	1367	2194	java/lang/Throwable
    //   1381	1388	2194	java/lang/Throwable
    //   1399	1405	2194	java/lang/Throwable
    //   1416	1442	2194	java/lang/Throwable
    //   1453	1462	2194	java/lang/Throwable
    //   1473	1500	2194	java/lang/Throwable
    //   1511	1548	2194	java/lang/Throwable
    //   1559	1565	2194	java/lang/Throwable
    //   1585	1591	2194	java/lang/Throwable
    //   1602	1610	2194	java/lang/Throwable
    //   1621	1630	2194	java/lang/Throwable
    //   1641	1648	2194	java/lang/Throwable
    //   1659	1667	2194	java/lang/Throwable
    //   1678	1684	2194	java/lang/Throwable
    //   1695	1700	2194	java/lang/Throwable
    //   1711	1719	2194	java/lang/Throwable
    //   1730	1744	2194	java/lang/Throwable
    //   1755	1763	2194	java/lang/Throwable
    //   1774	1799	2194	java/lang/Throwable
    //   1810	1818	2194	java/lang/Throwable
    //   1833	1843	2194	java/lang/Throwable
    //   1854	1865	2194	java/lang/Throwable
    //   1876	1882	2194	java/lang/Throwable
    //   1893	1903	2194	java/lang/Throwable
    //   1914	1918	2194	java/lang/Throwable
    //   1929	1935	2194	java/lang/Throwable
    //   1946	1956	2194	java/lang/Throwable
    //   1967	1976	2194	java/lang/Throwable
    //   1987	1994	2194	java/lang/Throwable
    //   2005	2018	2194	java/lang/Throwable
    //   2076	2082	2194	java/lang/Throwable
    //   2096	2136	2194	java/lang/Throwable
    //   2147	2191	2194	java/lang/Throwable
    //   2385	2393	2194	java/lang/Throwable
    //   2404	2416	2194	java/lang/Throwable
    //   2427	2435	2194	java/lang/Throwable
    //   2446	2452	2194	java/lang/Throwable
    //   2463	2468	2194	java/lang/Throwable
    //   2539	2554	2194	java/lang/Throwable
    //   2565	2593	2194	java/lang/Throwable
    //   2604	2615	2194	java/lang/Throwable
    //   2626	2647	2194	java/lang/Throwable
    //   2665	2675	2194	java/lang/Throwable
    //   2686	2726	2194	java/lang/Throwable
    //   2741	2748	2194	java/lang/Throwable
    //   2759	2765	2194	java/lang/Throwable
    //   2776	2786	2194	java/lang/Throwable
    //   2797	2804	2194	java/lang/Throwable
    //   2815	2822	2194	java/lang/Throwable
    //   2887	2928	2194	java/lang/Throwable
    //   2939	2952	2194	java/lang/Throwable
    //   3010	3020	2194	java/lang/Throwable
    //   3031	3044	2194	java/lang/Throwable
    //   3067	3075	2194	java/lang/Throwable
    //   3243	3249	2194	java/lang/Throwable
    //   3261	3267	2194	java/lang/Throwable
    //   3279	3285	2194	java/lang/Throwable
    //   3453	3459	2194	java/lang/Throwable
    //   3471	3477	2194	java/lang/Throwable
    //   3489	3495	2194	java/lang/Throwable
    //   4468	4474	2194	java/lang/Throwable
    //   4486	4492	2194	java/lang/Throwable
    //   4504	4510	2194	java/lang/Throwable
    //   4596	4602	2194	java/lang/Throwable
    //   4614	4620	2194	java/lang/Throwable
    //   4632	4638	2194	java/lang/Throwable
    //   4800	4812	2194	java/lang/Throwable
    //   4823	4831	2194	java/lang/Throwable
    //   4842	4848	2194	java/lang/Throwable
    //   4859	4869	2194	java/lang/Throwable
    //   4929	4937	2194	java/lang/Throwable
    //   4948	4961	2194	java/lang/Throwable
    //   5019	5030	2194	java/lang/Throwable
    //   5048	5058	2194	java/lang/Throwable
    //   5071	5084	2194	java/lang/Throwable
    //   5142	5148	2194	java/lang/Throwable
    //   5159	5172	2194	java/lang/Throwable
    //   5244	5255	2194	java/lang/Throwable
    //   5266	5279	2194	java/lang/Throwable
    //   5393	5404	2194	java/lang/Throwable
    //   5422	5439	2194	java/lang/Throwable
    //   5450	5457	2194	java/lang/Throwable
    //   5468	5481	2194	java/lang/Throwable
    //   5588	5599	2194	java/lang/Throwable
    //   5638	5643	2194	java/lang/Throwable
    //   5654	5661	2194	java/lang/Throwable
    //   5672	5685	2194	java/lang/Throwable
    //   5792	5801	2194	java/lang/Throwable
    //   5812	5819	2194	java/lang/Throwable
    //   5837	5842	2194	java/lang/Throwable
    //   5902	5915	2194	java/lang/Throwable
    //   761	790	2471	finally
    //   801	809	2471	finally
    //   820	844	2471	finally
    //   855	878	2471	finally
    //   889	899	2471	finally
    //   1044	1070	2471	finally
    //   1089	1098	2471	finally
    //   1109	1117	2471	finally
    //   1128	1141	2471	finally
    //   1199	1204	2471	finally
    //   1215	1222	2471	finally
    //   1233	1239	2471	finally
    //   1250	1290	2471	finally
    //   1301	1313	2471	finally
    //   1324	1333	2471	finally
    //   1344	1350	2471	finally
    //   1361	1367	2471	finally
    //   1381	1388	2471	finally
    //   1399	1405	2471	finally
    //   1416	1442	2471	finally
    //   1453	1462	2471	finally
    //   1473	1500	2471	finally
    //   1511	1548	2471	finally
    //   1559	1565	2471	finally
    //   1585	1591	2471	finally
    //   1602	1610	2471	finally
    //   1621	1630	2471	finally
    //   1641	1648	2471	finally
    //   1659	1667	2471	finally
    //   1678	1684	2471	finally
    //   1695	1700	2471	finally
    //   1711	1719	2471	finally
    //   1730	1744	2471	finally
    //   1755	1763	2471	finally
    //   1774	1799	2471	finally
    //   1810	1818	2471	finally
    //   1833	1843	2471	finally
    //   1854	1865	2471	finally
    //   1876	1882	2471	finally
    //   1893	1903	2471	finally
    //   1914	1918	2471	finally
    //   1929	1935	2471	finally
    //   1946	1956	2471	finally
    //   1967	1976	2471	finally
    //   1987	1994	2471	finally
    //   2005	2018	2471	finally
    //   2076	2082	2471	finally
    //   2096	2136	2471	finally
    //   2147	2191	2471	finally
    //   2204	2212	2471	finally
    //   2220	2227	2471	finally
    //   2231	2239	2471	finally
    //   2243	2285	2471	finally
    //   2289	2297	2471	finally
    //   2301	2314	2471	finally
    //   2385	2393	2471	finally
    //   2404	2416	2471	finally
    //   2427	2435	2471	finally
    //   2446	2452	2471	finally
    //   2463	2468	2471	finally
    //   2539	2554	2471	finally
    //   2565	2593	2471	finally
    //   2604	2615	2471	finally
    //   2626	2647	2471	finally
    //   2665	2675	2471	finally
    //   2686	2726	2471	finally
    //   2741	2748	2471	finally
    //   2759	2765	2471	finally
    //   2776	2786	2471	finally
    //   2797	2804	2471	finally
    //   2815	2822	2471	finally
    //   2887	2928	2471	finally
    //   2939	2952	2471	finally
    //   3010	3020	2471	finally
    //   3031	3044	2471	finally
    //   3067	3075	2471	finally
    //   3243	3249	2471	finally
    //   3261	3267	2471	finally
    //   3279	3285	2471	finally
    //   3453	3459	2471	finally
    //   3471	3477	2471	finally
    //   3489	3495	2471	finally
    //   4468	4474	2471	finally
    //   4486	4492	2471	finally
    //   4504	4510	2471	finally
    //   4596	4602	2471	finally
    //   4614	4620	2471	finally
    //   4632	4638	2471	finally
    //   4800	4812	2471	finally
    //   4823	4831	2471	finally
    //   4842	4848	2471	finally
    //   4859	4869	2471	finally
    //   4929	4937	2471	finally
    //   4948	4961	2471	finally
    //   5019	5030	2471	finally
    //   5048	5058	2471	finally
    //   5071	5084	2471	finally
    //   5142	5148	2471	finally
    //   5159	5172	2471	finally
    //   5244	5255	2471	finally
    //   5266	5279	2471	finally
    //   5393	5404	2471	finally
    //   5422	5439	2471	finally
    //   5450	5457	2471	finally
    //   5468	5481	2471	finally
    //   5588	5599	2471	finally
    //   5638	5643	2471	finally
    //   5654	5661	2471	finally
    //   5672	5685	2471	finally
    //   5792	5801	2471	finally
    //   5812	5819	2471	finally
    //   5837	5842	2471	finally
    //   5902	5915	2471	finally
    //   5966	5971	2471	finally
    //   5975	5980	2471	finally
    //   5984	5997	2471	finally
    //   6001	6008	2471	finally
    //   6012	6025	2471	finally
    //   3089	3098	3378	java/io/IOException
    //   3103	3125	3378	java/io/IOException
    //   3345	3375	3378	java/io/IOException
    //   3395	3416	4709	finally
    //   3416	3441	4709	finally
    //   4385	4456	4709	finally
    //   4559	4584	4709	finally
    //   4693	4706	4709	finally
    //   4730	4736	4763	java/lang/Throwable
    //   4740	4746	4763	java/lang/Throwable
    //   4750	4756	4763	java/lang/Throwable
    //   4760	4763	4763	java/lang/Throwable
    //   913	923	6183	finally
    //   934	943	6183	finally
    //   954	962	6183	finally
    //   973	986	6183	finally
    //   4252	4258	6183	finally
    //   4269	4275	6183	finally
    //   4286	4292	6183	finally
    //   4303	4310	6183	finally
    //   4321	4334	6183	finally
    //   4730	4736	6183	finally
    //   4740	4746	6183	finally
    //   4750	4756	6183	finally
    //   4760	4763	6183	finally
    //   913	923	6192	java/lang/Throwable
    //   934	943	6192	java/lang/Throwable
    //   954	962	6192	java/lang/Throwable
    //   973	986	6192	java/lang/Throwable
    //   4252	4258	6192	java/lang/Throwable
    //   4269	4275	6192	java/lang/Throwable
    //   4286	4292	6192	java/lang/Throwable
    //   4303	4310	6192	java/lang/Throwable
    //   4321	4334	6192	java/lang/Throwable
    //   3075	3084	6201	finally
    //   3089	3098	6215	finally
    //   3103	3125	6215	finally
    //   3345	3375	6215	finally
    //   3125	3156	6226	finally
    //   3156	3161	6234	finally
    //   3177	3184	6239	finally
    //   3192	3201	6239	finally
    //   3209	3222	6239	finally
    //   3565	3577	6239	finally
    //   3589	3596	6239	finally
    //   3604	3614	6239	finally
    //   3626	3634	6239	finally
    //   3650	3655	6239	finally
    //   3671	3676	6239	finally
    //   3684	3690	6239	finally
    //   3726	3735	6239	finally
    //   3743	3748	6239	finally
    //   3779	3788	6239	finally
    //   3796	3835	6239	finally
    //   3843	3856	6239	finally
    //   3876	3886	6239	finally
    //   3894	3903	6239	finally
    //   3911	3959	6239	finally
    //   3967	3980	6239	finally
    //   3697	3710	6248	finally
    //   3992	4007	6253	finally
    //   4026	4096	6253	finally
    //   4120	4147	6253	finally
    //   4147	4157	6253	finally
    //   4157	4177	6253	finally
    //   4177	4199	6253	finally
    //   3075	3084	6262	java/io/IOException
    //   3125	3156	6274	java/io/IOException
    //   3156	3161	6302	java/io/IOException
    //   3177	3184	6326	java/io/IOException
    //   3192	3201	6326	java/io/IOException
    //   3209	3222	6326	java/io/IOException
    //   3565	3577	6326	java/io/IOException
    //   3589	3596	6326	java/io/IOException
    //   3604	3614	6326	java/io/IOException
    //   3626	3634	6326	java/io/IOException
    //   3650	3655	6326	java/io/IOException
    //   3671	3676	6326	java/io/IOException
    //   3684	3690	6326	java/io/IOException
    //   3726	3735	6326	java/io/IOException
    //   3743	3748	6326	java/io/IOException
    //   3779	3788	6326	java/io/IOException
    //   3796	3835	6326	java/io/IOException
    //   3843	3856	6326	java/io/IOException
    //   3876	3886	6326	java/io/IOException
    //   3894	3903	6326	java/io/IOException
    //   3911	3959	6326	java/io/IOException
    //   3967	3980	6326	java/io/IOException
    //   3697	3710	6354	java/io/IOException
    //   3992	4007	6378	java/io/IOException
    //   4026	4096	6378	java/io/IOException
    //   4120	4147	6378	java/io/IOException
    //   4147	4157	6378	java/io/IOException
    //   4157	4177	6378	java/io/IOException
    //   4177	4199	6378	java/io/IOException
  }
  
  public boolean a(boolean paramBoolean1, boolean paramBoolean2)
  {
    paramBoolean1 = true;
    int i1 = TbsDownloadConfig.getInstance(this.g).mPreferences.getInt("use_backup_version", 0);
    int i2 = ai.a().c(this.g);
    if (i1 == 0) {
      i1 = TbsDownloadConfig.getInstance(this.g).mPreferences.getInt("tbs_download_version", 0);
    }
    for (this.a = "by default key"; (i1 == 0) || (i1 == i2); this.a = "by new key")
    {
      paramBoolean1 = false;
      return paramBoolean1;
    }
    if (paramBoolean2)
    {
      File localFile = TbsDownloader.a(i1);
      Object localObject;
      if ((localFile != null) && (localFile.exists()))
      {
        String str = j.a(this.g, 4);
        if (TbsDownloader.getOverSea(this.g))
        {
          localObject = "x5.oversea.tbs.org";
          label136:
          localObject = new File(str, (String)localObject);
        }
      }
      for (;;)
      {
        try
        {
          j.b(localFile, (File)localObject);
          i2 = 1;
          if (!h()) {
            break label284;
          }
          if (!g()) {
            break label307;
          }
          TbsDownloadConfig.getInstance(this.g).a.put("tbs_download_interrupt_code_reason", Integer.valueOf(65322));
          TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(65322);
          c(false);
          if (i2 == 0) {
            break;
          }
          a(100, "use local backup apk in startDownload" + this.a, true);
          this.v.a(TbsLogReport.EventType.TYPE_DOWNLOAD);
          return true;
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
        localObject = "x5.tbs.org";
        break label136;
        i2 = 0;
      }
      label284:
      i();
      if (!a.a(this.g, localFile, 0L, i1)) {
        j.b(localFile);
      }
    }
    label307:
    if (b(false, paramBoolean2))
    {
      TbsDownloadConfig.getInstance(this.g).a.put("tbs_download_interrupt_code_reason", Integer.valueOf(65322));
      TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(65322);
      c(false);
      return true;
    }
    if ((!d(true)) && (!d(true)))
    {
      TbsLog.e("TbsDownload", "[TbsApkDownloader] delete file failed!");
      TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(65235);
    }
    return false;
  }
  
  public void b()
  {
    this.r = true;
  }
  
  public boolean b(boolean paramBoolean)
  {
    if ((paramBoolean) && (!n()) && ((!QbSdk.getDownloadWithoutWifi()) || (!Apn.isNetworkAvailable(this.g)))) {}
    while ((this.b == null) || (this.c < 0) || (this.c >= this.b.length)) {
      return false;
    }
    String[] arrayOfString = this.b;
    int i1 = this.c;
    this.c = (i1 + 1);
    this.j = arrayOfString[i1];
    this.p = 0;
    this.q = 0;
    this.l = -1L;
    this.o = false;
    this.r = false;
    this.s = false;
    this.y = false;
    return true;
  }
  
  public void c()
  {
    b();
    d(false);
    d(true);
  }
  
  public boolean d()
  {
    TbsLog.i("TbsDownload", "[TbsApkDownloader.isDownloadForeground] mIsDownloadForeground=" + this.C);
    return this.C;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/tencent/smtt/sdk/ab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */