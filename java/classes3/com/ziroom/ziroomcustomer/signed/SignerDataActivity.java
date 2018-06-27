package com.ziroom.ziroomcustomer.signed;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.format.DateFormat;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.alibaba.fastjson.e;
import com.facebook.drawee.drawable.ScalingUtils.ScaleType;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.view.SimpleDraweeView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.itrus.raapi.implement.ClientForAndroid;
import com.itrus.raapi.implement.certInfo;
import com.ziroom.router.activityrouter.Routers;
import com.ziroom.ziroomcustomer.account.BankcardDetailActivity;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.a.f;
import com.ziroom.ziroomcustomer.e.c.o;
import com.ziroom.ziroomcustomer.e.e.d;
import com.ziroom.ziroomcustomer.e.e.n;
import com.ziroom.ziroomcustomer.e.g;
import com.ziroom.ziroomcustomer.e.j;
import com.ziroom.ziroomcustomer.e.q;
import com.ziroom.ziroomcustomer.model.Contract;
import com.ziroom.ziroomcustomer.model.CreditsEntity;
import com.ziroom.ziroomcustomer.model.HouseDetail;
import com.ziroom.ziroomcustomer.model.IkeyRaConfig;
import com.ziroom.ziroomcustomer.model.LeaseMyDataEntity;
import com.ziroom.ziroomcustomer.model.SignedInfo;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.util.ah;
import com.ziroom.ziroomcustomer.util.h;
import com.ziroom.ziroomcustomer.util.m;
import com.ziroom.ziroomcustomer.util.n;
import com.ziroom.ziroomcustomer.util.u;
import com.ziroom.ziroomcustomer.util.w;
import com.ziroom.ziroomcustomer.widget.ScanImageActivity;
import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

public class SignerDataActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private String A;
  private Context B;
  private String C = "";
  private String D = "";
  private String E = "";
  private int F = -1;
  private ArrayList<String> G = new ArrayList(3);
  private TextView H;
  private int I = 0;
  private TextView J;
  private String K = "";
  private String L = "";
  private HouseDetail M;
  private HashMap<String, String> N;
  private int O = 0;
  private boolean P;
  private RelativeLayout Q;
  private boolean R = false;
  private com.ziroom.ziroomcustomer.c.a S;
  private boolean T = true;
  private Thread U;
  private AlertDialog V;
  private String W;
  private String X;
  private String Y;
  private String Z;
  l.a a = new l.a()
  {
    public void showHour(String paramAnonymousString, int paramAnonymousInt1, int paramAnonymousInt2)
    {
      switch (paramAnonymousInt2)
      {
      default: 
      case 0: 
        do
        {
          return;
          SignerDataActivity.d(SignerDataActivity.this).setText(paramAnonymousString);
          if ("男".equals(paramAnonymousString))
          {
            SignerDataActivity.a(SignerDataActivity.this, 1);
            return;
          }
        } while (!"女".equals(paramAnonymousString));
        SignerDataActivity.a(SignerDataActivity.this, 2);
        return;
      }
      if ("身份证".equals(paramAnonymousString)) {
        paramAnonymousInt1 = 1;
      }
      for (;;)
      {
        SignerDataActivity.this.getData(paramAnonymousInt1 + "");
        SignerDataActivity.b(SignerDataActivity.this, paramAnonymousInt1);
        SignerDataActivity.c(SignerDataActivity.this, paramAnonymousInt1);
        if (paramAnonymousInt1 == 1)
        {
          SignerDataActivity.f(SignerDataActivity.this).setText(VdsAgent.trackEditTextSilent(SignerDataActivity.f(SignerDataActivity.this)));
          SignerDataActivity.h(SignerDataActivity.this).setText(VdsAgent.trackEditTextSilent(SignerDataActivity.h(SignerDataActivity.this)));
          SignerDataActivity.s(SignerDataActivity.this).setVisibility(8);
          SignerDataActivity.t(SignerDataActivity.this).setVisibility(0);
          SignerDataActivity.H(SignerDataActivity.this);
          if (SignerDataActivity.a(SignerDataActivity.this) == null)
          {
            SignerDataActivity.n(SignerDataActivity.this).setText("去认证");
            SignerDataActivity.n(SignerDataActivity.this).setEnabled(true);
            return;
            if ("港澳居民来往内地通行证".equals(paramAnonymousString))
            {
              paramAnonymousInt1 = 13;
              continue;
            }
            if (!"台湾居民往来大陆通行证".equals(paramAnonymousString)) {
              break label317;
            }
            paramAnonymousInt1 = 6;
            continue;
          }
          if (SignerDataActivity.a(SignerDataActivity.this).getCredits() != null) {
            break;
          }
          SignerDataActivity.n(SignerDataActivity.this).setText("去认证");
          SignerDataActivity.n(SignerDataActivity.this).setEnabled(true);
          return;
        }
        SignerDataActivity.n(SignerDataActivity.this).setText("确定");
        return;
        label317:
        paramAnonymousInt1 = 0;
      }
    }
  };
  private int aa = 1;
  private String[] ab;
  private String[] ac;
  private TextView ad;
  private View ae;
  private TextView af;
  private TextView ag;
  private TextView ah;
  private TextView ai;
  private Dialog aj;
  private View ak;
  private TextView al;
  private TextView am;
  private TextView an;
  private TextView ao;
  private Dialog ap;
  private View.OnClickListener aq = new View.OnClickListener()
  {
    @Instrumented
    public void onClick(View paramAnonymousView)
    {
      VdsAgent.onClick(this, paramAnonymousView);
      SignerDataActivity.v(SignerDataActivity.this).dismiss();
      switch (paramAnonymousView.getId())
      {
      default: 
        return;
      case 2131692507: 
        SignerDataActivity.this.takePhoto();
        return;
      }
      SignerDataActivity.this.selectPhoto();
    }
  };
  private BroadcastReceiver ar = new BroadcastReceiver()
  {
    public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      int i = paramAnonymousIntent.getIntExtra("code", -2);
      if (i == 0) {
        if (ae.isNull(SignerDataActivity.q(SignerDataActivity.this)))
        {
          com.ziroom.ziroomcustomer.e.d.getRaConfig(SignerDataActivity.this, SignerDataActivity.r(SignerDataActivity.this));
          SignerDataActivity.this.showProgress("", 100000L);
        }
      }
      do
      {
        return;
        paramAnonymousContext = new Intent(SignerDataActivity.j(SignerDataActivity.this), SignerAptitudeActivity.class);
        paramAnonymousContext.putExtra("mHouseStatus", SignerDataActivity.q(SignerDataActivity.this));
        paramAnonymousContext.putExtra("detail", SignerDataActivity.m(SignerDataActivity.this));
        SignerDataActivity.this.startActivity(paramAnonymousContext);
        return;
        if (i == 1)
        {
          if (SignerDataActivity.y(SignerDataActivity.this) == null)
          {
            SignerDataActivity.this.getData("");
            return;
          }
          com.ziroom.ziroomcustomer.e.d.getLeaseMyData(SignerDataActivity.r(SignerDataActivity.this), SignerDataActivity.y(SignerDataActivity.this));
          return;
        }
      } while (i != -1);
      if (SignerDataActivity.y(SignerDataActivity.this) == null)
      {
        SignerDataActivity.this.getData("");
        return;
      }
      com.ziroom.ziroomcustomer.e.d.getLeaseMyData(SignerDataActivity.r(SignerDataActivity.this), SignerDataActivity.y(SignerDataActivity.this));
    }
  };
  private SignedInfo as;
  private Handler at = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      Object localObject = (com.ziroom.ziroomcustomer.e.l)paramAnonymousMessage.obj;
      switch (paramAnonymousMessage.what)
      {
      default: 
        return;
      case 4144: 
        SignerDataActivity.this.dismissProgress();
        if (((com.ziroom.ziroomcustomer.e.l)localObject).getSuccess().booleanValue())
        {
          SignerDataActivity.d(SignerDataActivity.this, (String)((com.ziroom.ziroomcustomer.e.l)localObject).getObject());
          SignerDataActivity.this.a(SignerDataActivity.w(SignerDataActivity.this), SignerDataActivity.x(SignerDataActivity.this));
          return;
        }
        SignerDataActivity.this.showToast("图片上传失败！");
        return;
      case 69665: 
        SignerDataActivity.this.dismissProgress();
        if (((com.ziroom.ziroomcustomer.e.l)localObject).getSuccess().booleanValue())
        {
          SignerDataActivity.a(SignerDataActivity.this, (SignedInfo)((com.ziroom.ziroomcustomer.e.l)localObject).getObject());
          SignerDataActivity.this.a(SignerDataActivity.a(SignerDataActivity.this));
          return;
        }
        SignerDataActivity.this.showToast("证件信息获取失败，请返回重试");
        return;
      case 69699: 
        if (((com.ziroom.ziroomcustomer.e.l)localObject).getSuccess().booleanValue())
        {
          SignerDataActivity.z(SignerDataActivity.this);
          SignerDataActivity.A(SignerDataActivity.this);
          return;
        }
        SignerDataActivity.this.showToast("无纸化签约证书出现问题,请稍后再试!!!");
        com.ziroom.ziroomcustomer.e.d.errorLog(SignerDataActivity.this, "获取RA配置信息失败", ((com.ziroom.ziroomcustomer.e.l)localObject).getMessage());
        SignerDataActivity.this.dismissProgress();
        return;
      case 69700: 
        SignerDataActivity.this.dismissProgress();
        if (SignerDataActivity.B(SignerDataActivity.this))
        {
          if (ae.notNull(SignerDataActivity.C(SignerDataActivity.this)))
          {
            if (SignerDataActivity.a(SignerDataActivity.this).getCert_type() == 1)
            {
              paramAnonymousMessage = new Intent(SignerDataActivity.this, BankcardDetailActivity.class);
              paramAnonymousMessage.putExtra("name", SignerDataActivity.a(SignerDataActivity.this).getReal_name());
              SignerDataActivity.this.startActivity(paramAnonymousMessage);
              SignerDataActivity.this.finish();
              return;
            }
            SignerDataActivity.a(SignerDataActivity.this, Integer.valueOf(2));
            return;
          }
          SignerDataActivity.this.finish();
          return;
        }
        if (ae.notNull(SignerDataActivity.D(SignerDataActivity.this)))
        {
          paramAnonymousMessage = new Intent(SignerDataActivity.this, TurnSignTermsActivity.class);
          SignerDataActivity.this.startActivity(paramAnonymousMessage);
          return;
        }
        if (ae.notNull(SignerDataActivity.C(SignerDataActivity.this)))
        {
          paramAnonymousMessage = new Intent(SignerDataActivity.this, BankcardDetailActivity.class);
          paramAnonymousMessage.putExtra("name", SignerDataActivity.a(SignerDataActivity.this).getReal_name());
          SignerDataActivity.this.startActivity(paramAnonymousMessage);
          return;
        }
        paramAnonymousMessage = new Intent(SignerDataActivity.this, SignerAptitudeActivity.class);
        paramAnonymousMessage.putExtra("detail", SignerDataActivity.m(SignerDataActivity.this));
        SignerDataActivity.this.startActivity(paramAnonymousMessage);
        return;
      }
      SignerDataActivity.this.dismissProgress();
      if (((com.ziroom.ziroomcustomer.e.l)localObject).getSuccess().booleanValue())
      {
        paramAnonymousMessage = (LeaseMyDataEntity)((com.ziroom.ziroomcustomer.e.l)localObject).getObject();
        localObject = new CreditsEntity();
        ((CreditsEntity)localObject).setRealNameStatus(paramAnonymousMessage.getRealNameStatus());
        SignerDataActivity.a(SignerDataActivity.this, new SignedInfo(paramAnonymousMessage.getUserName(), paramAnonymousMessage.getUserSex(), paramAnonymousMessage.getUserPhone(), paramAnonymousMessage.getCertType(), paramAnonymousMessage.getCertNum(), paramAnonymousMessage.getHandleCert1(), paramAnonymousMessage.getHandleCert2(), paramAnonymousMessage.getHandleCert3(), 1, 1, (CreditsEntity)localObject));
        SignerDataActivity.this.a(SignerDataActivity.a(SignerDataActivity.this));
        return;
      }
      SignerDataActivity.this.showToast("证件信息获取失败，请返回重试");
    }
  };
  private View au;
  private String av;
  private TextView b;
  private TextView c;
  private TextView d;
  private EditText e;
  private EditText f;
  private EditText g;
  private EditText r;
  private SimpleDraweeView s;
  private SimpleDraweeView t;
  private SimpleDraweeView u;
  private SimpleDraweeView v;
  private LinearLayout w;
  private k x;
  private Button y;
  private String z;
  
  private void a()
  {
    if (ae.isNull(com.ziroom.commonlib.utils.b.getAppId())) {
      ApplicationEx.c.getHttpAppID();
    }
  }
  
  private void a(int paramInt, String[] paramArrayOfString)
  {
    paramArrayOfString = new l(this, this.a, paramArrayOfString, paramInt);
    u.e("list", this.ab.toString());
    paramArrayOfString.setCanceledOnTouchOutside(true);
    Window localWindow = paramArrayOfString.getWindow();
    localWindow.getDecorView().setPadding(0, 0, 0, 0);
    WindowManager.LayoutParams localLayoutParams = localWindow.getAttributes();
    localLayoutParams.width = -1;
    localLayoutParams.height = -2;
    localWindow.setAttributes(localLayoutParams);
    localWindow.setGravity(80);
    paramArrayOfString.show();
    paramArrayOfString.getTv_choose().setText("");
  }
  
  /* Error */
  private void a(Intent paramIntent)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_0
    //   4: new 317	java/lang/StringBuilder
    //   7: dup
    //   8: invokespecial 318	java/lang/StringBuilder:<init>	()V
    //   11: ldc_w 320
    //   14: getstatic 326	java/util/Locale:CHINA	Ljava/util/Locale;
    //   17: invokestatic 332	java/util/Calendar:getInstance	(Ljava/util/Locale;)Ljava/util/Calendar;
    //   20: invokestatic 338	android/text/format/DateFormat:format	(Ljava/lang/CharSequence;Ljava/util/Calendar;)Ljava/lang/CharSequence;
    //   23: invokevirtual 342	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   26: ldc_w 344
    //   29: invokevirtual 347	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: invokevirtual 348	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   35: putfield 350	com/ziroom/ziroomcustomer/signed/SignerDataActivity:z	Ljava/lang/String;
    //   38: aload_1
    //   39: invokevirtual 356	android/content/Intent:getData	()Landroid/net/Uri;
    //   42: astore_1
    //   43: aload_1
    //   44: ifnonnull +4 -> 48
    //   47: return
    //   48: aload_0
    //   49: invokevirtual 360	com/ziroom/ziroomcustomer/signed/SignerDataActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   52: astore_3
    //   53: aload_3
    //   54: aload_1
    //   55: invokevirtual 366	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   58: astore_3
    //   59: aload_3
    //   60: astore_1
    //   61: aload_3
    //   62: invokestatic 372	com/ziroom/ziroomcustomer/util/h:getBytes	(Ljava/io/InputStream;)[B
    //   65: astore 5
    //   67: aload 5
    //   69: astore 4
    //   71: aload_3
    //   72: astore_1
    //   73: new 374	android/graphics/BitmapFactory$Options
    //   76: dup
    //   77: invokespecial 375	android/graphics/BitmapFactory$Options:<init>	()V
    //   80: astore 5
    //   82: aload_3
    //   83: astore_1
    //   84: aload 5
    //   86: iconst_1
    //   87: putfield 378	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   90: aload_3
    //   91: astore_1
    //   92: aload 4
    //   94: iconst_0
    //   95: aload 4
    //   97: arraylength
    //   98: aload 5
    //   100: invokestatic 384	android/graphics/BitmapFactory:decodeByteArray	([BIILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   103: pop
    //   104: aload_3
    //   105: astore_1
    //   106: aload 5
    //   108: getfield 387	android/graphics/BitmapFactory$Options:outWidth	I
    //   111: i2f
    //   112: aload 5
    //   114: getfield 390	android/graphics/BitmapFactory$Options:outHeight	I
    //   117: i2f
    //   118: invokestatic 394	com/ziroom/ziroomcustomer/util/h:setSimpleSize	(FF)I
    //   121: istore_2
    //   122: aload_3
    //   123: astore_1
    //   124: aload 5
    //   126: iconst_0
    //   127: putfield 378	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   130: aload_3
    //   131: astore_1
    //   132: aload 5
    //   134: iload_2
    //   135: putfield 397	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   138: aload_3
    //   139: astore_1
    //   140: aload 4
    //   142: iconst_0
    //   143: aload 4
    //   145: arraylength
    //   146: aload 5
    //   148: invokestatic 384	android/graphics/BitmapFactory:decodeByteArray	([BIILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   151: astore 4
    //   153: aload 4
    //   155: ifnull +52 -> 207
    //   158: aload_3
    //   159: astore_1
    //   160: aload 4
    //   162: sipush 300
    //   165: invokestatic 401	com/ziroom/ziroomcustomer/util/h:compImgBySize	(Landroid/graphics/Bitmap;I)Landroid/graphics/Bitmap;
    //   168: astore 5
    //   170: aload_3
    //   171: astore_1
    //   172: aload 5
    //   174: aload_0
    //   175: getfield 350	com/ziroom/ziroomcustomer/signed/SignerDataActivity:z	Ljava/lang/String;
    //   178: bipush 100
    //   180: invokestatic 405	com/ziroom/ziroomcustomer/util/h:saveBitmap	(Landroid/graphics/Bitmap;Ljava/lang/String;I)V
    //   183: aload 4
    //   185: ifnull +10 -> 195
    //   188: aload_3
    //   189: astore_1
    //   190: aload 4
    //   192: invokevirtual 410	android/graphics/Bitmap:recycle	()V
    //   195: aload 5
    //   197: ifnull +10 -> 207
    //   200: aload_3
    //   201: astore_1
    //   202: aload 5
    //   204: invokevirtual 410	android/graphics/Bitmap:recycle	()V
    //   207: aload_3
    //   208: ifnull -161 -> 47
    //   211: aload_3
    //   212: invokevirtual 415	java/io/InputStream:close	()V
    //   215: return
    //   216: astore_1
    //   217: aload_1
    //   218: invokevirtual 418	java/io/IOException:printStackTrace	()V
    //   221: return
    //   222: astore 5
    //   224: aload_3
    //   225: astore_1
    //   226: aload 5
    //   228: invokevirtual 418	java/io/IOException:printStackTrace	()V
    //   231: goto -160 -> 71
    //   234: astore 4
    //   236: aload_3
    //   237: astore_1
    //   238: aload 4
    //   240: invokevirtual 419	java/io/FileNotFoundException:printStackTrace	()V
    //   243: aload_3
    //   244: ifnull -197 -> 47
    //   247: aload_3
    //   248: invokevirtual 415	java/io/InputStream:close	()V
    //   251: return
    //   252: astore_1
    //   253: aload_1
    //   254: invokevirtual 418	java/io/IOException:printStackTrace	()V
    //   257: return
    //   258: astore_3
    //   259: aconst_null
    //   260: astore_1
    //   261: aload_1
    //   262: ifnull +7 -> 269
    //   265: aload_1
    //   266: invokevirtual 415	java/io/InputStream:close	()V
    //   269: aload_3
    //   270: athrow
    //   271: astore_1
    //   272: aload_1
    //   273: invokevirtual 418	java/io/IOException:printStackTrace	()V
    //   276: goto -7 -> 269
    //   279: astore_3
    //   280: goto -19 -> 261
    //   283: astore 4
    //   285: aconst_null
    //   286: astore_3
    //   287: goto -51 -> 236
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	290	0	this	SignerDataActivity
    //   0	290	1	paramIntent	Intent
    //   121	14	2	i	int
    //   52	196	3	localObject1	Object
    //   258	12	3	localObject2	Object
    //   279	1	3	localObject3	Object
    //   286	1	3	localObject4	Object
    //   1	190	4	localObject5	Object
    //   234	5	4	localFileNotFoundException1	java.io.FileNotFoundException
    //   283	1	4	localFileNotFoundException2	java.io.FileNotFoundException
    //   65	138	5	localObject6	Object
    //   222	5	5	localIOException	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   211	215	216	java/io/IOException
    //   61	67	222	java/io/IOException
    //   61	67	234	java/io/FileNotFoundException
    //   73	82	234	java/io/FileNotFoundException
    //   84	90	234	java/io/FileNotFoundException
    //   92	104	234	java/io/FileNotFoundException
    //   106	122	234	java/io/FileNotFoundException
    //   124	130	234	java/io/FileNotFoundException
    //   132	138	234	java/io/FileNotFoundException
    //   140	153	234	java/io/FileNotFoundException
    //   160	170	234	java/io/FileNotFoundException
    //   172	183	234	java/io/FileNotFoundException
    //   190	195	234	java/io/FileNotFoundException
    //   202	207	234	java/io/FileNotFoundException
    //   226	231	234	java/io/FileNotFoundException
    //   247	251	252	java/io/IOException
    //   53	59	258	finally
    //   265	269	271	java/io/IOException
    //   61	67	279	finally
    //   73	82	279	finally
    //   84	90	279	finally
    //   92	104	279	finally
    //   106	122	279	finally
    //   124	130	279	finally
    //   132	138	279	finally
    //   140	153	279	finally
    //   160	170	279	finally
    //   172	183	279	finally
    //   190	195	279	finally
    //   202	207	279	finally
    //   226	231	279	finally
    //   238	243	279	finally
    //   53	59	283	java/io/FileNotFoundException
  }
  
  private void a(Integer paramInteger)
  {
    this.ak = View.inflate(this, 2130905178, null);
    this.an = ((TextView)this.ak.findViewById(2131697634));
    this.ao = ((TextView)this.ak.findViewById(2131697637));
    this.al = ((TextView)this.ak.findViewById(2131697639));
    this.am = ((TextView)this.ak.findViewById(2131697638));
    if (paramInteger.intValue() == 1)
    {
      this.an.setVisibility(8);
      this.ao.setVisibility(0);
      this.al.setText("联系管家");
      this.am.setText("稍后再说");
      this.ao.setText("因无法获取到您的证件信息，需要您联系管家进行转签确认。");
      this.al.setOnClickListener(this);
      this.am.setOnClickListener(this);
      if (this.ap == null)
      {
        this.ap = new Dialog(this, 2131427781);
        this.ap.setContentView(this.ak);
        paramInteger = this.ap;
        if ((paramInteger instanceof Dialog)) {
          break label303;
        }
        paramInteger.show();
      }
    }
    for (;;)
    {
      this.ap.setOnDismissListener(new DialogInterface.OnDismissListener()
      {
        public void onDismiss(DialogInterface paramAnonymousDialogInterface)
        {
          SignerDataActivity.a(SignerDataActivity.this, null);
          SignerDataActivity.u(SignerDataActivity.this).dismiss();
        }
      });
      return;
      if (paramInteger.intValue() != 2) {
        break;
      }
      this.an.setVisibility(0);
      this.ao.setVisibility(8);
      this.an.setHeight(n.dip2px(this, 48.0F));
      this.am.setText("知道了");
      this.al.setVisibility(8);
      this.am.setVisibility(0);
      this.an.setText("非身份证用户请联系客服400-100-1111进行认证");
      this.am.setOnClickListener(this);
      break;
      label303:
      VdsAgent.showDialog((Dialog)paramInteger);
    }
  }
  
  private void a(String paramString1, final int paramInt1, final String paramString2, final int paramInt2, final String paramString3, final String paramString4, final String paramString5, final String paramString6)
  {
    if (this.au == null) {
      this.au = LayoutInflater.from(this).inflate(2130903771, null);
    }
    paramString1 = (Button)this.au.findViewById(2131692249);
    Button localButton = (Button)this.au.findViewById(2131690460);
    if (this.as.getCredits() != null)
    {
      if ((this.as.getCredits().getRealNameStatus() != 1) || (this.as.getCert_type() != 1)) {
        break label209;
      }
      localButton.setText("去认证");
      localButton.setEnabled(true);
    }
    for (;;)
    {
      localButton.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          w.onEvent(SignerDataActivity.j(SignerDataActivity.this), "signup_idcard_reminder_submit");
          if (!ah.checkNet(SignerDataActivity.j(SignerDataActivity.this)))
          {
            SignerDataActivity.this.showToast("请检查你的网络设置");
            return;
          }
          paramAnonymousView = SignerDataActivity.c(SignerDataActivity.this, VdsAgent.trackEditTextSilent(SignerDataActivity.k(SignerDataActivity.this)).toString().trim());
          if (SignerDataActivity.l(SignerDataActivity.this) == null) {
            SignerDataActivity.a(SignerDataActivity.this, new HashMap());
          }
          for (;;)
          {
            SignerDataActivity.l(SignerDataActivity.this).put("name", paramAnonymousView);
            SignerDataActivity.l(SignerDataActivity.this).put("mCerType2", paramInt2 + "");
            SignerDataActivity.l(SignerDataActivity.this).put("cerNum", paramString3);
            ApplicationEx.c.setUserMap(SignerDataActivity.l(SignerDataActivity.this));
            if (SignerDataActivity.m(SignerDataActivity.this) == null) {
              SignerDataActivity.a(SignerDataActivity.this, new HouseDetail());
            }
            SignerDataActivity.n(SignerDataActivity.this).setEnabled(false);
            String str = paramString3.replaceAll("x", "X");
            paramAnonymousView = g.buildSignedUserInfo(SignerDataActivity.a(SignerDataActivity.this).getCert_id(), com.ziroom.commonlibrary.login.a.getToken(SignerDataActivity.this.getApplicationContext()), paramAnonymousView, paramInt1, paramString2, paramInt2, str, paramString4, paramString5, paramString6, SignerDataActivity.m(SignerDataActivity.this).getHouse_type(), SignerDataActivity.o(SignerDataActivity.this));
            SignerDataActivity.a(SignerDataActivity.this, paramAnonymousView);
            SignerDataActivity.p(SignerDataActivity.this).dismiss();
            SignerDataActivity.b(SignerDataActivity.this, null);
            return;
            SignerDataActivity.l(SignerDataActivity.this).clear();
          }
        }
      });
      paramString1.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          SignerDataActivity.p(SignerDataActivity.this).dismiss();
          SignerDataActivity.b(SignerDataActivity.this, null);
          w.onEvent(SignerDataActivity.j(SignerDataActivity.this), "signup_idcard_reminder_later");
        }
      });
      this.V = new AlertDialog.Builder(this).create();
      this.V.setOnDismissListener(new DialogInterface.OnDismissListener()
      {
        public void onDismiss(DialogInterface paramAnonymousDialogInterface)
        {
          SignerDataActivity.p(SignerDataActivity.this).dismiss();
          SignerDataActivity.b(SignerDataActivity.this, null);
          SignerDataActivity.n(SignerDataActivity.this).setEnabled(true);
        }
      });
      this.V.setView(this.au, 0, 0, 0, 0);
      if (!this.V.isShowing())
      {
        paramString1 = this.V;
        if ((paramString1 instanceof AlertDialog)) {
          break;
        }
        paramString1.show();
      }
      return;
      label209:
      if (this.as.getCredits().getRealNameStatus() == 2)
      {
        localButton.setText("认证中");
        localButton.setEnabled(false);
      }
      else if ((this.as.getCredits().getRealNameStatus() == 3) && (this.as.getCert_type() == 1))
      {
        localButton.setText("去认证");
        localButton.setEnabled(true);
      }
    }
    VdsAgent.showDialog((AlertDialog)paramString1);
  }
  
  private void a(String paramString, SimpleDraweeView paramSimpleDraweeView)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("token", com.ziroom.commonlibrary.login.a.getToken(getApplicationContext()));
    localHashMap.put("uuid", paramString + "");
    paramString = g.getPassportSign(localHashMap);
    paramSimpleDraweeView.setController(com.freelxl.baselibrary.f.c.frescoController(b(q.O + e.d.d, paramString)));
  }
  
  private void a(final HashMap<String, String> paramHashMap)
  {
    this.U = new Thread(new Runnable()
    {
      public void run()
      {
        String str = SignerDataActivity.b(SignerDataActivity.this, paramHashMap);
        if (TextUtils.isEmpty(str))
        {
          if ((SignerDataActivity.E(SignerDataActivity.this)) && (SignerDataActivity.F(SignerDataActivity.this)))
          {
            SignerDataActivity.b(SignerDataActivity.this, false);
            SignerDataActivity.z(SignerDataActivity.this);
            SignerDataActivity.c(SignerDataActivity.this, paramHashMap);
            return;
          }
          com.ziroom.ziroomcustomer.e.d.errorLog(SignerDataActivity.this, "生成CSR失败", "操作失败!!" + ApplicationEx.c.k.GetLastErrInfo());
          SignerDataActivity.this.dismissProgress();
          SignerDataActivity.this.runOnUiThread(new Runnable()
          {
            public void run()
            {
              SignerDataActivity.this.showToast("无纸化出现异常,请稍后再试!");
            }
          });
          return;
        }
        u.d("ikey", "CSR生成成功!! 正在申请证书...");
        com.itrus.raapi.implement.UserInfo localUserInfo = new com.itrus.raapi.implement.UserInfo();
        localUserInfo.setUserAdditionalField1(ApplicationEx.c.getUserId(SignerDataActivity.this));
        localUserInfo.setUserName((String)paramHashMap.get("name"));
        localUserInfo.setUserSurname((String)paramHashMap.get("cerNum"));
        localUserInfo.setUserAdditionalField2(SignerDataActivity.d(SignerDataActivity.this, Integer.parseInt(((String)paramHashMap.get("mCerType2")).toString())));
        u.d("ikey", "name===" + (String)paramHashMap.get("name"));
        u.d("ikey", "cerNum===" + (String)paramHashMap.get("cerNum"));
        Bundle localBundle = new Bundle();
        localBundle.putSerializable("UserInfo", localUserInfo);
        localBundle.putString("CSR", str);
        localBundle.putString("PassPort", "");
        localBundle.putString("CHALLENGE", ApplicationEx.c.getRaConfig().getStrChangllege());
        localBundle.putString("Time", "1");
        new SignerDataActivity.a(SignerDataActivity.this, null).execute(new Bundle[] { localBundle });
      }
    });
    this.U.start();
  }
  
  private void a(final Map<String, String> paramMap)
  {
    com.freelxl.baselibrary.f.d.e("url", q.O + e.n.q + paramMap);
    com.freelxl.baselibrary.d.a.post(q.O + e.n.q).tag(this.B).params(paramMap).addHeader("Accept", "application/json; version=1").enqueue(new com.ziroom.commonlibrary.a.a(this.B, new com.freelxl.baselibrary.d.f.c())
    {
      public void onSuccess(int paramAnonymousInt, e paramAnonymouse)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymouse);
        u.d("OKHttp", "===" + paramAnonymouse.toString());
        dismissProgress();
        if ("success".equals(paramAnonymouse.get("status")))
        {
          if (SignerDataActivity.a(SignerDataActivity.this).getCredits() != null)
          {
            if (SignerDataActivity.a(SignerDataActivity.this).getCredits().getRealNameStatus() != 4)
            {
              paramAnonymouse = VdsAgent.trackEditTextSilent(SignerDataActivity.k(SignerDataActivity.this)).toString().trim();
              str = VdsAgent.trackEditTextSilent(SignerDataActivity.f(SignerDataActivity.this)).toString().trim();
              paramAnonymouse.replace(" ", "");
              str.replace(" ", "");
              paramAnonymouse = "ziroomCustomer://zrCreditModule/zmAuthentication?userName=" + (String)paramMap.get("real_name") + "&userPhone=" + (String)paramMap.get("phone") + "&certType=" + Integer.parseInt((String)paramMap.get("cert_type")) + "&certNum=" + (String)paramMap.get("cert_num") + "&cerPositiveUrl=" + (String)paramMap.get("user_cert1") + "&certReverseUrl=" + (String)paramMap.get("user_cert2") + "&certHandhelUrl=" + (String)paramMap.get("user_cert3") + "&userSex=" + Integer.parseInt((String)paramMap.get("gender")) + "&source=0&isEnterprise=0";
              Routers.open(SignerDataActivity.this, paramAnonymouse);
              return;
            }
            if (ae.isNull(SignerDataActivity.q(SignerDataActivity.this)))
            {
              com.ziroom.ziroomcustomer.e.d.getRaConfig(SignerDataActivity.this, SignerDataActivity.r(SignerDataActivity.this));
              SignerDataActivity.this.showProgress("", 100000L);
              return;
            }
            paramAnonymouse = new Intent(SignerDataActivity.j(SignerDataActivity.this), SignerAptitudeActivity.class);
            paramAnonymouse.putExtra("mHouseStatus", SignerDataActivity.q(SignerDataActivity.this));
            paramAnonymouse.putExtra("detail", SignerDataActivity.m(SignerDataActivity.this));
            SignerDataActivity.this.startActivity(paramAnonymouse);
            return;
          }
          paramAnonymouse = VdsAgent.trackEditTextSilent(SignerDataActivity.k(SignerDataActivity.this)).toString().trim();
          String str = VdsAgent.trackEditTextSilent(SignerDataActivity.f(SignerDataActivity.this)).toString().trim();
          paramAnonymouse.replace(" ", "");
          str.replace(" ", "");
          paramAnonymouse = "ziroomCustomer://zrCreditModule/zmAuthentication?userName=" + (String)paramMap.get("real_name") + "&userPhone=" + (String)paramMap.get("phone") + "&certType=" + Integer.parseInt((String)paramMap.get("cert_type")) + "&certNum=" + (String)paramMap.get("cert_num") + "&cerPositiveUrl=" + (String)paramMap.get("user_cert1") + "&certReverseUrl=" + (String)paramMap.get("user_cert2") + "&certHandhelUrl=" + (String)paramMap.get("user_cert3") + "&userSex=" + Integer.parseInt((String)paramMap.get("gender")) + "&source=0&isEnterprise=0";
          Routers.open(SignerDataActivity.this, paramAnonymouse);
          return;
        }
        SignerDataActivity.this.showToast(paramAnonymouse.get("error_message") + "");
      }
    });
  }
  
  private void a(boolean paramBoolean)
  {
    this.H.setEnabled(paramBoolean);
  }
  
  private String b(HashMap<String, String> paramHashMap)
  {
    try
    {
      Thread.sleep(1000L);
      u.d("ikey", "正在生成CSR");
      u.d("ikey", "android.os.Build.MODEL===" + Build.MODEL);
      u.d("ikey", "map.get(name)===" + (String)paramHashMap.get("name"));
      paramHashMap = ApplicationEx.c.k.GenCSR(Build.MODEL, (String)paramHashMap.get("name"), "", "", "", 1024, "RSA");
      return paramHashMap;
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        localInterruptedException.printStackTrace();
      }
    }
    finally {}
  }
  
  private void b()
  {
    this.ab = new String[2];
    this.ab[0] = "男";
    this.ab[1] = "女";
    this.ac = new String[3];
    this.ac[0] = "身份证";
    this.ac[1] = "港澳居民来往内地通行证";
    this.ac[2] = "台湾居民往来大陆通行证";
  }
  
  private void b(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      this.J.setText("身份证 ");
      this.w.setVisibility(8);
      this.ad.setVisibility(0);
      i();
      return;
    case 13: 
      if (!this.R) {
        a(true);
      }
      this.J.setText("港澳居民来往通行证 ");
      this.w.setVisibility(0);
      this.ad.setVisibility(8);
      return;
    }
    if (!this.R) {
      a(true);
    }
    this.J.setText("台湾居民来往通行证 ");
    this.w.setVisibility(0);
    this.ad.setVisibility(8);
  }
  
  private void b(boolean paramBoolean)
  {
    this.t.setEnabled(paramBoolean);
    this.u.setEnabled(paramBoolean);
    this.v.setEnabled(paramBoolean);
  }
  
  private void c(int paramInt)
  {
    Intent localIntent = new Intent(this, ScanImageActivity.class);
    ArrayList localArrayList = new ArrayList();
    if (ae.notNull(this.C)) {
      localArrayList.add(this.C);
    }
    if (ae.notNull(this.D)) {
      localArrayList.add(this.D);
    }
    if (ae.notNull(this.E)) {
      localArrayList.add(this.E);
    }
    int i = paramInt;
    if (localArrayList.size() == 2)
    {
      if (paramInt != 2) {
        break label136;
      }
      i = 1;
    }
    for (;;)
    {
      localIntent.putExtra("tag", "SignerDataActivity");
      localIntent.putExtra("position", i);
      localIntent.putExtra("photos", localArrayList);
      startActivityForResult(localIntent, 3);
      return;
      label136:
      i = paramInt;
      if (ae.isNull(this.C))
      {
        i = paramInt;
        if (paramInt == 1) {
          i = 0;
        }
      }
    }
  }
  
  private String d(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "";
    case 1: 
      return "身份证 ";
    case 2: 
      return "护照 ";
    case 13: 
      return "港澳居民来往通行证 ";
    }
    return "台湾居民来往通行证 ";
  }
  
  private void d(String paramString)
  {
    try
    {
      if (Long.valueOf(m.getDaysBetween(new Date(System.currentTimeMillis()), new Date(n()))).longValue() < 0L)
      {
        ApplicationEx.c.k.DeleteCertBySerialNumber(ApplicationEx.c.k.GetCertSerialNumber(paramString));
        a(this.N);
        return;
      }
      paramString = this.at.obtainMessage();
      paramString.what = 69700;
      this.at.sendMessage(paramString);
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private String e(String paramString)
  {
    Object localObject = paramString;
    if (!ae.checkNameChese(paramString))
    {
      localObject = paramString.toCharArray();
      int i = 0;
      while (i < paramString.length())
      {
        if ((!ae.isChinese(localObject[i])) && (!Character.isLetter(localObject[i])) && (!Character.isDigit(localObject[i]))) {
          localObject[i] = ae.unicode2String("\\\\u00b7").toCharArray()[0];
        }
        i += 1;
      }
      localObject = String.valueOf((char[])localObject);
    }
    return (String)localObject;
  }
  
  private void e()
  {
    this.M = new HouseDetail();
    int i = 0;
    while (i < 3)
    {
      this.G.add("");
      i += 1;
    }
    this.P = ae.notNull(getIntent().getStringExtra("signData"));
    if (!this.P)
    {
      this.aa = 1;
      this.Y = getIntent().getStringExtra("is_turn");
      if (ae.notNull(this.Y)) {
        this.Q.setVisibility(8);
      }
    }
    for (;;)
    {
      this.av = getIntent().getStringExtra("account");
      this.Z = getIntent().getStringExtra("phone");
      if (this.Z != null)
      {
        this.f.setText(this.Z);
        this.f.setEnabled(false);
      }
      this.X = getIntent().getStringExtra("lease");
      if (this.X != null) {
        break;
      }
      getData("");
      return;
      this.Q.setVisibility(0);
      this.W = getIntent().getStringExtra("House_status");
      this.M = ((HouseDetail)getIntent().getSerializableExtra("detail"));
      label238:
      Object localObject;
      if (ae.isNull(this.W))
      {
        w.onEvent(this.B, "signup_idinfo");
        if (this.M == null) {
          break label500;
        }
        com.freelxl.baselibrary.f.d.d("house_message", "    " + this.M.getIs_duanzu());
        localObject = this.M.getHouse_photos_small();
        if ((localObject != null) && (((List)localObject).size() > 0)) {
          this.s.setController(com.freelxl.baselibrary.f.c.frescoController((String)((List)localObject).get(0)));
        }
        this.b.setText(this.M.getHouse_name());
        if (this.M.getIs_duanzu() != 1) {
          break label451;
        }
        localObject = this.M.getHouse_price() + "元/天";
        ah.setTextColor(this.c, (String)localObject, 0, this.M.getHouse_price().length());
      }
      for (;;)
      {
        if (!ae.notNull(this.M.getHouse_area())) {
          break label498;
        }
        this.d.setText(this.M.getHouse_area() + "m²");
        break;
        w.onEvent(this.B, "book_idinfo");
        break label238;
        label451:
        localObject = this.M.getHouse_price() + "元/月";
        ah.setTextColor(this.c, (String)localObject, 0, this.M.getHouse_price().length());
      }
      label498:
      continue;
      label500:
      this.Q.setVisibility(8);
      continue;
      this.aa = 0;
      this.Q.setVisibility(8);
      i();
      w.onEvent(this.B, "personal_settings_idinfo");
    }
    com.ziroom.ziroomcustomer.e.d.getLeaseMyData(this.at, this.X);
    this.y.setVisibility(8);
    this.ad.setVisibility(8);
  }
  
  private void f()
  {
    this.t.setOnClickListener(this);
    this.u.setOnClickListener(this);
    this.v.setOnClickListener(this);
    this.y.setOnClickListener(this);
    this.H.setOnClickListener(this);
    this.J.setOnClickListener(this);
    this.g.addTextChangedListener(new TextWatcher()
    {
      private int b = -1;
      
      public void afterTextChanged(Editable paramAnonymousEditable) {}
      
      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        this.b = paramAnonymousInt1;
      }
      
      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        if (SignerDataActivity.b(SignerDataActivity.this) == 1)
        {
          paramAnonymousInt2 = paramAnonymousCharSequence.toString().length();
          paramAnonymousCharSequence = paramAnonymousCharSequence.toString();
          if ((!SignerDataActivity.c(SignerDataActivity.this)) && (paramAnonymousInt2 != 21)) {
            break label174;
          }
        }
        for (;;)
        {
          try
          {
            if (Integer.valueOf(paramAnonymousCharSequence.charAt(paramAnonymousInt2 - 2)).intValue() % 2 == 0) {
              continue;
            }
            SignerDataActivity.d(SignerDataActivity.this).setText("男");
            SignerDataActivity.a(SignerDataActivity.this, 1);
            SignerDataActivity.a(SignerDataActivity.this, false);
          }
          catch (Exception localException)
          {
            localException.printStackTrace();
            continue;
          }
          SignerDataActivity.a(SignerDataActivity.this, ah.formatIDCard(paramAnonymousCharSequence, " "));
          if (((!ae.notNull(SignerDataActivity.e(SignerDataActivity.this))) || (!paramAnonymousCharSequence.equals(SignerDataActivity.e(SignerDataActivity.this)))) && (!ae.isNull(paramAnonymousCharSequence))) {
            break;
          }
          return;
          SignerDataActivity.d(SignerDataActivity.this).setText("女");
          SignerDataActivity.a(SignerDataActivity.this, 2);
          continue;
          label174:
          SignerDataActivity.a(SignerDataActivity.this, true);
        }
        if (SignerDataActivity.e(SignerDataActivity.this).length() > paramAnonymousCharSequence.length()) {
          paramAnonymousInt2 = SignerDataActivity.e(SignerDataActivity.this).length() - paramAnonymousCharSequence.length() + paramAnonymousInt1 + 1;
        }
        for (;;)
        {
          SignerDataActivity.f(SignerDataActivity.this).setText(SignerDataActivity.e(SignerDataActivity.this));
          SignerDataActivity.f(SignerDataActivity.this).setSelection(paramAnonymousInt2);
          SignerDataActivity.a(SignerDataActivity.this, paramAnonymousCharSequence);
          return;
          if ((SignerDataActivity.e(SignerDataActivity.this).length() >= paramAnonymousCharSequence.length()) || (paramAnonymousCharSequence.length() > 21)) {
            break;
          }
          paramAnonymousInt2 = paramAnonymousInt1;
          if (paramAnonymousInt1 > SignerDataActivity.e(SignerDataActivity.this).length()) {
            paramAnonymousInt2 = SignerDataActivity.e(SignerDataActivity.this).length();
          }
        }
        if (paramAnonymousInt1 + paramAnonymousInt3 > SignerDataActivity.e(SignerDataActivity.this).length()) {
          paramAnonymousInt1 = SignerDataActivity.e(SignerDataActivity.this).length();
        }
        for (;;)
        {
          paramAnonymousInt2 = paramAnonymousInt1;
          break;
          paramAnonymousInt1 += paramAnonymousInt3;
        }
      }
    });
    this.r.addTextChangedListener(new TextWatcher()
    {
      private int b = -1;
      
      public void afterTextChanged(Editable paramAnonymousEditable) {}
      
      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        this.b = paramAnonymousInt1;
      }
      
      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        if (SignerDataActivity.b(SignerDataActivity.this) == 1)
        {
          paramAnonymousCharSequence.toString().length();
          paramAnonymousCharSequence = paramAnonymousCharSequence.toString();
          SignerDataActivity.b(SignerDataActivity.this, ah.formatIDCard(paramAnonymousCharSequence, " "));
          if (((!ae.notNull(SignerDataActivity.g(SignerDataActivity.this))) || (!paramAnonymousCharSequence.equals(SignerDataActivity.g(SignerDataActivity.this)))) && (!ae.isNull(paramAnonymousCharSequence))) {}
        }
        else
        {
          return;
        }
        if (SignerDataActivity.g(SignerDataActivity.this).length() > paramAnonymousCharSequence.length()) {
          paramAnonymousInt2 = SignerDataActivity.g(SignerDataActivity.this).length() - paramAnonymousCharSequence.length() + paramAnonymousInt1 + 1;
        }
        for (;;)
        {
          SignerDataActivity.h(SignerDataActivity.this).setText(SignerDataActivity.g(SignerDataActivity.this));
          SignerDataActivity.h(SignerDataActivity.this).setSelection(paramAnonymousInt2);
          SignerDataActivity.b(SignerDataActivity.this, paramAnonymousCharSequence);
          return;
          if ((SignerDataActivity.g(SignerDataActivity.this).length() >= paramAnonymousCharSequence.length()) || (paramAnonymousCharSequence.length() > 21)) {
            break;
          }
          paramAnonymousInt2 = paramAnonymousInt1;
          if (paramAnonymousInt1 > SignerDataActivity.g(SignerDataActivity.this).length()) {
            paramAnonymousInt2 = SignerDataActivity.g(SignerDataActivity.this).length();
          }
        }
        if (paramAnonymousInt1 + paramAnonymousInt3 > SignerDataActivity.g(SignerDataActivity.this).length()) {
          paramAnonymousInt1 = SignerDataActivity.g(SignerDataActivity.this).length();
        }
        for (;;)
        {
          paramAnonymousInt2 = paramAnonymousInt1;
          break;
          paramAnonymousInt1 += paramAnonymousInt3;
        }
      }
    });
    findViewById(2131692413).setOnClickListener(this);
  }
  
  private void g()
  {
    this.ad = ((TextView)findViewById(2131692424));
    this.b = ((TextView)findViewById(2131692417));
    this.c = ((TextView)findViewById(2131692418));
    this.d = ((TextView)findViewById(2131692419));
    this.e = ((EditText)findViewById(2131697781));
    this.f = ((EditText)findViewById(2131697784));
    this.g = ((EditText)findViewById(2131697791));
    this.r = ((EditText)findViewById(2131697794));
    this.s = ((SimpleDraweeView)findViewById(2131692415));
    this.t = ((SimpleDraweeView)findViewById(2131692421));
    this.u = ((SimpleDraweeView)findViewById(2131692422));
    this.v = ((SimpleDraweeView)findViewById(2131692423));
    ((GenericDraweeHierarchy)this.t.getHierarchy()).setActualImageScaleType(ScalingUtils.ScaleType.FIT_XY);
    ((GenericDraweeHierarchy)this.u.getHierarchy()).setActualImageScaleType(ScalingUtils.ScaleType.FIT_XY);
    ((GenericDraweeHierarchy)this.v.getHierarchy()).setActualImageScaleType(ScalingUtils.ScaleType.FIT_XY);
    ((GenericDraweeHierarchy)this.t.getHierarchy()).setPlaceholderImage(2130837780);
    ((GenericDraweeHierarchy)this.u.getHierarchy()).setPlaceholderImage(2130837780);
    ((GenericDraweeHierarchy)this.v.getHierarchy()).setPlaceholderImage(2130837780);
    this.w = ((LinearLayout)findViewById(2131692420));
    this.y = ((Button)findViewById(2131692425));
    this.H = ((TextView)findViewById(2131697782));
    this.J = ((TextView)findViewById(2131697788));
    this.Q = ((RelativeLayout)findViewById(2131692414));
  }
  
  private void h()
  {
    this.ae = View.inflate(this, 2130905178, null);
    this.af = ((TextView)this.ae.findViewById(2131697639));
    this.ai = ((TextView)this.ae.findViewById(2131697638));
    this.ah = ((TextView)this.ae.findViewById(2131697637));
    this.ag = ((TextView)this.ae.findViewById(2131697634));
    this.ag.setHeight(n.dip2px(this, 48.0F));
    this.af.setOnClickListener(this);
    this.ai.setOnClickListener(this);
    this.ag.setText("您确定退出转签操作吗？");
    this.ah.setVisibility(8);
    this.af.setText("确认");
    this.ai.setText("取消");
    Dialog localDialog;
    if (this.aj == null)
    {
      this.aj = new Dialog(this, 2131427781);
      this.aj.setContentView(this.ae);
      this.aj.setCanceledOnTouchOutside(false);
      localDialog = this.aj;
      if ((localDialog instanceof Dialog)) {
        break label222;
      }
      localDialog.show();
    }
    for (;;)
    {
      this.aj.setOnDismissListener(new DialogInterface.OnDismissListener()
      {
        public void onDismiss(DialogInterface paramAnonymousDialogInterface)
        {
          SignerDataActivity.a(SignerDataActivity.this, null);
          SignerDataActivity.i(SignerDataActivity.this).dismiss();
          SignerDataActivity.a(SignerDataActivity.this, null);
        }
      });
      return;
      label222:
      VdsAgent.showDialog((Dialog)localDialog);
    }
  }
  
  private void i()
  {
    if (this.as == null) {}
    do
    {
      do
      {
        do
        {
          return;
        } while (this.as.getCredits() == null);
        if ((this.as.getCredits().getRealNameStatus() == 1) && (this.as.getCert_type() == 1))
        {
          this.y.setText("去认证");
          this.y.setEnabled(true);
          return;
        }
        if (this.as.getCredits().getRealNameStatus() == 2)
        {
          this.y.setText("认证中");
          this.y.setEnabled(false);
          return;
        }
        if ((this.as.getCredits().getRealNameStatus() == 3) && (this.as.getCert_type() == 1))
        {
          this.y.setText("去认证");
          this.y.setEnabled(true);
          return;
        }
      } while (this.as.getCredits().getRealNameStatus() != 4);
      this.ad.setText("您的证件信息已经成功实名认证！");
    } while (this.aa == 1);
    this.y.setText("确定");
  }
  
  private void j()
  {
    String str2 = VdsAgent.trackEditTextSilent(this.e).toString().trim();
    String str4 = VdsAgent.trackEditTextSilent(this.f).toString().trim();
    String str3 = VdsAgent.trackEditTextSilent(this.g).toString().trim();
    String str1 = VdsAgent.trackEditTextSilent(this.r).toString().trim();
    str2 = str2.replace(" ", "");
    str4 = str4.replace(" ", "");
    str3 = str3.replace(" ", "");
    str1 = str1.replace(" ", "");
    if (ae.isNull(str2))
    {
      if (ae.notNull(this.Y))
      {
        a(Integer.valueOf(1));
        return;
      }
      showToast("请填写姓名！");
      this.e.setEnabled(true);
      return;
    }
    if (str2.length() > 21)
    {
      showToast("姓名不可大于21个字！");
      this.e.setEnabled(true);
      return;
    }
    if (this.I == 0)
    {
      if (ae.notNull(this.Y))
      {
        a(Integer.valueOf(1));
        return;
      }
      showToast("请选择性别！");
      return;
    }
    if ((ae.isNull(str4)) || (!ah.isMobile(str4)))
    {
      if (ae.notNull(this.Y))
      {
        a(Integer.valueOf(1));
        return;
      }
      showToast("请填写正确的电话号码");
      this.f.setEnabled(true);
      return;
    }
    if (this.O == 0)
    {
      if (ae.notNull(this.Y))
      {
        a(Integer.valueOf(1));
        return;
      }
      showToast("请选择证件类型");
      return;
    }
    if (ae.isNull(str3))
    {
      if (ae.notNull(this.Y))
      {
        a(Integer.valueOf(1));
        return;
      }
      showToast("请填写证件号码！");
      return;
    }
    if (!str3.equals(str1))
    {
      if (ae.notNull(this.Y))
      {
        a(Integer.valueOf(1));
        return;
      }
      showToast("两次证件号码必须一致");
      return;
    }
    a(str2, this.I, str4, this.O, str3, this.C, this.D, this.E);
  }
  
  private void k()
  {
    this.x = new k(this, this.aq);
    k localk = this.x;
    View localView = findViewById(2131690092);
    if (!(localk instanceof PopupWindow))
    {
      localk.showAtLocation(localView, 81, 0, 0);
      return;
    }
    VdsAgent.showAtLocation((PopupWindow)localk, localView, 81, 0, 0);
  }
  
  private void l()
  {
    if (!o())
    {
      showToast("无纸化签约证书出现问题,请稍后再试!!!");
      com.ziroom.ziroomcustomer.e.d.errorLog(this, "无纸化错误", ApplicationEx.c.k.GetLastErrInfo());
    }
    do
    {
      return;
      this.S = new com.ziroom.ziroomcustomer.c.a(ApplicationEx.c.getRaConfig().getWebsite(), ApplicationEx.c.getRaConfig().getAccounthash(), this);
    } while (ApplicationEx.c.k != null);
    ApplicationEx.c.k = ClientForAndroid.getInstance(this);
  }
  
  private void m()
  {
    String[] arrayOfString = ApplicationEx.c.k.FilterCert("", "", "", 0, 0);
    if (arrayOfString.length < 1)
    {
      u.d("ikey", "过滤证书失败!!!");
      a(this.N);
      return;
    }
    int k = arrayOfString.length;
    int i = 0;
    for (;;)
    {
      Object localObject1;
      if (i < k)
      {
        localObject1 = arrayOfString[i];
        if (TextUtils.isEmpty(ApplicationEx.c.getUser().getUid())) {}
      }
      else
      {
        try
        {
          Object localObject4 = ApplicationEx.c.k.GetCertAttribute((String)localObject1).Subject.split(",");
          String str = localObject4[0].split("=")[1];
          Object localObject2 = localObject4[1].split("=")[1].replace("\"", "");
          Object localObject3 = localObject4[2].split(":")[1];
          localObject4 = localObject4[5].split("=")[1];
          if ((ApplicationEx.c.getUser().getUid().equals(localObject3)) && (((String)this.N.get("name")).equals(localObject4)) && (d(Integer.parseInt((String)this.N.get("mCerType2"))).equals(localObject2)) && (((String)this.N.get("cerNum")).equals(str)))
          {
            d((String)localObject1);
            u.d("ikey", "同一用户");
          }
          for (;;)
          {
            delRepetition(arrayOfString);
            return;
            u.d("ikey", "不同用户");
            a(this.N);
          }
          int j;
          i += 1;
        }
        catch (Exception localException)
        {
          localObject1 = localException.getCause();
          localObject2 = new StringBuffer();
          while (localObject1 != null)
          {
            localObject3 = ((Throwable)localObject1).getStackTrace();
            ((StringBuffer)localObject2).append("\n");
            ((StringBuffer)localObject2).append(localObject1);
            j = 0;
            while (j < localObject3.length)
            {
              ((StringBuffer)localObject2).append("\nError:" + localObject3[j].toString());
              j += 1;
            }
            localObject1 = ((Throwable)localObject1).getCause();
          }
          com.ziroom.ziroomcustomer.e.d.errorLog(this, localException.getMessage(), ((StringBuffer)localObject2).toString());
        }
      }
    }
  }
  
  private String n()
  {
    Object localObject1 = ApplicationEx.c.k.FilterCert("", "", "", 0, 0);
    if (localObject1.length > 0)
    {
      localObject1 = ApplicationEx.c.k.GetCertAttribute(localObject1[0]).toString().split(",");
      if (localObject1.length > 15)
      {
        Object localObject2 = localObject1[15];
        localObject1 = localObject2;
        if (((String)localObject2).trim().startsWith("ValidTo")) {
          localObject1 = ((String)localObject2).replace("ValidTo=", "");
        }
        return (String)localObject1;
      }
    }
    return null;
  }
  
  private boolean o()
  {
    if (ApplicationEx.c.k == null) {
      ApplicationEx.c.k = ClientForAndroid.getInstance(this);
    }
    int i = ApplicationEx.c.k.SetLicense(ApplicationEx.c.getRaConfig().getLicense());
    u.d("ikey", "SetLicense===" + i + "---" + ApplicationEx.c.getRaConfig().getLicense());
    if (i == 0) {
      return p();
    }
    return false;
  }
  
  private boolean p()
  {
    boolean bool1 = true;
    boolean bool2 = false;
    int i = ApplicationEx.c.k.VerifyUserPIN(Build.MODEL, "111", 5);
    if (i == 3)
    {
      bool1 = bool2;
      if (ApplicationEx.c.k.CSetAdminPIN("", "123", 0) == 0)
      {
        bool1 = bool2;
        if (ApplicationEx.c.k.CInitUserPIN("123", "111") == 0)
        {
          bool1 = bool2;
          if (ApplicationEx.c.k.VerifyUserPIN(Build.MODEL, "111", 5) == 0) {
            bool1 = true;
          }
        }
      }
      return bool1;
    }
    if (i == 1)
    {
      if ((q()) && (this.T))
      {
        this.T = false;
        l();
        return false;
      }
      com.ziroom.ziroomcustomer.e.d.errorLog(this, "初始化pin失败", "操作失败!!" + ApplicationEx.c.k.GetLastErrInfo());
      dismissProgress();
      showToast("无纸化出现异常,请稍后再试!");
      return false;
    }
    if (i == 0) {}
    for (;;)
    {
      return bool1;
      bool1 = false;
    }
  }
  
  private boolean q()
  {
    boolean bool = false;
    String[] arrayOfString = new String[3];
    arrayOfString[0] = "cert9.db";
    arrayOfString[1] = "itrusChina.db";
    arrayOfString[2] = "key4.db";
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      Object localObject = arrayOfString[i];
      localObject = new File(getApplicationContext().getFilesDir().getAbsolutePath() + "/" + (String)localObject);
      if (((File)localObject).exists()) {
        bool = ((File)localObject).delete();
      }
      i += 1;
    }
    return bool;
  }
  
  protected void a(SignedInfo paramSignedInfo)
  {
    if (paramSignedInfo == null) {
      return;
    }
    Object localObject1 = paramSignedInfo.getReal_name();
    if (ae.notNull((String)localObject1))
    {
      this.e.setText((CharSequence)localObject1);
      if (paramSignedInfo.getUser_is_lock() == 1) {
        this.e.setEnabled(false);
      }
      localObject1 = paramSignedInfo.getPhone();
      if (!ae.notNull((String)localObject1)) {
        break label157;
      }
      this.f.setText((CharSequence)localObject1);
      this.f.setEnabled(false);
    }
    int i;
    label157:
    while (!ae.notNull(this.Y))
    {
      i = paramSignedInfo.getCert_type();
      if (i == 0) {
        break label192;
      }
      this.O = i;
      b(i);
      if ((this.O != 0) && (this.O != 2)) {
        break label634;
      }
      if (!ae.notNull(this.Y)) {
        break label184;
      }
      this.J.setEnabled(false);
      a(Integer.valueOf(1));
      return;
      if (!ae.notNull(this.Y)) {
        break;
      }
      a(Integer.valueOf(1));
      this.e.setEnabled(false);
      return;
    }
    this.f.setEnabled(false);
    a(Integer.valueOf(1));
    return;
    label184:
    this.J.setEnabled(true);
    label192:
    localObject1 = paramSignedInfo.getCert_num();
    Object localObject3;
    if ((ae.notNull((String)localObject1)) && (i != 2)) {
      if (i == 1)
      {
        Object localObject2 = localObject1;
        if (((String)localObject1).length() >= 17)
        {
          localObject2 = new StringBuffer();
          ((StringBuffer)localObject2).append(((String)localObject1).substring(0, 6));
          ((StringBuffer)localObject2).append(" ");
          ((StringBuffer)localObject2).append(((String)localObject1).substring(6, 10));
          ((StringBuffer)localObject2).append(" ");
          ((StringBuffer)localObject2).append(((String)localObject1).substring(10, 14));
          ((StringBuffer)localObject2).append(" ");
          ((StringBuffer)localObject2).append(((String)localObject1).substring(14, 18));
          localObject2 = ((StringBuffer)localObject2).toString();
        }
        localObject3 = localObject2;
        if (paramSignedInfo.getUser_is_lock() == 1)
        {
          this.g.setEnabled(false);
          this.r.setEnabled(false);
          localObject3 = localObject2;
        }
        label356:
        this.g.setText((CharSequence)localObject3);
        this.r.setText((CharSequence)localObject3);
        localObject1 = localObject3;
        label377:
        if (ae.isNull((String)localObject1))
        {
          this.g.setText("");
          this.r.setText("");
        }
        localObject1 = paramSignedInfo.getUser_cert1();
        localObject2 = paramSignedInfo.getUser_cert2();
        localObject3 = paramSignedInfo.getUser_cert3();
        if (!ae.notNull((String)localObject1)) {
          break label729;
        }
        this.C = ((String)localObject1);
        label431:
        a(this.C, this.t);
        if (!ae.notNull((String)localObject2)) {
          break label738;
        }
        this.D = ((String)localObject2);
        label457:
        a(this.D, this.u);
        if (!ae.notNull((String)localObject3)) {
          break label747;
        }
        this.E = ((String)localObject3);
        label483:
        a(this.E, this.v);
        if (paramSignedInfo.getCert_is_lock() != 1) {
          break label756;
        }
        b(false);
        label508:
        i = paramSignedInfo.getGender();
        if (i != 1) {
          break label764;
        }
        this.I = i;
        this.H.setText("男");
        this.I = 1;
        if (paramSignedInfo.getUser_is_lock() == 1)
        {
          a(false);
          this.R = true;
        }
      }
    }
    for (;;)
    {
      this.y.setEnabled(true);
      if ((!ae.isNull(paramSignedInfo.getCert_num())) || (!ae.isNull(paramSignedInfo.getReal_name())) || (!ae.isNull(paramSignedInfo.getPhone())) || (paramSignedInfo.getCert_type() != 0) || (paramSignedInfo.getGender() != 0) || (this.O != 0)) {
        break label810;
      }
      if (this.aa == 1) {
        break;
      }
      this.y.setText("提交");
      return;
      label634:
      if (paramSignedInfo.getUser_is_lock() != 1) {
        break label192;
      }
      this.J.setEnabled(false);
      break label192;
      localObject3 = localObject1;
      if (paramSignedInfo.getUser_is_lock() != 1) {
        break label356;
      }
      this.g.setEnabled(false);
      this.r.setEnabled(false);
      localObject3 = localObject1;
      break label356;
      if (!ae.notNull(this.Y)) {
        break label377;
      }
      this.J.setEnabled(false);
      this.g.setEnabled(false);
      this.r.setEnabled(false);
      a(Integer.valueOf(1));
      return;
      label729:
      this.C = "";
      break label431;
      label738:
      this.D = "";
      break label457;
      label747:
      this.E = "";
      break label483;
      label756:
      b(true);
      break label508;
      label764:
      if (i == 2)
      {
        this.I = i;
        this.H.setText("女");
        this.I = 2;
        if (paramSignedInfo.getUser_is_lock() == 1)
        {
          a(false);
          this.R = true;
        }
      }
    }
    label810:
    if ((this.aa != 1) && (this.O != 1)) {
      this.y.setText("确定");
    }
    i();
  }
  
  protected void a(String paramString, int paramInt)
  {
    SimpleDraweeView localSimpleDraweeView = new SimpleDraweeView(this.B);
    if (paramInt == 1)
    {
      localSimpleDraweeView = this.t;
      this.C = paramString;
      this.G.set(0, paramString);
    }
    for (;;)
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("token", com.ziroom.commonlibrary.login.a.getToken(getApplicationContext()));
      localHashMap.put("uuid", paramString + "");
      paramString = g.getPassportSign(localHashMap);
      localSimpleDraweeView.setController(com.freelxl.baselibrary.f.c.frescoController(b(q.O + e.d.d, paramString)));
      return;
      if (paramInt == 2)
      {
        localSimpleDraweeView = this.u;
        this.D = paramString;
        this.G.set(1, paramString);
      }
      else if (paramInt == 3)
      {
        localSimpleDraweeView = this.v;
        this.E = paramString;
        this.G.set(2, paramString);
      }
    }
  }
  
  protected String b(String paramString, Map<String, String> paramMap)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramString.contains("?")) {
      localStringBuilder.append(paramString + "&");
    }
    while ((paramMap != null) && (!paramMap.isEmpty()))
    {
      paramString = paramMap.keySet().iterator();
      while (paramString.hasNext())
      {
        String str = (String)paramString.next();
        localStringBuilder.append(str).append("=").append((String)paramMap.get(str)).append("&");
      }
      localStringBuilder.append(paramString + "?");
    }
    return localStringBuilder.deleteCharAt(localStringBuilder.length() - 1).toString();
  }
  
  public void delRepetition(String[] paramArrayOfString)
  {
    u.d("ikey", "去除证书重复!");
    if (paramArrayOfString.length <= 1) {
      return;
    }
    for (;;)
    {
      int i;
      try
      {
        int j = paramArrayOfString.length;
        i = 0;
        if (i >= j) {
          break;
        }
        String str1 = paramArrayOfString[i];
        if (!TextUtils.isEmpty(ApplicationEx.c.getUser().getUid()))
        {
          Object localObject = ApplicationEx.c.k.GetCertAttribute(str1).Subject.split(",");
          String str2 = localObject[0].split("=")[1];
          String str3 = localObject[1].split("=")[1].replace("\"", "");
          String str4 = localObject[2].split(":")[1];
          localObject = localObject[5].split("=")[1];
          if ((ApplicationEx.c.getUser().getUid().equals(str4)) && (((String)this.N.get("name")).equals(localObject)) && (d(Integer.parseInt((String)this.N.get("mCerType2"))).equals(str3)) && (((String)this.N.get("cerNum")).equals(str2)))
          {
            u.d("ikey", "相同证书");
          }
          else
          {
            ApplicationEx.c.k.DeleteCertBySerialNumber(ApplicationEx.c.k.GetCertSerialNumber(str1));
            u.d("ikey", "删除证书");
          }
        }
      }
      catch (Exception paramArrayOfString)
      {
        return;
      }
      i += 1;
    }
  }
  
  public void getData(String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("token", com.ziroom.commonlibrary.login.a.getToken(getApplicationContext()));
    localHashMap.put("is_newsign", this.aa + "");
    localHashMap.put("cert_type", paramString + "");
    g.getPassportSign(localHashMap);
    com.freelxl.baselibrary.d.a.isLog(true);
    com.freelxl.baselibrary.f.d.e("url", q.O + e.n.p + localHashMap.toString());
    com.freelxl.baselibrary.d.a.get(q.O + e.n.p).tag(this).params(localHashMap).addHeader("Accept", "application/json; version=1").enqueue(new com.ziroom.commonlibrary.a.a(this.B, new com.freelxl.baselibrary.d.f.c())
    {
      public void onSuccess(int paramAnonymousInt, e paramAnonymouse)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymouse);
        u.d("OKHttp", "===" + paramAnonymouse.toString());
        dismissProgress();
        if ("success".equals(paramAnonymouse.get("status")))
        {
          paramAnonymouse = paramAnonymouse.get("data").toString();
          if ((ae.notNull(paramAnonymouse)) && (paramAnonymouse.length() > 5)) {
            SignerDataActivity.a(SignerDataActivity.this, (SignedInfo)com.alibaba.fastjson.a.parseObject(paramAnonymouse, SignedInfo.class));
          }
          for (;;)
          {
            SignerDataActivity.this.a(SignerDataActivity.a(SignerDataActivity.this));
            return;
            SignerDataActivity.a(SignerDataActivity.this, new SignedInfo());
          }
        }
        SignerDataActivity.this.showToast(paramAnonymouse.get("error_message") + "");
      }
    });
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    Routers.open(this, "ziroomCustomer://zrCreditModule/zmAuthenticationResult?requestCode=" + paramInt1 + "&resultCode=" + paramInt2);
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
      if ((paramInt1 == 3) && (paramIntent != null))
      {
        paramIntent = (ArrayList)paramIntent.getSerializableExtra("pics");
        if (paramIntent != null)
        {
          paramIntent = paramIntent.iterator();
          while (paramIntent.hasNext())
          {
            String str = (String)paramIntent.next();
            if (this.C.equals(str))
            {
              this.C = "";
              this.t.setController(com.freelxl.baselibrary.f.c.frescoController(""));
            }
            if (this.D.equals(str))
            {
              this.D = "";
              this.u.setController(com.freelxl.baselibrary.f.c.frescoController(""));
            }
            if (this.E.equals(str))
            {
              this.E = "";
              this.v.setController(com.freelxl.baselibrary.f.c.frescoController(""));
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
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              if (ae.isNull(this.C))
              {
                this.F = 1;
                k();
                return;
              }
              c(0);
              return;
              if (ae.isNull(this.D))
              {
                this.F = 2;
                k();
                return;
              }
              c(1);
              return;
              if (ae.notNull(this.Y))
              {
                h();
                return;
              }
              finish();
              return;
              if (ae.isNull(this.E))
              {
                this.F = 3;
                k();
                return;
              }
              c(2);
              return;
              j();
              return;
              a(0, this.ab);
              return;
              a(1, this.ac);
              return;
              if (!"联系管家".equals(((TextView)paramView).getText())) {
                break;
              }
            } while (ApplicationEx.c.getContracts() == null);
            ah.callPhone(this, ((Contract)ApplicationEx.c.getContracts().get(0)).getHire_commissioner_phone());
            this.ap.dismiss();
            return;
          } while (!"确认".equals(((TextView)paramView).getText()));
          finish();
          return;
          if (!"稍后再说".equals(((TextView)paramView).getText())) {
            break;
          }
        } while (this.ap == null);
        this.ap.dismiss();
        return;
        if (!"取消".equals(((TextView)paramView).getText())) {
          break;
        }
      } while (this.aj == null);
      this.aj.dismiss();
      return;
    } while (!"知道了".equals(((TextView)paramView).getText()));
    if (this.aj != null) {
      this.aj.dismiss();
    }
    finish();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903499);
    this.B = this;
    ApplicationEx.c.addActivity(this);
    registerReceiver(this.ar, new IntentFilter("com.ziroom.ziroomcustomer.zmcertresult"));
    if (!((ApplicationEx)getApplication()).isLoginState())
    {
      com.ziroom.commonlibrary.login.a.startLoginActivity(this);
      finish();
    }
    g();
    f();
    e();
    b();
    a();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    unregisterReceiver(this.ar);
    ApplicationEx.c.removeActivity(this);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return true;
      if (ae.notNull(this.Y)) {
        h();
      } else {
        finish();
      }
    }
  }
  
  public void selectPhoto()
  {
    Intent localIntent = new Intent("android.intent.action.GET_CONTENT");
    localIntent.addCategory("android.intent.category.OPENABLE");
    localIntent.setType("image/*");
    startActivityForResult(Intent.createChooser(localIntent, "选择图片"), 2);
  }
  
  public void takePhoto()
  {
    Intent localIntent = new Intent("android.media.action.IMAGE_CAPTURE");
    this.z = (DateFormat.format("yyyyMMddhhmmss", Calendar.getInstance(Locale.CHINA)) + ".jpg");
    File localFile = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/images/");
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    localIntent.putExtra("output", Uri.fromFile(new File(localFile, this.z)));
    startActivityForResult(localIntent, 1);
  }
  
  public void uploadPhoto()
  {
    if (ae.isNull(this.z)) {}
    File localFile;
    do
    {
      return;
      localFile = new File(h.a + "/" + this.z);
      Bitmap localBitmap = h.tryGetBitmap(this.z, 1280, 500000);
      h.saveBitmap(localBitmap, this.z, 100);
      if ((localBitmap != null) && (!localBitmap.isRecycled())) {
        localBitmap.recycle();
      }
    } while (this.z == null);
    j.headSignerImgUpload(this, com.ziroom.commonlibrary.login.a.getToken(this), localFile, new f(this.B, new o())
    {
      public void onSuccess(int paramAnonymousInt, e paramAnonymouse)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymouse);
        paramAnonymouse = com.alibaba.fastjson.a.parseObject(paramAnonymouse.toString());
        SignerDataActivity.d(SignerDataActivity.this, (String)paramAnonymouse.get("uuid"));
        SignerDataActivity.this.a(SignerDataActivity.w(SignerDataActivity.this), SignerDataActivity.x(SignerDataActivity.this));
      }
    });
  }
  
  public Map<String, Object> urlSplit(String paramString)
  {
    StringBuffer localStringBuffer1 = new StringBuffer();
    StringBuffer localStringBuffer2 = new StringBuffer();
    HashMap localHashMap = new HashMap();
    int i = 0;
    if (i < paramString.length())
    {
      int j;
      if (paramString.substring(i, i + 1).equals("="))
      {
        j = i + 1;
        if (j >= paramString.length()) {
          break label215;
        }
        if ((paramString.substring(j, j + 1).equals("&")) || (j == paramString.length() - 1))
        {
          localHashMap.put(localStringBuffer1.toString(), localStringBuffer2);
          localStringBuffer1 = new StringBuffer("");
          localStringBuffer2 = new StringBuffer("");
        }
      }
      for (;;)
      {
        i = j + 1;
        break;
        if (j == paramString.length() - 2)
        {
          localStringBuffer2.append(paramString.substring(j, j + 1));
          localStringBuffer2.append(paramString.substring(j + 1, j + 2));
        }
        for (;;)
        {
          j += 1;
          break;
          localStringBuffer2.append(paramString.substring(j, j + 1));
        }
        localStringBuffer1.append(paramString.substring(i, i + 1));
        label215:
        j = i;
      }
    }
    return localHashMap;
  }
  
  private class a
    extends AsyncTask<Bundle, Integer, String>
  {
    private a() {}
    
    protected String a(Bundle... paramVarArgs)
    {
      Object localObject = paramVarArgs[0];
      paramVarArgs = ((Bundle)localObject).getString("CSR");
      String str1 = ((Bundle)localObject).getString("CHALLENGE");
      String str2 = ((Bundle)localObject).getString("PassPort");
      localObject = (com.itrus.raapi.implement.UserInfo)((Bundle)localObject).getSerializable("UserInfo");
      return SignerDataActivity.G(SignerDataActivity.this).enrollCert(paramVarArgs, (com.itrus.raapi.implement.UserInfo)localObject, str2, str1, "1");
    }
    
    protected void a(String paramString)
    {
      if (TextUtils.isEmpty(paramString))
      {
        u.d("ikey", "证书申请失败");
        com.ziroom.ziroomcustomer.e.d.errorLog(SignerDataActivity.this, "证书申请失败", "操作失败!!" + paramString);
      }
      for (;;)
      {
        SignerDataActivity.this.dismissProgress();
        super.onPostExecute(paramString);
        return;
        if ("$OKOKOK$".equals(paramString.substring(0, "$OKOKOK$".length())))
        {
          if (ApplicationEx.c.k.ImportCert("", paramString.substring("$OKOKOK$".length() - 1)) == 0)
          {
            u.d("ikey", "证书导入成功!!!");
            if (ApplicationEx.c.k.FilterCert("", "", "", 0, 0).length < 1)
            {
              u.d("ikey", "过滤证书失败!!!");
            }
            else
            {
              Intent localIntent;
              if (SignerDataActivity.B(SignerDataActivity.this))
              {
                if (ae.notNull(SignerDataActivity.C(SignerDataActivity.this)))
                {
                  if (SignerDataActivity.a(SignerDataActivity.this).getCert_type() == 1)
                  {
                    localIntent = new Intent(SignerDataActivity.this, BankcardDetailActivity.class);
                    localIntent.putExtra("name", SignerDataActivity.a(SignerDataActivity.this).getReal_name());
                    SignerDataActivity.this.startActivity(localIntent);
                    SignerDataActivity.this.finish();
                  }
                  else
                  {
                    SignerDataActivity.a(SignerDataActivity.this, Integer.valueOf(2));
                  }
                }
                else {
                  SignerDataActivity.this.finish();
                }
              }
              else if (ae.notNull(SignerDataActivity.D(SignerDataActivity.this)))
              {
                localIntent = new Intent(SignerDataActivity.this, TurnSignTermsActivity.class);
                SignerDataActivity.this.startActivity(localIntent);
              }
              else
              {
                localIntent = new Intent(SignerDataActivity.this, SignerAptitudeActivity.class);
                localIntent.putExtra("detail", SignerDataActivity.m(SignerDataActivity.this));
                SignerDataActivity.this.startActivity(localIntent);
              }
            }
          }
          else
          {
            com.ziroom.ziroomcustomer.e.d.errorLog(SignerDataActivity.this, "证书导入失败!!!", "证书导入失败!!!" + ApplicationEx.c.k.GetLastErrInfo());
          }
        }
        else
        {
          u.d("ikey", "证书申请失败!!!\n" + paramString);
          com.ziroom.ziroomcustomer.e.d.errorLog(SignerDataActivity.this, "证书申请失败!!!", "证书申请失败!!!\n" + paramString + "\n" + ApplicationEx.c.k.GetLastErrInfo());
          SignerDataActivity.this.showToast("无纸化签约证书出现问题,请稍后再试!!!");
        }
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/signed/SignerDataActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */