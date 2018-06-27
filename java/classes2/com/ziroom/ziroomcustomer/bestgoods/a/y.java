package com.ziroom.ziroomcustomer.bestgoods.a;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.u;
import android.text.TextPaint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.f.c;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.bestgoods.activity.GoodsDetailAc;
import com.ziroom.ziroomcustomer.bestgoods.model.al.g;
import com.ziroom.ziroomcustomer.newServiceList.utils.j;
import com.ziroom.ziroomcustomer.util.n;
import com.ziroom.ziroomcustomer.util.x;
import java.util.List;

public class y
  extends RecyclerView.a<a>
{
  List<al.g> a;
  private Context b;
  
  public y(Context paramContext, List<al.g> paramList)
  {
    this.b = paramContext;
    this.a = paramList;
  }
  
  public int getItemCount()
  {
    if (this.a == null) {
      return 0;
    }
    return this.a.size();
  }
  
  public void onBindViewHolder(a parama, final int paramInt)
  {
    parama.f.setPadding(0, 0, n.dip2px(this.b, 6.0F), 0);
    ViewGroup.LayoutParams localLayoutParams = parama.a.getLayoutParams();
    float f1 = j.getDisplayWidth(this.b) * 342.0F / 375.0F;
    float f2 = 228.0F * f1 / 342.0F;
    localLayoutParams.width = ((int)f1);
    localLayoutParams.height = ((int)f2);
    parama.a.setLayoutParams(localLayoutParams);
    x.makeUrl(((al.g)this.a.get(paramInt)).getUrl());
    parama.a.setController(c.frescoController(((al.g)this.a.get(paramInt)).getUrl()));
    parama.a.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        paramAnonymousView = new Intent(y.a(y.this), GoodsDetailAc.class);
        paramAnonymousView.putExtra("productCode", ((al.g)y.this.a.get(paramInt)).getTimeToBuyProductCode());
        paramAnonymousView.putExtra("skuCode", ((al.g)y.this.a.get(paramInt)).getTimeToBuySkuCode());
        y.a(y.this).startActivity(paramAnonymousView);
      }
    });
    parama.e.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        paramAnonymousView = new Intent(y.a(y.this), GoodsDetailAc.class);
        paramAnonymousView.putExtra("productCode", ((al.g)y.this.a.get(paramInt)).getTimeToBuyProductCode());
        paramAnonymousView.putExtra("skuCode", ((al.g)y.this.a.get(paramInt)).getTimeToBuySkuCode());
        y.a(y.this).startActivity(paramAnonymousView);
      }
    });
    parama.b.getPaint().setFlags(16);
    parama.b.setText("￥" + ((al.g)this.a.get(paramInt)).getPrice());
    parama.c.setText("￥" + ((al.g)this.a.get(paramInt)).getActivityPrice());
    parama.d.setText(((al.g)this.a.get(paramInt)).getName());
  }
  
  public a onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    return new a(LayoutInflater.from(this.b).inflate(2130904587, paramViewGroup, false));
  }
  
  class a
    extends RecyclerView.u
  {
    SimpleDraweeView a;
    TextView b;
    TextView c;
    TextView d;
    TextView e;
    View f;
    
    public a(View paramView)
    {
      super();
      this.a = ((SimpleDraweeView)paramView.findViewById(2131694449));
      this.f = paramView.findViewById(2131690425);
      this.b = ((TextView)paramView.findViewById(2131695831));
      this.c = ((TextView)paramView.findViewById(2131695830));
      this.d = ((TextView)paramView.findViewById(2131690720));
      this.e = ((TextView)paramView.findViewById(2131695832));
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/bestgoods/a/y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */