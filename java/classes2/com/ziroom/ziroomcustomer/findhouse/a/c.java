package com.ziroom.ziroomcustomer.findhouse.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.ziroom.ziroomcustomer.findhouse.presenter.model.RentHouseDetail.ActivityArray;
import com.ziroom.ziroomcustomer.util.ae;
import java.util.List;

public class c
  extends BaseAdapter
{
  private List<RentHouseDetail.ActivityArray> a;
  private Context b;
  private a c;
  
  public c(List<RentHouseDetail.ActivityArray> paramList, Context paramContext)
  {
    this.a = paramList;
    this.b = paramContext;
  }
  
  public int getCount()
  {
    return this.a.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.a.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = View.inflate(this.b, 2130905202, null);
      this.c = new a();
      this.c.c = ((TextView)paramView.findViewById(2131692028));
      this.c.b = ((TextView)paramView.findViewById(2131690049));
      this.c.a = ((TextView)paramView.findViewById(2131689541));
      this.c.d = ((ImageView)paramView.findViewById(2131697710));
      paramView.setTag(this.c);
      paramViewGroup = (RentHouseDetail.ActivityArray)this.a.get(paramInt);
      if (!ae.notNull(paramViewGroup.getLink())) {
        break label215;
      }
      this.c.d.setVisibility(0);
    }
    for (;;)
    {
      this.c.a.setText(paramViewGroup.getTitle());
      this.c.b.setText("【" + paramViewGroup.getName() + "】");
      this.c.c.setText(paramViewGroup.getDesc());
      return paramView;
      this.c = ((a)paramView.getTag());
      break;
      label215:
      this.c.d.setVisibility(8);
    }
  }
  
  class a
  {
    TextView a;
    TextView b;
    TextView c;
    ImageView d;
    
    a() {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/findhouse/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */