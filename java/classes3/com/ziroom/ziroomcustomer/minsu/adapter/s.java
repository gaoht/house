package com.ziroom.ziroomcustomer.minsu.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView.a;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.List;

public class s
  extends RecyclerView.a<t>
{
  private Context a;
  private List<String> b;
  
  public s(Context paramContext, List<String> paramList)
  {
    this.a = paramContext;
    this.b = paramList;
  }
  
  public int getItemCount()
  {
    return this.b.size();
  }
  
  public void onBindViewHolder(t paramt, int paramInt)
  {
    paramt.a.setText((CharSequence)this.b.get(paramInt));
  }
  
  public t onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    return new t(LayoutInflater.from(this.a).inflate(2130904454, null));
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/adapter/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */