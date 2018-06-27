package com.ziroom.ziroomcustomer.newServiceList.utils.trans;

import android.animation.Animator.AnimatorListener;
import android.animation.TimeInterpolator;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import java.util.ArrayList;
import java.util.Iterator;

public class a
{
  private static void a(Activity paramActivity, ArrayList<EasyTransitionOptions.ViewAttrs> paramArrayList, long paramLong, TimeInterpolator paramTimeInterpolator)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      return;
    }
    Iterator localIterator = paramArrayList.iterator();
    while (localIterator.hasNext())
    {
      EasyTransitionOptions.ViewAttrs localViewAttrs = (EasyTransitionOptions.ViewAttrs)localIterator.next();
      View localView = paramActivity.findViewById(localViewAttrs.a);
      int[] arrayOfInt = new int[2];
      localView.getLocationOnScreen(arrayOfInt);
      localView.setPivotX(0.0F);
      localView.setPivotY(0.0F);
      localView.animate().scaleX(localViewAttrs.d / localView.getWidth()).scaleY(localViewAttrs.e / localView.getHeight()).translationX(localViewAttrs.b - arrayOfInt[0]).translationY(localViewAttrs.c - arrayOfInt[1]).setInterpolator(paramTimeInterpolator).setDuration(paramLong);
    }
    paramActivity.findViewById(((EasyTransitionOptions.ViewAttrs)paramArrayList.get(0)).a).postDelayed(new Runnable()
    {
      public void run()
      {
        this.a.finish();
        this.a.overridePendingTransition(0, 0);
      }
    }, paramLong);
  }
  
  private static void a(Activity paramActivity, ArrayList<EasyTransitionOptions.ViewAttrs> paramArrayList, final long paramLong, TimeInterpolator paramTimeInterpolator, final Animator.AnimatorListener paramAnimatorListener)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {}
    for (;;)
    {
      return;
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        final EasyTransitionOptions.ViewAttrs localViewAttrs = (EasyTransitionOptions.ViewAttrs)paramArrayList.next();
        View localView = paramActivity.findViewById(localViewAttrs.a);
        if (localView != null) {
          localView.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
          {
            public boolean onPreDraw()
            {
              this.a.getViewTreeObserver().removeOnPreDrawListener(this);
              int[] arrayOfInt = new int[2];
              this.a.getLocationOnScreen(arrayOfInt);
              this.a.setPivotX(0.0F);
              this.a.setPivotY(0.0F);
              this.a.setScaleX(localViewAttrs.d / this.a.getWidth());
              this.a.setScaleY(localViewAttrs.e / this.a.getHeight());
              this.a.setTranslationX(localViewAttrs.b - arrayOfInt[0]);
              this.a.setTranslationY(localViewAttrs.c - arrayOfInt[1]);
              Log.d("lsdjgkd222", "===== attr.startY" + localViewAttrs.c + "   location[0]=" + arrayOfInt[1]);
              this.a.animate().scaleX(1.0F).scaleY(1.0F).translationX(0.0F).translationY(0.0F).setDuration(paramLong).setInterpolator(paramAnimatorListener).setListener(this.e);
              return true;
            }
          });
        }
      }
    }
  }
  
  public static void enter(Activity paramActivity)
  {
    enter(paramActivity, 1000L, null, null);
  }
  
  public static void enter(Activity paramActivity, long paramLong, Animator.AnimatorListener paramAnimatorListener)
  {
    enter(paramActivity, paramLong, null, paramAnimatorListener);
  }
  
  public static void enter(Activity paramActivity, long paramLong, TimeInterpolator paramTimeInterpolator, Animator.AnimatorListener paramAnimatorListener)
  {
    a(paramActivity, paramActivity.getIntent().getParcelableArrayListExtra("easy_transition_options"), paramLong, paramTimeInterpolator, paramAnimatorListener);
  }
  
  public static void enter(Activity paramActivity, Animator.AnimatorListener paramAnimatorListener)
  {
    enter(paramActivity, 1000L, null, paramAnimatorListener);
  }
  
  public static void enter(Activity paramActivity, TimeInterpolator paramTimeInterpolator, Animator.AnimatorListener paramAnimatorListener)
  {
    enter(paramActivity, 1000L, paramTimeInterpolator, paramAnimatorListener);
  }
  
  public static void exit(Activity paramActivity)
  {
    exit(paramActivity, 1000L, null);
  }
  
  public static void exit(Activity paramActivity, long paramLong)
  {
    exit(paramActivity, paramLong, null);
  }
  
  public static void exit(Activity paramActivity, long paramLong, TimeInterpolator paramTimeInterpolator)
  {
    a(paramActivity, paramActivity.getIntent().getParcelableArrayListExtra("easy_transition_options"), paramLong, paramTimeInterpolator);
  }
  
  public static void exit(Activity paramActivity, TimeInterpolator paramTimeInterpolator)
  {
    exit(paramActivity, 1000L, paramTimeInterpolator);
  }
  
  public static void startActivity(Intent paramIntent, EasyTransitionOptions paramEasyTransitionOptions)
  {
    paramEasyTransitionOptions.update();
    paramIntent.putParcelableArrayListExtra("easy_transition_options", paramEasyTransitionOptions.getAttrs());
    Log.d("lsdjgkd111", "===== attr.startY" + ((EasyTransitionOptions.ViewAttrs)paramEasyTransitionOptions.getAttrs().get(0)).c);
    paramEasyTransitionOptions = paramEasyTransitionOptions.getActivity();
    paramEasyTransitionOptions.startActivity(paramIntent);
    paramEasyTransitionOptions.overridePendingTransition(0, 0);
  }
  
  public static void startActivityForResult(Intent paramIntent, int paramInt, EasyTransitionOptions paramEasyTransitionOptions)
  {
    paramEasyTransitionOptions.update();
    paramIntent.putParcelableArrayListExtra("easy_transition_options", paramEasyTransitionOptions.getAttrs());
    paramEasyTransitionOptions = paramEasyTransitionOptions.getActivity();
    paramEasyTransitionOptions.startActivityForResult(paramIntent, paramInt);
    paramEasyTransitionOptions.overridePendingTransition(0, 0);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newServiceList/utils/trans/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */