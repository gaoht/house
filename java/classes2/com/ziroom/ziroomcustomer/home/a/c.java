package com.ziroom.ziroomcustomer.home.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.ziroom.ziroomcustomer.home.bean.HomePageBannerInfo.DataBean;
import com.ziroom.ziroomcustomer.util.ac;
import java.util.List;

public class c
  extends BaseAdapter
{
  private Context a;
  private List<HomePageBannerInfo.DataBean> b;
  private float c;
  private float d;
  private int e;
  
  public c(Context paramContext, List<HomePageBannerInfo.DataBean> paramList, int paramInt)
  {
    this.a = paramContext;
    this.b = paramList;
    int i = ac.getScreenWidth(paramContext);
    this.c = ((float)(i * 0.9D));
    this.d = ((float)(i * 0.9D * 2.0D / 3.0D));
    this.e = paramInt;
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
      paramView = LayoutInflater.from(this.a).inflate(2130904021, null);
      paramViewGroup = new a(null);
      paramViewGroup.a = ((SimpleDraweeView)paramView.findViewById(2131694412));
      paramViewGroup.b = ((TextView)paramView.findViewById(2131694468));
      com.freelxl.baselibrary.f.c.frescoHierarchyController(paramViewGroup.a, 2130838349);
      paramViewGroup.c = ((TextView)paramView.findViewById(2131694469));
      paramViewGroup.a.setLayoutParams(new RelativeLayout.LayoutParams((int)this.c, (int)this.d));
      paramViewGroup.b.setLayoutParams(new LinearLayout.LayoutParams((int)this.c, -2));
      paramViewGroup.c.setLayoutParams(new LinearLayout.LayoutParams((int)this.c, -2));
      paramView.setTag(paramViewGroup);
    }
    HomePageBannerInfo.DataBean localDataBean;
    for (;;)
    {
      localDataBean = (HomePageBannerInfo.DataBean)this.b.get(paramInt);
      paramViewGroup.a.setController(com.freelxl.baselibrary.f.c.frescoController(localDataBean.getPic()));
      paramViewGroup.b.setText(localDataBean.getTitle());
      if (this.e != 1) {
        break;
      }
      paramViewGroup.c.setVisibility(8);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
    }
    paramViewGroup.c.setText(localDataBean.getSubtitle());
    return paramView;
  }
  
  private class a
  {
    SimpleDraweeView a;
    TextView b;
    TextView c;
    
    private a() {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/home/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */