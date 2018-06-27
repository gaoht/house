package com.pgyersdk.views;

import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.pgyersdk.i.c;
import com.pgyersdk.i.i;
import com.pgyersdk.i.k;
import com.pgyersdk.i.m;
import java.io.File;

public class b
  extends RelativeLayout
  implements View.OnClickListener
{
  public static String a = "#2E2D2D";
  public static String b = "#2E2D2D";
  public static String c = "#272828";
  public static View i;
  public static String p;
  private static String s = "#ffffff";
  private String A = "#ED3A3A";
  public n d;
  p e;
  a f;
  a g;
  a h;
  int j;
  int k;
  ObjectAnimator l;
  ObjectAnimator m;
  TranslateAnimation n;
  TranslateAnimation o;
  LinearLayout.LayoutParams q;
  ColorDrawable r;
  private String t;
  private a u;
  private a v;
  private View w;
  private Context x;
  private boolean y = false;
  private ImageView z;
  
  public b(Context paramContext, String paramString)
  {
    super(paramContext);
    this.x = paramContext;
    this.t = paramString;
    if (paramContext.getResources().getConfiguration().orientation == 1)
    {
      a(paramContext);
      return;
    }
    b(paramContext);
  }
  
  private View a(Context paramContext, f paramf, int paramInt, Paint paramPaint)
  {
    Object localObject2 = new ShapeDrawable(new d(this, paramPaint, paramContext, paramInt));
    paramPaint = new FrameLayout(paramContext);
    Object localObject1 = new BitmapDrawable(com.pgyersdk.i.f.a("iVBORw0KGgoAAAANSUhEUgAAADwAAAA8CAMAAAANIilAAAAAV1BMVEUAAAD///////////////////////////////////////////////////////////////////////////////////////////////////////////////+ORg7oAAAAHHRSTlMA+8MbFQ/vP8molVVIBtB88+S+QrSzrqVzcN99O8Pg/gAAASJJREFUSMe111mOgzAQBNC2wWbfIQtT9z/nSBESIiFgupT3X5J3d8s+VzZZ2rVA26VZUzoJFj2swYaxjygomkwGO8yUnEctvrLH8eiOQ/eDwRceJ3wh+6ocAfJqL+t6BLHxZzZOEaj+SLsawWr3Nt8eF/Tbeee4JN/sES4q1mzkcZFfT8sNl91kMUBhWMIWCna5SFBJXuEJKtPrXBqomFhEnlB6rsulWjJnoGSclFArpYHan2RQyySFWiod1DppodYKCEzYMMP2zILN1FZRh4Q6ntTFoK4k8xhQzxD7AMoIlZF69JnvhvromC+W+tyZsoIpaIhSylayEdeAqgRc0oosUbgSJTNRrBNtgqZBGeRMMu63RmPy66ZsbQdnb4yfD9rBf/ksMN7cBHqMAAAAAElFTkSuQmCC"));
    if (Build.VERSION.SDK_INT >= 16) {
      paramPaint.setBackground((Drawable)localObject1);
    }
    localObject1 = new TextView(paramContext);
    ((TextView)localObject1).setBackgroundDrawable((Drawable)localObject2);
    ((TextView)localObject1).setClickable(true);
    ((TextView)localObject1).setTag(paramf);
    ((TextView)localObject1).setOnClickListener(new e(this));
    ((TextView)localObject1).setGravity(17);
    paramPaint.addView((View)localObject1);
    paramf = new ImageView(paramContext);
    paramf.setImageBitmap(com.pgyersdk.i.f.a("iVBORw0KGgoAAAANSUhEUgAAADwAAAA8CAYAAAA6/NlyAAAAAXNSR0IArs4c6QAA ABxpRE9UAAAAAgAAAAAAAAAeAAAAKAAAAB4AAAAeAAABamLW3/kAAAE2SURBVGgF 1JlbC8IwDIWnvqgPCuJt4OX//8qZ8xAoQ9xMs5y0EDqVtvly2tR2XbdcWUvXO7Gj 2FnsLvYQe4m9xbphGMIN43qWjXR2EAMcoH5ZOCwC7FW20tF1AnAM3yQwQOeoOYbF 56aAMXWxLr+BzP2uGeC9gD4rYZtQeCWQJwdQnQGpFcYWc3OETa0w1mvvDJsWGMou AZsSGGvWexrr+k0J7JmgSlB9TpW0sPWoY0vVaYCRpDz22alApQG+BKiLYKQAxn/j KWW8fk8BbD0IWIJAB45UN8WU/vc8a1G1bENVGJm5dCbimQqMa5kIyHIMKnBkslJo GjAOCOpEZE0DxlVqJKiORQPGvbE6EVnTgGsv46xBogEzEhaCRAPG6w+rSjXtaMD6 rqfGeUtbGrDFWY82FOAPAAAA//+Fw8fAAAAA9UlEQVTl2ckOAjEIgGFcDupBE+O+ vv9TVn7j3F1aoNKETK9fmMLQERG5O4WUUsxDrXLLBr5kAx+ygTfZwKts4Hk28Dgb WL3iUbjMezB9f1hL3Vh/gLiCJ9nAZHpnjHbNMOBZNjBoy+LlnmHAllkOAQa91bCo 2GHAVOyrAToMWK2yyAYGvW6MDpVhwCONfUN0ODBoBotTI3RIMGiK2LEBOiwYNJmu /XqHBoPmTNcsZOHBoFm0rBp9uhswaM71r5d/XYFBs/j2/nbg6BL8VL/gn87TXYMH +FQ3XBe9k/W/AA9wnrQyroC592YCo5efNSh4/M9yAT8APkf75B/DphwAAAAASUVO RK5CYII="));
    localObject2 = new ImageView(paramContext);
    FrameLayout.LayoutParams localLayoutParams = getDefaultFrameLayoutParams();
    localLayoutParams.width = c.a(paramContext, 10.0F);
    localLayoutParams.height = localLayoutParams.width;
    localLayoutParams.gravity = 17;
    ((ImageView)localObject2).setImageBitmap(com.pgyersdk.i.f.a("iVBORw0KGgoAAAANSUhEUgAAACQAAAAcCAYAAAAJKR1YAAAAAXNSR0IArs4c6QAA AAlwSFlzAAAWJQAAFiUBSVIk8AAAABxpRE9UAAAAAgAAAAAAAAAOAAAAKAAAAA4A AAAOAAABhhAbPSQAAAFSSURBVFgJvJU9SgRBEIUnEhVFEQTBQDDxFN7BQMRANhED MRENxMTbGBgaiCAGIiIGipFgIhgIHmAx8f97sE962t6ZRpwJHjXVVfXqg53eKV66 3aJFDbBrHy3229k2zCEgX+gdLaeg2gIaYvkxEowlqA4qMZSSuPhP+TA+p8ggYfzg fC3c0zTQKMvO+8AY7JP6hqGaBBpjyWUNTAi1LaimgCYwv86EMZTibhXQAg0HSFe1 qi+uTdJ/i8JFuc97sZnzJQxfe6ZHxEHkWlWcou+uN5cL4b4d7UiZr1DQlXSj4gnS bUn1+2ya+j0K53Ke9VJv2dtmjqsUYhibnlEb8WAUZ8gfkHtzY+mGydMgiutIDVVm F9R1e8K5WfLHmrmU56//IPnaeJOkDsamV/SOaxjNoSfkWm7Ur9BB3v8T9aCXKdfI fTfMzKPnP8y+MZP8jnFefAMAAP//TmVJhgAAARVJREFUvZO9agJBFIV9DMFCsBGs RAkWEcRCBLEQi1RWaaxSWvl2PoWNYBEIBILKKv4gmu8WC7PLnXVm17X42Jk7955z mGUKhyCYw/1FnPEZQ8FGeDB7QaATHkNbkLAeBpLvF9wgj9s6oNsH009dx4vTHELt 0ey6hJGeeCDZf8IVnnFTO3TaoPmoNbWIwASyhtqi0fIJI722QFL/gAukuak/5pqQ pK+eqUVDaMRanqpPqF/664bGI4/IeWRjERlQP4JLqB/6ahYdF6/EX2YK9DCRp5sU 6pvzapYwMmuaPlp3GAhAC7WmXhHBrPgKvGMor8cMtWJfzhoknPcNJP1vsAEJtYQS pNFRZ9Sig0GDngUUHXq9PP4B62fQcqx0J7wAAAAASUVORK5CYII="));
    ((ImageView)localObject2).setVisibility(8);
    ((f)((TextView)localObject1).getTag()).b = ((ImageView)localObject2);
    if (this.A.equals(((f)((TextView)localObject1).getTag()).a)) {
      ((ImageView)localObject2).setVisibility(0);
    }
    paramPaint.addView(paramf);
    paramPaint.addView((View)localObject2, localLayoutParams);
    return paramPaint;
  }
  
  private p a(Context paramContext, int paramInt)
  {
    this.e = new p(paramContext, Color.parseColor(c));
    this.e.setGravity(16);
    this.e.setPadding(0, 0, 0, c.a(paramContext, 5.0F));
    LinearLayout.LayoutParams localLayoutParams = getDefaultLayoutParams1();
    localLayoutParams.setMargins(c.a(paramContext, 10.0F), 0, c.a(paramContext, 10.0F), 0);
    localLayoutParams.gravity = 16;
    localLayoutParams.height = c.a(paramContext, 30.0F);
    int i1 = 0;
    if (i1 < 6)
    {
      Paint localPaint = new Paint();
      localPaint.setStyle(Paint.Style.FILL);
      String str = "#ED3A3A";
      switch (i1)
      {
      }
      for (;;)
      {
        localPaint.setColor(Color.parseColor(str));
        f localf = new f(this);
        localf.a = str;
        this.e.addView(a(paramContext, localf, paramInt, localPaint), localLayoutParams);
        i1 += 1;
        break;
        str = "#ED3A3A";
        continue;
        str = "#006AA1";
        continue;
        str = "#5CC500";
        continue;
        str = "#F1B600";
        continue;
        str = "#F77A00";
        continue;
        str = "#E5E5E5";
      }
    }
    return this.e;
  }
  
  @TargetApi(14)
  private void a(Context paramContext)
  {
    Object localObject1 = new LinearLayout(paramContext);
    ((LinearLayout)localObject1).setBackgroundColor(-1);
    ((LinearLayout)localObject1).setOrientation(1);
    ((LinearLayout)localObject1).setFitsSystemWindows(true);
    ((LinearLayout)localObject1).setClipToPadding(false);
    Object localObject2 = getDefaultLayoutParams();
    this.w = c(paramContext);
    ((LinearLayout)localObject1).addView(this.w, (ViewGroup.LayoutParams)localObject2);
    this.q = getDefaultLayoutParams();
    localObject2 = new LinearLayout(paramContext);
    ((LinearLayout)localObject2).setGravity(17);
    this.q.setMargins(c.a(paramContext, 40.0F), 0, c.a(paramContext, 40.0F), 0);
    this.q.gravity = 17;
    this.d = new n(paramContext);
    this.d.setScaleType(ImageView.ScaleType.FIT_XY);
    this.j = paramContext.getResources().getDisplayMetrics().widthPixels;
    this.k = paramContext.getResources().getDisplayMetrics().heightPixels;
    int i1 = View.MeasureSpec.makeMeasureSpec(0, 0);
    int i2 = View.MeasureSpec.makeMeasureSpec(0, 0);
    this.w.measure(i1, i2);
    i1 = this.w.getMeasuredHeight();
    this.q.height = (this.k - i1 - c.a(paramContext, 70.0F));
    this.q.width = (this.q.height * this.j / this.k);
    this.d.setImageBitmap(com.pgyersdk.i.f.a(paramContext, this.t, this.q.width, this.q.height));
    ((LinearLayout)localObject2).addView(this.d, this.q);
    ((LinearLayout)localObject1).addView((View)localObject2, getDefaultLayoutParams1());
    addView((View)localObject1);
    i1 = c.a(paramContext, 30.0F);
    i2 = c.a(paramContext, 120.0F);
    localObject1 = getRelativeLayoutParams();
    ((RelativeLayout.LayoutParams)localObject1).addRule(12);
    ((RelativeLayout.LayoutParams)localObject1).width = (i2 + i1 * 6);
    ((RelativeLayout.LayoutParams)localObject1).height = c.a(paramContext, 45.0F);
    ((RelativeLayout.LayoutParams)localObject1).setMargins(c.a(paramContext, 5.0F), 0, 0, 0);
    this.e = a(paramContext, i1);
    addView(this.e, (ViewGroup.LayoutParams)localObject1);
    localObject2 = getRelativeLayoutParams();
    ((RelativeLayout.LayoutParams)localObject2).addRule(12);
    LinearLayout localLinearLayout = new LinearLayout(paramContext);
    localLinearLayout.setLayoutParams(getDefaultLayoutParams());
    localLinearLayout.setOrientation(1);
    localObject1 = getDefaultLayoutParams();
    ((LinearLayout.LayoutParams)localObject1).height = c.a(paramContext, 45.0F);
    ((LinearLayout.LayoutParams)localObject1).gravity = 16;
    localLinearLayout.addView(d(paramContext), (ViewGroup.LayoutParams)localObject1);
    addView(localLinearLayout, (ViewGroup.LayoutParams)localObject2);
    i = new View(paramContext);
    localObject2 = getRelativeLayoutParams();
    ((RelativeLayout.LayoutParams)localObject2).height = this.k;
    ((RelativeLayout.LayoutParams)localObject2).width = this.j;
    i.setBackgroundColor(Color.parseColor("#9f000000"));
    addView(i, (ViewGroup.LayoutParams)localObject2);
    i.setVisibility(8);
    if (Build.VERSION.SDK_INT >= 11)
    {
      this.l = ObjectAnimator.ofFloat(this.e, "translationY", new float[] { 0.0F, -(((LinearLayout.LayoutParams)localObject1).height + c.a(paramContext, 2.0F)) });
      this.l.setDuration(300L);
      this.m = ObjectAnimator.ofFloat(this.e, "translationY", new float[] { -(((LinearLayout.LayoutParams)localObject1).height + c.a(paramContext, 2.0F)), 0.0F });
      this.m.setDuration(300L);
      return;
    }
    this.n = new TranslateAnimation(0.0F, 0.0F, 0.0F, -c.a(paramContext, 45.0F));
    this.n.setDuration(300L);
    this.n.setFillAfter(true);
    this.n.setFillEnabled(true);
    this.o = new TranslateAnimation(0.0F, 0.0F, c.a(paramContext, 45.0F), 0.0F);
    this.o.setDuration(300L);
    this.o.setFillAfter(true);
    this.o.setFillEnabled(true);
  }
  
  private void a(View paramView)
  {
    int i1 = 0;
    while (i1 < this.e.getChildCount())
    {
      FrameLayout localFrameLayout = (FrameLayout)this.e.getChildAt(i1);
      int i2 = 0;
      if (i2 < localFrameLayout.getChildCount())
      {
        View localView = localFrameLayout.getChildAt(i2);
        f localf;
        if (((localView instanceof TextView)) && ((localView.getTag() instanceof f)))
        {
          localf = (f)localView.getTag();
          if (!localView.equals(paramView)) {
            break label137;
          }
          localf.b.setVisibility(0);
          this.A = localf.a;
          this.r = new ColorDrawable(Color.parseColor(this.A));
          this.z.setImageDrawable(this.r);
        }
        for (;;)
        {
          i2 += 1;
          break;
          label137:
          localf.b.setVisibility(8);
        }
      }
      i1 += 1;
    }
  }
  
  @TargetApi(14)
  private void b(Context paramContext)
  {
    Object localObject1 = new LinearLayout(paramContext);
    ((LinearLayout)localObject1).setBackgroundColor(-1);
    ((LinearLayout)localObject1).setOrientation(1);
    ((LinearLayout)localObject1).setFitsSystemWindows(true);
    ((LinearLayout)localObject1).setClipToPadding(false);
    Object localObject2 = getDefaultLayoutParams();
    ((LinearLayout.LayoutParams)localObject2).width = paramContext.getResources().getDisplayMetrics().widthPixels;
    this.w = c(paramContext);
    ((LinearLayout)localObject1).addView(this.w, (ViewGroup.LayoutParams)localObject2);
    this.q = getDefaultLayoutParams();
    localObject2 = new LinearLayout(paramContext);
    ((LinearLayout)localObject2).setGravity(17);
    this.q.setMargins(c.a(paramContext, 40.0F), 0, c.a(paramContext, 40.0F), 0);
    this.q.gravity = 49;
    this.d = new n(paramContext);
    this.d.setScaleType(ImageView.ScaleType.FIT_XY);
    this.j = paramContext.getResources().getDisplayMetrics().widthPixels;
    this.k = paramContext.getResources().getDisplayMetrics().heightPixels;
    int i1 = View.MeasureSpec.makeMeasureSpec(0, 0);
    int i2 = View.MeasureSpec.makeMeasureSpec(0, 0);
    this.w.measure(i1, i2);
    i1 = this.w.getMeasuredHeight();
    this.q.height = (this.k - i1 - c.a(paramContext, 70.0F));
    this.q.width = (this.q.height * this.j / this.k);
    this.d.setImageBitmap(com.pgyersdk.i.f.a(paramContext, this.t, this.q.width, this.q.height));
    ((LinearLayout)localObject2).addView(this.d, this.q);
    ((LinearLayout)localObject1).addView((View)localObject2, getDefaultLayoutParams1());
    addView((View)localObject1);
    i1 = c.a(paramContext, 30.0F);
    i2 = c.a(paramContext, 120.0F);
    localObject1 = getRelativeLayoutParams();
    ((RelativeLayout.LayoutParams)localObject1).addRule(12);
    ((RelativeLayout.LayoutParams)localObject1).width = (i2 + i1 * 6);
    ((RelativeLayout.LayoutParams)localObject1).height = c.a(paramContext, 45.0F);
    ((RelativeLayout.LayoutParams)localObject1).setMargins(c.a(paramContext, 5.0F), 0, 0, 0);
    this.e = a(paramContext, i1);
    addView(this.e, (ViewGroup.LayoutParams)localObject1);
    localObject2 = getRelativeLayoutParams();
    ((RelativeLayout.LayoutParams)localObject2).addRule(12);
    LinearLayout localLinearLayout = new LinearLayout(paramContext);
    localLinearLayout.setLayoutParams(getDefaultLayoutParams());
    localLinearLayout.setOrientation(1);
    localObject1 = getDefaultLayoutParams();
    ((LinearLayout.LayoutParams)localObject1).height = c.a(paramContext, 45.0F);
    ((LinearLayout.LayoutParams)localObject1).gravity = 16;
    localLinearLayout.addView(d(paramContext), (ViewGroup.LayoutParams)localObject1);
    addView(localLinearLayout, (ViewGroup.LayoutParams)localObject2);
    i = new View(paramContext);
    localObject2 = getRelativeLayoutParams();
    ((RelativeLayout.LayoutParams)localObject2).height = this.k;
    ((RelativeLayout.LayoutParams)localObject2).width = this.j;
    i.setBackgroundColor(Color.parseColor("#9f000000"));
    addView(i, (ViewGroup.LayoutParams)localObject2);
    i.setVisibility(8);
    if (Build.VERSION.SDK_INT >= 11)
    {
      this.l = ObjectAnimator.ofFloat(this.e, "translationY", new float[] { 0.0F, -(((LinearLayout.LayoutParams)localObject1).height + c.a(paramContext, 2.0F)) });
      this.l.setDuration(300L);
      this.m = ObjectAnimator.ofFloat(this.e, "translationY", new float[] { -(((LinearLayout.LayoutParams)localObject1).height + c.a(paramContext, 2.0F)), 0.0F });
      this.m.setDuration(300L);
      return;
    }
    this.n = new TranslateAnimation(0.0F, 0.0F, 0.0F, -c.a(paramContext, 45.0F));
    this.n.setDuration(300L);
    this.n.setFillAfter(true);
    this.n.setFillEnabled(true);
    this.o = new TranslateAnimation(0.0F, 0.0F, c.a(paramContext, 45.0F), 0.0F);
    this.o.setDuration(300L);
    this.o.setFillAfter(true);
    this.o.setFillEnabled(true);
  }
  
  private View c(Context paramContext)
  {
    LinearLayout localLinearLayout = new LinearLayout(paramContext);
    localLinearLayout.setBackgroundColor(Color.parseColor(a));
    this.u = new a(paramContext);
    this.u.setImageBitmap(com.pgyersdk.i.f.a(com.pgyersdk.i.f.a("iVBORw0KGgoAAAANSUhEUgAAADwAAAA8BAMAAADI0sRBAAAAIVBMVEUAAAD////////////////////////////////////////PIev5AAAACnRSTlMA90eSsOpoKxoI1urS1QAAAJpJREFUOMvtz7sJhEAAhGE54R7phRedYAEmJoaGpjZgCZZgCbYgWqgwBrPs8hcgOtHOLt/CZHcumU8btnKOnp/L3+XxG2LefH0u1uT3/OAHrnxvDtjcGLgxcOOEGxMXRi7MXJi5MHNhTLfhkzZrO6VYtR1xlTPXZubaLI5YnLE4YnPA4oDNAZsDNk8w8lcftnqM+RSWd3bnpNkB6m8e8+TpDLMAAAAASUVORK5CYII="), c.a(paramContext, 40.0F), c.a(paramContext, 40.0F)));
    LinearLayout.LayoutParams localLayoutParams1 = getDefaultLayoutParams();
    localLayoutParams1.width = c.a(paramContext, 50.0F);
    localLayoutParams1.height = localLayoutParams1.width;
    localLayoutParams1.setMargins(0, 0, 0, 0);
    localLayoutParams1.gravity = 16;
    this.u.setOnClickListener(this);
    localLinearLayout.addView(this.u, localLayoutParams1);
    LinearLayout.LayoutParams localLayoutParams2 = getDefaultLayoutParams1();
    TextView localTextView = new TextView(paramContext);
    localTextView.setTextSize(22.0F);
    localTextView.setText(com.pgyersdk.b.b.a(1062));
    localTextView.setTextColor(Color.parseColor(s));
    localTextView.setPadding(30, 20, 0, 20);
    localTextView.setBackgroundColor(Color.parseColor(a));
    localTextView.setGravity(17);
    localLinearLayout.addView(localTextView, localLayoutParams2);
    this.v = new a(paramContext);
    this.v.setImageBitmap(com.pgyersdk.i.f.a(com.pgyersdk.i.f.a("iVBORw0KGgoAAAANSUhEUgAAADwAAAA8CAMAAAANIilAAAAApVBMVEUAAAD///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////+4/eNVAAAANnRSTlMA++b07hUN+N6lcDsJ1s0c8OqcSyjRwryqiXY0LAPbysW1sJiWaSQGBIN9ZWJgW1BEMBjioJBbXN1rAAABxUlEQVRIx+2Tx3LbQBAFZwmQyBBAMeecaSrY/f+f5tUaBcgHkQAvLqvYB/LNoWtRU/PkwYPvwmhG5041bDqg7nOPKcoiuUcdxhDZEFdX657C9iNqeJVd30b9bHSpdfErqkEE05EssVouw0rq20JRO4usUc875YwrqOO9hbMKRV4UAwmYVHCfXehsdGjZNEUGzEurT114v4im4ZrT6rEvqW77FlZ/Z3KMG+q/Ns/l3B/vMH8Sg0dqUkKjjNrqwOQlGw44gWg21MpUYOmQHPJvUJxNODG77Z5SVK+eX7VFXwwrVqUqEBRHkrLI4ozzdbVhKlDMYUS8y3KNTYkKSIFuQz2LDZKbFXiVT6ywRvm50b5yUAtFepKCP23Ihz29r2UHlqEUZG3ImevhS2ywm8VKsjYUTAiuLPowATU9msrmbcgZO2on1wgW1sfzLTNMTRtyhrhyg8YgAmLdgz62/i3wS5U56Fn2WN4cLvIZj76UIdSb+UVX/iLmImVxP4q/HklOQr20rCy9AId4vc1OiLS0W6emhZ4FiTcyrWZWSdaEfgS0/a3eQbOabHj1zPNtjlVlw9ZvA7Qqy/nz7lKqywX/g/zgwb/nN0WyL+YC26DcAAAAAElFTkSuQmCC"), c.a(paramContext, 40.0F), c.a(paramContext, 40.0F)));
    localLayoutParams2 = getDefaultLayoutParams();
    localLayoutParams2.width = c.a(paramContext, 50.0F);
    localLayoutParams2.height = localLayoutParams1.width;
    localLayoutParams2.setMargins(0, 0, 0, 0);
    localLayoutParams2.gravity = 16;
    this.v.setOnClickListener(this);
    localLinearLayout.addView(this.v, localLayoutParams2);
    return localLinearLayout;
  }
  
  private View d(Context paramContext)
  {
    LinearLayout.LayoutParams localLayoutParams1 = getDefaultLayoutParams1();
    localLayoutParams1.gravity = 16;
    LinearLayout localLinearLayout1 = new LinearLayout(paramContext);
    localLinearLayout1.setOrientation(0);
    localLinearLayout1.setBackgroundColor(Color.parseColor(b));
    LinearLayout localLinearLayout2 = new LinearLayout(paramContext);
    localLinearLayout2.setOrientation(1);
    LinearLayout.LayoutParams localLayoutParams2 = getDefaultLayoutParams();
    localLayoutParams2.gravity = 17;
    this.f = new a(paramContext);
    this.f.setImageBitmap(com.pgyersdk.i.f.a(com.pgyersdk.i.f.a("iVBORw0KGgoAAAANSUhEUgAAADwAAAA8CAMAAAANIilAAAAAq1BMVEUAAAD////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////Nr6iZAAAAOHRSTlMAMlEu/fKAVlPa0GJbLBv69+uRXjs2BwPVzLmklXjdoZtybEQ+JRgRtnVpKSEN5sjEv7CNh3sBqutKTB8AAAHpSURBVEjH7VbZdqowFAUUEESRQWYUB+rQ1jq2+/+/7ILQhtV7APvQp7IfkpBkrzNyTrgOHf4W3nkrCtSZ4m9NrfdD7lTy+iihqzH/ONPZewC8+c0ShOEtVACow/fHuMMDkMgbtrGR58BMe4D6fIQYl0yGJ6mP4KWNKwDmK3XwNMdk3aIyIHx99E6Rk8/jwt0aMGziDmCM2JcHLLLJFrEvQgA/H0c0dwQxvS/2Ozcbj4WoBDiU52OOkxGQXFeBfV8sADNXN9lxn5KZbiJt+QLXYhECb2w7t5n5s09r7YiGW94++d+uMG5NsmmQuGYMMKnh9o4YN3NliDmXtljJp6VydWvlZsZPZYc4+0CSmwvArrM3d9wJVJa+4ZaNGwP9lJar33U2QanuYXn/MSS70V6JVEzFssnPYhnsC3hS7biey3LjTNq8xSUbW3PDOFDBkKDWxpflxjNCsoQEsHh5FyXS6j9fseQ2sSIFpDpKfDjfc+MTr/qMozG6RMtVL7XP2FaKcJEbJUK01sEz1l+iJgZf9ZzPtUFgIV9VyyGPybiVfGVeqVo/1bFu7xiGQcXSYpW1UesFUbdD6GuuHTtYVMfYvnAPIO0jGmwqTI31qnYIPgAljPMuGc+LLun+Yn+mXwZB/jLo0KHDD/APMKg3IQLxv2kAAAAASUVORK5CYII="), c.a(paramContext, 40.0F), c.a(paramContext, 40.0F)));
    this.f.setOnClickListener(this);
    localLinearLayout2.addView(this.f, localLayoutParams2);
    this.r = new ColorDrawable(Color.parseColor(this.A));
    LinearLayout.LayoutParams localLayoutParams3 = getDefaultLayoutParams();
    localLayoutParams3.setMargins(0, -c.a(paramContext, 10.0F), 0, 0);
    localLayoutParams3.gravity = 1;
    localLayoutParams3.height = c.a(paramContext, 4.0F);
    localLayoutParams3.width = c.a(paramContext, 20.0F);
    this.z = new ImageView(paramContext);
    this.z.setImageDrawable(this.r);
    this.z.setBackgroundColor(-1);
    this.z.setPadding(1, 1, 1, 1);
    localLinearLayout2.addView(this.z, localLayoutParams3);
    localLayoutParams3 = getDefaultLayoutParams1();
    localLayoutParams3.gravity = 16;
    localLinearLayout1.addView(localLinearLayout2, localLayoutParams3);
    localLinearLayout2 = new LinearLayout(paramContext);
    this.g = new a(paramContext);
    this.g.setImageBitmap(com.pgyersdk.i.f.a(com.pgyersdk.i.f.a(com.pgyersdk.b.a.m), c.a(paramContext, 40.0F), c.a(paramContext, 40.0F)));
    this.g.setOnClickListener(this);
    localLinearLayout2.addView(this.g, localLayoutParams2);
    localLinearLayout1.addView(localLinearLayout2, localLayoutParams1);
    localLinearLayout2 = new LinearLayout(paramContext);
    this.h = new a(paramContext);
    this.h.setImageBitmap(com.pgyersdk.i.f.a(com.pgyersdk.i.f.a("iVBORw0KGgoAAAANSUhEUgAAADwAAAA8CAMAAAANIilAAAAAq1BMVEUAAAD////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////Nr6iZAAAAOHRSTlMAY1IE3JsX+uzo18GRVk80Eb25qH5oYFouDQj1x7CsiHNDJRry4tLNtqWgjEk9OCEcAe6FeW0pMjZ5GTkAAAF+SURBVEjH7ZXHkoJQEEVbJYNIUBFUkjln5/7/lw1VDkUpQ5i3mQ1n10UdoLr7vkcNDf+FPomY3c5OdFjdkQIMGN0QMNFiUmcW5LjHJnfn2Aiks8gGj3GXiNoM8mEB80xsch+4E73k7t/U5wTLHqVyaLiX+m4L0DppMUSCrGqtU60B+ZD0rPziN1OVQwIXzqrc/Ri+m+/9qGUBCNzSVQ6K19EYyJDKumfCFKgQLwRuVIgF9VwalBX44t++AQ8qw0JQ0rA5pgZlXDx6ZwW92BZsXNtZGSkcN/G1YZxO/oyxQcUMAc1LCwdzTkSCvIvSxzyVEKtQsvUckif0BlsZWL4GpeBUFYx+Kjs/vTzYwOpIRDoCKuW4gHr6jGTMv94pSVSOy0N0cnk+KJh2iEePKmhfYeeOIc/G5HJEvzIjwhrSM3cAasm3x+s9VfIA1E+Ztthw3J2qGS1/SZkJcaHVvG5yKXRlSFuqhdChTyKINjFjYc0ujxSf2HHa1NDQ0PDONzsAKUS0GwsiAAAAAElFTkSuQmCC"), c.a(paramContext, 40.0F), c.a(paramContext, 40.0F)));
    this.h.setOnClickListener(this);
    localLinearLayout2.addView(this.h, localLayoutParams2);
    localLinearLayout1.addView(localLinearLayout2, localLayoutParams1);
    return localLinearLayout1;
  }
  
  private FrameLayout.LayoutParams getDefaultFrameLayoutParams()
  {
    return new FrameLayout.LayoutParams(-1, -2);
  }
  
  private LinearLayout.LayoutParams getDefaultLayoutParams()
  {
    return new LinearLayout.LayoutParams(-1, -2);
  }
  
  private LinearLayout.LayoutParams getDefaultLayoutParams1()
  {
    return new LinearLayout.LayoutParams(-1, -2, 1.0F);
  }
  
  private RelativeLayout.LayoutParams getRelativeLayoutParams()
  {
    return new RelativeLayout.LayoutParams(-1, -2);
  }
  
  @TargetApi(11)
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    if (paramView.equals(this.f))
    {
      if (!this.y) {
        break label321;
      }
      if (this.m == null) {
        break label293;
      }
      this.m.start();
      if (this.y) {
        break label359;
      }
    }
    String str1;
    String str2;
    label293:
    label321:
    label359:
    for (boolean bool = true;; bool = false)
    {
      this.y = bool;
      if (paramView.equals(this.h)) {
        this.d.a();
      }
      if (paramView.equals(this.g))
      {
        i.setVisibility(0);
        com.pgyersdk.d.a.getInstance().showDialog(this.x, true);
      }
      if ((paramView.equals(this.u)) && ((this.x instanceof Activity)))
      {
        this.d.c();
        com.pgyersdk.d.a.getInstance().destroy();
        ((Activity)this.x).finish();
      }
      if (paramView.equals(this.v))
      {
        p = com.pgyersdk.i.d.a().a(this.x);
        com.pgyersdk.i.f.a(this.d.b(), p);
        str1 = i.a(getContext(), "selfmail");
        str2 = i.a(getContext(), "feedback_des");
        paramView = null;
        if (!k.a(i.a(getContext(), "voicefile"))) {
          paramView = new File(i.a(getContext(), "voicefile"));
        }
        if (!k.a(str1)) {
          break label372;
        }
        i.setVisibility(0);
        com.pgyersdk.d.a.getInstance().showDialog(this.x, true);
        paramView = Toast.makeText(getContext(), com.pgyersdk.b.b.a(1063), 0);
        if ((paramView instanceof Toast)) {
          break label364;
        }
        paramView.show();
      }
      return;
      if (this.o == null) {
        break;
      }
      this.e.setAnimation(this.o);
      this.o.start();
      break;
      if (this.l != null)
      {
        this.l.start();
        break;
      }
      if (this.n == null) {
        break;
      }
      this.e.startAnimation(this.n);
      break;
    }
    label364:
    VdsAgent.showToast((Toast)paramView);
    return;
    label372:
    if (!m.a(str1))
    {
      i.setVisibility(0);
      com.pgyersdk.d.a.getInstance().showDialog(this.x, true);
      paramView = Toast.makeText(getContext(), com.pgyersdk.b.b.a(1046), 0);
      if (!(paramView instanceof Toast))
      {
        paramView.show();
        return;
      }
      VdsAgent.showToast((Toast)paramView);
      return;
    }
    com.pgyersdk.d.a.getInstance().sendFeedback(getContext(), str1, str2, paramView, p, Boolean.valueOf(true));
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/pgyersdk/views/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */