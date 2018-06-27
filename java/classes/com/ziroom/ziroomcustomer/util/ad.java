package com.ziroom.ziroomcustomer.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.alibaba.fastjson.a;
import com.baidu.mapapi.model.LatLng;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.b;
import com.ziroom.ziroomcustomer.findhouse.model.MapPlanNode;
import com.ziroom.ziroomcustomer.home.bean.ImageInfo;
import com.ziroom.ziroomcustomer.model.Advertisement;
import com.ziroom.ziroomcustomer.model.UserInfo;
import com.ziroom.ziroomcustomer.newServiceList.model.be;
import com.ziroom.ziroomcustomer.newclean.periodclean.bean.FrequencyBean;
import com.ziroom.ziroomcustomer.newclean.periodclean.bean.ServiceTimeLongBean;
import com.ziroom.ziroomcustomer.newmovehouse.model.Address;
import com.ziroom.ziroomcustomer.newmovehouse.model.SmallMoveAddressBean;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ad
{
  public static void clearUser(Context paramContext)
  {
    paramContext = paramContext.getSharedPreferences("USER", 0).edit();
    paramContext.remove("uid");
    paramContext.remove("loginName");
    paramContext.remove("token");
    paramContext.apply();
  }
  
  public static Advertisement getAdvertisement(Context paramContext)
  {
    paramContext = paramContext.getSharedPreferences("welcome_advertisement", 0);
    Advertisement localAdvertisement = new Advertisement();
    localAdvertisement.setTitle(paramContext.getString("title", "2"));
    localAdvertisement.setSubtitle(paramContext.getString("subtitle", ""));
    localAdvertisement.setPic(paramContext.getString("pic", "pic"));
    localAdvertisement.setTypes(paramContext.getString("types", "1"));
    localAdvertisement.setRgb(paramContext.getString("rgb", "0"));
    localAdvertisement.setUrl(paramContext.getString("url", ""));
    return localAdvertisement;
  }
  
  public static int getAppUpdateNum(Context paramContext)
  {
    return paramContext.getSharedPreferences("app_update_num", 0).getInt("app_update_num", 0);
  }
  
  public static long getAppUpdateTime(Context paramContext)
  {
    return paramContext.getSharedPreferences("app_update_time", 0).getLong("app_update_time", 0L);
  }
  
  public static int getAppUpdateVersion(Context paramContext)
  {
    return paramContext.getSharedPreferences("app_update_code", 0).getInt("app_update_code", 0);
  }
  
  public static String getAppVersion(Context paramContext)
  {
    return paramContext.getSharedPreferences("app_version", 0).getString("app_version", "");
  }
  
  public static boolean getBoolean(Context paramContext, String paramString)
  {
    return paramContext.getSharedPreferences("settingState", 0).getBoolean(paramString, false);
  }
  
  public static String getBrowserPackageName(Context paramContext)
  {
    return paramContext.getSharedPreferences("browser_package_name", 0).getString("browser_package_name", "");
  }
  
  public static String getCityLocaton(Context paramContext, String paramString)
  {
    return paramContext.getSharedPreferences("citylocation", 0).getString(paramString, "");
  }
  
  public static long getCleanServiceTime(Context paramContext)
  {
    return paramContext.getSharedPreferences("time", 0).getLong("cleanServiceTime", 0L);
  }
  
  public static String getEasyPayTag(Context paramContext)
  {
    return paramContext.getSharedPreferences("easy_pay_tag", 0).getString("easy_tag", "");
  }
  
  public static String getFiveImgUrl(Context paramContext)
  {
    return paramContext.getSharedPreferences("five_year", 0).getString("imgUrl", "");
  }
  
  public static String getFiveYearUrl(Context paramContext)
  {
    return paramContext.getSharedPreferences("five_year", 0).getString("linkUrl", "");
  }
  
  public static long getGateWayDiffTime(Context paramContext)
  {
    return paramContext.getSharedPreferences("Web_gateway_difftime", 0).getLong("gateway_difftime", 0L);
  }
  
  public static String getLockHouseCode(Context paramContext)
  {
    return paramContext.getSharedPreferences("Intel_lock", 0).getString("Intel_lock_house_code", "");
  }
  
  public static int getLockLeftTime(Context paramContext)
  {
    return paramContext.getSharedPreferences("Intel_lock_houseCode", 0).getInt("Intel_lock_left_time", 0);
  }
  
  public static String getLockTime(Context paramContext)
  {
    return paramContext.getSharedPreferences("Intel_lock_houseCode", 0).getString("Intel_lock_time", "");
  }
  
  public static String getMeetaTag(Context paramContext)
  {
    return paramContext.getSharedPreferences("meeta_tag", 0).getString("meeta_tag", "");
  }
  
  public static SmallMoveAddressBean getMiddleMoveStartAddressData(Context paramContext, String paramString)
  {
    String str = "";
    if (ApplicationEx.c.getUser() != null) {
      str = "_" + ApplicationEx.c.getUser().getUid();
    }
    paramContext = paramContext.getSharedPreferences(paramString + str + "_" + b.d, 0);
    paramString = new SmallMoveAddressBean();
    paramString.setStart_latlng(paramContext.getString("start_latlng", ""));
    paramString.setLatlng_map_lat(paramContext.getString("latlng_map_lat", ""));
    paramString.setLatlng_map_lng(paramContext.getString("latlng_map_lng", ""));
    paramString.setAddress_location(paramContext.getString("address_location", ""));
    paramString.setAddress_detail(paramContext.getString("address_detail", ""));
    paramString.setElevator(paramContext.getInt("elevator", 0));
    paramString.setFloors(paramContext.getInt("floors", 0));
    paramString.setFloorsFee(paramContext.getString("floorsFee", ""));
    return paramString;
  }
  
  public static Boolean getMinsuLandReleaseHint(Context paramContext)
  {
    return Boolean.valueOf(paramContext.getSharedPreferences("minsu_ll_release", 0).getBoolean("minsu_ll_release", true));
  }
  
  public static Boolean getMinsuMainTodayHint(Context paramContext)
  {
    return Boolean.valueOf(paramContext.getSharedPreferences("minsu_main_tab_red_ll", 0).getBoolean("minsu_main_tab_red_ll", true));
  }
  
  public static String getMinsuMainTodayHintTime(Context paramContext)
  {
    return paramContext.getSharedPreferences("minsu_main_tab_red_ll", 0).getString("hint_time", "");
  }
  
  public static Boolean getMinsuTodayMainNew(Context paramContext)
  {
    return Boolean.valueOf(paramContext.getSharedPreferences("minsu_today_main_new", 0).getBoolean("minsu_today_main_new", true));
  }
  
  public static Address getMovingVanAddressData(Context paramContext, String paramString)
  {
    String str = "";
    if (ApplicationEx.c.getUser() != null) {
      str = "_" + ApplicationEx.c.getUser().getUid();
    }
    paramContext = paramContext.getSharedPreferences(paramString + str + "_" + b.d, 0);
    paramString = new Address();
    paramString.orderAddress = paramContext.getString("address_location", "");
    paramString.orderDoorplate = paramContext.getString("address_detail", "");
    paramString.addressLat = paramContext.getString("latlng_map_lat", "");
    paramString.addressLon = paramContext.getString("latlng_map_lng", "");
    paramString.isElevator = paramContext.getInt("elevator", 0);
    paramString.floors = paramContext.getInt("floors", 0);
    return paramString;
  }
  
  public static String getNetPicConfig(Context paramContext)
  {
    return paramContext.getSharedPreferences("mona_config", 0).getString("mona_config", "");
  }
  
  public static String getOther(Context paramContext, String paramString)
  {
    return paramContext.getSharedPreferences("othercase_key", 0).getString(paramString, "");
  }
  
  public static FrequencyBean getPeriodCleanFrequency(Context paramContext)
  {
    return (FrequencyBean)a.parseObject(paramContext.getSharedPreferences("service_period_clean_frequency", 0).getString("frequency", ""), FrequencyBean.class);
  }
  
  public static ServiceTimeLongBean getPeriodCleanTimePeriod(Context paramContext)
  {
    return (ServiceTimeLongBean)a.parseObject(paramContext.getSharedPreferences("service_period_clean_time_period", 0).getString("mCurrentSelectServiceTimeLongBean", ""), ServiceTimeLongBean.class);
  }
  
  public static String getProject(Context paramContext)
  {
    return paramContext.getSharedPreferences("zryu_list", 0).getString("zryu_list", "");
  }
  
  public static MapPlanNode getResblockMapCompany(Context paramContext)
  {
    Object localObject = paramContext.getSharedPreferences("resblockMapCompany", 0);
    paramContext = new MapPlanNode();
    paramContext.setName(((SharedPreferences)localObject).getString("name", ""));
    String str = ((SharedPreferences)localObject).getString("lat", "0");
    localObject = ((SharedPreferences)localObject).getString("lng", "0");
    paramContext.setLatlng(new LatLng(Double.parseDouble(str), Double.parseDouble((String)localObject)));
    return paramContext;
  }
  
  public static List<ImageInfo> getRollImage(Context paramContext, String paramString)
  {
    int i = 0;
    ArrayList localArrayList = new ArrayList();
    paramString = paramContext.getSharedPreferences("rollimage" + paramString, 0);
    paramContext = paramString.getString("imageUrl", "");
    paramString = paramString.getString("adUrl", "");
    if ((!TextUtils.isEmpty(paramContext)) && (!TextUtils.isEmpty(paramString)))
    {
      paramContext = paramContext.split(",");
      paramString = paramString.split(",");
      while (i < paramContext.length)
      {
        ImageInfo localImageInfo = new ImageInfo();
        localImageInfo.setbImageUrl(paramContext[i]);
        localImageInfo.setUrl(paramString[i]);
        if ((!"".equals(paramContext[i])) && (!"".equals(paramString[i]))) {
          localArrayList.add(localImageInfo);
        }
        i += 1;
      }
    }
    return localArrayList;
  }
  
  public static List<be> getRollPeopleImage(Context paramContext, String paramString)
  {
    int i = 0;
    ArrayList localArrayList = new ArrayList();
    paramString = paramContext.getSharedPreferences("rollimage" + paramString, 0);
    paramContext = paramString.getString("imageUrl", "");
    paramString = paramString.getString("adUrl", "");
    if ((!TextUtils.isEmpty(paramContext)) && (!TextUtils.isEmpty(paramString)))
    {
      paramContext = paramContext.split(",");
      paramString = paramString.split(",");
      while (i < paramContext.length)
      {
        be localbe = new be();
        localbe.setPic(paramContext[i]);
        localbe.setUrl(paramString[i]);
        if ((!"".equals(paramContext[i])) && (!"".equals(paramString[i]))) {
          localArrayList.add(localbe);
        }
        i += 1;
      }
    }
    return localArrayList;
  }
  
  public static long getSearchBizCircleTime(Context paramContext)
  {
    return paramContext.getSharedPreferences("search_time", 0).getLong("search_bizcircle_time", 0L);
  }
  
  public static long getSearchSubWayLineTime(Context paramContext)
  {
    return paramContext.getSharedPreferences("search_time", 0).getLong("search_line_time", 0L);
  }
  
  public static long getSearchSubWayStationTime(Context paramContext)
  {
    return paramContext.getSharedPreferences("search_time", 0).getLong("search_station_time", 0L);
  }
  
  public static String getServicePicList(Context paramContext, String paramString1, String paramString2)
  {
    return paramContext.getSharedPreferences("servicePicList" + paramString1 + paramString2, 0).getString("picJson", "");
  }
  
  public static String getSkinSign(Context paramContext)
  {
    return paramContext.getSharedPreferences("skin_tag", 0).getString("skin_sign", "");
  }
  
  public static SmallMoveAddressBean getSmallMoveStartAddressData(Context paramContext, String paramString)
  {
    String str = "";
    if (ApplicationEx.c.getUser() != null) {
      str = "_" + ApplicationEx.c.getUser().getUid();
    }
    paramContext = paramContext.getSharedPreferences(paramString + str + "_" + b.d, 0);
    paramString = new SmallMoveAddressBean();
    paramString.setStart_latlng(paramContext.getString("start_latlng", ""));
    paramString.setLatlng_map_lat(paramContext.getString("latlng_map_lat", ""));
    paramString.setLatlng_map_lng(paramContext.getString("latlng_map_lng", ""));
    paramString.setAddress_location(paramContext.getString("address_location", ""));
    paramString.setAddress_detail(paramContext.getString("address_detail", ""));
    paramString.setElevator(paramContext.getInt("elevator", 0));
    paramString.setFloors(paramContext.getInt("floors", 0));
    paramString.setFloorsFee(paramContext.getString("floorsFee", ""));
    return paramString;
  }
  
  public static String getSubletTag(Context paramContext)
  {
    return paramContext.getSharedPreferences("sublet_tag", 0).getString("sublet_tag", "");
  }
  
  public static UserInfo getUser(Context paramContext)
  {
    UserInfo localUserInfo = new UserInfo();
    paramContext = paramContext.getSharedPreferences("USER", 0);
    localUserInfo.setUid(paramContext.getString("uid", ""));
    localUserInfo.setLogin_name_mobile(paramContext.getString("loginName", ""));
    return localUserInfo;
  }
  
  public static int getWalletStatus(Context paramContext)
  {
    return paramContext.getSharedPreferences("myZiroomState", 0).getInt("myzioom_wallet_status", 0);
  }
  
  public static Boolean getZiroomStationMainNew(Context paramContext)
  {
    return Boolean.valueOf(paramContext.getSharedPreferences("ziroom_station_main_new", 0).getBoolean("ziroom_station_main_new", true));
  }
  
  public static boolean isFirstEnterMyCenter(Context paramContext)
  {
    paramContext = paramContext.getSharedPreferences("first_login_mycenter", 0);
    boolean bool = paramContext.getBoolean("first_login_mycenter", true);
    if (bool)
    {
      paramContext = paramContext.edit();
      paramContext.putBoolean("first_login_mycenter", false);
      paramContext.apply();
    }
    return bool;
  }
  
  public static void isFirstMyZiRoom(Context paramContext, boolean paramBoolean, String paramString)
  {
    paramContext = paramContext.getSharedPreferences("myZiroomState", 0).edit();
    paramContext.putBoolean("isFirst_" + paramString, paramBoolean);
    paramContext.apply();
  }
  
  public static void isFirstSetting(Context paramContext, boolean paramBoolean)
  {
    paramContext = paramContext.getSharedPreferences("settingState", 0).edit();
    paramContext.putBoolean("isFirst", paramBoolean);
    paramContext.apply();
  }
  
  public static void isFirstWelcome(Context paramContext, boolean paramBoolean)
  {
    paramContext = paramContext.getSharedPreferences("welcomeState", 0).edit();
    paramContext.putBoolean("isFirst", paramBoolean);
    paramContext.apply();
  }
  
  public static void isPublicRepair(Context paramContext, boolean paramBoolean)
  {
    paramContext = paramContext.getSharedPreferences("settingState", 0).edit();
    paramContext.putBoolean("publicRepair", paramBoolean);
    paramContext.apply();
  }
  
  public static void isRentNew(Context paramContext, boolean paramBoolean)
  {
    paramContext = paramContext.getSharedPreferences("settingState", 0).edit();
    paramContext.putBoolean("rentNew", paramBoolean);
    paramContext.apply();
  }
  
  public static void isRentWait(Context paramContext, boolean paramBoolean)
  {
    paramContext = paramContext.getSharedPreferences("settingState", 0).edit();
    paramContext.putBoolean("rentWait", paramBoolean);
    paramContext.apply();
  }
  
  public static void isRepairProgress(Context paramContext, boolean paramBoolean)
  {
    paramContext = paramContext.getSharedPreferences("settingState", 0).edit();
    paramContext.putBoolean("repair", paramBoolean);
    paramContext.apply();
  }
  
  public static void notifyRentDay(Context paramContext, int paramInt)
  {
    paramContext = paramContext.getSharedPreferences("settingState", 0).edit();
    paramContext.putInt("rent_notify", paramInt);
    paramContext.apply();
  }
  
  public static void putCityLocaton(Context paramContext, String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return;
    }
    paramContext = paramContext.getSharedPreferences("citylocation", 0).edit();
    paramContext.putString(paramString1, paramString2);
    paramContext.apply();
  }
  
  public static void putOther(Context paramContext, String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return;
    }
    paramContext = paramContext.getSharedPreferences("othercase_key", 0).edit();
    paramContext.putString(paramString1, paramString2);
    paramContext.apply();
  }
  
  public static void saveAdvertisement(Context paramContext, Advertisement paramAdvertisement)
  {
    paramContext = paramContext.getSharedPreferences("welcome_advertisement", 0).edit();
    paramContext.putString("title", paramAdvertisement.getTitle());
    paramContext.putString("subtitle", paramAdvertisement.getSubtitle());
    paramContext.putString("pic", paramAdvertisement.getPic());
    paramContext.putString("types", paramAdvertisement.getTypes());
    paramContext.putString("rgb", paramAdvertisement.getRgb());
    paramContext.putString("url", paramAdvertisement.getUrl());
    paramContext.apply();
  }
  
  public static void saveAppUpdateNum(Context paramContext, int paramInt)
  {
    paramContext = paramContext.getSharedPreferences("app_update_num", 0).edit();
    paramContext.putInt("app_update_num", paramInt);
    paramContext.apply();
  }
  
  public static void saveAppUpdateTime(Context paramContext, long paramLong)
  {
    paramContext = paramContext.getSharedPreferences("app_update_time", 0).edit();
    paramContext.putLong("app_update_time", paramLong);
    paramContext.apply();
  }
  
  public static void saveAppUpdateVersion(Context paramContext, int paramInt)
  {
    paramContext = paramContext.getSharedPreferences("app_update_code", 0).edit();
    paramContext.putInt("app_update_code", paramInt);
    paramContext.apply();
  }
  
  public static void saveAppVersion(Context paramContext)
  {
    paramContext = paramContext.getSharedPreferences("app_version", 0).edit();
    paramContext.putString("app_version", "5.6.0");
    paramContext.apply();
  }
  
  public static void saveBrowserPackageName(Context paramContext, String paramString)
  {
    paramContext = paramContext.getSharedPreferences("browser_package_name", 0).edit();
    paramContext.putString("browser_package_name", paramString);
    paramContext.apply();
  }
  
  public static void saveCleanPicList(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    paramContext = paramContext.getSharedPreferences("servicePicList" + paramString2 + paramString3, 0).edit();
    paramContext.putString("picJson", paramString1);
    paramContext.apply();
  }
  
  public static void saveCleanServiceTime(Context paramContext, long paramLong)
  {
    paramContext = paramContext.getSharedPreferences("time", 0).edit();
    paramContext.putLong("cleanServiceTime", paramLong);
    paramContext.apply();
  }
  
  public static void saveEasyPayTag(Context paramContext, String paramString)
  {
    paramContext = paramContext.getSharedPreferences("easy_pay_tag", 0).edit();
    paramContext.putString("easy_tag", paramString);
    paramContext.apply();
  }
  
  public static void saveFiveYearUrl(Context paramContext, String paramString1, String paramString2)
  {
    paramContext = paramContext.getSharedPreferences("five_year", 0).edit();
    paramContext.putString("linkUrl", paramString1);
    paramContext.putString("imgUrl", paramString1);
    paramContext.apply();
  }
  
  public static void saveGateWayDiffTime(Context paramContext, long paramLong)
  {
    paramContext = paramContext.getSharedPreferences("Web_gateway_difftime", 0).edit();
    paramContext.putLong("gateway_difftime", paramLong);
    paramContext.apply();
  }
  
  public static void saveLockTime(Context paramContext, String paramString, int paramInt)
  {
    paramContext = paramContext.getSharedPreferences("Intel_lock_houseCode", 0).edit();
    paramContext.putString("Intel_lock_time", paramString);
    paramContext.putInt("Intel_lock_left_time", paramInt);
    paramContext.apply();
  }
  
  public static void saveLoginName(Context paramContext, String paramString, boolean paramBoolean)
  {
    paramContext = paramContext.getSharedPreferences("loginState", 0).edit();
    paramContext.putBoolean("state", paramBoolean);
    paramContext.putString("name", paramString);
    paramContext.apply();
  }
  
  public static void saveMeetaTag(Context paramContext, String paramString)
  {
    paramContext = paramContext.getSharedPreferences("meeta_tag", 0).edit();
    paramContext.putString("meeta_tag", paramString);
    paramContext.apply();
  }
  
  public static void saveMiddleMoveStartAddressData(Context paramContext, String paramString1, double paramDouble1, double paramDouble2, String paramString2, String paramString3, int paramInt1, int paramInt2, double paramDouble3)
  {
    String str = "";
    if (ApplicationEx.c.getUser() != null) {
      str = "_" + ApplicationEx.c.getUser().getUid();
    }
    paramContext = paramContext.getSharedPreferences("service_middle_move_start_address" + str + "_" + b.d, 0).edit();
    paramContext.putString("start_latlng", paramString1);
    paramContext.putString("latlng_map_lat", paramDouble1 + "");
    paramContext.putString("latlng_map_lng", paramDouble2 + "");
    paramContext.putString("address_location", paramString2);
    paramContext.putString("address_detail", paramString3);
    paramContext.putInt("elevator", paramInt1);
    paramContext.putInt("floors", paramInt2);
    paramContext.putString("floorsFee", paramDouble3 + "");
    paramContext.apply();
  }
  
  public static void saveMidleMoveEndAddressData(Context paramContext, String paramString1, double paramDouble1, double paramDouble2, String paramString2, String paramString3, int paramInt1, int paramInt2, double paramDouble3)
  {
    String str = "";
    if (ApplicationEx.c.getUser() != null) {
      str = "_" + ApplicationEx.c.getUser().getUid();
    }
    paramContext = paramContext.getSharedPreferences("service_middle_move_end_address" + str + "_" + b.d, 0).edit();
    paramContext.putString("start_latlng", paramString1);
    paramContext.putString("latlng_map_lat", paramDouble1 + "");
    paramContext.putString("latlng_map_lng", paramDouble2 + "");
    paramContext.putString("address_location", paramString2);
    paramContext.putString("address_detail", paramString3);
    paramContext.putInt("elevator", paramInt1);
    paramContext.putInt("floors", paramInt2);
    paramContext.putString("floorsFee", paramDouble3 + "");
    if (ApplicationEx.c.getUser() != null) {
      paramContext.putString("uid", ApplicationEx.c.getUser().getUid());
    }
    paramContext.apply();
  }
  
  public static void saveMinsuLandReleaseHint(Context paramContext, Boolean paramBoolean)
  {
    paramContext = paramContext.getSharedPreferences("minsu_ll_release", 0).edit();
    paramContext.putBoolean("minsu_ll_release", paramBoolean.booleanValue());
    paramContext.apply();
  }
  
  public static void saveMinsuMainTodayHint(Context paramContext, Boolean paramBoolean, String paramString)
  {
    paramContext = paramContext.getSharedPreferences("minsu_main_tab_red_ll", 0).edit();
    paramContext.putBoolean("minsu_main_tab_red_ll", paramBoolean.booleanValue());
    paramContext.putString("hint_time", paramString);
    paramContext.apply();
  }
  
  public static void saveMinsuTodayMainNew(Context paramContext, Boolean paramBoolean)
  {
    paramContext = paramContext.getSharedPreferences("minsu_today_main_new", 0).edit();
    paramContext.putBoolean("minsu_today_main_new", paramBoolean.booleanValue());
    paramContext.apply();
  }
  
  public static void saveMovingVanEndAddressData(Context paramContext, String paramString1, String paramString2, double paramDouble1, double paramDouble2, int paramInt1, int paramInt2)
  {
    String str = "";
    if (ApplicationEx.c.getUser() != null) {
      str = "_" + ApplicationEx.c.getUser().getUid();
    }
    paramContext = paramContext.getSharedPreferences("service_moving_van_end_address" + str + "_" + b.d, 0).edit();
    paramContext.putString("address_location", paramString1);
    paramContext.putString("address_detail", paramString2);
    paramContext.putString("latlng_map_lat", paramDouble1 + "");
    paramContext.putString("latlng_map_lng", paramDouble2 + "");
    paramContext.putInt("elevator", paramInt1);
    paramContext.putInt("floors", paramInt2);
    paramContext.apply();
  }
  
  public static void saveMovingVanStartAddressData(Context paramContext, String paramString1, String paramString2, double paramDouble1, double paramDouble2, int paramInt1, int paramInt2)
  {
    String str = "";
    if (ApplicationEx.c.getUser() != null) {
      str = "_" + ApplicationEx.c.getUser().getUid();
    }
    paramContext = paramContext.getSharedPreferences("service_moving_van_start_address" + str + "_" + b.d, 0).edit();
    paramContext.putString("address_location", paramString1);
    paramContext.putString("address_detail", paramString2);
    paramContext.putString("latlng_map_lat", paramDouble1 + "");
    paramContext.putString("latlng_map_lng", paramDouble2 + "");
    paramContext.putInt("elevator", paramInt1);
    paramContext.putInt("floors", paramInt2);
    paramContext.apply();
  }
  
  public static void saveNetPicConfig(Context paramContext, String paramString)
  {
    paramContext = paramContext.getSharedPreferences("mona_config", 0).edit();
    paramContext.putString("mona_config", paramString);
    paramContext.apply();
  }
  
  public static void savePeriodCleanFrequency(Context paramContext, FrequencyBean paramFrequencyBean)
  {
    paramContext = paramContext.getSharedPreferences("service_period_clean_frequency", 0).edit();
    paramContext.putString("frequency", a.toJSONString(paramFrequencyBean));
    paramContext.apply();
  }
  
  public static void savePeriodCleanTimePeriod(Context paramContext, ServiceTimeLongBean paramServiceTimeLongBean)
  {
    paramContext = paramContext.getSharedPreferences("service_period_clean_time_period", 0).edit();
    paramContext.putString("mCurrentSelectServiceTimeLongBean", a.toJSONString(paramServiceTimeLongBean));
    paramContext.apply();
  }
  
  public static void saveProject(Context paramContext, String paramString)
  {
    paramContext = paramContext.getSharedPreferences("zryu_list", 0).edit();
    paramContext.putString("zryu_list", paramString);
    paramContext.apply();
  }
  
  public static void saveRollImage(Context paramContext, List<ImageInfo> paramList, String paramString)
  {
    if (paramContext == null) {}
    SharedPreferences.Editor localEditor;
    do
    {
      return;
      localEditor = paramContext.getSharedPreferences("rollimage" + paramString, 0).edit();
    } while ((paramList == null) || (paramList.size() <= 0));
    paramString = "";
    paramContext = "";
    Iterator localIterator = paramList.iterator();
    paramList = paramString;
    if (localIterator.hasNext())
    {
      paramString = (ImageInfo)localIterator.next();
      if (("".equals(paramString.getbImageUrl())) || ("".equals(paramString.getUrl()))) {
        break label228;
      }
      paramList = paramList + paramString.getbImageUrl();
      paramList = paramList + ",";
      paramContext = paramContext + paramString.getUrl();
      paramContext = paramContext + ",";
    }
    label228:
    for (;;)
    {
      break;
      localEditor.putString("imageUrl", paramList);
      localEditor.putString("adUrl", paramContext);
      localEditor.apply();
      return;
    }
  }
  
  public static void saveRollPeopleImage(Context paramContext, List<be> paramList, String paramString)
  {
    if (paramContext == null) {}
    SharedPreferences.Editor localEditor;
    do
    {
      return;
      localEditor = paramContext.getSharedPreferences("rollimage" + paramString, 0).edit();
    } while ((paramList == null) || (paramList.size() <= 0));
    paramString = "";
    paramContext = "";
    Iterator localIterator = paramList.iterator();
    paramList = paramString;
    if (localIterator.hasNext())
    {
      paramString = (be)localIterator.next();
      if (("".equals(paramString.getPic())) || ("".equals(paramString.getUrl()))) {
        break label228;
      }
      paramList = paramList + paramString.getPic();
      paramList = paramList + ",";
      paramContext = paramContext + paramString.getUrl();
      paramContext = paramContext + ",";
    }
    label228:
    for (;;)
    {
      break;
      localEditor.putString("imageUrl", paramList);
      localEditor.putString("adUrl", paramContext);
      localEditor.apply();
      return;
    }
  }
  
  public static void saveSearchHouseBizCircleTime(Context paramContext, long paramLong)
  {
    paramContext = paramContext.getSharedPreferences("search_time", 0).edit();
    paramContext.putLong("search_bizcircle_time", paramLong);
    paramContext.apply();
  }
  
  public static void saveSearchHouseServiceTime(Context paramContext, long paramLong)
  {
    paramContext = paramContext.getSharedPreferences("search_time", 0).edit();
    paramContext.putLong("search_line_time", paramLong);
    paramContext.apply();
  }
  
  public static void saveSearchHouseSubWayStationTime(Context paramContext, long paramLong)
  {
    paramContext = paramContext.getSharedPreferences("search_time", 0).edit();
    paramContext.putLong("search_station_time", paramLong);
    paramContext.apply();
  }
  
  public static void saveServicePicList(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    paramContext = paramContext.getSharedPreferences("servicePicList" + paramString2 + paramString3, 0).edit();
    paramContext.putString("picJson", paramString1);
    paramContext.apply();
  }
  
  public static void saveShadeGuideState(Context paramContext, String paramString, boolean paramBoolean)
  {
    paramContext = paramContext.getSharedPreferences("shadeState", 0).edit();
    paramContext.putBoolean(paramString, paramBoolean);
    paramContext.apply();
  }
  
  public static void saveSkinTag(Context paramContext, String paramString)
  {
    paramContext = paramContext.getSharedPreferences("skin_tag", 0).edit();
    paramContext.putString("skin_sign", paramString);
    paramContext.apply();
  }
  
  public static void saveSmallMoveEndAddressData(Context paramContext, String paramString1, double paramDouble1, double paramDouble2, String paramString2, String paramString3, int paramInt1, int paramInt2, double paramDouble3)
  {
    String str = "";
    if (ApplicationEx.c.getUser() != null) {
      str = "_" + ApplicationEx.c.getUser().getUid();
    }
    paramContext = paramContext.getSharedPreferences("service_small_move_end_address" + str + "_" + b.d, 0).edit();
    paramContext.putString("start_latlng", paramString1);
    paramContext.putString("latlng_map_lat", paramDouble1 + "");
    paramContext.putString("latlng_map_lng", paramDouble2 + "");
    paramContext.putString("address_location", paramString2);
    paramContext.putString("address_detail", paramString3);
    paramContext.putInt("elevator", paramInt1);
    paramContext.putInt("floors", paramInt2);
    paramContext.putString("floorsFee", paramDouble3 + "");
    if (ApplicationEx.c.getUser() != null) {
      paramContext.putString("uid", ApplicationEx.c.getUser().getUid());
    }
    paramContext.apply();
  }
  
  public static void saveSmallMoveStartAddressData(Context paramContext, String paramString1, double paramDouble1, double paramDouble2, String paramString2, String paramString3, int paramInt1, int paramInt2, double paramDouble3)
  {
    String str = "";
    if (ApplicationEx.c.getUser() != null) {
      str = "_" + ApplicationEx.c.getUser().getUid();
    }
    paramContext = paramContext.getSharedPreferences("service_small_move_start_address" + str + "_" + b.d, 0).edit();
    paramContext.putString("start_latlng", paramString1);
    paramContext.putString("latlng_map_lat", paramDouble1 + "");
    paramContext.putString("latlng_map_lng", paramDouble2 + "");
    paramContext.putString("address_location", paramString2);
    paramContext.putString("address_detail", paramString3);
    paramContext.putInt("elevator", paramInt1);
    paramContext.putInt("floors", paramInt2);
    paramContext.putString("floorsFee", paramDouble3 + "");
    paramContext.apply();
  }
  
  public static void saveSubletTag(Context paramContext, String paramString)
  {
    paramContext = paramContext.getSharedPreferences("sublet_tag", 0).edit();
    paramContext.putString("sublet_tag", paramString);
    paramContext.apply();
  }
  
  public static void saveVersion(Context paramContext, int paramInt)
  {
    paramContext = paramContext.getSharedPreferences("welcomeState", 0).edit();
    paramContext.putInt("version", paramInt);
    paramContext.apply();
  }
  
  public static void saveWalletStatus(Context paramContext)
  {
    paramContext = paramContext.getSharedPreferences("myZiroomState", 0).edit();
    paramContext.putInt("myzioom_wallet_status", 1);
    paramContext.apply();
  }
  
  public static void saveZiroomStationMainNew(Context paramContext, Boolean paramBoolean)
  {
    paramContext = paramContext.getSharedPreferences("ziroom_station_main_new", 0).edit();
    paramContext.putBoolean("ziroom_station_main_new", paramBoolean.booleanValue());
    paramContext.apply();
  }
  
  public static void setBoolean(Context paramContext, String paramString, boolean paramBoolean)
  {
    paramContext.getSharedPreferences("settingState", 0).edit().putBoolean(paramString, paramBoolean).apply();
  }
  
  public static void setResblockMapCompany(Context paramContext, MapPlanNode paramMapPlanNode)
  {
    if ((paramMapPlanNode == null) || (paramMapPlanNode.getLatlng() == null)) {
      return;
    }
    paramContext.getSharedPreferences("resblockMapCompany", 0).edit().putString("name", paramMapPlanNode.getName()).putString("lat", paramMapPlanNode.getLatlng().latitude + "").putString("lng", paramMapPlanNode.getLatlng().longitude + "").apply();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/ziroom/ziroomcustomer/util/ad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */