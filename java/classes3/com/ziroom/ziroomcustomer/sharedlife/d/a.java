package com.ziroom.ziroomcustomer.sharedlife.d;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.airbnb.lottie.LottieAnimationView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.e.a.d;
import com.ziroom.ziroomcustomer.e.c.f;
import com.ziroom.ziroomcustomer.model.UserInfo;
import com.ziroom.ziroomcustomer.newServiceList.utils.i;
import com.ziroom.ziroomcustomer.sharedlife.activity.SharedLifeGestureLockActivity;
import com.ziroom.ziroomcustomer.util.ad;
import com.ziroom.ziroomcustomer.util.u;
import java.util.List;
import java.util.Locale;

public class a
{
  public static String getEqStatusName(int paramInt)
  {
    String str = "";
    if (paramInt == 0) {
      str = "空闲";
    }
    do
    {
      return str;
      if (paramInt == 1) {
        return "使用中";
      }
      if (paramInt == 2) {
        return "准备中";
      }
      if (paramInt == 3) {
        return "占用中";
      }
      if (paramInt == 4) {
        return "离线";
      }
      if (paramInt == 5) {
        return "等待支付";
      }
      if (paramInt == 6) {
        return "暂停中";
      }
    } while (paramInt != 8);
    return "完成中";
  }
  
  public static String getFormatTime(int paramInt)
  {
    int i = paramInt / 3600;
    int j = paramInt % 3600 / 60;
    return String.format(Locale.CHINA, "%02d:%02d:%02d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(paramInt % 60) });
  }
  
  public static int getLeftTime(Context paramContext)
  {
    int j = 0;
    String str = ad.getLockTime(paramContext);
    int k = ad.getLockLeftTime(paramContext);
    int i = j;
    if (!TextUtils.isEmpty(str))
    {
      long l = i.getSecondDiff(str);
      i = j;
      if (l > 0L)
      {
        i = j;
        if (l < k) {
          i = k - (int)l;
        }
      }
    }
    return i;
  }
  
  public static void setEqSdvLayoutParam(SimpleDraweeView paramSimpleDraweeView, LottieAnimationView paramLottieAnimationView, int paramInt, String paramString)
  {
    int i = paramInt * 251 / 667;
    int j = i * 215 / 251;
    paramInt = paramInt * 1 / 667;
    paramString = (RelativeLayout.LayoutParams)paramSimpleDraweeView.getLayoutParams();
    paramString.width = j;
    paramString.height = i;
    paramSimpleDraweeView.setLayoutParams(paramString);
    paramSimpleDraweeView = (RelativeLayout.LayoutParams)paramLottieAnimationView.getLayoutParams();
    paramSimpleDraweeView.width = j;
    paramSimpleDraweeView.height = i;
    paramLottieAnimationView.setLayoutParams(paramSimpleDraweeView);
  }
  
  public static void setEqStaticLayoutParam(RelativeLayout paramRelativeLayout, SimpleDraweeView paramSimpleDraweeView, LottieAnimationView paramLottieAnimationView, ImageView paramImageView, int paramInt)
  {
    paramSimpleDraweeView = (LinearLayout.LayoutParams)paramRelativeLayout.getLayoutParams();
    paramSimpleDraweeView.height = (paramInt * 315 / 667);
    paramRelativeLayout.setLayoutParams(paramSimpleDraweeView);
    int i = paramInt * 251 / 667 * 215 / 251;
    paramInt = paramInt * 1 / 667;
    paramRelativeLayout = (RelativeLayout.LayoutParams)paramImageView.getLayoutParams();
    paramRelativeLayout.width = i;
    paramRelativeLayout.bottomMargin = paramInt;
    paramImageView.setLayoutParams(paramRelativeLayout);
  }
  
  public static void sharedLifeContract(final Context paramContext)
  {
    if (!ApplicationEx.c.isLoginState())
    {
      com.ziroom.commonlibrary.login.a.startLoginActivity(paramContext);
      return;
    }
    com.ziroom.ziroomcustomer.sharedlife.a.getSharedLifeContracts(paramContext, ApplicationEx.c.getUser().getUid(), new d(paramContext, new f(com.ziroom.ziroomcustomer.sharedlife.c.a.class))
    {
      public void onSuccess(int paramAnonymousInt, com.ziroom.ziroomcustomer.sharedlife.c.a paramAnonymousa)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousa);
        u.d("sjgds", "====  " + com.alibaba.fastjson.a.toJSONString(paramAnonymousa));
        Intent localIntent = new Intent(paramContext, SharedLifeGestureLockActivity.class);
        if ((paramAnonymousa != null) && (paramAnonymousa.getTbRentContracts() != null) && (paramAnonymousa.getTbRentContracts().size() > 0)) {
          localIntent.putExtra("sl_contractList", com.alibaba.fastjson.a.toJSONString(paramAnonymousa.getTbRentContracts()));
        }
        for (;;)
        {
          paramContext.startActivity(localIntent);
          return;
          localIntent.putExtra("sl_contractList", "");
        }
      }
    });
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/sharedlife/d/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */