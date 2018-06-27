package com.ziroom.ziroomcustomer.findhouse.widget;

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
import com.ziroom.ziroomcustomer.findhouse.model.SelectBean;
import com.ziroom.ziroomcustomer.model.SearchCondition;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class PriceListPop
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
  private List<SelectBean> k = new ArrayList();
  private int l = 0;
  private int m = 0;
  private int n = 15000;
  private HouseList_ConditionalView.c o;
  private a p;
  
  public PriceListPop(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public PriceListPop(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public PriceListPop(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
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
      this.i = LayoutInflater.from(paramContext).inflate(2130905047, null);
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
        PriceListPop.a(PriceListPop.this, paramAnonymousInt1);
        PriceListPop.b(PriceListPop.this, paramAnonymousInt2);
        if (PriceListPop.a(PriceListPop.this) != 15000) {
          PriceListPop.b(PriceListPop.this).setText("¥" + paramAnonymousInt1 + " - ¥" + paramAnonymousInt2);
        }
        for (;;)
        {
          if (PriceListPop.c(PriceListPop.this)) {
            PriceListPop.a(false);
          }
          return;
          PriceListPop.b(PriceListPop.this).setText("¥" + paramAnonymousInt1 + " - 不限");
        }
      }
    });
    this.a.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      @Instrumented
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        VdsAgent.onItemClick(this, paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
        if ((PriceListPop.d(PriceListPop.this) != null) && (PriceListPop.e(PriceListPop.this) != null) && (PriceListPop.e(PriceListPop.this).size() > paramAnonymousInt))
        {
          paramAnonymousAdapterView = (SelectBean)PriceListPop.e(PriceListPop.this).get(paramAnonymousInt);
          if ((paramAnonymousAdapterView != null) && (paramAnonymousAdapterView.getValue() != null))
          {
            paramAnonymousView = paramAnonymousAdapterView.getValue().split(",", 2);
            if (!"".equals(paramAnonymousView[0])) {
              break label171;
            }
            PriceListPop.a(PriceListPop.this, 0);
            if (!"".equals(paramAnonymousView[1])) {
              break label188;
            }
            PriceListPop.b(PriceListPop.this, 0);
            label124:
            if (!"不限".equals(paramAnonymousAdapterView.getTitle())) {
              break label205;
            }
            PriceListPop.d(PriceListPop.this).select(PriceListPop.f(PriceListPop.this), PriceListPop.a(PriceListPop.this), false);
          }
        }
        for (;;)
        {
          PriceListPop.this.dismiss();
          return;
          label171:
          PriceListPop.a(PriceListPop.this, Integer.parseInt(paramAnonymousView[0]));
          break;
          label188:
          PriceListPop.b(PriceListPop.this, Integer.parseInt(paramAnonymousView[1]));
          break label124;
          label205:
          PriceListPop.d(PriceListPop.this).select(PriceListPop.f(PriceListPop.this), PriceListPop.a(PriceListPop.this), true);
        }
      }
    });
    setOnDismissListener(new PopupWindow.OnDismissListener()
    {
      public void onDismiss()
      {
        if (PriceListPop.g(PriceListPop.this) != null) {
          PriceListPop.g(PriceListPop.this).onDismiss();
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
      if (this.p != null)
      {
        if (this.l > 15000) {
          this.l = 15000;
        }
        if (this.m > 15000) {
          this.m = 15000;
        }
        if (!f) {
          break label107;
        }
        this.p.select(this.l, this.m, false);
      }
      for (;;)
      {
        dismiss();
        return;
        label107:
        this.p.select(this.l, this.m, true);
      }
    }
    this.l = 0;
    this.m = 15000;
    this.c.setThumbIndices(0, 150);
    this.j.notifyDataSetChanged();
    f = true;
  }
  
  public void setOnSelectListener(a parama)
  {
    this.p = parama;
  }
  
  public void setPopDismisListener(HouseList_ConditionalView.c paramc)
  {
    this.o = paramc;
  }
  
  public void show(View paramView, List<SelectBean> paramList, SearchCondition paramSearchCondition, boolean paramBoolean)
  {
    f = paramBoolean;
    this.k.clear();
    this.k.addAll(paramList);
    int i1 = 50;
    if (paramSearchCondition == null)
    {
      this.g = false;
      if ((0 != 0) || (0 != 0)) {
        break label169;
      }
      this.c.setThumbIndices(0, i1);
    }
    for (;;)
    {
      this.l = 0;
      this.m = 0;
      a(this.a);
      this.j.notifyDataSetChanged();
      this.g = true;
      if ((this instanceof PopupWindow)) {
        break label198;
      }
      showAsDropDown(paramView, 0, 0);
      return;
      paramList = paramSearchCondition.getTypeSet();
      if ((paramList.size() == 1) && (paramList.contains(Integer.valueOf(1))))
      {
        this.c.setTickCount(51);
        this.n = 5000;
        break;
      }
      this.c.setTickCount(151);
      this.n = 15000;
      i1 = 150;
      break;
      label169:
      if (0 == 0) {
        this.c.setThumbIndices(0, i1);
      } else {
        this.c.setThumbIndices(0, 0);
      }
    }
    label198:
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
    private List<SelectBean> b;
    
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
        paramView = LayoutInflater.from(PriceListPop.h(PriceListPop.this)).inflate(2130903676, null);
        paramViewGroup = new a();
        paramViewGroup.a = ((TextView)paramView.findViewById(2131693236));
        paramViewGroup.b = paramView.findViewById(2131693237);
        paramView.setTag(paramViewGroup);
      }
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
      Object localObject = localSelectBean.getValue().split(",", 2);
      SelectBean localSelectBean = localObject[0];
      localObject = localObject[1];
      if ("".equals(localSelectBean))
      {
        paramInt = 0;
        if (!"".equals(localObject)) {
          break label242;
        }
      }
      label242:
      for (int i = 0;; i = Integer.parseInt((String)localObject))
      {
        if ((PriceListPop.f(PriceListPop.this) != paramInt) || (PriceListPop.a(PriceListPop.this) != i) || (PriceListPop.a())) {
          break label252;
        }
        paramViewGroup.a.setTextColor(PriceListPop.h(PriceListPop.this).getResources().getColor(2131624588));
        paramViewGroup.b.setVisibility(0);
        return paramView;
        paramInt = Integer.parseInt(localSelectBean);
        break;
      }
      label252:
      paramViewGroup.a.setTextColor(PriceListPop.h(PriceListPop.this).getResources().getColor(2131624415));
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


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/findhouse/widget/PriceListPop.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */