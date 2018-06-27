package com.ziroom.ziroomcustomer.bestgoods.a;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.f.c;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.bestgoods.activity.BestGoodsListAc;
import com.ziroom.ziroomcustomer.bestgoods.model.ab;
import com.ziroom.ziroomcustomer.bestgoods.model.z;
import java.text.DecimalFormat;
import java.util.List;

public class n
  extends BaseAdapter
{
  private Context a;
  private List<ab> b;
  private z c;
  
  public n(Context paramContext, z paramz, List<ab> paramList)
  {
    this.a = paramContext;
    this.b = paramList;
    this.c = paramz;
  }
  
  public int getCount()
  {
    if (this.b == null) {
      return 0;
    }
    if (this.b.size() <= 5) {
      return this.b.size() + 1;
    }
    return 6;
  }
  
  public Object getItem(int paramInt)
  {
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramViewGroup = new a();
      paramView = LayoutInflater.from(this.a).inflate(2130904574, null);
      paramViewGroup.a = ((SimpleDraweeView)paramView.findViewById(2131695800));
      paramViewGroup.b = ((TextView)paramView.findViewById(2131690720));
      paramViewGroup.c = ((TextView)paramView.findViewById(2131695561));
      paramViewGroup.d = ((Button)paramView.findViewById(2131695801));
      paramView.setTag(paramViewGroup);
      if (paramInt != getCount() - 1) {
        break label157;
      }
      paramViewGroup.a.setImageResource(2131624576);
      paramViewGroup.b.setText("");
      paramViewGroup.c.setText("");
      paramViewGroup.d.setVisibility(0);
    }
    for (;;)
    {
      paramViewGroup.d.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          paramAnonymousView = n.a(n.this).getStyleCode();
          Intent localIntent = new Intent(n.b(n.this), BestGoodsListAc.class);
          localIntent.putExtra("styleCode", paramAnonymousView);
          localIntent.putExtra("styleName", n.a(n.this).getStyleName());
          n.b(n.this).startActivity(localIntent);
        }
      });
      return paramView;
      paramViewGroup = (a)paramView.getTag();
      break;
      label157:
      paramViewGroup.a.setController(c.frescoController(((ab)this.b.get(paramInt)).getImgUrl()));
      paramViewGroup.b.setText(((ab)this.b.get(paramInt)).getSkuName());
      DecimalFormat localDecimalFormat = new DecimalFormat("0.00");
      paramViewGroup.c.setText("￥" + localDecimalFormat.format(((ab)this.b.get(paramInt)).getSkuPrice()));
    }
  }
  
  class a
  {
    SimpleDraweeView a;
    TextView b;
    TextView c;
    Button d;
    
    a() {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/bestgoods/a/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */