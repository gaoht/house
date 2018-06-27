package com.ziroom.ziroomcustomer.minsu.chat;

import android.app.Activity;
import android.widget.BaseAdapter;
import com.hyphenate.chat.EMMessage;
import com.hyphenate.chat.EMMessage.Direct;
import com.hyphenate.chat.EMMessage.Type;
import com.ziroom.ziroomcustomer.minsu.chat.d.k;

public class h
  implements f
{
  private Activity a;
  private k b;
  
  public h(Activity paramActivity, k paramk)
  {
    this.a = paramActivity;
    this.b = paramk;
  }
  
  public MinsuChatRow getCustomChatRow(EMMessage paramEMMessage, int paramInt, BaseAdapter paramBaseAdapter)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramEMMessage.getType() == EMMessage.Type.TXT)
    {
      localObject1 = localObject2;
      if ("ZIROOM_ZRY_IM".equals(paramEMMessage.getStringAttribute("ziroomFlag", "")))
      {
        localObject1 = localObject2;
        if (!"3".equals(paramEMMessage.getStringAttribute("msgType", "")))
        {
          localObject1 = localObject2;
          if (!"4".equals(paramEMMessage.getStringAttribute("msgType", ""))) {
            localObject1 = new MinsuChatRowStationText(this.a, paramEMMessage, paramInt, paramBaseAdapter, this.b);
          }
        }
      }
    }
    return (MinsuChatRow)localObject1;
  }
  
  public int getCustomChatRowType(EMMessage paramEMMessage)
  {
    if (paramEMMessage == null) {}
    for (;;)
    {
      return -1;
      try
      {
        if ((paramEMMessage.getType() == EMMessage.Type.TXT) && ("ZIROOM_ZRY_IM".equals(paramEMMessage.getStringAttribute("ziroomFlag", ""))) && (!"3".equals(paramEMMessage.getStringAttribute("msgType", ""))) && (!"4".equals(paramEMMessage.getStringAttribute("msgType", ""))))
        {
          paramEMMessage = paramEMMessage.direct();
          EMMessage.Direct localDirect = EMMessage.Direct.RECEIVE;
          if (paramEMMessage == localDirect) {
            return 0;
          }
          return 1;
        }
      }
      catch (Exception paramEMMessage)
      {
        paramEMMessage.printStackTrace();
      }
    }
    return -1;
  }
  
  public int getCustomChatRowTypeCount()
  {
    return 2;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/chat/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */