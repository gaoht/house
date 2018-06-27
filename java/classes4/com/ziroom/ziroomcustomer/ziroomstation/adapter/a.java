package com.ziroom.ziroomcustomer.ziroomstation.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.u;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import java.util.List;

public class a
  extends RecyclerView.a<b>
{
  private a a;
  private LayoutInflater b;
  private List<Integer> c;
  
  public a(Context paramContext, List<Integer> paramList)
  {
    this.b = LayoutInflater.from(paramContext);
    this.c = paramList;
  }
  
  public int getItemCount()
  {
    return this.c.size();
  }
  
  public void onBindViewHolder(final b paramb, final int paramInt)
  {
    paramb.a.setImageResource(((Integer)this.c.get(paramInt)).intValue());
    if (this.a != null) {
      paramb.itemView.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          a.a(a.this).onItemClick(paramb.itemView, paramInt);
        }
      });
    }
  }
  
  public b onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = this.b.inflate(2130904453, paramViewGroup, false);
    b localb = new b(paramViewGroup);
    localb.a = ((ImageView)paramViewGroup.findViewById(2131690969));
    return localb;
  }
  
  public void setOnItemClickLitener(a parama)
  {
    this.a = parama;
  }
  
  public static abstract interface a
  {
    public abstract void onItemClick(View paramView, int paramInt);
  }
  
  public static class b
    extends RecyclerView.u
  {
    ImageView a;
    
    public b(View paramView)
    {
      super();
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes4-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomstation/adapter/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */