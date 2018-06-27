package cn.testin.analysis;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.Context;
import android.graphics.BlurMaskFilter;
import android.graphics.BlurMaskFilter.Blur;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.Style;
import android.os.IBinder;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import com.growingio.android.sdk.agent.VdsAgent;

@TargetApi(11)
public class ba
  extends View
  implements View.OnTouchListener, bk, bl
{
  private static ba a;
  private WindowManager.LayoutParams b;
  private WindowManager c;
  private cu d;
  private boolean e;
  private boolean f;
  private float g;
  private float h;
  private int i = -1;
  private int j = -1;
  private int k;
  private int l;
  private int m;
  private int n;
  private int o;
  private int p;
  private int q;
  private int r;
  private Paint s;
  private Activity t;
  private bd u;
  private BlurMaskFilter v;
  
  private ba(Context paramContext)
  {
    super(paramContext);
    setLayerType(1, null);
    this.n = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    setOnTouchListener(this);
    this.o = al.a(paramContext, 16.0F);
    this.p = Color.parseColor("#1081DE");
    this.q = Color.parseColor("#0BBA8B");
    this.s = new Paint();
    this.s.setAntiAlias(true);
    this.s.setTextSize(this.o);
    int i1 = al.a(paramContext, 3.0F);
    this.v = new BlurMaskFilter(i1, BlurMaskFilter.Blur.SOLID);
    this.m = al.a(paramContext, 3.0F);
    this.k = ((int)(this.s.measureText("Testin") / 2.0F + al.a(paramContext, 3.0F)) + this.m);
    this.l = (i1 + this.k);
    this.r = 0;
  }
  
  public static ba a(Context paramContext, cu paramcu)
  {
    if ((a == null) && (paramContext != null) && (paramcu != null))
    {
      a = new ba(paramContext);
      a.d = paramcu;
    }
    return a;
  }
  
  public static void a(Activity paramActivity)
  {
    if ((paramActivity == null) || (paramActivity.getClass() == TesterActivity.class)) {}
    while ((a == null) || (a.getParent() != null)) {
      return;
    }
    a.t = paramActivity;
    a.b = new WindowManager.LayoutParams();
    a.b.type = 1003;
    a.b.format = 1;
    a.b.flags = 8;
    a.b.gravity = 51;
    if ((a.i < 0) || (a.i > al.i(paramActivity))) {
      a.i = (al.i(paramActivity) - a.l * 2);
    }
    if ((a.j < 0) || (a.j > al.j(paramActivity))) {
      a.j = al.a(paramActivity, 30.0F);
    }
    a.b.width = (a.l * 2);
    a.b.height = (a.l * 2);
    a.b.x = a.i;
    a.b.y = a.j;
    a.c = paramActivity.getWindowManager();
    View localView = paramActivity.getWindow().getDecorView();
    IBinder localIBinder = localView.getWindowToken();
    if (localIBinder == null)
    {
      paramActivity.getWindow().getDecorView().post(new bb(localView));
      return;
    }
    try
    {
      a.b.token = localIBinder;
      a.c.addView(a, a.b);
      return;
    }
    catch (Exception paramActivity)
    {
      ar.b(paramActivity);
    }
  }
  
  private void a(Canvas paramCanvas)
  {
    this.s.setMaskFilter(this.v);
    this.s.setStyle(Paint.Style.FILL);
    this.s.setColor(this.p);
    paramCanvas.drawCircle(this.l, this.l, this.k, this.s);
  }
  
  public static void b(Activity paramActivity)
  {
    if ((paramActivity == null) || (paramActivity.getClass() == TesterActivity.class)) {}
    while (a == null) {
      return;
    }
    try
    {
      if (a.getParent() != null) {
        paramActivity.getWindowManager().removeViewImmediate(a);
      }
      return;
    }
    catch (Exception paramActivity)
    {
      ar.b(paramActivity);
      return;
    }
    finally
    {
      a.c = null;
      a.t = null;
    }
  }
  
  private void b(Canvas paramCanvas)
  {
    if (this.r == 2)
    {
      this.s.setStrokeWidth(this.m);
      this.s.setMaskFilter(null);
      this.s.setColor(this.q);
      this.s.setStyle(Paint.Style.STROKE);
      paramCanvas.drawCircle(this.l, this.l, this.k - this.m / 2, this.s);
    }
  }
  
  private void c()
  {
    if (this.u == null)
    {
      this.u = new bd();
      this.u.a(this.d);
      this.u.a(this);
      this.u.a(this);
      this.d.a(this.u);
    }
    bd localbd = this.u;
    FragmentManager localFragmentManager = this.t.getFragmentManager();
    if (!(localbd instanceof DialogFragment)) {
      localbd.show(localFragmentManager, "switchFragment");
    }
    for (;;)
    {
      setVisibility(8);
      return;
      VdsAgent.showDialogFragment((DialogFragment)localbd, localFragmentManager, "switchFragment");
    }
  }
  
  private void c(Canvas paramCanvas)
  {
    this.s.setStrokeWidth(0.0F);
    this.s.setMaskFilter(null);
    this.s.setColor(-1);
    this.s.setFakeBoldText(true);
    this.s.setTextSize(this.o);
    this.s.setStyle(Paint.Style.FILL);
    Paint.FontMetrics localFontMetrics = this.s.getFontMetrics();
    float f1 = this.l;
    float f2 = (-localFontMetrics.ascent - localFontMetrics.descent) / 2.0F;
    paramCanvas.drawText("Testin", this.l - this.s.measureText("Testin") / 2.0F, f2 + f1, this.s);
  }
  
  public void a()
  {
    setVisibility(0);
  }
  
  public void a(int paramInt)
  {
    this.r = paramInt;
    if (isShown()) {
      postInvalidate();
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    a(paramCanvas);
    b(paramCanvas);
    c(paramCanvas);
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    boolean bool = true;
    if ((this.b != null) && (this.c != null))
    {
      switch (paramMotionEvent.getAction())
      {
      default: 
        bool = false;
      case 0: 
      case 2: 
      case 1: 
        do
        {
          float f1;
          float f2;
          do
          {
            return bool;
            this.g = paramMotionEvent.getRawX();
            this.h = paramMotionEvent.getRawY();
            this.e = false;
            return true;
            f1 = paramMotionEvent.getRawX() - this.g;
            f2 = paramMotionEvent.getRawY() - this.h;
            if ((!this.e) && (!this.f) && ((Math.abs(f1) > this.n) || (Math.abs(f2) > this.n))) {
              this.e = true;
            }
          } while (!this.e);
          paramView = this.b;
          int i1 = this.i;
          paramView.x = ((int)f1 + i1);
          paramView = this.b;
          i1 = this.j;
          paramView.y = ((int)f2 + i1);
          this.c.updateViewLayout(this, this.b);
          return true;
          if (this.e)
          {
            this.i = this.b.x;
            this.j = this.b.y;
            return true;
          }
        } while (this.f);
        c();
        return true;
      }
      this.e = false;
      this.f = false;
      return true;
    }
    return false;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/testin/analysis/ba.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */