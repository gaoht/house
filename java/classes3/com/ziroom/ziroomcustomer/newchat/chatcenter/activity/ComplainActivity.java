package com.ziroom.ziroomcustomer.newchat.chatcenter.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.u;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.alibaba.fastjson.b;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.f.c;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.commonlibrary.widget.unifiedziroom.BasicZiroomToolBar;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.c.w;
import com.ziroom.ziroomcustomer.e.n;
import com.ziroom.ziroomcustomer.model.UserInfo;
import com.ziroom.ziroomcustomer.newchat.chatcenter.ShowBigPicActivity;
import com.ziroom.ziroomcustomer.newchat.chatcenter.b.p;
import com.ziroom.ziroomcustomer.newchat.chatcenter.b.q;
import com.ziroom.ziroomcustomer.newchat.chatcenter.b.q.a;
import com.ziroom.ziroomcustomer.util.ah;
import com.ziroom.ziroomcustomer.widget.LabeledEditText;
import com.ziroom.ziroomcustomer.widget.LabeledEditText.a;
import com.ziroom.ziroomcustomer.ziroomstation.dialog.a.b;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class ComplainActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private String A;
  private String B;
  private boolean C = false;
  private HashMap<String, String> D = new HashMap();
  private ImageView E;
  private String F;
  private RecyclerView.a G = new RecyclerView.a()
  {
    public int getItemCount()
    {
      if (ComplainActivity.i(ComplainActivity.this).size() == 3) {
        return 3;
      }
      return ComplainActivity.i(ComplainActivity.this).size() + 1;
    }
    
    public void onBindViewHolder(final RecyclerView.u paramAnonymousu, final int paramAnonymousInt)
    {
      SimpleDraweeView localSimpleDraweeView = ((a)paramAnonymousu).a;
      paramAnonymousu = ((a)paramAnonymousu).b;
      if (paramAnonymousInt >= ComplainActivity.i(ComplainActivity.this).size())
      {
        paramAnonymousu.setVisibility(8);
        localSimpleDraweeView.setController(c.frescoController(""));
        localSimpleDraweeView.setOnClickListener(new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymous2View)
          {
            VdsAgent.onClick(this, paramAnonymous2View);
            ComplainActivity.this.selectPhoto();
          }
        });
        return;
      }
      paramAnonymousu.setVisibility(0);
      paramAnonymousu.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymous2View)
        {
          VdsAgent.onClick(this, paramAnonymous2View);
          ComplainActivity.i(ComplainActivity.this).remove(paramAnonymousInt);
          ComplainActivity.j(ComplainActivity.this).notifyDataSetChanged();
        }
      });
      paramAnonymousu = "http://pic.ziroom.com/sms2/pics/" + ComplainActivity.i(ComplainActivity.this).getString(paramAnonymousInt);
      localSimpleDraweeView.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymous2View)
        {
          VdsAgent.onClick(this, paramAnonymous2View);
          ComplainActivity.a(ComplainActivity.this, paramAnonymousu, paramAnonymousInt + 1);
        }
      });
      localSimpleDraweeView.setController(c.frescoController(paramAnonymousu));
    }
    
    public RecyclerView.u onCreateViewHolder(ViewGroup paramAnonymousViewGroup, int paramAnonymousInt)
    {
      return new a(LayoutInflater.from(ComplainActivity.this).inflate(2130904246, paramAnonymousViewGroup, false));
    }
    
    class a
      extends RecyclerView.u
    {
      SimpleDraweeView a;
      ImageView b;
      
      public a(View paramView)
      {
        super();
        this.a = ((SimpleDraweeView)paramView.findViewById(2131695096));
        this.b = ((ImageView)paramView.findViewById(2131691648));
      }
    }
  };
  BasicZiroomToolBar a;
  String b = "";
  String c = "";
  private final int d = 18;
  private final int e = 19;
  private RecyclerView f;
  private b g = new b();
  private Context r;
  private LabeledEditText s;
  private LabeledEditText t;
  private EditText u;
  private TextView v;
  private UserInfo w;
  private com.ziroom.ziroomcustomer.ziroomstation.dialog.a x;
  private List<String> y = new ArrayList();
  private List<q.a> z;
  
  private void a()
  {
    this.a = ((BasicZiroomToolBar)findViewById(2131689787));
    this.a.setTitle("我有建议");
    this.s = ((LabeledEditText)findViewById(2131692593));
    this.t = ((LabeledEditText)findViewById(2131692595));
    this.u = ((EditText)findViewById(2131692594));
    this.v = ((TextView)findViewById(2131692596));
    this.E = ((ImageView)findViewById(2131690102));
    this.f = ((RecyclerView)findViewById(2131690100));
    this.f.setLayoutManager(new LinearLayoutManager(this, 0, false));
    this.f.setAdapter(this.G);
    this.s.setOnClickListener(this);
    this.v.setOnClickListener(this);
    this.E.setOnClickListener(this);
    this.u.addTextChangedListener(new TextWatcher()
    {
      public void afterTextChanged(Editable paramAnonymousEditable) {}
      
      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        ComplainActivity.a(ComplainActivity.this);
      }
    });
    this.s.addTextChangedListener(new LabeledEditText.a()
    {
      public void afterTextChanged(Editable paramAnonymousEditable) {}
      
      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        ComplainActivity.a(ComplainActivity.this);
      }
    });
    this.t.addTextChangedListener(new LabeledEditText.a()
    {
      public void afterTextChanged(Editable paramAnonymousEditable) {}
      
      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        if (paramAnonymousCharSequence.length() > 11)
        {
          ComplainActivity.b(ComplainActivity.this).setText(paramAnonymousCharSequence.subSequence(0, 11).toString());
          ComplainActivity.b(ComplainActivity.this).setSelection(paramAnonymousCharSequence.subSequence(0, 11).toString().length());
        }
        if (paramAnonymousCharSequence.length() > 0)
        {
          ComplainActivity.c(ComplainActivity.this).setVisibility(0);
          ComplainActivity.a(ComplainActivity.this);
          return;
        }
        ComplainActivity.c(ComplainActivity.this).setVisibility(8);
      }
    });
    this.w = ApplicationEx.c.getUser();
    this.c = this.w.getPhone();
    if (!TextUtils.isEmpty(this.c)) {
      this.t.setText(this.c);
    }
  }
  
  private void a(String paramString, int paramInt)
  {
    Intent localIntent = new Intent(this, ShowBigPicActivity.class);
    localIntent.putExtra("picUrl", paramString);
    localIntent.putExtra("mImgIndex", paramInt + "");
    localIntent.putExtra("mImgCount", this.g.size() + "");
    startActivityForResult(localIntent, 19);
  }
  
  private void b()
  {
    if (!ah.checkNet(this.r)) {
      showToast("当前网络不佳，请稍后再试");
    }
    if (this.C)
    {
      if (this.B.length() < 15) {
        g.textToast(ApplicationEx.c, "请至少输入15个字");
      }
    }
    else {
      return;
    }
    if (this.B.length() > 200)
    {
      g.textToast(ApplicationEx.c, "输入字数不能超过200个字");
      return;
    }
    if (this.w != null) {
      if (TextUtils.isEmpty(this.w.getRealName())) {
        break label216;
      }
    }
    label216:
    for (this.b = this.w.getRealName();; this.b = "访客")
    {
      String str1 = this.w.getUid();
      this.c = this.t.getText();
      this.v.setClickable(false);
      String str2 = (String)this.D.get(this.A);
      com.freelxl.baselibrary.f.d.d("suggestTypeId", "====suggestTypeId=" + str2);
      n.suggest_commit(this.r, str2, this.B, this.c, this.b, str1, this.g, new com.ziroom.commonlibrary.a.a(this.r, new com.freelxl.baselibrary.d.f.d(p.class))
      {
        public void onFailure(Throwable paramAnonymousThrowable)
        {
          ComplainActivity.d(ComplainActivity.this).setClickable(true);
          super.onFailure(paramAnonymousThrowable);
          g.textToast(ApplicationEx.c, "网络访问失败");
        }
        
        public void onSuccess(int paramAnonymousInt, Object paramAnonymousObject)
        {
          ComplainActivity.d(ComplainActivity.this).setClickable(true);
          super.onSuccess(paramAnonymousInt, paramAnonymousObject);
          paramAnonymousObject = (p)paramAnonymousObject;
          if (paramAnonymousObject != null)
          {
            if (((p)paramAnonymousObject).getStatus() == 1)
            {
              paramAnonymousObject = new Intent(ComplainActivity.e(ComplainActivity.this), AcceptSuccessActivity.class);
              ((Intent)paramAnonymousObject).putExtra("pageType", "suggest");
              ComplainActivity.this.startActivity((Intent)paramAnonymousObject);
              ComplainActivity.this.finish();
            }
          }
          else {
            return;
          }
          g.textToast(ComplainActivity.this, ((p)paramAnonymousObject).getMessage(), 1);
        }
      });
      return;
    }
  }
  
  private void e()
  {
    this.y.clear();
    Iterator localIterator = this.z.iterator();
    while (localIterator.hasNext())
    {
      q.a locala = (q.a)localIterator.next();
      this.y.add(locala.getName());
      this.D.put(locala.getName(), locala.getId());
    }
    this.x = new com.ziroom.ziroomcustomer.ziroomstation.dialog.a(this.r, "请选择建议类型", new a.b()
    {
      public void callBack(HashMap<Integer, String> paramAnonymousHashMap)
      {
        paramAnonymousHashMap = (String)paramAnonymousHashMap.get(Integer.valueOf(0));
        ComplainActivity.h(ComplainActivity.this).setText(paramAnonymousHashMap);
      }
    }, new List[] { this.y });
  }
  
  private void f()
  {
    this.A = this.s.getText().toString();
    this.B = VdsAgent.trackEditTextSilent(this.u).toString();
    this.F = this.t.getText();
    if ((!TextUtils.isEmpty(this.A)) && (!TextUtils.isEmpty(this.B)) && (!TextUtils.isEmpty(this.F)))
    {
      this.v.setBackground(ContextCompat.getDrawable(this, 2130838035));
      this.C = true;
      return;
    }
    this.v.setBackground(ContextCompat.getDrawable(this, 2130839643));
    this.C = false;
  }
  
  public void getSuggestData()
  {
    n.get_SuggestType(this.r, new com.freelxl.baselibrary.d.c.a(new com.freelxl.baselibrary.d.f.d(q.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable) {}
      
      public void onSuccess(int paramAnonymousInt, Object paramAnonymousObject)
      {
        paramAnonymousObject = (q)paramAnonymousObject;
        if ((paramAnonymousObject != null) && (((q)paramAnonymousObject).getStatus() == 1))
        {
          ComplainActivity.a(ComplainActivity.this, ((q)paramAnonymousObject).getData());
          if ((ComplainActivity.f(ComplainActivity.this) != null) && (ComplainActivity.f(ComplainActivity.this).size() > 0)) {
            ComplainActivity.g(ComplainActivity.this);
          }
        }
      }
    });
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, final Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 != -1) {}
    for (;;)
    {
      return;
      switch (paramInt1)
      {
      default: 
        
      case 18: 
        if (paramIntent != null)
        {
          paramIntent = paramIntent.getStringExtra("path");
          if (!TextUtils.isEmpty(paramIntent))
          {
            paramIntent = new File(paramIntent);
            n.uploadImg(this, paramIntent, new com.ziroom.commonlibrary.a.a(this, new w())
            {
              public void onSuccess(int paramAnonymousInt, List<String> paramAnonymousList)
              {
                super.onSuccess(paramAnonymousInt, paramAnonymousList);
                if ((paramAnonymousList != null) && (paramAnonymousList.size() == 1))
                {
                  paramAnonymousList = (String)paramAnonymousList.get(0);
                  ComplainActivity.i(ComplainActivity.this).add(paramAnonymousList);
                  ComplainActivity.j(ComplainActivity.this).notifyDataSetChanged();
                  if (paramIntent.exists()) {
                    paramIntent.delete();
                  }
                }
              }
            });
            return;
          }
        }
        break;
      case 19: 
        if (paramIntent != null)
        {
          paramIntent = paramIntent.getStringExtra("imgIndex");
          if (!TextUtils.isEmpty(paramIntent)) {
            try
            {
              paramInt1 = Integer.parseInt(paramIntent) - 1;
              if (paramInt1 < this.g.size())
              {
                this.g.remove(paramInt1);
                this.G.notifyDataSetChanged();
                return;
              }
            }
            catch (Exception paramIntent)
            {
              paramIntent.printStackTrace();
            }
          }
        }
        break;
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
    case 2131692593: 
      do
      {
        return;
      } while (this.x == null);
      this.x.show();
      return;
    case 2131692596: 
      b();
      return;
    }
    this.t.setText("");
    f();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903526);
    this.r = this;
    a();
    getSuggestData();
  }
  
  public void selectPhoto()
  {
    startActivityForResult(com.freelxl.baselibrary.widget.imgpicker.a.getPickerIntent(this, false, 0, true, 400, 400), 18);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newchat/chatcenter/activity/ComplainActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */