package cn.testin.analysis;

import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.Size;
import android.os.AsyncTask;
import android.os.AsyncTask.Status;
import android.os.Build.VERSION;

public class gk
  extends AsyncTask<Void, Void, String>
{
  private Camera a;
  private byte[] b;
  private gl c;
  
  public gk(Camera paramCamera, byte[] paramArrayOfByte, gl paramgl)
  {
    this.a = paramCamera;
    this.b = paramArrayOfByte;
    this.c = paramgl;
  }
  
  public gk a()
  {
    if (Build.VERSION.SDK_INT >= 11)
    {
      executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
      return this;
    }
    execute(new Void[0]);
    return this;
  }
  
  protected String a(Void... paramVarArgs)
  {
    paramVarArgs = this.a.getParameters().getPreviewSize();
    int k = paramVarArgs.width;
    int m = paramVarArgs.height;
    paramVarArgs = new byte[this.b.length];
    int i = 0;
    while (i < m)
    {
      int j = 0;
      while (j < k)
      {
        paramVarArgs[(j * m + m - i - 1)] = this.b[(i * k + j)];
        j += 1;
      }
      i += 1;
    }
    try
    {
      if (this.c == null) {
        return null;
      }
      String str = this.c.a(paramVarArgs, m, k, false);
      return str;
    }
    catch (Exception localException)
    {
      try
      {
        paramVarArgs = this.c.a(paramVarArgs, m, k, true);
        return paramVarArgs;
      }
      catch (Exception paramVarArgs) {}
    }
    return null;
  }
  
  public void b()
  {
    if (getStatus() != AsyncTask.Status.FINISHED) {
      cancel(true);
    }
  }
  
  protected void onCancelled()
  {
    super.onCancelled();
    this.c = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/testin/analysis/gk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */