package com.unionpay.mobile.android.widgets;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.ScrollView;
import android.widget.TextView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.unionpay.mobile.android.global.a;
import com.unionpay.mobile.android.resource.c;
import com.unionpay.mobile.android.utils.f;
import com.unionpay.mobile.android.utils.g;
import com.unionpay.mobile.android.utils.j;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class bb
{
  private static int a = a.r;
  private static int b = 40;
  private static List<Integer> i = new ArrayList(10);
  private Context c = null;
  private View.OnClickListener d = null;
  private PopupWindow e = null;
  private View f = null;
  private ScrollView g = null;
  private int h = -1;
  private PopupWindow.OnDismissListener j = new bc(this);
  
  static
  {
    int k = 0;
    while (k < 10)
    {
      i.add(Integer.valueOf(k));
      k += 1;
    }
  }
  
  public bb(Context paramContext, View.OnClickListener paramOnClickListener, View paramView)
  {
    this.c = paramContext;
    this.d = paramOnClickListener;
    a = f.a(this.c, 55.0F);
    b = f.a(this.c, 40.0F);
    for (paramOnClickListener = (ViewParent)paramView;; paramOnClickListener = paramOnClickListener.getParent()) {
      if (paramOnClickListener != null)
      {
        if ((paramOnClickListener instanceof ScrollView))
        {
          this.g = ((ScrollView)paramOnClickListener);
          j.a("UPWidgetKeyBoard", "mSV : " + this.g.toString());
          j.a("UPWidgetKeyBoard", "mSV H:" + this.g.getHeight());
          this.f = ((ScrollView)paramOnClickListener).getChildAt(0);
        }
      }
      else
      {
        paramOnClickListener = new RelativeLayout(paramContext);
        new RelativeLayout.LayoutParams(-1, -2).setMargins(0, 0, 0, 0);
        paramOnClickListener.setBackgroundColor(-1342177280);
        paramContext = new RelativeLayout(paramContext);
        paramContext.setBackgroundColor(-13290188);
        paramView = new RelativeLayout.LayoutParams(-1, -2);
        paramView.setMargins(0, 0, 0, 0);
        paramOnClickListener.addView(paramContext, paramView);
        paramContext.addView(new b(this.c), paramView);
        this.e = new PopupWindow(paramOnClickListener, -1, -2, true);
        new RelativeLayout.LayoutParams(-1, -2);
        this.e.setBackgroundDrawable(new BitmapDrawable());
        this.e.setOutsideTouchable(false);
        this.e.setFocusable(false);
        this.e.setOnDismissListener(this.j);
        return;
      }
    }
  }
  
  private static int d()
  {
    int k = a * 4 + b;
    j.c("UPWidgetKeyBoard", "kbH=" + k);
    return k;
  }
  
  public final void a()
  {
    if (this.e != null) {
      this.e.dismiss();
    }
  }
  
  public final void a(View paramView)
  {
    Object localObject;
    if (this.e != null)
    {
      localObject = this.e;
      if ((localObject instanceof PopupWindow)) {
        break label140;
      }
      ((PopupWindow)localObject).showAtLocation(paramView, 80, 0, 0);
    }
    for (;;)
    {
      this.e.update();
      if (this.f != null)
      {
        paramView.setVisibility(0);
        localObject = (ViewGroup.MarginLayoutParams)this.g.getLayoutParams();
        this.h = ((ViewGroup.MarginLayoutParams)localObject).height;
        Rect localRect = new Rect();
        paramView.getWindowVisibleDisplayFrame(localRect);
        ((ViewGroup.MarginLayoutParams)localObject).height = (a.t - localRect.top - a.k - d());
        j.a("UPWidgetKeyBoard", "height = " + ((ViewGroup.MarginLayoutParams)localObject).height);
        ((ViewGroup.MarginLayoutParams)localObject).bottomMargin = d();
        this.g.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      return;
      label140:
      VdsAgent.showAtLocation((PopupWindow)localObject, paramView, 80, 0, 0);
    }
  }
  
  public final boolean b()
  {
    return this.e.isShowing();
  }
  
  private final class a
    extends BaseAdapter
  {
    private a() {}
    
    public final int getCount()
    {
      return bb.c().size() + 2;
    }
    
    public final Object getItem(int paramInt)
    {
      return null;
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      int i = 10;
      paramView = new LinearLayout(bb.c(bb.this));
      paramViewGroup = c.a(bb.c(bb.this)).a(1022);
      Object localObject = c.a(bb.c(bb.this)).a(1023);
      paramView.setBackgroundDrawable(g.a(paramViewGroup, (Drawable)localObject, (Drawable)localObject, paramViewGroup));
      paramView.setMinimumHeight(f.a(bb.c(bb.this), 55.0F));
      paramView.setClickable(true);
      paramView.setOnClickListener(bb.d(bb.this));
      paramViewGroup = new LinearLayout.LayoutParams(-1, -1);
      paramViewGroup.gravity = 17;
      if ((paramInt == 9) || (paramInt == 11))
      {
        localObject = new ImageView(bb.c(bb.this));
        if (paramInt == 9) {
          if (paramInt != 9) {
            break label213;
          }
        }
        label213:
        for (paramInt = 1024;; paramInt = 1025)
        {
          ((ImageView)localObject).setImageDrawable(c.a(bb.c(bb.this)).a(paramInt, -1, f.a(bb.c(bb.this), 20.0F)));
          paramView.setId(i);
          paramView.addView((View)localObject, paramViewGroup);
          return paramView;
          i = 20;
          break;
        }
      }
      localObject = new TextView(bb.c(bb.this));
      ((TextView)localObject).setTextColor(-1);
      ((TextView)localObject).getPaint().setFakeBoldText(true);
      ((TextView)localObject).setTextSize(30.0F);
      ((TextView)localObject).setGravity(17);
      i = paramInt;
      if (paramInt == 10) {
        i = 9;
      }
      paramInt = ((Integer)bb.c().get(i)).intValue();
      paramView.setId(paramInt);
      ((TextView)localObject).setText(paramInt);
      paramView.addView((View)localObject, paramViewGroup);
      return paramView;
    }
  }
  
  private final class b
    extends LinearLayout
  {
    public b(Context paramContext)
    {
      super();
      setOrientation(1);
      setBackgroundColor(-11316397);
      this$1 = new LinearLayout.LayoutParams(-1, -2);
      bb.this.gravity = 17;
      LinearLayout localLinearLayout = new LinearLayout(paramContext);
      int i = f.a(paramContext, 5.0F);
      localLinearLayout.setPadding(0, i, 0, i);
      localLinearLayout.setGravity(17);
      localLinearLayout.setBackgroundColor(-13816531);
      localLinearLayout.setOrientation(0);
      i = f.a(paramContext, 24.0F);
      Drawable localDrawable = c.a(paramContext).a(1020, -1, i);
      ImageView localImageView = new ImageView(paramContext);
      localImageView.setImageDrawable(localDrawable);
      localLinearLayout.addView(localImageView);
      addView(localLinearLayout, bb.this);
      Collections.shuffle(bb.c());
      this$1 = new LinearLayout.LayoutParams(-1, -2);
      bb.this.gravity = 17;
      paramContext = new GridView(paramContext);
      paramContext.setNumColumns(3);
      paramContext.setAdapter(new bb.a(bb.this, (byte)0));
      paramContext.setGravity(17);
      paramContext.setStretchMode(2);
      paramContext.setHorizontalScrollBarEnabled(false);
      paramContext.setVerticalScrollBarEnabled(false);
      paramContext.setEnabled(true);
      i = f.a(bb.c(bb.this), 1.0F);
      paramContext.setHorizontalSpacing(i);
      paramContext.setVerticalSpacing(i);
      int j = -i;
      paramContext.setPadding(j, i, j, j);
      addView(paramContext, bb.this);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/mobile/android/widgets/bb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */