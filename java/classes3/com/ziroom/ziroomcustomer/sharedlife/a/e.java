package com.ziroom.ziroomcustomer.sharedlife.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.f.c;
import com.ziroom.ziroomcustomer.sharedlife.c.g;
import java.util.List;

public class e
  extends BaseAdapter
{
  private List<g> a;
  private Context b;
  
  public e(Context paramContext, List<g> paramList)
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
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    g localg;
    if (paramView == null)
    {
      paramView = View.inflate(this.b, 2130904535, null);
      paramViewGroup = new a();
      paramViewGroup.b = ((TextView)paramView.findViewById(2131695665));
      paramViewGroup.a = ((SimpleDraweeView)paramView.findViewById(2131693871));
      paramViewGroup.c = ((TextView)paramView.findViewById(2131695679));
      a.a(paramViewGroup, (TextView)paramView.findViewById(2131692733));
      paramView.setTag(paramViewGroup);
      localg = (g)this.a.get(paramInt);
      paramViewGroup.b.setText(localg.getDeviceTypeName());
      if (paramViewGroup.a.getTag() != null) {
        break label188;
      }
      paramViewGroup.a.setTag(localg.getPicUrl());
      paramViewGroup.a.setController(c.frescoController(localg.getPicUrl()));
    }
    for (;;)
    {
      paramViewGroup.c.setText(localg.getDesc());
      if (localg.getIsUse() != 1) {
        break label236;
      }
      a.a(paramViewGroup).setVisibility(0);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
      break;
      label188:
      if (!localg.getPicUrl().equals(paramViewGroup.a.getTag()))
      {
        paramViewGroup.a.setTag(localg.getPicUrl());
        paramViewGroup.a.setController(c.frescoController(localg.getPicUrl()));
      }
    }
    label236:
    a.a(paramViewGroup).setVisibility(8);
    return paramView;
  }
  
  public class a
  {
    public SimpleDraweeView a;
    public TextView b;
    public TextView c;
    private TextView e;
    
    public a() {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/sharedlife/a/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */