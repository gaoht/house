package com.ziroom.ziroomcustomer.minsu.landlordrelease;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnGroupClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.alibaba.fastjson.a;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.commonlibrary.widget.unifiedziroom.d;
import com.ziroom.commonlibrary.widget.unifiedziroom.d.a;
import com.ziroom.commonlibrary.widget.unifiedziroom.d.b;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.minsu.f.aa;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.b.b;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.b.b.b;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.LandlordReleaseAmenitiesBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.houseprice.FacilitiesListBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.houseprice.FacilitiesListDataBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.houseprice.HouseFacilityGroupBean;
import com.ziroom.ziroomcustomer.widget.ObservableScrollView;
import com.ziroom.ziroomcustomer.widget.ObservableScrollView.a;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class HouseAmenitiesActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private ImageView a;
  private TextView b;
  private ExpandableListView c;
  private Context d;
  private List<LandlordReleaseAmenitiesBean> e = new ArrayList();
  private TextView f;
  private ObservableScrollView g;
  private View r;
  private StringBuffer s = new StringBuffer();
  private boolean t = false;
  
  private void a()
  {
    this.d = this;
    this.a = ((ImageView)findViewById(2131689492));
    this.g = ((ObservableScrollView)findViewById(2131689506));
    this.r = findViewById(2131689863);
    this.b = ((TextView)findViewById(2131689903));
    this.f = ((TextView)findViewById(2131689904));
    this.f.setFocusable(true);
    this.f.setFocusableInTouchMode(true);
    this.f.requestFocus();
    this.c = ((ExpandableListView)findViewById(2131689905));
  }
  
  private void b()
  {
    this.a.setOnClickListener(this);
    this.b.setOnClickListener(this);
    this.g.setOnScrollChangedCallback(new ObservableScrollView.a()
    {
      public void onScroll(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        float f = paramAnonymousInt2 / 100.0F;
        HouseAmenitiesActivity.a(HouseAmenitiesActivity.this).setAlpha(f);
      }
    });
  }
  
  private void e()
  {
    int j = 0;
    Object localObject = (List)getIntent().getExtras().getSerializable("amenitiesData");
    if (localObject != null)
    {
      i = 0;
      while (i < ((List)localObject).size())
      {
        String str = ((HouseFacilityGroupBean)((List)localObject).get(i)).getName();
        LandlordReleaseAmenitiesBean localLandlordReleaseAmenitiesBean = new LandlordReleaseAmenitiesBean();
        localLandlordReleaseAmenitiesBean.setGroupTitle(str);
        localLandlordReleaseAmenitiesBean.setChildList(((HouseFacilityGroupBean)((List)localObject).get(i)).getFacilitiesList().getList());
        this.e.add(localLandlordReleaseAmenitiesBean);
        i += 1;
      }
      localObject = a.toJSONString(this.e);
      aa.putString(this.d, "groupString", (String)localObject);
    }
    this.c.setGroupIndicator(null);
    localObject = new b(this.d, this.e, new a(null));
    this.c.setAdapter((ExpandableListAdapter)localObject);
    int k = this.c.getCount();
    int i = j;
    while (i < k)
    {
      this.c.expandGroup(i);
      i += 1;
    }
    this.c.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener()
    {
      @Instrumented
      public boolean onGroupClick(ExpandableListView paramAnonymousExpandableListView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        VdsAgent.onGroupClick(this, paramAnonymousExpandableListView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
        VdsAgent.handleClickResult(new Boolean(true));
        return true;
      }
    });
  }
  
  private void f()
  {
    List localList1 = a.parseArray(aa.getString(this.d, "groupString", ""), LandlordReleaseAmenitiesBean.class);
    if (this.e.size() != localList1.size()) {
      this.t = false;
    }
    label217:
    while (this.t)
    {
      d.newBuilder(this.d).setOnConfirmClickListener(new d.b()
      {
        public void onLeftClick(View paramAnonymousView) {}
        
        public void onRightClick(View paramAnonymousView)
        {
          HouseAmenitiesActivity.this.finish();
        }
      }).setTitle(getResources().getString(2131297090)).setContent(getResources().getString(2131297089)).setButtonText("取消", "确定").show();
      return;
      int i = 0;
      for (;;)
      {
        if (i >= this.e.size()) {
          break label217;
        }
        List localList2 = ((LandlordReleaseAmenitiesBean)this.e.get(i)).getChildList();
        List localList3 = ((LandlordReleaseAmenitiesBean)localList1.get(i)).getChildList();
        int j = 0;
        for (;;)
        {
          if (j < localList2.size()) {
            if (((FacilitiesListDataBean)localList2.get(j)).isSelect() == ((FacilitiesListDataBean)localList3.get(j)).isSelect())
            {
              this.t = false;
              j += 1;
            }
            else
            {
              this.t = true;
              break;
            }
          }
        }
        i += 1;
      }
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
    Object localObject = new StringBuilder();
    int i = 0;
    while (i < this.e.size())
    {
      paramView = ((LandlordReleaseAmenitiesBean)this.e.get(i)).getChildList();
      int j = 0;
      while (j < paramView.size())
      {
        if (((FacilitiesListDataBean)paramView.get(j)).isSelect())
        {
          this.s.append(((FacilitiesListDataBean)paramView.get(j)).getText() + "、");
          ((StringBuilder)localObject).append(((FacilitiesListDataBean)paramView.get(j)).getValue() + ",");
        }
        j += 1;
      }
      i += 1;
    }
    if ((this.s.length() >= 1) && (((StringBuilder)localObject).length() >= 1))
    {
      this.s.deleteCharAt(this.s.length() - 1);
      ((StringBuilder)localObject).deleteCharAt(((StringBuilder)localObject).length() - 1);
      paramView = this.s.toString();
      localObject = ((StringBuilder)localObject).toString();
      Intent localIntent = new Intent(this.d, MinsuReleaseActivity.class);
      Bundle localBundle = new Bundle();
      localIntent.putExtra("chosenAmentiesStr", paramView);
      localIntent.putExtra("houseFacility", (String)localObject);
      localBundle.putSerializable("groupList", (Serializable)this.e);
      localIntent.putExtras(localBundle);
      setResult(-1, localIntent);
      finish();
      return;
    }
    showToast("请选择客户可以使用的便利设施");
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903092);
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
    implements b.b
  {
    private a() {}
    
    public void setAmenitiesChosen(List<LandlordReleaseAmenitiesBean> paramList)
    {
      HouseAmenitiesActivity.a(HouseAmenitiesActivity.this, paramList);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/landlordrelease/HouseAmenitiesActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */