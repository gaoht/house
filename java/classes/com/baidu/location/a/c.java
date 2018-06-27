package com.baidu.location.a;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.SharedPreferences;
import android.location.Location;
import android.os.Environment;
import android.os.Handler;
import com.baidu.location.Jni;
import com.baidu.location.d.i;
import com.baidu.location.f;
import com.maa.android.agent.instrumentation.Instrumented;
import com.mato.sdk.instrumentation.HttpInstrumentation;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

@Instrumented
public class c
{
  public static String f = "0";
  private static c j = null;
  private a A = null;
  private boolean B = false;
  private boolean C = false;
  private int D = 0;
  private float E = 0.0F;
  private float F = 0.0F;
  private long G = 0L;
  private int H = 500;
  private Handler I = null;
  private byte[] J = new byte[4];
  private byte[] K = null;
  private int L = 0;
  private List<Byte> M = null;
  private boolean N = false;
  long a = 0L;
  Location b = null;
  Location c = null;
  StringBuilder d = null;
  long e = 0L;
  int g = 0;
  double h = 116.22345545D;
  double i = 40.245667323D;
  private int k = 1;
  private double l = 0.699999988079071D;
  private String m = "3G|4G";
  private int n = 1;
  private int o = 307200;
  private int p = 15;
  private int q = 1;
  private double r = 3.5D;
  private double s = 3.0D;
  private double t = 0.5D;
  private int u = 300;
  private int v = 60;
  private int w = 0;
  private int x = 60;
  private int y = 0;
  private long z = 0L;
  
  public static c a()
  {
    if (j == null) {
      j = new c();
    }
    return j;
  }
  
  private String a(File paramFile, String paramString)
  {
    String str = UUID.randomUUID().toString();
    try
    {
      paramString = new URL(paramString);
      if (!(paramString instanceof URL))
      {
        paramString = paramString.openConnection();
        paramString = (HttpURLConnection)paramString;
        paramString.setReadTimeout(10000);
        paramString.setConnectTimeout(10000);
        paramString.setDoInput(true);
        paramString.setDoOutput(true);
        paramString.setUseCaches(false);
        paramString.setRequestMethod("POST");
        paramString.setRequestProperty("Charset", "utf-8");
        paramString.setRequestProperty("connection", "close");
        paramString.setRequestProperty("Content-Type", "multipart/form-data" + ";boundary=" + str);
        if ((paramFile != null) && (paramFile.exists()))
        {
          localOutputStream = paramString.getOutputStream();
          localDataOutputStream = new DataOutputStream(localOutputStream);
          Object localObject = new StringBuffer();
          ((StringBuffer)localObject).append("--");
          ((StringBuffer)localObject).append(str);
          ((StringBuffer)localObject).append("\r\n");
          ((StringBuffer)localObject).append("Content-Disposition: form-data; name=\"location_dat\"; filename=\"" + paramFile.getName() + "\"" + "\r\n");
          ((StringBuffer)localObject).append("Content-Type: application/octet-stream; charset=utf-8" + "\r\n");
          ((StringBuffer)localObject).append("\r\n");
          localDataOutputStream.write(((StringBuffer)localObject).toString().getBytes());
          paramFile = new FileInputStream(paramFile);
          localObject = new byte['Ѐ'];
          for (;;)
          {
            i1 = paramFile.read((byte[])localObject);
            if (i1 == -1) {
              break;
            }
            localDataOutputStream.write((byte[])localObject, 0, i1);
          }
        }
      }
    }
    catch (MalformedURLException paramFile)
    {
      int i1;
      do
      {
        OutputStream localOutputStream;
        DataOutputStream localDataOutputStream;
        for (;;)
        {
          return "0";
          paramString = HttpInstrumentation.openConnection((URL)paramString);
        }
        paramFile.close();
        localDataOutputStream.write("\r\n".getBytes());
        localDataOutputStream.write(("--" + str + "--" + "\r\n").getBytes());
        localDataOutputStream.flush();
        i1 = paramString.getResponseCode();
        localOutputStream.close();
        paramString.disconnect();
        this.y += 400;
        c(this.y);
      } while (i1 != 200);
      return "1";
    }
    catch (IOException paramFile)
    {
      for (;;) {}
    }
  }
  
  private boolean a(String paramString, Context paramContext)
  {
    boolean bool4 = false;
    boolean bool3 = false;
    boolean bool1 = false;
    boolean bool2 = bool4;
    label127:
    for (;;)
    {
      try
      {
        paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses();
        if (paramContext != null)
        {
          bool2 = bool4;
          paramContext = paramContext.iterator();
          bool2 = bool1;
          bool3 = bool1;
          if (paramContext.hasNext())
          {
            bool2 = bool1;
            ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)paramContext.next();
            bool2 = bool1;
            if (!localRunningAppProcessInfo.processName.equals(paramString)) {
              break label127;
            }
            bool2 = bool1;
            int i1 = localRunningAppProcessInfo.importance;
            if ((i1 != 200) && (i1 != 100)) {
              break label127;
            }
            bool1 = true;
            continue;
          }
        }
        return bool3;
      }
      catch (Exception paramString)
      {
        bool3 = bool2;
      }
    }
  }
  
  private byte[] a(int paramInt)
  {
    return new byte[] { (byte)(paramInt & 0xFF), (byte)((0xFF00 & paramInt) >> 8), (byte)((0xFF0000 & paramInt) >> 16), (byte)((0xFF000000 & paramInt) >> 24) };
  }
  
  private byte[] a(String paramString)
  {
    int i4 = 0;
    if (paramString == null) {
      return null;
    }
    paramString = paramString.getBytes();
    int i1 = (byte)new Random().nextInt(255);
    int i2 = (byte)new Random().nextInt(255);
    byte[] arrayOfByte = new byte[paramString.length + 2];
    int i5 = paramString.length;
    int i3 = 0;
    while (i4 < i5)
    {
      arrayOfByte[i3] = ((byte)(paramString[i4] ^ i1));
      i4 += 1;
      i3 += 1;
    }
    i4 = i3 + 1;
    arrayOfByte[i3] = i1;
    arrayOfByte[i4] = i2;
    return arrayOfByte;
  }
  
  private String b(String paramString)
  {
    Calendar localCalendar = Calendar.getInstance();
    return String.format(paramString, new Object[] { Integer.valueOf(localCalendar.get(1)), Integer.valueOf(localCalendar.get(2) + 1), Integer.valueOf(localCalendar.get(5)) });
  }
  
  private void b(int paramInt)
  {
    byte[] arrayOfByte = a(paramInt);
    paramInt = 0;
    while (paramInt < 4)
    {
      this.M.add(Byte.valueOf(arrayOfByte[paramInt]));
      paramInt += 1;
    }
  }
  
  private void b(Location paramLocation)
  {
    c(paramLocation);
    h();
  }
  
  private void c()
  {
    if (this.N) {
      return;
    }
    this.N = true;
    d(com.baidu.location.d.b.d);
    j();
    d();
  }
  
  private void c(int paramInt)
  {
    if (paramInt == 0) {}
    for (;;)
    {
      return;
      Object localObject1 = i.a + "/grtcf.dat";
      try
      {
        localObject1 = new File((String)localObject1);
        Object localObject2;
        if (!((File)localObject1).exists())
        {
          localObject2 = new File(i.a);
          if (!((File)localObject2).exists()) {
            ((File)localObject2).mkdirs();
          }
          if (((File)localObject1).createNewFile())
          {
            localObject2 = new RandomAccessFile((File)localObject1, "rw");
            ((RandomAccessFile)localObject2).seek(2L);
            ((RandomAccessFile)localObject2).writeInt(0);
            ((RandomAccessFile)localObject2).seek(8L);
            byte[] arrayOfByte = "1980_01_01:0".getBytes();
            ((RandomAccessFile)localObject2).writeInt(arrayOfByte.length);
            ((RandomAccessFile)localObject2).write(arrayOfByte);
            ((RandomAccessFile)localObject2).seek(200L);
            ((RandomAccessFile)localObject2).writeBoolean(false);
            ((RandomAccessFile)localObject2).seek(800L);
            ((RandomAccessFile)localObject2).writeBoolean(false);
            ((RandomAccessFile)localObject2).close();
          }
        }
        else
        {
          localObject1 = new RandomAccessFile((File)localObject1, "rw");
          ((RandomAccessFile)localObject1).seek(8L);
          localObject2 = (b("%d_%02d_%02d") + ":" + paramInt).getBytes();
          ((RandomAccessFile)localObject1).writeInt(localObject2.length);
          ((RandomAccessFile)localObject1).write((byte[])localObject2);
          ((RandomAccessFile)localObject1).close();
          return;
        }
      }
      catch (Exception localException) {}
    }
  }
  
  private void c(Location paramLocation)
  {
    if ((System.currentTimeMillis() - this.a < this.H) || (paramLocation == null)) {
      return;
    }
    if ((paramLocation != null) && (paramLocation.hasSpeed()) && (paramLocation.getSpeed() > this.E)) {
      this.E = paramLocation.getSpeed();
    }
    try
    {
      if (this.M == null)
      {
        this.M = new ArrayList();
        i();
        d(paramLocation);
      }
      for (;;)
      {
        this.L += 1;
        return;
        e(paramLocation);
      }
    }
    catch (Exception paramLocation)
    {
      for (;;) {}
    }
  }
  
  private void c(String paramString)
  {
    if (paramString != null) {}
    try
    {
      paramString = new JSONObject(paramString);
      if (paramString.has("on")) {
        this.k = paramString.getInt("on");
      }
      if (paramString.has("bash")) {
        this.l = paramString.getDouble("bash");
      }
      if (paramString.has("net")) {
        this.m = paramString.getString("net");
      }
      if (paramString.has("tcon")) {
        this.n = paramString.getInt("tcon");
      }
      if (paramString.has("tcsh")) {
        this.o = paramString.getInt("tcsh");
      }
      if (paramString.has("per")) {
        this.p = paramString.getInt("per");
      }
      if (paramString.has("chdron")) {
        this.q = paramString.getInt("chdron");
      }
      if (paramString.has("spsh")) {
        this.r = paramString.getDouble("spsh");
      }
      if (paramString.has("acsh")) {
        this.s = paramString.getDouble("acsh");
      }
      if (paramString.has("stspsh")) {
        this.t = paramString.getDouble("stspsh");
      }
      if (paramString.has("drstsh")) {
        this.u = paramString.getInt("drstsh");
      }
      if (paramString.has("stper")) {
        this.v = paramString.getInt("stper");
      }
      if (paramString.has("nondron")) {
        this.w = paramString.getInt("nondron");
      }
      if (paramString.has("nondrper")) {
        this.x = paramString.getInt("nondrper");
      }
      if (paramString.has("uptime")) {
        this.z = paramString.getLong("uptime");
      }
      k();
      return;
    }
    catch (JSONException paramString) {}
  }
  
  private void d()
  {
    Object localObject = null;
    if (0 == 0) {
      localObject = "7.0.2";
    }
    localObject = ((String)localObject).split("\\.");
    int i2 = localObject.length;
    this.J[0] = 0;
    this.J[1] = 0;
    this.J[2] = 0;
    this.J[3] = 0;
    int i1 = i2;
    if (i2 >= 4) {
      i1 = 4;
    }
    i2 = 0;
    while (i2 < i1) {
      try
      {
        this.J[i2] = ((byte)(Integer.valueOf(localObject[i2]).intValue() & 0xFF));
        i2 += 1;
      }
      catch (Exception localException) {}
    }
    this.K = a(com.baidu.location.d.b.d + ":" + com.baidu.location.d.b.a().b);
  }
  
  private void d(Location paramLocation)
  {
    int i2 = 0;
    this.e = System.currentTimeMillis();
    b((int)(this.e / 1000L));
    b((int)(paramLocation.getLongitude() * 1000000.0D));
    b((int)(paramLocation.getLatitude() * 1000000.0D));
    int i1;
    if (paramLocation.hasBearing())
    {
      i1 = 0;
      if (!paramLocation.hasSpeed()) {
        break label115;
      }
      label65:
      if (i1 <= 0) {
        break label121;
      }
      this.M.add(Byte.valueOf((byte)32));
      label84:
      if (i2 <= 0) {
        break label157;
      }
      this.M.add(Byte.valueOf((byte)Byte.MIN_VALUE));
    }
    for (;;)
    {
      this.b = paramLocation;
      return;
      i1 = 1;
      break;
      label115:
      i2 = 1;
      break label65;
      label121:
      byte b1 = (byte)((byte)((int)(paramLocation.getBearing() / 15.0F) & 0xFF) & 0xFFFFFFDF);
      this.M.add(Byte.valueOf(b1));
      break label84;
      label157:
      b1 = (byte)((byte)((int)(paramLocation.getSpeed() * 3.6D / 4.0D) & 0xFF) & 0x7F);
      this.M.add(Byte.valueOf(b1));
    }
  }
  
  private void d(String paramString)
  {
    i2 = 1;
    Object localObject1 = i.a + "/grtcf.dat";
    for (;;)
    {
      try
      {
        localObject1 = new File((String)localObject1);
        if (((File)localObject1).exists())
        {
          localObject1 = new RandomAccessFile((File)localObject1, "rw");
          ((RandomAccessFile)localObject1).seek(2L);
          i3 = ((RandomAccessFile)localObject1).readInt();
          ((RandomAccessFile)localObject1).seek(8L);
          i1 = ((RandomAccessFile)localObject1).readInt();
          localObject2 = new byte[i1];
          ((RandomAccessFile)localObject1).read((byte[])localObject2, 0, i1);
          localObject2 = new String((byte[])localObject2);
          i1 = i2;
          if (((String)localObject2).contains(b("%d_%02d_%02d")))
          {
            boolean bool = ((String)localObject2).contains(":");
            i1 = i2;
            if (!bool) {}
          }
        }
      }
      catch (Exception paramString)
      {
        int i3;
        Object localObject2;
        long l1;
        return;
      }
      try
      {
        localObject2 = ((String)localObject2).split(":");
        i1 = i2;
        if (localObject2.length > 1)
        {
          this.y = Integer.valueOf(localObject2[1]).intValue();
          i1 = i2;
        }
      }
      catch (Exception localException)
      {
        i1 = i2;
        continue;
      }
      if (i1 <= i3)
      {
        l1 = i1 * 2048;
        ((RandomAccessFile)localObject1).seek(l1);
        i2 = ((RandomAccessFile)localObject1).readInt();
        localObject2 = new byte[i2];
        ((RandomAccessFile)localObject1).read((byte[])localObject2, 0, i2);
        localObject2 = new String((byte[])localObject2);
        if ((paramString != null) && (((String)localObject2).contains(paramString))) {
          c((String)localObject2);
        }
      }
      else
      {
        ((RandomAccessFile)localObject1).close();
        return;
      }
      i1 += 1;
    }
  }
  
  private void e(Location paramLocation)
  {
    if (paramLocation == null) {
      return;
    }
    int i4 = (int)((paramLocation.getLongitude() - this.b.getLongitude()) * 100000.0D);
    int i5 = (int)((paramLocation.getLatitude() - this.b.getLatitude()) * 100000.0D);
    int i1;
    int i2;
    label63:
    int i3;
    label71:
    label86:
    byte b2;
    if (paramLocation.hasBearing())
    {
      i1 = 0;
      if (!paramLocation.hasSpeed()) {
        break label385;
      }
      i2 = 0;
      if (i4 <= 0) {
        break label391;
      }
      i3 = 0;
      int i6 = Math.abs(i4);
      if (i5 <= 0) {
        break label397;
      }
      i4 = 0;
      i5 = Math.abs(i5);
      if (this.L > 1)
      {
        this.c = null;
        this.c = this.b;
      }
      this.b = paramLocation;
      if ((this.b != null) && (this.c != null) && (this.b.getTime() > this.c.getTime()) && (this.b.getTime() - this.c.getTime() < 5000L))
      {
        long l1 = this.b.getTime() - this.c.getTime();
        float[] arrayOfFloat = new float[2];
        Location.distanceBetween(this.b.getAltitude(), this.b.getLongitude(), this.c.getLatitude(), this.c.getLongitude(), arrayOfFloat);
        double d1 = 2.0F * (arrayOfFloat[0] - this.c.getSpeed() * (float)l1) / (float)(l1 * l1);
        if (d1 > this.F) {
          this.F = ((float)d1);
        }
      }
      this.M.add(Byte.valueOf((byte)(i6 & 0xFF)));
      this.M.add(Byte.valueOf((byte)(i5 & 0xFF)));
      if (i1 <= 0) {
        break label403;
      }
      b1 = 32;
      if (i4 > 0) {
        b1 = (byte)96;
      }
      b2 = b1;
      if (i3 > 0) {
        b2 = (byte)(b1 | 0xFFFFFF80);
      }
      this.M.add(Byte.valueOf(b2));
    }
    for (;;)
    {
      if (i2 <= 0) {
        break label465;
      }
      this.M.add(Byte.valueOf((byte)Byte.MIN_VALUE));
      return;
      i1 = 1;
      break;
      label385:
      i2 = 1;
      break label63;
      label391:
      i3 = 1;
      break label71;
      label397:
      i4 = 1;
      break label86;
      label403:
      b2 = (byte)((byte)((int)(paramLocation.getBearing() / 15.0F) & 0xFF) & 0x1F);
      b1 = b2;
      if (i4 > 0) {
        b1 = (byte)(b2 | 0x40);
      }
      b2 = b1;
      if (i3 > 0) {
        b2 = (byte)(b1 | 0xFFFFFF80);
      }
      this.M.add(Byte.valueOf(b2));
    }
    label465:
    byte b1 = (byte)((byte)((int)(paramLocation.getSpeed() * 3.6D / 4.0D) & 0xFF) & 0x7F);
    this.M.add(Byte.valueOf(b1));
  }
  
  private void e(String paramString)
  {
    Object localObject1 = i.a + "/grtcf.dat";
    try
    {
      localObject1 = new File((String)localObject1);
      Object localObject2;
      int i2;
      int i1;
      if (!((File)localObject1).exists())
      {
        localObject2 = new File(i.a);
        if (!((File)localObject2).exists()) {
          ((File)localObject2).mkdirs();
        }
        if (((File)localObject1).createNewFile())
        {
          localObject2 = new RandomAccessFile((File)localObject1, "rw");
          ((RandomAccessFile)localObject2).seek(2L);
          ((RandomAccessFile)localObject2).writeInt(0);
          ((RandomAccessFile)localObject2).seek(8L);
          byte[] arrayOfByte = "1980_01_01:0".getBytes();
          ((RandomAccessFile)localObject2).writeInt(arrayOfByte.length);
          ((RandomAccessFile)localObject2).write(arrayOfByte);
          ((RandomAccessFile)localObject2).seek(200L);
          ((RandomAccessFile)localObject2).writeBoolean(false);
          ((RandomAccessFile)localObject2).seek(800L);
          ((RandomAccessFile)localObject2).writeBoolean(false);
          ((RandomAccessFile)localObject2).close();
        }
      }
      else
      {
        localObject1 = new RandomAccessFile((File)localObject1, "rw");
        ((RandomAccessFile)localObject1).seek(2L);
        i2 = ((RandomAccessFile)localObject1).readInt();
        i1 = 1;
      }
      for (;;)
      {
        if (i1 <= i2)
        {
          ((RandomAccessFile)localObject1).seek(i1 * 2048);
          int i3 = ((RandomAccessFile)localObject1).readInt();
          localObject2 = new byte[i3];
          ((RandomAccessFile)localObject1).read((byte[])localObject2, 0, i3);
          if (!new String((byte[])localObject2).contains(com.baidu.location.d.b.d)) {}
        }
        else
        {
          if (i1 >= i2)
          {
            ((RandomAccessFile)localObject1).seek(2L);
            ((RandomAccessFile)localObject1).writeInt(i1);
          }
          ((RandomAccessFile)localObject1).seek(i1 * 2048);
          paramString = paramString.getBytes();
          ((RandomAccessFile)localObject1).writeInt(paramString.length);
          ((RandomAccessFile)localObject1).write(paramString);
          ((RandomAccessFile)localObject1).close();
          return;
        }
        i1 += 1;
      }
      return;
    }
    catch (Exception paramString) {}
  }
  
  /* Error */
  private boolean e()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: iconst_0
    //   4: istore_2
    //   5: iconst_0
    //   6: istore_1
    //   7: new 244	java/io/File
    //   10: dup
    //   11: new 232	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 233	java/lang/StringBuilder:<init>	()V
    //   18: invokestatic 645	com/baidu/location/d/j:f	()Ljava/lang/String;
    //   21: invokevirtual 239	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: getstatic 648	java/io/File:separator	Ljava/lang/String;
    //   27: invokevirtual 239	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: ldc_w 650
    //   33: invokevirtual 239	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: invokevirtual 242	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   39: invokespecial 439	java/io/File:<init>	(Ljava/lang/String;)V
    //   42: astore_3
    //   43: aload_3
    //   44: invokevirtual 248	java/io/File:exists	()Z
    //   47: ifne +8 -> 55
    //   50: aload_3
    //   51: invokevirtual 445	java/io/File:createNewFile	()Z
    //   54: pop
    //   55: iconst_0
    //   56: ifne +178 -> 234
    //   59: new 447	java/io/RandomAccessFile
    //   62: dup
    //   63: aload_3
    //   64: ldc_w 449
    //   67: invokespecial 452	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   70: astore_3
    //   71: aload_3
    //   72: invokevirtual 654	java/io/RandomAccessFile:getChannel	()Ljava/nio/channels/FileChannel;
    //   75: astore 4
    //   77: aload 4
    //   79: invokevirtual 660	java/nio/channels/FileChannel:tryLock	()Ljava/nio/channels/FileLock;
    //   82: astore 6
    //   84: aload 6
    //   86: astore 5
    //   88: aload 5
    //   90: ifnull +8 -> 98
    //   93: aload 5
    //   95: invokevirtual 665	java/nio/channels/FileLock:release	()V
    //   98: aload 4
    //   100: ifnull +8 -> 108
    //   103: aload 4
    //   105: invokevirtual 666	java/nio/channels/FileChannel:close	()V
    //   108: iload_1
    //   109: istore_2
    //   110: aload_3
    //   111: ifnull +9 -> 120
    //   114: aload_3
    //   115: invokevirtual 474	java/io/RandomAccessFile:close	()V
    //   118: iload_1
    //   119: istore_2
    //   120: iload_2
    //   121: ireturn
    //   122: astore 6
    //   124: iconst_1
    //   125: istore_1
    //   126: goto -38 -> 88
    //   129: astore_3
    //   130: aconst_null
    //   131: astore_3
    //   132: iconst_0
    //   133: ifeq +11 -> 144
    //   136: new 668	java/lang/NullPointerException
    //   139: dup
    //   140: invokespecial 669	java/lang/NullPointerException:<init>	()V
    //   143: athrow
    //   144: iconst_0
    //   145: ifeq +11 -> 156
    //   148: new 668	java/lang/NullPointerException
    //   151: dup
    //   152: invokespecial 669	java/lang/NullPointerException:<init>	()V
    //   155: athrow
    //   156: aload_3
    //   157: ifnull -37 -> 120
    //   160: aload_3
    //   161: invokevirtual 474	java/io/RandomAccessFile:close	()V
    //   164: iconst_0
    //   165: ireturn
    //   166: astore_3
    //   167: iconst_0
    //   168: ireturn
    //   169: astore 5
    //   171: aconst_null
    //   172: astore_3
    //   173: aconst_null
    //   174: astore 4
    //   176: iconst_0
    //   177: ifeq +11 -> 188
    //   180: new 668	java/lang/NullPointerException
    //   183: dup
    //   184: invokespecial 669	java/lang/NullPointerException:<init>	()V
    //   187: athrow
    //   188: aload 4
    //   190: ifnull +8 -> 198
    //   193: aload 4
    //   195: invokevirtual 666	java/nio/channels/FileChannel:close	()V
    //   198: aload_3
    //   199: ifnull +7 -> 206
    //   202: aload_3
    //   203: invokevirtual 474	java/io/RandomAccessFile:close	()V
    //   206: aload 5
    //   208: athrow
    //   209: astore_3
    //   210: goto -4 -> 206
    //   213: astore 5
    //   215: aconst_null
    //   216: astore 4
    //   218: goto -42 -> 176
    //   221: astore 5
    //   223: goto -47 -> 176
    //   226: astore 4
    //   228: goto -96 -> 132
    //   231: astore_3
    //   232: iload_1
    //   233: ireturn
    //   234: aconst_null
    //   235: astore_3
    //   236: aconst_null
    //   237: astore 4
    //   239: goto -151 -> 88
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	242	0	this	c
    //   6	227	1	bool1	boolean
    //   4	117	2	bool2	boolean
    //   42	73	3	localObject1	Object
    //   129	1	3	localException1	Exception
    //   131	30	3	localObject2	Object
    //   166	1	3	localException2	Exception
    //   172	31	3	localObject3	Object
    //   209	1	3	localException3	Exception
    //   231	1	3	localException4	Exception
    //   235	1	3	localObject4	Object
    //   75	142	4	localFileChannel	java.nio.channels.FileChannel
    //   226	1	4	localException5	Exception
    //   237	1	4	localObject5	Object
    //   1	93	5	localObject6	Object
    //   169	38	5	localObject7	Object
    //   213	1	5	localObject8	Object
    //   221	1	5	localObject9	Object
    //   82	3	6	localFileLock	java.nio.channels.FileLock
    //   122	1	6	localException6	Exception
    // Exception table:
    //   from	to	target	type
    //   77	84	122	java/lang/Exception
    //   7	55	129	java/lang/Exception
    //   59	71	129	java/lang/Exception
    //   136	144	166	java/lang/Exception
    //   148	156	166	java/lang/Exception
    //   160	164	166	java/lang/Exception
    //   7	55	169	finally
    //   59	71	169	finally
    //   180	188	209	java/lang/Exception
    //   193	198	209	java/lang/Exception
    //   202	206	209	java/lang/Exception
    //   71	77	213	finally
    //   77	84	221	finally
    //   71	77	226	java/lang/Exception
    //   93	98	231	java/lang/Exception
    //   103	108	231	java/lang/Exception
    //   114	118	231	java/lang/Exception
  }
  
  private boolean f()
  {
    if (this.B) {
      if (this.C) {
        if (this.E < this.t)
        {
          this.D += this.p;
          if ((this.D > this.u) && (System.currentTimeMillis() - this.G <= this.v * 1000)) {
            break label186;
          }
        }
      }
    }
    do
    {
      do
      {
        return true;
        this.D = 0;
        this.C = false;
        return true;
      } while (this.E >= this.t);
      this.C = true;
      this.D = 0;
      this.D += this.p;
      return true;
      if ((this.E >= this.r) || (this.F >= this.s))
      {
        this.B = true;
        return true;
      }
    } while ((this.w == 1) && (System.currentTimeMillis() - this.G > this.x * 1000));
    label186:
    return false;
  }
  
  private void g()
  {
    this.M = null;
    this.e = 0L;
    this.L = 0;
    this.b = null;
    this.c = null;
    this.E = 0.0F;
    this.F = 0.0F;
  }
  
  private void h()
  {
    if ((this.e == 0L) || (System.currentTimeMillis() - this.e < this.p * 1000)) {}
    do
    {
      return;
      if (f.getServiceContext().getSharedPreferences("loc_navi_mode", 4).getBoolean("is_navi_on", false))
      {
        g();
        return;
      }
      if ((this.n == 1) && (!f()))
      {
        g();
        return;
      }
      if (!com.baidu.location.d.b.d.equals("com.ubercab.driver"))
      {
        if (!a(com.baidu.location.d.b.d, f.getServiceContext())) {
          g();
        }
      }
      else if (e())
      {
        g();
        return;
      }
    } while (this.M == null);
    int i2 = this.M.size();
    this.M.set(0, Byte.valueOf((byte)(i2 & 0xFF)));
    this.M.set(1, Byte.valueOf((byte)((0xFF00 & i2) >> 8)));
    this.M.set(3, Byte.valueOf((byte)(this.L & 0xFF)));
    byte[] arrayOfByte = new byte[i2];
    int i1 = 0;
    while (i1 < i2)
    {
      arrayOfByte[i1] = ((Byte)this.M.get(i1)).byteValue();
      i1 += 1;
    }
    Object localObject;
    if (Environment.getExternalStorageState().equals("mounted"))
    {
      localObject = new File(Environment.getExternalStorageDirectory(), "baidu/tempdata");
      if (!((File)localObject).exists()) {
        ((File)localObject).mkdirs();
      }
      if (((File)localObject).exists())
      {
        localObject = new File((File)localObject, "intime.dat");
        if (((File)localObject).exists()) {
          ((File)localObject).delete();
        }
      }
    }
    try
    {
      localObject = new BufferedOutputStream(new FileOutputStream((File)localObject));
      ((BufferedOutputStream)localObject).write(arrayOfByte);
      ((BufferedOutputStream)localObject).flush();
      ((BufferedOutputStream)localObject).close();
      new e(this).start();
      g();
      this.G = System.currentTimeMillis();
      return;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  private void i()
  {
    int i1 = 0;
    this.M.add(Byte.valueOf((byte)0));
    this.M.add(Byte.valueOf((byte)0));
    if (f.equals("0")) {
      this.M.add(Byte.valueOf((byte)110));
    }
    for (;;)
    {
      this.M.add(Byte.valueOf((byte)0));
      this.M.add(Byte.valueOf(this.J[0]));
      this.M.add(Byte.valueOf(this.J[1]));
      this.M.add(Byte.valueOf(this.J[2]));
      this.M.add(Byte.valueOf(this.J[3]));
      int i2 = this.K.length;
      this.M.add(Byte.valueOf((byte)(i2 + 1 & 0xFF)));
      while (i1 < i2)
      {
        this.M.add(Byte.valueOf(this.K[i1]));
        i1 += 1;
      }
      this.M.add(Byte.valueOf((byte)126));
    }
  }
  
  private void j()
  {
    if (System.currentTimeMillis() - this.z > 86400000L)
    {
      if (this.A == null) {
        this.A = new a();
      }
      StringBuffer localStringBuffer = new StringBuffer();
      localStringBuffer.append(com.baidu.location.d.b.a().a(false));
      localStringBuffer.append(a.a().c());
      this.A.a(localStringBuffer.toString());
    }
    k();
  }
  
  private void k() {}
  
  public void a(Location paramLocation)
  {
    if (!this.N) {
      c();
    }
    if ((this.k != 1) || (!this.m.contains(com.baidu.location.b.c.a(com.baidu.location.b.b.a().e()))) || ((this.n == 1) && (this.y > this.o))) {
      return;
    }
    this.I.post(new d(this, paramLocation));
  }
  
  public void b()
  {
    if (!this.N) {
      return;
    }
    this.N = false;
    g();
  }
  
  class a
    extends com.baidu.location.d.e
  {
    String a = null;
    
    public a()
    {
      this.k = new HashMap();
    }
    
    public void a()
    {
      this.h = "http://loc.map.baidu.com/cc.php";
      String str = Jni.encode(this.a);
      this.a = null;
      this.k.put("q", str);
    }
    
    public void a(String paramString)
    {
      this.a = paramString;
      e();
    }
    
    public void a(boolean paramBoolean)
    {
      if ((paramBoolean) && (this.j != null)) {}
      try
      {
        JSONObject localJSONObject = new JSONObject(this.j);
        localJSONObject.put("prod", com.baidu.location.d.b.d);
        localJSONObject.put("uptime", System.currentTimeMillis());
        c.a(c.this, localJSONObject.toString());
        if (this.k != null) {
          this.k.clear();
        }
        return;
      }
      catch (Exception localException)
      {
        for (;;) {}
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/location/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */