package com.ziroom.ziroomcustomer.minsu.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.GridView;
import android.widget.ImageView;

public class DragGridView
  extends GridView
{
  private ImageView a;
  private WindowManager.LayoutParams b;
  private WindowManager c;
  private boolean d = false;
  private int e = -1;
  private int f;
  private int g;
  private AdapterView.OnItemLongClickListener h = new AdapterView.OnItemLongClickListener()
  {
    public boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
    {
      DragGridView.a(DragGridView.this, paramAnonymousInt);
      paramAnonymousView.destroyDrawingCache();
      paramAnonymousView.setDrawingCacheEnabled(true);
      paramAnonymousAdapterView = Bitmap.createBitmap(paramAnonymousView.getDrawingCache());
      DragGridView.a(DragGridView.this).gravity = 51;
      DragGridView.a(DragGridView.this).width = ((int)(paramAnonymousAdapterView.getWidth() * 1.2F));
      DragGridView.a(DragGridView.this).height = ((int)(paramAnonymousAdapterView.getHeight() * 1.2F));
      DragGridView.a(DragGridView.this).x = (DragGridView.b(DragGridView.this) - DragGridView.a(DragGridView.this).width / 2);
      DragGridView.a(DragGridView.this).y = (DragGridView.c(DragGridView.this) - DragGridView.a(DragGridView.this).height / 2);
      DragGridView.a(DragGridView.this).flags = 408;
      DragGridView.a(DragGridView.this).format = -3;
      DragGridView.a(DragGridView.this).windowAnimations = 0;
      if (((Integer)DragGridView.d(DragGridView.this).getTag()).intValue() == 1)
      {
        DragGridView.e(DragGridView.this).removeView(DragGridView.d(DragGridView.this));
        DragGridView.d(DragGridView.this).setTag(Integer.valueOf(0));
      }
      DragGridView.d(DragGridView.this).setImageBitmap(paramAnonymousAdapterView);
      DragGridView.e(DragGridView.this).addView(DragGridView.d(DragGridView.this), DragGridView.a(DragGridView.this));
      DragGridView.d(DragGridView.this).setTag(Integer.valueOf(1));
      DragGridView.a(DragGridView.this, true);
      ((b)DragGridView.this.getAdapter()).hideView(paramAnonymousInt);
      return true;
    }
  };
  
  public DragGridView(Context paramContext)
  {
    super(paramContext);
    initView();
  }
  
  public DragGridView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    initView();
  }
  
  public DragGridView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    initView();
  }
  
  public void initView()
  {
    setOnItemLongClickListener(this.h);
    this.a = new ImageView(getContext());
    this.a.setTag(Integer.valueOf(0));
    this.b = new WindowManager.LayoutParams();
    this.c = ((WindowManager)getContext().getSystemService("window"));
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE));
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      this.f = ((int)paramMotionEvent.getRawX());
      this.g = ((int)paramMotionEvent.getRawY());
    }
    for (;;)
    {
      return super.onTouchEvent(paramMotionEvent);
      if ((paramMotionEvent.getAction() == 2) && (this.d == true))
      {
        Log.i("DragGridView", "" + paramMotionEvent.getRawX() + " " + paramMotionEvent.getRawY());
        this.b.x = ((int)(paramMotionEvent.getRawX() - this.a.getWidth() / 2));
        this.b.y = ((int)(paramMotionEvent.getRawY() - this.a.getHeight() / 2));
        this.c.updateViewLayout(this.a, this.b);
        int i = pointToPosition((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
        if ((i != -1) && (i != this.e))
        {
          ((b)getAdapter()).swapView(this.e, i);
          this.e = i;
        }
      }
      else if ((paramMotionEvent.getAction() == 1) && (this.d == true))
      {
        ((b)getAdapter()).showHideView();
        if (((Integer)this.a.getTag()).intValue() == 1)
        {
          this.c.removeView(this.a);
          this.a.setTag(Integer.valueOf(0));
        }
        this.d = false;
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/view/DragGridView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */