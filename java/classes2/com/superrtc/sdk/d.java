package com.superrtc.sdk;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.hardware.Camera;
import android.opengl.EGLContext;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import android.view.View;
import com.superrtc.call.DataChannel;
import com.superrtc.call.Logging;
import com.superrtc.call.Logging.a;
import com.superrtc.call.Logging.b;
import com.superrtc.call.MediaStream;
import com.superrtc.call.MediaStreamTrack.a;
import com.superrtc.call.PeerConnection;
import com.superrtc.call.PeerConnection.a;
import com.superrtc.call.PeerConnection.c;
import com.superrtc.call.PeerConnection.d;
import com.superrtc.call.PeerConnection.e;
import com.superrtc.call.PeerConnection.f;
import com.superrtc.call.PeerConnection.h;
import com.superrtc.call.PeerConnection.i;
import com.superrtc.call.PeerConnection.j;
import com.superrtc.call.PeerConnection.k;
import com.superrtc.call.PeerConnection.l;
import com.superrtc.call.PeerConnectionFactory;
import com.superrtc.call.PeerConnectionFactory.a;
import com.superrtc.call.VideoRenderer;
import com.superrtc.call.VideoRenderer.a;
import com.superrtc.call.VideoSource;
import com.superrtc.call.VideoTrack;
import com.superrtc.call.e.a;
import com.superrtc.call.l;
import com.superrtc.call.m;
import com.superrtc.call.n;
import com.superrtc.call.n.a;
import com.superrtc.call.o.c;
import com.superrtc.call.p;
import com.superrtc.call.q;
import com.superrtc.call.q.a;
import com.superrtc.call.r;
import com.superrtc.call.s;
import com.superrtc.call.s.a;
import com.superrtc.call.w;
import com.superrtc.call.w.c;
import com.superrtc.call.w.d;
import com.superrtc.call.w.e;
import com.superrtc.call.y;
import com.superrtc.mediamanager.i;
import java.io.File;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

@SuppressLint({"DefaultLocale"})
public class d
{
  private static Logging.a C = Logging.a.d;
  private static boolean D = false;
  private static int E = 0;
  private static int F = 80;
  private static int G = 80;
  private static boolean H = false;
  private static boolean I = false;
  private static int X = -1;
  private static boolean Y = true;
  private static Context a;
  private static String ae;
  private static d aj = new d()
  {
    public void onLog(int paramAnonymousInt, String paramAnonymousString)
    {
      Log.i("RtcConn", paramAnonymousString);
    }
  };
  private static e ak;
  private static com.superrtc.a.f b;
  private static PeerConnectionFactory c;
  public static int r = 6;
  public static d s = aj;
  private boolean A = false;
  private boolean B = false;
  private e.a J = null;
  private String K = "disconn";
  private boolean L = false;
  private c M = new c();
  private c N = new c();
  private PeerConnection.c O;
  private boolean P = false;
  private String Q = "VP8";
  private String R = "OPUS";
  private String S = "VP8";
  private String T = "OPUS";
  private int U = 0;
  private boolean V = false;
  private boolean W = false;
  private k Z;
  private int aA = 0;
  private int aB = 0;
  private int aC = 0;
  private int aD = 0;
  private int aE = 0;
  private int aF = 0;
  private int aG = 0;
  private int aH = 0;
  private int aI = 0;
  private int aJ = 0;
  private int aK = 0;
  private final f aL = new f(null);
  private PeerConnection aM;
  private VideoSource aN;
  private com.superrtc.call.a aO;
  private boolean aP = true;
  private boolean aQ = true;
  private boolean aR = false;
  private boolean aS = false;
  private String aT = null;
  private String aU = ae;
  private int aV = 0;
  private int aW = 0;
  private int aX = 15;
  private int aY = 0;
  private int aZ = 0;
  private boolean aa;
  private m ab;
  private int ac = 0;
  private boolean ad = false;
  private long af = 0L;
  private LinkedList<q> ag = new LinkedList();
  private List<l> ah = new ArrayList();
  private final com.superrtc.a.e ai = new com.superrtc.a.e();
  private b al = new b();
  private b am = new b();
  private b an = new b();
  private b ao = new b();
  private o.c ap = o.c.a;
  private o.c aq = o.c.a;
  private int ar = 0;
  private int as = 0;
  private int at = 0;
  private int au = 0;
  private int av = 0;
  private int aw = 0;
  private int ax = 0;
  private int ay = 0;
  private int az = 0;
  private boolean bA = true;
  private boolean bB = true;
  private boolean bC = true;
  private boolean bD = true;
  private com.superrtc.a.a bE = null;
  private boolean bF = false;
  private boolean ba = true;
  private boolean bb = true;
  private String bc;
  private int bd = 24;
  private int be = 24;
  private boolean bf = false;
  private boolean bg = true;
  private Timer bh;
  private VideoRenderer.a bi;
  private VideoRenderer.a bj;
  private VideoRenderer bk;
  private VideoRenderer bl;
  private List<PeerConnection.e> bm = new ArrayList();
  private n bn;
  private n bo;
  private n bp;
  private n bq;
  private boolean br;
  private q bs;
  private MediaStream bt;
  private int bu;
  private w bv;
  private boolean bw;
  private VideoTrack bx;
  private com.superrtc.call.b by;
  private VideoTrack bz;
  private boolean d = false;
  public String e = "RTC0";
  public String f = "";
  public g g;
  public g h;
  y i;
  y j;
  j k;
  j l;
  f m = new f("ARDAMS");
  c n = new c(null);
  i o = new i(null);
  MediaStream p;
  boolean q = false;
  PeerConnectionFactory.a t = null;
  ParcelFileDescriptor u = null;
  public View v = null;
  private boolean w = true;
  private b x;
  private boolean y = false;
  private g z;
  
  public d(final String paramString)
  {
    this.e = paramString;
    this.P = false;
    s.onLog(r, paramString + "::: [rapi]++ create RtcConnection");
    this.bh = new Timer();
    setStatsEnable(true);
    b.execute(new Runnable()
    {
      public void run()
      {
        d.s.onLog(d.r, "create RtcConnection start -0- name: " + paramString);
        if (d.a(d.this))
        {
          d.s.onLog(d.r, paramString + "::: skip createConnectionFactory because of conn is already hangup!");
          return;
        }
        d.s.onLog(d.r, paramString + "::: [rapi]-- create RtcConnection");
      }
    });
  }
  
  static int a(int paramInt1, int paramInt2)
  {
    if (((paramInt1 == 320) && (paramInt2 == 240)) || ((paramInt1 == 240) && (paramInt2 == 320))) {}
    do
    {
      return 300;
      if (((paramInt1 == 640) && (paramInt2 == 480)) || ((paramInt1 == 480) && (paramInt2 == 640))) {
        return 800;
      }
      if (((paramInt1 == 1280) && (paramInt2 == 720)) || ((paramInt1 == 720) && (paramInt2 == 1280))) {
        return 2500;
      }
    } while (((paramInt1 != 1920) || (paramInt2 != 1080)) && ((paramInt1 != 1080) || (paramInt2 != 1920)));
    return 10000;
  }
  
  private static q a(l paraml)
  {
    if ((paraml.a.equalsIgnoreCase(l.a())) || (paraml.a.equalsIgnoreCase(l.b())) || (paraml.a.equalsIgnoreCase(l.c()))) {
      return new q(q.a.valueOf(paraml.a.toUpperCase()), paraml.d);
    }
    return null;
  }
  
  private static String a(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString1.equals(""))) {
      return paramString2;
    }
    return paramString1 + "," + paramString2;
  }
  
  private void a(q paramq)
  {
    synchronized (this.ag)
    {
      s.onLog(r, this.e + "::: add pending sdp");
      this.ag.addLast(paramq);
      return;
    }
  }
  
  private void a(String paramString)
  {
    int i1 = 0;
    boolean bool = true;
    for (;;)
    {
      try
      {
        s.onLog(r, this.e + "::: start setConfigure: config=" + paramString);
        paramString = new JSONObject(paramString);
        Object localObject;
        if (paramString.has("capVideo"))
        {
          localObject = paramString.get("capVideo");
          if ((Boolean.TRUE.equals(localObject)) || (Integer.valueOf(1).equals(localObject))) {
            this.aP = true;
          }
        }
        else
        {
          if (paramString.has("recvVideo"))
          {
            localObject = paramString.get("recvVideo");
            if ((!Boolean.TRUE.equals(localObject)) && (!Integer.valueOf(1).equals(localObject))) {
              break label919;
            }
            this.aQ = true;
          }
          if (paramString.has("customVideoSrc"))
          {
            if (paramString.optInt("customVideoSrc") == 0) {
              bool = false;
            }
            this.aa = bool;
            this.aP = true;
          }
          if (paramString.has("prefVC")) {
            this.aU = paramString.getString("prefVC");
          }
          if (paramString.has("width"))
          {
            this.aV = paramString.getInt("width");
            if ((this.L) && (paramString.has("heigth")))
            {
              this.aW = paramString.getInt("heigth");
              if ((this.aV != 0) && (this.aW != 0)) {
                changeVideoResolution(this.aV, this.aW);
              }
            }
          }
          if (paramString.has("heigth")) {
            this.aW = paramString.getInt("heigth");
          }
          if (paramString.has("videofps")) {
            this.aX = paramString.getInt("videofps");
          }
          if (paramString.has("maxVKbps"))
          {
            this.aY = paramString.getInt("maxVKbps");
            if (this.aY < 0) {
              this.aY = 0;
            }
          }
          if (paramString.has("relayVKbps")) {
            this.aZ = paramString.getInt("relayVKbps");
          }
          if (paramString.has("capAudio"))
          {
            localObject = paramString.get("capAudio");
            if ((!Boolean.TRUE.equals(localObject)) && (!Integer.valueOf(1).equals(localObject))) {
              break label927;
            }
            this.ba = true;
          }
          if (paramString.has("recvAudio"))
          {
            localObject = paramString.get("recvAudio");
            if ((!Boolean.TRUE.equals(localObject)) && (!Integer.valueOf(1).equals(localObject))) {
              break label935;
            }
            this.bb = true;
          }
          if (paramString.has("prefAC")) {
            this.bc = paramString.getString("prefAC");
          }
          if (paramString.has("maxAKbps")) {
            this.bd = paramString.getInt("maxAKbps");
          }
          if (paramString.has("relayAKbps")) {
            this.be = paramString.getInt("relayAKbps");
          }
          if (paramString.has("disablePranswer"))
          {
            localObject = paramString.get("disablePranswer");
            if ((!Boolean.TRUE.equals(localObject)) && (!Integer.valueOf(1).equals(localObject))) {
              break label943;
            }
            this.aR = true;
          }
          if (paramString.has("loopback"))
          {
            localObject = paramString.get("loopback");
            if ((!Boolean.TRUE.equals(localObject)) && (!Integer.valueOf(1).equals(localObject))) {
              break label951;
            }
            this.aS = true;
          }
          if (paramString.has("aecdumpFile")) {
            this.aT = paramString.getString("aecdumpFile");
          }
          if (paramString.has("relayOnly"))
          {
            localObject = paramString.get("relayOnly");
            if ((!Boolean.TRUE.equals(localObject)) && (!Integer.valueOf(1).equals(localObject))) {
              break label959;
            }
            this.bf = true;
          }
          if (paramString.has("hdencoder"))
          {
            localObject = paramString.get("hdencoder");
            if ((!Boolean.TRUE.equals(localObject)) && (!Integer.valueOf(1).equals(localObject))) {
              break label967;
            }
            this.V = true;
          }
          if (paramString.has("hddecoder"))
          {
            localObject = paramString.get("hddecoder");
            if ((!Boolean.TRUE.equals(localObject)) && (!Integer.valueOf(1).equals(localObject))) {
              break label975;
            }
            this.W = true;
          }
          paramString = paramString.optJSONArray("iceServers");
          if (paramString == null) {
            break;
          }
          this.bm.clear();
          if (i1 >= paramString.length()) {
            break;
          }
          localObject = paramString.getJSONObject(i1);
          this.bm.add(new PeerConnection.e(((JSONObject)localObject).optString("url"), ((JSONObject)localObject).optString("username"), ((JSONObject)localObject).optString("credential")));
          i1 += 1;
          continue;
        }
        this.w = false;
        this.aP = false;
        continue;
        this.aQ = false;
      }
      catch (JSONException paramString)
      {
        s.onLog(r, this.e + "::: setConfigure failed");
        paramString.printStackTrace();
        return;
      }
      label919:
      continue;
      label927:
      this.ba = false;
      continue;
      label935:
      this.bb = false;
      continue;
      label943:
      this.aR = false;
      continue;
      label951:
      this.aS = false;
      continue;
      label959:
      this.bf = false;
      continue;
      label967:
      this.V = false;
      continue;
      label975:
      this.W = false;
    }
    s.onLog(r, this.e + "::: finish setConfigure");
  }
  
  private l b(l paraml)
  {
    if (paraml.a.equalsIgnoreCase("candidate")) {
      return new l("audio", paraml.b, paraml.c);
    }
    return null;
  }
  
  private static String b(String paramString1, String paramString2, boolean paramBoolean)
  {
    int i4 = 0;
    String[] arrayOfString = paramString1.split("\r\n");
    String str2 = null;
    Pattern localPattern = Pattern.compile("^a=rtpmap:(\\d+) " + paramString2 + "(/\\d+)+[\r]?$");
    String str1 = "m=video ";
    if (paramBoolean) {
      str1 = "m=audio ";
    }
    int i1 = 0;
    int i2 = -1;
    if ((i1 < arrayOfString.length) && ((i2 == -1) || (str2 == null)))
    {
      int i3;
      if (arrayOfString[i1].startsWith(str1)) {
        i3 = i1;
      }
      for (;;)
      {
        i1 += 1;
        i2 = i3;
        break;
        Matcher localMatcher = localPattern.matcher(arrayOfString[i1]);
        i3 = i2;
        if (localMatcher.matches())
        {
          str2 = localMatcher.group(1);
          i3 = i2;
        }
      }
    }
    if (i2 == -1)
    {
      s.onLog(r, "::: No " + str1 + " line, so can't prefer " + paramString2);
      return paramString1;
    }
    if (str2 == null)
    {
      s.onLog(r, "::: No rtpmap for " + paramString2);
      return paramString1;
    }
    s.onLog(r, "::: Found " + paramString2 + " rtpmap " + str2 + ", prefer at " + arrayOfString[i2]);
    paramString1 = arrayOfString[i2].split(" ");
    if (paramString1.length > 3)
    {
      paramString2 = new StringBuilder();
      paramString2.append(paramString1[0]).append(" ");
      paramString2.append(paramString1[1]).append(" ");
      paramString2.append(paramString1[2]).append(" ");
      paramString2.append(str2);
      i1 = 3;
      while (i1 < paramString1.length)
      {
        if (!paramString1[i1].equals(str2)) {
          paramString2.append(" ").append(paramString1[i1]);
        }
        i1 += 1;
      }
      arrayOfString[i2] = paramString2.toString();
      s.onLog(r, "::: Change media description: " + arrayOfString[i2]);
    }
    for (;;)
    {
      paramString1 = new StringBuilder();
      i2 = arrayOfString.length;
      i1 = i4;
      while (i1 < i2)
      {
        paramString1.append(arrayOfString[i1]).append("\r\n");
        i1 += 1;
      }
      s.onLog(r, "::: Wrong SDP media description format: " + arrayOfString[i2]);
    }
    return paramString1.toString();
  }
  
  private static Map<String, String> b(s.a[] paramArrayOfa)
  {
    HashMap localHashMap = new HashMap();
    int i2 = paramArrayOfa.length;
    int i1 = 0;
    while (i1 < i2)
    {
      s.a locala = paramArrayOfa[i1];
      localHashMap.put(locala.a, locala.b);
      i1 += 1;
    }
    return localHashMap;
  }
  
  private static void b(Context paramContext, EGLContext paramEGLContext, boolean paramBoolean)
    throws Exception
  {
    PeerConnectionFactory.initializeFieldTrials(null);
    if (!PeerConnectionFactory.initializeAndroidGlobals(paramContext, true, true, paramBoolean)) {
      throw d("Failed to initializeAndroid");
    }
    c = new PeerConnectionFactory();
  }
  
  private void b(q paramq)
  {
    if (this.aM == null) {
      return;
    }
    String str = paramq.b;
    if (this.bf) {}
    for (str = str.replaceAll("a=mid:audio\r", "a=mid:audio\r\nb=AS:" + this.be + "\r").replaceAll("a=mid:video\r", String.format("a=mid:video\r\nb=AS:%d\r\na=fmtp:100 x-google-start-bitrate=%d\r", new Object[] { Integer.valueOf(this.aZ), Integer.valueOf(120) }));; str = str.replaceAll("a=mid:audio\r", "a=mid:audio\r\nb=AS:" + this.bd + "\r").replaceAll("a=mid:video\r", String.format("a=mid:video\r\nb=AS:%d\r\na=fmtp:100 x-google-start-bitrate=%d\r", new Object[] { Integer.valueOf(this.aY), Integer.valueOf(120) })))
    {
      paramq = new q(paramq.a, str);
      s.onLog(r, this.e + "::: Set remote SDP => " + paramq.a);
      try
      {
        this.aM.setRemoteDescription(this.o, paramq);
        if (this.p == null) {
          break;
        }
        b("p1");
        if ((this.bz == null) || (this.bz.state() != MediaStreamTrack.a.c)) {
          break;
        }
        s.onLog(r, this.e + "::: remote remote video track");
        b("p2");
        return;
      }
      catch (Throwable paramq)
      {
        paramq.printStackTrace();
        s.onLog(r, this.e + "::: Set remote SDP exception " + paramq.getMessage());
        return;
      }
    }
  }
  
  private void b(String paramString)
  {
    if (this.p == null) {}
    do
    {
      return;
      if (this.p.b == null) {
        break;
      }
      s.onLog(r, this.e + "::: " + paramString + " remote stream video tracks = " + this.p.b.size());
    } while (this.p.b.size() <= 0);
    s.onLog(r, this.e + "::: " + paramString + " remote stream video track[0] state = " + ((VideoTrack)this.p.b.get(0)).state());
    return;
    s.onLog(r, this.e + "::: " + paramString + " remote stream video tracks is null");
  }
  
  private void b(boolean paramBoolean)
  {
    if ((this.bi != null) && (this.i != null))
    {
      s.onLog(r, this.e + "::: update local renderer,LocalscalingType::" + this.ap + " mirror:" + paramBoolean);
      this.i.update(this.bi, this.k.a, this.k.b, this.k.c, this.k.d, this.ap, paramBoolean);
    }
  }
  
  private void c(final String paramString)
  {
    s.onLog(r, this.e + "::: rtc reportError: " + paramString);
    b.execute(new Runnable()
    {
      public void run()
      {
        if (!d.a(d.this)) {
          d.E(d.this).onError(d.this, paramString);
        }
      }
    });
  }
  
  private static void c(Map<String, String> paramMap, String paramString1, String paramString2)
  {
    paramMap.put(paramString1, a((String)paramMap.get(paramString1), paramString2));
  }
  
  private void c(final boolean paramBoolean)
  {
    b.execute(new Runnable()
    {
      public void run()
      {
        if (d.R(d.this) != null) {
          d.R(d.this).setdisableResize(paramBoolean);
        }
      }
    });
  }
  
  private g d()
  {
    return new g(true, this.aS, this.aV, this.aW, this.aX, this.aY, this.aU, false, 0, this.bc, false, true);
  }
  
  private static Exception d(String paramString)
  {
    a.i("RtcConn", paramString);
    return new Exception(paramString);
  }
  
  private static String d(Map<String, String> paramMap, String paramString1, String paramString2)
  {
    if (paramMap.get(paramString1) != null) {
      return paramString2 + paramString1 + ": " + (String)paramMap.get(paramString1) + "\r\n";
    }
    return "";
  }
  
  private void d(boolean paramBoolean)
  {
    this.br = paramBoolean;
    s.onLog(r, this.e + "::: isInitiator => " + this.br);
    if (this.z == null)
    {
      this.z = d();
      if (this.w)
      {
        this.z.e = this.w;
        this.z.c = this.w;
        this.z.f = this.ba;
        this.z.d = this.bb;
        this.z.g = this.aP;
        if (this.aU == null)
        {
          this.aU = "VP8";
          s.onLog(r, this.e + "::: use default video codec " + this.aU);
        }
        this.z.m = this.aU;
        if ((this.aV == 0) || (this.aW == 0))
        {
          this.aV = 640;
          this.aW = 480;
          s.onLog(r, this.e + "::: use default video size " + this.aV + "x" + this.aW);
        }
        this.z.i = this.aV;
        this.z.j = this.aW;
        if (this.aY == 0)
        {
          this.aY = a(this.aV, this.aW);
          s.onLog(r, this.e + "::: use default maxVideoKbps " + this.aY);
        }
        if (this.aZ == 0) {
          this.aZ = a(this.aV, this.aW);
        }
        this.z.k = this.aX;
        if (this.bc == null)
        {
          this.bc = "OPUS";
          s.onLog(r, this.e + "::: use default audio codec " + this.bc);
        }
        this.z.p = this.bc;
      }
    }
    else
    {
      if ((!this.aP) || (!this.z.a)) {
        break label518;
      }
    }
    label518:
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.bw = paramBoolean;
      this.bw = true;
      n();
      o();
      return;
      this.z.e = this.aP;
      this.z.c = this.aQ;
      break;
    }
  }
  
  private void e(String paramString)
  {
    a.i("RtcConn", "<D><" + this.e + "> " + paramString);
  }
  
  private boolean e()
  {
    return (this.g != null) && (this.g.isViewReady());
  }
  
  private String f(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    paramString = paramString.split("\r\n");
    int i1 = 0;
    while (i1 < paramString.length)
    {
      localStringBuilder.append(paramString[i1]).append("\r\n");
      i1 += 1;
    }
    return localStringBuilder.toString();
  }
  
  private boolean f()
  {
    return (this.h != null) && (this.h.isViewReady());
  }
  
  private void g()
  {
    int i1;
    if (this.aM == null)
    {
      i1 = 1;
      if ((i1 | this.P) == 0) {
        break label24;
      }
    }
    label24:
    while (this.aM.getStats(new r()
    {
      public void onComplete(s[] paramAnonymousArrayOfs)
      {
        Object localObject2 = new HashMap();
        HashMap localHashMap4 = new HashMap();
        HashMap localHashMap2 = new HashMap();
        HashMap localHashMap3 = new HashMap();
        HashMap localHashMap1 = new HashMap();
        d.n localn = new d.n(d.this);
        int j = paramAnonymousArrayOfs.length;
        int i = 0;
        if (i < j)
        {
          Object localObject3 = paramAnonymousArrayOfs[i];
          localObject1 = d.a(((s)localObject3).d);
          if (((s)localObject3).b.equals("googCandidatePair")) {
            if (((String)((Map)localObject1).get("googActiveConnection")).equals("true"))
            {
              localObject3 = (String)((Map)localObject1).get("googLocalCandidateType");
              localObject1 = (String)((Map)localObject1).get("googRemoteCandidateType");
              if (((localObject3 == null) || (!((String)localObject3).equals("relay"))) && ((localObject1 == null) || (!((String)localObject1).equals("relay")))) {
                break label212;
              }
              d.a((Map)localObject2, "connection", "relay");
              d.a(d.this, "relay");
              localn.a = d.g(d.this);
            }
          }
          for (;;)
          {
            i += 1;
            break;
            label212:
            d.a((Map)localObject2, "connection", "direct");
            d.a(d.this, "direct");
            localn.a = d.g(d.this);
            continue;
            if (((s)localObject3).b.equals("ssrc"))
            {
              localObject3 = (String)((Map)localObject1).get("googCodecName");
              String str1;
              String str2;
              int k;
              int m;
              int n;
              int i1;
              if (((Map)localObject1).get("googFrameWidthReceived") != null)
              {
                d.b(d.this, (String)localObject3);
                str1 = (String)((Map)localObject1).get("googFrameWidthReceived");
                str2 = (String)((Map)localObject1).get("googFrameHeightReceived");
                localHashMap2.put("vcodec", localObject3);
                localHashMap2.put("vsize", str1 + "x" + str2);
                localHashMap2.put("vfps", ((Map)localObject1).get("googFrameRateDecoded"));
                localHashMap2.put("vlost", ((Map)localObject1).get("packetsLost"));
                localHashMap2.put("vbytes", ((Map)localObject1).get("bytesReceived"));
                d.h(d.this).update((String)((Map)localObject1).get("bytesReceived"));
                d.a(d.this, Integer.parseInt((String)((Map)localObject1).get("bytesReceived")));
                d.b(d.this, Integer.parseInt((String)((Map)localObject1).get("packetsReceived")));
                k = d.i(d.this);
                m = d.j(d.this);
                d.c(d.this, d.i(d.this));
                d.d(d.this, Integer.parseInt((String)((Map)localObject1).get("packetsLost")));
                n = d.k(d.this);
                i1 = d.l(d.this);
                d.e(d.this, d.k(d.this));
                d.m(d.this).addvideopackslost(k - m, n - i1);
                localn.u = d.m(d.this).getvideopackslostrate();
                localHashMap1.put("vsize", str1 + "x" + str2);
                localHashMap1.put("vfps", ((Map)localObject1).get("googFrameRateReceived"));
                localHashMap1.put("vlost", ((Map)localObject1).get("packetsLost"));
                localn.q = Integer.parseInt((String)((Map)localObject1).get("googFrameWidthReceived"));
                localn.r = Integer.parseInt((String)((Map)localObject1).get("googFrameHeightReceived"));
                localn.s = Integer.parseInt((String)((Map)localObject1).get("googFrameRateReceived"));
                localn.t = Integer.parseInt((String)((Map)localObject1).get("packetsLost"));
              }
              else if (((Map)localObject1).get("googFrameWidthSent") != null)
              {
                str1 = (String)((Map)localObject1).get("googFrameWidthSent");
                str2 = (String)((Map)localObject1).get("googFrameHeightSent");
                d.c(d.this, (String)localObject3);
                localHashMap4.put("vlcodec", localObject3);
                localHashMap4.put("vinsize", (String)((Map)localObject1).get("googFrameWidthInput") + "x" + (String)((Map)localObject1).get("googFrameHeightInput"));
                localHashMap4.put("vsize", str1 + "x" + str2);
                localHashMap4.put("vfps", (String)((Map)localObject1).get("googFrameRateInput") + "/" + (String)((Map)localObject1).get("googFrameRateSent"));
                localHashMap4.put("vlost", ((Map)localObject1).get("packetsLost"));
                localHashMap4.put("vrtt", ((Map)localObject1).get("googRtt"));
                localHashMap4.put("vbytes", ((Map)localObject1).get("bytesSent"));
                d.n(d.this).update((String)((Map)localObject1).get("bytesSent"));
                d.f(d.this, Integer.parseInt((String)((Map)localObject1).get("bytesSent")));
                d.g(d.this, Integer.parseInt((String)((Map)localObject1).get("packetsSent")));
                k = d.o(d.this);
                m = d.p(d.this);
                d.h(d.this, d.o(d.this));
                d.i(d.this, Integer.parseInt((String)((Map)localObject1).get("packetsLost")));
                n = d.q(d.this);
                i1 = d.r(d.this);
                d.j(d.this, d.q(d.this));
                d.s(d.this).addvideopackslost(k - m, n - i1);
                localn.k = d.s(d.this).getvideopackslostrate();
                localHashMap3.put("vsize", str1 + "x" + str2);
                localHashMap3.put("vfps", (String)((Map)localObject1).get("googFrameRateInput") + "/" + (String)((Map)localObject1).get("googFrameRateSent"));
                localHashMap3.put("vlost", ((Map)localObject1).get("packetsLost"));
                localHashMap3.put("vrtt", ((Map)localObject1).get("googRtt"));
                localn.b = Integer.parseInt((String)((Map)localObject1).get("googFrameWidthInput"));
                localn.c = Integer.parseInt((String)((Map)localObject1).get("googFrameHeightInput"));
                localn.e = Integer.parseInt((String)((Map)localObject1).get("googFrameWidthSent"));
                localn.f = Integer.parseInt((String)((Map)localObject1).get("googFrameHeightSent"));
                localn.d = Integer.parseInt((String)((Map)localObject1).get("googFrameRateInput"));
                localn.g = Integer.parseInt((String)((Map)localObject1).get("googFrameRateSent"));
                localn.j = Integer.parseInt((String)((Map)localObject1).get("packetsLost"));
                localn.l = Integer.parseInt((String)((Map)localObject1).get("googRtt"));
              }
              else if (((Map)localObject1).get("bytesReceived") != null)
              {
                d.d(d.this, (String)localObject3);
                localHashMap2.put("acodec", localObject3);
                localHashMap2.put("alost", ((Map)localObject1).get("packetsLost"));
                localHashMap2.put("abytes", ((Map)localObject1).get("bytesReceived"));
                d.t(d.this).update((String)((Map)localObject1).get("bytesReceived"));
                d.k(d.this, Integer.parseInt((String)((Map)localObject1).get("bytesReceived")));
                d.l(d.this, Integer.parseInt((String)((Map)localObject1).get("packetsReceived")));
                k = d.u(d.this);
                m = d.v(d.this);
                d.m(d.this, d.u(d.this));
                d.n(d.this, Integer.parseInt((String)((Map)localObject1).get("packetsLost")));
                n = d.w(d.this);
                i1 = d.x(d.this);
                d.o(d.this, d.w(d.this));
                d.m(d.this).addaudiopackslost(k - m, n - i1);
                localn.x = d.m(d.this).getaudiopackslostrate();
                localHashMap1.put("alost", ((Map)localObject1).get("packetsLost"));
                localHashMap1.put("artt", ((Map)localObject1).get("googRtt"));
                localn.w = Integer.parseInt((String)((Map)localObject1).get("packetsLost"));
              }
              else if (((Map)localObject1).get("bytesSent") != null)
              {
                d.e(d.this, (String)localObject3);
                localHashMap4.put("acodec", localObject3);
                localHashMap4.put("alost", ((Map)localObject1).get("packetsLost"));
                localHashMap4.put("abytes", ((Map)localObject1).get("bytesSent"));
                d.y(d.this).update((String)((Map)localObject1).get("bytesSent"));
                localHashMap3.put("alost", ((Map)localObject1).get("packetsLost"));
                localHashMap3.put("abytes", ((Map)localObject1).get("bytesSent"));
                localHashMap3.put("artt", ((Map)localObject1).get("googRtt"));
                d.p(d.this, Integer.parseInt((String)((Map)localObject1).get("bytesSent")));
                d.q(d.this, Integer.parseInt((String)((Map)localObject1).get("packetsSent")));
                k = d.z(d.this);
                m = d.A(d.this);
                d.r(d.this, d.z(d.this));
                d.s(d.this, Integer.parseInt((String)((Map)localObject1).get("packetsLost")));
                n = d.B(d.this);
                i1 = d.C(d.this);
                d.t(d.this, d.B(d.this));
                d.s(d.this).addaudiopackslost(k - m, n - i1);
                localn.n = d.s(d.this).getaudiopackslostrate();
                localn.p = Integer.parseInt((String)((Map)localObject1).get("googRtt"));
                localn.m = Integer.parseInt((String)((Map)localObject1).get("packetsLost"));
              }
            }
            else if (((s)localObject3).b.equals("VideoBwe"))
            {
              localHashMap4.put("vbr", (String)((Map)localObject1).get("googActualEncBitrate") + "/" + (String)((Map)localObject1).get("googTargetEncBitrate"));
              localHashMap3.put("vbr", Integer.parseInt((String)((Map)localObject1).get("googActualEncBitrate")) / 1000 + "/" + Integer.parseInt((String)((Map)localObject1).get("googTargetEncBitrate")) / 1000);
              localn.h = (Integer.parseInt((String)((Map)localObject1).get("googActualEncBitrate")) / 1000);
              localn.i = (Integer.parseInt((String)((Map)localObject1).get("googTargetEncBitrate")) / 1000);
            }
          }
        }
        if (((Map)localObject2).get("connection") == null) {
          ((Map)localObject2).put("connection", "disconnect");
        }
        Object localObject1 = "" + d.b((Map)localObject2, "connection", "");
        localObject2 = "" + d.b((Map)localObject2, "connection", "");
        paramAnonymousArrayOfs = (s[])localObject1;
        if (d.D(d.this).sampleCpuUtilization()) {
          paramAnonymousArrayOfs = (String)localObject1 + "CPU%: " + d.D(d.this).getCpuCurrent() + "/" + d.D(d.this).getCpuAvg3() + "/" + d.D(d.this).getCpuAvgAll();
        }
        if (localHashMap4.size() > 0)
        {
          localHashMap4.put("vbps", String.valueOf(d.n(d.this).getBitrateString()));
          localHashMap4.put("abps", String.valueOf(d.y(d.this).getBitrateString()));
          localHashMap3.put("abps", String.valueOf(d.y(d.this).getBitrateString()));
          localn.o = Integer.parseInt(d.y(d.this).getBitrateString());
          paramAnonymousArrayOfs = paramAnonymousArrayOfs + "\r\n";
          paramAnonymousArrayOfs = paramAnonymousArrayOfs + d.b(localHashMap4, "vlcodec", "");
          paramAnonymousArrayOfs = paramAnonymousArrayOfs + d.b(localHashMap4, "vinsize", "");
          paramAnonymousArrayOfs = paramAnonymousArrayOfs + d.b(localHashMap4, "vsize", "");
          paramAnonymousArrayOfs = paramAnonymousArrayOfs + d.b(localHashMap4, "vfps", "");
          paramAnonymousArrayOfs = paramAnonymousArrayOfs + d.b(localHashMap4, "vrtt", "");
          paramAnonymousArrayOfs = paramAnonymousArrayOfs + d.b(localHashMap4, "vlost", "");
          paramAnonymousArrayOfs = paramAnonymousArrayOfs + d.b(localHashMap4, "vbytes", "");
          paramAnonymousArrayOfs = paramAnonymousArrayOfs + d.b(localHashMap4, "vbps", "");
          paramAnonymousArrayOfs = paramAnonymousArrayOfs + d.b(localHashMap4, "vbr", "");
          paramAnonymousArrayOfs = paramAnonymousArrayOfs + d.b(localHashMap4, "acodec", "");
          paramAnonymousArrayOfs = paramAnonymousArrayOfs + d.b(localHashMap4, "alost", "");
          paramAnonymousArrayOfs = paramAnonymousArrayOfs + d.b(localHashMap4, "abytes", "");
          localObject1 = paramAnonymousArrayOfs + d.b(localHashMap4, "abps", "");
          paramAnonymousArrayOfs = (String)localObject2 + d.b(localHashMap4, "vlcodec", "");
          paramAnonymousArrayOfs = paramAnonymousArrayOfs + d.b(localHashMap3, "vsize", "");
          paramAnonymousArrayOfs = paramAnonymousArrayOfs + d.b(localHashMap3, "vfps", "");
          paramAnonymousArrayOfs = paramAnonymousArrayOfs + d.b(localHashMap3, "vrtt", "");
          paramAnonymousArrayOfs = paramAnonymousArrayOfs + d.b(localHashMap3, "vlost", "");
          paramAnonymousArrayOfs = paramAnonymousArrayOfs + "vlostrate: " + localn.k + "\r\n";
          paramAnonymousArrayOfs = paramAnonymousArrayOfs + d.b(localHashMap3, "vbr", "");
          paramAnonymousArrayOfs = paramAnonymousArrayOfs + d.b(localHashMap3, "alost", "");
          paramAnonymousArrayOfs = paramAnonymousArrayOfs + "alostrate: " + localn.n + "\r\n";
          paramAnonymousArrayOfs = paramAnonymousArrayOfs + d.b(localHashMap3, "artt", "");
        }
        for (paramAnonymousArrayOfs = paramAnonymousArrayOfs + d.b(localHashMap3, "abps", "");; paramAnonymousArrayOfs = (s[])localObject2)
        {
          localObject2 = paramAnonymousArrayOfs;
          if (localHashMap2.size() > 0)
          {
            localHashMap2.put("vbps", String.valueOf(d.h(d.this).getBitrateString()));
            localHashMap2.put("abps", String.valueOf(d.t(d.this).getBitrateString()));
            localHashMap1.put("vbps", String.valueOf(d.h(d.this).getBitrateString()));
            localHashMap1.put("abps", String.valueOf(d.t(d.this).getBitrateString()));
            localn.v = Integer.parseInt(d.h(d.this).getBitrateString());
            localn.y = Integer.parseInt(d.t(d.this).getBitrateString());
            localObject1 = (String)localObject1 + "\r\n";
            localObject1 = (String)localObject1 + "remote:\r\n";
            localObject1 = (String)localObject1 + d.b(localHashMap2, "vcodec", "");
            localObject1 = (String)localObject1 + d.b(localHashMap2, "vsize", "");
            localObject1 = (String)localObject1 + d.b(localHashMap2, "vfps", "");
            localObject1 = (String)localObject1 + d.b(localHashMap2, "vlost", "");
            localObject1 = (String)localObject1 + d.b(localHashMap2, "vbytes", "");
            localObject1 = (String)localObject1 + d.b(localHashMap2, "vbps", "");
            localObject1 = (String)localObject1 + d.b(localHashMap2, "acodec", "");
            localObject1 = (String)localObject1 + d.b(localHashMap2, "alost", "");
            localObject1 = (String)localObject1 + d.b(localHashMap2, "abytes", "");
            new StringBuilder().append((String)localObject1).append(d.b(localHashMap2, "abps", "")).toString();
            paramAnonymousArrayOfs = paramAnonymousArrayOfs + d.b(localHashMap1, "vcodec", "");
            paramAnonymousArrayOfs = paramAnonymousArrayOfs + d.b(localHashMap1, "vsize", "");
            paramAnonymousArrayOfs = paramAnonymousArrayOfs + d.b(localHashMap1, "vfps", "");
            paramAnonymousArrayOfs = paramAnonymousArrayOfs + d.b(localHashMap1, "vlost", "");
            paramAnonymousArrayOfs = paramAnonymousArrayOfs + "vlostrate: " + localn.u + "\r\n";
            paramAnonymousArrayOfs = paramAnonymousArrayOfs + d.b(localHashMap1, "vbps", "");
            paramAnonymousArrayOfs = paramAnonymousArrayOfs + d.b(localHashMap1, "alost", "");
            paramAnonymousArrayOfs = paramAnonymousArrayOfs + "alostrate: " + localn.x + "\r\n";
            localObject2 = paramAnonymousArrayOfs + d.b(localHashMap1, "abps", "");
          }
          localn.z = ((String)localObject2);
          if (!d.a(d.this)) {
            d.E(d.this).onStats(d.this, localn);
          }
          return;
          localObject1 = paramAnonymousArrayOfs;
        }
      }
    }, null))
    {
      return;
      i1 = 0;
      break;
    }
    s.onLog(r, this.e + "::: getStats() returns false!");
  }
  
  public static Map<String, Map<Integer, Integer>> getAudioVolumeOfRTCMap(Map<String, i> paramMap)
  {
    HashMap localHashMap = new HashMap();
    Iterator localIterator = paramMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      Map localMap = ((i)paramMap.get(str)).getAudioVolume();
      if (localMap != null) {
        localHashMap.put(str, localMap);
      }
    }
    return localHashMap;
  }
  
  public static String getVersion()
  {
    return String.format("%s-%s", new Object[] { "2.0.0", PeerConnection.getVersion() });
  }
  
  private void h()
  {
    s.onLog(r, this.e + "::: checkAddRenddererInternal: => local=[" + this.bi + ", " + this.bx + "], remote=[" + this.bj + ", " + this.bz + "]");
    if (f())
    {
      if (this.bj == null)
      {
        s.onLog(r, this.e + "::: create remote renderer");
        this.bj = this.j.create(this.l.a, this.l.b, this.l.c, this.l.d, this.aq, false);
      }
      if ((this.bz != null) && (!this.B) && (this.bj != null))
      {
        this.B = true;
        s.onLog(r, this.e + "::: add remote renderer");
        this.bl = new VideoRenderer(this.bj);
        this.bz.addRenderer(this.bl);
      }
    }
    if (e())
    {
      if (this.bi == null)
      {
        s.onLog(r, this.e + "::: create local renderer. Mirror::" + Y);
        this.bi = this.i.create(this.k.a, this.k.b, this.k.c, this.k.d, this.ap, Y);
      }
      if ((this.bx != null) && (!this.A) && (this.bi != null))
      {
        this.A = true;
        s.onLog(r, this.e + "::: add local renderer");
        this.bk = new VideoRenderer(this.bi);
        this.bx.addRenderer(this.bk);
      }
    }
  }
  
  private void i()
  {
    if (this.bj != null)
    {
      s.onLog(r, this.e + "::: update remote renderer,RemotescalingType::" + this.aq);
      if (this.j != null) {
        this.j.update(this.bj, this.l.a, this.l.b, this.l.c, this.l.d, this.aq, false);
      }
    }
    if ((this.bi != null) && (this.i != null))
    {
      s.onLog(r, this.e + "::: update local renderer,LocalscalingType::" + this.ap);
      this.i.update(this.bi, this.k.a, this.k.b, this.k.c, this.k.d, this.ap, Y);
    }
  }
  
  public static void initGlobal(Context paramContext)
    throws Exception
  {
    initGlobal(paramContext, false, null);
  }
  
  public static void initGlobal(Context paramContext, com.superrtc.a.f paramf)
    throws Exception
  {
    initGlobal(paramContext, false, paramf);
  }
  
  public static void initGlobal(final Context paramContext, boolean paramBoolean, com.superrtc.a.f paramf)
    throws Exception
  {
    s.onLog(r, "[rapi]++ initGlobal, useVideoCodecHw=" + paramBoolean + "rtc sdk version " + getVersion());
    a = paramContext;
    if (paramf == null)
    {
      b = new com.superrtc.a.f();
      b.requestStart();
    }
    for (;;)
    {
      H = paramBoolean;
      b.execute(new Runnable()
      {
        public void run()
        {
          d.s.onLog(d.r, "[rapi]-- initGlobal, useVideoCodecHw=" + this.a);
          PeerConnectionFactory.setconfigframerate(20);
          try
          {
            d.a(paramContext, null, this.a);
            Logging.enableTracing("logcat:", EnumSet.of(Logging.b.g), d.a());
            return;
          }
          catch (Exception localException)
          {
            for (;;)
            {
              localException.printStackTrace();
            }
          }
        }
      });
      return;
      b = paramf;
    }
  }
  
  private q j()
  {
    synchronized (this.ag)
    {
      if (this.ag.isEmpty()) {
        return null;
      }
      q localq = (q)this.ag.removeFirst();
      return localq;
    }
  }
  
  private void k()
  {
    for (;;)
    {
      q localq = j();
      if (localq == null) {
        break;
      }
      if (localq.a == q.a.a)
      {
        if (this.br)
        {
          s.onLog(r, this.e + "::: got offer but isInitiator, drop it");
        }
        else
        {
          if (this.aM == null) {
            d(false);
          }
          if (this.aM.signalingState() == PeerConnection.k.a)
          {
            if (this.aM.getRemoteDescription() == null)
            {
              this.q = true;
              b(localq);
              s.onLog(r, this.e + "::: create PRANSWER : sdpMediaConstraints=" + this.bq);
              this.aM.createAnswer(this.n, this.bq);
            }
            else
            {
              this.q = false;
              b(localq);
              s.onLog(r, this.e + "::: create ANSWER : sdpMediaConstraints=" + this.bq);
              this.aM.createAnswer(this.n, this.bq);
            }
          }
          else {
            s.onLog(r, this.e + "::: got offer at wrong state " + this.aM.signalingState());
          }
        }
      }
      else if ((localq.a == q.a.b) || (localq.a == q.a.c))
      {
        if (!this.br) {
          s.onLog(r, this.e + "::: got " + localq.a + " but NOT isInitiator, drop it " + this.br);
        } else if (this.aM == null) {
          s.onLog(r, this.e + "::: got " + localq.a + " but NOT pc null, drop it");
        } else if (((this.O != PeerConnection.c.c) || (this.K != "direct")) || ((this.aM.signalingState() == PeerConnection.k.b) || (this.aM.signalingState() == PeerConnection.k.e))) {
          b(localq);
        } else {
          s.onLog(r, this.e + "::: got " + localq.a + " at wrong state " + this.aM.signalingState());
        }
      }
      else {
        s.onLog(r, this.e + "::: unknown sdp type " + localq.a);
      }
    }
  }
  
  private void l()
  {
    if (this.aM != null)
    {
      synchronized (this.ah)
      {
        Iterator localIterator = this.ah.iterator();
        if (localIterator.hasNext())
        {
          l locall = (l)localIterator.next();
          this.aM.addIceCandidate(locall);
        }
      }
      this.ah.clear();
    }
  }
  
  private long m()
  {
    try
    {
      this.af += 1L;
      long l1 = this.af;
      return l1;
    }
    finally {}
  }
  
  private void n()
  {
    this.bn = new n();
    if (this.z.h)
    {
      s.onLog(r, this.e + "::: loopback: set DTLS_SRTP_KEY_AGREEMENT_CONSTRAINT false ");
      this.bn.b.add(new n.a("DtlsSrtpKeyAgreement", "false"));
      this.bu = com.superrtc.call.c.getDeviceCount();
      if (this.bu == 0)
      {
        s.onLog(r, this.e + "::: No camera on device. Switch to audio only call.");
        this.aP = false;
      }
      if (this.z.e)
      {
        this.bo = new n();
        int i3 = this.z.i;
        int i4 = this.z.j;
        int i2;
        if (i3 != 0)
        {
          i1 = i4;
          i2 = i3;
          if (i4 != 0) {}
        }
        else
        {
          i1 = i4;
          i2 = i3;
          if (this.z.n)
          {
            i1 = i4;
            i2 = i3;
            if (m.isVp8HwSupported())
            {
              i1 = 1080;
              i2 = 1920;
            }
          }
        }
        if ((i2 > 0) && (i1 > 0))
        {
          i2 = Math.min(i2, 1920);
          i1 = Math.min(i1, 1920);
          this.bo.a.add(new n.a("minWidth", Integer.toString(i2)));
          this.bo.a.add(new n.a("maxWidth", Integer.toString(1920)));
          this.bo.a.add(new n.a("minHeight", Integer.toString(i1)));
          this.bo.a.add(new n.a("maxHeight", Integer.toString(1920)));
        }
        int i1 = this.z.k;
        if (i1 > 0)
        {
          i1 = Math.min(i1, 30);
          this.bo.a.add(new n.a("minFrameRate", Integer.toString(i1)));
          this.bo.a.add(new n.a("maxFrameRate", Integer.toString(i1)));
        }
      }
      this.bp = new n();
      if (this.z.q)
      {
        s.onLog(r, this.e + "::: Disabling audio processing");
        this.bp.a.add(new n.a("googEchoCancellation", "false"));
        this.bp.a.add(new n.a("googAutoGainControl", "false"));
        this.bp.a.add(new n.a("googHighpassFilter", "false"));
        this.bp.a.add(new n.a("googNoiseSuppression", "false"));
      }
      if (!this.bB)
      {
        s.onLog(r, this.e + "::: Disabling audio AEC");
        this.bp.a.add(new n.a("googEchoCancellation", "false"));
      }
      if (!this.bC)
      {
        s.onLog(r, this.e + "::: Disabling audio AGC");
        this.bp.a.add(new n.a("googAutoGainControl", "false"));
      }
      if (!this.bD)
      {
        s.onLog(r, this.e + "::: Disabling audio NS");
        this.bp.a.add(new n.a("googNoiseSuppression", "false"));
      }
      this.bq = new n();
      if ((!this.z.h) && (!this.z.d)) {
        break label966;
      }
      this.bq.a.add(new n.a("OfferToReceiveAudio", "true"));
    }
    for (;;)
    {
      if ((!this.z.h) && (!this.z.c) && (!this.z.e)) {
        break label1029;
      }
      this.bq.a.add(new n.a("OfferToReceiveVideo", "true"));
      s.onLog(r, this.e + "::: OfferToReceiveVideo true");
      return;
      this.bn.b.add(new n.a("DtlsSrtpKeyAgreement", "true"));
      break;
      label966:
      this.bq.a.add(new n.a("OfferToReceiveAudio", "false"));
      s.onLog(r, this.e + "::: set OfferToReceiveAudio false");
    }
    label1029:
    this.bq.a.add(new n.a("OfferToReceiveVideo", "false"));
  }
  
  private void o()
  {
    if (c == null)
    {
      s.onLog(r, this.e + "::: Peerconnection factory is not created");
      return;
    }
    s.onLog(r, this.e + "::: Create peer connection");
    s.onLog(r, this.e + "::: PCConstraints: " + this.bn.toString());
    if (this.bo != null) {
      s.onLog(r, this.e + "::: VideoConstraints: " + this.bo.toString());
    }
    PeerConnection.i locali = new PeerConnection.i(this.bm);
    locali.e = PeerConnection.l.b;
    locali.c = PeerConnection.a.b;
    locali.d = PeerConnection.j.b;
    if (this.bf) {
      locali.a = PeerConnection.f.b;
    }
    this.aM = c.createPeerConnection(locali, this.bn, this.aL);
    if (this.aM != null)
    {
      if (D) {
        this.aM.setdisableResize(D);
      }
      if (E != 0) {
        PeerConnectionFactory.setconfigframerate(E);
      }
      if (F > 0) {
        break label334;
      }
      F = G;
      this.aM.setconfigminbitrate(F);
    }
    for (;;)
    {
      this.bt = c.createLocalMediaStream("ARDAMS");
      if (this.br) {
        t();
      }
      this.aM.addStream(this.bt);
      x();
      return;
      label334:
      this.aM.setconfigminbitrate(F);
    }
  }
  
  private void p() {}
  
  private void q()
  {
    if ((this.bv != null) && (this.ad)) {
      this.bv.setRotation(this.ac);
    }
  }
  
  private void r()
  {
    if (this.Z != null) {
      if (this.bv != null) {
        this.bv.setCameraDataProcessor(new w.e()
        {
          public void onProcessData(byte[] paramAnonymousArrayOfByte, Camera paramAnonymousCamera, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
          {
            d.W(d.this).onProcessData(paramAnonymousArrayOfByte, paramAnonymousCamera, paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3);
          }
          
          public void setResolution(int paramAnonymousInt1, int paramAnonymousInt2)
          {
            d.W(d.this).setResolution(paramAnonymousInt1, paramAnonymousInt2);
          }
        });
      }
    }
    while (this.bv == null) {
      return;
    }
    this.bv.setCameraDataProcessor(null);
  }
  
  /* Error */
  public static void registerLogListener(d paramd)
  {
    // Byte code:
    //   0: ldc_w 1127
    //   3: ldc_w 1544
    //   6: invokestatic 1549	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   9: pop
    //   10: ldc 2
    //   12: monitorenter
    //   13: ldc_w 1127
    //   16: ldc_w 1551
    //   19: invokestatic 1549	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   22: pop
    //   23: aload_0
    //   24: putstatic 359	com/superrtc/sdk/d:s	Lcom/superrtc/sdk/d$d;
    //   27: aload_0
    //   28: ifnull +11 -> 39
    //   31: aload_0
    //   32: putstatic 359	com/superrtc/sdk/d:s	Lcom/superrtc/sdk/d$d;
    //   35: ldc 2
    //   37: monitorexit
    //   38: return
    //   39: getstatic 357	com/superrtc/sdk/d:aj	Lcom/superrtc/sdk/d$d;
    //   42: putstatic 359	com/superrtc/sdk/d:s	Lcom/superrtc/sdk/d$d;
    //   45: goto -10 -> 35
    //   48: astore_0
    //   49: ldc 2
    //   51: monitorexit
    //   52: aload_0
    //   53: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	54	0	paramd	d
    // Exception table:
    //   from	to	target	type
    //   13	27	48	finally
    //   31	35	48	finally
    //   35	38	48	finally
    //   39	45	48	finally
    //   49	52	48	finally
  }
  
  private void s()
  {
    if (this.ab != null) {
      if (this.bv != null) {
        this.bv.setGlTextureProcessor(new w.d()
        {
          public void onDrawFrame(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, float[] paramAnonymousArrayOfFloat, int paramAnonymousInt4)
          {
            d.X(d.this).onDrawFrame(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3, paramAnonymousArrayOfFloat, paramAnonymousInt4);
          }
        });
      }
    }
    while (this.bv == null) {
      return;
    }
    this.bv.setGlTextureProcessor(null);
  }
  
  public static void setAudioSampleRate(int paramInt)
  {
    if (paramInt > 0) {
      com.superrtc.b.a.setAudioSampleRate(paramInt);
    }
  }
  
  public static void setCameraFacing(int paramInt)
  {
    if (X != paramInt)
    {
      X = paramInt;
      if (X != 0) {
        break label22;
      }
      Y = false;
    }
    label22:
    while (X != 1) {
      return;
    }
    Y = true;
  }
  
  public static int setDocDirectory(String paramString)
  {
    return PeerConnection.setDocDiretory(paramString);
  }
  
  public static void setGlobalVideoCodec(String paramString)
  {
    ae = paramString;
  }
  
  public static void setMediaLogLevel(e parame)
  {
    switch (42.a[parame.ordinal()])
    {
    default: 
      return;
    case 1: 
      C = Logging.a.a;
      return;
    case 2: 
      C = Logging.a.b;
      return;
    case 3: 
      C = Logging.a.c;
      return;
    case 4: 
      C = Logging.a.d;
      return;
    }
    C = Logging.a.e;
  }
  
  public static void setMinVideoKbps(int paramInt)
  {
    if (paramInt > 0)
    {
      F = paramInt;
      return;
    }
    F = G;
  }
  
  public static void setRtcListener(e parame)
  {
    ak = parame;
    com.superrtc.b.a.setRtcListener(parame);
  }
  
  public static boolean startRecordPlayout()
  {
    if (c == null) {
      return false;
    }
    return c.startRecordPlayout();
  }
  
  public static String stopRecordPlayout()
  {
    if (c == null) {
      return null;
    }
    return c.stopRecordPlayout();
  }
  
  private void t()
  {
    if (this.aM == null) {}
    while (this.bt == null) {
      return;
    }
    Object localObject2;
    Object localObject1;
    int i1;
    if ((this.z.e) && (this.bx == null))
    {
      localObject2 = com.superrtc.call.c.getDeviceName(0);
      localObject1 = com.superrtc.call.c.getNameOfFrontFacingDevice();
      if ((this.bu <= 1) || (localObject1 == null)) {
        break label883;
      }
      i1 = 0;
      localObject2 = localObject1;
    }
    for (;;)
    {
      localObject1 = localObject2;
      if (X >= 0)
      {
        localObject1 = localObject2;
        if (X < this.bu)
        {
          localObject2 = com.superrtc.call.c.getDeviceName(X);
          localObject1 = localObject2;
          if (X == 0) {
            i1 = 1;
          }
        }
      }
      for (;;)
      {
        boolean bool;
        if (i1 != 0)
        {
          Y = false;
          b(Y);
          s.onLog(r, this.e + "::: Opening camera: " + (String)localObject2 + " Mirror::" + Y);
          if ((!this.z.g) || (this.y)) {
            break label435;
          }
          bool = true;
          label185:
          this.d = bool;
          if (this.ab == null) {
            break label440;
          }
          if (this.i != null) {
            this.J = this.i.getEglBaseContext();
          }
          this.bv = w.create((String)localObject2, null, this.J);
          label229:
          if (this.bv != null) {
            break label453;
          }
          c("Failed to open camera");
          h();
          p();
        }
        for (;;)
        {
          if ((f()) && (this.bj == null))
          {
            s.onLog(r, this.e + "::: checking remote renderer");
            h();
          }
          if ((!this.z.f) || (this.by != null)) {
            break label762;
          }
          s.onLog(r, this.e + "::: create capture audio");
          this.aO = c.createAudioSource(this.bp);
          this.by = c.createAudioTrack("ARDAMSa0", this.aO);
          if (this.by != null)
          {
            if (!this.bA) {
              this.by.setEnabled(this.bA);
            }
            this.bt.addTrack(this.by);
          }
          p();
          return;
          Y = true;
          break;
          label435:
          bool = false;
          break label185;
          label440:
          this.bv = w.create((String)localObject2, null);
          break label229;
          label453:
          q();
          this.bv.setEnableExternalVideoData(this.aa);
          this.bv.setRtcListener(ak);
          r();
          s();
          if (this.z.g) {
            if (this.y)
            {
              this.bv.setEnableCamera(false);
              this.bv.setEnableCameragetsuppoted(false);
            }
          }
          for (;;)
          {
            this.aN = c.createVideoSource(this.bv, this.bo);
            this.bx = c.createVideoTrack("ARDAMSv0", this.aN);
            this.bx.setEnabled(this.bw);
            this.bt.addTrack(this.bx);
            break;
            this.bv.setEnableCamera(true);
            this.bv.setEnableCameragetsuppoted(false);
            continue;
            if (this.w)
            {
              this.bv.setEnableCamera(false);
              this.bv.setEnableCameragetsuppoted(false);
            }
          }
          if ((!this.z.e) && (this.bx != null))
          {
            s.onLog(r, this.e + "::: remove video track");
            if (this.bx != null)
            {
              this.bt.removeTrack(this.bx);
              this.bx.setEnabled(false);
              this.bx.dispose();
              this.bx = null;
              if (this.A) {
                this.A = false;
              }
            }
            if (this.aN != null)
            {
              this.aN.stop();
              this.aN.dispose();
              this.aN = null;
            }
            p();
          }
        }
        label762:
        if ((!this.z.f) && (this.by != null))
        {
          s.onLog(r, this.e + "::: remove audio track");
          if (this.by != null)
          {
            this.bt.removeTrack(this.by);
            this.by = null;
          }
          p();
          return;
        }
        s.onLog(r, this.e + "::: do nothing for audio");
        return;
        localObject2 = localObject1;
      }
      label883:
      i1 = 1;
    }
  }
  
  private void u()
  {
    s.onLog(r, this.e + "::: Closing peer connection.");
    this.bh.cancel();
    if (this.aM != null)
    {
      this.aM.dispose();
      this.aM = null;
    }
    e("Closing video source.");
    if (this.aN != null)
    {
      this.aN.dispose();
      this.aN = null;
    }
    s.onLog(r, this.e + "::: Closing peer connection factory.");
    this.t = null;
    s.onLog(r, this.e + "::: Closing peer connection done.");
    s.onLog(r, this.e + ":::  onClosed");
    if (!this.P) {
      this.x.onClosed(this);
    }
    PeerConnectionFactory.stopInternalTracingCapture();
    PeerConnectionFactory.shutdownInternalTracer();
  }
  
  private void v()
  {
    if (this.w)
    {
      if ((!this.d) || (this.bu < 2) || (this.bv == null)) {
        s.onLog(r, this.e + "::: Failed to switch camera. Video: " + this.d + ". Number of cameras: " + this.bu);
      }
    }
    else if ((!this.aP) || (this.bu < 2) || (this.bv == null))
    {
      s.onLog(r, this.e + "::: Failed to switch camera. Video: " + this.aP + ". Number of cameras: " + this.bu);
      return;
    }
    s.onLog(r, this.e + "::: Switch camera");
    this.bv.switchCamera(new w.c()
    {
      public void onCameraSwitchDone(boolean paramAnonymousBoolean)
      {
        if (paramAnonymousBoolean) {
          d.a(true);
        }
        for (;;)
        {
          d.k(d.this, d.c());
          return;
          d.a(false);
        }
      }
      
      public void onCameraSwitchError(String paramAnonymousString)
      {
        d.s.onLog(d.r, d.this.e + "::: switchCamera Error::" + paramAnonymousString);
      }
    });
  }
  
  private void w()
  {
    if ((this.bv == null) || (this.d) || (!this.w))
    {
      s.onLog(r, this.e + "::: Failed to enableCamera. Video:" + this.d + " autoAddVideo:" + this.w);
      return;
    }
    this.bv.enableCameraThread();
    this.d = true;
  }
  
  @SuppressLint({"NewApi"})
  private void x()
  {
    try
    {
      if (this.aT == null) {
        return;
      }
      String str = this.aT;
      s.onLog(r, this.e + "::: start aec dump " + str);
      this.u = ParcelFileDescriptor.open(new File(str), 1006632960);
      s.onLog(r, this.e + "::: aec dump fd " + this.u.getFd());
      c.startAecDump(this.u.getFd(), -1);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void y()
  {
    b.execute(new Runnable()
    {
      public void run()
      {
        if ((!d.am(d.this)) || (d.this.v == null)) {
          return;
        }
        d.ao(d.this);
        d.an(d.this);
      }
    });
  }
  
  private void z()
  {
    s.onLog(r, "capture share view display content");
    if ((!this.bF) || (this.v == null)) {
      return;
    }
    s.onLog(r, "capture bitmap -0- " + System.currentTimeMillis());
    this.v.setDrawingCacheEnabled(true);
    Bitmap localBitmap = Bitmap.createBitmap(this.v.getDrawingCache());
    this.v.setDrawingCacheEnabled(false);
    int i1 = localBitmap.getWidth();
    int i2 = localBitmap.getHeight();
    Matrix localMatrix = new Matrix();
    float f1 = 1.0F / com.superrtc.a.d.getZoomScale(i1, i2, 800);
    localMatrix.postScale(f1, f1);
    localBitmap = Bitmap.createBitmap(localBitmap, 0, 0, i1, i2, localMatrix, true);
    i1 = localBitmap.getWidth();
    i2 = localBitmap.getHeight();
    s.onLog(r, "capture bitmap -1- " + System.currentTimeMillis());
    inputExternalVideoData(rgb2yuv(localBitmap, i1, i2), i1, i2, 0);
  }
  
  public void SetMaxSendBandwidth(final int paramInt)
  {
    s.onLog(r, this.e + "::: [rapi]++ SetMaxSendBandwidth::" + paramInt);
    b.execute(new Runnable()
    {
      public void run()
      {
        if (d.a(d.this))
        {
          d.s.onLog(d.r, d.this.e + "::: skip SetMaxSendBandwidth because of conn is already hangup!");
          return;
        }
        if (d.R(d.this) != null) {
          d.R(d.this).SetMaxSendBandwidth(paramInt * 1000);
        }
        d.s.onLog(d.r, d.this.e + "::: [rapi]-- SetMaxSendBandwidth");
      }
    });
  }
  
  public void SetVideoResolution(final int paramInt1, final int paramInt2, final boolean paramBoolean)
  {
    s.onLog(r, this.e + "::: [rapi]++ SetVideoResolution " + paramInt1 + "*height enable:" + paramBoolean);
    b.execute(new Runnable()
    {
      public void run()
      {
        if (d.a(d.this))
        {
          d.s.onLog(d.r, d.this.e + "::: skip SetVideoResolution because of conn is already hangup!");
          return;
        }
        if (d.R(d.this) != null) {
          d.R(d.this).SetVideoResolution(paramInt1, paramInt2, paramBoolean);
        }
        d.s.onLog(d.r, d.this.e + "::: [rapi]-- SetVideoResolution");
      }
    });
  }
  
  public void TakePicture(String paramString)
  {
    this.aM.TakePicture(paramString);
  }
  
  public void addIceServer(final String paramString1, final String paramString2, final String paramString3)
  {
    s.onLog(r, "[rapi]++ addIceServer");
    b.execute(new Runnable()
    {
      public void run()
      {
        d.s.onLog(d.r, d.this.e + "::: [rapi]-- addIceServer");
        d.s.onLog(d.r, d.this.e + "::: add ice server: " + paramString1);
        d.c(d.this).add(new PeerConnection.e(paramString1, paramString2, paramString3));
      }
    });
  }
  
  public void addRenderer(final g paramg1, final g paramg2)
  {
    b.execute(new Runnable()
    {
      public void run()
      {
        d.s.onLog(d.r, "Add renderer start -0- name: " + d.this.e);
        if (d.a(d.this))
        {
          d.s.onLog(d.r, d.this.e + "::: skip addRenderer because of conn is already hangup!");
          return;
        }
        d.this.h = paramg2;
        d.this.g = paramg1;
        if (paramg2 != null) {
          d.this.j = paramg2.a();
        }
        if (paramg1 != null) {
          d.this.i = paramg1.a();
        }
        if ((d.this.l == null) && (d.this.h != null)) {
          d.this.l = new d.j(0, 0, 100, 100);
        }
        if ((d.this.k == null) && (d.this.g != null)) {
          if (paramg1 == paramg2) {
            break label290;
          }
        }
        label290:
        for (d.this.k = new d.j(0, 0, 100, 100);; d.this.k = new d.j(72, 72, 25, 25))
        {
          d.O(d.this);
          d.this.makeblack(false);
          d.s.onLog(d.r, d.this.e + "::: [rapi]-- setViews");
          return;
        }
      }
    });
  }
  
  public void addlocalstream()
  {
    Object localObject1 = com.superrtc.call.c.getDeviceName(0);
    Object localObject2 = com.superrtc.call.c.getNameOfFrontFacingDevice();
    if ((this.bu > 1) && (localObject2 != null)) {
      localObject1 = localObject2;
    }
    for (;;)
    {
      localObject2 = localObject1;
      if (this.z.b >= 0)
      {
        localObject2 = localObject1;
        if (this.z.b < this.bu) {
          localObject2 = com.superrtc.call.c.getDeviceName(this.z.b);
        }
      }
      s.onLog(r, this.e + "::: Opening camera: " + (String)localObject2);
      return;
    }
  }
  
  public void answer()
  {
    s.onLog(r, this.e + "::: [rapi]++ answer");
    b.execute(new Runnable()
    {
      public void run()
      {
        d.s.onLog(d.r, d.this.e + "::: [rapi]++ answer start -0-");
        if ((!d.this.q) && (!d.S(d.this)))
        {
          d.s.onLog(d.r, d.this.e + "::: accpet: NOT pranswer state");
          d.s.onLog(d.r, d.this.e + "::: [rapi]-- answer");
          return;
        }
        d.this.q = false;
        d.f(d.this);
        d.R(d.this).createAnswer(d.this.n, d.Q(d.this));
        if ((d.T(d.this) == PeerConnection.c.c) && (d.g(d.this) == "direct")) {}
        d.s.onLog(d.r, d.this.e + "::: [rapi]-- answer");
      }
    });
  }
  
  public void capturePicture(String paramString) {}
  
  public void changeVideoResolution(int paramInt1, int paramInt2)
  {
    if ((!this.aP) || (this.bv == null))
    {
      Log.e("RtcConn", "Failed to change capture format. Video: " + this.aP + ". Error : ");
      return;
    }
    this.bv.onOutputFormatRequest(paramInt1, paramInt2, 15);
    this.bv.changeCaptureFormat(paramInt1, paramInt2, 15);
  }
  
  public void clearIceServer()
  {
    s.onLog(r, this.e + "::: [rapi]++ clearIceServer");
    b.execute(new Runnable()
    {
      public void run()
      {
        d.s.onLog(d.r, d.this.e + "::: [rapi]-- clearIceServer");
        d.c(d.this).clear();
      }
    });
  }
  
  public void close()
  {
    s.onLog(r, this.e + "::: [rapi]++ close");
    b.execute(new Runnable()
    {
      public void run()
      {
        d.aa(d.this);
        d.s.onLog(d.r, d.this.e + "::: [rapi]-- close");
      }
    });
  }
  
  public void createOffer()
  {
    createOffer(null);
  }
  
  public void createOffer(g paramg)
  {
    s.onLog(r, this.e + "::: [rapi]++ createOffer");
    b.execute(new Runnable()
    {
      public void run()
      {
        if (d.a(d.this))
        {
          d.s.onLog(d.r, d.this.e + "::: skip createOffer because of conn is already hangup!");
          return;
        }
        d.c(d.this, true);
        d.R(d.this).createOffer(d.this.n, d.Q(d.this));
        d.s.onLog(d.r, d.this.e + "::: [rapi]-- createOffer");
      }
    });
  }
  
  public void enableFixedVideoResolution(boolean paramBoolean)
  {
    D = paramBoolean;
    c(paramBoolean);
  }
  
  public Map<Integer, Integer> getAudioVolume()
  {
    if (this.aM == null) {}
    long[][] arrayOfLong;
    do
    {
      return null;
      arrayOfLong = this.aM.getAudioLevel();
    } while (arrayOfLong == null);
    HashMap localHashMap = new HashMap();
    localHashMap.put(Integer.valueOf(-1), Integer.valueOf((int)arrayOfLong[1][0]));
    localHashMap.put(Integer.valueOf(-2), Integer.valueOf((int)arrayOfLong[1][1]));
    int i1 = 2;
    while (i1 < arrayOfLong[1].length)
    {
      localHashMap.put(Integer.valueOf((int)arrayOfLong[0][i1]), Integer.valueOf((int)arrayOfLong[1][i1]));
      s.onLog(r, "k:" + (int)arrayOfLong[0][i1] + ",v:" + (int)arrayOfLong[1][i1]);
      i1 += 1;
    }
    return localHashMap;
  }
  
  public int getCameraFacing()
  {
    if (this.bv == null)
    {
      s.onLog(r, this.e + "::: videoCapturer is null,Failed to getCameraFacing.");
      return -1;
    }
    return this.bv.getCurrentCameraId();
  }
  
  public String getName()
  {
    return this.e;
  }
  
  public String getReportString()
    throws JSONException
  {
    s.onLog(r, this.e + "::: [rapi]++ getReportString");
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("conn", this.K);
      localJSONObject.put("lvcodec", this.Q);
      localJSONObject.put("lacodec", this.R);
      localJSONObject.put("rvcodec", this.S);
      localJSONObject.put("racodec", this.T);
      localJSONObject.put("sentVB", this.av);
      localJSONObject.put("sentAB", this.ax);
      localJSONObject.put("recvVB", this.aw);
      localJSONObject.put("recvAB", this.ay);
      localJSONObject.put("sentVP", this.ar);
      localJSONObject.put("sentAP", this.at);
      localJSONObject.put("recvVP", this.aD);
      localJSONObject.put("recvAP", this.aF);
      localJSONObject.put("os", "a");
      if (this.j != null) {
        this.U = this.j.getframesReceived();
      }
      localJSONObject.put("rvfrm", this.U);
      s.onLog(r, this.e + "::: [rapi]-- getReportString");
      return localJSONObject.toString();
    }
    finally {}
  }
  
  public void handleFlashLight(final boolean paramBoolean)
  {
    if (this.i == null) {
      return;
    }
    b.execute(new Runnable()
    {
      public void run()
      {
        if (d.a(d.this)) {
          d.s.onLog(d.r, d.this.e + "::: skip flashlight because of conn is already hangup!");
        }
        while (d.b(d.this) == null) {
          return;
        }
        d.b(d.this).handleFlashLight(paramBoolean);
      }
    });
  }
  
  public void handleFocus(final int paramInt1, final int paramInt2, final int paramInt3, final int paramInt4)
  {
    if (this.i == null) {
      return;
    }
    final int i1 = this.i.getScreenWidth();
    final int i2 = this.i.getScreenHeight();
    b.execute(new Runnable()
    {
      public void run()
      {
        if (d.a(d.this)) {
          d.s.onLog(d.r, d.this.e + "::: skip handleFocus because of conn is already hangup!");
        }
        while (d.b(d.this) == null) {
          return;
        }
        d.b(d.this).handleFocusMetering(paramInt1, paramInt2, i1, i2, paramInt3, paramInt4);
      }
    });
  }
  
  public void handleManualFocus(final float paramFloat1, final float paramFloat2, final int paramInt1, final int paramInt2)
  {
    if (this.i == null) {
      return;
    }
    final int i1 = this.i.getScreenWidth();
    final int i2 = this.i.getScreenHeight();
    b.execute(new Runnable()
    {
      public void run()
      {
        if (d.a(d.this)) {
          d.s.onLog(d.r, d.this.e + "::: skip handleFocus because of conn is already hangup!");
        }
        while (d.b(d.this) == null) {
          return;
        }
        d.b(d.this).handleManualFocus(paramFloat1, paramFloat2, i1, i2, paramInt1, paramInt2);
      }
    });
  }
  
  public void handleManualZoom(final boolean paramBoolean, final int paramInt)
  {
    if (this.i == null) {
      return;
    }
    b.execute(new Runnable()
    {
      public void run()
      {
        if (d.a(d.this)) {
          d.s.onLog(d.r, d.this.e + "::: skip zoom because of conn is already hangup!");
        }
        while (d.b(d.this) == null) {
          return;
        }
        d.b(d.this).handleManualZoom(paramBoolean, paramInt);
      }
    });
  }
  
  public void handleZoom(final Float paramFloat)
  {
    b.execute(new Runnable()
    {
      public void run()
      {
        if (d.a(d.this)) {
          d.s.onLog(d.r, d.this.e + "::: skip handleZoom because of conn is already hangup!");
        }
        while (d.b(d.this) == null) {
          return;
        }
        d.b(d.this).handleZoom(paramFloat);
      }
    });
  }
  
  public void hangup()
  {
    s.onLog(r, this.e + "::: [rapi]++ hangup");
    b.execute(new Runnable()
    {
      public void run()
      {
        if (d.a(d.this))
        {
          d.s.onLog(d.r, d.this.e + "::: peer isHangup : " + d.a(d.this));
          return;
        }
        d.ab(d.this).cancel();
        d.h(d.this, true);
        d.i(d.this, false);
        d.this.v = null;
        d.this.makeblack(true);
        d.j(d.this, false);
        if (d.R(d.this) != null)
        {
          d.s.onLog(d.r, d.this.e + "::: RTC hangup close peerConnection");
          d.R(d.this).dispose();
          d.a(d.this, null);
        }
        if (d.ac(d.this) != null)
        {
          d.s.onLog(d.r, d.this.e + "::: RTC hangup close videosource");
          d.ac(d.this).dispose();
          d.a(d.this, null);
          if (d.this.i != null)
          {
            d.this.i.remove(d.N(d.this));
            d.b(d.this, null);
            d.this.i = null;
          }
          d.this.g = null;
        }
        if (d.this.j != null)
        {
          d.this.j.remove(d.J(d.this));
          d.a(d.this, null);
          d.this.j = null;
          d.this.h = null;
        }
        if (d.ad(d.this) != null)
        {
          d.ad(d.this).dispose();
          d.a(d.this, null);
        }
        d.this.t = null;
        d.s.onLog(d.r, d.this.e + "::: [rapi]++ onClosed");
        if (!d.a(d.this)) {
          d.E(d.this).onClosed(d.this);
        }
        d.s.onLog(d.r, d.this.e + "::: [rapi]-- hangup");
      }
    });
  }
  
  public void inputExternalVideoData(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    s.onLog(r, this.e + ", " + paramArrayOfByte.length + ",w:" + paramInt1 + ", h:" + paramInt2 + ", videoCapturer " + this.bv);
    if (this.bv != null)
    {
      Logging.e("RtcConn", this.e + ",w:" + paramInt1 + ", h:" + paramInt2);
      this.bv.inputExternalVideoData(paramArrayOfByte, paramInt1, paramInt2, paramInt3);
    }
  }
  
  public void interestAt(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    if (!this.aa) {
      handleFocus(paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  public String inverseSdpJson(String paramString)
    throws Exception
  {
    l locall = l.fromJson(paramString);
    if (locall.a.equalsIgnoreCase(l.a())) {
      paramString = l.a(new q(q.a.valueOf(l.b().toUpperCase()), locall.d), m(), "connectionId");
    }
    while (!locall.a.equalsIgnoreCase(l.b())) {
      return paramString;
    }
    return l.a(new q(q.a.valueOf(l.a().toUpperCase()), locall.d), m(), "connectionId");
  }
  
  public void makeblack(boolean paramBoolean)
  {
    s.onLog(r, this.e + "::: makeblack :" + paramBoolean);
    if (this.j != null) {
      this.j.makeblack(paramBoolean);
    }
    if (this.i != null) {
      this.i.makeblack(paramBoolean);
    }
  }
  
  public byte[] rgb2yuv(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    s.onLog(r, "rgb -> yuv -0- " + System.currentTimeMillis());
    int[] arrayOfInt = new int[paramInt1 * paramInt2];
    paramBitmap.getPixels(arrayOfInt, 0, paramInt1, 0, 0, paramInt1, paramInt2);
    paramBitmap.recycle();
    paramBitmap = new byte[paramInt1 * paramInt2 * 3 / 2];
    int i1 = 0;
    int i3 = paramInt1 * paramInt2;
    int i2 = 0;
    int i5 = 0;
    int i6;
    label89:
    int i4;
    int i9;
    int i8;
    int i7;
    if (i5 < paramInt2)
    {
      i6 = 0;
      if (i6 < paramInt1)
      {
        i4 = (arrayOfInt[i2] & 0xFF0000) >> 16;
        i9 = (arrayOfInt[i2] & 0xFF00) >> 8;
        int i10 = (arrayOfInt[i2] & 0xFF) >> 0;
        i8 = (i4 * 66 + i9 * 129 + i10 * 25 + 128 >> 8) + 16;
        i7 = (i4 * -38 - i9 * 74 + i10 * 112 + 128 >> 8) + 128;
        i9 = (i4 * 112 - i9 * 94 - i10 * 18 + 128 >> 8) + 128;
        if (i8 < 0)
        {
          i4 = 0;
          label234:
          paramBitmap[i1] = ((byte)i4);
          if ((i5 % 2 != 0) || (i2 % 2 != 0) || (i3 >= paramBitmap.length)) {
            break label435;
          }
          i8 = i3 + 1;
          if (i9 >= 0) {
            break label345;
          }
          i4 = 0;
          label276:
          paramBitmap[i3] = ((byte)i4);
          if (i7 >= 0) {
            break label368;
          }
          i3 = 0;
          label291:
          paramBitmap[i8] = ((byte)i3);
          i3 = i8 + 1;
        }
      }
    }
    label345:
    label368:
    label435:
    for (;;)
    {
      i6 += 1;
      i2 += 1;
      i1 += 1;
      break label89;
      i4 = i8;
      if (i8 <= 255) {
        break label234;
      }
      i4 = 255;
      break label234;
      if (i9 > 255)
      {
        i4 = 255;
        break label276;
      }
      i4 = i9;
      break label276;
      if (i7 > 255)
      {
        i3 = 255;
        break label291;
      }
      i3 = i7;
      break label291;
      i5 += 1;
      break;
      s.onLog(r, "rgb -> yuv -1- " + System.currentTimeMillis());
      return paramBitmap;
    }
  }
  
  public void setAspectMode(final a parama1, final a parama2)
  {
    s.onLog(r, this.e + "::: [rapi]++ setAspectMode Localaspectmode::" + parama1 + ",Remoteaspectmode::" + parama2);
    b.execute(new Runnable()
    {
      public void run()
      {
        if (parama1 == d.a.b)
        {
          d.a(d.this, o.c.b);
          if (parama2 != d.a.b) {
            break label110;
          }
          d.b(d.this, o.c.b);
        }
        for (;;)
        {
          d.P(d.this);
          d.s.onLog(d.r, d.this.e + "::: [rapi]-- setAspectMode");
          return;
          if (parama1 != d.a.a) {
            break;
          }
          d.a(d.this, o.c.a);
          break;
          label110:
          if (parama2 == d.a.a) {
            d.b(d.this, o.c.a);
          }
        }
      }
    });
  }
  
  public void setCallAudioSource(int paramInt)
  {
    com.superrtc.b.a.setCallAudioSource(paramInt);
  }
  
  public void setCaptureFromView(final View paramView)
  {
    b.execute(new Runnable()
    {
      public void run()
      {
        if (d.a(d.this)) {}
        do
        {
          do
          {
            return;
            d.this.v = paramView;
            d.l(d.this, false);
            if (d.this.v == null) {
              break;
            }
          } while (d.am(d.this));
          d.i(d.this, true);
          d.an(d.this);
          return;
        } while (!d.am(d.this));
        d.i(d.this, false);
      }
    });
  }
  
  public void setConfigure(final String paramString)
  {
    s.onLog(r, this.e + "::: [rapi]++ setConfigure");
    b.execute(new Runnable()
    {
      public void run()
      {
        d.s.onLog(d.r, "set Configure start -0- name: " + d.this.e);
        d.f(d.this, paramString);
        d.s.onLog(d.r, d.this.e + "::: [rapi]-- setConfigure");
      }
    });
  }
  
  public void setEnableExternalVideoData(boolean paramBoolean)
  {
    this.aa = paramBoolean;
  }
  
  public void setIceServer(final String paramString1, final String paramString2, final String paramString3)
  {
    s.onLog(r, this.e + "::: [rapi]++ setIceServer");
    b.execute(new Runnable()
    {
      public void run()
      {
        try
        {
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("url", paramString1);
          localJSONObject.put("username", paramString2);
          localJSONObject.put("credential", paramString3);
          JSONArray localJSONArray = new JSONArray();
          localJSONArray.put(localJSONObject);
          localJSONObject = new JSONObject();
          localJSONObject.put("iceServers", localJSONArray);
          d.f(d.this, localJSONObject.toString());
          d.s.onLog(d.r, d.this.e + "::: [rapi]-- setIceServer");
          return;
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            localJSONException.printStackTrace();
            d.s.onLog(d.r, d.this.e + "::: excpetion:" + localJSONException.getMessage());
          }
        }
      }
    });
  }
  
  public void setListener(final b paramb)
  {
    s.onLog(r, this.e + "::: [rapi]++ setListener");
    b.execute(new Runnable()
    {
      public void run()
      {
        if (d.a(d.this))
        {
          d.s.onLog(d.r, d.this.e + "::: skip setListener because of conn is already hangup!");
          return;
        }
        d.s.onLog(d.r, d.this.e + "::: [rapi]-- setListener");
        d.a(d.this, paramb);
      }
    });
  }
  
  public void setMaxVideoFrameRate(final int paramInt)
  {
    E = paramInt;
    s.onLog(r, this.e + "::: [rapi]++ SetMaxSendBandwidth fps:" + paramInt);
    b.execute(new Runnable()
    {
      public void run()
      {
        if (d.a(d.this))
        {
          d.s.onLog(d.r, d.this.e + "::: skip setMaxVideoFrameRate because of conn is already hangup!");
          return;
        }
        if (paramInt > 0) {
          PeerConnectionFactory.setconfigframerate(paramInt);
        }
        for (;;)
        {
          d.s.onLog(d.r, d.this.e + "::: [rapi]-- SetMaxSendBandwidth");
          return;
          PeerConnectionFactory.setconfigframerate(20);
        }
      }
    });
  }
  
  public void setMute(final boolean paramBoolean)
  {
    s.onLog(r, this.e + "::: [rapi]++ setMute ::" + paramBoolean);
    b.execute(new Runnable()
    {
      public void run()
      {
        d locald = d.this;
        if (!paramBoolean) {}
        for (boolean bool = true;; bool = false)
        {
          d.g(locald, bool);
          if (d.Y(d.this) != null) {
            d.Y(d.this).setEnabled(d.Z(d.this));
          }
          d.s.onLog(d.r, d.this.e + "::: [rapi]-- setMute");
          return;
        }
      }
    });
  }
  
  public String setRemoteCandidate(String paramString)
    throws Exception
  {
    s.onLog(r, this.e + "::: [rapi]++ setRemoteCandidate");
    paramString = l.fromJson(paramString);
    final l locall = b(paramString);
    if (locall != null)
    {
      b.execute(new Runnable()
      {
        public void run()
        {
          if (d.R(d.this) != null)
          {
            d.s.onLog(d.r, d.this.e + "::: add remoteCandidate:: " + locall.toString());
            d.R(d.this).addIceCandidate(locall);
            d.s.onLog(d.r, d.this.e + "::: [rapi]-- setRemoteCandidate");
            return;
          }
          d.s.onLog(d.r, d.this.e + "::: add pending candidate");
          synchronized (d.V(d.this))
          {
            d.V(d.this).add(locall);
            d.s.onLog(d.r, d.this.e + "::: [rapi]-- setRemoteCandidate");
            return;
          }
        }
      });
      return paramString.a;
    }
    throw new Exception("unknown type " + paramString.a);
  }
  
  public String setRemoteJson(String paramString)
    throws Exception
  {
    s.onLog(r, this.e + "::: remote json: " + paramString);
    s.onLog(r, this.e + "::: [rapi]++ setRemoteJson");
    paramString = l.fromJson(paramString);
    final Object localObject = a(paramString);
    if (localObject != null)
    {
      a((q)localObject);
      b.execute(new Runnable()
      {
        public void run()
        {
          d.s.onLog(d.r, "setRemoteJson start -0- name: " + d.this.e);
          if (d.a(d.this))
          {
            d.s.onLog(d.r, d.this.e + "::: skip setRemoteJson because of conn is already hangup!");
            return;
          }
          d.U(d.this);
          d.s.onLog(d.r, d.this.e + "::: [rapi]-- setRemoteJson remote sdp");
        }
      });
      return paramString.a;
    }
    localObject = b(paramString);
    if (localObject != null)
    {
      b.execute(new Runnable()
      {
        public void run()
        {
          d.s.onLog(d.r, "setRemoteJson remote candidate start -0- name: " + d.this.e);
          if (d.R(d.this) != null)
          {
            d.R(d.this).addIceCandidate(localObject);
            d.s.onLog(d.r, d.this.e + "::: [rapi]-- setRemoteJson remote candidate");
            return;
          }
          synchronized (d.V(d.this))
          {
            d.V(d.this).add(localObject);
            d.s.onLog(d.r, d.this.e + "::: [rapi]-- setRemoteJson remote candidate");
            return;
          }
        }
      });
      return paramString.a;
    }
    throw new Exception("unknown type " + paramString.a);
  }
  
  public String setRemoteSdp(String paramString)
    throws Exception
  {
    s.onLog(r, this.e + "::: [rapi]++ setRemoteSdp");
    s.onLog(r, this.e + "::: setRemoteSdp: " + paramString);
    paramString = l.fromJson(paramString);
    q localq = a(paramString);
    if (localq != null)
    {
      a(localq);
      b.execute(new Runnable()
      {
        public void run()
        {
          d.U(d.this);
          d.s.onLog(d.r, d.this.e + "::: [rapi]-- setRemoteSdp");
        }
      });
      return paramString.a;
    }
    throw new Exception("unknown type " + paramString.a);
  }
  
  public void setRotation(int paramInt)
  {
    this.ad = true;
    this.ac = paramInt;
    q();
  }
  
  public void setRtcCameraDataProcessor(k paramk)
  {
    this.Z = paramk;
    r();
  }
  
  public void setRtcGlTextureProcessor(m paramm)
  {
    this.ab = paramm;
    s();
  }
  
  public void setStatsEnable(boolean paramBoolean)
  {
    if (paramBoolean) {
      try
      {
        this.bh.schedule(new TimerTask()
        {
          public void run()
          {
            d.b().execute(new Runnable()
            {
              public void run()
              {
                d.F(d.this);
              }
            });
          }
        }, 0L, 1000L);
        return;
      }
      catch (Exception localException)
      {
        s.onLog(r, this.e + "::: Can not schedule statistics timer " + localException);
        return;
      }
    }
    this.bh.cancel();
  }
  
  public void setViews(g paramg1, g paramg2)
  {
    String str1 = "";
    if (paramg1 != null) {
      str1 = "" + " localView_ ";
    }
    String str2 = str1;
    if (paramg2 != null) {
      str2 = str1 + " remoteView_ ";
    }
    s.onLog(r, this.e + "::: [rapi]++ setViews" + str2);
    stopRenderer(this.g, this.h);
    addRenderer(paramg1, paramg2);
  }
  
  public void setenableaec(final boolean paramBoolean)
  {
    s.onLog(r, this.e + "::: [rapi]++ setenableaec:" + paramBoolean);
    b.execute(new Runnable()
    {
      public void run()
      {
        d.s.onLog(d.r, d.this.e + "::: [rapi]-- setenableaec");
        d.d(d.this, paramBoolean);
      }
    });
  }
  
  public void setenableagc(final boolean paramBoolean)
  {
    s.onLog(r, this.e + "::: [rapi]++ setenableagc:" + paramBoolean);
    b.execute(new Runnable()
    {
      public void run()
      {
        d.s.onLog(d.r, d.this.e + "::: [rapi]-- setenableagc");
        d.e(d.this, paramBoolean);
      }
    });
  }
  
  public void setenablens(final boolean paramBoolean)
  {
    s.onLog(r, this.e + "::: [rapi]++ setenablens:" + paramBoolean);
    b.execute(new Runnable()
    {
      public void run()
      {
        d.s.onLog(d.r, d.this.e + "::: [rapi]-- setenablens");
        d.f(d.this, paramBoolean);
      }
    });
  }
  
  public void startCapture()
  {
    s.onLog(r, this.e + "::: [rapi]++ startCapture");
    b.execute(new Runnable()
    {
      public void run()
      {
        d.s.onLog(d.r, "startCapture start -0- ");
        if ((d.b(d.this) == null) || (d.d(d.this)))
        {
          d.s.onLog(d.r, "Failed to startCapture. OpenCamera:" + d.d(d.this));
          d.s.onLog(d.r, d.this.e + "::: [rapi]-- startCapture");
          return;
        }
        d.af(d.this);
        d.ac(d.this).restart();
        d.l(d.this, true);
        d.s.onLog(d.r, d.this.e + "::: [rapi]-- startCapture");
      }
    });
  }
  
  public void startRecord(String paramString) {}
  
  public void stopCapture()
  {
    s.onLog(r, this.e + "::: [rapi]++ stopCapture");
    this.y = true;
    b.execute(new Runnable()
    {
      public void run()
      {
        if ((!d.d(d.this)) || (d.b(d.this) == null))
        {
          d.s.onLog(d.r, "Failed to stopCapture. OpenCamera:" + d.d(d.this));
          d.s.onLog(d.r, d.this.e + "::: [rapi]-- stopCapture");
          return;
        }
        d.ac(d.this).stop();
        d.l(d.this, false);
        d.s.onLog(d.r, d.this.e + "::: [rapi]-- stopCapture");
      }
    });
  }
  
  public String stopRecord()
  {
    return null;
  }
  
  public void stopRenderer(final g paramg1, final g paramg2)
  {
    if (!this.L) {
      return;
    }
    b.execute(new Runnable()
    {
      public void run()
      {
        d.this.makeblack(true);
        if ((paramg2 != null) && (d.this.h == paramg2) && (d.G(d.this) != null) && (d.H(d.this)) && (d.I(d.this) != null))
        {
          d.a(d.this, false);
          d.G(d.this).removeRenderer(d.I(d.this));
          d.this.l = null;
          d.a(d.this, null);
          if (d.this.j != null)
          {
            d.this.j.remove(d.J(d.this));
            d.a(d.this, null);
            d.this.j = null;
          }
          d.this.h = null;
        }
        if ((paramg1 != null) && (d.this.g == paramg1) && (d.K(d.this) != null) && (d.L(d.this)) && (d.M(d.this) != null))
        {
          d.b(d.this, false);
          d.K(d.this).removeRenderer(d.M(d.this));
          d.this.k = null;
          d.b(d.this, null);
          d.this.g = null;
          if (d.this.i != null)
          {
            d.this.i.remove(d.N(d.this));
            d.b(d.this, null);
            d.this.i = null;
          }
        }
      }
    });
  }
  
  public void switchAudio(final boolean paramBoolean)
  {
    b.execute(new Runnable()
    {
      public void run()
      {
        if (d.a(d.this))
        {
          d.s.onLog(d.r, d.this.e + "::: skip switchAudio because of conn is already hangup!");
          return;
        }
        d.e(d.this).f = paramBoolean;
        d.f(d.this);
      }
    });
  }
  
  public void switchCamera()
  {
    s.onLog(r, this.e + "::: [rapi]++ switchCamera");
    b.execute(new Runnable()
    {
      public void run()
      {
        if (d.a(d.this))
        {
          d.s.onLog(d.r, d.this.e + "::: skip switchCamera because of conn is already hangup!");
          return;
        }
        d.ae(d.this);
        d.s.onLog(d.r, d.this.e + "::: [rapi]-- switchCamera");
      }
    });
  }
  
  public void switchTorchOn(boolean paramBoolean)
  {
    b.execute(new Runnable()
    {
      public void run()
      {
        if (d.a(d.this)) {
          d.s.onLog(d.r, d.this.e + "::: skip switchTorchOn because of conn is already hangup!");
        }
        while ((d.d(d.this)) && (d.b(d.this) != null)) {
          return;
        }
        d.s.onLog(d.r, "Failed to switchTorchOn. OpenCamera:" + d.d(d.this));
        d.s.onLog(d.r, d.this.e + "::: [rapi]-- switchTorchOn");
      }
    });
  }
  
  public void switchVideo(final boolean paramBoolean)
  {
    b.execute(new Runnable()
    {
      public void run()
      {
        if (d.a(d.this)) {
          d.s.onLog(d.r, d.this.e + "::: skip switchVideo because of conn is already hangup!");
        }
        while (d.e(d.this) == null) {
          return;
        }
        d.e(d.this).e = paramBoolean;
        d.f(d.this);
      }
    });
  }
  
  public void takeCameraPicture(com.superrtc.a.g paramg)
  {
    if (!this.aa) {
      this.bv.takeCameraPicture(paramg);
    }
  }
  
  public void zoomWithFactor(Float paramFloat)
  {
    if (!this.aa) {
      handleZoom(paramFloat);
    }
  }
  
  public static enum a
  {
    private a() {}
  }
  
  public static abstract interface b
  {
    public abstract void onCandidateCompleted(d paramd);
    
    public abstract void onClosed(d paramd);
    
    public abstract void onConnected(d paramd);
    
    public abstract void onConnectionsetup(d paramd);
    
    public abstract void onDisconnected(d paramd);
    
    public abstract void onError(d paramd, String paramString);
    
    public abstract void onLocalCandidate(d paramd, String paramString);
    
    public abstract void onLocalSdp(d paramd, String paramString);
    
    public abstract void onStats(d paramd, d.n paramn);
  }
  
  private class c
    implements p
  {
    private c() {}
    
    public void onCreateFailure(String paramString)
    {
      d.g(d.this, "create local sdp failure: " + paramString);
    }
    
    public void onCreateSuccess(final q paramq)
    {
      d.s.onLog(d.r, "create local sdp success");
      d.b().execute(new Runnable()
      {
        public void run()
        {
          d.s.onLog(d.r, "create local sdp success start -0-");
          if (d.a(d.this))
          {
            d.s.onLog(d.r, d.this.e + "::: skip set local because of conn is already hangup!");
            return;
          }
          if (d.R(d.this) == null)
          {
            d.s.onLog(d.r, d.this.e + "::: skip set local because of null conn");
            return;
          }
          Object localObject = d.a(d.a(paramq.b, d.ai(d.this), true), d.aj(d.this), false);
          localObject = d.h(d.this, (String)localObject);
          String str = d.this.m.changeSSRC((String)localObject);
          q.a locala2 = paramq.a;
          q.a locala1 = locala2;
          localObject = str;
          if (d.this.q)
          {
            locala1 = locala2;
            localObject = str;
            if (!d.S(d.this))
            {
              localObject = str.replaceAll("a=recvonly", "a=inactive");
              localObject = d.this.m.processPranswer((String)localObject);
              locala1 = q.a.b;
            }
          }
          localObject = new q(locala1, (String)localObject);
          d.s.onLog(d.r, d.this.e + "::: Set local SDP " + ((q)localObject).a);
          d.a(d.this, (q)localObject);
          d.R(d.this).setLocalDescription(d.this.n, (q)localObject);
        }
      });
    }
    
    public void onSetFailure(String paramString)
    {
      d.g(d.this, "set local sdp failure: " + paramString);
    }
    
    public void onSetSuccess()
    {
      d.s.onLog(d.r, d.this.e + "::: set local sdp success");
      d.b().execute(new Runnable()
      {
        public void run()
        {
          d.s.onLog(d.r, "set local sdp success start -0-");
          if (d.a(d.this)) {
            d.s.onLog(d.r, d.this.e + "::: skip onSetSuccess because of conn is already hangup!");
          }
          while (d.R(d.this) == null) {
            return;
          }
          d.s.onLog(d.r, d.this.e + "::: [rapi] onLocalSdp");
          if (!d.a(d.this)) {
            d.E(d.this).onLocalSdp(d.this, d.l.a(d.ak(d.this), d.ag(d.this), "connectionId"));
          }
          d.al(d.this);
          d.i(d.this, "after local sdp: ");
        }
      });
    }
  }
  
  public static abstract interface d
  {
    public abstract void onLog(int paramInt, String paramString);
  }
  
  public static enum e
  {
    private e() {}
  }
  
  private class f
    implements PeerConnection.h
  {
    private f() {}
    
    public void onAddStream(final MediaStream paramMediaStream)
    {
      d.s.onLog(d.r, d.this.e + "::: onAddStream");
      d.b().execute(new Runnable()
      {
        public void run()
        {
          d.s.onLog(d.r, "onAddStream start -0-");
          if (d.a(d.this)) {
            d.s.onLog(d.r, d.this.e + "::: skip onAddStream because of conn is already hangup!");
          }
          while (d.R(d.this) == null) {
            return;
          }
          if ((paramMediaStream.a.size() > 1) || (paramMediaStream.b.size() > 1))
          {
            d.g(d.this, "Weird-looking stream: " + paramMediaStream);
            return;
          }
          if (paramMediaStream.b.size() == 1)
          {
            d.a(d.this, (VideoTrack)paramMediaStream.b.get(0));
            d.G(d.this).setEnabled(true);
            d.O(d.this);
            if (d.G(d.this) != null) {
              d.s.onLog(d.r, d.this.e + "::: onAddStream: remoteVideoTrack state " + d.G(d.this).state());
            }
          }
          d.this.p = paramMediaStream;
        }
      });
    }
    
    public void onDataChannel(DataChannel paramDataChannel)
    {
      d.s.onLog(d.r, d.this.e + "::: onDataChannel");
      d.g(d.this, "AppRTC doesn't use data channels, but got: " + paramDataChannel.label() + " anyway!");
    }
    
    public void onIceCandidate(final l paraml)
    {
      d.s.onLog(d.r, d.this.e + "::: [rapi]++ onlocalIceCandidate::" + paraml);
      d.b().execute(new Runnable()
      {
        public void run()
        {
          d.E(d.this).onLocalCandidate(d.this, d.l.a(paraml, d.ag(d.this), "connectionId"));
          d.s.onLog(d.r, d.this.e + "::: [rapi]-- onlocalIceCandidate");
        }
      });
    }
    
    public void onIceConnectionChange(final PeerConnection.c paramc)
    {
      d.s.onLog(d.r, d.this.e + ":::  ++ onIceConnectionChange: " + paramc + " (signalingState=" + d.R(d.this).signalingState() + ")");
      d.b().execute(new Runnable()
      {
        public void run()
        {
          d.s.onLog(d.r, "onIceConnectionChange: start -0- " + paramc);
          if (paramc == PeerConnection.c.c) {
            if (!d.ah(d.this))
            {
              d.s.onLog(d.r, d.this.e + "::: [rapi]++ onConnectionsetup");
              if (!d.a(d.this)) {
                d.E(d.this).onConnectionsetup(d.this);
              }
              d.j(d.this, true);
              d.s.onLog(d.r, d.this.e + "::: [rapi]++ connectType ::" + d.g(d.this));
              d.P(d.this);
              d.a(d.this, PeerConnection.c.c);
            }
          }
          for (;;)
          {
            d.s.onLog(d.r, d.this.e + "::: -- onIceConnectionChange: ");
            return;
            d.s.onLog(d.r, d.this.e + "::: [rapi]++ onConnected");
            if (d.a(d.this)) {
              break;
            }
            d.E(d.this).onConnected(d.this);
            break;
            if (paramc == PeerConnection.c.f)
            {
              d.s.onLog(d.r, d.this.e + "::: [rapi]++ onDisconnected");
              if (!d.a(d.this)) {
                d.E(d.this).onDisconnected(d.this);
              }
            }
            else if (paramc == PeerConnection.c.e)
            {
              d.g(d.this, "ICE connection failed.");
            }
          }
        }
      });
    }
    
    public void onIceConnectionReceivingChange(boolean paramBoolean)
    {
      d.s.onLog(d.r, d.this.e + "::: IceConnectionReceiving changed to " + paramBoolean);
    }
    
    public void onIceGatheringChange(PeerConnection.d paramd)
    {
      d.s.onLog(d.r, d.this.e + "::: IceGatheringState: " + paramd);
      if (paramd == PeerConnection.d.c)
      {
        d.s.onLog(d.r, d.this.e + "::: [rapi]++ onCandidateCompleted");
        if (!d.a(d.this)) {
          d.E(d.this).onCandidateCompleted(d.this);
        }
      }
    }
    
    public void onRemoveStream(final MediaStream paramMediaStream)
    {
      d.s.onLog(d.r, d.this.e + "::: onRemoveStream");
      d.b().execute(new Runnable()
      {
        public void run()
        {
          if (d.R(d.this) == null) {
            return;
          }
          d.a(d.this, null);
          ((VideoTrack)paramMediaStream.b.get(0)).dispose();
          if (paramMediaStream == d.this.p)
          {
            d.s.onLog(d.r, d.this.e + "::: remove remote stream");
            d.this.p = null;
            return;
          }
          d.s.onLog(d.r, d.this.e + "::: warning: remove known stream");
        }
      });
    }
    
    public void onRenegotiationNeeded()
    {
      d.s.onLog(d.r, d.this.e + "::: onRenegotiationNeeded");
    }
    
    public void onSignalingChange(PeerConnection.k paramk)
    {
      d.s.onLog(d.r, d.this.e + "::: onSignalingChange: " + paramk);
    }
  }
  
  public static class g
    extends d.h
  {
    public boolean a = true;
    public int b = -1;
    public boolean c = true;
    public boolean d = true;
    public boolean e = true;
    public boolean f = true;
    
    public g(boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString1, boolean paramBoolean3, int paramInt5, String paramString2, boolean paramBoolean4, boolean paramBoolean5)
    {
      super(paramBoolean2, paramInt1, paramInt2, paramInt3, paramInt4, paramString1, paramBoolean3, paramInt5, paramString2, paramBoolean4, paramBoolean5);
    }
    
    public void enableAudio(boolean paramBoolean1, boolean paramBoolean2)
    {
      this.f = paramBoolean1;
      this.d = paramBoolean2;
    }
    
    public void enableVideo(boolean paramBoolean1, boolean paramBoolean2)
    {
      this.e = paramBoolean1;
      this.c = paramBoolean2;
    }
  }
  
  public static class h
  {
    public boolean g;
    public boolean h;
    public int i;
    public int j;
    public int k;
    public int l;
    public String m;
    public boolean n;
    public int o;
    public String p;
    public boolean q;
    public boolean r;
    
    public h(boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString1, boolean paramBoolean3, int paramInt5, String paramString2, boolean paramBoolean4, boolean paramBoolean5)
    {
      this.g = paramBoolean1;
      this.h = paramBoolean2;
      this.i = paramInt1;
      this.j = paramInt2;
      this.k = paramInt3;
      this.l = paramInt4;
      this.m = paramString1;
      this.n = paramBoolean3;
      this.o = paramInt5;
      this.p = paramString2;
      this.q = paramBoolean4;
      this.r = paramBoolean5;
    }
    
    public String toString()
    {
      return "[videoCallEnabled=" + this.g + ", loopback=" + this.h + ", videoWidth=" + this.i + ", videoHeight=" + this.j + ", videoFps=" + this.k + ", videoStartBitrate=" + this.l + ", videoCodec=" + this.m + ", videoCodecHwAcceleration=" + this.n + ", audioStartBitrate=" + this.o + ", audioCodec=" + this.p + ", noAudioProcessing=" + this.q + ", cpuOveruseDetection=" + this.r + "]";
    }
  }
  
  private class i
    implements p
  {
    private i() {}
    
    public void onCreateFailure(String paramString)
    {
      d.g(d.this, "create local sdp failure: " + paramString);
    }
    
    public void onCreateSuccess(q paramq)
    {
      d.s.onLog(d.r, d.this.e + "::: create remote sdp success??");
    }
    
    public void onSetFailure(String paramString)
    {
      d.g(d.this, "set local sdp failure: " + paramString);
    }
    
    public void onSetSuccess()
    {
      d.s.onLog(d.r, d.this.e + "::: set remote sdp success");
      d.b().execute(new Runnable()
      {
        public void run()
        {
          d.s.onLog(d.r, "set remote sdp success start -0-");
          if (d.R(d.this) == null) {
            return;
          }
          d.al(d.this);
          d.i(d.this, "after remote sdp: ");
        }
      });
    }
  }
  
  public static class j
  {
    int a;
    int b;
    int c;
    int d;
    
    public j(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      this.a = paramInt1;
      this.b = paramInt2;
      this.c = paramInt3;
      this.d = paramInt4;
    }
  }
  
  public static abstract interface k
  {
    public abstract void onProcessData(byte[] paramArrayOfByte, Camera paramCamera, int paramInt1, int paramInt2, int paramInt3);
    
    public abstract void setResolution(int paramInt1, int paramInt2);
  }
  
  private static class l
  {
    private static final String f = q.a.a.name();
    private static final String g = q.a.c.name();
    private static final String h = q.a.b.name();
    String a;
    int b;
    String c;
    String d;
    long e;
    
    protected static String a(l paraml, long paramLong, String paramString)
    {
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("type", "candidate");
        localJSONObject.put("mlineindex", paraml.b);
        localJSONObject.put("mid", paraml.a);
        localJSONObject.put("candidate", paraml.c);
        localJSONObject.put("connId", paramString);
        localJSONObject.put("seq", paramLong);
        paraml = localJSONObject.toString();
        return paraml;
      }
      catch (JSONException paraml)
      {
        a.i("RtcConn", "Exception: " + paraml.getMessage());
        paraml.printStackTrace();
      }
      return null;
    }
    
    protected static String a(q paramq, long paramLong, String paramString)
    {
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("type", paramq.a.toString().toLowerCase());
        localJSONObject.put("sdp", paramq.b);
        localJSONObject.put("seq", paramLong);
        localJSONObject.put("connId", paramString);
        paramq = localJSONObject.toString();
        return paramq;
      }
      catch (JSONException paramq)
      {
        a.i("RtcConn", "Exception: " + paramq.getMessage());
        paramq.printStackTrace();
      }
      return null;
    }
    
    public static l fromJson(String paramString)
      throws JSONException
    {
      l locall = new l();
      paramString = (JSONObject)new JSONTokener(paramString).nextValue();
      locall.a = paramString.optString("type");
      locall.b = paramString.optInt("mlineindex", -1);
      locall.c = paramString.optString("candidate", null);
      locall.d = paramString.optString("sdp", null);
      locall.e = paramString.optLong("seq", -1L);
      return locall;
    }
    
    public boolean isSdp()
    {
      if (this.a == null) {}
      while ((!this.a.equalsIgnoreCase(f)) && (!this.a.equalsIgnoreCase(g)) && (!this.a.equalsIgnoreCase(h))) {
        return false;
      }
      return true;
    }
  }
  
  public static abstract interface m
  {
    public abstract void onDrawFrame(int paramInt1, int paramInt2, int paramInt3, float[] paramArrayOfFloat, int paramInt4);
  }
  
  public class n
  {
    public String a = "disconnect";
    public int b = 0;
    public int c = 0;
    public int d = 0;
    public int e = 0;
    public int f = 0;
    public int g = 0;
    public int h = 0;
    public int i = 0;
    public int j = 0;
    public int k = 0;
    public int l = 0;
    public int m = 0;
    public int n = 0;
    public int o = 0;
    public int p = 0;
    public int q = 0;
    public int r = 0;
    public int s = 0;
    public int t = 0;
    public int u = 0;
    public int v = 0;
    public int w = 0;
    public int x = 0;
    public int y = 0;
    public String z = "fullStats";
    
    public n() {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/superrtc/sdk/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */