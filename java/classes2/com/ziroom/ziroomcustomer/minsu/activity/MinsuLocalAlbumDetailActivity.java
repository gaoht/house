package com.ziroom.ziroomcustomer.minsu.activity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.request.BasePostprocessor;
import com.freelxl.baselibrary.f.c;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.minsu.f.ad;
import com.ziroom.ziroomcustomer.minsu.view.CommonTitle;
import com.ziroom.ziroomcustomer.minsu.view.widget.AlbumViewPager;
import com.ziroom.ziroomcustomer.minsu.view.widget.a;
import com.ziroom.ziroomcustomer.minsu.view.widget.a.a;
import com.ziroom.ziroomcustomer.util.af;
import java.util.List;

public class MinsuLocalAlbumDetailActivity
  extends BaseActivity
  implements View.OnClickListener, CompoundButton.OnCheckedChangeListener
{
  int A;
  private ViewPager.OnPageChangeListener B = new ViewPager.OnPageChangeListener()
  {
    public void onPageScrollStateChanged(int paramAnonymousInt) {}
    
    public void onPageScrolled(int paramAnonymousInt1, float paramAnonymousFloat, int paramAnonymousInt2) {}
    
    public void onPageSelected(int paramAnonymousInt)
    {
      if (MinsuLocalAlbumDetailActivity.this.g.getAdapter() != null)
      {
        String str = paramAnonymousInt + 1 + "/" + MinsuLocalAlbumDetailActivity.this.g.getAdapter().getCount();
        MinsuLocalAlbumDetailActivity.this.s.setText(str);
        MinsuLocalAlbumDetailActivity.this.x.setTag(MinsuLocalAlbumDetailActivity.this.t.get(paramAnonymousInt));
        MinsuLocalAlbumDetailActivity.this.x.setChecked(MinsuLocalAlbumDetailActivity.this.z.contains(MinsuLocalAlbumDetailActivity.this.t.get(paramAnonymousInt)));
        return;
      }
      MinsuLocalAlbumDetailActivity.this.s.setText("0/0");
    }
  };
  private View.OnClickListener C = new View.OnClickListener()
  {
    @Instrumented
    public void onClick(View paramAnonymousView)
    {
      VdsAgent.onClick(this, paramAnonymousView);
      if (MinsuLocalAlbumDetailActivity.this.w.getVisibility() == 0)
      {
        paramAnonymousView = new AlphaAnimation(1.0F, 0.0F);
        paramAnonymousView.setDuration(300L);
        MinsuLocalAlbumDetailActivity.this.w.startAnimation(paramAnonymousView);
        MinsuLocalAlbumDetailActivity.this.w.setVisibility(8);
        return;
      }
      MinsuLocalAlbumDetailActivity.this.w.setVisibility(0);
      paramAnonymousView = new AlphaAnimation(0.0F, 1.0F);
      paramAnonymousView.setDuration(300L);
      MinsuLocalAlbumDetailActivity.this.w.startAnimation(paramAnonymousView);
    }
  };
  CommonTitle a;
  GridView b;
  View c;
  View d;
  TextView e;
  TextView f;
  AlbumViewPager g;
  String r;
  TextView s;
  List<a.a> t = null;
  ImageView u;
  ImageView v;
  View w;
  CheckBox x;
  a y = a.getInstance();
  List<a.a> z;
  
  private void a()
  {
    new Thread(new Runnable()
    {
      public void run()
      {
        MinsuLocalAlbumDetailActivity.this.y.initImage();
        final List localList = MinsuLocalAlbumDetailActivity.this.y.getFolder(MinsuLocalAlbumDetailActivity.this.r);
        MinsuLocalAlbumDetailActivity.this.runOnUiThread(new Runnable()
        {
          public void run()
          {
            if (localList != null)
            {
              MinsuLocalAlbumDetailActivity.this.z = MinsuLocalAlbumDetailActivity.this.y.getCheckedItems();
              MinsuLocalAlbumDetailActivity.this.t = localList;
              MinsuLocalAlbumDetailActivity.a locala = new MinsuLocalAlbumDetailActivity.a(MinsuLocalAlbumDetailActivity.this, MinsuLocalAlbumDetailActivity.this, localList);
              MinsuLocalAlbumDetailActivity.this.a.setMiddleText(MinsuLocalAlbumDetailActivity.this.r);
              MinsuLocalAlbumDetailActivity.this.b.setAdapter(locala);
              MinsuLocalAlbumDetailActivity.this.u.clearAnimation();
              ((View)MinsuLocalAlbumDetailActivity.this.u.getParent()).setVisibility(8);
              MinsuLocalAlbumDetailActivity.this.b.setVisibility(0);
              MinsuLocalAlbumDetailActivity.this.e.setVisibility(0);
              MinsuLocalAlbumDetailActivity.this.d.setVisibility(0);
              if (MinsuLocalAlbumDetailActivity.this.z.size() + a.getInstance().getCurrentSize() > 0)
              {
                MinsuLocalAlbumDetailActivity.this.e.setText("上传(" + (MinsuLocalAlbumDetailActivity.this.z.size() + a.getInstance().getCurrentSize()) + "/" + MinsuLocalAlbumDetailActivity.this.A + ")");
                MinsuLocalAlbumDetailActivity.this.e.setEnabled(true);
                MinsuLocalAlbumDetailActivity.this.f.setText("上传(" + (MinsuLocalAlbumDetailActivity.this.z.size() + a.getInstance().getCurrentSize()) + "/" + MinsuLocalAlbumDetailActivity.this.A + ")");
                MinsuLocalAlbumDetailActivity.this.f.setEnabled(true);
                MinsuLocalAlbumDetailActivity.this.e.setBackgroundResource(2130837929);
                MinsuLocalAlbumDetailActivity.this.f.setBackgroundColor(MinsuLocalAlbumDetailActivity.this.getResources().getColor(2131624475));
              }
            }
            else
            {
              return;
            }
            MinsuLocalAlbumDetailActivity.this.e.setText("上传(0/" + MinsuLocalAlbumDetailActivity.this.A + ")");
            MinsuLocalAlbumDetailActivity.this.e.setEnabled(false);
            MinsuLocalAlbumDetailActivity.this.e.setBackgroundResource(2130837928);
            MinsuLocalAlbumDetailActivity.this.f.setText("上传(0/" + MinsuLocalAlbumDetailActivity.this.A + ")");
            MinsuLocalAlbumDetailActivity.this.f.setEnabled(false);
            MinsuLocalAlbumDetailActivity.this.f.setBackgroundColor(Color.parseColor("#dddddd"));
          }
        });
      }
    }).start();
  }
  
  private void a(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    a.a locala = (a.a)paramCompoundButton.getTag();
    if (!paramBoolean) {
      if (this.z.contains(paramCompoundButton.getTag())) {
        this.z.remove(paramCompoundButton.getTag());
      }
    }
    while (this.z.size() + a.getInstance().getCurrentSize() > 0)
    {
      this.e.setText("上传(" + (this.z.size() + a.getInstance().getCurrentSize()) + "/" + this.A + ")");
      this.e.setEnabled(true);
      this.f.setText("上传(" + (this.z.size() + a.getInstance().getCurrentSize()) + "/" + this.A + ")");
      this.f.setEnabled(true);
      this.e.setBackgroundResource(2130837929);
      this.f.setBackgroundColor(getResources().getColor(2131624475));
      return;
      if (!this.z.contains(paramCompoundButton.getTag()))
      {
        if (this.z.size() + a.getInstance().getCurrentSize() >= this.A)
        {
          af.showToast(this, "最多选择" + this.A + "张图片", 1);
          paramCompoundButton.setChecked(false);
          return;
        }
        ad.getRealFilePath2(ApplicationEx.c, Uri.parse(locala.getOriginalUri()));
        this.z.add((a.a)paramCompoundButton.getTag());
      }
    }
    this.e.setText("上传(0/" + this.A + ")");
    this.e.setEnabled(false);
    this.f.setText("上传(0/" + this.A + ")");
    this.f.setEnabled(false);
    this.e.setBackgroundResource(2130837928);
    this.f.setBackgroundColor(Color.parseColor("#dddddd"));
  }
  
  private void b()
  {
    this.a = ((CommonTitle)findViewById(2131691272));
    this.a.setLeftButtonType(-1);
    this.a.setMiddleText("所有图片");
    this.a.showRightText(true, "取消");
    this.a.showLeftText(true, "选择相册");
    this.a.setOnRightButtonClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        MinsuLocalAlbumDetailActivity.this.finish();
      }
    });
    this.a.setOnLeftButtonClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        paramAnonymousView = new Intent(MinsuLocalAlbumDetailActivity.this, MinsuLocalAlbumActivity.class);
        paramAnonymousView.putExtra("picMaxNum", MinsuLocalAlbumDetailActivity.this.A);
        MinsuLocalAlbumDetailActivity.this.startActivityForResult(paramAnonymousView, 4);
      }
    });
  }
  
  private void e()
  {
    this.c.setVisibility(8);
    this.b.setVisibility(0);
    this.e.setVisibility(0);
    this.d.setVisibility(0);
    AnimationSet localAnimationSet = new AnimationSet(true);
    Object localObject = new ScaleAnimation(1.0F, 0.9F, 1.0F, 0.9F, this.c.getWidth() / 2, this.c.getHeight() / 2);
    ((ScaleAnimation)localObject).setDuration(200L);
    localAnimationSet.addAnimation((Animation)localObject);
    localObject = new AlphaAnimation(1.0F, 0.0F);
    ((AlphaAnimation)localObject).setDuration(200L);
    localAnimationSet.addAnimation((Animation)localObject);
    this.c.startAnimation(localAnimationSet);
    ((BaseAdapter)this.b.getAdapter()).notifyDataSetChanged();
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    switch (paramInt1)
    {
    }
    do
    {
      return;
    } while (paramInt2 != -1);
    this.r = paramIntent.getExtras().getString("local_folder_name");
    a();
  }
  
  public void onBackPressed()
  {
    if (this.c.getVisibility() == 0)
    {
      e();
      return;
    }
    super.onBackPressed();
  }
  
  @Instrumented
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    VdsAgent.onCheckedChanged(this, paramCompoundButton, paramBoolean);
    a(paramCompoundButton, paramBoolean);
  }
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131692293: 
      e();
      return;
    case 2131692288: 
    case 2131692295: 
      a.getInstance().setResultOk(true);
      finish();
      return;
    }
    paramView = new Intent(this, MinsuLocalAlbumActivity.class);
    paramView.putExtra("picMaxNum", this.A);
    startActivity(paramView);
    finish();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130904912);
    if (!a.getInstance().isInited())
    {
      finish();
      return;
    }
    this.y.clear();
    this.A = getIntent().getIntExtra("picMaxNum", 8);
    b();
    this.d = findViewById(2131689578);
    this.e = ((TextView)findViewById(2131692288));
    this.f = ((TextView)findViewById(2131692295));
    this.b = ((GridView)findViewById(2131689486));
    this.g = ((AlbumViewPager)findViewById(2131692291));
    this.c = findViewById(2131692290);
    this.s = ((TextView)findViewById(2131692294));
    this.g.setOnPageChangeListener(this.B);
    this.g.setOnSingleTapListener(this.C);
    this.v = ((ImageView)findViewById(2131692293));
    this.w = findViewById(2131692292);
    this.x = ((CheckBox)findViewById(2131689720));
    this.u = ((ImageView)findViewById(2131692289));
    this.x.setOnCheckedChangeListener(this);
    this.v.setOnClickListener(this);
    this.e.setOnClickListener(this);
    this.f.setOnClickListener(this);
    this.r = getIntent().getExtras().getString("local_folder_name");
    a();
    a.getInstance().setResultOk(false);
  }
  
  public class a
    extends BaseAdapter
  {
    List<a.a> a;
    private Context c;
    
    public a(List<a.a> paramList)
    {
      this.c = paramList;
      List localList;
      this.a = localList;
    }
    
    public int getCount()
    {
      return this.a.size();
    }
    
    public a.a getItem(int paramInt)
    {
      return (a.a)this.a.get(paramInt);
    }
    
    public long getItemId(int paramInt)
    {
      return 0L;
    }
    
    public View getView(final int paramInt, View paramView, final ViewGroup paramViewGroup)
    {
      new a(null);
      if ((paramView == null) || (paramView.getTag() == null))
      {
        paramViewGroup = new a(null);
        paramView = MinsuLocalAlbumDetailActivity.this.getLayoutInflater().inflate(2130904933, null);
        paramViewGroup.a = ((SimpleDraweeView)paramView.findViewById(2131694826));
        paramViewGroup.b = ((CheckBox)paramView.findViewById(2131689720));
        paramViewGroup.b.setOnCheckedChangeListener(MinsuLocalAlbumDetailActivity.this);
        paramView.setTag(paramViewGroup);
      }
      for (;;)
      {
        a.a locala = (a.a)this.a.get(paramInt);
        paramViewGroup.a.setController(c.frescoController(locala.getThumbnailUri(), new BasePostprocessor()
        {
          public void process(Bitmap paramAnonymousBitmap)
          {
            MinsuLocalAlbumDetailActivity.this.runOnUiThread(new Runnable()
            {
              public void run()
              {
                MinsuLocalAlbumDetailActivity.a.1.this.a.a.getDrawable().setColorFilter(Color.argb(255, 238, 238, 238), PorterDuff.Mode.MULTIPLY);
              }
            });
          }
        }));
        paramViewGroup.a.setController(c.frescoController(locala.getThumbnailUri()));
        paramViewGroup.b.setTag(locala);
        paramViewGroup.b.setChecked(MinsuLocalAlbumDetailActivity.this.z.contains(locala));
        paramViewGroup.a.setTag(paramViewGroup.b);
        paramViewGroup.a.setOnClickListener(new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymousView)
          {
            VdsAgent.onClick(this, paramAnonymousView);
            a.a locala = (a.a)MinsuLocalAlbumDetailActivity.a.this.a.get(paramInt);
            if (MinsuLocalAlbumDetailActivity.this.z.contains(locala)) {
              MinsuLocalAlbumDetailActivity.this.z.remove(locala);
            }
            for (;;)
            {
              ((CheckBox)paramAnonymousView.getTag()).setChecked(MinsuLocalAlbumDetailActivity.this.z.contains(locala));
              return;
              if (MinsuLocalAlbumDetailActivity.this.z.size() + a.getInstance().getCurrentSize() < MinsuLocalAlbumDetailActivity.this.A)
              {
                ad.getRealFilePath2(ApplicationEx.c, Uri.parse(locala.getOriginalUri()));
                MinsuLocalAlbumDetailActivity.this.z.add(locala);
              }
              else
              {
                af.showToast(MinsuLocalAlbumDetailActivity.this, "最多选择" + MinsuLocalAlbumDetailActivity.this.A + "张图片", 1);
              }
            }
          }
        });
        return paramView;
        paramViewGroup = (a)paramView.getTag();
      }
    }
    
    private class a
    {
      SimpleDraweeView a;
      CheckBox b;
      
      private a() {}
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/activity/MinsuLocalAlbumDetailActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */