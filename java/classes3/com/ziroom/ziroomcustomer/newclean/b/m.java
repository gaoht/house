package com.ziroom.ziroomcustomer.newclean.b;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.f.c;
import com.ziroom.ziroomcustomer.newclean.d.z;
import java.text.DecimalFormat;
import java.util.List;

public class m
  extends BaseAdapter
{
  private List<z> a;
  private Context b;
  
  public m(Context paramContext, List<z> paramList)
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
    if (paramView == null)
    {
      paramView = View.inflate(this.b, 2130904164, null);
      paramViewGroup = new a();
      paramViewGroup.a = ((SimpleDraweeView)paramView.findViewById(2131694931));
      paramViewGroup.b = ((TextView)paramView.findViewById(2131690049));
      paramViewGroup.c = ((TextView)paramView.findViewById(2131691744));
      paramViewGroup.d = ((TextView)paramView.findViewById(2131690003));
      paramViewGroup.e = ((TextView)paramView.findViewById(2131694932));
      paramViewGroup.f = ((TextView)paramView.findViewById(2131694933));
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      z localz = (z)this.a.get(paramInt);
      paramViewGroup.a.setController(c.frescoController(localz.getPicUrl()));
      paramViewGroup.b.setText(localz.getName());
      paramViewGroup.c.setText(localz.getDistanceContent());
      paramViewGroup.d.setText(localz.getServiceNum() + "");
      try
      {
        DecimalFormat localDecimalFormat = new DecimalFormat("######0.0");
        paramViewGroup.e.setText(localDecimalFormat.format(localz.getEvaluateScore()) + "");
        paramViewGroup.f.setText(localz.getFavorableRate());
        return paramView;
        paramViewGroup = (a)paramView.getTag();
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
        }
      }
    }
  }
  
  public class a
  {
    public SimpleDraweeView a;
    public TextView b;
    public TextView c;
    public TextView d;
    public TextView e;
    public TextView f;
    
    public a() {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newclean/b/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */