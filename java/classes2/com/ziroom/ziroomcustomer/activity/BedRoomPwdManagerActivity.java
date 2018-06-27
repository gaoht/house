package com.ziroom.ziroomcustomer.activity;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import com.alibaba.fastjson.a;
import com.freelxl.baselibrary.e.i.a;
import com.freelxl.baselibrary.e.k;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.j;
import com.ziroom.ziroomcustomer.model.LockRoom;
import com.ziroom.ziroomcustomer.model.LockRoomDetail;
import com.ziroom.ziroomcustomer.model.PwdManage;
import com.ziroom.ziroomcustomer.model.UserInfo;
import com.ziroom.ziroomcustomer.util.m;
import com.ziroom.ziroomcustomer.util.n;
import com.ziroom.ziroomcustomer.util.u;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class BedRoomPwdManagerActivity
  extends BaseActivity
  implements View.OnClickListener
{
  static long b = 86400000L;
  static long c = 3600000L;
  SimpleDateFormat a;
  private ListView d;
  private UserInfo e;
  private LockRoom f;
  private TextView g;
  private List<PwdManage> r;
  private PwdManage s;
  private int t = -1;
  private LockRoomDetail u;
  private List<PwdManage> v;
  private b w;
  private c x;
  
  private void a(final PwdManage paramPwdManage)
  {
    View localView = LayoutInflater.from(this).inflate(2130903803, null);
    TextView localTextView = (TextView)localView.findViewById(2131689850);
    Button localButton1 = (Button)localView.findViewById(2131692249);
    Button localButton2 = (Button)localView.findViewById(2131690460);
    final AlertDialog localAlertDialog = new AlertDialog.Builder(this, 2131427587).create();
    if ((paramPwdManage != null) && (paramPwdManage.getPasswordType() == 1))
    {
      localTextView.setText("点击「确定」按钮后我们会给你发送一条包含开门密码的短信，您之前的密码将不可用。");
      localButton1.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          BedRoomPwdManagerActivity.c(BedRoomPwdManagerActivity.this, paramPwdManage);
          localAlertDialog.dismiss();
          BedRoomPwdManagerActivity.this.showProgressNoCancel("正在提交,请稍后", 20000L);
        }
      });
      localButton2.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          localAlertDialog.dismiss();
          BedRoomPwdManagerActivity.a(BedRoomPwdManagerActivity.this, -1);
        }
      });
      if ((localAlertDialog instanceof AlertDialog)) {
        break label214;
      }
      localAlertDialog.show();
    }
    for (;;)
    {
      localAlertDialog.setContentView(localView);
      return;
      StringBuffer localStringBuffer = new StringBuffer();
      String str1 = paramPwdManage.getUserName();
      String str2 = paramPwdManage.getUserPhone();
      if (str1 != null) {
        localStringBuffer.append(str1).append("  ");
      }
      if (str2 != null) {
        localStringBuffer.append(str2);
      }
      localTextView.setText("点击「确定」按钮后我们会使该密码失效，" + localStringBuffer.toString() + "将无法进入您房间。");
      break;
      label214:
      VdsAgent.showDialog((AlertDialog)localAlertDialog);
    }
  }
  
  private static String b(int paramInt1, int paramInt2, int paramInt3)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    if (paramInt2 > 0) {
      localStringBuffer.append(paramInt2).append("个月");
    }
    if (paramInt3 > 0) {
      localStringBuffer.append(paramInt3).append("天");
    }
    if (paramInt1 == 1) {
      localStringBuffer.append("后生效");
    }
    for (;;)
    {
      return localStringBuffer.toString();
      localStringBuffer.append("内有效");
    }
  }
  
  private void b()
  {
    this.d = ((ListView)findViewById(2131689979));
    this.d.setDivider(new ColorDrawable(Color.parseColor("#E6E6E6")));
    this.d.setDividerHeight(n.dip2px(this, 0.5F));
    this.g = ((TextView)findViewById(2131689978));
    this.g.setOnClickListener(this);
    findViewById(2131689976).setOnClickListener(this);
  }
  
  private void b(PwdManage paramPwdManage)
  {
    if ((this.f != null) && (this.u != null))
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("uid", this.e.getUid());
      localHashMap.put("userName", this.e.getUser_name());
      localHashMap.put("userPhone", this.e.getMobile());
      if ("home_lock".equals(this.u.getDeviceType()))
      {
        localHashMap.put("houseCode", this.f.getHouseCode1());
        localHashMap.put("houseId", this.f.getHouseCode1());
        localHashMap.put("userIdentify", paramPwdManage.getUserId());
        localHashMap.put("deviceType", this.u.getDeviceType());
        int i = paramPwdManage.getPasswordType();
        localHashMap.put("passwordType", Integer.valueOf(i));
        if (i != 1) {
          break label235;
        }
        localHashMap.put("receivePhone", this.e.getMobile());
        localHashMap.put("receiveName", this.e.getUser_name());
      }
      label235:
      for (paramPwdManage = "passwordCus/replacePassword";; paramPwdManage = "passwordCus/frozenPassword")
      {
        u.e("BedRoomPwdManagerActivity", localHashMap);
        j.changeIntellectPwdState(this, localHashMap, new c(), true, paramPwdManage);
        return;
        localHashMap.put("houseCode", this.f.getHouseCode());
        break;
      }
    }
    g.textToast(this, "数据错误", 1);
  }
  
  public static String caculateLeftString(long paramLong)
  {
    long l1 = paramLong / b;
    long l2 = paramLong / (b * 30L);
    long l3 = paramLong % (b * 30L) / b;
    if (l1 >= 1L) {
      return "";
    }
    StringBuffer localStringBuffer = new StringBuffer();
    if (l1 > 30L)
    {
      localStringBuffer.append(l2).append("个月").append(l3).append("天");
      if (paramLong >= 0L) {
        break label260;
      }
      localStringBuffer.append("后生效");
    }
    for (;;)
    {
      return localStringBuffer.toString();
      if ((l1 >= 1L) && (l1 <= 30L))
      {
        localStringBuffer.append(l1).append("天");
        break;
      }
      if (l1 >= 1L) {
        break;
      }
      l3 = Math.abs(paramLong);
      l1 = l3 / c;
      l2 = l3 / 60000L;
      l3 /= 1000L;
      if ((l1 < 24L) && (l2 > 61L))
      {
        localStringBuffer.append(l1).append("小时");
        break;
      }
      if ((l2 <= 61L) && (l2 > 10L))
      {
        localStringBuffer.append(l2).append("分钟");
        break;
      }
      if (l2 > 10L) {
        break;
      }
      localStringBuffer.append(l3).append("秒");
      break;
      label260:
      localStringBuffer.append("内有效");
    }
  }
  
  private void e()
  {
    if ((this.u != null) && (this.f != null) && (this.e != null))
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("uid", this.e.getUid());
      localHashMap.put("userName", this.e.getUser_name());
      localHashMap.put("userPhone", this.e.getMobile());
      localHashMap.put("houseCode", this.u.getHouseCode());
      localHashMap.put("houseId", this.f.getHouseCode1());
      System.out.println(localHashMap.toString());
      if (this.x == null) {
        this.x = new c();
      }
      j.getUnlockList(this, localHashMap, this.x, false);
      return;
    }
    g.textToast(this, "数据错误", 1);
  }
  
  void a()
  {
    showProgress("正在加载数据,请后");
    e();
  }
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    switch (paramView.getId())
    {
    case 2131689977: 
    default: 
    case 2131689978: 
      do
      {
        return;
      } while (this.s == null);
      if ("生效".equals(this.s.getStatus()))
      {
        a(this.s);
        return;
      }
      g.textToast(this, "密码状态不允许更换", 0);
      return;
    }
    finish();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903105);
    this.a = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    b();
    this.r = new ArrayList();
    try
    {
      this.f = ((LockRoom)a.parseObject(getIntent().getStringExtra("lockRoomInfo"), LockRoom.class));
      this.u = ((LockRoomDetail)a.parseObject(getIntent().getStringExtra("lockRoomDetail"), LockRoomDetail.class));
      this.e = ((ApplicationEx)getApplication()).getUser();
      e();
      this.v = new ArrayList();
      this.w = new b(this, this.v);
      showProgress("正在加载数据");
      return;
    }
    catch (Exception paramBundle)
    {
      for (;;)
      {
        paramBundle.printStackTrace();
      }
    }
  }
  
  protected void onStop()
  {
    dismissProgress();
    super.onStop();
  }
  
  static class a
  {
    TextView a;
    TextView b;
    TextView c;
    TextView d;
  }
  
  class b
    extends BaseAdapter
  {
    Context a;
    List<PwdManage> b;
    
    public b(List<PwdManage> paramList)
    {
      this.a = paramList;
      List localList;
      this.b = localList;
    }
    
    public int getCount()
    {
      return this.b.size();
    }
    
    public Object getItem(int paramInt)
    {
      return null;
    }
    
    public long getItemId(int paramInt)
    {
      return 0L;
    }
    
    public View getView(final int paramInt, final View paramView, ViewGroup paramViewGroup)
    {
      paramViewGroup = paramView;
      if (paramView == null)
      {
        paramView = new BedRoomPwdManagerActivity.a();
        paramViewGroup = View.inflate(this.a, 2130904129, null);
        paramView.a = ((TextView)paramViewGroup.findViewById(2131694847));
        paramView.b = ((TextView)paramViewGroup.findViewById(2131694848));
        paramView.c = ((TextView)paramViewGroup.findViewById(2131694849));
        paramView.d = ((TextView)paramViewGroup.findViewById(2131694850));
        paramViewGroup.setTag(paramView);
      }
      BedRoomPwdManagerActivity.a locala = (BedRoomPwdManagerActivity.a)paramViewGroup.getTag();
      paramView = (PwdManage)this.b.get(paramInt);
      if (paramView.getPasswordType() == 1) {
        BedRoomPwdManagerActivity.d(BedRoomPwdManagerActivity.this).add(paramView);
      }
      Object localObject = new StringBuffer();
      String str1 = paramView.getUserName();
      String str2 = paramView.getUserPhone();
      if (str1 != null) {
        ((StringBuffer)localObject).append(str1).append("  ");
      }
      if (str2 != null) {
        ((StringBuffer)localObject).append(str2);
      }
      locala.b.setText(((StringBuffer)localObject).toString());
      locala.a.setText(paramView.getCreateTime());
      if (paramView.getPasswordType() == 1)
      {
        localObject = paramView.getStatus();
        BedRoomPwdManagerActivity.a(BedRoomPwdManagerActivity.this, paramView);
        if ("生效".equals(localObject))
        {
          locala.d.setText("更换");
          locala.b.setTextColor(Color.parseColor("#111111"));
          locala.d.setTextColor(Color.parseColor("#FF8400"));
          locala.d.setOnClickListener(new View.OnClickListener()
          {
            @Instrumented
            public void onClick(View paramAnonymousView)
            {
              VdsAgent.onClick(this, paramAnonymousView);
              BedRoomPwdManagerActivity.a(BedRoomPwdManagerActivity.this, paramInt);
              BedRoomPwdManagerActivity.b(BedRoomPwdManagerActivity.this, paramView);
            }
          });
        }
      }
      for (;;)
      {
        localObject = paramView.getBegin();
        paramView = paramView.getEnd();
        if (paramView != null) {
          break;
        }
        locala.c.setText("永久生效");
        return paramViewGroup;
        locala.d.setText(paramView.getStatus());
        locala.d.setOnClickListener(null);
        locala.d.setTextColor(Color.parseColor("#111111"));
        continue;
        localObject = paramView.getStatus();
        locala.b.setTextColor(Color.parseColor("#FF5544"));
        if (localObject != null) {
          if (("已冻结".equals(localObject)) || ("冻结中".equals(localObject)))
          {
            locala.d.setText(paramView.getStatus());
            locala.d.setOnClickListener(null);
            locala.d.setTextColor(Color.parseColor("#111111"));
          }
          else
          {
            locala.d.setText("冻结");
            locala.d.setTextColor(Color.parseColor("#55AADD"));
            locala.d.setOnClickListener(new View.OnClickListener()
            {
              @Instrumented
              public void onClick(View paramAnonymousView)
              {
                VdsAgent.onClick(this, paramAnonymousView);
                BedRoomPwdManagerActivity.a(BedRoomPwdManagerActivity.this, paramInt);
                BedRoomPwdManagerActivity.b(BedRoomPwdManagerActivity.this, paramView);
              }
            });
          }
        }
      }
      long l = m.caculateLeftTime((String)localObject, paramView, BedRoomPwdManagerActivity.this.a);
      if (Math.abs(l) >= BedRoomPwdManagerActivity.b) {
        paramView = m.caculateDayAndMonth2((String)localObject, paramView, BedRoomPwdManagerActivity.this.a);
      }
      for (paramView = BedRoomPwdManagerActivity.a(paramView[0], paramView[1], paramView[2]);; paramView = BedRoomPwdManagerActivity.caculateLeftString(l))
      {
        locala.c.setText(paramView);
        return paramViewGroup;
      }
    }
    
    public void setList(List<PwdManage> paramList)
    {
      this.b = paramList;
    }
  }
  
  public class c
    implements i.a<String>
  {
    public c() {}
    
    public void onParse(String paramString, k paramk)
    {
      u.e("BedRoomPwdManagerActivity", paramString);
      paramk.setObject(paramString);
    }
    
    public void onSuccess(k paramk)
    {
      if (paramk != null)
      {
        String str = paramk.getUrl();
        paramk = (String)paramk.getObject();
        if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty(paramk)))
        {
          if (str.contains("passwordCus/getPasswords"))
          {
            try
            {
              paramk = new JSONObject(paramk);
              str = paramk.getString("data");
              if ((str != null) && ((str == null) || (!"[]".equals(str)))) {
                break label106;
              }
              str = paramk.getString("error_message");
              paramk = str;
              if (str == null) {
                paramk = "获取内容错误";
              }
              g.textToast(BedRoomPwdManagerActivity.this, paramk, 1);
            }
            catch (Exception paramk)
            {
              for (;;)
              {
                g.textToast(BedRoomPwdManagerActivity.this, "获取内容错误", 1);
                continue;
                g.textToast(BedRoomPwdManagerActivity.this, "未获取到密码数据", 1);
              }
            }
            BedRoomPwdManagerActivity.this.dismissProgress();
          }
          label106:
          int i;
          do
          {
            return;
            BedRoomPwdManagerActivity.a(BedRoomPwdManagerActivity.this, a.parseArray(str, PwdManage.class));
            if ((BedRoomPwdManagerActivity.a(BedRoomPwdManagerActivity.this) != null) && (BedRoomPwdManagerActivity.a(BedRoomPwdManagerActivity.this).size() > 0))
            {
              BedRoomPwdManagerActivity.b(BedRoomPwdManagerActivity.this).setList(BedRoomPwdManagerActivity.a(BedRoomPwdManagerActivity.this));
              BedRoomPwdManagerActivity.c(BedRoomPwdManagerActivity.this).setAdapter(BedRoomPwdManagerActivity.b(BedRoomPwdManagerActivity.this));
              break;
            }
            if (str.contains("passwordCus/frozenPassword")) {
              for (;;)
              {
                try
                {
                  paramk = new JSONObject(paramk);
                  i = paramk.getInt("error_code");
                  str = paramk.getString("error_message");
                  if (i != 0) {
                    continue;
                  }
                  paramk = str;
                  if (str == null) {
                    paramk = "冻结成功";
                  }
                  BedRoomPwdManagerActivity.this.a();
                  g.textToast(BedRoomPwdManagerActivity.this, paramk, 1);
                }
                catch (JSONException paramk)
                {
                  paramk.printStackTrace();
                  g.textToast(BedRoomPwdManagerActivity.this, "冻结失败", 1);
                  continue;
                }
                BedRoomPwdManagerActivity.this.dismissProgress();
                return;
                paramk = str;
                if (str == null) {
                  paramk = "冻结失败";
                }
              }
            }
          } while (!str.contains("passwordCus/replacePassword"));
          for (;;)
          {
            try
            {
              paramk = new JSONObject(paramk);
              i = paramk.getInt("error_code");
              str = paramk.getString("error_message");
              if (i != 0) {
                continue;
              }
              paramk = str;
              if (str == null) {
                paramk = "更换成功";
              }
              BedRoomPwdManagerActivity.this.a();
              g.textToast(BedRoomPwdManagerActivity.this, paramk, 1);
            }
            catch (JSONException paramk)
            {
              paramk.printStackTrace();
              g.textToast(BedRoomPwdManagerActivity.this, "数据错误", 1);
              continue;
            }
            BedRoomPwdManagerActivity.this.dismissProgress();
            return;
            paramk = str;
            if (str == null) {
              paramk = "系统错误";
            }
          }
        }
        BedRoomPwdManagerActivity.this.dismissProgress();
        g.textToast(BedRoomPwdManagerActivity.this, "数据错误", 1);
        return;
      }
      BedRoomPwdManagerActivity.this.dismissProgress();
      g.textToast(BedRoomPwdManagerActivity.this, "数据错误", 1);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/activity/BedRoomPwdManagerActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */