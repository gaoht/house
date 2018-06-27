package com.baidu.location;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Messenger;
import android.text.TextUtils;
import com.baidu.location.a.b.b;
import com.baidu.location.a.h;
import java.util.ArrayList;
import java.util.Iterator;

public final class LocationClient
  implements b.b
{
  private static final int MIN_REQUEST_SPAN = 1000;
  private static final int MSG_REG_LISTENER = 5;
  private static final int MSG_REG_NOTIFY_LISTENER = 8;
  private static final int MSG_REMOVE_NOTIFY = 10;
  private static final int MSG_REQ_LOC = 4;
  private static final int MSG_REQ_NOTIFY_LOC = 11;
  private static final int MSG_REQ_OFFLINE_LOC = 12;
  private static final int MSG_REQ_POI = 7;
  private static final int MSG_RIGSTER_NOTIFY = 9;
  private static final int MSG_SET_OPT = 3;
  private static final int MSG_START = 1;
  private static final int MSG_STOP = 2;
  private static final int MSG_UNREG_LISTENER = 6;
  private static final String TAG = "baidu_location_Client";
  private boolean clientFirst = false;
  private Boolean firstConnected = Boolean.valueOf(true);
  private boolean inDoorState = false;
  private boolean isScheduled = false;
  private boolean isStop = true;
  private boolean isWaitingForLocation = false;
  private boolean isWaitingLocTag = false;
  private long lastReceiveGpsTime = 0L;
  private long lastReceiveLocationTime = 0L;
  private ServiceConnection mConnection = new b(this);
  private Context mContext = null;
  private boolean mDebugByDev;
  private boolean mGpsStatus = false;
  private a mHandler = new a(null);
  private boolean mIsStarted = false;
  private String mKey;
  private BDLocation mLastLocation = null;
  private long mLastRequestTime = 0L;
  private ArrayList<BDLocationListener> mLocationListeners = null;
  private final Object mLock = new Object();
  private final Messenger mMessenger = new Messenger(this.mHandler);
  private LocationClientOption mOption = new LocationClientOption();
  private String mPackName = null;
  private b mScheduledRequest = null;
  private Messenger mServer = null;
  private com.baidu.location.a.b mloc = null;
  private boolean serverFirst = false;
  private String serviceName = null;
  
  public LocationClient(Context paramContext)
  {
    this.mContext = paramContext;
    this.mOption = new LocationClientOption();
  }
  
  public LocationClient(Context paramContext, LocationClientOption paramLocationClientOption)
  {
    this.mContext = paramContext;
    this.mOption = paramLocationClientOption;
  }
  
  private void callListeners(int paramInt)
  {
    if (this.mLastLocation.getCoorType() == null) {
      this.mLastLocation.setCoorType(this.mOption.coorType);
    }
    if ((this.isWaitingForLocation == true) || ((this.mOption.location_change_notify == true) && (this.mLastLocation.getLocType() == 61)) || (this.mLastLocation.getLocType() == 66) || (this.mLastLocation.getLocType() == 67) || (this.inDoorState) || (this.mLastLocation.getLocType() == 161))
    {
      if (this.mLocationListeners != null)
      {
        Iterator localIterator = this.mLocationListeners.iterator();
        while (localIterator.hasNext()) {
          ((BDLocationListener)localIterator.next()).onReceiveLocation(this.mLastLocation);
        }
      }
      if ((this.mLastLocation.getLocType() != 66) && (this.mLastLocation.getLocType() != 67)) {}
    }
    else
    {
      return;
    }
    this.isWaitingForLocation = false;
    this.lastReceiveLocationTime = System.currentTimeMillis();
  }
  
  public static BDLocation getBDLocationInCoorType(BDLocation paramBDLocation, String paramString)
  {
    BDLocation localBDLocation = new BDLocation(paramBDLocation);
    paramBDLocation = Jni.coorEncrypt(paramBDLocation.getLongitude(), paramBDLocation.getLatitude(), paramString);
    localBDLocation.setLatitude(paramBDLocation[1]);
    localBDLocation.setLongitude(paramBDLocation[0]);
    return localBDLocation;
  }
  
  private Bundle getOptionBundle()
  {
    if (this.mOption == null) {
      return null;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("packName", this.mPackName);
    localBundle.putString("prodName", this.mOption.prodName);
    localBundle.putString("coorType", this.mOption.coorType);
    localBundle.putString("addrType", this.mOption.addrType);
    localBundle.putBoolean("openGPS", this.mOption.openGps);
    localBundle.putBoolean("location_change_notify", this.mOption.location_change_notify);
    localBundle.putBoolean("enableSimulateGps", this.mOption.enableSimulateGps);
    localBundle.putInt("scanSpan", this.mOption.scanSpan);
    localBundle.putInt("timeOut", this.mOption.timeOut);
    localBundle.putInt("priority", this.mOption.priority);
    localBundle.putBoolean("map", false);
    localBundle.putBoolean("import", false);
    localBundle.putBoolean("needDirect", this.mOption.mIsNeedDeviceDirect);
    localBundle.putBoolean("isneedaptag", this.mOption.isNeedAptag);
    localBundle.putBoolean("isneedpoiregion", this.mOption.isNeedPoiRegion);
    localBundle.putBoolean("isneedregular", this.mOption.isNeedRegular);
    localBundle.putBoolean("isneedaptagd", this.mOption.isNeedAptagd);
    localBundle.putBoolean("isneedaltitude", this.mOption.isNeedAltitude);
    return localBundle;
  }
  
  private void onNewLocation(Message paramMessage, int paramInt)
  {
    if (!this.mIsStarted) {
      return;
    }
    try
    {
      paramMessage = paramMessage.getData();
      paramMessage.setClassLoader(BDLocation.class.getClassLoader());
      this.mLastLocation = ((BDLocation)paramMessage.getParcelable("locStr"));
      if (this.mLastLocation.getLocType() == 61) {
        this.lastReceiveGpsTime = System.currentTimeMillis();
      }
      callListeners(paramInt);
      return;
    }
    catch (Exception paramMessage) {}
  }
  
  private void onNewNotifyLocation(Message paramMessage) {}
  
  private void onRegisterListener(Message paramMessage)
  {
    if ((paramMessage == null) || (paramMessage.obj == null)) {}
    do
    {
      return;
      paramMessage = (BDLocationListener)paramMessage.obj;
      if (this.mLocationListeners == null) {
        this.mLocationListeners = new ArrayList();
      }
    } while (this.mLocationListeners.contains(paramMessage));
    this.mLocationListeners.add(paramMessage);
  }
  
  private void onRegisterNotifyLocationListener(Message paramMessage)
  {
    if ((paramMessage == null) || (paramMessage.obj == null)) {
      return;
    }
    paramMessage = (BDLocationListener)paramMessage.obj;
  }
  
  private void onRequestLocation()
  {
    if (this.mServer == null) {
      return;
    }
    if (((System.currentTimeMillis() - this.lastReceiveGpsTime > 3000L) || (!this.mOption.location_change_notify) || (this.isWaitingLocTag)) && ((!this.inDoorState) || (System.currentTimeMillis() - this.lastReceiveLocationTime > 20000L) || (this.isWaitingLocTag)))
    {
      ??? = Message.obtain(null, 22);
      if (this.isWaitingLocTag)
      {
        Bundle localBundle = new Bundle();
        this.isWaitingLocTag = false;
        localBundle.putBoolean("isWaitingLocTag", this.isWaitingLocTag);
        ((Message)???).setData(localBundle);
      }
    }
    try
    {
      ((Message)???).replyTo = this.mMessenger;
      this.mServer.send((Message)???);
      this.mLastRequestTime = System.currentTimeMillis();
      this.isWaitingForLocation = true;
      synchronized (this.mLock)
      {
        if ((this.mOption != null) && (this.mOption.scanSpan >= 1000) && (!this.isScheduled))
        {
          if (this.mScheduledRequest == null) {
            this.mScheduledRequest = new b(null);
          }
          this.mHandler.postDelayed(this.mScheduledRequest, this.mOption.scanSpan);
          this.isScheduled = true;
        }
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  private void onRequestNotifyLocation()
  {
    if (this.mServer == null) {
      return;
    }
    Message localMessage = Message.obtain(null, 22);
    try
    {
      localMessage.replyTo = this.mMessenger;
      this.mServer.send(localMessage);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void onRequestOffLineLocation()
  {
    Message localMessage = Message.obtain(null, 28);
    try
    {
      localMessage.replyTo = this.mMessenger;
      this.mServer.send(localMessage);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  /* Error */
  private void onSetOption(Message paramMessage)
  {
    // Byte code:
    //   0: aload_0
    //   1: iconst_0
    //   2: putfield 125	com/baidu/location/LocationClient:isWaitingLocTag	Z
    //   5: aload_1
    //   6: ifnull +10 -> 16
    //   9: aload_1
    //   10: getfield 446	android/os/Message:obj	Ljava/lang/Object;
    //   13: ifnonnull +4 -> 17
    //   16: return
    //   17: aload_1
    //   18: getfield 446	android/os/Message:obj	Ljava/lang/Object;
    //   21: checkcast 96	com/baidu/location/LocationClientOption
    //   24: astore_1
    //   25: aload_0
    //   26: getfield 99	com/baidu/location/LocationClient:mOption	Lcom/baidu/location/LocationClientOption;
    //   29: aload_1
    //   30: invokevirtual 485	com/baidu/location/LocationClientOption:optionEquals	(Lcom/baidu/location/LocationClientOption;)Z
    //   33: ifne -17 -> 16
    //   36: aload_0
    //   37: getfield 99	com/baidu/location/LocationClient:mOption	Lcom/baidu/location/LocationClientOption;
    //   40: getfield 372	com/baidu/location/LocationClientOption:scanSpan	I
    //   43: aload_1
    //   44: getfield 372	com/baidu/location/LocationClientOption:scanSpan	I
    //   47: if_icmpeq +95 -> 142
    //   50: aload_0
    //   51: getfield 133	com/baidu/location/LocationClient:mLock	Ljava/lang/Object;
    //   54: astore_2
    //   55: aload_2
    //   56: monitorenter
    //   57: aload_0
    //   58: getfield 127	com/baidu/location/LocationClient:isScheduled	Z
    //   61: iconst_1
    //   62: if_icmpne +19 -> 81
    //   65: aload_0
    //   66: getfield 110	com/baidu/location/LocationClient:mHandler	Lcom/baidu/location/LocationClient$a;
    //   69: aload_0
    //   70: getfield 129	com/baidu/location/LocationClient:mScheduledRequest	Lcom/baidu/location/LocationClient$b;
    //   73: invokevirtual 489	com/baidu/location/LocationClient$a:removeCallbacks	(Ljava/lang/Runnable;)V
    //   76: aload_0
    //   77: iconst_0
    //   78: putfield 127	com/baidu/location/LocationClient:isScheduled	Z
    //   81: aload_1
    //   82: getfield 372	com/baidu/location/LocationClientOption:scanSpan	I
    //   85: sipush 1000
    //   88: if_icmplt +52 -> 140
    //   91: aload_0
    //   92: getfield 127	com/baidu/location/LocationClient:isScheduled	Z
    //   95: ifne +45 -> 140
    //   98: aload_0
    //   99: getfield 129	com/baidu/location/LocationClient:mScheduledRequest	Lcom/baidu/location/LocationClient$b;
    //   102: ifnonnull +16 -> 118
    //   105: aload_0
    //   106: new 11	com/baidu/location/LocationClient$b
    //   109: dup
    //   110: aload_0
    //   111: aconst_null
    //   112: invokespecial 474	com/baidu/location/LocationClient$b:<init>	(Lcom/baidu/location/LocationClient;Lcom/baidu/location/b;)V
    //   115: putfield 129	com/baidu/location/LocationClient:mScheduledRequest	Lcom/baidu/location/LocationClient$b;
    //   118: aload_0
    //   119: getfield 110	com/baidu/location/LocationClient:mHandler	Lcom/baidu/location/LocationClient$a;
    //   122: aload_0
    //   123: getfield 129	com/baidu/location/LocationClient:mScheduledRequest	Lcom/baidu/location/LocationClient$b;
    //   126: aload_1
    //   127: getfield 372	com/baidu/location/LocationClientOption:scanSpan	I
    //   130: i2l
    //   131: invokevirtual 478	com/baidu/location/LocationClient$a:postDelayed	(Ljava/lang/Runnable;J)Z
    //   134: pop
    //   135: aload_0
    //   136: iconst_1
    //   137: putfield 127	com/baidu/location/LocationClient:isScheduled	Z
    //   140: aload_2
    //   141: monitorexit
    //   142: aload_0
    //   143: new 96	com/baidu/location/LocationClientOption
    //   146: dup
    //   147: aload_1
    //   148: invokespecial 492	com/baidu/location/LocationClientOption:<init>	(Lcom/baidu/location/LocationClientOption;)V
    //   151: putfield 99	com/baidu/location/LocationClient:mOption	Lcom/baidu/location/LocationClientOption;
    //   154: aload_0
    //   155: getfield 105	com/baidu/location/LocationClient:mServer	Landroid/os/Messenger;
    //   158: ifnull -142 -> 16
    //   161: aconst_null
    //   162: bipush 15
    //   164: invokestatic 462	android/os/Message:obtain	(Landroid/os/Handler;I)Landroid/os/Message;
    //   167: astore_1
    //   168: aload_1
    //   169: aload_0
    //   170: getfield 117	com/baidu/location/LocationClient:mMessenger	Landroid/os/Messenger;
    //   173: putfield 470	android/os/Message:replyTo	Landroid/os/Messenger;
    //   176: aload_1
    //   177: aload_0
    //   178: invokespecial 253	com/baidu/location/LocationClient:getOptionBundle	()Landroid/os/Bundle;
    //   181: invokevirtual 467	android/os/Message:setData	(Landroid/os/Bundle;)V
    //   184: aload_0
    //   185: getfield 105	com/baidu/location/LocationClient:mServer	Landroid/os/Messenger;
    //   188: aload_1
    //   189: invokevirtual 473	android/os/Messenger:send	(Landroid/os/Message;)V
    //   192: return
    //   193: astore_1
    //   194: aload_1
    //   195: invokevirtual 481	java/lang/Exception:printStackTrace	()V
    //   198: return
    //   199: astore_3
    //   200: aload_2
    //   201: monitorexit
    //   202: aload_3
    //   203: athrow
    //   204: astore_2
    //   205: goto -63 -> 142
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	208	0	this	LocationClient
    //   0	208	1	paramMessage	Message
    //   204	1	2	localException	Exception
    //   199	4	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   161	192	193	java/lang/Exception
    //   57	81	199	finally
    //   81	118	199	finally
    //   118	140	199	finally
    //   140	142	199	finally
    //   200	202	199	finally
    //   50	57	204	java/lang/Exception
    //   202	204	204	java/lang/Exception
  }
  
  private void onStart()
  {
    if (this.mIsStarted == true) {
      return;
    }
    if (this.firstConnected.booleanValue())
    {
      new c(this).start();
      this.firstConnected = Boolean.valueOf(false);
    }
    this.mPackName = this.mContext.getPackageName();
    this.serviceName = (this.mPackName + "_bdls_v2.9");
    Intent localIntent = new Intent(this.mContext, f.class);
    try
    {
      localIntent.putExtra("debug_dev", this.mDebugByDev);
      if (this.mOption == null) {
        this.mOption = new LocationClientOption();
      }
      localIntent.putExtra("cache_exception", this.mOption.isIgnoreCacheException);
      localIntent.putExtra("kill_process", this.mOption.isIgnoreKillProcess);
      try
      {
        this.mContext.bindService(localIntent, this.mConnection, 1);
        return;
      }
      catch (Exception localException1)
      {
        localException1.printStackTrace();
        this.mIsStarted = false;
        return;
      }
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        localException2.printStackTrace();
      }
    }
  }
  
  private void onStop()
  {
    if ((!this.mIsStarted) || (this.mServer == null)) {
      return;
    }
    ??? = Message.obtain(null, 12);
    ((Message)???).replyTo = this.mMessenger;
    try
    {
      this.mServer.send((Message)???);
    }
    catch (Exception localException2)
    {
      try
      {
        this.mContext.unbindService(this.mConnection);
      }
      catch (Exception localException2)
      {
        synchronized (this.mLock)
        {
          try
          {
            for (;;)
            {
              if (this.isScheduled == true)
              {
                this.mHandler.removeCallbacks(this.mScheduledRequest);
                this.isScheduled = false;
              }
              this.mServer = null;
              this.isWaitingLocTag = false;
              this.inDoorState = false;
              this.mIsStarted = false;
              this.clientFirst = false;
              this.serverFirst = false;
              return;
              localException1 = localException1;
              localException1.printStackTrace();
            }
            localException2 = localException2;
            localException2.printStackTrace();
          }
          catch (Exception localException3)
          {
            for (;;)
            {
              localException3.printStackTrace();
            }
          }
        }
      }
    }
  }
  
  private void onUnRegisterListener(Message paramMessage)
  {
    if ((paramMessage == null) || (paramMessage.obj == null)) {}
    do
    {
      return;
      paramMessage = (BDLocationListener)paramMessage.obj;
    } while ((this.mLocationListeners == null) || (!this.mLocationListeners.contains(paramMessage)));
    this.mLocationListeners.remove(paramMessage);
  }
  
  private void sendFirstLoc(BDLocation paramBDLocation)
  {
    if (this.isStop) {}
    for (;;)
    {
      return;
      this.mLastLocation = paramBDLocation;
      if ((!this.serverFirst) && (paramBDLocation.getLocType() == 161)) {
        this.clientFirst = true;
      }
      if (this.mLocationListeners != null)
      {
        Iterator localIterator = this.mLocationListeners.iterator();
        while (localIterator.hasNext()) {
          ((BDLocationListener)localIterator.next()).onReceiveLocation(paramBDLocation);
        }
      }
    }
  }
  
  public String getAccessKey()
  {
    try
    {
      this.mKey = h.b(this.mContext);
      if (TextUtils.isEmpty(this.mKey)) {
        throw new IllegalStateException("please setting key from Manifest.xml");
      }
      String str = String.format("KEY=%s", new Object[] { this.mKey });
      return str;
    }
    catch (Exception localException) {}
    return null;
  }
  
  public BDLocation getLastKnownLocation()
  {
    return this.mLastLocation;
  }
  
  public LocationClientOption getLocOption()
  {
    return this.mOption;
  }
  
  public String getVersion()
  {
    return "7.0.2";
  }
  
  public boolean isStarted()
  {
    return this.mIsStarted;
  }
  
  public void onReceiveLocation(BDLocation paramBDLocation)
  {
    if ((this.serverFirst == true) && (!this.clientFirst)) {}
    while (paramBDLocation == null) {
      return;
    }
    Message localMessage = this.mHandler.obtainMessage(701);
    localMessage.obj = paramBDLocation;
    localMessage.sendToTarget();
  }
  
  public void registerLocationListener(BDLocationListener paramBDLocationListener)
  {
    if (paramBDLocationListener == null) {
      throw new IllegalStateException("please set a non-null listener");
    }
    Message localMessage = this.mHandler.obtainMessage(5);
    localMessage.obj = paramBDLocationListener;
    localMessage.sendToTarget();
  }
  
  public void registerNotifyLocationListener(BDLocationListener paramBDLocationListener)
  {
    Message localMessage = this.mHandler.obtainMessage(8);
    localMessage.obj = paramBDLocationListener;
    localMessage.sendToTarget();
  }
  
  public int requestLocation()
  {
    if ((this.mServer == null) || (this.mMessenger == null)) {
      return 1;
    }
    if ((this.mLocationListeners == null) || (this.mLocationListeners.size() < 1)) {
      return 2;
    }
    if (System.currentTimeMillis() - this.mLastRequestTime < 1000L) {
      return 6;
    }
    this.isWaitingLocTag = true;
    Message localMessage = this.mHandler.obtainMessage(4);
    localMessage.arg1 = 0;
    localMessage.sendToTarget();
    return 0;
  }
  
  public void requestNotifyLocation()
  {
    this.mHandler.obtainMessage(11).sendToTarget();
  }
  
  public int requestOfflineLocation()
  {
    if ((this.mServer == null) || (this.mMessenger == null)) {
      return 1;
    }
    if ((this.mLocationListeners == null) || (this.mLocationListeners.size() < 1)) {
      return 2;
    }
    this.mHandler.obtainMessage(12).sendToTarget();
    return 0;
  }
  
  public void setLocOption(LocationClientOption paramLocationClientOption)
  {
    LocationClientOption localLocationClientOption = paramLocationClientOption;
    if (paramLocationClientOption == null) {
      localLocationClientOption = new LocationClientOption();
    }
    paramLocationClientOption = this.mHandler.obtainMessage(3);
    paramLocationClientOption.obj = localLocationClientOption;
    paramLocationClientOption.sendToTarget();
  }
  
  public void start()
  {
    this.isStop = false;
    this.mHandler.obtainMessage(1).sendToTarget();
  }
  
  public void stop()
  {
    this.isStop = true;
    this.mHandler.obtainMessage(2).sendToTarget();
    this.mloc = null;
  }
  
  public void unRegisterLocationListener(BDLocationListener paramBDLocationListener)
  {
    if (paramBDLocationListener == null) {
      throw new IllegalStateException("please set a non-null listener");
    }
    Message localMessage = this.mHandler.obtainMessage(6);
    localMessage.obj = paramBDLocationListener;
    localMessage.sendToTarget();
  }
  
  public boolean updateLocation(Location paramLocation)
  {
    if ((this.mServer == null) || (this.mMessenger == null) || (paramLocation == null)) {
      return false;
    }
    try
    {
      Message localMessage = Message.obtain(null, 57);
      localMessage.obj = paramLocation;
      this.mServer.send(localMessage);
      return true;
    }
    catch (Exception paramLocation)
    {
      for (;;)
      {
        paramLocation.printStackTrace();
      }
    }
  }
  
  private class a
    extends Handler
  {
    private a() {}
    
    public void handleMessage(Message paramMessage)
    {
      switch (paramMessage.what)
      {
      default: 
        super.handleMessage(paramMessage);
      case 7: 
      case 3: 
      case 8: 
      case 5: 
      case 6: 
      case 1: 
      case 2: 
      case 11: 
      case 4: 
      case 12: 
      case 54: 
      case 55: 
      case 21: 
        Object localObject;
        do
        {
          do
          {
            do
            {
              return;
              LocationClient.this.onSetOption(paramMessage);
              return;
              LocationClient.this.onRegisterNotifyLocationListener(paramMessage);
              return;
              LocationClient.this.onRegisterListener(paramMessage);
              return;
              LocationClient.this.onUnRegisterListener(paramMessage);
              return;
              LocationClient.this.onStart();
              return;
              LocationClient.this.onStop();
              return;
              LocationClient.this.onRequestNotifyLocation();
              return;
              LocationClient.this.onRequestLocation();
              return;
              LocationClient.this.onRequestOffLineLocation();
              return;
            } while (!LocationClient.this.mOption.location_change_notify);
            LocationClient.access$2602(LocationClient.this, true);
            return;
          } while (!LocationClient.this.mOption.location_change_notify);
          LocationClient.access$2602(LocationClient.this, false);
          return;
          localObject = paramMessage.getData();
          ((Bundle)localObject).setClassLoader(BDLocation.class.getClassLoader());
          localObject = (BDLocation)((Bundle)localObject).getParcelable("locStr");
        } while ((!LocationClient.this.serverFirst) && (LocationClient.this.clientFirst == true) && (((BDLocation)localObject).getLocType() == 66));
        if ((!LocationClient.this.serverFirst) && (LocationClient.this.clientFirst == true))
        {
          LocationClient.access$2702(LocationClient.this, true);
          return;
        }
        if (!LocationClient.this.serverFirst) {
          LocationClient.access$2702(LocationClient.this, true);
        }
        LocationClient.this.onNewLocation(paramMessage, 21);
        return;
      case 26: 
        LocationClient.this.onNewLocation(paramMessage, 26);
        return;
      case 27: 
        LocationClient.this.onNewNotifyLocation(paramMessage);
        return;
      }
      LocationClient.this.sendFirstLoc((BDLocation)paramMessage.obj);
    }
  }
  
  private class b
    implements Runnable
  {
    private b() {}
    
    public void run()
    {
      synchronized (LocationClient.this.mLock)
      {
        LocationClient.access$1302(LocationClient.this, false);
        if ((LocationClient.this.mServer == null) || (LocationClient.this.mMessenger == null)) {
          return;
        }
        if ((LocationClient.this.mLocationListeners == null) || (LocationClient.this.mLocationListeners.size() < 1)) {
          return;
        }
      }
      if (LocationClient.this.isWaitingLocTag)
      {
        if (LocationClient.this.mScheduledRequest == null) {
          LocationClient.access$1602(LocationClient.this, new b(LocationClient.this));
        }
        LocationClient.this.mHandler.postDelayed(LocationClient.this.mScheduledRequest, LocationClient.this.mOption.scanSpan);
        return;
      }
      LocationClient.this.mHandler.obtainMessage(4).sendToTarget();
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/location/LocationClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */