package com.ziroom.ziroomcustomer.newrepair.utils;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.freelxl.baselibrary.f.g;
import com.ziroom.commonlib.utils.SignKeyUtil;
import com.ziroom.commonlib.utils.h;
import com.ziroom.commonlibrary.login.a;
import com.ziroom.commonlibrary.widget.unifiedziroom.c.a;
import com.ziroom.commonlibrary.widget.unifiedziroom.c.b;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.newrepair.activity.InternalRepairSelectActivity;
import com.ziroom.ziroomcustomer.newrepair.b.v.a;
import com.ziroom.ziroomcustomer.util.af;
import com.ziroom.ziroomcustomer.util.ah;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class c
{
  public static void catchExp(Throwable paramThrowable)
  {
    if (ah.checkNet(ApplicationEx.c))
    {
      paramThrowable.printStackTrace();
      af.showToast(ApplicationEx.c, "请求数据失败！");
      return;
    }
    paramThrowable.printStackTrace();
    af.showToast(ApplicationEx.c, "网络请求失败，请检查网络连接");
  }
  
  public static void clice2Repair(Context paramContext)
  {
    if (!ApplicationEx.c.isLoginState())
    {
      a.startLoginActivity(paramContext);
      g.textToast(paramContext, "请先登录");
      return;
    }
    if ((ApplicationEx.c.getContracts() == null) || ((ApplicationEx.c.getContracts() != null) && (ApplicationEx.c.getContracts().size() == 0)))
    {
      com.ziroom.commonlibrary.widget.unifiedziroom.c.newBuilder(paramContext).setTitle("提示").setContent("您没有履行中的合同哦~").setOnConfirmClickListener(new c.b()
      {
        public void onClick(View paramAnonymousView, boolean paramAnonymousBoolean) {}
      }).build().show();
      return;
    }
    paramContext.startActivity(new Intent(paramContext, InternalRepairSelectActivity.class));
  }
  
  public static String getMuchDateStr(String paramString, int paramInt)
  {
    try
    {
      paramString = new SimpleDateFormat("yyyy-MM-dd").parse(paramString);
      Calendar localCalendar = Calendar.getInstance();
      localCalendar.setTime(paramString);
      localCalendar.add(5, paramInt);
      paramString = localCalendar.getTime();
      paramString = new SimpleDateFormat("yyyy-MM-dd").format(paramString).replaceAll("-", "/");
      return paramString;
    }
    catch (ParseException paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public static String getYdTime(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "";
    case 1: 
      return "9:00-13:00";
    case 2: 
      return "13:00-17:00";
    }
    return "17:00-24:00";
  }
  
  public static String signParams(Map<String, String> paramMap)
  {
    ArrayList localArrayList = new ArrayList(paramMap.keySet());
    Collections.sort(localArrayList);
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    if (i < localArrayList.size())
    {
      String str1 = (String)localArrayList.get(i);
      if ("sign".equals(str1)) {}
      for (;;)
      {
        i += 1;
        break;
        String str2 = (String)paramMap.get(str1);
        localStringBuilder.append(str1).append("=").append(str2);
        localStringBuilder.append("&");
      }
    }
    if (4 == h.getsEnvironment()) {}
    for (paramMap = SignKeyUtil.getSignKey();; paramMap = "d2a57dc1d883fd21fb9951699df71cc7")
    {
      localStringBuilder.append(paramMap);
      return signToMd5(localStringBuilder.toString()).toUpperCase();
    }
  }
  
  public static String signToMd5(String paramString)
  {
    try
    {
      Object localObject = MessageDigest.getInstance("MD5");
      ((MessageDigest)localObject).update(paramString.getBytes("UTF-8"));
      paramString = ((MessageDigest)localObject).digest();
      localObject = new StringBuffer("");
      int i = 0;
      while (i < paramString.length)
      {
        int k = paramString[i];
        int j = k;
        if (k < 0) {
          j = k + 256;
        }
        if (j < 16) {
          ((StringBuffer)localObject).append("0");
        }
        ((StringBuffer)localObject).append(Integer.toHexString(j));
        i += 1;
      }
      paramString = ((StringBuffer)localObject).toString();
      return paramString;
    }
    catch (NoSuchAlgorithmException paramString)
    {
      paramString.printStackTrace();
      return null;
    }
    catch (UnsupportedEncodingException paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public long dateDiff(String paramString1, String paramString2)
  {
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    long l1 = 0L;
    try
    {
      long l2 = localSimpleDateFormat.parse(paramString2).getTime() - localSimpleDateFormat.parse(paramString1).getTime();
      l1 = l2;
      l2 /= 86400000L;
      return l2;
    }
    catch (ParseException paramString1)
    {
      paramString1.printStackTrace();
    }
    return l1;
  }
  
  public List<String> getAppointDateList(String paramString1, String paramString2)
  {
    ArrayList localArrayList = new ArrayList();
    int i;
    if (dateDiff(paramString1, paramString2) == 0L)
    {
      localArrayList.add("今天");
      localArrayList.add("明天");
      localArrayList.add("后天");
      i = 3;
      while (i < 7)
      {
        localArrayList.add(getNextMuchDateStr(paramString2, i));
        i += 1;
      }
    }
    if (dateDiff(paramString1, paramString2) == 1L)
    {
      localArrayList.add("明天");
      localArrayList.add("后天");
      i = 2;
      while (i < 7)
      {
        localArrayList.add(getNextMuchDateStr(paramString2, i));
        i += 1;
      }
    }
    if (dateDiff(paramString1, paramString2) == 2L)
    {
      localArrayList.add("后天");
      i = 1;
      while (i < 7)
      {
        localArrayList.add(getNextMuchDateStr(paramString2, i));
        i += 1;
      }
    }
    return localArrayList;
  }
  
  public List<String> getGeneralDateList(int paramInt, String paramString)
  {
    int i = 2;
    ArrayList localArrayList = new ArrayList();
    if (paramInt == 1)
    {
      localArrayList.add("今天");
      localArrayList.add("明天");
      localArrayList.add("后天");
      paramInt = 3;
      while (paramInt < 7)
      {
        localArrayList.add(getNextMuchDateStr(paramString, paramInt));
        paramInt += 1;
      }
    }
    if (paramInt == 2)
    {
      localArrayList.add("明天");
      localArrayList.add("后天");
      paramInt = i;
      while (paramInt < 7)
      {
        localArrayList.add(getNextMuchDateStr(paramString, paramInt));
        paramInt += 1;
      }
    }
    return localArrayList;
  }
  
  public List<String> getNDateList(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < 7)
    {
      localArrayList.add(getNextMuchDateStr(paramString, i));
      i += 1;
    }
    return localArrayList;
  }
  
  public String getNextMuchDateStr(String paramString, int paramInt)
  {
    try
    {
      paramString = new SimpleDateFormat("yyyy-MM-dd").parse(paramString);
      Calendar localCalendar = Calendar.getInstance();
      localCalendar.setTime(paramString);
      localCalendar.add(5, paramInt);
      paramString = localCalendar.getTime();
      paramString = new SimpleDateFormat("MM月dd日").format(paramString);
      return paramString;
    }
    catch (ParseException paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public List<String> getServiceAppointDateList(String paramString, List<v.a> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    if (i < paramList.size())
    {
      Object localObject = (v.a)paramList.get(i);
      long l = dateDiff(paramString, ((v.a)localObject).getDate());
      if (l == 0L) {
        localArrayList.add("今天");
      }
      for (;;)
      {
        i += 1;
        break;
        if (l == 1L) {
          localArrayList.add("明天");
        } else if (l == 2L) {
          localArrayList.add("后天");
        } else {
          try
          {
            localObject = new SimpleDateFormat("yyyy-MM-dd").parse(((v.a)localObject).getDate());
            localArrayList.add(new SimpleDateFormat("MM月dd日").format((Date)localObject));
          }
          catch (ParseException paramString)
          {
            paramString.printStackTrace();
            return null;
          }
        }
      }
    }
    return localArrayList;
  }
  
  public List<String> getServiceDateList(List<v.a> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramList.size())
    {
      localArrayList.add(((v.a)paramList.get(i)).getDate().replaceAll("-", "/"));
      i += 1;
    }
    return localArrayList;
  }
  
  public List<String> getSevenDateList(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < 7)
    {
      localArrayList.add(getMuchDateStr(paramString, i));
      i += 1;
    }
    return localArrayList;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newrepair/utils/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */