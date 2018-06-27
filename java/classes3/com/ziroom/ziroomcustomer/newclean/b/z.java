package com.ziroom.ziroomcustomer.newclean.b;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.mapapi.search.core.PoiInfo;
import java.util.List;

public class z
  extends BaseAdapter
{
  private List<PoiInfo> a;
  private Context b;
  
  public z(Context paramContext, List<PoiInfo> paramList)
  {
    this.a = paramList;
    this.b = paramContext;
  }
  
  public int getCount()
  {
    if (this.a == null) {
      return 0;
    }
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
    Object localObject = LayoutInflater.from(this.b).inflate(2130904370, paramViewGroup, false);
    paramViewGroup = paramView;
    if (paramView == null)
    {
      paramView = new a(null);
      paramView.a = ((TextView)((View)localObject).findViewById(2131695366));
      paramView.b = ((TextView)((View)localObject).findViewById(2131695367));
      ((View)localObject).setTag(paramView);
      paramViewGroup = (ViewGroup)localObject;
    }
    paramView = (a)paramViewGroup.getTag();
    localObject = (PoiInfo)this.a.get(paramInt);
    paramView.a.setText(((PoiInfo)localObject).name);
    paramView.b.setText(((PoiInfo)localObject).address);
    return paramViewGroup;
  }
  
  private class a
  {
    TextView a;
    TextView b;
    
    private a() {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newclean/b/z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */