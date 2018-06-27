package com.growingio.android.sdk.circle;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.growingio.android.sdk.utils.Util;

public class e
  extends f
{
  public e(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  private void a()
  {
    setBackgroundColor(-1090519040);
    Object localObject = new ImageView(getContext())
    {
      Paint a = new Paint();
      
      @SuppressLint({"MissingSuperCall"})
      public void draw(Canvas paramAnonymousCanvas)
      {
        Path localPath = new Path();
        localPath.moveTo(getWidth() * 0.4F, 0.0F);
        localPath.lineTo(getWidth() * 0.6F, 0.0F);
        localPath.lineTo(getWidth() * 0.6F, getHeight() * 0.7F);
        localPath.lineTo(getWidth(), getHeight() * 0.7F);
        localPath.lineTo(getWidth() * 0.5F, getHeight());
        localPath.lineTo(0.0F, getHeight() * 0.7F);
        localPath.lineTo(getWidth() * 0.4F, getHeight() * 0.7F);
        localPath.close();
        paramAnonymousCanvas.drawPath(localPath, this.a);
      }
    };
    int i = Util.a(getContext(), 42.0F);
    int j = Util.a(getContext(), 80.0F);
    FrameLayout.LayoutParams localLayoutParams1 = new FrameLayout.LayoutParams(i, j);
    localLayoutParams1.gravity = 1;
    localLayoutParams1.topMargin = (i.d() / 2 - a.a - j);
    addView((View)localObject, localLayoutParams1);
    localObject = new TextView(getContext());
    ((TextView)localObject).setTextColor(-723724);
    ((TextView)localObject).setTextSize(2, 18.0F);
    FrameLayout.LayoutParams localLayoutParams2 = new FrameLayout.LayoutParams(-2, -2);
    localLayoutParams2.gravity = 1;
    localLayoutParams2.topMargin = (localLayoutParams1.topMargin - a.a / 2 - Util.b(getContext(), 18.0F));
    addView((View)localObject, localLayoutParams2);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/growingio/android/sdk/circle/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */