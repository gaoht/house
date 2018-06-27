package com.pgyersdk.d;

import android.os.Handler;
import android.os.Message;
import android.widget.Toast;
import com.growingio.android.sdk.agent.VdsAgent;
import com.pgyersdk.b.b;
import com.pgyersdk.i.d;

class i
  extends Handler
{
  i(a parama) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      com.pgyersdk.i.i.a("feedback_des", "");
      com.pgyersdk.i.i.a("voicefile", "");
      com.pgyersdk.i.i.a("voiceTime", "");
      this.a.destroy();
      return;
    case 20001: 
      paramMessage = Toast.makeText(a.b(this.a), b.a(1058), 0);
      if (!(paramMessage instanceof Toast)) {
        paramMessage.show();
      }
      for (;;)
      {
        d.a().a(d.a().b(a.b(this.a)));
        break;
        VdsAgent.showToast((Toast)paramMessage);
      }
    }
    paramMessage = Toast.makeText(a.b(this.a), b.a(1059), 0);
    if (!(paramMessage instanceof Toast)) {
      paramMessage.show();
    }
    for (;;)
    {
      d.a().a(d.a().b(a.b(this.a)));
      break;
      VdsAgent.showToast((Toast)paramMessage);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/pgyersdk/d/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */