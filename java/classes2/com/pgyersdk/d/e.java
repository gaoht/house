package com.pgyersdk.d;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.Toast;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.pgyersdk.b.b;
import com.pgyersdk.i.k;
import com.pgyersdk.views.g;

class e
  implements DialogInterface.OnClickListener
{
  e(a parama, Context paramContext) {}
  
  @Instrumented
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    VdsAgent.onClick(this, paramDialogInterface, paramInt);
    a.a(this.b, a.a(this.b).l);
    Toast localToast;
    if ((!k.a(VdsAgent.trackEditTextSilent(a.a(this.b).c()).toString())) || (a.c(this.b) != null) || (!k.a(VdsAgent.trackEditTextSilent(a.a(this.b).b()).toString().trim())))
    {
      a.a(paramDialogInterface, Boolean.valueOf(true));
      localToast = Toast.makeText(this.a, b.a(1056), 0);
      if (!(localToast instanceof Toast))
      {
        localToast.show();
        if ((a.e(this.b) != null) && (a.e(this.b).isShowing())) {
          a.e(this.b).dismiss();
        }
      }
    }
    for (;;)
    {
      paramDialogInterface.cancel();
      a.a(this.b).f();
      return;
      VdsAgent.showToast((Toast)localToast);
      break;
      a.a(paramDialogInterface, Boolean.valueOf(true));
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/pgyersdk/d/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */