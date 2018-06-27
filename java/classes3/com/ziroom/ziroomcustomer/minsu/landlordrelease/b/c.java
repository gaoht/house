package com.ziroom.ziroomcustomer.minsu.landlordrelease.b;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.houseprice.BedAllTypeListDataBean;
import java.util.ArrayList;

public class c
  extends BaseAdapter
{
  private Context a;
  private ArrayList<BedAllTypeListDataBean> b;
  private b c;
  
  public c(Context paramContext, b paramb, ArrayList<BedAllTypeListDataBean> paramArrayList)
  {
    this.a = paramContext;
    this.c = paramb;
    this.b = paramArrayList;
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
  
  public View getView(final int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    String str1;
    int j;
    if (paramView == null)
    {
      paramViewGroup = new a();
      paramView = LayoutInflater.from(this.a).inflate(2130904338, null);
      paramViewGroup.a = ((TextView)paramView.findViewById(2131690049));
      paramViewGroup.b = ((TextView)paramView.findViewById(2131690071));
      paramViewGroup.c = ((TextView)paramView.findViewById(2131695329));
      paramViewGroup.d = ((TextView)paramView.findViewById(2131689995));
      paramViewGroup.e = ((TextView)paramView.findViewById(2131690041));
      paramView.setTag(paramViewGroup);
      str1 = ((BedAllTypeListDataBean)this.b.get(paramInt)).getText();
      j = ((BedAllTypeListDataBean)this.b.get(paramInt)).getCount();
      String str2 = ((BedAllTypeListDataBean)this.b.get(paramInt)).getExplain();
      ((BedAllTypeListDataBean)this.b.get(paramInt)).isSelect();
      if (!TextUtils.isEmpty(str2)) {
        break label337;
      }
      paramViewGroup.b.setVisibility(8);
      label177:
      if (j <= 0) {
        break label369;
      }
      paramViewGroup.c.setClickable(true);
      paramViewGroup.e.setClickable(true);
      paramViewGroup.c.setBackgroundResource(2130838655);
      paramViewGroup.e.setBackgroundResource(2130838652);
    }
    int i;
    for (;;)
    {
      paramViewGroup.a.setText(str1);
      paramViewGroup.d.setText(j + "");
      paramViewGroup.c.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          int i = ((BedAllTypeListDataBean)c.a(c.this).get(paramInt)).getCount();
          ((BedAllTypeListDataBean)c.a(c.this).get(paramInt)).setCount(i - 1);
          c.b(c.this).setHouseBedChosen(c.a(c.this));
          c.this.notifyDataSetChanged();
        }
      });
      paramViewGroup.e.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          int i = ((BedAllTypeListDataBean)c.a(c.this).get(paramInt)).getCount();
          ((BedAllTypeListDataBean)c.a(c.this).get(paramInt)).setCount(i + 1);
          c.b(c.this).setHouseBedChosen(c.a(c.this));
          c.this.notifyDataSetChanged();
        }
      });
      paramInt = 0;
      i = 0;
      while (paramInt < this.b.size())
      {
        i += ((BedAllTypeListDataBean)this.b.get(paramInt)).getCount();
        paramInt += 1;
      }
      paramViewGroup = (a)paramView.getTag();
      break;
      label337:
      paramViewGroup.b.setVisibility(0);
      paramViewGroup.b.setText(((BedAllTypeListDataBean)this.b.get(paramInt)).getExplain());
      break label177;
      label369:
      if (j == 0)
      {
        paramViewGroup.c.setClickable(false);
        paramViewGroup.c.setBackgroundResource(2130838654);
        paramViewGroup.e.setBackgroundResource(2130838652);
      }
    }
    if (i >= 7)
    {
      if (j <= 0) {
        paramViewGroup.c.setClickable(false);
      }
      for (;;)
      {
        paramViewGroup.e.setClickable(false);
        paramViewGroup.e.setBackgroundResource(2130838653);
        return paramView;
        paramViewGroup.c.setClickable(true);
      }
    }
    if (j <= 0) {
      paramViewGroup.c.setClickable(false);
    }
    for (;;)
    {
      paramViewGroup.e.setClickable(true);
      paramViewGroup.e.setBackgroundResource(2130838652);
      return paramView;
      paramViewGroup.c.setClickable(true);
    }
  }
  
  public void setmAmenitiesChosenListener(b paramb)
  {
    this.c = paramb;
  }
  
  public class a
  {
    TextView a;
    TextView b;
    TextView c;
    TextView d;
    TextView e;
    
    public a() {}
  }
  
  public static abstract interface b
  {
    public abstract void setHouseBedChosen(ArrayList<BedAllTypeListDataBean> paramArrayList);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/landlordrelease/b/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */