package com.ziroom.ziroomcustomer.minsu.chat;

import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.provider.MediaStore.Images.Media;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.u;
import android.text.ClipboardManager;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.widget.Toast;
import cn.dreamtobe.kpswitch.b.a.b;
import cn.dreamtobe.kpswitch.widget.KPSwitchPanelFrameLayout;
import com.freelxl.baselibrary.d.f.e;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.hyphenate.EMMessageListener;
import com.hyphenate.chat.EMChatManager;
import com.hyphenate.chat.EMChatRoomManager;
import com.hyphenate.chat.EMClient;
import com.hyphenate.chat.EMConversation;
import com.hyphenate.chat.EMConversation.EMConversationType;
import com.hyphenate.chat.EMImageMessageBody;
import com.hyphenate.chat.EMMessage;
import com.hyphenate.chat.EMMessage.ChatType;
import com.hyphenate.chat.EMMessage.Direct;
import com.hyphenate.chat.EMMessage.Status;
import com.hyphenate.chat.EMTextMessageBody;
import com.hyphenate.util.PathUtil;
import com.ziroom.ziroomcustomer.MainActivity;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseFragment;
import com.ziroom.ziroomcustomer.minsu.activity.MinsuHouseDetailActivity;
import com.ziroom.ziroomcustomer.minsu.adapter.h;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuHouseBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuHouseBean.DataBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuHouseBean.DataBean.ListBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuImReplyCommonBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuImReplyCommonBean.DataBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuImReplyCommonBean.DataBean.ListMsgBean;
import com.ziroom.ziroomcustomer.minsu.bean.OrderStatusEnum;
import com.ziroom.ziroomcustomer.minsu.f.aa;
import com.ziroom.ziroomcustomer.minsu.f.ad;
import com.ziroom.ziroomcustomer.minsu.f.k;
import com.ziroom.ziroomcustomer.minsu.landlord.activity.MinsuLandLordMainNewActivity;
import com.ziroom.ziroomcustomer.minsu.tenant.MinsuLandlordDetailActivty;
import com.ziroom.ziroomcustomer.minsu.view.CommonTitle;
import com.ziroom.ziroomcustomer.minsu.view.MyChatEditText;
import com.ziroom.ziroomcustomer.minsu.view.b.e.a;
import com.ziroom.ziroomcustomer.minsu.view.b.f.a;
import com.ziroom.ziroomcustomer.newchat.ExpandGridView;
import com.ziroom.ziroomcustomer.newchat.SmileUtils;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.util.m;
import com.ziroom.ziroomcustomer.util.u;
import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MinsuChatFragment
  extends BaseFragment
  implements View.OnClickListener, EMMessageListener
{
  private int A;
  private String B;
  private String C;
  private int D = 1;
  private String E;
  private String F;
  private String G;
  private boolean H = false;
  private String I;
  private String J;
  private String K;
  private String L;
  private String M;
  private int N = 1;
  private com.ziroom.ziroomcustomer.minsu.adapter.n O = null;
  private h P = null;
  private List<MinsuImReplyCommonBean.DataBean.ListMsgBean> Q;
  private int R = 0;
  private List<String> S;
  private ViewPager T;
  private LinearLayout U;
  private ImageView V;
  private ImageView W;
  private View X;
  private TextView Y;
  private KPSwitchPanelFrameLayout Z;
  protected Bundle a;
  private Handler aa = new Handler(Looper.getMainLooper())
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      super.handleMessage(paramAnonymousMessage);
      MinsuChatFragment.a(MinsuChatFragment.this, 3);
      MinsuChatFragment.u(MinsuChatFragment.this);
    }
  };
  protected int b;
  protected String c;
  protected MinsuChatMessageList d;
  protected EMConversation e;
  protected InputMethodManager f;
  protected ClipboardManager g;
  protected Handler h = new Handler();
  protected File i;
  protected SwipeRefreshLayout j;
  protected ListView k;
  protected boolean l;
  protected boolean m = true;
  protected int n = 20;
  protected EMMessage o;
  int p;
  protected a q;
  protected BroadcastReceiver r = new BroadcastReceiver()
  {
    public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      MinsuChatFragment.this.d.refresh();
    }
  };
  private boolean s;
  private CommonTitle t;
  private TextView u;
  private ImageView v;
  private ImageView w;
  private ImageView x;
  private MyChatEditText y;
  private String z;
  
  private void A()
  {
    String str = this.y.getText().toString();
    if (f(str)) {
      return;
    }
    c(str);
    this.y.setText("");
  }
  
  private void B()
  {
    this.S = getExpressionRes(35);
    final ArrayList localArrayList = new ArrayList();
    View localView = b(1);
    Object localObject = b(2);
    localArrayList.add(localView);
    localArrayList.add(localObject);
    localArrayList.add(com.ziroom.ziroomcustomer.minsu.chat.b.b.getBigExpressionView(getActivity(), 1, new com.ziroom.ziroomcustomer.minsu.chat.c.a()
    {
      public void onClick(String paramAnonymousString)
      {
        MinsuChatFragment.this.a(MinsuChatFragment.this.c, paramAnonymousString);
      }
    }));
    localArrayList.add(com.ziroom.ziroomcustomer.minsu.chat.b.b.getBigExpressionView(getActivity(), 2, new com.ziroom.ziroomcustomer.minsu.chat.c.a()
    {
      public void onClick(String paramAnonymousString)
      {
        MinsuChatFragment.this.a(MinsuChatFragment.this.c, paramAnonymousString);
      }
    }));
    this.T.setOffscreenPageLimit(4);
    this.T.setAdapter(new com.ziroom.ziroomcustomer.minsu.chat.b.d(localArrayList));
    this.U.removeAllViews();
    int i1 = 0;
    while (i1 < 2)
    {
      localView = new View(getActivity());
      localObject = new LinearLayout.LayoutParams(com.ziroom.ziroomcustomer.util.n.dip2px(getActivity(), 8.0F), com.ziroom.ziroomcustomer.util.n.dip2px(getActivity(), 8.0F));
      ((LinearLayout.LayoutParams)localObject).leftMargin = com.ziroom.ziroomcustomer.util.n.dip2px(getActivity(), 7.0F);
      localView.setBackgroundResource(2130839308);
      localView.setEnabled(true);
      localView.setId(i1);
      this.U.addView(localView, (ViewGroup.LayoutParams)localObject);
      i1 += 1;
    }
    this.T.addOnPageChangeListener(new ViewPager.OnPageChangeListener()
    {
      public void onPageScrollStateChanged(int paramAnonymousInt) {}
      
      public void onPageScrolled(int paramAnonymousInt1, float paramAnonymousFloat, int paramAnonymousInt2) {}
      
      public void onPageSelected(int paramAnonymousInt)
      {
        int i = paramAnonymousInt % localArrayList.size();
        paramAnonymousInt = 0;
        if (paramAnonymousInt < 2)
        {
          if (paramAnonymousInt == i % 2) {
            MinsuChatFragment.v(MinsuChatFragment.this).findViewById(paramAnonymousInt).setEnabled(false);
          }
          for (;;)
          {
            paramAnonymousInt += 1;
            break;
            MinsuChatFragment.v(MinsuChatFragment.this).findViewById(paramAnonymousInt).setEnabled(true);
          }
        }
        switch (i)
        {
        default: 
          return;
        case 0: 
        case 1: 
          MinsuChatFragment.w(MinsuChatFragment.this).setSelected(true);
          MinsuChatFragment.x(MinsuChatFragment.this).setSelected(false);
          return;
        }
        MinsuChatFragment.w(MinsuChatFragment.this).setSelected(false);
        MinsuChatFragment.x(MinsuChatFragment.this).setSelected(true);
      }
    });
    this.U.getChildAt(0).setEnabled(false);
  }
  
  private void a(int paramInt)
  {
    this.R = paramInt;
    switch (paramInt)
    {
    default: 
      if (paramInt != 5)
      {
        this.w.setImageResource(2130840230);
        if (this.v != null) {
          this.v.setImageResource(2130840298);
        }
      }
      break;
    }
    for (;;)
    {
      if (paramInt != 1) {
        break label464;
      }
      t();
      return;
      getView().findViewById(2131696860).setVisibility(8);
      getView().findViewById(2131694554).setVisibility(8);
      this.X.setVisibility(8);
      this.Z.setVisibility(8);
      this.x.setImageResource(2130840233);
      break;
      getView().findViewById(2131696860).setVisibility(8);
      getView().findViewById(2131694554).setVisibility(8);
      this.X.setVisibility(8);
      this.Z.setVisibility(8);
      this.x.setImageResource(2130840233);
      break;
      this.Z.setVisibility(0);
      getView().findViewById(2131696860).setVisibility(0);
      getView().findViewById(2131694554).setVisibility(8);
      this.X.setVisibility(8);
      this.x.setImageResource(2130840227);
      break;
      this.Z.setVisibility(0);
      getView().findViewById(2131696860).setVisibility(0);
      getView().findViewById(2131694554).setVisibility(8);
      this.X.setVisibility(8);
      this.x.setImageResource(2130840227);
      break;
      this.Z.setVisibility(0);
      getView().findViewById(2131696860).setVisibility(8);
      getView().findViewById(2131694554).setVisibility(0);
      this.X.setVisibility(8);
      this.x.setImageResource(2130840233);
      break;
      this.Z.setVisibility(0);
      getView().findViewById(2131696860).setVisibility(8);
      getView().findViewById(2131694554).setVisibility(8);
      this.X.setVisibility(0);
      break;
      this.w.setImageResource(2130840232);
      if (this.v != null) {
        this.v.setImageResource(2130840299);
      }
    }
    label464:
    l();
  }
  
  private void a(final MinsuHouseBean.DataBean paramDataBean, String paramString1, String paramString2)
  {
    if (this.O == null)
    {
      this.O = new com.ziroom.ziroomcustomer.minsu.adapter.n(getActivity(), paramDataBean, paramString1, paramString2);
      this.O.setmOnItemClickListener(new e.a()
      {
        public void onItemClick(View paramAnonymousView, RecyclerView.u paramAnonymousu, int paramAnonymousInt)
        {
          if ((paramDataBean != null) && (!com.ziroom.ziroomcustomer.minsu.f.c.isNullList(paramDataBean.list)) && (paramAnonymousInt >= paramDataBean.list.size())) {
            return;
          }
          paramAnonymousView = (MinsuHouseBean.DataBean.ListBean)paramDataBean.list.get(paramAnonymousInt);
          paramAnonymousu = new ArrayList();
          paramAnonymousu.add(paramAnonymousView);
          MinsuChatFragment.this.a(paramAnonymousu);
        }
        
        public boolean onItemLongClick(View paramAnonymousView, RecyclerView.u paramAnonymousu, int paramAnonymousInt)
        {
          return false;
        }
      });
    }
    for (;;)
    {
      paramDataBean = (RecyclerView)getView().findViewById(2131696860);
      paramString1 = new LinearLayoutManager(getActivity());
      paramString1.setOrientation(0);
      paramDataBean.setLayoutManager(paramString1);
      paramDataBean.addItemDecoration(((f.a)new f.a(getActivity()).color(-1)).build());
      paramDataBean.setAdapter(this.O);
      return;
      this.O.notifyDataSetChanged();
    }
  }
  
  private void a(MinsuImReplyCommonBean.DataBean paramDataBean)
  {
    this.Q = paramDataBean.listMsg;
    if (this.P == null)
    {
      this.P = new h(getActivity(), paramDataBean);
      this.P.setmOnItemClickListener(new e.a()
      {
        public void onItemClick(View paramAnonymousView, RecyclerView.u paramAnonymousu, int paramAnonymousInt)
        {
          if ((MinsuChatFragment.s(MinsuChatFragment.this) != null) && (MinsuChatFragment.s(MinsuChatFragment.this).size() > paramAnonymousInt))
          {
            paramAnonymousView = (MinsuImReplyCommonBean.DataBean.ListMsgBean)MinsuChatFragment.s(MinsuChatFragment.this).get(paramAnonymousInt);
            if (!TextUtils.isEmpty(paramAnonymousView.content)) {
              MinsuChatFragment.this.c(paramAnonymousView.content);
            }
            return;
          }
          MinsuChatFragment.t(MinsuChatFragment.this);
        }
        
        public boolean onItemLongClick(View paramAnonymousView, RecyclerView.u paramAnonymousu, int paramAnonymousInt)
        {
          return false;
        }
      });
    }
    for (;;)
    {
      paramDataBean = (RecyclerView)getView().findViewById(2131696860);
      LinearLayoutManager localLinearLayoutManager = new LinearLayoutManager(getActivity());
      localLinearLayoutManager.setOrientation(1);
      paramDataBean.setLayoutManager(localLinearLayoutManager);
      paramDataBean.addItemDecoration(((com.ziroom.ziroomcustomer.minsu.view.b.c.a)((com.ziroom.ziroomcustomer.minsu.view.b.c.a)new com.ziroom.ziroomcustomer.minsu.view.b.c.a(getActivity()).color(getResources().getColor(2131624047))).sizeResId(2131231170)).build());
      paramDataBean.setAdapter(this.P);
      return;
      this.P.setData(this.Q);
    }
  }
  
  private View b(int paramInt)
  {
    View localView = View.inflate(getActivity(), 2130903884, null);
    ExpandGridView localExpandGridView = (ExpandGridView)localView.findViewById(2131689486);
    final Object localObject = new ArrayList();
    if (paramInt == 1) {
      ((List)localObject).addAll(this.S.subList(0, 20));
    }
    for (;;)
    {
      ((List)localObject).add("zrk_ic_fdmsgs_del");
      localObject = new com.ziroom.ziroomcustomer.minsu.chat.b.a(getActivity(), 0, (List)localObject);
      localExpandGridView.setAdapter((ListAdapter)localObject);
      localExpandGridView.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        @Instrumented
        public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          VdsAgent.onItemClick(this, paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
          paramAnonymousAdapterView = (String)localObject.getItem(paramAnonymousInt);
          u.e("filename: ", paramAnonymousAdapterView);
          if (TextUtils.isEmpty(paramAnonymousAdapterView)) {}
          do
          {
            do
            {
              return;
              if (paramAnonymousAdapterView != "zrk_ic_fdmsgs_del") {}
              int i;
              try
              {
                paramAnonymousAdapterView = Class.forName("com.ziroom.ziroomcustomer.newchat.SmileUtils").getField(paramAnonymousAdapterView);
                MinsuChatFragment.a(MinsuChatFragment.this).append(SmileUtils.getSmiledText(MinsuChatFragment.this.getActivity(), (String)paramAnonymousAdapterView.get(null)));
                return;
              }
              catch (Exception paramAnonymousAdapterView) {}
            } while (TextUtils.isEmpty(MinsuChatFragment.a(MinsuChatFragment.this).getText()));
            paramAnonymousInt = MinsuChatFragment.a(MinsuChatFragment.this).getSelectionStart();
          } while (paramAnonymousInt <= 0);
          paramAnonymousAdapterView = MinsuChatFragment.a(MinsuChatFragment.this).getText().toString().substring(0, paramAnonymousInt);
          i = paramAnonymousAdapterView.lastIndexOf("[");
          if (i != -1)
          {
            if (SmileUtils.containsKey(paramAnonymousAdapterView.substring(i, paramAnonymousInt).toString()))
            {
              MinsuChatFragment.a(MinsuChatFragment.this).getEditableText().delete(i, paramAnonymousInt);
              return;
            }
            MinsuChatFragment.a(MinsuChatFragment.this).getEditableText().delete(paramAnonymousInt - 1, paramAnonymousInt);
            return;
          }
          MinsuChatFragment.a(MinsuChatFragment.this).getEditableText().delete(paramAnonymousInt - 1, paramAnonymousInt);
          return;
        }
      });
      return localView;
      if (paramInt == 2)
      {
        ((List)localObject).addAll(this.S.subList(20, this.S.size()));
        if (((List)localObject).size() < 20) {
          while (((List)localObject).size() < 20) {
            ((List)localObject).add("");
          }
        }
      }
    }
  }
  
  private void b(EMMessage paramEMMessage)
  {
    String str2 = paramEMMessage.getStringAttribute("fid", "");
    int i1 = Integer.parseInt(paramEMMessage.getStringAttribute("rentWay", ""));
    String str3 = paramEMMessage.getStringAttribute("startDate", "");
    String str4 = paramEMMessage.getStringAttribute("endDate", "");
    if (TextUtils.isEmpty(this.F)) {}
    for (String str1 = "0";; str1 = this.F)
    {
      paramEMMessage.getStringAttribute("isTop50Online", str1);
      str1 = paramEMMessage.getStringAttribute("houseName", "");
      paramEMMessage = paramEMMessage.getStringAttribute("personNum", "");
      k.toLLApplyDetail(getActivity(), str2, i1, str3, str4, str1, paramEMMessage);
      return;
    }
  }
  
  private void c(EMMessage paramEMMessage)
  {
    try
    {
      Object localObject = (EMTextMessageBody)paramEMMessage.getBody();
      String str3 = paramEMMessage.getStringAttribute("fid", "");
      int i1 = Integer.parseInt(paramEMMessage.getStringAttribute("rentWay", ""));
      String str2 = ((EMTextMessageBody)localObject).getMessage();
      String str4 = paramEMMessage.getStringAttribute("startDate", "");
      String str5 = paramEMMessage.getStringAttribute("endDate", "");
      String str1 = c.getUserName(paramEMMessage.getTo());
      localObject = str2;
      if (j.isImError(str2)) {
        localObject = "";
      }
      str2 = paramEMMessage.getStringAttribute("houseName", "");
      FragmentActivity localFragmentActivity = getActivity();
      OrderStatusEnum localOrderStatusEnum = OrderStatusEnum.YD;
      paramEMMessage = str1;
      if (ae.isNull(str1)) {
        paramEMMessage = "";
      }
      k.toMinsuApplyActivity(localFragmentActivity, localOrderStatusEnum, str3, str2, i1, str4, str5, paramEMMessage, (String)localObject);
      return;
    }
    catch (Exception paramEMMessage)
    {
      paramEMMessage.printStackTrace();
    }
  }
  
  private boolean f(String paramString)
  {
    int i1 = aa.getInt(ApplicationEx.c, "imConMax", 400);
    if (paramString.length() > i1)
    {
      showToast("字数超出限制");
      return true;
    }
    return false;
  }
  
  private String g(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (1 == this.D) {
      localStringBuilder.append("房东");
    }
    for (;;)
    {
      String str = c.getUserName4N(com.ziroom.ziroomcustomer.minsu.e.d.getUid());
      if (!TextUtils.isEmpty(str)) {
        localStringBuilder.append(str);
      }
      localStringBuilder.append(":").append(paramString);
      return localStringBuilder.toString();
      if (2 == this.D) {
        localStringBuilder.append("房客");
      }
    }
  }
  
  private void h(String paramString)
  {
    if (ae.isNull(paramString)) {
      return;
    }
    paramString = j.removeEMPrefix(paramString);
    Intent localIntent = new Intent(getActivity(), MinsuLandlordDetailActivty.class);
    localIntent.putExtra("uid", paramString);
    startActivity(localIntent);
  }
  
  private void m()
  {
    this.a = getArguments();
    this.b = this.a.getInt("chatType", 1);
    this.c = this.a.getString("userId");
    this.E = this.a.getString("fid");
    this.A = this.a.getInt("rentWay");
    this.B = this.a.getString("rentWayName");
    this.F = this.a.getString("isTop50Online");
    this.G = this.a.getString("from");
    this.C = this.a.getString("housePicUrl");
    this.D = this.a.getInt("msgSenderType");
    this.z = this.a.getString("houseName");
    this.I = this.a.getString("lName");
    this.L = this.a.getString("startDate");
    this.M = this.a.getString("endDate");
    this.K = this.a.getString("personNum");
    this.J = this.a.getString("purpose");
    c();
    d();
    q();
    B();
    n();
    i();
  }
  
  private void n()
  {
    IntentFilter localIntentFilter = new IntentFilter("action_sync_im_succ");
    LocalBroadcastManager.getInstance(getActivity()).registerReceiver(this.r, localIntentFilter);
  }
  
  private void o()
  {
    getView().findViewById(2131696860).setVisibility(8);
  }
  
  private void p() {}
  
  private void q()
  {
    if (this.D == 1) {}
    for (int i1 = 1;; i1 = 0)
    {
      this.u = ((TextView)getView().findViewById(2131691438));
      this.u.setOnClickListener(this);
      this.y.addTextChangedListener(new TextWatcher()
      {
        public void afterTextChanged(Editable paramAnonymousEditable) {}
        
        public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        
        public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          if (ae.isNull(MinsuChatFragment.a(MinsuChatFragment.this).getText().toString()))
          {
            MinsuChatFragment.e(MinsuChatFragment.this).setTextColor(ApplicationEx.c.getResources().getColor(2131624046));
            MinsuChatFragment.e(MinsuChatFragment.this).setEnabled(false);
            if (MinsuChatFragment.f(MinsuChatFragment.this) != null)
            {
              MinsuChatFragment.f(MinsuChatFragment.this).setTextColor(ApplicationEx.c.getResources().getColor(2131624046));
              MinsuChatFragment.f(MinsuChatFragment.this).setEnabled(false);
            }
          }
          do
          {
            return;
            MinsuChatFragment.e(MinsuChatFragment.this).setTextColor(ApplicationEx.c.getResources().getColor(2131624475));
            MinsuChatFragment.e(MinsuChatFragment.this).setEnabled(true);
          } while (MinsuChatFragment.f(MinsuChatFragment.this) == null);
          MinsuChatFragment.f(MinsuChatFragment.this).setTextColor(ApplicationEx.c.getResources().getColor(2131624475));
          MinsuChatFragment.f(MinsuChatFragment.this).setEnabled(true);
        }
      });
      this.X = getView().findViewById(2131694548);
      this.T = ((ViewPager)getView().findViewById(2131694549));
      this.U = ((LinearLayout)getView().findViewById(2131694550));
      this.V = ((ImageView)getView().findViewById(2131694552));
      this.V.setSelected(true);
      this.V.setOnClickListener(this);
      this.W = ((ImageView)getView().findViewById(2131694553));
      this.W.setOnClickListener(this);
      this.w = ((ImageView)getView().findViewById(2131696856));
      this.x = ((ImageView)getView().findViewById(2131696857));
      if (i1 == 0) {
        break;
      }
      cn.dreamtobe.kpswitch.b.c.attach(getActivity(), this.Z, new cn.dreamtobe.kpswitch.b.c.b()
      {
        public void onKeyboardShowing(boolean paramAnonymousBoolean)
        {
          if (paramAnonymousBoolean) {}
          for (String str = "showing";; str = "hiding")
          {
            u.i("MinsuChatFragment", String.format("Keyboard is %s", new Object[] { str }));
            return;
          }
        }
      });
      this.y.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          MinsuChatFragment.a(MinsuChatFragment.this, 1);
        }
      });
      this.y.addTextChangedListener(new TextWatcher()
      {
        public void afterTextChanged(Editable paramAnonymousEditable) {}
        
        public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        
        public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          if (TextUtils.isEmpty(paramAnonymousCharSequence)) {
            if (MinsuChatFragment.g(MinsuChatFragment.this) == 1)
            {
              MinsuChatFragment.e(MinsuChatFragment.this).setVisibility(8);
              MinsuChatFragment.h(MinsuChatFragment.this).setVisibility(0);
            }
          }
          while (MinsuChatFragment.g(MinsuChatFragment.this) != 1) {
            return;
          }
          MinsuChatFragment.e(MinsuChatFragment.this).setVisibility(0);
          MinsuChatFragment.h(MinsuChatFragment.this).setVisibility(8);
        }
      });
      getView().findViewById(2131696858).setVisibility(8);
      getView().findViewById(2131694555).setOnClickListener(this);
      getView().findViewById(2131694556).setOnClickListener(this);
      getView().findViewById(2131694557).setOnClickListener(this);
      getView().findViewById(2131694558).setOnClickListener(this);
      getView().findViewById(2131696856).setOnClickListener(this);
      getView().findViewById(2131696857).setOnClickListener(this);
      return;
    }
    this.v = ((ImageView)getView().findViewById(2131694526));
    getView().findViewById(2131696858).setVisibility(0);
    getView().findViewById(2131694529).setOnClickListener(this);
    getView().findViewById(2131694526).setOnClickListener(this);
    getView().findViewById(2131694528).setOnClickListener(this);
    getView().findViewById(2131694527).setOnClickListener(this);
    this.x.setVisibility(8);
    this.w.setVisibility(8);
    this.u.setVisibility(0);
    cn.dreamtobe.kpswitch.b.a.attach(this.Z, null, this.y, new a.b()
    {
      public void onClickSwitch(boolean paramAnonymousBoolean)
      {
        if (paramAnonymousBoolean)
        {
          MinsuChatFragment.a(MinsuChatFragment.this).clearFocus();
          return;
        }
        MinsuChatFragment.a(MinsuChatFragment.this).requestFocus();
      }
    });
  }
  
  private void r()
  {
    if ((getView().findViewById(2131696860).getVisibility() == 0) && (this.R == 2))
    {
      a(0);
      return;
    }
    w();
    a(2);
  }
  
  private void s()
  {
    if ((getView().findViewById(2131696860).getVisibility() == 0) && (this.R == 3)) {
      a(0);
    }
    for (;;)
    {
      this.d.scrollToListViewBottom();
      return;
      a(3);
      u();
    }
  }
  
  private void t()
  {
    this.y.requestFocus();
    new Timer().schedule(new TimerTask()
    {
      public void run()
      {
        InputMethodManager localInputMethodManager = (InputMethodManager)MinsuChatFragment.this.getActivity().getSystemService("input_method");
        localInputMethodManager.showSoftInput(MinsuChatFragment.a(MinsuChatFragment.this), 2);
        localInputMethodManager.toggleSoftInput(2, 1);
      }
    }, 100L);
  }
  
  private void u()
  {
    com.ziroom.ziroomcustomer.minsu.e.a.imReclyCommon(getActivity(), new com.ziroom.commonlibrary.a.a(getActivity(), new com.freelxl.baselibrary.d.f.d(MinsuImReplyCommonBean.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        MinsuChatFragment.a(MinsuChatFragment.this, 0);
      }
      
      public void onSuccess(int paramAnonymousInt, MinsuImReplyCommonBean paramAnonymousMinsuImReplyCommonBean)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousMinsuImReplyCommonBean);
        if ((paramAnonymousMinsuImReplyCommonBean != null) && (paramAnonymousMinsuImReplyCommonBean.checkSuccess(MinsuChatFragment.this.getActivity())))
        {
          MinsuChatFragment.a(MinsuChatFragment.this, 3);
          MinsuChatFragment.a(MinsuChatFragment.this, paramAnonymousMinsuImReplyCommonBean.data);
          return;
        }
        MinsuChatFragment.a(MinsuChatFragment.this, 0);
      }
    });
  }
  
  private void v()
  {
    a(0);
    k.toComomReplyList(getActivity());
  }
  
  private void w()
  {
    EMMessage localEMMessage = this.e.getLastMessage();
    final String str2 = this.L;
    final String str1 = this.M;
    if (localEMMessage != null)
    {
      str2 = localEMMessage.getStringAttribute("startDate", "");
      str1 = localEMMessage.getStringAttribute("endDate", "");
    }
    com.ziroom.ziroomcustomer.minsu.e.a.landShareHouseList(getActivity(), str2, str1, this.K, 1, 200, new com.ziroom.commonlibrary.a.a(getActivity(), new com.freelxl.baselibrary.d.f.d(MinsuHouseBean.class))
    {
      public void onSuccess(int paramAnonymousInt, MinsuHouseBean paramAnonymousMinsuHouseBean)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousMinsuHouseBean);
        String str1;
        if (TextUtils.isEmpty(str1))
        {
          str1 = str1;
          if ((paramAnonymousMinsuHouseBean != null) && (paramAnonymousMinsuHouseBean.data != null) && (paramAnonymousMinsuHouseBean.checkSuccess(MinsuChatFragment.this.getActivity()))) {
            if (!TextUtils.isEmpty(str2)) {
              break label97;
            }
          }
        }
        label97:
        for (String str2 = str2;; str2 = m.getFormatDate(m.strToDate(str2, m.b), m.h))
        {
          MinsuChatFragment.a(MinsuChatFragment.this, paramAnonymousMinsuHouseBean.data, str2, str1);
          return;
          str1 = m.getFormatDate(m.strToDate(str1, m.b), m.h);
          break;
        }
      }
    });
  }
  
  private void x()
  {
    new Thread(new a(this.aa)).start();
  }
  
  private void y()
  {
    if ((this.T.getCurrentItem() == 2) || (this.T.getCurrentItem() == 3)) {
      return;
    }
    this.T.setCurrentItem(2);
  }
  
  private void z()
  {
    if ((this.T.getCurrentItem() == 1) || (this.T.getCurrentItem() == 0)) {
      return;
    }
    this.T.setCurrentItem(0);
  }
  
  protected void a(Uri paramUri)
  {
    String[] arrayOfString = new String[1];
    arrayOfString[0] = "_data";
    Cursor localCursor = getActivity().getContentResolver().query(paramUri, arrayOfString, null, null, null);
    if (localCursor != null)
    {
      localCursor.moveToFirst();
      paramUri = localCursor.getString(localCursor.getColumnIndex(arrayOfString[0]));
      localCursor.close();
      if ((paramUri == null) || (paramUri.equals("null")))
      {
        paramUri = Toast.makeText(getActivity(), 2131297293, 0);
        paramUri.setGravity(17, 0, 0);
        if (!(paramUri instanceof Toast))
        {
          paramUri.show();
          return;
        }
        VdsAgent.showToast((Toast)paramUri);
        return;
      }
      if (!new File(paramUri).exists())
      {
        paramUri = Toast.makeText(getActivity(), 2131297293, 0);
        paramUri.setGravity(17, 0, 0);
        if (!(paramUri instanceof Toast))
        {
          paramUri.show();
          return;
        }
        VdsAgent.showToast((Toast)paramUri);
        return;
      }
      d(paramUri);
      return;
    }
    paramUri = new File(paramUri.getPath());
    if (!paramUri.exists())
    {
      paramUri = Toast.makeText(getActivity(), 2131297293, 0);
      paramUri.setGravity(17, 0, 0);
      if (!(paramUri instanceof Toast))
      {
        paramUri.show();
        return;
      }
      VdsAgent.showToast((Toast)paramUri);
      return;
    }
    d(paramUri.getAbsolutePath());
  }
  
  protected void a(EMMessage paramEMMessage)
  {
    if (this.q != null) {
      this.q.onSetMessageAttributes(paramEMMessage);
    }
    EMClient.getInstance().chatManager().sendMessage(paramEMMessage);
    this.d.refreshSelectLast();
  }
  
  protected void a(EMMessage paramEMMessage, String paramString)
  {
    HashMap localHashMap = new HashMap(1);
    localHashMap.put("msgSenderType", "" + this.D);
    com.ziroom.ziroomcustomer.minsu.chat.d.c.setAPNS(paramEMMessage, paramString, "ZIROOM_MINSU_IM", localHashMap);
    a(paramEMMessage);
  }
  
  protected void a(String paramString1, String paramString2)
  {
    a(com.ziroom.ziroomcustomer.minsu.chat.d.c.createExpressionMessage(paramString1, paramString2), g("[动画表情]"));
  }
  
  protected void a(List<MinsuHouseBean.DataBean.ListBean> paramList)
  {
    if (com.ziroom.ziroomcustomer.minsu.f.c.isNull(paramList)) {
      return;
    }
    if (paramList.size() >= 5)
    {
      g.textToast(ApplicationEx.c, "超过批量发送上限" + 5 + ",请分批发送!");
      return;
    }
    for (;;)
    {
      try
      {
        localObject = new JSONArray();
        try
        {
          paramList = paramList.iterator();
          if (!paramList.hasNext()) {
            continue;
          }
          MinsuHouseBean.DataBean.ListBean localListBean = (MinsuHouseBean.DataBean.ListBean)paramList.next();
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("price", (localListBean.price + 50) / 100 + "");
          localJSONObject.put("name", localListBean.houseName);
          localJSONObject.put("fid", localListBean.fid);
          localJSONObject.put("rentWay", localListBean.rentWay + "");
          localJSONObject.put("rentWayName", localListBean.rentWayName + "");
          localJSONObject.put("city", localListBean.cityName);
          localJSONObject.put("picUrl", localListBean.picUrl);
          localJSONObject.put("isTop50Online", localListBean.isTop50Online + "");
          ((JSONArray)localObject).put(localJSONObject);
          continue;
          ((JSONException)localObject).printStackTrace();
        }
        catch (JSONException localJSONException2)
        {
          paramList = (List<MinsuHouseBean.DataBean.ListBean>)localObject;
          localObject = localJSONException2;
        }
      }
      catch (JSONException localJSONException1)
      {
        Object localObject;
        paramList = null;
        continue;
      }
      localObject = EMMessage.createTxtSendMessage("不支持的消息,请升级APP版本", this.c);
      ((EMMessage)localObject).setAttribute("msgType", "2");
      ((EMMessage)localObject).setAttribute("houseCard", "0");
      ((EMMessage)localObject).setAttribute("shareHouseMsg", paramList);
      a((EMMessage)localObject, g("房源推荐消息"));
      return;
      paramList = (List<MinsuHouseBean.DataBean.ListBean>)localObject;
    }
  }
  
  protected void b(String paramString)
  {
    if (ae.isNull(paramString))
    {
      showToast("输入内容为空");
      return;
    }
    EMMessage localEMMessage = EMMessage.createTxtSendMessage(paramString, this.c);
    localEMMessage.setAttribute("houseCard", "0");
    localEMMessage.setAttribute("msgType", "0");
    a(localEMMessage, g(paramString));
  }
  
  protected void c()
  {
    this.d = ((MinsuChatMessageList)getView().findViewById(2131696855));
    if (this.b != 1) {
      this.d.setShowUserNick(true);
    }
    this.k = this.d.getListView();
    this.y = ((MyChatEditText)getView().findViewById(2131693118));
    this.y.setOnEditorActionListener(new TextView.OnEditorActionListener()
    {
      public boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        if ((paramAnonymousInt == 4) || (paramAnonymousInt == 6) || ((paramAnonymousKeyEvent != null) && (66 == paramAnonymousKeyEvent.getKeyCode()) && (paramAnonymousKeyEvent.getAction() == 0)))
        {
          paramAnonymousTextView = MinsuChatFragment.a(MinsuChatFragment.this).getText().toString();
          if (MinsuChatFragment.a(MinsuChatFragment.this, paramAnonymousTextView)) {
            return true;
          }
          MinsuChatFragment.this.c(paramAnonymousTextView);
          MinsuChatFragment.a(MinsuChatFragment.this).postDelayed(new Runnable()
          {
            public void run()
            {
              MinsuChatFragment.a(MinsuChatFragment.this).setText("");
              MinsuChatFragment.a(MinsuChatFragment.this).setLines(1);
              MinsuChatFragment.this.d.scrollToListViewBottom();
            }
          }, 50L);
        }
        return false;
      }
    });
    this.y.addTextChangedListener(new TextWatcher()
    {
      public void afterTextChanged(Editable paramAnonymousEditable) {}
      
      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        if (!TextUtils.isEmpty(paramAnonymousCharSequence)) {
          MinsuChatFragment.a(MinsuChatFragment.this).setMaxLines(4);
        }
      }
      
      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    this.j = this.d.getSwipeRefreshLayout();
    this.j.setColorSchemeResources(new int[] { 2131624403, 2131624404, 2131624405, 2131624406 });
    this.f = ((InputMethodManager)getActivity().getSystemService("input_method"));
    this.g = ((ClipboardManager)getActivity().getSystemService("clipboard"));
    getActivity().getWindow().setSoftInputMode(3);
    this.Z = ((KPSwitchPanelFrameLayout)getView().findViewById(2131692491));
    this.Z.setIgnoreRecommendHeight(true);
    initTitle();
    new Handler().postDelayed(new Runnable()
    {
      public void run()
      {
        MinsuChatFragment.this.getView().getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
        {
          public void onGlobalLayout()
          {
            Rect localRect = new Rect();
            MinsuChatFragment.this.getView().getWindowVisibleDisplayFrame(localRect);
            int i = localRect.height();
            if (MinsuChatFragment.this.p == 0) {
              MinsuChatFragment.this.p = i;
            }
            do
            {
              do
              {
                return;
              } while (MinsuChatFragment.this.p == i);
              if (MinsuChatFragment.this.p - i > 200)
              {
                MinsuChatFragment.b(MinsuChatFragment.this);
                MinsuChatFragment.this.p = i;
                return;
              }
            } while (i - MinsuChatFragment.this.p <= 200);
            MinsuChatFragment.c(MinsuChatFragment.this);
            MinsuChatFragment.this.p = i;
          }
        });
      }
    }, 700L);
  }
  
  protected void c(String paramString)
  {
    if (ae.isNull(paramString))
    {
      showToast("输入内容为空");
      return;
    }
    EMMessage localEMMessage = EMMessage.createTxtSendMessage(paramString, this.c);
    localEMMessage.setAttribute("houseCard", "0");
    localEMMessage.setAttribute("msgType", "0");
    a(localEMMessage, g(paramString));
  }
  
  protected void d()
  {
    if (this.b != 3)
    {
      e();
      f();
    }
    h();
    String str = getArguments().getString("forward_msg_id");
    if (str != null) {
      e(str);
    }
    setChatFragmentHelper(new a()
    {
      public void onAvatarClick(String paramAnonymousString)
      {
        if (MinsuChatFragment.g(MinsuChatFragment.this) == 1)
        {
          if ((ae.notNull(MinsuChatFragment.this.c)) && (MinsuChatFragment.this.c.equals(paramAnonymousString)))
          {
            c.toCustomerPage(MinsuChatFragment.this.getActivity(), j.removeEMPrefix(paramAnonymousString));
            return;
          }
          MinsuChatFragment.b(MinsuChatFragment.this, paramAnonymousString);
          return;
        }
        if ((ae.notNull(MinsuChatFragment.this.c)) && (MinsuChatFragment.this.c.equals(paramAnonymousString)))
        {
          MinsuChatFragment.b(MinsuChatFragment.this, paramAnonymousString);
          return;
        }
        c.toCustomerPage(MinsuChatFragment.this.getActivity(), j.removeEMPrefix(paramAnonymousString));
      }
      
      public void onEnterToChatDetails() {}
      
      public boolean onExtendMenuItemClick(int paramAnonymousInt, View paramAnonymousView)
      {
        return false;
      }
      
      public boolean onMessageBubbleClick(EMMessage paramAnonymousEMMessage)
      {
        if ("1".equals(paramAnonymousEMMessage.getStringAttribute("houseCard", "")))
        {
          if (MinsuChatFragment.g(MinsuChatFragment.this) == 2) {}
          while (MinsuChatFragment.g(MinsuChatFragment.this) != 1) {
            try
            {
              MinsuChatFragment.a(MinsuChatFragment.this, paramAnonymousEMMessage);
              return true;
            }
            catch (Exception paramAnonymousEMMessage)
            {
              paramAnonymousEMMessage.printStackTrace();
              return true;
            }
          }
          MinsuChatFragment.b(MinsuChatFragment.this, paramAnonymousEMMessage);
          return true;
        }
        return false;
      }
      
      public void onMessageBubbleLongClick(EMMessage paramAnonymousEMMessage) {}
      
      public f onSetCustomChatRowProvider()
      {
        return null;
      }
      
      public void onSetMessageAttributes(EMMessage paramAnonymousEMMessage)
      {
        Object localObject = MinsuChatFragment.this.e.getLastMessage();
        int k = MinsuChatFragment.g(MinsuChatFragment.this) | 0x0;
        int i = k;
        if (localObject != null)
        {
          if (((EMMessage)localObject).direct() == EMMessage.Direct.SEND) {
            i = ((EMMessage)localObject).getIntAttribute("roleType", 0) | MinsuChatFragment.g(MinsuChatFragment.this);
          }
        }
        else
        {
          j.setExtMsg(paramAnonymousEMMessage, (EMMessage)localObject, MinsuChatFragment.g(MinsuChatFragment.this) + "", i);
          if (((!MinsuChatFragment.i(MinsuChatFragment.this)) && ("MinsuOrderSigned".equals(MinsuChatFragment.d(MinsuChatFragment.this)))) || ("MJavascriptInterface".equals(MinsuChatFragment.d(MinsuChatFragment.this))))
          {
            MinsuChatFragment.a(MinsuChatFragment.this, true);
            if (!TextUtils.isEmpty(MinsuChatFragment.j(MinsuChatFragment.this))) {
              if (!ae.isNull(MinsuChatFragment.j(MinsuChatFragment.this))) {
                break label255;
              }
            }
          }
        }
        label255:
        for (localObject = "";; localObject = MinsuChatFragment.j(MinsuChatFragment.this))
        {
          paramAnonymousEMMessage.setAttribute("fid", (String)localObject);
          paramAnonymousEMMessage.setAttribute("rentWay", MinsuChatFragment.k(MinsuChatFragment.this));
          MinsuChatFragment.l(MinsuChatFragment.this);
          return;
          i = k;
          if (((EMMessage)localObject).direct() != EMMessage.Direct.RECEIVE) {
            break;
          }
          int m = ((EMMessage)localObject).getIntAttribute("roleType", 0);
          int j = k;
          if ((m & 0x1) != 0) {
            j = k | 0x2;
          }
          i = j;
          if ((m & 0x2) == 0) {
            break;
          }
          i = j | 0x1;
          break;
        }
      }
    });
  }
  
  protected void d(String paramString)
  {
    paramString = EMMessage.createImageSendMessage(paramString, false, this.c);
    Toast localToast;
    if (paramString == null)
    {
      localToast = Toast.makeText(getActivity(), 2131297293, 0);
      localToast.setGravity(17, 0, 0);
      if ((localToast instanceof Toast)) {
        break label58;
      }
      localToast.show();
    }
    for (;;)
    {
      a(paramString, g("[图片]"));
      return;
      label58:
      VdsAgent.showToast((Toast)localToast);
    }
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    boolean bool = false;
    if (this.R != 0)
    {
      a(0);
      bool = true;
    }
    return bool;
  }
  
  protected void e()
  {
    this.e = EMClient.getInstance().chatManager().getConversation(this.c, EMConversation.EMConversationType.Chat, true);
    this.e.markAllMessagesAsRead();
    new ArrayList().addAll(this.e.loadMoreMsgFromDB(null, this.n));
    try
    {
      if (this.D == 1) {
        x();
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  protected void e(String paramString)
  {
    EMMessage localEMMessage = EMClient.getInstance().chatManager().getMessage(paramString);
    paramString = localEMMessage.getType();
    switch (20.a[paramString.ordinal()])
    {
    }
    for (;;)
    {
      if (localEMMessage.getChatType() == EMMessage.ChatType.ChatRoom) {
        EMClient.getInstance().chatroomManager().leaveChatRoom(localEMMessage.getTo());
      }
      return;
      if (localEMMessage.getBooleanAttribute("em_is_big_expression", false))
      {
        a(((EMTextMessageBody)localEMMessage.getBody()).getMessage(), localEMMessage.getStringAttribute("em_expression_id", null));
      }
      else
      {
        c(((EMTextMessageBody)localEMMessage.getBody()).getMessage());
        continue;
        String str = ((EMImageMessageBody)localEMMessage.getBody()).getLocalUrl();
        if (str != null)
        {
          paramString = str;
          if (!new File(str).exists()) {
            paramString = com.ziroom.ziroomcustomer.minsu.chat.d.f.getThumbnailImagePath(str);
          }
          d(paramString);
        }
      }
    }
  }
  
  protected void f()
  {
    MinsuChatMessageList localMinsuChatMessageList = this.d;
    String str = this.c;
    int i1 = this.b;
    if (this.q != null) {}
    for (f localf = this.q.onSetCustomChatRowProvider();; localf = null)
    {
      localMinsuChatMessageList.init(str, i1, localf);
      g();
      this.d.getListView().setOnTouchListener(new View.OnTouchListener()
      {
        public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          MinsuChatFragment.a(MinsuChatFragment.this, 0);
          return false;
        }
      });
      this.s = true;
      new Handler().postDelayed(new Runnable()
      {
        public void run()
        {
          if (MinsuChatFragment.this.d != null) {
            MinsuChatFragment.this.d.refreshSelectLast();
          }
        }
      }, 70L);
      return;
    }
  }
  
  protected void g()
  {
    this.d.setItemClickListener(new d()
    {
      public boolean onBubbleClick(EMMessage paramAnonymousEMMessage)
      {
        if (MinsuChatFragment.this.q != null) {
          return MinsuChatFragment.this.q.onMessageBubbleClick(paramAnonymousEMMessage);
        }
        return false;
      }
      
      public void onBubbleLongClick(EMMessage paramAnonymousEMMessage)
      {
        MinsuChatFragment.this.o = paramAnonymousEMMessage;
        if (MinsuChatFragment.this.q != null) {
          MinsuChatFragment.this.q.onMessageBubbleLongClick(paramAnonymousEMMessage);
        }
      }
      
      public void onResendClick(final EMMessage paramAnonymousEMMessage)
      {
        com.ziroom.commonlibrary.widget.unifiedziroom.c.newBuilder(MinsuChatFragment.this.getActivity()).setTitle(MinsuChatFragment.this.getActivity().getResources().getString(2131297402)).setContent(MinsuChatFragment.this.getActivity().getResources().getString(2131296732)).setOnConfirmClickListener(new com.ziroom.commonlibrary.widget.unifiedziroom.c.b()
        {
          public void onClick(View paramAnonymous2View, boolean paramAnonymous2Boolean)
          {
            if (paramAnonymous2Boolean) {
              MinsuChatFragment.this.resendMessage(paramAnonymousEMMessage);
            }
          }
        }).build().show();
      }
      
      public void onUserAvatarClick(String paramAnonymousString)
      {
        if (MinsuChatFragment.this.q != null) {
          MinsuChatFragment.this.q.onAvatarClick(paramAnonymousString);
        }
      }
    });
    this.d.setOnMessageStatusAdapter(new i()
    {
      public void onFail(EMMessage paramAnonymousEMMessage)
      {
        String str8 = j.getMessageDigest(paramAnonymousEMMessage, MinsuChatFragment.this.getActivity());
        u.i("lanzhihong huanxin", "消息发送失败===" + str8);
        String str1;
        String str2;
        label71:
        String str3;
        label87:
        String str9;
        String str5;
        String str4;
        String str6;
        String str7;
        if (MinsuChatFragment.g(MinsuChatFragment.this) == 1)
        {
          str1 = "10";
          if (MinsuChatFragment.g(MinsuChatFragment.this) != 1) {
            break label331;
          }
          str2 = MinsuChatFragment.this.c;
          if (MinsuChatFragment.g(MinsuChatFragment.this) != 1) {
            break label338;
          }
          str3 = com.ziroom.ziroomcustomer.minsu.e.d.getUid();
          str9 = paramAnonymousEMMessage.getMsgId();
          EMMessage localEMMessage = MinsuChatFragment.this.e.getLastMessage();
          str5 = MinsuChatFragment.m(MinsuChatFragment.this);
          str4 = MinsuChatFragment.n(MinsuChatFragment.this);
          str6 = MinsuChatFragment.j(MinsuChatFragment.this);
          str7 = MinsuChatFragment.k(MinsuChatFragment.this) + "";
          if (localEMMessage == null) {
            break label350;
          }
          str5 = localEMMessage.getStringAttribute("startDate", "");
          str4 = localEMMessage.getStringAttribute("endDate", "");
          str6 = localEMMessage.getStringAttribute("fid", "");
          str7 = localEMMessage.getStringAttribute("rentWay", "");
        }
        label331:
        label338:
        label350:
        for (;;)
        {
          com.ziroom.ziroomcustomer.minsu.e.a.putImErrorData(MinsuChatFragment.this.getActivity(), str2, str3, str8, str1, MinsuChatFragment.o(MinsuChatFragment.this) + "", str4, str5, str6, paramAnonymousEMMessage.getStringAttribute("houseCard", ""), MinsuChatFragment.p(MinsuChatFragment.this), MinsuChatFragment.q(MinsuChatFragment.this), MinsuChatFragment.r(MinsuChatFragment.this), str7 + "", com.ziroom.ziroomcustomer.minsu.e.d.getUid(), str9, new com.freelxl.baselibrary.d.c.a(new e())
          {
            public void onFailure(Throwable paramAnonymous2Throwable) {}
            
            public void onSuccess(int paramAnonymous2Int, String paramAnonymous2String)
            {
              u.i("lanzhihong huanxin", "str===" + paramAnonymous2String);
            }
          });
          return;
          str1 = "20";
          break;
          str2 = com.ziroom.ziroomcustomer.minsu.e.d.getUid();
          break label71;
          str3 = MinsuChatFragment.this.c;
          break label87;
        }
      }
      
      public void onSuccess(EMMessage paramAnonymousEMMessage)
      {
        String str8 = j.getMessageDigest(paramAnonymousEMMessage, ApplicationEx.c);
        u.i("lanzhihong huanxin", "消息发送成功===" + str8);
        String str1;
        String str2;
        label67:
        String str3;
        label83:
        String str9;
        String str5;
        String str4;
        String str6;
        String str7;
        if (MinsuChatFragment.g(MinsuChatFragment.this) == 1)
        {
          str1 = "10";
          if (MinsuChatFragment.g(MinsuChatFragment.this) != 1) {
            break label352;
          }
          str2 = MinsuChatFragment.this.c;
          if (MinsuChatFragment.g(MinsuChatFragment.this) != 1) {
            break label359;
          }
          str3 = com.ziroom.ziroomcustomer.minsu.e.d.getUid();
          str9 = paramAnonymousEMMessage.getMsgId();
          u.i("lanzhihong huanxin", "msgid==" + str9);
          EMMessage localEMMessage = MinsuChatFragment.this.e.getLastMessage();
          str5 = MinsuChatFragment.m(MinsuChatFragment.this);
          str4 = MinsuChatFragment.n(MinsuChatFragment.this);
          str6 = MinsuChatFragment.j(MinsuChatFragment.this);
          str7 = MinsuChatFragment.k(MinsuChatFragment.this) + "";
          if (localEMMessage == null) {
            break label371;
          }
          str5 = localEMMessage.getStringAttribute("startDate", "");
          str4 = localEMMessage.getStringAttribute("endDate", "");
          str6 = localEMMessage.getStringAttribute("fid", "");
          str7 = localEMMessage.getStringAttribute("rentWay", "");
        }
        label352:
        label359:
        label371:
        for (;;)
        {
          com.ziroom.ziroomcustomer.minsu.e.a.putImData(MinsuChatFragment.this.getActivity(), str2, str3, str8, str1, MinsuChatFragment.o(MinsuChatFragment.this) + "", str4, str5, str6, paramAnonymousEMMessage.getStringAttribute("houseCard", ""), MinsuChatFragment.p(MinsuChatFragment.this), MinsuChatFragment.q(MinsuChatFragment.this), MinsuChatFragment.r(MinsuChatFragment.this), str7 + "", com.ziroom.ziroomcustomer.minsu.e.d.getUid(), str9, new com.freelxl.baselibrary.d.c.a(new e())
          {
            public void onFailure(Throwable paramAnonymous2Throwable) {}
            
            public void onSuccess(int paramAnonymous2Int, String paramAnonymous2String)
            {
              u.i("lanzhihong huanxin", "str===" + paramAnonymous2String);
            }
          });
          return;
          str1 = "20";
          break;
          str2 = com.ziroom.ziroomcustomer.minsu.e.d.getUid();
          break label67;
          str3 = MinsuChatFragment.this.c;
          break label83;
        }
      }
    });
  }
  
  public List<String> getExpressionRes(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    int i1 = 1;
    while (i1 <= paramInt)
    {
      localArrayList.add("ee_" + i1);
      i1 += 1;
    }
    return localArrayList;
  }
  
  protected void h()
  {
    this.j.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener()
    {
      public void onRefresh()
      {
        new Handler().postDelayed(new Runnable()
        {
          public void run()
          {
            if ((MinsuChatFragment.this.k.getFirstVisiblePosition() == 0) && (!MinsuChatFragment.this.l) && (MinsuChatFragment.this.m)) {}
            for (;;)
            {
              try
              {
                List localList;
                if (MinsuChatFragment.this.b == 1)
                {
                  localList = MinsuChatFragment.this.e.loadMoreMsgFromDB(MinsuChatFragment.this.d.getItem(0).getMsgId(), MinsuChatFragment.this.n);
                  if (localList.size() > 0)
                  {
                    MinsuChatFragment.this.d.refreshSeekTo(localList.size() - 1);
                    if (localList.size() != MinsuChatFragment.this.n) {
                      MinsuChatFragment.this.m = false;
                    }
                    MinsuChatFragment.this.l = false;
                    MinsuChatFragment.this.j.setRefreshing(false);
                  }
                }
                else
                {
                  localList = MinsuChatFragment.this.e.loadMoreMsgFromDB(MinsuChatFragment.this.d.getItem(0).getMsgId(), MinsuChatFragment.this.n);
                  continue;
                }
                MinsuChatFragment.this.m = false;
              }
              catch (Exception localException)
              {
                MinsuChatFragment.this.j.setRefreshing(false);
                return;
              }
              continue;
              g.textToast(MinsuChatFragment.this.getActivity(), MinsuChatFragment.this.getResources().getString(2131297288));
            }
          }
        }, 600L);
      }
    });
  }
  
  protected void i()
  {
    if (!MinsuHouseDetailActivity.class.getSimpleName().equals(this.G)) {
      return;
    }
    label31:
    EMMessage localEMMessage;
    if (ae.isNull(this.J))
    {
      str = "#error#";
      localEMMessage = EMMessage.createTxtSendMessage(str, this.c);
      localEMMessage.setAttribute("houseCard", "1");
      localEMMessage.setAttribute("msgType", "1");
      if (!ae.isNull(this.E)) {
        break label261;
      }
      str = "";
      label73:
      localEMMessage.setAttribute("fid", str);
      localEMMessage.setAttribute("rentWay", this.A);
      localEMMessage.setAttribute("rentWayName", this.B);
      localEMMessage.setAttribute("startDate", this.L);
      localEMMessage.setAttribute("endDate", this.M);
      if (!TextUtils.isEmpty(this.F)) {
        break label269;
      }
      str = "0";
      label139:
      localEMMessage.setAttribute("isTop50Online", str);
      if (!ae.isNull(this.z)) {
        break label277;
      }
      str = "";
      label160:
      localEMMessage.setAttribute("houseName", str);
      if (!ae.isNull(this.C)) {
        break label285;
      }
    }
    label261:
    label269:
    label277:
    label285:
    for (String str = "";; str = this.C)
    {
      localEMMessage.setAttribute("housePicUrl", str);
      localEMMessage.setAttribute("personNum", this.K);
      localEMMessage.setAttribute("startDate", this.L);
      localEMMessage.setAttribute("endDate", this.M);
      a(localEMMessage, g("房源咨询消息"));
      if (!ae.notNull(this.J)) {
        break;
      }
      b(this.J);
      return;
      str = this.J;
      break label31;
      str = this.E;
      break label73;
      str = this.F;
      break label139;
      str = this.z;
      break label160;
    }
  }
  
  public void initTitle()
  {
    this.t = ((CommonTitle)getView().findViewById(2131691272));
    this.t.setLeftButtonType(0);
    this.t.setOnLeftButtonClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        if ("offline_push".equals(MinsuChatFragment.d(MinsuChatFragment.this))) {
          if (!ad.isMinsuLandlord()) {
            break label69;
          }
        }
        label69:
        for (paramAnonymousView = new Intent(MinsuChatFragment.this.getActivity(), MinsuLandLordMainNewActivity.class);; paramAnonymousView = new Intent(MinsuChatFragment.this.getActivity(), MainActivity.class))
        {
          MinsuChatFragment.this.startActivity(paramAnonymousView);
          com.ziroom.ziroomcustomer.home.view.recyclerview2gallery.a.i("wz", " initTitle left click ");
          MinsuChatFragment.this.getActivity().finish();
          return;
        }
      }
    });
    if (ae.isNull(this.I))
    {
      c.getUserName(getActivity(), this.c, this.t);
      return;
    }
    this.t.setMiddleText(this.I);
  }
  
  protected void j()
  {
    if (!com.ziroom.ziroomcustomer.newchat.d.isExitsSdcard())
    {
      Toast localToast = Toast.makeText(getActivity(), 2131297414, 0);
      if (!(localToast instanceof Toast))
      {
        localToast.show();
        return;
      }
      VdsAgent.showToast((Toast)localToast);
      return;
    }
    this.i = new File(PathUtil.getInstance().getImagePath(), EMClient.getInstance().getCurrentUser() + System.currentTimeMillis() + ".jpg");
    this.i.getParentFile().mkdirs();
    startActivityForResult(new Intent("android.media.action.IMAGE_CAPTURE").putExtra("output", Uri.fromFile(this.i)), 2);
  }
  
  protected void k()
  {
    Intent localIntent;
    if (Build.VERSION.SDK_INT < 19)
    {
      localIntent = new Intent("android.intent.action.GET_CONTENT");
      localIntent.setType("image/*");
    }
    for (;;)
    {
      startActivityForResult(localIntent, 3);
      return;
      localIntent = new Intent("android.intent.action.PICK", MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
    }
  }
  
  protected void l()
  {
    if ((getActivity().getWindow().getAttributes().softInputMode != 2) && (getActivity().getCurrentFocus() != null) && (this.f != null)) {
      ((InputMethodManager)getActivity().getSystemService("input_method")).hideSoftInputFromWindow(getActivity().getCurrentFocus().getWindowToken(), 0);
    }
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    m();
    super.onActivityCreated(paramBundle);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 == -1)
    {
      if (paramInt1 != 2) {
        break label46;
      }
      if ((this.i != null) && (this.i.exists())) {
        d(this.i.getAbsolutePath());
      }
    }
    label46:
    do
    {
      do
      {
        do
        {
          return;
          if (paramInt1 != 3) {
            break;
          }
        } while (paramIntent == null);
        paramIntent = paramIntent.getData();
      } while (paramIntent == null);
      a(paramIntent);
      return;
    } while (paramInt1 != 1);
  }
  
  public void onBackPressed()
  {
    com.ziroom.ziroomcustomer.home.view.recyclerview2gallery.a.i("wz", " onBackPressed ");
    if (ad.isKeyboardShown(getView().getRootView()))
    {
      l();
      return;
    }
    Intent localIntent;
    if ("offline_push".equals(this.G))
    {
      if (!ad.isMinsuLandlord()) {
        break label74;
      }
      localIntent = new Intent(getActivity(), MinsuLandLordMainNewActivity.class);
    }
    for (;;)
    {
      startActivity(localIntent);
      getActivity().finish();
      return;
      label74:
      localIntent = new Intent(getActivity(), MainActivity.class);
      localIntent.putExtra("FRAGMENT_TYPE", 2);
    }
  }
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    switch (paramView.getId())
    {
    case 2131694529: 
    default: 
      return;
    case 2131691438: 
      A();
      return;
    case 2131694526: 
      if ((this.Z.getVisibility() == 0) && (this.X.getVisibility() == 0))
      {
        a(0);
        return;
      }
      a(5);
      return;
    case 2131694528: 
      k();
      return;
    case 2131694527: 
      j();
      return;
    case 2131694555: 
      k();
      return;
    case 2131694556: 
      j();
      return;
    case 2131694557: 
      s();
      return;
    case 2131694558: 
      r();
      return;
    case 2131696856: 
      if ((this.R == 5) && (this.X.getVisibility() == 0))
      {
        a(1);
        return;
      }
      a(5);
      return;
    case 2131696857: 
      a(4);
      return;
    case 2131694552: 
      z();
      return;
    }
    y();
  }
  
  public void onCmdMessageReceived(List<EMMessage> paramList)
  {
    com.ziroom.ziroomcustomer.home.view.recyclerview2gallery.a.i(" huanxin ");
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    int i1 = 1;
    if (this.D == 1) {}
    while (i1 != 0)
    {
      return paramLayoutInflater.inflate(2130904893, paramViewGroup, false);
      i1 = 0;
    }
    return paramLayoutInflater.inflate(2130904891, paramViewGroup, false);
  }
  
  public void onDestroy()
  {
    LocalBroadcastManager.getInstance(getActivity()).unregisterReceiver(this.r);
    super.onDestroy();
  }
  
  public void onMessageChanged(EMMessage paramEMMessage, Object paramObject)
  {
    com.ziroom.ziroomcustomer.home.view.recyclerview2gallery.a.i(" huanxin  onMessageChanged");
    this.d.refresh();
  }
  
  public void onMessageDelivered(List<EMMessage> paramList)
  {
    com.ziroom.ziroomcustomer.home.view.recyclerview2gallery.a.i(" huanxin ");
    this.d.refresh();
  }
  
  public void onMessageRead(List<EMMessage> paramList)
  {
    com.ziroom.ziroomcustomer.home.view.recyclerview2gallery.a.i(" huanxin ");
    this.d.refresh();
  }
  
  public void onMessageRecalled(List<EMMessage> paramList) {}
  
  public void onMessageReceived(List<EMMessage> paramList)
  {
    com.ziroom.ziroomcustomer.home.view.recyclerview2gallery.a.i(" huanxin ");
    j.logMsg(paramList);
    this.d.refresh();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      EMMessage localEMMessage = (EMMessage)paramList.next();
      if (localEMMessage.getFrom().equals(this.c))
      {
        this.d.refreshSelectLast();
        ApplicationEx.c.getNotifier().viberateAndPlayTone(localEMMessage);
      }
      else
      {
        try
        {
          if ("ZIROOM_MINSU_IM".equals(localEMMessage.getStringAttribute("ziroomFlag", ""))) {
            ApplicationEx.c.getNotifier().onNewMsg(localEMMessage);
          }
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
      }
    }
    this.e.markAllMessagesAsRead();
  }
  
  @Instrumented
  public void onNewIntent(Intent paramIntent)
  {
    VdsAgent.onNewIntent(this, paramIntent);
    m();
    ApplicationEx.c.getNotifier().a();
  }
  
  public void onPause()
  {
    super.onPause();
    this.e.markAllMessagesAsRead();
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.s) {
      this.d.refresh();
    }
    com.ziroom.ziroomcustomer.util.j.getInstance().pushActivity(getActivity());
    EMClient.getInstance().chatManager().addMessageListener(this);
  }
  
  public void onStop()
  {
    super.onStop();
    EMClient.getInstance().chatManager().removeMessageListener(this);
    com.ziroom.ziroomcustomer.util.j.getInstance().popActivity(getActivity());
    a(0);
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
  }
  
  public void resendMessage(EMMessage paramEMMessage)
  {
    paramEMMessage.setStatus(EMMessage.Status.CREATE);
    EMClient.getInstance().chatManager().sendMessage(paramEMMessage);
    this.d.refresh();
  }
  
  public void setChatFragmentHelper(a parama)
  {
    this.q = parama;
  }
  
  public class a
    implements Runnable
  {
    private Handler b;
    
    a(Handler paramHandler)
    {
      this.b = paramHandler;
    }
    
    public void rShow()
    {
      this.b.sendEmptyMessageDelayed(1, 500L);
    }
    
    public void run()
    {
      for (;;)
      {
        int i;
        try
        {
          localList = MinsuChatFragment.this.e.getAllMessages();
          i = localList.size();
          if (i > 0) {
            break label91;
          }
          localList.clear();
          localList.addAll(MinsuChatFragment.this.e.loadMoreMsgFromDB(null, MinsuChatFragment.this.n));
        }
        catch (Exception localException)
        {
          List localList;
          localException.printStackTrace();
          return;
        }
        if (i > 0)
        {
          if (((EMMessage)localList.get(i)).direct() != EMMessage.Direct.SEND) {}
        }
        else
        {
          rShow();
          return;
          label91:
          i -= 1;
          continue;
        }
        i -= 1;
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/chat/MinsuChatFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */