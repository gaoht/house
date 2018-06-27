package com.ziroom.ziroomcustomer.contract;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.alibaba.fastjson.e;
import com.freelxl.baselibrary.d.b.c;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.itrus.raapi.implement.ClientForAndroid;
import com.itrus.raapi.implement.certInfo;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.a.f;
import com.ziroom.ziroomcustomer.e.c.o;
import com.ziroom.ziroomcustomer.e.d;
import com.ziroom.ziroomcustomer.e.e.n;
import com.ziroom.ziroomcustomer.e.l;
import com.ziroom.ziroomcustomer.e.q;
import com.ziroom.ziroomcustomer.model.IkeyRaConfig;
import com.ziroom.ziroomcustomer.signed.BoundCardActivity;
import com.ziroom.ziroomcustomer.signed.ContractTermsActivity;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.util.ah;
import com.ziroom.ziroomcustomer.util.m;
import com.ziroom.ziroomcustomer.util.u;
import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ContractDataActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private boolean A = true;
  private Handler B = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      switch (paramAnonymousMessage.what)
      {
      default: 
        return;
      case 69746: 
        ContractDataActivity.a(ContractDataActivity.this).setEnabled(true);
        ContractDataActivity.this.dismissProgress();
        paramAnonymousMessage = (l)paramAnonymousMessage.obj;
        if (paramAnonymousMessage.getSuccess().booleanValue())
        {
          if ("2".equals(((b)paramAnonymousMessage.getObject()).getRenew_state()))
          {
            ContractDataActivity.a(ContractDataActivity.this, new HashMap());
            ContractDataActivity.c(ContractDataActivity.this).put("name", ContractDataActivity.b(ContractDataActivity.this).getUserName());
            ContractDataActivity.c(ContractDataActivity.this).put("mCerType2", ContractDataActivity.b(ContractDataActivity.this).getCertType() + "");
            ContractDataActivity.c(ContractDataActivity.this).put("cerNum", ContractDataActivity.b(ContractDataActivity.this).getCertNum());
            d.getRaConfig(ContractDataActivity.this, ContractDataActivity.d(ContractDataActivity.this));
            ContractDataActivity.this.showProgressNoCancel("", 100000L);
            return;
          }
          ContractDataActivity.this.showToast("抱歉，出错了，请稍后再试！");
          return;
        }
        ContractDataActivity.this.showToast(paramAnonymousMessage.getMessage());
        return;
      case 69745: 
        ContractDataActivity.this.dismissProgress();
        paramAnonymousMessage = (l)paramAnonymousMessage.obj;
        if (paramAnonymousMessage.getSuccess().booleanValue())
        {
          ContractDataActivity.a(ContractDataActivity.this, (a)paramAnonymousMessage.getObject());
          ContractDataActivity.this.initView();
          return;
        }
        ContractDataActivity.this.showToast(paramAnonymousMessage.getMessage());
        return;
      case 69699: 
        paramAnonymousMessage = (l)paramAnonymousMessage.obj;
        if (paramAnonymousMessage.getSuccess().booleanValue())
        {
          ContractDataActivity.e(ContractDataActivity.this);
          return;
        }
        d.errorLog(ContractDataActivity.this, "获取RA配置信息失败", paramAnonymousMessage.getMessage());
        ContractDataActivity.this.dismissProgress();
        return;
      }
      ContractDataActivity.this.dismissProgress();
      if ("1".equals(ContractDataActivity.b(ContractDataActivity.this).getIsZWhite()))
      {
        ContractDataActivity.this.dismissProgress();
        com.freelxl.baselibrary.d.a.isLog(true);
        paramAnonymousMessage = new HashMap();
        paramAnonymousMessage.put("outcontractCode", ContractDataActivity.b(ContractDataActivity.this).getRenewContractCode());
        paramAnonymousMessage.put("interfaceId", "57");
        com.ziroom.ziroomcustomer.e.g.appendCommenParamsString(paramAnonymousMessage);
        com.freelxl.baselibrary.d.a.post(q.s + e.n.X).tag(this).params(paramAnonymousMessage).enqueue(new f(ContractDataActivity.this, new o())
        {
          public void onSuccess(int paramAnonymous2Int, e paramAnonymous2e)
          {
            super.onSuccess(paramAnonymous2Int, paramAnonymous2e);
            paramAnonymous2e = new Intent(ContractDataActivity.this.getApplicationContext(), BoundCardActivity.class);
            paramAnonymous2e.putExtra("is_pre_bind", false);
            paramAnonymous2e.putExtra("mBoundCardType", 2);
            paramAnonymous2e.putExtra("contract_code", ContractDataActivity.b(ContractDataActivity.this).getRenewContractCode());
            paramAnonymous2e.putExtra("old_contract_code", ContractDataActivity.f(ContractDataActivity.this));
            paramAnonymous2e.putExtra("cityCode", ContractDataActivity.g(ContractDataActivity.this));
            ContractDataActivity.this.startActivity(paramAnonymous2e);
          }
        });
        return;
      }
      paramAnonymousMessage = new Intent(ContractDataActivity.h(ContractDataActivity.this), ContractTermsActivity.class);
      paramAnonymousMessage.putExtra("old_contract_code", ContractDataActivity.f(ContractDataActivity.this));
      paramAnonymousMessage.putExtra("cityCode", ContractDataActivity.g(ContractDataActivity.this));
      ContractDataActivity.this.startActivity(paramAnonymousMessage);
    }
  };
  private Thread C;
  private boolean D = true;
  private Context a;
  private TextView b;
  private TextView c;
  private TextView d;
  private TextView e;
  private TextView f;
  private TextView g;
  private TextView r;
  private TextView s;
  private TextView t;
  private TextView u;
  private a v;
  private String w;
  private com.ziroom.ziroomcustomer.c.a x;
  private HashMap<String, String> y;
  private String z;
  
  private void a(final HashMap<String, String> paramHashMap)
  {
    try
    {
      this.C = new Thread(new Runnable()
      {
        public void run()
        {
          u.d("ikey", "正在生成CSR");
          u.d("ikey", "android.os.Build.MODEL===" + Build.MODEL);
          u.d("ikey", "map.get(name)===" + (String)paramHashMap.get("name"));
          try
          {
            Thread.sleep(1000L);
            String str = ApplicationEx.c.k.GenCSR(Build.MODEL, (String)paramHashMap.get("name"), "", "", "", 1024, "RSA");
            if (TextUtils.isEmpty(str)) {
              if ((ContractDataActivity.i(ContractDataActivity.this)) && (ContractDataActivity.j(ContractDataActivity.this)))
              {
                ContractDataActivity.a(ContractDataActivity.this, false);
                ContractDataActivity.b(ContractDataActivity.this, true);
                ContractDataActivity.e(ContractDataActivity.this);
                return;
              }
            }
          }
          catch (InterruptedException localInterruptedException)
          {
            for (;;)
            {
              localInterruptedException.printStackTrace();
            }
            d.errorLog(ContractDataActivity.this, "生成CSR失败", "操作失败!!" + ApplicationEx.c.k.GetLastErrInfo());
            ContractDataActivity.this.dismissProgress();
            ContractDataActivity.this.runOnUiThread(new Runnable()
            {
              public void run()
              {
                ContractDataActivity.this.showToast("无纸化出现异常,请稍后再试!");
              }
            });
            return;
          }
          u.d("ikey", "CSR生成成功!! 正在申请证书...");
          com.itrus.raapi.implement.UserInfo localUserInfo = new com.itrus.raapi.implement.UserInfo();
          localUserInfo.setUserAdditionalField1(ApplicationEx.c.getUserId(ContractDataActivity.this));
          localUserInfo.setUserName((String)paramHashMap.get("name"));
          localUserInfo.setUserSurname((String)paramHashMap.get("cerNum"));
          localUserInfo.setUserAdditionalField2(ContractDataActivity.a(ContractDataActivity.this, Integer.parseInt(((String)paramHashMap.get("mCerType2")).toString())));
          u.d("ikey", "name===" + (String)paramHashMap.get("name"));
          u.d("ikey", "cerNum===" + (String)paramHashMap.get("cerNum"));
          Bundle localBundle = new Bundle();
          localBundle.putSerializable("UserInfo", localUserInfo);
          localBundle.putString("CSR", localInterruptedException);
          localBundle.putString("PassPort", "");
          localBundle.putString("CHALLENGE", ApplicationEx.c.getRaConfig().getStrChangllege());
          localBundle.putString("Time", "1");
          new ContractDataActivity.a(ContractDataActivity.this, null).execute(new Bundle[] { localBundle });
        }
      });
      this.C.start();
      return;
    }
    finally
    {
      paramHashMap = finally;
      throw paramHashMap;
    }
  }
  
  private boolean a()
  {
    boolean bool = false;
    String[] arrayOfString = new String[3];
    arrayOfString[0] = "cert9.db";
    arrayOfString[1] = "itrusChina.db";
    arrayOfString[2] = "key4.db";
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      Object localObject = arrayOfString[i];
      localObject = new File(getApplicationContext().getFilesDir().getAbsolutePath() + "/" + (String)localObject);
      if (((File)localObject).exists()) {
        bool = ((File)localObject).delete();
      }
      i += 1;
    }
    return bool;
  }
  
  private String b(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "";
    case 1: 
      return "身份证 ";
    case 2: 
      return "护照 ";
    case 13: 
      return "港澳居民来往通行证 ";
    }
    return "台湾居民来往通行证 ";
  }
  
  private boolean b()
  {
    boolean bool = false;
    String[] arrayOfString = new String[3];
    arrayOfString[0] = "cert9.db";
    arrayOfString[1] = "itrusChina.db";
    arrayOfString[2] = "key4.db";
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      Object localObject = arrayOfString[i];
      localObject = new File(getApplicationContext().getFilesDir().getAbsolutePath() + "/db/" + (String)localObject);
      if (((File)localObject).exists()) {
        bool = ((File)localObject).delete();
      }
      i += 1;
    }
    return bool;
  }
  
  private void d(String paramString)
  {
    try
    {
      if (Long.valueOf(m.getDaysBetween(new Date(System.currentTimeMillis()), new Date(f()))).longValue() < 0L)
      {
        ApplicationEx.c.k.DeleteCertBySerialNumber(ApplicationEx.c.k.GetCertSerialNumber(paramString));
        a(this.y);
        return;
      }
      paramString = this.B.obtainMessage();
      paramString.what = 69700;
      this.B.sendMessage(paramString);
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private void e()
  {
    if (!g())
    {
      dismissProgress();
      d.errorLog(this, "无纸化错误", ApplicationEx.c.k.GetLastErrInfo());
      return;
    }
    this.x = new com.ziroom.ziroomcustomer.c.a(ApplicationEx.c.getRaConfig().getWebsite(), ApplicationEx.c.getRaConfig().getAccounthash(), this);
    if (ApplicationEx.c.k == null) {
      ApplicationEx.c.k = ClientForAndroid.getInstance(this);
    }
    String[] arrayOfString = ApplicationEx.c.k.FilterCert("", "", "", 0, 0);
    if (arrayOfString.length < 1)
    {
      u.d("ikey", "过滤证书失败!!!");
      a(this.y);
      return;
    }
    int k = arrayOfString.length;
    int i = 0;
    for (;;)
    {
      Object localObject1;
      if (i < k)
      {
        localObject1 = arrayOfString[i];
        if (TextUtils.isEmpty(ApplicationEx.c.getUser().getUid())) {}
      }
      else
      {
        try
        {
          Object localObject4 = ApplicationEx.c.k.GetCertAttribute((String)localObject1).Subject.split(",");
          String str = localObject4[0].split("=")[1];
          Object localObject2 = localObject4[1].split("=")[1].replace("\"", "");
          Object localObject3 = localObject4[2].split(":")[1];
          localObject4 = localObject4[5].split("=")[1];
          if ((ApplicationEx.c.getUser().getUid().equals(localObject3)) && (((String)this.y.get("name")).equals(localObject4)) && (b(Integer.parseInt((String)this.y.get("mCerType2"))).equals(localObject2)) && (((String)this.y.get("cerNum")).equals(str)))
          {
            u.d("ikey", "证书主题为:" + ApplicationEx.c.k.GetCertAttribute((String)localObject1).toString());
            d((String)localObject1);
            u.d("ikey", "同一用户");
          }
          for (;;)
          {
            delRepetition(arrayOfString);
            return;
            u.d("ikey", "不同用户");
            a(this.y);
          }
          int j;
          i += 1;
        }
        catch (Exception localException)
        {
          localObject1 = localException.getCause();
          localObject2 = new StringBuffer();
          while (localObject1 != null)
          {
            localObject3 = ((Throwable)localObject1).getStackTrace();
            ((StringBuffer)localObject2).append("\n");
            ((StringBuffer)localObject2).append(localObject1);
            j = 0;
            while (j < localObject3.length)
            {
              ((StringBuffer)localObject2).append("\nError:" + localObject3[j].toString());
              j += 1;
            }
            localObject1 = ((Throwable)localObject1).getCause();
          }
          dismissProgress();
          d.errorLog(this, localException.getMessage(), ((StringBuffer)localObject2).toString());
        }
      }
    }
  }
  
  private String f()
  {
    Object localObject1 = ApplicationEx.c.k.FilterCert("", "", "", 0, 0);
    if (localObject1.length > 0)
    {
      localObject1 = ApplicationEx.c.k.GetCertAttribute(localObject1[0]).toString().split(",");
      if (localObject1.length > 15)
      {
        Object localObject2 = localObject1[15];
        localObject1 = localObject2;
        if (((String)localObject2).trim().startsWith("ValidTo")) {
          localObject1 = ((String)localObject2).replace("ValidTo=", "");
        }
        return (String)localObject1;
      }
    }
    return null;
  }
  
  private boolean g()
  {
    if (ApplicationEx.c.k == null) {
      ApplicationEx.c.k = ClientForAndroid.getInstance(this);
    }
    a();
    if (ApplicationEx.c.k.SetLicense(ApplicationEx.c.getRaConfig().getLicense()) == 0)
    {
      if (this.D)
      {
        ApplicationEx.c.k.SetSystemDBDir(getApplicationContext().getFilesDir().getAbsolutePath() + "/db/");
        File localFile = new File(getApplicationContext().getFilesDir().getAbsolutePath() + "/db/");
        if (!localFile.exists()) {
          localFile.mkdirs();
        }
        boolean bool = h();
        if (bool) {
          this.D = false;
        }
        return bool;
      }
      return true;
    }
    return false;
  }
  
  private boolean h()
  {
    boolean bool1 = true;
    boolean bool2 = false;
    int i = ApplicationEx.c.k.VerifyUserPIN(Build.MODEL, "111", 5);
    if (i == 3)
    {
      bool1 = bool2;
      if (ApplicationEx.c.k.CSetAdminPIN("", "123", 0) == 0)
      {
        bool1 = bool2;
        if (ApplicationEx.c.k.CInitUserPIN("123", "111") == 0)
        {
          bool1 = bool2;
          if (ApplicationEx.c.k.VerifyUserPIN(Build.MODEL, "111", 5) == 0) {
            bool1 = true;
          }
        }
      }
      return bool1;
    }
    if (i == 1)
    {
      if ((b()) && (this.A))
      {
        this.A = false;
        e();
        return false;
      }
      d.errorLog(this, "初始化pin失败", "操作失败!!" + ApplicationEx.c.k.GetLastErrInfo());
      dismissProgress();
      showToast("无纸化出现异常,请稍后再试!");
      return false;
    }
    if (i == 0) {}
    for (;;)
    {
      return bool1;
      bool1 = false;
    }
  }
  
  public void delRepetition(String[] paramArrayOfString)
  {
    u.d("ikey", "去除证书重复!");
    if (paramArrayOfString.length <= 1) {
      return;
    }
    for (;;)
    {
      int i;
      try
      {
        int j = paramArrayOfString.length;
        i = 0;
        if (i >= j) {
          break;
        }
        String str1 = paramArrayOfString[i];
        if (!TextUtils.isEmpty(ApplicationEx.c.getUser().getUid()))
        {
          Object localObject = ApplicationEx.c.k.GetCertAttribute(str1).Subject.split(",");
          String str2 = localObject[0].split("=")[1];
          String str3 = localObject[1].split("=")[1].replace("\"", "");
          String str4 = localObject[2].split(":")[1];
          localObject = localObject[5].split("=")[1];
          if ((ApplicationEx.c.getUser().getUid().equals(str4)) && (((String)this.y.get("name")).equals(localObject)) && (b(Integer.parseInt((String)this.y.get("mCerType2"))).equals(str3)) && (((String)this.y.get("cerNum")).equals(str2)))
          {
            u.d("ikey", "相同证书");
          }
          else
          {
            ApplicationEx.c.k.DeleteCertBySerialNumber(ApplicationEx.c.k.GetCertSerialNumber(str1));
            u.d("ikey", "删除证书");
          }
        }
      }
      catch (Exception paramArrayOfString)
      {
        return;
      }
      i += 1;
    }
  }
  
  public boolean filter(a parama)
  {
    if (ae.isNull(parama.getUserName())) {}
    while ((ae.isNull(parama.getUserPhone())) || (ae.isNull(parama.getStopDate())) || (ae.isNull(parama.getSignDate())) || ((ae.isNull(parama.getPayment())) && (ae.isNull(parama.getIsBlank()))) || (ae.isNull(parama.getCertType())) || (ae.isNull(parama.getCertNum())) || (ae.isNull(parama.getAddress()))) {
      return false;
    }
    return true;
  }
  
  public void initView()
  {
    this.u = ((TextView)findViewById(2131692413));
    this.t = ((TextView)findViewById(2131693393));
    this.b = ((TextView)findViewById(2131693385));
    this.c = ((TextView)findViewById(2131693386));
    this.d = ((TextView)findViewById(2131693387));
    this.e = ((TextView)findViewById(2131693388));
    this.f = ((TextView)findViewById(2131693389));
    this.g = ((TextView)findViewById(2131693390));
    this.r = ((TextView)findViewById(2131693391));
    this.s = ((TextView)findViewById(2131693392));
    String str;
    if (this.v != null)
    {
      this.b.setText(this.v.getUserName());
      this.c.setText(this.v.getUserPhone());
      str = "";
      if (!"1".equals(this.v.getCertType())) {
        break label300;
      }
      str = "身份证";
      this.d.setText(str);
      this.e.setText(this.v.getCertNum());
      this.f.setText(this.v.getAddress());
      this.g.setText(m.StrToNorDate(this.v.getSignDate()));
      this.r.setText(m.StrToNorDate(this.v.getStopDate()));
      str = "";
      if (!"1".equals(this.v.getIsBlank())) {
        break label507;
      }
      str = "自如白条";
    }
    for (;;)
    {
      this.s.setText(str);
      return;
      label300:
      if ("2".equals(this.v.getCertType()))
      {
        str = "护照";
        break;
      }
      if ("3".equals(this.v.getCertType()))
      {
        str = "军官证";
        break;
      }
      if ("5".equals(this.v.getCertType()))
      {
        str = "驾驶证";
        break;
      }
      if ("6".equals(this.v.getCertType()))
      {
        str = "台胞证";
        break;
      }
      if ("7".equals(this.v.getCertType()))
      {
        str = "社保卡";
        break;
      }
      if ("12".equals(this.v.getCertType()))
      {
        str = "营业执照";
        break;
      }
      if ("13".equals(this.v.getCertType()))
      {
        str = "港澳通行证";
        break;
      }
      if ("14".equals(this.v.getCertType()))
      {
        str = "户口本";
        break;
      }
      if (!"15".equals(this.v.getCertType())) {
        break;
      }
      str = "居住证";
      break;
      label507:
      if ("1".equals(this.v.getIsZWhite())) {
        str = "自如分期";
      } else if ("1".equals(this.v.getPayment())) {
        str = "押一付一";
      } else if ("3".equals(this.v.getPayment())) {
        str = "押一付三";
      } else if ("6".equals(this.v.getPayment())) {
        str = "押一付六";
      } else if ("12".equals(this.v.getPayment())) {
        str = "押一付十二";
      } else if ("99".equals(this.v.getPayment())) {
        str = "一次性付清";
      }
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
    case 2131693393: 
      if (filter(this.v))
      {
        this.t.setEnabled(false);
        d.getContractCodeState(this.a, this.B, this.w);
        return;
      }
      com.freelxl.baselibrary.f.g.textToast(this.a, "请联系管家，重新录入续约信息.");
      return;
    }
    finish();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903698);
    this.a = this;
    this.w = getIntent().getStringExtra("old_contract_code");
    this.z = getIntent().getStringExtra("cityCode");
    if (!ah.checkNet(this.a))
    {
      com.freelxl.baselibrary.f.g.textToast(this, "网络请求失败，请检查您的网络设置", 0);
      return;
    }
    d.getContractExtension(this.a, this.B, this.w);
    showProgress("");
    initView();
    setListener();
  }
  
  public void setListener()
  {
    this.t.setOnClickListener(this);
    this.u.setOnClickListener(this);
  }
  
  private class a
    extends AsyncTask<Bundle, Integer, String>
  {
    private a() {}
    
    protected String a(Bundle... paramVarArgs)
    {
      Object localObject = paramVarArgs[0];
      paramVarArgs = ((Bundle)localObject).getString("CSR");
      String str1 = ((Bundle)localObject).getString("CHALLENGE");
      String str2 = ((Bundle)localObject).getString("PassPort");
      localObject = (com.itrus.raapi.implement.UserInfo)((Bundle)localObject).getSerializable("UserInfo");
      return ContractDataActivity.k(ContractDataActivity.this).enrollCert(paramVarArgs, (com.itrus.raapi.implement.UserInfo)localObject, str2, str1, "1");
    }
    
    protected void a(String paramString)
    {
      if (TextUtils.isEmpty(paramString))
      {
        u.d("ikey", "证书申请失败");
        ContractDataActivity.this.dismissProgress();
        d.errorLog(ContractDataActivity.this, "证书申请失败", "操作失败!!" + paramString);
      }
      for (;;)
      {
        ContractDataActivity.this.dismissProgress();
        super.onPostExecute(paramString);
        return;
        if ("$OKOKOK$".equals(paramString.substring(0, "$OKOKOK$".length())))
        {
          if (ApplicationEx.c.k.ImportCert("", paramString.substring("$OKOKOK$".length() - 1)) == 0)
          {
            u.d("ikey", "证书导入成功!!!");
            Object localObject = ApplicationEx.c.k.FilterCert("", "", "", 0, 0);
            if (localObject.length < 1)
            {
              u.d("ikey", "过滤证书失败!!!");
            }
            else
            {
              u.d("ikey", "证书主题为:" + ApplicationEx.c.k.GetCertAttribute(localObject[0]).toString());
              if ("1".equals(ContractDataActivity.b(ContractDataActivity.this).getIsZWhite()))
              {
                ContractDataActivity.this.dismissProgress();
                com.freelxl.baselibrary.d.a.isLog(true);
                localObject = new HashMap();
                ((Map)localObject).put("outcontractCode", ContractDataActivity.b(ContractDataActivity.this).getRenewContractCode());
                ((Map)localObject).put("interfaceId", "57");
                com.ziroom.ziroomcustomer.e.g.appendCommenParamsString((Map)localObject);
                com.freelxl.baselibrary.d.a.post(q.s + e.n.X).tag(this).params((Map)localObject).enqueue(new f(ContractDataActivity.this, new o())
                {
                  public void onSuccess(int paramAnonymousInt, e paramAnonymouse)
                  {
                    super.onSuccess(paramAnonymousInt, paramAnonymouse);
                    paramAnonymouse = new Intent(ContractDataActivity.this.getApplicationContext(), BoundCardActivity.class);
                    paramAnonymouse.putExtra("is_pre_bind", false);
                    paramAnonymouse.putExtra("mBoundCardType", 2);
                    paramAnonymouse.putExtra("contract_code", ContractDataActivity.b(ContractDataActivity.this).getRenewContractCode());
                    paramAnonymouse.putExtra("old_contract_code", ContractDataActivity.f(ContractDataActivity.this));
                    paramAnonymouse.putExtra("url", q.W + "/btForAppV1.0/bindBank.html?token=" + com.ziroom.commonlibrary.login.a.getToken(ContractDataActivity.this) + "&outContractCode=" + ContractDataActivity.b(ContractDataActivity.this).getRenewContractCode());
                    paramAnonymouse.putExtra("cityCode", ContractDataActivity.g(ContractDataActivity.this));
                    ContractDataActivity.this.startActivity(paramAnonymouse);
                  }
                });
              }
              else
              {
                localObject = new Intent(ContractDataActivity.h(ContractDataActivity.this), ContractTermsActivity.class);
                ((Intent)localObject).putExtra("old_contract_code", ContractDataActivity.f(ContractDataActivity.this));
                ((Intent)localObject).putExtra("cityCode", ContractDataActivity.g(ContractDataActivity.this));
                ContractDataActivity.this.startActivity((Intent)localObject);
              }
            }
          }
          else
          {
            d.errorLog(ContractDataActivity.this, "证书导入失败!!!", "证书导入失败!!!" + ApplicationEx.c.k.GetLastErrInfo());
          }
        }
        else
        {
          u.d("ikey", "证书申请失败!!!\n" + paramString);
          ContractDataActivity.this.showToast("无纸化签约证书出现问题,请稍后再试!!!");
        }
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/contract/ContractDataActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */