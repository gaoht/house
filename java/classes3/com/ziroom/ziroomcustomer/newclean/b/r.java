package com.ziroom.ziroomcustomer.newclean.b;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.ziroom.ziroomcustomer.newclean.d.al;
import java.util.List;

public class r
  extends BaseAdapter
{
  private Context a;
  private List<al> b;
  private String c;
  
  public r(Context paramContext, List<al> paramList, String paramString)
  {
    this.a = paramContext;
    this.b = paramList;
    this.c = paramString;
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
      paramView = View.inflate(this.a, 2130904172, null);
      paramViewGroup = new a();
      paramViewGroup.a = ((TextView)paramView.findViewById(2131689846));
      paramViewGroup.b = ((TextView)paramView.findViewById(2131689848));
      paramViewGroup.c = ((TextView)paramView.findViewById(2131689852));
      paramViewGroup.d = ((RelativeLayout)paramView.findViewById(2131694898));
      paramViewGroup.e = ((TextView)paramView.findViewById(2131690316));
      paramViewGroup.f = ((LinearLayout)paramView.findViewById(2131690208));
      paramViewGroup.g = ((ImageView)paramView.findViewById(2131692488));
      paramView.setTag(paramViewGroup);
      localal = (al)this.b.get(paramInt);
      if (localal.getIsUsable() != 0) {
        break label281;
      }
      paramViewGroup.f.setBackgroundResource(2130837741);
      paramViewGroup.g.setBackgroundResource(2130838606);
      label161:
      if (!TextUtils.isEmpty(localal.getDescription())) {
        break label311;
      }
      paramViewGroup.d.setVisibility(8);
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(localal.getCommonAdressId()))
      {
        if (this.c.equals(localal.getCommonAdressId()))
        {
          if (localal.getState() == 2)
          {
            paramViewGroup.a.setText((int)localal.getPromoPrice() + "");
            paramViewGroup.b.setText(localal.getPromoName());
            paramViewGroup.c.setText("已过期");
            return paramView;
            paramViewGroup = (a)paramView.getTag();
            break;
            label281:
            if (localal.getIsUsable() != 1) {
              break label161;
            }
            paramViewGroup.f.setBackgroundResource(2130837740);
            paramViewGroup.g.setBackgroundResource(2130838198);
            break label161;
            label311:
            paramViewGroup.d.setVisibility(0);
            paramViewGroup.e.setText(localal.getDescription());
            continue;
          }
          paramViewGroup.a.setText((int)localal.getPromoPrice() + "");
          paramViewGroup.b.setText(localal.getPromoName());
          paramViewGroup.c.setText(localal.getStartDate() + "至" + localal.getEndDate() + "有效");
          return paramView;
        }
        paramViewGroup.a.setText((int)localal.getPromoPrice() + "");
        paramViewGroup.b.setText(localal.getPromoName());
        paramViewGroup.c.setText(localal.getStartDate() + "至" + localal.getEndDate() + "有效");
        return paramView;
      }
    }
    if (localal.getState() == 2)
    {
      paramViewGroup.a.setText((int)localal.getPromoPrice() + "");
      paramViewGroup.b.setText(localal.getPromoName());
      paramViewGroup.c.setText(localal.getStartDate() + "至" + localal.getEndDate() + "有效");
      return paramView;
    }
    paramViewGroup.a.setText((int)localal.getPromoPrice() + "");
    paramViewGroup.b.setText(localal.getPromoName());
    paramViewGroup.c.setText(localal.getStartDate() + "至" + localal.getEndDate() + "有效");
    return paramView;
  }
  
  public class a
  {
    public TextView a;
    public TextView b;
    public TextView c;
    public RelativeLayout d;
    public TextView e;
    public LinearLayout f;
    public ImageView g;
    
    public a() {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newclean/b/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */