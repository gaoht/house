package com.ziroom.ziroomcustomer.ziroomapartment.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.freelxl.baselibrary.d.f.a;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.a.c;
import com.ziroom.ziroomcustomer.e.c.f;
import com.ziroom.ziroomcustomer.e.j;
import com.ziroom.ziroomcustomer.widget.ListViewForScrollView;
import com.ziroom.ziroomcustomer.ziroomapartment.model.sign.ZryuSignConfigure;
import com.ziroom.ziroomcustomer.ziroomapartment.model.sign.ZryuSignConfigureItem;
import com.ziroom.ziroomcustomer.ziroomapartment.model.sign.ZryuSignConfigureItem.Item;
import java.util.ArrayList;
import java.util.List;

public class ZryuSignConfigureActivity
  extends BaseActivity
{
  private LayoutInflater a;
  private ImageView b;
  private ListViewForScrollView c;
  private String d;
  private c e = new c(this, new f(ZryuSignConfigure.class))
  {
    public void onSuccess(int paramAnonymousInt, ZryuSignConfigure paramAnonymousZryuSignConfigure)
    {
      super.onSuccess(paramAnonymousInt, paramAnonymousZryuSignConfigure);
      if (paramAnonymousZryuSignConfigure != null)
      {
        paramAnonymousZryuSignConfigure = paramAnonymousZryuSignConfigure.getCatalogItems();
        if ((paramAnonymousZryuSignConfigure != null) && (paramAnonymousZryuSignConfigure.size() > 0)) {
          ZryuSignConfigureActivity.a(ZryuSignConfigureActivity.this).setAdapter(new ZryuSignConfigureActivity.a(ZryuSignConfigureActivity.this, paramAnonymousZryuSignConfigure));
        }
      }
    }
  };
  
  private void a()
  {
    this.d = getIntent().getStringExtra("contractId");
    if (!TextUtils.isEmpty(this.d)) {
      j.zryuItemDeliveryCatalogItems(this, this.d, this.e);
    }
  }
  
  private void b()
  {
    this.b = ((ImageView)findViewById(2131689492));
    this.c = ((ListViewForScrollView)findViewById(2131690077));
    this.a = LayoutInflater.from(this);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903608);
    b();
    a();
  }
  
  public void onViewClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    finish();
  }
  
  private class a
    extends BaseAdapter
  {
    private List<ZryuSignConfigureItem.Item> b;
    
    public a()
    {
      Object localObject;
      if ((localObject != null) && (((List)localObject).size() > 0))
      {
        this.b = new ArrayList();
        int i = 0;
        while (i < ((List)localObject).size())
        {
          this$1 = (ZryuSignConfigureItem)((List)localObject).get(i);
          if (ZryuSignConfigureActivity.this != null)
          {
            ZryuSignConfigureItem.Item localItem = new ZryuSignConfigureItem.Item();
            localItem.setName(ZryuSignConfigureActivity.this.getName());
            localItem.setType(0);
            this.b.add(localItem);
            if ((ZryuSignConfigureActivity.this.getItems() != null) && (ZryuSignConfigureActivity.this.getItems().size() > 0))
            {
              int j = 0;
              while (j < ZryuSignConfigureActivity.this.getItems().size())
              {
                localItem = (ZryuSignConfigureItem.Item)ZryuSignConfigureActivity.this.getItems().get(j);
                localItem.setType(1);
                this.b.add(localItem);
                j += 1;
              }
            }
          }
          i += 1;
        }
      }
    }
    
    public int getCount()
    {
      if (this.b == null) {
        return 0;
      }
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
    
    public int getItemViewType(int paramInt)
    {
      return ((ZryuSignConfigureItem.Item)this.b.get(paramInt)).getType();
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      int i = getItemViewType(paramInt);
      Object localObject;
      if (i == 0) {
        if (paramView == null)
        {
          paramView = ZryuSignConfigureActivity.b(ZryuSignConfigureActivity.this).inflate(2130904635, paramViewGroup, false);
          paramViewGroup = new b(null);
          paramViewGroup.a = ((TextView)paramView.findViewById(2131690049));
          paramView.setTag(paramViewGroup);
          localObject = (ZryuSignConfigureItem.Item)getItem(paramInt);
          paramViewGroup.a.setText(((ZryuSignConfigureItem.Item)localObject).getName());
          localObject = paramView;
        }
      }
      do
      {
        return (View)localObject;
        paramViewGroup = (b)paramView.getTag();
        break;
        localObject = paramView;
      } while (i != 1);
      if (paramView == null)
      {
        paramView = ZryuSignConfigureActivity.b(ZryuSignConfigureActivity.this).inflate(2130904637, paramViewGroup, false);
        paramViewGroup = new a(null);
        paramViewGroup.a = ((TextView)paramView.findViewById(2131690049));
        paramViewGroup.b = ((TextView)paramView.findViewById(2131689912));
        paramViewGroup.c = ((TextView)paramView.findViewById(2131690003));
        paramView.setTag(paramViewGroup);
        localObject = (ZryuSignConfigureItem.Item)getItem(paramInt);
        paramViewGroup.a.setText(((ZryuSignConfigureItem.Item)localObject).getName());
        if (!TextUtils.isEmpty(((ZryuSignConfigureItem.Item)localObject).getPrice())) {
          break label252;
        }
        paramViewGroup.b.setText("");
      }
      for (;;)
      {
        if (((ZryuSignConfigureItem.Item)localObject).getNum() != null) {
          break label290;
        }
        paramViewGroup.c.setText("");
        return paramView;
        paramViewGroup = (a)paramView.getTag();
        break;
        label252:
        paramViewGroup.b.setText("（" + ((ZryuSignConfigureItem.Item)localObject).getPrice() + "）");
      }
      label290:
      paramViewGroup.c.setText("×" + ((ZryuSignConfigureItem.Item)localObject).getNum());
      return paramView;
    }
    
    public int getViewTypeCount()
    {
      return 2;
    }
    
    private class a
    {
      TextView a;
      TextView b;
      TextView c;
      
      private a() {}
    }
    
    private class b
    {
      TextView a;
      
      private b() {}
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomapartment/activity/ZryuSignConfigureActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */