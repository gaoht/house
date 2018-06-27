package com.hyphenate.chat;

import android.util.Pair;
import com.amap.api.discover.Discover;
import com.amap.api.discover.Discover.AMapDiscoverListener;
import com.amap.api.netlocation.AMapNetworkLocationClient;
import com.hyphenate.chat.core.EMChatConfigPrivate;
import com.hyphenate.util.CryptoUtils;
import java.util.concurrent.atomic.AtomicBoolean;

class EMGDLocation
{
  public static final String TAG = "EMGDL";
  static EMGDLocation sInstance;
  private Object lock = new Object();
  private AtomicBoolean working = new AtomicBoolean(false);
  
  public static EMGDLocation getInstance()
  {
    try
    {
      if (sInstance == null) {
        sInstance = new EMGDLocation();
      }
      EMGDLocation localEMGDLocation = sInstance;
      return localEMGDLocation;
    }
    finally {}
  }
  
  Pair<Integer, String> getLocation()
  {
    Object localObject1 = null;
    for (;;)
    {
      try
      {
        this.working.set(true);
        if (!EMClient.getInstance().isConnected()) {
          break label305;
        }
        ??? = new Discover(EMClient.getInstance().getContext());
        try
        {
          localObject6 = EMClient.getInstance().getEncryptProvider();
          localObject8 = EMClient.getInstance().getChatConfigPrivate().A();
          str2 = EMClient.getInstance().getChatConfigPrivate().B();
          if (((String)localObject8).isEmpty()) {
            break label300;
          }
          ((Discover)???).setApiKey(new String(((EMEncryptProvider)localObject6).decrypt(CryptoUtils.fromHexString((String)localObject8), "")));
          localObject8 = new DiscoverResult(this.lock);
          ((Discover)???).setDiscoverListener((Discover.AMapDiscoverListener)localObject8);
          ((Discover)???).getDiscover();
        }
        catch (Exception localException)
        {
          Object localObject6;
          Object localObject8;
          String str2;
          localException.printStackTrace();
          this.working.set(false);
          Object localObject3 = null;
          continue;
        }
        finally
        {
          this.working.set(false);
        }
        synchronized (this.lock)
        {
          this.lock.wait(20000L);
          if (!this.working.get())
          {
            this.working.set(false);
            return (Pair<Integer, String>)localObject1;
          }
          i = ((DiscoverResult)localObject8).getTypeCode();
          if (!str2.isEmpty())
          {
            localObject1 = new String(((EMEncryptProvider)localObject6).decrypt(CryptoUtils.fromHexString(str2), ""));
            localObject6 = new AMapNetworkLocationClient(EMClient.getInstance().getContext());
            ((AMapNetworkLocationClient)localObject6).setApiKey((String)localObject1);
            localObject1 = ((AMapNetworkLocationClient)localObject6).getNetworkLocation();
            localObject1 = new Pair(Integer.valueOf(i), localObject1);
            this.working.set(false);
          }
        }
        str1 = "";
      }
      finally {}
      continue;
      label300:
      int i = -1;
      continue;
      label305:
      String str1 = null;
    }
  }
  
  public void onDestroy()
  {
    if ((this.lock != null) && (this.working.get() == true))
    {
      this.working.set(false);
      synchronized (this.lock)
      {
        this.lock.notify();
        return;
      }
    }
  }
  
  private class DiscoverResult
    implements Discover.AMapDiscoverListener
  {
    String discoverUser = "";
    Object mLock;
    int typeCode = -1;
    
    DiscoverResult(Object paramObject)
    {
      this.mLock = paramObject;
      this.discoverUser = EMClient.getInstance().getCurrentUser();
    }
    
    public int getTypeCode()
    {
      return this.typeCode;
    }
    
    /* Error */
    public void onDiscovered(com.amap.api.discover.DiscoverResult arg1, int paramInt)
    {
      // Byte code:
      //   0: ldc 51
      //   2: new 53	java/lang/StringBuilder
      //   5: dup
      //   6: invokespecial 54	java/lang/StringBuilder:<init>	()V
      //   9: ldc 56
      //   11: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   14: iload_2
      //   15: invokevirtual 63	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   18: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   21: invokestatic 72	com/hyphenate/util/EMLog:d	(Ljava/lang/String;Ljava/lang/String;)V
      //   24: iload_2
      //   25: sipush 1000
      //   28: if_icmpne +7 -> 35
      //   31: aload_1
      //   32: ifnonnull +25 -> 57
      //   35: aload_0
      //   36: getfield 32	com/hyphenate/chat/EMGDLocation$DiscoverResult:mLock	Ljava/lang/Object;
      //   39: astore_1
      //   40: aload_1
      //   41: monitorenter
      //   42: aload_0
      //   43: getfield 32	com/hyphenate/chat/EMGDLocation$DiscoverResult:mLock	Ljava/lang/Object;
      //   46: invokevirtual 75	java/lang/Object:notify	()V
      //   49: aload_1
      //   50: monitorexit
      //   51: return
      //   52: astore_3
      //   53: aload_1
      //   54: monitorexit
      //   55: aload_3
      //   56: athrow
      //   57: invokestatic 38	com/hyphenate/chat/EMClient:getInstance	()Lcom/hyphenate/chat/EMClient;
      //   60: invokevirtual 79	com/hyphenate/chat/EMClient:isConnected	()Z
      //   63: ifeq +58 -> 121
      //   66: aload_0
      //   67: getfield 30	com/hyphenate/chat/EMGDLocation$DiscoverResult:discoverUser	Ljava/lang/String;
      //   70: invokestatic 38	com/hyphenate/chat/EMClient:getInstance	()Lcom/hyphenate/chat/EMClient;
      //   73: invokevirtual 42	com/hyphenate/chat/EMClient:getCurrentUser	()Ljava/lang/String;
      //   76: invokevirtual 85	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   79: ifeq +42 -> 121
      //   82: aload_1
      //   83: invokevirtual 91	com/amap/api/discover/DiscoverResult:getPois	()Ljava/util/List;
      //   86: astore_1
      //   87: aload_1
      //   88: invokeinterface 96 1 0
      //   93: ifle +28 -> 121
      //   96: aload_1
      //   97: iconst_0
      //   98: invokeinterface 100 2 0
      //   103: checkcast 102	com/amap/api/discover/Poi
      //   106: astore_1
      //   107: aload_0
      //   108: aload_1
      //   109: invokevirtual 104	com/amap/api/discover/Poi:getTypeCode	()Ljava/lang/String;
      //   112: invokestatic 110	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
      //   115: invokevirtual 113	java/lang/Integer:intValue	()I
      //   118: putfield 26	com/hyphenate/chat/EMGDLocation$DiscoverResult:typeCode	I
      //   121: aload_0
      //   122: getfield 32	com/hyphenate/chat/EMGDLocation$DiscoverResult:mLock	Ljava/lang/Object;
      //   125: astore_1
      //   126: aload_1
      //   127: monitorenter
      //   128: aload_0
      //   129: getfield 32	com/hyphenate/chat/EMGDLocation$DiscoverResult:mLock	Ljava/lang/Object;
      //   132: invokevirtual 75	java/lang/Object:notify	()V
      //   135: aload_1
      //   136: monitorexit
      //   137: return
      //   138: astore_3
      //   139: aload_1
      //   140: monitorexit
      //   141: aload_3
      //   142: athrow
      //   143: astore_1
      //   144: aload_1
      //   145: invokevirtual 116	java/lang/Exception:printStackTrace	()V
      //   148: goto -27 -> 121
      //   151: astore_1
      //   152: aload_1
      //   153: invokevirtual 116	java/lang/Exception:printStackTrace	()V
      //   156: aload_0
      //   157: getfield 32	com/hyphenate/chat/EMGDLocation$DiscoverResult:mLock	Ljava/lang/Object;
      //   160: astore_1
      //   161: aload_1
      //   162: monitorenter
      //   163: aload_0
      //   164: getfield 32	com/hyphenate/chat/EMGDLocation$DiscoverResult:mLock	Ljava/lang/Object;
      //   167: invokevirtual 75	java/lang/Object:notify	()V
      //   170: aload_1
      //   171: monitorexit
      //   172: return
      //   173: astore_3
      //   174: aload_1
      //   175: monitorexit
      //   176: aload_3
      //   177: athrow
      //   178: astore_3
      //   179: aload_0
      //   180: getfield 32	com/hyphenate/chat/EMGDLocation$DiscoverResult:mLock	Ljava/lang/Object;
      //   183: astore_1
      //   184: aload_1
      //   185: monitorenter
      //   186: aload_0
      //   187: getfield 32	com/hyphenate/chat/EMGDLocation$DiscoverResult:mLock	Ljava/lang/Object;
      //   190: invokevirtual 75	java/lang/Object:notify	()V
      //   193: aload_1
      //   194: monitorexit
      //   195: aload_3
      //   196: athrow
      //   197: astore_3
      //   198: aload_1
      //   199: monitorexit
      //   200: aload_3
      //   201: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	202	0	this	DiscoverResult
      //   0	202	2	paramInt	int
      //   52	4	3	localObject1	Object
      //   138	4	3	localObject2	Object
      //   173	4	3	localObject3	Object
      //   178	18	3	localObject4	Object
      //   197	4	3	localObject5	Object
      // Exception table:
      //   from	to	target	type
      //   42	51	52	finally
      //   53	55	52	finally
      //   128	137	138	finally
      //   139	141	138	finally
      //   107	121	143	java/lang/Exception
      //   57	107	151	java/lang/Exception
      //   144	148	151	java/lang/Exception
      //   163	172	173	finally
      //   174	176	173	finally
      //   57	107	178	finally
      //   107	121	178	finally
      //   144	148	178	finally
      //   152	156	178	finally
      //   186	195	197	finally
      //   198	200	197	finally
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/hyphenate/chat/EMGDLocation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */