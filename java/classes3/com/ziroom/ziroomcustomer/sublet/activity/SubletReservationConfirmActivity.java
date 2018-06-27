package com.ziroom.ziroomcustomer.sublet.activity;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.alibaba.fastjson.e;
import com.freelxl.baselibrary.e.i.a;
import com.freelxl.baselibrary.e.k;
import com.growingio.android.sdk.agent.VdsAgent;
import com.ziroom.ziroomcustomer.activity.HouseBillInfoActivity;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.a.f;
import com.ziroom.ziroomcustomer.e.c.r;
import com.ziroom.ziroomcustomer.e.e.a;
import com.ziroom.ziroomcustomer.e.g;
import com.ziroom.ziroomcustomer.e.j;
import com.ziroom.ziroomcustomer.e.q;
import com.ziroom.ziroomcustomer.model.IkeyRaConfig;
import com.ziroom.ziroomcustomer.model.InfoItem;
import com.ziroom.ziroomcustomer.model.UserInfo;
import com.ziroom.ziroomcustomer.sublet.model.SubletReservationInfo;
import com.ziroom.ziroomcustomer.sublet.model.SubletReservationInfo.DataBean;
import com.ziroom.ziroomcustomer.util.a.b;
import com.ziroom.ziroomcustomer.util.ad;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.util.af;
import com.ziroom.ziroomcustomer.util.ah;
import com.ziroom.ziroomcustomer.util.u;
import com.ziroom.ziroomcustomer.widget.InfoBlockLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SubletReservationConfirmActivity
  extends BaseActivity
{
  View.OnClickListener A = new View.OnClickListener()
  {
    private void a()
    {
      j.subletInitiatorConfirmReserveOrder(SubletReservationConfirmActivity.this.s, com.ziroom.commonlibrary.login.a.getUid(SubletReservationConfirmActivity.this.s), SubletReservationConfirmActivity.this.f, SubletReservationConfirmActivity.e(SubletReservationConfirmActivity.this), new f(SubletReservationConfirmActivity.this.s, new r())
      {
        public void onSuccess(int paramAnonymous2Int, e paramAnonymous2e)
        {
          super.onSuccess(paramAnonymous2Int, paramAnonymous2e);
          u.d("OKHttp_ymq", "===" + paramAnonymous2e.toString());
          paramAnonymous2Int = paramAnonymous2e.getInteger("error_code").intValue();
          String str = paramAnonymous2e.getString("status");
          paramAnonymous2e.getString("data");
          paramAnonymous2e = paramAnonymous2e.getString("error_message");
          if (("success".equals(str)) && (paramAnonymous2Int == 0))
          {
            paramAnonymous2e = new Intent(SubletReservationConfirmActivity.this.s, HouseBillInfoActivity.class);
            paramAnonymous2e.putExtra("uniqueCode", SubletReservationConfirmActivity.this.f);
            paramAnonymous2e.putExtra("period", "");
            paramAnonymous2e.putExtra("contract_code", SubletReservationConfirmActivity.this.g);
            paramAnonymous2e.putExtra("payType", SubletReservationConfirmActivity.this.u);
            paramAnonymous2e.putExtra("mContentText", "倒计时结束之前，您可以在个人中心\"我的合同\"列表里进入转租详情进行支付。");
            SubletReservationConfirmActivity.this.startActivityAndFinish(paramAnonymous2e);
            return;
          }
          af.showToast(SubletReservationConfirmActivity.this.s, paramAnonymous2e);
        }
      });
    }
    
    private void b()
    {
      Map localMap = g.buildSetreserveData(SubletReservationConfirmActivity.this.f, SubletReservationConfirmActivity.this.r.data.userPhone, SubletReservationConfirmActivity.this.r.data.userName, SubletReservationConfirmActivity.this.r.data.certType + "", SubletReservationConfirmActivity.this.r.data.certNum, SubletReservationConfirmActivity.e(SubletReservationConfirmActivity.this));
      j.confirmSubletReservation(SubletReservationConfirmActivity.this.s, localMap, new f(SubletReservationConfirmActivity.this.s, new r())
      {
        public void onSuccess(int paramAnonymous2Int, e paramAnonymous2e)
        {
          super.onSuccess(paramAnonymous2Int, paramAnonymous2e);
          u.d("OKHttp_ymq", "===" + paramAnonymous2e.toString());
          paramAnonymous2Int = paramAnonymous2e.getInteger("error_code").intValue();
          String str = paramAnonymous2e.getString("status");
          paramAnonymous2e.getString("data");
          paramAnonymous2e = paramAnonymous2e.getString("error_message");
          if (("success".equals(str)) && (paramAnonymous2Int == 0))
          {
            paramAnonymous2e = new Intent(SubletReservationConfirmActivity.this.s, HouseBillInfoActivity.class);
            paramAnonymous2e.putExtra("uniqueCode", SubletReservationConfirmActivity.this.f);
            paramAnonymous2e.putExtra("period", "");
            paramAnonymous2e.putExtra("payType", SubletReservationConfirmActivity.this.u);
            paramAnonymous2e.putExtra("mContentText", "倒计时结束之前，您可以在“我的订单”里找到待支付的长租预订单进行支付。");
            SubletReservationConfirmActivity.this.startActivityAndFinish(paramAnonymous2e);
            return;
          }
          af.showToast(SubletReservationConfirmActivity.this.s, paramAnonymous2e);
        }
      });
    }
    
    @com.growingio.android.sdk.instrumentation.Instrumented
    public void onClick(View paramAnonymousView)
    {
      VdsAgent.onClick(this, paramAnonymousView);
      switch (paramAnonymousView.getId())
      {
      default: 
      case 2131697195: 
        do
        {
          return;
          SubletReservationConfirmActivity.d(SubletReservationConfirmActivity.this).dismiss();
          SubletReservationConfirmActivity.a(SubletReservationConfirmActivity.this, VdsAgent.trackEditTextSilent(SubletReservationConfirmActivity.this.z).toString());
          if ((SubletReservationConfirmActivity.e(SubletReservationConfirmActivity.this).length() == 0) || (SubletReservationConfirmActivity.e(SubletReservationConfirmActivity.this) == null))
          {
            af.showToast(SubletReservationConfirmActivity.this, "验证码不能为空");
            return;
          }
          if ("ZZYD".equals(SubletReservationConfirmActivity.this.u))
          {
            b();
            return;
          }
        } while (!"QRYD".equals(SubletReservationConfirmActivity.this.u));
        a();
        return;
      }
      SubletReservationConfirmActivity.d(SubletReservationConfirmActivity.this).dismiss();
    }
  };
  private Dialog B;
  private TextView C;
  private Bitmap D;
  private String E;
  private String F;
  private Handler G = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      switch (paramAnonymousMessage.what)
      {
      default: 
        return;
      }
      SubletReservationConfirmActivity.this.y.setImageBitmap(SubletReservationConfirmActivity.h(SubletReservationConfirmActivity.this));
      SubletReservationConfirmActivity.g(SubletReservationConfirmActivity.this).setVisibility(8);
    }
  };
  List<InfoItem> a;
  List<InfoItem> b;
  List<InfoItem> c;
  String d;
  String e;
  String f;
  String g;
  @BindView(2131697610)
  InfoBlockLayout iblHouseInfo;
  @BindView(2131697611)
  InfoBlockLayout iblInitiatorInfo;
  @BindView(2131697608)
  InfoBlockLayout iblReservatorInfo;
  @BindView(2131689492)
  ImageView ivBack;
  SubletReservationInfo r;
  Context s;
  String t;
  @BindView(2131697612)
  TextView tvConfirmReservation;
  @BindView(2131691990)
  TextView tvContactKeeper;
  @BindView(2131697609)
  TextView tvDateDesc;
  String u;
  com.ziroom.ziroomcustomer.util.a.a v;
  String w;
  int x;
  ImageView y;
  EditText z;
  
  private void a()
  {
    this.f = getIntent().getStringExtra("reserveCode");
    this.u = getIntent().getStringExtra("confirmType");
    this.g = getIntent().getStringExtra("contract_code");
    this.x = Integer.parseInt(ad.getOther(this, "signed_user_type"));
  }
  
  private void a(String paramString1, String paramString2, String paramString3)
  {
    paramString1 = g.buildCrmSignGetSecretInfo(this.s, paramString1, paramString2, paramString3);
    j.crmSignGetSecretInfo(this.s, paramString1, new f(this.s, new r())
    {
      public void onSuccess(int paramAnonymousInt, e paramAnonymouse)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymouse);
        u.d("OKHttp_ymq", "===" + paramAnonymouse.toString());
        paramAnonymousInt = paramAnonymouse.getInteger("error_code").intValue();
        String str = paramAnonymouse.getString("status");
        SubletReservationConfirmActivity.this.t = paramAnonymouse.getString("data");
        paramAnonymouse = paramAnonymouse.getString("error_message");
        if (("success".equals(str)) && (paramAnonymousInt == 0))
        {
          SubletReservationConfirmActivity.c(SubletReservationConfirmActivity.this);
          return;
        }
        af.showToast(SubletReservationConfirmActivity.this.s, paramAnonymouse);
      }
    });
  }
  
  private void b()
  {
    if (!ApplicationEx.c.isLoginState())
    {
      com.ziroom.commonlibrary.login.a.startLoginActivity(this.s);
      return;
    }
    if (ApplicationEx.c.getUser() != null) {
      this.w = ApplicationEx.c.getUser().getUid();
    }
    j.getSubletReservationInfo(this, g.buildGetreserveData(this.f), new f(this, new r())
    {
      public void onSuccess(int paramAnonymousInt, e paramAnonymouse)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymouse);
        if (paramAnonymouse != null)
        {
          u.logBigData("OKHttp_ymq", "===" + paramAnonymouse.toString());
          SubletReservationConfirmActivity.this.r = ((SubletReservationInfo)e.parseObject(paramAnonymouse.toString(), SubletReservationInfo.class));
          if (SubletReservationConfirmActivity.this.r != null)
          {
            if (!"success".equals(SubletReservationConfirmActivity.this.r.status)) {
              break label193;
            }
            SubletReservationConfirmActivity.this.a = new ArrayList();
            SubletReservationConfirmActivity.this.b = new ArrayList();
            SubletReservationConfirmActivity.this.c = new ArrayList();
            SubletReservationConfirmActivity.a(SubletReservationConfirmActivity.this);
            SubletReservationConfirmActivity.b(SubletReservationConfirmActivity.this);
            paramAnonymouse = new InfoItem();
            paramAnonymouse.title = "物业地址";
            paramAnonymouse.value = SubletReservationConfirmActivity.this.r.data.houseAddress;
            SubletReservationConfirmActivity.this.b.add(paramAnonymouse);
            SubletReservationConfirmActivity.this.updateView();
          }
        }
        return;
        label193:
        af.showToast(SubletReservationConfirmActivity.this.s, SubletReservationConfirmActivity.this.r.error_message);
      }
    });
  }
  
  private void b(String paramString1, String paramString2, String paramString3)
  {
    paramString1 = g.buildCrmSignVerify(this.s, paramString1, paramString2, paramString3);
    j.crmSignVerify(this.s, paramString1, new f(this.s, new r())
    {
      public void onSuccess(int paramAnonymousInt, e paramAnonymouse)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymouse);
        u.d("OKHttp_ymq", "===" + paramAnonymouse.toString());
        paramAnonymousInt = paramAnonymouse.getInteger("error_code").intValue();
        String str = paramAnonymouse.getString("status");
        paramAnonymouse.getString("data");
        paramAnonymouse = paramAnonymouse.getString("error_message");
        if (("success".equals(str)) && (paramAnonymousInt == 0))
        {
          SubletReservationConfirmActivity.this.onSign();
          return;
        }
        af.showToast(SubletReservationConfirmActivity.this.s, paramAnonymouse);
      }
    });
  }
  
  private void e()
  {
    int i = 0;
    if (i < 3)
    {
      InfoItem localInfoItem = new InfoItem();
      switch (i)
      {
      }
      for (;;)
      {
        this.c.add(localInfoItem);
        i += 1;
        break;
        localInfoItem.title = "姓名";
        localInfoItem.value = this.r.data.subtenantUserName;
        continue;
        localInfoItem.title = "证件号码";
        if ("ZZYD".equals(this.u))
        {
          localInfoItem.value = c(this.r.data.subtenantCertNum);
        }
        else
        {
          localInfoItem.value = this.r.data.subtenantCertNum;
          continue;
          localInfoItem.title = "退租日期";
          localInfoItem.value = this.r.data.subtenantBackRentDate;
          if ("QRYD".equals(this.u)) {
            localInfoItem.isValueLight = true;
          }
        }
      }
    }
  }
  
  private void f()
  {
    int i = 0;
    if (i < 3)
    {
      InfoItem localInfoItem = new InfoItem();
      switch (i)
      {
      }
      for (;;)
      {
        this.a.add(localInfoItem);
        i += 1;
        break;
        localInfoItem.title = "姓名";
        localInfoItem.value = this.r.data.userName;
        continue;
        localInfoItem.title = "证件号码";
        if ("QRYD".equals(this.u))
        {
          localInfoItem.value = c(this.r.data.certNum);
        }
        else
        {
          localInfoItem.value = this.r.data.certNum;
          continue;
          localInfoItem.title = "可签约日期";
          localInfoItem.value = this.r.data.canSigndate;
          if ("ZZYD".equals(this.u)) {
            localInfoItem.isValueLight = true;
          }
        }
      }
    }
  }
  
  private void g()
  {
    j.iTrusRaConfig(this.s, new com.ziroom.ziroomcustomer.e.a.c(this, new com.ziroom.ziroomcustomer.e.c.a(IkeyRaConfig.class))
    {
      public void onSuccess(int paramAnonymousInt, IkeyRaConfig paramAnonymousIkeyRaConfig)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousIkeyRaConfig);
        if (paramAnonymousIkeyRaConfig != null)
        {
          paramAnonymousIkeyRaConfig = new com.ziroom.ziroomcustomer.util.a.c(SubletReservationConfirmActivity.this.v, paramAnonymousIkeyRaConfig);
          paramAnonymousIkeyRaConfig.setListener(new b()
          {
            public void onError(String paramAnonymous2String)
            {
              if (!TextUtils.isEmpty(paramAnonymous2String))
              {
                u.d("ITrusListener", paramAnonymous2String);
                paramAnonymous2String = g.getAddErrorMsg("签名错误", paramAnonymous2String, SubletReservationConfirmActivity.this.s);
                j.getReservationOrderText(SubletReservationConfirmActivity.this.s, new SubletReservationConfirmActivity.a(SubletReservationConfirmActivity.this), paramAnonymous2String, false, q.s + e.a.r);
              }
            }
            
            public void onSignEnd(String paramAnonymous2String)
            {
              u.i("sign_ymq", "sign:" + paramAnonymous2String);
              if (ae.notNull(paramAnonymous2String)) {
                SubletReservationConfirmActivity.a(SubletReservationConfirmActivity.this, SubletReservationConfirmActivity.this.f, SubletReservationConfirmActivity.this.u, paramAnonymous2String);
              }
            }
          });
          paramAnonymousIkeyRaConfig.sign(SubletReservationConfirmActivity.this.t);
        }
      }
    });
  }
  
  public void getYanzhengmaBitmap()
  {
    new Thread(new Runnable()
    {
      /* Error */
      public void run()
      {
        // Byte code:
        //   0: new 38	java/util/ArrayList
        //   3: dup
        //   4: invokespecial 39	java/util/ArrayList:<init>	()V
        //   7: astore 4
        //   9: new 41	java/util/HashMap
        //   12: dup
        //   13: invokespecial 42	java/util/HashMap:<init>	()V
        //   16: astore_3
        //   17: aload_0
        //   18: getfield 26	com/ziroom/ziroomcustomer/sublet/activity/SubletReservationConfirmActivity$7:a	Lcom/ziroom/ziroomcustomer/sublet/activity/SubletReservationConfirmActivity;
        //   21: getfield 46	com/ziroom/ziroomcustomer/sublet/activity/SubletReservationConfirmActivity:r	Lcom/ziroom/ziroomcustomer/sublet/model/SubletReservationInfo;
        //   24: ifnull +16 -> 40
        //   27: aload_0
        //   28: getfield 26	com/ziroom/ziroomcustomer/sublet/activity/SubletReservationConfirmActivity$7:a	Lcom/ziroom/ziroomcustomer/sublet/activity/SubletReservationConfirmActivity;
        //   31: getfield 46	com/ziroom/ziroomcustomer/sublet/activity/SubletReservationConfirmActivity:r	Lcom/ziroom/ziroomcustomer/sublet/model/SubletReservationInfo;
        //   34: getfield 52	com/ziroom/ziroomcustomer/sublet/model/SubletReservationInfo:data	Lcom/ziroom/ziroomcustomer/sublet/model/SubletReservationInfo$DataBean;
        //   37: ifnonnull +4 -> 41
        //   40: return
        //   41: ldc 54
        //   43: aload_0
        //   44: getfield 26	com/ziroom/ziroomcustomer/sublet/activity/SubletReservationConfirmActivity$7:a	Lcom/ziroom/ziroomcustomer/sublet/activity/SubletReservationConfirmActivity;
        //   47: getfield 58	com/ziroom/ziroomcustomer/sublet/activity/SubletReservationConfirmActivity:u	Ljava/lang/String;
        //   50: invokevirtual 64	java/lang/String:equals	(Ljava/lang/Object;)Z
        //   53: ifeq +173 -> 226
        //   56: aload_0
        //   57: getfield 26	com/ziroom/ziroomcustomer/sublet/activity/SubletReservationConfirmActivity$7:a	Lcom/ziroom/ziroomcustomer/sublet/activity/SubletReservationConfirmActivity;
        //   60: getfield 46	com/ziroom/ziroomcustomer/sublet/activity/SubletReservationConfirmActivity:r	Lcom/ziroom/ziroomcustomer/sublet/model/SubletReservationInfo;
        //   63: getfield 52	com/ziroom/ziroomcustomer/sublet/model/SubletReservationInfo:data	Lcom/ziroom/ziroomcustomer/sublet/model/SubletReservationInfo$DataBean;
        //   66: getfield 69	com/ziroom/ziroomcustomer/sublet/model/SubletReservationInfo$DataBean:houseCode	Ljava/lang/String;
        //   69: aload_0
        //   70: getfield 26	com/ziroom/ziroomcustomer/sublet/activity/SubletReservationConfirmActivity$7:a	Lcom/ziroom/ziroomcustomer/sublet/activity/SubletReservationConfirmActivity;
        //   73: getfield 46	com/ziroom/ziroomcustomer/sublet/activity/SubletReservationConfirmActivity:r	Lcom/ziroom/ziroomcustomer/sublet/model/SubletReservationInfo;
        //   76: getfield 52	com/ziroom/ziroomcustomer/sublet/model/SubletReservationInfo:data	Lcom/ziroom/ziroomcustomer/sublet/model/SubletReservationInfo$DataBean;
        //   79: getfield 72	com/ziroom/ziroomcustomer/sublet/model/SubletReservationInfo$DataBean:houseType	Ljava/lang/String;
        //   82: aload_0
        //   83: getfield 26	com/ziroom/ziroomcustomer/sublet/activity/SubletReservationConfirmActivity$7:a	Lcom/ziroom/ziroomcustomer/sublet/activity/SubletReservationConfirmActivity;
        //   86: getfield 46	com/ziroom/ziroomcustomer/sublet/activity/SubletReservationConfirmActivity:r	Lcom/ziroom/ziroomcustomer/sublet/model/SubletReservationInfo;
        //   89: getfield 52	com/ziroom/ziroomcustomer/sublet/model/SubletReservationInfo:data	Lcom/ziroom/ziroomcustomer/sublet/model/SubletReservationInfo$DataBean;
        //   92: getfield 75	com/ziroom/ziroomcustomer/sublet/model/SubletReservationInfo$DataBean:houseId	Ljava/lang/String;
        //   95: invokestatic 81	com/ziroom/ziroomcustomer/e/g:buildReserveImage	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/Map;
        //   98: astore_3
        //   99: new 83	java/lang/StringBuilder
        //   102: dup
        //   103: invokespecial 84	java/lang/StringBuilder:<init>	()V
        //   106: getstatic 89	com/ziroom/ziroomcustomer/e/q:s	Ljava/lang/String;
        //   109: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   112: getstatic 98	com/ziroom/ziroomcustomer/e/e$m:e	Ljava/lang/String;
        //   115: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   118: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   121: astore_2
        //   122: aload_3
        //   123: ifnull +7 -> 130
        //   126: aload_3
        //   127: invokestatic 106	com/ziroom/ziroomcustomer/e/g:appendCommenParams	(Ljava/util/Map;)V
        //   130: aload_3
        //   131: ifnull +155 -> 286
        //   134: aload_3
        //   135: invokeinterface 112 1 0
        //   140: ifne +146 -> 286
        //   143: aload_3
        //   144: invokeinterface 116 1 0
        //   149: invokeinterface 122 1 0
        //   154: astore 5
        //   156: aload 5
        //   158: invokeinterface 127 1 0
        //   163: ifeq +123 -> 286
        //   166: aload 5
        //   168: invokeinterface 131 1 0
        //   173: checkcast 133	java/util/Map$Entry
        //   176: astore 6
        //   178: aload 6
        //   180: invokeinterface 136 1 0
        //   185: ifnull -29 -> 156
        //   188: aload 4
        //   190: new 138	org/apache/http/message/BasicNameValuePair
        //   193: dup
        //   194: aload 6
        //   196: invokeinterface 141 1 0
        //   201: checkcast 60	java/lang/String
        //   204: aload 6
        //   206: invokeinterface 136 1 0
        //   211: invokevirtual 142	java/lang/Object:toString	()Ljava/lang/String;
        //   214: invokespecial 145	org/apache/http/message/BasicNameValuePair:<init>	(Ljava/lang/String;Ljava/lang/String;)V
        //   217: invokeinterface 150 2 0
        //   222: pop
        //   223: goto -67 -> 156
        //   226: ldc -104
        //   228: aload_0
        //   229: getfield 26	com/ziroom/ziroomcustomer/sublet/activity/SubletReservationConfirmActivity$7:a	Lcom/ziroom/ziroomcustomer/sublet/activity/SubletReservationConfirmActivity;
        //   232: getfield 58	com/ziroom/ziroomcustomer/sublet/activity/SubletReservationConfirmActivity:u	Ljava/lang/String;
        //   235: invokevirtual 64	java/lang/String:equals	(Ljava/lang/Object;)Z
        //   238: ifeq +346 -> 584
        //   241: aload_0
        //   242: getfield 26	com/ziroom/ziroomcustomer/sublet/activity/SubletReservationConfirmActivity$7:a	Lcom/ziroom/ziroomcustomer/sublet/activity/SubletReservationConfirmActivity;
        //   245: getfield 46	com/ziroom/ziroomcustomer/sublet/activity/SubletReservationConfirmActivity:r	Lcom/ziroom/ziroomcustomer/sublet/model/SubletReservationInfo;
        //   248: getfield 52	com/ziroom/ziroomcustomer/sublet/model/SubletReservationInfo:data	Lcom/ziroom/ziroomcustomer/sublet/model/SubletReservationInfo$DataBean;
        //   251: getfield 75	com/ziroom/ziroomcustomer/sublet/model/SubletReservationInfo$DataBean:houseId	Ljava/lang/String;
        //   254: ldc -102
        //   256: invokestatic 158	com/ziroom/ziroomcustomer/e/g:buildReserveImageByType	(Ljava/lang/String;Ljava/lang/String;)Ljava/util/Map;
        //   259: astore_3
        //   260: new 83	java/lang/StringBuilder
        //   263: dup
        //   264: invokespecial 84	java/lang/StringBuilder:<init>	()V
        //   267: getstatic 89	com/ziroom/ziroomcustomer/e/q:s	Ljava/lang/String;
        //   270: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   273: getstatic 163	com/ziroom/ziroomcustomer/e/e$q:t	Ljava/lang/String;
        //   276: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   279: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   282: astore_2
        //   283: goto -161 -> 122
        //   286: new 165	org/apache/http/client/methods/HttpPost
        //   289: dup
        //   290: aload_2
        //   291: invokespecial 168	org/apache/http/client/methods/HttpPost:<init>	(Ljava/lang/String;)V
        //   294: astore 5
        //   296: ldc -86
        //   298: new 83	java/lang/StringBuilder
        //   301: dup
        //   302: invokespecial 84	java/lang/StringBuilder:<init>	()V
        //   305: aload_2
        //   306: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   309: aload_3
        //   310: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //   313: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   316: invokestatic 177	com/ziroom/ziroomcustomer/util/u:e	(Ljava/lang/String;Ljava/lang/String;)V
        //   319: new 179	org/apache/http/impl/client/DefaultHttpClient
        //   322: dup
        //   323: invokespecial 180	org/apache/http/impl/client/DefaultHttpClient:<init>	()V
        //   326: astore_3
        //   327: aload 5
        //   329: new 182	org/apache/http/client/entity/UrlEncodedFormEntity
        //   332: dup
        //   333: aload 4
        //   335: ldc -72
        //   337: invokespecial 187	org/apache/http/client/entity/UrlEncodedFormEntity:<init>	(Ljava/util/List;Ljava/lang/String;)V
        //   340: invokevirtual 191	org/apache/http/client/methods/HttpPost:setEntity	(Lorg/apache/http/HttpEntity;)V
        //   343: aload_3
        //   344: instanceof 193
        //   347: ifne +187 -> 534
        //   350: aload_3
        //   351: aload 5
        //   353: invokevirtual 197	org/apache/http/impl/client/DefaultHttpClient:execute	(Lorg/apache/http/client/methods/HttpUriRequest;)Lorg/apache/http/HttpResponse;
        //   356: astore_2
        //   357: aload_2
        //   358: invokeinterface 203 1 0
        //   363: invokeinterface 209 1 0
        //   368: istore_1
        //   369: aload_0
        //   370: getfield 26	com/ziroom/ziroomcustomer/sublet/activity/SubletReservationConfirmActivity$7:a	Lcom/ziroom/ziroomcustomer/sublet/activity/SubletReservationConfirmActivity;
        //   373: invokevirtual 212	com/ziroom/ziroomcustomer/sublet/activity/SubletReservationConfirmActivity:dismissProgress	()V
        //   376: iload_1
        //   377: sipush 200
        //   380: if_icmpne +167 -> 547
        //   383: aload_2
        //   384: invokeinterface 216 1 0
        //   389: invokeinterface 222 1 0
        //   394: astore_2
        //   395: aload_3
        //   396: invokevirtual 226	org/apache/http/impl/client/DefaultHttpClient:getCookieStore	()Lorg/apache/http/client/CookieStore;
        //   399: invokeinterface 232 1 0
        //   404: astore_3
        //   405: iconst_0
        //   406: istore_1
        //   407: iload_1
        //   408: aload_3
        //   409: invokeinterface 235 1 0
        //   414: if_icmpge +49 -> 463
        //   417: ldc -19
        //   419: aload_3
        //   420: iload_1
        //   421: invokeinterface 241 2 0
        //   426: checkcast 243	org/apache/http/cookie/Cookie
        //   429: invokeinterface 246 1 0
        //   434: invokevirtual 64	java/lang/String:equals	(Ljava/lang/Object;)Z
        //   437: ifeq +154 -> 591
        //   440: aload_0
        //   441: getfield 26	com/ziroom/ziroomcustomer/sublet/activity/SubletReservationConfirmActivity$7:a	Lcom/ziroom/ziroomcustomer/sublet/activity/SubletReservationConfirmActivity;
        //   444: aload_3
        //   445: iload_1
        //   446: invokeinterface 241 2 0
        //   451: checkcast 243	org/apache/http/cookie/Cookie
        //   454: invokeinterface 248 1 0
        //   459: invokestatic 252	com/ziroom/ziroomcustomer/sublet/activity/SubletReservationConfirmActivity:b	(Lcom/ziroom/ziroomcustomer/sublet/activity/SubletReservationConfirmActivity;Ljava/lang/String;)Ljava/lang/String;
        //   462: pop
        //   463: aload_0
        //   464: getfield 26	com/ziroom/ziroomcustomer/sublet/activity/SubletReservationConfirmActivity$7:a	Lcom/ziroom/ziroomcustomer/sublet/activity/SubletReservationConfirmActivity;
        //   467: aload_2
        //   468: invokestatic 258	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
        //   471: invokestatic 261	com/ziroom/ziroomcustomer/sublet/activity/SubletReservationConfirmActivity:a	(Lcom/ziroom/ziroomcustomer/sublet/activity/SubletReservationConfirmActivity;Landroid/graphics/Bitmap;)Landroid/graphics/Bitmap;
        //   474: pop
        //   475: aload_2
        //   476: invokevirtual 266	java/io/InputStream:close	()V
        //   479: aload_0
        //   480: getfield 26	com/ziroom/ziroomcustomer/sublet/activity/SubletReservationConfirmActivity$7:a	Lcom/ziroom/ziroomcustomer/sublet/activity/SubletReservationConfirmActivity;
        //   483: invokestatic 270	com/ziroom/ziroomcustomer/sublet/activity/SubletReservationConfirmActivity:f	(Lcom/ziroom/ziroomcustomer/sublet/activity/SubletReservationConfirmActivity;)Landroid/os/Handler;
        //   486: iconst_5
        //   487: invokevirtual 276	android/os/Handler:sendEmptyMessage	(I)Z
        //   490: pop
        //   491: return
        //   492: astore_2
        //   493: aload_0
        //   494: getfield 26	com/ziroom/ziroomcustomer/sublet/activity/SubletReservationConfirmActivity$7:a	Lcom/ziroom/ziroomcustomer/sublet/activity/SubletReservationConfirmActivity;
        //   497: new 15	com/ziroom/ziroomcustomer/sublet/activity/SubletReservationConfirmActivity$7$2
        //   500: dup
        //   501: aload_0
        //   502: invokespecial 279	com/ziroom/ziroomcustomer/sublet/activity/SubletReservationConfirmActivity$7$2:<init>	(Lcom/ziroom/ziroomcustomer/sublet/activity/SubletReservationConfirmActivity$7;)V
        //   505: invokevirtual 283	com/ziroom/ziroomcustomer/sublet/activity/SubletReservationConfirmActivity:runOnUiThread	(Ljava/lang/Runnable;)V
        //   508: aload_2
        //   509: invokevirtual 286	org/apache/http/client/ClientProtocolException:printStackTrace	()V
        //   512: return
        //   513: astore_2
        //   514: aload_0
        //   515: getfield 26	com/ziroom/ziroomcustomer/sublet/activity/SubletReservationConfirmActivity$7:a	Lcom/ziroom/ziroomcustomer/sublet/activity/SubletReservationConfirmActivity;
        //   518: new 19	com/ziroom/ziroomcustomer/sublet/activity/SubletReservationConfirmActivity$7$4
        //   521: dup
        //   522: aload_0
        //   523: invokespecial 287	com/ziroom/ziroomcustomer/sublet/activity/SubletReservationConfirmActivity$7$4:<init>	(Lcom/ziroom/ziroomcustomer/sublet/activity/SubletReservationConfirmActivity$7;)V
        //   526: invokevirtual 283	com/ziroom/ziroomcustomer/sublet/activity/SubletReservationConfirmActivity:runOnUiThread	(Ljava/lang/Runnable;)V
        //   529: aload_2
        //   530: invokevirtual 288	java/lang/Exception:printStackTrace	()V
        //   533: return
        //   534: aload_3
        //   535: checkcast 193	org/apache/http/client/HttpClient
        //   538: aload 5
        //   540: invokestatic 293	com/mato/sdk/instrumentation/ApacheHttpClientInstrumentation:execute	(Lorg/apache/http/client/HttpClient;Lorg/apache/http/client/methods/HttpUriRequest;)Lorg/apache/http/HttpResponse;
        //   543: astore_2
        //   544: goto -187 -> 357
        //   547: aload_0
        //   548: getfield 26	com/ziroom/ziroomcustomer/sublet/activity/SubletReservationConfirmActivity$7:a	Lcom/ziroom/ziroomcustomer/sublet/activity/SubletReservationConfirmActivity;
        //   551: new 13	com/ziroom/ziroomcustomer/sublet/activity/SubletReservationConfirmActivity$7$1
        //   554: dup
        //   555: aload_0
        //   556: invokespecial 294	com/ziroom/ziroomcustomer/sublet/activity/SubletReservationConfirmActivity$7$1:<init>	(Lcom/ziroom/ziroomcustomer/sublet/activity/SubletReservationConfirmActivity$7;)V
        //   559: invokevirtual 283	com/ziroom/ziroomcustomer/sublet/activity/SubletReservationConfirmActivity:runOnUiThread	(Ljava/lang/Runnable;)V
        //   562: return
        //   563: astore_2
        //   564: aload_0
        //   565: getfield 26	com/ziroom/ziroomcustomer/sublet/activity/SubletReservationConfirmActivity$7:a	Lcom/ziroom/ziroomcustomer/sublet/activity/SubletReservationConfirmActivity;
        //   568: new 17	com/ziroom/ziroomcustomer/sublet/activity/SubletReservationConfirmActivity$7$3
        //   571: dup
        //   572: aload_0
        //   573: invokespecial 295	com/ziroom/ziroomcustomer/sublet/activity/SubletReservationConfirmActivity$7$3:<init>	(Lcom/ziroom/ziroomcustomer/sublet/activity/SubletReservationConfirmActivity$7;)V
        //   576: invokevirtual 283	com/ziroom/ziroomcustomer/sublet/activity/SubletReservationConfirmActivity:runOnUiThread	(Ljava/lang/Runnable;)V
        //   579: aload_2
        //   580: invokevirtual 296	java/io/IOException:printStackTrace	()V
        //   583: return
        //   584: ldc_w 298
        //   587: astore_2
        //   588: goto -466 -> 122
        //   591: iload_1
        //   592: iconst_1
        //   593: iadd
        //   594: istore_1
        //   595: goto -188 -> 407
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	598	0	this	7
        //   368	227	1	i	int
        //   121	355	2	localObject1	Object
        //   492	17	2	localClientProtocolException	org.apache.http.client.ClientProtocolException
        //   513	17	2	localException	Exception
        //   543	1	2	localHttpResponse	org.apache.http.HttpResponse
        //   563	17	2	localIOException	java.io.IOException
        //   587	1	2	str	String
        //   16	519	3	localObject2	Object
        //   7	327	4	localArrayList	ArrayList
        //   154	385	5	localObject3	Object
        //   176	29	6	localEntry	java.util.Map.Entry
        // Exception table:
        //   from	to	target	type
        //   343	357	492	org/apache/http/client/ClientProtocolException
        //   357	376	492	org/apache/http/client/ClientProtocolException
        //   383	405	492	org/apache/http/client/ClientProtocolException
        //   407	463	492	org/apache/http/client/ClientProtocolException
        //   463	491	492	org/apache/http/client/ClientProtocolException
        //   534	544	492	org/apache/http/client/ClientProtocolException
        //   547	562	492	org/apache/http/client/ClientProtocolException
        //   286	343	513	java/lang/Exception
        //   343	357	513	java/lang/Exception
        //   357	376	513	java/lang/Exception
        //   383	405	513	java/lang/Exception
        //   407	463	513	java/lang/Exception
        //   463	491	513	java/lang/Exception
        //   493	512	513	java/lang/Exception
        //   534	544	513	java/lang/Exception
        //   547	562	513	java/lang/Exception
        //   564	583	513	java/lang/Exception
        //   343	357	563	java/io/IOException
        //   357	376	563	java/io/IOException
        //   383	405	563	java/io/IOException
        //   407	463	563	java/io/IOException
        //   463	491	563	java/io/IOException
        //   534	544	563	java/io/IOException
        //   547	562	563	java/io/IOException
      }
    }).start();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130905159);
    ButterKnife.bind(this);
    this.s = this;
    a();
    b();
  }
  
  public void onSign()
  {
    Object localObject2 = LayoutInflater.from(this.s).inflate(2130905132, null);
    this.B = new Dialog(this.s, 2131427781);
    this.B.setContentView((View)localObject2);
    this.C = ((TextView)((View)localObject2).findViewById(2131697541));
    this.y = ((ImageView)((View)localObject2).findViewById(2131697540));
    this.z = ((EditText)((View)localObject2).findViewById(2131694428));
    Object localObject1 = (TextView)((View)localObject2).findViewById(2131697195);
    localObject2 = (TextView)((View)localObject2).findViewById(2131697542);
    this.y.setOnClickListener(new View.OnClickListener()
    {
      @com.growingio.android.sdk.instrumentation.Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        SubletReservationConfirmActivity.a(SubletReservationConfirmActivity.this, null);
        SubletReservationConfirmActivity.this.showProgress("");
        SubletReservationConfirmActivity.this.getYanzhengmaBitmap();
      }
    });
    ((TextView)localObject2).setOnClickListener(this.A);
    ((TextView)localObject1).setOnClickListener(this.A);
    this.D = null;
    localObject1 = this.B;
    if (!(localObject1 instanceof Dialog)) {
      ((Dialog)localObject1).show();
    }
    for (;;)
    {
      getYanzhengmaBitmap();
      return;
      VdsAgent.showDialog((Dialog)localObject1);
    }
  }
  
  @OnClick({2131689492, 2131691990, 2131697612})
  public void onViewClicked(View paramView)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      return;
      finish();
      return;
      ah.callPhone(this, this.d);
      return;
    } while ((this.r == null) || (this.r.data == null));
    if ((2 == this.x) && ("QRYD".equals(this.u)))
    {
      onSign();
      return;
    }
    if ("ZZYD".equals(this.u)) {
      this.v = new com.ziroom.ziroomcustomer.util.a.a(this.r.data.uid, this.r.data.userName, com.ziroom.ziroomcustomer.util.a.c.certTypeToName(this.r.data.certType), this.r.data.certNum);
    }
    for (;;)
    {
      showProgress("");
      a(this.f, this.u, this.r.data.houseSourceCode);
      return;
      if ("QRYD".equals(this.u)) {
        this.v = new com.ziroom.ziroomcustomer.util.a.a(this.r.data.subtenantUid, this.r.data.subtenantUserName, com.ziroom.ziroomcustomer.util.a.c.certTypeToName(this.r.data.subtenantCertType), this.r.data.subtenantCertNum);
      }
    }
  }
  
  public void updateView()
  {
    if ("ZZYD".equals(this.u))
    {
      this.e = this.r.data.rentPromptMsg;
      this.iblReservatorInfo.initData("租客信息", this.a);
      this.iblInitiatorInfo.initData("发起者信息", this.c);
      this.iblHouseInfo.initData("房源信息", this.b);
      if (!ae.isNull(this.e)) {
        break label153;
      }
      this.tvDateDesc.setVisibility(8);
    }
    for (;;)
    {
      if (!ae.isNull(this.d)) {
        break label175;
      }
      this.tvContactKeeper.setVisibility(8);
      return;
      this.e = this.r.data.subtenantPromptMsg;
      this.iblReservatorInfo.initData("发起者信息", this.c);
      this.iblInitiatorInfo.initData("租客信息", this.a);
      break;
      label153:
      this.tvDateDesc.setVisibility(0);
      this.tvDateDesc.setText(this.e);
    }
    label175:
    this.tvContactKeeper.setVisibility(0);
  }
  
  class a
    implements i.a<String>
  {
    a() {}
    
    public void onParse(String paramString, k paramk) {}
    
    public void onSuccess(k paramk) {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/sublet/activity/SubletReservationConfirmActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */