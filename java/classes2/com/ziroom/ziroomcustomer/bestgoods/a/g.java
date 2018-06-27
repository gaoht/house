package com.ziroom.ziroomcustomer.bestgoods.a;

import android.content.Context;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.u;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout.LayoutParams;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.f.c;
import com.ziroom.ziroomcustomer.bestgoods.model.QualifcationProofMo;
import com.ziroom.ziroomcustomer.util.n;
import java.util.ArrayList;
import java.util.List;

public class g
  extends RecyclerView.a<a>
{
  private List<QualifcationProofMo> a;
  private Context b;
  
  public g(Context paramContext, List<QualifcationProofMo> paramList)
  {
    if (paramList != null) {}
    for (this.a = paramList;; this.a = new ArrayList())
    {
      this.b = paramContext;
      return;
    }
  }
  
  public int getItemCount()
  {
    if (this.a == null) {
      return 0;
    }
    return this.a.size();
  }
  
  public void onBindViewHolder(a parama, int paramInt)
  {
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)a.a(parama).getLayoutParams();
    if (paramInt == this.a.size() - 1) {}
    for (localLayoutParams.bottomMargin = n.dip2px(this.b, 24.0F);; localLayoutParams.bottomMargin = 0)
    {
      a.a(parama).setLayoutParams(localLayoutParams);
      a.a(parama).setController(c.frescoController(((QualifcationProofMo)this.a.get(paramInt)).getImgUrl()));
      return;
    }
  }
  
  public a onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    return new a(LayoutInflater.from(this.b).inflate(2130904449, paramViewGroup, false));
  }
  
  public void setData(List<QualifcationProofMo> paramList)
  {
    this.a = paramList;
  }
  
  public static class a
    extends RecyclerView.u
  {
    private SimpleDraweeView a;
    
    public a(View paramView)
    {
      super();
      this.a = ((SimpleDraweeView)paramView.findViewById(2131694859));
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/bestgoods/a/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */