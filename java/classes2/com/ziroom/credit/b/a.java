package com.ziroom.credit.b;

import android.app.Activity;
import com.ziroom.credit.R.anim;

public class a
{
  public static void closeAcAnim(Activity paramActivity)
  {
    paramActivity.overridePendingTransition(R.anim.credit_alpha_in, R.anim.credit_push_bottom_out_credit);
  }
  
  public static void startAcAnim(Activity paramActivity)
  {
    paramActivity.overridePendingTransition(R.anim.credit_push_bottom_in_credit, R.anim.credit_alpha_out);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/credit/b/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */