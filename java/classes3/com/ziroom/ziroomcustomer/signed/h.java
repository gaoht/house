package com.ziroom.ziroomcustomer.signed;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.graphics.drawable.Animatable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.f.c;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.util.ah;
import com.ziroom.ziroomcustomer.util.u;
import com.ziroom.ziroomcustomer.widget.LodingProgressDialog;

public class h
{
  private static int[] a = { 2130838166, 2130838167 };
  private static int b = 100;
  private static Dialog c = null;
  private static com.ziroom.ziroomcustomer.widget.e d = null;
  private static Activity e = null;
  
  public static void creatDialog(final Context paramContext, String paramString1, boolean paramBoolean1, boolean paramBoolean2, final String paramString2, com.alibaba.fastjson.e parame, final a parama)
  {
    if ((parame != null) && (parame.get("isToast") == null)) {
      parama.closeDialog();
    }
    for (;;)
    {
      return;
      if ((paramContext == null) || ((parame != null) && (!"1".equals(parame.get("isToast").toString()))))
      {
        parama.closeDialog();
        return;
      }
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
      parame = new LinearLayout(paramContext);
      parame.setGravity(17);
      c = new Dialog(paramContext, 2131427873);
      c.setCancelable(paramBoolean1);
      View localView = View.inflate(paramContext, 2130904945, null);
      ImageView localImageView = (ImageView)localView.findViewById(2131696940);
      final SimpleDraweeView localSimpleDraweeView = (SimpleDraweeView)localView.findViewById(2131696938);
      final TextView localTextView = (TextView)localView.findViewById(2131696939);
      localTextView.setText("加载中...");
      u.e("弹窗", "tantantantantan");
      localImageView.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          if (h.a() != null) {
            h.a().dismiss();
          }
          if (h.b() != null) {
            h.b().removeCallBacks();
          }
          this.a.closeDialog();
        }
      });
      localSimpleDraweeView.setController(c.frescoController(paramString1, new BaseControllerListener()
      {
        public void onFailure(String paramAnonymousString, Throwable paramAnonymousThrowable)
        {
          super.onFailure(paramAnonymousString, paramAnonymousThrowable);
          h.b().removeCallBacks();
          this.a.setVisibility(0);
          localSimpleDraweeView.setVisibility(8);
          localTextView.setVisibility(0);
          localTextView.setText("抱歉，加载失败了~");
        }
        
        public void onFinalImageSet(String paramAnonymousString, Object paramAnonymousObject, Animatable paramAnonymousAnimatable)
        {
          super.onFinalImageSet(paramAnonymousString, paramAnonymousObject, paramAnonymousAnimatable);
          h.b().removeCallBacks();
          this.a.setVisibility(0);
          localTextView.setVisibility(8);
          paramAnonymousString = (LinearLayout.LayoutParams)localSimpleDraweeView.getLayoutParams();
          paramAnonymousString.width = ah.dip2px(paramContext, 300.0F);
          paramAnonymousString.height = ah.dip2px(paramContext, 439.0F);
          localSimpleDraweeView.setLayoutParams(paramAnonymousString);
          localSimpleDraweeView.setBackgroundResource(2131624576);
          localSimpleDraweeView.setOnClickListener(new View.OnClickListener()
          {
            @Instrumented
            public void onClick(View paramAnonymous2View)
            {
              VdsAgent.onClick(this, paramAnonymous2View);
              h.2.this.e.toMoveHouseWeb(h.2.this.f);
              h.2.this.a.performClick();
            }
          });
        }
      }));
      d = new com.ziroom.ziroomcustomer.widget.e(localSimpleDraweeView, a, b);
      parame.addView(localView, localLayoutParams);
      paramContext = new LinearLayout.LayoutParams(-1, -1);
      parame.setBackgroundResource(2130838986);
      c.setContentView(parame, paramContext);
      paramContext = c;
      if (!(paramContext instanceof Dialog)) {
        paramContext.show();
      }
      while (c != null)
      {
        c.setOnCancelListener(new DialogInterface.OnCancelListener()
        {
          public void onCancel(DialogInterface paramAnonymousDialogInterface) {}
        });
        return;
        VdsAgent.showDialog((Dialog)paramContext);
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void closeDialog();
    
    public abstract void toMoveHouseWeb(String paramString);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/signed/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */