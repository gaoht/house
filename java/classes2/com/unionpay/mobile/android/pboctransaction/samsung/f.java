package com.unionpay.mobile.android.pboctransaction.samsung;

import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import com.unionpay.mobile.android.pboctransaction.d;
import com.unionpay.mobile.android.utils.j;
import com.unionpay.tsmservice.UPTsmAddon;
import com.unionpay.tsmservice.UPTsmAddon.UPTsmConnectionListener;
import com.unionpay.tsmservice.data.Amount;
import com.unionpay.tsmservice.request.CheckSSamsungPayRequestParams;
import com.unionpay.tsmservice.request.CloseChannelRequestParams;
import com.unionpay.tsmservice.request.GetCardInfoBySpayRequestParams;
import com.unionpay.tsmservice.request.GetSeAppListRequestParams;
import com.unionpay.tsmservice.request.InitRequestParams;
import com.unionpay.tsmservice.request.OpenChannelRequestParams;
import com.unionpay.tsmservice.request.SendApduRequestParams;
import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.RSAPrivateKeySpec;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public final class f
  implements com.unionpay.mobile.android.pboctransaction.c
{
  private final Handler A = new Handler(this.z);
  private InitRequestParams B;
  private SendApduRequestParams C;
  private final UPTsmAddon.UPTsmConnectionListener D = new h(this);
  String a = "19999741583305435775450371903957622252895007857586703985696530069777024392884287211670048223494223356836139331264745305488035196420545843046674853984852305228918004888414759300445308845681087472809487791392726663269247999482633231304479943902981311338709709401000108625221857486530967716878328228310703650408575058288784573884262229674701501842066793928002725038356122707147929560460157457327696696471785787505023643000687928051333648369477362945785046976181683285277919023274376124429148429078602516462345014971452220809120399264066736558357572250447243744965533695780751271768398207631002867947152625578881506566297";
  String b = "65537";
  String c = "5929703506495688276130676968213384164609348882017291684789802337394713840702726472221198819456433069055388915357817202968369194525956730949539025096963015440180443916974948318765778051794088998339276397676916425744003507605582286608745438301704836361482343765671805403004194772735755889141443700570750608527755694790475628670051863813384800013641474007746161600969180035295709344887092512089121125289090881005234379649440422346798246278284328310221953743757037875834557694749810951089453346522229122216198442376081589767583019062954875861469699069474707285206935898628020341168773624455554331118138151051364372906861";
  String d = "UnionPay";
  String e = "";
  boolean f = false;
  private final String g = "A0000003334355502D4D4F42494C45";
  private final int h = 10000;
  private Context i;
  private com.unionpay.mobile.android.pboctransaction.b j;
  private a k;
  private UPTsmAddon l;
  private Handler m = null;
  private int n = 0;
  private final int o = 8;
  private boolean p = false;
  private String q = "-1";
  private String r = "";
  private boolean s = false;
  private String t = null;
  private boolean u = false;
  private String v = "-1";
  private String w = "-1";
  private String x = "";
  private String y = "";
  private final Handler.Callback z = new g(this);
  
  public f(a parama)
  {
    this.k = parama;
  }
  
  private void a(String paramString1, String paramString2)
  {
    this.C = new SendApduRequestParams();
    this.C.setChannel(paramString2);
    this.C.setHexApdu(paramString1);
    if (this.f) {
      this.C.setReserve(g());
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.j != null)
    {
      if (paramBoolean) {
        this.j.a();
      }
    }
    else {
      return;
    }
    this.j.b();
  }
  
  private void f()
  {
    if (this.B == null)
    {
      this.B = new InitRequestParams();
      if (this.f)
      {
        this.B.setSignature(g());
        this.B.setReserve(g());
      }
    }
    try
    {
      int i1 = this.l.init(this.B, new e(1000, this.A));
      if (i1 != 0) {
        this.A.sendMessage(Message.obtain(this.A, 1, 1000, 0, ""));
      }
      for (;;)
      {
        j.c("uppay", "ret = " + i1);
        return;
        this.A.sendMessageDelayed(Message.obtain(this.A, 4, 1000, 0, ""), 20000L);
      }
      return;
    }
    catch (RemoteException localRemoteException)
    {
      localRemoteException.printStackTrace();
    }
  }
  
  private String g()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("signature", this.e);
      return localJSONObject.toString();
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  public final String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    this.r = "";
    do
    {
      try
      {
        OpenChannelRequestParams localOpenChannelRequestParams = new OpenChannelRequestParams();
        localOpenChannelRequestParams.setAppAID(paramString);
        if (this.f) {
          localOpenChannelRequestParams.setReserve(g());
        }
        if (this.l.openChannel(localOpenChannelRequestParams, new e(1011, this.A)) != 0) {
          this.A.sendMessage(Message.obtain(this.A, 1, 1011, 0, ""));
        }
      }
      catch (RemoteException localRemoteException)
      {
        for (;;)
        {
          localRemoteException.printStackTrace();
          continue;
          this.w = this.q;
        }
      }
    } while (!this.p);
    if ("A0000003334355502D4D4F42494C45".equals(paramString))
    {
      this.v = this.q;
      this.p = false;
      return this.r;
    }
  }
  
  public final ArrayList<com.unionpay.mobile.android.model.c> a(d paramd)
  {
    if (this.l != null) {}
    for (;;)
    {
      try
      {
        if ((!com.unionpay.mobile.android.model.b.aB) || (!com.unionpay.mobile.android.model.b.aA) || (!com.unionpay.mobile.android.model.b.bn)) {
          continue;
        }
        paramd = new GetCardInfoBySpayRequestParams();
        Amount localAmount = new Amount();
        localAmount.setProductPrice(this.x);
        String str = com.unionpay.mobile.android.pboctransaction.e.e(this.y);
        if (!TextUtils.isEmpty(str)) {
          localAmount.setCurrencyType(str);
        }
        paramd.setAmount(localAmount);
        if (this.f) {
          paramd.setReserve(g());
        }
        int i1 = this.l.getCardInfoBySamsungPay(paramd, new e(1015, this.A));
        if (i1 == 0) {
          continue;
        }
        this.A.sendMessage(Message.obtain(this.A, 1, 1015, 0, ""));
        j.c("uppay", "readList: " + i1);
      }
      catch (RemoteException paramd)
      {
        paramd.printStackTrace();
        continue;
        paramd = new GetSeAppListRequestParams();
        if (!this.f) {
          continue;
        }
        paramd.setReserve(g());
        if (this.l.getSEAppList(paramd, new e(1014, this.A)) == 0) {
          continue;
        }
        this.A.sendMessage(Message.obtain(this.A, 1, 1014, 0, ""));
        continue;
      }
      catch (Exception paramd)
      {
        paramd.printStackTrace();
        continue;
        this.A.sendMessageDelayed(Message.obtain(this.A, 4, 1014, 0, ""), 20000L);
        continue;
      }
      j.c("uppay", "readList");
      return null;
      this.A.sendMessageDelayed(Message.obtain(this.A, 4, 1015, 0, ""), 20000L);
    }
  }
  
  public final void a()
  {
    if (this.l != null)
    {
      this.l.removeConnectionListener(this.D);
      this.l.unbind();
    }
  }
  
  public final void a(Handler paramHandler)
  {
    this.m = paramHandler;
  }
  
  public final void a(com.unionpay.mobile.android.pboctransaction.b paramb, Context paramContext)
  {
    this.j = paramb;
    this.i = paramContext;
    try
    {
      paramb = this.a;
      String str = this.c;
      paramb = new RSAPrivateKeySpec(new BigInteger(paramb), new BigInteger(str));
      this.e = a.a(KeyFactory.getInstance("RSA").generatePrivate(paramb), this.d);
      if (!"com.unionpay.uppay".equals(com.unionpay.mobile.android.utils.e.b(this.i)))
      {
        bool = true;
        this.f = bool;
        this.l = UPTsmAddon.getInstance(paramContext);
        this.l.addConnectionListener(this.D);
        j.c("uppay-spay", "type se  bind service");
        if ((this.l == null) || (this.l.isConnected())) {
          break label173;
        }
        j.c("uppay", "bind service");
        this.l.bind();
      }
    }
    catch (NoSuchAlgorithmException paramb)
    {
      for (;;)
      {
        paramb.printStackTrace();
      }
    }
    catch (InvalidKeySpecException paramb)
    {
      label173:
      do
      {
        for (;;)
        {
          paramb.printStackTrace();
          continue;
          boolean bool = false;
        }
      } while ((this.l == null) || (!this.l.isConnected()));
      j.c("uppay", "tem service already connected");
      f();
    }
  }
  
  public final byte[] a(byte[] paramArrayOfByte, int paramInt)
  {
    Object localObject = null;
    this.t = null;
    j.a("uppay", "--->" + com.unionpay.mobile.android.pboctransaction.e.a(paramArrayOfByte));
    if (paramInt == 0) {
      a(com.unionpay.mobile.android.pboctransaction.e.a(paramArrayOfByte), this.w);
    }
    try
    {
      for (;;)
      {
        if (this.l.sendApdu(this.C, new e(1012, this.A)) != 0) {
          this.A.sendMessage(Message.obtain(this.A, 1, 1012, 0, ""));
        }
        this.A.sendMessageDelayed(Message.obtain(this.A, 3), 10000L);
        while ((this.t == null) && (!this.s)) {}
        j.a("uppay", "mApduResult: " + this.t + ",mApduReturn:" + this.s);
        paramArrayOfByte = (byte[])localObject;
        if (this.t != null)
        {
          paramArrayOfByte = com.unionpay.mobile.android.pboctransaction.e.a(this.t);
          j.a("uppay", "ret1 <---" + paramArrayOfByte);
        }
        j.a("uppay", "<---" + this.t);
        this.s = false;
        j.a("uppay", "ret2 <---" + paramArrayOfByte);
        return paramArrayOfByte;
        if (paramInt == 1) {
          a(com.unionpay.mobile.android.pboctransaction.e.a(paramArrayOfByte), this.v);
        }
      }
    }
    catch (RemoteException paramArrayOfByte)
    {
      for (;;)
      {
        paramArrayOfByte.printStackTrace();
      }
    }
  }
  
  public final void b() {}
  
  public final void b(String paramString)
  {
    this.x = paramString;
  }
  
  public final void c()
  {
    if ((this.v != null) && (!"-1".equals(this.v)))
    {
      do
      {
        try
        {
          localCloseChannelRequestParams = new CloseChannelRequestParams();
          localCloseChannelRequestParams.setChannel(this.v);
          if (this.f) {
            localCloseChannelRequestParams.setReserve(g());
          }
          if (this.l.closeChannel(localCloseChannelRequestParams, new e(1013, this.A)) != 0) {
            this.A.sendMessage(Message.obtain(this.A, 1, 1013, 0, ""));
          }
        }
        catch (RemoteException localRemoteException1)
        {
          for (;;)
          {
            CloseChannelRequestParams localCloseChannelRequestParams;
            localRemoteException1.printStackTrace();
          }
        }
      } while (!this.u);
      this.v = "-1";
      this.u = false;
    }
    if ((this.w != null) && (!"-1".equals(this.w)))
    {
      do
      {
        try
        {
          localCloseChannelRequestParams = new CloseChannelRequestParams();
          localCloseChannelRequestParams.setChannel(this.w);
          if (this.f) {
            localCloseChannelRequestParams.setReserve(g());
          }
          if (this.l.closeChannel(localCloseChannelRequestParams, new e(1013, this.A)) != 0) {
            this.A.sendMessage(Message.obtain(this.A, 1, 1013, 0, ""));
          }
        }
        catch (RemoteException localRemoteException2)
        {
          for (;;)
          {
            localRemoteException2.printStackTrace();
          }
        }
      } while (!this.u);
      this.w = "-1";
      this.u = false;
    }
  }
  
  public final void c(String paramString)
  {
    this.y = paramString;
  }
  
  public final void d() {}
  
  public final boolean e()
  {
    CheckSSamsungPayRequestParams localCheckSSamsungPayRequestParams = new CheckSSamsungPayRequestParams();
    if (this.f) {
      localCheckSSamsungPayRequestParams.setReserve(g());
    }
    try
    {
      j.c("uppay", "getSpaySupported");
      int i1 = this.l.checkSSamsungPay(localCheckSSamsungPayRequestParams, new e(1016, this.A));
      j.c("uppay", "retcheck = " + i1);
      if (i1 != 0)
      {
        j.c("uppay", "getSpaySupported  retCheck != 0");
        return false;
      }
      this.A.sendMessageDelayed(Message.obtain(this.A, 4, 1016, 0, ""), 20000L);
      return true;
    }
    catch (RemoteException localRemoteException)
    {
      j.c("uppay", "getSpaySupported  RemoteException");
    }
    return false;
  }
  
  public static abstract interface a
  {
    public abstract void a(boolean paramBoolean);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/mobile/android/pboctransaction/samsung/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */