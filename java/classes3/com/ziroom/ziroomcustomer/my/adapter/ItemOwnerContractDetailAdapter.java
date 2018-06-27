package com.ziroom.ziroomcustomer.my.adapter;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.commonlibrary.widget.unifiedziroom.e.a;
import com.ziroom.ziroomcustomer.util.ae;
import java.util.List;

public class ItemOwnerContractDetailAdapter
  extends BaseAdapter
{
  private Context a;
  private List<com.alibaba.fastjson.e> b;
  
  public ItemOwnerContractDetailAdapter(Context paramContext, List<com.alibaba.fastjson.e> paramList)
  {
    this.a = paramContext;
    this.b = paramList;
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
      paramView = View.inflate(this.a, 2130904410, null);
      paramViewGroup = new viewHolder(paramView);
      paramView.setTag(paramViewGroup);
    }
    com.alibaba.fastjson.e locale;
    for (;;)
    {
      locale = (com.alibaba.fastjson.e)this.b.get(paramInt);
      if (locale != null) {
        break;
      }
      paramView.setVisibility(8);
      return paramView;
      paramViewGroup = (viewHolder)paramView.getTag();
    }
    final String str = locale.getString("explainText");
    if (ae.notNull(str))
    {
      paramViewGroup.item_owner_contract_detail_info_item_img.setVisibility(0);
      paramViewGroup.item_owner_contract_detail_info_item_img.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          com.ziroom.commonlibrary.widget.unifiedziroom.e.newBuilder(ItemOwnerContractDetailAdapter.a(ItemOwnerContractDetailAdapter.this)).setContent(str).setButtonText("知道了").build().show();
        }
      });
      if (!ae.notNull(locale.get("title") + "")) {
        break label251;
      }
      paramViewGroup.item_owner_contract_detail_info_item_title.setText("·" + locale.get("title"));
    }
    for (;;)
    {
      if (!ae.notNull(locale.get("value") + "")) {
        break label263;
      }
      paramViewGroup.item_owner_contract_detail_info_item_context.setText(locale.get("value") + "");
      return paramView;
      paramViewGroup.item_owner_contract_detail_info_item_img.setVisibility(8);
      break;
      label251:
      paramViewGroup.item_owner_contract_detail_info_item_title.setText("·");
    }
    label263:
    paramViewGroup.item_owner_contract_detail_info_item_context.setText("");
    return paramView;
  }
  
  class viewHolder
  {
    @BindView(2131695472)
    TextView item_owner_contract_detail_info_item_context;
    @BindView(2131695473)
    ImageView item_owner_contract_detail_info_item_img;
    @BindView(2131695471)
    TextView item_owner_contract_detail_info_item_title;
    
    viewHolder(View paramView)
    {
      ButterKnife.bind(this, paramView);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/my/adapter/ItemOwnerContractDetailAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */