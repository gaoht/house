package cn.testin.analysis;

import android.widget.Toast;
import com.growingio.android.sdk.agent.VdsAgent;

class bi
  implements Runnable
{
  bi(bd parambd, String paramString) {}
  
  public void run()
  {
    Toast localToast = Toast.makeText(a.d, this.a, 0);
    if (!(localToast instanceof Toast))
    {
      localToast.show();
      return;
    }
    VdsAgent.showToast((Toast)localToast);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/testin/analysis/bi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */