package com.ziroom.ziroomcustomer.ziroomapartment.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.freelxl.baselibrary.e.i.a;
import com.freelxl.baselibrary.e.k;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.util.af;
import com.ziroom.ziroomcustomer.util.u;
import com.ziroom.ziroomcustomer.ziroomapartment.a.c;
import com.ziroom.ziroomcustomer.ziroomapartment.a.e;
import com.ziroom.ziroomcustomer.ziroomapartment.adapter.ZryuFirstProjectListAdapter;
import com.ziroom.ziroomcustomer.ziroomapartment.model.ZryuFirstProjectListModel;
import com.ziroom.ziroomcustomer.ziroomapartment.model.ZryuFirstProjectListModel.DataBean;
import com.ziroom.ziroomcustomer.ziroomapartment.model.ZryuSearchConditionRecord;
import com.ziroom.ziroomcustomer.ziroomapartment.model.ZryuSearchConditionResult;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ZryuFirstProjectListActivity
  extends BaseActivity
  implements View.OnClickListener
{
  ZryuFirstProjectListAdapter a;
  ZryuFirstProjectListModel b;
  @BindView(2131690078)
  ImageView btnBack;
  boolean c = false;
  Unbinder d;
  public ZryuSearchConditionResult e;
  private String f = "ZryuFirstProjectListActivity";
  @BindView(2131692857)
  ListView lvZryuProjectListFirst;
  @BindView(2131692856)
  TextView tvProjectListFilter;
  @BindView(2131689541)
  TextView tvTitle;
  
  public void initData()
  {
    Object localObject;
    if (this.c)
    {
      this.b = new ZryuFirstProjectListModel();
      this.b.data = new ArrayList();
      int i = 0;
      while (i < 5)
      {
        localObject = new ZryuFirstProjectListModel.DataBean();
        ((ZryuFirstProjectListModel.DataBean)localObject).projAddr = ("北京市朝阳区" + i);
        ((ZryuFirstProjectListModel.DataBean)localObject).projId = ("bjcyqp" + i);
        ((ZryuFirstProjectListModel.DataBean)localObject).projName = ("自如寓" + i + "号");
        ((ZryuFirstProjectListModel.DataBean)localObject).projMinPrice = "2300";
        ((ZryuFirstProjectListModel.DataBean)localObject).projImgUrl = "http://imgsrc.baidu.com/forum/pic/item/a275666b3b092e466a60fbfe.jpg";
        this.b.data.add(localObject);
        i += 1;
      }
      this.a.setData(this.b.data);
      return;
    }
    if (checkNet(this))
    {
      localObject = c.buildFirstGetProjectList(this);
      e.getFirstProjectList(this, new a(), (Map)localObject, true);
      return;
    }
    af.showToast(this, "请检查您的网络，稍后再试！");
  }
  
  public void initView()
  {
    this.btnBack.setOnClickListener(this);
    this.tvProjectListFilter.setOnClickListener(this);
    if (this.b == null) {}
    for (this.a = new ZryuFirstProjectListAdapter(this, null);; this.a = new ZryuFirstProjectListAdapter(this, this.b.data))
    {
      this.lvZryuProjectListFirst.setAdapter(this.a);
      return;
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((-1 == paramInt2) && (43981 == paramInt1))
    {
      this.e = ((ZryuSearchConditionResult)paramIntent.getSerializableExtra("search_condition_result"));
      paramIntent = new Intent(this, ZryuProjectListActivity.class);
      paramIntent.putExtra("search_condition_result", this.e);
      startActivity(paramIntent);
      finish();
    }
  }
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131690078: 
      finish();
      return;
    }
    ZryuSearchConditionRecord.getInstance().startProjectSearchActivity(this);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903583);
    this.d = ButterKnife.bind(this);
    initView();
    initData();
  }
  
  protected void onDestroy()
  {
    this.d.unbind();
    super.onDestroy();
  }
  
  class a
    implements i.a<String>
  {
    a() {}
    
    public void onParse(String paramString, k paramk)
    {
      u.i(ZryuFirstProjectListActivity.a(ZryuFirstProjectListActivity.this), "接口返回：" + paramString);
    }
    
    public void onSuccess(k paramk)
    {
      if (paramk.getSuccess().booleanValue())
      {
        ZryuFirstProjectListActivity.this.b = ((ZryuFirstProjectListModel)paramk.getObject());
        if (200 == ZryuFirstProjectListActivity.this.b.error_code)
        {
          ZryuFirstProjectListActivity.this.a.setData(ZryuFirstProjectListActivity.this.b.data);
          return;
        }
        af.showToast(ZryuFirstProjectListActivity.this, ZryuFirstProjectListActivity.this.b.error_message);
        return;
      }
      af.showToast(ZryuFirstProjectListActivity.this, paramk.getMessage());
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomapartment/activity/ZryuFirstProjectListActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */