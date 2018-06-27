package com.ziroom.ziroomcustomer.signed;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.facebook.drawee.drawable.ScalingUtils.ScaleType;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.adapter.a;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.dialog.b;
import com.ziroom.ziroomcustomer.dialog.b.a;
import com.ziroom.ziroomcustomer.e.l;
import com.ziroom.ziroomcustomer.model.Contract;
import com.ziroom.ziroomcustomer.model.LeaseListEntity;
import com.ziroom.ziroomcustomer.model.ShareInfo;
import com.ziroom.ziroomcustomer.model.UserInfo;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.util.ah;
import com.ziroom.ziroomcustomer.util.h;
import com.ziroom.ziroomcustomer.widget.ScanImageActivity;
import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public class SharerInformationActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private static List<LeaseListEntity> T = new ArrayList();
  private View A;
  private ListView B;
  private a C;
  private boolean D = false;
  private String E = "";
  private String F = "";
  private String G = "";
  private ShareInfo H;
  private int I = -1;
  private k J;
  private String K;
  private ArrayList<String> L = new ArrayList(2);
  private Context M;
  private String N;
  private int O = -1;
  private String P;
  private int Q;
  private int R;
  private TextView S;
  private String U;
  private LinearLayout V;
  private AlertDialog W;
  private View X;
  private View.OnClickListener Y = new View.OnClickListener()
  {
    @Instrumented
    public void onClick(View paramAnonymousView)
    {
      VdsAgent.onClick(this, paramAnonymousView);
      SharerInformationActivity.k(SharerInformationActivity.this).dismiss();
      switch (paramAnonymousView.getId())
      {
      default: 
        return;
      case 2131692507: 
        SharerInformationActivity.this.takePhoto();
        return;
      }
      SharerInformationActivity.this.selectPhoto();
    }
  };
  private Handler Z = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      l locall = (l)paramAnonymousMessage.obj;
      switch (paramAnonymousMessage.what)
      {
      default: 
        return;
      case 69654: 
        if (locall.getSuccess().booleanValue())
        {
          SharerInformationActivity.a(SharerInformationActivity.this, (ShareInfo)locall.getObject());
          if (SharerInformationActivity.l(SharerInformationActivity.this) == null)
          {
            SharerInformationActivity.m(SharerInformationActivity.this).setText("");
            SharerInformationActivity.n(SharerInformationActivity.this).setText("");
            SharerInformationActivity.c(SharerInformationActivity.this).setText("");
            SharerInformationActivity.a(SharerInformationActivity.this).setText("请输入");
            SharerInformationActivity.a(SharerInformationActivity.this).setTextColor(Color.rgb(222, 217, 211));
            SharerInformationActivity.o(SharerInformationActivity.this).setTextColor(Color.rgb(167, 161, 154));
            SharerInformationActivity.p(SharerInformationActivity.this).setTextColor(Color.rgb(167, 161, 154));
            SharerInformationActivity.q(SharerInformationActivity.this).setController(com.freelxl.baselibrary.f.c.frescoController(""));
            SharerInformationActivity.r(SharerInformationActivity.this).setController(com.freelxl.baselibrary.f.c.frescoController(""));
            SharerInformationActivity.c(SharerInformationActivity.this, "");
            SharerInformationActivity.d(SharerInformationActivity.this, "");
            return;
          }
          SharerInformationActivity.c(SharerInformationActivity.this, SharerInformationActivity.l(SharerInformationActivity.this).getJointRentSex().intValue());
          if (SharerInformationActivity.s(SharerInformationActivity.this) == 1)
          {
            SharerInformationActivity.o(SharerInformationActivity.this).setTextColor(Color.rgb(221, 102, 13));
            SharerInformationActivity.p(SharerInformationActivity.this).setTextColor(Color.rgb(167, 161, 154));
            SharerInformationActivity.m(SharerInformationActivity.this).setText(SharerInformationActivity.l(SharerInformationActivity.this).getJointRentName());
            SharerInformationActivity.n(SharerInformationActivity.this).setText(SharerInformationActivity.l(SharerInformationActivity.this).getJointRentPhone());
            paramAnonymousMessage = SharerInformationActivity.l(SharerInformationActivity.this).getJointRentCertNum().toString();
            SharerInformationActivity.c(SharerInformationActivity.this).setText(paramAnonymousMessage.replaceAll(" ", ""));
            if (SharerInformationActivity.l(SharerInformationActivity.this).getUserIsLock().intValue() != 0) {
              break label651;
            }
            VdsAgent.trackEditTextSilent(SharerInformationActivity.m(SharerInformationActivity.this)).toString();
            VdsAgent.trackEditTextSilent(SharerInformationActivity.n(SharerInformationActivity.this)).toString();
            VdsAgent.trackEditTextSilent(SharerInformationActivity.c(SharerInformationActivity.this)).toString();
            if (SharerInformationActivity.l(SharerInformationActivity.this).getCertIsLock().intValue() != 0) {
              break label720;
            }
            SharerInformationActivity.q(SharerInformationActivity.this).setController(com.freelxl.baselibrary.f.c.frescoController(SharerInformationActivity.l(SharerInformationActivity.this).getJointRentCertPic1()));
            SharerInformationActivity.r(SharerInformationActivity.this).setController(com.freelxl.baselibrary.f.c.frescoController(SharerInformationActivity.l(SharerInformationActivity.this).getJointRentCertPic2()));
            SharerInformationActivity.c(SharerInformationActivity.this, SharerInformationActivity.l(SharerInformationActivity.this).getJointRentCertPic1());
            SharerInformationActivity.d(SharerInformationActivity.this, SharerInformationActivity.l(SharerInformationActivity.this).getJointRentCertPic2());
            SharerInformationActivity.a(SharerInformationActivity.this, SharerInformationActivity.l(SharerInformationActivity.this).getJointRentCertType().intValue());
          }
        }
        for (;;)
        {
          SharerInformationActivity.this.dismissProgress();
          return;
          if (SharerInformationActivity.s(SharerInformationActivity.this) != 2) {
            break;
          }
          SharerInformationActivity.p(SharerInformationActivity.this).setTextColor(Color.rgb(221, 102, 13));
          SharerInformationActivity.o(SharerInformationActivity.this).setTextColor(Color.rgb(167, 161, 154));
          break;
          SharerInformationActivity.m(SharerInformationActivity.this).setEnabled(false);
          SharerInformationActivity.n(SharerInformationActivity.this).setEnabled(false);
          SharerInformationActivity.c(SharerInformationActivity.this).setEnabled(false);
          SharerInformationActivity.a(SharerInformationActivity.this).setEnabled(false);
          SharerInformationActivity.o(SharerInformationActivity.this).setEnabled(false);
          SharerInformationActivity.p(SharerInformationActivity.this).setEnabled(false);
          break label469;
          SharerInformationActivity.q(SharerInformationActivity.this).setController(com.freelxl.baselibrary.f.c.frescoController(SharerInformationActivity.l(SharerInformationActivity.this).getJointRentCertPic1()));
          SharerInformationActivity.r(SharerInformationActivity.this).setController(com.freelxl.baselibrary.f.c.frescoController(SharerInformationActivity.l(SharerInformationActivity.this).getJointRentCertPic2()));
          SharerInformationActivity.c(SharerInformationActivity.this, SharerInformationActivity.l(SharerInformationActivity.this).getJointRentCertPic1());
          SharerInformationActivity.d(SharerInformationActivity.this, SharerInformationActivity.l(SharerInformationActivity.this).getJointRentCertPic2());
          SharerInformationActivity.q(SharerInformationActivity.this).setEnabled(false);
          SharerInformationActivity.r(SharerInformationActivity.this).setEnabled(false);
          break label567;
          SharerInformationActivity.this.showToast(locall.getMessage());
          SharerInformationActivity.m(SharerInformationActivity.this).setText("");
          SharerInformationActivity.n(SharerInformationActivity.this).setText("");
          SharerInformationActivity.c(SharerInformationActivity.this).setText("");
          SharerInformationActivity.a(SharerInformationActivity.this).setText("请输入");
          SharerInformationActivity.a(SharerInformationActivity.this).setTextColor(Color.rgb(222, 217, 211));
          SharerInformationActivity.o(SharerInformationActivity.this).setTextColor(Color.rgb(167, 161, 154));
          SharerInformationActivity.p(SharerInformationActivity.this).setTextColor(Color.rgb(167, 161, 154));
          SharerInformationActivity.q(SharerInformationActivity.this).setController(com.freelxl.baselibrary.f.c.frescoController(""));
          SharerInformationActivity.r(SharerInformationActivity.this).setController(com.freelxl.baselibrary.f.c.frescoController(""));
          SharerInformationActivity.c(SharerInformationActivity.this, "");
          SharerInformationActivity.d(SharerInformationActivity.this, "");
        }
      case 69657: 
        if (locall.getSuccess().booleanValue())
        {
          SharerInformationActivity.this.finish();
          return;
        }
        SharerInformationActivity.this.showToast(locall.getMessage());
        return;
      case 4144: 
        SharerInformationActivity.this.dismissProgress();
        if (locall.getSuccess().booleanValue())
        {
          SharerInformationActivity.e(SharerInformationActivity.this, (String)locall.getObject());
          SharerInformationActivity.this.a(SharerInformationActivity.t(SharerInformationActivity.this), SharerInformationActivity.u(SharerInformationActivity.this));
          return;
        }
        SharerInformationActivity.this.showToast("图片上传失败！");
        return;
      case 4102: 
        label469:
        label567:
        label651:
        label720:
        if (locall.getSuccess().booleanValue())
        {
          SharerInformationActivity.a((List)locall.getObject());
          if ((SharerInformationActivity.a() != null) && (SharerInformationActivity.a().size() > 0))
          {
            SharerInformationActivity.v(SharerInformationActivity.this).setVisibility(0);
            SharerInformationActivity.b(SharerInformationActivity.this, ((LeaseListEntity)SharerInformationActivity.a().get(0)).getContractCode());
            com.ziroom.ziroomcustomer.e.d.getSharer(SharerInformationActivity.this, SharerInformationActivity.e(SharerInformationActivity.this), SharerInformationActivity.f(SharerInformationActivity.this));
            if (SharerInformationActivity.w(SharerInformationActivity.this) != null)
            {
              SharerInformationActivity.this.closeEmpty(SharerInformationActivity.w(SharerInformationActivity.this));
              SharerInformationActivity.a(SharerInformationActivity.this, null);
            }
          }
        }
        for (;;)
        {
          SharerInformationActivity.this.dismissProgress();
          return;
          SharerInformationActivity.v(SharerInformationActivity.this).setVisibility(8);
          SharerInformationActivity.this.showEmptyView("您暂时没有合同");
          continue;
          SharerInformationActivity.v(SharerInformationActivity.this).setVisibility(8);
          SharerInformationActivity.this.showToast(locall.getMessage());
          SharerInformationActivity.this.showEmptyView(locall.getMessage() + "");
        }
      }
      SharerInformationActivity.this.dismissProgress();
      if (locall.getSuccess().booleanValue())
      {
        SharerInformationActivity.this.finish();
        return;
      }
      SharerInformationActivity.this.showToast(locall.getMessage());
    }
  };
  public Activity a;
  boolean b = true;
  public UserInfo c;
  private EditText d;
  private EditText e;
  private EditText f;
  private TextView g;
  private TextView r;
  private TextView s;
  private TextView t;
  private ImageView u;
  private SimpleDraweeView v;
  private SimpleDraweeView w;
  private Button x;
  private PopupWindow y;
  private List<Contract> z;
  
  /* Error */
  private void a(Intent paramIntent)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_0
    //   4: new 158	java/lang/StringBuilder
    //   7: dup
    //   8: invokespecial 159	java/lang/StringBuilder:<init>	()V
    //   11: ldc -95
    //   13: getstatic 167	java/util/Locale:CHINA	Ljava/util/Locale;
    //   16: invokestatic 173	java/util/Calendar:getInstance	(Ljava/util/Locale;)Ljava/util/Calendar;
    //   19: invokestatic 179	android/text/format/DateFormat:format	(Ljava/lang/CharSequence;Ljava/util/Calendar;)Ljava/lang/CharSequence;
    //   22: invokevirtual 183	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   25: ldc -71
    //   27: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: invokevirtual 192	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   33: putfield 194	com/ziroom/ziroomcustomer/signed/SharerInformationActivity:K	Ljava/lang/String;
    //   36: aload_1
    //   37: invokevirtual 200	android/content/Intent:getData	()Landroid/net/Uri;
    //   40: astore_1
    //   41: aload_1
    //   42: ifnonnull +4 -> 46
    //   45: return
    //   46: aload_0
    //   47: invokevirtual 204	com/ziroom/ziroomcustomer/signed/SharerInformationActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   50: astore_3
    //   51: aload_3
    //   52: aload_1
    //   53: invokevirtual 210	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   56: astore_3
    //   57: aload_3
    //   58: astore_1
    //   59: aload_3
    //   60: invokestatic 216	com/ziroom/ziroomcustomer/util/h:getBytes	(Ljava/io/InputStream;)[B
    //   63: astore 5
    //   65: aload 5
    //   67: astore 4
    //   69: aload_3
    //   70: astore_1
    //   71: new 218	android/graphics/BitmapFactory$Options
    //   74: dup
    //   75: invokespecial 219	android/graphics/BitmapFactory$Options:<init>	()V
    //   78: astore 5
    //   80: aload_3
    //   81: astore_1
    //   82: aload 5
    //   84: iconst_1
    //   85: putfield 222	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   88: aload_3
    //   89: astore_1
    //   90: aload 4
    //   92: iconst_0
    //   93: aload 4
    //   95: arraylength
    //   96: aload 5
    //   98: invokestatic 228	android/graphics/BitmapFactory:decodeByteArray	([BIILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   101: pop
    //   102: aload_3
    //   103: astore_1
    //   104: aload 5
    //   106: getfield 231	android/graphics/BitmapFactory$Options:outWidth	I
    //   109: i2f
    //   110: aload 5
    //   112: getfield 234	android/graphics/BitmapFactory$Options:outHeight	I
    //   115: i2f
    //   116: invokestatic 238	com/ziroom/ziroomcustomer/util/h:setSimpleSize	(FF)I
    //   119: istore_2
    //   120: aload_3
    //   121: astore_1
    //   122: aload 5
    //   124: iconst_0
    //   125: putfield 222	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   128: aload_3
    //   129: astore_1
    //   130: aload 5
    //   132: iload_2
    //   133: putfield 241	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   136: aload_3
    //   137: astore_1
    //   138: aload 4
    //   140: iconst_0
    //   141: aload 4
    //   143: arraylength
    //   144: aload 5
    //   146: invokestatic 228	android/graphics/BitmapFactory:decodeByteArray	([BIILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   149: astore 4
    //   151: aload 4
    //   153: ifnull +52 -> 205
    //   156: aload_3
    //   157: astore_1
    //   158: aload 4
    //   160: sipush 300
    //   163: invokestatic 245	com/ziroom/ziroomcustomer/util/h:compImgBySize	(Landroid/graphics/Bitmap;I)Landroid/graphics/Bitmap;
    //   166: astore 5
    //   168: aload_3
    //   169: astore_1
    //   170: aload 5
    //   172: aload_0
    //   173: getfield 194	com/ziroom/ziroomcustomer/signed/SharerInformationActivity:K	Ljava/lang/String;
    //   176: bipush 100
    //   178: invokestatic 249	com/ziroom/ziroomcustomer/util/h:saveBitmap	(Landroid/graphics/Bitmap;Ljava/lang/String;I)V
    //   181: aload 4
    //   183: ifnull +10 -> 193
    //   186: aload_3
    //   187: astore_1
    //   188: aload 4
    //   190: invokevirtual 254	android/graphics/Bitmap:recycle	()V
    //   193: aload 5
    //   195: ifnull +10 -> 205
    //   198: aload_3
    //   199: astore_1
    //   200: aload 5
    //   202: invokevirtual 254	android/graphics/Bitmap:recycle	()V
    //   205: aload_3
    //   206: ifnull -161 -> 45
    //   209: aload_3
    //   210: invokevirtual 259	java/io/InputStream:close	()V
    //   213: return
    //   214: astore_1
    //   215: aload_1
    //   216: invokevirtual 262	java/io/IOException:printStackTrace	()V
    //   219: return
    //   220: astore 5
    //   222: aload_3
    //   223: astore_1
    //   224: aload 5
    //   226: invokevirtual 262	java/io/IOException:printStackTrace	()V
    //   229: goto -160 -> 69
    //   232: astore 4
    //   234: aload_3
    //   235: astore_1
    //   236: aload 4
    //   238: invokevirtual 263	java/io/FileNotFoundException:printStackTrace	()V
    //   241: aload_3
    //   242: ifnull -197 -> 45
    //   245: aload_3
    //   246: invokevirtual 259	java/io/InputStream:close	()V
    //   249: return
    //   250: astore_1
    //   251: aload_1
    //   252: invokevirtual 262	java/io/IOException:printStackTrace	()V
    //   255: return
    //   256: astore_3
    //   257: aconst_null
    //   258: astore_1
    //   259: aload_1
    //   260: ifnull +7 -> 267
    //   263: aload_1
    //   264: invokevirtual 259	java/io/InputStream:close	()V
    //   267: aload_3
    //   268: athrow
    //   269: astore_1
    //   270: aload_1
    //   271: invokevirtual 262	java/io/IOException:printStackTrace	()V
    //   274: goto -7 -> 267
    //   277: astore_3
    //   278: goto -19 -> 259
    //   281: astore 4
    //   283: aconst_null
    //   284: astore_3
    //   285: goto -51 -> 234
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	288	0	this	SharerInformationActivity
    //   0	288	1	paramIntent	Intent
    //   119	14	2	i	int
    //   50	196	3	localObject1	Object
    //   256	12	3	localObject2	Object
    //   277	1	3	localObject3	Object
    //   284	1	3	localObject4	Object
    //   1	188	4	localObject5	Object
    //   232	5	4	localFileNotFoundException1	java.io.FileNotFoundException
    //   281	1	4	localFileNotFoundException2	java.io.FileNotFoundException
    //   63	138	5	localObject6	Object
    //   220	5	5	localIOException	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   209	213	214	java/io/IOException
    //   59	65	220	java/io/IOException
    //   59	65	232	java/io/FileNotFoundException
    //   71	80	232	java/io/FileNotFoundException
    //   82	88	232	java/io/FileNotFoundException
    //   90	102	232	java/io/FileNotFoundException
    //   104	120	232	java/io/FileNotFoundException
    //   122	128	232	java/io/FileNotFoundException
    //   130	136	232	java/io/FileNotFoundException
    //   138	151	232	java/io/FileNotFoundException
    //   158	168	232	java/io/FileNotFoundException
    //   170	181	232	java/io/FileNotFoundException
    //   188	193	232	java/io/FileNotFoundException
    //   200	205	232	java/io/FileNotFoundException
    //   224	229	232	java/io/FileNotFoundException
    //   245	249	250	java/io/IOException
    //   51	57	256	finally
    //   263	267	269	java/io/IOException
    //   59	65	277	finally
    //   71	80	277	finally
    //   82	88	277	finally
    //   90	102	277	finally
    //   104	120	277	finally
    //   122	128	277	finally
    //   130	136	277	finally
    //   138	151	277	finally
    //   158	168	277	finally
    //   170	181	277	finally
    //   188	193	277	finally
    //   200	205	277	finally
    //   224	229	277	finally
    //   236	241	277	finally
    //   51	57	281	java/io/FileNotFoundException
  }
  
  private void a(final String paramString1, final String paramString2, final int paramInt1, final String paramString3, final int paramInt2, final String paramString4, final String paramString5, final String paramString6)
  {
    if (this.A == null) {
      this.A = LayoutInflater.from(this).inflate(2130903771, null);
    }
    Button localButton = (Button)this.A.findViewById(2131692249);
    ((Button)this.A.findViewById(2131690460)).setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        if (!ah.checkNet(SharerInformationActivity.h(SharerInformationActivity.this)))
        {
          SharerInformationActivity.this.showToast("请检查你的网络设置");
          return;
        }
        com.ziroom.ziroomcustomer.e.d.setSharer(SharerInformationActivity.this, SharerInformationActivity.e(SharerInformationActivity.this), paramString1, paramString2, paramInt1, paramString3, paramInt2, paramString4, paramString5, paramString6);
      }
    });
    localButton.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        SharerInformationActivity.i(SharerInformationActivity.this).dismiss();
        SharerInformationActivity.a(SharerInformationActivity.this, null);
      }
    });
    this.W = new AlertDialog.Builder(this).create();
    this.W.setOnDismissListener(new DialogInterface.OnDismissListener()
    {
      public void onDismiss(DialogInterface paramAnonymousDialogInterface)
      {
        SharerInformationActivity.i(SharerInformationActivity.this).dismiss();
        SharerInformationActivity.a(SharerInformationActivity.this, null);
        SharerInformationActivity.j(SharerInformationActivity.this).setEnabled(true);
      }
    });
    this.W.setView(this.A, 0, 0, 0, 0);
    if (!this.W.isShowing())
    {
      paramString1 = this.W;
      if (!(paramString1 instanceof AlertDialog)) {
        paramString1.show();
      }
    }
    else
    {
      return;
    }
    VdsAgent.showDialog((AlertDialog)paramString1);
  }
  
  private void b()
  {
    int i = 0;
    while (i < 2)
    {
      this.L.add("");
      i += 1;
    }
    new ArrayList();
    this.s.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        SharerInformationActivity.this.showContract(paramAnonymousView);
      }
    });
  }
  
  private void b(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      this.t.setText("身份证");
      this.t.setTextColor(Color.rgb(221, 102, 13));
      return;
    case 2: 
      this.t.setText("护照");
      this.t.setTextColor(Color.rgb(221, 102, 13));
      return;
    case 13: 
      this.t.setText("港澳居民来往通行证");
      this.t.setTextColor(Color.rgb(221, 102, 13));
      return;
    }
    this.t.setText("台湾居民来往通行证");
    this.t.setTextColor(Color.rgb(221, 102, 13));
  }
  
  private void c(int paramInt)
  {
    Intent localIntent = new Intent(this, ScanImageActivity.class);
    ArrayList localArrayList = new ArrayList();
    if (ae.notNull(this.F)) {
      localArrayList.add(this.F);
    }
    if (ae.notNull(this.G)) {
      localArrayList.add(this.G);
    }
    if ((localArrayList.size() == 2) && (paramInt != 0)) {
      localIntent.putExtra("position", paramInt - 1);
    }
    for (;;)
    {
      localIntent.putExtra("photos", localArrayList);
      startActivityForResult(localIntent, 2);
      return;
      localIntent.putExtra("position", paramInt);
    }
  }
  
  public static boolean checkNet(Context paramContext)
  {
    paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
    if (paramContext != null)
    {
      paramContext = paramContext.getActiveNetworkInfo();
      if ((paramContext != null) && (paramContext.isConnected()) && (paramContext.getState() == NetworkInfo.State.CONNECTED)) {
        return true;
      }
    }
    return false;
  }
  
  private void e()
  {
    this.V = ((LinearLayout)findViewById(2131692381));
    this.d = ((EditText)findViewById(2131692382));
    this.e = ((EditText)findViewById(2131692385));
    this.t = ((TextView)findViewById(2131692386));
    this.f = ((EditText)findViewById(2131692387));
    this.g = ((TextView)findViewById(2131692383));
    this.r = ((TextView)findViewById(2131692384));
    this.s = ((TextView)findViewById(2131690319));
    this.v = ((SimpleDraweeView)findViewById(2131692388));
    this.w = ((SimpleDraweeView)findViewById(2131692389));
    ((GenericDraweeHierarchy)this.w.getHierarchy()).setPlaceholderImage(2130838863);
    ((GenericDraweeHierarchy)this.v.getHierarchy()).setPlaceholderImage(2130838863);
    ((GenericDraweeHierarchy)this.w.getHierarchy()).setActualImageScaleType(ScalingUtils.ScaleType.FIT_XY);
    ((GenericDraweeHierarchy)this.v.getHierarchy()).setActualImageScaleType(ScalingUtils.ScaleType.FIT_XY);
    this.u = ((ImageView)findViewById(2131697532));
    this.x = ((Button)findViewById(2131692390));
    this.S = ((TextView)findViewById(2131692045));
    this.U = getIntent().getStringExtra("lease");
    String str = getIntent().getStringExtra("paycontract_code");
    if (ae.notNull(this.U)) {
      this.P = this.U;
    }
    while (this.U == null)
    {
      this.c = ((ApplicationEx)getApplication()).getUser();
      if (this.c != null)
      {
        showProgress("数据加载中");
        this.z = com.ziroom.ziroomcustomer.b.d.query(this, this.c.getUid());
        com.ziroom.ziroomcustomer.e.d.getLease(this, this.Z, "0", 0);
      }
      return;
      if (ae.notNull(str)) {
        this.P = str;
      }
    }
    this.s.setVisibility(8);
    com.ziroom.ziroomcustomer.e.d.getSharer(this, this.Z, this.U);
  }
  
  private void f()
  {
    this.v.setOnClickListener(this);
    this.w.setOnClickListener(this);
    this.x.setOnClickListener(this);
    this.u.setOnClickListener(this);
    this.t.setOnClickListener(this);
    this.g.setOnClickListener(this);
    this.r.setOnClickListener(this);
    this.S.setOnClickListener(this);
    this.f.addTextChangedListener(new TextWatcher()
    {
      private boolean b = true;
      private int c = -1;
      private int d = -1;
      
      public void afterTextChanged(Editable paramAnonymousEditable) {}
      
      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        this.c = paramAnonymousInt1;
      }
      
      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        paramAnonymousInt2 = paramAnonymousCharSequence.toString().length();
        String str = paramAnonymousCharSequence.toString();
        if ("身份证".equals(SharerInformationActivity.a(SharerInformationActivity.this).getText().toString())) {
          SharerInformationActivity.b(SharerInformationActivity.this);
        }
        paramAnonymousCharSequence = str;
        if (paramAnonymousInt2 > 21)
        {
          paramAnonymousCharSequence = str.substring(0, 21);
          SharerInformationActivity.c(SharerInformationActivity.this).setText(paramAnonymousCharSequence);
          SharerInformationActivity.c(SharerInformationActivity.this).setSelection(paramAnonymousInt1);
        }
        SharerInformationActivity.a(SharerInformationActivity.this, ah.formatIDCard(paramAnonymousCharSequence, " "));
        if (((ae.notNull(SharerInformationActivity.d(SharerInformationActivity.this))) && (paramAnonymousCharSequence.equals(SharerInformationActivity.d(SharerInformationActivity.this)))) || (ae.isNull(paramAnonymousCharSequence))) {
          return;
        }
        if (SharerInformationActivity.d(SharerInformationActivity.this).length() > paramAnonymousCharSequence.length()) {
          paramAnonymousInt2 = SharerInformationActivity.d(SharerInformationActivity.this).length() - paramAnonymousCharSequence.length() + paramAnonymousInt1 + 1;
        }
        for (;;)
        {
          SharerInformationActivity.c(SharerInformationActivity.this).setText(SharerInformationActivity.d(SharerInformationActivity.this));
          SharerInformationActivity.c(SharerInformationActivity.this).setSelection(paramAnonymousInt2);
          SharerInformationActivity.a(SharerInformationActivity.this, paramAnonymousCharSequence);
          return;
          if ((SharerInformationActivity.d(SharerInformationActivity.this).length() >= paramAnonymousCharSequence.length()) || (paramAnonymousCharSequence.length() > 21)) {
            break;
          }
          paramAnonymousInt2 = paramAnonymousInt1;
          if (paramAnonymousInt1 > SharerInformationActivity.d(SharerInformationActivity.this).length()) {
            paramAnonymousInt2 = SharerInformationActivity.d(SharerInformationActivity.this).length();
          }
        }
        if (paramAnonymousInt1 + paramAnonymousInt3 > SharerInformationActivity.d(SharerInformationActivity.this).length()) {
          paramAnonymousInt1 = SharerInformationActivity.d(SharerInformationActivity.this).length();
        }
        for (;;)
        {
          paramAnonymousInt2 = paramAnonymousInt1;
          break;
          paramAnonymousInt1 += paramAnonymousInt3;
        }
      }
    });
  }
  
  private void g()
  {
    String str = VdsAgent.trackEditTextSilent(this.f).toString();
    if (str.length() == 20)
    {
      if (Integer.parseInt(String.valueOf(str.charAt(19))) % 2 == 0)
      {
        this.r.setTextColor(Color.rgb(221, 102, 13));
        this.g.setTextColor(Color.rgb(167, 161, 154));
      }
    }
    else {
      return;
    }
    this.g.setTextColor(Color.rgb(221, 102, 13));
    this.r.setTextColor(Color.rgb(167, 161, 154));
  }
  
  private void h()
  {
    b localb = new b(this, 2131427591, 2);
    localb.setOnCerSelectListener(new b.a()
    {
      public void onCerSelectListener(int paramAnonymousInt)
      {
        SharerInformationActivity.a(SharerInformationActivity.this, paramAnonymousInt);
        SharerInformationActivity.b(SharerInformationActivity.this, paramAnonymousInt);
      }
    });
    localb.show();
  }
  
  private void i()
  {
    if (!checkNet(getApplicationContext()))
    {
      g.textToast(this, "网络请求失败，请检查您的网络设置", 1);
      return;
    }
    String str1 = this.t.getText().toString();
    if ("身份证".equals(str1)) {
      this.R = 1;
    }
    String str3;
    String str2;
    String str4;
    String str5;
    for (;;)
    {
      if ("护照".equals(str1)) {
        this.R = 2;
      }
      str3 = VdsAgent.trackEditTextSilent(this.d).toString();
      str2 = VdsAgent.trackEditTextSilent(this.e).toString();
      str1 = VdsAgent.trackEditTextSilent(this.f).toString().replaceAll(" ", "");
      str2 = str2.replaceAll(" ", "");
      str3 = str3.replaceAll(" ", "");
      str4 = this.F;
      str5 = this.G;
      if (!ae.isNull(str3)) {
        break;
      }
      showToast("请填写合租人姓名！");
      return;
      if ("港澳居民来往通行证".equals(str1)) {
        this.R = 13;
      } else if ("台湾居民来往通行证".equals(str1)) {
        this.R = 6;
      }
    }
    if (ae.isNull(str2))
    {
      showToast("请填写合租人手机号！");
      return;
    }
    if (!c.isNumeric(str2))
    {
      showToast("请填写合法的手机号码！");
      return;
    }
    if (ae.isNull(str1))
    {
      showToast("请填写证件号码！");
      return;
    }
    if (this.Q <= 0)
    {
      g.textToast(this.M, "请选择性别", 0);
      return;
    }
    a(this.P, str3, this.Q, str2, this.R, str1, str4, str5);
  }
  
  private void j()
  {
    this.J = new k(this, this.Y);
    k localk = this.J;
    View localView = findViewById(2131692380);
    if (!(localk instanceof PopupWindow))
    {
      localk.showAtLocation(localView, 81, 0, 0);
      return;
    }
    VdsAgent.showAtLocation((PopupWindow)localk, localView, 81, 0, 0);
  }
  
  protected void a(String paramString, int paramInt)
  {
    SimpleDraweeView localSimpleDraweeView = new SimpleDraweeView(this.M);
    if (paramInt == 1)
    {
      localSimpleDraweeView = this.v;
      this.F = paramString;
      this.L.set(0, paramString);
    }
    for (;;)
    {
      localSimpleDraweeView.setController(com.freelxl.baselibrary.f.c.frescoController(paramString));
      return;
      if (paramInt == 2)
      {
        localSimpleDraweeView = this.w;
        this.G = paramString;
        this.L.set(1, paramString);
      }
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 1) && (paramInt2 == -1)) {
      uploadPhoto();
    }
    for (;;)
    {
      return;
      if ((paramInt1 == 2) && (paramInt2 == -1) && (paramIntent != null))
      {
        a(paramIntent);
        uploadPhoto();
        return;
      }
      if (paramIntent != null)
      {
        paramIntent = (ArrayList)paramIntent.getSerializableExtra("pics");
        if (paramIntent != null)
        {
          paramIntent = paramIntent.iterator();
          while (paramIntent.hasNext())
          {
            String str = (String)paramIntent.next();
            if (this.F.equals(str))
            {
              this.F = "";
              this.v.setImageResource(2130837780);
            }
            if (this.G.equals(str))
            {
              this.G = "";
              this.w.setImageResource(2130837780);
            }
          }
        }
      }
    }
  }
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131692384: 
      this.r.setTextColor(Color.rgb(221, 102, 13));
      this.g.setTextColor(Color.rgb(167, 161, 154));
      this.Q = 2;
      return;
    case 2131692383: 
      this.g.setTextColor(Color.rgb(221, 102, 13));
      this.r.setTextColor(Color.rgb(167, 161, 154));
      this.Q = 1;
      return;
    case 2131697532: 
      finish();
      return;
    case 2131692390: 
      i();
      return;
    case 2131692388: 
      if (ae.isNull(this.F))
      {
        this.I = 1;
        j();
        return;
      }
      c(0);
      return;
    case 2131692389: 
      if (ae.isNull(this.G))
      {
        this.I = 2;
        j();
        return;
      }
      c(1);
      return;
    case 2131692386: 
      h();
      return;
    }
    showChoseShare();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903492);
    this.a = this;
    this.M = this;
    e();
    f();
    b();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
  }
  
  public void selectPhoto()
  {
    Intent localIntent = new Intent("android.intent.action.GET_CONTENT");
    localIntent.addCategory("android.intent.category.OPENABLE");
    localIntent.setType("image/*");
    startActivityForResult(Intent.createChooser(localIntent, "选择图片"), 2);
  }
  
  public void showChoseShare()
  {
    final AlertDialog localAlertDialog = new AlertDialog.Builder(this).create();
    View localView = getLayoutInflater().inflate(2130903650, null);
    TextView localTextView1 = (TextView)localView.findViewById(2131691289);
    TextView localTextView2 = (TextView)localView.findViewById(2131693121);
    localTextView1.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        com.ziroom.ziroomcustomer.e.d.setIsSharer(SharerInformationActivity.this, SharerInformationActivity.e(SharerInformationActivity.this), SharerInformationActivity.f(SharerInformationActivity.this), "2");
        SharerInformationActivity.this.showProgress("", 30000L);
      }
    });
    localTextView2.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        localAlertDialog.dismiss();
      }
    });
    localAlertDialog.setView(localView, 0, 0, 0, 0);
    if (!(localAlertDialog instanceof AlertDialog))
    {
      localAlertDialog.show();
      return;
    }
    VdsAgent.showDialog((AlertDialog)localAlertDialog);
  }
  
  public void showContract(View paramView)
  {
    paramView = View.inflate(this.a, 2130905074, null);
    this.y = new PopupWindow(paramView, 394, -2, true);
    this.y.setBackgroundDrawable(new ColorDrawable(0));
    this.y.setOutsideTouchable(true);
    this.y.setFocusable(true);
    this.y.setContentView(paramView);
    View localView = View.inflate(this.a, 2130905128, null);
    PopupWindow localPopupWindow = this.y;
    if (!(localPopupWindow instanceof PopupWindow)) {
      localPopupWindow.showAtLocation(localView, 53, 10, 240);
    }
    for (;;)
    {
      this.B = ((ListView)paramView.findViewById(2131691156));
      this.C = new a(this, T);
      this.B.setAdapter(this.C);
      this.B.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        @Instrumented
        public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          VdsAgent.onItemClick(this, paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
          if (SharerInformationActivity.a() != null)
          {
            SharerInformationActivity.b(SharerInformationActivity.this, ((LeaseListEntity)SharerInformationActivity.a().get(paramAnonymousInt)).getContractCode());
            com.ziroom.ziroomcustomer.e.d.getSharer(SharerInformationActivity.this, SharerInformationActivity.e(SharerInformationActivity.this), SharerInformationActivity.f(SharerInformationActivity.this));
            SharerInformationActivity.g(SharerInformationActivity.this).dismiss();
          }
        }
      });
      return;
      VdsAgent.showAtLocation((PopupWindow)localPopupWindow, localView, 53, 10, 240);
    }
  }
  
  public void showEmptyView(String paramString)
  {
    this.X = showEmptyView(this.V, paramString);
    this.X.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        SharerInformationActivity.this.showProgress("");
        com.ziroom.ziroomcustomer.e.d.getLease(SharerInformationActivity.h(SharerInformationActivity.this), SharerInformationActivity.e(SharerInformationActivity.this), "0", 0);
      }
    });
  }
  
  public void takePhoto()
  {
    Intent localIntent = new Intent("android.media.action.IMAGE_CAPTURE");
    this.K = (DateFormat.format("yyyyMMddhhmmss", Calendar.getInstance(Locale.CHINA)) + ".jpg");
    File localFile = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/images/");
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    localIntent.putExtra("output", Uri.fromFile(new File(localFile, this.K)));
    startActivityForResult(localIntent, 1);
  }
  
  public void uploadPhoto()
  {
    if (ae.isNull(this.K)) {
      return;
    }
    showProgress("图片上传中...");
    Bitmap localBitmap = h.tryGetBitmap(this.K, 1280, 200000);
    h.saveBitmap(localBitmap, this.K, 100);
    if ((localBitmap != null) && (!localBitmap.isRecycled())) {
      localBitmap.recycle();
    }
    com.ziroom.ziroomcustomer.e.d.uploadImage(this, this.Z, this.K, h.getBitmapByte(this.K));
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/signed/SharerInformationActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */