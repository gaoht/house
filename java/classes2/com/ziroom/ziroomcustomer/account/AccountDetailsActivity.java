package com.ziroom.ziroomcustomer.account;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.LinearLayout;
import android.widget.ListView;
import com.freelxl.baselibrary.e.i.a;
import com.freelxl.baselibrary.e.k;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.commonlibrary.widget.unifiedziroom.BasicZiroomToolBar;
import com.ziroom.ziroomcustomer.account.a.b;
import com.ziroom.ziroomcustomer.account.model.AccountDetails;
import com.ziroom.ziroomcustomer.account.model.AccountDetails.DataBean;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.g;
import com.ziroom.ziroomcustomer.e.j;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AccountDetailsActivity
  extends BaseActivity
{
  BasicZiroomToolBar a;
  private ListView b;
  private b c;
  private List<AccountDetails.DataBean> d = new ArrayList();
  private LinearLayout e;
  
  private void a()
  {
    Map localMap = g.buildBalance();
    j.getAccountDetails(this, new a(), localMap, true);
  }
  
  private void b()
  {
    this.a = ((BasicZiroomToolBar)findViewById(2131689787));
    this.a.setTitle("账户明细");
    this.b = ((ListView)findViewById(2131689789));
    this.e = ((LinearLayout)findViewById(2131689788));
    this.c = new b(this, this.d);
    this.b.setAdapter(this.c);
    e();
  }
  
  private void e()
  {
    this.b.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      @Instrumented
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        VdsAgent.onItemClick(this, paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
        paramAnonymousAdapterView = (AccountDetails.DataBean)AccountDetailsActivity.a(AccountDetailsActivity.this).getItem(paramAnonymousInt);
        paramAnonymousView = new Intent(AccountDetailsActivity.this, AccountItemDetailsActivity.class);
        paramAnonymousView.putExtra("accountDetails", paramAnonymousAdapterView);
        AccountDetailsActivity.this.startActivity(paramAnonymousView);
      }
    });
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903074);
    b();
    a();
  }
  
  class a
    implements i.a<String>
  {
    a() {}
    
    public void onParse(String paramString, k paramk) {}
    
    public void onSuccess(k paramk)
    {
      if (paramk.getSuccess().booleanValue())
      {
        paramk = (AccountDetails)paramk.getObject();
        if (paramk.getData() != null)
        {
          if (paramk.getData().size() > 0)
          {
            AccountDetailsActivity.b(AccountDetailsActivity.this).addAll(paramk.getData());
            AccountDetailsActivity.a(AccountDetailsActivity.this).notifyDataSetChanged();
            return;
          }
          AccountDetailsActivity.this.showEmpty(AccountDetailsActivity.c(AccountDetailsActivity.this), "");
          return;
        }
        AccountDetailsActivity.this.showEmpty(AccountDetailsActivity.c(AccountDetailsActivity.this), "");
        return;
      }
      AccountDetailsActivity.this.showEmpty(AccountDetailsActivity.c(AccountDetailsActivity.this), "");
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/account/AccountDetailsActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */