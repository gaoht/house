package com.pgyersdk.d;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.view.View;
import com.pgyersdk.activity.FeedbackActivity;
import com.pgyersdk.i.f;

class h
  extends AsyncTask
{
  h(a parama, Bitmap paramBitmap, String paramString, Context paramContext, View paramView) {}
  
  protected Boolean a(Void... paramVarArgs)
  {
    if (f.a(this.a, this.b).booleanValue()) {
      return Boolean.valueOf(true);
    }
    return Boolean.valueOf(false);
  }
  
  protected void a(Boolean paramBoolean)
  {
    super.onPostExecute(paramBoolean);
    if ((!a.g(this.e).booleanValue()) && (this.e.a != null))
    {
      this.e.a.b();
      this.e.a = null;
    }
    if (paramBoolean.booleanValue())
    {
      if (a.b() != null) {
        a.b().a(a.d(this.e));
      }
      if (!a.g(this.e).booleanValue())
      {
        paramBoolean = new Intent(this.c, FeedbackActivity.class);
        paramBoolean.addFlags(536870912);
        paramBoolean.putExtra("imgFile", this.b);
        paramBoolean.putExtra("glSurface", a.b);
        this.c.startActivity(paramBoolean);
      }
    }
    for (;;)
    {
      this.d.setDrawingCacheEnabled(false);
      return;
      if (a.b() != null) {
        a.b().a();
      }
      a.getInstance().destroy();
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/pgyersdk/d/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */