package com.ziroom.ziroomcustomer.ziroomstation;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.Window;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.freelxl.baselibrary.e.i.a;
import com.freelxl.baselibrary.e.k;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.model.UserInfo;
import com.ziroom.ziroomcustomer.newServiceList.activity.ServiceLoginActivity;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.util.af;
import com.ziroom.ziroomcustomer.util.n;
import com.ziroom.ziroomcustomer.util.u;
import com.ziroom.ziroomcustomer.util.w;
import com.ziroom.ziroomcustomer.ziroomstation.adapter.j;
import com.ziroom.ziroomcustomer.ziroomstation.b.c;
import com.ziroom.ziroomcustomer.ziroomstation.model.EvaluateMsg;
import com.ziroom.ziroomcustomer.ziroomstation.model.EvaluateMsg.QuestionsBean;
import com.ziroom.ziroomcustomer.ziroomstation.model.EvaluateResultModel;
import com.ziroom.ziroomcustomer.ziroomstation.model.GetEvaluateInfoModel;
import com.ziroom.ziroomcustomer.ziroomstation.model.GetEvaluateInfoModel.QuestionsBean;
import com.ziroom.ziroomcustomer.ziroomstation.model.GetEvaluateInfoModel.QuestionsBean.ChildrenBean;
import com.ziroom.ziroomcustomer.ziroomstation.model.GetEvaluateInfoModel.QuestionsBean.ChildrenBean.OptionsBean;
import com.ziroom.ziroomcustomer.ziroomstation.model.ImageItem;
import com.ziroom.ziroomcustomer.ziroomstation.model.UploadPicResultModel;
import com.ziroom.ziroomcustomer.ziroomstation.model.UploadPicResultModel.DataBean;
import com.ziroom.ziroomcustomer.ziroomstation.utils.i;
import com.ziroom.ziroomcustomer.ziroomstation.widget.FlowLayout;
import com.ziroom.ziroomcustomer.ziroomstation.widget.TagTextView;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Vector;

public class StationEvaluateActivity
  extends BaseActivity
  implements View.OnClickListener
{
  public static final String a = StationEvaluateActivity.class.getSimpleName();
  public static List<ImageItem> b = new ArrayList();
  private GetEvaluateInfoModel.QuestionsBean.ChildrenBean A;
  private GetEvaluateInfoModel.QuestionsBean.ChildrenBean B;
  private GetEvaluateInfoModel.QuestionsBean.ChildrenBean C;
  private GetEvaluateInfoModel.QuestionsBean.ChildrenBean D;
  private String E = "0718";
  private String F;
  private EvaluateMsg G;
  private String H = "";
  private EvaluateResultModel I;
  private List<String> J;
  private int K;
  private Vector<UploadPicResultModel> L;
  private boolean M = false;
  private String[] N;
  private boolean O = false;
  private boolean P = false;
  private boolean Q = false;
  private String R;
  private String S;
  private String T;
  private ImageView c;
  private GridView d;
  private com.ziroom.ziroomcustomer.ziroomstation.adapter.d e;
  private String f = "";
  private TextView g;
  private RelativeLayout r;
  private EditText s;
  private FlowLayout t;
  private Button u;
  private ListView v;
  private j w;
  private GetEvaluateInfoModel x;
  private List<GetEvaluateInfoModel.QuestionsBean.ChildrenBean> y;
  private GetEvaluateInfoModel.QuestionsBean.ChildrenBean z;
  
  private void a()
  {
    c.putEvaluatedSucc(this, com.ziroom.ziroomcustomer.ziroomstation.b.b.buildEvaluatedSucc(this, this.R), new e(), true);
  }
  
  private void a(Intent paramIntent)
  {
    paramIntent = (List)paramIntent.getSerializableExtra("image_list_selected");
    if (paramIntent != null)
    {
      b.removeAll(b);
      b.addAll(paramIntent);
    }
  }
  
  private void a(List<GetEvaluateInfoModel.QuestionsBean.ChildrenBean.OptionsBean> paramList)
  {
    if (!i.isLegal(paramList)) {}
    for (;;)
    {
      return;
      this.t.removeAllViews();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Object localObject = (GetEvaluateInfoModel.QuestionsBean.ChildrenBean.OptionsBean)paramList.next();
        if (!TextUtils.isEmpty(((GetEvaluateInfoModel.QuestionsBean.ChildrenBean.OptionsBean)localObject).desc))
        {
          TagTextView localTagTextView = new TagTextView(this);
          localTagTextView.setTagBean((GetEvaluateInfoModel.QuestionsBean.ChildrenBean.OptionsBean)localObject);
          localTagTextView.setGravity(16);
          localTagTextView.setTag(Integer.valueOf(2));
          localTagTextView.setTextAppearance(this, 2131427972);
          localTagTextView.setBackgroundResource(2130839576);
          localObject = new ViewGroup.MarginLayoutParams(-2, n.dip2px(this, 18.0F));
          int i = n.dip2px(this, 6.0F);
          ((ViewGroup.MarginLayoutParams)localObject).setMargins(i, i, i, i);
          localTagTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
          i = n.dip2px(this, 5.0F);
          localTagTextView.setPadding(i, 0, i, 0);
          localTagTextView.setOnClickListener(new View.OnClickListener()
          {
            @Instrumented
            public void onClick(View paramAnonymousView)
            {
              VdsAgent.onClick(this, paramAnonymousView);
              if (((Integer)paramAnonymousView.getTag()).intValue() == 2)
              {
                paramAnonymousView.setTag(Integer.valueOf(1));
                ((TextView)paramAnonymousView).setTextAppearance(StationEvaluateActivity.this, 2131427971);
                paramAnonymousView.setBackgroundResource(2130839580);
              }
              for (;;)
              {
                StationEvaluateActivity.c(StationEvaluateActivity.this, true);
                return;
                if (((Integer)paramAnonymousView.getTag()).intValue() == 1)
                {
                  paramAnonymousView.setTag(Integer.valueOf(2));
                  ((TextView)paramAnonymousView).setTextAppearance(StationEvaluateActivity.this, 2131427972);
                  paramAnonymousView.setBackgroundResource(2130839576);
                }
              }
            }
          });
          this.t.addView(localTagTextView);
          this.t.requestLayout();
        }
      }
    }
  }
  
  private void b()
  {
    this.c = ((ImageView)findViewById(2131690549));
    this.c.setOnClickListener(this);
    this.v = ((ListView)findViewById(2131692517));
    this.w = new j(this.y, this, new b()
    {
      public void checked()
      {
        StationEvaluateActivity.a(StationEvaluateActivity.this, true);
      }
    });
    this.v.setAdapter(this.w);
    this.d = ((GridView)findViewById(2131689486));
    this.d.setSelector(new ColorDrawable(0));
    this.e = new com.ziroom.ziroomcustomer.ziroomstation.adapter.d(this, b);
    this.d.setAdapter(this.e);
    this.d.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      @Instrumented
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        VdsAgent.onItemClick(this, paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
        if (paramAnonymousInt == StationEvaluateActivity.k(StationEvaluateActivity.this))
        {
          StationEvaluateActivity.l(StationEvaluateActivity.this);
          new StationEvaluateActivity.a(StationEvaluateActivity.this, StationEvaluateActivity.this, StationEvaluateActivity.m(StationEvaluateActivity.this), StationEvaluateActivity.n(StationEvaluateActivity.this));
          return;
        }
        paramAnonymousAdapterView = new Intent(StationEvaluateActivity.this, ImageZoomActivity.class);
        paramAnonymousAdapterView.putExtra("image_list", (Serializable)StationEvaluateActivity.b);
        paramAnonymousAdapterView.putExtra("current_img_position", paramAnonymousInt);
        StationEvaluateActivity.this.startActivity(paramAnonymousAdapterView);
        StationEvaluateActivity.b(StationEvaluateActivity.this, true);
      }
    });
    this.g = ((TextView)findViewById(2131692504));
    this.r = ((RelativeLayout)findViewById(2131692515));
    this.s = ((EditText)findViewById(2131692505));
    this.t = ((FlowLayout)findViewById(2131692509));
    this.u = ((Button)findViewById(2131692516));
    this.u.setOnClickListener(this);
  }
  
  private static byte[] d(String paramString)
  {
    try
    {
      int i = com.ziroom.ziroomcustomer.ziroomstation.utils.takephoto.a.readPictureDegree(paramString);
      Bitmap localBitmap = com.ziroom.ziroomcustomer.ziroomstation.utils.takephoto.a.getCompressImage(paramString);
      Object localObject = localBitmap;
      if (Math.abs(i) > 0) {
        localObject = com.ziroom.ziroomcustomer.ziroomstation.utils.takephoto.a.rotaingImageView(i, localBitmap);
      }
      localObject = com.ziroom.ziroomcustomer.ziroomstation.utils.takephoto.a.Bitmap2Bytes((Bitmap)localObject);
      u.e("Http Station,图片压缩前byteSize:", Integer.valueOf(com.ziroom.ziroomcustomer.ziroomstation.utils.takephoto.a.fileToBype(new File(paramString)).length));
      u.e("Http Station,图片压缩后bytesSize:", Integer.valueOf(localObject.length));
      return (byte[])localObject;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  private int e()
  {
    if (b == null) {
      return 0;
    }
    return b.size();
  }
  
  private void f()
  {
    submitEvaluate();
  }
  
  private int g()
  {
    int i = 8 - b.size();
    if (i >= 0) {
      return i;
    }
    return 0;
  }
  
  private void h()
  {
    this.e.notifyDataSetChanged();
  }
  
  private void i()
  {
    ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 2);
  }
  
  private void j()
  {
    if (this.O) {
      w.onEventToZiroomAndUmeng("zinn_det_eva_tag");
    }
    if (this.P) {
      w.onEventToZiroomAndUmeng("zinn_det_eva_pic");
    }
    if ((this.s != null) && (!TextUtils.isEmpty(VdsAgent.trackEditTextSilent(this.s).toString().trim()))) {
      w.onEventToZiroomAndUmeng("zinn_det_eva_word");
    }
    if (this.Q) {
      w.onEventToZiroomAndUmeng("zinn_det_eva_star");
    }
  }
  
  public void dismissProgress()
  {
    if ((com.freelxl.baselibrary.widget.a.getDialog() != null) && (com.freelxl.baselibrary.widget.a.isShowing())) {
      com.freelxl.baselibrary.widget.a.dismiss();
    }
  }
  
  public void getEvaluateInfo()
  {
    if (b == null) {
      b = new ArrayList();
    }
    while (checkNet(this))
    {
      c.getEvaluateInfo(this, com.ziroom.ziroomcustomer.ziroomstation.b.b.buildGetEvaluateInfo(this.E, "zra", "zra", "app"), new c(), true);
      return;
      b.removeAll(b);
    }
    af.showToast(this, "网络不佳，请稍后再试");
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    switch (paramInt1)
    {
    }
    do
    {
      return;
    } while ((b.size() >= 8) || (paramInt2 != -1) || (TextUtils.isEmpty(this.f)));
    paramIntent = new ImageItem();
    paramIntent.sourcePath = this.f;
    b.add(paramIntent);
  }
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    switch (paramView.getId())
    {
    case 2131692504: 
    default: 
      return;
    case 2131690549: 
      finish();
      return;
    }
    w.onEventToZiroomAndUmeng("zinn_det_eva_submit");
    f();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    getWindow().setSoftInputMode(32);
    setContentView(2130903513);
    if (getIntent() != null)
    {
      this.S = getIntent().getStringExtra("dName");
      this.T = getIntent().getStringExtra("phone");
      this.R = getIntent().getStringExtra("orderBid");
      this.H = getIntent().getStringExtra("orderNumber");
      paramBundle = getIntent().getStringExtra("houseTypeNames");
      com.freelxl.baselibrary.f.d.e("StationEvaluateActivity", "dName:" + this.S + ";phone:" + this.T + ";orderBid:" + this.R + ";orderCode:" + this.H + ";houseTypeNames:" + paramBundle);
      if ((TextUtils.isEmpty(paramBundle)) || (!paramBundle.contains(","))) {
        break label243;
      }
    }
    for (;;)
    {
      try
      {
        this.N = paramBundle.split(",");
        this.E = getIntent().getStringExtra("projectBid");
        b();
        getEvaluateInfo();
        return;
      }
      catch (Exception localException)
      {
        this.N = new String[1];
        this.N[0] = paramBundle;
        continue;
      }
      label243:
      this.N = new String[1];
      this.N[0] = paramBundle;
    }
  }
  
  protected void onDestroy()
  {
    j();
    super.onDestroy();
  }
  
  @Instrumented
  protected void onNewIntent(Intent paramIntent)
  {
    VdsAgent.onNewIntent(this, paramIntent);
    super.onNewIntent(paramIntent);
    if ((!ae.isNull(paramIntent.getStringExtra("orderBid"))) && (!paramIntent.getStringExtra("orderBid").equals(this.H))) {
      this.H = paramIntent.getStringExtra("orderBid");
    }
    String str = getIntent().getStringExtra("houseTypeNames");
    com.freelxl.baselibrary.f.d.i("Http house", "获取houseTypeNames:" + str);
    if ((!TextUtils.isEmpty(str)) && (str.contains(","))) {}
    for (;;)
    {
      try
      {
        this.N = str.split(",");
        if ((!ae.isNull(paramIntent.getStringExtra("projectBid"))) && ((!paramIntent.getStringExtra("projectBid").equals(this.E)) || (this.F == null)))
        {
          this.E = paramIntent.getStringExtra("projectBid");
          getEvaluateInfo();
        }
        a(paramIntent);
        return;
      }
      catch (Exception localException)
      {
        this.N = new String[1];
        this.N[0] = str;
        continue;
      }
      this.N = new String[1];
      this.N[0] = str;
    }
  }
  
  protected void onResume()
  {
    a("zinn_eva_duration");
    super.onResume();
    h();
  }
  
  public void putEvaluateInfo()
  {
    this.G = new EvaluateMsg();
    if (!this.M) {
      if (ApplicationEx.c.getUser() == null) {}
    }
    for (this.G.requesterId = ApplicationEx.c.getUser().getUid(); (this.B == null) || (this.z == null) || (this.C == null) || (this.A == null); this.G.requesterId = "9c43cee6-1778-2cbd-e401-8247871067fd")
    {
      return;
      startActivity(new Intent(this, ServiceLoginActivity.class));
      return;
    }
    this.G.requesterType = "app";
    this.G.orderCode = this.H;
    this.G.ext = (this.S + this.T);
    this.G.questions = new ArrayList();
    Object localObject = new EvaluateMsg.QuestionsBean();
    ((EvaluateMsg.QuestionsBean)localObject).code = this.B.code;
    ((EvaluateMsg.QuestionsBean)localObject).content = VdsAgent.trackEditTextSilent(this.s).toString().trim();
    this.G.questions.add(localObject);
    int i;
    if (this.t != null)
    {
      i = 0;
      while (i < this.t.getChildCount())
      {
        localObject = (TagTextView)this.t.getChildAt(i);
        if (((Integer)((TagTextView)localObject).getTag()).intValue() == 1)
        {
          EvaluateMsg.QuestionsBean localQuestionsBean = new EvaluateMsg.QuestionsBean();
          localQuestionsBean.code = this.z.code;
          localQuestionsBean.optionCode = ((TagTextView)localObject).getTagBean().code;
          this.G.questions.add(localQuestionsBean);
        }
        i += 1;
      }
    }
    if ((this.y != null) && (this.y.size() > 0))
    {
      i = 0;
      while (i < this.y.size())
      {
        localObject = new EvaluateMsg.QuestionsBean();
        ((EvaluateMsg.QuestionsBean)localObject).code = ((GetEvaluateInfoModel.QuestionsBean.ChildrenBean)this.y.get(i)).code;
        ((EvaluateMsg.QuestionsBean)localObject).optionCode = ((GetEvaluateInfoModel.QuestionsBean.ChildrenBean)this.y.get(i)).curScoreCode;
        this.G.questions.add(localObject);
        i += 1;
      }
    }
    if ((this.J != null) && (this.J.size() > 0))
    {
      localObject = new EvaluateMsg.QuestionsBean();
      ((EvaluateMsg.QuestionsBean)localObject).code = this.C.code;
      i = 0;
      if (i < this.J.size())
      {
        if (i == 0) {}
        for (((EvaluateMsg.QuestionsBean)localObject).picUrl = ((String)this.J.get(0));; ((EvaluateMsg.QuestionsBean)localObject).picUrl = (((EvaluateMsg.QuestionsBean)localObject).picUrl + "," + (String)this.J.get(i)))
        {
          i += 1;
          break;
        }
      }
      this.G.questions.add(localObject);
    }
    com.freelxl.baselibrary.f.d.i("Http house", "开始填入房型");
    if ((this.N != null) && (this.N.length > 0))
    {
      com.freelxl.baselibrary.f.d.i("Http house", "确实开始填入房型");
      i = 0;
      if (i < this.N.length)
      {
        int j = 0;
        for (;;)
        {
          if (j < this.A.options.size())
          {
            if ((!TextUtils.isEmpty(this.N[i])) && (this.N[i].equals(((GetEvaluateInfoModel.QuestionsBean.ChildrenBean.OptionsBean)this.A.options.get(j)).desc)))
            {
              localObject = new EvaluateMsg.QuestionsBean();
              ((EvaluateMsg.QuestionsBean)localObject).code = this.A.code;
              ((EvaluateMsg.QuestionsBean)localObject).optionCode = ((GetEvaluateInfoModel.QuestionsBean.ChildrenBean.OptionsBean)this.A.options.get(j)).code;
              this.G.questions.add(localObject);
              com.freelxl.baselibrary.f.d.i("Http house", "确定填入房型:" + ((GetEvaluateInfoModel.QuestionsBean.ChildrenBean.OptionsBean)this.A.options.get(j)).desc);
            }
          }
          else
          {
            i += 1;
            break;
          }
          j += 1;
        }
      }
    }
    if (checkNet(this))
    {
      c.putEvaluateInfo(this, com.ziroom.ziroomcustomer.ziroomstation.b.b.buildPutEvaluateInfo(this.F, com.alibaba.fastjson.a.toJSONString(this.G)), new d(), true);
      return;
    }
    af.showToast(this, "网络不佳，请稍后再试");
  }
  
  public boolean showProgress(String paramString)
  {
    com.freelxl.baselibrary.widget.a.show(this, paramString, false, true);
    return true;
  }
  
  public void submitEvaluate()
  {
    if (this.L == null) {
      this.L = new Vector();
    }
    for (;;)
    {
      this.K = 0;
      if ((b == null) || (b.size() <= 0)) {
        break label178;
      }
      showProgress("图片上传");
      this.K = b.size();
      if (!checkNet(this)) {
        break;
      }
      int i = 0;
      while (i < b.size())
      {
        Map localMap = com.ziroom.ziroomcustomer.ziroomstation.b.b.buildUpdatePic(this, ((ImageItem)b.get(i)).sourcePath);
        c.uploadPic(this, d(((ImageItem)b.get(i)).sourcePath), localMap, ((ImageItem)b.get(i)).sourcePath, new f(), false);
        i += 1;
      }
      this.L.removeAll(this.L);
    }
    af.showToast(this, "网络不佳，请稍后再试");
    return;
    label178:
    putEvaluateInfo();
  }
  
  public void takePhoto()
  {
    Intent localIntent = new Intent("android.media.action.IMAGE_CAPTURE");
    File localFile = new File(Environment.getExternalStorageDirectory() + "/ziroom_station_images/", String.valueOf(System.currentTimeMillis()) + ".jpg");
    if (!localFile.exists()) {
      localFile.getParentFile().mkdirs();
    }
    for (;;)
    {
      this.f = localFile.getPath();
      localIntent.putExtra("output", Uri.fromFile(localFile));
      startActivityForResult(localIntent, 0);
      return;
      if (localFile.exists()) {
        localFile.delete();
      }
    }
  }
  
  public class a
    extends PopupWindow
  {
    public a(Context paramContext, View paramView, int paramInt)
    {
      Object localObject = View.inflate(paramContext, 2130904444, null);
      ((View)localObject).startAnimation(AnimationUtils.loadAnimation(paramContext, 2130968651));
      ((LinearLayout)((View)localObject).findViewById(2131695549)).startAnimation(AnimationUtils.loadAnimation(paramContext, 2130968674));
      setWidth(-1);
      setHeight(-1);
      setFocusable(true);
      setOutsideTouchable(true);
      setContentView((View)localObject);
      if (!(this instanceof PopupWindow)) {
        showAtLocation(paramView, 80, 0, 0);
      }
      for (;;)
      {
        update();
        ((TextView)((View)localObject).findViewById(2131695553)).setText("亲,您还可以上传" + paramInt + "张图片");
        paramContext = (Button)((View)localObject).findViewById(2131695554);
        paramView = (Button)((View)localObject).findViewById(2131695555);
        localObject = (Button)((View)localObject).findViewById(2131695552);
        paramContext.setOnClickListener(new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymousView)
          {
            VdsAgent.onClick(this, paramAnonymousView);
            StationEvaluateActivity.this.takePhoto();
            StationEvaluateActivity.a.this.dismiss();
          }
        });
        paramView.setOnClickListener(new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymousView)
          {
            VdsAgent.onClick(this, paramAnonymousView);
            paramAnonymousView = new Intent(StationEvaluateActivity.this, ImageBucketChooseActivity.class);
            paramAnonymousView.putExtra("can_add_image_size", StationEvaluateActivity.n(StationEvaluateActivity.this));
            paramAnonymousView.putExtra("orderBid", StationEvaluateActivity.o(StationEvaluateActivity.this));
            paramAnonymousView.putExtra("projectBid", StationEvaluateActivity.p(StationEvaluateActivity.this));
            paramAnonymousView.putExtra("image_list_selected", (Serializable)StationEvaluateActivity.b);
            com.freelxl.baselibrary.f.d.i(StationEvaluateActivity.a, "getAvailableSize:" + StationEvaluateActivity.n(StationEvaluateActivity.this));
            StationEvaluateActivity.this.startActivity(paramAnonymousView);
            StationEvaluateActivity.a.this.dismiss();
          }
        });
        ((Button)localObject).setOnClickListener(new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymousView)
          {
            VdsAgent.onClick(this, paramAnonymousView);
            StationEvaluateActivity.a.this.dismiss();
          }
        });
        return;
        VdsAgent.showAtLocation((PopupWindow)this, paramView, 80, 0, 0);
      }
    }
  }
  
  public static abstract interface b
  {
    public abstract void checked();
  }
  
  class c
    implements i.a<String>
  {
    c() {}
    
    public void onParse(String paramString, k paramk) {}
    
    public void onSuccess(k paramk)
    {
      if (paramk.getSuccess().booleanValue())
      {
        StationEvaluateActivity.a(StationEvaluateActivity.this, (GetEvaluateInfoModel)paramk.getObject());
        if (StationEvaluateActivity.a(StationEvaluateActivity.this) != null)
        {
          StationEvaluateActivity.a(StationEvaluateActivity.this, StationEvaluateActivity.a(StationEvaluateActivity.this).tokenId);
          if (StationEvaluateActivity.b(StationEvaluateActivity.this) == null)
          {
            StationEvaluateActivity.a(StationEvaluateActivity.this, new ArrayList());
            if ((StationEvaluateActivity.a(StationEvaluateActivity.this).questions != null) && (StationEvaluateActivity.a(StationEvaluateActivity.this).questions.size() > 0)) {
              paramk = ((GetEvaluateInfoModel.QuestionsBean)StationEvaluateActivity.a(StationEvaluateActivity.this).questions.get(0)).children.iterator();
            }
          }
          else
          {
            for (;;)
            {
              if (!paramk.hasNext()) {
                break label398;
              }
              GetEvaluateInfoModel.QuestionsBean.ChildrenBean localChildrenBean = (GetEvaluateInfoModel.QuestionsBean.ChildrenBean)paramk.next();
              if (localChildrenBean != null)
              {
                if ("7".equals(localChildrenBean.optionType))
                {
                  localChildrenBean.curScore = "5";
                  if ((localChildrenBean.options == null) || (localChildrenBean.options.size() <= 0) || (localChildrenBean.options.get(localChildrenBean.options.size() - 1) == null)) {
                    continue;
                  }
                  localChildrenBean.curScoreCode = ((GetEvaluateInfoModel.QuestionsBean.ChildrenBean.OptionsBean)localChildrenBean.options.get(localChildrenBean.options.size() - 1)).code;
                  StationEvaluateActivity.b(StationEvaluateActivity.this).add(localChildrenBean);
                  continue;
                  StationEvaluateActivity.b(StationEvaluateActivity.this).removeAll(StationEvaluateActivity.b(StationEvaluateActivity.this));
                  break;
                }
                if ("4".equals(localChildrenBean.optionType)) {
                  StationEvaluateActivity.a(StationEvaluateActivity.this, localChildrenBean);
                } else if ("6".equals(localChildrenBean.optionType)) {
                  StationEvaluateActivity.b(StationEvaluateActivity.this, localChildrenBean);
                } else if ("2".equals(localChildrenBean.optionType)) {
                  StationEvaluateActivity.c(StationEvaluateActivity.this, localChildrenBean);
                } else if ("5".equals(localChildrenBean.optionType)) {
                  StationEvaluateActivity.d(StationEvaluateActivity.this, localChildrenBean);
                } else {
                  StationEvaluateActivity.e(StationEvaluateActivity.this, localChildrenBean);
                }
              }
            }
          }
          label398:
          if (StationEvaluateActivity.b(StationEvaluateActivity.this).size() > 0) {
            StationEvaluateActivity.c(StationEvaluateActivity.this).setDatas(StationEvaluateActivity.b(StationEvaluateActivity.this));
          }
          if ((StationEvaluateActivity.d(StationEvaluateActivity.this) != null) && (StationEvaluateActivity.d(StationEvaluateActivity.this).options != null) && (StationEvaluateActivity.d(StationEvaluateActivity.this).options.size() > 0)) {
            StationEvaluateActivity.b(StationEvaluateActivity.this, StationEvaluateActivity.d(StationEvaluateActivity.this).options);
          }
        }
        return;
      }
      com.freelxl.baselibrary.f.d.i("HttpResult :", "ro failed:" + paramk.getMessage());
      af.showToast(StationEvaluateActivity.this, paramk.getMessage());
    }
  }
  
  class d
    implements i.a<String>
  {
    d() {}
    
    public void onParse(String paramString, k paramk) {}
    
    public void onSuccess(k paramk)
    {
      if (paramk.getSuccess().booleanValue())
      {
        StationEvaluateActivity.a(StationEvaluateActivity.this, (EvaluateResultModel)paramk.getObject());
        paramk = StationEvaluateActivity.e(StationEvaluateActivity.this).message;
        StationEvaluateActivity.b.removeAll(StationEvaluateActivity.b);
        StationEvaluateActivity.f(StationEvaluateActivity.this);
        StationEvaluateActivity.g(StationEvaluateActivity.this);
        return;
      }
      com.freelxl.baselibrary.f.d.i("HttpResult :", "ro failed:" + paramk.getMessage());
      paramk = paramk.getMessage();
      af.showToast(StationEvaluateActivity.this, paramk);
    }
  }
  
  class e
    implements i.a<String>
  {
    e() {}
    
    public void onParse(String paramString, k paramk) {}
    
    public void onSuccess(k paramk)
    {
      if (paramk.getSuccess().booleanValue())
      {
        paramk = (com.freelxl.baselibrary.b.b)paramk.getObject();
        if (200 == paramk.error_code)
        {
          StationEvaluateActivity.this.setResult(0, null);
          StationEvaluateActivity.this.finish();
          af.showToast(StationEvaluateActivity.this, StationEvaluateActivity.this.getResources().getString(2131297495));
          return;
        }
        af.showToast(StationEvaluateActivity.this, paramk.error_message);
        return;
      }
      af.showToast(StationEvaluateActivity.this, paramk.getMessage());
    }
  }
  
  class f
    implements i.a<String>
  {
    f() {}
    
    public void onParse(String paramString, k paramk) {}
    
    public void onSuccess(k paramk)
    {
      if (paramk.getSuccess().booleanValue())
      {
        paramk = (UploadPicResultModel)paramk.getObject();
        if (StationEvaluateActivity.h(StationEvaluateActivity.this) == null) {
          StationEvaluateActivity.a(StationEvaluateActivity.this, new Vector());
        }
        StationEvaluateActivity.h(StationEvaluateActivity.this).add(paramk);
        if (StationEvaluateActivity.h(StationEvaluateActivity.this).size() == StationEvaluateActivity.i(StationEvaluateActivity.this))
        {
          if (StationEvaluateActivity.j(StationEvaluateActivity.this) == null) {
            StationEvaluateActivity.c(StationEvaluateActivity.this, new ArrayList());
          }
          for (;;)
          {
            int i = 0;
            while (i < StationEvaluateActivity.i(StationEvaluateActivity.this))
            {
              StationEvaluateActivity.j(StationEvaluateActivity.this).add(((UploadPicResultModel)StationEvaluateActivity.h(StationEvaluateActivity.this).get(i)).data.imgUrl);
              i += 1;
            }
            StationEvaluateActivity.j(StationEvaluateActivity.this).removeAll(StationEvaluateActivity.j(StationEvaluateActivity.this));
          }
          StationEvaluateActivity.this.dismissProgress();
          StationEvaluateActivity.this.putEvaluateInfo();
        }
        return;
      }
      com.freelxl.baselibrary.f.d.i("HttpResult :", "ro failed:" + paramk.getMessage());
      af.showToast(StationEvaluateActivity.this, paramk.getMessage());
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes4-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomstation/StationEvaluateActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */