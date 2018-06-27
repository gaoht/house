package com.ziroom.ziroomcustomer.minsu.d;

import android.os.Bundle;
import com.ziroom.ziroomcustomer.base.BaseFragment;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.LLEditHouseRuleFragment;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.LLRManagerStepSecondHouseFragment;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.LLRManagerStepSecondRoomFragment;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.LLRManagerStepfirstFragment;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.LandlordReleaseThirdStepFragment;

public class c
{
  private static c a;
  
  public static c getInstance()
  {
    if (a == null) {
      a = new c();
    }
    return a;
  }
  
  public BaseFragment getFragment(int paramInt, Bundle paramBundle)
  {
    switch (paramInt)
    {
    default: 
      throw new UnknownError("不支持的fragment类型");
    case 1: 
      return LLEditHouseRuleFragment.getInstance(paramBundle);
    case 2: 
      return LandlordReleaseThirdStepFragment.getInstance(paramBundle);
    case 3: 
      return LLRManagerStepfirstFragment.getInstance(paramBundle);
    case 4: 
      return LLRManagerStepSecondHouseFragment.getInstance(paramBundle);
    }
    return LLRManagerStepSecondRoomFragment.getInstance(paramBundle);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/d/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */