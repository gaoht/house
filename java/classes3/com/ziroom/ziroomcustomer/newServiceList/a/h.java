package com.ziroom.ziroomcustomer.newServiceList.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.ziroom.ziroomcustomer.newServiceList.model.an;
import java.util.ArrayList;
import java.util.List;

public class h
  extends BaseAdapter
{
  private LayoutInflater a;
  private Context b;
  private List<String> c;
  private List<an> d;
  private int e;
  private int f = -1;
  
  public h(Context paramContext, int paramInt)
  {
    this.a = LayoutInflater.from(paramContext);
    this.b = paramContext;
    this.e = paramInt;
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.c = this.c;
      return;
      this.d = a();
      continue;
      this.d = b();
      continue;
      this.d = c();
      continue;
      this.d = d();
    }
  }
  
  private List<an> a()
  {
    ArrayList localArrayList = new ArrayList();
    an localan1 = new an(2130838453, 2130838454, 2130838455, "水管龙头", "101010121000000");
    an localan2 = new an(2130838219, 2130838220, 2130838221, "马桶", "101010121000001");
    an localan3 = new an(2130838518, 2130838519, 2130838520, "洗手/菜池", "101010121000002");
    an localan4 = new an(2130839707, 2130839708, 2130839709, "淋浴", "101010121000003");
    an localan5 = new an(2130837637, 2130837638, 2130837639, "浴缸", "101010121000004");
    an localan6 = new an(2130838474, 2130838475, 2130838476, "地漏", "101010121000005");
    an localan7 = new an(2130839898, 2130839899, 2130839900, "阀门", "101010121000006");
    an localan8 = new an(2130839302, 2130839303, 2130839304, "疏通", "101010121000007");
    localArrayList.add(localan1);
    localArrayList.add(localan2);
    localArrayList.add(localan3);
    localArrayList.add(localan4);
    localArrayList.add(localan5);
    localArrayList.add(localan6);
    localArrayList.add(localan7);
    localArrayList.add(localan8);
    return localArrayList;
  }
  
  private void a(ImageView paramImageView, TextView paramTextView, int paramInt)
  {
    an localan = (an)this.d.get(paramInt);
    if (!localan.isSelected()) {
      paramImageView.setImageResource(localan.getDefaultRes());
    }
    for (;;)
    {
      paramTextView.setText(localan.getName());
      return;
      paramImageView.setImageResource(localan.getSelectedRes());
    }
  }
  
  private List<an> b()
  {
    ArrayList localArrayList = new ArrayList();
    an localan1 = new an(2130838917, 2130838918, 2130838919, "灯具", "101010101000000");
    an localan2 = new an(2130839256, 2130839257, 2130839258, "插座开关", "101010101000001");
    an localan3 = new an(2130838943, 2130838944, 2130838945, "线路问题", "101010101000002");
    an localan4 = new an(2130837640, 2130837641, 2130837642, "卫浴灯具", "101010101000003");
    localArrayList.add(localan1);
    localArrayList.add(localan2);
    localArrayList.add(localan3);
    localArrayList.add(localan4);
    return localArrayList;
  }
  
  private List<an> c()
  {
    ArrayList localArrayList = new ArrayList();
    an localan1 = new an(2130838081, 2130838082, 2130838083, "防盗门锁", "101010111000001");
    an localan2 = new an(2130837644, 2130837645, 2130837646, "卧室门锁", "101010111000000");
    localArrayList.add(localan1);
    localArrayList.add(localan2);
    return localArrayList;
  }
  
  private List<an> d()
  {
    ArrayList localArrayList = new ArrayList();
    an localan = new an(2130838081, 2130837596, 2130837597, "空调清洗", "101010141000000");
    localan.setSelected(true);
    localArrayList.add(localan);
    return localArrayList;
  }
  
  public int getCount()
  {
    return this.d.size();
  }
  
  public Object getItem(int paramInt)
  {
    return Integer.valueOf(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public an getRepairItem(int paramInt)
  {
    if (this.d == null) {
      return null;
    }
    return (an)this.d.get(paramInt);
  }
  
  public List<an> getRepairItemList()
  {
    return this.d;
  }
  
  public int getReservationId(int paramInt)
  {
    if (this.d == null) {
      return -1;
    }
    return ((an)this.d.get(paramInt)).getReservationRes();
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramView = this.a.inflate(2130904473, paramViewGroup, false);
    a((ImageView)paramView.findViewById(2131693056), (TextView)paramView.findViewById(2131690049), paramInt);
    return paramView;
  }
  
  public void setItemSelected(int paramInt)
  {
    if (this.f == -1)
    {
      this.f = paramInt;
      ((an)this.d.get(paramInt)).setSelected(true);
    }
    for (;;)
    {
      notifyDataSetChanged();
      return;
      ((an)this.d.get(this.f)).setSelected(false);
      ((an)this.d.get(paramInt)).setSelected(true);
      this.f = paramInt;
    }
  }
  
  public void setRepairItem(int paramInt, an paraman)
  {
    this.d.set(paramInt, paraman);
  }
  
  public void setRepairItemList(List<an> paramList)
  {
    this.d = paramList;
    notifyDataSetChanged();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newServiceList/a/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */