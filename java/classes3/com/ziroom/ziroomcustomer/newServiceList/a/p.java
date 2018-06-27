package com.ziroom.ziroomcustomer.newServiceList.a;

import android.content.Context;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.ScaleAnimation;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.newServiceList.model.w;
import java.util.List;

public class p
  extends BaseAdapter
{
  private Context a;
  private List<w> b;
  private a c;
  private int d;
  
  public p(Context paramContext, List<w> paramList)
  {
    this.a = paramContext;
    this.b = paramList;
  }
  
  public int getCount()
  {
    return this.b.size();
  }
  
  public Object getItem(int paramInt)
  {
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(final int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    label74:
    final w localw;
    if (paramView == null)
    {
      paramView = View.inflate(this.a, 2130904508, null);
      paramViewGroup = new b();
      paramViewGroup.a = ((TextView)paramView.findViewById(2131695648));
      paramViewGroup.b = paramView.findViewById(2131694715);
      paramViewGroup.c = paramView.findViewById(2131695649);
      paramView.setTag(paramViewGroup);
      if (paramInt != 0) {
        break label264;
      }
      paramViewGroup.b.setVisibility(0);
      localw = (w)this.b.get(paramInt);
      int i = View.MeasureSpec.makeMeasureSpec(0, 0);
      int j = View.MeasureSpec.makeMeasureSpec(0, 0);
      paramViewGroup.a.measure(i, j);
      paramViewGroup.a.getMeasuredHeight();
      i = paramViewGroup.a.getMeasuredWidth();
      Object localObject = paramViewGroup.c.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject).width = i;
      paramViewGroup.c.setLayoutParams((ViewGroup.LayoutParams)localObject);
      if (!localw.isSelect()) {
        break label276;
      }
      paramViewGroup.c.setVisibility(0);
      localObject = new ScaleAnimation(0.0F, 1.0F, 1.0F, 1.0F, 1, 0.5F, 1, 0.5F);
      ((ScaleAnimation)localObject).setDuration(300L);
      paramViewGroup.c.startAnimation((Animation)localObject);
      ((ScaleAnimation)localObject).setAnimationListener(new Animation.AnimationListener()
      {
        public void onAnimationEnd(Animation paramAnonymousAnimation)
        {
          if (p.a(p.this) != null) {
            p.a(p.this).downPositon(p.b(p.this));
          }
        }
        
        public void onAnimationRepeat(Animation paramAnonymousAnimation) {}
        
        public void onAnimationStart(Animation paramAnonymousAnimation) {}
      });
    }
    for (;;)
    {
      paramViewGroup.a.setText(localw.getTypeName());
      paramViewGroup.a.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          int i = 0;
          if (i < p.c(p.this).size())
          {
            if (i == paramInt) {
              localw.setSelect(true);
            }
            for (;;)
            {
              i += 1;
              break;
              ((w)p.c(p.this).get(i)).setSelect(false);
            }
          }
          p.a(p.this, paramInt);
          p.this.notifyDataSetChanged();
        }
      });
      return paramView;
      paramViewGroup = (b)paramView.getTag();
      break;
      label264:
      paramViewGroup.b.setVisibility(8);
      break label74;
      label276:
      paramViewGroup.c.setVisibility(4);
    }
  }
  
  public void setDownDataChangeListener(a parama)
  {
    this.c = parama;
  }
  
  public static abstract interface a
  {
    public abstract void downPositon(int paramInt);
  }
  
  public class b
  {
    public TextView a;
    public View b;
    public View c;
    
    public b() {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newServiceList/a/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */