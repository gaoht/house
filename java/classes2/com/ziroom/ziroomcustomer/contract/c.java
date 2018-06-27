package com.ziroom.ziroomcustomer.contract;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.facebook.drawee.drawable.ScalingUtils.ScaleType;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.view.SimpleDraweeView;
import com.ziroom.ziroomcustomer.d.a.a;
import com.ziroom.ziroomcustomer.model.HomeIndex;
import java.util.List;

public class c
  extends BaseAdapter
{
  int[] a = { 2130838626, 2130838873, 2130839942 };
  private a b;
  private Context c;
  private List<HomeIndex> d;
  
  public c(Context paramContext, List<HomeIndex> paramList)
  {
    this.c = paramContext;
    this.d = paramList;
  }
  
  public int getCount()
  {
    return this.d.size();
  }
  
  public Object getItem(int paramInt)
  {
    return Integer.valueOf(this.a[paramInt]);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      this.b = new a();
      paramView = LayoutInflater.from(this.c).inflate(2130905244, null);
      a.a(this.b, (SimpleDraweeView)paramView.findViewById(2131689744));
      paramView.setTag(this.b);
    }
    for (;;)
    {
      ((GenericDraweeHierarchy)a.a(this.b).getHierarchy()).setActualImageScaleType(ScalingUtils.ScaleType.FIT_XY);
      ((GenericDraweeHierarchy)a.a(this.b).getHierarchy()).setPlaceholderImage(a.a.b);
      a.a(this.b).setController(com.freelxl.baselibrary.f.c.frescoController(((HomeIndex)this.d.get(paramInt)).getPic()));
      return paramView;
      this.b = ((a)paramView.getTag());
    }
  }
  
  public List<HomeIndex> getmList()
  {
    return this.d;
  }
  
  public void setmList(List<HomeIndex> paramList)
  {
    this.d = paramList;
  }
  
  class a
  {
    private SimpleDraweeView b;
    
    a() {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/contract/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */