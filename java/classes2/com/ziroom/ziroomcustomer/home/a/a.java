package com.ziroom.ziroomcustomer.home.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery.LayoutParams;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.f.c;
import com.ziroom.ziroomcustomer.home.bean.HomePageBannerInfo.DataBean;
import com.ziroom.ziroomcustomer.util.ac;
import java.util.List;

public class a
  extends BaseAdapter
{
  private Context a;
  private List<HomePageBannerInfo.DataBean> b;
  private float c;
  private float d;
  
  public a(Context paramContext, List<HomePageBannerInfo.DataBean> paramList)
  {
    this.a = paramContext;
    this.b = paramList;
    int i = ac.getScreenWidth(paramContext);
    this.c = ((float)(i * 0.9D));
    this.d = ((float)(i * 0.9D * 2.0D / 3.0D));
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
    if (paramView == null)
    {
      paramViewGroup = new a(null);
      paramView = new SimpleDraweeView(this.a);
      paramView.setLayoutParams(new Gallery.LayoutParams((int)this.c, (int)this.d));
      paramViewGroup.a = paramView;
      c.frescoHierarchyController(paramViewGroup.a, 2130838349);
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      HomePageBannerInfo.DataBean localDataBean = (HomePageBannerInfo.DataBean)this.b.get(paramInt);
      paramViewGroup.a.setController(c.frescoController(localDataBean.getPic()));
      return paramView;
      paramViewGroup = (a)paramView.getTag();
    }
  }
  
  private class a
  {
    SimpleDraweeView a;
    
    private a() {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/home/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */