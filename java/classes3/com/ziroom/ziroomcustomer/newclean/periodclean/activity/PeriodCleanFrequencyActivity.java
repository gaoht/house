package com.ziroom.ziroomcustomer.newclean.periodclean.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.a.d;
import com.ziroom.ziroomcustomer.e.c.e;
import com.ziroom.ziroomcustomer.newclean.periodclean.a.a.a;
import com.ziroom.ziroomcustomer.newclean.periodclean.bean.FrequencyBean;
import java.util.List;

public class PeriodCleanFrequencyActivity
  extends BaseActivity
{
  private com.ziroom.ziroomcustomer.newclean.periodclean.a.a a;
  private FrequencyBean b;
  @BindView(2131689492)
  ImageView bankcardBack;
  @BindView(2131691217)
  ListView list;
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903426);
    ButterKnife.bind(this);
    this.b = ((FrequencyBean)getIntent().getSerializableExtra("period"));
    this.a = new com.ziroom.ziroomcustomer.newclean.periodclean.a.a(this, null);
    this.list.setAdapter(this.a);
    this.a.setmFrequencyType(new a.a()
    {
      public void setPayType(FrequencyBean paramAnonymousFrequencyBean)
      {
        Intent localIntent = new Intent();
        localIntent.putExtra("frequency", paramAnonymousFrequencyBean);
        PeriodCleanFrequencyActivity.this.setResult(16, localIntent);
        PeriodCleanFrequencyActivity.this.finish();
      }
    });
    com.ziroom.ziroomcustomer.newclean.periodclean.a.getFrequencyConfigs(this, new d(this, new e(FrequencyBean.class))
    {
      public void onSuccess(int paramAnonymousInt, List<FrequencyBean> paramAnonymousList)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousList);
        if (PeriodCleanFrequencyActivity.a(PeriodCleanFrequencyActivity.this) != null) {
          paramAnonymousInt = 0;
        }
        for (;;)
        {
          if (paramAnonymousInt < paramAnonymousList.size())
          {
            if (((FrequencyBean)paramAnonymousList.get(paramAnonymousInt)).getCycleIndex() == PeriodCleanFrequencyActivity.a(PeriodCleanFrequencyActivity.this).getCycleIndex()) {
              PeriodCleanFrequencyActivity.b(PeriodCleanFrequencyActivity.this).a = paramAnonymousInt;
            }
          }
          else
          {
            PeriodCleanFrequencyActivity.b(PeriodCleanFrequencyActivity.this).setmList(paramAnonymousList);
            return;
          }
          paramAnonymousInt += 1;
        }
      }
    });
  }
  
  @OnClick({2131689492})
  public void onViewClicked()
  {
    finish();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newclean/periodclean/activity/PeriodCleanFrequencyActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */