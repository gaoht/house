package com.ziroom.ziroomcustomer.ziroomapartment.dialog;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.util.u;
import com.ziroom.ziroomcustomer.ziroomapartment.model.ZryuSearchConditionV2.CityListBean;
import com.ziroom.ziroomcustomer.ziroomapartment.widget.ProjectListConditionalView.b;
import java.util.ArrayList;
import java.util.List;

public class ZryuCityListPop
  extends PopupWindow
{
  private String a = ZryuCityListPop.class.getSimpleName();
  private ListView b;
  private Context c;
  private View d;
  private a e;
  private List<ZryuSearchConditionV2.CityListBean> f = new ArrayList();
  private int g = -1;
  private ProjectListConditionalView.b h;
  private b i;
  
  public ZryuCityListPop(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ZryuCityListPop(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ZryuCityListPop(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setSoftInputMode(16);
    setWidth(-1);
    if (Build.VERSION.SDK_INT >= 24) {
      setHeight(-2);
    }
    for (;;)
    {
      setAnimationStyle(2131427934);
      this.d = LayoutInflater.from(paramContext).inflate(2130905068, null);
      this.c = paramContext;
      a();
      return;
      setHeight(-1);
    }
  }
  
  private void a()
  {
    this.b = ((ListView)this.d.findViewById(2131697318));
    this.e = new a(this.f);
    this.b.setAdapter(this.e);
    this.b.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      @Instrumented
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        VdsAgent.onItemClick(this, paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
        ZryuCityListPop.a(ZryuCityListPop.this, paramAnonymousInt);
        if ((ZryuCityListPop.a(ZryuCityListPop.this) != null) && (ZryuCityListPop.b(ZryuCityListPop.this) != null) && (ZryuCityListPop.b(ZryuCityListPop.this).size() > paramAnonymousInt)) {
          ZryuCityListPop.a(ZryuCityListPop.this).select(ZryuCityListPop.c(ZryuCityListPop.this), true);
        }
        ZryuCityListPop.this.dismiss();
      }
    });
    setOnDismissListener(new PopupWindow.OnDismissListener()
    {
      public void onDismiss()
      {
        if (ZryuCityListPop.d(ZryuCityListPop.this) != null) {
          ZryuCityListPop.d(ZryuCityListPop.this).onDismiss();
        }
      }
    });
    setContentView(this.d);
  }
  
  private void a(ListView paramListView)
  {
    if (paramListView == null) {}
    ListAdapter localListAdapter;
    do
    {
      return;
      localListAdapter = paramListView.getAdapter();
    } while (localListAdapter == null);
    int j = 0;
    int k = 0;
    while (j < localListAdapter.getCount())
    {
      localObject = localListAdapter.getView(j, null, paramListView);
      ((View)localObject).measure(0, 0);
      k += ((View)localObject).getMeasuredHeight();
      j += 1;
    }
    Object localObject = paramListView.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).height = (paramListView.getDividerHeight() * (localListAdapter.getCount() - 1) + k);
    paramListView.setLayoutParams((ViewGroup.LayoutParams)localObject);
  }
  
  public void setOnSelectListener(b paramb)
  {
    this.i = paramb;
  }
  
  public void setPopDismisListener(ProjectListConditionalView.b paramb)
  {
    this.h = paramb;
  }
  
  public void show(View paramView, List<ZryuSearchConditionV2.CityListBean> paramList, int paramInt)
  {
    this.f.clear();
    this.f.addAll(paramList);
    this.g = paramInt;
    a(this.b);
    this.e.notifyDataSetChanged();
    if (!(this instanceof PopupWindow))
    {
      showAsDropDown(paramView, 0, 0);
      return;
    }
    VdsAgent.showAsDropDown((PopupWindow)this, paramView, 0, 0);
  }
  
  public void showAsDropDown(View paramView, int paramInt1, int paramInt2)
  {
    if (Build.VERSION.SDK_INT == 24)
    {
      int[] arrayOfInt = new int[2];
      paramView.getLocationInWindow(arrayOfInt);
      paramInt2 = arrayOfInt[1] + paramView.getHeight() + paramInt2;
      if (!(this instanceof PopupWindow))
      {
        showAtLocation(paramView, 0, paramInt1, paramInt2);
        return;
      }
      VdsAgent.showAtLocation((PopupWindow)this, paramView, 0, paramInt1, paramInt2);
      return;
    }
    super.showAsDropDown(paramView, paramInt1, paramInt2);
  }
  
  class a
    extends BaseAdapter
  {
    private List<ZryuSearchConditionV2.CityListBean> b;
    
    public a()
    {
      List localList;
      this.b = localList;
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
        paramView = LayoutInflater.from(ZryuCityListPop.e(ZryuCityListPop.this)).inflate(2130903676, null);
        paramViewGroup = new a();
        paramViewGroup.a = ((TextView)paramView.findViewById(2131693236));
        paramViewGroup.b = paramView.findViewById(2131693237);
        paramView.setTag(paramViewGroup);
      }
      for (;;)
      {
        paramViewGroup.a.setText(((ZryuSearchConditionV2.CityListBean)this.b.get(paramInt)).cityName);
        u.i(ZryuCityListPop.f(ZryuCityListPop.this), "position:" + paramInt + ";selected:" + ZryuCityListPop.c(ZryuCityListPop.this));
        if (paramInt != ZryuCityListPop.c(ZryuCityListPop.this)) {
          break;
        }
        paramViewGroup.a.setTextColor(ZryuCityListPop.e(ZryuCityListPop.this).getResources().getColor(2131624588));
        paramViewGroup.b.setVisibility(0);
        return paramView;
        paramViewGroup = (a)paramView.getTag();
      }
      paramViewGroup.a.setTextColor(ZryuCityListPop.e(ZryuCityListPop.this).getResources().getColor(2131624415));
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
  
  public static abstract interface b
  {
    public abstract void select(int paramInt, boolean paramBoolean);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomapartment/dialog/ZryuCityListPop.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */