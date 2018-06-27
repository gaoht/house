package com.ziroom.ziroomcustomer.findhouse.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.findhouse.presenter.model.RentHouseDetail.Service;
import com.ziroom.ziroomcustomer.findhouse.presenter.model.RentHouseDetail.Service.Detail;
import com.ziroom.ziroomcustomer.findhouse.presenter.model.RentHouseDetail.Service.Item;
import com.ziroom.ziroomcustomer.webview.HomeWebActivity;
import com.ziroom.ziroomcustomer.widget.ListViewForScrollView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class RentHouseDetailServicePop
  extends PopupWindow
  implements View.OnClickListener
{
  private ImageView a;
  private ListViewForScrollView b;
  private View c;
  private Context d;
  private LayoutInflater e;
  private List<Map<String, String>> f;
  
  public RentHouseDetailServicePop(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public RentHouseDetailServicePop(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public RentHouseDetailServicePop(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setSoftInputMode(16);
    setWidth(-1);
    setHeight(-1);
    setAnimationStyle(2131427507);
    this.e = ((Activity)paramContext).getLayoutInflater();
    this.c = this.e.inflate(2130904782, null);
    this.d = paramContext;
    a();
  }
  
  private void a()
  {
    this.a = ((ImageView)this.c.findViewById(2131689492));
    this.b = ((ListViewForScrollView)this.c.findViewById(2131690077));
    this.a.setOnClickListener(this);
    setContentView(this.c);
  }
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    switch (paramView.getId())
    {
    default: 
      return;
    }
    dismiss();
  }
  
  public void show(View paramView, RentHouseDetail.Service paramService)
  {
    if ((paramService != null) && (paramService.getDetail() != null) && (paramService.getDetail().size() > 0))
    {
      this.f = new ArrayList();
      paramService = paramService.getDetail().iterator();
      while (paramService.hasNext())
      {
        Object localObject1 = (RentHouseDetail.Service.Detail)paramService.next();
        Object localObject2 = new HashMap();
        ((Map)localObject2).put("desc", ((RentHouseDetail.Service.Detail)localObject1).getTitle());
        ((Map)localObject2).put("type", "detail");
        if ("window".equals(((RentHouseDetail.Service.Detail)localObject1).getType()))
        {
          ((Map)localObject2).put("url", "");
          this.f.add(localObject2);
          if ((((RentHouseDetail.Service.Detail)localObject1).getItem() != null) && (((RentHouseDetail.Service.Detail)localObject1).getItem().size() > 0))
          {
            localObject1 = ((RentHouseDetail.Service.Detail)localObject1).getItem().iterator();
            while (((Iterator)localObject1).hasNext())
            {
              localObject2 = (RentHouseDetail.Service.Item)((Iterator)localObject1).next();
              HashMap localHashMap = new HashMap();
              localHashMap.put("desc", ((RentHouseDetail.Service.Item)localObject2).getDesc());
              localHashMap.put("sub_desc", ((RentHouseDetail.Service.Item)localObject2).getSub_desc());
              localHashMap.put("type", "item");
              localHashMap.put("url", ((RentHouseDetail.Service.Item)localObject2).getUrl());
              this.f.add(localHashMap);
            }
          }
        }
        else if ("link".equals(((RentHouseDetail.Service.Detail)localObject1).getType()))
        {
          ((Map)localObject2).put("url", ((RentHouseDetail.Service.Detail)localObject1).getUrl());
          this.f.add(localObject2);
        }
      }
      this.b.setAdapter(new a(null));
      if (!(this instanceof PopupWindow)) {
        super.showAtLocation(paramView, 0, 0, 0);
      }
    }
    else
    {
      return;
    }
    VdsAgent.showAtLocation((PopupWindow)this, paramView, 0, 0, 0);
  }
  
  private class a
    extends BaseAdapter
  {
    private a() {}
    
    public int getCount()
    {
      if (RentHouseDetailServicePop.a(RentHouseDetailServicePop.this) == null) {
        return 0;
      }
      return RentHouseDetailServicePop.a(RentHouseDetailServicePop.this).size();
    }
    
    public Object getItem(int paramInt)
    {
      return RentHouseDetailServicePop.a(RentHouseDetailServicePop.this).get(paramInt);
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public int getItemViewType(int paramInt)
    {
      Map localMap = (Map)getItem(paramInt);
      if ("detail".equals(localMap.get("type"))) {
        return 0;
      }
      if ("item".equals(localMap.get("type"))) {
        return 1;
      }
      return super.getItemViewType(paramInt);
    }
    
    public View getView(int paramInt, View paramView, final ViewGroup paramViewGroup)
    {
      View localView = paramView;
      if (paramView == null)
      {
        if (getItemViewType(paramInt) == 0) {
          localView = RentHouseDetailServicePop.b(RentHouseDetailServicePop.this).inflate(2130904460, paramViewGroup, false);
        }
      }
      else
      {
        paramViewGroup = (Map)getItem(paramInt);
        paramView = null;
        if (getItemViewType(paramInt) != 0) {
          break label174;
        }
        ((TextView)localView.findViewById(2131692617)).setText((CharSequence)paramViewGroup.get("desc"));
      }
      for (;;)
      {
        final Object localObject1;
        if ((paramView != null) && (getItemViewType(paramInt) == 1))
        {
          localObject1 = (String)paramViewGroup.get("url");
          paramViewGroup = (String)paramViewGroup.get("desc");
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            break label309;
          }
          paramView.setVisibility(0);
          paramView.setOnClickListener(new View.OnClickListener()
          {
            @Instrumented
            public void onClick(View paramAnonymousView)
            {
              VdsAgent.onClick(this, paramAnonymousView);
              paramAnonymousView = new Intent(RentHouseDetailServicePop.c(RentHouseDetailServicePop.this), HomeWebActivity.class);
              paramAnonymousView.putExtra("url", localObject1);
              paramAnonymousView.putExtra("title", paramViewGroup);
              RentHouseDetailServicePop.c(RentHouseDetailServicePop.this).startActivity(paramAnonymousView);
            }
          });
        }
        return localView;
        localView = paramView;
        if (getItemViewType(paramInt) != 1) {
          break;
        }
        localView = RentHouseDetailServicePop.b(RentHouseDetailServicePop.this).inflate(2130904461, paramViewGroup, false);
        break;
        label174:
        if (getItemViewType(paramInt) == 1)
        {
          Object localObject2 = (TextView)localView.findViewById(2131690073);
          localObject1 = (TextView)localView.findViewById(2131695575);
          paramView = (TextView)localView.findViewById(2131693772);
          String str = (String)paramViewGroup.get("desc");
          if (TextUtils.isEmpty(str)) {
            ((TextView)localObject2).setVisibility(8);
          }
          for (;;)
          {
            localObject2 = (String)paramViewGroup.get("sub_desc");
            if (!TextUtils.isEmpty((CharSequence)localObject2)) {
              break label293;
            }
            ((TextView)localObject1).setVisibility(8);
            break;
            ((TextView)localObject2).setVisibility(0);
            ((TextView)localObject2).setText(str);
          }
          label293:
          ((TextView)localObject1).setVisibility(0);
          ((TextView)localObject1).setText((CharSequence)localObject2);
        }
      }
      label309:
      paramView.setVisibility(8);
      return localView;
    }
    
    public int getViewTypeCount()
    {
      return 2;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/findhouse/view/RentHouseDetailServicePop.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */