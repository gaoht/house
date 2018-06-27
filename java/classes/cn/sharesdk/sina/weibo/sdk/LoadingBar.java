package cn.sharesdk.sina.weibo.sdk;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Handler;
import android.util.AttributeSet;
import android.widget.TextView;

public class LoadingBar
  extends TextView
{
  private int a;
  private int b;
  private Paint c;
  private Handler d;
  private Runnable e;
  
  public LoadingBar(Context paramContext)
  {
    super(paramContext);
    this.e = new Runnable()
    {
      public void run()
      {
        LoadingBar.a(LoadingBar.this, LoadingBar.a(LoadingBar.this) + 1);
        LoadingBar.this.a(LoadingBar.a(LoadingBar.this));
      }
    };
    a(paramContext);
  }
  
  public LoadingBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public LoadingBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    this.d = new Handler();
    this.c = new Paint();
    a();
  }
  
  private Rect b()
  {
    int i = getLeft();
    int j = getTop();
    return new Rect(0, 0, getLeft() + (getRight() - getLeft()) * this.a / 100 - i, getBottom() - j);
  }
  
  public void a()
  {
    this.b = -11693826;
  }
  
  public void a(int paramInt)
  {
    if (paramInt < 7) {
      this.d.postDelayed(this.e, 70L);
    }
    for (;;)
    {
      invalidate();
      return;
      this.d.removeCallbacks(this.e);
      this.a = paramInt;
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    this.c.setColor(this.b);
    paramCanvas.drawRect(b(), this.c);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/sharesdk/sina/weibo/sdk/LoadingBar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */