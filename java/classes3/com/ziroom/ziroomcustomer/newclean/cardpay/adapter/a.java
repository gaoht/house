package com.ziroom.ziroomcustomer.newclean.cardpay.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.newclean.cardpay.model.CanBuyCard;
import java.util.List;

public class a
  extends BaseAdapter
{
  b a = null;
  a b;
  private Context c;
  private List<CanBuyCard> d;
  private int e;
  
  public a(Context paramContext, List<CanBuyCard> paramList)
  {
    this.c = paramContext;
    this.d = paramList;
  }
  
  public int getCount()
  {
    if (this.d == null) {
      return 0;
    }
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
  
  public View getView(final int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      this.a = new b(null);
      paramView = LayoutInflater.from(this.c).inflate(2130904152, null);
      this.a.a = ((TextView)paramView.findViewById(2131689846));
      this.a.b = ((Button)paramView.findViewById(2131694902));
      paramView.setTag(this.a);
    }
    for (;;)
    {
      this.a.a.setText(Long.parseLong(((CanBuyCard)this.d.get(paramInt)).getRechargeAmount()) / 100L + "");
      this.a.b.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          a.a(a.this, paramInt);
          if (a.this.b == null) {
            return;
          }
          a.this.b.getClickView(a.a(a.this));
        }
      });
      return paramView;
      this.a = ((b)paramView.getTag());
    }
  }
  
  public void setOnclickPositionListener(a parama)
  {
    this.b = parama;
  }
  
  public static abstract interface a
  {
    public abstract void getClickView(int paramInt);
  }
  
  private class b
  {
    TextView a;
    Button b;
    
    private b() {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newclean/cardpay/adapter/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */