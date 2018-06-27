package com.ziroom.ziroomcustomer.minsu.f;

import android.content.Context;
import android.text.TextUtils;
import com.alibaba.fastjson.a;
import com.ziroom.ziroomcustomer.minsu.bean.MsHistorySBean;
import com.ziroom.ziroomcustomer.minsu.bean.MsHouseHistoryBean;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.util.u;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class j
{
  public static List<MsHistorySBean> getHouseDetailHistoryLocal(Context paramContext)
  {
    if (paramContext == null) {}
    do
    {
      return null;
      paramContext = aa.getString(paramContext, "ziroomminsuhousedetailhistory", null);
    } while (ae.isNull(paramContext));
    paramContext = a.parseArray(paramContext, MsHistorySBean.class);
    Collections.sort(paramContext);
    return paramContext;
  }
  
  public static List<MsHouseHistoryBean> getHouseDetailHistoryNet(Context paramContext)
  {
    Object localObject = getHouseDetailHistoryLocal(paramContext);
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      paramContext = new ArrayList();
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        paramContext.add(((MsHistorySBean)((Iterator)localObject).next()).toMsHouseHistoryBean());
      }
      return paramContext;
    }
    return null;
  }
  
  public static void putHouseDetailHistory(Context paramContext, MsHistorySBean paramMsHistorySBean)
  {
    if ((paramContext == null) || (paramMsHistorySBean == null) || (TextUtils.isEmpty(paramMsHistorySBean.fid))) {
      return;
    }
    paramMsHistorySBean.updateTime = System.currentTimeMillis();
    Object localObject = getHouseDetailHistoryLocal(paramContext);
    if (localObject == null) {
      localObject = new ArrayList();
    }
    for (;;)
    {
      if (((List)localObject).contains(paramMsHistorySBean))
      {
        u.e("error", "bean 修改== " + paramMsHistorySBean.toString());
        ((MsHistorySBean)((List)localObject).get(((List)localObject).indexOf(paramMsHistorySBean))).updateTime = paramMsHistorySBean.updateTime;
      }
      for (;;)
      {
        aa.putString(paramContext, "ziroomminsuhousedetailhistory", a.toJSONString(localObject));
        return;
        if (((List)localObject).size() == 15) {
          ((List)localObject).remove(14);
        }
        u.e("error", "bean 新加== " + paramMsHistorySBean.toString());
        ((List)localObject).add(0, paramMsHistorySBean);
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/f/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */