package com.ziroom.ziroomcustomer.sublet.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.f.c;
import com.freelxl.baselibrary.f.g;
import com.freelxl.baselibrary.widget.a;
import com.ziroom.threelib.ziroomshare.f;
import com.ziroom.threelib.ziroomshare.f.c;
import com.ziroom.ziroomcustomer.findhouse.presenter.model.RentHouseDetail;
import com.ziroom.ziroomcustomer.findhouse.presenter.model.RentHouseDetail.Ensure;
import com.ziroom.ziroomcustomer.findhouse.presenter.model.RentHouseDetail.Ensure.Detail;
import com.ziroom.ziroomcustomer.findhouse.presenter.model.RentHouseDetail.ResidentialInfo;
import com.ziroom.ziroomcustomer.findhouse.presenter.model.RentHouseDetail.Share;
import com.ziroom.ziroomcustomer.findhouse.presenter.model.RentHouseDetail.Space;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.util.n;
import com.ziroom.ziroomcustomer.util.z;
import com.ziroom.ziroomcustomer.widget.GradientTextView;
import com.ziroom.ziroomcustomer.widget.MyGridView;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LuxuryHouseShareView
  extends LinearLayout
{
  TextView a;
  GradientTextView b;
  TextView c;
  SimpleDraweeView d;
  TextView e;
  TextView f;
  TextView g;
  TextView h;
  TextView i;
  TextView j;
  SimpleDraweeView k;
  ImageView l;
  MyGridView m;
  MyGridView n;
  private Context o;
  private String p;
  private Bitmap q;
  private String r = "";
  private boolean s = false;
  private Handler t = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      super.handleMessage(paramAnonymousMessage);
      switch (paramAnonymousMessage.what)
      {
      default: 
      case 0: 
      case 1: 
        do
        {
          return;
          LuxuryHouseShareView.c(LuxuryHouseShareView.this);
          LuxuryHouseShareView.a(LuxuryHouseShareView.this, false);
          f.newBuilder(LuxuryHouseShareView.a(LuxuryHouseShareView.this)).setFlag(31).setShareTitle("").setShareUrl("").setShareContent("").setSharePicUrl("").setSharePicUrlLocal(LuxuryHouseShareView.d(LuxuryHouseShareView.this)).build().show();
          return;
          LuxuryHouseShareView.this.l.setImageBitmap(LuxuryHouseShareView.e(LuxuryHouseShareView.this));
        } while (LuxuryHouseShareView.e(LuxuryHouseShareView.this) == null);
        LuxuryHouseShareView.a(LuxuryHouseShareView.this, null);
        return;
      }
      LuxuryHouseShareView.a(LuxuryHouseShareView.this, false);
      g.textToast(LuxuryHouseShareView.a(LuxuryHouseShareView.this), "保存成功");
      LuxuryHouseShareView.c(LuxuryHouseShareView.this);
    }
  };
  
  public LuxuryHouseShareView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public LuxuryHouseShareView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public LuxuryHouseShareView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.o = paramContext;
    a();
  }
  
  private Bitmap a(Bitmap paramBitmap)
  {
    float f1 = paramBitmap.getWidth();
    float f2 = paramBitmap.getHeight();
    Matrix localMatrix = new Matrix();
    localMatrix.postScale(0.5F, 0.5F);
    return Bitmap.createBitmap(paramBitmap, 0, 0, (int)f1, (int)f2, localMatrix, true);
  }
  
  private void a()
  {
    LayoutInflater.from(this.o).inflate(2130904738, this, true);
    this.a = ((TextView)findViewById(2131690978));
    this.b = ((GradientTextView)findViewById(2131696275));
    this.c = ((TextView)findViewById(2131696276));
    this.d = ((SimpleDraweeView)findViewById(2131696277));
    this.e = ((TextView)findViewById(2131696278));
    this.f = ((TextView)findViewById(2131690979));
    this.g = ((TextView)findViewById(2131696097));
    this.h = ((TextView)findViewById(2131695093));
    this.j = ((TextView)findViewById(2131696280));
    this.i = ((TextView)findViewById(2131696068));
    this.k = ((SimpleDraweeView)findViewById(2131696279));
    this.l = ((ImageView)findViewById(2131696282));
    this.m = ((MyGridView)findViewById(2131689486));
    this.n = ((MyGridView)findViewById(2131696281));
  }
  
  private void b()
  {
    if ((a.getDialog() != null) && (a.isShowing())) {
      a.dismiss();
    }
  }
  
  public Bitmap getViewBitmap()
  {
    int i1 = this.o.getResources().getDisplayMetrics().widthPixels;
    int i2 = getHeight();
    Bitmap localBitmap = Bitmap.createBitmap(i1, i2, Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    localCanvas.drawColor(-1);
    layout(0, 0, i1, i2);
    draw(localCanvas);
    return a(localBitmap);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    getChildAt(0).layout(0, 0, getMeasuredWidth(), getMeasuredHeight());
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    measureChildren(paramInt1, paramInt2);
    setMeasuredDimension(this.o.getResources().getDisplayMetrics().widthPixels, getChildAt(0).getMeasuredHeight());
  }
  
  public void saveImage(Bitmap paramBitmap)
  {
    File localFile = new File(Environment.getExternalStorageDirectory(), "ziroom");
    if (!localFile.exists()) {
      localFile.mkdir();
    }
    localFile = new File(localFile, "ziroom_house_" + this.r + ".jpg");
    this.p = localFile.getPath();
    try
    {
      FileOutputStream localFileOutputStream = new FileOutputStream(localFile);
      if (localFileOutputStream != null)
      {
        paramBitmap.compress(Bitmap.CompressFormat.JPEG, 100, localFileOutputStream);
        localFileOutputStream.flush();
        localFileOutputStream.close();
      }
      paramBitmap = Uri.fromFile(localFile);
      this.o.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", paramBitmap));
      return;
    }
    catch (FileNotFoundException paramBitmap)
    {
      paramBitmap.printStackTrace();
      return;
    }
    catch (IOException paramBitmap)
    {
      paramBitmap.printStackTrace();
    }
  }
  
  public void setContent(final RentHouseDetail paramRentHouseDetail)
  {
    if (paramRentHouseDetail == null) {
      return;
    }
    this.r = paramRentHouseDetail.getHouse_code();
    this.a.setText(paramRentHouseDetail.getName());
    Object localObject2;
    final Object localObject1;
    if ((paramRentHouseDetail.getResblock() != null) && (paramRentHouseDetail.getResblock().getFacilities() != null) && (paramRentHouseDetail.getResblock().getFacilities().size() > 0))
    {
      localObject2 = paramRentHouseDetail.getResblock().getFacilities().iterator();
      String str;
      for (localObject1 = ""; ((Iterator)localObject2).hasNext(); localObject1 = (String)localObject1 + str + " · ") {
        str = (String)((Iterator)localObject2).next();
      }
      localObject1 = ((String)localObject1).substring(0, ((String)localObject1).length() - 3);
      this.b.setVisibility(0);
      this.b.setGradientColor(this.o.getResources().getColor(2131624414), this.o.getResources().getColor(2131624413));
      this.b.setText((CharSequence)localObject1);
      this.c.setText(paramRentHouseDetail.getSubway_primary());
      localObject2 = "";
      localObject1 = localObject2;
      if (paramRentHouseDetail != null)
      {
        localObject1 = localObject2;
        if (paramRentHouseDetail.getPhotos_big().size() > 0) {
          localObject1 = (String)paramRentHouseDetail.getPhotos_big().get(0);
        }
      }
      this.d.setController(c.frescoController((String)localObject1));
      this.f.setText(paramRentHouseDetail.getPrice());
      this.e.setText(paramRentHouseDetail.getPrice_unit());
      this.g.setText(paramRentHouseDetail.getPrice_desc());
      this.i.setText(paramRentHouseDetail.getIntroduction());
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(paramRentHouseDetail.getArea()).append("㎡").append(" | ").append(paramRentHouseDetail.getBedroom()).append("室").append(paramRentHouseDetail.getParlor()).append("厅").append(" | ").append(paramRentHouseDetail.getFloor()).append("/").append(paramRentHouseDetail.getFloor_total()).append("层").append(" | ").append("朝").append(paramRentHouseDetail.getFace());
      this.h.setText(((StringBuilder)localObject1).toString());
      localObject2 = "";
      localObject1 = localObject2;
      if (paramRentHouseDetail.getHx_photos_big() != null)
      {
        localObject1 = localObject2;
        if (paramRentHouseDetail.getHx_photos_big().size() > 0) {
          localObject1 = (String)paramRentHouseDetail.getHx_photos_big().get(0);
        }
      }
      this.k.setController(c.frescoController((String)localObject1));
      localObject1 = "m.ziroom.com";
      if (paramRentHouseDetail.getWechat_share() != null) {
        localObject1 = paramRentHouseDetail.getWechat_share().getUrl();
      }
      if ((paramRentHouseDetail.getSpace() == null) || (paramRentHouseDetail.getSpace().size() <= 0)) {
        break label629;
      }
      if (paramRentHouseDetail.getSpace().size() > 6) {
        break label613;
      }
      localObject2 = paramRentHouseDetail.getSpace();
      label510:
      localObject2 = new LuxuryImageAdapter(this.o, (List)localObject2);
      this.m.setAdapter((ListAdapter)localObject2);
    }
    for (;;)
    {
      if (paramRentHouseDetail.getEnsures() != null)
      {
        paramRentHouseDetail = paramRentHouseDetail.getEnsures();
        if (ae.notNull(paramRentHouseDetail.getTitle())) {
          this.j.setText(paramRentHouseDetail.getTitle());
        }
        this.n.setAdapter(new BaseAdapter()
        {
          public int getCount()
          {
            return paramRentHouseDetail.getDetailed().size();
          }
          
          public Object getItem(int paramAnonymousInt)
          {
            return paramRentHouseDetail.getDetailed().get(paramAnonymousInt);
          }
          
          public long getItemId(int paramAnonymousInt)
          {
            return paramAnonymousInt;
          }
          
          public View getView(int paramAnonymousInt, View paramAnonymousView, ViewGroup paramAnonymousViewGroup)
          {
            paramAnonymousView = (RentHouseDetail.Ensure.Detail)paramRentHouseDetail.getDetailed().get(paramAnonymousInt);
            paramAnonymousViewGroup = LayoutInflater.from(LuxuryHouseShareView.a(LuxuryHouseShareView.this)).inflate(2130904229, null);
            SimpleDraweeView localSimpleDraweeView = (SimpleDraweeView)paramAnonymousViewGroup.findViewById(2131695065);
            TextView localTextView1 = (TextView)paramAnonymousViewGroup.findViewById(2131695066);
            TextView localTextView2 = (TextView)paramAnonymousViewGroup.findViewById(2131695067);
            localSimpleDraweeView.setController(c.frescoController(paramAnonymousView.getIcon()));
            localTextView1.setText(paramAnonymousView.getTitle());
            localTextView2.setText(paramAnonymousView.getDesc());
            return paramAnonymousViewGroup;
          }
        });
      }
      new Thread(new Runnable()
      {
        public void run()
        {
          LuxuryHouseShareView.a(LuxuryHouseShareView.this, z.createQRImage(LuxuryHouseShareView.a(LuxuryHouseShareView.this), localObject1, null));
          LuxuryHouseShareView.b(LuxuryHouseShareView.this).sendEmptyMessage(1);
        }
      }).start();
      return;
      this.b.setVisibility(8);
      break;
      label613:
      localObject2 = paramRentHouseDetail.getSpace().subList(0, 6);
      break label510;
      label629:
      this.m.setVisibility(8);
    }
  }
  
  public void toSave()
  {
    if (this.s) {
      return;
    }
    this.s = true;
    new Thread(new Runnable()
    {
      public void run()
      {
        LuxuryHouseShareView.this.saveImage(this.a);
        LuxuryHouseShareView.b(LuxuryHouseShareView.this).sendEmptyMessage(2);
      }
    }).start();
  }
  
  public void toShare()
  {
    if (this.s) {
      return;
    }
    this.s = true;
    new Thread(new Runnable()
    {
      public void run()
      {
        LuxuryHouseShareView.this.saveImage(this.a);
        LuxuryHouseShareView.b(LuxuryHouseShareView.this).sendEmptyMessage(0);
      }
    }).start();
  }
  
  public class LuxuryImageAdapter
    extends BaseAdapter
  {
    private List<RentHouseDetail.Space> b = new ArrayList();
    private Context c;
    private int d;
    private int e;
    
    public LuxuryImageAdapter(List<RentHouseDetail.Space> paramList)
    {
      this.c = paramList;
      List localList;
      this.b = localList;
      this.e = ((((WindowManager)paramList.getSystemService("window")).getDefaultDisplay().getWidth() - n.dip2px(paramList, 48.0F)) / 2);
      this.d = (this.e * 3 / 4);
    }
    
    public int getCount()
    {
      if (this.b != null) {
        return this.b.size();
      }
      return 0;
    }
    
    public Object getItem(int paramInt)
    {
      return this.b.get(paramInt);
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    @SuppressLint({"ViewHolder"})
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      if (paramView != null)
      {
        ViewHolder localViewHolder = (ViewHolder)paramView.getTag();
        paramViewGroup = paramView;
        paramView = localViewHolder;
      }
      for (;;)
      {
        paramView.ivLuxuryShareImg.getLayoutParams().height = this.d;
        paramView.v_luxury_share_img_top.getLayoutParams().height = n.dip2px(this.c, 38.0F);
        paramView.ivLuxuryShareImg.getLayoutParams().width = this.e;
        paramView.v_luxury_share_img_top.getLayoutParams().width = this.e;
        paramView.ivLuxuryShareImg.setTag(((RentHouseDetail.Space)this.b.get(paramInt)).getPhotos_big());
        paramView.ivLuxuryShareImg.setController(c.frescoController((String)((RentHouseDetail.Space)this.b.get(paramInt)).getPhotos_min().get(0)));
        paramView.tvLuxuryImgDesc.setText(((RentHouseDetail.Space)this.b.get(paramInt)).getName());
        return paramViewGroup;
        paramViewGroup = View.inflate(this.c, 2130904283, null);
        paramView = new ViewHolder(paramViewGroup);
        paramViewGroup.setTag(paramView);
      }
    }
    
    class ViewHolder
    {
      @BindView(2131695211)
      SimpleDraweeView ivLuxuryShareImg;
      @BindView(2131695213)
      TextView tvLuxuryImgDesc;
      @BindView(2131695212)
      View v_luxury_share_img_top;
      
      ViewHolder(View paramView)
      {
        ButterKnife.bind(this, paramView);
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/sublet/widget/LuxuryHouseShareView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */