package com.pgyersdk.d;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.view.View;
import com.growingio.android.sdk.agent.VdsAgent;
import com.pgyersdk.i.i;
import com.pgyersdk.views.g;

class f
  implements DialogInterface.OnCancelListener
{
  f(a parama, boolean paramBoolean) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    a.a(this.b).f();
    i.a("selfmail", VdsAgent.trackEditTextSilent(a.a(this.b).b()).toString().trim());
    i.a("feedback_des", VdsAgent.trackEditTextSilent(a.a(this.b).c()).toString().trim());
    if (this.a) {
      com.pgyersdk.views.b.i.setVisibility(8);
    }
    for (;;)
    {
      a.a(this.b, null);
      a.f(null);
      return;
      if (this.b.a != null) {
        this.b.a.b();
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/pgyersdk/d/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */