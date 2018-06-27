package com.ziroom.ziroomcustomer.payment.a;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.f.c;
import com.freelxl.baselibrary.f.f;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.payment.b.n;
import java.util.List;

public class b
  extends BaseAdapter
{
  private Context a;
  private List<n> b;
  private a c;
  private int d = -1;
  private int e;
  private Boolean f = Boolean.valueOf(true);
  
  public b(Context paramContext)
  {
    this.a = paramContext;
  }
  
  public b(Context paramContext, List<n> paramList, Boolean paramBoolean)
  {
    this.b = paramList;
    this.a = paramContext;
    this.f = paramBoolean;
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
  
  public Boolean getShowCheck()
  {
    return this.f;
  }
  
  public View getView(final int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    n localn;
    if (paramView == null)
    {
      paramView = View.inflate(this.a, 2130904427, null);
      paramViewGroup = new b();
      paramViewGroup.e = ((CheckBox)paramView.findViewById(2131695528));
      paramViewGroup.a = ((TextView)paramView.findViewById(2131695525));
      paramViewGroup.b = ((TextView)paramView.findViewById(2131695526));
      paramViewGroup.d = ((SimpleDraweeView)paramView.findViewById(2131695524));
      paramViewGroup.c = ((TextView)paramView.findViewById(2131695527));
      paramView.setTag(paramViewGroup);
      localn = (n)this.b.get(paramInt);
      if ((this.f.booleanValue()) && ((localn.getLimit() <= 0) || (this.e <= localn.getLimit()))) {
        break label380;
      }
      paramViewGroup.e.setVisibility(4);
      paramViewGroup.a.setAlpha(0.6F);
      paramViewGroup.b.setAlpha(0.6F);
      paramViewGroup.d.setAlpha(0.6F);
      paramViewGroup.c.setAlpha(0.6F);
      if ((this.f.booleanValue()) && (localn.getLimit() >= 0)) {
        break label330;
      }
      paramViewGroup.c.setText(localn.getDesc());
      label213:
      if (this.d != paramInt) {
        break label435;
      }
      if (paramViewGroup.e.getVisibility() != 0)
      {
        this.d = -1;
        this.c.setPayType(null);
      }
      paramViewGroup.e.setChecked(true);
      label254:
      paramViewGroup.a.setText(localn.getPayTypeTitle());
      paramViewGroup.d.setController(c.frescoController(localn.getIcon()));
      if (!f.isNull(localn.getRedPacketDesc())) {
        break label446;
      }
      paramViewGroup.b.setVisibility(8);
    }
    for (;;)
    {
      paramViewGroup.e.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          if (b.a(b.this) == paramInt)
          {
            b.a(b.this, -1);
            b.b(b.this).setPayType(null);
            return;
          }
          b.a(b.this, paramInt);
          b.b(b.this).setPayType((n)b.c(b.this).get(paramInt));
          b.this.notifyDataSetChanged();
        }
      });
      return paramView;
      paramViewGroup = (b)paramView.getTag();
      break;
      label330:
      paramViewGroup.c.setText(localn.getDesc() + "(限额" + localn.getLimit() / 100.0F + "元)");
      break label213;
      label380:
      paramViewGroup.e.setVisibility(0);
      paramViewGroup.a.setAlpha(1.0F);
      paramViewGroup.b.setAlpha(1.0F);
      paramViewGroup.d.setAlpha(1.0F);
      paramViewGroup.c.setAlpha(1.0F);
      paramViewGroup.c.setText(localn.getDesc());
      break label213;
      label435:
      paramViewGroup.e.setChecked(false);
      break label254;
      label446:
      paramViewGroup.b.setVisibility(0);
      paramViewGroup.b.setText(localn.getRedPacketDesc());
    }
  }
  
  public List<n> getmList()
  {
    return this.b;
  }
  
  public int getmPayMoney()
  {
    return this.e;
  }
  
  public a getmPayType()
  {
    return this.c;
  }
  
  public void setSelectedItem(int paramInt)
  {
    if (paramInt < getCount())
    {
      n localn = (n)this.b.get(paramInt);
      if ((this.f.booleanValue()) && ((localn.getLimit() <= 0) || (this.e <= localn.getLimit()))) {
        break label55;
      }
    }
    for (;;)
    {
      notifyDataSetChanged();
      return;
      label55:
      if (-1 == this.d)
      {
        this.d = paramInt;
        this.c.setPayType((n)this.b.get(paramInt));
      }
    }
  }
  
  public void setShowCheck(Boolean paramBoolean)
  {
    this.f = paramBoolean;
    setSelectedItem(0);
  }
  
  public void setmList(List<n> paramList)
  {
    this.b = paramList;
    setSelectedItem(0);
  }
  
  public void setmListAndMaxMoney(List<n> paramList, int paramInt)
  {
    this.f = Boolean.valueOf(true);
    this.b = paramList;
    this.e = paramInt;
    setSelectedItem(0);
  }
  
  public void setmPayMoney(int paramInt)
  {
    this.f = Boolean.valueOf(true);
    this.e = paramInt;
    notifyDataSetChanged();
  }
  
  public void setmPayType(a parama)
  {
    this.c = parama;
  }
  
  public static abstract interface a
  {
    public abstract void setPayType(n paramn);
  }
  
  class b
  {
    TextView a;
    TextView b;
    TextView c;
    SimpleDraweeView d;
    CheckBox e;
    
    b() {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/payment/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */