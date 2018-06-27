package com.ziroom.ziroomcustomer.activity;

import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.TextView;
import com.alibaba.fastjson.a;
import com.freelxl.baselibrary.e.i.a;
import com.freelxl.baselibrary.e.k;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.MainActivity;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.j;
import com.ziroom.ziroomcustomer.gesturelock.LoginPwdVerifyActivity;
import com.ziroom.ziroomcustomer.intellect.IntellectLockFragment;
import com.ziroom.ziroomcustomer.model.LockRoom;
import com.ziroom.ziroomcustomer.model.LockRoomDetail;
import com.ziroom.ziroomcustomer.model.UserInfo;
import com.ziroom.ziroomcustomer.util.n;
import com.ziroom.ziroomcustomer.util.u;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class IntellectLockActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private List<LockRoom> A;
  private List<LockRoomDetail> B;
  private Dialog C;
  private List<IntellectLockFragment> D;
  private TextView E;
  public boolean a = false;
  boolean b;
  private final String c = "IntellectLockActivity";
  private TextView d;
  private ViewPager e;
  private ImageView f;
  private ViewGroup g;
  private ApplicationEx r;
  private LinearLayout s;
  private IntellectLockFragment t;
  private b u;
  private c v;
  private int w = 0;
  private int x = 0;
  private LockRoom y;
  private LockRoomDetail z;
  
  private void a()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("uid", this.r.getUserId(this));
    j.getLockRoomInfo(this, localHashMap, this.v, false);
  }
  
  private void a(k paramk)
  {
    u.d("lock:  ", "======    " + a.toJSONString(paramk));
    if ((paramk != null) && (!isFinishing()))
    {
      Object localObject = paramk.getUrl();
      if (paramk.getObject() != null)
      {
        if ((!TextUtils.isEmpty((CharSequence)localObject)) && (((String)localObject).contains("passwordCus/getContractHasPassword")))
        {
          try
          {
            paramk = (String)paramk.getObject();
            if (paramk != null)
            {
              this.A = a.parseArray(new JSONObject(paramk).getString("data"), LockRoom.class);
              if ((this.A != null) && (this.A.size() > 0))
              {
                this.y = ((LockRoom)this.A.get(this.w));
                a(this.y);
                if (this.A.size() <= 1) {
                  return;
                }
                this.f.setVisibility(0);
                this.f.setVisibility(0);
                this.f.setOnClickListener(this);
                return;
              }
              d("您的房源暂未使用智能锁或合同状态无效");
              return;
            }
          }
          catch (Exception paramk)
          {
            paramk.printStackTrace();
            g();
            return;
          }
          g();
          return;
        }
        if ((!TextUtils.isEmpty((CharSequence)localObject)) && (((String)localObject).contains("passwordCus/getPasswordInfo")))
        {
          this.g.removeAllViews();
          this.e.setVisibility(0);
          this.g.addView(this.e);
          paramk = (String)paramk.getObject();
          try
          {
            localObject = new JSONObject(paramk);
            i = ((JSONObject)localObject).getInt("error_code");
            paramk = ((JSONObject)localObject).getString("error_message");
            if (i != 0) {
              break label928;
            }
            this.B = a.parseArray(((JSONObject)localObject).getString("data"), LockRoomDetail.class);
            a(this.B);
            if ((this.B == null) || (this.B.size() <= 0)) {
              break label907;
            }
            if (this.B.size() != 1) {
              break label507;
            }
            this.z = ((LockRoomDetail)this.B.get(0));
            setLockRoomTitle(this.z);
            if (this.D.size() > 1)
            {
              i = 1;
              while (i < this.D.size())
              {
                this.D.remove(1);
                i += 1;
              }
              this.u.notifyDataSetChanged();
              if (this.s != null) {
                this.s.setVisibility(4);
              }
            }
            paramk = (LockRoom)this.A.get(this.w);
            ((IntellectLockFragment)this.D.get(0)).setLockRoomInfo(paramk);
            ((IntellectLockFragment)this.D.get(0)).setLockRoomData(this.z);
            ((IntellectLockFragment)this.D.get(0)).setDataChanged();
          }
          catch (JSONException paramk)
          {
            for (;;)
            {
              int i;
              paramk.printStackTrace();
              if (this.D.size() > 1)
              {
                this.e.setCurrentItem(0);
                this.D.remove(1);
                this.u.notifyDataSetChanged();
                continue;
                this.e.setCurrentItem(this.x);
                this.u.notifyDataSetChanged();
              }
            }
          }
          catch (NullPointerException paramk)
          {
            for (;;)
            {
              paramk.printStackTrace();
              this.e.setCurrentItem(0);
              if (this.D.size() > 1)
              {
                this.D.remove(1);
                this.u.notifyDataSetChanged();
                continue;
                localObject = paramk;
                if (TextUtils.isEmpty(paramk)) {
                  localObject = "智能锁信息不存在";
                }
                d((String)localObject);
                continue;
                localObject = paramk;
                if (TextUtils.isEmpty(paramk)) {
                  localObject = "智能锁信息不存在";
                }
                d((String)localObject);
              }
            }
          }
          dismissProgress();
          return;
          label507:
          b(this.B.size());
          this.D.clear();
          i = 0;
          while (i < this.B.size())
          {
            paramk = new IntellectLockFragment(this);
            this.D.add(paramk);
            i += 1;
          }
          if (this.x > this.B.size()) {
            this.x = (this.B.size() - 1);
          }
          this.z = ((LockRoomDetail)this.B.get(this.x));
          if (this.D.size() > 5) {
            ((TextView)this.s.getChildAt(0)).setText(this.x + 1 + " / " + this.B.size());
          }
          for (;;)
          {
            setLockRoomTitle(this.z);
            paramk = (LockRoom)this.A.get(this.w);
            i = 0;
            while (i < this.D.size())
            {
              localObject = (IntellectLockFragment)this.D.get(i);
              this.z = ((LockRoomDetail)this.B.get(i));
              ((IntellectLockFragment)localObject).setLockRoomInfo(paramk);
              ((IntellectLockFragment)localObject).setLockRoomData(this.z);
              ((IntellectLockFragment)localObject).setDataChanged();
              i += 1;
            }
            c(this.x);
          }
        }
      }
      else
      {
        label907:
        label928:
        dismissProgress();
        g();
      }
    }
  }
  
  private void a(LockRoom paramLockRoom)
  {
    UserInfo localUserInfo = this.r.getUser();
    if ((paramLockRoom != null) && (localUserInfo != null))
    {
      this.E.setText(paramLockRoom.getVillageName());
      HashMap localHashMap = new HashMap();
      localHashMap.put("contractCode", paramLockRoom.getContractCode());
      localHashMap.put("houseCode", paramLockRoom.getHouseCode());
      localHashMap.put("houseId", paramLockRoom.getHouseCode1());
      localHashMap.put("houseType", paramLockRoom.getHouseType());
      localHashMap.put("uid", localUserInfo.getUid());
      localHashMap.put("userName", localUserInfo.getUser_name());
      localHashMap.put("userPhone", localUserInfo.getMobile());
      j.getLockPwdInfo(this, localHashMap, this.v, false);
    }
  }
  
  private void a(String paramString, boolean paramBoolean)
  {
    if ((this.f != null) && (paramBoolean)) {
      this.f.setVisibility(4);
    }
    this.e.setVisibility(8);
    if (this.s != null) {
      this.s.setVisibility(4);
    }
    this.d.setText("我的智能锁");
    this.d.setVisibility(8);
    dismissProgress();
    showEmpty(this.g, paramString);
  }
  
  private void a(List<LockRoomDetail> paramList)
  {
    Collections.sort(paramList, new Comparator()
    {
      public int compare(LockRoomDetail paramAnonymousLockRoomDetail1, LockRoomDetail paramAnonymousLockRoomDetail2)
      {
        if (paramAnonymousLockRoomDetail1 == null) {
          if (paramAnonymousLockRoomDetail2 != null) {}
        }
        do
        {
          return 1;
          return -1;
          if (paramAnonymousLockRoomDetail2 == null) {
            return -1;
          }
          if (("home_lock".equals(paramAnonymousLockRoomDetail1.getDeviceType())) && ("home_lock".equals(paramAnonymousLockRoomDetail2.getDeviceType()))) {
            return 0;
          }
          if ("home_lock".equals(paramAnonymousLockRoomDetail1.getDeviceType())) {
            return -1;
          }
        } while ("home_lock".equals(paramAnonymousLockRoomDetail2.getDeviceType()));
        return 0;
      }
    });
  }
  
  private void b()
  {
    this.e = ((ViewPager)findViewById(2131690993));
    this.g = ((ViewGroup)findViewById(2131690992));
    this.e.setPageMargin(n.dip2px(this, 10.0F));
    this.d = ((TextView)findViewById(2131689977));
    this.E = ((TextView)findViewById(2131690990));
    this.f = ((ImageView)findViewById(2131690991));
  }
  
  private void b(int paramInt)
  {
    this.s = ((LinearLayout)findViewById(2131690994));
    if (paramInt > 1)
    {
      if (paramInt <= 5)
      {
        this.s.removeAllViews();
        int j = n.dip2px(this, 1.0F);
        int i = 0;
        while (i < paramInt)
        {
          localObject = new ImageView(this);
          LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(j * 7, j * 7);
          localLayoutParams.rightMargin = (j * 5);
          ((ImageView)localObject).setLayoutParams(localLayoutParams);
          ((ImageView)localObject).setImageDrawable(getResources().getDrawable(2130838870));
          this.s.addView((View)localObject);
          i += 1;
        }
      }
      Object localObject = new TextView(this);
      ((TextView)localObject).setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
      ((TextView)localObject).setTextSize(10.0F);
      this.s.addView((View)localObject);
    }
    this.s.setVisibility(0);
    this.b = true;
  }
  
  private void c(int paramInt)
  {
    if (this.b)
    {
      Drawable localDrawable1 = getResources().getDrawable(2130838869);
      Drawable localDrawable2 = getResources().getDrawable(2130838870);
      int i = 0;
      if (i < this.s.getChildCount())
      {
        ImageView localImageView = (ImageView)this.s.getChildAt(i);
        if (i == paramInt) {
          localImageView.setImageDrawable(localDrawable1);
        }
        for (;;)
        {
          i += 1;
          break;
          localImageView.setImageDrawable(localDrawable2);
        }
      }
    }
    else
    {
      b(-1);
      c(paramInt);
    }
  }
  
  private void d(String paramString)
  {
    a(paramString, false);
  }
  
  private void e()
  {
    findViewById(2131689976).setOnClickListener(this);
    this.e.setOnPageChangeListener(new ViewPager.OnPageChangeListener()
    {
      public void onPageScrollStateChanged(int paramAnonymousInt) {}
      
      public void onPageScrolled(int paramAnonymousInt1, float paramAnonymousFloat, int paramAnonymousInt2) {}
      
      public void onPageSelected(int paramAnonymousInt)
      {
        if ((IntellectLockActivity.a(IntellectLockActivity.this) != null) && (IntellectLockActivity.a(IntellectLockActivity.this).size() > 0))
        {
          IntellectLockFragment localIntellectLockFragment = (IntellectLockFragment)IntellectLockActivity.a(IntellectLockActivity.this).get(paramAnonymousInt);
          LockRoomDetail localLockRoomDetail = localIntellectLockFragment.getLockRoomData();
          if ((localIntellectLockFragment != null) && (localLockRoomDetail != null)) {
            IntellectLockActivity.this.setLockRoomTitle(localLockRoomDetail);
          }
          if ((IntellectLockActivity.c(IntellectLockActivity.this) != null) && (IntellectLockActivity.c(IntellectLockActivity.this).getVisibility() == 0))
          {
            if (IntellectLockActivity.a(IntellectLockActivity.this).size() <= 5) {
              break label223;
            }
            ((TextView)IntellectLockActivity.c(IntellectLockActivity.this).getChildAt(0)).setText(paramAnonymousInt + 1 + " / " + IntellectLockActivity.a(IntellectLockActivity.this).size());
          }
        }
        for (;;)
        {
          IntellectLockActivity.b(IntellectLockActivity.this, paramAnonymousInt);
          return;
          IntellectLockActivity.b(IntellectLockActivity.this).setText("我的智能锁");
          IntellectLockActivity.b(IntellectLockActivity.this).setVisibility(0);
          if (IntellectLockActivity.c(IntellectLockActivity.this) != null) {
            IntellectLockActivity.c(IntellectLockActivity.this).setVisibility(4);
          }
          IntellectLockActivity.d(IntellectLockActivity.this).setLockRoomData(null);
          break;
          label223:
          IntellectLockActivity.a(IntellectLockActivity.this, paramAnonymousInt);
        }
      }
    });
  }
  
  private void f()
  {
    this.D = new ArrayList();
    this.t = new IntellectLockFragment(this);
    this.D.add(this.t);
    this.u = new b(getSupportFragmentManager(), this.D);
    this.e.setAdapter(this.u);
    this.e.setOnTouchListener(new View.OnTouchListener()
    {
      public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        return IntellectLockActivity.this.a;
      }
    });
  }
  
  private void g()
  {
    d("查询智能锁失败，请稍候再试");
  }
  
  private void h()
  {
    this.C = new Dialog(this, 2131427692);
    Object localObject1 = getLayoutInflater().inflate(2130903804, null);
    Object localObject2 = (ListView)((View)localObject1).findViewById(2131693805);
    Object localObject3 = (TextView)((View)localObject1).findViewById(2131691288);
    ((ListView)localObject2).setDivider(new ColorDrawable(Color.parseColor("#E6E6E6")));
    ((ListView)localObject2).setDividerHeight(n.dip2px(this, 0.5F));
    ((ListView)localObject2).setAdapter(new a());
    ((TextView)localObject3).setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        IntellectLockActivity.e(IntellectLockActivity.this).dismiss();
      }
    });
    int i = n.dip2px(this, 48.0F);
    if ((this.A != null) && (this.A.size() >= 3)) {
      i *= 3;
    }
    for (;;)
    {
      if ((this.A != null) && (this.A.size() >= 2)) {
        ((ListView)localObject2).setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
          @Instrumented
          public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
          {
            VdsAgent.onItemClick(this, paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
            IntellectLockActivity.c(IntellectLockActivity.this, paramAnonymousInt);
            IntellectLockActivity.a(IntellectLockActivity.this, (LockRoom)IntellectLockActivity.f(IntellectLockActivity.this).get(paramAnonymousInt));
            IntellectLockActivity.e(IntellectLockActivity.this).dismiss();
            if (IntellectLockActivity.c(IntellectLockActivity.this) != null) {
              IntellectLockActivity.c(IntellectLockActivity.this).setVisibility(4);
            }
            IntellectLockActivity.g(IntellectLockActivity.this);
            IntellectLockActivity.this.setLockRoomTitle(null);
            IntellectLockActivity.this.showProgress("");
          }
        });
      }
      localObject3 = ((ListView)localObject2).getLayoutParams();
      ((ViewGroup.LayoutParams)localObject3).width = -1;
      ((ViewGroup.LayoutParams)localObject3).height = i;
      ((ListView)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject3);
      localObject2 = this.C.getWindow();
      ((Window)localObject2).getDecorView().setPadding(0, 0, 0, 0);
      localObject3 = ((Window)localObject2).getAttributes();
      ((WindowManager.LayoutParams)localObject3).width = -1;
      ((WindowManager.LayoutParams)localObject3).height = -2;
      ((Window)localObject2).setAttributes((WindowManager.LayoutParams)localObject3);
      ((Window)localObject2).getDecorView().setBackgroundColor(Color.parseColor("#FFFFFFFF"));
      ((Window)localObject2).setGravity(80);
      this.C.getWindow().setContentView((View)localObject1);
      localObject1 = this.C;
      if ((localObject1 instanceof Dialog)) {
        break;
      }
      ((Dialog)localObject1).show();
      return;
      i = -2;
    }
    VdsAgent.showDialog((Dialog)localObject1);
  }
  
  private void i()
  {
    this.e.setCurrentItem(0);
    this.x = 0;
    IntellectLockFragment localIntellectLockFragment = (IntellectLockFragment)this.D.get(0);
    localIntellectLockFragment.setLockRoomData(null);
    localIntellectLockFragment.setLockRoomInfo(null);
    localIntellectLockFragment.setDataChanged();
    int j = this.D.size();
    int i = 1;
    while (i < j)
    {
      this.D.remove(1);
      i += 1;
    }
    this.u.setfList(this.D);
    this.u.notifyDataSetChanged();
  }
  
  public void onBackPressed()
  {
    Object localObject = getIntent().getStringExtra("from");
    if (LoginPwdVerifyActivity.class.getName().equals(localObject))
    {
      localObject = new Intent(this, MainActivity.class);
      ((Intent)localObject).putExtra("FRAGMENT_TYPE", 7);
      startActivity((Intent)localObject);
      return;
    }
    super.onBackPressed();
  }
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131689976: 
      onBackPressed();
      return;
    }
    h();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903223);
    this.r = ((ApplicationEx)getApplication());
    b();
    f();
    e();
    this.v = new c();
    a();
    showProgress("");
    this.a = false;
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      onBackPressed();
      return false;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void onStop()
  {
    dismissProgress();
    super.onStop();
  }
  
  public void setLockRoomTitle(LockRoomDetail paramLockRoomDetail)
  {
    if (paramLockRoomDetail != null)
    {
      this.d.setVisibility(0);
      String str = paramLockRoomDetail.getDeviceType();
      if ("home_lock".equals(str)) {
        this.d.setText("大门门锁");
      }
      while (!"room_lock".equals(str)) {
        return;
      }
      paramLockRoomDetail = paramLockRoomDetail.getRoomCode();
      if (!TextUtils.isEmpty(paramLockRoomDetail))
      {
        this.d.setText("内门门锁" + paramLockRoomDetail);
        return;
      }
      this.d.setText("内门门锁");
      return;
    }
    this.d.setText("我的智能锁");
  }
  
  public class a
    extends BaseAdapter
  {
    public a() {}
    
    public int getCount()
    {
      return IntellectLockActivity.f(IntellectLockActivity.this).size();
    }
    
    public Object getItem(int paramInt)
    {
      return null;
    }
    
    public long getItemId(int paramInt)
    {
      return 0L;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      paramViewGroup = paramView;
      if (paramView == null)
      {
        paramView = new IntellectLockActivity.d();
        paramViewGroup = View.inflate(IntellectLockActivity.this, 2130904143, null);
        paramView.a = ((TextView)paramViewGroup.findViewById(2131693248));
        paramView.b = ((TextView)paramViewGroup.findViewById(2131694880));
        paramView.c = ((ImageView)paramViewGroup.findViewById(2131694881));
        paramViewGroup.setTag(paramView);
      }
      paramView = (IntellectLockActivity.d)paramViewGroup.getTag();
      LockRoom localLockRoom = (LockRoom)IntellectLockActivity.f(IntellectLockActivity.this).get(paramInt);
      paramView.a.setText(localLockRoom.getVillageName());
      paramView.b.setText(localLockRoom.getContractCode());
      if (IntellectLockActivity.h(IntellectLockActivity.this) == paramInt)
      {
        paramView.a.setTextColor(Color.parseColor("#FF8400"));
        paramView.c.setVisibility(0);
        return paramViewGroup;
      }
      paramView.a.setTextColor(Color.parseColor("#000000"));
      paramView.c.setVisibility(8);
      return paramViewGroup;
    }
  }
  
  class b
    extends FragmentStatePagerAdapter
  {
    List<IntellectLockFragment> a = null;
    
    public b(List<IntellectLockFragment> paramList)
    {
      super();
      List localList;
      this.a = localList;
    }
    
    public int getCount()
    {
      return this.a.size();
    }
    
    public Fragment getItem(int paramInt)
    {
      return (Fragment)this.a.get(paramInt);
    }
    
    public int getItemPosition(Object paramObject)
    {
      return -2;
    }
    
    public void setfList(List<IntellectLockFragment> paramList)
    {
      this.a = paramList;
    }
  }
  
  public class c
    implements i.a<String>
  {
    public c() {}
    
    public void onParse(String paramString, k paramk)
    {
      u.d("lock-----", "===== str  " + paramString);
      u.d("lock-----", "=====   " + a.toJSONString(paramk));
      paramk.setObject(paramString);
    }
    
    public void onSuccess(k paramk)
    {
      IntellectLockActivity.a(IntellectLockActivity.this, paramk);
    }
  }
  
  static class d
  {
    TextView a;
    TextView b;
    ImageView c;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/activity/IntellectLockActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */