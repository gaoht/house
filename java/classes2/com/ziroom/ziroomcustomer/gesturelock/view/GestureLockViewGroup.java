package com.ziroom.ziroomcustomer.gesturelock.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Point;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.ziroom.ziroomcustomer.R.styleable;
import com.ziroom.ziroomcustomer.gesturelock.view.a.b;
import com.ziroom.ziroomcustomer.gesturelock.view.a.c;
import com.ziroom.ziroomcustomer.gesturelock.view.a.d;
import com.ziroom.ziroomcustomer.gesturelock.view.a.e;
import com.ziroom.ziroomcustomer.minsu.f.ab;
import com.ziroom.ziroomcustomer.util.ac;
import com.ziroom.ziroomcustomer.util.ah;
import java.util.ArrayList;
import java.util.List;

public class GestureLockViewGroup
  extends RelativeLayout
{
  public static boolean a = false;
  private a A;
  private boolean B = false;
  private boolean C = false;
  private boolean D = true;
  private boolean E = false;
  private String F = "";
  private int G;
  public boolean b;
  c c;
  d d;
  private GestureLockView[] e;
  private int f = 3;
  private String g = "";
  private List<Integer> h = new ArrayList();
  private String i = "";
  private Paint j;
  private int k = 30;
  private int l;
  private int m = -13135927;
  private int n = -1305185;
  private int o = -7218086;
  private int p = -65536;
  private int q;
  private int r;
  private Path s;
  private int t;
  private int u;
  private Point v = new Point();
  private int w = -1;
  private b x;
  private com.ziroom.ziroomcustomer.gesturelock.view.a.a y;
  private e z;
  
  public GestureLockViewGroup(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public GestureLockViewGroup(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.GestureLockViewGroup, paramInt, 0);
    this.m = paramContext.getColor(3, this.m);
    this.n = paramContext.getColor(0, this.n);
    this.o = paramContext.getColor(1, this.o);
    this.p = paramContext.getColor(2, this.p);
    this.f = paramContext.getInt(4, this.f);
    paramContext.recycle();
    loadPasswordStatus();
    this.j = new Paint(1);
    this.j.setStyle(Paint.Style.STROKE);
    this.j.setStrokeCap(Paint.Cap.ROUND);
    this.j.setStrokeJoin(Paint.Join.ROUND);
    this.s = new Path();
    this.G = ab.dp2px(getContext(), 1.0F);
  }
  
  private void a()
  {
    if (this.e == null)
    {
      this.e = new GestureLockView[this.f * this.f];
      this.j.setStrokeWidth(this.G * 2);
      int i1 = 0;
      if (i1 < this.e.length)
      {
        this.e[i1] = new GestureLockView(getContext(), this.m, this.n, this.o, this.p);
        this.e[i1].setId(i1 + 1);
        RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(this.l, this.l);
        if (i1 % this.f != 0) {
          localLayoutParams.addRule(1, this.e[(i1 - 1)].getId());
        }
        if (i1 > this.f - 1) {
          localLayoutParams.addRule(3, this.e[(i1 - this.f)].getId());
        }
        int i2;
        if ((i1 + 1) % this.f != 0)
        {
          i2 = this.k;
          label182:
          if (i1 >= (this.f - 1) * this.f) {
            break label247;
          }
        }
        label247:
        for (int i3 = this.k;; i3 = 0)
        {
          localLayoutParams.setMargins(0, 0, i2, i3);
          this.e[i1].setMode(GestureLockView.a.a);
          addView(this.e[i1], localLayoutParams);
          i1 += 1;
          break;
          i2 = 0;
          break label182;
        }
      }
    }
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    this.j.setColor(this.n);
    GestureLockView localGestureLockView = b(paramInt1, paramInt2);
    int i1;
    if (localGestureLockView != null)
    {
      i1 = localGestureLockView.getId();
      if (!this.h.contains(Integer.valueOf(i1)))
      {
        this.h.add(Integer.valueOf(i1));
        this.i += i1 - 1;
        localGestureLockView.setMode(GestureLockView.a.b);
        this.t = (localGestureLockView.getLeft() / 2 + localGestureLockView.getRight() / 2);
        i1 = localGestureLockView.getTop() / 2;
        this.u = (localGestureLockView.getBottom() / 2 + i1);
        if (this.h.size() != 1) {
          break label182;
        }
        this.s.moveTo(this.t, this.u);
      }
    }
    for (;;)
    {
      this.v.x = paramInt1;
      this.v.y = paramInt2;
      return;
      label182:
      this.s.lineTo(this.t, this.u);
      a = true;
      i1 = ((Integer)this.h.get(this.h.size() - 2)).intValue();
      int i2 = ((Integer)this.h.get(this.h.size() - 1)).intValue();
      localGestureLockView = (GestureLockView)findViewById(i1);
      a(localGestureLockView, (GestureLockView)findViewById(i2));
      localGestureLockView.invalidate();
    }
  }
  
  private void a(GestureLockView paramGestureLockView1, GestureLockView paramGestureLockView2)
  {
    int i1 = paramGestureLockView2.getLeft();
    int i2 = paramGestureLockView1.getLeft();
    paramGestureLockView1.setArrowDegree((int)Math.toDegrees(Math.atan2(paramGestureLockView2.getTop() - paramGestureLockView1.getTop(), i1 - i2)) + 90);
  }
  
  private boolean a(View paramView, int paramInt1, int paramInt2)
  {
    int i1 = (int)(this.l * 0.15D);
    return (paramInt1 >= paramView.getLeft() + i1) && (paramInt1 <= paramView.getRight() - i1) && (paramInt2 >= paramView.getTop() + i1) && (paramInt2 <= paramView.getBottom() - i1);
  }
  
  private GestureLockView b(int paramInt1, int paramInt2)
  {
    GestureLockView[] arrayOfGestureLockView = this.e;
    int i2 = arrayOfGestureLockView.length;
    int i1 = 0;
    while (i1 < i2)
    {
      GestureLockView localGestureLockView = arrayOfGestureLockView[i1];
      if (a(localGestureLockView, paramInt1, paramInt2)) {
        return localGestureLockView;
      }
      i1 += 1;
    }
    return null;
  }
  
  private void b()
  {
    if (a) {
      this.j.setColor(this.o);
    }
    for (;;)
    {
      Log.d("GestureLockViewGroup", "mChoose = " + this.h);
      this.v.x = this.t;
      this.v.y = this.u;
      d();
      int i1 = 0;
      while (i1 + 1 < this.h.size())
      {
        int i2 = ((Integer)this.h.get(i1)).intValue();
        int i3 = ((Integer)this.h.get(i1 + 1)).intValue();
        a((GestureLockView)findViewById(i2), (GestureLockView)findViewById(i3));
        i1 += 1;
      }
      this.b = true;
      this.j.setColor(this.p);
    }
  }
  
  private void c()
  {
    if (this.D) {
      if (this.x.onFirstInputComplete(this.i.length()))
      {
        if (this.c != null) {
          this.c.drawCurrentPath(this.i);
        }
        this.F = this.i;
        this.D = false;
      }
    }
    for (;;)
    {
      e();
      return;
      if (this.F.equals(this.i))
      {
        this.x.onSuccess();
        this.C = false;
      }
      else
      {
        this.x.onFail();
      }
    }
  }
  
  private void d()
  {
    GestureLockView[] arrayOfGestureLockView = this.e;
    int i2 = arrayOfGestureLockView.length;
    int i1 = 0;
    while (i1 < i2)
    {
      GestureLockView localGestureLockView = arrayOfGestureLockView[i1];
      if (this.h.contains(Integer.valueOf(localGestureLockView.getId()))) {
        localGestureLockView.setMode(GestureLockView.a.c);
      }
      i1 += 1;
    }
  }
  
  private void e()
  {
    int i1 = 0;
    this.h.clear();
    this.i = "";
    this.s.reset();
    this.b = false;
    if (this.e != null)
    {
      GestureLockView[] arrayOfGestureLockView = this.e;
      int i2 = arrayOfGestureLockView.length;
      while (i1 < i2)
      {
        GestureLockView localGestureLockView = arrayOfGestureLockView[i1];
        localGestureLockView.setMode(GestureLockView.a.a);
        localGestureLockView.setArrowDegree(-1);
        i1 += 1;
      }
    }
    this.d.onReset();
  }
  
  public boolean checkAnswer()
  {
    if (this.g.equals(ah.MD5Encode(this.i))) {
      return true;
    }
    if (this.E) {
      this.w -= 1;
    }
    return false;
  }
  
  public void clearLocalPwdInfo()
  {
    removePassword();
    this.A.clear();
    this.D = true;
    resetView();
  }
  
  public void dispatchDraw(Canvas paramCanvas)
  {
    super.dispatchDraw(paramCanvas);
    if (this.s != null) {
      paramCanvas.drawPath(this.s, this.j);
    }
    if ((this.h.size() > 0) && (this.t != 0) && (this.u != 0)) {
      paramCanvas.drawLine(this.t, this.u, this.v.x, this.v.y, this.j);
    }
  }
  
  public String getPassword()
  {
    return this.i;
  }
  
  public boolean isSetPassword()
  {
    return this.B;
  }
  
  public void loadPasswordStatus()
  {
    boolean bool2 = true;
    if (this.A == null) {
      this.A = new a(getContext(), -1);
    }
    this.g = this.A.ReadStringPreference();
    Log.d("GestureLockViewGroup", "password now is : " + this.g);
    if (!this.g.equals("null"))
    {
      bool1 = true;
      this.B = bool1;
      if (this.B) {
        break label106;
      }
    }
    label106:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.C = bool1;
      return;
      bool1 = false;
      break;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    this.q = ac.getScreenWidth(getContext());
    this.r = ac.getScreenHeight(getContext());
    if (this.q < this.r) {}
    for (paramInt1 = this.q;; paramInt1 = this.r)
    {
      this.q = paramInt1;
      this.r = paramInt1;
      this.l = ((int)(this.r / (this.f * 2 + 0.5D)));
      this.k = ((int)(this.l * 0.65D));
      paramInt1 = this.l * this.f + this.k * (this.f - 1);
      setMeasuredDimension(paramInt1, paramInt1);
      a();
      return;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i1 = paramMotionEvent.getAction();
    int i2 = (int)paramMotionEvent.getX();
    int i3 = (int)paramMotionEvent.getY();
    if ((this.w <= 0) && (this.E)) {
      return true;
    }
    switch (i1)
    {
    default: 
    case 0: 
    case 2: 
      for (;;)
      {
        label60:
        invalidate();
        return true;
        e();
        continue;
        a(i2, i3);
      }
    }
    if (this.C) {
      if (this.x != null) {
        c();
      }
    }
    for (;;)
    {
      b();
      break label60;
      if (this.h.size() <= 0) {
        break;
      }
      a = checkAnswer();
      if (this.y != null) {
        this.y.onGestureEvent(a);
      }
      if (this.w == 0) {
        this.z.onUnmatchedExceedBoundary();
      }
    }
  }
  
  public void removePassword()
  {
    this.A.WriteStringPreference("null");
    this.B = false;
    this.D = true;
    this.C = true;
  }
  
  public void resetView()
  {
    e();
    invalidate();
  }
  
  public void savePassword(String paramString)
  {
    this.g = paramString;
    this.A.WriteStringPreference(ah.MD5Encode(paramString));
  }
  
  public void setCurrentPathListener(c paramc)
  {
    this.c = paramc;
  }
  
  public void setGestureEventListener(com.ziroom.ziroomcustomer.gesturelock.view.a.a parama)
  {
    this.y = parama;
  }
  
  public void setGesturePasswordSettingListener(b paramb)
  {
    this.x = paramb;
  }
  
  public void setGestureUnmatchedExceedListener(int paramInt, e parame)
  {
    this.E = true;
    this.w = paramInt;
    this.z = parame;
  }
  
  public void setResetListener(d paramd)
  {
    this.d = paramd;
  }
  
  public void setRetryTimes(int paramInt)
  {
    this.w = paramInt;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/gesturelock/view/GestureLockViewGroup.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */