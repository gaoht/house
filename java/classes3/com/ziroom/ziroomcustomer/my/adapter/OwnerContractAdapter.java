package com.ziroom.ziroomcustomer.my.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.commonlibrary.login.a;
import com.ziroom.commonlibrary.login.a.c;
import com.ziroom.ziroomcustomer.my.OwnerContractConfirmActivity;
import com.ziroom.ziroomcustomer.my.OwnerContrastListActivity;
import com.ziroom.ziroomcustomer.my.OwnerZoneActivity;
import com.ziroom.ziroomcustomer.my.model.OwnerMyUnSignedEntity;
import com.ziroom.ziroomcustomer.util.ae;
import java.util.List;

public class OwnerContractAdapter
  extends BaseAdapter
{
  private Context a;
  private List<OwnerMyUnSignedEntity> b;
  private viewHolder c;
  
  public OwnerContractAdapter(Context paramContext, List<OwnerMyUnSignedEntity> paramList)
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
    final OwnerMyUnSignedEntity localOwnerMyUnSignedEntity;
    if (paramView == null)
    {
      paramView = View.inflate(this.a, 2130904412, null);
      this.c = new viewHolder(paramView);
      paramView.setTag(this.c);
      localOwnerMyUnSignedEntity = (OwnerMyUnSignedEntity)this.b.get(paramInt);
      if (!ae.notNull(localOwnerMyUnSignedEntity.getType_text())) {
        break label253;
      }
      paramViewGroup = localOwnerMyUnSignedEntity.getType_text() + "·";
      label86:
      if (!ae.notNull(localOwnerMyUnSignedEntity.getAddress())) {
        break label259;
      }
      this.c.owner_contract_address.setText(paramViewGroup + localOwnerMyUnSignedEntity.getAddress());
      label129:
      if (!ae.notNull(localOwnerMyUnSignedEntity.getStart_date())) {
        break label274;
      }
      this.c.owner_contract_start_time.setText("起租日期：" + localOwnerMyUnSignedEntity.getStart_date());
      label173:
      if (!ae.notNull(localOwnerMyUnSignedEntity.getEnd_date())) {
        break label289;
      }
      this.c.owner_contract_end_time.setText("合同截止日期：" + localOwnerMyUnSignedEntity.getEnd_date());
    }
    for (;;)
    {
      this.c.owner_contract_btn.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          if (!ae.isNull(localOwnerMyUnSignedEntity.getApplink()))
          {
            paramAnonymousView = localOwnerMyUnSignedEntity.getApplink();
            i = -1;
            switch (paramAnonymousView.hashCode())
            {
            default: 
              switch (i)
              {
              }
              break;
            }
          }
          while ((!"1".equals(localOwnerMyUnSignedEntity.getLink_type())) || (!(OwnerContractAdapter.a(OwnerContractAdapter.this) instanceof OwnerZoneActivity)))
          {
            for (;;)
            {
              int i;
              return;
              if (paramAnonymousView.equals("yzSureContract"))
              {
                i = 0;
                continue;
                if (paramAnonymousView.equals("yzContract")) {
                  i = 1;
                }
              }
            }
            a.verifyToken(OwnerContractAdapter.a(OwnerContractAdapter.this), new a.c()
            {
              public void onVerifyFinish(boolean paramAnonymous2Boolean)
              {
                if (paramAnonymous2Boolean)
                {
                  Intent localIntent = new Intent(OwnerContractAdapter.a(OwnerContractAdapter.this), OwnerContractConfirmActivity.class);
                  localIntent.putExtra("contractCode", OwnerContractAdapter.1.this.a.getCode());
                  OwnerContractAdapter.a(OwnerContractAdapter.this).startActivity(localIntent);
                  return;
                }
                a.startLoginActivity(OwnerContractAdapter.a(OwnerContractAdapter.this));
              }
            });
            return;
            a.verifyToken(OwnerContractAdapter.a(OwnerContractAdapter.this), new a.c()
            {
              public void onVerifyFinish(boolean paramAnonymous2Boolean)
              {
                if (paramAnonymous2Boolean)
                {
                  Intent localIntent = new Intent(OwnerContractAdapter.a(OwnerContractAdapter.this), OwnerContrastListActivity.class);
                  OwnerContractAdapter.a(OwnerContractAdapter.this).startActivity(localIntent);
                  return;
                }
                a.startLoginActivity(OwnerContractAdapter.a(OwnerContractAdapter.this));
              }
            });
            return;
          }
          ((OwnerZoneActivity)OwnerContractAdapter.a(OwnerContractAdapter.this)).toH5Page(localOwnerMyUnSignedEntity.getLink(), "确认合同");
        }
      });
      return paramView;
      this.c = ((viewHolder)paramView.getTag());
      break;
      label253:
      paramViewGroup = "";
      break label86;
      label259:
      this.c.owner_contract_address.setText("");
      break label129;
      label274:
      this.c.owner_contract_start_time.setText("");
      break label173;
      label289:
      this.c.owner_contract_end_time.setText("");
    }
  }
  
  class viewHolder
  {
    @BindView(2131695476)
    TextView owner_contract_address;
    @BindView(2131695479)
    TextView owner_contract_btn;
    @BindView(2131695478)
    TextView owner_contract_end_time;
    @BindView(2131695477)
    TextView owner_contract_start_time;
    
    viewHolder(View paramView)
    {
      ButterKnife.bind(this, paramView);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/my/adapter/OwnerContractAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */