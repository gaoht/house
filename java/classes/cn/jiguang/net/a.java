package cn.jiguang.net;

import android.content.Context;
import android.os.AsyncTask;

final class a
  extends AsyncTask<HttpRequest, Void, HttpResponse>
{
  private HttpUtils.HttpListener a;
  private Context b;
  
  public a(Context paramContext, HttpUtils.HttpListener paramHttpListener)
  {
    this.a = paramHttpListener;
    this.b = paramContext;
  }
  
  protected final void onPreExecute() {}
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/jiguang/net/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */