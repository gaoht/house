package com.ziroom.ziroomcustomer.intellect;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.alibaba.fastjson.a;
import com.freelxl.baselibrary.e.i.a;
import com.freelxl.baselibrary.e.k;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.activity.IntellectLockActivity;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.e.j;
import com.ziroom.ziroomcustomer.home.ZiRuWebViewActivity;
import com.ziroom.ziroomcustomer.model.LockRoom;
import com.ziroom.ziroomcustomer.model.LockRoomDetail;
import com.ziroom.ziroomcustomer.model.UserInfo;
import com.ziroom.ziroomcustomer.newServiceList.utils.i;
import com.ziroom.ziroomcustomer.util.ad;
import com.ziroom.ziroomcustomer.util.m;
import com.ziroom.ziroomcustomer.util.u;
import com.ziroom.ziroomcustomer.widget.CircleWaveView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONException;
import org.json.JSONObject;

@Instrumented
public class IntellectLockFragment
  extends Fragment
  implements View.OnClickListener
{
  static int c = 1;
  static int d = 2;
  static int e = 3;
  static int f = 4;
  private RelativeLayout A;
  private TextView B;
  private TextView C;
  private TextView D;
  private int E;
  private IntellectLockActivity F;
  private String G;
  private Timer H;
  private Thread I;
  public ImageView a;
  public CircleWaveView b;
  long g = 0L;
  String h;
  Handler i = new Handler();
  b j;
  int k = 59;
  boolean l = false;
  boolean m = false;
  boolean n = false;
  boolean o = false;
  private Context p;
  private boolean q = false;
  private TextView r;
  private TextView s;
  private ImageView t;
  private ImageView u;
  private LockRoomDetail v;
  private LockRoom w;
  private i.a<String> x;
  private String y;
  private RelativeLayout z;
  
  public IntellectLockFragment() {}
  
  public IntellectLockFragment(IntellectLockActivity paramIntellectLockActivity)
  {
    this.F = paramIntellectLockActivity;
  }
  
  private void a(View paramView)
  {
    this.s = ((TextView)paramView.findViewById(2131692371));
    this.t = ((ImageView)paramView.findViewById(2131692370));
    this.t.setOnClickListener(this);
    this.u = ((ImageView)paramView.findViewById(2131692373));
    this.u.setOnClickListener(this);
    this.a = ((ImageView)paramView.findViewById(2131692365));
    this.r = ((TextView)paramView.findViewById(2131692361));
    this.b = ((CircleWaveView)paramView.findViewById(2131692363));
    this.t = ((ImageView)paramView.findViewById(2131692370));
    this.z = ((RelativeLayout)paramView.findViewById(2131692364));
    this.A = ((RelativeLayout)paramView.findViewById(2131692360));
    this.B = ((TextView)paramView.findViewById(2131692366));
    this.C = ((TextView)paramView.findViewById(2131692367));
    this.D = ((TextView)paramView.findViewById(2131692374));
  }
  
  private void a(String paramString)
  {
    g.textToast(this.p, paramString, 1);
  }
  
  private void a(final String paramString, final int paramInt)
  {
    FragmentTransaction localFragmentTransaction = getFragmentManager().beginTransaction();
    Fragment localFragment = getFragmentManager().findFragmentByTag("dialog");
    if (localFragment != null) {
      localFragmentTransaction.remove(localFragment);
    }
    paramString = IntellectDialogFragment.newInstance(paramString);
    paramString.setDialogStyle(paramInt);
    paramString.setOnclickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        if (paramInt == IntellectLockFragment.d)
        {
          IntellectLockFragment.e(IntellectLockFragment.this);
          paramString.dismiss();
        }
        do
        {
          return;
          if (paramInt == IntellectLockFragment.c)
          {
            IntellectLockFragment.c(IntellectLockFragment.this, paramString.getPwd());
            if ((IntellectLockFragment.f(IntellectLockFragment.this) == null) || (IntellectLockFragment.f(IntellectLockFragment.this).length() < 6))
            {
              g.textToast(IntellectLockFragment.g(IntellectLockFragment.this), "请输入六位数密码", 0);
              return;
            }
            IntellectLockFragment.h(IntellectLockFragment.this);
            paramString.dismiss();
            return;
          }
          if (paramInt == IntellectLockFragment.e)
          {
            paramString.dismiss();
            IntellectLockFragment.a(IntellectLockFragment.this, null, IntellectLockFragment.c);
            return;
          }
        } while (paramInt != IntellectLockFragment.f);
        paramString.dismiss();
        IntellectLockFragment.i(IntellectLockFragment.this);
      }
    });
    if (!(paramString instanceof DialogFragment))
    {
      paramString.show(localFragmentTransaction, "dialog");
      return;
    }
    VdsAgent.showDialogFragment((DialogFragment)paramString, localFragmentTransaction, "dialog");
  }
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.z.setBackgroundResource(2130838876);
      this.b.setVisibility(0);
      this.a.setOnClickListener(this);
      return;
    }
    this.z.setBackgroundResource(2130837723);
    this.b.setVisibility(4);
    this.b.stopAnimat();
    this.a.setOnClickListener(null);
  }
  
  private void b()
  {
    setDisableTouch(true);
    a();
    if (this.H == null) {
      this.H = new Timer();
    }
    this.j = new b();
    this.H.schedule(this.j, 1000L, 1000L);
    if (this.v != null)
    {
      this.v.getHouseCode();
      if (ad.getLockLeftTime(this.p) != 0) {
        break label133;
      }
      this.r.setText("60秒后可刷新状态...");
    }
    for (;;)
    {
      ad.saveLockTime(this.p, "", 0);
      this.r.setTextColor(Color.parseColor("#757575"));
      c();
      this.a.setOnClickListener(null);
      this.l = true;
      return;
      label133:
      if ((this.k > 0) && (this.k < 60)) {
        this.r.setText(this.k + "秒后可刷新状态...");
      }
    }
  }
  
  private void b(boolean paramBoolean)
  {
    Object localObject = ApplicationEx.c;
    if ((localObject != null) && (this.w != null))
    {
      localObject = ((ApplicationEx)localObject).getUser();
      if ((this.w != null) && (localObject != null))
      {
        HashMap localHashMap = new HashMap();
        localHashMap.put("contractCode", this.w.getContractCode());
        localHashMap.put("houseCode", this.w.getHouseCode());
        localHashMap.put("houseId", this.w.getHouseCode1());
        localHashMap.put("houseType", this.w.getHouseType());
        localHashMap.put("uid", ((UserInfo)localObject).getUid());
        localHashMap.put("userName", ((UserInfo)localObject).getUser_name());
        localHashMap.put("userPhone", ((UserInfo)localObject).getMobile());
        j.getLockPwdInfo(this.p, localHashMap, this.x, paramBoolean);
      }
    }
  }
  
  private void c()
  {
    this.t.setImageResource(2130838877);
    this.t.setOnClickListener(null);
  }
  
  private void d()
  {
    UserInfo localUserInfo = ((ApplicationEx)((Activity)this.p).getApplication()).getUser();
    HashMap localHashMap;
    if ((this.w != null) && (this.v != null) && (localUserInfo != null))
    {
      localHashMap = new HashMap();
      localHashMap.put("uid", localUserInfo.getUid());
      localHashMap.put("userName", localUserInfo.getUser_name());
      localHashMap.put("userPhone", localUserInfo.getMobile());
      if (!"home_lock".equals(this.v.getDeviceType())) {
        break label259;
      }
      localHashMap.put("houseCode", this.w.getHouseCode1());
    }
    for (;;)
    {
      localHashMap.put("houseId", this.w.getHouseCode1());
      localHashMap.put("userIdentify", this.w.getContractCode());
      localHashMap.put("deviceType", this.v.getDeviceType());
      localHashMap.put("passwordType", Integer.valueOf(1));
      localHashMap.put("receivePhone", localUserInfo.getMobile());
      localHashMap.put("receiveName", localUserInfo.getUser_name());
      if ((this.G != null) && (this.G.length() == 6)) {
        localHashMap.put("password", this.G);
      }
      j.changeIntellectPwdState(this.p, localHashMap, this.x, false, "passwordCus/replacePassword");
      b();
      g.textToast(this.p, "密码下发中", 0);
      this.o = true;
      return;
      label259:
      localHashMap.put("houseCode", this.v.getHouseCode());
    }
  }
  
  private void e()
  {
    UserInfo localUserInfo = ((ApplicationEx)getActivity().getApplication()).getUser();
    HashMap localHashMap;
    if ((this.w != null) && (localUserInfo != null))
    {
      localHashMap = new HashMap();
      localHashMap.put("uid", localUserInfo.getUid());
      localHashMap.put("userName", localUserInfo.getUser_name());
      localHashMap.put("userPhone", localUserInfo.getMobile());
      localHashMap.put("deviceType", this.v.getDeviceType());
      localHashMap.put("houseId", this.w.getHouseCode1());
      if (!"home_lock".equals(this.v.getDeviceType())) {
        break label187;
      }
      localHashMap.put("roomId", this.w.getHouseCode1());
    }
    for (;;)
    {
      localHashMap.put("contractCode", this.w.getContractCode());
      u.d("jdgkljklf", "======  " + a.toJSONString(localHashMap));
      j.getTempPwd(this.p, localHashMap, this.x);
      return;
      label187:
      localHashMap.put("roomId", this.v.getHouseCode());
    }
  }
  
  private void f()
  {
    String str = this.v.getManufactoryPhone();
    if (!TextUtils.isEmpty(str)) {
      startActivity(new Intent("android.intent.action.CALL", Uri.parse("tel:" + str)));
    }
  }
  
  private void g()
  {
    this.I = new Thread(this.b);
    this.b.setThread(this.I);
    this.b.startAnimat();
  }
  
  private void h()
  {
    if (this.v != null)
    {
      String str = ad.getLockTime(this.p);
      int i1 = ad.getLockLeftTime(this.p);
      if (!TextUtils.isEmpty(str))
      {
        long l1 = i.getSecondDiff(str);
        if ((l1 > 0L) && (l1 < i1))
        {
          this.k = (i1 - (int)l1);
          b();
        }
      }
    }
  }
  
  void a()
  {
    if (this.H != null) {
      this.H.purge();
    }
    if (this.j != null) {
      this.j.cancel();
    }
    this.m = false;
  }
  
  public LockRoomDetail getLockRoomData()
  {
    return this.v;
  }
  
  public boolean hasValue()
  {
    return this.v != null;
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    this.p = paramActivity;
  }
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    switch (paramView.getId())
    {
    default: 
    case 2131692370: 
    case 2131692373: 
      do
      {
        return;
        if ((this.w != null) && (this.v != null))
        {
          if (this.v.getOnoffLine() == 1)
          {
            a("为了保证安全,自如不会存放任何明文密码,请牢记您的自定义密码，您的密码将在两分钟内生效", e);
            return;
          }
          if ("已冻结".equals(this.v.getLockStateStr()))
          {
            g.textToast(this.p, "密码已冻结，请联系您的管家");
            return;
          }
          a("门锁离线,使用临时密码紧急进门,接通门锁基站,可再次获取合同密码", d);
          return;
        }
        g.textToast(this.p, "数据错误", 1);
        return;
      } while (this.v == null);
      if ((this.E >= 22) || (this.E < 9))
      {
        a(this.v.getManufactoryName() + this.v.getManufactoryPhone(), f);
        return;
      }
      paramView = new Intent(this.p, ZiRuWebViewActivity.class);
      paramView.putExtra("ziru", "howtocharge");
      paramView.putExtra("url", this.v.getCharge());
      startActivity(paramView);
      return;
    }
    b();
    b(false);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.q = true;
    paramLayoutInflater = paramLayoutInflater.inflate(2130903926, null);
    a(paramLayoutInflater);
    setDataChanged();
    this.x = new a();
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if ((this.b != null) && (this.b.getVisibility() == 0)) {
      this.b.stopAnimat();
    }
  }
  
  public void onHiddenChanged(boolean paramBoolean)
  {
    super.onHiddenChanged(paramBoolean);
    VdsAgent.onFragmentHiddenChanged(this, paramBoolean);
  }
  
  public void onPause()
  {
    VdsAgent.onFragmentPause(this);
    super.onPause();
    if (this.m)
    {
      String str = i.getNowDateTime();
      if (this.v != null) {
        ad.saveLockTime(this.p, str, this.k);
      }
    }
  }
  
  public void onResume()
  {
    VdsAgent.onFragmentResume(this);
    super.onResume();
    h();
  }
  
  public void resetRefreshStyle()
  {
    a();
    this.r.setText("点击图标刷新密码状态");
    if (this.v != null)
    {
      if (this.v.getIsAlarm() != 1) {
        break label83;
      }
      this.r.setTextColor(Color.parseColor("#FF6262"));
    }
    for (;;)
    {
      this.t.setOnClickListener(this);
      this.t.setImageResource(2130840202);
      this.a.setOnClickListener(this);
      setDisableTouch(false);
      this.k = 59;
      return;
      label83:
      this.r.setTextColor(Color.parseColor("#999999"));
    }
  }
  
  public void setDataChanged()
  {
    int i1;
    Drawable localDrawable;
    if (this.q)
    {
      if (this.v == null) {
        break label538;
      }
      this.r.setVisibility(4);
      i1 = this.v.getOnoffLine();
      if (i1 != 1) {
        break label376;
      }
      this.r.setVisibility(0);
      this.r.setTextColor(Color.parseColor("#55FAA9"));
      this.r.setText("点击图标刷新密码状态");
      a(true);
      this.s.setVisibility(0);
      this.t.setImageResource(2130840202);
      i1 = this.v.getPower();
      this.C.setText("电池电量" + i1 + "%");
      this.C.setTextColor(Color.parseColor("#FFFFFF"));
      this.B.setTextColor(Color.parseColor("#FFFFFF"));
      if (this.v.getIsAlarm() != 1) {
        break label326;
      }
      this.B.setText("低电");
      localDrawable = this.p.getResources().getDrawable(2130837725);
      this.r.setTextColor(Color.parseColor("#FF6262"));
      this.b.setColor("#FF6262");
      if ("已冻结".equals(this.v.getLockStateStr())) {
        c();
      }
      g();
      label238:
      localDrawable.setBounds(0, 0, localDrawable.getMinimumWidth(), localDrawable.getMinimumHeight());
      if (Build.VERSION.SDK_INT < 16) {
        break label527;
      }
      this.z.setBackground(localDrawable);
    }
    for (;;)
    {
      this.E = Integer.valueOf(m.getDateByTimestamp(System.currentTimeMillis(), "HH")).intValue();
      if ((this.E < 22) && (this.E > 9)) {
        break label591;
      }
      this.u.setImageResource(2130838879);
      this.D.setText("紧急帮助");
      return;
      label326:
      this.B.setText("正常");
      this.b.setColor("#55FAA9");
      this.r.setTextColor(Color.parseColor("#999999"));
      localDrawable = this.p.getResources().getDrawable(2130837724);
      break;
      label376:
      if (i1 == 2)
      {
        a(false);
        this.t.setImageResource(2130838880);
        this.s.setTextColor(Color.parseColor("#FF8400"));
        this.s.setText("获取临时密码");
        localDrawable = this.p.getResources().getDrawable(2130837723);
        this.r.setVisibility(8);
        this.B.setText("离线");
        this.B.setTextColor(Color.parseColor("#FFFFFF"));
        this.A.setVisibility(0);
        this.r.setText("门锁离线");
        break label238;
      }
      this.r.setVisibility(0);
      this.r.setTextColor(Color.parseColor("#757575"));
      a(false);
      localDrawable = this.p.getResources().getDrawable(2130837723);
      break label238;
      label527:
      this.z.setBackgroundDrawable(localDrawable);
      continue;
      label538:
      a(false);
      this.r.setText("无访问权限");
      this.r.setVisibility(0);
      localDrawable = this.p.getResources().getDrawable(2130837723);
      localDrawable.setBounds(0, 0, localDrawable.getMinimumWidth(), localDrawable.getMinimumHeight());
    }
    label591:
    this.u.setImageResource(2130838878);
    this.D.setText("智能锁说明");
    this.D.setOnClickListener(this);
  }
  
  public void setDisableTouch(boolean paramBoolean)
  {
    this.F.a = paramBoolean;
  }
  
  public void setLockRoomData(LockRoomDetail paramLockRoomDetail)
  {
    this.v = paramLockRoomDetail;
  }
  
  public void setLockRoomInfo(LockRoom paramLockRoom)
  {
    this.w = paramLockRoom;
  }
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    super.setUserVisibleHint(paramBoolean);
    VdsAgent.setFragmentUserVisibleHint(this, paramBoolean);
  }
  
  class a
    implements i.a<String>
  {
    a() {}
    
    public void onParse(String paramString, k paramk)
    {
      paramk.setObject(paramString);
    }
    
    public void onSuccess(k paramk)
    {
      Object localObject;
      String str1;
      if ((paramk != null) && (paramk.getObject() != null))
      {
        u.d("lock-----", "=====   " + a.toJSONString(paramk));
        localObject = (String)paramk.getObject();
        str1 = paramk.getUrl();
        if (str1 != null)
        {
          if (str1.contains("passwordCus/getDynamicPassword")) {
            try
            {
              paramk = new JSONObject((String)localObject);
              if (paramk.getInt("error_code") == 0)
              {
                localObject = (JSONObject)paramk.get("data");
                paramk = ((JSONObject)localObject).getString("passwordCode");
                localObject = ((JSONObject)localObject).getString("invalidTime");
                IntellectLockFragment.a(IntellectLockFragment.this, "临时密码:" + paramk + "\n截止时间:" + (String)localObject);
                IntellectLockFragment.b(IntellectLockFragment.this, IntellectLockFragment.b(IntellectLockFragment.this));
                return;
              }
              paramk = paramk.getString("error_message");
              IntellectLockFragment.b(IntellectLockFragment.this, paramk);
              return;
            }
            catch (JSONException paramk)
            {
              paramk.printStackTrace();
              return;
            }
          }
          if ((!str1.contains("passwordCus/replacePassword")) && (!TextUtils.isEmpty(str1)) && (str1.contains("passwordCus/getPasswordInfo"))) {
            paramk = (String)paramk.getObject();
          }
        }
      }
      for (;;)
      {
        int i;
        String str2;
        String str3;
        String str4;
        try
        {
          paramk = new JSONObject(paramk);
          if (paramk.getInt("error_code") != 0) {
            break label572;
          }
          paramk = (ArrayList)a.parseArray(paramk.getString("data"), LockRoomDetail.class);
          if ((paramk != null) && (paramk.size() > 0))
          {
            i = 0;
            if (i < paramk.size())
            {
              localObject = (LockRoomDetail)paramk.get(i);
              str1 = IntellectLockFragment.c(IntellectLockFragment.this).getRoomCode();
              str2 = IntellectLockFragment.c(IntellectLockFragment.this).getHouseCode();
              str3 = ((LockRoomDetail)localObject).getRoomCode();
              str4 = ((LockRoomDetail)localObject).getHouseCode();
              if ((str1 != null) || (str3 != null) || (str2 != null) || (str4 != null)) {
                break label423;
              }
              IntellectLockFragment.this.h = ((LockRoomDetail)localObject).getLockStateStr();
            }
          }
          if (TextUtils.isEmpty(IntellectLockFragment.this.h)) {
            break label572;
          }
          if (!IntellectLockFragment.this.h.equals("下发中")) {
            break label477;
          }
          paramk = "密码下发中，请耐心等待";
          IntellectLockFragment.b(IntellectLockFragment.this, paramk);
          IntellectLockFragment.this.resetRefreshStyle();
          if (!IntellectLockFragment.this.h.equals("已冻结")) {
            break label572;
          }
          IntellectLockFragment.d(IntellectLockFragment.this);
          return;
        }
        catch (JSONException paramk)
        {
          paramk.printStackTrace();
          return;
        }
        label423:
        if ((str1 != null) && (str3 != null) && (str1.equals(str3)) && (str2 != null) && (str4 != null) && (str2.equals(str4)))
        {
          IntellectLockFragment.this.h = ((LockRoomDetail)localObject).getLockStateStr();
          continue;
          label477:
          if (IntellectLockFragment.this.h.equals("已生效")) {
            paramk = "密码记录已生效";
          } else if (IntellectLockFragment.this.h.equals("下发失败")) {
            paramk = "下发密码失败，请稍后重新尝试";
          } else if (IntellectLockFragment.this.h.equals("已冻结")) {
            paramk = "密码已被冻结，请联系您的管家";
          } else if (IntellectLockFragment.this.h.equals("密码记录不存在")) {
            paramk = "您的密码下发失败，请尝试设置复杂密码";
          } else {
            paramk = IntellectLockFragment.this.h;
          }
        }
        else
        {
          label572:
          i += 1;
        }
      }
    }
  }
  
  class b
    extends TimerTask
  {
    b() {}
    
    public void run()
    {
      IntellectLockFragment.this.i.post(new Runnable()
      {
        public void run()
        {
          if (IntellectLockFragment.this.k > 0)
          {
            TextView localTextView = IntellectLockFragment.a(IntellectLockFragment.this);
            StringBuilder localStringBuilder = new StringBuilder();
            IntellectLockFragment localIntellectLockFragment = IntellectLockFragment.this;
            int i = localIntellectLockFragment.k;
            localIntellectLockFragment.k = (i - 1);
            localTextView.setText(i + "秒后可刷新状态...");
            IntellectLockFragment.this.m = true;
            return;
          }
          IntellectLockFragment.this.k = 0;
          IntellectLockFragment.this.a();
          IntellectLockFragment.this.resetRefreshStyle();
          if (IntellectLockFragment.this.o)
          {
            IntellectLockFragment.this.o = false;
            IntellectLockFragment.a(IntellectLockFragment.this, true);
          }
          IntellectLockFragment.this.l = true;
        }
      });
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/intellect/IntellectLockFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */