package com.ziroom.ziroomcustomer.signed;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.model.SignedPayServiceDataEntity;
import com.ziroom.ziroomcustomer.model.SignedPayServiceInfoEntity;
import com.ziroom.ziroomcustomer.util.ae;
import java.util.List;

public class i
  extends BaseAdapter
  implements View.OnClickListener
{
  private Context a;
  private b b;
  private String c = "";
  private List<SignedPayServiceDataEntity> d;
  private float e;
  private a f;
  
  public i(Context paramContext, List<SignedPayServiceDataEntity> paramList)
  {
    this.a = paramContext;
    this.d = paramList;
  }
  
  public String getActivity()
  {
    this.c = "";
    int i = 0;
    if (i < this.d.size())
    {
      if ("1".equals(((SignedPayServiceDataEntity)this.d.get(i)).getIs_default_check())) {
        if (!ae.notNull(this.c)) {
          break label107;
        }
      }
      label107:
      for (this.c = (this.c + "|" + ((SignedPayServiceDataEntity)this.d.get(i)).getActivityCode());; this.c = ((SignedPayServiceDataEntity)this.d.get(i)).getActivityCode())
      {
        i += 1;
        break;
      }
    }
    return this.c;
  }
  
  public int getCount()
  {
    return this.d.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.d.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.a).inflate(2130905015, null);
      this.b = new b(null);
      b.a(this.b, (CheckBox)paramView.findViewById(2131697191));
      b.a(this.b, (TextView)paramView.findViewById(2131697192));
      b.b(this.b, (TextView)paramView.findViewById(2131697193));
      paramView.setTag(this.b);
      if (!"0".equals(((SignedPayServiceDataEntity)this.d.get(paramInt)).getIs_default_check())) {
        break label316;
      }
      b.a(this.b).setChecked(false);
    }
    for (;;)
    {
      this.f.checkActivity();
      b.b(this.b).setText(((SignedPayServiceDataEntity)this.d.get(paramInt)).getActivity());
      b.a(this.b).setTag(Integer.valueOf(paramInt));
      b.a(this.b).setOnClickListener(this);
      float f1 = ((SignedPayServiceDataEntity)this.d.get(paramInt)).getPrice().getPrivilege_price();
      float f2 = ((SignedPayServiceDataEntity)this.d.get(paramInt)).getDeposit().getPrivilege_price();
      this.e = (((SignedPayServiceDataEntity)this.d.get(paramInt)).getCommission().getPrivilege_price() + (f1 + f2));
      b.c(this.b).setText("" + ((SignedPayServiceDataEntity)this.d.get(paramInt)).getActivity_rule());
      return paramView;
      this.b = ((b)paramView.getTag());
      break;
      label316:
      b.a(this.b).setChecked(true);
    }
  }
  
  public String getmActivity()
  {
    return this.c;
  }
  
  public List<SignedPayServiceDataEntity> getmList()
  {
    return this.d;
  }
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    int j = ((Integer)paramView.getTag()).intValue();
    int i = 0;
    if (i < getCount())
    {
      if (j == i)
      {
        if (!"1".equals(((SignedPayServiceDataEntity)this.d.get(i)).getIs_default_check())) {
          break label89;
        }
        ((SignedPayServiceDataEntity)this.d.get(i)).setIs_default_check("0");
      }
      for (;;)
      {
        this.f.checkActivity();
        i += 1;
        break;
        label89:
        ((SignedPayServiceDataEntity)this.d.get(i)).setIs_default_check("1");
      }
    }
    notifyDataSetChanged();
  }
  
  public void setPrice(a parama)
  {
    this.f = parama;
  }
  
  public void setmList(List<SignedPayServiceDataEntity> paramList)
  {
    this.d = paramList;
  }
  
  public static abstract interface a
  {
    public abstract void checkActivity();
  }
  
  private class b
  {
    private CheckBox b;
    private TextView c;
    private TextView d;
    
    private b() {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/signed/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */