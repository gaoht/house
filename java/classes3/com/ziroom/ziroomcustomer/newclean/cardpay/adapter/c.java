package com.ziroom.ziroomcustomer.newclean.cardpay.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.freelxl.baselibrary.f.f;
import com.ziroom.ziroomcustomer.newServiceList.utils.i;
import com.ziroom.ziroomcustomer.newclean.d.w;
import java.text.DecimalFormat;
import java.util.List;

public class c
  extends BaseAdapter
{
  private Context a;
  private List<w> b;
  
  public c(Context paramContext, List<w> paramList)
  {
    this.a = paramContext;
    this.b = paramList;
  }
  
  public static String getFormatNumber(long paramLong)
  {
    return new DecimalFormat("0.00").format(paramLong / 100.0D);
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
    w localw;
    if (paramView == null)
    {
      paramView = View.inflate(this.a, 2130904155, null);
      paramViewGroup = new a();
      paramViewGroup.a = ((TextView)paramView.findViewById(2131694905));
      paramViewGroup.b = ((TextView)paramView.findViewById(2131694906));
      paramViewGroup.c = ((TextView)paramView.findViewById(2131694907));
      paramViewGroup.d = ((TextView)paramView.findViewById(2131694908));
      paramViewGroup.e = ((TextView)paramView.findViewById(2131694910));
      paramViewGroup.f = ((TextView)paramView.findViewById(2131694911));
      paramViewGroup.g = ((TextView)paramView.findViewById(2131694909));
      paramView.setTag(paramViewGroup);
      localw = (w)this.b.get(paramInt);
      paramViewGroup.a.setText(localw.getRecordTypeValue());
      paramViewGroup.e.setText(localw.getChangeTypeValue() + getFormatNumber(Long.parseLong(localw.getAmount())));
      paramViewGroup.b.setText(i.getSysData(Long.parseLong(localw.getCreateTime())));
      paramViewGroup.c.setText(i.getLong2Data(Long.parseLong(localw.getCreateTime())));
      paramViewGroup.d.setText("总余额" + Long.parseLong(localw.getRemainAmount()) / 100L + "元");
      if (!f.notNull(localw.getOrderNumber())) {
        break label357;
      }
      paramViewGroup.g.setText("交易单号：" + localw.getOrderNumber());
      paramViewGroup.g.setVisibility(0);
    }
    for (;;)
    {
      if (TextUtils.isEmpty(localw.getServiceTypeName())) {
        break label369;
      }
      paramViewGroup.f.setVisibility(0);
      paramViewGroup.f.setText(localw.getServiceTypeName());
      return paramView;
      paramViewGroup = (a)paramView.getTag();
      break;
      label357:
      paramViewGroup.g.setVisibility(8);
    }
    label369:
    paramViewGroup.f.setVisibility(8);
    return paramView;
  }
  
  public class a
  {
    public TextView a;
    public TextView b;
    public TextView c;
    public TextView d;
    public TextView e;
    public TextView f;
    public TextView g;
    
    public a() {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newclean/cardpay/adapter/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */