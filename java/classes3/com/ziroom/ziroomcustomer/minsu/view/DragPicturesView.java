package com.ziroom.ziroomcustomer.minsu.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.ScrollView;
import android.widget.TextView;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.commonlibrary.widget.gridpasswordview.c;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.minsu.activity.MinsuScanPhotoActivity;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuHousePicBean;
import com.ziroom.ziroomcustomer.minsu.view.widget.DragPictureImageView;
import com.ziroom.ziroomcustomer.minsu.view.widget.a;
import com.ziroom.ziroomcustomer.util.ac;
import com.ziroom.ziroomcustomer.util.af;
import com.ziroom.ziroomcustomer.util.n;
import com.ziroom.ziroomcustomer.util.u;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class DragPicturesView
  extends ScrollView
{
  private static float h = 1.2F;
  int a;
  int b;
  int c;
  private List<MinsuHousePicBean> d = new ArrayList();
  private List<String> e = new ArrayList();
  private int f = 0;
  private RelativeLayout g;
  private ImageView i;
  private WindowManager.LayoutParams j;
  private WindowManager k;
  private boolean l = false;
  private int m = -1;
  private int n;
  private int o;
  private View.OnLongClickListener p = new View.OnLongClickListener()
  {
    public boolean onLongClick(View paramAnonymousView)
    {
      if ((DragPicturesView.a(DragPicturesView.this) == 0) || (DragPicturesView.a(DragPicturesView.this) == 2)) {
        return false;
      }
      DragPicturesView.a(DragPicturesView.this, DragPicturesView.b(DragPicturesView.this).indexOf(paramAnonymousView));
      paramAnonymousView.destroyDrawingCache();
      paramAnonymousView.setDrawingCacheEnabled(true);
      paramAnonymousView = Bitmap.createBitmap(paramAnonymousView.getDrawingCache());
      DragPicturesView.c(DragPicturesView.this).gravity = 51;
      if (DragPicturesView.d(DragPicturesView.this) == 0) {
        DragPicturesView.a(0.3F);
      }
      for (;;)
      {
        DragPicturesView.c(DragPicturesView.this).width = ((int)(DragPicturesView.a() * paramAnonymousView.getWidth()));
        DragPicturesView.c(DragPicturesView.this).height = ((int)(DragPicturesView.a() * paramAnonymousView.getHeight()));
        DragPicturesView.c(DragPicturesView.this).x = (DragPicturesView.e(DragPicturesView.this) - DragPicturesView.c(DragPicturesView.this).width / 2);
        DragPicturesView.c(DragPicturesView.this).y = (DragPicturesView.f(DragPicturesView.this) - DragPicturesView.c(DragPicturesView.this).height / 2);
        DragPicturesView.c(DragPicturesView.this).flags = 408;
        DragPicturesView.c(DragPicturesView.this).format = -3;
        DragPicturesView.c(DragPicturesView.this).windowAnimations = 0;
        if (((Integer)DragPicturesView.g(DragPicturesView.this).getTag()).intValue() == 1)
        {
          DragPicturesView.h(DragPicturesView.this).removeView(DragPicturesView.g(DragPicturesView.this));
          DragPicturesView.g(DragPicturesView.this).setTag(Integer.valueOf(0));
        }
        DragPicturesView.g(DragPicturesView.this).setImageBitmap(paramAnonymousView);
        DragPicturesView.h(DragPicturesView.this).addView(DragPicturesView.g(DragPicturesView.this), DragPicturesView.c(DragPicturesView.this));
        DragPicturesView.g(DragPicturesView.this).setTag(Integer.valueOf(1));
        DragPicturesView.a(DragPicturesView.this, true);
        return true;
        DragPicturesView.a(1.2F);
      }
    }
  };
  private List<View> q = new ArrayList();
  private int r = 0;
  private a s;
  
  public DragPicturesView(Context paramContext)
  {
    super(paramContext);
    initView();
  }
  
  public DragPicturesView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    initView();
  }
  
  public DragPicturesView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    initView();
  }
  
  public DragPicturesView(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
    initView();
  }
  
  private int a(int paramInt1, int paramInt2)
  {
    Rect localRect = new Rect();
    int i1 = 0;
    while (i1 < this.q.size())
    {
      ((View)this.q.get(i1)).getHitRect(localRect);
      if (localRect.contains(paramInt1, paramInt2)) {
        return i1;
      }
      i1 += 1;
    }
    return -1;
  }
  
  private void b()
  {
    Object localObject = new TextView(getContext());
    ((TextView)localObject).setText("建议使用横图作为封面照片");
    ((TextView)localObject).setTextColor(Color.parseColor("#ababab"));
    ((TextView)localObject).setTextSize(15.0F);
    ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(-1, -2);
    ((TextView)localObject).setGravity(1);
    ((TextView)localObject).setLayoutParams(localLayoutParams);
    ((TextView)localObject).setY(this.g.getLayoutParams().height - this.a / 4);
    this.g.addView((View)localObject);
    localObject = new DisplayMetrics();
    ((Activity)getContext()).getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject);
    localLayoutParams = this.g.getLayoutParams();
    localLayoutParams.height = (((DisplayMetrics)localObject).heightPixels - getStatusBarHeight() - n.dip2px(getContext(), 43.0F));
    this.g.setLayoutParams(localLayoutParams);
  }
  
  private int getStatusBarHeight()
  {
    try
    {
      Class localClass = Class.forName("com.android.internal.R$dimen");
      Object localObject = localClass.newInstance();
      int i1 = Integer.parseInt(localClass.getField("status_bar_height").get(localObject).toString());
      i1 = getResources().getDimensionPixelSize(i1);
      return i1;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return 0;
  }
  
  public void AddView(View paramView)
  {
    this.q.add(paramView);
    int i1 = this.q.size() - 1;
    int i2 = i1 / 3;
    if (i1 % 3 > 0) {}
    for (i1 = 1;; i1 = 0)
    {
      paramView = this.g.getLayoutParams();
      paramView.height = ((i1 + i2) * (this.a / 3) + this.a);
      this.g.setLayoutParams(paramView);
      return;
    }
  }
  
  public void RemoveAllViews()
  {
    this.q.clear();
    this.g.removeAllViews();
  }
  
  public DragPictureImageView getDefaultView()
  {
    if ((this.q != null) && (this.q.size() > 0)) {
      return (DragPictureImageView)((View)this.q.get(0)).findViewById(2131695333);
    }
    return null;
  }
  
  public List<String> getDelUrls()
  {
    return this.e;
  }
  
  public List<MinsuHousePicBean> getDelViews()
  {
    return this.d;
  }
  
  public void initView()
  {
    super.setVerticalScrollBarEnabled(false);
    this.a = ac.getScreenWidth(getContext());
    this.b = ac.getScreenHeight(getContext());
    this.c = c.dp2px(getContext(), 15);
    this.i = new ImageView(getContext());
    this.i.setTag(Integer.valueOf(0));
    this.j = new WindowManager.LayoutParams();
    this.k = ((WindowManager)getContext().getSystemService("window"));
    this.g = new RelativeLayout(getContext());
    Object localObject = new RelativeLayout.LayoutParams(ac.getScreenWidth(getContext()), ac.getScreenWidth(getContext()) * 2);
    ((RelativeLayout.LayoutParams)localObject).addRule(13);
    this.g.setLayoutParams((ViewGroup.LayoutParams)localObject);
    addView(this.g);
    localObject = new DisplayMetrics();
    ((Activity)getContext()).getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((this.r == 0) || (this.r == 2)) {
      return super.onTouchEvent(paramMotionEvent);
    }
    if (paramMotionEvent.getAction() == 0)
    {
      this.n = ((int)paramMotionEvent.getRawX());
      this.o = ((int)paramMotionEvent.getRawY());
    }
    for (;;)
    {
      return super.onTouchEvent(paramMotionEvent);
      if ((paramMotionEvent.getAction() == 2) && (this.l))
      {
        this.j.x = ((int)(paramMotionEvent.getRawX() - this.i.getWidth() / 2));
        this.j.y = ((int)(paramMotionEvent.getRawY() - this.i.getHeight() / 2));
        this.k.updateViewLayout(this.i, this.j);
        int i1 = a((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY() + getScrollY());
        if ((i1 != -1) && (i1 != this.m) && (swapView(this.m, i1))) {
          this.m = i1;
        }
        if ((paramMotionEvent.getRawY() < getY() + 400.0F) || (paramMotionEvent.getRawY() > this.b - 200)) {
          smoothScrollBy(0, (int)(paramMotionEvent.getRawY() - this.o));
        }
        return true;
      }
      if ((paramMotionEvent.getAction() == 1) && (this.l))
      {
        if (((Integer)this.i.getTag()).intValue() == 1)
        {
          this.k.removeView(this.i);
          this.i.setTag(Integer.valueOf(0));
        }
        this.l = false;
      }
    }
  }
  
  public void redraw()
  {
    this.g.removeAllViews();
    int i1 = 0;
    if (i1 < this.q.size())
    {
      final View localView = (View)this.q.get(i1);
      this.g.addView(localView);
      localView.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          if (DragPicturesView.a(DragPicturesView.this) == 0)
          {
            paramAnonymousView = new ArrayList();
            localIntent = new Intent(DragPicturesView.this.getContext(), MinsuScanPhotoActivity.class);
            localBundle = new Bundle();
            paramAnonymousView.addAll(DragPicturesView.i(DragPicturesView.this).getPicUrls());
            str = localView.getTag(2131689523) + "";
            j = paramAnonymousView.indexOf(str);
            i = j;
            if (j == -1)
            {
              u.e("error", "curent url = " + str);
              u.e("error", "photos .size = " + paramAnonymousView.size());
              i = 0;
            }
            localBundle.putSerializable("photos", paramAnonymousView);
            localIntent.putExtra("position", i);
            localIntent.putExtra("mHouse_type", 0);
            localIntent.putExtra("type", 0);
            localIntent.putExtras(localBundle);
            DragPicturesView.this.getContext().startActivity(localIntent);
          }
          while ((DragPicturesView.a(DragPicturesView.this) == 0) || (DragPicturesView.a(DragPicturesView.this) == 2))
          {
            Intent localIntent;
            Bundle localBundle;
            String str;
            int j;
            return;
          }
          int i = DragPicturesView.b(DragPicturesView.this).indexOf(paramAnonymousView);
          DragPicturesView.this.swapView(i, 0);
        }
      });
      int i2 = this.a - this.c * 2;
      label111:
      ImageView localImageView;
      if (i1 == 0)
      {
        localView.getLayoutParams().width = i2;
        localView.getLayoutParams().height = (i2 * 2 / 3);
        localView.setX(this.c);
        localView.setY(this.c);
        localImageView = (ImageView)localView.findViewById(2131695334);
        if (this.r != 2) {
          break label299;
        }
        localImageView.setVisibility(0);
      }
      for (;;)
      {
        localImageView.setTag(localView);
        localImageView.setOnClickListener(new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymousView)
          {
            VdsAgent.onClick(this, paramAnonymousView);
            if (((DragPictureImageView)((ViewGroup)paramAnonymousView.getParent()).findViewById(2131695333)).getIsDefault() == 1)
            {
              g.textToast(ApplicationEx.c, "封面照片不允许删除,只允许更换");
              return;
            }
            if ((DragPicturesView.b(DragPicturesView.this).size() <= 1) && (DragPicturesView.j(DragPicturesView.this) == 40))
            {
              g.textToast(ApplicationEx.c, "最后一张照片不允许删除");
              return;
            }
            Object localObject = (DragPictureImageView)((ViewGroup)paramAnonymousView.getParent()).findViewById(2131695333);
            MinsuHousePicBean localMinsuHousePicBean = new MinsuHousePicBean();
            localMinsuHousePicBean.housePicFid = ((DragPictureImageView)localObject).getFid();
            localMinsuHousePicBean.picType = ((DragPictureImageView)localObject).getHousePicType();
            DragPicturesView.k(DragPicturesView.this).add(localMinsuHousePicBean);
            localObject = localView.getTag(2131689523) + "";
            DragPicturesView.l(DragPicturesView.this).add(localObject);
            ((View)paramAnonymousView.getTag()).clearAnimation();
            DragPicturesView.b(DragPicturesView.this).remove(paramAnonymousView.getTag());
            a.getInstance().getCheckedItems().remove(((View)paramAnonymousView.getTag()).getTag());
            int i = DragPicturesView.b(DragPicturesView.this).size() - 1;
            int j = i / 3;
            if (i % 3 > 0) {}
            for (i = 1;; i = 0)
            {
              paramAnonymousView = DragPicturesView.m(DragPicturesView.this).getLayoutParams();
              paramAnonymousView.height = ((i + j) * (DragPicturesView.this.a / 3) + DragPicturesView.this.a);
              DragPicturesView.m(DragPicturesView.this).setLayoutParams(paramAnonymousView);
              DragPicturesView.this.redraw();
              return;
            }
          }
        });
        localView.setOnLongClickListener(this.p);
        localView.setOnTouchListener(new View.OnTouchListener()
        {
          public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
          {
            if ((DragPicturesView.a(DragPicturesView.this) == 0) || (DragPicturesView.a(DragPicturesView.this) == 2)) {
              return false;
            }
            if (paramAnonymousMotionEvent.getAction() == 0)
            {
              DragPicturesView.b(DragPicturesView.this, (int)paramAnonymousMotionEvent.getRawX());
              DragPicturesView.c(DragPicturesView.this, (int)paramAnonymousMotionEvent.getRawY());
              System.gc();
            }
            while ((paramAnonymousMotionEvent.getAction() != 1) || (!DragPicturesView.n(DragPicturesView.this))) {
              return false;
            }
            if (((Integer)DragPicturesView.g(DragPicturesView.this).getTag()).intValue() == 1)
            {
              DragPicturesView.h(DragPicturesView.this).removeView(DragPicturesView.g(DragPicturesView.this));
              DragPicturesView.g(DragPicturesView.this).setTag(Integer.valueOf(0));
            }
            DragPicturesView.a(DragPicturesView.this, false);
            return true;
          }
        });
        i1 += 1;
        break;
        localView.getLayoutParams().width = ((this.a - this.c * 4) / 3);
        localView.getLayoutParams().height = ((this.a - this.c * 4) / 3);
        localView.setX(this.c + ((this.a - this.c * 4) / 3 + this.c) * ((i1 - 1) % 3));
        localView.setY((i1 - 1) / 3 * ((this.a - this.c * 4) / 3 + this.c) + this.a - i2 / 3);
        break label111;
        label299:
        localImageView.setVisibility(8);
      }
    }
    if (this.r == 1) {
      b();
    }
  }
  
  public void removeDelView()
  {
    if (this.d != null) {
      this.d.clear();
    }
    if (this.e != null) {
      this.e.clear();
    }
  }
  
  public void setEditType(int paramInt)
  {
    this.r = paramInt;
    redraw();
  }
  
  public void setGetUrls(a parama)
  {
    this.s = parama;
  }
  
  public void setHouseStatus(int paramInt)
  {
    this.f = paramInt;
  }
  
  public boolean swapView(int paramInt1, int paramInt2)
  {
    int i1;
    DragPictureImageView localDragPictureImageView;
    if ((paramInt1 != 0) || (paramInt2 != 0)) {
      if (paramInt1 == 0)
      {
        i1 = 0;
        localDragPictureImageView = null;
        if (i1 < ((ViewGroup)this.q.get(paramInt2)).getChildCount())
        {
          if (!(((ViewGroup)this.q.get(paramInt2)).getChildAt(i1) instanceof DragPictureImageView)) {
            break label359;
          }
          localDragPictureImageView = (DragPictureImageView)((ViewGroup)this.q.get(paramInt2)).getChildAt(i1);
        }
      }
    }
    label356:
    label359:
    for (;;)
    {
      i1 += 1;
      break;
      if ((localDragPictureImageView != null) && (localDragPictureImageView.getOriginWidth() / localDragPictureImageView.getOriginHeight() <= 1.0F))
      {
        af.showToast(getContext(), "封面照片必须为横图！");
        return false;
      }
      if (paramInt2 == 0)
      {
        i1 = 0;
        localDragPictureImageView = null;
        if (i1 < ((ViewGroup)this.q.get(paramInt1)).getChildCount())
        {
          if (!(((ViewGroup)this.q.get(paramInt1)).getChildAt(i1) instanceof DragPictureImageView)) {
            break label356;
          }
          localDragPictureImageView = (DragPictureImageView)((ViewGroup)this.q.get(paramInt1)).getChildAt(i1);
        }
      }
      for (;;)
      {
        i1 += 1;
        break;
        if ((localDragPictureImageView != null) && (localDragPictureImageView.getOriginWidth() / localDragPictureImageView.getOriginHeight() <= 1.0F))
        {
          af.showToast(getContext(), "封面照片必须为横图！");
          return false;
        }
        if (paramInt1 < paramInt2)
        {
          this.q.add(paramInt2 + 1, this.q.get(paramInt1));
          this.q.remove(paramInt1);
        }
        for (;;)
        {
          Log.e("test", paramInt1 + "-" + paramInt2);
          redraw();
          return true;
          if (paramInt1 > paramInt2)
          {
            this.q.add(paramInt2, this.q.get(paramInt1));
            this.q.remove(paramInt1 + 1);
          }
        }
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract List<String> getPicUrls();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/view/DragPicturesView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */