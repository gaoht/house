package com.growingio.android.sdk.circle;

import android.os.AsyncTask;
import android.util.Pair;
import com.growingio.android.sdk.a.e;

class g
  extends AsyncTask<Void, Void, Pair<Integer, byte[]>>
{
  private String a;
  private c.a b;
  
  g(c.a parama, String paramString)
  {
    this.a = paramString;
    this.b = parama;
  }
  
  protected Pair<Integer, byte[]> a(Void... paramVarArgs)
  {
    return e.a().a(this.a);
  }
  
  protected void a(Pair<Integer, byte[]> paramPair)
  {
    this.b.a(paramPair);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/growingio/android/sdk/circle/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */