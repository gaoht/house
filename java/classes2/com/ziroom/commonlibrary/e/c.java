package com.ziroom.commonlibrary.e;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import com.freelxl.baselibrary.f.h;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.unionpay.UPPayAssistEx;
import java.io.File;

public class c
{
  private static String a = "00";
  
  public static void doStartUnionPayPlugin(Activity paramActivity, final String paramString)
  {
    paramActivity.runOnUiThread(new Runnable()
    {
      public void run()
      {
        UPPayAssistEx.startPay(this.a, null, null, paramString, c.a());
      }
    });
  }
  
  public static void doUnionPayResult(Context paramContext, int paramInt1, int paramInt2, Intent paramIntent, b paramb, int paramInt3)
  {
    if (paramIntent == null) {}
    do
    {
      return;
      paramContext = paramIntent.getExtras().getString("pay_result");
      if ("success".equalsIgnoreCase(paramContext))
      {
        paramb.onSuccess(paramInt3, new String[] { "支付成功" });
        return;
      }
      if ("fail".equalsIgnoreCase(paramContext))
      {
        paramb.onFail(paramInt3, new String[] { "支付失败" });
        return;
      }
    } while (!"cancel".equalsIgnoreCase(paramContext));
    paramb.onCancel(paramInt3, new String[] { "用户取消了支付" });
  }
  
  public static void doUnionPayResult(Context paramContext, int paramInt1, int paramInt2, Intent paramIntent, final a parama)
  {
    if (paramIntent == null) {
      return;
    }
    String str1 = "";
    String str2 = paramIntent.getExtras().getString("pay_result");
    if ("success".equalsIgnoreCase(str2)) {
      paramIntent = "支付成功！";
    }
    for (;;)
    {
      paramContext = new AlertDialog.Builder(paramContext);
      paramContext.setTitle("支付结果通知");
      paramContext.setMessage(paramIntent);
      paramContext.setInverseBackgroundForced(true);
      paramContext.setNegativeButton("确定", new DialogInterface.OnClickListener()
      {
        @Instrumented
        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          VdsAgent.onClick(this, paramAnonymousDialogInterface, paramAnonymousInt);
          paramAnonymousDialogInterface.dismiss();
          if (this.a.equalsIgnoreCase("success")) {
            parama.doBack();
          }
        }
      });
      paramContext = paramContext.create();
      if ((paramContext instanceof AlertDialog)) {
        break;
      }
      paramContext.show();
      return;
      if ("fail".equalsIgnoreCase(str2))
      {
        paramIntent = "支付失败！";
      }
      else
      {
        paramIntent = str1;
        if ("cancel".equalsIgnoreCase(str2)) {
          paramIntent = "用户取消了支付";
        }
      }
    }
    VdsAgent.showDialog((AlertDialog)paramContext);
  }
  
  public static void doUnionPayResult(Context paramContext, int paramInt1, int paramInt2, Intent paramIntent, b paramb)
  {
    if (paramIntent == null) {
      return;
    }
    String str1 = "";
    final String str2 = paramIntent.getExtras().getString("pay_result");
    if ("success".equalsIgnoreCase(str2)) {
      paramIntent = "支付成功！";
    }
    for (;;)
    {
      paramContext = new AlertDialog.Builder(paramContext);
      paramContext.setTitle("支付结果通知");
      paramContext.setMessage(paramIntent);
      paramContext.setInverseBackgroundForced(true);
      paramContext.setNegativeButton("确定", new DialogInterface.OnClickListener()
      {
        @Instrumented
        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          VdsAgent.onClick(this, paramAnonymousDialogInterface, paramAnonymousInt);
          paramAnonymousDialogInterface.dismiss();
          this.a.doBack(str2);
        }
      });
      paramContext = paramContext.create();
      if ((paramContext instanceof AlertDialog)) {
        break;
      }
      paramContext.show();
      return;
      if ("fail".equalsIgnoreCase(str2))
      {
        paramIntent = "支付失败！";
      }
      else
      {
        paramIntent = str1;
        if ("cancel".equalsIgnoreCase(str2)) {
          paramIntent = "用户取消了支付";
        }
      }
    }
    VdsAgent.showDialog((AlertDialog)paramContext);
  }
  
  public void doStartUnionPayAPK(final Activity paramActivity, String paramString)
  {
    final int i = UPPayAssistEx.startPay(paramActivity, null, null, paramString, a);
    if ((i == 2) || (i == -1))
    {
      paramString = new AlertDialog.Builder(paramActivity);
      paramString.setTitle("提示");
      paramString.setMessage("完成购买需要安装银联支付控件，是否安装？");
      paramString.setNegativeButton("确定", new DialogInterface.OnClickListener()
      {
        @Instrumented
        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          VdsAgent.onClick(this, paramAnonymousDialogInterface, paramAnonymousInt);
          if ((i == -1) && (h.copyApkFromAssets(paramActivity, "UPPayPluginEx.apk", Environment.getExternalStorageDirectory().getAbsolutePath() + "/UPPayPluginEx.apk")))
          {
            Intent localIntent = new Intent("android.intent.action.VIEW");
            localIntent.addFlags(268435456);
            localIntent.setDataAndType(Uri.parse("file://" + Environment.getExternalStorageDirectory().getAbsolutePath() + "/UPPayPluginEx.apk"), "application/vnd.android.package-archive");
            paramActivity.startActivity(localIntent);
          }
          paramAnonymousDialogInterface.dismiss();
        }
      });
      paramString.setPositiveButton("取消", new DialogInterface.OnClickListener()
      {
        @Instrumented
        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          VdsAgent.onClick(this, paramAnonymousDialogInterface, paramAnonymousInt);
          paramAnonymousDialogInterface.dismiss();
        }
      });
      paramActivity = paramString.create();
      if (!(paramActivity instanceof AlertDialog)) {
        paramActivity.show();
      }
    }
    else
    {
      return;
    }
    VdsAgent.showDialog((AlertDialog)paramActivity);
  }
  
  public static abstract interface a
  {
    public abstract void doBack();
  }
  
  public static abstract interface b
  {
    public abstract void doBack(String paramString);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/commonlibrary/e/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */