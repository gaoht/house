package com.pgyersdk.views;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.LinearLayout;
import android.widget.Toast;
import com.growingio.android.sdk.agent.VdsAgent;
import com.pgyersdk.b.b;
import com.pgyersdk.i.i;
import com.pgyersdk.i.m;
import java.io.File;
import java.util.Date;

class j
  implements View.OnTouchListener
{
  j(g paramg) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (!m.a().a(this.a.a, "android.permission.RECORD_AUDIO"))
    {
      paramView = Toast.makeText(this.a.a, b.a(1074), 0);
      if (!(paramView instanceof Toast))
      {
        paramView.show();
        return false;
      }
      VdsAgent.showToast((Toast)paramView);
      return false;
    }
    switch (paramMotionEvent.getAction())
    {
    case 2: 
    default: 
      return false;
    case 0: 
      g.i(this.a);
      g.g(this.a).setText(b.a(1073));
      return false;
    }
    g.b(this.a, new Date().getTime());
    g.g(this.a).setText(b.a(1072));
    g.f(this.a);
    if (g.j(this.a) - g.b(this.a) < 1000L)
    {
      paramMotionEvent = Toast.makeText(this.a.a, b.a(1075), 0);
      if (!(paramMotionEvent instanceof Toast))
      {
        paramMotionEvent.show();
        this.a.l = null;
        g.g(this.a).setVisibility(0);
        g.h(this.a).setVisibility(8);
      }
    }
    for (;;)
    {
      g.a(this.a, paramView);
      return false;
      VdsAgent.showToast((Toast)paramMotionEvent);
      break;
      g.g(this.a).setVisibility(8);
      g.h(this.a).setVisibility(0);
      if (this.a.l != null)
      {
        i.a("voicefile", this.a.l.getAbsolutePath());
        i.a("voiceTime", this.a.k.getText().toString());
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/pgyersdk/views/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */