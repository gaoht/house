package com.ziroom.ziroomcustomer.newclean.cardpay.adapter;

import android.content.Context;
import android.text.TextPaint;
import android.text.TextUtils;
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

public class b
  extends BaseAdapter
{
  b a = null;
  a b;
  private Context c;
  private List<CanBuyCard> d;
  private int e;
  
  public b(Context paramContext, List<CanBuyCard> paramList)
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
      paramView = LayoutInflater.from(this.c).inflate(2130904153, null);
      this.a.a = ((TextView)paramView.findViewById(2131689846));
      this.a.b = ((TextView)paramView.findViewById(2131689857));
      this.a.c = ((TextView)paramView.findViewById(2131694903));
      this.a.d = ((TextView)paramView.findViewById(2131694904));
      this.a.e = ((Button)paramView.findViewById(2131694902));
      paramView.setTag(this.a);
      this.a.a.setText(Long.parseLong(((CanBuyCard)this.d.get(paramInt)).getRechargeAmount()) / 100L + "");
      if (TextUtils.isEmpty(((CanBuyCard)this.d.get(paramInt)).getLabel())) {
        break label351;
      }
      this.a.b.setVisibility(0);
      this.a.b.setText(((CanBuyCard)this.d.get(paramInt)).getLabel());
      label229:
      this.a.c.setText("赠送" + ((CanBuyCard)this.d.get(paramInt)).getGiftCount().longValue() / 100L + "元");
      if (((CanBuyCard)this.d.get(paramInt)).getShowGiftAmount() != null) {
        break label366;
      }
      this.a.d.setVisibility(8);
    }
    for (;;)
    {
      this.a.e.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          b.a(b.this, paramInt);
          b.this.b.getClickView(b.a(b.this));
        }
      });
      return paramView;
      this.a = ((b)paramView.getTag());
      break;
      label351:
      this.a.b.setVisibility(8);
      break label229;
      label366:
      if (((CanBuyCard)this.d.get(paramInt)).getShowGiftAmount().longValue() > 0L)
      {
        this.a.d.setVisibility(0);
        this.a.d.setText("赠送" + ((CanBuyCard)this.d.get(paramInt)).getShowGiftAmount().longValue() / 100L + "元");
        this.a.d.getPaint().setFlags(16);
      }
      else
      {
        this.a.d.setVisibility(8);
      }
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
    TextView b;
    TextView c;
    TextView d;
    Button e;
    
    private b() {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newclean/cardpay/adapter/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */