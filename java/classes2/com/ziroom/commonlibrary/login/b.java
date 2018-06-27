package com.ziroom.commonlibrary.login;

import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;

public class b
{
  int a;
  private View b;
  private a c;
  
  public b(Activity paramActivity)
  {
    this.b = paramActivity.getWindow().getDecorView();
    this.b.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
    {
      public void onGlobalLayout()
      {
        Rect localRect = new Rect();
        b.a(b.this).getWindowVisibleDisplayFrame(localRect);
        int i = localRect.height();
        if (b.this.a == 0) {
          b.this.a = i;
        }
        do
        {
          do
          {
            return;
          } while (b.this.a == i);
          if (b.this.a - i > 200)
          {
            if (b.b(b.this) != null) {
              b.b(b.this).keyBoardShow(b.this.a - i);
            }
            b.this.a = i;
            return;
          }
        } while (i - b.this.a <= 200);
        if (b.b(b.this) != null) {
          b.b(b.this).keyBoardHide(i - b.this.a);
        }
        b.this.a = i;
      }
    });
  }
  
  private void a(a parama)
  {
    this.c = parama;
  }
  
  public static void setListener(Activity paramActivity, a parama)
  {
    new b(paramActivity).a(parama);
  }
  
  public static abstract interface a
  {
    public abstract void keyBoardHide(int paramInt);
    
    public abstract void keyBoardShow(int paramInt);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/commonlibrary/login/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */