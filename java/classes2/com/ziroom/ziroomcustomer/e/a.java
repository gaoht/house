package com.ziroom.ziroomcustomer.e;

import android.content.Context;
import android.text.TextUtils;
import com.alibaba.fastjson.b;
import com.ziroom.ziroomcustomer.model.RepairCapacity;
import com.ziroom.ziroomcustomer.model.RepairScore;
import com.ziroom.ziroomcustomer.newServiceList.model.af;
import com.ziroom.ziroomcustomer.newServiceList.model.ag;
import com.ziroom.ziroomcustomer.newServiceList.model.ai;
import com.ziroom.ziroomcustomer.newServiceList.model.aj;
import com.ziroom.ziroomcustomer.newServiceList.model.ak;
import com.ziroom.ziroomcustomer.newServiceList.model.al;
import com.ziroom.ziroomcustomer.newServiceList.model.am;
import com.ziroom.ziroomcustomer.newServiceList.model.ao;
import com.ziroom.ziroomcustomer.newServiceList.model.ar;
import com.ziroom.ziroomcustomer.newServiceList.model.au;
import com.ziroom.ziroomcustomer.newServiceList.model.bj;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class a
{
  public static <T> l parseDivServiceList(Context paramContext, String paramString1, Class<T> paramClass, String paramString2)
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
        if (!com.ziroom.ziroomcustomer.util.ah.checkNet(paramContext)) {
          break label170;
        }
      }
      paramString1.printStackTrace();
      locall.setSuccess(Boolean.valueOf(false));
      locall.setMessage("请求数据失败！");
      return locall;
    }
    else
    {
      paramString1 = com.alibaba.fastjson.a.parseObject(paramString1);
      String str = (String)paramString1.get("status");
      if (("0".equals(str)) || ("success".equals(str)))
      {
        locall.setObject(com.alibaba.fastjson.a.parseArray(paramString1.get(paramString2).toString(), paramClass));
        locall.setSuccess(Boolean.valueOf(true));
        return locall;
      }
      locall.setSuccess(Boolean.valueOf(false));
      if (paramString1.get("message") != null)
      {
        locall.setMessage((String)paramString1.get("message"));
        return locall;
      }
      locall.setMessage("请求数据失败！");
      return locall;
    }
    label170:
    paramString1.printStackTrace();
    locall.setSuccess(Boolean.valueOf(false));
    locall.setMessage("网络请求失败，请检查网络连接");
    return locall;
  }
  
  public static <T> l parseDiverService(Context paramContext, String paramString)
  {
    l locall = new l();
    if (paramString == null)
    {
      try
      {
        throw new Exception();
      }
      catch (Exception paramString)
      {
        if (!com.ziroom.ziroomcustomer.util.ah.checkNet(paramContext)) {
          break label137;
        }
      }
      paramString.printStackTrace();
      locall.setSuccess(Boolean.valueOf(false));
      locall.setMessage("请求数据失败！");
      return locall;
    }
    else
    {
      paramString = com.alibaba.fastjson.a.parseObject(paramString);
      String str = (String)paramString.get("status");
      if (("0".equals(str)) || ("success".equals(str)))
      {
        locall.setSuccess(Boolean.valueOf(true));
        return locall;
      }
      locall.setSuccess(Boolean.valueOf(false));
      if (paramString.get("message") != null)
      {
        locall.setMessage((String)paramString.get("message"));
        return locall;
      }
      locall.setMessage("请求数据失败！");
      return locall;
    }
    label137:
    paramString.printStackTrace();
    locall.setSuccess(Boolean.valueOf(false));
    locall.setMessage("网络请求失败，请检查网络连接");
    return locall;
  }
  
  public static l parseGetRepairCancle(Context paramContext, String paramString)
  {
    l locall = new l();
    if (paramString == null)
    {
      try
      {
        throw new Exception();
      }
      catch (Exception paramString)
      {
        if (!com.ziroom.ziroomcustomer.util.ah.checkNet(paramContext)) {
          break label132;
        }
      }
      paramString.printStackTrace();
      locall.setSuccess(Boolean.valueOf(false));
      locall.setMessage("请求数据失败！");
      return locall;
    }
    else
    {
      paramString = com.alibaba.fastjson.a.parseObject(paramString);
      if (((String)paramString.get("status")).equals("0"))
      {
        locall.setSuccess(Boolean.valueOf(true));
        return locall;
      }
      locall.setSuccess(Boolean.valueOf(false));
      if (!TextUtils.isEmpty((String)paramString.get("message")))
      {
        locall.setMessage((String)paramString.get("message"));
        return locall;
      }
      locall.setMessage("网络请求失败，请检查网络连接");
      return locall;
    }
    label132:
    paramString.printStackTrace();
    locall.setSuccess(Boolean.valueOf(false));
    locall.setMessage("网络请求失败，请检查网络连接");
    return locall;
  }
  
  public static <T> l parseGetRepairCancleTag(Context paramContext, String paramString)
  {
    l locall = new l();
    if (paramString == null)
    {
      try
      {
        throw new Exception();
      }
      catch (Exception paramString)
      {
        if (!com.ziroom.ziroomcustomer.util.ah.checkNet(paramContext)) {
          break label271;
        }
      }
      paramString.printStackTrace();
      locall.setSuccess(Boolean.valueOf(false));
      locall.setMessage("请求数据失败！");
      return locall;
    }
    else
    {
      paramString = com.alibaba.fastjson.a.parseObject(paramString);
      Object localObject = (String)paramString.get("status");
      if (((String)localObject).equals("0"))
      {
        localObject = new ak();
        paramString = (aj)com.alibaba.fastjson.a.parseObject(paramString.get("data").toString(), aj.class);
        ((ak)localObject).setData(paramString);
        locall.setSuccess(Boolean.valueOf(true));
        locall.setObject(paramString.getTags());
        return locall;
      }
      if (((String)localObject).equals("10"))
      {
        localObject = new bj();
        au localau = (au)com.alibaba.fastjson.a.parseObject(paramString.get("data").toString(), au.class);
        ((bj)localObject).setData(localau);
        locall.setSuccess(Boolean.valueOf(false));
        locall.setObject(localau.getLinkPhone());
        if (paramString.get("message") != null)
        {
          locall.setMessage((String)paramString.get("message"));
          return locall;
        }
        locall.setMessage("请求数据失败！");
        return locall;
      }
      locall.setSuccess(Boolean.valueOf(false));
      locall.setObject(null);
      if (paramString.get("message") != null)
      {
        locall.setMessage((String)paramString.get("message"));
        return locall;
      }
      locall.setMessage("请求数据失败！");
      return locall;
    }
    label271:
    paramString.printStackTrace();
    locall.setSuccess(Boolean.valueOf(false));
    locall.setMessage("网络请求失败，请检查网络连接");
    return locall;
  }
  
  public static l parseGetRepairCapacity(Context paramContext, String paramString)
  {
    l locall = new l();
    if (paramString == null)
    {
      try
      {
        throw new Exception();
      }
      catch (Exception paramString)
      {
        if (!com.ziroom.ziroomcustomer.util.ah.checkNet(paramContext)) {
          break label266;
        }
      }
      paramString.printStackTrace();
      locall.setSuccess(Boolean.valueOf(false));
      locall.setMessage("请求数据失败！");
      return locall;
    }
    else
    {
      Object localObject = com.alibaba.fastjson.a.parseObject(paramString);
      if (((String)((Map)localObject).get("status")).equals("success"))
      {
        paramString = new HashMap();
        List localList = com.alibaba.fastjson.a.parseArray(((Map)localObject).get("dateList").toString(), RepairCapacity.class);
        HashMap localHashMap = new HashMap();
        localObject = (b)((Map)localObject).get("ruleList");
        if (localObject != null)
        {
          localObject = ((b)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            Map localMap = (Map)((Iterator)localObject).next();
            localHashMap.put(Integer.valueOf(((Integer)localMap.get("p")).intValue()), Integer.valueOf(((Integer)localMap.get("c")).intValue()));
          }
        }
        paramString.put("dateList", localList);
        paramString.put("ruleList", localHashMap);
        locall.setSuccess(Boolean.valueOf(true));
        locall.setObject(paramString);
        return locall;
      }
      locall.setSuccess(Boolean.valueOf(false));
      locall.setMessage((String)((Map)localObject).get(""));
      return locall;
    }
    label266:
    paramString.printStackTrace();
    locall.setSuccess(Boolean.valueOf(false));
    locall.setMessage("网络请求失败，请检查网络连接");
    return locall;
  }
  
  public static l parseGetRepairEvalDetail(Context paramContext, String paramString)
  {
    l locall = new l();
    if (paramString == null)
    {
      try
      {
        throw new Exception();
      }
      catch (Exception paramString)
      {
        if (!com.ziroom.ziroomcustomer.util.ah.checkNet(paramContext)) {
          break label164;
        }
      }
      paramString.printStackTrace();
      locall.setSuccess(Boolean.valueOf(false));
      locall.setMessage("请求数据失败！");
      return locall;
    }
    else
    {
      Object localObject = com.alibaba.fastjson.a.parseObject(paramString);
      if (((String)((Map)localObject).get("status")).equals("0"))
      {
        paramString = new ag();
        localObject = (af)com.alibaba.fastjson.a.parseObject(((Map)localObject).get("data").toString(), af.class);
        paramString.setData((af)localObject);
        locall.setSuccess(Boolean.valueOf(true));
        locall.setObject(localObject);
        return locall;
      }
      locall.setSuccess(Boolean.valueOf(false));
      if (((Map)localObject).get("message") != null)
      {
        locall.setMessage((String)((Map)localObject).get("message"));
        return locall;
      }
      locall.setMessage("请求数据失败！");
      return locall;
    }
    label164:
    paramString.printStackTrace();
    locall.setSuccess(Boolean.valueOf(false));
    locall.setMessage("网络请求失败，请检查网络连接");
    return locall;
  }
  
  public static l parseGetRepairList(Context paramContext, String paramString)
  {
    l locall = new l();
    if (paramString == null)
    {
      try
      {
        throw new Exception();
      }
      catch (Exception paramString)
      {
        if (!com.ziroom.ziroomcustomer.util.ah.checkNet(paramContext)) {
          break label170;
        }
      }
      paramString.printStackTrace();
      locall.setSuccess(Boolean.valueOf(false));
      locall.setMessage("请求数据失败！");
      return locall;
    }
    else
    {
      paramString = com.alibaba.fastjson.a.parseObject(paramString);
      if (((String)paramString.get("status")).equals("0"))
      {
        if (paramString.get("data") != null)
        {
          ar localar = new ar();
          localar.setData(com.alibaba.fastjson.a.parseArray(paramString.get("data").toString(), ao.class));
          locall.setObject(localar);
        }
        locall.setSuccess(Boolean.valueOf(true));
        return locall;
      }
      locall.setSuccess(Boolean.valueOf(false));
      if (paramString.get("message") != null)
      {
        locall.setMessage((String)paramString.get("message"));
        return locall;
      }
      locall.setMessage("请求数据失败！");
      return locall;
    }
    label170:
    paramString.printStackTrace();
    locall.setSuccess(Boolean.valueOf(false));
    locall.setMessage("网络请求失败，请检查网络连接");
    return locall;
  }
  
  public static l parseGetRepairListDetail(Context paramContext, String paramString)
  {
    l locall = new l();
    if (paramString == null)
    {
      try
      {
        throw new Exception();
      }
      catch (Exception paramString)
      {
        if (!com.ziroom.ziroomcustomer.util.ah.checkNet(paramContext)) {
          break label159;
        }
      }
      paramString.printStackTrace();
      locall.setSuccess(Boolean.valueOf(false));
      locall.setMessage("请求数据失败！");
      return locall;
    }
    else
    {
      paramString = com.alibaba.fastjson.a.parseObject(paramString);
      if (((String)paramString.get("status")).equals("success"))
      {
        am localam = new am();
        localam.setData(com.alibaba.fastjson.a.parseArray(paramString.get("list").toString(), al.class));
        locall.setSuccess(Boolean.valueOf(true));
        locall.setObject(localam);
        return locall;
      }
      locall.setSuccess(Boolean.valueOf(false));
      if (paramString.get("message") != null)
      {
        locall.setMessage((String)paramString.get("message"));
        return locall;
      }
      locall.setMessage("请求数据失败！");
      return locall;
    }
    label159:
    paramString.printStackTrace();
    locall.setSuccess(Boolean.valueOf(false));
    locall.setMessage("网络请求失败，请检查网络连接");
    return locall;
  }
  
  public static l parseGetRepairListExternalDetail(Context paramContext, String paramString)
  {
    l locall = new l();
    if (paramString == null)
    {
      try
      {
        throw new Exception();
      }
      catch (Exception paramString)
      {
        if (!com.ziroom.ziroomcustomer.util.ah.checkNet(paramContext)) {
          break label164;
        }
      }
      paramString.printStackTrace();
      locall.setSuccess(Boolean.valueOf(false));
      locall.setMessage("请求数据失败！");
      return locall;
    }
    else
    {
      Object localObject = com.alibaba.fastjson.a.parseObject(paramString);
      if (((String)((Map)localObject).get("status")).equals("0"))
      {
        paramString = new ai();
        localObject = (com.ziroom.ziroomcustomer.newServiceList.model.ah)com.alibaba.fastjson.a.parseObject(((Map)localObject).get("data").toString(), com.ziroom.ziroomcustomer.newServiceList.model.ah.class);
        paramString.setData((com.ziroom.ziroomcustomer.newServiceList.model.ah)localObject);
        locall.setSuccess(Boolean.valueOf(true));
        locall.setObject(localObject);
        return locall;
      }
      locall.setSuccess(Boolean.valueOf(false));
      if (((Map)localObject).get("message") != null)
      {
        locall.setMessage((String)((Map)localObject).get("message"));
        return locall;
      }
      locall.setMessage("请求数据失败！");
      return locall;
    }
    label164:
    paramString.printStackTrace();
    locall.setSuccess(Boolean.valueOf(false));
    locall.setMessage("网络请求失败，请检查网络连接");
    return locall;
  }
  
  public static l parseGetRepairScoreItem(Context paramContext, String paramString)
  {
    l locall = new l();
    if (paramString == null)
    {
      try
      {
        throw new Exception();
      }
      catch (Exception paramString)
      {
        if (!com.ziroom.ziroomcustomer.util.ah.checkNet(paramContext)) {
          break label154;
        }
      }
      paramString.printStackTrace();
      locall.setSuccess(Boolean.valueOf(false));
      locall.setMessage("请求数据失败！");
      return locall;
    }
    else
    {
      paramString = com.alibaba.fastjson.a.parseObject(paramString);
      if (((String)paramString.get("status")).equals("success"))
      {
        paramString = com.alibaba.fastjson.a.parseArray(paramString.get("scoreList").toString(), RepairScore.class);
        locall.setSuccess(Boolean.valueOf(true));
        locall.setObject(paramString);
        return locall;
      }
      locall.setSuccess(Boolean.valueOf(false));
      if (!TextUtils.isEmpty((String)paramString.get("message")))
      {
        locall.setMessage((String)paramString.get("message"));
        return locall;
      }
      locall.setMessage("网络请求失败，请检查网络连接");
      return locall;
    }
    label154:
    paramString.printStackTrace();
    locall.setSuccess(Boolean.valueOf(false));
    locall.setMessage("网络请求失败，请检查网络连接");
    return locall;
  }
  
  public static l parseGetRepairTime(Context paramContext, String paramString)
  {
    l locall = new l();
    if (paramString == null)
    {
      try
      {
        throw new Exception();
      }
      catch (Exception paramString)
      {
        if (!com.ziroom.ziroomcustomer.util.ah.checkNet(paramContext)) {
          break label143;
        }
      }
      paramString.printStackTrace();
      locall.setSuccess(Boolean.valueOf(false));
      locall.setMessage("请求数据失败！");
      return locall;
    }
    else
    {
      paramString = com.alibaba.fastjson.a.parseObject(paramString);
      if (((String)paramString.get("status")).equals("success"))
      {
        paramString = (Map)paramString.get("data");
        locall.setSuccess(Boolean.valueOf(true));
        locall.setObject(paramString);
        return locall;
      }
      locall.setSuccess(Boolean.valueOf(false));
      if (paramString.get("message") != null)
      {
        locall.setMessage((String)paramString.get("message"));
        return locall;
      }
      locall.setMessage("请求数据失败！");
      return locall;
    }
    label143:
    paramString.printStackTrace();
    locall.setSuccess(Boolean.valueOf(false));
    locall.setMessage("网络请求失败，请检查网络连接");
    return locall;
  }
  
  public static l parseLockRepairCapacity(Context paramContext, String paramString)
  {
    l locall = new l();
    if (paramString == null)
    {
      try
      {
        throw new Exception();
      }
      catch (Exception paramString)
      {
        if (!com.ziroom.ziroomcustomer.util.ah.checkNet(paramContext)) {
          break label131;
        }
      }
      paramString.printStackTrace();
      locall.setSuccess(Boolean.valueOf(false));
      locall.setMessage("请求数据失败！");
      return locall;
    }
    else
    {
      paramString = com.alibaba.fastjson.a.parseObject(paramString);
      if (((String)paramString.get("status")).equals("success"))
      {
        locall.setSuccess(Boolean.valueOf(true));
        locall.setObject(paramString);
        return locall;
      }
      locall.setSuccess(Boolean.valueOf(false));
      if (paramString.get("message") != null)
      {
        locall.setMessage((String)paramString.get("message"));
        return locall;
      }
      locall.setMessage("请求数据失败！");
      return locall;
    }
    label131:
    paramString.printStackTrace();
    locall.setSuccess(Boolean.valueOf(false));
    locall.setMessage("网络请求失败，请检查网络连接");
    return locall;
  }
  
  public static <T> l parseMHObject(Context paramContext, String paramString, Class<T> paramClass)
  {
    l locall = new l();
    if (paramString == null)
    {
      try
      {
        throw new Exception();
      }
      catch (Exception paramString)
      {
        if (!com.ziroom.ziroomcustomer.util.ah.checkNet(paramContext)) {
          break label192;
        }
      }
      paramString.printStackTrace();
      locall.setSuccess(Boolean.valueOf(false));
      locall.setMessage("请求数据失败！");
      return locall;
    }
    else
    {
      paramString = com.alibaba.fastjson.a.parseObject(paramString);
      String str = (String)paramString.get("status");
      if ((str.equals("success")) || (str.equals("0")))
      {
        locall.setSuccess(Boolean.valueOf(true));
        if (paramString.get("data") != null)
        {
          locall.setObject(com.alibaba.fastjson.a.parseObject(paramString.get("data").toString(), paramClass));
          return locall;
        }
        locall.setSuccess(Boolean.valueOf(false));
        locall.setMessage("请求数据失败！");
        return locall;
      }
      locall.setSuccess(Boolean.valueOf(false));
      if (!TextUtils.isEmpty((String)paramString.get("message")))
      {
        locall.setMessage((String)paramString.get("message"));
        return locall;
      }
      locall.setMessage("网络请求失败，请检查网络连接");
      return locall;
    }
    label192:
    paramString.printStackTrace();
    locall.setSuccess(Boolean.valueOf(false));
    locall.setMessage("网络请求失败，请检查网络连接");
    return locall;
  }
  
  public static l parseMHStatus(Context paramContext, String paramString)
  {
    l locall = new l();
    if (paramString == null)
    {
      try
      {
        throw new Exception();
      }
      catch (Exception paramString)
      {
        if (!com.ziroom.ziroomcustomer.util.ah.checkNet(paramContext)) {
          break label143;
        }
      }
      paramString.printStackTrace();
      locall.setSuccess(Boolean.valueOf(false));
      locall.setMessage("请求数据失败！");
      return locall;
    }
    else
    {
      paramString = com.alibaba.fastjson.a.parseObject(paramString);
      String str = (String)paramString.get("status");
      if ((str.equals("success")) || (str.equals("0")))
      {
        locall.setSuccess(Boolean.valueOf(true));
        return locall;
      }
      locall.setSuccess(Boolean.valueOf(false));
      if (!TextUtils.isEmpty((String)paramString.get("message")))
      {
        locall.setMessage((String)paramString.get("message"));
        return locall;
      }
      locall.setMessage("网络请求失败，请检查网络连接");
      return locall;
    }
    label143:
    paramString.printStackTrace();
    locall.setSuccess(Boolean.valueOf(false));
    locall.setMessage("网络请求失败，请检查网络连接");
    return locall;
  }
  
  public static <T> l parseMHZeroList(Context paramContext, String paramString, Class<T> paramClass)
  {
    l locall = new l();
    if (paramString == null)
    {
      try
      {
        throw new Exception();
      }
      catch (Exception paramString)
      {
        if (!com.ziroom.ziroomcustomer.util.ah.checkNet(paramContext)) {
          break label176;
        }
      }
      paramString.printStackTrace();
      locall.setSuccess(Boolean.valueOf(false));
      locall.setMessage("请求数据失败！");
    }
    else
    {
      do
      {
        return locall;
        paramString = com.alibaba.fastjson.a.parseObject(paramString);
        String str = (String)paramString.get("status");
        if ((!str.equals("success")) && (!str.equals("0"))) {
          break;
        }
        locall.setSuccess(Boolean.valueOf(true));
      } while (paramString.get("data") == null);
      locall.setObject(com.alibaba.fastjson.a.parseArray(paramString.get("data").toString(), paramClass));
      return locall;
      locall.setSuccess(Boolean.valueOf(false));
      if (!TextUtils.isEmpty((String)paramString.get("message")))
      {
        locall.setMessage((String)paramString.get("message"));
        return locall;
      }
      locall.setMessage("网络请求失败，请检查网络连接");
      return locall;
    }
    label176:
    paramString.printStackTrace();
    locall.setSuccess(Boolean.valueOf(false));
    locall.setMessage("网络请求失败，请检查网络连接");
    return locall;
  }
  
  public static l parseNewCoupon(Context paramContext, String paramString)
  {
    l locall = new l();
    if (paramString == null)
    {
      try
      {
        throw new Exception();
      }
      catch (Exception paramString)
      {
        if (!com.ziroom.ziroomcustomer.util.ah.checkNet(paramContext)) {
          break label184;
        }
      }
      paramString.printStackTrace();
      locall.setSuccess(Boolean.valueOf(false));
      locall.setMessage("请求数据失败！");
    }
    else
    {
      String str;
      do
      {
        return locall;
        paramString = com.alibaba.fastjson.a.parseObject(paramString);
        str = (String)paramString.get("status");
        if (str.equals("0"))
        {
          locall.setState("0");
          return locall;
        }
        if (str.equals("1"))
        {
          locall.setState("1");
          if (paramString.get("message") != null)
          {
            locall.setMessage((String)paramString.get("message"));
            return locall;
          }
          locall.setMessage("请求数据失败！");
          return locall;
        }
      } while (!str.equals("1000002"));
      locall.setState("1000002");
      if (paramString.get("message") != null)
      {
        locall.setMessage((String)paramString.get("message"));
        return locall;
      }
      locall.setMessage("请求数据失败！");
      return locall;
    }
    label184:
    paramString.printStackTrace();
    locall.setSuccess(Boolean.valueOf(false));
    locall.setMessage("网络请求失败，请检查网络连接");
    return locall;
  }
  
  public static l parseRepairAcceptConfirm(Context paramContext, String paramString)
  {
    l locall = new l();
    if (paramString == null)
    {
      try
      {
        throw new Exception();
      }
      catch (Exception paramString)
      {
        if (!com.ziroom.ziroomcustomer.util.ah.checkNet(paramContext)) {
          break label126;
        }
      }
      paramString.printStackTrace();
      locall.setSuccess(Boolean.valueOf(false));
      locall.setMessage("请求数据失败！");
      return locall;
    }
    else
    {
      paramString = com.alibaba.fastjson.a.parseObject(paramString);
      if (((String)paramString.get("status")).equals("0"))
      {
        locall.setSuccess(Boolean.valueOf(true));
        return locall;
      }
      locall.setSuccess(Boolean.valueOf(false));
      if (paramString.get("message") != null)
      {
        locall.setMessage((String)paramString.get("message"));
        return locall;
      }
      locall.setMessage("请求数据失败！");
      return locall;
    }
    label126:
    paramString.printStackTrace();
    locall.setSuccess(Boolean.valueOf(false));
    locall.setMessage("网络请求失败，请检查网络连接");
    return locall;
  }
  
  public static l parseSaveRepairEvalDetail(Context paramContext, String paramString)
  {
    l locall = new l();
    if (paramString == null)
    {
      try
      {
        throw new Exception();
      }
      catch (Exception paramString)
      {
        if (!com.ziroom.ziroomcustomer.util.ah.checkNet(paramContext)) {
          break label126;
        }
      }
      paramString.printStackTrace();
      locall.setSuccess(Boolean.valueOf(false));
      locall.setMessage("请求数据失败！");
      return locall;
    }
    else
    {
      paramString = com.alibaba.fastjson.a.parseObject(paramString);
      if (((String)paramString.get("status")).equals("0"))
      {
        locall.setSuccess(Boolean.valueOf(true));
        return locall;
      }
      locall.setSuccess(Boolean.valueOf(false));
      if (paramString.get("message") != null)
      {
        locall.setMessage((String)paramString.get("message"));
        return locall;
      }
      locall.setMessage("请求数据失败！");
      return locall;
    }
    label126:
    paramString.printStackTrace();
    locall.setSuccess(Boolean.valueOf(false));
    locall.setMessage("网络请求失败，请检查网络连接");
    return locall;
  }
  
  public static <T> l parseService(Context paramContext, String paramString, Class<T> paramClass, int paramInt)
  {
    l locall = new l();
    if (paramString == null) {}
    try
    {
      if (com.ziroom.ziroomcustomer.util.ah.checkNet(paramContext))
      {
        locall.setSuccess(Boolean.valueOf(false));
        locall.setMessage("请求数据失败！");
        throw new Exception();
      }
    }
    catch (ClassNotFoundException paramContext)
    {
      for (;;)
      {
        paramContext.printStackTrace();
        locall.setSuccess(Boolean.valueOf(false));
        locall.setMessage("类型解析异常");
        return locall;
        locall.setSuccess(Boolean.valueOf(false));
        locall.setMessage("网络请求失败，请检查网络连接");
      }
    }
    catch (NullPointerException paramContext)
    {
      paramContext.printStackTrace();
      locall.setSuccess(Boolean.valueOf(false));
      locall.setMessage("空指针异常");
      return locall;
      paramString = com.alibaba.fastjson.a.parseObject(paramString);
      if (((Integer)paramString.get("status")).intValue() == 1) {
        if (paramInt == 0) {
          if (paramString.get("data") != null)
          {
            locall.setObject(com.alibaba.fastjson.a.parseObject(paramString.get("data").toString(), paramClass));
            locall.setSuccess(Boolean.valueOf(true));
            return locall;
          }
        }
      }
    }
    catch (Exception paramString)
    {
      while (com.ziroom.ziroomcustomer.util.ah.checkNet(paramContext))
      {
        paramString.printStackTrace();
        locall.setSuccess(Boolean.valueOf(false));
        locall.setMessage("解析数据失败！");
        return locall;
        locall.setObject("");
        continue;
        if (paramInt == 1)
        {
          if (paramString.get("data") != null) {
            locall.setObject(com.alibaba.fastjson.a.parseArray(paramString.get("data").toString(), paramClass));
          }
          locall.setSuccess(Boolean.valueOf(true));
          return locall;
        }
        if (paramInt == 2)
        {
          locall.setSuccess(Boolean.valueOf(true));
          return locall;
        }
        if (paramInt == 3)
        {
          locall.setSuccess(Boolean.valueOf(true));
          if (paramString.get("data") != null) {
            locall.setObject(paramString.get("data").toString());
          }
          if (paramString.get("message") != null)
          {
            locall.setMessage((String)paramString.get("message"));
            return locall;
            locall.setSuccess(Boolean.valueOf(false));
            if (paramString.get("message") != null)
            {
              locall.setMessage((String)paramString.get("message"));
              return locall;
            }
            locall.setMessage("请求数据失败！");
            return locall;
          }
        }
      }
      paramString.printStackTrace();
      locall.setSuccess(Boolean.valueOf(false));
      locall.setMessage("网络请求失败，请检查网络连接");
    }
    return locall;
  }
  
  public static <T> l parseServiceList(Context paramContext, String paramString, Class<T> paramClass)
  {
    l locall = new l();
    if (paramString == null)
    {
      try
      {
        throw new Exception();
      }
      catch (Exception paramString)
      {
        if (!com.ziroom.ziroomcustomer.util.ah.checkNet(paramContext)) {
          break label170;
        }
      }
      paramString.printStackTrace();
      locall.setSuccess(Boolean.valueOf(false));
      locall.setMessage("请求数据失败！");
      return locall;
    }
    else
    {
      paramString = com.alibaba.fastjson.a.parseObject(paramString);
      String str = (String)paramString.get("status");
      if (("0".equals(str)) || ("success".equals(str)))
      {
        if (paramString.get("data") != null) {
          locall.setObject(com.alibaba.fastjson.a.parseArray(paramString.get("data").toString(), paramClass));
        }
        locall.setSuccess(Boolean.valueOf(true));
        return locall;
      }
      locall.setSuccess(Boolean.valueOf(false));
      if (paramString.get("message") != null)
      {
        locall.setMessage((String)paramString.get("message"));
        return locall;
      }
      locall.setMessage("请求数据失败！");
      return locall;
    }
    label170:
    paramString.printStackTrace();
    locall.setSuccess(Boolean.valueOf(false));
    locall.setMessage("网络请求失败，请检查网络连接");
    return locall;
  }
  
  public static <T> l parseServiceObject(Context paramContext, String paramString, Class<T> paramClass)
  {
    l locall = new l();
    if (paramString == null)
    {
      try
      {
        throw new Exception();
      }
      catch (Exception paramString)
      {
        if (!com.ziroom.ziroomcustomer.util.ah.checkNet(paramContext)) {
          break label159;
        }
      }
      paramString.printStackTrace();
      locall.setSuccess(Boolean.valueOf(false));
      locall.setMessage("请求数据失败！");
      return locall;
    }
    else
    {
      paramString = com.alibaba.fastjson.a.parseObject(paramString);
      String str = (String)paramString.get("status");
      if (("0".equals(str)) || ("success".equals(str)))
      {
        locall.setObject(com.alibaba.fastjson.a.parseObject(paramString.get("data").toString(), paramClass));
        locall.setSuccess(Boolean.valueOf(true));
        return locall;
      }
      locall.setSuccess(Boolean.valueOf(false));
      if (paramString.get("message") != null)
      {
        locall.setMessage((String)paramString.get("message"));
        return locall;
      }
      locall.setMessage("请求数据失败！");
      return locall;
    }
    label159:
    paramString.printStackTrace();
    locall.setSuccess(Boolean.valueOf(false));
    locall.setMessage("网络请求失败，请检查网络连接");
    return locall;
  }
  
  public static l parseServiceString(Context paramContext, String paramString)
  {
    l locall = new l();
    if (paramString == null)
    {
      try
      {
        throw new Exception();
      }
      catch (Exception paramString)
      {
        if (!com.ziroom.ziroomcustomer.util.ah.checkNet(paramContext)) {
          break label152;
        }
      }
      paramString.printStackTrace();
      locall.setSuccess(Boolean.valueOf(false));
      locall.setMessage("请求数据失败！");
      return locall;
    }
    else
    {
      paramString = com.alibaba.fastjson.a.parseObject(paramString);
      String str = (String)paramString.get("status");
      if (("0".equals(str)) || ("success".equals(str)))
      {
        locall.setObject((String)paramString.get("data"));
        locall.setSuccess(Boolean.valueOf(true));
        return locall;
      }
      locall.setSuccess(Boolean.valueOf(false));
      if (paramString.get("message") != null)
      {
        locall.setMessage((String)paramString.get("message"));
        return locall;
      }
      locall.setMessage("请求数据失败！");
      return locall;
    }
    label152:
    paramString.printStackTrace();
    locall.setSuccess(Boolean.valueOf(false));
    locall.setMessage("网络请求失败，请检查网络连接");
    return locall;
  }
  
  public static <T> l parseTestService(Context paramContext, String paramString)
  {
    l locall = new l();
    if (paramString == null)
    {
      try
      {
        throw new Exception();
      }
      catch (Exception paramString)
      {
        if (!com.ziroom.ziroomcustomer.util.ah.checkNet(paramContext)) {
          break label125;
        }
      }
      paramString.printStackTrace();
      locall.setSuccess(Boolean.valueOf(false));
      locall.setMessage("请求数据失败！");
      return locall;
    }
    else
    {
      paramString = com.alibaba.fastjson.a.parseObject(paramString);
      if (((Integer)paramString.get("status")).intValue() == 1)
      {
        locall.setSuccess(Boolean.valueOf(true));
        return locall;
      }
      locall.setSuccess(Boolean.valueOf(false));
      if (paramString.get("message") != null)
      {
        locall.setMessage((String)paramString.get("message"));
        return locall;
      }
      locall.setMessage("请求数据失败！");
      return locall;
    }
    label125:
    paramString.printStackTrace();
    locall.setSuccess(Boolean.valueOf(false));
    locall.setMessage("网络请求失败，请检查网络连接");
    return locall;
  }
  
  public static <T> l parseTestServiceList(Context paramContext, String paramString, Class<T> paramClass)
  {
    l locall = new l();
    if (paramString == null)
    {
      try
      {
        throw new Exception();
      }
      catch (Exception paramString)
      {
        if (!com.ziroom.ziroomcustomer.util.ah.checkNet(paramContext)) {
          break label155;
        }
      }
      paramString.printStackTrace();
      locall.setSuccess(Boolean.valueOf(false));
      locall.setMessage("请求数据失败！");
      return locall;
    }
    else
    {
      paramString = com.alibaba.fastjson.a.parseObject(paramString);
      if (((Integer)paramString.get("status")).intValue() == 1)
      {
        if (paramString.get("data") != null) {
          locall.setObject(com.alibaba.fastjson.a.parseArray(paramString.get("data").toString(), paramClass));
        }
        locall.setSuccess(Boolean.valueOf(true));
        return locall;
      }
      locall.setSuccess(Boolean.valueOf(false));
      if (paramString.get("message") != null)
      {
        locall.setMessage((String)paramString.get("message"));
        return locall;
      }
      locall.setMessage("请求数据失败！");
      return locall;
    }
    label155:
    paramString.printStackTrace();
    locall.setSuccess(Boolean.valueOf(false));
    locall.setMessage("网络请求失败，请检查网络连接");
    return locall;
  }
  
  public static <T> l parseTestServiceObject(Context paramContext, String paramString, Class<T> paramClass)
  {
    l locall = new l();
    if (paramString == null)
    {
      try
      {
        throw new Exception();
      }
      catch (Exception paramString)
      {
        if (!com.ziroom.ziroomcustomer.util.ah.checkNet(paramContext)) {
          break label155;
        }
      }
      paramString.printStackTrace();
      locall.setSuccess(Boolean.valueOf(false));
      locall.setMessage("请求数据失败！");
      return locall;
    }
    else
    {
      paramString = com.alibaba.fastjson.a.parseObject(paramString);
      if (((Integer)paramString.get("status")).intValue() == 1)
      {
        if (paramString.get("data") != null) {
          locall.setObject(com.alibaba.fastjson.a.parseObject(paramString.get("data").toString(), paramClass));
        }
        locall.setSuccess(Boolean.valueOf(true));
        return locall;
      }
      locall.setSuccess(Boolean.valueOf(false));
      if (paramString.get("message") != null)
      {
        locall.setMessage((String)paramString.get("message"));
        return locall;
      }
      locall.setMessage("请求数据失败！");
      return locall;
    }
    label155:
    paramString.printStackTrace();
    locall.setSuccess(Boolean.valueOf(false));
    locall.setMessage("网络请求失败，请检查网络连接");
    return locall;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/e/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */