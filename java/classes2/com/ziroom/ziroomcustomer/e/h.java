package com.ziroom.ziroomcustomer.e;

import android.text.TextUtils;
import com.ziroom.ziroomcustomer.model.Acitivities;
import com.ziroom.ziroomcustomer.model.ActiveMessage;
import com.ziroom.ziroomcustomer.model.AlternateListing;
import com.ziroom.ziroomcustomer.model.Area;
import com.ziroom.ziroomcustomer.model.AreaInfo;
import com.ziroom.ziroomcustomer.model.AreaSurrounding;
import com.ziroom.ziroomcustomer.model.Bulletin;
import com.ziroom.ziroomcustomer.model.ConsumeScore;
import com.ziroom.ziroomcustomer.model.Contract;
import com.ziroom.ziroomcustomer.model.Distric;
import com.ziroom.ziroomcustomer.model.Fees;
import com.ziroom.ziroomcustomer.model.GoodList;
import com.ziroom.ziroomcustomer.model.HomeIndex;
import com.ziroom.ziroomcustomer.model.HouseDetail;
import com.ziroom.ziroomcustomer.model.HouseDetailPayWay;
import com.ziroom.ziroomcustomer.model.HouseListSearchResult;
import com.ziroom.ziroomcustomer.model.IkeyRaConfig;
import com.ziroom.ziroomcustomer.model.ImageInfo;
import com.ziroom.ziroomcustomer.model.Integral;
import com.ziroom.ziroomcustomer.model.KeyCards;
import com.ziroom.ziroomcustomer.model.LeaseInfo;
import com.ziroom.ziroomcustomer.model.LeaseListEntity;
import com.ziroom.ziroomcustomer.model.LeaseMyDataEntity;
import com.ziroom.ziroomcustomer.model.LeasePayDetail;
import com.ziroom.ziroomcustomer.model.LifeBanner;
import com.ziroom.ziroomcustomer.model.LifeDetails;
import com.ziroom.ziroomcustomer.model.LifeInfo;
import com.ziroom.ziroomcustomer.model.Login;
import com.ziroom.ziroomcustomer.model.MapBizcircle;
import com.ziroom.ziroomcustomer.model.MapBuilding;
import com.ziroom.ziroomcustomer.model.MapDistrict;
import com.ziroom.ziroomcustomer.model.MapHouse;
import com.ziroom.ziroomcustomer.model.MyToSee;
import com.ziroom.ziroomcustomer.model.Neighbour;
import com.ziroom.ziroomcustomer.model.NeighbourDetail;
import com.ziroom.ziroomcustomer.model.NotPayEntity;
import com.ziroom.ziroomcustomer.model.PayOrder;
import com.ziroom.ziroomcustomer.model.PayPartStateInfo;
import com.ziroom.ziroomcustomer.model.RegisterAutoCode;
import com.ziroom.ziroomcustomer.model.RentCard;
import com.ziroom.ziroomcustomer.model.RentCardDetail;
import com.ziroom.ziroomcustomer.model.RepairScore;
import com.ziroom.ziroomcustomer.model.RepairScoreResult;
import com.ziroom.ziroomcustomer.model.Server;
import com.ziroom.ziroomcustomer.model.SettingCommon;
import com.ziroom.ziroomcustomer.model.ShareInfo;
import com.ziroom.ziroomcustomer.model.SignedInfo;
import com.ziroom.ziroomcustomer.model.SignedOldPayDataEntity;
import com.ziroom.ziroomcustomer.model.SignedPayDataEntity;
import com.ziroom.ziroomcustomer.model.SignedPayDetails;
import com.ziroom.ziroomcustomer.model.SignedPayServiceDataEntity;
import com.ziroom.ziroomcustomer.model.Steward;
import com.ziroom.ziroomcustomer.model.TenancyInfo;
import com.ziroom.ziroomcustomer.model.TenancyUpdate;
import com.ziroom.ziroomcustomer.model.ToSeeStatu;
import com.ziroom.ziroomcustomer.model.UserInfo;
import com.ziroom.ziroomcustomer.model.Ziruke;
import com.ziroom.ziroomcustomer.signed.d;
import com.ziroom.ziroomcustomer.signed.g;
import com.ziroom.ziroomcustomer.signed.r;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.util.u;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class h
{
  public static l parseActiveImage(String paramString)
  {
    l locall = new l();
    if (paramString == null) {
      try
      {
        throw new Exception();
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        locall.setSuccess(Boolean.valueOf(false));
        locall.setMessage("服务器异常，正在努力抢修中，请稍后再试!");
        return locall;
      }
    }
    Object localObject = com.alibaba.fastjson.a.parseObject(paramString);
    paramString = (String)((Map)localObject).get("status");
    String str = ((Map)localObject).get("data").toString();
    localObject = (String)((Map)localObject).get("error_message");
    if (paramString.equals("success"))
    {
      paramString = (Acitivities)com.alibaba.fastjson.a.parseObject(str, Acitivities.class);
      locall.setSuccess(Boolean.valueOf(true));
      locall.setObject(paramString);
      return locall;
    }
    locall.setSuccess(Boolean.valueOf(false));
    locall.setMessage((String)localObject);
    return locall;
  }
  
  public static l parseAddActiveMessageList(String paramString)
  {
    l locall = new l();
    if (paramString == null) {
      try
      {
        throw new Exception();
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        locall.setSuccess(Boolean.valueOf(false));
        locall.setMessage("服务器异常，正在努力抢修中，请稍后再试!");
        return locall;
      }
    }
    paramString = com.alibaba.fastjson.a.parseObject(paramString);
    if (((String)paramString.get("status")).equals("success"))
    {
      locall.setObject("");
      locall.setSuccess(Boolean.valueOf(true));
      return locall;
    }
    locall.setSuccess(Boolean.valueOf(false));
    locall.setCode((String)paramString.get("error_code"));
    locall.setMessage((String)paramString.get("error_message"));
    return locall;
  }
  
  public static l parseAppointStewards(String paramString)
  {
    l locall = new l();
    if (paramString == null) {
      try
      {
        throw new Exception();
      }
      catch (Exception paramString)
      {
        locall.setSuccess(Boolean.valueOf(false));
        locall.setMessage("服务器异常，正在努力抢修中，请稍后再试!");
        return locall;
      }
    }
    paramString = com.alibaba.fastjson.a.parseObject(paramString);
    paramString.get("error_message").toString();
    if ("success".equals((String)paramString.get("status")))
    {
      locall.setObject(com.alibaba.fastjson.a.parseArray(paramString.get("data").toString(), Steward.class));
      locall.setSuccess(Boolean.valueOf(true));
      return locall;
    }
    locall.setSuccess(Boolean.valueOf(false));
    locall.setMessage(paramString.get("error_message").toString());
    return locall;
  }
  
  public static l parseAutoCode(String paramString)
  {
    l locall = new l();
    if (paramString == null) {
      try
      {
        throw new Exception();
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        locall.setSuccess(Boolean.valueOf(false));
        locall.setMessage("服务器异常，正在努力抢修中，请稍后再试!");
        return locall;
      }
    }
    paramString = com.alibaba.fastjson.a.parseObject(paramString);
    String str1 = (String)paramString.get("status");
    String str2 = (String)paramString.get("error_message");
    if (str1.equals("success"))
    {
      locall.setSuccess(Boolean.valueOf(true));
      locall.setObject((RegisterAutoCode)com.alibaba.fastjson.e.parseObject(paramString.get("data").toString(), RegisterAutoCode.class));
      return locall;
    }
    locall.setSuccess(Boolean.valueOf(false));
    locall.setMessage(str2);
    return locall;
  }
  
  public static l parseAutoLogin(String paramString)
  {
    l locall = new l();
    if (paramString == null) {
      try
      {
        throw new Exception();
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        locall.setSuccess(Boolean.valueOf(false));
        locall.setMessage("网络数据请求失败!");
        u.e("parseLogin", paramString.getMessage());
        return locall;
      }
    }
    paramString = com.alibaba.fastjson.a.parseObject(paramString);
    if (((String)paramString.get("status")).equals("success"))
    {
      locall.setSuccess(Boolean.valueOf(true));
      locall.setObject("");
      return locall;
    }
    locall.setSuccess(Boolean.valueOf(false));
    locall.setMessage((String)paramString.get("error_message"));
    return locall;
  }
  
  public static l parseBizcircleList(String paramString)
  {
    l locall = new l();
    if (paramString == null) {
      try
      {
        throw new Exception();
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        locall.setSuccess(Boolean.valueOf(false));
        locall.setMessage("服务器异常，正在努力抢修中，请稍后再试!");
        return locall;
      }
    }
    paramString = com.alibaba.fastjson.a.parseObject(paramString);
    if (((String)paramString.get("status")).equals("success"))
    {
      locall.setObject(com.alibaba.fastjson.a.parseArray(paramString.get("data").toString(), MapBizcircle.class));
      locall.setSuccess(Boolean.valueOf(true));
      return locall;
    }
    locall.setSuccess(Boolean.valueOf(false));
    locall.setMessage((String)paramString.get("error_message"));
    return locall;
  }
  
  public static l parseBuildingHouseList(String paramString)
  {
    l locall = new l();
    if (paramString == null) {
      try
      {
        throw new Exception();
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        locall.setSuccess(Boolean.valueOf(false));
        locall.setMessage("服务器异常，正在努力抢修中，请稍后再试!");
        return locall;
      }
    }
    paramString = com.alibaba.fastjson.a.parseObject(paramString);
    if (((String)paramString.get("status")).equals("success"))
    {
      locall.setObject(com.alibaba.fastjson.a.parseArray(paramString.get("data").toString(), MapHouse.class));
      locall.setSuccess(Boolean.valueOf(true));
      return locall;
    }
    locall.setSuccess(Boolean.valueOf(false));
    locall.setMessage((String)paramString.get("error_message"));
    return locall;
  }
  
  public static l parseBuildingList(String paramString)
  {
    l locall = new l();
    if (paramString == null) {
      try
      {
        throw new Exception();
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        locall.setSuccess(Boolean.valueOf(false));
        locall.setMessage("服务器异常，正在努力抢修中，请稍后再试!");
        return locall;
      }
    }
    paramString = com.alibaba.fastjson.a.parseObject(paramString);
    if (((String)paramString.get("status")).equals("success"))
    {
      locall.setObject(com.alibaba.fastjson.a.parseArray(paramString.get("data").toString(), MapBuilding.class));
      locall.setSuccess(Boolean.valueOf(true));
      return locall;
    }
    locall.setSuccess(Boolean.valueOf(false));
    locall.setMessage((String)paramString.get("error_message"));
    return locall;
  }
  
  public static l parseChangePswByCode(String paramString)
  {
    l locall = new l();
    if (paramString == null) {
      try
      {
        throw new Exception();
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        locall.setSuccess(Boolean.valueOf(false));
        locall.setMessage("服务器异常，正在努力抢修中，请稍后再试!");
        return locall;
      }
    }
    paramString = com.alibaba.fastjson.a.parseObject(paramString);
    if (((String)paramString.get("status")).equals("success"))
    {
      locall.setSuccess(Boolean.valueOf(true));
      return locall;
    }
    locall.setSuccess(Boolean.valueOf(false));
    locall.setMessage((String)paramString.get("error_message"));
    return locall;
  }
  
  public static l parseCheckHasEvaluate(String paramString)
  {
    l locall = new l();
    if (paramString == null) {
      try
      {
        throw new Exception();
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        locall.setSuccess(Boolean.valueOf(false));
        locall.setMessage("网络数据请求失败!");
        u.e("parseCheckHasEvaluate", paramString.getMessage());
        return locall;
      }
    }
    paramString = com.alibaba.fastjson.a.parseObject(paramString);
    if (((String)paramString.get("status")).equals("success"))
    {
      locall.setSuccess(Boolean.valueOf(true));
      locall.setObject(paramString);
      return locall;
    }
    locall.setSuccess(Boolean.valueOf(false));
    locall.setMessage((String)paramString.get("message"));
    return locall;
  }
  
  public static l parseConsumeIntegral(String paramString)
  {
    l locall = new l();
    if (paramString == null) {
      try
      {
        throw new Exception();
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        locall.setSuccess(Boolean.valueOf(false));
        locall.setMessage("服务器异常，正在努力抢修中，请稍后再试!");
        return locall;
      }
    }
    paramString = com.alibaba.fastjson.a.parseObject(paramString);
    if (((Integer)paramString.get("status")).intValue() == 1)
    {
      locall.setObject((ConsumeScore)com.alibaba.fastjson.a.parseObject(paramString.get("detail").toString(), ConsumeScore.class));
      locall.setSuccess(Boolean.valueOf(true));
      return locall;
    }
    locall.setSuccess(Boolean.valueOf(false));
    locall.setMessage("服务器异常，正在努力抢修中，请稍后再试!");
    return locall;
  }
  
  public static l parseContractCodeState(String paramString)
  {
    l locall = new l();
    if (paramString == null) {
      try
      {
        throw new Exception();
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        locall.setSuccess(Boolean.valueOf(false));
        locall.setMessage("服务器异常，正在努力抢修中，请稍后再试!");
        return locall;
      }
    }
    Object localObject = com.alibaba.fastjson.a.parseObject(paramString);
    paramString = (String)((Map)localObject).get("status");
    String str = ((Map)localObject).get("data").toString();
    localObject = (String)((Map)localObject).get("error_message");
    if ("success".equals(paramString))
    {
      paramString = (com.ziroom.ziroomcustomer.contract.b)com.alibaba.fastjson.a.parseObject(str, com.ziroom.ziroomcustomer.contract.b.class);
      locall.setSuccess(Boolean.valueOf(true));
      locall.setObject(paramString);
      return locall;
    }
    locall.setSuccess(Boolean.valueOf(false));
    locall.setMessage((String)localObject);
    return locall;
  }
  
  public static l parseContractExtension(String paramString)
  {
    l locall = new l();
    if (paramString == null) {
      try
      {
        throw new Exception();
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        locall.setSuccess(Boolean.valueOf(false));
        locall.setMessage("服务器异常，正在努力抢修中，请稍后再试!");
        return locall;
      }
    }
    Object localObject = com.alibaba.fastjson.a.parseObject(paramString);
    paramString = (String)((Map)localObject).get("status");
    String str = ((Map)localObject).get("data").toString();
    localObject = (String)((Map)localObject).get("error_message");
    if (paramString.equals("success"))
    {
      paramString = (com.ziroom.ziroomcustomer.contract.a)com.alibaba.fastjson.a.parseObject(str, com.ziroom.ziroomcustomer.contract.a.class);
      locall.setSuccess(Boolean.valueOf(true));
      locall.setObject(paramString);
      return locall;
    }
    locall.setSuccess(Boolean.valueOf(false));
    locall.setMessage((String)localObject);
    return locall;
  }
  
  public static l parseContractSummary(String paramString)
  {
    l locall = new l();
    if (paramString == null) {
      try
      {
        throw new Exception();
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        locall.setSuccess(Boolean.valueOf(false));
        locall.setMessage("服务器异常，正在努力抢修中，请稍后再试!");
        return locall;
      }
    }
    paramString = com.alibaba.fastjson.a.parseObject(paramString);
    if ("success".equals((String)paramString.get("status")))
    {
      locall.setObject((d)com.alibaba.fastjson.a.parseObject(paramString.get("data").toString(), d.class));
      locall.setSuccess(Boolean.valueOf(true));
      return locall;
    }
    locall.setSuccess(Boolean.valueOf(false));
    locall.setMessage((String)paramString.get("error_message"));
    return locall;
  }
  
  public static l parseDistrictList(String paramString)
  {
    l locall = new l();
    if (paramString == null) {
      try
      {
        throw new Exception();
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        locall.setSuccess(Boolean.valueOf(false));
        locall.setMessage("服务器异常，正在努力抢修中，请稍后再试!");
        return locall;
      }
    }
    paramString = com.alibaba.fastjson.a.parseObject(paramString);
    if (((String)paramString.get("status")).equals("success"))
    {
      locall.setObject(com.alibaba.fastjson.a.parseArray(paramString.get("data").toString(), MapDistrict.class));
      locall.setSuccess(Boolean.valueOf(true));
      return locall;
    }
    locall.setSuccess(Boolean.valueOf(false));
    locall.setMessage((String)paramString.get("error_message"));
    return locall;
  }
  
  public static l parseEvaluateAppoint(String paramString)
  {
    l locall = new l();
    if (paramString == null) {
      try
      {
        throw new RuntimeException();
      }
      catch (Exception paramString)
      {
        locall.setSuccess(Boolean.valueOf(false));
        locall.setMessage("服务器异常，正在努力抢修中，请稍后再试!");
        return locall;
      }
    }
    paramString = com.alibaba.fastjson.a.parseObject(paramString);
    if ("success".equals((String)paramString.get("status")))
    {
      locall.setObject(paramString);
      locall.setSuccess(Boolean.valueOf(true));
      return locall;
    }
    locall.setSuccess(Boolean.valueOf(false));
    locall.setMessage(paramString.get("error_message").toString());
    return locall;
  }
  
  public static l parseExtendData(String paramString)
  {
    l locall = new l();
    if (paramString == null) {
      try
      {
        throw new Exception();
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        locall.setSuccess(Boolean.valueOf(false));
        locall.setMessage("服务器异常，正在努力抢修中，请稍后再试!");
        return locall;
      }
    }
    com.alibaba.fastjson.e locale = com.alibaba.fastjson.a.parseObject(paramString);
    if ("success".equals((String)locale.get("status")))
    {
      paramString = null;
      if (locale.get("data").toString().length() > 5) {
        paramString = (g)com.alibaba.fastjson.a.parseObject(locale.get("data").toString(), g.class);
      }
      locall.setObject(paramString);
      locall.setSuccess(Boolean.valueOf(true));
      return locall;
    }
    locall.setSuccess(Boolean.valueOf(false));
    locall.setMessage((String)locale.get("error_message"));
    return locall;
  }
  
  public static l parseGetActiveMessageList(String paramString)
  {
    l locall = new l();
    if (paramString == null) {
      try
      {
        throw new Exception();
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        locall.setSuccess(Boolean.valueOf(false));
        locall.setMessage("服务器异常，正在努力抢修中，请稍后再试!");
        return locall;
      }
    }
    paramString = com.alibaba.fastjson.a.parseObject(paramString);
    if (((String)paramString.get("status")).equals("success"))
    {
      locall.setObject(com.alibaba.fastjson.a.parseArray(paramString.get("data").toString(), ActiveMessage.class));
      locall.setSuccess(Boolean.valueOf(true));
      return locall;
    }
    locall.setSuccess(Boolean.valueOf(false));
    locall.setCode((String)paramString.get("error_code"));
    locall.setMessage((String)paramString.get("error_message"));
    return locall;
  }
  
  public static l parseGetAlternateList(String paramString)
  {
    l locall = new l();
    if (paramString == null) {
      try
      {
        throw new Exception();
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        locall.setSuccess(Boolean.valueOf(false));
        locall.setMessage("网络数据请求失败!");
        u.e("parseSaveAlternateList", paramString.getMessage());
        return locall;
      }
    }
    paramString = com.alibaba.fastjson.a.parseObject(paramString);
    if (((String)paramString.get("status")).equals("success"))
    {
      locall.setObject(com.alibaba.fastjson.a.parseArray(paramString.get("data").toString(), AlternateListing.class));
      locall.setSuccess(Boolean.valueOf(true));
      return locall;
    }
    locall.setSuccess(Boolean.valueOf(false));
    locall.setMessage((String)paramString.get("error_message"));
    return locall;
  }
  
  public static l parseGetAreaInfo(String paramString)
  {
    l locall = new l();
    if (paramString == null) {
      try
      {
        throw new Exception();
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        locall.setSuccess(Boolean.valueOf(false));
        locall.setMessage("服务器异常，正在努力抢修中，请稍后再试!");
        return locall;
      }
    }
    locall.setObject((AreaInfo)com.alibaba.fastjson.a.parseObject(com.alibaba.fastjson.a.parseObject(paramString).get("data").toString(), AreaInfo.class));
    locall.setSuccess(Boolean.valueOf(true));
    return locall;
  }
  
  public static l parseGetAreaListByBizcId(String paramString)
  {
    l locall = new l();
    if (paramString == null) {
      try
      {
        throw new Exception();
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        locall.setSuccess(Boolean.valueOf(false));
        locall.setMessage("服务器异常，正在努力抢修中，请稍后再试!");
        return locall;
      }
    }
    paramString = com.alibaba.fastjson.a.parseObject(paramString);
    if (((Integer)paramString.get("status")).intValue() == 1)
    {
      locall.setObject(com.alibaba.fastjson.a.parseArray(paramString.get("data").toString(), Area.class));
      locall.setSuccess(Boolean.valueOf(true));
      return locall;
    }
    locall.setSuccess(Boolean.valueOf(false));
    locall.setMessage((String)paramString.get("error_message"));
    return locall;
  }
  
  public static l parseGetBizcircles(String paramString)
  {
    l locall = new l();
    if (paramString == null) {
      try
      {
        throw new Exception();
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        locall.setSuccess(Boolean.valueOf(false));
        locall.setMessage("服务器异常，正在努力抢修中，请稍后再试!");
        return locall;
      }
    }
    paramString = com.alibaba.fastjson.a.parseObject(paramString);
    if (((Integer)paramString.get("status")).intValue() == 1)
    {
      locall.setObject(com.alibaba.fastjson.a.parseArray(paramString.get("data").toString(), Distric.class));
      locall.setSuccess(Boolean.valueOf(true));
      return locall;
    }
    locall.setSuccess(Boolean.valueOf(false));
    locall.setCode((String)paramString.get("error_code"));
    locall.setMessage((String)paramString.get("error_message"));
    return locall;
  }
  
  public static l parseGetBulletinList(String paramString)
  {
    l locall = new l();
    if (paramString == null) {
      try
      {
        throw new Exception();
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        locall.setSuccess(Boolean.valueOf(false));
        locall.setMessage("服务器异常，正在努力抢修中，请稍后再试!");
        return locall;
      }
    }
    paramString = com.alibaba.fastjson.a.parseObject(paramString);
    if (((String)paramString.get("status")).equals("success"))
    {
      locall.setObject(com.alibaba.fastjson.a.parseArray(paramString.get("data").toString(), Bulletin.class));
      locall.setSuccess(Boolean.valueOf(true));
      return locall;
    }
    locall.setSuccess(Boolean.valueOf(false));
    locall.setCode((String)paramString.get("error_code"));
    locall.setMessage((String)paramString.get("error_message"));
    return locall;
  }
  
  public static l parseGetBusinessList(String paramString)
  {
    l locall = new l();
    if (paramString == null) {
      try
      {
        throw new Exception();
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        locall.setSuccess(Boolean.valueOf(false));
        locall.setMessage("服务器异常，正在努力抢修中，请稍后再试!");
        return locall;
      }
    }
    paramString = com.alibaba.fastjson.a.parseObject(paramString);
    if (((String)paramString.get("status")).equals("success"))
    {
      locall.setObject((AreaSurrounding)com.alibaba.fastjson.a.parseObject(paramString.get("data").toString(), AreaSurrounding.class));
      locall.setSuccess(Boolean.valueOf(true));
      return locall;
    }
    locall.setSuccess(Boolean.valueOf(false));
    locall.setCode((String)paramString.get("error_code"));
    locall.setMessage((String)paramString.get("error_message"));
    return locall;
  }
  
  public static l parseGetContract(String paramString)
  {
    l locall = new l();
    if (paramString == null) {
      try
      {
        throw new Exception();
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        locall.setSuccess(Boolean.valueOf(false));
        locall.setMessage("服务器异常，正在努力抢修中，请稍后再试!");
        return locall;
      }
    }
    paramString = com.alibaba.fastjson.a.parseObject(paramString);
    if (((String)paramString.get("status")).equals("success"))
    {
      Object localObject = (com.alibaba.fastjson.b)paramString.get("data");
      if (localObject == null) {
        break label185;
      }
      paramString = new ArrayList();
      localObject = ((com.alibaba.fastjson.b)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        paramString.add((Contract)com.alibaba.fastjson.a.parseObject(((Iterator)localObject).next().toString(), Contract.class));
      }
    }
    for (;;)
    {
      locall.setSuccess(Boolean.valueOf(true));
      locall.setObject(paramString);
      return locall;
      locall.setSuccess(Boolean.valueOf(false));
      locall.setMessage(paramString.get("error_message") + "");
      return locall;
      label185:
      paramString = null;
    }
  }
  
  public static l parseGetEvaluateProblems(String paramString)
  {
    l locall = new l();
    if (paramString == null) {
      try
      {
        throw new Exception();
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        locall.setSuccess(Boolean.valueOf(false));
        locall.setMessage("网络数据请求失败!");
        u.e("parseGetEvaluateProblems", paramString.getMessage());
        return locall;
      }
    }
    paramString = com.alibaba.fastjson.a.parseObject(paramString);
    if (((String)paramString.get("status")).equals("success"))
    {
      locall.setSuccess(Boolean.valueOf(true));
      locall.setObject(paramString);
      return locall;
    }
    locall.setSuccess(Boolean.valueOf(false));
    locall.setMessage((String)paramString.get("message"));
    return locall;
  }
  
  public static l parseGetIntegral(String paramString)
  {
    u.e("netnet", paramString);
    l locall = new l();
    if (paramString == null) {
      try
      {
        throw new Exception();
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        locall.setSuccess(Boolean.valueOf(false));
        locall.setMessage("服务器异常，正在努力抢修中，请稍后再试!");
        return locall;
      }
    }
    paramString = com.alibaba.fastjson.a.parseObject(paramString);
    if (((Integer)paramString.get("status")).intValue() == 1)
    {
      paramString = (Integral)com.alibaba.fastjson.a.parseObject(paramString.get("detail").toString(), Integral.class);
      locall.setSuccess(Boolean.valueOf(true));
      locall.setObject(paramString);
      return locall;
    }
    locall.setSuccess(Boolean.valueOf(false));
    locall.setMessage("获取数据失败!");
    return locall;
  }
  
  public static l parseGetMyActiveMessageList(String paramString)
  {
    l locall = new l();
    if (paramString == null) {
      try
      {
        throw new Exception();
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        locall.setSuccess(Boolean.valueOf(false));
        locall.setMessage("服务器异常，正在努力抢修中，请稍后再试!");
        return locall;
      }
    }
    paramString = com.alibaba.fastjson.a.parseObject(paramString);
    if (((String)paramString.get("status")).equals("success"))
    {
      locall.setObject(com.alibaba.fastjson.a.parseArray(paramString.get("data").toString(), ActiveMessage.class));
      locall.setSuccess(Boolean.valueOf(true));
      return locall;
    }
    locall.setSuccess(Boolean.valueOf(false));
    locall.setCode((String)paramString.get("error_code"));
    locall.setMessage((String)paramString.get("error_message"));
    return locall;
  }
  
  public static l parseGetRaConfig(String paramString)
  {
    l locall = new l();
    if (paramString == null) {
      try
      {
        throw new Exception();
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        locall.setSuccess(Boolean.valueOf(false));
        locall.setMessage("网络数据请求失败!");
        u.e("parseGetRaConfig", paramString.getMessage());
        return locall;
      }
    }
    paramString = com.alibaba.fastjson.a.parseObject(paramString);
    if (((String)paramString.get("status")).equals("success"))
    {
      paramString = (IkeyRaConfig)com.alibaba.fastjson.a.parseObject(paramString.get("data").toString(), IkeyRaConfig.class);
      locall.setSuccess(Boolean.valueOf(true));
      locall.setObject(paramString);
      return locall;
    }
    locall.setSuccess(Boolean.valueOf(false));
    locall.setMessage((String)paramString.get("error_message"));
    return locall;
  }
  
  public static l parseGetRaSignInfo(String paramString)
  {
    l locall = new l();
    if (paramString == null) {
      try
      {
        throw new Exception();
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        locall.setSuccess(Boolean.valueOf(false));
        locall.setMessage("网络数据请求失败!");
        u.e("parseGetRaSignInfo", paramString.getMessage());
        return locall;
      }
    }
    paramString = com.alibaba.fastjson.a.parseObject(paramString);
    if (((String)paramString.get("status")).equals("success"))
    {
      locall.setSuccess(Boolean.valueOf(true));
      locall.setObject(paramString.get("data"));
      return locall;
    }
    locall.setSuccess(Boolean.valueOf(false));
    locall.setMessage((String)paramString.get("error_message"));
    return locall;
  }
  
  public static l parseGetRentAgentCode(String paramString)
  {
    l locall = new l();
    if (paramString == null) {
      try
      {
        throw new Exception();
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        locall.setSuccess(Boolean.valueOf(false));
        locall.setMessage("网络数据请求失败!");
        u.e("parseGetRentAgentCode", paramString.getMessage());
        return locall;
      }
    }
    paramString = com.alibaba.fastjson.a.parseObject(paramString);
    if (((String)paramString.get("status")).equals("success"))
    {
      locall.setSuccess(Boolean.valueOf(true));
      locall.setObject(paramString);
      return locall;
    }
    locall.setSuccess(Boolean.valueOf(false));
    locall.setMessage((String)paramString.get("error_message"));
    return locall;
  }
  
  public static l parseGetRentCard(String paramString)
  {
    l locall = new l();
    if (paramString == null) {
      try
      {
        throw new Exception();
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        locall.setSuccess(Boolean.valueOf(false));
        locall.setMessage("服务器异常，正在努力抢修中，请稍后再试!");
        return locall;
      }
    }
    paramString = com.alibaba.fastjson.a.parseObject(paramString);
    if (((Integer)paramString.get("status")).intValue() == 1)
    {
      paramString = (RentCard)com.alibaba.fastjson.a.parseObject(paramString.get("detail").toString(), RentCard.class);
      locall.setSuccess(Boolean.valueOf(true));
      locall.setObject(paramString);
      return locall;
    }
    locall.setSuccess(Boolean.valueOf(false));
    locall.setMessage("获取数据失败!");
    return locall;
  }
  
  public static l parseGetRentCards(String paramString)
  {
    l locall = new l();
    if (paramString == null) {
      try
      {
        throw new Exception();
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        locall.setSuccess(Boolean.valueOf(false));
        locall.setMessage("服务器异常，正在努力抢修中，请稍后再试!");
        return locall;
      }
    }
    paramString = com.alibaba.fastjson.a.parseObject(paramString);
    if ("success".equals(paramString.get("status").toString()))
    {
      paramString = com.alibaba.fastjson.a.parseArray(paramString.get("data").toString(), RentCardDetail.class);
      locall.setSuccess(Boolean.valueOf(true));
      locall.setObject(paramString);
      return locall;
    }
    locall.setSuccess(Boolean.valueOf(false));
    locall.setMessage((String)paramString.get("error_message"));
    return locall;
  }
  
  public static l parseGetRepairScore(String paramString)
  {
    l locall = new l();
    if (paramString == null) {
      try
      {
        throw new Exception();
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        locall.setSuccess(Boolean.valueOf(false));
        locall.setMessage("服务器异常，正在努力抢修中，请稍后再试!");
        return locall;
      }
    }
    Object localObject1 = com.alibaba.fastjson.a.parseObject(paramString);
    if (((String)((Map)localObject1).get("status")).equals("success"))
    {
      paramString = new RepairScoreResult();
      paramString.setRemark((String)((Map)localObject1).get("remark"));
      Object localObject2 = (com.alibaba.fastjson.b)((Map)localObject1).get("list");
      localObject1 = new ArrayList();
      if (localObject2 != null)
      {
        localObject2 = ((com.alibaba.fastjson.b)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          Map localMap = (Map)((Iterator)localObject2).next();
          RepairScore localRepairScore = new RepairScore();
          localRepairScore.setFID((String)localMap.get("itemId"));
          localRepairScore.setVALUE(String.valueOf(localMap.get("score")));
          ((List)localObject1).add(localRepairScore);
        }
      }
      paramString.setList((List)localObject1);
      locall.setSuccess(Boolean.valueOf(true));
      locall.setObject(paramString);
      return locall;
    }
    locall.setSuccess(Boolean.valueOf(false));
    locall.setMessage((String)((Map)localObject1).get("message"));
    return locall;
  }
  
  public static l parseGetTurnRaSignInfo(String paramString)
  {
    l locall = new l();
    if (paramString == null) {
      try
      {
        throw new Exception();
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        locall.setSuccess(Boolean.valueOf(false));
        locall.setMessage("网络数据请求失败!");
        u.e("parseGetRaSignInfo", paramString.getMessage());
        return locall;
      }
    }
    paramString = com.alibaba.fastjson.a.parseObject(paramString);
    if (((String)paramString.get("status")).equals("success"))
    {
      paramString = com.alibaba.fastjson.a.parseArray(paramString.get("data").toString(), r.class);
      locall.setSuccess(Boolean.valueOf(true));
      locall.setObject(paramString);
      return locall;
    }
    locall.setSuccess(Boolean.valueOf(false));
    locall.setMessage((String)paramString.get("error_message"));
    return locall;
  }
  
  public static l parseGetTurnSign(String paramString)
  {
    l locall = new l();
    if (paramString == null) {
      try
      {
        throw new Exception();
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        locall.setSuccess(Boolean.valueOf(false));
        locall.setMessage("服务器异常，正在努力抢修中，请稍后再试!");
        return locall;
      }
    }
    paramString = com.alibaba.fastjson.a.parseObject(paramString);
    if (((String)paramString.get("message")).equals("success"))
    {
      if (paramString.get("resp") != null)
      {
        locall.setObject(paramString.get("resp").toString());
        locall.setSuccess(Boolean.valueOf(true));
        return locall;
      }
      locall.setSuccess(Boolean.valueOf(false));
      return locall;
    }
    locall.setSuccess(Boolean.valueOf(false));
    locall.setMessage((String)paramString.get("message"));
    return locall;
  }
  
  public static l parseGetTurnText(String paramString)
  {
    l locall = new l();
    if (paramString == null) {
      try
      {
        throw new Exception();
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        locall.setSuccess(Boolean.valueOf(false));
        locall.setMessage("服务器异常，正在努力抢修中，请稍后再试!");
        return locall;
      }
    }
    paramString = com.alibaba.fastjson.a.parseObject(paramString);
    if (((String)paramString.get("message")).equals("success"))
    {
      if (paramString.get("resp") != null)
      {
        paramString = (com.ziroom.ziroomcustomer.activity.e)com.alibaba.fastjson.e.parseObject(paramString.get("resp").toString(), com.ziroom.ziroomcustomer.activity.e.class);
        locall.setSuccess(Boolean.valueOf(true));
        locall.setObject(paramString);
        return locall;
      }
      locall.setSuccess(Boolean.valueOf(false));
      return locall;
    }
    locall.setSuccess(Boolean.valueOf(false));
    locall.setMessage((String)paramString.get("message"));
    return locall;
  }
  
  public static l parseGetZirukeList(String paramString)
  {
    l locall = new l();
    if (paramString == null) {
      try
      {
        throw new Exception();
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        locall.setSuccess(Boolean.valueOf(false));
        locall.setMessage("服务器异常，正在努力抢修中，请稍后再试!");
        return locall;
      }
    }
    paramString = com.alibaba.fastjson.a.parseObject(paramString);
    if (((String)paramString.get("status")).equals("success"))
    {
      locall.setObject(com.alibaba.fastjson.a.parseArray(paramString.get("data").toString(), Ziruke.class));
      locall.setSuccess(Boolean.valueOf(true));
      return locall;
    }
    locall.setSuccess(Boolean.valueOf(false));
    locall.setMessage((String)paramString.get("error_message"));
    return locall;
  }
  
  public static l parseGuideList(String paramString)
  {
    l locall = new l();
    if (paramString == null) {
      try
      {
        throw new Exception();
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        locall.setSuccess(Boolean.valueOf(false));
        locall.setMessage("服务器异常，正在努力抢修中，请稍后再试!");
        return locall;
      }
    }
    Object localObject = com.alibaba.fastjson.a.parseObject(paramString);
    paramString = (String)((Map)localObject).get("status");
    String str = ((Map)localObject).get("data").toString();
    localObject = (String)((Map)localObject).get("error_message");
    if (paramString.equals("success"))
    {
      paramString = (Server)com.alibaba.fastjson.a.parseObject(str, Server.class);
      locall.setSuccess(Boolean.valueOf(true));
      locall.setObject(paramString);
      return locall;
    }
    locall.setSuccess(Boolean.valueOf(false));
    locall.setMessage((String)localObject);
    return locall;
  }
  
  public static l parseHasUsePhone(String paramString)
  {
    l locall = new l();
    if (paramString == null) {
      try
      {
        throw new Exception();
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        locall.setSuccess(Boolean.valueOf(false));
        locall.setMessage("服务器异常，正在努力抢修中，请稍后再试!");
        return locall;
      }
    }
    if (paramString.equals("1"))
    {
      locall.setSuccess(Boolean.valueOf(true));
      return locall;
    }
    locall.setSuccess(Boolean.valueOf(false));
    return locall;
  }
  
  public static l parseHomePageNewImage(String paramString)
  {
    l locall = new l();
    if (paramString == null) {
      try
      {
        throw new Exception();
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        locall.setSuccess(Boolean.valueOf(false));
        locall.setMessage("服务器异常，正在努力抢修中，请稍后再试!");
        return locall;
      }
    }
    paramString = com.alibaba.fastjson.a.parseObject(paramString);
    if (((String)paramString.get("status")).equals("success"))
    {
      Object localObject = (com.alibaba.fastjson.b)paramString.get("data");
      if (localObject != null)
      {
        paramString = new ArrayList();
        localObject = ((com.alibaba.fastjson.b)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          Map localMap = (Map)((Iterator)localObject).next();
          ImageInfo localImageInfo = new ImageInfo();
          localImageInfo.setTitle((String)localMap.get("title"));
          localImageInfo.setUrl((String)localMap.get("url"));
          localImageInfo.setsImageUrl((String)localMap.get("320_pic"));
          localImageInfo.setbImageUrl((String)localMap.get("640_pic"));
          paramString.add(localImageInfo);
        }
        locall.setSuccess(Boolean.valueOf(true));
        locall.setObject(paramString);
        return locall;
      }
      locall.setSuccess(Boolean.valueOf(false));
      locall.setMessage("服务器异常，正在努力抢修中，请稍后再试!");
      return locall;
    }
    locall.setSuccess(Boolean.valueOf(false));
    locall.setMessage((String)paramString.get("message"));
    return locall;
  }
  
  public static l parseHotSearchWords(String paramString)
  {
    l locall = new l();
    if (paramString == null) {
      try
      {
        throw new Exception();
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        locall.setSuccess(Boolean.valueOf(false));
        locall.setMessage("服务器异常，正在努力抢修中，请稍后再试!");
        return locall;
      }
    }
    paramString = com.alibaba.fastjson.a.parseObject(paramString);
    if (((String)paramString.get("status")).equals("success"))
    {
      locall.setObject(com.alibaba.fastjson.a.parseArray(paramString.get("data").toString(), String.class));
      locall.setSuccess(Boolean.valueOf(true));
      return locall;
    }
    locall.setSuccess(Boolean.valueOf(false));
    locall.setMessage((String)paramString.get("error_message"));
    return locall;
  }
  
  public static l parseHotValues(String paramString)
  {
    l locall = new l();
    if (paramString == null) {
      try
      {
        throw new Exception();
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        locall.setSuccess(Boolean.valueOf(false));
        locall.setMessage("服务器异常，正在努力抢修中，请稍后再试!");
        return locall;
      }
    }
    paramString = com.alibaba.fastjson.a.parseObject(paramString);
    if (((String)paramString.get("status")).equals("success"))
    {
      Object localObject = (com.alibaba.fastjson.b)paramString.get("data");
      if (localObject != null)
      {
        paramString = new ArrayList();
        localObject = ((com.alibaba.fastjson.b)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          paramString.add((MapBizcircle)com.alibaba.fastjson.a.parseObject(((Iterator)localObject).next().toString(), MapBizcircle.class));
        }
        locall.setSuccess(Boolean.valueOf(true));
        locall.setObject(paramString);
        return locall;
      }
      locall.setSuccess(Boolean.valueOf(false));
      locall.setMessage("服务器异常，正在努力抢修中，请稍后再试!");
      return locall;
    }
    locall.setSuccess(Boolean.valueOf(false));
    locall.setMessage((String)paramString.get("error_message"));
    return locall;
  }
  
  public static l parseHouseCondition(String paramString)
  {
    l locall = new l();
    if (paramString == null) {
      try
      {
        throw new Exception();
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        locall.setSuccess(Boolean.valueOf(false));
        locall.setMessage("服务器异常，正在努力抢修中，请稍后再试!");
        return locall;
      }
    }
    Object localObject = com.alibaba.fastjson.a.parseObject(paramString);
    if (((String)((Map)localObject).get("status")).equals("success"))
    {
      paramString = new ArrayList();
      localObject = com.alibaba.fastjson.a.parseArray(((Map)localObject).get("data").toString(), HouseListSearchResult.class).iterator();
      while (((Iterator)localObject).hasNext())
      {
        HouseListSearchResult localHouseListSearchResult = (HouseListSearchResult)((Iterator)localObject).next();
        if (localHouseListSearchResult != null) {
          paramString.add(localHouseListSearchResult);
        }
      }
      locall.setSuccess(Boolean.valueOf(true));
      locall.setObject(paramString);
      return locall;
    }
    locall.setSuccess(Boolean.valueOf(false));
    locall.setMessage((String)((Map)localObject).get("error_message"));
    return locall;
  }
  
  public static l parseHouseDetailHZ(String paramString)
  {
    l locall = new l();
    if (paramString == null) {
      try
      {
        throw new Exception();
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        locall.setSuccess(Boolean.valueOf(false));
        locall.setMessage("服务器异常，正在努力抢修中，请稍后再试!");
        return locall;
      }
    }
    paramString = com.alibaba.fastjson.a.parseObject(paramString);
    if (((String)paramString.get("status")).equals("success"))
    {
      locall.setObject((HouseDetail)com.alibaba.fastjson.a.parseArray(paramString.get("data").toString().replaceAll("\n", ""), HouseDetail.class).get(0));
      locall.setSuccess(Boolean.valueOf(true));
      return locall;
    }
    locall.setSuccess(Boolean.valueOf(false));
    locall.setMessage((String)paramString.get("error_message"));
    return locall;
  }
  
  public static l parseHouseDetailPayWay(String paramString)
  {
    l locall = new l();
    if (paramString == null) {
      try
      {
        throw new Exception();
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        locall.setSuccess(Boolean.valueOf(false));
        locall.setMessage("服务器异常，正在努力抢修中，请稍后再试!");
        return locall;
      }
    }
    paramString = com.alibaba.fastjson.a.parseObject(paramString);
    if (((String)paramString.get("status")).equals("success"))
    {
      locall.setObject((HouseDetailPayWay)com.alibaba.fastjson.a.parseObject(paramString.get("data").toString(), HouseDetailPayWay.class));
      locall.setSuccess(Boolean.valueOf(true));
      return locall;
    }
    locall.setSuccess(Boolean.valueOf(false));
    locall.setMessage((String)paramString.get("error_message"));
    return locall;
  }
  
  public static l parseHouseDetailRecommend(String paramString)
  {
    l locall = new l();
    if (paramString == null) {
      try
      {
        throw new Exception();
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        locall.setSuccess(Boolean.valueOf(false));
        locall.setMessage("服务器异常，正在努力抢修中，请稍后再试!");
        return locall;
      }
    }
    paramString = com.alibaba.fastjson.a.parseObject(paramString);
    if (((String)paramString.get("status")).equals("success"))
    {
      locall.setObject(com.alibaba.fastjson.a.parseArray(paramString.get("data").toString(), HouseListSearchResult.class));
      locall.setSuccess(Boolean.valueOf(true));
      return locall;
    }
    locall.setSuccess(Boolean.valueOf(false));
    locall.setMessage((String)paramString.get("error_message"));
    return locall;
  }
  
  public static l parseHouseDetailZZ(String paramString)
  {
    l locall = new l();
    if (paramString == null) {
      try
      {
        throw new Exception();
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        locall.setSuccess(Boolean.valueOf(false));
        locall.setMessage("服务器异常，正在努力抢修中，请稍后再试!");
        return locall;
      }
    }
    paramString = com.alibaba.fastjson.a.parseObject(paramString);
    if (((String)paramString.get("status")).equals("success"))
    {
      locall.setObject((HouseDetail)com.alibaba.fastjson.a.parseArray(paramString.get("data").toString(), HouseDetail.class).get(0));
      locall.setSuccess(Boolean.valueOf(true));
      return locall;
    }
    locall.setSuccess(Boolean.valueOf(false));
    locall.setMessage((String)paramString.get("error_message"));
    return locall;
  }
  
  public static l parseHouseListDuanZu(String paramString)
  {
    l locall = new l();
    if (paramString == null) {
      try
      {
        throw new Exception();
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        locall.setSuccess(Boolean.valueOf(false));
        locall.setMessage("服务器异常，正在努力抢修中，请稍后再试!");
        return locall;
      }
    }
    paramString = com.alibaba.fastjson.a.parseObject(paramString);
    if (((String)paramString.get("status")).equals("success"))
    {
      locall.setObject(com.alibaba.fastjson.a.parseArray(paramString.get("data").toString(), HouseListSearchResult.class));
      locall.setSuccess(Boolean.valueOf(true));
      return locall;
    }
    locall.setSuccess(Boolean.valueOf(false));
    locall.setMessage((String)paramString.get("error_message"));
    return locall;
  }
  
  public static l parseHouseListDuanZuScreening(String paramString)
  {
    l locall = new l();
    if (paramString == null) {
      try
      {
        throw new Exception();
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        locall.setSuccess(Boolean.valueOf(false));
        locall.setMessage("服务器异常，正在努力抢修中，请稍后再试!");
        return locall;
      }
    }
    paramString = com.alibaba.fastjson.a.parseObject(paramString);
    if (((String)paramString.get("status")).equals("success"))
    {
      locall.setObject(com.alibaba.fastjson.a.parseArray(paramString.get("data").toString(), HouseListSearchResult.class));
      locall.setSuccess(Boolean.valueOf(true));
      return locall;
    }
    locall.setSuccess(Boolean.valueOf(false));
    locall.setMessage((String)paramString.get("error_message"));
    return locall;
  }
  
  public static l parseHouseListRecommend(String paramString)
  {
    l locall = new l();
    if (paramString == null) {
      try
      {
        throw new Exception();
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        locall.setSuccess(Boolean.valueOf(false));
        locall.setMessage("服务器异常，正在努力抢修中，请稍后再试!");
        return locall;
      }
    }
    paramString = com.alibaba.fastjson.a.parseObject(paramString);
    if (((String)paramString.get("status")).equals("success"))
    {
      locall.setObject(com.alibaba.fastjson.a.parseArray(paramString.get("data").toString(), HouseListSearchResult.class));
      locall.setSuccess(Boolean.valueOf(true));
      return locall;
    }
    locall.setSuccess(Boolean.valueOf(false));
    locall.setMessage((String)paramString.get("error_message"));
    return locall;
  }
  
  public static l parseHouseListSearch(String paramString)
  {
    l locall = new l();
    if (paramString == null) {
      try
      {
        throw new Exception();
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        locall.setSuccess(Boolean.valueOf(false));
        locall.setMessage("服务器异常，正在努力抢修中，请稍后再试!");
        return locall;
      }
    }
    paramString = com.alibaba.fastjson.a.parseObject(paramString);
    if (((String)paramString.get("status")).equals("success"))
    {
      locall.setObject(com.alibaba.fastjson.a.parseArray(paramString.get("data").toString(), HouseListSearchResult.class));
      locall.setSuccess(Boolean.valueOf(true));
      return locall;
    }
    locall.setSuccess(Boolean.valueOf(false));
    locall.setMessage((String)paramString.get("error_message"));
    return locall;
  }
  
  public static l parseIdentity(String paramString)
  {
    l locall = new l();
    if (paramString == null) {
      try
      {
        throw new Exception();
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        locall.setSuccess(Boolean.valueOf(false));
        locall.setMessage("服务器异常，正在努力抢修中，请稍后再试!");
        return locall;
      }
    }
    paramString = com.alibaba.fastjson.a.parseObject(paramString);
    if (((String)paramString.get("status")).equals("success"))
    {
      Object localObject = (com.alibaba.fastjson.b)paramString.get("data");
      if (localObject == null) {
        break label163;
      }
      paramString = new ArrayList();
      localObject = ((com.alibaba.fastjson.b)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        paramString.add((UserInfo)com.alibaba.fastjson.a.parseObject(((Iterator)localObject).next().toString(), UserInfo.class));
      }
    }
    for (;;)
    {
      locall.setSuccess(Boolean.valueOf(true));
      locall.setObject(paramString);
      return locall;
      locall.setSuccess(Boolean.valueOf(false));
      locall.setMessage("对不起，你不是自如客用户");
      return locall;
      label163:
      paramString = null;
    }
  }
  
  public static l parseIndex(String paramString)
  {
    l locall = new l();
    if (paramString == null) {
      try
      {
        throw new Exception();
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        locall.setSuccess(Boolean.valueOf(false));
        locall.setMessage("服务器异常，正在努力抢修中，请稍后再试!");
        return locall;
      }
    }
    paramString = com.alibaba.fastjson.a.parseObject(paramString);
    if (((String)paramString.get("status")).equals("success"))
    {
      locall.setObject(com.alibaba.fastjson.a.parseArray(paramString.get("data").toString(), HomeIndex.class));
      locall.setSuccess(Boolean.valueOf(true));
      return locall;
    }
    locall.setSuccess(Boolean.valueOf(false));
    locall.setMessage((String)paramString.get("error_message"));
    return locall;
  }
  
  public static l parseInitiateAppoint(String paramString)
  {
    l locall = new l();
    if (paramString == null) {
      try
      {
        throw new RuntimeException();
      }
      catch (Exception paramString)
      {
        locall.setSuccess(Boolean.valueOf(false));
        locall.setMessage("服务器异常，正在努力抢修中，请稍后再试!");
        return locall;
      }
    }
    paramString = com.alibaba.fastjson.a.parseObject(paramString);
    if ("success".equals((String)paramString.get("status")))
    {
      locall.setObject(paramString);
      locall.setSuccess(Boolean.valueOf(true));
    }
    for (;;)
    {
      locall.setMessage(paramString.get("error_message").toString());
      locall.setCode(paramString.get("error_code").toString());
      return locall;
      locall.setSuccess(Boolean.valueOf(false));
      locall.setMessage(paramString.get("error_message").toString());
    }
  }
  
  public static l parseLease(String paramString)
  {
    l locall = new l();
    if (paramString == null) {
      try
      {
        throw new Exception();
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        locall.setSuccess(Boolean.valueOf(false));
        locall.setMessage("服务器异常，正在努力抢修中，请稍后再试!");
        return locall;
      }
    }
    paramString = com.alibaba.fastjson.a.parseObject(paramString);
    if (((String)paramString.get("status")).equals("success"))
    {
      if ((com.alibaba.fastjson.e)paramString.get("data") != null)
      {
        new LeaseInfo();
        paramString = (LeaseInfo)com.alibaba.fastjson.a.parseObject(paramString.get("data").toString(), LeaseInfo.class);
        locall.setSuccess(Boolean.valueOf(true));
        locall.setObject(paramString);
        return locall;
      }
      locall.setSuccess(Boolean.valueOf(false));
      locall.setMessage("服务器异常，正在努力抢修中，请稍后再试!");
      return locall;
    }
    locall.setSuccess(Boolean.valueOf(false));
    locall.setMessage((String)paramString.get("message"));
    return locall;
  }
  
  public static l parseLeaseList(String paramString)
  {
    l locall = new l();
    if (paramString == null) {}
    try
    {
      locall.setSuccess(Boolean.valueOf(false));
      locall.setMessage("服务器异常，正在抢修中！");
      return locall;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      locall.setSuccess(Boolean.valueOf(false));
      locall.setMessage("服务器异常，正在努力抢修中，请稍后再试!");
    }
    paramString = com.alibaba.fastjson.a.parseObject(paramString);
    if (((String)paramString.get("status")).equals("success"))
    {
      new ArrayList();
      paramString = com.alibaba.fastjson.a.parseArray(paramString.get("data").toString(), LeaseListEntity.class);
      locall.setSuccess(Boolean.valueOf(true));
      locall.setObject(paramString);
    }
    else
    {
      locall.setSuccess(Boolean.valueOf(false));
      locall.setMessage((String)paramString.get("message"));
    }
    return locall;
  }
  
  public static l parseLeaseMyData(String paramString)
  {
    l locall = new l();
    if (paramString == null) {
      try
      {
        throw new Exception();
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        locall.setSuccess(Boolean.valueOf(false));
        locall.setMessage("服务器异常，正在努力抢修中，请稍后再试!");
        return locall;
      }
    }
    paramString = com.alibaba.fastjson.a.parseObject(paramString);
    if (((String)paramString.get("status")).equals("success"))
    {
      paramString = (LeaseMyDataEntity)com.alibaba.fastjson.a.parseObject(paramString.get("data").toString(), LeaseMyDataEntity.class);
      locall.setSuccess(Boolean.valueOf(true));
      locall.setObject(paramString);
      return locall;
    }
    locall.setSuccess(Boolean.valueOf(false));
    locall.setMessage((String)paramString.get("error_message"));
    return locall;
  }
  
  public static l parseLifeActivityData(String paramString)
  {
    l locall = new l();
    if (paramString == null) {
      try
      {
        throw new Exception();
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        locall.setSuccess(Boolean.valueOf(false));
        locall.setMessage("服务器异常，正在努力抢修中，请稍后再试!");
        return locall;
      }
    }
    paramString = com.alibaba.fastjson.a.parseObject(paramString);
    if ("success".equals((String)paramString.get("status")))
    {
      locall.setObject(com.alibaba.fastjson.a.parseArray(paramString.get("data").toString(), LifeInfo.class));
      locall.setSuccess(Boolean.valueOf(true));
      return locall;
    }
    locall.setSuccess(Boolean.valueOf(false));
    locall.setMessage((String)paramString.get("error_message"));
    return locall;
  }
  
  public static l parseLifeBannerData(String paramString)
  {
    l locall = new l();
    if (paramString == null) {
      try
      {
        throw new Exception();
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        locall.setSuccess(Boolean.valueOf(false));
        locall.setMessage("服务器异常，正在努力抢修中，请稍后再试!");
        return locall;
      }
    }
    paramString = com.alibaba.fastjson.a.parseObject(paramString);
    if ("success".equals((String)paramString.get("status")))
    {
      locall.setObject(com.alibaba.fastjson.a.parseArray(paramString.get("data").toString(), LifeBanner.class));
      locall.setSuccess(Boolean.valueOf(true));
      return locall;
    }
    locall.setSuccess(Boolean.valueOf(false));
    locall.setMessage((String)paramString.get("error_message"));
    return locall;
  }
  
  public static l parseLifeDetailsData(String paramString)
  {
    l locall = new l();
    if (paramString == null) {
      try
      {
        throw new Exception();
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        locall.setSuccess(Boolean.valueOf(false));
        locall.setMessage("服务器异常，正在努力抢修中，请稍后再试!");
        return locall;
      }
    }
    paramString = com.alibaba.fastjson.a.parseObject(paramString);
    if ("success".equals((String)paramString.get("status")))
    {
      locall.setObject((LifeDetails)com.alibaba.fastjson.a.parseObject(paramString.get("data").toString().replaceAll("\n", ""), LifeDetails.class));
      locall.setSuccess(Boolean.valueOf(true));
      return locall;
    }
    locall.setSuccess(Boolean.valueOf(false));
    locall.setMessage((String)paramString.get("error_message"));
    return locall;
  }
  
  public static l parseLogin(String paramString)
  {
    l locall = new l();
    if (paramString == null) {
      try
      {
        throw new Exception();
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        locall.setSuccess(Boolean.valueOf(false));
        locall.setMessage("网络数据请求失败!");
        u.e("parseLogin", paramString.getMessage());
        return locall;
      }
    }
    paramString = com.alibaba.fastjson.a.parseObject(paramString);
    if (((String)paramString.get("status")).equals("success"))
    {
      paramString = (UserInfo)com.alibaba.fastjson.a.parseObject(paramString.get("data").toString(), UserInfo.class);
      locall.setSuccess(Boolean.valueOf(true));
      locall.setObject(paramString);
      return locall;
    }
    locall.setSuccess(Boolean.valueOf(false));
    locall.setMessage((String)paramString.get("error_message"));
    return locall;
  }
  
  public static l parseLoginByCode(String paramString)
  {
    l locall = new l();
    if (paramString == null) {
      try
      {
        throw new Exception();
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        locall.setSuccess(Boolean.valueOf(false));
        locall.setMessage("服务器异常，正在努力抢修中，请稍后再试!");
        return locall;
      }
    }
    paramString = com.alibaba.fastjson.a.parseObject(paramString);
    if (((String)paramString.get("status")).equals("success"))
    {
      locall.setObject((Login)com.alibaba.fastjson.a.parseObject(paramString.get("data").toString(), Login.class));
      locall.setSuccess(Boolean.valueOf(true));
      return locall;
    }
    locall.setSuccess(Boolean.valueOf(false));
    locall.setMessage((String)paramString.get("error_message"));
    return locall;
  }
  
  public static l parseLoginCode(String paramString)
  {
    l locall = new l();
    if (paramString == null) {
      try
      {
        throw new Exception();
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        locall.setSuccess(Boolean.valueOf(false));
        locall.setMessage("服务器异常，正在努力抢修中，请稍后再试!");
        return locall;
      }
    }
    paramString = com.alibaba.fastjson.a.parseObject(paramString);
    if (((String)paramString.get("status")).equals("success"))
    {
      locall.setSuccess(Boolean.valueOf(true));
      return locall;
    }
    locall.setSuccess(Boolean.valueOf(false));
    locall.setMessage((String)paramString.get("error_message"));
    return locall;
  }
  
  public static l parseMakeOrder(String paramString1, String paramString2)
  {
    l locall = new l();
    if (paramString1 == null)
    {
      try
      {
        throw new Exception();
      }
      catch (Exception paramString1)
      {
        paramString1.printStackTrace();
        locall.setSuccess(Boolean.valueOf(false));
        locall.setMessage("服务器异常，正在努力抢修中，请稍后再试!");
      }
      return locall;
    }
    paramString1 = com.alibaba.fastjson.a.parseObject(paramString1);
    PayOrder localPayOrder;
    if ("success".equals(paramString1.get("status").toString()))
    {
      localPayOrder = new PayOrder();
      if ("1".equals(paramString2)) {
        paramString1 = (Map)paramString1.get("data");
      }
    }
    for (;;)
    {
      if (paramString1 == null)
      {
        locall.setSuccess(Boolean.valueOf(false));
        locall.setMessage("服务器异常，正在努力抢修中，请稍后再试!");
        return locall;
        if ("0".equals(paramString2)) {
          paramString1 = (Map)paramString1.get("data");
        }
      }
      else
      {
        label156:
        int i;
        if (paramString1.get("package") == null)
        {
          paramString2 = "";
          localPayOrder.set_package(paramString2);
          if (paramString1.get("card_values") != null) {
            break label529;
          }
          i = 0;
          label176:
          localPayOrder.setCard_values(i);
          if (paramString1.get("current_money") != null) {
            break label571;
          }
          i = 0;
          label196:
          localPayOrder.setCurrent_money(i);
          if (paramString1.get("merorder_id") != null) {
            break label590;
          }
          paramString2 = "";
          label217:
          localPayOrder.setMerorder_id(paramString2);
          if (paramString1.get("sign") != null) {
            break label606;
          }
          paramString2 = "";
          label238:
          localPayOrder.setSign(paramString2);
          if (paramString1.get("timestamp") != null) {
            break label622;
          }
          paramString2 = "";
          label259:
          localPayOrder.setTimestamp(paramString2);
          if (paramString1.get("trans_id") != null) {
            break label638;
          }
          paramString2 = "";
          label280:
          localPayOrder.setTrans_id(paramString2);
          if (paramString1.get("url") != null) {
            break label654;
          }
          paramString2 = "";
          label301:
          localPayOrder.setUrl(paramString2);
          if (paramString1.get("stand_num") != null) {
            break label670;
          }
          paramString2 = "";
          label322:
          localPayOrder.setStand_num(paramString2);
          if (paramString1.get("partnerid") != null) {
            break label686;
          }
          paramString2 = "";
          label343:
          localPayOrder.setPartnerid(paramString2);
          if (paramString1.get("companyCode") != null) {
            break label702;
          }
          paramString2 = "";
          label364:
          localPayOrder.setCompanyCode(paramString2);
          if (paramString1.get("orderCode") != null) {
            break label718;
          }
          paramString2 = "";
          label385:
          localPayOrder.setOrderCode(paramString2);
          if (paramString1.get("resp_desc") != null) {
            break label734;
          }
          paramString2 = "";
          label406:
          localPayOrder.setResp_desc(paramString2);
          if (paramString1.get("resp_code") != null) {
            break label750;
          }
          paramString2 = "";
          label427:
          localPayOrder.setResp_code(paramString2);
          if (paramString1.get("respCode") != null) {
            break label766;
          }
          paramString2 = "";
          label448:
          localPayOrder.setRespCode(paramString2);
          if (paramString1.get("respMsg") != null) {
            break label782;
          }
          paramString2 = "";
          label469:
          localPayOrder.setRespMsg(paramString2);
          if (paramString1.get("bizCode") != null) {
            break label798;
          }
        }
        label529:
        label571:
        label590:
        label606:
        label622:
        label638:
        label654:
        label670:
        label686:
        label702:
        label718:
        label734:
        label750:
        label766:
        label782:
        label798:
        for (paramString1 = "";; paramString1 = paramString1.get("bizCode").toString())
        {
          localPayOrder.setBizCode(paramString1);
          locall.setSuccess(Boolean.valueOf(true));
          locall.setObject(localPayOrder);
          break;
          paramString2 = paramString1.get("package").toString();
          break label156;
          if (ae.isNull(paramString1.get("card_values").toString()))
          {
            i = 0;
            break label176;
          }
          i = Integer.parseInt(paramString1.get("card_values").toString());
          break label176;
          i = Integer.parseInt(paramString1.get("current_money").toString());
          break label196;
          paramString2 = paramString1.get("merorder_id").toString();
          break label217;
          paramString2 = paramString1.get("sign").toString();
          break label238;
          paramString2 = paramString1.get("timestamp").toString();
          break label259;
          paramString2 = paramString1.get("trans_id").toString();
          break label280;
          paramString2 = paramString1.get("url").toString();
          break label301;
          paramString2 = paramString1.get("stand_num").toString();
          break label322;
          paramString2 = paramString1.get("partnerid").toString();
          break label343;
          paramString2 = paramString1.get("companyCode").toString();
          break label364;
          paramString2 = paramString1.get("orderCode").toString();
          break label385;
          paramString2 = paramString1.get("resp_desc").toString();
          break label406;
          paramString2 = paramString1.get("resp_code").toString();
          break label427;
          paramString2 = paramString1.get("respCode").toString();
          break label448;
          paramString2 = paramString1.get("respMsg").toString();
          break label469;
        }
        locall.setSuccess(Boolean.valueOf(false));
        locall.setCode(paramString1.get("error_code").toString());
        locall.setMessage((String)paramString1.get("error_describe"));
        if ("1".equals(paramString2)) {
          locall.setMessage((String)paramString1.get("error_message"));
        }
        for (;;)
        {
          if (paramString1.get("error_describe") != null) {
            break label925;
          }
          locall.setMessage((String)paramString1.get("error_message"));
          break;
          locall.setMessage((String)paramString1.get("error_describe"));
        }
        label925:
        break;
      }
      paramString1 = null;
    }
  }
  
  public static l parseModifyContractState(String paramString)
  {
    l locall = new l();
    if (paramString == null) {
      try
      {
        throw new Exception();
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        locall.setSuccess(Boolean.valueOf(false));
        locall.setMessage("服务器异常，正在努力抢修中，请稍后再试!");
        return locall;
      }
    }
    paramString = com.alibaba.fastjson.a.parseObject(paramString);
    if ("success".equals((String)paramString.get("status")))
    {
      locall.setSuccess(Boolean.valueOf(true));
      return locall;
    }
    locall.setSuccess(Boolean.valueOf(false));
    locall.setMessage((String)paramString.get("error_message"));
    return locall;
  }
  
  public static l parseNeighbor(String paramString)
  {
    l locall = new l();
    if (paramString == null) {
      try
      {
        throw new Exception();
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        locall.setSuccess(Boolean.valueOf(false));
        locall.setMessage("服务器异常，正在努力抢修中，请稍后再试!");
        return locall;
      }
    }
    Object localObject1 = com.alibaba.fastjson.a.parseObject(paramString);
    if (((String)((Map)localObject1).get("status")).equals("success"))
    {
      paramString = com.alibaba.fastjson.a.parseObject(((Map)localObject1).get("data").toString());
      localObject1 = ((Map)((Map)localObject1).get("data")).entrySet().iterator();
      ArrayList localArrayList = new ArrayList();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject3 = (Map.Entry)((Iterator)localObject1).next();
        Object localObject2 = (com.alibaba.fastjson.b)paramString.get(((Map.Entry)localObject3).getKey());
        if (localObject2 != null)
        {
          Neighbour localNeighbour = new Neighbour();
          localNeighbour.setHouse_code((String)((Map.Entry)localObject3).getKey());
          localObject3 = new ArrayList();
          localObject2 = ((com.alibaba.fastjson.b)localObject2).iterator();
          while (((Iterator)localObject2).hasNext()) {
            ((List)localObject3).add((NeighbourDetail)com.alibaba.fastjson.a.parseObject(((Iterator)localObject2).next().toString(), NeighbourDetail.class));
          }
          localNeighbour.setList((List)localObject3);
          localArrayList.add(localNeighbour);
        }
      }
      locall.setSuccess(Boolean.valueOf(true));
      locall.setObject(localArrayList);
      return locall;
    }
    locall.setSuccess(Boolean.valueOf(false));
    return locall;
  }
  
  public static l parseNewLogin(String paramString)
  {
    l locall = new l();
    if (paramString == null) {
      try
      {
        throw new Exception();
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        locall.setSuccess(Boolean.valueOf(false));
        locall.setMessage("网络数据请求失败!");
        u.e("parseLogin", paramString.getMessage());
        return locall;
      }
    }
    paramString = com.alibaba.fastjson.a.parseObject(paramString);
    if (((String)paramString.get("status")).equals("success"))
    {
      paramString = com.alibaba.fastjson.a.parseObject(paramString.get("data").toString());
      locall.setSuccess(Boolean.valueOf(true));
      locall.setObject(paramString.get("uid"));
      return locall;
    }
    locall.setSuccess(Boolean.valueOf(false));
    locall.setMessage((String)paramString.get("error_message"));
    return locall;
  }
  
  public static l parseNotPayEntity(String paramString)
  {
    l locall = new l();
    if (paramString == null) {
      try
      {
        throw new Exception();
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        locall.setSuccess(Boolean.valueOf(false));
        locall.setMessage("服务器异常，正在努力抢修中，请稍后再试!");
        return locall;
      }
    }
    paramString = com.alibaba.fastjson.a.parseObject(paramString);
    if (((String)paramString.get("status")).equals("success"))
    {
      locall.setObject(com.alibaba.fastjson.a.parseArray(com.alibaba.fastjson.a.parseObject(paramString.get("data").toString()).get("rentAndPenalty").toString(), NotPayEntity.class));
      locall.setSuccess(Boolean.valueOf(true));
      return locall;
    }
    locall.setSuccess(Boolean.valueOf(false));
    locall.setMessage((String)paramString.get("error_message"));
    return locall;
  }
  
  public static l parseNotify(String paramString)
  {
    l locall = new l();
    if (paramString == null) {
      try
      {
        throw new Exception();
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        locall.setSuccess(Boolean.valueOf(false));
        locall.setMessage("服务器异常，正在努力抢修中，请稍后再试!");
        return locall;
      }
    }
    Object localObject = com.alibaba.fastjson.a.parseObject(paramString);
    paramString = (String)((Map)localObject).get("status");
    localObject = (String)((Map)localObject).get("error_message");
    if (paramString.equals("success"))
    {
      locall.setSuccess(Boolean.valueOf(true));
      return locall;
    }
    locall.setSuccess(Boolean.valueOf(false));
    locall.setMessage((String)localObject);
    return locall;
  }
  
  public static l parseOldMakeOrder(String paramString1, String paramString2)
  {
    paramString2 = new l();
    if (paramString1 == null) {
      try
      {
        throw new Exception();
      }
      catch (Exception paramString1)
      {
        paramString1.printStackTrace();
        paramString2.setSuccess(Boolean.valueOf(false));
        paramString2.setMessage("服务器异常，正在努力抢修中，请稍后再试!");
        return paramString2;
      }
    }
    paramString1 = com.alibaba.fastjson.a.parseObject(paramString1);
    if ("success".equals((String)paramString1.get("status")))
    {
      PayOrder localPayOrder = new PayOrder();
      Map localMap = (Map)paramString1.get("data");
      int i;
      if (localMap.get("package") == null)
      {
        paramString1 = "";
        localPayOrder.set_package(paramString1);
        if (localMap.get("card_values") != null) {
          break label452;
        }
        i = 0;
        label122:
        localPayOrder.setCard_values(i);
        if (localMap.get("current_money") != null) {
          break label496;
        }
        i = 0;
        label142:
        localPayOrder.setCurrent_money(i);
        if (localMap.get("merorder_id") != null) {
          break label516;
        }
        paramString1 = "";
        label163:
        localPayOrder.setMerorder_id(paramString1);
        if (localMap.get("sign") != null) {
          break label533;
        }
        paramString1 = "";
        label184:
        localPayOrder.setSign(paramString1);
        if (localMap.get("timestamp") != null) {
          break label550;
        }
        paramString1 = "";
        label205:
        localPayOrder.setTimestamp(paramString1);
        if (localMap.get("trans_id") != null) {
          break label567;
        }
        paramString1 = "";
        label226:
        localPayOrder.setTrans_id(paramString1);
        if (localMap.get("url") != null) {
          break label584;
        }
        paramString1 = "";
        label247:
        localPayOrder.setUrl(paramString1);
        if (localMap.get("stand_num") != null) {
          break label601;
        }
        paramString1 = "";
        label268:
        localPayOrder.setStand_num(paramString1);
        if (localMap.get("partnerid") != null) {
          break label618;
        }
        paramString1 = "";
        label289:
        localPayOrder.setPartnerid(paramString1);
        if (localMap.get("orderCode") != null) {
          break label635;
        }
        paramString1 = "";
        label310:
        localPayOrder.setOrderCode(paramString1);
        if (localMap.get("resp_desc") != null) {
          break label652;
        }
        paramString1 = "";
        label331:
        localPayOrder.setResp_desc(paramString1);
        if (localMap.get("resp_code") != null) {
          break label669;
        }
        paramString1 = "";
        label352:
        localPayOrder.setResp_code(paramString1);
        if (localMap.get("respCode") != null) {
          break label686;
        }
        paramString1 = "";
        label373:
        localPayOrder.setRespCode(paramString1);
        if (localMap.get("respMsg") != null) {
          break label703;
        }
        paramString1 = "";
        label394:
        localPayOrder.setRespMsg(paramString1);
        if (localMap.get("bizCode") != null) {
          break label720;
        }
      }
      label452:
      label496:
      label516:
      label533:
      label550:
      label567:
      label584:
      label601:
      label618:
      label635:
      label652:
      label669:
      label686:
      label703:
      label720:
      for (paramString1 = "";; paramString1 = localMap.get("bizCode").toString())
      {
        localPayOrder.setBizCode(paramString1);
        paramString2.setSuccess(Boolean.valueOf(true));
        paramString2.setObject(localPayOrder);
        return paramString2;
        paramString1 = localMap.get("package").toString();
        break;
        if (ae.isNull(localMap.get("card_values").toString()))
        {
          i = 0;
          break label122;
        }
        i = Integer.parseInt(localMap.get("card_values").toString());
        break label122;
        i = Integer.parseInt(localMap.get("current_money").toString());
        break label142;
        paramString1 = localMap.get("merorder_id").toString();
        break label163;
        paramString1 = localMap.get("sign").toString();
        break label184;
        paramString1 = localMap.get("timestamp").toString();
        break label205;
        paramString1 = localMap.get("trans_id").toString();
        break label226;
        paramString1 = localMap.get("url").toString();
        break label247;
        paramString1 = localMap.get("stand_num").toString();
        break label268;
        paramString1 = localMap.get("partnerid").toString();
        break label289;
        paramString1 = localMap.get("orderCode").toString();
        break label310;
        paramString1 = localMap.get("resp_desc").toString();
        break label331;
        paramString1 = localMap.get("resp_code").toString();
        break label352;
        paramString1 = localMap.get("respCode").toString();
        break label373;
        paramString1 = localMap.get("respMsg").toString();
        break label394;
      }
    }
    paramString2.setSuccess(Boolean.valueOf(false));
    paramString2.setMessage((String)paramString1.get("error_message"));
    return paramString2;
  }
  
  public static l parsePayContractJava(String paramString)
  {
    l locall = new l();
    if (paramString == null) {
      try
      {
        throw new Exception();
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        locall.setSuccess(Boolean.valueOf(false));
        locall.setMessage("网络数据请求失败!");
        u.e("parsePayStateInformation", paramString.getMessage());
        return locall;
      }
    }
    paramString = com.alibaba.fastjson.a.parseObject(paramString);
    if ("success".equals((String)paramString.get("status")))
    {
      com.alibaba.fastjson.a.parseObject(paramString.get("data").toString());
      locall.setSuccess(Boolean.valueOf(true));
      return locall;
    }
    locall.setSuccess(Boolean.valueOf(false));
    locall.setCode(paramString.get("error_code").toString());
    locall.setMessage((String)paramString.get("error_message"));
    return locall;
  }
  
  public static l parsePayContractPhp(String paramString)
  {
    l locall = new l();
    if (paramString == null) {
      try
      {
        throw new Exception();
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        locall.setSuccess(Boolean.valueOf(false));
        locall.setMessage("网络数据请求失败!");
        u.e("parsePayStateInformation", paramString.getMessage());
        return locall;
      }
    }
    paramString = com.alibaba.fastjson.a.parseObject(paramString);
    if ("success".equals((String)paramString.get("status")))
    {
      paramString = paramString.get("data").toString();
      locall.setSuccess(Boolean.valueOf(true));
      locall.setObject(paramString);
      return locall;
    }
    locall.setSuccess(Boolean.valueOf(false));
    locall.setMessage((String)paramString.get("error_message"));
    return locall;
  }
  
  public static l parsePayData(String paramString1, String paramString2)
  {
    l locall = new l();
    if (paramString1 == null) {
      try
      {
        throw new Exception();
      }
      catch (Exception paramString1)
      {
        paramString1.printStackTrace();
        locall.setSuccess(Boolean.valueOf(false));
        locall.setMessage("服务器异常，正在努力抢修中，请稍后再试!");
        return locall;
      }
    }
    paramString1 = com.alibaba.fastjson.a.parseObject(paramString1);
    if (((String)paramString1.get("status")).equals("success"))
    {
      if ("0".equals(paramString2))
      {
        paramString1 = (SignedPayDataEntity)com.alibaba.fastjson.a.parseObject(paramString1.get("data").toString(), SignedPayDataEntity.class);
        locall.setSuccess(Boolean.valueOf(true));
        locall.setObject(paramString1);
        return locall;
      }
      paramString1 = (SignedOldPayDataEntity)com.alibaba.fastjson.a.parseObject(paramString1.get("data").toString(), SignedOldPayDataEntity.class);
      locall.setSuccess(Boolean.valueOf(true));
      locall.setObject(paramString1);
      return locall;
    }
    locall.setSuccess(Boolean.valueOf(false));
    locall.setMessage((String)paramString1.get("error_message"));
    return locall;
  }
  
  public static l parsePayDetailInfo(String paramString)
  {
    l locall = new l();
    if (paramString == null) {
      try
      {
        throw new Exception();
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        locall.setSuccess(Boolean.valueOf(false));
        locall.setMessage("服务器异常，正在努力抢修中，请稍后再试!");
        return locall;
      }
    }
    paramString = com.alibaba.fastjson.a.parseObject(paramString);
    if ("success".equals((String)paramString.get("status")))
    {
      locall.setObject((LeasePayDetail)com.alibaba.fastjson.a.parseObject(paramString.get("data").toString(), LeasePayDetail.class));
      locall.setSuccess(Boolean.valueOf(true));
      return locall;
    }
    locall.setSuccess(Boolean.valueOf(false));
    locall.setMessage((String)paramString.get("error_message"));
    return locall;
  }
  
  public static l parsePayDetails(String paramString)
  {
    l locall = new l();
    if (paramString == null) {
      try
      {
        throw new Exception();
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        locall.setSuccess(Boolean.valueOf(false));
        locall.setMessage("服务器异常，正在努力抢修中，请稍后再试!");
        return locall;
      }
    }
    paramString = com.alibaba.fastjson.a.parseObject(paramString);
    if (((String)paramString.get("status")).equals("success"))
    {
      paramString = (SignedPayDetails)com.alibaba.fastjson.a.parseObject(paramString.get("data").toString(), SignedPayDetails.class);
      locall.setSuccess(Boolean.valueOf(true));
      locall.setObject(paramString);
      return locall;
    }
    locall.setSuccess(Boolean.valueOf(false));
    locall.setMessage((String)paramString.get("error_message"));
    return locall;
  }
  
  public static l parsePayKims(String paramString)
  {
    l locall = new l();
    if (paramString == null) {
      try
      {
        throw new Exception();
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        locall.setSuccess(Boolean.valueOf(false));
        locall.setMessage("服务器异常，正在努力抢修中，请稍后再试!");
        return locall;
      }
    }
    paramString = com.alibaba.fastjson.a.parseObject(paramString);
    if (((String)paramString.get("status")).equals("success"))
    {
      float f = Float.parseFloat(com.alibaba.fastjson.a.parseObject(paramString.get("data").toString()).get("value").toString());
      locall.setSuccess(Boolean.valueOf(true));
      locall.setObject(Float.valueOf(f));
      return locall;
    }
    locall.setSuccess(Boolean.valueOf(false));
    locall.setMessage(paramString.get("error_message").toString());
    return locall;
  }
  
  public static l parsePayPartStateInformation(String paramString)
  {
    l locall = new l();
    if (paramString == null) {
      try
      {
        throw new Exception();
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        locall.setSuccess(Boolean.valueOf(false));
        locall.setMessage("网络数据请求失败!");
        u.e("parsePayPartStateInformation", paramString.getMessage());
        return locall;
      }
    }
    paramString = com.alibaba.fastjson.a.parseObject(paramString);
    if ("success".equals((String)paramString.get("status")))
    {
      paramString = (PayPartStateInfo)com.alibaba.fastjson.a.parseObject(paramString.get("data").toString(), PayPartStateInfo.class);
      locall.setSuccess(Boolean.valueOf(true));
      locall.setObject(paramString);
      return locall;
    }
    locall.setSuccess(Boolean.valueOf(false));
    locall.setMessage((String)paramString.get("error_message"));
    return locall;
  }
  
  public static l parsePayServiceData(String paramString)
  {
    l locall = new l();
    if (paramString == null) {
      try
      {
        throw new Exception();
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        locall.setSuccess(Boolean.valueOf(false));
        locall.setMessage("服务器异常，正在努力抢修中，请稍后再试!");
        return locall;
      }
    }
    paramString = com.alibaba.fastjson.a.parseObject(paramString);
    if (((String)paramString.get("status")).equals("success"))
    {
      paramString = com.alibaba.fastjson.a.parseArray(paramString.get("data").toString(), SignedPayServiceDataEntity.class);
      locall.setSuccess(Boolean.valueOf(true));
      locall.setObject(paramString);
      return locall;
    }
    locall.setSuccess(Boolean.valueOf(false));
    locall.setMessage((String)paramString.get("error_message"));
    return locall;
  }
  
  public static l parsePayStateWYInformation(String paramString)
  {
    l locall = new l();
    if (paramString == null) {
      try
      {
        throw new Exception();
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        locall.setSuccess(Boolean.valueOf(false));
        locall.setMessage("网络数据请求失败!");
        u.e("parseShareInformation", paramString.getMessage());
        return locall;
      }
    }
    paramString = com.alibaba.fastjson.a.parseObject(paramString);
    if (((String)paramString.get("status")).equals("success"))
    {
      locall.setSuccess(Boolean.valueOf(true));
      return locall;
    }
    locall.setSuccess(Boolean.valueOf(false));
    locall.setMessage((String)paramString.get("error_message"));
    return locall;
  }
  
  public static l parsePayStatus(String paramString)
  {
    l locall = new l();
    if (paramString == null) {
      try
      {
        throw new Exception();
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        locall.setSuccess(Boolean.valueOf(false));
        locall.setMessage("服务器异常，正在努力抢修中，请稍后再试!");
        return locall;
      }
    }
    paramString = com.alibaba.fastjson.a.parseObject(paramString);
    if (((String)paramString.get("status")).equals("success"))
    {
      paramString = com.alibaba.fastjson.a.parseObject(paramString.get("data").toString()).get("house_status").toString();
      locall.setSuccess(Boolean.valueOf(true));
      locall.setObject(paramString);
      return locall;
    }
    locall.setSuccess(Boolean.valueOf(false));
    locall.setMessage((String)paramString.get("error_message"));
    return locall;
  }
  
  public static l parsePayType(String paramString)
  {
    l locall = new l();
    if (paramString == null) {
      try
      {
        throw new Exception();
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        locall.setSuccess(Boolean.valueOf(false));
        locall.setMessage("服务器异常，正在努力抢修中，请稍后再试!");
        return locall;
      }
    }
    paramString = com.alibaba.fastjson.a.parseObject(paramString);
    if (((String)paramString.get("status")).equals("success"))
    {
      locall.setSuccess(Boolean.valueOf(true));
      return locall;
    }
    locall.setSuccess(Boolean.valueOf(false));
    locall.setMessage((String)paramString.get("error_message"));
    return locall;
  }
  
  public static l parsePersonData(String paramString)
  {
    l locall = new l();
    if (paramString == null) {
      try
      {
        throw new Exception();
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        locall.setSuccess(Boolean.valueOf(false));
        locall.setMessage("服务器异常，正在努力抢修中，请稍后再试!");
        return locall;
      }
    }
    Object localObject = com.alibaba.fastjson.a.parseObject(paramString);
    paramString = (String)((Map)localObject).get("status");
    localObject = (String)((Map)localObject).get("error_message");
    if (paramString.equals("success"))
    {
      locall.setSuccess(Boolean.valueOf(true));
      return locall;
    }
    locall.setSuccess(Boolean.valueOf(false));
    locall.setMessage((String)localObject);
    return locall;
  }
  
  public static l parsePhoneAndIdentifyCode(String paramString)
  {
    l locall = new l();
    if (paramString == null) {
      try
      {
        throw new Exception();
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        locall.setSuccess(Boolean.valueOf(false));
        locall.setMessage("服务器异常，正在努力抢修中，请稍后再试!");
        return locall;
      }
    }
    if (paramString.equals("(1)"))
    {
      locall.setMessage("短信已发送成功");
      locall.setSuccess(Boolean.valueOf(true));
    }
    if (paramString.equals("(-1)"))
    {
      locall.setSuccess(Boolean.valueOf(false));
      locall.setMessage("5分钟内已经发送，禁止再次发送");
    }
    if (paramString.equals("(-3)"))
    {
      locall.setSuccess(Boolean.valueOf(false));
      locall.setMessage("验证码输入错误");
      return locall;
    }
    locall.setSuccess(Boolean.valueOf(false));
    return locall;
  }
  
  public static l parseRegister(String paramString)
  {
    l locall = new l();
    if (paramString == null) {
      try
      {
        throw new Exception();
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        locall.setSuccess(Boolean.valueOf(false));
        locall.setMessage("服务器异常，正在努力抢修中，请稍后再试!");
        return locall;
      }
    }
    paramString = com.alibaba.fastjson.a.parseObject(paramString);
    if (((String)paramString.get("status")).equals("success"))
    {
      locall.setSuccess(Boolean.valueOf(true));
      return locall;
    }
    locall.setSuccess(Boolean.valueOf(false));
    locall.setMessage((String)paramString.get("error_message"));
    return locall;
  }
  
  public static l parseRegisterByCode(String paramString)
  {
    l locall = new l();
    if (paramString == null) {
      try
      {
        throw new Exception();
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        locall.setSuccess(Boolean.valueOf(false));
        locall.setMessage("服务器异常，正在努力抢修中，请稍后再试!");
        return locall;
      }
    }
    paramString = com.alibaba.fastjson.a.parseObject(paramString);
    if (((String)paramString.get("status")).equals("success"))
    {
      locall.setObject((Login)com.alibaba.fastjson.a.parseObject(paramString.get("data").toString(), Login.class));
      locall.setSuccess(Boolean.valueOf(true));
      return locall;
    }
    locall.setSuccess(Boolean.valueOf(false));
    locall.setMessage((String)paramString.get("error_message"));
    return locall;
  }
  
  public static l parseRegisterCode(String paramString)
  {
    l locall = new l();
    if (paramString == null) {
      try
      {
        throw new Exception();
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        locall.setCode("110");
        locall.setSuccess(Boolean.valueOf(false));
        locall.setMessage("服务器异常，正在努力抢修中，请稍后再试!");
        return locall;
      }
    }
    paramString = com.alibaba.fastjson.a.parseObject(paramString);
    if (((String)paramString.get("status")).equals("success"))
    {
      paramString = (Map)paramString.get("data");
      locall.setObject("");
      locall.setSuccess(Boolean.valueOf(true));
      return locall;
    }
    locall.setSuccess(Boolean.valueOf(false));
    locall.setCode((String)paramString.get("error_code"));
    locall.setMessage((String)paramString.get("error_message"));
    return locall;
  }
  
  public static l parseRemoveAlternateList(String paramString)
  {
    l locall = new l();
    if (paramString == null) {
      try
      {
        throw new Exception();
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        locall.setSuccess(Boolean.valueOf(false));
        locall.setMessage("网络数据请求失败!");
        u.e("parseRemoveAlternateList", paramString.getMessage());
        return locall;
      }
    }
    paramString = com.alibaba.fastjson.a.parseObject(paramString);
    if (((String)paramString.get("status")).equals("success"))
    {
      locall.setSuccess(Boolean.valueOf(true));
      return locall;
    }
    locall.setSuccess(Boolean.valueOf(false));
    locall.setMessage((String)paramString.get("error_message"));
    return locall;
  }
  
  public static l parseResetPsw(String paramString)
  {
    l locall = new l();
    if (paramString == null) {
      try
      {
        throw new Exception();
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        locall.setSuccess(Boolean.valueOf(false));
        locall.setMessage("服务器异常，正在努力抢修中，请稍后再试!");
        return locall;
      }
    }
    Object localObject = com.alibaba.fastjson.a.parseObject(paramString);
    paramString = (String)((Map)localObject).get("status");
    localObject = (String)((Map)localObject).get("error_message");
    if (paramString.equals("success"))
    {
      locall.setSuccess(Boolean.valueOf(true));
      return locall;
    }
    locall.setSuccess(Boolean.valueOf(false));
    locall.setMessage((String)localObject);
    return locall;
  }
  
  public static l parseSaveAlternateList(String paramString)
  {
    l locall = new l();
    if (paramString == null) {
      try
      {
        throw new Exception();
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        locall.setSuccess(Boolean.valueOf(false));
        locall.setMessage("网络数据请求失败!");
        u.e("parseSaveAlternateList", paramString.getMessage());
        return locall;
      }
    }
    paramString = com.alibaba.fastjson.a.parseObject(paramString);
    if (((String)paramString.get("status")).equals("success"))
    {
      locall.setSuccess(Boolean.valueOf(true));
      return locall;
    }
    locall.setSuccess(Boolean.valueOf(false));
    locall.setMessage((String)paramString.get("error_message"));
    return locall;
  }
  
  public static l parseSetIsShareInformation(String paramString)
  {
    l locall = new l();
    if (paramString == null) {
      try
      {
        throw new Exception();
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        locall.setSuccess(Boolean.valueOf(false));
        locall.setMessage("网络数据请求失败!");
        u.e("parseShareInformation", paramString.getMessage());
        return locall;
      }
    }
    paramString = com.alibaba.fastjson.a.parseObject(paramString);
    if (((String)paramString.get("status")).equals("success"))
    {
      locall.setSuccess(Boolean.valueOf(true));
      return locall;
    }
    locall.setSuccess(Boolean.valueOf(false));
    locall.setMessage((String)paramString.get("error_message"));
    return locall;
  }
  
  public static l parseSetPayWay(String paramString)
  {
    l locall = new l();
    if (paramString == null) {
      try
      {
        throw new Exception();
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        locall.setSuccess(Boolean.valueOf(false));
        locall.setMessage("服务器异常，正在努力抢修中，请稍后再试!");
        return locall;
      }
    }
    paramString = com.alibaba.fastjson.a.parseObject(paramString);
    if (((String)paramString.get("status")).equals("success"))
    {
      paramString = paramString.get("data").toString();
      locall.setSuccess(Boolean.valueOf(true));
      locall.setObject(paramString);
      return locall;
    }
    locall.setSuccess(Boolean.valueOf(false));
    locall.setCode(paramString.get("error_code").toString());
    locall.setMessage((String)paramString.get("error_message"));
    return locall;
  }
  
  public static l parseSetShareInformation(String paramString)
  {
    l locall = new l();
    if (paramString == null) {
      try
      {
        throw new Exception();
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        locall.setSuccess(Boolean.valueOf(false));
        locall.setMessage("网络数据请求失败!");
        u.e("parseShareInformation", paramString.getMessage());
        return locall;
      }
    }
    paramString = com.alibaba.fastjson.a.parseObject(paramString);
    if (((String)paramString.get("status")).equals("success"))
    {
      locall.setSuccess(Boolean.valueOf(true));
      return locall;
    }
    locall.setSuccess(Boolean.valueOf(false));
    locall.setMessage((String)paramString.get("error_message"));
    return locall;
  }
  
  public static l parseSetTurnSign(String paramString)
  {
    l locall = new l();
    if (paramString == null) {
      try
      {
        throw new Exception();
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        locall.setSuccess(Boolean.valueOf(false));
        locall.setMessage("服务器异常，正在努力抢修中，请稍后再试!");
        return locall;
      }
    }
    paramString = com.alibaba.fastjson.a.parseObject(paramString);
    if (((String)paramString.get("message")).equals("success"))
    {
      locall.setSuccess(Boolean.valueOf(true));
      return locall;
    }
    locall.setSuccess(Boolean.valueOf(false));
    locall.setMessage((String)paramString.get("message"));
    return locall;
  }
  
  public static l parseSettingState(String paramString)
  {
    l locall = new l();
    if (paramString == null) {
      try
      {
        throw new Exception();
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        locall.setSuccess(Boolean.valueOf(false));
        locall.setMessage("服务器异常，正在努力抢修中，请稍后再试!");
        return locall;
      }
    }
    paramString = com.alibaba.fastjson.a.parseObject(paramString);
    Object localObject1 = (String)paramString.get("status");
    ((Integer)paramString.get("error_code")).intValue();
    Object localObject2 = (String)paramString.get("error_message");
    if (((String)localObject1).equals("success"))
    {
      Object localObject3 = com.alibaba.fastjson.a.parseObject(paramString.get("data").toString());
      paramString = (SettingCommon)com.alibaba.fastjson.a.parseObject(((Map)localObject3).get("main_message").toString(), SettingCommon.class);
      localObject1 = (SettingCommon)com.alibaba.fastjson.a.parseObject(((Map)localObject3).get("rent_message").toString(), SettingCommon.class);
      localObject2 = (SettingCommon)com.alibaba.fastjson.a.parseObject(((Map)localObject3).get("neighbors_message").toString(), SettingCommon.class);
      SettingCommon localSettingCommon = (SettingCommon)com.alibaba.fastjson.a.parseObject(((Map)localObject3).get("repair_message").toString(), SettingCommon.class);
      localObject3 = (SettingCommon)com.alibaba.fastjson.a.parseObject(((Map)localObject3).get("comm_repair_message").toString(), SettingCommon.class);
      HashMap localHashMap = new HashMap();
      localHashMap.put("main_switch", paramString);
      localHashMap.put("rent_switch", localObject1);
      localHashMap.put("neighbors_switch", localObject2);
      localHashMap.put("repair_switch", localSettingCommon);
      localHashMap.put("comm_repair_switch", localObject3);
      locall.setObject(localHashMap);
      locall.setSuccess(Boolean.valueOf(true));
      return locall;
    }
    locall.setSuccess(Boolean.valueOf(false));
    locall.setMessage((String)localObject2);
    return locall;
  }
  
  public static l parseSettingTotal(String paramString)
  {
    l locall = new l();
    if (paramString == null) {
      try
      {
        throw new Exception();
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        locall.setSuccess(Boolean.valueOf(false));
        locall.setMessage("服务器异常，正在努力抢修中，请稍后再试!");
        return locall;
      }
    }
    if (((String)com.alibaba.fastjson.a.parseObject(paramString).get("status")).equals("success"))
    {
      locall.setSuccess(Boolean.valueOf(true));
      return locall;
    }
    locall.setSuccess(Boolean.valueOf(false));
    locall.setMessage("保存设置失败！");
    return locall;
  }
  
  public static l parseShareInformation(String paramString)
  {
    l locall = new l();
    if (paramString == null) {
      try
      {
        throw new Exception();
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        locall.setSuccess(Boolean.valueOf(false));
        locall.setMessage("网络数据请求失败!");
        u.e("parseShareInformation", paramString.getMessage());
        return locall;
      }
    }
    paramString = com.alibaba.fastjson.a.parseObject(paramString);
    if (((String)paramString.get("status")).equals("success"))
    {
      if (paramString.get("data") != null)
      {
        if (!paramString.get("data").toString().equals("[]")) {
          locall.setObject((ShareInfo)com.alibaba.fastjson.a.parseObject(paramString.get("data").toString(), ShareInfo.class));
        }
        for (;;)
        {
          locall.setSuccess(Boolean.valueOf(true));
          return locall;
          locall.setObject(null);
        }
      }
      locall.setSuccess(Boolean.valueOf(true));
      return locall;
    }
    locall.setSuccess(Boolean.valueOf(false));
    locall.setMessage((String)paramString.get("error_message"));
    return locall;
  }
  
  public static l parseSignInfo(String paramString)
  {
    l locall = new l();
    if (paramString == null) {
      try
      {
        throw new Exception();
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        locall.setSuccess(Boolean.valueOf(false));
        locall.setMessage("服务器异常，正在努力抢修中，请稍后再试!");
        return locall;
      }
    }
    paramString = com.alibaba.fastjson.a.parseObject(paramString);
    if (((String)paramString.get("status")).equals("success"))
    {
      paramString = (SignedInfo)com.alibaba.fastjson.a.parseObject(paramString.get("data").toString(), SignedInfo.class);
      locall.setSuccess(Boolean.valueOf(true));
      locall.setObject(paramString);
      return locall;
    }
    locall.setSuccess(Boolean.valueOf(false));
    locall.setMessage((String)paramString.get("error_message"));
    return locall;
  }
  
  public static l parseSignUpdate(String paramString)
  {
    l locall = new l();
    if (paramString == null) {
      try
      {
        throw new Exception();
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        locall.setSuccess(Boolean.valueOf(false));
        locall.setMessage("服务器异常，正在努力抢修中，请稍后再试!");
        return locall;
      }
    }
    paramString = com.alibaba.fastjson.a.parseObject(paramString);
    if (((String)paramString.get("status")).equals("success"))
    {
      locall.setSuccess(Boolean.valueOf(true));
      return locall;
    }
    locall.setSuccess(Boolean.valueOf(false));
    locall.setMessage((String)paramString.get("error_message"));
    return locall;
  }
  
  public static l parseSignature(String paramString)
  {
    l locall = new l();
    if (paramString == null) {
      try
      {
        throw new Exception();
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        locall.setSuccess(Boolean.valueOf(false));
        locall.setMessage("网络数据请求失败!");
        u.e("parseSignature", paramString.getMessage());
        return locall;
      }
    }
    paramString = com.alibaba.fastjson.a.parseObject(paramString);
    if (((String)paramString.get("status")).equals("success"))
    {
      locall.setSuccess(Boolean.valueOf(true));
      return locall;
    }
    locall.setSuccess(Boolean.valueOf(false));
    locall.setMessage((String)paramString.get("error_message"));
    return locall;
  }
  
  public static l parseStation(String paramString)
  {
    l locall = new l();
    if (paramString == null) {
      try
      {
        throw new Exception();
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        locall.setSuccess(Boolean.valueOf(false));
        locall.setMessage("服务器异常，正在努力抢修中，请稍后再试!");
        return locall;
      }
    }
    paramString = com.alibaba.fastjson.a.parseObject(paramString);
    if (((String)paramString.get("status")).equals("success"))
    {
      Object localObject = (com.alibaba.fastjson.b)paramString.get("data");
      if (localObject != null)
      {
        paramString = new ArrayList();
        ArrayList localArrayList = new ArrayList();
        localObject = ((com.alibaba.fastjson.b)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          Map localMap = (Map)((Iterator)localObject).next();
          paramString.add((String)localMap.get("subway_station_name"));
          localArrayList.add((Integer)localMap.get("is_hot"));
        }
        locall.setSuccess(Boolean.valueOf(true));
        locall.setObject(new com.ziroom.ziroomcustomer.findhouse.b(paramString, localArrayList));
        return locall;
      }
      locall.setSuccess(Boolean.valueOf(false));
      locall.setMessage("服务器异常，正在努力抢修中，请稍后再试!");
      return locall;
    }
    locall.setSuccess(Boolean.valueOf(false));
    locall.setMessage((String)paramString.get("error_message"));
    return locall;
  }
  
  public static l parseSubWayLine(String paramString)
  {
    l locall = new l();
    if (paramString == null) {
      try
      {
        throw new Exception();
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        locall.setSuccess(Boolean.valueOf(false));
        locall.setMessage("服务器异常，正在努力抢修中，请稍后再试!");
        return locall;
      }
    }
    paramString = com.alibaba.fastjson.a.parseObject(paramString);
    if (((String)paramString.get("status")).equals("success"))
    {
      Object localObject = (com.alibaba.fastjson.b)paramString.get("data");
      if (localObject != null)
      {
        paramString = new ArrayList();
        localObject = ((com.alibaba.fastjson.b)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          paramString.add((String)((Map)((Iterator)localObject).next()).get("subway_line_name"));
        }
        locall.setSuccess(Boolean.valueOf(true));
        locall.setObject(paramString);
        return locall;
      }
      locall.setSuccess(Boolean.valueOf(false));
      locall.setMessage("服务器异常，正在努力抢修中，请稍后再试!");
      return locall;
    }
    locall.setSuccess(Boolean.valueOf(false));
    locall.setMessage((String)paramString.get("message"));
    return locall;
  }
  
  public static l parseSundHandleConfirm(String paramString1, String paramString2)
  {
    l locall = new l();
    if (paramString1 == null) {
      try
      {
        throw new Exception();
      }
      catch (Exception paramString1)
      {
        paramString1.printStackTrace();
        locall.setSuccess(Boolean.valueOf(false));
        locall.setMessage("网络数据请求失败!");
        u.e("parseSundHandleConfirm", paramString1.getMessage());
        return locall;
      }
    }
    paramString1 = com.alibaba.fastjson.a.parseObject(paramString1);
    if (((String)paramString1.get("status")).equals("success"))
    {
      if (paramString2.equals("Y")) {
        locall.setObject((String)((Map)paramString1.get("data")).get("contract_state"));
      }
      locall.setSuccess(Boolean.valueOf(true));
      return locall;
    }
    locall.setSuccess(Boolean.valueOf(false));
    locall.setCode(paramString1.get("error_code").toString());
    locall.setMessage(paramString1.get("error_message").toString());
    return locall;
  }
  
  public static l parseSundHandleList(String paramString)
  {
    l locall = new l();
    if (paramString == null) {
      try
      {
        throw new Exception();
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        locall.setSuccess(Boolean.valueOf(false));
        u.e("parseSundHandleList", paramString.getMessage());
        return locall;
      }
    }
    paramString = com.alibaba.fastjson.a.parseObject(paramString);
    if (((String)paramString.get("status")).equals("success"))
    {
      paramString = (Map)paramString.get("data");
      HashMap localHashMap = new HashMap();
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      ArrayList localArrayList3 = new ArrayList();
      Object localObject1 = (com.alibaba.fastjson.b)paramString.get("goods_list");
      Object localObject2;
      Object localObject3;
      if (localObject1 != null)
      {
        localObject1 = ((com.alibaba.fastjson.b)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (Map)((Iterator)localObject1).next();
          localObject3 = new GoodList();
          ((GoodList)localObject3).setName((String)((Map)localObject2).get("name"));
          ((GoodList)localObject3).setType((String)((Map)localObject2).get("type"));
          ((GoodList)localObject3).setBrand((String)((Map)localObject2).get("brand"));
          ((GoodList)localObject3).setBelong((String)((Map)localObject2).get("belong"));
          ((GoodList)localObject3).setSums((String)((Map)localObject2).get("sums"));
          ((GoodList)localObject3).setUse_status((String)((Map)localObject2).get("use_status"));
          ((GoodList)localObject3).setGoodsprice((String)((Map)localObject2).get("goodsprice"));
          localArrayList2.add(localObject3);
        }
      }
      localObject1 = (com.alibaba.fastjson.b)paramString.get("fees");
      if (localObject1 != null)
      {
        localObject1 = ((com.alibaba.fastjson.b)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (Map)((Iterator)localObject1).next();
          localObject3 = new Fees();
          ((Fees)localObject3).setType((String)((Map)localObject2).get("type"));
          ((Fees)localObject3).setPrice((String)((Map)localObject2).get("price"));
          ((Fees)localObject3).setBalance((String)((Map)localObject2).get("balance"));
          ((Fees)localObject3).setIsAdvancePay((String)((Map)localObject2).get("isAdvancePay"));
          ((Fees)localObject3).setDisplayNums((String)((Map)localObject2).get("displayNums"));
          ((Fees)localObject3).setPrice_unit((String)((Map)localObject2).get("price_unit"));
          localArrayList1.add(localObject3);
        }
      }
      localObject1 = (Map)paramString.get("key_cards");
      if (localObject1 != null)
      {
        if (!TextUtils.isEmpty((CharSequence)((Map)localObject1).get("doorKeyNums")))
        {
          localObject2 = new KeyCards();
          ((KeyCards)localObject2).setName("房门钥匙");
          ((KeyCards)localObject2).setNums((String)((Map)localObject1).get("doorKeyNums"));
          ((KeyCards)localObject2).setOver((String)((Map)localObject1).get("doorKeyisOver"));
          ((KeyCards)localObject2).setState((String)((Map)localObject1).get("doorKeyuseState"));
          localArrayList3.add(localObject2);
        }
        if (!TextUtils.isEmpty((CharSequence)((Map)localObject1).get("unitKeyNums")))
        {
          localObject2 = new KeyCards();
          ((KeyCards)localObject2).setName("单元门钥匙");
          ((KeyCards)localObject2).setNums((String)((Map)localObject1).get("unitKeyNums"));
          ((KeyCards)localObject2).setOver((String)((Map)localObject1).get("unitKeyisOver"));
          ((KeyCards)localObject2).setState((String)((Map)localObject1).get("unitKeyuseState"));
          localArrayList3.add(localObject2);
        }
        if (!TextUtils.isEmpty((CharSequence)((Map)localObject1).get("letterBoxKeyNums")))
        {
          localObject2 = new KeyCards();
          ((KeyCards)localObject2).setName("信箱钥匙");
          ((KeyCards)localObject2).setNums((String)((Map)localObject1).get("letterBoxKeyNums"));
          ((KeyCards)localObject2).setOver((String)((Map)localObject1).get("letterBoxKeyisOver"));
          ((KeyCards)localObject2).setState((String)((Map)localObject1).get("letterBoxKeyuseState"));
          localArrayList3.add(localObject2);
        }
        if (!TextUtils.isEmpty((CharSequence)((Map)localObject1).get("guardCardNums")))
        {
          localObject2 = new KeyCards();
          ((KeyCards)localObject2).setName("门禁卡");
          ((KeyCards)localObject2).setNums((String)((Map)localObject1).get("guardCardNums"));
          ((KeyCards)localObject2).setOver((String)((Map)localObject1).get("guardCardisOver"));
          ((KeyCards)localObject2).setState((String)((Map)localObject1).get("guardCarduseState"));
          localArrayList3.add(localObject2);
        }
        if (!TextUtils.isEmpty((CharSequence)((Map)localObject1).get("electricCardNums")))
        {
          localObject2 = new KeyCards();
          ((KeyCards)localObject2).setName("电卡");
          ((KeyCards)localObject2).setNums((String)((Map)localObject1).get("electricCardNums"));
          ((KeyCards)localObject2).setOver((String)((Map)localObject1).get("electricCardisOver"));
          ((KeyCards)localObject2).setState((String)((Map)localObject1).get("doorKeyuseState"));
          localArrayList3.add(localObject2);
        }
        if (!TextUtils.isEmpty((CharSequence)((Map)localObject1).get("warterCardNums")))
        {
          localObject2 = new KeyCards();
          ((KeyCards)localObject2).setName("水卡");
          ((KeyCards)localObject2).setNums((String)((Map)localObject1).get("warterCardNums"));
          ((KeyCards)localObject2).setOver((String)((Map)localObject1).get("warterCardisOver"));
          ((KeyCards)localObject2).setState((String)((Map)localObject1).get("doorKeyuseState"));
          localArrayList3.add(localObject2);
        }
        if (!TextUtils.isEmpty((CharSequence)((Map)localObject1).get("gasCardNums")))
        {
          localObject2 = new KeyCards();
          ((KeyCards)localObject2).setName("煤气卡");
          ((KeyCards)localObject2).setNums((String)((Map)localObject1).get("gasCardNums"));
          ((KeyCards)localObject2).setOver((String)((Map)localObject1).get("gasCardisOver"));
          ((KeyCards)localObject2).setState((String)((Map)localObject1).get("doorKeyuseState"));
          localArrayList3.add(localObject2);
        }
      }
      localHashMap.put("feeslist", localArrayList1);
      localHashMap.put("goodlist", localArrayList2);
      localHashMap.put("keycardslist", localArrayList3);
      localHashMap.put("house_type", paramString.get("houseType"));
      localHashMap.put("goodsDocument", paramString.get("goodsDocument"));
      localHashMap.put("keyDocument", paramString.get("keyDocument"));
      localHashMap.put("feesDocument", paramString.get("feesDocument"));
      localHashMap.put("contractStrategy", paramString.get("contractStrategy"));
      locall.setObject(localHashMap);
      locall.setSuccess(Boolean.valueOf(true));
      return locall;
    }
    locall.setSuccess(Boolean.valueOf(false));
    locall.setMessage("管家正在录入，请稍候...");
    return locall;
  }
  
  public static l parseTenancyInfo(String paramString)
  {
    l locall = new l();
    if (paramString == null) {
      try
      {
        throw new Exception();
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        locall.setSuccess(Boolean.valueOf(false));
        locall.setMessage("服务器异常，正在努力抢修中，请稍后再试!");
        return locall;
      }
    }
    paramString = com.alibaba.fastjson.a.parseObject(paramString);
    if (((String)paramString.get("status")).equals("success"))
    {
      paramString = com.alibaba.fastjson.a.parseArray(paramString.get("data").toString(), TenancyInfo.class);
      locall.setSuccess(Boolean.valueOf(true));
      locall.setObject(paramString);
      return locall;
    }
    locall.setSuccess(Boolean.valueOf(false));
    locall.setMessage((String)paramString.get("error_message"));
    return locall;
  }
  
  public static l parseTerms(String paramString)
  {
    l locall = new l();
    if (paramString == null) {
      try
      {
        throw new Exception();
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        locall.setSuccess(Boolean.valueOf(false));
        locall.setMessage("服务器异常，正在努力抢修中，请稍后再试!");
        return locall;
      }
    }
    paramString = com.alibaba.fastjson.a.parseObject(paramString);
    if (((String)paramString.get("status")).equals("success"))
    {
      paramString = paramString.get("data").toString();
      locall.setSuccess(Boolean.valueOf(true));
      locall.setObject(paramString);
      return locall;
    }
    locall.setSuccess(Boolean.valueOf(false));
    locall.setMessage((String)paramString.get("error_message"));
    return locall;
  }
  
  public static l parseText(String paramString)
  {
    l locall = new l();
    if (paramString == null) {
      try
      {
        throw new Exception();
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        locall.setSuccess(Boolean.valueOf(false));
        locall.setMessage("服务器异常，正在努力抢修中，请稍后再试!");
        return locall;
      }
    }
    paramString = com.alibaba.fastjson.a.parseObject(paramString);
    if (((String)paramString.get("status")).equals("success"))
    {
      paramString = com.alibaba.fastjson.a.parseObject(paramString.get("data").toString());
      locall.setSuccess(Boolean.valueOf(true));
      locall.setObject(paramString);
      return locall;
    }
    locall.setSuccess(Boolean.valueOf(false));
    locall.setMessage((String)paramString.get("error_message"));
    return locall;
  }
  
  public static l parseThreeUserInfo(String paramString)
  {
    l locall = new l();
    if (paramString == null) {
      try
      {
        throw new Exception();
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        locall.setSuccess(Boolean.valueOf(false));
        locall.setMessage("网络数据请求失败!");
        return locall;
      }
    }
    paramString = com.alibaba.fastjson.a.parseObject(paramString);
    if (((String)paramString.get("status")).equals("success"))
    {
      locall.setSuccess(Boolean.valueOf(true));
      return locall;
    }
    locall.setSuccess(Boolean.valueOf(false));
    locall.setMessage((String)paramString.get("errormsg"));
    return locall;
  }
  
  public static l parseToSee(String paramString)
  {
    l locall = new l();
    if (paramString == null) {
      try
      {
        throw new Exception();
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        locall.setSuccess(Boolean.valueOf(false));
        locall.setMessage("服务器异常，正在努力抢修中，请稍后再试!");
        return locall;
      }
    }
    paramString = com.alibaba.fastjson.a.parseObject(paramString);
    if (((String)paramString.get("status")).equals("success"))
    {
      locall.setSuccess(Boolean.valueOf(true));
      return locall;
    }
    locall.setSuccess(Boolean.valueOf(false));
    locall.setMessage((String)paramString.get("error_message"));
    locall.setCode((String)paramString.get("error_code"));
    return locall;
  }
  
  public static l parseToSeeConfirm(String paramString)
  {
    l locall = new l();
    if (paramString == null) {
      try
      {
        throw new Exception();
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        locall.setSuccess(Boolean.valueOf(false));
        locall.setMessage("服务器异常，正在努力抢修中，请稍后再试!");
        return locall;
      }
    }
    paramString = com.alibaba.fastjson.a.parseObject(paramString);
    if (((String)paramString.get("status")).equals("success"))
    {
      locall.setSuccess(Boolean.valueOf(true));
      return locall;
    }
    locall.setSuccess(Boolean.valueOf(false));
    locall.setMessage((String)paramString.get("error_message"));
    return locall;
  }
  
  public static l parseToSeeList(String paramString)
  {
    l locall = new l();
    if (paramString == null) {
      try
      {
        throw new Exception();
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        locall.setSuccess(Boolean.valueOf(false));
        locall.setMessage("服务器异常，正在努力抢修中，请稍后再试!");
        return locall;
      }
    }
    paramString = com.alibaba.fastjson.a.parseObject(paramString);
    if (((String)paramString.get("status")).equals("success"))
    {
      locall.setObject(com.alibaba.fastjson.a.parseArray(paramString.get("data").toString(), MyToSee.class));
      locall.setSuccess(Boolean.valueOf(true));
      return locall;
    }
    locall.setSuccess(Boolean.valueOf(false));
    locall.setMessage((String)paramString.get("error_message"));
    return locall;
  }
  
  public static l parseToSeeStatu(String paramString)
  {
    l locall = new l();
    if (paramString == null) {
      try
      {
        throw new Exception();
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        locall.setSuccess(Boolean.valueOf(false));
        locall.setMessage("服务器异常，正在努力抢修中，请稍后再试!");
        return locall;
      }
    }
    paramString = com.alibaba.fastjson.a.parseObject(paramString);
    if (((String)paramString.get("status")).equals("success"))
    {
      locall.setObject(com.alibaba.fastjson.a.parseArray(paramString.get("data").toString(), ToSeeStatu.class));
      locall.setSuccess(Boolean.valueOf(true));
      return locall;
    }
    locall.setSuccess(Boolean.valueOf(false));
    locall.setMessage((String)paramString.get("error_message"));
    return locall;
  }
  
  public static l parseUpdateTenancy(String paramString)
  {
    l locall = new l();
    if (paramString == null) {
      try
      {
        throw new Exception();
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        locall.setSuccess(Boolean.valueOf(false));
        locall.setMessage("服务器异常，正在努力抢修中，请稍后再试!");
        return locall;
      }
    }
    paramString = com.alibaba.fastjson.a.parseObject(paramString);
    if (((String)paramString.get("status")).equals("success"))
    {
      paramString = (TenancyUpdate)com.alibaba.fastjson.a.parseObject(paramString.get("data").toString(), TenancyUpdate.class);
      locall.setSuccess(Boolean.valueOf(true));
      locall.setObject(paramString);
      return locall;
    }
    locall.setSuccess(Boolean.valueOf(false));
    locall.setMessage((String)paramString.get("error_message"));
    return locall;
  }
  
  public static l parseUploadHeadImg(String paramString)
  {
    l locall = new l();
    if (paramString == null) {
      try
      {
        throw new Exception();
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        locall.setSuccess(Boolean.valueOf(false));
        locall.setMessage("服务器异常，正在努力抢修中，请稍后再试!");
        return locall;
      }
    }
    paramString = com.alibaba.fastjson.a.parseObject(paramString);
    if (((String)paramString.get("status")).equals("success"))
    {
      paramString = (String)paramString.get("img_url");
      locall.setSuccess(Boolean.valueOf(true));
      locall.setObject(paramString);
      return locall;
    }
    locall.setSuccess(Boolean.valueOf(false));
    locall.setMessage("上传头像失败");
    return locall;
  }
  
  public static l parseUploadImage(String paramString)
  {
    l locall = new l();
    if (paramString == null) {
      try
      {
        throw new Exception();
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        locall.setSuccess(Boolean.valueOf(false));
        locall.setMessage("服务器异常，正在努力抢修中，请稍后再试!");
        return locall;
      }
    }
    paramString = com.alibaba.fastjson.a.parseObject(paramString);
    if (((String)paramString.get("status")).equals("success"))
    {
      paramString = (String)paramString.get("data");
      locall.setSuccess(Boolean.valueOf(true));
      locall.setObject(paramString);
      return locall;
    }
    locall.setSuccess(Boolean.valueOf(false));
    locall.setMessage((String)paramString.get("message"));
    return locall;
  }
  
  public static l parseVerification(String paramString)
  {
    l locall = new l();
    if (paramString == null) {
      try
      {
        throw new Exception();
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        locall.setSuccess(Boolean.valueOf(false));
        locall.setMessage("服务器异常，正在努力抢修中，请稍后再试!");
        return locall;
      }
    }
    Object localObject = com.alibaba.fastjson.a.parseObject(paramString);
    paramString = (String)((Map)localObject).get("status");
    localObject = (String)((Map)localObject).get("error_message");
    if (paramString.equals("success"))
    {
      locall.setSuccess(Boolean.valueOf(true));
      return locall;
    }
    locall.setSuccess(Boolean.valueOf(false));
    locall.setMessage("验证码输入错误");
    return locall;
  }
  
  public static l parselogout(String paramString)
  {
    l locall = new l();
    if (paramString == null) {
      try
      {
        throw new Exception();
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        locall.setSuccess(Boolean.valueOf(false));
        locall.setMessage("服务器异常，正在努力抢修中，请稍后再试!");
        return locall;
      }
    }
    Object localObject = com.alibaba.fastjson.a.parseObject(paramString);
    paramString = (String)((Map)localObject).get("status");
    localObject = (String)((Map)localObject).get("error_message");
    if (paramString.equals("success"))
    {
      locall.setSuccess(Boolean.valueOf(true));
      return locall;
    }
    locall.setSuccess(Boolean.valueOf(false));
    locall.setMessage((String)localObject);
    return locall;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/e/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */