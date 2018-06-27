package com.ziroom.ziroomcustomer.bestgoods.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.f.c;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.bestgoods.model.ax;
import com.ziroom.ziroomcustomer.bestgoods.model.t;
import com.ziroom.ziroomcustomer.bestgoods.model.v;
import com.ziroom.ziroomcustomer.e.c.a.e;
import com.ziroom.ziroomcustomer.e.c.m;
import com.ziroom.ziroomcustomer.e.n;
import com.ziroom.ziroomcustomer.minsu.f.aa;
import com.ziroom.ziroomcustomer.model.UserInfo;
import com.ziroom.ziroomcustomer.util.af;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class an
  extends BaseExpandableListAdapter
{
  private Context a;
  private List<v> b;
  private b c;
  private List<ax> d = new ArrayList();
  private String e = "";
  private DecimalFormat f = new DecimalFormat("0.00");
  
  public an(Context paramContext, List<v> paramList, b paramb)
  {
    this.a = paramContext;
    this.b = paramList;
    this.c = paramb;
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3)
  {
    String str1 = ((t)((v)this.b.get(paramInt1)).getShoppingCartEntityList().get(paramInt2)).getProductCode();
    String str2 = ((t)((v)this.b.get(paramInt1)).getShoppingCartEntityList().get(paramInt2)).getLogicCode();
    String str3 = ((t)((v)this.b.get(paramInt1)).getShoppingCartEntityList().get(paramInt2)).getShoppingCartCode();
    int i = ((t)((v)this.b.get(paramInt1)).getShoppingCartEntityList().get(paramInt2)).getAmount().intValue();
    ax localax = new ax();
    localax.setSkuCode(str2);
    localax.setAmount(Integer.valueOf(i));
    localax.setProductCode(str1);
    localax.setUid(this.e);
    localax.setCityCode(aa.getString(this.a, "currentYouPinCityCode", "000000"));
    localax.setShoopingCartCode(str3);
    if ((this.d != null) && (!this.d.isEmpty())) {
      this.d.clear();
    }
    if (i != 0) {
      this.d.add(localax);
    }
    n.addYouPinShoppingCart(this.a, this.d, new com.ziroom.ziroomcustomer.e.a.a(this.a, new m(String.class, new e()))
    {
      public void onSuccess(int paramAnonymousInt, String paramAnonymousString)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousString);
      }
    });
    ((t)((v)this.b.get(paramInt1)).getShoppingCartEntityList().get(paramInt2)).setAmount(Integer.valueOf(paramInt3));
    this.c.setChildChanged(this.b, paramInt1, paramInt2);
  }
  
  public Object getChild(int paramInt1, int paramInt2)
  {
    return null;
  }
  
  public long getChildId(int paramInt1, int paramInt2)
  {
    return paramInt2;
  }
  
  public View getChildView(final int paramInt1, final int paramInt2, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    final List localList;
    label260:
    label394:
    int i;
    int j;
    if (paramView == null)
    {
      paramViewGroup = new c();
      paramView = LayoutInflater.from(this.a).inflate(2130904599, null);
      paramViewGroup.b = paramView.findViewById(2131695814);
      paramViewGroup.a = ((RelativeLayout)paramView.findViewById(2131695851));
      paramViewGroup.d = ((SimpleDraweeView)paramView.findViewById(2131695815));
      paramViewGroup.e = ((TextView)paramView.findViewById(2131695794));
      paramViewGroup.f = ((TextView)paramView.findViewById(2131695816));
      paramViewGroup.g = ((TextView)paramView.findViewById(2131695818));
      paramViewGroup.c = ((ImageView)paramView.findViewById(2131695852));
      paramViewGroup.h = ((ImageView)paramView.findViewById(2131695854));
      paramViewGroup.i = ((RelativeLayout)paramView.findViewById(2131695853));
      paramViewGroup.j = ((TextView)paramView.findViewById(2131695817));
      paramViewGroup.k = ((ImageView)paramView.findViewById(2131695856));
      paramViewGroup.l = ((RelativeLayout)paramView.findViewById(2131695855));
      paramView.setTag(paramViewGroup);
      localList = ((v)this.b.get(paramInt1)).getShoppingCartEntityList();
      if (!((t)localList.get(paramInt2)).isChildSelect()) {
        break label582;
      }
      paramViewGroup.c.setImageResource(2130840187);
      paramViewGroup.d.setController(c.frescoController(((t)localList.get(paramInt2)).getUrl()));
      paramViewGroup.e.setText(((t)localList.get(paramInt2)).getName());
      paramViewGroup.f.setText(((t)localList.get(paramInt2)).getSpecificationName());
      if (((t)localList.get(paramInt2)).getActivityType() != null) {
        break label596;
      }
      paramViewGroup.g.setText("￥" + this.f.format(((t)localList.get(paramInt2)).getPrice()));
      i = ((t)localList.get(paramInt2)).getAmounts().intValue();
      j = ((t)localList.get(paramInt2)).getAmount().intValue();
      paramViewGroup.j.setText(j + "");
      if (i < 9) {
        break label647;
      }
      i = 9;
      label471:
      if (j != 1) {
        break label681;
      }
      if (j >= i) {
        break label650;
      }
      paramViewGroup.h.setImageResource(2130840252);
      paramViewGroup.k.setImageResource(2130840245);
    }
    for (;;)
    {
      paramViewGroup.c.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          if (((t)localList.get(paramInt2)).isChildSelect()) {
            ((t)localList.get(paramInt2)).setChildSelect(false);
          }
          for (;;)
          {
            an.b(an.this).setChildChanged(an.a(an.this), paramInt1, paramInt2);
            return;
            ((t)localList.get(paramInt2)).setChildSelect(true);
          }
        }
      });
      paramViewGroup.i.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          int j = 9;
          VdsAgent.onClick(this, paramAnonymousView);
          paramAnonymousView = ApplicationEx.c.getUser();
          if (paramAnonymousView == null)
          {
            com.ziroom.commonlibrary.login.a.startLoginActivity(an.c(an.this));
            return;
          }
          an.a(an.this, paramAnonymousView.getUid());
          paramAnonymousView = ((t)localList.get(paramInt2)).getAmounts();
          int k = ((t)localList.get(paramInt2)).getAmount().intValue();
          if (paramAnonymousView.intValue() >= 9) {}
          int i;
          while (k == 1) {
            if (k < j)
            {
              af.showToast(an.c(an.this), "最小数量为1");
              ((t)((v)an.a(an.this).get(paramInt1)).getShoppingCartEntityList().get(paramInt2)).setAmount(Integer.valueOf(k));
              an.b(an.this).setChildChanged(an.a(an.this), paramInt1, paramInt2);
              return;
              j = paramAnonymousView.intValue();
            }
            else
            {
              i = k;
              if (j > 1) {
                break label335;
              }
              af.showToast(an.c(an.this), "最小数量为1");
              ((t)((v)an.a(an.this).get(paramInt1)).getShoppingCartEntityList().get(paramInt2)).setAmount(Integer.valueOf(j));
              an.b(an.this).setChildChanged(an.a(an.this), paramInt1, paramInt2);
              return;
            }
          }
          if (k > j)
          {
            ((t)((v)an.a(an.this).get(paramInt1)).getShoppingCartEntityList().get(paramInt2)).setAmount(Integer.valueOf(j));
            i = j;
          }
          for (;;)
          {
            label335:
            paramAnonymousView = ((t)((v)an.a(an.this).get(paramInt1)).getShoppingCartEntityList().get(paramInt2)).getProductCode();
            String str1 = ((t)((v)an.a(an.this).get(paramInt1)).getShoppingCartEntityList().get(paramInt2)).getLogicCode();
            String str2 = ((t)((v)an.a(an.this).get(paramInt1)).getShoppingCartEntityList().get(paramInt2)).getShoppingCartCode();
            j = ((t)((v)an.a(an.this).get(paramInt1)).getShoppingCartEntityList().get(paramInt2)).getAmount().intValue();
            ax localax = new ax();
            localax.setSkuCode(str1);
            localax.setAmount(Integer.valueOf(j));
            localax.setProductCode(paramAnonymousView);
            localax.setUid(an.d(an.this));
            localax.setCityCode(aa.getString(an.c(an.this), "currentYouPinCityCode", "000000"));
            localax.setShoopingCartCode(str2);
            if ((an.e(an.this) != null) && (!an.e(an.this).isEmpty())) {
              an.e(an.this).clear();
            }
            if (j != 0) {
              an.e(an.this).add(localax);
            }
            n.addYouPinShoppingCart(an.c(an.this), an.e(an.this), new com.ziroom.ziroomcustomer.e.a.a(an.c(an.this), new m(String.class, new e()))
            {
              public void onSuccess(int paramAnonymous2Int, String paramAnonymous2String)
              {
                super.onSuccess(paramAnonymous2Int, paramAnonymous2String);
              }
            });
            ((t)((v)an.a(an.this).get(paramInt1)).getShoppingCartEntityList().get(paramInt2)).setAmount(Integer.valueOf(i));
            an.b(an.this).setChildChanged(an.a(an.this), paramInt1, paramInt2);
            return;
            if (k == j)
            {
              i = k - 1;
              ((t)((v)an.a(an.this).get(paramInt1)).getShoppingCartEntityList().get(paramInt2)).setAmount(Integer.valueOf(i));
            }
            else
            {
              i = k;
              if (k < j)
              {
                i = k - 1;
                ((t)((v)an.a(an.this).get(paramInt1)).getShoppingCartEntityList().get(paramInt2)).setAmount(Integer.valueOf(i));
              }
            }
          }
        }
      });
      paramViewGroup.l.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          int j = 9;
          VdsAgent.onClick(this, paramAnonymousView);
          paramAnonymousView = ApplicationEx.c.getUser();
          if (paramAnonymousView == null)
          {
            com.ziroom.commonlibrary.login.a.startLoginActivity(an.c(an.this));
            return;
          }
          an.a(an.this, paramAnonymousView.getUid());
          int i = ((t)localList.get(paramInt2)).getAmounts().intValue();
          int k = ((t)localList.get(paramInt2)).getAmount().intValue();
          if (i >= 9)
          {
            if (k != 1) {
              break label299;
            }
            if (k >= j) {
              break label175;
            }
            i = k + 1;
            ((t)((v)an.a(an.this).get(paramInt1)).getShoppingCartEntityList().get(paramInt2)).setAmount(Integer.valueOf(i));
          }
          for (;;)
          {
            an.a(an.this, paramInt1, paramInt2, i);
            return;
            j = i;
            break;
            label175:
            i = k;
            if (j <= 1)
            {
              af.showToast(an.c(an.this), ((t)localList.get(paramInt2)).getName() + "库存不足");
              ((t)((v)an.a(an.this).get(paramInt1)).getShoppingCartEntityList().get(paramInt2)).setAmount(Integer.valueOf(j));
              an.b(an.this).setChildChanged(an.a(an.this), paramInt1, paramInt2);
              return;
              label299:
              if (k > j)
              {
                af.showToast(an.c(an.this), ((t)localList.get(paramInt2)).getName() + "已达物品最大数量");
                ((t)((v)an.a(an.this).get(paramInt1)).getShoppingCartEntityList().get(paramInt2)).setAmount(Integer.valueOf(j));
                an.a(an.this, paramInt1, paramInt2, j);
                an.b(an.this).setChildChanged(an.a(an.this), paramInt1, paramInt2);
                return;
              }
              if (k == j)
              {
                af.showToast(an.c(an.this), ((t)localList.get(paramInt2)).getName() + "已达物品最大数量");
                ((t)((v)an.a(an.this).get(paramInt1)).getShoppingCartEntityList().get(paramInt2)).setAmount(Integer.valueOf(j));
                an.b(an.this).setChildChanged(an.a(an.this), paramInt1, paramInt2);
                return;
              }
              i = k;
              if (k < j)
              {
                i = k + 1;
                ((t)((v)an.a(an.this).get(paramInt1)).getShoppingCartEntityList().get(paramInt2)).setAmount(Integer.valueOf(i));
              }
            }
          }
        }
      });
      return paramView;
      paramViewGroup = (c)paramView.getTag();
      break;
      label582:
      paramViewGroup.c.setImageResource(2130840186);
      break label260;
      label596:
      paramViewGroup.g.setText("￥" + this.f.format(((t)localList.get(paramInt2)).getActivityPrice()));
      break label394;
      label647:
      break label471;
      label650:
      if (i <= 1)
      {
        paramViewGroup.h.setImageResource(2130840252);
        paramViewGroup.k.setImageResource(2130840246);
        continue;
        label681:
        if (j > i)
        {
          paramViewGroup.h.setImageResource(2130840251);
          paramViewGroup.k.setImageResource(2130840246);
        }
        else if (j == i)
        {
          paramViewGroup.h.setImageResource(2130840251);
          paramViewGroup.k.setImageResource(2130840246);
        }
        else if (j < i)
        {
          paramViewGroup.h.setImageResource(2130840251);
          paramViewGroup.k.setImageResource(2130840245);
        }
      }
    }
  }
  
  public int getChildrenCount(int paramInt)
  {
    if (((v)this.b.get(paramInt)).getShoppingCartEntityList() == null) {
      return 0;
    }
    return ((v)this.b.get(paramInt)).getShoppingCartEntityList().size();
  }
  
  public Object getGroup(int paramInt)
  {
    return this.b.get(paramInt);
  }
  
  public int getGroupCount()
  {
    if (this.b == null) {
      return 0;
    }
    return this.b.size();
  }
  
  public long getGroupId(int paramInt)
  {
    return paramInt;
  }
  
  public View getGroupView(final int paramInt, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramViewGroup = new a();
      paramView = View.inflate(this.a, 2130904600, null);
      paramViewGroup.b = ((ImageView)paramView.findViewById(2131695857));
      paramViewGroup.a = ((TextView)paramView.findViewById(2131690739));
      paramView.setTag(paramViewGroup);
      paramBoolean = ((v)this.b.get(paramInt)).isGroupSelect();
      ((v)this.b.get(paramInt)).getShoppingCartEntityList();
      if (!paramBoolean) {
        break label165;
      }
      paramViewGroup.b.setImageResource(2130840187);
    }
    for (;;)
    {
      paramViewGroup.a.setText(((v)this.b.get(paramInt)).getProviderName());
      paramViewGroup.b.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          int i = 0;
          VdsAgent.onClick(this, paramAnonymousView);
          boolean bool = ((v)an.a(an.this).get(paramInt)).isGroupSelect();
          paramAnonymousView = ((v)an.a(an.this).get(paramInt)).getShoppingCartEntityList();
          if (bool)
          {
            ((v)an.a(an.this).get(paramInt)).setGroupSelect(false);
            if ((paramAnonymousView != null) && (!paramAnonymousView.isEmpty()))
            {
              i = 0;
              while (i < paramAnonymousView.size())
              {
                ((t)paramAnonymousView.get(i)).setChildSelect(false);
                i += 1;
              }
            }
          }
          else
          {
            ((v)an.a(an.this).get(paramInt)).setGroupSelect(true);
            if ((paramAnonymousView != null) && (!paramAnonymousView.isEmpty())) {
              while (i < paramAnonymousView.size())
              {
                ((t)paramAnonymousView.get(i)).setChildSelect(true);
                i += 1;
              }
            }
          }
          an.b(an.this).setGroupChanged(an.a(an.this), paramInt);
        }
      });
      return paramView;
      paramViewGroup = (a)paramView.getTag();
      break;
      label165:
      paramViewGroup.b.setImageResource(2130840186);
    }
  }
  
  public boolean hasStableIds()
  {
    return true;
  }
  
  public boolean isChildSelectable(int paramInt1, int paramInt2)
  {
    return true;
  }
  
  public static class a
  {
    TextView a;
    ImageView b;
  }
  
  public static abstract interface b
  {
    public abstract void setChildChanged(List<v> paramList, int paramInt1, int paramInt2);
    
    public abstract void setGroupChanged(List<v> paramList, int paramInt);
  }
  
  public static class c
  {
    RelativeLayout a;
    View b;
    ImageView c;
    SimpleDraweeView d;
    TextView e;
    TextView f;
    TextView g;
    ImageView h;
    RelativeLayout i;
    TextView j;
    ImageView k;
    RelativeLayout l;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/bestgoods/a/an.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */