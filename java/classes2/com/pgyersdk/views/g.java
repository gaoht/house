package com.pgyersdk.views;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.inputmethod.InputMethodManager;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.pgyersdk.b.b;
import com.pgyersdk.i.d;
import java.io.File;
import java.io.FileInputStream;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class g
  extends c
  implements View.OnClickListener, com.pgyersdk.d.c
{
  private MediaRecorder A;
  private MediaPlayer B;
  private long C;
  private long D;
  private long E;
  private boolean F = false;
  private String G = "tagBtnPlay";
  private String H = "tagBtnDelete";
  private int I = 1;
  private Handler J = new h(this);
  t k;
  public File l;
  PopupWindow m;
  s n;
  Timer o;
  TimerTask p;
  View.OnTouchListener q = new i(this);
  View.OnTouchListener r = new j(this);
  private EditText s;
  private EditText t;
  private CheckBox u;
  private String v;
  private o w;
  private LinearLayout x;
  private r y;
  private int z = 120000;
  
  public g(Context paramContext)
  {
    super(paramContext);
    com.pgyersdk.d.a.setIScreenShotListener(this);
    com.pgyersdk.i.a.setIScreenShotListener(this);
  }
  
  @TargetApi(11)
  public g(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
    com.pgyersdk.d.a.setIScreenShotListener(this);
    com.pgyersdk.i.a.setIScreenShotListener(this);
  }
  
  private void a(View paramView)
  {
    Context localContext1 = this.a;
    Context localContext2 = this.a;
    ((InputMethodManager)localContext1.getSystemService("input_method")).hideSoftInputFromWindow(paramView.getWindowToken(), 2);
  }
  
  private void a(LinearLayout paramLinearLayout)
  {
    this.x = new LinearLayout(this.a);
    LinearLayout.LayoutParams localLayoutParams1 = g();
    localLayoutParams1.setMargins(com.pgyersdk.i.c.a(this.a, 20.0F), com.pgyersdk.i.c.a(this.a, 20.0F), com.pgyersdk.i.c.a(this.a, 20.0F), com.pgyersdk.i.c.a(this.a, 20.0F));
    this.x.setGravity(16);
    LinearLayout.LayoutParams localLayoutParams2 = new LinearLayout.LayoutParams(-2, com.pgyersdk.i.c.a(this.a, 40.0F));
    localLayoutParams2.weight = 1.0F;
    localLayoutParams2.setMargins(0, 0, com.pgyersdk.i.c.a(this.a, 20.0F), 0);
    this.k = new t(this.a);
    this.k.setPadding(0, 0, com.pgyersdk.i.c.a(this.a, 10.0F), 0);
    this.k.setGravity(21);
    this.k.setOnClickListener(this);
    this.k.setTag(this.G);
    this.x.addView(this.k, localLayoutParams2);
    this.y = new r(this.a);
    this.y.setTag(this.H);
    this.y.setOnClickListener(this);
    localLayoutParams2 = g();
    localLayoutParams2.width = com.pgyersdk.i.c.a(this.a, 30.0F);
    localLayoutParams2.height = com.pgyersdk.i.c.a(this.a, 30.0F);
    this.x.addView(this.y, localLayoutParams2);
    this.x.setVisibility(8);
    paramLinearLayout.addView(this.x, localLayoutParams1);
    localLayoutParams1 = g();
    localLayoutParams1.height = com.pgyersdk.i.c.a(this.a, 40.0F);
    localLayoutParams1.setMargins(com.pgyersdk.i.c.a(this.a, 20.0F), com.pgyersdk.i.c.a(this.a, 20.0F), com.pgyersdk.i.c.a(this.a, 20.0F), com.pgyersdk.i.c.a(this.a, 20.0F));
    this.w = new o(this.a);
    this.w.setText(b.a(1072));
    this.w.setOnTouchListener(this.r);
    paramLinearLayout.addView(this.w, localLayoutParams1);
  }
  
  private void h()
  {
    if (!com.pgyersdk.i.k.a(com.pgyersdk.i.i.a(this.a, "selfmail"))) {
      this.t.setText(com.pgyersdk.i.i.a(this.a, "selfmail"));
    }
    if (!com.pgyersdk.i.k.a(com.pgyersdk.i.i.a(this.a, "feedback_des"))) {
      this.s.setText(com.pgyersdk.i.i.a(this.a, "feedback_des"));
    }
    if (!com.pgyersdk.i.k.a(com.pgyersdk.i.i.a(this.a, "voicefile")))
    {
      this.l = new File(com.pgyersdk.i.i.a(this.a, "voicefile"));
      this.w.setVisibility(8);
      this.x.setVisibility(0);
      this.k.setText(com.pgyersdk.i.i.a(this.a, "voiceTime"));
    }
  }
  
  private void i()
  {
    try
    {
      k();
      if ((this.A != null) && (!this.F))
      {
        this.A.prepare();
        this.A.start();
        this.C = new Date().getTime();
        this.F = true;
        m();
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  private void j()
  {
    try
    {
      if ((this.F) && (this.A != null))
      {
        this.A.reset();
        this.F = false;
        this.D = new Date().getTime();
        this.k.setText(String.format("%.0f", new Object[] { Double.valueOf(Math.ceil((this.D - this.C) / 1000.0D)) }) + "\"");
        this.J.removeMessages(20006);
        n();
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  private void k()
  {
    try
    {
      File localFile = new File(d.a().b(this.a));
      if (!localFile.exists()) {
        localFile.mkdir();
      }
      if (this.A == null) {
        this.A = new MediaRecorder();
      }
      this.A.setAudioSource(1);
      this.A.setOutputFormat(2);
      this.A.setAudioEncoder(3);
      this.A.setMaxDuration(this.z);
      this.l = File.createTempFile("recorder_", ".wav", localFile);
      this.A.setOutputFile(this.l.getAbsolutePath());
      return;
    }
    catch (Exception localException) {}
  }
  
  private void l()
  {
    this.p = new m(this);
    this.o = new Timer();
    this.o.schedule(this.p, 0L, 400L);
  }
  
  private void m()
  {
    this.n = new s(this.a);
    this.m = new PopupWindow(this.n);
    this.m.setWidth(com.pgyersdk.i.c.a(this.a, 80.0F));
    this.m.setHeight(com.pgyersdk.i.c.a(this.a, 80.0F));
    PopupWindow localPopupWindow;
    EditText localEditText;
    int i;
    if (this.a.getResources().getConfiguration().orientation == 1)
    {
      localPopupWindow = this.m;
      localEditText = this.s;
      i = com.pgyersdk.i.c.a(this.a, 115.0F);
      if (!(localPopupWindow instanceof PopupWindow)) {
        localPopupWindow.showAtLocation(localEditText, 48, 0, i);
      }
    }
    for (;;)
    {
      o();
      return;
      VdsAgent.showAtLocation((PopupWindow)localPopupWindow, localEditText, 48, 0, i);
      continue;
      localPopupWindow = this.m;
      localEditText = this.s;
      i = com.pgyersdk.i.c.a(this.a, 70.0F);
      if (!(localPopupWindow instanceof PopupWindow)) {
        localPopupWindow.showAtLocation(localEditText, 48, 0, i);
      } else {
        VdsAgent.showAtLocation((PopupWindow)localPopupWindow, localEditText, 48, 0, i);
      }
    }
  }
  
  private void n()
  {
    this.J.removeMessages(20005);
    if ((this.m != null) && (this.m.isShowing())) {
      this.m.dismiss();
    }
  }
  
  private void o()
  {
    int i = this.A.getMaxAmplitude();
    if (i < 800)
    {
      i = 0;
      this.I = 1;
    }
    for (;;)
    {
      if (i > 32768) {
        this.I = 7;
      }
      Message localMessage = new Message();
      localMessage.what = 20005;
      localMessage.obj = Integer.valueOf(this.I);
      this.J.sendMessageDelayed(localMessage, 100L);
      return;
      if ((i >= 800) && (i < 2000)) {
        this.I = 2;
      } else if ((i >= 2000) && (i < 4000)) {
        this.I = 3;
      } else if ((i >= 4000) && (i < 7000)) {
        this.I = 4;
      } else if ((i >= 7000) && (i < 10000)) {
        this.I = 5;
      } else if ((i >= 10000) && (i < 15000)) {
        this.I = 6;
      } else {
        this.I = 7;
      }
    }
  }
  
  protected View a(Context paramContext)
  {
    LinearLayout localLinearLayout = new LinearLayout(paramContext);
    localLinearLayout.setOnTouchListener(this.q);
    localLinearLayout.setBackgroundColor(-1);
    localLinearLayout.setOrientation(1);
    LinearLayout.LayoutParams localLayoutParams = g();
    a(paramContext, localLinearLayout);
    Object localObject = new LinearLayout.LayoutParams(-2, -2);
    ((LinearLayout.LayoutParams)localObject).gravity = 3;
    ((LinearLayout.LayoutParams)localObject).setMargins(com.pgyersdk.i.c.a(paramContext, 15.0F), 0, com.pgyersdk.i.c.a(paramContext, 20.0F), com.pgyersdk.i.c.a(paramContext, 20.0F));
    this.u = new CheckBox(paramContext);
    this.u.setText(b.a(1064));
    this.u.setTextColor(Color.parseColor(this.f));
    this.u.setChecked(true);
    localLinearLayout.addView(this.u, (ViewGroup.LayoutParams)localObject);
    localObject = new TextView(paramContext);
    ((TextView)localObject).setText(b.a(1065) + com.pgyersdk.b.a.g + "\t" + com.pgyersdk.b.a.f + "（" + com.pgyersdk.b.a.e + "）");
    ((TextView)localObject).setTextColor(Color.parseColor(this.f));
    ((TextView)localObject).setTextSize(12.0F);
    ((TextView)localObject).setPadding(com.pgyersdk.i.c.a(paramContext, 20.0F), 0, com.pgyersdk.i.c.a(paramContext, 20.0F), com.pgyersdk.i.c.a(paramContext, 20.0F));
    localLinearLayout.addView((View)localObject, localLayoutParams);
    return localLinearLayout;
  }
  
  protected View a(Context paramContext, LinearLayout paramLinearLayout)
  {
    LinearLayout.LayoutParams localLayoutParams = g();
    this.t = new EditText(paramContext);
    this.t.setHint(b.a(1045));
    this.t.setSingleLine(true);
    this.t.setPadding(com.pgyersdk.i.c.a(paramContext, 20.0F), com.pgyersdk.i.c.a(paramContext, 10.0F), com.pgyersdk.i.c.a(paramContext, 20.0F), com.pgyersdk.i.c.a(paramContext, 10.0F));
    this.t.setHintTextColor(Color.parseColor(this.g));
    this.t.setMinLines(1);
    this.t.setTextSize(14.0F);
    this.t.setGravity(19);
    this.t.setBackgroundColor(this.i);
    paramLinearLayout.addView(this.t, localLayoutParams);
    TextView localTextView = new TextView(paramContext);
    localTextView.setBackgroundColor(Color.parseColor("#f0f0f0"));
    localTextView.setHeight(com.pgyersdk.i.c.a(paramContext, 1.0F));
    paramLinearLayout.addView(localTextView, localLayoutParams);
    this.s = new EditText(paramContext);
    this.s.setHint(b.a(1044));
    this.s.setPadding(com.pgyersdk.i.c.a(paramContext, 20.0F), com.pgyersdk.i.c.a(paramContext, 10.0F), com.pgyersdk.i.c.a(paramContext, 20.0F), 0);
    this.s.setHintTextColor(Color.parseColor(this.g));
    this.s.setMinLines(8);
    this.s.setTextSize(14.0F);
    this.s.setGravity(51);
    this.s.setBackgroundColor(this.i);
    paramLinearLayout.addView(this.s, localLayoutParams);
    a(paramLinearLayout);
    this.t.setFocusable(true);
    this.t.setFocusableInTouchMode(true);
    this.t.requestFocus();
    h();
    return paramLinearLayout;
  }
  
  public void a() {}
  
  public void a(String paramString)
  {
    this.v = paramString;
  }
  
  protected View b(Context paramContext)
  {
    LinearLayout localLinearLayout = new LinearLayout(paramContext);
    localLinearLayout.setOrientation(1);
    localLinearLayout.setBackgroundColor(-1);
    localLinearLayout.setOnTouchListener(this.q);
    LinearLayout.LayoutParams localLayoutParams = g();
    b(paramContext, localLinearLayout);
    Object localObject = new LinearLayout.LayoutParams(-2, -2);
    ((LinearLayout.LayoutParams)localObject).setMargins(com.pgyersdk.i.c.a(paramContext, 15.0F), 0, com.pgyersdk.i.c.a(paramContext, 20.0F), com.pgyersdk.i.c.a(paramContext, 20.0F));
    this.u = new CheckBox(paramContext);
    this.u.setText(b.a(1064));
    this.u.setTextColor(Color.parseColor(this.f));
    this.u.setChecked(true);
    localLinearLayout.addView(this.u, (ViewGroup.LayoutParams)localObject);
    localObject = new TextView(paramContext);
    ((TextView)localObject).setText(b.a(1065) + com.pgyersdk.b.a.g + "\t" + com.pgyersdk.b.a.f + "（" + com.pgyersdk.b.a.e + "）");
    ((TextView)localObject).setTextColor(Color.parseColor(this.f));
    ((TextView)localObject).setTextSize(12.0F);
    ((TextView)localObject).setBackgroundColor(-1);
    ((TextView)localObject).setPadding(com.pgyersdk.i.c.a(paramContext, 20.0F), 0, 0, com.pgyersdk.i.c.a(paramContext, 20.0F));
    localLinearLayout.addView((View)localObject, localLayoutParams);
    return localLinearLayout;
  }
  
  protected View b(Context paramContext, LinearLayout paramLinearLayout)
  {
    LinearLayout.LayoutParams localLayoutParams = g();
    this.t = new EditText(paramContext);
    this.t.setHint(b.a(1045));
    this.t.setSingleLine(true);
    this.t.setPadding(com.pgyersdk.i.c.a(paramContext, 20.0F), com.pgyersdk.i.c.a(paramContext, 10.0F), com.pgyersdk.i.c.a(paramContext, 20.0F), com.pgyersdk.i.c.a(paramContext, 10.0F));
    this.t.setHintTextColor(Color.parseColor(this.g));
    this.t.setMinLines(1);
    this.t.setTextSize(14.0F);
    this.t.setGravity(19);
    this.t.setBackgroundColor(this.i);
    paramLinearLayout.addView(this.t, localLayoutParams);
    if (!com.pgyersdk.i.k.a("selfmail")) {
      this.t.setText(com.pgyersdk.i.i.a(paramContext, "selfmail"));
    }
    TextView localTextView = new TextView(paramContext);
    localTextView.setBackgroundColor(Color.parseColor("#f0f0f0"));
    localTextView.setHeight(com.pgyersdk.i.c.a(paramContext, 1.0F));
    paramLinearLayout.addView(localTextView, localLayoutParams);
    this.s = new EditText(paramContext);
    this.s.setPadding(com.pgyersdk.i.c.a(paramContext, 20.0F), com.pgyersdk.i.c.a(paramContext, 10.0F), com.pgyersdk.i.c.a(paramContext, 20.0F), 0);
    this.s.setHint(b.a(1044));
    this.s.setMinLines(2);
    this.s.setTextSize(14.0F);
    this.s.setHintTextColor(Color.parseColor(this.g));
    this.s.setGravity(51);
    this.s.setBackgroundColor(this.i);
    paramLinearLayout.addView(this.s, localLayoutParams);
    a(paramLinearLayout);
    h();
    return paramLinearLayout;
  }
  
  public EditText b()
  {
    return this.t;
  }
  
  public EditText c()
  {
    return this.s;
  }
  
  public CheckBox d()
  {
    return this.u;
  }
  
  public void e()
  {
    if (this.o != null) {
      this.o.cancel();
    }
    if (this.p != null) {
      this.p.cancel();
    }
    if (this.B == null)
    {
      this.B = new MediaPlayer();
      this.B.setOnCompletionListener(new k(this));
      this.B.setOnPreparedListener(new l(this));
    }
    if (this.B.isPlaying()) {
      this.B.reset();
    }
    this.B.setAudioStreamType(2);
    if (this.l.exists()) {}
    try
    {
      FileInputStream localFileInputStream = new FileInputStream(this.l);
      this.B.reset();
      this.B.setDataSource(localFileInputStream.getFD());
      this.B.prepare();
      this.B.start();
      l();
      return;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  public void f()
  {
    try
    {
      if ((this.B != null) && (this.B.isPlaying()))
      {
        this.B.stop();
        this.B.release();
      }
      if (this.A != null) {
        this.A.release();
      }
      com.pgyersdk.e.a.f(this.a);
      return;
    }
    catch (Exception localException) {}
  }
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    if (this.G.equals(paramView.getTag().toString())) {
      e();
    }
    if (this.H.equals(paramView.getTag().toString()))
    {
      this.x.setVisibility(8);
      this.w.setVisibility(0);
      d.a().a(this.l);
      com.pgyersdk.i.i.a("voicefile", "");
      com.pgyersdk.i.i.a("voiceTime", "");
      this.l = null;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/pgyersdk/views/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */