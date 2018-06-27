package com.ziroom.ziroomcustomer.widget;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.airbnb.lottie.LottieAnimationView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.f.h;
import com.growingio.android.sdk.agent.VdsAgent;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.util.ad;
import com.ziroom.ziroomcustomer.util.c.c.a;
import com.ziroom.ziroomcustomer.util.c.g;
import java.io.File;

public class LodingProgressDialog
{
  private static int[] a = { 2130838982, 2130838983, 2130838984, 2130838985 };
  private static int b = 500;
  private static Dialog c = null;
  private static e d = null;
  private static Activity e = null;
  
  private static void a(Context paramContext, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramContext == null) {}
    label296:
    label304:
    for (;;)
    {
      return;
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
      paramString = new LinearLayout(paramContext);
      paramString.setGravity(17);
      c = new Dialog(paramContext, 2131427873);
      c.setCancelable(paramBoolean1);
      View localView = View.inflate(paramContext, 2130904859, null);
      SimpleDraweeView localSimpleDraweeView = (SimpleDraweeView)localView.findViewById(2131696753);
      LottieAnimationView localLottieAnimationView = (LottieAnimationView)localView.findViewById(2131696754);
      if (g.checkSkin())
      {
        localSimpleDraweeView.setController(com.freelxl.baselibrary.f.c.frescoFromFileController(new File(g.a + ad.getSkinSign(ApplicationEx.c) + "/" + g.getLoadingJson().getResources().getResource_refreshJson())));
        h.loadLottieFromScCard(paramContext, localLottieAnimationView, g.a + ad.getSkinSign(ApplicationEx.c) + "/" + g.getLoadingJson().getResources().getResource_refreshJson());
        paramString.addView(localView, localLayoutParams);
        paramContext = new LinearLayout.LayoutParams(-1, -1);
        paramString.setBackgroundResource(2130838986);
        c.setContentView(paramString, paramContext);
        paramContext = c;
        if ((paramContext instanceof Dialog)) {
          break label296;
        }
        paramContext.show();
      }
      for (;;)
      {
        if (c == null) {
          break label304;
        }
        c.setOnCancelListener(new DialogInterface.OnCancelListener()
        {
          public void onCancel(DialogInterface paramAnonymousDialogInterface) {}
        });
        return;
        localSimpleDraweeView.setController(com.freelxl.baselibrary.f.c.frescoFromResourceController(2130840449));
        localLottieAnimationView.setAnimation("defultloading.json");
        localLottieAnimationView.loop(true);
        localLottieAnimationView.playAnimation();
        break;
        VdsAgent.showDialog((Dialog)paramContext);
      }
    }
  }
  
  public static void dismiss()
  {
    try
    {
      if ((c != null) && (e != null) && (!e.isFinishing()))
      {
        c.dismiss();
        e = null;
        if (d != null) {
          d.removeCallBacks();
        }
        c = null;
        d = null;
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public static Dialog getDialog()
  {
    return c;
  }
  
  public static boolean isShowing()
  {
    return c.isShowing();
  }
  
  public static void show(Activity paramActivity, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    e = paramActivity;
    if (e.isFinishing()) {}
    do
    {
      return;
      if (c == null)
      {
        a(paramActivity, paramString, paramBoolean1, paramBoolean2);
        return;
      }
    } while (isShowing());
    paramActivity = c;
    if (!(paramActivity instanceof Dialog))
    {
      paramActivity.show();
      return;
    }
    VdsAgent.showDialog((Dialog)paramActivity);
  }
  
  public static void show(Activity paramActivity, boolean paramBoolean1, boolean paramBoolean2)
  {
    e = paramActivity;
    if (!e.isFinishing()) {
      a(paramActivity, "", paramBoolean1, paramBoolean2);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/widget/LodingProgressDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */