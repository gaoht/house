package com.hyphenate.chat;

import com.hyphenate.chat.adapter.EMAPushConfigs;

public class EMPushConfigs
  extends EMBase<EMAPushConfigs>
{
  public EMPushConfigs(EMAPushConfigs paramEMAPushConfigs)
  {
    this.emaObject = paramEMAPushConfigs;
  }
  
  public String getDisplayNickname()
  {
    return ((EMAPushConfigs)this.emaObject).getDisplayNickname();
  }
  
  public int getNoDisturbEndHour()
  {
    return ((EMAPushConfigs)this.emaObject).getNoDisturbEndHour();
  }
  
  public int getNoDisturbStartHour()
  {
    return ((EMAPushConfigs)this.emaObject).getNoDisturbStartHour();
  }
  
  public boolean isNoDisturbOn()
  {
    return ((EMAPushConfigs)this.emaObject).isNoDisturbOn();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/hyphenate/chat/EMPushConfigs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */