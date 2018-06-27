package com.ziroom.ziroomcustomer.ziroomapartment.dialog;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.ziroomapartment.model.ZryuCity;
import java.util.List;

public class ZryuCityPop
  extends PopupWindow
  implements View.OnClickListener
{
  private Context a;
  private LayoutInflater b;
  private ImageView c;
  private ListView d;
  private View e;
  private List<ZryuCity> f;
  private b g;
  
  public ZryuCityPop(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ZryuCityPop(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ZryuCityPop(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setSoftInputMode(16);
    setWidth(-1);
    setHeight(-1);
    setAnimationStyle(2131427507);
    this.a = paramContext;
    this.b = LayoutInflater.from(paramContext);
    this.e = this.b.inflate(2130904821, null);
    a();
  }
  
  private void a()
  {
    this.c = ((ImageView)this.e.findViewById(2131689492));
    this.d = ((ListView)this.e.findViewById(2131689817));
    this.c.setOnClickListener(this);
    setContentView(this.e);
  }
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    switch (paramView.getId())
    {
    default: 
      return;
    }
    dismiss();
  }
  
  public void show(View paramView, final List<ZryuCity> paramList, b paramb)
  {
    this.f = paramList;
    this.g = paramb;
    paramList = new a(null);
    this.d.setAdapter(paramList);
    this.d.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      @Instrumented
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        VdsAgent.onItemClick(this, paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
        if (ZryuCityPop.a(ZryuCityPop.this) != null)
        {
          ZryuCityPop.a(ZryuCityPop.this).onCitySelect((ZryuCity)paramList.getItem(paramAnonymousInt));
          ZryuCityPop.this.dismiss();
        }
      }
    });
    if (!(this instanceof PopupWindow))
    {
      showAtLocation(paramView, 0, 0, 0);
      return;
    }
    VdsAgent.showAtLocation((PopupWindow)this, paramView, 0, 0, 0);
  }
  
  private class a
    extends BaseAdapter
  {
    private a() {}
    
    public int getCount()
    {
      if (ZryuCityPop.b(ZryuCityPop.this) == null) {
        return 0;
      }
      return ZryuCityPop.b(ZryuCityPop.this).size();
    }
    
    public Object getItem(int paramInt)
    {
      return ZryuCityPop.b(ZryuCityPop.this).get(paramInt);
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      paramView = ZryuCityPop.c(ZryuCityPop.this).inflate(2130904608, paramViewGroup, false);
      ((TextView)paramView).setText(((ZryuCity)getItem(paramInt)).getCityName());
      return paramView;
    }
  }
  
  public static abstract interface b
  {
    public abstract void onCitySelect(ZryuCity paramZryuCity);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomapartment/dialog/ZryuCityPop.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */