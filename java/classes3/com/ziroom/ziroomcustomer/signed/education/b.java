package com.ziroom.ziroomcustomer.signed.education;

import android.content.Context;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.TextView;
import com.alibaba.fastjson.e;
import com.ziroom.ziroomcustomer.e.a.f;
import com.ziroom.ziroomcustomer.e.c.o;
import com.ziroom.ziroomcustomer.e.e.s;
import com.ziroom.ziroomcustomer.e.g;
import com.ziroom.ziroomcustomer.e.j;
import com.ziroom.ziroomcustomer.e.q;
import com.ziroom.ziroomcustomer.model.CreditsEntity;
import com.ziroom.ziroomcustomer.signed.l;
import com.ziroom.ziroomcustomer.signed.l.a;
import com.ziroom.ziroomcustomer.signed.n;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.util.m;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public class b
  implements a.a
{
  WeakReference<a.b> a;
  l.a b = new l.a()
  {
    public void showHour(String paramAnonymousString, int paramAnonymousInt1, int paramAnonymousInt2)
    {
      if (b.this.getView() == null) {
        return;
      }
      switch (paramAnonymousInt2)
      {
      default: 
        return;
      case 0: 
        b.this.getView().showSchooling(paramAnonymousString);
        return;
      case 1: 
        b.this.getView().showInYear(paramAnonymousString);
        return;
      case 2: 
        b.this.getView().showGraduateYear(paramAnonymousString);
        return;
      }
      b.this.getView().showEducationType(paramAnonymousString);
    }
  };
  private String[] c;
  private String[] d;
  private String[] e;
  private String[] f;
  private String g;
  private String h;
  private Map<Integer, String> i;
  private Map<String, Integer> j;
  private Map<Integer, String> k;
  private Map<String, Integer> l;
  
  public b(a.b paramb)
  {
    this.a = new WeakReference(paramb);
    if (getView() != null) {
      getView().setPresenter(this);
    }
  }
  
  private int a(String paramString)
  {
    return ((Integer)this.j.get(paramString)).intValue();
  }
  
  private String a(int paramInt)
  {
    return (String)this.i.get(Integer.valueOf(paramInt));
  }
  
  private void a()
  {
    int n = 0;
    this.c = new String[5];
    this.c[0] = "博士研究生";
    this.c[1] = "硕士研究生";
    this.c[2] = "本科";
    this.c[3] = "专科";
    this.c[4] = "成人";
    this.d = new String[6];
    this.d[0] = "普通全日制";
    this.d[1] = "在职研究生";
    this.d[2] = "成人教育";
    this.d[3] = "高等教育自学考试";
    this.d[4] = "网络教育";
    this.d[5] = "开放教育";
    this.i = new HashMap();
    this.i.put(Integer.valueOf(1), "普通全日制");
    this.i.put(Integer.valueOf(2), "在职研究生");
    this.i.put(Integer.valueOf(5), "成人教育");
    this.i.put(Integer.valueOf(6), "高等教育自学考试");
    this.i.put(Integer.valueOf(7), "网络教育");
    this.i.put(Integer.valueOf(8), "开放教育");
    this.j = new HashMap();
    this.j.put("普通全日制", Integer.valueOf(1));
    this.j.put("在职研究生", Integer.valueOf(2));
    this.j.put("成人教育", Integer.valueOf(5));
    this.j.put("高等教育自学考试", Integer.valueOf(6));
    this.j.put("网络教育", Integer.valueOf(7));
    this.j.put("开放教育", Integer.valueOf(8));
    this.k = new HashMap();
    this.k.put(Integer.valueOf(1), "博士研究生");
    this.k.put(Integer.valueOf(2), "硕士研究生");
    this.k.put(Integer.valueOf(3), "本科");
    this.k.put(Integer.valueOf(4), "专科");
    this.k.put(Integer.valueOf(5), "成人");
    this.l = new HashMap();
    this.l.put("博士研究生", Integer.valueOf(1));
    this.l.put("硕士研究生", Integer.valueOf(2));
    this.l.put("本科", Integer.valueOf(3));
    this.l.put("专科", Integer.valueOf(4));
    this.l.put("成人", Integer.valueOf(5));
    int i1 = m.GetNowYear() - 1950;
    this.e = new String[i1 + 1];
    int m = 0;
    while (m <= i1)
    {
      this.e[m] = (m.GetNowYear() - m + "");
      m += 1;
    }
    this.f = new String[i1 + 8];
    m = n;
    while (m <= i1 + 7)
    {
      this.f[m] = (m.GetNowYear() - m + 7 + "");
      m += 1;
    }
  }
  
  private void a(int paramInt, String[] paramArrayOfString)
  {
    if (getView() == null) {
      return;
    }
    paramArrayOfString = new l(getView().getViewContext(), this.b, paramArrayOfString, paramInt);
    paramArrayOfString.setCanceledOnTouchOutside(true);
    Window localWindow = paramArrayOfString.getWindow();
    localWindow.getDecorView().setPadding(0, 0, 0, 0);
    WindowManager.LayoutParams localLayoutParams = localWindow.getAttributes();
    localLayoutParams.width = -1;
    localLayoutParams.height = -2;
    localWindow.setAttributes(localLayoutParams);
    localWindow.setGravity(80);
    paramArrayOfString.show();
    paramArrayOfString.getTv_choose().setText("");
  }
  
  private void a(n paramn)
  {
    if (getView() == null) {
      return;
    }
    if (paramn == null)
    {
      getView().showTopRightBtn("提交", true);
      return;
    }
    if ((paramn.getEducation() == 0) && (paramn.getEducation_type() == 0) && (ae.isNull(paramn.getEnrollment_year())) && (ae.isNull(paramn.getGraduation_year())) && (ae.isNull(paramn.getSchool()))) {
      getView().showTopRightBtn("提交", true);
    }
    for (;;)
    {
      getView().showSchooling(b(paramn.getEducation()));
      getView().showEducationType(a(paramn.getEducation_type()));
      getView().showInYear(paramn.getEnrollment_year());
      getView().showGraduateYear(paramn.getGraduation_year());
      getView().showSchool(paramn.getSchool());
      if ((paramn.getCredits() == null) || (4 != paramn.getCredits().getEducationStatus())) {
        break;
      }
      getView().setHintVisible(0);
      return;
      if (paramn.getCredits() != null)
      {
        if (paramn.getCredits().getEducationStatus() == 4) {
          getView().showTopRightBtn("更新信息", true);
        } else {
          getView().showTopRightBtn("更新信息", true);
        }
      }
      else {
        getView().showTopRightBtn("更新信息", true);
      }
    }
  }
  
  private int b(String paramString)
  {
    return ((Integer)this.l.get(paramString)).intValue();
  }
  
  private String b(int paramInt)
  {
    return (String)this.k.get(Integer.valueOf(paramInt));
  }
  
  public void detachView()
  {
    if (this.a != null)
    {
      this.a.clear();
      this.a = null;
    }
  }
  
  public void getInYear()
  {
    a(1, this.e);
  }
  
  public void getOutYear()
  {
    a(2, this.f);
  }
  
  public void getSchoolName() {}
  
  public void getSchoolType()
  {
    a(3, this.d);
  }
  
  public void getSchoolingDegree()
  {
    a(0, this.c);
  }
  
  public a.b getView()
  {
    if (this.a != null) {
      return (a.b)this.a.get();
    }
    return null;
  }
  
  public void initData()
  {
    a();
    a.b localb = getView();
    if (localb == null) {
      return;
    }
    this.g = (q.O + e.s.y);
    Map localMap = g.buildSignedUserGetSchooling(com.ziroom.commonlibrary.login.a.getToken(localb.getViewContext()));
    j.setGetSchooling(localb.getViewContext(), localMap, true, this.g, new f(getView().getViewContext(), new o())
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        dismissProgress();
        super.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, e paramAnonymouse)
      {
        dismissProgress();
        if (paramAnonymouse.toJSONString().length() > 3)
        {
          paramAnonymouse = (n)com.alibaba.fastjson.a.parseObject(paramAnonymouse.toJSONString(), n.class);
          b.a(b.this, paramAnonymouse);
          return;
        }
        b.a(b.this, null);
      }
    });
  }
  
  public void start() {}
  
  public void submitData(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    if (getView() == null) {
      return;
    }
    this.h = (q.O + e.s.z);
    paramString1 = g.buildSignedUserSetSchooling(paramString1, paramString2, paramString3, paramString4, a(paramString5) + "", b(paramString6) + "");
    j.setSetSchooling(getView().getViewContext(), paramString1, true, this.h, new f(getView().getViewContext(), new o())
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        dismissProgress();
        super.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, e paramAnonymouse)
      {
        dismissProgress();
        if (b.this.getView() == null) {
          return;
        }
        b.this.getView().finishAc();
      }
    });
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/signed/education/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */