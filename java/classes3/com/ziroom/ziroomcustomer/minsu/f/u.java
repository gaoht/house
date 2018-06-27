package com.ziroom.ziroomcustomer.minsu.f;

import android.content.Context;
import com.alibaba.fastjson.a;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuLandlordInfo.Medal;
import com.ziroom.ziroomcustomer.util.ae;
import java.util.List;

public class u
{
  public static List<MinsuLandlordInfo.Medal> getEmblemHistory(Context paramContext)
  {
    if (paramContext == null) {}
    do
    {
      return null;
      paramContext = aa.getString(paramContext, "ziroomminsuminsulandlordemblem", null);
    } while (ae.isNull(paramContext));
    return a.parseArray(paramContext, MinsuLandlordInfo.Medal.class);
  }
  
  public static void putEmblemHistory(Context paramContext, List<MinsuLandlordInfo.Medal> paramList)
  {
    if (paramContext == null) {
      return;
    }
    aa.putString(paramContext, "ziroomminsuminsulandlordemblem", a.toJSONString(paramList));
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/f/u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */