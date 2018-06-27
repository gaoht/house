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
import com.ziroom.ziroomcustomer.minsu.landlordrelease.b.i;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.b.i.a;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.roombasic.FacilitiesChildDataBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.roombasic.LLReleaseRoomAmenitiesBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.roombasic.RoomFacilityGroupBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.roombasic.RoomFacilityGroupBean.FacilitiesBean;
import com.ziroom.ziroomcustomer.widget.ObservableScrollView;
import com.ziroom.ziroomcustomer.widget.ObservableScrollView.a;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class RoomAmenitiesActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private ImageView a;
  private View b;
  private ObservableScrollView c;
  private TextView d;
  private ExpandableListView e;
  private Context f;
  private List<RoomFacilityGroupBean> g;
  private List<LLReleaseRoomAmenitiesBean> r = new ArrayList();
  private TextView s;
  private StringBuffer t = new StringBuffer();
  private StringBuffer u = new StringBuffer();
  private int v = 777;
  private boolean w = false;
  
  private void a()
  {
    this.f = this;
    this.a = ((ImageView)findViewById(2131689492));
    this.b = findViewById(2131689863);
    this.c = ((ObservableScrollView)findViewById(2131689506));
    this.d = ((TextView)findViewById(2131689903));
    this.s = ((TextView)findViewById(2131689904));
    this.s.setFocusable(true);
    this.s.setFocusableInTouchMode(true);
    this.s.requestFocus();
    this.e = ((ExpandableListView)findViewById(2131689905));
  }
  
  private void b()
  {
    this.a.setOnClickListener(this);
    this.d.setOnClickListener(this);
    this.c.setOnScrollChangedCallback(new ObservableScrollView.a()
    {
      public void onScroll(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        float f = paramAnonymousInt2 / 100.0F;
        RoomAmenitiesActivity.a(RoomAmenitiesActivity.this).setAlpha(f);
      }
    });
  }
  
  private void e()
  {
    int j = 0;
    this.g = ((List)getIntent().getExtras().getSerializable("amenitiesData"));
    if (this.g != null)
    {
      i = 0;
      while (i < this.g.size())
      {
        localObject = ((RoomFacilityGroupBean)this.g.get(i)).getName();
        LLReleaseRoomAmenitiesBean localLLReleaseRoomAmenitiesBean = new LLReleaseRoomAmenitiesBean();
        localLLReleaseRoomAmenitiesBean.setGroupTitle((String)localObject);
        localLLReleaseRoomAmenitiesBean.setChildList(((RoomFacilityGroupBean)this.g.get(i)).getFacilitiesList().getList());
        this.r.add(localLLReleaseRoomAmenitiesBean);
        i += 1;
      }
      localObject = a.toJSONString(this.r);
      aa.putString(this.f, "groupString", (String)localObject);
    }
    this.e.setGroupIndicator(null);
    Object localObject = new i(this.f, this.r, new a(null));
    this.e.setAdapter((ExpandableListAdapter)localObject);
    int k = this.e.getCount();
    int i = j;
    while (i < k)
    {
      this.e.expandGroup(i);
      i += 1;
    }
    this.e.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener()
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
    List localList1 = a.parseArray(aa.getString(this.f, "groupString", ""), LLReleaseRoomAmenitiesBean.class);
    if (this.r != null)
    {
      if ((localList1 == null) || (this.r.size() == localList1.size())) {
        break label114;
      }
      this.w = false;
    }
    label114:
    label231:
    while (this.w)
    {
      d.newBuilder(this.f).setOnConfirmClickListener(new d.b()
      {
        public void onLeftClick(View paramAnonymousView) {}
        
        public void onRightClick(View paramAnonymousView)
        {
          RoomAmenitiesActivity.this.finish();
        }
      }).setTitle(getResources().getString(2131297090)).setContent(getResources().getString(2131297089)).setButtonText("取消", "确定").show();
      return;
      int i = 0;
      for (;;)
      {
        if (i >= this.r.size()) {
          break label231;
        }
        List localList2 = ((LLReleaseRoomAmenitiesBean)this.r.get(i)).getChildList();
        List localList3 = ((LLReleaseRoomAmenitiesBean)localList1.get(i)).getChildList();
        int j = 0;
        for (;;)
        {
          if (j < localList2.size()) {
            if (((FacilitiesChildDataBean)localList2.get(j)).isSelect() == ((FacilitiesChildDataBean)localList3.get(j)).isSelect())
            {
              this.w = false;
              j += 1;
            }
            else
            {
              this.w = true;
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
    int i = 0;
    while (i < this.r.size())
    {
      paramView = ((LLReleaseRoomAmenitiesBean)this.r.get(i)).getChildList();
      int j = 0;
      while (j < paramView.size())
      {
        if (((FacilitiesChildDataBean)paramView.get(j)).isSelect())
        {
          this.t.append(((FacilitiesChildDataBean)paramView.get(j)).getText() + "、");
          this.u.append(((FacilitiesChildDataBean)paramView.get(j)).getValue() + ",");
        }
        j += 1;
      }
      i += 1;
    }
    if ((this.t.length() >= 1) && (this.u.length() >= 1))
    {
      this.t.deleteCharAt(this.t.length() - 1);
      this.u.deleteCharAt(this.u.length() - 1);
      paramView = this.t.toString();
      String str = this.u.toString();
      Intent localIntent = new Intent(this.f, MinsuReleaseActivity.class);
      Bundle localBundle = new Bundle();
      localBundle.putString("chosenAmentiesStr", paramView);
      localBundle.putString("chosenAmentiesValue", str);
      localBundle.putSerializable("groupList", (Serializable)this.r);
      localIntent.putExtras(localBundle);
      setResult(this.v, localIntent);
      finish();
      return;
    }
    showToast("请选择便利设施");
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
    implements i.a
  {
    private a() {}
    
    public void setAmenitiesChosen(List<LLReleaseRoomAmenitiesBean> paramList)
    {
      RoomAmenitiesActivity.a(RoomAmenitiesActivity.this, paramList);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/landlordrelease/RoomAmenitiesActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */