package com.ziroom.ziroomcustomer.e;

import android.content.Context;
import com.ziroom.ziroomcustomer.b.b;
import com.ziroom.ziroomcustomer.b.i;
import com.ziroom.ziroomcustomer.b.j;
import com.ziroom.ziroomcustomer.b.k;
import com.ziroom.ziroomcustomer.b.n;
import com.ziroom.ziroomcustomer.model.LeaseInfo;
import com.ziroom.ziroomcustomer.model.LeasePayPlan;
import java.util.Iterator;
import java.util.List;

public class c
{
  public static l getBizcircleList(Context paramContext, String paramString1, String paramString2)
  {
    l locall = new l();
    com.ziroom.ziroomcustomer.b.l.deleteBefore(paramContext);
    paramContext = com.ziroom.ziroomcustomer.b.l.query(paramContext, paramString1, paramString2);
    if ((paramContext != null) && (paramContext.size() > 0))
    {
      locall.setObject(paramContext);
      locall.setSuccess(Boolean.valueOf(true));
      return locall;
    }
    locall.setSuccess(Boolean.valueOf(false));
    return locall;
  }
  
  public static l getLease(Context paramContext, String paramString)
  {
    l locall = new l();
    List localList1 = i.query(paramContext, paramString);
    if ((localList1 != null) && (localList1.size() > 0))
    {
      Iterator localIterator1 = localList1.iterator();
      while (localIterator1.hasNext())
      {
        LeaseInfo localLeaseInfo = (LeaseInfo)localIterator1.next();
        List localList2 = k.query(paramContext, paramString, localLeaseInfo.getContractCode());
        if ((localList2 != null) && (localList2.size() > 0))
        {
          Iterator localIterator2 = localList2.iterator();
          while (localIterator2.hasNext())
          {
            LeasePayPlan localLeasePayPlan = (LeasePayPlan)localIterator2.next();
            localLeasePayPlan.setLpdl(j.query(paramContext, paramString, localLeasePayPlan.getContractCode(), localLeasePayPlan.getPeriods().intValue()));
          }
        }
        localLeaseInfo.setPayPlan(localList2);
      }
      locall.setSuccess(Boolean.valueOf(true));
    }
    for (;;)
    {
      locall.setObject(localList1);
      return locall;
      locall.setSuccess(Boolean.valueOf(false));
      locall.setMessage("获取数据失败!");
    }
  }
  
  public static int getNewMsgSize(Context paramContext, String paramString)
  {
    int j = n.getMsgCnt(paramContext, paramString);
    if ((paramString == null) || (paramString.equals(""))) {}
    for (int i = b.getUnreadMsgCnt(paramContext, com.ziroom.ziroomcustomer.newchat.c.getGuestAccount(paramContext));; i = b.getUnreadMsgCnt(paramContext, paramString)) {
      return i + j;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/e/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */