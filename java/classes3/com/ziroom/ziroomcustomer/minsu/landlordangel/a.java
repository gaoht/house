package com.ziroom.ziroomcustomer.minsu.landlordangel;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.u;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.ziroom.ziroomcustomer.model.sojourn.AngelLandlordHome.TargetListBean;
import java.util.List;

public class a
  extends RecyclerView.a<RecyclerView.u>
{
  private Context a;
  private List<AngelLandlordHome.TargetListBean> b;
  
  public a(Context paramContext)
  {
    this.a = paramContext;
  }
  
  private int a(int paramInt)
  {
    return paramInt - 1;
  }
  
  public int getItemCount()
  {
    if (this.b == null) {
      return 0;
    }
    return this.b.size() + 1;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (paramInt == 0) {
      return -1;
    }
    return 0;
  }
  
  public void onBindViewHolder(RecyclerView.u paramu, int paramInt)
  {
    if ((paramu instanceof b))
    {
      paramu = (b)paramu;
      localTargetListBean = (AngelLandlordHome.TargetListBean)this.b.get(a(paramInt));
      paramu.e.setText(localTargetListBean.getFieldText());
      paramu.d.setText(localTargetListBean.getFieldMsg());
      paramu.c.setText(localTargetListBean.getFieldStandard());
      paramu.b.setText(localTargetListBean.getFieldValue());
      if (localTargetListBean.getIsLighten() == 1) {
        paramu.f.setImageDrawable(this.a.getResources().getDrawable(2130840279));
      }
    }
    while (!(paramu instanceof a))
    {
      AngelLandlordHome.TargetListBean localTargetListBean;
      return;
      paramu.f.setImageDrawable(this.a.getResources().getDrawable(2130840278));
      return;
    }
    paramu = (a)paramu;
  }
  
  public RecyclerView.u onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    if (paramInt == 0) {
      return new b(LayoutInflater.from(this.a).inflate(2130904265, paramViewGroup, false));
    }
    if (paramInt == -1) {
      return new a(LayoutInflater.from(this.a).inflate(2130904266, paramViewGroup, false));
    }
    return null;
  }
  
  public void setData(List<AngelLandlordHome.TargetListBean> paramList)
  {
    this.b = paramList;
    notifyDataSetChanged();
  }
  
  class a
    extends RecyclerView.u
  {
    View a;
    
    public a(View paramView)
    {
      super();
      this.a = paramView;
    }
  }
  
  class b
    extends RecyclerView.u
  {
    View a;
    TextView b;
    TextView c;
    TextView d;
    TextView e;
    ImageView f;
    
    public b(View paramView)
    {
      super();
      this.a = paramView;
      this.f = ((ImageView)this.a.findViewById(2131695129));
      this.b = ((TextView)this.a.findViewById(2131695128));
      this.c = ((TextView)this.a.findViewById(2131695127));
      this.d = ((TextView)this.a.findViewById(2131695126));
      this.e = ((TextView)this.a.findViewById(2131691707));
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/landlordangel/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */