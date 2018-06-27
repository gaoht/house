package com.ziroom.ziroomcustomer.my;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.alibaba.fastjson.e;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.f.c;
import com.ziroom.commonlibrary.widget.unifiedziroom.BasicZiroomToolBar;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.a.f;
import com.ziroom.ziroomcustomer.e.c.o;
import com.ziroom.ziroomcustomer.e.e.p;
import com.ziroom.ziroomcustomer.e.g;
import com.ziroom.ziroomcustomer.e.j;
import com.ziroom.ziroomcustomer.e.q;
import com.ziroom.ziroomcustomer.my.model.MyEvaIsRentAvaiModel;
import com.ziroom.ziroomcustomer.my.model.MyEvaIsRentAvaiModel.EvaluateInfoBean;
import com.ziroom.ziroomcustomer.my.model.MyEvaIsRentAvaiModel.EvaluateInfoBean.ResultBean;
import com.ziroom.ziroomcustomer.my.model.MySteweardInfoEntity;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.util.af;
import com.ziroom.ziroomcustomer.util.ah;
import com.ziroom.ziroomcustomer.util.u;
import com.ziroom.ziroomcustomer.widget.StarBar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyStewardInfoActivity
  extends BaseActivity
{
  private Context a;
  private String b = MyStewardInfoActivity.class.getSimpleName();
  @BindView(2131696998)
  TextView btn_to_evaluate;
  private Unbinder c;
  private String d;
  private MySteweardInfoEntity e;
  private String f = "";
  private String g = "";
  @BindView(2131689787)
  BasicZiroomToolBar mBztb;
  @BindView(2131696997)
  TextView my_steward_btn;
  @BindView(2131696990)
  SimpleDraweeView my_steward_img;
  @BindView(2131696996)
  TextView my_steward_introduction;
  @BindView(2131696991)
  TextView my_steward_name;
  @BindView(2131696995)
  TextView my_steward_phone;
  @BindView(2131696992)
  StarBar my_steward_rb;
  @BindView(2131696993)
  TextView my_steward_score;
  private String r = "";
  private MyEvaIsRentAvaiModel s;
  private String t = "fwgj";
  private String u = "ziroomer";
  private String v = "cfzq";
  private String w = "app";
  private int x = 2;
  
  private void a()
  {
    this.d = getIntent().getStringExtra("contractCode");
    com.freelxl.baselibrary.d.a.isLog(true);
    HashMap localHashMap = new HashMap();
    localHashMap.put("token", com.ziroom.commonlibrary.login.a.getToken(this.a));
    localHashMap.put("contractCode", this.d);
    com.freelxl.baselibrary.d.a.get(q.R + e.p.b).tag(this).params(g.getCommonHouseSign(localHashMap)).enqueue(new f(this, new o())
    {
      public void onSuccess(int paramAnonymousInt, e paramAnonymouse)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymouse);
        u.d("OKHttp", "===" + paramAnonymouse.toString());
        MyStewardInfoActivity.a(MyStewardInfoActivity.this, (MySteweardInfoEntity)com.alibaba.fastjson.a.parseObject(paramAnonymouse.toString(), MySteweardInfoEntity.class));
        if (MyStewardInfoActivity.a(MyStewardInfoActivity.this) != null)
        {
          MyStewardInfoActivity.b(MyStewardInfoActivity.this, MyStewardInfoActivity.a(MyStewardInfoActivity.this));
          MyStewardInfoActivity.a(MyStewardInfoActivity.this, com.ziroom.commonlibrary.login.a.getUid(MyStewardInfoActivity.this));
          MyStewardInfoActivity.b(MyStewardInfoActivity.this, MyStewardInfoActivity.a(MyStewardInfoActivity.this).getEmpCode());
          MyStewardInfoActivity.c(MyStewardInfoActivity.this, MyStewardInfoActivity.b(MyStewardInfoActivity.this));
          MyStewardInfoActivity.c(MyStewardInfoActivity.this);
          return;
        }
        MyStewardInfoActivity.this.showToast("");
      }
    });
  }
  
  private void a(MySteweardInfoEntity paramMySteweardInfoEntity)
  {
    if (paramMySteweardInfoEntity == null) {
      return;
    }
    this.my_steward_rb.setStarMark(Float.parseFloat(paramMySteweardInfoEntity.getStar()));
    this.my_steward_name.setText(paramMySteweardInfoEntity.getEmpName());
    this.my_steward_img.setController(c.frescoController(paramMySteweardInfoEntity.getPic()));
    this.my_steward_score.setText(paramMySteweardInfoEntity.getStar() + "分 好评率" + paramMySteweardInfoEntity.getPraise());
    this.my_steward_phone.setText(paramMySteweardInfoEntity.getPhoneMobile());
    this.my_steward_introduction.setText(paramMySteweardInfoEntity.getHouse_evaluation_introduction());
  }
  
  private void b()
  {
    if (checkNet(this))
    {
      j.getRentZOEvaluateStatus(this, g.buildRentZOEvaluateAvailable(this.x, this.f, this.u, this.r, this.t, this.v, this.g, this.w), new f(this, new com.ziroom.ziroomcustomer.e.c.b())
      {
        public void onSuccess(int paramAnonymousInt, e paramAnonymouse)
        {
          super.onSuccess(paramAnonymousInt, paramAnonymouse);
          if (paramAnonymouse != null)
          {
            u.logBigData(MyStewardInfoActivity.d(MyStewardInfoActivity.this), "===" + paramAnonymouse.toString());
            MyStewardInfoActivity.a(MyStewardInfoActivity.this, (MyEvaIsRentAvaiModel)com.alibaba.fastjson.a.parseObject(paramAnonymouse.toString(), MyEvaIsRentAvaiModel.class));
            if ((MyStewardInfoActivity.e(MyStewardInfoActivity.this) != null) && (MyStewardInfoActivity.e(MyStewardInfoActivity.this).evaluateInfo != null) && (MyStewardInfoActivity.e(MyStewardInfoActivity.this).evaluateInfo.result != null) && (MyStewardInfoActivity.e(MyStewardInfoActivity.this).evaluateInfo.result.size() > 0))
            {
              if (!"1".equals(((MyEvaIsRentAvaiModel.EvaluateInfoBean.ResultBean)MyStewardInfoActivity.e(MyStewardInfoActivity.this).evaluateInfo.result.get(0)).statusContent)) {
                break label163;
              }
              MyStewardInfoActivity.f(MyStewardInfoActivity.this);
            }
          }
          return;
          label163:
          MyStewardInfoActivity.g(MyStewardInfoActivity.this);
        }
      });
      return;
    }
    af.showToast(this, "请检查您的网络，稍后再试！");
  }
  
  private void d(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      ah.callPhone(this, paramString);
    }
  }
  
  private void e()
  {
    this.btn_to_evaluate.setVisibility(0);
    this.my_steward_btn.setVisibility(0);
    this.my_steward_btn.setTextColor(getResources().getColor(2131624597));
    this.my_steward_btn.setBackgroundColor(getResources().getColor(2131624583));
  }
  
  private void f()
  {
    this.btn_to_evaluate.setVisibility(8);
    this.my_steward_btn.setVisibility(0);
    this.my_steward_btn.setTextColor(getResources().getColor(2131624583));
    this.my_steward_btn.setBackgroundColor(getResources().getColor(2131624609));
  }
  
  @OnClick({2131696997, 2131696998})
  public void onClic(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131696998: 
      paramView = new Intent(this, MySubmitEvaluateActivity.class);
      paramView.putExtra("isShowHistory", false);
      paramView.putExtra("evaluateSource", this.x);
      paramView.putExtra("keeperId", this.r);
      paramView.putExtra("orderCode", this.g);
      startActivity(paramView);
      return;
    }
    if (this.e != null)
    {
      if (ae.notNull(this.e.getPhoneMobile()))
      {
        d(this.e.getPhoneMobile());
        return;
      }
      showToast("管家联系方式更换，请直接联系400客服");
      return;
    }
    showToast("获取管家信息失败");
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130904959);
    this.a = this;
    this.c = ButterKnife.bind(this);
    this.mBztb.setTitle("我的管家");
    a();
    this.my_steward_rb.setOnTouchListener(new View.OnTouchListener()
    {
      public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        return true;
      }
    });
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/my/MyStewardInfoActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */