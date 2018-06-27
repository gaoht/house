package com.ziroom.ziroomcustomer.findhouse.widget;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.findhouse.model.SelectBean;
import com.ziroom.ziroomcustomer.model.SearchCondition;
import java.util.List;

public class a
  extends Dialog
{
  private Context a;
  private View b;
  private List<SelectBean> c;
  private b d;
  private SearchCondition e;
  private ListView f;
  private a g;
  
  public a(Context paramContext)
  {
    this(paramContext, 2131427567);
  }
  
  public a(Context paramContext, int paramInt)
  {
    super(paramContext, 2131427567);
    this.a = paramContext;
    requestWindowFeature(1);
    Window localWindow = getWindow();
    setCanceledOnTouchOutside(true);
    setCancelable(true);
    WindowManager.LayoutParams localLayoutParams = localWindow.getAttributes();
    localLayoutParams.width = paramContext.getResources().getDisplayMetrics().widthPixels;
    localLayoutParams.gravity = 80;
    localWindow.setAttributes(localLayoutParams);
    this.b = LayoutInflater.from(paramContext).inflate(2130903800, null);
    a();
  }
  
  private void a()
  {
    this.f = ((ListView)this.b.findViewById(2131693798));
    this.f.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      @Instrumented
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        VdsAgent.onItemClick(this, paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
        if (a.a(a.this) != null) {
          a.a(a.this).setSort(((SelectBean)a.b(a.this).get(paramAnonymousInt)).getValue());
        }
        if (a.c(a.this) != null) {
          a.c(a.this).getData(a.a(a.this));
        }
        a.this.dismiss();
      }
    });
    setContentView(this.b);
  }
  
  public void setDataListener(a parama)
  {
    this.g = parama;
  }
  
  public void show(List<SelectBean> paramList, SearchCondition paramSearchCondition)
  {
    if (!(this instanceof Dialog)) {
      super.show();
    }
    for (;;)
    {
      this.c = paramList;
      this.e = paramSearchCondition;
      this.d = new b(this.c, paramSearchCondition.getSort());
      this.f.setAdapter(this.d);
      return;
      VdsAgent.showDialog((Dialog)this);
    }
  }
  
  public static abstract interface a
  {
    public abstract void getData(SearchCondition paramSearchCondition);
  }
  
  class b
    extends BaseAdapter
  {
    private List<SelectBean> b;
    
    public b(String paramString)
    {
      this.b = paramString;
    }
    
    public int getCount()
    {
      if (this.b == null) {
        return 0;
      }
      return this.b.size();
    }
    
    public Object getItem(int paramInt)
    {
      return this.b.get(paramInt);
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      if (paramView == null)
      {
        paramView = LayoutInflater.from(a.d(a.this)).inflate(2130903676, null);
        paramViewGroup = new a();
        paramViewGroup.a = ((TextView)paramView.findViewById(2131693236));
        paramViewGroup.b = paramView.findViewById(2131693237);
        paramView.setTag(paramViewGroup);
      }
      SelectBean localSelectBean;
      for (;;)
      {
        paramViewGroup.a.setText(((SelectBean)this.b.get(paramInt)).getTitle());
        localSelectBean = (SelectBean)this.b.get(paramInt);
        if ((localSelectBean != null) && (localSelectBean.getValue() != null)) {
          break;
        }
        return paramView;
        paramViewGroup = (a)paramView.getTag();
      }
      if (a.a(a.this) == null) {}
      for (String str = "";; str = a.a(a.this).getSort())
      {
        paramViewGroup.b.setVisibility(8);
        if ((str == null) || (!str.equals(localSelectBean.getValue()))) {
          break;
        }
        paramViewGroup.a.setTextColor(a.d(a.this).getResources().getColor(2131624588));
        paramViewGroup.b.setVisibility(0);
        return paramView;
      }
      paramViewGroup.a.setTextColor(a.d(a.this).getResources().getColor(2131624415));
      paramViewGroup.b.setVisibility(8);
      return paramView;
    }
    
    class a
    {
      TextView a;
      View b;
      
      a() {}
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/findhouse/widget/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */