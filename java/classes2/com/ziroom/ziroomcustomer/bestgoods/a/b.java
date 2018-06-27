package com.ziroom.ziroomcustomer.bestgoods.a;

import android.content.Context;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.u;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.f.c;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.bestgoods.model.a;
import com.ziroom.ziroomcustomer.util.n;
import java.text.DecimalFormat;
import java.util.List;

public class b
  extends RecyclerView.a<b>
{
  private Context a;
  private List<a> b;
  private a c = null;
  
  public b(Context paramContext, List<a> paramList)
  {
    this.a = paramContext;
    this.b = paramList;
  }
  
  public int getItemCount()
  {
    if (this.b == null) {
      return 0;
    }
    return this.b.size();
  }
  
  public void onBindViewHolder(b paramb, int paramInt)
  {
    Object localObject = (LinearLayout.LayoutParams)paramb.e.getLayoutParams();
    if ((paramInt - (this.b.size() - 1) == 0) || (paramInt - (this.b.size() - 1) == 1))
    {
      ((LinearLayout.LayoutParams)localObject).bottomMargin = n.dip2px(this.a, 32.0F);
      paramb.e.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    for (;;)
    {
      c.loadHolderImage(paramb.b, ((a)this.b.get(paramInt)).getImgUrl());
      paramb.d.setText(((a)this.b.get(paramInt)).getSkuName());
      localObject = new DecimalFormat("0.00");
      if (((a)this.b.get(paramInt)).getActiveType() != null) {
        break;
      }
      paramb.c.setText(((DecimalFormat)localObject).format(((a)this.b.get(paramInt)).getPrice()));
      return;
      ((LinearLayout.LayoutParams)localObject).bottomMargin = n.dip2px(this.a, 8.0F);
      paramb.e.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    paramb.c.setText(((DecimalFormat)localObject).format(((a)this.b.get(paramInt)).getActivePrice()));
  }
  
  public b onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    return new b(View.inflate(this.a, 2130904134, null), this.c);
  }
  
  public void setOnItemClickListener(a parama)
  {
    this.c = parama;
  }
  
  public static abstract interface a
  {
    public abstract void onItemClick(View paramView, int paramInt);
  }
  
  public class b
    extends RecyclerView.u
    implements View.OnClickListener
  {
    b.a a;
    SimpleDraweeView b;
    TextView c;
    TextView d;
    RelativeLayout e;
    
    public b(View paramView, b.a parama)
    {
      super();
      this.a = parama;
      paramView.setOnClickListener(this);
      this.e = ((RelativeLayout)paramView.findViewById(2131694863));
      this.b = ((SimpleDraweeView)paramView.findViewById(2131694864));
      this.d = ((TextView)paramView.findViewById(2131690720));
      this.c = ((TextView)paramView.findViewById(2131689991));
    }
    
    @Instrumented
    public void onClick(View paramView)
    {
      VdsAgent.onClick(this, paramView);
      if (this.a != null) {
        this.a.onItemClick(paramView, getPosition());
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/bestgoods/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */