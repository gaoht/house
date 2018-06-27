package com.ziroom.ziroomcustomer.findhouse.widget;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.findhouse.model.SelectBean;
import java.util.List;

public class SingleListPop
  extends PopupWindow
{
  private Context a;
  private LinearLayout b;
  private ListView c;
  private a d;
  private List<SelectBean> e;
  private int f = -1;
  private String g = "--null--";
  private HouseList_ConditionalView.c h;
  private c i;
  
  public SingleListPop(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SingleListPop(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SingleListPop(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setSoftInputMode(16);
    setWidth(-1);
    setHeight(-1);
    setAnimationStyle(2131427934);
    this.a = paramContext;
    this.b = ((LinearLayout)LayoutInflater.from(paramContext).inflate(2130905061, null));
    a();
    setContentView(this.b);
  }
  
  private void a()
  {
    this.c = ((ListView)this.b.findViewById(2131689817));
    this.b.findViewById(2131694517).setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        SingleListPop.this.dismiss();
      }
    });
    this.d = new a();
    this.c.setAdapter(this.d);
    setOnDismissListener(new PopupWindow.OnDismissListener()
    {
      public void onDismiss()
      {
        if (SingleListPop.a(SingleListPop.this) != null) {
          SingleListPop.a(SingleListPop.this).onDismiss();
        }
      }
    });
    this.c.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      @Instrumented
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        VdsAgent.onItemClick(this, paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
        paramAnonymousAdapterView = (SelectBean)SingleListPop.b(SingleListPop.this).get(paramAnonymousInt);
        SingleListPop.a(SingleListPop.this, paramAnonymousInt);
        if ((SingleListPop.c(SingleListPop.this) != null) && (paramAnonymousAdapterView != null)) {
          SingleListPop.c(SingleListPop.this).onSelect(paramAnonymousAdapterView.getTitle(), paramAnonymousAdapterView.getValue());
        }
        SingleListPop.this.dismiss();
      }
    });
  }
  
  public void setOnSelectListener(c paramc)
  {
    this.i = paramc;
  }
  
  public void setPopDismisListener(HouseList_ConditionalView.c paramc)
  {
    this.h = paramc;
  }
  
  public void show(View paramView, List<SelectBean> paramList, String paramString)
  {
    if ((this.e == null) || (this.e.size() < 1))
    {
      this.e = paramList;
      this.d.setList(this.e);
      this.d.notifyDataSetChanged();
    }
    if (!TextUtils.isEmpty(paramString))
    {
      this.g = paramString;
      this.d.notifyDataSetChanged();
    }
    if (!(this instanceof PopupWindow))
    {
      super.showAsDropDown(paramView);
      return;
    }
    VdsAgent.showAsDropDown((PopupWindow)this, paramView);
  }
  
  class a
    extends BaseAdapter
  {
    private List<SelectBean> b;
    
    a() {}
    
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
        paramViewGroup = new SingleListPop.b();
        paramView = LayoutInflater.from(SingleListPop.d(SingleListPop.this)).inflate(2130903676, null);
        paramViewGroup.a = ((TextView)paramView.findViewById(2131693236));
        paramView.setTag(paramViewGroup);
        paramViewGroup.a.setTextSize(2, 14.0F);
        paramViewGroup.a.setText(((SelectBean)this.b.get(paramInt)).getTitle());
        paramViewGroup.a.setTextColor(SingleListPop.d(SingleListPop.this).getResources().getColor(2131624415));
        if (SingleListPop.e(SingleListPop.this) != paramInt) {
          break label148;
        }
        paramViewGroup.a.setTextColor(SingleListPop.d(SingleListPop.this).getResources().getColor(2131624588));
      }
      label148:
      while ((SingleListPop.f(SingleListPop.this) == null) || (!SingleListPop.f(SingleListPop.this).equals(((SelectBean)this.b.get(paramInt)).getValue())))
      {
        return paramView;
        paramViewGroup = (SingleListPop.b)paramView.getTag();
        break;
      }
      paramViewGroup.a.setTextColor(SingleListPop.d(SingleListPop.this).getResources().getColor(2131624588));
      return paramView;
    }
    
    public void setList(List<SelectBean> paramList)
    {
      this.b = paramList;
    }
  }
  
  static class b
  {
    TextView a;
  }
  
  public static abstract interface c
  {
    public abstract void onSelect(String paramString1, String paramString2);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/findhouse/widget/SingleListPop.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */