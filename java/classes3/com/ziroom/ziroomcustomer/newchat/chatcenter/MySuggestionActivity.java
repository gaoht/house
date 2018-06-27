package com.ziroom.ziroomcustomer.newchat.chatcenter;

import android.content.Context;
import android.os.Bundle;
import com.freelxl.baselibrary.d.f.a;
import com.ziroom.commonlibrary.widget.unifiedziroom.BasicZiroomToolBar;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.a.h;
import com.ziroom.ziroomcustomer.e.c.u;
import com.ziroom.ziroomcustomer.e.n;
import com.ziroom.ziroomcustomer.model.UserInfo;
import com.ziroom.ziroomcustomer.util.af;
import com.ziroom.ziroomcustomer.widget.XListView;
import com.ziroom.ziroomcustomer.widget.XListView.a;
import java.util.ArrayList;
import java.util.List;

public class MySuggestionActivity
  extends BaseActivity
  implements XListView.a
{
  BasicZiroomToolBar a;
  private Context b;
  private XListView c;
  private List<l> d = new ArrayList();
  private e e;
  private UserInfo f;
  
  private void a()
  {
    this.f = ApplicationEx.c.getUser();
    if (this.f != null) {
      n.getMyComplainList(this, this.f.getUid(), new h(this, new u(l.class))
      {
        public void onFailure(Throwable paramAnonymousThrowable)
        {
          super.onFailure(paramAnonymousThrowable);
        }
        
        public void onSuccess(int paramAnonymousInt, List<l> paramAnonymousList)
        {
          super.onSuccess(paramAnonymousInt, paramAnonymousList);
          if (paramAnonymousList != null) {
            MySuggestionActivity.a(MySuggestionActivity.this, paramAnonymousList);
          }
          for (;;)
          {
            if ((paramAnonymousList == null) || (paramAnonymousList.size() == 0)) {
              af.showToast(MySuggestionActivity.b(MySuggestionActivity.this), "您还没有投诉单");
            }
            MySuggestionActivity.a(MySuggestionActivity.this, new e(MySuggestionActivity.this, MySuggestionActivity.a(MySuggestionActivity.this)));
            MySuggestionActivity.d(MySuggestionActivity.this).setAdapter(MySuggestionActivity.c(MySuggestionActivity.this));
            MySuggestionActivity.d(MySuggestionActivity.this).stopRefresh();
            MySuggestionActivity.d(MySuggestionActivity.this).setRefreshTime("刚刚");
            return;
            MySuggestionActivity.a(MySuggestionActivity.this).clear();
          }
        }
      });
    }
  }
  
  private void b()
  {
    this.c = ((XListView)findViewById(2131690167));
    this.a = ((BasicZiroomToolBar)findViewById(2131689787));
    this.a.setTitle("我的投诉");
    this.c.setPullLoadEnable(false);
    this.c.setPullRefreshEnable(true);
    this.c.setXListViewListener(this);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903246);
    this.b = this;
    b();
    a();
  }
  
  public void onLoadMore() {}
  
  public void onRefresh()
  {
    a();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newchat/chatcenter/MySuggestionActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */