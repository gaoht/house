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
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.facebook.drawee.drawable.ScalingUtils.ScaleType;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.MainActivity;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.dialog.b;
import com.ziroom.ziroomcustomer.dialog.b.a;
import com.ziroom.ziroomcustomer.e.d;
import com.ziroom.ziroomcustomer.e.l;
import com.ziroom.ziroomcustomer.model.ShareInfo;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.util.ah;
import com.ziroom.ziroomcustomer.util.h;
import com.ziroom.ziroomcustomer.widget.ScanImageActivity;
import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Locale;

public class ShareInformationSecondActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private String A = "";
  private String B = "";
  private ShareInfo C;
  private int D = -1;
  private k E;
  private String F;
  private ArrayList<String> G = new ArrayList(2);
  private Context H;
  private String I;
  private int J = -1;
  private String K;
  private int L;
  private int M;
  private TextView N;
  private ImageView O;
  private Button P;
  private String Q;
  private String R;
  private TextView S;
  private AlertDialog T;
  private View.OnClickListener U = new View.OnClickListener()
  {
    @Instrumented
    public void onClick(View paramAnonymousView)
    {
      VdsAgent.onClick(this, paramAnonymousView);
      ShareInformationSecondActivity.j(ShareInformationSecondActivity.this).dismiss();
      switch (paramAnonymousView.getId())
      {
      default: 
        return;
      case 2131692507: 
        ShareInformationSecondActivity.this.takePhoto();
        return;
      }
      ShareInformationSecondActivity.this.selectPhoto();
    }
  };
  private Handler V = new Handler()
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
          ShareInformationSecondActivity.a(ShareInformationSecondActivity.this, (ShareInfo)locall.getObject());
          if (ShareInformationSecondActivity.k(ShareInformationSecondActivity.this) == null)
          {
            ShareInformationSecondActivity.l(ShareInformationSecondActivity.this).setText("");
            ShareInformationSecondActivity.m(ShareInformationSecondActivity.this).setText("");
            ShareInformationSecondActivity.c(ShareInformationSecondActivity.this).setText("");
            ShareInformationSecondActivity.a(ShareInformationSecondActivity.this).setText("请输入");
            ShareInformationSecondActivity.a(ShareInformationSecondActivity.this).setTextColor(Color.rgb(222, 217, 211));
            ShareInformationSecondActivity.n(ShareInformationSecondActivity.this).setTextColor(Color.rgb(167, 161, 154));
            ShareInformationSecondActivity.o(ShareInformationSecondActivity.this).setTextColor(Color.rgb(167, 161, 154));
            ShareInformationSecondActivity.p(ShareInformationSecondActivity.this).setController(com.freelxl.baselibrary.f.c.frescoController(""));
            ShareInformationSecondActivity.q(ShareInformationSecondActivity.this).setController(com.freelxl.baselibrary.f.c.frescoController(""));
            ShareInformationSecondActivity.b(ShareInformationSecondActivity.this, "");
            ShareInformationSecondActivity.c(ShareInformationSecondActivity.this, "");
            return;
          }
          ShareInformationSecondActivity.c(ShareInformationSecondActivity.this, ShareInformationSecondActivity.k(ShareInformationSecondActivity.this).getJointRentSex().intValue());
          if (ShareInformationSecondActivity.r(ShareInformationSecondActivity.this) == 1)
          {
            ShareInformationSecondActivity.n(ShareInformationSecondActivity.this).setTextColor(Color.rgb(221, 102, 13));
            ShareInformationSecondActivity.o(ShareInformationSecondActivity.this).setTextColor(Color.rgb(167, 161, 154));
            ShareInformationSecondActivity.l(ShareInformationSecondActivity.this).setText(ShareInformationSecondActivity.k(ShareInformationSecondActivity.this).getJointRentName());
            ShareInformationSecondActivity.m(ShareInformationSecondActivity.this).setText(ShareInformationSecondActivity.k(ShareInformationSecondActivity.this).getJointRentPhone());
            paramAnonymousMessage = ShareInformationSecondActivity.k(ShareInformationSecondActivity.this).getJointRentCertNum().toString();
            ShareInformationSecondActivity.c(ShareInformationSecondActivity.this).setText(paramAnonymousMessage.replaceAll(" ", ""));
            if (ShareInformationSecondActivity.k(ShareInformationSecondActivity.this).getUserIsLock().intValue() != 0) {
              break label643;
            }
            VdsAgent.trackEditTextSilent(ShareInformationSecondActivity.l(ShareInformationSecondActivity.this)).toString();
            VdsAgent.trackEditTextSilent(ShareInformationSecondActivity.m(ShareInformationSecondActivity.this)).toString();
            VdsAgent.trackEditTextSilent(ShareInformationSecondActivity.c(ShareInformationSecondActivity.this)).toString();
            if (ShareInformationSecondActivity.k(ShareInformationSecondActivity.this).getCertIsLock().intValue() != 0) {
              break label712;
            }
            ShareInformationSecondActivity.p(ShareInformationSecondActivity.this).setController(com.freelxl.baselibrary.f.c.frescoController(ShareInformationSecondActivity.k(ShareInformationSecondActivity.this).getJointRentCertPic1()));
            ShareInformationSecondActivity.q(ShareInformationSecondActivity.this).setController(com.freelxl.baselibrary.f.c.frescoController(ShareInformationSecondActivity.k(ShareInformationSecondActivity.this).getJointRentCertPic2()));
            ShareInformationSecondActivity.b(ShareInformationSecondActivity.this, ShareInformationSecondActivity.k(ShareInformationSecondActivity.this).getJointRentCertPic1());
            ShareInformationSecondActivity.c(ShareInformationSecondActivity.this, ShareInformationSecondActivity.k(ShareInformationSecondActivity.this).getJointRentCertPic2());
            ShareInformationSecondActivity.a(ShareInformationSecondActivity.this, ShareInformationSecondActivity.k(ShareInformationSecondActivity.this).getJointRentCertType().intValue());
          }
        }
        for (;;)
        {
          ShareInformationSecondActivity.this.dismissProgress();
          return;
          if (ShareInformationSecondActivity.r(ShareInformationSecondActivity.this) != 2) {
            break;
          }
          ShareInformationSecondActivity.o(ShareInformationSecondActivity.this).setTextColor(Color.rgb(221, 102, 13));
          ShareInformationSecondActivity.n(ShareInformationSecondActivity.this).setTextColor(Color.rgb(167, 161, 154));
          break;
          ShareInformationSecondActivity.l(ShareInformationSecondActivity.this).setEnabled(false);
          ShareInformationSecondActivity.m(ShareInformationSecondActivity.this).setEnabled(false);
          ShareInformationSecondActivity.c(ShareInformationSecondActivity.this).setEnabled(false);
          ShareInformationSecondActivity.a(ShareInformationSecondActivity.this).setEnabled(false);
          ShareInformationSecondActivity.n(ShareInformationSecondActivity.this).setEnabled(false);
          ShareInformationSecondActivity.o(ShareInformationSecondActivity.this).setEnabled(false);
          break label461;
          ShareInformationSecondActivity.p(ShareInformationSecondActivity.this).setController(com.freelxl.baselibrary.f.c.frescoController(ShareInformationSecondActivity.k(ShareInformationSecondActivity.this).getJointRentCertPic1()));
          ShareInformationSecondActivity.q(ShareInformationSecondActivity.this).setController(com.freelxl.baselibrary.f.c.frescoController(ShareInformationSecondActivity.k(ShareInformationSecondActivity.this).getJointRentCertPic2()));
          ShareInformationSecondActivity.b(ShareInformationSecondActivity.this, ShareInformationSecondActivity.k(ShareInformationSecondActivity.this).getJointRentCertPic1());
          ShareInformationSecondActivity.c(ShareInformationSecondActivity.this, ShareInformationSecondActivity.k(ShareInformationSecondActivity.this).getJointRentCertPic2());
          ShareInformationSecondActivity.p(ShareInformationSecondActivity.this).setEnabled(false);
          ShareInformationSecondActivity.q(ShareInformationSecondActivity.this).setEnabled(false);
          break label559;
          ShareInformationSecondActivity.this.showToast(locall.getMessage());
          ShareInformationSecondActivity.l(ShareInformationSecondActivity.this).setText("");
          ShareInformationSecondActivity.m(ShareInformationSecondActivity.this).setText("");
          ShareInformationSecondActivity.c(ShareInformationSecondActivity.this).setText("");
          ShareInformationSecondActivity.a(ShareInformationSecondActivity.this).setText("请输入");
          ShareInformationSecondActivity.a(ShareInformationSecondActivity.this).setTextColor(Color.rgb(222, 217, 211));
          ShareInformationSecondActivity.n(ShareInformationSecondActivity.this).setTextColor(Color.rgb(167, 161, 154));
          ShareInformationSecondActivity.o(ShareInformationSecondActivity.this).setTextColor(Color.rgb(167, 161, 154));
          ShareInformationSecondActivity.p(ShareInformationSecondActivity.this).setController(com.freelxl.baselibrary.f.c.frescoController(""));
          ShareInformationSecondActivity.q(ShareInformationSecondActivity.this).setController(com.freelxl.baselibrary.f.c.frescoController(""));
          ShareInformationSecondActivity.b(ShareInformationSecondActivity.this, "");
          ShareInformationSecondActivity.c(ShareInformationSecondActivity.this, "");
        }
      case 69657: 
        if (locall.getSuccess().booleanValue())
        {
          paramAnonymousMessage = ShareInformationSecondActivity.this.getIntent().getStringExtra("wystate");
          if (ae.notNull(ShareInformationSecondActivity.s(ShareInformationSecondActivity.this)))
          {
            paramAnonymousMessage = new Intent(ShareInformationSecondActivity.this, HandleWaitToDoneActivity.class);
            paramAnonymousMessage.putExtra("new_contract_code", ShareInformationSecondActivity.t(ShareInformationSecondActivity.this));
            paramAnonymousMessage.putExtra("old_contract_code", ShareInformationSecondActivity.s(ShareInformationSecondActivity.this));
            ShareInformationSecondActivity.this.startActivity(paramAnonymousMessage);
            ShareInformationSecondActivity.this.finish();
            return;
          }
          if ((paramAnonymousMessage != null) && (paramAnonymousMessage.equals("wystate")))
          {
            ShareInformationSecondActivity.u(ShareInformationSecondActivity.this).setVisibility(4);
            paramAnonymousMessage = new Intent(ShareInformationSecondActivity.this, HandleWaitToDoneActivity.class);
            paramAnonymousMessage.putExtra("wuyesure", "wuyesure");
            paramAnonymousMessage.putExtra("contract_part_code", ShareInformationSecondActivity.f(ShareInformationSecondActivity.this));
            ShareInformationSecondActivity.this.startActivity(paramAnonymousMessage);
            return;
          }
          paramAnonymousMessage = new Intent(ShareInformationSecondActivity.this, ZxingActivity.class);
          paramAnonymousMessage.putExtra("contract_part_code", ShareInformationSecondActivity.this.getIntent().getStringExtra("paycontract_code"));
          ShareInformationSecondActivity.this.startActivity(paramAnonymousMessage);
          return;
        }
        g.textToast(ShareInformationSecondActivity.g(ShareInformationSecondActivity.this), locall.getMessage(), 0);
        return;
      case 4144: 
        label461:
        label559:
        label643:
        label712:
        ShareInformationSecondActivity.this.dismissProgress();
        if (locall.getSuccess().booleanValue())
        {
          ShareInformationSecondActivity.d(ShareInformationSecondActivity.this, (String)locall.getObject());
          ShareInformationSecondActivity.this.a(ShareInformationSecondActivity.v(ShareInformationSecondActivity.this), ShareInformationSecondActivity.w(ShareInformationSecondActivity.this));
          return;
        }
        ShareInformationSecondActivity.this.showToast("图片上传失败！");
        return;
      }
      if (locall.getSuccess().booleanValue())
      {
        paramAnonymousMessage = ShareInformationSecondActivity.this.getIntent().getStringExtra("wystate");
        if (ae.notNull(ShareInformationSecondActivity.s(ShareInformationSecondActivity.this)))
        {
          paramAnonymousMessage = new Intent(ShareInformationSecondActivity.this, HandleWaitToDoneActivity.class);
          paramAnonymousMessage.putExtra("new_contract_code", ShareInformationSecondActivity.t(ShareInformationSecondActivity.this));
          paramAnonymousMessage.putExtra("old_contract_code", ShareInformationSecondActivity.s(ShareInformationSecondActivity.this));
          ShareInformationSecondActivity.this.startActivity(paramAnonymousMessage);
          ShareInformationSecondActivity.this.finish();
          return;
        }
        if ((paramAnonymousMessage != null) && (paramAnonymousMessage.equals("wystate")))
        {
          ShareInformationSecondActivity.u(ShareInformationSecondActivity.this).setVisibility(4);
          paramAnonymousMessage = new Intent(ShareInformationSecondActivity.this, HandleWaitToDoneActivity.class);
          paramAnonymousMessage.putExtra("wuyesure", "wuyesure");
          paramAnonymousMessage.putExtra("contract_part_code", ShareInformationSecondActivity.f(ShareInformationSecondActivity.this));
          ShareInformationSecondActivity.this.startActivity(paramAnonymousMessage);
          return;
        }
        paramAnonymousMessage = new Intent(ShareInformationSecondActivity.this, ZxingActivity.class);
        paramAnonymousMessage.putExtra("contract_part_code", ShareInformationSecondActivity.this.getIntent().getStringExtra("paycontract_code"));
        ShareInformationSecondActivity.this.startActivity(paramAnonymousMessage);
        return;
      }
      g.textToast(ShareInformationSecondActivity.g(ShareInformationSecondActivity.this), locall.getMessage(), 0);
    }
  };
  public Activity a;
  boolean b = true;
  private EditText c;
  private EditText d;
  private EditText e;
  private TextView f;
  private TextView g;
  private TextView r;
  private TextView s;
  private ImageView t;
  private SimpleDraweeView u;
  private SimpleDraweeView v;
  private Button w;
  private View x;
  private boolean y = false;
  private String z = "";
  
  private void a()
  {
    int i = 0;
    while (i < 2)
    {
      this.G.add("");
      i += 1;
    }
    new ArrayList();
    this.r.setVisibility(4);
  }
  
  /* Error */
  private void a(Intent paramIntent)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_0
    //   4: new 146	java/lang/StringBuilder
    //   7: dup
    //   8: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   11: ldc -107
    //   13: getstatic 155	java/util/Locale:CHINA	Ljava/util/Locale;
    //   16: invokestatic 161	java/util/Calendar:getInstance	(Ljava/util/Locale;)Ljava/util/Calendar;
    //   19: invokestatic 167	android/text/format/DateFormat:format	(Ljava/lang/CharSequence;Ljava/util/Calendar;)Ljava/lang/CharSequence;
    //   22: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   25: ldc -83
    //   27: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: invokevirtual 180	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   33: putfield 182	com/ziroom/ziroomcustomer/signed/ShareInformationSecondActivity:F	Ljava/lang/String;
    //   36: aload_1
    //   37: invokevirtual 188	android/content/Intent:getData	()Landroid/net/Uri;
    //   40: astore_1
    //   41: aload_1
    //   42: ifnonnull +4 -> 46
    //   45: return
    //   46: aload_0
    //   47: invokevirtual 192	com/ziroom/ziroomcustomer/signed/ShareInformationSecondActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   50: astore_3
    //   51: aload_3
    //   52: aload_1
    //   53: invokevirtual 198	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   56: astore_3
    //   57: aload_3
    //   58: astore_1
    //   59: aload_3
    //   60: invokestatic 204	com/ziroom/ziroomcustomer/util/h:getBytes	(Ljava/io/InputStream;)[B
    //   63: astore 5
    //   65: aload 5
    //   67: astore 4
    //   69: aload_3
    //   70: astore_1
    //   71: new 206	android/graphics/BitmapFactory$Options
    //   74: dup
    //   75: invokespecial 207	android/graphics/BitmapFactory$Options:<init>	()V
    //   78: astore 5
    //   80: aload_3
    //   81: astore_1
    //   82: aload 5
    //   84: iconst_1
    //   85: putfield 210	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   88: aload_3
    //   89: astore_1
    //   90: aload 4
    //   92: iconst_0
    //   93: aload 4
    //   95: arraylength
    //   96: aload 5
    //   98: invokestatic 216	android/graphics/BitmapFactory:decodeByteArray	([BIILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   101: pop
    //   102: aload_3
    //   103: astore_1
    //   104: aload 5
    //   106: getfield 219	android/graphics/BitmapFactory$Options:outWidth	I
    //   109: i2f
    //   110: aload 5
    //   112: getfield 222	android/graphics/BitmapFactory$Options:outHeight	I
    //   115: i2f
    //   116: invokestatic 226	com/ziroom/ziroomcustomer/util/h:setSimpleSize	(FF)I
    //   119: istore_2
    //   120: aload_3
    //   121: astore_1
    //   122: aload 5
    //   124: iconst_0
    //   125: putfield 210	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   128: aload_3
    //   129: astore_1
    //   130: aload 5
    //   132: iload_2
    //   133: putfield 229	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   136: aload_3
    //   137: astore_1
    //   138: aload 4
    //   140: iconst_0
    //   141: aload 4
    //   143: arraylength
    //   144: aload 5
    //   146: invokestatic 216	android/graphics/BitmapFactory:decodeByteArray	([BIILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   149: astore 4
    //   151: aload 4
    //   153: ifnull +52 -> 205
    //   156: aload_3
    //   157: astore_1
    //   158: aload 4
    //   160: sipush 300
    //   163: invokestatic 233	com/ziroom/ziroomcustomer/util/h:compImgBySize	(Landroid/graphics/Bitmap;I)Landroid/graphics/Bitmap;
    //   166: astore 5
    //   168: aload_3
    //   169: astore_1
    //   170: aload 5
    //   172: aload_0
    //   173: getfield 182	com/ziroom/ziroomcustomer/signed/ShareInformationSecondActivity:F	Ljava/lang/String;
    //   176: bipush 100
    //   178: invokestatic 237	com/ziroom/ziroomcustomer/util/h:saveBitmap	(Landroid/graphics/Bitmap;Ljava/lang/String;I)V
    //   181: aload 4
    //   183: ifnull +10 -> 193
    //   186: aload_3
    //   187: astore_1
    //   188: aload 4
    //   190: invokevirtual 242	android/graphics/Bitmap:recycle	()V
    //   193: aload 5
    //   195: ifnull +10 -> 205
    //   198: aload_3
    //   199: astore_1
    //   200: aload 5
    //   202: invokevirtual 242	android/graphics/Bitmap:recycle	()V
    //   205: aload_3
    //   206: ifnull -161 -> 45
    //   209: aload_3
    //   210: invokevirtual 247	java/io/InputStream:close	()V
    //   213: return
    //   214: astore_1
    //   215: aload_1
    //   216: invokevirtual 250	java/io/IOException:printStackTrace	()V
    //   219: return
    //   220: astore 5
    //   222: aload_3
    //   223: astore_1
    //   224: aload 5
    //   226: invokevirtual 250	java/io/IOException:printStackTrace	()V
    //   229: goto -160 -> 69
    //   232: astore 4
    //   234: aload_3
    //   235: astore_1
    //   236: aload 4
    //   238: invokevirtual 251	java/io/FileNotFoundException:printStackTrace	()V
    //   241: aload_3
    //   242: ifnull -197 -> 45
    //   245: aload_3
    //   246: invokevirtual 247	java/io/InputStream:close	()V
    //   249: return
    //   250: astore_1
    //   251: aload_1
    //   252: invokevirtual 250	java/io/IOException:printStackTrace	()V
    //   255: return
    //   256: astore_3
    //   257: aconst_null
    //   258: astore_1
    //   259: aload_1
    //   260: ifnull +7 -> 267
    //   263: aload_1
    //   264: invokevirtual 247	java/io/InputStream:close	()V
    //   267: aload_3
    //   268: athrow
    //   269: astore_1
    //   270: aload_1
    //   271: invokevirtual 250	java/io/IOException:printStackTrace	()V
    //   274: goto -7 -> 267
    //   277: astore_3
    //   278: goto -19 -> 259
    //   281: astore 4
    //   283: aconst_null
    //   284: astore_3
    //   285: goto -51 -> 234
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	288	0	this	ShareInformationSecondActivity
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
    if (this.x == null) {
      this.x = LayoutInflater.from(this).inflate(2130903771, null);
    }
    Button localButton = (Button)this.x.findViewById(2131692249);
    ((Button)this.x.findViewById(2131690460)).setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        if (!ah.checkNet(ShareInformationSecondActivity.g(ShareInformationSecondActivity.this)))
        {
          ShareInformationSecondActivity.this.showToast("请检查你的网络设置");
          return;
        }
        d.setSharer(ShareInformationSecondActivity.this, ShareInformationSecondActivity.e(ShareInformationSecondActivity.this), paramString1, paramString2, paramInt1, paramString3, paramInt2, paramString4, paramString5, paramString6);
      }
    });
    localButton.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        ShareInformationSecondActivity.h(ShareInformationSecondActivity.this).dismiss();
        ShareInformationSecondActivity.a(ShareInformationSecondActivity.this, null);
      }
    });
    this.T = new AlertDialog.Builder(this).create();
    this.T.setOnDismissListener(new DialogInterface.OnDismissListener()
    {
      public void onDismiss(DialogInterface paramAnonymousDialogInterface)
      {
        ShareInformationSecondActivity.h(ShareInformationSecondActivity.this).dismiss();
        ShareInformationSecondActivity.a(ShareInformationSecondActivity.this, null);
        ShareInformationSecondActivity.i(ShareInformationSecondActivity.this).setEnabled(true);
      }
    });
    this.T.setView(this.x, 0, 0, 0, 0);
    if (!this.T.isShowing())
    {
      paramString1 = this.T;
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
    this.O = ((ImageView)findViewById(2131697531));
    this.S = ((TextView)findViewById(2131692045));
    this.c = ((EditText)findViewById(2131692391));
    this.d = ((EditText)findViewById(2131692394));
    this.s = ((TextView)findViewById(2131692395));
    this.e = ((EditText)findViewById(2131692396));
    this.f = ((TextView)findViewById(2131692392));
    this.g = ((TextView)findViewById(2131692393));
    this.r = ((TextView)findViewById(2131690319));
    this.u = ((SimpleDraweeView)findViewById(2131692397));
    this.v = ((SimpleDraweeView)findViewById(2131692398));
    ((GenericDraweeHierarchy)this.u.getHierarchy()).setActualImageScaleType(ScalingUtils.ScaleType.FIT_XY);
    ((GenericDraweeHierarchy)this.v.getHierarchy()).setActualImageScaleType(ScalingUtils.ScaleType.FIT_XY);
    ((GenericDraweeHierarchy)this.u.getHierarchy()).setPlaceholderImage(2130838863);
    ((GenericDraweeHierarchy)this.v.getHierarchy()).setPlaceholderImage(2130838863);
    this.t = ((ImageView)findViewById(2131697532));
    this.w = ((Button)findViewById(2131692399));
    this.N = ((TextView)findViewById(2131692400));
    this.P = ((Button)findViewById(2131692401));
    this.r.setVisibility(4);
    this.K = getIntent().getStringExtra("paycontract_code");
    this.Q = getIntent().getStringExtra("new_contract_code");
    this.R = getIntent().getStringExtra("old_contract_code");
    String str = getIntent().getStringExtra("wystate");
    if ((str != null) && (str.equals("wystate"))) {
      this.P.setVisibility(4);
    }
    if (ae.notNull(this.R))
    {
      this.N.setVisibility(8);
      this.P.setVisibility(8);
    }
    this.P.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        paramAnonymousView = new Intent(ShareInformationSecondActivity.this, ZxingActivity.class);
        paramAnonymousView.putExtra("contract_part_code", ShareInformationSecondActivity.this.getIntent().getStringExtra("paycontract_code"));
        ShareInformationSecondActivity.this.startActivity(paramAnonymousView);
      }
    });
    if (ae.notNull(this.Q)) {
      d.getSharer(this, this.V, this.Q);
    }
  }
  
  private void b(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      this.s.setText("身份证");
      this.s.setTextColor(Color.rgb(221, 102, 13));
      return;
    case 2: 
      this.s.setText("护照");
      this.s.setTextColor(Color.rgb(255, 155, 40));
      return;
    case 13: 
      this.s.setText("港澳居民来往通行证");
      this.s.setTextColor(Color.rgb(221, 102, 13));
      return;
    }
    this.s.setText("台湾居民来往通行证");
    this.s.setTextColor(Color.rgb(221, 102, 13));
  }
  
  private void c(int paramInt)
  {
    Intent localIntent = new Intent(this, ScanImageActivity.class);
    ArrayList localArrayList = new ArrayList();
    if (ae.notNull(this.A)) {
      localArrayList.add(this.A);
    }
    if (ae.notNull(this.B)) {
      localArrayList.add(this.B);
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
    this.u.setOnClickListener(this);
    this.v.setOnClickListener(this);
    this.w.setOnClickListener(this);
    this.t.setOnClickListener(this);
    this.s.setOnClickListener(this);
    this.S.setOnClickListener(this);
    this.f.setOnClickListener(this);
    this.g.setOnClickListener(this);
    this.O.setOnClickListener(this);
    this.e.addTextChangedListener(new TextWatcher()
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
        if ("身份证".equals(ShareInformationSecondActivity.a(ShareInformationSecondActivity.this).getText().toString())) {
          ShareInformationSecondActivity.b(ShareInformationSecondActivity.this);
        }
        paramAnonymousCharSequence = str;
        if (paramAnonymousInt2 > 21)
        {
          paramAnonymousCharSequence = str.substring(0, 21);
          ShareInformationSecondActivity.c(ShareInformationSecondActivity.this).setText(paramAnonymousCharSequence);
          ShareInformationSecondActivity.c(ShareInformationSecondActivity.this).setSelection(paramAnonymousInt1);
        }
        ShareInformationSecondActivity.a(ShareInformationSecondActivity.this, ah.formatIDCard(paramAnonymousCharSequence, " "));
        if (((ae.notNull(ShareInformationSecondActivity.d(ShareInformationSecondActivity.this))) && (paramAnonymousCharSequence.equals(ShareInformationSecondActivity.d(ShareInformationSecondActivity.this)))) || (ae.isNull(paramAnonymousCharSequence))) {
          return;
        }
        if (ShareInformationSecondActivity.d(ShareInformationSecondActivity.this).length() > paramAnonymousCharSequence.length()) {
          paramAnonymousInt2 = ShareInformationSecondActivity.d(ShareInformationSecondActivity.this).length() - paramAnonymousCharSequence.length() + paramAnonymousInt1 + 1;
        }
        for (;;)
        {
          ShareInformationSecondActivity.c(ShareInformationSecondActivity.this).setText(ShareInformationSecondActivity.d(ShareInformationSecondActivity.this));
          ShareInformationSecondActivity.c(ShareInformationSecondActivity.this).setSelection(paramAnonymousInt2);
          ShareInformationSecondActivity.a(ShareInformationSecondActivity.this, paramAnonymousCharSequence);
          return;
          if ((ShareInformationSecondActivity.d(ShareInformationSecondActivity.this).length() >= paramAnonymousCharSequence.length()) || (paramAnonymousCharSequence.length() > 21)) {
            break;
          }
          paramAnonymousInt2 = paramAnonymousInt1;
          if (paramAnonymousInt1 > ShareInformationSecondActivity.d(ShareInformationSecondActivity.this).length()) {
            paramAnonymousInt2 = ShareInformationSecondActivity.d(ShareInformationSecondActivity.this).length();
          }
        }
        if (paramAnonymousInt1 + paramAnonymousInt3 > ShareInformationSecondActivity.d(ShareInformationSecondActivity.this).length()) {
          paramAnonymousInt1 = ShareInformationSecondActivity.d(ShareInformationSecondActivity.this).length();
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
  
  private void f()
  {
    String str = VdsAgent.trackEditTextSilent(this.e).toString();
    if (str.length() == 20)
    {
      if (Integer.parseInt(String.valueOf(str.charAt(19))) % 2 == 0)
      {
        this.g.setTextColor(Color.rgb(221, 102, 13));
        this.f.setTextColor(Color.rgb(167, 161, 154));
      }
    }
    else {
      return;
    }
    this.f.setTextColor(Color.rgb(221, 102, 13));
    this.g.setTextColor(Color.rgb(167, 161, 154));
  }
  
  private void g()
  {
    b localb = new b(this, 2131427591, 2);
    localb.setOnCerSelectListener(new b.a()
    {
      public void onCerSelectListener(int paramAnonymousInt)
      {
        ShareInformationSecondActivity.a(ShareInformationSecondActivity.this, paramAnonymousInt);
        ShareInformationSecondActivity.b(ShareInformationSecondActivity.this, paramAnonymousInt);
      }
    });
    localb.show();
  }
  
  private void h()
  {
    if (!checkNet(getApplicationContext()))
    {
      g.textToast(this, "网络请求失败，请检查您的网络设置", 1);
      return;
    }
    String str1 = this.s.getText().toString();
    if ("身份证".equals(str1)) {
      this.M = 1;
    }
    String str3;
    String str2;
    String str4;
    String str5;
    for (;;)
    {
      str3 = VdsAgent.trackEditTextSilent(this.c).toString();
      str2 = VdsAgent.trackEditTextSilent(this.d).toString();
      str1 = VdsAgent.trackEditTextSilent(this.e).toString().replaceAll(" ", "");
      str2 = str2.replaceAll(" ", "");
      str3 = str3.replaceAll(" ", "");
      str4 = this.A;
      str5 = this.B;
      if (!ae.isNull(str3)) {
        break;
      }
      showToast("请填写合租人姓名！");
      return;
      if ("港澳居民来往通行证".equals(str1)) {
        this.M = 13;
      } else if ("台湾居民来往通行证".equals(str1)) {
        this.M = 6;
      } else if ("护照".equals(str1)) {
        this.M = 2;
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
    String str6 = getIntent().getStringExtra("paycontract_code");
    if (this.L <= 0)
    {
      g.textToast(this.H, "请选择性别", 0);
      return;
    }
    a(str6, str3, this.L, str2, this.M, str1, str4, str5);
  }
  
  private void i()
  {
    this.E = new k(this, this.U);
    k localk = this.E;
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
    SimpleDraweeView localSimpleDraweeView = new SimpleDraweeView(this.H);
    if (paramInt == 1)
    {
      localSimpleDraweeView = this.u;
      this.A = paramString;
      this.G.set(0, paramString);
    }
    for (;;)
    {
      localSimpleDraweeView.setController(com.freelxl.baselibrary.f.c.frescoController(paramString));
      return;
      if (paramInt == 2)
      {
        localSimpleDraweeView = this.v;
        this.B = paramString;
        this.G.set(1, paramString);
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
            if (this.A.equals(str))
            {
              this.A = "";
              this.u.setImageResource(2130837780);
            }
            if (this.B.equals(str))
            {
              this.B = "";
              this.v.setImageResource(2130837780);
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
    case 2131692393: 
      this.g.setTextColor(Color.rgb(221, 102, 13));
      this.f.setTextColor(Color.rgb(167, 161, 154));
      this.L = 2;
      return;
    case 2131692392: 
      this.f.setTextColor(Color.rgb(221, 102, 13));
      this.g.setTextColor(Color.rgb(167, 161, 154));
      this.L = 1;
      return;
    case 2131697532: 
      finish();
      return;
    case 2131692399: 
      h();
      return;
    case 2131692397: 
      if (ae.isNull(this.A))
      {
        this.D = 1;
        i();
        return;
      }
      c(0);
      return;
    case 2131692398: 
      if (ae.isNull(this.B))
      {
        this.D = 2;
        i();
        return;
      }
      c(1);
      return;
    case 2131692395: 
      g();
      return;
    case 2131692045: 
      showChoseShare();
      return;
    }
    paramView = new Intent(this, MainActivity.class);
    paramView.putExtra("FRAGMENT_TYPE", 7);
    startActivity(paramView);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903493);
    this.a = this;
    this.H = this;
    b();
    e();
    a();
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
        d.setIsSharer(ShareInformationSecondActivity.this, ShareInformationSecondActivity.e(ShareInformationSecondActivity.this), ShareInformationSecondActivity.f(ShareInformationSecondActivity.this), "2");
        ShareInformationSecondActivity.this.showProgress("", 30000L);
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
  
  public void takePhoto()
  {
    Intent localIntent = new Intent("android.media.action.IMAGE_CAPTURE");
    Object localObject = new StringBuilder();
    new DateFormat();
    this.F = (DateFormat.format("yyyyMMddhhmmss", Calendar.getInstance(Locale.CHINA)) + ".jpg");
    localObject = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/images/");
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    localIntent.putExtra("output", Uri.fromFile(new File((File)localObject, this.F)));
    startActivityForResult(localIntent, 1);
  }
  
  public void uploadPhoto()
  {
    showProgress("图片上传中...");
    Bitmap localBitmap = h.tryGetBitmap(this.F, 1280, 200000);
    h.saveBitmap(localBitmap, this.F, 100);
    if ((localBitmap != null) && (!localBitmap.isRecycled())) {
      localBitmap.recycle();
    }
    d.uploadImage(this, this.V, this.F, h.getBitmapByte(this.F));
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/signed/ShareInformationSecondActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */