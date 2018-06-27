package com.ziroom.ziroomcustomer.ziroomstation.utils.takephoto.b;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.PopupWindow;
import java.util.List;

public abstract class a<T>
  extends PopupWindow
{
  protected View a;
  protected Context b;
  protected List<T> c;
  
  public a(View paramView, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    this(paramView, paramInt1, paramInt2, paramBoolean, null);
  }
  
  public a(View paramView, int paramInt1, int paramInt2, boolean paramBoolean, List<T> paramList)
  {
    this(paramView, paramInt1, paramInt2, paramBoolean, paramList, new Object[0]);
  }
  
  public a(View paramView, int paramInt1, int paramInt2, boolean paramBoolean, List<T> paramList, Object... paramVarArgs)
  {
    super(paramView, paramInt1, paramInt2, paramBoolean);
    this.a = paramView;
    this.b = paramView.getContext();
    if (paramList != null) {
      this.c = paramList;
    }
    if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {
      a(paramVarArgs);
    }
    setBackgroundDrawable(new BitmapDrawable());
    setTouchable(true);
    setOutsideTouchable(true);
    setTouchInterceptor(new View.OnTouchListener()
    {
      public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        if (paramAnonymousMotionEvent.getAction() == 4)
        {
          a.this.dismiss();
          return true;
        }
        return false;
      }
    });
    initViews();
    initEvents();
    init();
  }
  
  protected abstract void a(Object... paramVarArgs);
  
  public View findViewById(int paramInt)
  {
    return this.a.findViewById(paramInt);
  }
  
  public abstract void init();
  
  public abstract void initEvents();
  
  public abstract void initViews();
}


/* Location:              /Users/gaoht/Downloads/zirom/classes4-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomstation/utils/takephoto/b/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */