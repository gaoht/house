package com.ziroom.ziroomcustomer.termination.view;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewConfiguration;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.commonlibrary.widget.unifiedziroom.c.a;
import com.ziroom.commonlibrary.widget.unifiedziroom.c.b;
import com.ziroom.ziroomcustomer.termination.a.b;
import com.ziroom.ziroomcustomer.util.u;
import java.util.List;

public class CalendarCard
  extends View
{
  private static c i;
  View.OnClickListener a = new View.OnClickListener()
  {
    @Instrumented
    public void onClick(View paramAnonymousView)
    {
      VdsAgent.onClick(this, paramAnonymousView);
      switch (paramAnonymousView.getId())
      {
      default: 
        return;
      case 2131697639: 
        if (CalendarCard.d(CalendarCard.this) != null) {
          CalendarCard.e(CalendarCard.this).clickDate(CalendarCard.d(CalendarCard.this));
        }
        CalendarCard.f(CalendarCard.this).dismiss();
        return;
      }
      CalendarCard.f(CalendarCard.this).dismiss();
      CalendarCard.a(CalendarCard.this, null);
    }
  };
  private Context b;
  private Paint c;
  private Paint d;
  private int e;
  private int f;
  private int g;
  private c[] h = new c[6];
  private b j;
  private int k;
  private boolean l;
  private a m;
  private float n;
  private float o;
  private List<b> p;
  private c q;
  private Dialog r;
  
  public CalendarCard(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
    this.b = paramContext;
  }
  
  public CalendarCard(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
    this.b = paramContext;
  }
  
  public CalendarCard(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
    this.b = paramContext;
  }
  
  public CalendarCard(Context paramContext, b paramb, List<b> paramList)
  {
    super(paramContext);
    this.j = paramb;
    i = new c();
    i.setmList(paramList);
    a(paramContext);
    this.b = paramContext;
  }
  
  private void a()
  {
    b();
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    if ((paramInt1 >= 7) || (paramInt2 >= 6)) {}
    do
    {
      return;
      if (this.m != null) {
        this.h[this.m.e].b[this.m.d] = this.m;
      }
    } while (this.h[paramInt2] == null);
    this.m = new a(this.h[paramInt2].b[paramInt1].a, this.h[paramInt2].b[paramInt1].b, this.h[paramInt2].b[paramInt1].d, this.h[paramInt2].b[paramInt1].e, this.h[paramInt2].b[paramInt1].c);
    c localc = this.h[paramInt2].b[paramInt1].a;
    localc.e = paramInt1;
    localc.setXingqi(a.getCurrentWeekOfMonth(localc.a + "-" + localc.b + "-" + localc.c));
    if ((this.h[paramInt2].b[paramInt1].b == d.i) || (this.h[paramInt2].b[paramInt1].b == d.a))
    {
      this.q = localc;
      showDialog(this.b, "在" + localc.c + "号办理将收取已产生的" + this.h[paramInt2].b[paramInt1].c + "天房租、服务费及生活费用", "确认要在" + localc.c + "号退租吗？");
    }
    for (;;)
    {
      if ((this.h[paramInt2].b[paramInt1].b == d.h) || (this.h[paramInt2].b[paramInt1].b == d.a) || (this.h[paramInt2].b[paramInt1].b == d.f) || (this.h[paramInt2].b[paramInt1].b == d.g) || (this.h[paramInt2].b[paramInt1].b == d.i)) {
        i.d = (localc.a + "-" + localc.b + "-" + localc.c);
      }
      update();
      return;
      this.j.clickDate(localc);
    }
  }
  
  private void a(Context paramContext)
  {
    this.d = new Paint(1);
    this.c = new Paint(1);
    this.c.setStyle(Paint.Style.FILL);
    this.c.setColor(Color.parseColor("#FF8400"));
    this.k = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    a();
  }
  
  private void b()
  {
    this.p = i.getmList();
    a.getCurrentMonthDay();
    int i5 = a.getMonthDays(i.a, i.b - 1);
    int i6 = a.getMonthDays(i.a, i.b);
    int i7 = a.getWeekDayFromDate(i.a, i.b);
    if (a.isCurrentMonth(i)) {}
    int i2 = 0;
    int i1 = 0;
    while (i2 < 6)
    {
      this.h[i2] = new c(i2);
      int i3 = 0;
      if (i3 < 7)
      {
        int i4 = i3 + i2 * 7;
        if ((i4 >= i7) && (i4 < i7 + i6))
        {
          i4 = i1 + 1;
          this.h[i2].b[i3] = new a(c.modifiDayForObject(i, i4), d.b, i3, i2);
          i1 = 0;
          if (i1 < this.p.size())
          {
            a.getIsMonth(((b)this.p.get(i1)).getDate());
            Object localObject = ((b)this.p.get(i1)).getDate().split("-");
            if (a.isCurrentDay(((b)this.p.get(i1)).getDate(), i4, i))
            {
              localObject = new c(Integer.parseInt(localObject[0]), Integer.parseInt(localObject[1]), i4);
              ((c)localObject).setState(((b)this.p.get(i1)).getState());
              if (!a.isCurrentDay(i.d, i4, i)) {
                break label352;
              }
              this.h[i2].b[i3] = new a((c)localObject, d.h, i3, i2);
            }
            for (;;)
            {
              i1 += 1;
              break;
              label352:
              if (((c)localObject).getState() == 1) {
                this.h[i2].b[i3] = new a((c)localObject, d.a, i3, i2, ((b)this.p.get(i1)).getWhichPosInAfter3());
              } else if (((c)localObject).getState() == 2) {
                this.h[i2].b[i3] = new a((c)localObject, d.f, i3, i2);
              } else if (((c)localObject).getState() == 3) {
                this.h[i2].b[i3] = new a((c)localObject, d.g, i3, i2);
              } else if (((c)localObject).getState() == 4) {
                this.h[i2].b[i3] = new a((c)localObject, d.i, i3, i2, ((b)this.p.get(i1)).getWhichPosInAfter3());
              }
            }
          }
          i1 = i4;
        }
        for (;;)
        {
          i3 += 1;
          break;
          if (i4 < i7) {
            this.h[i2].b[i3] = new a(new c(i.a, i.b - 1, i5 - (i7 - i4 - 1)), d.c, i3, i2);
          } else if (i4 >= i7 + i6) {
            this.h[i2].b[i3] = new a(new c(i.a, i.b + 1, i4 - i7 - i6 + 1), d.d, i3, i2);
          }
        }
      }
      i2 += 1;
    }
    this.j.changeDate(i);
  }
  
  public void leftSlide()
  {
    c localc;
    if (i.b == 1)
    {
      i.b = 12;
      localc = i;
      localc.a -= 1;
    }
    for (;;)
    {
      update();
      return;
      localc = i;
      localc.b -= 1;
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int i1 = 0;
    while (i1 < 6)
    {
      if (this.h[i1] != null) {
        this.h[i1].drawCells(paramCanvas);
      }
      i1 += 1;
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.e = paramInt1;
    this.f = paramInt2;
    u.e("width      height", paramInt1 + "        " + paramInt2);
    this.g = Math.min(this.f / 6, this.e / 7);
    if (!this.l) {
      this.l = true;
    }
    this.d.setTextSize(this.g / 3);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return true;
      this.n = paramMotionEvent.getX();
      this.o = paramMotionEvent.getY();
      continue;
      float f1 = paramMotionEvent.getX();
      float f2 = this.n;
      float f3 = paramMotionEvent.getY();
      float f4 = this.o;
      if ((Math.abs(f1 - f2) < this.k) && (Math.abs(f3 - f4) < this.k)) {
        a((int)(this.n / this.g), (int)(this.o / this.g));
      }
    }
  }
  
  public void rightSlide()
  {
    c localc;
    if (i.b == 12)
    {
      i.b = 1;
      localc = i;
      localc.a += 1;
    }
    for (;;)
    {
      update();
      return;
      localc = i;
      localc.b += 1;
    }
  }
  
  public void showDialog(Context paramContext, String paramString1, String paramString2)
  {
    com.ziroom.commonlibrary.widget.unifiedziroom.c.newBuilder(paramContext).setTitle(paramString2).setContent(paramString1).setBtnConfirmText("确定").setBtnCancelText("我再想想").setOnConfirmClickListener(new c.b()
    {
      public void onClick(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        if (paramAnonymousBoolean)
        {
          if (CalendarCard.d(CalendarCard.this) != null) {
            CalendarCard.e(CalendarCard.this).clickDate(CalendarCard.d(CalendarCard.this));
          }
          return;
        }
        CalendarCard.a(CalendarCard.this, null);
      }
    }).build().show();
  }
  
  public void update()
  {
    b();
    invalidate();
  }
  
  class a
  {
    public c a;
    public CalendarCard.d b;
    public int c;
    public int d;
    public int e;
    
    public a(c paramc, CalendarCard.d paramd, int paramInt1, int paramInt2)
    {
      this.a = paramc;
      this.b = paramd;
      this.d = paramInt1;
      this.e = paramInt2;
    }
    
    public a(c paramc, CalendarCard.d paramd, int paramInt1, int paramInt2, int paramInt3)
    {
      this.a = paramc;
      this.b = paramd;
      this.d = paramInt1;
      this.e = paramInt2;
      this.c = paramInt3;
    }
    
    public void drawSelf(Canvas paramCanvas)
    {
      switch (CalendarCard.3.a[this.b.ordinal()])
      {
      }
      for (;;)
      {
        String str = this.a.c + "";
        paramCanvas.drawText(str, (float)((this.d + 0.5D) * CalendarCard.b(CalendarCard.this) - CalendarCard.a(CalendarCard.this).measureText(str) / 2.0F), (float)((this.e + 0.7D) * CalendarCard.b(CalendarCard.this) - CalendarCard.a(CalendarCard.this).measureText(str, 0, 1) / 2.0F), CalendarCard.a(CalendarCard.this));
        return;
        CalendarCard.a(CalendarCard.this).setColor(Color.parseColor("#FF8400"));
        continue;
        CalendarCard.a(CalendarCard.this).setColor(Color.parseColor("#FF6262"));
        continue;
        CalendarCard.a(CalendarCard.this).setColor(Color.parseColor("#ffffff"));
        paramCanvas.drawCircle((float)(CalendarCard.b(CalendarCard.this) * (this.d + 0.5D)), (float)((this.e + 0.5D) * CalendarCard.b(CalendarCard.this)), CalendarCard.b(CalendarCard.this) / 3, CalendarCard.c(CalendarCard.this));
        continue;
        CalendarCard.a(CalendarCard.this).setColor(Color.parseColor("#55aadd"));
        continue;
        CalendarCard.a(CalendarCard.this).setColor(Color.parseColor("#000000"));
        continue;
        CalendarCard.a(CalendarCard.this).setColor(-16777216);
        CalendarCard.a(CalendarCard.this).setColor(Color.parseColor("#a3a3a3"));
        continue;
        CalendarCard.a(CalendarCard.this).setColor(Color.parseColor("#f5f4f9"));
        continue;
        CalendarCard.a(CalendarCard.this).setColor(-7829368);
      }
    }
  }
  
  public static abstract interface b
  {
    public abstract void changeDate(c paramc);
    
    public abstract void clickDate(c paramc);
  }
  
  class c
  {
    public int a;
    public CalendarCard.a[] b = new CalendarCard.a[7];
    
    c(int paramInt)
    {
      this.a = paramInt;
    }
    
    public void drawCells(Canvas paramCanvas)
    {
      int i = 0;
      while (i < this.b.length)
      {
        if (this.b[i] != null) {
          this.b[i].drawSelf(paramCanvas);
        }
        i += 1;
      }
    }
  }
  
  static enum d
  {
    private d() {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/termination/view/CalendarCard.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */