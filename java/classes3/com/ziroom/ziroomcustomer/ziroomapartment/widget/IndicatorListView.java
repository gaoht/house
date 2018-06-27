package com.ziroom.ziroomcustomer.ziroomapartment.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.R.styleable;
import java.util.ArrayList;
import java.util.List;

public class IndicatorListView
  extends FrameLayout
{
  private int A = 0;
  private Context a;
  private ObservableScrollView b;
  private LinearLayout c;
  private RelativeLayout d;
  private a e;
  private d f;
  private c g;
  private final int h = 2147483646;
  private final int i = 2147483645;
  private final int j = 2147483644;
  private final int k = 2147483643;
  private final boolean l = true;
  private final boolean m = false;
  private final int n = 1;
  private final int o = 2;
  private final int p = 3;
  private final int q = 4;
  private List<View> r = new ArrayList();
  private int s = 3;
  private int t = 2;
  private int u = 0;
  private int v = 0;
  private int w;
  private int x;
  private int y;
  private int z;
  
  public IndicatorListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.a = paramContext;
    setAttributeSet(paramAttributeSet);
  }
  
  private View a(int paramInt1, int paramInt2)
  {
    View localView = this.e.getChildView(paramInt1, paramInt2);
    localView.setTag(2147483646, Integer.valueOf(paramInt1));
    localView.setTag(2147483644, Integer.valueOf(2));
    localView.setTag(2147483643, Integer.valueOf(paramInt2));
    switch (this.s)
    {
    }
    for (;;)
    {
      if (this.g != null) {
        localView.setOnClickListener(new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymousView)
          {
            VdsAgent.onClick(this, paramAnonymousView);
            int i = ((Integer)paramAnonymousView.getTag(2147483646)).intValue();
            int j = ((Integer)paramAnonymousView.getTag(2147483643)).intValue();
            IndicatorListView.c(IndicatorListView.this).onChildClick(paramAnonymousView, i, j);
          }
        });
      }
      return localView;
      localView.setVisibility(8);
      continue;
      if (paramInt2 >= this.t) {
        localView.setVisibility(8);
      }
    }
  }
  
  private void a()
  {
    this.b.setOnScrollListener(new e()
    {
      public void onScrollChanged(ScrollView paramAnonymousScrollView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4)
      {
        IndicatorListView.a(IndicatorListView.this, paramAnonymousScrollView.getScrollY());
        paramAnonymousScrollView = IndicatorListView.this;
        if (IndicatorListView.a(IndicatorListView.this) == null) {}
        for (paramAnonymousInt1 = 0;; paramAnonymousInt1 = IndicatorListView.a(IndicatorListView.this).getHeight())
        {
          IndicatorListView.b(paramAnonymousScrollView, paramAnonymousInt1);
          if (IndicatorListView.b(IndicatorListView.this) >= 0) {
            IndicatorListView.c(IndicatorListView.this, IndicatorListView.b(IndicatorListView.this));
          }
          return;
        }
      }
    });
  }
  
  private void a(int paramInt)
  {
    int i3 = 1;
    int i4 = 0;
    int i2;
    View localView;
    if (paramInt > this.A)
    {
      i1 = 0;
      i2 = i4;
      if (i1 < this.r.size())
      {
        if ((paramInt < ((View)this.r.get(i1)).getTop()) || (paramInt > ((View)this.r.get(i1)).getBottom() - 10)) {
          break label365;
        }
        localView = this.d.getChildAt(0);
        if ((localView != null) && (i1 == ((Integer)localView.getTag(2147483646)).intValue())) {
          i2 = i4;
        }
      }
      else if (i2 < this.r.size())
      {
        if ((((View)this.r.get(i2)).getTop() - paramInt <= 0) || (paramInt - ((View)this.r.get(i2)).getTop() + this.v <= 0)) {
          break label372;
        }
        this.d.layout(this.y, this.w - (this.v - (((View)this.r.get(i2)).getTop() - paramInt)), this.z, this.x - (this.v - (((View)this.r.get(i2)).getTop() - paramInt)));
      }
    }
    ViewGroup.LayoutParams localLayoutParams;
    label365:
    label372:
    while (paramInt >= this.A) {
      for (;;)
      {
        this.A = paramInt;
        return;
        this.d.removeAllViews();
        localView = b(i1);
        localView.setTag(2147483646, Integer.valueOf(i1));
        this.d.addView(localView);
        localLayoutParams = localView.getLayoutParams();
        localLayoutParams.width = -1;
        localView.setLayoutParams(localLayoutParams);
        this.v = ((View)this.r.get(i1)).getMeasuredHeight();
        this.y = 0;
        this.w = 0;
        this.z = ((View)this.r.get(i1)).getMeasuredWidth();
        this.x = this.v;
        i2 = i4;
        continue;
        i1 += 1;
        continue;
        i2 += 1;
      }
    }
    int i1 = 0;
    label389:
    if (i1 < this.r.size()) {
      if ((((View)this.r.get(i1)).getTop() - paramInt > 0) && (paramInt - ((View)this.r.get(i1)).getTop() + this.v > 0)) {
        this.d.layout(this.y, this.w - (this.v - (((View)this.r.get(i1)).getTop() - paramInt)), this.z, this.x - (this.v - (((View)this.r.get(i1)).getTop() - paramInt)));
      }
    }
    for (;;)
    {
      i2 = i3;
      if (this.r.size() > 1)
      {
        i2 = i3;
        if (paramInt < ((View)this.r.get(i1)).getTop() - this.v)
        {
          this.d.layout(this.y, 0, this.z, this.v);
          i2 = i3;
        }
      }
      for (;;)
      {
        if (i2 >= this.r.size()) {
          break label810;
        }
        if ((paramInt <= ((View)this.r.get(i2)).getTop()) && (paramInt >= ((View)this.r.get(i2 - 1)).getBottom() - 10))
        {
          localView = this.d.getChildAt(0);
          if ((localView != null) && (i2 - 1 == ((Integer)localView.getTag(2147483646)).intValue())) {
            break;
          }
          this.d.removeAllViews();
          localView = b(i2 - 1);
          localView.setTag(2147483646, Integer.valueOf(i2 - 1));
          this.d.addView(localView);
          localLayoutParams = localView.getLayoutParams();
          localLayoutParams.width = -1;
          localView.setLayoutParams(localLayoutParams);
          this.v = ((View)this.r.get(i2)).getMeasuredHeight();
          this.y = 0;
          this.w = 0;
          this.z = ((View)this.r.get(i2)).getMeasuredWidth();
          this.x = this.v;
          break;
          i1 += 1;
          break label389;
        }
        i2 += 1;
      }
      label810:
      break;
      i1 = 1;
    }
  }
  
  private void a(TypedArray paramTypedArray)
  {
    this.d = new RelativeLayout(this.a)
    {
      protected void onDraw(Canvas paramAnonymousCanvas)
      {
        super.onDraw(paramAnonymousCanvas);
      }
      
      protected void onLayout(boolean paramAnonymousBoolean, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4)
      {
        super.onLayout(paramAnonymousBoolean, paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3, paramAnonymousInt4);
      }
    };
    this.d.setVisibility(0);
    paramTypedArray = new ViewGroup.LayoutParams(-1, -2);
    addView(this.d, paramTypedArray);
  }
  
  private View b(int paramInt)
  {
    View localView = this.e.getGroupView(paramInt);
    localView.setTag(2147483646, Integer.valueOf(paramInt));
    localView.setTag(2147483644, Integer.valueOf(1));
    if (this.f != null) {
      localView.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          int i = ((Integer)paramAnonymousView.getTag(2147483646)).intValue();
          IndicatorListView.d(IndicatorListView.this).onGroupClick(paramAnonymousView, i);
        }
      });
    }
    return localView;
  }
  
  private void b(TypedArray paramTypedArray)
  {
    this.s = paramTypedArray.getInt(0, 3);
    this.b = new ObservableScrollView(this.a);
    paramTypedArray = new ViewGroup.LayoutParams(-1, -1);
    addView(this.b, paramTypedArray);
    this.c = new LinearLayout(this.a);
    this.c.setOrientation(1);
    paramTypedArray = new ViewGroup.LayoutParams(-1, -1);
    this.b.addView(this.c, paramTypedArray);
  }
  
  private View c(int paramInt)
  {
    View localView = this.e.getLessView(paramInt);
    if (localView == null) {
      return localView;
    }
    switch (this.s)
    {
    }
    for (;;)
    {
      localView.setTag(2147483645, Boolean.valueOf(false));
      localView.setTag(2147483646, Integer.valueOf(paramInt));
      localView.setTag(2147483644, Integer.valueOf(3));
      localView.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          int m = ((Integer)paramAnonymousView.getTag(2147483646)).intValue();
          int i = 0;
          int j = 0;
          if (i < IndicatorListView.e(IndicatorListView.this).getChildCount())
          {
            View localView = IndicatorListView.e(IndicatorListView.this).getChildAt(i);
            int n = ((Integer)localView.getTag(2147483644)).intValue();
            int i1 = ((Integer)localView.getTag(2147483646)).intValue();
            if ((i1 == m) && (n == 3) && (((Boolean)localView.getTag(2147483645)).booleanValue()))
            {
              paramAnonymousView.setVisibility(8);
              localView.setVisibility(0);
            }
            int k = j;
            if (i1 == m)
            {
              k = j;
              if (n == 2) {
                if (j >= IndicatorListView.f(IndicatorListView.this)) {
                  break label166;
                }
              }
            }
            for (k = j + 1;; k = j)
            {
              i += 1;
              j = k;
              break;
              label166:
              localView.setVisibility(8);
            }
          }
        }
      });
      return localView;
      localView.setVisibility(8);
      continue;
      localView.setVisibility(0);
      continue;
      localView.setVisibility(8);
      continue;
      localView.setVisibility(8);
    }
  }
  
  private View d(int paramInt)
  {
    View localView = this.e.getMoreView(paramInt);
    if (localView == null) {
      return localView;
    }
    switch (this.s)
    {
    }
    for (;;)
    {
      localView.setTag(2147483645, Boolean.valueOf(true));
      localView.setTag(2147483646, Integer.valueOf(paramInt));
      localView.setTag(2147483644, Integer.valueOf(3));
      localView.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          int j = ((Integer)paramAnonymousView.getTag(2147483646)).intValue();
          int i = 0;
          while (i < IndicatorListView.e(IndicatorListView.this).getChildCount())
          {
            View localView = IndicatorListView.e(IndicatorListView.this).getChildAt(i);
            int k = ((Integer)localView.getTag(2147483644)).intValue();
            int m = ((Integer)localView.getTag(2147483646)).intValue();
            if ((m == j) && (k == 2)) {
              localView.setVisibility(0);
            }
            if ((m == j) && (k == 3) && (!((Boolean)localView.getTag(2147483645)).booleanValue()))
            {
              paramAnonymousView.setVisibility(8);
              localView.setVisibility(0);
            }
            i += 1;
          }
        }
      });
      return localView;
      localView.setVisibility(8);
      continue;
      localView.setVisibility(8);
      continue;
      localView.setVisibility(0);
      continue;
      localView.setVisibility(8);
    }
  }
  
  private void setAttributeSet(AttributeSet paramAttributeSet)
  {
    paramAttributeSet = this.a.obtainStyledAttributes(paramAttributeSet, R.styleable.ZRCustomIndicatorListView);
    b(paramAttributeSet);
    a(paramAttributeSet);
    a();
    paramAttributeSet.recycle();
  }
  
  public a getAdapter()
  {
    return this.e;
  }
  
  public void notifyDataSetChanged()
  {
    this.r.clear();
    this.c.removeAllViews();
    int i1 = 0;
    while (i1 < this.e.getGroupCount())
    {
      View localView = b(i1);
      this.r.add(localView);
      this.c.addView(localView);
      if (this.e.getChildCount(i1) > this.t) {}
      for (int i2 = 1;; i2 = 0)
      {
        int i3 = 0;
        while (i3 < this.e.getChildCount(i1))
        {
          localView = a(i1, i3);
          this.c.addView(localView);
          i3 += 1;
        }
      }
      localView = d(i1);
      if (localView != null)
      {
        if (i2 == 0) {
          localView.setVisibility(8);
        }
        this.c.addView(localView);
      }
      localView = c(i1);
      if (localView != null)
      {
        if (i2 == 0) {
          localView.setVisibility(8);
        }
        this.c.addView(localView);
      }
      i1 += 1;
    }
  }
  
  public void setAdapter(a parama)
  {
    this.e = parama;
    notifyDataSetChanged();
  }
  
  public void setMoreNumber(int paramInt)
  {
    this.t = paramInt;
    notifyDataSetChanged();
  }
  
  public void setOnChildClickListener(c paramc)
  {
    if (paramc != null)
    {
      this.g = paramc;
      if (this.c != null)
      {
        int i1 = 0;
        while (i1 < this.c.getChildCount())
        {
          paramc = this.c.getChildAt(i1);
          if (((Integer)paramc.getTag(2147483644)).intValue() == 2) {
            paramc.setOnClickListener(new View.OnClickListener()
            {
              @Instrumented
              public void onClick(View paramAnonymousView)
              {
                VdsAgent.onClick(this, paramAnonymousView);
                int i = ((Integer)paramAnonymousView.getTag(2147483646)).intValue();
                int j = ((Integer)paramAnonymousView.getTag(2147483643)).intValue();
                IndicatorListView.c(IndicatorListView.this).onChildClick(paramAnonymousView, i, j);
              }
            });
          }
          i1 += 1;
        }
      }
    }
  }
  
  public void setOnGroupClickListener(d paramd)
  {
    if (paramd != null)
    {
      this.f = paramd;
      if (this.c != null)
      {
        int i1 = 0;
        while (i1 < this.c.getChildCount())
        {
          paramd = this.c.getChildAt(i1);
          if (((Integer)paramd.getTag(2147483644)).intValue() == 1) {
            paramd.setOnClickListener(new View.OnClickListener()
            {
              @Instrumented
              public void onClick(View paramAnonymousView)
              {
                VdsAgent.onClick(this, paramAnonymousView);
                int i = ((Integer)paramAnonymousView.getTag(2147483646)).intValue();
                IndicatorListView.d(IndicatorListView.this).onGroupClick(paramAnonymousView, i);
              }
            });
          }
          i1 += 1;
        }
      }
    }
  }
  
  public void setShowType(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      this.s = 3;
    }
    for (;;)
    {
      notifyDataSetChanged();
      return;
      this.s = 1;
      continue;
      this.s = 2;
      continue;
      this.s = 3;
      continue;
      this.s = 4;
    }
  }
  
  private class ObservableScrollView
    extends ScrollView
  {
    private IndicatorListView.e b;
    
    public ObservableScrollView(Context paramContext)
    {
      super();
    }
    
    protected void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
      if (this.b != null) {
        this.b.onScrollChanged(this, paramInt1, paramInt2, paramInt3, paramInt4);
      }
    }
    
    public void setOnScrollListener(IndicatorListView.e parame)
    {
      this.b = parame;
    }
  }
  
  public static abstract class a
    implements IndicatorListView.b
  {}
  
  public static abstract interface b
  {
    public abstract Object getChild(int paramInt1, int paramInt2);
    
    public abstract int getChildCount(int paramInt);
    
    public abstract View getChildView(int paramInt1, int paramInt2);
    
    public abstract Object getGroup(int paramInt);
    
    public abstract int getGroupCount();
    
    public abstract View getGroupView(int paramInt);
    
    public abstract View getLessView(int paramInt);
    
    public abstract View getMoreView(int paramInt);
  }
  
  public static abstract interface c
  {
    public abstract void onChildClick(View paramView, int paramInt1, int paramInt2);
  }
  
  public static abstract interface d
  {
    public abstract void onGroupClick(View paramView, int paramInt);
  }
  
  private static abstract interface e
  {
    public abstract void onScrollChanged(ScrollView paramScrollView, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomapartment/widget/IndicatorListView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */