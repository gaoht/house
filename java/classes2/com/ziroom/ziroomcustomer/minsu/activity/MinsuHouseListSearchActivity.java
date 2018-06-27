package com.ziroom.ziroomcustomer.minsu.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.freelxl.baselibrary.a.b;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuSearchHistoryBean;
import com.ziroom.ziroomcustomer.minsu.d.a.a;
import com.ziroom.ziroomcustomer.minsu.d.f;
import com.ziroom.ziroomcustomer.minsu.f.v;
import com.ziroom.ziroomcustomer.minsu.f.z;
import com.ziroom.ziroomcustomer.util.ae;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MinsuHouseListSearchActivity
  extends BaseActivity
{
  private TextView a;
  private EditText b;
  private ListView c;
  private ImageView d;
  private List<MinsuSearchHistoryBean> e;
  private com.ziroom.ziroomcustomer.minsu.a.a f;
  private LinearLayout g;
  private String r;
  
  private void a()
  {
    this.r = getIntent().getStringExtra("cityCode");
    f.getInstance(this).checkCityCode(this.r);
  }
  
  private void b()
  {
    this.d = ((ImageView)findViewById(2131691648));
    this.c = ((ListView)findViewById(2131690955));
    this.b = ((EditText)findViewById(2131691401));
    this.b.addTextChangedListener(new TextWatcher()
    {
      public void afterTextChanged(Editable paramAnonymousEditable)
      {
        if (TextUtils.isEmpty(paramAnonymousEditable.toString()))
        {
          MinsuHouseListSearchActivity.a(MinsuHouseListSearchActivity.this).setVisibility(8);
          return;
        }
        MinsuHouseListSearchActivity.a(MinsuHouseListSearchActivity.this).setVisibility(0);
      }
      
      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    this.d.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        MinsuHouseListSearchActivity.b(MinsuHouseListSearchActivity.this).setText("");
        com.ziroom.ziroomcustomer.minsu.searchlist.base.c.getInstance().setKeyword(null);
      }
    });
    this.a = ((TextView)findViewById(2131690169));
    this.g = ((LinearLayout)findViewById(2131691649));
    this.a.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        MinsuHouseListSearchActivity.this.setResult(0);
        MinsuHouseListSearchActivity.this.finish();
      }
    });
    e();
    this.b.setOnEditorActionListener(new TextView.OnEditorActionListener()
    {
      public boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        if ((paramAnonymousInt == 4) || ((paramAnonymousKeyEvent != null) && (paramAnonymousKeyEvent.getKeyCode() == 66)))
        {
          paramAnonymousTextView = VdsAgent.trackEditTextSilent(MinsuHouseListSearchActivity.b(MinsuHouseListSearchActivity.this)).toString();
          MinsuHouseListSearchActivity.a(MinsuHouseListSearchActivity.this, paramAnonymousTextView);
          return true;
        }
        return false;
      }
    });
    com.ziroom.ziroomcustomer.minsu.d.a.getInstance().setBlurCb(new a.a()
    {
      public void onBlured(final Bitmap paramAnonymousBitmap)
      {
        if (!com.ziroom.ziroomcustomer.minsu.f.c.isNull(paramAnonymousBitmap)) {
          MinsuHouseListSearchActivity.this.runOnUiThread(new Runnable()
          {
            public void run()
            {
              MinsuHouseListSearchActivity.this.getWindow().getDecorView().setBackground(new BitmapDrawable(MinsuHouseListSearchActivity.this.getResources(), paramAnonymousBitmap));
            }
          });
        }
      }
    });
  }
  
  private void d(String paramString)
  {
    if (ae.notNull(paramString))
    {
      localObject = new MinsuSearchHistoryBean();
      ((MinsuSearchHistoryBean)localObject).cityName = paramString;
      z.putCitySearchHistory(this, (MinsuSearchHistoryBean)localObject);
    }
    Object localObject = new Intent();
    Bundle localBundle = new Bundle();
    localBundle.putString("type", "keyWord");
    localBundle.putString("key", paramString);
    ((Intent)localObject).putExtras(localBundle);
    setResult(-1, (Intent)localObject);
    finish();
  }
  
  private void e()
  {
    new Timer().schedule(new TimerTask()
    {
      public void run()
      {
        ((InputMethodManager)MinsuHouseListSearchActivity.b(MinsuHouseListSearchActivity.this).getContext().getSystemService("input_method")).showSoftInput(MinsuHouseListSearchActivity.b(MinsuHouseListSearchActivity.this), 0);
      }
    }, 500L);
  }
  
  private void f()
  {
    this.e = z.getCitySearchHistory(this);
    if ((this.e != null) && (!this.e.isEmpty()))
    {
      this.g.setVisibility(0);
      if (!TextUtils.isEmpty(getIntent().getStringExtra("key"))) {
        this.b.setText(getIntent().getStringExtra("key"));
      }
      this.b.setSelection(VdsAgent.trackEditTextSilent(this.b).length());
      if (this.f == null)
      {
        this.f = new com.ziroom.ziroomcustomer.minsu.a.a(this, this.e, 2130904345)
        {
          public void convert(b paramAnonymousb, MinsuSearchHistoryBean paramAnonymousMinsuSearchHistoryBean)
          {
            paramAnonymousb.setText(2131690049, paramAnonymousMinsuSearchHistoryBean.cityName);
          }
        };
        this.c.setAdapter(this.f);
        this.c.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
          @Instrumented
          public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
          {
            VdsAgent.onItemClick(this, paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
            paramAnonymousAdapterView = ((MinsuSearchHistoryBean)MinsuHouseListSearchActivity.c(MinsuHouseListSearchActivity.this).get(paramAnonymousInt)).cityName;
            if (ae.notNull(paramAnonymousAdapterView)) {
              MinsuHouseListSearchActivity.a(MinsuHouseListSearchActivity.this, paramAnonymousAdapterView);
            }
            v.onClick(MinsuHouseListSearchActivity.this, "M-Search_keyhistory");
          }
        });
      }
      this.f.setDatas(this.e);
      if ((this.e == null) || (this.e.isEmpty()))
      {
        this.f.notifyDataSetInvalidated();
        return;
      }
      this.f.notifyDataSetChanged();
      return;
    }
    this.g.setVisibility(8);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903326);
    a();
    b();
  }
  
  public boolean onCreatePanelMenu(int paramInt, Menu paramMenu)
  {
    return super.onCreatePanelMenu(paramInt, paramMenu);
  }
  
  protected void onResume()
  {
    super.onResume();
    f();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/activity/MinsuHouseListSearchActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */