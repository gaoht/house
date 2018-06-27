package com.ziroom.ziroomcustomer.bestgoods.a;

import android.content.Context;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.u;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.f.c;
import java.util.List;

public class ae
  extends RecyclerView.a<a>
{
  private Context a;
  private List<String> b;
  
  public ae(Context paramContext, List<String> paramList)
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
  
  public void onBindViewHolder(a parama, int paramInt)
  {
    a.a(parama).setController(c.frescoController((String)this.b.get(paramInt)));
  }
  
  public a onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    return new a(LayoutInflater.from(this.a).inflate(2130904586, paramViewGroup, false));
  }
  
  public static class a
    extends RecyclerView.u
  {
    private SimpleDraweeView a;
    
    public a(View paramView)
    {
      super();
      this.a = ((SimpleDraweeView)paramView.findViewById(2131695829));
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/bestgoods/a/ae.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */