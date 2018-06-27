package com.ziroom.ziroomcustomer.ziroomapartment.dialog;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
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
import com.ziroom.commonlibrary.widget.rangebar.RangeBar;
import com.ziroom.commonlibrary.widget.rangebar.RangeBar.a;
import com.ziroom.ziroomcustomer.ziroomapartment.model.ZryuSearchConditionV2.PriceRangeListBean;
import com.ziroom.ziroomcustomer.ziroomapartment.widget.ProjectListConditionalView.b;
import java.util.ArrayList;
import java.util.List;

public class ZryuPriceListPop
  extends PopupWindow
  implements View.OnClickListener
{
  private static boolean f = false;
  private ListView a;
  private TextView b;
  private RangeBar c;
  private TextView d;
  private TextView e;
  private boolean g = true;
  private Context h;
  private View i;
  private b j;
  private List<ZryuSearchConditionV2.PriceRangeListBean> k = new ArrayList();
  private int l = 0;
  private int m = 0;
  private int n;
  private int o;
  private ProjectListConditionalView.b p;
  private a q;
  
  public ZryuPriceListPop(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ZryuPriceListPop(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ZryuPriceListPop(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
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
      this.i = LayoutInflater.from(paramContext).inflate(2130905070, null);
      this.h = paramContext;
      b();
      return;
      setHeight(-1);
    }
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
    int i1 = 0;
    int i2 = 0;
    while (i1 < localListAdapter.getCount())
    {
      localObject = localListAdapter.getView(i1, null, paramListView);
      ((View)localObject).measure(0, 0);
      i2 += ((View)localObject).getMeasuredHeight();
      i1 += 1;
    }
    Object localObject = paramListView.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).height = (paramListView.getDividerHeight() * (localListAdapter.getCount() - 1) + i2);
    paramListView.setLayoutParams((ViewGroup.LayoutParams)localObject);
  }
  
  private void b()
  {
    this.a = ((ListView)this.i.findViewById(2131697318));
    this.b = ((TextView)this.i.findViewById(2131697304));
    this.c = ((RangeBar)this.i.findViewById(2131691679));
    this.d = ((TextView)this.i.findViewById(2131691289));
    this.e = ((TextView)this.i.findViewById(2131693064));
    this.d.setOnClickListener(this);
    this.e.setOnClickListener(this);
    this.j = new b(this.k);
    this.a.setAdapter(this.j);
    this.c.setOnRangeBarChangeListener(new RangeBar.a()
    {
      public void onIndexChangeListener(RangeBar paramAnonymousRangeBar, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        paramAnonymousInt1 *= 100;
        paramAnonymousInt2 *= 100;
        ZryuPriceListPop.a(ZryuPriceListPop.this, paramAnonymousInt1);
        ZryuPriceListPop.b(ZryuPriceListPop.this, paramAnonymousInt2);
        if ((ZryuPriceListPop.a(ZryuPriceListPop.this) != ZryuPriceListPop.b(ZryuPriceListPop.this)) && (ZryuPriceListPop.a(ZryuPriceListPop.this) != 0)) {
          ZryuPriceListPop.c(ZryuPriceListPop.this).setText("¥" + paramAnonymousInt1 + " - ¥" + paramAnonymousInt2);
        }
        for (;;)
        {
          if (ZryuPriceListPop.d(ZryuPriceListPop.this)) {
            ZryuPriceListPop.a(false);
          }
          return;
          ZryuPriceListPop.c(ZryuPriceListPop.this).setText("¥" + paramAnonymousInt1 + " - 不限");
        }
      }
    });
    this.a.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      @Instrumented
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        VdsAgent.onItemClick(this, paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
        if ((ZryuPriceListPop.e(ZryuPriceListPop.this) != null) && (ZryuPriceListPop.f(ZryuPriceListPop.this) != null) && (ZryuPriceListPop.f(ZryuPriceListPop.this).size() > paramAnonymousInt))
        {
          paramAnonymousAdapterView = (ZryuSearchConditionV2.PriceRangeListBean)ZryuPriceListPop.f(ZryuPriceListPop.this).get(paramAnonymousInt);
          if (paramAnonymousAdapterView != null)
          {
            ZryuPriceListPop.a(ZryuPriceListPop.this, (int)paramAnonymousAdapterView.minPrice);
            ZryuPriceListPop.b(ZryuPriceListPop.this, (int)paramAnonymousAdapterView.maxPrice);
            if (!"不限".equals(paramAnonymousAdapterView.rangeDescribe)) {
              break label139;
            }
            ZryuPriceListPop.e(ZryuPriceListPop.this).select(ZryuPriceListPop.g(ZryuPriceListPop.this), ZryuPriceListPop.a(ZryuPriceListPop.this), false);
          }
        }
        for (;;)
        {
          ZryuPriceListPop.this.dismiss();
          return;
          label139:
          ZryuPriceListPop.e(ZryuPriceListPop.this).select(ZryuPriceListPop.g(ZryuPriceListPop.this), ZryuPriceListPop.a(ZryuPriceListPop.this), true);
        }
      }
    });
    setOnDismissListener(new PopupWindow.OnDismissListener()
    {
      public void onDismiss()
      {
        if (ZryuPriceListPop.h(ZryuPriceListPop.this) != null) {
          ZryuPriceListPop.h(ZryuPriceListPop.this).onDismiss();
        }
      }
    });
    setContentView(this.i);
  }
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131691289: 
      if (this.q != null)
      {
        if (!f) {
          break label73;
        }
        this.q.select(this.l, this.m, false);
      }
      for (;;)
      {
        dismiss();
        return;
        label73:
        this.q.select(this.l, this.m, true);
      }
    }
    this.l = 0;
    this.m = 0;
    this.c.setThumbIndices(0, this.n - 1);
    this.j.notifyDataSetChanged();
    f = true;
  }
  
  public void setOnSelectListener(a parama)
  {
    this.q = parama;
  }
  
  public void setPopDismisListener(ProjectListConditionalView.b paramb)
  {
    this.p = paramb;
  }
  
  public void show(View paramView, List<ZryuSearchConditionV2.PriceRangeListBean> paramList, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3)
  {
    f = paramBoolean;
    this.k.clear();
    this.k.addAll(paramList);
    this.g = false;
    this.o = paramInt3;
    this.n = (this.o / 100 + 1);
    this.c.setTickCount(this.n);
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      this.c.setThumbIndices(0, this.n - 1);
    }
    for (;;)
    {
      this.l = paramInt1;
      this.m = paramInt2;
      a(this.a);
      this.j.notifyDataSetChanged();
      this.g = true;
      if ((this instanceof PopupWindow)) {
        break;
      }
      showAsDropDown(paramView, 0, 0);
      return;
      if (paramInt2 == 0) {
        this.c.setThumbIndices(paramInt1 / 100, this.n - 1);
      } else {
        this.c.setThumbIndices(paramInt1 / 100, paramInt2 / 100);
      }
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
  
  public static abstract interface a
  {
    public abstract void select(int paramInt1, int paramInt2, boolean paramBoolean);
  }
  
  class b
    extends BaseAdapter
  {
    private List<ZryuSearchConditionV2.PriceRangeListBean> b;
    
    public b()
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
        paramView = LayoutInflater.from(ZryuPriceListPop.i(ZryuPriceListPop.this)).inflate(2130903676, null);
        paramViewGroup = new a();
        paramViewGroup.a = ((TextView)paramView.findViewById(2131693236));
        paramViewGroup.b = paramView.findViewById(2131693237);
        paramView.setTag(paramViewGroup);
      }
      ZryuSearchConditionV2.PriceRangeListBean localPriceRangeListBean;
      for (;;)
      {
        paramViewGroup.a.setText(((ZryuSearchConditionV2.PriceRangeListBean)this.b.get(paramInt)).rangeDescribe);
        localPriceRangeListBean = (ZryuSearchConditionV2.PriceRangeListBean)this.b.get(paramInt);
        if ((localPriceRangeListBean != null) && (localPriceRangeListBean.rangeDescribe != null)) {
          break;
        }
        return paramView;
        paramViewGroup = (a)paramView.getTag();
      }
      if ((ZryuPriceListPop.g(ZryuPriceListPop.this) == localPriceRangeListBean.minPrice) && (ZryuPriceListPop.a(ZryuPriceListPop.this) == localPriceRangeListBean.maxPrice) && (!ZryuPriceListPop.a()))
      {
        paramViewGroup.a.setTextColor(ZryuPriceListPop.i(ZryuPriceListPop.this).getResources().getColor(2131624588));
        paramViewGroup.b.setVisibility(0);
        return paramView;
      }
      paramViewGroup.a.setTextColor(ZryuPriceListPop.i(ZryuPriceListPop.this).getResources().getColor(2131624415));
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


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomapartment/dialog/ZryuPriceListPop.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */