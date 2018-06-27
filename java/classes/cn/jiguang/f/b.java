package cn.jiguang.f;

import android.content.Context;
import android.widget.Toast;
import com.growingio.android.sdk.agent.VdsAgent;

final class b
  implements Runnable
{
  b(Context paramContext, String paramString) {}
  
  public final void run()
  {
    Toast localToast = Toast.makeText(this.a, this.b, 0);
    if (!(localToast instanceof Toast))
    {
      localToast.show();
      return;
    }
    VdsAgent.showToast((Toast)localToast);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/jiguang/f/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */