package com.ziroom.ziroomcustomer.ziroomapartment.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
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
import com.ziroom.ziroomcustomer.ziroomapartment.a.c;
import com.ziroom.ziroomcustomer.ziroomapartment.a.e;
import com.ziroom.ziroomcustomer.ziroomapartment.adapter.g;
import com.ziroom.ziroomcustomer.ziroomapartment.model.Price;
import com.ziroom.ziroomcustomer.ziroomapartment.model.ZryuProjectListModel;
import com.ziroom.ziroomcustomer.ziroomapartment.model.ZryuProjectListModel.DataBean;
import com.ziroom.ziroomcustomer.ziroomapartment.model.ZryuProjectListModel.DataBean.ProjectListBean;
import com.ziroom.ziroomcustomer.ziroomapartment.model.ZryuProjectListModel.DataBean.ProjectListBean.HouseTypeListBean;
import com.ziroom.ziroomcustomer.ziroomapartment.model.ZryuSearchConditionRecord;
import com.ziroom.ziroomcustomer.ziroomapartment.model.ZryuSearchConditionResult;
import com.ziroom.ziroomcustomer.ziroomapartment.widget.IndicatorListView;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ZryuProjectListActivity
  extends BaseActivity
  implements View.OnClickListener
{
  g a;
  ZryuProjectListModel b;
  @BindView(2131690078)
  ImageView btnBack;
  boolean c = false;
  boolean d = false;
  Unbinder e;
  public ZryuSearchConditionResult f;
  private String g = ZryuProjectListActivity.class.getSimpleName();
  @BindView(2131692931)
  IndicatorListView ilvZryuProjectList;
  private Price r = new Price();
  @BindView(2131692929)
  RelativeLayout rlNoSearchResult;
  @BindView(2131692930)
  TextView tvNoSearchResultTip;
  @BindView(2131692856)
  TextView tvProjectListFilter;
  @BindView(2131689541)
  TextView tvTitle;
  
  private void a()
  {
    this.a.setData(null);
    this.ilvZryuProjectList.notifyDataSetChanged();
    if (checkNet(this))
    {
      Map localMap = c.buildGetProjectList(this, this.f);
      e.getProjectList(this, new a(), localMap, true);
      return;
    }
    af.showToast(this, "请检查您的网络，稍后再试！");
  }
  
  public void initData()
  {
    if (this.d)
    {
      this.b = new ZryuProjectListModel();
      this.b.data = new ZryuProjectListModel.DataBean();
      this.b.data.htAcc = 12;
      this.b.data.projectAcc = 13;
      this.b.data.projectList = new ArrayList();
      int i = 0;
      while (i < 5)
      {
        ZryuProjectListModel.DataBean.ProjectListBean localProjectListBean = new ZryuProjectListModel.DataBean.ProjectListBean();
        localProjectListBean.projectAddr = ("北京市朝阳区" + i);
        localProjectListBean.projectId = ("bjcyqp" + i);
        localProjectListBean.projectName = ("自如寓" + i + "号");
        localProjectListBean.projectMinPrice = "2300";
        localProjectListBean.projectImgUrl = "http://imgsrc.baidu.com/forum/pic/item/a275666b3b092e466a60fbfe.jpg";
        localProjectListBean.houseTypeList = new ArrayList();
        int j = 0;
        while (j < 8)
        {
          ZryuProjectListModel.DataBean.ProjectListBean.HouseTypeListBean localHouseTypeListBean = new ZryuProjectListModel.DataBean.ProjectListBean.HouseTypeListBean();
          localHouseTypeListBean.htArea = (i * 10 + 300 + j + "");
          localHouseTypeListBean.htAvaRoomAcc = (i * 100 + 10000 + j);
          localHouseTypeListBean.htId = "bjzryutype";
          localHouseTypeListBean.htImgUrl = "http://img.taopic.com/uploads/allimg/140328/235043-14032Q1063876.jpg";
          localHouseTypeListBean.htMaxPrice = (i * 10 + 8000 + j + "");
          localHouseTypeListBean.htMinPrice = (i * 10 + 4000 + j + "");
          localHouseTypeListBean.htName = (i + "项目" + j + "房型");
          localProjectListBean.houseTypeList.add(localHouseTypeListBean);
          j += 1;
        }
        this.b.data.projectList.add(localProjectListBean);
        i += 1;
      }
      this.a.setData(this.b.data.projectList);
      this.ilvZryuProjectList.notifyDataSetChanged();
      return;
    }
    this.f = ((ZryuSearchConditionResult)getIntent().getSerializableExtra("search_condition_result"));
    a();
  }
  
  public void initView()
  {
    this.btnBack.setOnClickListener(this);
    this.tvProjectListFilter.setOnClickListener(this);
    if (this.b != null)
    {
      this.a = new g(this, this.b.data.projectList);
      this.ilvZryuProjectList.setAdapter(this.a);
      if (!this.c) {
        break label104;
      }
      this.ilvZryuProjectList.setShowType(1);
    }
    for (;;)
    {
      this.btnBack.setOnClickListener(this);
      this.tvTitle.setOnClickListener(this);
      return;
      this.a = new g(this, null);
      break;
      label104:
      this.ilvZryuProjectList.setShowType(3);
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((-1 == paramInt2) && (43981 == paramInt1))
    {
      this.f = ((ZryuSearchConditionResult)paramIntent.getSerializableExtra("search_condition_result"));
      a();
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
    setContentView(2130903594);
    this.e = ButterKnife.bind(this);
    initView();
    initData();
  }
  
  protected void onDestroy()
  {
    this.e.unbind();
    super.onDestroy();
  }
  
  @Instrumented
  protected void onNewIntent(Intent paramIntent)
  {
    VdsAgent.onNewIntent(this, paramIntent);
    super.onNewIntent(paramIntent);
    this.f = ((ZryuSearchConditionResult)paramIntent.getSerializableExtra("search_condition_result"));
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
        ZryuProjectListActivity.this.b = ((ZryuProjectListModel)paramk.getObject());
        if (200 == ZryuProjectListActivity.this.b.error_code)
        {
          if ("0".equals(ZryuProjectListActivity.this.b.data.ifSearchSuc))
          {
            ZryuProjectListActivity.this.rlNoSearchResult.setVisibility(0);
            ZryuProjectListActivity.this.tvNoSearchResultTip.setText(ZryuProjectListActivity.this.b.data.searchFailMsg);
          }
          for (;;)
          {
            ZryuProjectListActivity.this.a.setData(ZryuProjectListActivity.this.b.data.projectList);
            ZryuProjectListActivity.this.ilvZryuProjectList.notifyDataSetChanged();
            return;
            ZryuProjectListActivity.this.rlNoSearchResult.setVisibility(8);
          }
        }
        af.showToast(ZryuProjectListActivity.this, ZryuProjectListActivity.this.b.error_message);
        return;
      }
      af.showToast(ZryuProjectListActivity.this, paramk.getMessage());
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomapartment/activity/ZryuProjectListActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */