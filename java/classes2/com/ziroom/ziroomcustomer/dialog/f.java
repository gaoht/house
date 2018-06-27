package com.ziroom.ziroomcustomer.dialog;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.util.n;
import com.ziroom.ziroomcustomer.util.u;
import com.ziroom.ziroomcustomer.widget.ChoiceView;
import com.ziroom.ziroomcustomer.widget.ObservableScrollView;
import com.ziroom.ziroomcustomer.widget.ObservableScrollView.a;
import java.util.List;

public class f
  implements ObservableScrollView.a
{
  BaseAdapter a = new BaseAdapter()
  {
    public int getCount()
    {
      if (f.g(f.this) == null) {
        return 0;
      }
      return f.g(f.this).size();
    }
    
    public Object getItem(int paramAnonymousInt)
    {
      return f.g(f.this).get(paramAnonymousInt);
    }
    
    public long getItemId(int paramAnonymousInt)
    {
      return paramAnonymousInt;
    }
    
    public View getView(int paramAnonymousInt, View paramAnonymousView, ViewGroup paramAnonymousViewGroup)
    {
      if (paramAnonymousView == null) {}
      for (paramAnonymousView = new ChoiceView(f.h(f.this));; paramAnonymousView = (ChoiceView)paramAnonymousView)
      {
        paramAnonymousView.setText((String)f.g(f.this).get(paramAnonymousInt));
        return paramAnonymousView;
      }
    }
  };
  private Context b;
  private View c;
  private ListView d;
  private PopupWindow e;
  private View f;
  private RelativeLayout g;
  private List<String> h;
  private String i;
  private TextView j;
  private TextView k;
  private TextView l;
  private ObservableScrollView m;
  private View n;
  private b o;
  private LayoutInflater p;
  private String q = f.class.getSimpleName();
  private View r;
  private int s = -1;
  
  public f(String paramString, b paramb, List<String> paramList, Context paramContext, View paramView, int paramInt)
  {
    this.b = paramContext;
    this.c = paramView;
    this.h = paramList;
    this.i = paramString;
    this.o = paramb;
    this.s = paramInt;
    a();
  }
  
  private void a()
  {
    this.p = ((LayoutInflater)this.b.getSystemService("layout_inflater"));
    Object localObject = this.p.inflate(2130905062, null);
    a((View)localObject);
    this.e = new PopupWindow((View)localObject, -1, -1);
    this.e.setFocusable(true);
    localObject = new ColorDrawable(-1);
    this.e.setBackgroundDrawable((Drawable)localObject);
    this.e.setAnimationStyle(2131427507);
    this.e.setOnDismissListener(new PopupWindow.OnDismissListener()
    {
      public void onDismiss() {}
    });
  }
  
  private void a(View paramView)
  {
    this.n = paramView.findViewById(2131691166);
    this.m = ((ObservableScrollView)paramView.findViewById(2131697334));
    this.m.setOnScrollChangedCallback(this);
    this.f = paramView.findViewById(2131697337);
    this.f.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        f.this.dismiss();
      }
    });
    this.r = paramView.findViewById(2131697335);
    this.d = ((ListView)paramView.findViewById(2131697336));
    this.j = ((TextView)paramView.findViewById(2131689541));
    this.l = ((TextView)paramView.findViewById(2131697338));
    this.j.setText(this.i);
    this.l.setText(this.i);
    this.k = ((TextView)paramView.findViewById(2131697339));
    this.k.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        if (f.b(f.this) != -1)
        {
          f.c(f.this).onSelected(f.b(f.this));
          f.this.dismiss();
        }
      }
    });
    this.g = ((RelativeLayout)paramView.findViewById(2131689928));
    this.d.setChoiceMode(1);
    this.d.setAdapter(this.a);
    this.d.setOnScrollListener(new AbsListView.OnScrollListener()
    {
      public void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        if (paramAnonymousInt1 == 0)
        {
          paramAnonymousAbsListView = f.d(f.this).getChildAt(0);
          if ((paramAnonymousAbsListView != null) && (paramAnonymousAbsListView.getTop() == 0))
          {
            u.i(f.e(f.this), "##### 滚动到顶部 #####");
            f.f(f.this).setVisibility(8);
            return;
          }
          f.f(f.this).setVisibility(8);
          return;
        }
        f.f(f.this).setVisibility(8);
      }
      
      public void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt) {}
    });
    this.d.setOnItemClickListener(new a());
    this.d.setItemChecked(this.s, true);
    updateOKButtonBG();
  }
  
  public void dismiss()
  {
    if ((this.e != null) && (this.e.isShowing())) {
      this.e.dismiss();
    }
  }
  
  public PopupWindow getWindow()
  {
    return this.e;
  }
  
  public void onScroll(int paramInt1, int paramInt2)
  {
    float f1 = 1.0F;
    float f2 = paramInt2 / n.dip2px(this.b, 100.0F);
    if (f2 > 1.0F) {}
    for (;;)
    {
      this.g.setAlpha(f1);
      this.l.setAlpha(f1);
      this.n.setAlpha(f1);
      return;
      f1 = f2;
    }
  }
  
  public void showPopwindow()
  {
    PopupWindow localPopupWindow = this.e;
    View localView = this.c;
    if (!(localPopupWindow instanceof PopupWindow)) {
      localPopupWindow.showAsDropDown(localView);
    }
    for (;;)
    {
      this.m.post(new Runnable()
      {
        public void run()
        {
          f.a(f.this).scrollTo(0, 0);
        }
      });
      return;
      VdsAgent.showAsDropDown((PopupWindow)localPopupWindow, localView);
    }
  }
  
  public void updateOKButtonBG()
  {
    if (this.s != -1)
    {
      this.k.setBackgroundColor(40960);
      return;
    }
    this.k.setBackgroundColor(-2236963);
  }
  
  class a
    implements AdapterView.OnItemClickListener
  {
    a() {}
    
    @Instrumented
    public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
    {
      VdsAgent.onItemClick(this, paramAdapterView, paramView, paramInt, paramLong);
      f.a(f.this, paramInt);
      if (f.b(f.this) != -1)
      {
        f.c(f.this).onSelected(f.b(f.this));
        f.this.dismiss();
      }
    }
  }
  
  public static abstract interface b
  {
    public abstract void onSelected(int paramInt);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/dialog/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */