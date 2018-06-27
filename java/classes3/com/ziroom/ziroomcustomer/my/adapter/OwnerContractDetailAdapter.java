package com.ziroom.ziroomcustomer.my.adapter;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.alibaba.fastjson.e;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.commonlibrary.login.a.c;
import com.ziroom.ziroomcustomer.activity.ListViewForScrollView;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.webview.JsBridgeWebActivity;
import java.util.List;

public class OwnerContractDetailAdapter
  extends BaseAdapter
{
  private List<Object> a;
  private Context b;
  private String c = OwnerContractDetailAdapter.class.getSimpleName();
  
  public OwnerContractDetailAdapter(List<Object> paramList, Context paramContext)
  {
    this.a = paramList;
    this.b = paramContext;
  }
  
  public int getCount()
  {
    if (this.a == null) {
      return 0;
    }
    return this.a.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.a.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject;
    if (paramView == null)
    {
      paramView = View.inflate(this.b, 2130904409, null);
      paramViewGroup = new viewHolder(paramView);
      paramView.setTag(paramViewGroup);
      localObject = (e)this.a.get(paramInt);
      if (localObject != null) {
        break label63;
      }
    }
    label63:
    label105:
    label168:
    label355:
    label367:
    label377:
    for (;;)
    {
      return paramView;
      paramViewGroup = (viewHolder)paramView.getTag();
      break;
      final String str = ((e)localObject).getString("payPlan");
      if (ae.notNull(str))
      {
        paramViewGroup.owner_contract_detail_show_html.setVisibility(0);
        paramViewGroup.owner_contract_detail_show_html.setOnClickListener(new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymousView)
          {
            VdsAgent.onClick(this, paramAnonymousView);
            OwnerContractDetailAdapter.this.toH5Page(str, "付款计划页");
          }
        });
        if (!ae.notNull(((e)localObject).get("itemName") + "")) {
          break label355;
        }
        paramViewGroup.owner_contract_detail_title.setText("" + ((e)localObject).get("itemName"));
        if (!ae.notNull(((e)localObject).get("houseAddress") + "")) {
          break label367;
        }
        paramViewGroup.owner_contract_detail_context.setVisibility(0);
        paramViewGroup.owner_contract_detail_context.setText(((e)localObject).get("houseAddress") + "");
      }
      for (;;)
      {
        if (ae.isNull(((e)localObject).get("data") + "")) {
          break label377;
        }
        localObject = com.alibaba.fastjson.a.parseArray(((e)localObject).get("data") + "", e.class);
        if ((localObject == null) || (((List)localObject).size() <= 0)) {
          break;
        }
        localObject = new ItemOwnerContractDetailAdapter(this.b, (List)localObject);
        paramViewGroup.owner_contract_detail_item_list.setAdapter((ListAdapter)localObject);
        return paramView;
        paramViewGroup.owner_contract_detail_show_html.setVisibility(8);
        break label105;
        paramViewGroup.owner_contract_detail_title.setText("");
        break label168;
        paramViewGroup.owner_contract_detail_context.setVisibility(8);
      }
    }
  }
  
  public void toH5Page(final String paramString1, final String paramString2)
  {
    com.ziroom.commonlibrary.login.a.verifyToken(this.b, new a.c()
    {
      public void onVerifyFinish(boolean paramAnonymousBoolean)
      {
        if (paramAnonymousBoolean)
        {
          String str = paramString1;
          if (str.contains("?")) {}
          for (str = str + "&";; str = str + "?")
          {
            str = str + "token=" + com.ziroom.commonlibrary.login.a.getToken(OwnerContractDetailAdapter.a(OwnerContractDetailAdapter.this));
            Log.i(OwnerContractDetailAdapter.b(OwnerContractDetailAdapter.this), "跳转到H5:" + str);
            JsBridgeWebActivity.start(OwnerContractDetailAdapter.a(OwnerContractDetailAdapter.this), paramString2, str);
            return;
          }
        }
        com.ziroom.commonlibrary.login.a.startLoginActivity(OwnerContractDetailAdapter.a(OwnerContractDetailAdapter.this));
      }
    });
  }
  
  class viewHolder
  {
    @BindView(2131695468)
    TextView owner_contract_detail_context;
    @BindView(2131695469)
    ListViewForScrollView owner_contract_detail_item_list;
    @BindView(2131695470)
    TextView owner_contract_detail_show_html;
    @BindView(2131695467)
    TextView owner_contract_detail_title;
    
    viewHolder(View paramView)
    {
      ButterKnife.bind(this, paramView);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/my/adapter/OwnerContractDetailAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */