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
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.commonlibrary.widget.unifiedziroom.d;
import com.ziroom.commonlibrary.widget.unifiedziroom.d.a;
import com.ziroom.commonlibrary.widget.unifiedziroom.d.b;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.minsu.f.aa;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.b.a.b;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.AloneRoomBedTypeListDataBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.aloneroominfo.AloneRoomBedTypeListBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.aloneroominfo.AloneRoomBedTypeMsgListBean;
import com.ziroom.ziroomcustomer.widget.ListViewForScrollView;
import com.ziroom.ziroomcustomer.widget.ObservableScrollView;
import com.ziroom.ziroomcustomer.widget.ObservableScrollView.a;
import java.io.Serializable;
import java.util.List;

public class RoomBedInfoActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private ImageView a;
  private TextView b;
  private View c;
  private ObservableScrollView d;
  private ListViewForScrollView e;
  private Context f;
  private List<AloneRoomBedTypeListDataBean> g;
  private List<AloneRoomBedTypeMsgListBean> r;
  private boolean s = false;
  
  private void a()
  {
    this.f = this;
    this.a = ((ImageView)findViewById(2131689492));
    this.c = findViewById(2131689863);
    this.b = ((TextView)findViewById(2131689903));
    this.d = ((ObservableScrollView)findViewById(2131689506));
    this.e = ((ListViewForScrollView)findViewById(2131689952));
  }
  
  private void b()
  {
    this.a.setOnClickListener(this);
    this.b.setOnClickListener(this);
    this.d.setOnScrollChangedCallback(new ObservableScrollView.a()
    {
      public void onScroll(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        float f = paramAnonymousInt2 / 100.0F;
        RoomBedInfoActivity.a(RoomBedInfoActivity.this).setAlpha(f);
      }
    });
  }
  
  private void e()
  {
    int i = getIntent().getExtras().getInt("maxBedNumLimit", -1);
    this.r = ((List)getIntent().getExtras().getSerializable("bedTypeMsgList"));
    Object localObject = com.alibaba.fastjson.a.toJSONString(this.r);
    aa.putString(this.f, "bedTypeMsgList", (String)localObject);
    localObject = (AloneRoomBedTypeListBean)getIntent().getExtras().getSerializable("bedTypeList");
    if (localObject == null) {
      return;
    }
    this.g = ((AloneRoomBedTypeListBean)localObject).getList();
    localObject = new com.ziroom.ziroomcustomer.minsu.landlordrelease.b.a(this.f, this.g, this.r, i, new a(null));
    this.e.setAdapter((ListAdapter)localObject);
  }
  
  private void f()
  {
    List localList = com.alibaba.fastjson.a.parseArray(aa.getString(this.f, "bedTypeMsgList", ""), AloneRoomBedTypeMsgListBean.class);
    if (this.r.size() != localList.size()) {
      this.s = false;
    }
    while (this.s)
    {
      d.newBuilder(this.f).setOnConfirmClickListener(new d.b()
      {
        public void onLeftClick(View paramAnonymousView) {}
        
        public void onRightClick(View paramAnonymousView)
        {
          RoomBedInfoActivity.this.finish();
        }
      }).setTitle(getResources().getString(2131297090)).setContent(getResources().getString(2131297089)).setButtonText("取消", "确定").show();
      return;
      int i = 0;
      while (i < this.r.size())
      {
        if (((AloneRoomBedTypeMsgListBean)this.r.get(i)).getNum() != ((AloneRoomBedTypeMsgListBean)localList.get(i)).getNum()) {
          break label159;
        }
        this.s = false;
        i += 1;
      }
      continue;
      label159:
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
    paramView = new Intent(this.f, AloneRoomInfoActivity.class);
    Bundle localBundle = new Bundle();
    localBundle.putSerializable("bedTypeMsgList", (Serializable)this.r);
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
    implements a.b
  {
    private a() {}
    
    public void setRoomBedChosen(List<AloneRoomBedTypeMsgListBean> paramList)
    {
      RoomBedInfoActivity.a(RoomBedInfoActivity.this, paramList);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/landlordrelease/RoomBedInfoActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */