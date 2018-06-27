package cn.testin.analysis;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.os.Bundle;
import android.os.Vibrator;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import org.json.JSONException;
import org.json.JSONObject;

@TargetApi(11)
public class TesterActivity
  extends Activity
  implements View.OnClickListener, gq
{
  private final int a = 0;
  private final int b = 1;
  private TextView c;
  private TextView d;
  private TextView e;
  private TextView f;
  private TextView g;
  private int h = Color.parseColor("#1BA0E1");
  private int i;
  private String j;
  private String k;
  private String l;
  private String m;
  private String n;
  private String o;
  private String p;
  private ax q;
  
  private void a(boolean paramBoolean, String paramString)
  {
    if (paramBoolean) {
      e();
    }
    String str1;
    if (paramBoolean)
    {
      str1 = "确定";
      if (!paramBoolean) {
        break label77;
      }
    }
    label77:
    for (String str2 = null;; str2 = "重试")
    {
      e locale = new e(this, paramBoolean);
      f localf = new f(this);
      ay.a(this).a(paramString).a(str1, locale).a(str2, localf).b().a();
      return;
      str1 = "取消";
      break;
    }
  }
  
  private boolean b(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      paramString = Toast.makeText(this, "扫描二维码错误，请重新尝试", 0);
      if (!(paramString instanceof Toast)) {
        paramString.show();
      }
      for (;;)
      {
        return false;
        VdsAgent.showToast((Toast)paramString);
      }
    }
    Object localObject;
    try
    {
      localObject = new JSONObject(paramString);
      paramString = ((JSONObject)localObject).optString("appKey");
      localObject = ((JSONObject)localObject).optString("expVersionId");
      if ((!TextUtils.isEmpty(paramString)) && (!TextUtils.isEmpty((CharSequence)localObject))) {
        break label133;
      }
      paramString = Toast.makeText(this, "扫描二维码错误，请重新尝试", 0);
      if (!(paramString instanceof Toast)) {
        paramString.show();
      } else {
        VdsAgent.showToast((Toast)paramString);
      }
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
      paramString = Toast.makeText(this, "扫描二维码错误，请重新尝试", 0);
      if ((paramString instanceof Toast)) {
        break label183;
      }
    }
    paramString.show();
    for (;;)
    {
      return true;
      label133:
      if (!paramString.equals(a.e))
      {
        paramString = Toast.makeText(this, "appkey不一致，请重新尝试", 0);
        if (!(paramString instanceof Toast))
        {
          paramString.show();
          break;
        }
        VdsAgent.showToast((Toast)paramString);
        break;
      }
      c((String)localObject);
      continue;
      label183:
      VdsAgent.showToast((Toast)paramString);
    }
    return false;
    return false;
  }
  
  private void c()
  {
    this.j = "已成功进入实验版本";
    this.k = "当前未加入实验版本";
    this.n = "加入其他版本";
    this.o = "加入实验版本";
    this.l = "如需进入该实验的其他调试版本，请点击按钮“进入其他版本”来实现版本切换。\n\n如果完成调试，请点击“结束调试”按钮。结束调试后版本将恢复到原始版本。\n\n加入实验版本或者结束调试后，请重新进入app查看实验版本效果。";
    this.m = "加入实验版本步骤：\n\n1. 点击“加入实验版本”按钮，进入扫码界面。\n\n2. 打开集成调试页面，选择对应的版本进行二维码扫描。\n\n3. 扫描成功后，请重新进入app查看实验版本效果。";
  }
  
  private void c(String paramString)
  {
    au.a(au.b(this), "debugVersionId", paramString);
    aa.h();
  }
  
  private void d()
  {
    this.d.setOnClickListener(this);
    this.c.setOnClickListener(this);
    this.e.setOnClickListener(this);
  }
  
  private void e()
  {
    Object localObject;
    label22:
    String str1;
    label31:
    String str2;
    if (!"0".equals(a.h))
    {
      i1 = 1;
      if (i1 == 0) {
        break label88;
      }
      localObject = this.j;
      if (i1 == 0) {
        break label96;
      }
      str1 = this.l;
      if (i1 == 0) {
        break label104;
      }
      str2 = this.n;
      label41:
      this.f.setText((CharSequence)localObject);
      this.g.setText(str1);
      this.c.setText(str2);
      localObject = this.d;
      if (i1 == 0) {
        break label113;
      }
    }
    label88:
    label96:
    label104:
    label113:
    for (int i1 = 0;; i1 = 8)
    {
      ((TextView)localObject).setVisibility(i1);
      return;
      i1 = 0;
      break;
      localObject = this.k;
      break label22;
      str1 = this.m;
      break label31;
      str2 = this.o;
      break label41;
    }
  }
  
  private Drawable f()
  {
    float f1 = al.a(this, 4.0F);
    ShapeDrawable localShapeDrawable = new ShapeDrawable(new RoundRectShape(new float[] { f1, f1, f1, f1, f1, f1, f1, f1 }, null, null));
    localShapeDrawable.getPaint().setColor(this.h);
    return localShapeDrawable;
  }
  
  private Drawable g()
  {
    float f1 = al.a(this, 4.0F);
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setCornerRadius(f1);
    localGradientDrawable.setStroke(al.a(this, 1.0F), this.h);
    localGradientDrawable.setColor(-1);
    return localGradientDrawable;
  }
  
  private void h()
  {
    if (this.q == null)
    {
      this.q = new ax();
      this.q.a(this);
    }
    ax localax = this.q;
    FragmentManager localFragmentManager = getFragmentManager();
    if (!(localax instanceof DialogFragment))
    {
      localax.show(localFragmentManager, "captureFragment");
      return;
    }
    VdsAgent.showDialogFragment((DialogFragment)localax, localFragmentManager, "captureFragment");
  }
  
  private void i()
  {
    if (this.q != null) {
      this.q.dismiss();
    }
  }
  
  private void j()
  {
    this.p = a.h;
    this.i = 1;
    c(null);
    k();
  }
  
  private void k()
  {
    bc.a(this);
    aa.a().a(new d(this), 0, false);
  }
  
  private void l()
  {
    ay.a(this).a("相机使用权限被禁止").a("确定", null).a();
  }
  
  private void m()
  {
    if (al.b(this, "android.permission.VIBRATE")) {
      ((Vibrator)getSystemService("vibrator")).vibrate(200L);
    }
  }
  
  public View a()
  {
    int i1 = Color.parseColor("#4a4a4a");
    int i2 = al.a(this, 30.0F);
    int i3 = al.a(this, 130.0F);
    int i4 = al.a(this, 30.0F);
    ScrollView localScrollView = new ScrollView(this);
    localScrollView.setFillViewport(true);
    LinearLayout localLinearLayout = new LinearLayout(this);
    localLinearLayout.setOrientation(1);
    localLinearLayout.setBackgroundColor(-1);
    localLinearLayout.setGravity(1);
    localScrollView.addView(localLinearLayout, new ViewGroup.LayoutParams(-1, -1));
    Object localObject1 = new RelativeLayout(this);
    ((RelativeLayout)localObject1).setBackgroundColor(this.h);
    localLinearLayout.addView((View)localObject1, new ViewGroup.LayoutParams(-1, al.a(this, 56.0F)));
    Object localObject2 = new TextView(this);
    ((TextView)localObject2).getPaint().setFakeBoldText(true);
    ((TextView)localObject2).setTextColor(-1);
    ((TextView)localObject2).setTextSize(2, 18.0F);
    ((TextView)localObject2).setText("Testin A/B Tester");
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(13);
    ((RelativeLayout)localObject1).addView((View)localObject2, localLayoutParams);
    this.e = new TextView(this);
    this.e.setTextColor(-1);
    this.e.setTextSize(2, 14.0F);
    this.e.setText("关闭");
    this.e.setGravity(17);
    this.e.setPadding(al.a(this, 10.0F), 0, al.a(this, 15.0F), 0);
    localObject2 = new RelativeLayout.LayoutParams(-2, -1);
    ((RelativeLayout)localObject1).addView(this.e, (ViewGroup.LayoutParams)localObject2);
    this.f = new TextView(this);
    this.f.setTextSize(2, 18.0F);
    this.f.setTextColor(i1);
    this.f.setGravity(1);
    this.f.setPadding(0, i2, 0, 0);
    localLinearLayout.addView(this.f);
    this.g = new TextView(this);
    this.g.setTextSize(2, 14.0F);
    this.g.setTextColor(i1);
    this.g.setPadding(i2, al.a(this, 20.0F), i2, 0);
    localLinearLayout.addView(this.g);
    this.c = new TextView(this);
    this.c.setTextSize(2, 16.0F);
    this.c.setTextColor(this.h);
    this.c.setGravity(17);
    this.c.setBackgroundDrawable(g());
    localObject1 = new LinearLayout.LayoutParams(i3, i4);
    ((LinearLayout.LayoutParams)localObject1).setMargins(0, i2, 0, 0);
    localLinearLayout.addView(this.c, (ViewGroup.LayoutParams)localObject1);
    this.d = new TextView(this);
    this.d.setTextSize(2, 16.0F);
    this.d.setTextColor(-1);
    this.d.setText("结束调试");
    this.d.setGravity(17);
    this.d.setBackgroundDrawable(f());
    localObject1 = new LinearLayout.LayoutParams(i3, i4);
    ((LinearLayout.LayoutParams)localObject1).setMargins(0, i2, 0, 0);
    localLinearLayout.addView(this.d, (ViewGroup.LayoutParams)localObject1);
    return localScrollView;
  }
  
  public void a(String paramString)
  {
    ar.b("QRCodeResult:" + paramString);
    m();
    i();
    this.p = a.h;
    this.i = 0;
    if (b(paramString)) {
      k();
    }
  }
  
  public void b()
  {
    ay.a(this).a("打开相机出错").a("确定", new c(this)).a();
  }
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    if (paramView == this.c) {
      if (al.b(this, "android.permission.CAMERA")) {
        h();
      }
    }
    do
    {
      return;
      l();
      return;
      if (paramView == this.d)
      {
        j();
        return;
      }
    } while (paramView != this.e);
    finish();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(a());
    setRequestedOrientation(1);
    c();
    d();
    e();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/testin/analysis/TesterActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */