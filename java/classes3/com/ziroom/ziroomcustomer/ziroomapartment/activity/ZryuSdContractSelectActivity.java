package com.ziroom.ziroomcustomer.ziroomapartment.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;
import com.alibaba.fastjson.b;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.ziroomapartment.model.sd.ValidContract;
import java.util.List;

public class ZryuSdContractSelectActivity
  extends BaseActivity
{
  private Button a;
  private ListView b;
  private List<ValidContract> c;
  private ValidContract d;
  private int e = -1;
  private a f;
  
  private void a()
  {
    this.a = ((Button)findViewById(2131690043));
    this.b = ((ListView)findViewById(2131689817));
  }
  
  private void b()
  {
    Object localObject = getIntent().getStringExtra("contractList");
    this.e = getIntent().getIntExtra("selectedIndex", -1);
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      this.c = b.parseArray((String)localObject, ValidContract.class);
    }
    if ((this.c == null) || (this.e >= this.c.size()))
    {
      this.e = -1;
      localObject = this.a;
      if ((this.e == -1) || (this.d == null)) {
        break label143;
      }
    }
    label143:
    for (boolean bool = true;; bool = false)
    {
      ((Button)localObject).setEnabled(bool);
      this.f = new a();
      this.b.setAdapter(this.f);
      return;
      this.d = ((ValidContract)this.c.get(this.e));
      break;
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903599);
    a();
    b();
  }
  
  public void onViewClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131689492: 
      finish();
      overridePendingTransition(2130968590, 2130968680);
      return;
    }
    paramView = getIntent();
    paramView.putExtra("selectedIndex", this.e);
    paramView.putExtra("SelectedContract", this.d);
    setResult(-1, paramView);
    finish();
    overridePendingTransition(2130968590, 2130968680);
  }
  
  private class a
    extends BaseAdapter
  {
    private LayoutInflater b = LayoutInflater.from(ZryuSdContractSelectActivity.this);
    
    public a() {}
    
    public int getCount()
    {
      if (ZryuSdContractSelectActivity.a(ZryuSdContractSelectActivity.this) == null) {
        return 0;
      }
      return ZryuSdContractSelectActivity.a(ZryuSdContractSelectActivity.this).size();
    }
    
    public Object getItem(int paramInt)
    {
      return ZryuSdContractSelectActivity.a(ZryuSdContractSelectActivity.this).get(paramInt);
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public View getView(final int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      if (paramView == null)
      {
        paramView = this.b.inflate(2130904609, paramViewGroup, false);
        paramViewGroup = new a();
        paramViewGroup.a = ((RadioButton)paramView.findViewById(2131695865));
        paramViewGroup.b = ((TextView)paramView.findViewById(2131689752));
        paramView.setTag(paramViewGroup);
        ValidContract localValidContract = (ValidContract)ZryuSdContractSelectActivity.a(ZryuSdContractSelectActivity.this).get(paramInt);
        paramViewGroup.b.setText(localValidContract.getProjectName() + localValidContract.getRoomCode());
        paramViewGroup = paramViewGroup.a;
        if (ZryuSdContractSelectActivity.b(ZryuSdContractSelectActivity.this) != paramInt) {
          break label158;
        }
      }
      label158:
      for (boolean bool = true;; bool = false)
      {
        paramViewGroup.setChecked(bool);
        paramView.setOnClickListener(new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymousView)
          {
            VdsAgent.onClick(this, paramAnonymousView);
            ZryuSdContractSelectActivity.a(ZryuSdContractSelectActivity.this, paramInt);
            ZryuSdContractSelectActivity.a(ZryuSdContractSelectActivity.this, (ValidContract)ZryuSdContractSelectActivity.a(ZryuSdContractSelectActivity.this).get(paramInt));
            ZryuSdContractSelectActivity.a.this.notifyDataSetChanged();
            paramAnonymousView = ZryuSdContractSelectActivity.d(ZryuSdContractSelectActivity.this);
            if ((ZryuSdContractSelectActivity.b(ZryuSdContractSelectActivity.this) != -1) && (ZryuSdContractSelectActivity.c(ZryuSdContractSelectActivity.this) != null)) {}
            for (boolean bool = true;; bool = false)
            {
              paramAnonymousView.setEnabled(bool);
              return;
            }
          }
        });
        return paramView;
        paramViewGroup = (a)paramView.getTag();
        break;
      }
    }
    
    class a
    {
      RadioButton a;
      TextView b;
      
      a() {}
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomapartment/activity/ZryuSdContractSelectActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */