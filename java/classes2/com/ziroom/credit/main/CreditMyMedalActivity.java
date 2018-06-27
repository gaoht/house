package com.ziroom.credit.main;

import android.content.Context;
import android.widget.ListView;
import com.ziroom.credit.R.id;
import com.ziroom.credit.R.layout;
import com.ziroom.credit.a.a;
import com.ziroom.credit.base.CreditBaseActivity;
import com.ziroom.datacenter.remote.responsebody.financial.b.f;
import java.util.LinkedList;
import java.util.List;

public class CreditMyMedalActivity
  extends CreditBaseActivity
  implements k.b
{
  private ListView d;
  private a e;
  private List<f> f = new LinkedList();
  
  protected int c()
  {
    return R.layout.credit_activity_mymedal1;
  }
  
  protected void d()
  {
    setTitleText("我的勋章");
    this.d = ((ListView)findViewById(R.id.credit_grid));
    this.e = new a(this);
    this.d.setAdapter(this.e);
  }
  
  protected k.a e()
  {
    return new l(this);
  }
  
  public void getMedalList(List<f> paramList)
  {
    this.f = paramList;
    this.e.setData(this.f);
  }
  
  public Context getViewContext()
  {
    return this;
  }
  
  protected void initData() {}
  
  public boolean isActive()
  {
    return !isFinishing();
  }
  
  public void setPresenter(k.a parama) {}
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/credit/main/CreditMyMedalActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */