package cn.sharesdk.framework;

import cn.sharesdk.framework.b.b.f.a;
import cn.sharesdk.framework.utils.e;
import com.mob.MobSDK;
import com.mob.tools.log.NLog;
import com.mob.tools.utils.DeviceHelper;
import com.mob.tools.utils.Hashon;
import java.util.HashMap;

public abstract class Service
{
  public String getDeviceKey()
  {
    return DeviceHelper.getInstance(MobSDK.getContext()).getDeviceKey();
  }
  
  protected abstract int getServiceVersionInt();
  
  public abstract String getServiceVersionName();
  
  public void onBind() {}
  
  public void onUnbind() {}
  
  public static abstract class ServiceEvent
  {
    private static final int PLATFORM = 1;
    protected Service service;
    
    public ServiceEvent(Service paramService)
    {
      this.service = paramService;
    }
    
    protected HashMap<String, Object> filterShareContent(int paramInt, Platform.ShareParams paramShareParams, HashMap<String, Object> paramHashMap)
    {
      paramShareParams = ShareSDK.getPlatform(ShareSDK.platformIdToName(paramInt)).filterShareContent(paramShareParams, paramHashMap);
      paramHashMap = new HashMap();
      paramHashMap.put("shareID", paramShareParams.a);
      paramHashMap.put("shareContent", new Hashon().fromJson(paramShareParams.toString()));
      e.b().i("filterShareContent ==>>%s", new Object[] { paramHashMap });
      return paramHashMap;
    }
    
    protected HashMap<String, Object> toMap()
    {
      HashMap localHashMap = new HashMap();
      DeviceHelper localDeviceHelper = DeviceHelper.getInstance(MobSDK.getContext());
      localHashMap.put("deviceid", localDeviceHelper.getDeviceKey());
      localHashMap.put("appkey", MobSDK.getAppkey());
      localHashMap.put("apppkg", localDeviceHelper.getPackageName());
      localHashMap.put("appver", Integer.valueOf(localDeviceHelper.getAppVersion()));
      localHashMap.put("sdkver", Integer.valueOf(this.service.getServiceVersionInt()));
      localHashMap.put("plat", Integer.valueOf(1));
      localHashMap.put("networktype", localDeviceHelper.getDetailNetworkTypeForStatic());
      localHashMap.put("deviceData", localDeviceHelper.getDeviceDataNotAES());
      return localHashMap;
    }
    
    public final String toString()
    {
      return new Hashon().fromHashMap(toMap());
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/sharesdk/framework/Service.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */