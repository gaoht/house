package com.megvii.zhimasdk.d;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.megvii.zhimasdk.MGLivenessDetectActivity;

public class d
{
  private MGLivenessDetectActivity a;
  
  public d(MGLivenessDetectActivity paramMGLivenessDetectActivity)
  {
    this.a = paramMGLivenessDetectActivity;
  }
  
  public void a()
  {
    this.a = null;
  }
  
  public void a(String paramString, final boolean paramBoolean)
  {
    paramString = new AlertDialog.Builder(this.a).setTitle(paramString).setNegativeButton("确认", new DialogInterface.OnClickListener()
    {
      @Instrumented
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        VdsAgent.onClick(this, paramAnonymousDialogInterface, paramAnonymousInt);
        if (paramBoolean)
        {
          d.a(d.this).a(5);
          return;
        }
        d.a(d.this).a(7);
      }
    }).setCancelable(false).create();
    if (!(paramString instanceof AlertDialog))
    {
      paramString.show();
      return;
    }
    VdsAgent.showDialog((AlertDialog)paramString);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/megvii/zhimasdk/d/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */