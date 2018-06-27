package com.ziroom.ziroomcustomer.my.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.alibaba.fastjson.a;
import com.alibaba.fastjson.e;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.f.c;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.activity.ListViewForScrollView;
import com.ziroom.ziroomcustomer.my.OwnerPhotoPreviewActivity;
import com.ziroom.ziroomcustomer.util.ae;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class OwnerDeliveryDetailAdapter
  extends BaseAdapter
{
  private List<Object> a;
  private Context b;
  
  public OwnerDeliveryDetailAdapter(List<Object> paramList, Context paramContext)
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
  
  public View getView(final int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    final Object localObject1;
    if (paramView == null)
    {
      paramView = View.inflate(this.b, 2130904416, null);
      paramViewGroup = new viewHolder(paramView);
      paramView.setTag(paramViewGroup);
      localObject1 = (e)this.a.get(paramInt);
      if (localObject1 != null) {
        break label63;
      }
    }
    for (;;)
    {
      return paramView;
      paramViewGroup = (viewHolder)paramView.getTag();
      break;
      label63:
      if (ae.notNull(((e)localObject1).get("deliveryName") + "")) {
        paramViewGroup.owner_delivery_detail_title.setText("" + ((e)localObject1).get("deliveryName"));
      }
      Object localObject2;
      for (;;)
      {
        if (ae.isNull(((e)localObject1).get("data") + "")) {
          break label331;
        }
        localObject2 = a.parseArray(((e)localObject1).get("data") + "", e.class);
        if ((localObject2 == null) || (((List)localObject2).size() <= 0)) {
          break;
        }
        localObject2 = new ItemOwnerContractDetailAdapter(this.b, (List)localObject2);
        paramViewGroup.owner_delivery_detail_item_list.setAdapter((ListAdapter)localObject2);
        localObject2 = new ArrayList();
        ((List)localObject2).add(paramViewGroup.owner_delivery_detail_img1);
        ((List)localObject2).add(paramViewGroup.owner_delivery_detail_img2);
        ((List)localObject2).add(paramViewGroup.owner_delivery_detail_img3);
        ((List)localObject2).add(paramViewGroup.owner_delivery_detail_img4);
        Iterator localIterator = ((List)localObject2).iterator();
        while (localIterator.hasNext()) {
          ((SimpleDraweeView)localIterator.next()).setVisibility(4);
        }
        paramViewGroup.owner_delivery_detail_title.setText("");
      }
      label331:
      continue;
      localObject1 = ((e)localObject1).getString("imgUrls");
      if (!ae.notNull((String)localObject1)) {
        break label504;
      }
      localObject1 = a.parseArray((String)localObject1, String.class);
      if (((List)localObject1).size() <= 0) {
        break label493;
      }
      paramInt = 0;
      while (paramInt < ((List)localObject1).size())
      {
        if ((ae.notNull((String)((List)localObject1).get(paramInt))) && (paramInt < ((List)localObject2).size()))
        {
          paramViewGroup.owner_delivery_detail_img_ll.setVisibility(0);
          ((SimpleDraweeView)((List)localObject2).get(paramInt)).setController(c.frescoController((String)((List)localObject1).get(paramInt)));
          ((SimpleDraweeView)((List)localObject2).get(paramInt)).setVisibility(0);
          ((SimpleDraweeView)((List)localObject2).get(paramInt)).setOnClickListener(new View.OnClickListener()
          {
            @Instrumented
            public void onClick(View paramAnonymousView)
            {
              VdsAgent.onClick(this, paramAnonymousView);
              paramAnonymousView = new Intent(OwnerDeliveryDetailAdapter.a(OwnerDeliveryDetailAdapter.this), OwnerPhotoPreviewActivity.class);
              paramAnonymousView.putStringArrayListExtra("urlList", (ArrayList)localObject1);
              paramAnonymousView.putExtra("position", paramInt);
              OwnerDeliveryDetailAdapter.a(OwnerDeliveryDetailAdapter.this).startActivity(paramAnonymousView);
            }
          });
        }
        paramInt += 1;
      }
    }
    label493:
    paramViewGroup.owner_delivery_detail_img_ll.setVisibility(8);
    return paramView;
    label504:
    paramViewGroup.owner_delivery_detail_img_ll.setVisibility(8);
    return paramView;
  }
  
  class viewHolder
  {
    @BindView(2131695495)
    SimpleDraweeView owner_delivery_detail_img1;
    @BindView(2131695496)
    SimpleDraweeView owner_delivery_detail_img2;
    @BindView(2131695497)
    SimpleDraweeView owner_delivery_detail_img3;
    @BindView(2131695498)
    SimpleDraweeView owner_delivery_detail_img4;
    @BindView(2131695494)
    LinearLayout owner_delivery_detail_img_ll;
    @BindView(2131695493)
    ListViewForScrollView owner_delivery_detail_item_list;
    @BindView(2131695492)
    TextView owner_delivery_detail_title;
    
    viewHolder(View paramView)
    {
      ButterKnife.bind(this, paramView);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/my/adapter/OwnerDeliveryDetailAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */