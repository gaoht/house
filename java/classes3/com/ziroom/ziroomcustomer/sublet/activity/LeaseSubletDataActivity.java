package com.ziroom.ziroomcustomer.sublet.activity;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.alibaba.fastjson.e;
import com.freelxl.baselibrary.d.b.b;
import com.freelxl.baselibrary.d.b.c;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.commonlibrary.widget.unifiedziroom.BasicZiroomToolBar;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.a.f;
import com.ziroom.ziroomcustomer.e.c.o;
import com.ziroom.ziroomcustomer.e.e.q;
import com.ziroom.ziroomcustomer.e.g;
import com.ziroom.ziroomcustomer.e.q;
import com.ziroom.ziroomcustomer.model.UserInfo;
import com.ziroom.ziroomcustomer.my.CreditWebActivity;
import com.ziroom.ziroomcustomer.util.ad;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.util.ah;
import com.ziroom.ziroomcustomer.util.m;
import com.ziroom.ziroomcustomer.util.u;
import com.ziroom.ziroomcustomer.util.w;
import com.ziroom.ziroomcustomer.widget.LabeledEditText;
import com.ziroom.ziroomcustomer.widget.LabeledEditText.a;
import java.util.HashMap;
import java.util.Map;

public class LeaseSubletDataActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private static String A;
  private static String x;
  private static String y;
  private static String z;
  private int B;
  private View C;
  private TextView D;
  private TextView E;
  private TextView F;
  private TextView G;
  private Dialog H;
  private Context a;
  private String b;
  private a c;
  private String d;
  private Unbinder e;
  private String f;
  private String g;
  @BindView(2131696663)
  Button lease_sublet_data_btn;
  @BindView(2131696661)
  CheckBox lease_sublet_data_check;
  @BindView(2131696662)
  TextView lease_sublet_data_html;
  @BindView(2131696654)
  TextView lease_sublet_data_price;
  @BindView(2131696664)
  ImageView lease_sublet_data_prompt;
  @BindView(2131696655)
  TextView lease_sublet_data_time;
  @BindView(2131696653)
  LinearLayout lease_sublet_data_time_ll;
  @BindView(2131689787)
  BasicZiroomToolBar mBztb;
  private String r;
  private e s;
  @BindView(2131696659)
  LabeledEditText sublet_data_code_edit;
  @BindView(2131696648)
  EditText sublet_data_house_text_et;
  @BindView(2131696649)
  TextView sublet_data_house_text_size;
  @BindView(2131696656)
  LabeledEditText sublet_data_name_edit;
  @BindView(2131696657)
  LabeledEditText sublet_data_phone_edit;
  @BindView(2131696650)
  TextView sublet_data_sample;
  @BindView(2131696652)
  LabeledEditText sublet_data_time_edit;
  private int t = 20;
  private boolean u;
  private String v = "";
  @BindView(2131696660)
  TextView verification_code;
  @BindView(2131696658)
  RelativeLayout verivication_rl;
  private int w;
  
  private void a()
  {
    this.g = ad.getSubletTag(this.a);
    if (ae.isNull(this.g)) {
      this.lease_sublet_data_prompt.setVisibility(0);
    }
    for (;;)
    {
      com.freelxl.baselibrary.d.a.isLog(true);
      com.freelxl.baselibrary.d.a.isPrintLog(true);
      HashMap localHashMap = new HashMap();
      localHashMap.put("token", com.ziroom.commonlibrary.login.a.getToken(getApplicationContext()));
      localHashMap.put("contract_code", this.b + "");
      com.freelxl.baselibrary.d.a.get(q.Q + e.q.g + "?" + ah.encodeGetParams(g.getCommonHouseSign(localHashMap))).tag(this).enqueue(new f(this, new o())
      {
        public void onSuccess(int paramAnonymousInt, e paramAnonymouse)
        {
          super.onSuccess(paramAnonymousInt, paramAnonymouse);
          u.d("OKHttp", "===" + paramAnonymouse.toString());
          LeaseSubletDataActivity.a(LeaseSubletDataActivity.this, com.alibaba.fastjson.a.parseObject(paramAnonymouse.toString()));
          if (LeaseSubletDataActivity.a(LeaseSubletDataActivity.this) != null)
          {
            LeaseSubletDataActivity.b(LeaseSubletDataActivity.this, LeaseSubletDataActivity.a(LeaseSubletDataActivity.this));
            return;
          }
          LeaseSubletDataActivity.this.showToast("");
        }
      });
      return;
      this.lease_sublet_data_prompt.setVisibility(4);
    }
  }
  
  private void a(e parame)
  {
    this.mBztb.setTitle("补充转租信息");
    Object localObject;
    if (this.w != 2)
    {
      this.sublet_data_time_edit.setBottomHint("预计入住时间");
      this.sublet_data_time_edit.setTopHint("预计入住时间");
      localObject = ApplicationEx.c.getUser();
      if (localObject == null) {
        break label131;
      }
      localObject = ((UserInfo)localObject).getUid();
      if ((TextUtils.isEmpty(x)) || (TextUtils.isEmpty((CharSequence)localObject)) || (!x.equals(localObject))) {
        break label112;
      }
      label80:
      x = (String)localObject;
    }
    for (;;)
    {
      if (parame != null) {
        break label150;
      }
      return;
      this.sublet_data_time_edit.setBottomHint("预计退租日期");
      this.sublet_data_time_edit.setTopHint("预计退租日期");
      break;
      label112:
      x = null;
      y = null;
      z = null;
      A = null;
      break label80;
      label131:
      x = null;
      y = null;
      z = null;
      A = null;
    }
    label150:
    int i;
    if (ae.isNull(parame.getString("describe_maxlen")))
    {
      i = 0;
      this.t = i;
      if (this.t == 0) {
        this.t = 20;
      }
      if (!ae.isNull(parame.getString("checkin_date"))) {
        break label408;
      }
      localObject = "";
      label199:
      this.f = ((String)localObject);
      LabeledEditText localLabeledEditText = this.sublet_data_time_edit;
      if (!ae.isNull(parame.getString("checkin_date"))) {
        break label419;
      }
      localObject = "";
      label226:
      localLabeledEditText.setText((String)localObject);
      if (!TextUtils.isEmpty(parame.getString("customer_name"))) {
        break label430;
      }
      if (!TextUtils.isEmpty(z)) {
        this.sublet_data_name_edit.setText(z);
      }
      label264:
      if (!TextUtils.isEmpty(parame.getString("customer_phone"))) {
        break label447;
      }
      if (!TextUtils.isEmpty(A)) {
        this.sublet_data_phone_edit.setText(A);
      }
      label296:
      if (!TextUtils.isEmpty(parame.getString("describe"))) {
        break label464;
      }
      if (!TextUtils.isEmpty(y)) {
        this.sublet_data_house_text_et.setText(y);
      }
    }
    for (;;)
    {
      this.sublet_data_house_text_et.setSelection(VdsAgent.trackEditTextSilent(this.sublet_data_house_text_et).length());
      this.sublet_data_house_text_size.setText(VdsAgent.trackEditTextSilent(this.sublet_data_house_text_et).toString().length() + "/" + this.t);
      return;
      i = parame.getInteger("describe_maxlen").intValue();
      break;
      label408:
      localObject = parame.getString("checkin_date");
      break label199;
      label419:
      localObject = parame.getString("checkin_date");
      break label226;
      label430:
      this.sublet_data_name_edit.setText(parame.getString("customer_name"));
      break label264;
      label447:
      this.sublet_data_phone_edit.setText(parame.getString("customer_phone"));
      break label296;
      label464:
      this.sublet_data_house_text_et.setText(parame.getString("describe"));
    }
  }
  
  private void b()
  {
    this.lease_sublet_data_check.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
    {
      @Instrumented
      public void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
      {
        VdsAgent.onCheckedChanged(this, paramAnonymousCompoundButton, paramAnonymousBoolean);
        if (paramAnonymousBoolean) {
          w.onEvent(LeaseSubletDataActivity.b(LeaseSubletDataActivity.this), "sublet_agreement ");
        }
      }
    });
    this.sublet_data_house_text_et.addTextChangedListener(new TextWatcher()
    {
      public void afterTextChanged(Editable paramAnonymousEditable)
      {
        if (VdsAgent.trackEditTextSilent(LeaseSubletDataActivity.this.sublet_data_house_text_et).toString().length() > LeaseSubletDataActivity.c(LeaseSubletDataActivity.this))
        {
          LeaseSubletDataActivity.this.sublet_data_house_text_et.setText(LeaseSubletDataActivity.d(LeaseSubletDataActivity.this) + "");
          LeaseSubletDataActivity.this.showToast("请不要输入大于" + LeaseSubletDataActivity.c(LeaseSubletDataActivity.this) + "个字符");
          LeaseSubletDataActivity.d(LeaseSubletDataActivity.d(LeaseSubletDataActivity.this) + "");
          return;
        }
        LeaseSubletDataActivity.d(VdsAgent.trackEditTextSilent(LeaseSubletDataActivity.this.sublet_data_house_text_et).toString());
        LeaseSubletDataActivity.this.sublet_data_house_text_size.setText(VdsAgent.trackEditTextSilent(LeaseSubletDataActivity.this.sublet_data_house_text_et).toString().length() + "/" + LeaseSubletDataActivity.c(LeaseSubletDataActivity.this));
      }
      
      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        LeaseSubletDataActivity.a(LeaseSubletDataActivity.this, paramAnonymousCharSequence.toString());
      }
      
      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    this.sublet_data_name_edit.addTextChangedListener(new LabeledEditText.a()
    {
      public void afterTextChanged(Editable paramAnonymousEditable)
      {
        LeaseSubletDataActivity.e(paramAnonymousEditable.toString());
      }
      
      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    this.sublet_data_code_edit.addTextChangedListener(new LabeledEditText.a()
    {
      public void afterTextChanged(Editable paramAnonymousEditable) {}
      
      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    this.sublet_data_phone_edit.addTextChangedListener(new LabeledEditText.a()
    {
      public void afterTextChanged(Editable paramAnonymousEditable)
      {
        LeaseSubletDataActivity.f(LeaseSubletDataActivity.this.sublet_data_phone_edit.getText().toString());
      }
      
      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        LeaseSubletDataActivity.b(LeaseSubletDataActivity.this, LeaseSubletDataActivity.this.sublet_data_phone_edit.getText());
      }
      
      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        paramAnonymousInt1 = paramAnonymousCharSequence.length();
        if (paramAnonymousInt1 == 11)
        {
          String str = ApplicationEx.c.getUser().getPhone();
          if ((LeaseSubletDataActivity.a(LeaseSubletDataActivity.this).get("customer_phone").toString().equals(paramAnonymousCharSequence.toString())) || (str.equals(paramAnonymousCharSequence.toString())))
          {
            LeaseSubletDataActivity.this.verivication_rl.setVisibility(8);
            LeaseSubletDataActivity.a(LeaseSubletDataActivity.this, false);
          }
        }
        do
        {
          return;
          LeaseSubletDataActivity.a(LeaseSubletDataActivity.this, true);
          LeaseSubletDataActivity.this.verivication_rl.setVisibility(0);
          return;
          if (paramAnonymousInt1 > 11)
          {
            LeaseSubletDataActivity.this.sublet_data_phone_edit.setText(LeaseSubletDataActivity.e(LeaseSubletDataActivity.this));
            LeaseSubletDataActivity.this.verivication_rl.setVisibility(0);
            LeaseSubletDataActivity.this.sublet_data_phone_edit.setSelection(LeaseSubletDataActivity.this.sublet_data_phone_edit.getText().length());
            paramAnonymousCharSequence = ApplicationEx.c.getUser().getPhone();
            if ((LeaseSubletDataActivity.a(LeaseSubletDataActivity.this).get("customer_phone").toString().equals(LeaseSubletDataActivity.e(LeaseSubletDataActivity.this).toString())) || (paramAnonymousCharSequence.equals(LeaseSubletDataActivity.e(LeaseSubletDataActivity.this).toString())))
            {
              LeaseSubletDataActivity.this.verivication_rl.setVisibility(8);
              LeaseSubletDataActivity.a(LeaseSubletDataActivity.this, false);
              return;
            }
            LeaseSubletDataActivity.a(LeaseSubletDataActivity.this, true);
            LeaseSubletDataActivity.this.verivication_rl.setVisibility(0);
            return;
          }
        } while (paramAnonymousInt1 >= 11);
        LeaseSubletDataActivity.this.verivication_rl.setVisibility(8);
      }
    });
  }
  
  private void e()
  {
    w.onEvent(this.a, "sublet_publish_im ");
    if (ae.isNull(VdsAgent.trackEditTextSilent(this.sublet_data_house_text_et).toString()))
    {
      showToast("据说房源有描述更容易转租出去哦~");
      return;
    }
    if (VdsAgent.trackEditTextSilent(this.sublet_data_house_text_et).toString().length() < 40)
    {
      showToast("推荐理由应至少填写40个字");
      return;
    }
    if (ae.isNull(this.f))
    {
      localObject = "请选择预计退租日期";
      if (this.w != 2) {
        localObject = "请选择预计可入住日期";
      }
      showToast((String)localObject);
      return;
    }
    if (ae.isNull(this.sublet_data_name_edit.getText() + ""))
    {
      showToast("联系人不能为空");
      return;
    }
    if (ae.isNull(this.sublet_data_phone_edit.getText() + ""))
    {
      showToast("手机号不能为空");
      return;
    }
    if ((this.u) && (ae.isNull(this.sublet_data_code_edit.getText())))
    {
      showToast("请验证手机号");
      return;
    }
    if (!this.lease_sublet_data_check.isChecked())
    {
      showToast("若同意免责声明请勾选哦");
      return;
    }
    w.onEvent(this.a, "sublet_publish_im_correct ");
    com.freelxl.baselibrary.d.a.isLog(true);
    Object localObject = new HashMap();
    ((Map)localObject).put("token", com.ziroom.commonlibrary.login.a.getToken(getApplicationContext()));
    ((Map)localObject).put("turn_id", this.s.getString("turn_id") + "");
    ((Map)localObject).put("turn_id", this.s.getString("turn_id") + "");
    ((Map)localObject).put("contract_code", this.b + "");
    ((Map)localObject).put("customer_name", this.sublet_data_name_edit.getText() + "");
    ((Map)localObject).put("customer_phone", this.sublet_data_phone_edit.getText() + "");
    ((Map)localObject).put("checkin_date", this.f + "");
    ((Map)localObject).put("authcode", this.sublet_data_code_edit.getText() + "");
    ((Map)localObject).put("describe", VdsAgent.trackEditTextSilent(this.sublet_data_house_text_et).toString());
    com.freelxl.baselibrary.d.a.post(q.Q + e.q.h).tag(this).params(g.getCommonHouseSign((Map)localObject)).enqueue(new f(this, new o())
    {
      public void onSuccess(int paramAnonymousInt, e paramAnonymouse)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymouse);
        Intent localIntent = new Intent(LeaseSubletDataActivity.b(LeaseSubletDataActivity.this), LeaseSubletSuccessActivity.class);
        localIntent.putExtra("lease", LeaseSubletDataActivity.i(LeaseSubletDataActivity.this));
        if (paramAnonymouse != null)
        {
          if (paramAnonymouse.get("success_text") != null) {
            localIntent.putExtra("success_text", paramAnonymouse.get("success_text").toString());
          }
          if (paramAnonymouse.get("success_tip") != null) {
            localIntent.putExtra("success_tip", paramAnonymouse.get("success_tip").toString());
          }
          if (paramAnonymouse.get("activity_info") != null) {
            localIntent.putExtra("activity_info", paramAnonymouse.get("activity_info").toString());
          }
        }
        LeaseSubletDataActivity.this.startActivity(localIntent);
        w.onEvent(LeaseSubletDataActivity.b(LeaseSubletDataActivity.this), "sublet_publish_im_success ");
        ApplicationEx.c.addActivity(LeaseSubletDataActivity.this);
        if (LeaseSubletDataActivity.g(LeaseSubletDataActivity.this) != null) {
          LeaseSubletDataActivity.g(LeaseSubletDataActivity.this).cancel();
        }
      }
    });
  }
  
  private void g(String paramString)
  {
    if (ae.notNull(paramString))
    {
      com.freelxl.baselibrary.d.a.isLog(true);
      HashMap localHashMap = new HashMap();
      localHashMap.put("token", com.ziroom.commonlibrary.login.a.getToken(getApplicationContext()));
      localHashMap.put("checkin_date", paramString + "");
      localHashMap.put("contract_code", this.b + "");
      com.freelxl.baselibrary.d.a.get(q.Q + e.q.f + "?" + ah.encodeGetParams(g.getCommonHouseSign(localHashMap))).tag(this).enqueue(new f(this, new o())
      {
        public void onSuccess(int paramAnonymousInt, e paramAnonymouse)
        {
          super.onSuccess(paramAnonymousInt, paramAnonymouse);
          u.d("OKHttp", "===" + paramAnonymouse.toString());
          Object localObject = com.alibaba.fastjson.a.parseObject(paramAnonymouse.toString());
          if (localObject != null)
          {
            paramAnonymouse = ((e)localObject).getString("estimate_price");
            LeaseSubletDataActivity.c(LeaseSubletDataActivity.this, ((e)localObject).getString("estimate_price_desc"));
            localObject = ((e)localObject).getString("signing_max");
            LeaseSubletDataActivity.this.lease_sublet_data_time_ll.setVisibility(0);
            if (ae.notNull(paramAnonymouse)) {
              if (ae.notNull(LeaseSubletDataActivity.f(LeaseSubletDataActivity.this)))
              {
                paramAnonymouse = "转租价格：" + paramAnonymouse + " 查看说明";
                ah.setTextColor(LeaseSubletDataActivity.this.lease_sublet_data_price, paramAnonymouse, paramAnonymouse.length() - 4, 4);
                LeaseSubletDataActivity.this.lease_sublet_data_price.setVisibility(0);
              }
            }
            for (;;)
            {
              if (!ae.notNull((String)localObject)) {
                break label249;
              }
              LeaseSubletDataActivity.this.lease_sublet_data_time.setText("对方最长可签约至" + (String)localObject + ";");
              LeaseSubletDataActivity.this.lease_sublet_data_time.setVisibility(0);
              return;
              paramAnonymouse = "转租价格：" + paramAnonymouse;
              break;
              LeaseSubletDataActivity.this.lease_sublet_data_price.setVisibility(8);
            }
            label249:
            LeaseSubletDataActivity.this.lease_sublet_data_time.setVisibility(8);
            return;
          }
          LeaseSubletDataActivity.this.showToast("");
        }
      });
      return;
    }
    showToast("时间为空");
  }
  
  private void h(String paramString)
  {
    if (ae.notNull(paramString))
    {
      com.freelxl.baselibrary.d.a.isLog(true);
      HashMap localHashMap = new HashMap();
      localHashMap.put("token", com.ziroom.commonlibrary.login.a.getToken(getApplicationContext()));
      localHashMap.put("phone", paramString + "");
      com.freelxl.baselibrary.d.a.post(q.Q + e.q.b).tag(this).params(g.getCommonHouseSign(localHashMap)).enqueue(new f(this, new o())
      {
        public void onSuccess(int paramAnonymousInt, e paramAnonymouse)
        {
          super.onSuccess(paramAnonymousInt, paramAnonymouse);
          u.d("OKHttp", "===" + paramAnonymouse.toString());
          paramAnonymouse = com.alibaba.fastjson.a.parseObject(paramAnonymouse.toString());
          if (paramAnonymouse != null)
          {
            paramAnonymousInt = paramAnonymouse.getInteger("expire").intValue();
            LeaseSubletDataActivity.a(LeaseSubletDataActivity.this, new LeaseSubletDataActivity.a(LeaseSubletDataActivity.this, paramAnonymousInt * 1000, 1000L));
            LeaseSubletDataActivity.g(LeaseSubletDataActivity.this).start();
            LeaseSubletDataActivity.this.verification_code.setEnabled(false);
            return;
          }
          LeaseSubletDataActivity.this.showToast("");
        }
      });
      return;
    }
    showToast("手机号为空");
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 99) && (paramIntent != null))
    {
      this.f = paramIntent.getStringExtra("sublet");
      this.sublet_data_time_edit.setText(this.f + "");
      g(this.f);
    }
  }
  
  @OnClick({2131696651, 2131696660, 2131696665, 2131696663, 2131696654, 2131696662, 2131696650})
  public void onClic(View paramView)
  {
    switch (paramView.getId())
    {
    case 2131696652: 
    case 2131696653: 
    case 2131696655: 
    case 2131696656: 
    case 2131696657: 
    case 2131696658: 
    case 2131696659: 
    case 2131696661: 
    case 2131696664: 
    default: 
    case 2131696650: 
    case 2131696654: 
    case 2131696651: 
      do
      {
        do
        {
          return;
          showDialog("房子位置好，步行10分钟即达望京地铁站，方便乘坐14、15号线。小区安保严格，还有小花园，附近有大型商超和菜市场。\n\n屋内有朝南大阳台，晒衣服养绿植都很方便，阳光充足外加集中供暖，冬天家里一点都不冷。屋内装了4开门衣柜，多少衣服都装得下。邻居相处融洽，大家都是作息规律的上班族。02卧是个设计小哥，人超好。\n\n我自己在宜家购置了衣架、鞋架，另有若干绿植一同奉送。欢迎联系我看房，工作日看房可能要19:30以后哦。\n", 1);
          w.onEvent(this.a, "sublet_sample");
          return;
        } while (!ae.notNull(this.r));
        showDialog(this.r, 0);
        return;
      } while (this.s == null);
      if (ae.isNull(this.s.getString("end_date")))
      {
        showToast("end_date为空");
        return;
      }
      if (ae.isNull(this.s.getString("begin_date")))
      {
        showToast("begin_date为空");
        return;
      }
      long l = m.getTimeLength(this.f, this.s.getString("end_date"), m.b);
      if ((l > m.getTimeLength(this.s.getString("begin_date"), this.s.getString("end_date"), m.b)) || (l < 0L)) {}
      for (paramView = "";; paramView = this.f)
      {
        Intent localIntent = new Intent(this.a, LeaseSubletTimeActivity.class);
        localIntent.putExtra("subletTime", paramView);
        localIntent.putExtra("startTime", this.s.getString("begin_date"));
        localIntent.putExtra("endTime", this.s.getString("end_date"));
        startActivityForResult(localIntent, 99);
        w.onEvent(this.a, "sublet_available_date ");
        return;
      }
    case 2131696660: 
      h(this.sublet_data_phone_edit.getText());
      return;
    case 2131696665: 
      if (ae.isNull(this.g)) {
        ad.saveSubletTag(this.a, "1");
      }
      this.lease_sublet_data_prompt.setVisibility(4);
      paramView = new Intent(this.a, CreditWebActivity.class);
      paramView.putExtra("url", "http://zhuanti.ziroom.com/zhuanti/2017/zrk/zhuanzu/index.html");
      paramView.putExtra("title", "详细转租流程");
      startActivity(paramView);
      w.onEvent(this.a, "sublet_flow_detail ");
      return;
    case 2131696662: 
      paramView = new Intent(this.a, CreditWebActivity.class);
      paramView.putExtra("url", "http://www.ziroom.com/zhuanti/2016/zjlc/shenqing.html");
      paramView.putExtra("title", "转租申请协议");
      startActivity(paramView);
      return;
    }
    e();
  }
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131697639: 
      this.H.dismiss();
      return;
    }
    this.H.dismiss();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130904838);
    this.a = this;
    this.e = ButterKnife.bind(this);
    this.b = getIntent().getStringExtra("lease");
    this.w = getIntent().getIntExtra("version", 2);
    b();
    a();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (this.c != null) {
      this.c.cancel();
    }
    ApplicationEx.c.removeActivity(this);
    this.e.unbind();
  }
  
  public void showDialog(String paramString, int paramInt)
  {
    this.C = View.inflate(this.a, 2130905165, null);
    this.D = ((TextView)this.C.findViewById(2131697639));
    this.G = ((TextView)this.C.findViewById(2131697638));
    this.F = ((TextView)this.C.findViewById(2131697637));
    this.E = ((TextView)this.C.findViewById(2131697634));
    this.D.setOnClickListener(this);
    this.G.setOnClickListener(this);
    this.E.setVisibility(8);
    this.D.setVisibility(0);
    this.G.setVisibility(0);
    this.F.setGravity(17);
    this.F.setText(paramString);
    this.D.setText("我知道了");
    this.G.setVisibility(8);
    this.B = paramInt;
    if (paramInt == 1)
    {
      paramString = new LinearLayout.LayoutParams(-1, -2);
      paramString.setMargins(24, 40, 24, 40);
      this.F.setLayoutParams(paramString);
      this.F.setGravity(3);
      this.E.setText("参考示例");
      this.E.setVisibility(0);
    }
    if (this.H == null)
    {
      this.H = new Dialog(this.a, 2131427781);
      this.H.setContentView(this.C);
      if (paramInt != 1) {
        break label320;
      }
      this.H.setCanceledOnTouchOutside(true);
      this.H.setCancelable(true);
      paramString = this.H;
      if ((paramString instanceof Dialog)) {
        break label339;
      }
      paramString.show();
    }
    for (;;)
    {
      ApplicationEx.g = 2;
      this.H.setOnDismissListener(new DialogInterface.OnDismissListener()
      {
        public void onDismiss(DialogInterface paramAnonymousDialogInterface)
        {
          LeaseSubletDataActivity.a(LeaseSubletDataActivity.this, null);
          LeaseSubletDataActivity.h(LeaseSubletDataActivity.this).dismiss();
          LeaseSubletDataActivity.a(LeaseSubletDataActivity.this, null);
        }
      });
      return;
      label320:
      this.H.setCanceledOnTouchOutside(false);
      this.H.setCancelable(false);
      break;
      label339:
      VdsAgent.showDialog((Dialog)paramString);
    }
  }
  
  class a
    extends CountDownTimer
  {
    public a(long paramLong1, long paramLong2)
    {
      super(paramLong2);
    }
    
    public void onFinish()
    {
      if (LeaseSubletDataActivity.this.verification_code == null) {
        return;
      }
      LeaseSubletDataActivity.this.verification_code.setEnabled(true);
      LeaseSubletDataActivity.this.verification_code.setText("重新获取");
    }
    
    public void onTick(long paramLong)
    {
      if (LeaseSubletDataActivity.this.verification_code == null) {
        return;
      }
      LeaseSubletDataActivity.this.verification_code.setText(paramLong / 1000L + "s");
      LeaseSubletDataActivity.this.verification_code.setEnabled(false);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/sublet/activity/LeaseSubletDataActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */