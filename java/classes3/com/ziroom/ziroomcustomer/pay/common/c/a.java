package com.ziroom.ziroomcustomer.pay.common.c;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.itrus.raapi.implement.ClientForAndroid;
import com.itrus.raapi.implement.certInfo;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.d;
import com.ziroom.ziroomcustomer.e.l;
import com.ziroom.ziroomcustomer.model.IkeyRaConfig;
import com.ziroom.ziroomcustomer.util.m;
import com.ziroom.ziroomcustomer.util.u;
import java.io.File;
import java.util.Date;
import java.util.HashMap;

public class a
{
  private com.ziroom.ziroomcustomer.c.a a;
  private boolean b = true;
  private Thread c;
  private BaseActivity d;
  private HashMap<String, String> e;
  private b f;
  private Handler g = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      switch (paramAnonymousMessage.what)
      {
      default: 
        return;
      case 69700: 
        a.a(a.this).dismissProgress();
        a.b(a.this).setSignUpdate();
        return;
      }
      paramAnonymousMessage = (l)paramAnonymousMessage.obj;
      if (paramAnonymousMessage.getSuccess().booleanValue())
      {
        a.c(a.this);
        a.d(a.this);
        return;
      }
      a.a(a.this).showToast("无纸化签约证书出现问题,请稍后再试!!!");
      d.errorLog(a.a(a.this), "获取RA配置信息失败", paramAnonymousMessage.getMessage());
      a.a(a.this).dismissProgress();
    }
  };
  
  public a(BaseActivity paramBaseActivity, HashMap<String, String> paramHashMap, b paramb)
  {
    this.d = paramBaseActivity;
    this.f = paramb;
    this.e = paramHashMap;
    d.getRaConfig(this.d, this.g);
    this.d.showProgress("", 100000L);
  }
  
  private String a(int paramInt)
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
  
  private void a()
  {
    if (!d())
    {
      this.d.showToast("无纸化签约证书出现问题,请稍后再试!!!");
      d.errorLog(this.d, "无纸化错误", ApplicationEx.c.k.GetLastErrInfo());
    }
    do
    {
      return;
      this.a = new com.ziroom.ziroomcustomer.c.a(ApplicationEx.c.getRaConfig().getWebsite(), ApplicationEx.c.getRaConfig().getAccounthash(), this.d);
    } while (ApplicationEx.c.k != null);
    ApplicationEx.c.k = ClientForAndroid.getInstance(this.d);
  }
  
  private void a(String paramString)
  {
    try
    {
      if (Long.valueOf(m.getDaysBetween(new Date(System.currentTimeMillis()), new Date(c()))).longValue() < 0L)
      {
        ApplicationEx.c.k.DeleteCertBySerialNumber(ApplicationEx.c.k.GetCertSerialNumber(paramString));
        a(this.e);
        return;
      }
      paramString = this.g.obtainMessage();
      paramString.what = 69700;
      this.g.sendMessage(paramString);
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private void a(final HashMap<String, String> paramHashMap)
  {
    this.c = new Thread(new Runnable()
    {
      public void run()
      {
        String str = a.a(a.this, paramHashMap);
        if (TextUtils.isEmpty(str))
        {
          if ((a.e(a.this)) && (a.f(a.this)))
          {
            a.a(a.this, false);
            a.c(a.this);
            a.b(a.this, paramHashMap);
            return;
          }
          d.errorLog(a.a(a.this), "生成CSR失败", "操作失败!!" + ApplicationEx.c.k.GetLastErrInfo());
          a.a(a.this).dismissProgress();
          a.a(a.this).runOnUiThread(new Runnable()
          {
            public void run()
            {
              a.a(a.this).showToast("无纸化出现异常,请稍后再试!");
            }
          });
          return;
        }
        u.d("ikey", "CSR生成成功!! 正在申请证书...");
        com.itrus.raapi.implement.UserInfo localUserInfo = new com.itrus.raapi.implement.UserInfo();
        localUserInfo.setUserAdditionalField1(ApplicationEx.c.getUserId(a.a(a.this)));
        localUserInfo.setUserName((String)paramHashMap.get("name"));
        localUserInfo.setUserSurname((String)paramHashMap.get("cerNum"));
        localUserInfo.setUserAdditionalField2(a.a(a.this, Integer.parseInt(((String)paramHashMap.get("mCerType2")).toString())));
        u.d("ikey", "name===" + (String)paramHashMap.get("name"));
        u.d("ikey", "cerNum===" + (String)paramHashMap.get("cerNum"));
        Bundle localBundle = new Bundle();
        localBundle.putSerializable("UserInfo", localUserInfo);
        localBundle.putString("CSR", str);
        localBundle.putString("PassPort", "");
        localBundle.putString("CHALLENGE", ApplicationEx.c.getRaConfig().getStrChangllege());
        localBundle.putString("Time", "1");
        new a.a(a.this, null).execute(new Bundle[] { localBundle });
      }
    });
    this.c.start();
  }
  
  private String b(HashMap<String, String> paramHashMap)
  {
    try
    {
      Thread.sleep(1000L);
      u.d("ikey", "正在生成CSR");
      u.d("ikey", "android.os.Build.MODEL===" + Build.MODEL);
      u.d("ikey", "map.get(name)===" + (String)paramHashMap.get("name"));
      paramHashMap = ApplicationEx.c.k.GenCSR(Build.MODEL, (String)paramHashMap.get("name"), "", "", "", 1024, "RSA");
      return paramHashMap;
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        localInterruptedException.printStackTrace();
      }
    }
    finally {}
  }
  
  private void b()
  {
    String[] arrayOfString = ApplicationEx.c.k.FilterCert("", "", "", 0, 0);
    if (arrayOfString.length < 1)
    {
      u.d("ikey", "过滤证书失败!!!");
      a(this.e);
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
          if ((ApplicationEx.c.getUser().getUid().equals(localObject3)) && (((String)this.e.get("name")).equals(localObject4)) && (a(Integer.parseInt((String)this.e.get("mCerType2"))).equals(localObject2)) && (((String)this.e.get("cerNum")).equals(str)))
          {
            u.d("ikey", "证书主题为:" + ApplicationEx.c.k.GetCertAttribute((String)localObject1).toString());
            a((String)localObject1);
            u.d("ikey", "同一用户");
          }
          for (;;)
          {
            delRepetition(arrayOfString);
            return;
            u.d("ikey", "不同用户");
            a(this.e);
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
          d.errorLog(this.d, localException.getMessage(), ((StringBuffer)localObject2).toString());
        }
      }
    }
  }
  
  private String c()
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
  
  private boolean d()
  {
    if (ApplicationEx.c.k == null) {
      ApplicationEx.c.k = ClientForAndroid.getInstance(this.d);
    }
    f();
    int i = ApplicationEx.c.k.SetLicense(ApplicationEx.c.getRaConfig().getLicense());
    u.d("ikey", "SetLicense===" + i + "---" + ApplicationEx.c.getRaConfig().getLicense());
    if (i == 0)
    {
      ApplicationEx.c.k.SetSystemDBDir(this.d.getApplicationContext().getFilesDir().getAbsolutePath() + "/db/");
      File localFile = new File(this.d.getApplicationContext().getFilesDir().getAbsolutePath() + "/db/");
      if (!localFile.exists()) {
        localFile.mkdirs();
      }
      return e();
    }
    return false;
  }
  
  private boolean e()
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
      if ((g()) && (this.b))
      {
        this.b = false;
        a();
        return false;
      }
      d.errorLog(this.d, "初始化pin失败", "操作失败!!" + ApplicationEx.c.k.GetLastErrInfo());
      this.d.dismissProgress();
      this.d.showToast("无纸化出现异常,请稍后再试!");
      return false;
    }
    if (i == 0) {}
    for (;;)
    {
      return bool1;
      bool1 = false;
    }
  }
  
  private boolean f()
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
      localObject = new File(this.d.getApplicationContext().getFilesDir().getAbsolutePath() + "/" + (String)localObject);
      if (((File)localObject).exists()) {
        bool = ((File)localObject).delete();
      }
      i += 1;
    }
    return bool;
  }
  
  private boolean g()
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
      localObject = new File(this.d.getApplicationContext().getFilesDir().getAbsolutePath() + "/db/" + (String)localObject);
      if (((File)localObject).exists()) {
        bool = ((File)localObject).delete();
      }
      i += 1;
    }
    return bool;
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
          if ((ApplicationEx.c.getUser().getUid().equals(str4)) && (((String)this.e.get("name")).equals(localObject)) && (a(Integer.parseInt((String)this.e.get("mCerType2"))).equals(str3)) && (((String)this.e.get("cerNum")).equals(str2)))
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
      return a.g(a.this).enrollCert(paramVarArgs, (com.itrus.raapi.implement.UserInfo)localObject, str2, str1, "1");
    }
    
    protected void a(String paramString)
    {
      if (TextUtils.isEmpty(paramString))
      {
        u.d("ikey", "证书申请失败");
        d.errorLog(a.a(a.this), "证书申请失败", "操作失败!!" + paramString);
      }
      for (;;)
      {
        a.a(a.this).dismissProgress();
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
              localObject = a.h(a.this).obtainMessage();
              ((Message)localObject).what = 69700;
              a.h(a.this).sendMessage((Message)localObject);
            }
          }
          else
          {
            d.errorLog(a.a(a.this), "证书导入失败!!!", "证书导入失败!!!" + ApplicationEx.c.k.GetLastErrInfo());
          }
        }
        else
        {
          u.d("ikey", "证书申请失败!!!\n" + paramString);
          d.errorLog(a.a(a.this), "证书申请失败!!!", "证书申请失败!!!\n" + paramString + "\n" + ApplicationEx.c.k.GetLastErrInfo());
          a.a(a.this).showToast("无纸化签约证书出现问题,请稍后再试!!!");
        }
      }
    }
  }
  
  public static abstract interface b
  {
    public abstract void setSignUpdate();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/pay/common/c/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */