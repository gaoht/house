package com.ziroom.ziroomcustomer.util.a;

import android.content.Context;
import android.os.AsyncTask;
import android.os.AsyncTask.Status;
import android.text.TextUtils;
import com.itrus.raapi.implement.ClientForAndroid;
import com.itrus.raapi.implement.UserInfo;
import com.itrus.raapi.implement.certInfo;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.model.IkeyRaConfig;
import com.ziroom.ziroomcustomer.util.u;
import java.io.File;

public class c
{
  private final String a = "ITrusUtil";
  private ClientForAndroid b;
  private b c;
  private com.ziroom.ziroomcustomer.c.a d;
  private IkeyRaConfig e;
  private String f;
  private String g;
  private String h;
  private String i;
  private a j;
  private c k;
  private String l;
  
  public c(a parama, IkeyRaConfig paramIkeyRaConfig)
  {
    this.g = parama.getUid();
    this.f = parama.getUsername();
    this.h = parama.getCertType();
    this.i = parama.getCertNum();
    this.e = paramIkeyRaConfig;
  }
  
  private String a(String paramString)
    throws Exception
  {
    if ((this.b == null) && (!a())) {
      paramString = null;
    }
    int m;
    do
    {
      return paramString;
      u.d("ITrusUtil", "=====证书更新：" + paramString);
      if (this.b.CertExpireRemind(paramString) >= 0) {
        break label147;
      }
      String str = f().renewCert(paramString);
      if ((TextUtils.isEmpty(str)) || (!str.startsWith("$OKOKOK$"))) {
        break;
      }
      str = str.substring("$OKOKOK$".length() - 1);
      u.d("ITrusUtil", "=====证书更新：证书已更新：" + str);
      m = this.b.ImportCert("Android", str);
      a(m);
    } while (m == 0);
    return null;
    throw new b("证书更新失败！");
    label147:
    u.d("ITrusUtil", "=====证书更新：证书无需更新：" + paramString);
    return paramString;
  }
  
  private void a(int paramInt)
    throws c.b
  {
    if ((paramInt != 0) && (this.c != null) && (this.b != null)) {
      throw new b(this.b.GetLastErrInfo());
    }
  }
  
  private boolean a()
    throws c.b
  {
    if (!b())
    {
      this.b = null;
      throw new b("证书初始化失败！");
    }
    return true;
  }
  
  private void b(String paramString)
    throws c.b
  {
    if ((TextUtils.isEmpty(paramString)) && (this.c != null) && (this.b != null)) {
      throw new b(this.b.GetLastErrInfo());
    }
  }
  
  private boolean b()
    throws c.b
  {
    this.b = ClientForAndroid.getInstance(ApplicationEx.c);
    if (this.b == null) {
      throw new b("ClientForAndroid init failed!");
    }
    c();
    int m = this.b.SetLicense(this.e.getLicense());
    a(m);
    if (m != 0) {}
    do
    {
      do
      {
        return false;
        this.b.SetSystemDBDir(ApplicationEx.c.getApplicationContext().getFilesDir().getAbsolutePath() + "/db/");
        File localFile = new File(ApplicationEx.c.getApplicationContext().getFilesDir().getAbsolutePath() + "/db/");
        if (!localFile.exists()) {
          localFile.mkdirs();
        }
        m = this.b.VerifyUserPIN("Android", "111", 5);
        if (m == 0) {
          return true;
        }
        if (m != 3) {
          break;
        }
        m = this.b.CSetAdminPIN("", "123", 0);
        a(m);
      } while ((m != 0) || (this.b.CInitUserPIN("123", "111") != 0));
      m = this.b.VerifyUserPIN("Android", "111", 5);
      a(m);
    } while (m != 0);
    return true;
    a(m);
    return false;
  }
  
  private boolean c()
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
      localObject = new File(ApplicationEx.c.getApplicationContext().getFilesDir().getAbsolutePath() + "/" + (String)localObject);
      if (((File)localObject).exists()) {
        bool = ((File)localObject).delete();
      }
      m += 1;
    }
    return bool;
  }
  
  public static String certTypeToName(int paramInt)
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
  
  private String d()
    throws Exception
  {
    if ((this.b == null) && (!a())) {
      return null;
    }
    String[] arrayOfString = this.b.FilterCert("", "", "", 0, 0);
    if ((arrayOfString == null) || (arrayOfString.length == 0)) {
      e();
    }
    Object localObject1;
    Object localObject2;
    if ((arrayOfString != null) && (arrayOfString.length > 0))
    {
      int n = arrayOfString.length;
      int m = 0;
      localObject1 = null;
      localObject2 = localObject1;
      if (m < n)
      {
        String str = arrayOfString[m];
        localObject2 = localObject1;
        Object localObject3;
        if (!TextUtils.isEmpty(this.g))
        {
          localObject3 = this.b.GetCertAttribute(str).Subject.split(",");
          if (localObject3.length >= 6) {
            break label161;
          }
          this.b.DeleteCertBySerialNumber(this.b.GetCertSerialNumber(str));
          u.d("ITrusUtil", "删除证书");
          localObject2 = localObject1;
        }
        for (;;)
        {
          m += 1;
          localObject1 = localObject2;
          break;
          label161:
          u.d("ITrusUtil", "===certDetail:" + localObject3);
          Object localObject4 = localObject3[0].split("=");
          Object localObject5 = localObject3[1].split("=");
          localObject2 = localObject3[2].split(":");
          localObject3 = localObject3[5].split("=");
          if ((localObject4.length < 2) || (localObject5.length < 2) || (localObject2.length < 2) || (localObject3.length < 2))
          {
            this.b.DeleteCertBySerialNumber(this.b.GetCertSerialNumber(str));
            u.d("ITrusUtil", "删除证书");
            localObject2 = localObject1;
          }
          else
          {
            localObject4 = localObject4[1];
            localObject5 = localObject5[1].replace("\"", "");
            localObject2 = localObject2[1];
            localObject3 = localObject3[1];
            if ((this.g.equals(localObject2)) && (this.f.equals(localObject3)) && (this.h.equals(localObject5)) && (this.i.equals(localObject4)))
            {
              localObject2 = a(str);
            }
            else
            {
              this.b.DeleteCertBySerialNumber(this.b.GetCertSerialNumber(str));
              u.d("ITrusUtil", "删除证书");
              localObject2 = localObject1;
            }
          }
        }
      }
    }
    else
    {
      localObject2 = null;
    }
    if (TextUtils.isEmpty((CharSequence)localObject2))
    {
      e();
      localObject1 = this.b.FilterCert("", "", "", 0, 0);
      if ((localObject1 == null) || (localObject1.length == 0))
      {
        u.d("ITrusUtil", "筛选证书失败!");
        return null;
      }
      return localObject1[0];
    }
    return (String)localObject2;
  }
  
  private String e()
    throws Exception
  {
    String str;
    if ((this.b == null) && (!a())) {
      str = null;
    }
    int m;
    do
    {
      return str;
      str = this.b.GenCSR("Android", this.f, "", "", "", 1024, "RSA");
      b(str);
      if (TextUtils.isEmpty(str)) {
        break;
      }
      UserInfo localUserInfo = new UserInfo();
      localUserInfo.setUserName(this.f);
      localUserInfo.setUserSurname(this.i);
      localUserInfo.setUserAdditionalField1(this.g);
      localUserInfo.setUserAdditionalField2(this.h);
      str = f().enrollCert(str, localUserInfo, "", this.e.getStrChangllege(), "1");
      b(str);
      if ((TextUtils.isEmpty(str)) || (!str.startsWith("$OKOKOK$"))) {
        break;
      }
      str = str.substring("$OKOKOK$".length() - 1);
      m = this.b.ImportCert("Android", str);
      a(m);
    } while (m == 0);
    return null;
  }
  
  private com.ziroom.ziroomcustomer.c.a f()
  {
    if (this.d == null) {
      this.d = new com.ziroom.ziroomcustomer.c.a(ApplicationEx.c, this.e.getWebsite(), this.e.getAccounthash());
    }
    return this.d;
  }
  
  public boolean certInit()
  {
    boolean bool = false;
    if ((this.j == null) || (this.j.getStatus() == AsyncTask.Status.FINISHED))
    {
      this.j = new a(null);
      this.j.execute(new String[] { "" });
      bool = true;
    }
    return bool;
  }
  
  public void setListener(b paramb)
  {
    this.c = paramb;
  }
  
  public boolean sign(String paramString)
  {
    boolean bool = false;
    if ((this.k == null) || (this.k.getStatus() == AsyncTask.Status.FINISHED))
    {
      this.k = new c(null);
      this.k.execute(new String[] { paramString });
      bool = true;
    }
    return bool;
  }
  
  private class a
    extends AsyncTask<String, Integer, String>
  {
    private a() {}
    
    protected String a(String[] paramArrayOfString)
    {
      try
      {
        if ((c.a(c.this) == null) && (!c.b(c.this))) {
          return null;
        }
        paramArrayOfString = c.c(c.this);
        boolean bool = TextUtils.isEmpty(paramArrayOfString);
        if (!bool) {
          return paramArrayOfString;
        }
      }
      catch (c.b paramArrayOfString)
      {
        c.b(c.this, paramArrayOfString.getMessage());
        return null;
      }
      catch (Exception paramArrayOfString)
      {
        c.b(c.this, paramArrayOfString.getMessage());
      }
      return null;
    }
    
    protected void a(String paramString)
    {
      super.onPostExecute(paramString);
      if ((TextUtils.isEmpty(paramString)) && (c.d(c.this) != null))
      {
        if (TextUtils.isEmpty(c.e(c.this))) {
          c.b(c.this, "证书获取失败，未知错误！");
        }
        c.d(c.this).onError(c.e(c.this));
      }
      if (c.d(c.this) != null) {
        c.d(c.this).onCertInitEnd(paramString);
      }
    }
    
    protected void onPreExecute()
    {
      super.onPreExecute();
      if (c.d(c.this) != null) {
        c.d(c.this).onCertInitStart();
      }
      c.b(c.this, null);
    }
  }
  
  private class b
    extends Exception
  {
    public b() {}
    
    public b(String paramString)
    {
      super();
    }
    
    public b(String paramString, Throwable paramThrowable)
    {
      super(paramThrowable);
    }
    
    public b(String paramString, Throwable paramThrowable, boolean paramBoolean1, boolean paramBoolean2)
    {
      super(paramThrowable, paramBoolean1, paramBoolean2);
    }
    
    public b(Throwable paramThrowable)
    {
      super();
    }
  }
  
  private class c
    extends AsyncTask<String, Integer, String>
  {
    private c() {}
    
    protected String a(String[] paramArrayOfString)
    {
      if ((paramArrayOfString == null) || (paramArrayOfString.length == 0)) {}
      for (;;)
      {
        return null;
        try
        {
          if ((c.a(c.this) != null) || (c.b(c.this)))
          {
            String str = c.c(c.this);
            if (!TextUtils.isEmpty(str))
            {
              paramArrayOfString = c.a(c.this).SignMessage(paramArrayOfString[0], str, "SHA1", 1);
              c.a(c.this, paramArrayOfString);
              boolean bool = TextUtils.isEmpty(paramArrayOfString);
              if (!bool) {
                return paramArrayOfString;
              }
            }
          }
        }
        catch (c.b paramArrayOfString)
        {
          c.b(c.this, paramArrayOfString.getMessage());
          return null;
        }
        catch (Exception paramArrayOfString)
        {
          c.b(c.this, paramArrayOfString.getMessage());
        }
      }
      return null;
    }
    
    protected void a(String paramString)
    {
      super.onPostExecute(paramString);
      if ((TextUtils.isEmpty(paramString)) && (c.d(c.this) != null))
      {
        if (TextUtils.isEmpty(c.e(c.this))) {
          c.b(c.this, "签名失败，未知错误！");
        }
        c.d(c.this).onError(c.e(c.this));
      }
      if (c.d(c.this) != null) {
        c.d(c.this).onSignEnd(paramString);
      }
    }
    
    protected void onPreExecute()
    {
      super.onPreExecute();
      if (c.d(c.this) != null) {
        c.d(c.this).onSignStart();
      }
      c.b(c.this, null);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/util/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */