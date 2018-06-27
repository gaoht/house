package com.ziroom.ziroomcustomer.signed.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.ziroom.ziroomcustomer.model.KeyCards;
import com.ziroom.ziroomcustomer.termination.a.j;
import com.ziroom.ziroomcustomer.util.ae;
import java.util.List;

public class NewZZKeysAdapter
  extends BaseAdapter
{
  private Context a;
  private List<KeyCards> b;
  private viewHolder c;
  private String d;
  private List<j> e;
  
  public NewZZKeysAdapter(Context paramContext, List<KeyCards> paramList)
  {
    this.a = paramContext;
    this.b = paramList;
    this.d = null;
  }
  
  public NewZZKeysAdapter(Context paramContext, List<j> paramList, String paramString)
  {
    this.a = paramContext;
    this.e = paramList;
    this.d = paramString;
  }
  
  public int getCount()
  {
    if (ae.isNull(this.d)) {
      return this.b.size();
    }
    return this.e.size();
  }
  
  public Object getItem(int paramInt)
  {
    if (ae.isNull(this.d)) {
      return this.b.get(paramInt);
    }
    return this.e.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    String str3;
    String str2;
    String str1;
    if (paramView == null)
    {
      paramViewGroup = View.inflate(this.a, 2130904987, null);
      this.c = new viewHolder(paramViewGroup);
      paramViewGroup.setTag(this.c);
      if (!ae.isNull(this.d)) {
        break label261;
      }
      str3 = ((KeyCards)this.b.get(paramInt)).getName();
      paramView = ((KeyCards)this.b.get(paramInt)).getState();
      str2 = ((KeyCards)this.b.get(paramInt)).getOver();
      str1 = ((KeyCards)this.b.get(paramInt)).getNums();
      label117:
      if (ae.notNull(str3)) {
        this.c.keys_item_name.setText(str3);
      }
      if (!"1".equals(paramView)) {
        break label335;
      }
      paramView = "正常";
      label149:
      if ((TextUtils.isEmpty(str2)) || (!"1".equals(str2))) {
        break label392;
      }
      if (!ae.notNull(paramView)) {
        break label386;
      }
      paramView = paramView + "，已交付";
    }
    for (;;)
    {
      this.c.keys_item_content.setText(paramView);
      if (!ae.notNull(str1)) {
        break label428;
      }
      this.c.keys_item_size.setText("x" + str1);
      return paramViewGroup;
      this.c = ((viewHolder)paramView.getTag());
      paramViewGroup = paramView;
      break;
      label261:
      str3 = ((j)this.e.get(paramInt)).getName();
      paramView = ((j)this.e.get(paramInt)).getState();
      str2 = ((j)this.e.get(paramInt)).getIsDeliver();
      str1 = ((j)this.e.get(paramInt)).getCount();
      break label117;
      label335:
      if ("2".equals(paramView))
      {
        paramView = "丢失";
        break label149;
      }
      if ("3".equals(paramView))
      {
        paramView = "损坏可维修";
        break label149;
      }
      if ("4".equals(paramView))
      {
        paramView = "损坏不可维修";
        break label149;
      }
      paramView = "";
      break label149;
      label386:
      paramView = "已交付";
      continue;
      label392:
      if (ae.notNull(paramView)) {
        paramView = paramView + "，未交付";
      } else {
        paramView = "未交付";
      }
    }
    label428:
    this.c.keys_item_size.setText("x0");
    return paramViewGroup;
  }
  
  class viewHolder
  {
    @BindView(2131697109)
    TextView keys_item_content;
    @BindView(2131697108)
    TextView keys_item_name;
    @BindView(2131697110)
    TextView keys_item_size;
    
    viewHolder(View paramView)
    {
      ButterKnife.bind(this, paramView);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/signed/adapter/NewZZKeysAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */