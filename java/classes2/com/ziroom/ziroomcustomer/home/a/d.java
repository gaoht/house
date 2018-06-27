package com.ziroom.ziroomcustomer.home.a;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.f.c;
import com.ziroom.ziroomcustomer.util.ac;
import com.ziroom.ziroomcustomer.util.x;
import com.ziroom.ziroomcustomer.ziroomapartment.model.HomePageBeanZRY.CommunityBean.CommunitylistBean;
import java.util.List;

public class d
  extends BaseAdapter
{
  private Context a;
  private List<HomePageBeanZRY.CommunityBean.CommunitylistBean> b;
  private float c;
  private float d;
  
  public d(Context paramContext, List<HomePageBeanZRY.CommunityBean.CommunitylistBean> paramList)
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
    Object localObject1;
    Object localObject2;
    if (paramView == null)
    {
      float f = this.a.getResources().getDisplayMetrics().density;
      paramView = LayoutInflater.from(this.a).inflate(2130904022, null);
      paramViewGroup = new a(null);
      paramViewGroup.a = ((SimpleDraweeView)paramView.findViewById(2131694412));
      paramViewGroup.b = ((TextView)paramView.findViewById(2131694468));
      c.frescoHierarchyController(paramViewGroup.a, 2130838349);
      paramViewGroup.c = ((TextView)paramView.findViewById(2131694469));
      paramViewGroup.d = ((TextView)paramView.findViewById(2131694470));
      paramViewGroup.a.setLayoutParams(new RelativeLayout.LayoutParams((int)this.c, (int)this.d));
      localObject1 = new LinearLayout.LayoutParams((int)this.c, -2);
      ((LinearLayout.LayoutParams)localObject1).setMargins(0, (int)(12.0F * f), 0, 0);
      localObject2 = new LinearLayout.LayoutParams((int)this.c, -2);
      ((LinearLayout.LayoutParams)localObject2).setMargins(0, (int)(8.0F * f), 0, 0);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams((int)this.c, -2);
      localLayoutParams.setMargins(0, (int)(f * 8.0F), 0, 0);
      paramViewGroup.b.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      paramViewGroup.c.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      paramViewGroup.d.setLayoutParams(localLayoutParams);
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      localObject1 = (HomePageBeanZRY.CommunityBean.CommunitylistBean)this.b.get(paramInt);
      localObject2 = x.makeUrl(((HomePageBeanZRY.CommunityBean.CommunitylistBean)localObject1).getPic());
      paramViewGroup.a.setController(c.frescoController((String)localObject2));
      paramViewGroup.b.setText(((HomePageBeanZRY.CommunityBean.CommunitylistBean)localObject1).getTitle());
      paramViewGroup.c.setText(((HomePageBeanZRY.CommunityBean.CommunitylistBean)localObject1).getSubtitle());
      paramViewGroup.d.setText(((HomePageBeanZRY.CommunityBean.CommunitylistBean)localObject1).getActivity_time());
      return paramView;
      paramViewGroup = (a)paramView.getTag();
    }
  }
  
  private class a
  {
    SimpleDraweeView a;
    TextView b;
    TextView c;
    TextView d;
    
    private a() {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/home/a/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */