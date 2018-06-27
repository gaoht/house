package com.ziroom.commonlib.utils;

import android.text.TextUtils;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.aw;
import com.airbnb.lottie.aw.a;
import com.airbnb.lottie.bf;
import java.io.FileInputStream;

public class a
{
  public static boolean loadLottieFromSdCard(LottieAnimationView paramLottieAnimationView, String paramString)
  {
    boolean bool = false;
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        paramString = new FileInputStream(paramString);
        aw.a.fromInputStream(d.a, paramString, new bf()
        {
          public void onCompositionLoaded(aw paramAnonymousaw)
          {
            if (paramAnonymousaw != null)
            {
              this.a.setVisibility(0);
              this.a.setComposition(paramAnonymousaw);
              this.a.loop(true);
              this.a.playAnimation();
            }
          }
        });
        bool = true;
      }
      return bool;
    }
    catch (Exception paramLottieAnimationView)
    {
      paramLottieAnimationView.printStackTrace();
    }
    return false;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/commonlib/utils/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */