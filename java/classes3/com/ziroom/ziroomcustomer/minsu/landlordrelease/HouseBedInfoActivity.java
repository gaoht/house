package com.ziroom.ziroomcustomer.minsu.landlordrelease;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.alibaba.fastjson.a;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.commonlibrary.widget.unifiedziroom.d;
import com.ziroom.commonlibrary.widget.unifiedziroom.d.a;
import com.ziroom.commonlibrary.widget.unifiedziroom.d.b;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.minsu.f.aa;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.b.c;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.b.c.b;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.houseprice.BedAllTypeListDataBean;
import com.ziroom.ziroomcustomer.widget.ListViewForScrollView;
import com.ziroom.ziroomcustomer.widget.ObservableScrollView;
import com.ziroom.ziroomcustomer.widget.ObservableScrollView.a;
import java.util.ArrayList;
import java.util.List;

public class HouseBedInfoActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private ImageView a;
  private TextView b;
  private ObservableScrollView c;
  private View d;
  private ListViewForScrollView e;
  private Context f;
  private ArrayList<BedAllTypeListDataBean> g;
  private int r;
  private boolean s = false;
  
  private void a()
  {
    this.f = this;
    this.a = ((ImageView)findViewById(2131689492));
    this.d = findViewById(2131689863);
    this.b = ((TextView)findViewById(2131689903));
    this.c = ((ObservableScrollView)findViewById(2131689506));
    this.e = ((ListViewForScrollView)findViewById(2131689952));
  }
  
  private void b()
  {
    this.a.setOnClickListener(this);
    this.b.setOnClickListener(this);
    this.c.setOnScrollChangedCallback(new ObservableScrollView.a()
    {
      public void onScroll(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        float f = paramAnonymousInt2 / 100.0F;
        HouseBedInfoActivity.a(HouseBedInfoActivity.this).setAlpha(f);
      }
    });
  }
  
  private void e()
  {
    this.r = ((Integer)getIntent().getExtras().get("groupClickPosition")).intValue();
    this.g = ((ArrayList)getIntent().getExtras().getSerializable("bedTypeList"));
    Object localObject = a.toJSONString(this.g);
    aa.putString(this.f, "bedTypeMsgList", (String)localObject);
    localObject = new c(this.f, new a(null), this.g);
    this.e.setAdapter((ListAdapter)localObject);
  }
  
  private void f()
  {
    List localList = a.parseArray(aa.getString(this.f, "bedTypeMsgList", ""), BedAllTypeListDataBean.class);
    if (this.g.size() != localList.size()) {
      this.s = false;
    }
    while (this.s)
    {
      d.newBuilder(this.f).setOnConfirmClickListener(new d.b()
      {
        public void onLeftClick(View paramAnonymousView) {}
        
        public void onRightClick(View paramAnonymousView)
        {
          HouseBedInfoActivity.this.finish();
        }
      }).setTitle(getResources().getString(2131297090)).setContent(getResources().getString(2131297089)).setButtonText("取消", "确定").show();
      return;
      int i = 0;
      while (i < this.g.size())
      {
        if (((BedAllTypeListDataBean)this.g.get(i)).getCount() != ((BedAllTypeListDataBean)localList.get(i)).getCount()) {
          break label153;
        }
        this.s = false;
        i += 1;
      }
      continue;
      label153:
      this.s = true;
    }
    finish();
  }
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131689492: 
      f();
      return;
    }
    paramView = new Intent(this.f, MinsuReleaseActivity.class);
    Bundle localBundle = new Bundle();
    localBundle.putSerializable("bedTypeList", this.g);
    localBundle.putInt("groupClickPosition", this.r);
    paramView.putExtras(localBundle);
    setResult(-1, paramView);
    finish();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903102);
    a();
    b();
    e();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      f();
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  private class a
    implements c.b
  {
    private a() {}
    
    public void setHouseBedChosen(ArrayList<BedAllTypeListDataBean> paramArrayList)
    {
      HouseBedInfoActivity.a(HouseBedInfoActivity.this, paramArrayList);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/landlordrelease/HouseBedInfoActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */