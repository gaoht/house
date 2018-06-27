package com.ziroom.ziroomcustomer.termination;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.freelxl.baselibrary.e.i.a;
import com.itrus.raapi.implement.ClientForAndroid;
import com.itrus.raapi.implement.certInfo;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.e.a;
import com.ziroom.ziroomcustomer.e.e.n;
import com.ziroom.ziroomcustomer.e.g;
import com.ziroom.ziroomcustomer.e.j;
import com.ziroom.ziroomcustomer.e.q;
import com.ziroom.ziroomcustomer.model.IkeyRaConfig;
import com.ziroom.ziroomcustomer.signed.o;
import com.ziroom.ziroomcustomer.util.m;
import com.ziroom.ziroomcustomer.util.u;
import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class a
{
  private int a = 0;
  private Context b;
  private Thread c;
  private boolean d = true;
  private BaseActivity e;
  private HashMap<String, String> f;
  private com.ziroom.ziroomcustomer.c.a g;
  private b h;
  private i.a<String> i;
  private String j;
  private Handler k;
  
  public a(Context paramContext, BaseActivity paramBaseActivity, HashMap<String, String> paramHashMap, i.a<String> parama, Handler paramHandler)
  {
    this.b = paramContext;
    this.e = paramBaseActivity;
    this.f = paramHashMap;
    this.i = parama;
    this.k = paramHandler;
  }
  
  public a(BaseActivity paramBaseActivity, HashMap<String, String> paramHashMap, i.a<String> parama, Handler paramHandler, int paramInt)
  {
    this.b = paramBaseActivity;
    this.e = paramBaseActivity;
    this.f = paramHashMap;
    this.i = parama;
    this.k = paramHandler;
    this.a = paramInt;
  }
  
  private String a()
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
  
  private void a(String paramString)
  {
    try
    {
      if (Long.valueOf(m.getDaysBetween(new Date(System.currentTimeMillis()), new Date(a()))).longValue() < 0L)
      {
        ApplicationEx.c.k.DeleteCertBySerialNumber(ApplicationEx.c.k.GetCertSerialNumber(paramString));
        a(this.f);
        return;
      }
      this.h.DownloadSuccess();
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
        Object localObject = a.a(a.this, paramHashMap);
        if (TextUtils.isEmpty((CharSequence)localObject))
        {
          if ((a.a(a.this)) && (a.b(a.this)))
          {
            a.a(a.this, false);
            a.this.initCaManager();
            a.b(a.this, paramHashMap);
            return;
          }
          if (a.c(a.this) == 0) {
            a.a(a.this, q.s + e.a.r);
          }
          for (;;)
          {
            localObject = g.getAddErrorMsg("生成CSR失败", "操作失败!!" + ApplicationEx.c.k.GetLastErrInfo(), a.d(a.this));
            ((Map)localObject).put("interfaceId", Integer.valueOf(53));
            j.getReservationOrderText(a.d(a.this), a.e(a.this), (Map)localObject, false, a.f(a.this));
            a.g(a.this).DownloadError();
            a.h(a.this).runOnUiThread(new Runnable()
            {
              public void run()
              {
                a.h(a.this).showToast("无纸化出现异常,请稍后再试!");
              }
            });
            return;
            if (a.c(a.this) == 1) {
              a.a(a.this, q.s + e.n.X);
            }
          }
        }
        u.d("ikey", "CSR生成成功!! 正在申请证书...");
        com.itrus.raapi.implement.UserInfo localUserInfo = new com.itrus.raapi.implement.UserInfo();
        localUserInfo.setUserAdditionalField1(ApplicationEx.c.getUserId(a.h(a.this)));
        localUserInfo.setUserName((String)paramHashMap.get("name"));
        localUserInfo.setUserSurname((String)paramHashMap.get("cerNum"));
        localUserInfo.setUserAdditionalField2(((String)paramHashMap.get("mCerType2")).toString());
        u.d("ikey", "name===" + (String)paramHashMap.get("name"));
        u.d("ikey", "cerNum===" + (String)paramHashMap.get("cerNum"));
        Bundle localBundle = new Bundle();
        localBundle.putSerializable("UserInfo", localUserInfo);
        localBundle.putString("CSR", (String)localObject);
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
  
  private boolean b()
  {
    if (ApplicationEx.c.k == null) {
      ApplicationEx.c.k = ClientForAndroid.getInstance(this.e);
    }
    d();
    int m = ApplicationEx.c.k.SetLicense(ApplicationEx.c.getRaConfig().getLicense());
    u.d("ikey", "SetLicense===" + m + "---" + ApplicationEx.c.getRaConfig().getLicense());
    if (m == 0)
    {
      ApplicationEx.c.k.SetSystemDBDir(this.e.getApplicationContext().getFilesDir().getAbsolutePath() + "/db/");
      File localFile = new File(this.e.getApplicationContext().getFilesDir().getAbsolutePath() + "/db/");
      if (!localFile.exists()) {
        localFile.mkdirs();
      }
      return c();
    }
    return false;
  }
  
  private boolean c()
  {
    boolean bool1 = true;
    boolean bool2 = false;
    int m = ApplicationEx.c.k.VerifyUserPIN(Build.MODEL, "111", 5);
    if (m == 3)
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
    if (m == 1)
    {
      if ((e()) && (this.d))
      {
        this.d = false;
        initCaManager();
        return false;
      }
      if (this.a == 0) {
        this.j = (q.s + e.a.r);
      }
      for (;;)
      {
        Object localObject = g.getAddErrorMsg("初始化pin失败", "操作失败!!" + ApplicationEx.c.k.GetLastErrInfo(), this.b);
        ((Map)localObject).put("interfaceId", Integer.valueOf(53));
        j.getReservationOrderText(this.b, this.i, (Map)localObject, false, this.j);
        this.h.DownloadError();
        localObject = new Message();
        ((Message)localObject).obj = "无纸化出现异常,请稍后再试!";
        ((Message)localObject).what = 1;
        this.k.sendMessage((Message)localObject);
        return false;
        if (this.a == 1) {
          this.j = (q.s + e.n.X);
        }
      }
    }
    if (m == 0) {}
    for (;;)
    {
      return bool1;
      bool1 = false;
    }
  }
  
  private boolean d()
  {
    boolean bool = false;
    String[] arrayOfString = new String[3];
    arrayOfString[0] = "cert9.db";
    arrayOfString[1] = "itrusChina.db";
    arrayOfString[2] = "key4.db";
    int n = arrayOfString.length;
    int m = 0;
    while (m < n)
    {
      Object localObject = arrayOfString[m];
      localObject = new File(this.e.getApplicationContext().getFilesDir().getAbsolutePath() + "/" + (String)localObject);
      if (((File)localObject).exists()) {
        bool = ((File)localObject).delete();
      }
      m += 1;
    }
    return bool;
  }
  
  private boolean e()
  {
    boolean bool = false;
    String[] arrayOfString = new String[3];
    arrayOfString[0] = "cert9.db";
    arrayOfString[1] = "itrusChina.db";
    arrayOfString[2] = "key4.db";
    int n = arrayOfString.length;
    int m = 0;
    while (m < n)
    {
      Object localObject = arrayOfString[m];
      localObject = new File(this.e.getApplicationContext().getFilesDir().getAbsolutePath() + "/db/" + (String)localObject);
      if (((File)localObject).exists()) {
        bool = ((File)localObject).delete();
      }
      m += 1;
    }
    return bool;
  }
  
  public void checkSign(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if (ApplicationEx.c.k == null) {
      ApplicationEx.c.k = ClientForAndroid.getInstance(this.e);
    }
    String[] arrayOfString = ApplicationEx.c.k.FilterCert("", "", "", 0, 0);
    if (arrayOfString.length <= 0)
    {
      new o(this.b).toDownloadCertificate(0);
      return;
    }
    paramString = ApplicationEx.c.k.SignMessage(paramString, arrayOfString[0], "SHA1", 1);
    if (TextUtils.isEmpty(paramString))
    {
      if (this.a == 0) {
        this.j = (q.s + e.a.r);
      }
      for (;;)
      {
        paramString = g.getAddErrorMsg("签名失败", "失败原因是:" + ApplicationEx.c.k.GetLastErrInfo(), this.b);
        this.h.DownloadError();
        paramString.put("interfaceId", Integer.valueOf(53));
        j.getReservationOrderText(this.b, this.i, paramString, false, this.j);
        return;
        if (this.a == 1) {
          this.j = (q.s + e.n.X);
        }
      }
    }
    this.h.Attestation(paramString);
  }
  
  public void delRepetition(String[] paramArrayOfString)
  {
    u.d("ikey", "去除证书重复!");
    if (paramArrayOfString.length <= 1) {
      return;
    }
    for (;;)
    {
      int m;
      try
      {
        int n = paramArrayOfString.length;
        m = 0;
        if (m >= n) {
          break;
        }
        String str1 = paramArrayOfString[m];
        if (!TextUtils.isEmpty(ApplicationEx.c.getUser().getUid()))
        {
          Object localObject = ApplicationEx.c.k.GetCertAttribute(str1).Subject.split(",");
          String str2 = localObject[0].split("=")[1];
          String str3 = localObject[1].split("=")[1].replace("\"", "");
          String str4 = localObject[2].split(":")[1];
          localObject = localObject[5].split("=")[1];
          if ((ApplicationEx.c.getUser().getUid().equals(str4)) && (((String)this.f.get("name")).equals(localObject)) && (((String)this.f.get("mCerType2")).equals(str3)) && (((String)this.f.get("cerNum")).equals(str2)))
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
        u.e("异常", paramArrayOfString.toString() + "");
        return;
      }
      m += 1;
    }
  }
  
  public b getmPaperless()
  {
    return this.h;
  }
  
  public void iKeyFilter()
  {
    String[] arrayOfString = ApplicationEx.c.k.FilterCert("", "", "", 0, 0);
    if (arrayOfString.length < 1)
    {
      u.d("ikey", "过滤证书失败!!!");
      a(this.f);
      return;
    }
    int i1 = arrayOfString.length;
    int m = 0;
    Object localObject1;
    Object localObject2;
    if (m < i1)
    {
      localObject1 = arrayOfString[m];
      if (TextUtils.isEmpty(ApplicationEx.c.getUser().getUid())) {}
    }
    else
    {
      try
      {
        Object localObject4 = ApplicationEx.c.k.GetCertAttribute((String)localObject1).Subject.split(",");
        String str = localObject4[0].split("=")[1];
        localObject2 = localObject4[1].split("=")[1].replace("\"", "");
        Object localObject3 = localObject4[2].split(":")[1];
        localObject4 = localObject4[5].split("=")[1];
        if ((ApplicationEx.c.getUser().getUid().equals(localObject3)) && (((String)this.f.get("name")).equals(localObject4)) && (((String)this.f.get("mCerType2")).equals(localObject2)) && (((String)this.f.get("cerNum")).equals(str)))
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
          a(this.f);
        }
        int n;
        this.j = (q.s + e.a.r);
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
          n = 0;
          while (n < localObject3.length)
          {
            ((StringBuffer)localObject2).append("\nError:" + localObject3[n].toString());
            n += 1;
          }
          localObject1 = ((Throwable)localObject1).getCause();
        }
        if (this.a != 0) {}
      }
    }
    for (;;)
    {
      localObject1 = g.getAddErrorMsg(localException.getMessage(), ((StringBuffer)localObject2).toString(), this.b);
      this.h.DownloadError();
      ((Map)localObject1).put("interfaceId", Integer.valueOf(53));
      j.getReservationOrderText(this.b, this.i, (Map)localObject1, false, this.j);
      m += 1;
      break;
      if (this.a == 1) {
        this.j = (q.s + e.n.X);
      }
    }
  }
  
  public void initCaManager()
  {
    if (!b())
    {
      this.e.showToast("无纸化签约证书出现问题,请稍后再试!!!");
      if (this.a == 0) {
        this.j = (q.s + e.a.r);
      }
    }
    do
    {
      for (;;)
      {
        Map localMap = g.getAddErrorMsg("无纸化错误", ApplicationEx.c.k.GetLastErrInfo(), this.b);
        this.h.DownloadError();
        localMap.put("interfaceId", Integer.valueOf(53));
        j.getReservationOrderText(this.b, this.i, localMap, false, this.j);
        return;
        if (this.a == 1) {
          this.j = (q.s + e.n.X);
        }
      }
      this.g = new com.ziroom.ziroomcustomer.c.a(ApplicationEx.c.getRaConfig().getWebsite(), ApplicationEx.c.getRaConfig().getAccounthash(), this.e);
    } while (ApplicationEx.c.k != null);
    ApplicationEx.c.k = ClientForAndroid.getInstance(this.e);
  }
  
  public void setmPaperless(b paramb)
  {
    this.h = paramb;
  }
  
  public void sign(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    String[] arrayOfString;
    do
    {
      return;
      if (ApplicationEx.c.k == null) {
        ApplicationEx.c.k = ClientForAndroid.getInstance(this.e);
      }
      arrayOfString = ApplicationEx.c.k.FilterCert("", "", "", 0, 0);
    } while (arrayOfString.length <= 0);
    paramString = ApplicationEx.c.k.SignMessage(paramString, arrayOfString[0], "SHA1", 1);
    if (TextUtils.isEmpty(paramString))
    {
      if (this.a == 0) {
        this.j = (q.s + e.a.r);
      }
      for (;;)
      {
        paramString = g.getAddErrorMsg("签名失败", "失败原因是:" + ApplicationEx.c.k.GetLastErrInfo(), this.b);
        this.h.DownloadError();
        paramString.put("interfaceId", Integer.valueOf(53));
        j.getReservationOrderText(this.b, this.i, paramString, false, this.j);
        return;
        if (this.a == 1) {
          this.j = (q.s + e.n.X);
        }
      }
    }
    this.h.Attestation(paramString);
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
      return a.i(a.this).enrollCert(paramVarArgs, (com.itrus.raapi.implement.UserInfo)localObject, str2, str1, "1");
    }
    
    protected void a(String paramString)
    {
      Object localObject;
      if (TextUtils.isEmpty(paramString))
      {
        u.d("ikey", "证书申请失败");
        if (a.c(a.this) == 0)
        {
          a.a(a.this, q.s + e.a.r);
          localObject = g.getAddErrorMsg("证书申请失败", "操作失败!!" + paramString, a.d(a.this));
          a.g(a.this).DownloadError();
          ((Map)localObject).put("interfaceId", Integer.valueOf(53));
          j.getReservationOrderText(a.d(a.this), a.e(a.this), (Map)localObject, false, a.f(a.this));
        }
      }
      for (;;)
      {
        super.onPostExecute(paramString);
        return;
        if (a.c(a.this) != 1) {
          break;
        }
        a.a(a.this, q.s + e.n.X);
        break;
        if (!"$OKOKOK$".equals(paramString.substring(0, "$OKOKOK$".length()))) {
          break label504;
        }
        if (ApplicationEx.c.k.ImportCert("", paramString.substring("$OKOKOK$".length() - 1)) != 0) {
          break label325;
        }
        u.d("ikey", "证书导入成功!!!");
        localObject = ApplicationEx.c.k.FilterCert("", "", "", 0, 0);
        if (localObject.length < 1)
        {
          u.d("ikey", "过滤证书失败!!!");
        }
        else
        {
          u.d("ikey", "证书主题为:" + ApplicationEx.c.k.GetCertAttribute(localObject[0]).toString());
          a.g(a.this).DownloadSuccess();
        }
      }
      label325:
      if (a.c(a.this) == 0) {
        a.a(a.this, q.s + e.a.r);
      }
      for (;;)
      {
        localObject = g.getAddErrorMsg("证书导入失败!!!", "证书导入失败!!!" + ApplicationEx.c.k.GetLastErrInfo(), a.d(a.this));
        a.g(a.this).DownloadError();
        ((Map)localObject).put("interfaceId", Integer.valueOf(53));
        j.getReservationOrderText(a.d(a.this), a.e(a.this), (Map)localObject, false, a.f(a.this));
        break;
        if (a.c(a.this) == 1) {
          a.a(a.this, q.s + e.n.X);
        }
      }
      label504:
      u.d("ikey", "证书申请失败!!!\n" + paramString);
      if (a.c(a.this) == 0) {
        a.a(a.this, q.s + e.a.r);
      }
      for (;;)
      {
        localObject = g.getAddErrorMsg("证书申请失败!!!", "证书申请失败!!!\n" + paramString + "\n" + ApplicationEx.c.k.GetLastErrInfo(), a.d(a.this));
        a.g(a.this).DownloadError();
        ((Map)localObject).put("interfaceId", Integer.valueOf(53));
        j.getReservationOrderText(a.d(a.this), a.e(a.this), (Map)localObject, false, a.f(a.this));
        a.h(a.this).showToast("无纸化签约证书出现问题,请稍后再试!!!");
        break;
        if (a.c(a.this) == 1) {
          a.a(a.this, q.s + e.n.X);
        }
      }
    }
  }
  
  public static abstract interface b
  {
    public abstract void Attestation(String paramString);
    
    public abstract void DownloadError();
    
    public abstract void DownloadSuccess();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/termination/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */