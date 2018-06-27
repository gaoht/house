package com.ziroom.ziroomcustomer.signed.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.ziroom.ziroomcustomer.model.GoodList;
import com.ziroom.ziroomcustomer.termination.a.f;
import com.ziroom.ziroomcustomer.util.ae;
import java.util.List;

public class NewZZItemsAdapter
  extends BaseAdapter
{
  private Context a;
  private List<GoodList> b;
  private viewHolder c;
  private List<f> d;
  private String e;
  
  public NewZZItemsAdapter(Context paramContext, List<GoodList> paramList)
  {
    this.a = paramContext;
    this.b = paramList;
    this.e = null;
  }
  
  public NewZZItemsAdapter(Context paramContext, List<f> paramList, String paramString)
  {
    this.a = paramContext;
    this.d = paramList;
    this.e = paramString;
  }
  
  public int getCount()
  {
    if (ae.isNull(this.e)) {
      return this.b.size();
    }
    return this.d.size();
  }
  
  public Object getItem(int paramInt)
  {
    if (ae.isNull(this.e)) {
      return this.b.get(paramInt);
    }
    return this.d.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    int j;
    int i;
    String str2;
    String str3;
    String str1;
    if (paramView == null)
    {
      localView = View.inflate(this.a, 2130904985, null);
      this.c = new viewHolder(localView);
      localView.setTag(this.c);
      j = 0;
      i = 0;
      if (!ae.isNull(this.e)) {
        break label380;
      }
      paramView = ((GoodList)this.b.get(paramInt)).getName();
      paramViewGroup = ((GoodList)this.b.get(paramInt)).getType();
      if (ae.notNull(((GoodList)this.b.get(paramInt)).getUse_status())) {
        i = Integer.parseInt(((GoodList)this.b.get(paramInt)).getUse_status());
      }
      str2 = ((GoodList)this.b.get(paramInt)).getUnit();
      str3 = ((GoodList)this.b.get(paramInt)).getGoodsprice();
      str1 = ((GoodList)this.b.get(paramInt)).getSums();
      label186:
      if (ae.notNull(paramView)) {
        this.c.items_item_name.setText(paramView);
      }
      if (i != 1) {
        break label541;
      }
      if (!ae.isNull(paramViewGroup)) {
        break label518;
      }
      paramView = "正常";
      label220:
      paramViewGroup = paramView;
      if (ae.notNull(str3))
      {
        paramViewGroup = paramView;
        if (Float.parseFloat(str3) > 0.0F)
        {
          if (!ae.notNull(paramView)) {
            break label669;
          }
          paramView = paramView + "，￥" + str3;
          paramViewGroup = paramView;
          if (!ae.notNull(str2)) {}
        }
      }
    }
    label380:
    label518:
    label541:
    label669:
    for (paramViewGroup = paramView + str2;; paramViewGroup = "￥" + ((GoodList)this.b.get(paramInt)).getGoodsprice())
    {
      if (ae.notNull(paramViewGroup)) {
        this.c.items_item_content.setText(paramViewGroup);
      }
      if (!ae.notNull(str1)) {
        break label707;
      }
      this.c.items_item_size.setText("x" + str1);
      return localView;
      this.c = ((viewHolder)paramView.getTag());
      localView = paramView;
      break;
      paramView = ((f)this.d.get(paramInt)).getName();
      paramViewGroup = ((f)this.d.get(paramInt)).getType();
      i = j;
      if (ae.notNull(((f)this.d.get(paramInt)).getState())) {
        i = Integer.parseInt(((f)this.d.get(paramInt)).getState());
      }
      str2 = ((f)this.d.get(paramInt)).getUnit();
      str3 = ((f)this.d.get(paramInt)).getPrice();
      str1 = ((f)this.d.get(paramInt)).getCount();
      break label186;
      paramView = paramViewGroup + "，正常 ";
      break label220;
      if (i == 2)
      {
        if (ae.isNull(paramViewGroup))
        {
          paramView = "丢失";
          break label220;
        }
        paramView = paramViewGroup + "，丢失";
        break label220;
      }
      if (i == 3)
      {
        if (ae.isNull(paramViewGroup))
        {
          paramView = "损坏可维修";
          break label220;
        }
        paramView = paramViewGroup + "，损坏可维修";
        break label220;
      }
      paramView = paramViewGroup;
      if (i != 4) {
        break label220;
      }
      if (ae.isNull(paramViewGroup))
      {
        paramView = "损坏不可维修";
        break label220;
      }
      paramView = paramViewGroup + "，损坏不可维修";
      break label220;
    }
    label707:
    this.c.items_item_size.setText("x0");
    return localView;
  }
  
  class viewHolder
  {
    @BindView(2131697100)
    TextView items_item_content;
    @BindView(2131697099)
    TextView items_item_name;
    @BindView(2131697101)
    TextView items_item_size;
    
    viewHolder(View paramView)
    {
      ButterKnife.bind(this, paramView);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/signed/adapter/NewZZItemsAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */