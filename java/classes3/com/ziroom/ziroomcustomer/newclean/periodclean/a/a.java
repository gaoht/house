package com.ziroom.ziroomcustomer.newclean.periodclean.a;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.newclean.periodclean.bean.FrequencyBean;
import java.util.List;

public class a
  extends BaseAdapter
{
  public int a = -1;
  private Context b;
  private List<FrequencyBean> c = null;
  private a d;
  
  public a(Context paramContext)
  {
    this.b = paramContext;
  }
  
  public a(Context paramContext, List<FrequencyBean> paramList)
  {
    this.c = paramList;
    this.b = paramContext;
  }
  
  public int getCount()
  {
    if (this.c == null) {
      return 0;
    }
    return this.c.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.c.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(final int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    FrequencyBean localFrequencyBean;
    if (paramView == null)
    {
      paramView = View.inflate(this.b, 2130904431, null);
      paramViewGroup = new b();
      paramViewGroup.c = ((CheckBox)paramView.findViewById(2131695528));
      paramViewGroup.a = ((TextView)paramView.findViewById(2131689857));
      paramViewGroup.b = ((TextView)paramView.findViewById(2131689850));
      paramView.setTag(paramViewGroup);
      localFrequencyBean = (FrequencyBean)this.c.get(paramInt);
      if (this.a != paramInt) {
        break label174;
      }
      if (paramViewGroup.c.getVisibility() != 0)
      {
        this.a = -1;
        this.d.setPayType(null);
      }
      paramViewGroup.c.setChecked(true);
    }
    for (;;)
    {
      paramViewGroup.a.setText(localFrequencyBean.getName());
      paramViewGroup.b.setText(localFrequencyBean.getRemark());
      paramView.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          a.this.a = paramInt;
          a.b(a.this).setPayType((FrequencyBean)a.a(a.this).get(paramInt));
          a.this.notifyDataSetChanged();
        }
      });
      return paramView;
      paramViewGroup = (b)paramView.getTag();
      break;
      label174:
      paramViewGroup.c.setChecked(false);
    }
  }
  
  public a getmFrequencyType()
  {
    return this.d;
  }
  
  public List<FrequencyBean> getmList()
  {
    return this.c;
  }
  
  public void setmFrequencyType(a parama)
  {
    this.d = parama;
  }
  
  public void setmList(List<FrequencyBean> paramList)
  {
    this.c = paramList;
    notifyDataSetChanged();
  }
  
  public static abstract interface a
  {
    public abstract void setPayType(FrequencyBean paramFrequencyBean);
  }
  
  class b
  {
    TextView a;
    TextView b;
    CheckBox c;
    
    b() {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newclean/periodclean/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */