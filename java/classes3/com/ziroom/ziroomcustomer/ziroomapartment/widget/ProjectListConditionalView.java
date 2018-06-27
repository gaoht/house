package com.ziroom.ziroomcustomer.ziroomapartment.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.drawable.Drawable;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.util.m;
import com.ziroom.ziroomcustomer.ziroomapartment.dialog.ZryuCityListPop;
import com.ziroom.ziroomcustomer.ziroomapartment.dialog.ZryuCityListPop.b;
import com.ziroom.ziroomcustomer.ziroomapartment.dialog.ZryuDateListPop;
import com.ziroom.ziroomcustomer.ziroomapartment.dialog.ZryuDateListPop.a;
import com.ziroom.ziroomcustomer.ziroomapartment.dialog.ZryuPriceListPop;
import com.ziroom.ziroomcustomer.ziroomapartment.dialog.ZryuPriceListPop.a;
import com.ziroom.ziroomcustomer.ziroomapartment.model.ZryuSearchConditionV2;
import com.ziroom.ziroomcustomer.ziroomapartment.model.ZryuSearchConditionV2.CityListBean;
import com.ziroom.ziroomcustomer.ziroomapartment.model.ZryuSearchConditionV2.PriceBean;
import java.util.Date;
import java.util.List;

public class ProjectListConditionalView
  extends LinearLayout
  implements View.OnClickListener
{
  public static int a;
  private static String g = "";
  private Context b;
  private float c;
  private final int d = -1;
  private int e = -1;
  private String[] f = { "城市", "租金", "入住时间" };
  private ZryuCityListPop h;
  private ZryuPriceListPop i;
  private ZryuDateListPop j;
  private TextView k;
  private TextView l;
  private TextView m;
  private String n;
  private String o;
  private String p;
  private ZryuSearchConditionV2 q;
  private String r = "";
  private String s = "";
  private a t;
  
  public ProjectListConditionalView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ProjectListConditionalView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ProjectListConditionalView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.b = paramContext;
    this.c = this.b.getResources().getDisplayMetrics().density;
    a();
  }
  
  private void a()
  {
    setOrientation(0);
    setBackgroundColor(this.b.getResources().getColor(2131624583));
    int i1 = 0;
    while (i1 < this.f.length)
    {
      View localView = b();
      localView.setTag(this.f[i1]);
      ((TextView)localView).setText(this.f[i1]);
      localView.setOnClickListener(this);
      addView(localView);
      if (i1 != this.f.length - 1)
      {
        localView = new View(this.b);
        localView.setBackgroundColor(Color.parseColor("#dddddd"));
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams((int)(0.5D * this.c), -1);
        localLayoutParams.topMargin = ((int)(this.c * 14.0F));
        localLayoutParams.bottomMargin = ((int)(this.c * 14.0F));
        localView.setLayoutParams(localLayoutParams);
        addView(localView);
      }
      i1 += 1;
    }
    this.k = ((TextView)getChildAt(0));
    this.l = ((TextView)getChildAt(2));
    this.m = ((TextView)getChildAt(4));
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    if (((paramInt1 == 0) && (paramInt2 == 0)) || ((paramInt1 == 0) && (paramInt2 == a)))
    {
      this.p = "不限";
      this.l.setText(this.f[1]);
      this.l.setTextColor(this.b.getResources().getColor(2131624415));
      return;
    }
    if ((paramInt1 != 0) && ((paramInt2 == 0) || (paramInt2 == a)))
    {
      this.p = ("¥" + paramInt1 + "元以上");
      this.l.setText(this.p);
      this.l.setTextColor(this.b.getResources().getColor(2131624415));
      return;
    }
    if ((paramInt1 == 0) && (paramInt2 != 0) && (paramInt2 != a))
    {
      this.p = ("¥" + paramInt2 + "元以下");
      this.l.setText(this.p);
      this.l.setTextColor(this.b.getResources().getColor(2131624415));
      return;
    }
    this.p = ("¥" + paramInt1 + " - ¥" + paramInt2);
    this.l.setText(this.p);
    this.l.setTextColor(this.b.getResources().getColor(2131624415));
  }
  
  private void a(TextView paramTextView)
  {
    setSelectStyle(0, paramTextView);
    d();
  }
  
  private View b()
  {
    TextView localTextView = new TextView(this.b);
    localTextView.setSingleLine();
    localTextView.setGravity(17);
    localTextView.setEllipsize(TextUtils.TruncateAt.END);
    localTextView.setTextColor(this.b.getResources().getColor(2131624415));
    Object localObject = getResources().getDrawable(2130837621);
    ((Drawable)localObject).setBounds(0, 0, (int)(6.0F * this.c), (int)(4.0F * this.c));
    localTextView.setCompoundDrawables(null, null, (Drawable)localObject, null);
    localTextView.setPadding((int)(12.0F * this.c), 0, (int)(8.0F * this.c), 0);
    localObject = new LinearLayout.LayoutParams(0, -1);
    ((LinearLayout.LayoutParams)localObject).weight = 1.0F;
    localTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    return localTextView;
  }
  
  private void b(TextView paramTextView)
  {
    setSelectStyle(1, paramTextView);
    e();
  }
  
  private void c()
  {
    if (this.j == null)
    {
      this.j = new ZryuDateListPop(this.b);
      f();
    }
    if (this.j.isShowing())
    {
      this.j.dismiss();
      return;
    }
    this.j.show(this.m, this.q.checkInDate);
  }
  
  private void c(TextView paramTextView)
  {
    setSelectStyle(2, paramTextView);
    c();
  }
  
  private void d()
  {
    if (this.h == null)
    {
      this.h = new ZryuCityListPop(this.b);
      g();
    }
    if (this.h.isShowing())
    {
      this.h.dismiss();
      return;
    }
    List localList = this.q.cityList;
    this.h.show(this.k, localList, this.q.selectCityIndex);
  }
  
  private void e()
  {
    if (this.i == null)
    {
      this.i = new ZryuPriceListPop(this.b);
      h();
    }
    if (this.i.isShowing())
    {
      this.i.dismiss();
      return;
    }
    List localList = this.q.priceRangeList;
    this.i.show(this.l, localList, this.q.priceBean.minPrice, this.q.priceBean.maxPrice, this.f[1].equals(this.l.getText().toString()), a);
  }
  
  private void f()
  {
    this.j.setPopDismisListener(new b()
    {
      public void onDismiss()
      {
        ProjectListConditionalView.a(ProjectListConditionalView.this).setSelected(false);
        ProjectListConditionalView.a(ProjectListConditionalView.this, -1);
      }
    });
    this.j.setOnSelectListener(new ZryuDateListPop.a()
    {
      public void select(Date paramAnonymousDate, boolean paramAnonymousBoolean)
      {
        if (paramAnonymousBoolean) {
          if (ProjectListConditionalView.b(ProjectListConditionalView.this) != null)
          {
            ProjectListConditionalView.b(ProjectListConditionalView.this).checkInDate = paramAnonymousDate;
            ProjectListConditionalView.a(ProjectListConditionalView.this, m.getFormatDate(ProjectListConditionalView.b(ProjectListConditionalView.this).checkInDate, m.b));
            ProjectListConditionalView.a(ProjectListConditionalView.this).setText(ProjectListConditionalView.c(ProjectListConditionalView.this));
            ProjectListConditionalView.a(ProjectListConditionalView.this).setTextColor(ProjectListConditionalView.d(ProjectListConditionalView.this).getResources().getColor(2131624415));
            if ((ProjectListConditionalView.c(ProjectListConditionalView.this) == null) || (ProjectListConditionalView.c(ProjectListConditionalView.this).length() <= 4)) {
              break label157;
            }
            ProjectListConditionalView.a(ProjectListConditionalView.this).setGravity(33);
          }
        }
        label157:
        label304:
        for (;;)
        {
          if (ProjectListConditionalView.f(ProjectListConditionalView.this) != null) {
            ProjectListConditionalView.f(ProjectListConditionalView.this).getData(ProjectListConditionalView.b(ProjectListConditionalView.this));
          }
          return;
          ProjectListConditionalView.a(ProjectListConditionalView.this).setGravity(17);
          continue;
          ProjectListConditionalView.a(ProjectListConditionalView.this, ProjectListConditionalView.e(ProjectListConditionalView.this)[2]);
          ProjectListConditionalView.a(ProjectListConditionalView.this).setText(ProjectListConditionalView.c(ProjectListConditionalView.this));
          ProjectListConditionalView.a(ProjectListConditionalView.this).setTextColor(ProjectListConditionalView.d(ProjectListConditionalView.this).getResources().getColor(2131624415));
          if ((ProjectListConditionalView.c(ProjectListConditionalView.this) != null) && (ProjectListConditionalView.c(ProjectListConditionalView.this).length() > 4)) {
            ProjectListConditionalView.a(ProjectListConditionalView.this).setGravity(33);
          }
          for (;;)
          {
            if (ProjectListConditionalView.b(ProjectListConditionalView.this) == null) {
              break label304;
            }
            ProjectListConditionalView.b(ProjectListConditionalView.this).checkInDate = paramAnonymousDate;
            break;
            ProjectListConditionalView.a(ProjectListConditionalView.this).setGravity(17);
          }
        }
      }
    });
  }
  
  private void g()
  {
    this.h.setPopDismisListener(new b()
    {
      public void onDismiss()
      {
        ProjectListConditionalView.g(ProjectListConditionalView.this).setSelected(false);
        ProjectListConditionalView.a(ProjectListConditionalView.this, -1);
      }
    });
    this.h.setOnSelectListener(new ZryuCityListPop.b()
    {
      public void select(int paramAnonymousInt, boolean paramAnonymousBoolean)
      {
        if (paramAnonymousBoolean) {
          if ((ProjectListConditionalView.b(ProjectListConditionalView.this) != null) && (ProjectListConditionalView.b(ProjectListConditionalView.this).cityList != null) && (ProjectListConditionalView.b(ProjectListConditionalView.this).cityList.size() > paramAnonymousInt))
          {
            ProjectListConditionalView.b(ProjectListConditionalView.this).selectCityIndex = paramAnonymousInt;
            ProjectListConditionalView.b(ProjectListConditionalView.this, ((ZryuSearchConditionV2.CityListBean)ProjectListConditionalView.b(ProjectListConditionalView.this).cityList.get(paramAnonymousInt)).cityName);
            ProjectListConditionalView.g(ProjectListConditionalView.this).setText(ProjectListConditionalView.h(ProjectListConditionalView.this));
            ProjectListConditionalView.g(ProjectListConditionalView.this).setTextColor(ProjectListConditionalView.d(ProjectListConditionalView.this).getResources().getColor(2131624415));
            if ((ProjectListConditionalView.h(ProjectListConditionalView.this) == null) || (ProjectListConditionalView.h(ProjectListConditionalView.this).length() <= 4)) {
              break label195;
            }
            ProjectListConditionalView.g(ProjectListConditionalView.this).setGravity(19);
          }
        }
        label195:
        label374:
        for (;;)
        {
          if (ProjectListConditionalView.f(ProjectListConditionalView.this) != null) {
            ProjectListConditionalView.f(ProjectListConditionalView.this).getData(ProjectListConditionalView.b(ProjectListConditionalView.this));
          }
          return;
          ProjectListConditionalView.g(ProjectListConditionalView.this).setGravity(17);
          continue;
          ProjectListConditionalView.b(ProjectListConditionalView.this, ProjectListConditionalView.e(ProjectListConditionalView.this)[0]);
          ProjectListConditionalView.g(ProjectListConditionalView.this).setText(ProjectListConditionalView.h(ProjectListConditionalView.this));
          ProjectListConditionalView.g(ProjectListConditionalView.this).setTextColor(ProjectListConditionalView.d(ProjectListConditionalView.this).getResources().getColor(2131624415));
          if ((ProjectListConditionalView.h(ProjectListConditionalView.this) != null) && (ProjectListConditionalView.h(ProjectListConditionalView.this).length() > 4)) {
            ProjectListConditionalView.g(ProjectListConditionalView.this).setGravity(19);
          }
          for (;;)
          {
            if ((ProjectListConditionalView.b(ProjectListConditionalView.this) == null) || (ProjectListConditionalView.b(ProjectListConditionalView.this).cityList == null) || (ProjectListConditionalView.b(ProjectListConditionalView.this).cityList.size() <= paramAnonymousInt)) {
              break label374;
            }
            ProjectListConditionalView.b(ProjectListConditionalView.this).selectCityIndex = paramAnonymousInt;
            break;
            ProjectListConditionalView.g(ProjectListConditionalView.this).setGravity(17);
          }
        }
      }
    });
  }
  
  private void h()
  {
    this.i.setPopDismisListener(new b()
    {
      public void onDismiss()
      {
        ProjectListConditionalView.i(ProjectListConditionalView.this).setSelected(false);
        ProjectListConditionalView.a(ProjectListConditionalView.this, -1);
      }
    });
    this.i.setOnSelectListener(new ZryuPriceListPop.a()
    {
      public void select(int paramAnonymousInt1, int paramAnonymousInt2, boolean paramAnonymousBoolean)
      {
        if (paramAnonymousBoolean)
        {
          ProjectListConditionalView.a(ProjectListConditionalView.this, paramAnonymousInt1, paramAnonymousInt2);
          if ((ProjectListConditionalView.j(ProjectListConditionalView.this) == null) || (ProjectListConditionalView.j(ProjectListConditionalView.this).length() <= 4)) {
            break label169;
          }
          ProjectListConditionalView.i(ProjectListConditionalView.this).setGravity(19);
        }
        for (;;)
        {
          ProjectListConditionalView.b(ProjectListConditionalView.this).priceBean.minPrice = paramAnonymousInt1;
          ProjectListConditionalView.b(ProjectListConditionalView.this).priceBean.maxPrice = paramAnonymousInt2;
          if (ProjectListConditionalView.f(ProjectListConditionalView.this) != null) {
            ProjectListConditionalView.f(ProjectListConditionalView.this).getData(ProjectListConditionalView.b(ProjectListConditionalView.this));
          }
          return;
          ProjectListConditionalView.c(ProjectListConditionalView.this, ProjectListConditionalView.e(ProjectListConditionalView.this)[1]);
          ProjectListConditionalView.i(ProjectListConditionalView.this).setText(ProjectListConditionalView.j(ProjectListConditionalView.this));
          ProjectListConditionalView.i(ProjectListConditionalView.this).setTextColor(ProjectListConditionalView.d(ProjectListConditionalView.this).getResources().getColor(2131624415));
          break;
          label169:
          ProjectListConditionalView.i(ProjectListConditionalView.this).setGravity(17);
        }
      }
    });
  }
  
  public void dismissAllPop()
  {
    if ((this.h != null) && (this.h.isShowing())) {
      this.h.dismiss();
    }
    if ((this.i != null) && (this.i.isShowing())) {
      this.i.dismiss();
    }
    if ((this.j != null) && (this.j.isShowing())) {
      this.j.dismiss();
    }
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    super.dispatchDraw(paramCanvas);
    Paint localPaint = new Paint(1);
    localPaint.setColor(Color.parseColor("#d1d1d1"));
    localPaint.setStyle(Paint.Style.FILL);
    paramCanvas.drawLine(0.0F, getMeasuredHeight() - this.c, getMeasuredWidth(), getMeasuredHeight(), localPaint);
  }
  
  public void initState(ZryuSearchConditionV2 paramZryuSearchConditionV2)
  {
    this.e = -1;
    this.q = paramZryuSearchConditionV2;
    if (paramZryuSearchConditionV2.selectCityIndex == -1)
    {
      this.k.setText(this.f[0]);
      this.k.setTextColor(this.b.getResources().getColor(2131624415));
    }
    for (;;)
    {
      a = paramZryuSearchConditionV2.unlimitPrice;
      this.l.setSelected(false);
      if ((paramZryuSearchConditionV2 != null) && (paramZryuSearchConditionV2.priceBean != null)) {
        a(paramZryuSearchConditionV2.priceBean.minPrice, paramZryuSearchConditionV2.priceBean.maxPrice);
      }
      if (paramZryuSearchConditionV2.checkInDate != null) {
        break;
      }
      this.m.setText(this.f[2]);
      this.m.setTextColor(this.b.getResources().getColor(2131624415));
      return;
      this.k.setText(((ZryuSearchConditionV2.CityListBean)paramZryuSearchConditionV2.cityList.get(paramZryuSearchConditionV2.selectCityIndex)).cityName);
      this.k.setTextColor(this.b.getResources().getColor(2131624415));
    }
    this.m.setText(m.getFormatDate(paramZryuSearchConditionV2.checkInDate, m.b));
    this.m.setTextColor(this.b.getResources().getColor(2131624415));
  }
  
  public boolean isPopShowing()
  {
    return ((this.h != null) && (this.h.isShowing())) || ((this.h != null) && (this.h.isShowing())) || ((this.i != null) && (this.i.isShowing())) || ((this.j != null) && (this.j.isShowing()));
  }
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    if (this.q == null) {
      g.textToast(this.b, "服务器异常，正在努力抢修中，请稍后再试!");
    }
    String str;
    do
    {
      return;
      str = paramView.getTag().toString();
      int i1 = 0;
      while (i1 < getChildCount())
      {
        getChildAt(i1).setSelected(false);
        i1 += 1;
      }
      paramView = (TextView)paramView;
      if (this.f[0].equals(str))
      {
        a(paramView);
        return;
      }
      if (this.f[1].equals(str))
      {
        b(paramView);
        return;
      }
    } while (!this.f[2].equals(str));
    c(paramView);
  }
  
  public void setDataListener(a parama)
  {
    this.t = parama;
  }
  
  public void setSelectStyle(int paramInt, TextView paramTextView)
  {
    switch (this.e)
    {
    }
    while (this.e == paramInt)
    {
      this.e = -1;
      paramTextView.setSelected(false);
      return;
      if ((paramInt != 0) && (this.h != null) && (this.h.isShowing()))
      {
        this.h.dismiss();
        continue;
        if ((paramInt != 1) && (this.i != null) && (this.i.isShowing()))
        {
          this.i.dismiss();
          continue;
          if ((paramInt != 2) && (this.j != null) && (this.j.isShowing())) {
            this.j.dismiss();
          }
        }
      }
    }
    this.e = paramInt;
    paramTextView.setSelected(true);
  }
  
  public static abstract interface a
  {
    public abstract void getData(ZryuSearchConditionV2 paramZryuSearchConditionV2);
  }
  
  public static abstract interface b
  {
    public abstract void onDismiss();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomapartment/widget/ProjectListConditionalView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */