package cn.testin.analysis;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.StateListDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.growingio.android.sdk.agent.VdsAgent;
import java.util.ArrayList;
import java.util.List;

@TargetApi(11)
public class ay
  extends DialogFragment
{
  private Context a;
  private LinearLayout b;
  private List<String> c = new ArrayList();
  private List<View.OnClickListener> d = new ArrayList();
  private int e = Color.parseColor("#e6e6e6");
  private int f = -1;
  private String g;
  
  public static ay a(Context paramContext)
  {
    ay localay = new ay();
    localay.a = paramContext;
    return localay;
  }
  
  private void b(String paramString, View.OnClickListener paramOnClickListener)
  {
    int i = al.a(this.a, 10.0F);
    TextView localTextView = new TextView(this.a);
    localTextView.setText(paramString);
    localTextView.setTextSize(2, 16.0F);
    localTextView.setTextColor(this.f);
    localTextView.setGravity(17);
    localTextView.setBackgroundDrawable(f());
    localTextView.setPadding(0, i, 0, i);
    paramString = new LinearLayout.LayoutParams(-1, -2, 1.0F);
    this.b.addView(localTextView, paramString);
    localTextView.setOnClickListener(new az(this, paramOnClickListener));
  }
  
  private View c()
  {
    int i = 1;
    Object localObject1 = getActivity();
    LinearLayout localLinearLayout = new LinearLayout((Context)localObject1);
    localLinearLayout.setOrientation(1);
    localLinearLayout.setBackgroundDrawable(e());
    localLinearLayout.setGravity(1);
    int j = al.a((Context)localObject1, 20.0F);
    Object localObject2 = new TextView((Context)localObject1);
    if (!TextUtils.isEmpty(this.g)) {
      ((TextView)localObject2).setText(this.g);
    }
    ((TextView)localObject2).setTextSize(2, 16.0F);
    ((TextView)localObject2).setTextColor(this.f);
    ((TextView)localObject2).setPadding(j, j, j, j);
    localLinearLayout.addView((View)localObject2, new ViewGroup.LayoutParams(-2, -2));
    if (this.c.isEmpty())
    {
      this.c.add("确定");
      this.d.add(null);
    }
    localObject2 = new View((Context)localObject1);
    ((View)localObject2).setBackgroundColor(this.e);
    localLinearLayout.addView((View)localObject2, new ViewGroup.LayoutParams(-1, al.a((Context)localObject1, 1.0F)));
    this.b = new LinearLayout((Context)localObject1);
    this.b.setOrientation(0);
    localObject1 = new ViewGroup.LayoutParams(-1, -2);
    localLinearLayout.addView(this.b, (ViewGroup.LayoutParams)localObject1);
    b((String)this.c.get(0), (View.OnClickListener)this.d.get(0));
    while (i < this.c.size())
    {
      d();
      b((String)this.c.get(i), (View.OnClickListener)this.d.get(i));
      i += 1;
    }
    return localLinearLayout;
  }
  
  private void d()
  {
    View localView = new View(this.a);
    localView.setBackgroundColor(this.e);
    ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(al.a(this.a, 1.0F), -1);
    this.b.addView(localView, localLayoutParams);
  }
  
  private Drawable e()
  {
    ShapeDrawable localShapeDrawable = new ShapeDrawable(new RectShape());
    localShapeDrawable.getPaint().setColor(Color.parseColor("#303030"));
    localShapeDrawable.getPaint().setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_ATOP));
    return localShapeDrawable;
  }
  
  private Drawable f()
  {
    StateListDrawable localStateListDrawable = new StateListDrawable();
    ColorDrawable localColorDrawable = new ColorDrawable(0);
    localStateListDrawable.addState(new int[] { 16842910 }, localColorDrawable);
    return localStateListDrawable;
  }
  
  public ay a(String paramString)
  {
    this.g = paramString;
    return this;
  }
  
  public ay a(String paramString, View.OnClickListener paramOnClickListener)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      this.c.add(paramString);
      this.d.add(paramOnClickListener);
    }
    return this;
  }
  
  public void a()
  {
    FragmentManager localFragmentManager = ((Activity)this.a).getFragmentManager();
    if (!(this instanceof DialogFragment))
    {
      show(localFragmentManager, "CommonFragment");
      return;
    }
    VdsAgent.showDialogFragment((DialogFragment)this, localFragmentManager, "CommonFragment");
  }
  
  public ay b()
  {
    super.setCancelable(false);
    return this;
  }
  
  public Dialog onCreateDialog(Bundle paramBundle)
  {
    paramBundle = new AlertDialog.Builder(getActivity());
    paramBundle.setView(c());
    paramBundle = paramBundle.create();
    paramBundle.requestWindowFeature(1);
    return paramBundle;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/testin/analysis/ay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */