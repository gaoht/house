package com.ziroom.ziroomcustomer.bestgoods.a;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.u;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.bestgoods.model.x;
import java.util.List;

public class am
  extends RecyclerView.a<b>
{
  List<x> a;
  private Context b;
  private a c;
  private int d = 0;
  
  public am(Context paramContext, List<x> paramList)
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
  
  public void onBindViewHolder(b paramb, final int paramInt)
  {
    paramb.b.setText(((x)this.a.get(paramInt)).getProductName());
    if (((x)this.a.get(paramInt)).isChosen()) {
      paramb.b.setTextColor(Color.parseColor("#444444"));
    }
    for (;;)
    {
      paramb.b.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          if (am.a(am.this) == paramInt) {
            ((x)am.this.a.get(paramInt)).setChosen(true);
          }
          for (;;)
          {
            if (am.b(am.this) != null) {
              am.b(am.this).itemClick(paramInt);
            }
            am.this.notifyDataSetChanged();
            return;
            ((x)am.this.a.get(am.a(am.this))).setChosen(false);
            ((x)am.this.a.get(paramInt)).setChosen(true);
            am.a(am.this, paramInt);
          }
        }
      });
      if (paramInt != 0) {
        break;
      }
      paramb.d.setVisibility(0);
      paramb.e.setVisibility(8);
      return;
      paramb.b.setTextColor(Color.parseColor("#999999"));
    }
    paramb.d.setVisibility(8);
    paramb.e.setVisibility(0);
  }
  
  public b onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    return new b(LayoutInflater.from(this.b).inflate(2130904598, paramViewGroup, false));
  }
  
  public void setOnItemClickListener(a parama)
  {
    this.c = parama;
  }
  
  public static abstract interface a
  {
    public abstract void itemClick(int paramInt);
  }
  
  class b
    extends RecyclerView.u
  {
    RelativeLayout a;
    TextView b;
    View c;
    View d;
    View e;
    
    public b(View paramView)
    {
      super();
      this.a = ((RelativeLayout)paramView.findViewById(2131695848));
      this.b = ((TextView)paramView.findViewById(2131690049));
      this.c = paramView.findViewById(2131690678);
      this.d = paramView.findViewById(2131695849);
      this.e = paramView.findViewById(2131695850);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/bestgoods/a/am.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */