package com.ziroom.ziroomcustomer.newrepair.a;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.ziroom.ziroomcustomer.newServiceList.view.FlowLayoutLimitLine;
import com.ziroom.ziroomcustomer.newrepair.b.l;
import java.util.Iterator;
import java.util.List;

public class f
  extends BaseAdapter
{
  private Context a;
  private List<l> b;
  
  public f(Context paramContext, List<l> paramList)
  {
    this.a = paramContext;
    this.b = paramList;
  }
  
  private void a(a parama, List<com.ziroom.ziroomcustomer.newrepair.b.n> paramList)
  {
    parama.d.removeAllViews();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (com.ziroom.ziroomcustomer.newrepair.b.n)paramList.next();
      TextView localTextView = new TextView(this.a);
      localTextView.setText(((com.ziroom.ziroomcustomer.newrepair.b.n)localObject).getName());
      localTextView.setTag(Boolean.valueOf(false));
      localTextView.setTextColor(this.a.getResources().getColor(2131624097));
      localTextView.setTextSize(12.0F);
      localTextView.setIncludeFontPadding(false);
      localTextView.setGravity(16);
      localTextView.setPadding(com.ziroom.ziroomcustomer.util.n.dip2px(this.a, 8.0F), 0, com.ziroom.ziroomcustomer.util.n.dip2px(this.a, 8.0F), 0);
      localTextView.setBackgroundResource(2130839367);
      localObject = new LinearLayout.LayoutParams(-2, com.ziroom.ziroomcustomer.util.n.dip2px(this.a, 24.0F));
      ((LinearLayout.LayoutParams)localObject).setMargins(0, 0, com.ziroom.ziroomcustomer.util.n.dip2px(this.a, 6.0F), com.ziroom.ziroomcustomer.util.n.dip2px(this.a, 6.0F));
      localTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      parama.d.addView(localTextView);
    }
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
      paramView = LayoutInflater.from(this.a).inflate(2130904472, null);
      paramViewGroup = new a(null);
      paramViewGroup.a = ((TextView)paramView.findViewById(2131689541));
      paramViewGroup.b = ((TextView)paramView.findViewById(2131695579));
      paramViewGroup.c = ((TextView)paramView.findViewById(2131695580));
      paramViewGroup.d = ((FlowLayoutLimitLine)paramView.findViewById(2131691005));
      paramViewGroup.e = ((TextView)paramView.findViewById(2131695581));
      paramView.setTag(paramViewGroup);
    }
    List localList;
    String str;
    for (;;)
    {
      paramViewGroup.a.setText("报修项" + (paramInt + 1));
      paramViewGroup.b.setText(((l)this.b.get(paramInt)).getKongjianName());
      paramViewGroup.c.setText(((l)this.b.get(paramInt)).getZhutiName() + "  " + ((l)this.b.get(paramInt)).getXiangmuName());
      localList = ((l)this.b.get(paramInt)).getLables();
      str = ((l)this.b.get(paramInt)).getDes();
      if ((!TextUtils.isEmpty(str)) || ((localList != null) && (localList.size() != 0))) {
        break;
      }
      paramViewGroup.e.setText("未填写故障描述");
      paramViewGroup.d.setVisibility(8);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
    }
    if ((!TextUtils.isEmpty(str)) && (localList != null) && (localList.size() > 0))
    {
      paramViewGroup.d.setVisibility(0);
      paramViewGroup.e.setVisibility(0);
      paramViewGroup.e.setText(str);
      a(paramViewGroup, localList);
      return paramView;
    }
    if (!TextUtils.isEmpty(str))
    {
      paramViewGroup.d.setVisibility(8);
      paramViewGroup.e.setVisibility(0);
      paramViewGroup.e.setText(str);
      return paramView;
    }
    paramViewGroup.e.setVisibility(8);
    paramViewGroup.d.setVisibility(0);
    a(paramViewGroup, localList);
    return paramView;
  }
  
  private static class a
  {
    public TextView a;
    public TextView b;
    public TextView c;
    public FlowLayoutLimitLine d;
    public TextView e;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newrepair/a/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */