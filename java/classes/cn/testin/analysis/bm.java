package cn.testin.analysis;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.Style;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;

public class bm
  extends View
  implements View.OnClickListener
{
  private final float a = 3.0F;
  private Paint b;
  private TextPaint c;
  private bn d;
  private Shader e;
  private Matrix f;
  private int g;
  private int h;
  private int i;
  private int j;
  private int k;
  private int l;
  private int m;
  private int n;
  private float o;
  private String p;
  
  public bm(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    this.i = 0;
    this.g = al.a(paramContext, 40.0F);
    this.o = al.a(paramContext, 4.0F);
    this.h = al.a(paramContext, 4.0F);
    int i1 = this.g + this.h / 2;
    this.m = i1;
    this.l = i1;
    this.j = Color.parseColor("#1081DE");
    this.k = Color.parseColor("#0BBA8B");
    this.b = new Paint();
    this.b.setAntiAlias(true);
    this.b.setStrokeWidth(this.h);
    this.b.setColor(Color.parseColor("#1081DE"));
    this.c = new TextPaint();
    this.c.setTextSize(al.a(paramContext, 15.0F));
    this.c.setColor(-1);
    this.c.setAntiAlias(true);
    setOnClickListener(this);
  }
  
  private void a(Canvas paramCanvas)
  {
    this.b.setStyle(Paint.Style.FILL);
    this.b.setColor(this.j);
    this.b.setShader(null);
    paramCanvas.drawCircle(this.l, this.m, this.g, this.b);
  }
  
  private void b(Canvas paramCanvas)
  {
    if (this.i == 1)
    {
      this.f.setRotate(this.n, this.l, this.m);
      this.e.setLocalMatrix(this.f);
      this.b.setShader(this.e);
      this.b.setColor(this.k);
      this.b.setStyle(Paint.Style.STROKE);
      paramCanvas.drawCircle(this.l, this.m, this.g, this.b);
      this.n = ((int)(this.n + 3.0F));
      invalidate();
    }
    while (this.i != 2) {
      return;
    }
    this.b.setColor(this.k);
    this.b.setStyle(Paint.Style.STROKE);
    paramCanvas.drawCircle(this.l, this.m, this.g, this.b);
  }
  
  private void c(Canvas paramCanvas)
  {
    if (!TextUtils.isEmpty(this.p))
    {
      Paint.FontMetrics localFontMetrics = this.c.getFontMetrics();
      float f1 = this.l - (localFontMetrics.bottom - localFontMetrics.top) / 2.0F;
      if (this.p.contains("\n")) {
        f1 = this.m - (localFontMetrics.bottom - localFontMetrics.top) - this.o / 2.0F;
      }
      paramCanvas.save();
      paramCanvas.translate(0.0F, f1);
      new StaticLayout(this.p, this.c, this.g * 2 + this.h, Layout.Alignment.ALIGN_CENTER, 1.0F, this.o, true).draw(paramCanvas);
      paramCanvas.restore();
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    this.i = paramInt;
    this.p = paramString;
    if (paramInt == 1)
    {
      this.n = 0;
      if (this.f == null) {
        this.f = new Matrix();
      }
      if (this.e == null) {
        this.e = new SweepGradient(this.l, this.m, new int[] { -1, this.k, this.k, -1 }, new float[] { 0.0F, 0.75F, 0.95F, 1.0F });
      }
    }
    invalidate();
  }
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    if (this.d != null) {
      this.d.a(paramView, this.i);
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    a(paramCanvas);
    b(paramCanvas);
    c(paramCanvas);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    setMeasuredDimension(this.g * 2 + this.h, this.g * 2 + this.h);
  }
  
  public void setOnSwitchClickListener(bn parambn)
  {
    this.d = parambn;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/testin/analysis/bm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */