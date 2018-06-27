package com.ziroom.ziroomcustomer.minsu.f;

import android.content.Context;
import com.alibaba.fastjson.a;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuSearchHistoryBean;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.util.m;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class z
{
  public static List<MinsuSearchHistoryBean> getCitySearchHistory(Context paramContext)
  {
    if (paramContext == null) {}
    do
    {
      return null;
      paramContext = aa.getString(paramContext, "ziroomminsusearchCity", null);
    } while (ae.isNull(paramContext));
    paramContext = a.parseArray(paramContext, MinsuSearchHistoryBean.class);
    Collections.sort(paramContext, new e());
    return paramContext;
  }
  
  public static List<MinsuSearchHistoryBean> getSearchHistory(Context paramContext)
  {
    if (paramContext == null) {}
    do
    {
      return null;
      paramContext = aa.getString(paramContext, "ziroomminsusearch", null);
    } while (ae.isNull(paramContext));
    paramContext = a.parseArray(paramContext, MinsuSearchHistoryBean.class);
    removeErrorData(paramContext);
    Collections.sort(paramContext, new e());
    return paramContext;
  }
  
  public static void putCitySearchHistory(Context paramContext, MinsuSearchHistoryBean paramMinsuSearchHistoryBean)
  {
    if ((paramContext == null) || (paramMinsuSearchHistoryBean == null)) {
      return;
    }
    paramMinsuSearchHistoryBean.updateTime = System.currentTimeMillis();
    Object localObject = getCitySearchHistory(paramContext);
    if (localObject == null) {
      localObject = new ArrayList();
    }
    for (;;)
    {
      Iterator localIterator = ((List)localObject).iterator();
      while (localIterator.hasNext()) {
        if (((MinsuSearchHistoryBean)localIterator.next()).cityName.equals(paramMinsuSearchHistoryBean.cityName)) {
          localIterator.remove();
        }
      }
      if (((List)localObject).size() == 15) {
        ((List)localObject).remove(14);
      }
      if (ae.notNull(paramMinsuSearchHistoryBean.cityName)) {
        ((List)localObject).add(paramMinsuSearchHistoryBean);
      }
      aa.putString(paramContext, "ziroomminsusearchCity", a.toJSONString(localObject));
      return;
    }
  }
  
  public static void putSearchHistory(Context paramContext, MinsuSearchHistoryBean paramMinsuSearchHistoryBean)
  {
    if ((paramContext == null) || (paramMinsuSearchHistoryBean == null)) {
      return;
    }
    paramMinsuSearchHistoryBean.updateTime = System.currentTimeMillis();
    Object localObject = getSearchHistory(paramContext);
    if (localObject == null) {
      localObject = new ArrayList();
    }
    for (;;)
    {
      Iterator localIterator = ((List)localObject).iterator();
      while (localIterator.hasNext())
      {
        MinsuSearchHistoryBean localMinsuSearchHistoryBean = (MinsuSearchHistoryBean)localIterator.next();
        if ((localMinsuSearchHistoryBean.cityCode != null) && (localMinsuSearchHistoryBean.cityCode.equals(paramMinsuSearchHistoryBean.cityCode)) && (localMinsuSearchHistoryBean.startDate != null) && (localMinsuSearchHistoryBean.startDate.equals(paramMinsuSearchHistoryBean.startDate)) && (localMinsuSearchHistoryBean.endDate != null) && (localMinsuSearchHistoryBean.endDate.equals(paramMinsuSearchHistoryBean.endDate))) {
          localIterator.remove();
        }
      }
      if (((List)localObject).size() == 5) {
        ((List)localObject).remove(4);
      }
      if ((ae.notNull(paramMinsuSearchHistoryBean.cityCode)) && (ae.notNull(paramMinsuSearchHistoryBean.cityName))) {
        ((List)localObject).add(paramMinsuSearchHistoryBean);
      }
      aa.putString(paramContext, "ziroomminsusearch", a.toJSONString(localObject));
      return;
    }
  }
  
  public static void removeErrorData(List<MinsuSearchHistoryBean> paramList)
  {
    Object localObject = new java.sql.Date(System.currentTimeMillis());
    java.util.Date localDate = m.strToDate(new SimpleDateFormat(m.b).format((java.util.Date)localObject), m.b);
    Iterator localIterator = paramList.iterator();
    if (localIterator.hasNext())
    {
      localObject = (MinsuSearchHistoryBean)localIterator.next();
      if (!ae.notNull(((MinsuSearchHistoryBean)localObject).startDate)) {
        break label139;
      }
    }
    label137:
    label139:
    for (paramList = m.strToDate(((MinsuSearchHistoryBean)localObject).startDate, m.b);; paramList = null)
    {
      if (ae.notNull(((MinsuSearchHistoryBean)localObject).endDate)) {}
      for (localObject = m.strToDate(((MinsuSearchHistoryBean)localObject).endDate, m.b);; localObject = null)
      {
        if (((paramList == null) || (!paramList.before(localDate))) && ((localObject == null) || (((java.util.Date)localObject).after(localDate)))) {
          break label137;
        }
        localIterator.remove();
        break;
        return;
      }
      break;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/f/z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */