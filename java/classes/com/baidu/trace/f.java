package com.baidu.trace;

import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.telephony.CellIdentityCdma;
import android.telephony.CellIdentityGsm;
import android.telephony.CellIdentityLte;
import android.telephony.CellIdentityWcdma;
import android.telephony.CellInfo;
import android.telephony.CellInfoCdma;
import android.telephony.CellInfoGsm;
import android.telephony.CellInfoLte;
import android.telephony.CellInfoWcdma;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Random;

public final class f
{
  private static Method d = null;
  private static Method e = null;
  private static Method f = null;
  private static Class<?> g = null;
  private static char[] m = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_.".toCharArray();
  private Context a = null;
  private TelephonyManager b = null;
  private a c = new a(this, (byte)0);
  private WifiManager h = null;
  private a i = null;
  private String j = null;
  private int k = 0;
  private String l = null;
  
  public f(Context paramContext)
  {
    this.a = paramContext.getApplicationContext();
    String str = this.a.getPackageName();
    try
    {
      this.b = ((TelephonyManager)this.a.getSystemService("phone"));
      paramContext = this.b.getDeviceId();
      this.l = ("&" + str + "&" + paramContext);
      this.h = ((WifiManager)this.a.getSystemService("wifi"));
      return;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        paramContext = null;
      }
    }
  }
  
  private a a(CellInfo paramCellInfo)
  {
    int n = 0;
    int i1 = Integer.valueOf(Build.VERSION.SDK_INT).intValue();
    if (i1 < 17) {
      return null;
    }
    a locala = new a(this, (byte)0);
    Object localObject;
    if ((paramCellInfo instanceof CellInfoGsm))
    {
      localObject = ((CellInfoGsm)paramCellInfo).getCellIdentity();
      locala.c = b(((CellIdentityGsm)localObject).getMcc());
      locala.d = b(((CellIdentityGsm)localObject).getMnc());
      locala.a = b(((CellIdentityGsm)localObject).getLac());
      locala.b = b(((CellIdentityGsm)localObject).getCid());
      locala.e = 'g';
      n = 1;
    }
    for (;;)
    {
      if ((i1 >= 18) && (n == 0)) {}
      try
      {
        if ((paramCellInfo instanceof CellInfoWcdma))
        {
          paramCellInfo = ((CellInfoWcdma)paramCellInfo).getCellIdentity();
          locala.c = b(paramCellInfo.getMcc());
          locala.d = b(paramCellInfo.getMnc());
          locala.a = b(paramCellInfo.getLac());
          locala.b = b(paramCellInfo.getCid());
          locala.e = 'g';
        }
        return locala;
        if ((paramCellInfo instanceof CellInfoCdma))
        {
          localObject = ((CellInfoCdma)paramCellInfo).getCellIdentity();
          locala.d = b(((CellIdentityCdma)localObject).getSystemId());
          locala.a = b(((CellIdentityCdma)localObject).getNetworkId());
          locala.b = b(((CellIdentityCdma)localObject).getBasestationId());
          locala.e = 'w';
          n = 1;
          continue;
        }
        if (!(paramCellInfo instanceof CellInfoLte)) {
          continue;
        }
        localObject = ((CellInfoLte)paramCellInfo).getCellIdentity();
        locala.c = b(((CellIdentityLte)localObject).getMcc());
        locala.d = b(((CellIdentityLte)localObject).getMnc());
        locala.a = b(((CellIdentityLte)localObject).getTac());
        locala.b = b(((CellIdentityLte)localObject).getCi());
        locala.e = 'g';
        n = 1;
      }
      catch (Exception paramCellInfo)
      {
        for (;;) {}
      }
    }
  }
  
  private String a(int paramInt)
  {
    try
    {
      localObject1 = b();
      if ((localObject1 != null) && (a.a((a)localObject1))) {
        break label586;
      }
      localObject1 = this.b.getCellLocation();
      if ((localObject1 != null) && (this.b != null)) {
        break label156;
      }
      localObject1 = this.c.a();
    }
    catch (Exception localException4)
    {
      for (;;)
      {
        Object localObject1;
        Object localObject5;
        label156:
        int n;
        int i1;
        label361:
        label586:
        label595:
        int i2;
        int i3;
        label837:
        Object localObject3;
        label987:
        Object localObject4 = null;
        continue;
        for (;;)
        {
          label1020:
          i4 = i3 + 1;
          i3 = n;
          n = paramInt;
          paramInt = i3;
          i3 = i4;
          break;
          label1041:
          if (paramInt > i2)
          {
            i4 = n;
            if (i1 != 0) {
              break label837;
            }
          }
        }
        label1057:
        int i4 = paramInt;
      }
    }
    if (localObject1 == null) {}
    for (localObject5 = "Z";; localObject5 = localObject3)
    {
      try
      {
        if ((this.i == null) || (a.a(this.i))) {
          this.i = new a(this.h.getScanResults());
        }
        localObject1 = this.i;
        paramInt = ((a)localObject1).a();
        if (paramInt > 0) {
          break label595;
        }
        localObject1 = null;
      }
      catch (Exception localException3)
      {
        for (;;)
        {
          localObject3 = null;
        }
      }
      Object localObject6 = localObject5;
      if (localObject1 != null) {
        localObject6 = (String)localObject5 + (String)localObject1;
      }
      if (((String)localObject6).equals("Z"))
      {
        return null;
        localObject5 = new a(this, (byte)0);
        localObject6 = this.b.getNetworkOperator();
        if (localObject6 != null)
        {
          paramInt = ((String)localObject6).length();
          if (paramInt > 0) {
            n = 0;
          }
        }
      }
      try
      {
        if (((String)localObject6).length() >= 3)
        {
          i1 = Integer.valueOf(((String)localObject6).substring(0, 3)).intValue();
          paramInt = i1;
          if (i1 < 0) {
            paramInt = this.c.c;
          }
          ((a)localObject5).c = paramInt;
        }
        localObject6 = ((String)localObject6).substring(3);
        if (localObject6 != null)
        {
          localObject7 = ((String)localObject6).toCharArray();
          paramInt = 0;
          for (;;)
          {
            n = paramInt;
            if (paramInt >= localObject7.length) {
              break;
            }
            n = paramInt;
            if (!Character.isDigit(localObject7[paramInt])) {
              break;
            }
            paramInt += 1;
          }
        }
        n = Integer.valueOf(((String)localObject6).substring(0, n)).intValue();
        paramInt = n;
        if (n < 0) {
          paramInt = this.c.d;
        }
        ((a)localObject5).d = paramInt;
      }
      catch (Exception localException5)
      {
        Object localObject7;
        boolean bool;
        for (;;) {}
        i4 = paramInt;
        paramInt = n;
        n = i4;
      }
      if ((localObject1 instanceof GsmCellLocation))
      {
        ((a)localObject5).a = ((GsmCellLocation)localObject1).getLac();
        ((a)localObject5).b = ((GsmCellLocation)localObject1).getCid();
        ((a)localObject5).e = 'g';
      }
      while (!(localObject1 instanceof CdmaCellLocation))
      {
        if (!a.a((a)localObject5)) {
          break;
        }
        this.c = ((a)localObject5);
        break;
      }
      ((a)localObject5).e = 'w';
      localObject6 = g;
      if (localObject6 == null) {}
      try
      {
        localObject6 = Class.forName("android.telephony.cdma.CdmaCellLocation");
        g = (Class)localObject6;
        d = ((Class)localObject6).getMethod("getBaseStationId", new Class[0]);
        e = g.getMethod("getNetworkId", new Class[0]);
        f = g.getMethod("getSystemId", new Class[0]);
        if (g == null) {
          break label361;
        }
        bool = g.isInstance(localObject1);
        if (!bool) {
          break label361;
        }
        try
        {
          n = ((Integer)f.invoke(localObject1, new Object[0])).intValue();
          paramInt = n;
          if (n < 0) {
            paramInt = this.c.d;
          }
          ((a)localObject5).d = paramInt;
          ((a)localObject5).b = ((Integer)d.invoke(localObject1, new Object[0])).intValue();
          ((a)localObject5).a = ((Integer)e.invoke(localObject1, new Object[0])).intValue();
        }
        catch (Exception localException1) {}
      }
      catch (Exception localException2)
      {
        g = null;
      }
      break;
      this.c = localException2;
      break;
      i1 = 1;
      bool = localException2.b.c();
      if (bool) {
        i1 = 0;
      }
      for (i2 = 9;; i2 = 10)
      {
        localObject7 = new StringBuffer(512);
        int i5 = localException2.a.size();
        paramInt = 1;
        n = 0;
        i3 = 0;
        if (i3 >= i5) {
          break label1057;
        }
        if (((ScanResult)localException2.a.get(i3)).level != 0)
        {
          localObject6 = ((ScanResult)localException2.a.get(i3)).BSSID;
          i4 = ((ScanResult)localException2.a.get(i3)).level;
          localObject6 = ((String)localObject6).replace(":", "");
          if ((localException2.b.j != null) && (((String)localObject6).equals(localException2.b.j)))
          {
            localException2.b.k = StrictMath.abs(i4);
            i1 = paramInt;
            i4 = 1;
            paramInt = n;
            n = i1;
            i1 = i4;
            break label1020;
          }
          if (n >= i2) {
            break label987;
          }
          ((StringBuffer)localObject7).append("h");
          ((StringBuffer)localObject7).append((String)localObject6);
          ((StringBuffer)localObject7).append("m");
          ((StringBuffer)localObject7).append(StrictMath.abs(i4));
          paramInt = n + 1;
          n = 0;
          break label1041;
          localObject6 = null;
          if (bool) {
            localObject6 = "h" + localException2.b.j + "km" + localException2.b.k;
          }
          Object localObject2 = localObject6;
          if (i4 != 0) {
            break;
          }
          localObject2 = (String)localObject6 + ((StringBuffer)localObject7).toString();
          break;
          return a((String)localObject6 + "t" + System.currentTimeMillis() + this.l);
        }
        i4 = paramInt;
        paramInt = n;
        n = i4;
        break label1041;
      }
    }
  }
  
  private static String a(String paramString)
  {
    int i3 = 0;
    if (paramString == null) {
      return null;
    }
    paramString = paramString.getBytes();
    int n = (byte)new Random().nextInt(255);
    int i1 = (byte)new Random().nextInt(255);
    byte[] arrayOfByte = new byte[paramString.length + 2];
    int i4 = paramString.length;
    int i2 = 0;
    while (i3 < i4)
    {
      arrayOfByte[i2] = ((byte)(paramString[i3] ^ n));
      i3 += 1;
      i2 += 1;
    }
    arrayOfByte[i2] = n;
    arrayOfByte[(i2 + 1)] = i1;
    return a(arrayOfByte);
  }
  
  private static String a(byte[] paramArrayOfByte)
  {
    char[] arrayOfChar1 = new char[(paramArrayOfByte.length + 2) / 3 << 2];
    int n = 0;
    int i1 = 0;
    int i3;
    if (i1 < paramArrayOfByte.length)
    {
      i3 = (paramArrayOfByte[i1] & 0xFF) << 8;
      if (i1 + 1 >= paramArrayOfByte.length) {
        break label237;
      }
      i3 |= paramArrayOfByte[(i1 + 1)] & 0xFF;
    }
    label110:
    label215:
    label237:
    for (int i2 = 1;; i2 = 0)
    {
      i3 <<= 8;
      if (i1 + 2 < paramArrayOfByte.length) {
        i3 |= paramArrayOfByte[(i1 + 2)] & 0xFF;
      }
      for (int i4 = 1;; i4 = 0)
      {
        char[] arrayOfChar2 = m;
        if (i4 != 0)
        {
          i4 = 63 - (i3 & 0x3F);
          arrayOfChar1[(n + 3)] = arrayOfChar2[i4];
          i3 >>= 6;
          arrayOfChar2 = m;
          if (i2 == 0) {
            break label215;
          }
        }
        for (i2 = 63 - (i3 & 0x3F);; i2 = 64)
        {
          arrayOfChar1[(n + 2)] = arrayOfChar2[i2];
          i2 = i3 >> 6;
          arrayOfChar1[(n + 1)] = m[(63 - (i2 & 0x3F))];
          arrayOfChar1[n] = m[(63 - (i2 >> 6 & 0x3F))];
          i1 += 3;
          n += 4;
          break;
          i4 = 64;
          break label110;
        }
        return new String(arrayOfChar1);
      }
    }
  }
  
  private static int b(int paramInt)
  {
    int n = paramInt;
    if (paramInt == Integer.MAX_VALUE) {
      n = -1;
    }
    return n;
  }
  
  /* Error */
  private a b()
  {
    // Byte code:
    //   0: getstatic 123	android/os/Build$VERSION:SDK_INT	I
    //   3: invokestatic 129	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   6: invokevirtual 133	java/lang/Integer:intValue	()I
    //   9: bipush 17
    //   11: if_icmpge +5 -> 16
    //   14: aconst_null
    //   15: areturn
    //   16: aload_0
    //   17: getfield 61	com/baidu/trace/f:b	Landroid/telephony/TelephonyManager;
    //   20: invokevirtual 387	android/telephony/TelephonyManager:getAllCellInfo	()Ljava/util/List;
    //   23: astore_2
    //   24: aload_2
    //   25: ifnull -11 -> 14
    //   28: aload_2
    //   29: invokeinterface 312 1 0
    //   34: ifle -20 -> 14
    //   37: aload_2
    //   38: invokeinterface 391 1 0
    //   43: astore 4
    //   45: aconst_null
    //   46: astore_2
    //   47: aload 4
    //   49: invokeinterface 396 1 0
    //   54: ifeq +61 -> 115
    //   57: aload 4
    //   59: invokeinterface 400 1 0
    //   64: checkcast 402	android/telephony/CellInfo
    //   67: astore_3
    //   68: aload_3
    //   69: invokevirtual 405	android/telephony/CellInfo:isRegistered	()Z
    //   72: ifeq -25 -> 47
    //   75: aload_0
    //   76: aload_3
    //   77: invokespecial 407	com/baidu/trace/f:a	(Landroid/telephony/CellInfo;)Lcom/baidu/trace/a;
    //   80: astore_3
    //   81: aload_3
    //   82: astore_2
    //   83: aload_2
    //   84: ifnull +28 -> 112
    //   87: aload_2
    //   88: invokestatic 216	com/baidu/trace/a:a	(Lcom/baidu/trace/a;)Z
    //   91: istore_1
    //   92: iload_1
    //   93: ifne +5 -> 98
    //   96: aconst_null
    //   97: astore_2
    //   98: aload_2
    //   99: areturn
    //   100: astore_2
    //   101: aconst_null
    //   102: areturn
    //   103: astore_2
    //   104: aconst_null
    //   105: areturn
    //   106: astore_3
    //   107: aload_2
    //   108: areturn
    //   109: astore_3
    //   110: aload_2
    //   111: areturn
    //   112: goto -65 -> 47
    //   115: aload_2
    //   116: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	117	0	this	f
    //   91	2	1	bool	boolean
    //   23	76	2	localObject1	Object
    //   100	1	2	localNoSuchMethodError	NoSuchMethodError
    //   103	13	2	localException1	Exception
    //   67	15	3	localObject2	Object
    //   106	1	3	localException2	Exception
    //   109	1	3	localException3	Exception
    //   43	15	4	localIterator	java.util.Iterator
    // Exception table:
    //   from	to	target	type
    //   16	24	100	java/lang/NoSuchMethodError
    //   28	45	100	java/lang/NoSuchMethodError
    //   47	81	100	java/lang/NoSuchMethodError
    //   87	92	100	java/lang/NoSuchMethodError
    //   16	24	103	java/lang/Exception
    //   28	45	103	java/lang/Exception
    //   47	81	106	java/lang/Exception
    //   87	92	109	java/lang/Exception
  }
  
  private boolean c()
  {
    this.j = null;
    this.k = 0;
    Object localObject = this.h.getConnectionInfo();
    if (localObject == null) {}
    for (;;)
    {
      return false;
      try
      {
        String str = ((WifiInfo)localObject).getBSSID();
        localObject = "";
        if (str != null) {
          localObject = str.replace(":", "");
        }
        if (((String)localObject).length() == 12)
        {
          this.j = new String((String)localObject);
          return true;
        }
      }
      catch (Exception localException) {}
    }
    return false;
  }
  
  public final String a()
  {
    try
    {
      String str = a(10);
      return str;
    }
    catch (Exception localException) {}
    return null;
  }
  
  public final class a
  {
    public List<ScanResult> a = null;
    private long c = 0L;
    
    public a()
    {
      List localList;
      this.a = localList;
      this.c = System.currentTimeMillis();
      b();
    }
    
    private void b()
    {
      if (a() <= 0) {
        return;
      }
      int j = this.a.size() - 1;
      int i = 1;
      label22:
      int k;
      if ((j > 0) && (i != 0))
      {
        k = 0;
        i = 0;
        label34:
        if (k < j)
        {
          if (((ScanResult)this.a.get(k)).level >= ((ScanResult)this.a.get(k + 1)).level) {
            break label145;
          }
          ScanResult localScanResult = (ScanResult)this.a.get(k + 1);
          this.a.set(k + 1, this.a.get(k));
          this.a.set(k, localScanResult);
          i = 1;
        }
      }
      label145:
      for (;;)
      {
        k += 1;
        break label34;
        j -= 1;
        break label22;
        break;
      }
    }
    
    public final int a()
    {
      if (this.a == null) {
        return 0;
      }
      return this.a.size();
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/trace/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */