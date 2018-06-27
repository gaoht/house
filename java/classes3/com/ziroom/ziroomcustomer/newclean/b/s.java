package com.ziroom.ziroomcustomer.newclean.b;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.ziroom.ziroomcustomer.newclean.d.al;
import java.util.List;

public class s
  extends BaseAdapter
{
  private Context a;
  private List<al> b;
  private LayoutInflater c;
  
  public s(Context paramContext, List<al> paramList)
  {
    this.a = paramContext;
    this.b = paramList;
    this.c = LayoutInflater.from(paramContext);
  }
  
  public int getCount()
  {
    return this.b.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.b.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    al localal;
    if (paramView == null)
    {
      paramView = this.c.inflate(2130904381, paramViewGroup, false);
      paramViewGroup = new a();
      paramViewGroup.a = ((TextView)paramView.findViewById(2131690049));
      paramViewGroup.b = ((TextView)paramView.findViewById(2131689852));
      paramViewGroup.c = ((TextView)paramView.findViewById(2131690003));
      paramViewGroup.d = ((TextView)paramView.findViewById(2131689840));
      paramViewGroup.e = ((TextView)paramView.findViewById(2131689541));
      paramViewGroup.f = ((TextView)paramView.findViewById(2131694578));
      paramViewGroup.g = ((ImageView)paramView.findViewById(2131691574));
      paramViewGroup.h = ((RelativeLayout)paramView.findViewById(2131695381));
      paramView.setTag(paramViewGroup);
      localal = (al)this.b.get(paramInt);
      if (localal.getIsUsable() != 0) {
        break label299;
      }
      paramViewGroup.h.setBackgroundResource(2130837741);
    }
    for (;;)
    {
      paramViewGroup.a.setText(localal.getPromoName());
      paramViewGroup.c.setText((int)localal.getPromoPrice() + "");
      paramViewGroup.b.setText(localal.getStartDate() + " 到 " + localal.getEndDate());
      paramViewGroup.d.setText("¥");
      paramViewGroup.e.setText(localal.getDescription());
      paramViewGroup.f.setVisibility(8);
      paramViewGroup.g.setImageResource(2130838607);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
      break;
      label299:
      if (localal.getIsUsable() == 1) {
        paramViewGroup.h.setBackgroundResource(2130837740);
      } else {
        paramViewGroup.h.setBackgroundResource(2130837741);
      }
    }
  }
  
  public class a
  {
    TextView a;
    TextView b;
    TextView c;
    TextView d;
    TextView e;
    TextView f;
    ImageView g;
    RelativeLayout h;
    
    public a() {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newclean/b/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */