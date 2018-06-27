package com.ziroom.ziroomcustomer.wxapi;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.TextView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.util.n;
import com.ziroom.ziroomcustomer.util.u;

public class WXPayEntryActivity
  extends BaseActivity
  implements IWXAPIEventHandler
{
  private IWXAPI a;
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130905020);
    this.a = WXAPIFactory.createWXAPI(this, "wx484d02e10be8f5c9");
    this.a.handleIntent(getIntent(), this);
  }
  
  @Instrumented
  protected void onNewIntent(Intent paramIntent)
  {
    VdsAgent.onNewIntent(this, paramIntent);
    super.onNewIntent(paramIntent);
    setIntent(paramIntent);
    this.a.handleIntent(paramIntent, this);
  }
  
  public void onReq(BaseReq paramBaseReq) {}
  
  public void onResp(BaseResp paramBaseResp)
  {
    Object localObject2;
    Object localObject1;
    TextView localTextView;
    final Dialog localDialog;
    if (paramBaseResp.getType() == 5)
    {
      localObject2 = LayoutInflater.from(this).inflate(2130903872, null);
      localObject1 = (TextView)((View)localObject2).findViewById(2131690084);
      localTextView = (TextView)((View)localObject2).findViewById(2131691363);
      localDialog = new Dialog(this, 2131427695);
      localDialog.setContentView((View)localObject2);
      if ((localDialog instanceof Dialog)) {
        break label201;
      }
      localDialog.show();
      localObject2 = ((WindowManager)getSystemService("window")).getDefaultDisplay();
      Window localWindow = localDialog.getWindow();
      if (localWindow != null)
      {
        WindowManager.LayoutParams localLayoutParams = localWindow.getAttributes();
        localLayoutParams.width = (((Display)localObject2).getWidth() - n.dip2px(this, 48.0F));
        localWindow.setAttributes(localLayoutParams);
      }
      if (paramBaseResp.errCode != 0) {
        break label221;
      }
      ((TextView)localObject1).setText("微信支付成功！");
    }
    for (;;)
    {
      try
      {
        Thread.sleep(2000L);
        localObject1 = new Intent("com.ziroom.ziroomcustomer.activity_1");
        ((Intent)localObject1).putExtra("code", paramBaseResp.errCode);
        sendOrderedBroadcast((Intent)localObject1, null);
        localDialog.dismiss();
        finish();
        localTextView.setOnClickListener(new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymousView)
          {
            VdsAgent.onClick(this, paramAnonymousView);
            localDialog.dismiss();
            WXPayEntryActivity.this.finish();
          }
        });
        return;
        label201:
        VdsAgent.showDialog((Dialog)localDialog);
      }
      catch (InterruptedException localInterruptedException)
      {
        localInterruptedException.printStackTrace();
        continue;
      }
      label221:
      if (paramBaseResp.errCode == -2)
      {
        localObject2 = new Intent("com.ziroom.ziroomcustomer.activity_2");
        ((Intent)localObject2).putExtra("code", paramBaseResp.errCode);
        sendBroadcast((Intent)localObject2);
        localInterruptedException.setText("微信支付取消！");
      }
      else
      {
        localObject2 = new Intent("com.ziroom.ziroomcustomer.activity_2");
        ((Intent)localObject2).putExtra("code", paramBaseResp.errCode);
        sendBroadcast((Intent)localObject2);
        u.e("wx", "-2 0 " + paramBaseResp.errCode + " " + paramBaseResp.toString());
        localInterruptedException.setText("微信支付失败！");
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/wxapi/WXPayEntryActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */