package com.ziroom.ziroomcustomer.social.view;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import java.util.List;

public class SelectCityPop
  extends PopupWindow
{
  public BaseAdapter a = new BaseAdapter()
  {
    public int getCount()
    {
      if (SelectCityPop.a(SelectCityPop.this) == null) {
        return 0;
      }
      return SelectCityPop.a(SelectCityPop.this).size();
    }
    
    public Object getItem(int paramAnonymousInt)
    {
      return SelectCityPop.a(SelectCityPop.this).get(paramAnonymousInt);
    }
    
    public long getItemId(int paramAnonymousInt)
    {
      return paramAnonymousInt;
    }
    
    public View getView(final int paramAnonymousInt, View paramAnonymousView, ViewGroup paramAnonymousViewGroup)
    {
      if (paramAnonymousView == null) {
        paramAnonymousView = SelectCityPop.b(SelectCityPop.this).inflate(2130904113, paramAnonymousViewGroup, false);
      }
      for (;;)
      {
        paramAnonymousViewGroup = (TextView)paramAnonymousView;
        paramAnonymousViewGroup.setText((String)getItem(paramAnonymousInt));
        paramAnonymousViewGroup.setOnClickListener(new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymous2View)
          {
            VdsAgent.onClick(this, paramAnonymous2View);
            if (paramAnonymousInt < SelectCityPop.a(SelectCityPop.this).size())
            {
              paramAnonymous2View = (String)SelectCityPop.a(SelectCityPop.this).get(paramAnonymousInt);
              if (SelectCityPop.c(SelectCityPop.this) != null) {
                SelectCityPop.c(SelectCityPop.this).onAcCitySelected(paramAnonymous2View);
              }
            }
            SelectCityPop.this.dismiss();
          }
        });
        return paramAnonymousView;
      }
    }
  };
  private Context b;
  private ImageView c;
  private ListView d;
  private View e;
  private LayoutInflater f;
  private List<String> g;
  private a h;
  
  public SelectCityPop(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SelectCityPop(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SelectCityPop(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setSoftInputMode(16);
    setWidth(-1);
    setHeight(-1);
    setAnimationStyle(2131427507);
    this.f = ((Activity)paramContext).getLayoutInflater();
    this.e = this.f.inflate(2130904648, null);
    this.b = paramContext;
    a();
  }
  
  private void a()
  {
    this.c = ((ImageView)this.e.findViewById(2131689492));
    this.c.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        SelectCityPop.this.dismiss();
      }
    });
    this.d = ((ListView)this.e.findViewById(2131694506));
    this.d.setAdapter(this.a);
    setContentView(this.e);
  }
  
  public void setCityList(List<String> paramList)
  {
    this.g = paramList;
    this.a.notifyDataSetChanged();
  }
  
  public void show(View paramView, List<String> paramList, a parama)
  {
    setCityList(paramList);
    this.h = parama;
    if (!(this instanceof PopupWindow))
    {
      super.showAtLocation(paramView, 0, 0, 0);
      return;
    }
    VdsAgent.showAtLocation((PopupWindow)this, paramView, 0, 0, 0);
  }
  
  public static abstract interface a
  {
    public abstract void onAcCitySelected(String paramString);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/social/view/SelectCityPop.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */