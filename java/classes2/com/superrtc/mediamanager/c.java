package com.superrtc.mediamanager;

import android.content.Context;
import android.content.IntentFilter;
import android.content.pm.FeatureInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import com.superrtc.call.Logging;
import com.superrtc.sdk.d.b;
import com.superrtc.sdk.d.d;
import com.superrtc.sdk.d.n;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

public class c
{
  public static c a = null;
  static long c = 0L;
  private static com.superrtc.a.f d;
  private static boolean e = false;
  private static boolean f = false;
  private static Context l;
  private static a o = null;
  private static int p = -1;
  private static XClientBridger.a x = new XClientBridger.a()
  {
    public void onLog(int paramAnonymousInt, String paramAnonymousString)
    {
      Log.i("EMediaManager", paramAnonymousString);
    }
  };
  f b;
  private b g = new b();
  private e h;
  private boolean i;
  private Timer j;
  private k k;
  private AtomicBoolean m = new AtomicBoolean(true);
  private List<Long> n = new ArrayList();
  private boolean q = false;
  private int r = -1;
  private String s;
  private String t;
  private d.b u = new d.b()
  {
    public void onCandidateCompleted(final com.superrtc.sdk.d paramAnonymousd)
    {
      c.a().execute(new Runnable()
      {
        public void run()
        {
          if (!c.a(c.this, (i)paramAnonymousd, "didLocalCandidateComplete")) {
            return;
          }
          JSONObject localJSONObject = new JSONObject();
          try
          {
            localJSONObject.put("rtcId", paramAnonymousd.e);
            localJSONObject.put("op", "candDone");
            c.a(c.this).e.invokeWithDict(localJSONObject.toString(), null);
            return;
          }
          catch (JSONException localJSONException)
          {
            for (;;)
            {
              localJSONException.printStackTrace();
            }
          }
        }
      });
    }
    
    public void onClosed(final com.superrtc.sdk.d paramAnonymousd)
    {
      c.a().execute(new Runnable()
      {
        public void run()
        {
          if (!c.a(c.this, (i)paramAnonymousd, "didClose")) {
            return;
          }
          JSONObject localJSONObject = new JSONObject();
          try
          {
            localJSONObject.put("rtcId", paramAnonymousd.e);
            localJSONObject.put("op", "rtcClosed");
            c.a(c.this).e.invokeWithDict(localJSONObject.toString(), null);
            return;
          }
          catch (JSONException localJSONException)
          {
            for (;;)
            {
              localJSONException.printStackTrace();
            }
          }
        }
      });
    }
    
    public void onConnected(final com.superrtc.sdk.d paramAnonymousd)
    {
      c.a().execute(new Runnable()
      {
        public void run()
        {
          if (!c.a(c.this, (i)paramAnonymousd, "didReconnect")) {}
          for (;;)
          {
            return;
            JSONObject localJSONObject = new JSONObject();
            try
            {
              localJSONObject.put("rtcId", paramAnonymousd.e);
              localJSONObject.put("op", "rtcReconn");
              c.a(c.this).e.invokeWithDict(localJSONObject.toString(), null);
              if (c.b() == null) {
                continue;
              }
              c.b().onConnected(paramAnonymousd.e);
              return;
            }
            catch (JSONException localJSONException)
            {
              for (;;)
              {
                localJSONException.printStackTrace();
              }
            }
          }
        }
      });
    }
    
    public void onConnectionsetup(final com.superrtc.sdk.d paramAnonymousd)
    {
      c.a().execute(new Runnable()
      {
        public void run()
        {
          if (!c.a(c.this, (i)paramAnonymousd, "didSetup")) {}
          for (;;)
          {
            return;
            JSONObject localJSONObject = new JSONObject();
            try
            {
              localJSONObject.put("rtcId", paramAnonymousd.e);
              localJSONObject.put("op", "rtcSetup");
              c.a(c.this).e.invokeWithDict(localJSONObject.toString(), null);
              if (c.b() == null) {
                continue;
              }
              c.b().onConnectionsetup(paramAnonymousd.e);
              return;
            }
            catch (JSONException localJSONException)
            {
              for (;;)
              {
                localJSONException.printStackTrace();
              }
            }
          }
        }
      });
    }
    
    public void onDisconnected(final com.superrtc.sdk.d paramAnonymousd)
    {
      c.a().execute(new Runnable()
      {
        public void run()
        {
          if (!c.a(c.this, (i)paramAnonymousd, "didDisconnect")) {}
          for (;;)
          {
            return;
            JSONObject localJSONObject = new JSONObject();
            try
            {
              localJSONObject.put("rtcId", paramAnonymousd.e);
              localJSONObject.put("op", "rtcDisconn");
              c.a(c.this).e.invokeWithDict(localJSONObject.toString(), null);
              if (c.b() == null) {
                continue;
              }
              c.b().onDisconnected(paramAnonymousd.e);
              return;
            }
            catch (JSONException localJSONException)
            {
              for (;;)
              {
                localJSONException.printStackTrace();
              }
            }
          }
        }
      });
    }
    
    public void onError(final com.superrtc.sdk.d paramAnonymousd, final String paramAnonymousString)
    {
      c.a().execute(new Runnable()
      {
        public void run()
        {
          if (!c.a(c.this, (i)paramAnonymousd, "didError")) {
            return;
          }
          c.c().onLog(c.c.c.ordinal(), "rtc error: [" + paramAnonymousd.e + "]->[" + paramAnonymousString + "]");
          JSONObject localJSONObject = new JSONObject();
          try
          {
            localJSONObject.put("rtcId", paramAnonymousd.e);
            localJSONObject.put("op", "rtcError");
            c.a(c.this).e.invokeWithDict(localJSONObject.toString(), null);
            return;
          }
          catch (JSONException localJSONException)
          {
            for (;;)
            {
              localJSONException.printStackTrace();
            }
          }
        }
      });
    }
    
    public void onLocalCandidate(final com.superrtc.sdk.d paramAnonymousd, final String paramAnonymousString)
    {
      c.a().execute(new Runnable()
      {
        public void run()
        {
          if (!c.a(c.this, (i)paramAnonymousd, "didGetLocalCandidate")) {
            return;
          }
          JSONObject localJSONObject = new JSONObject();
          try
          {
            localJSONObject.put("rtcId", paramAnonymousd.e);
            localJSONObject.put("cand", paramAnonymousString);
            localJSONObject.put("op", "setLocalCand");
            c.a(c.this).e.invokeWithDict(localJSONObject.toString(), null);
            return;
          }
          catch (JSONException localJSONException)
          {
            for (;;)
            {
              localJSONException.printStackTrace();
            }
          }
        }
      });
    }
    
    public void onLocalSdp(final com.superrtc.sdk.d paramAnonymousd, final String paramAnonymousString)
    {
      c.a().execute(new Runnable()
      {
        public void run()
        {
          if (!c.a(c.this, (i)paramAnonymousd, "didGetLocalSdp")) {
            return;
          }
          JSONObject localJSONObject = new JSONObject();
          try
          {
            localJSONObject.put("rtcId", paramAnonymousd.e);
            localJSONObject.put("sdp", paramAnonymousString);
            localJSONObject.put("op", "setLocalSDP");
            c.a(c.this).e.invokeWithDict(localJSONObject.toString(), null);
            return;
          }
          catch (JSONException localJSONException)
          {
            for (;;)
            {
              localJSONException.printStackTrace();
            }
          }
        }
      });
    }
    
    public void onStats(final com.superrtc.sdk.d paramAnonymousd, final d.n paramAnonymousn)
    {
      c.a().execute(new Runnable()
      {
        public void run()
        {
          if (!c.a(c.this, (i)paramAnonymousd, "didGetStats")) {}
          for (;;)
          {
            return;
            JSONObject localJSONObject = new JSONObject();
            try
            {
              localJSONObject.put("rtcId", paramAnonymousd.e);
              localJSONObject.put("op", "rtcStatis");
              localJSONObject.put("conntype", paramAnonymousn.a);
              localJSONObject.put("rtt", paramAnonymousn.l);
              localJSONObject.put("llostratev", paramAnonymousn.k);
              localJSONObject.put("llostratea", paramAnonymousn.n);
              localJSONObject.put("rlostratev", paramAnonymousn.u);
              localJSONObject.put("rlostratea", paramAnonymousn.x);
              c.a(c.this).e.invokeWithDict(localJSONObject.toString(), null);
              if ((paramAnonymousd == null) || (!c.b(c.this).j) || (paramAnonymousd.f == null)) {
                continue;
              }
              c.this.b.invokeOnNotice(a.b.b, paramAnonymousd.e, paramAnonymousd.f, paramAnonymousn, c.b(c.this));
              return;
            }
            catch (JSONException localJSONException)
            {
              for (;;)
              {
                localJSONException.printStackTrace();
              }
            }
          }
        }
      });
    }
  };
  private k.a v = new k.a()
  {
    public void didCloseWithCode(k paramAnonymousk, int paramAnonymousInt, String paramAnonymousString, boolean paramAnonymousBoolean)
    {
      c.c().onLog(c.c.a.ordinal(), "webSocket: didCloseWithCode, code=[" + paramAnonymousInt + "], reason=[" + paramAnonymousString + "], wasClean=[" + paramAnonymousBoolean + "]");
      invokeConnWithWebsocket(paramAnonymousk, "connClosed");
    }
    
    public void didFailWithError(k paramAnonymousk, Exception paramAnonymousException)
    {
      c.c().onLog(c.c.c.ordinal(), "webSocket: didFailWithError, " + paramAnonymousException);
      invokeConnWithWebsocket(paramAnonymousk, "connFail");
    }
    
    public void didReceiveMessageWithData(k paramAnonymousk, byte[] paramAnonymousArrayOfByte)
    {
      c.c().onLog(c.c.a.ordinal(), "webSocket: didReceiveMessageWithData");
    }
    
    public void didReceiveMessageWithString(final k paramAnonymousk, final String paramAnonymousString)
    {
      c.a().execute(new Runnable()
      {
        public void run()
        {
          e locale = c.a(c.this, paramAnonymousk, "recvString");
          if (locale == null) {
            return;
          }
          c.c().onLog(c.c.a.ordinal(), "webSocket: didReceiveMessageWithString " + paramAnonymousString + " recvmesg:" + paramAnonymousString);
          c.a(c.this).e.jsonrecvstring(locale.a, paramAnonymousString);
        }
      });
    }
    
    public void didReceivePong(k paramAnonymousk, byte[] paramAnonymousArrayOfByte)
    {
      c.c().onLog(c.c.a.ordinal(), "WebSocket received pong, " + paramAnonymousArrayOfByte);
    }
    
    public void invokeConnWithWebsocket(final k paramAnonymousk, final String paramAnonymousString)
    {
      c.a().execute(new Runnable()
      {
        public void run()
        {
          e locale = c.a(c.this, paramAnonymousk, paramAnonymousString);
          if (locale == null) {
            c.c().onLog(c.c.c.ordinal(), "non-exist session [" + paramAnonymousString + "] for op [" + paramAnonymousString + "]");
          }
          for (;;)
          {
            return;
            JSONObject localJSONObject = new JSONObject();
            try
            {
              localJSONObject.put("connId", locale.a);
              localJSONObject.put("op", paramAnonymousString);
              int i = c.a(c.this).e.invokeWithDict(localJSONObject.toString(), null);
              if (i == 0) {
                continue;
              }
              c.c().onLog(c.c.c.ordinal(), "invokeConnWithWebsocket : fail with " + i);
              return;
            }
            catch (JSONException localJSONException)
            {
              for (;;)
              {
                localJSONException.printStackTrace();
              }
            }
          }
        }
      });
    }
    
    public void webSocketDidOpen(k paramAnonymousk)
    {
      c.c().onLog(c.c.a.ordinal(), "webSocket: webSocketDidOpen " + paramAnonymousk.b);
      invokeConnWithWebsocket(paramAnonymousk, "connOpened");
    }
  };
  private XClientBridger.b w = new XClientBridger.b()
  {
    public JSONObject onJsonCallback(JSONObject paramAnonymousJSONObject)
      throws JSONException, URISyntaxException
    {
      int j = 0;
      JSONObject localJSONObject = new JSONObject();
      Object localObject1 = paramAnonymousJSONObject.optString("op");
      c.c().onLog(c.c.a.ordinal(), "onJsonCallback dict::" + paramAnonymousJSONObject.toString());
      int i = j;
      long l;
      final e locale;
      if (((String)localObject1).equals("onEvent"))
      {
        l = paramAnonymousJSONObject.optInt("event");
        localObject1 = paramAnonymousJSONObject.optString("connId");
        locale = (e)c.a(c.this).h.get(localObject1);
        if (locale != null) {
          break label174;
        }
        c.c().onLog(c.c.c.ordinal(), "onEvent: can't find conn [" + (String)localObject1 + "]");
        i = j;
      }
      label174:
      Object localObject4;
      Object localObject3;
      Object localObject2;
      for (;;)
      {
        localJSONObject.put("op", "rsp");
        localJSONObject.put("status", i);
        return localJSONObject;
        c.c().onLog(c.c.a.ordinal(), "onEvent: connId=[" + (String)localObject1 + "] event=[" + l + "]");
        localObject1 = null;
        if (paramAnonymousJSONObject.has("argStr")) {
          localObject1 = paramAnonymousJSONObject.getString("argStr");
        }
        i = 0;
        if (paramAnonymousJSONObject.has("argInt")) {
          i = paramAnonymousJSONObject.getInt("argInt");
        }
        if (l == 1002L)
        {
          if (c.c(c.this) != null) {
            localObject1 = c.c(c.this);
          }
          i = 0;
          if (locale.g != null)
          {
            locale.g.close();
            locale.g = null;
            i = 1;
          }
          c.a(c.this, new k((String)localObject1, c.d(c.this), locale.a));
          locale.g = c.e(c.this);
          c.c().onLog(c.c.a.ordinal(), "opening websocket [" + locale.a + "] -> [" + locale.g.a + "]");
          locale.g.open();
          if (i != 0)
          {
            c.c().onLog(c.c.a.ordinal(), "reopening websocket [" + locale.a + "][" + locale.g + "] -> [" + (String)localObject1 + "%@]");
            i = j;
          }
          else
          {
            c.c().onLog(c.c.a.ordinal(), "opening websocket [" + locale.a + "][" + locale.g + "] -> [" + (String)localObject1 + "%@]");
            i = j;
          }
        }
        else if (l == 1040L)
        {
          i locali1 = (i)c.a(c.this).g.get(localObject1);
          i = 0;
          localObject4 = null;
          localObject3 = null;
          localObject2 = null;
          if (locali1 != null)
          {
            localObject4 = locali1.g;
            localObject3 = locali1.h;
            localObject2 = locali1.b;
            locali1.hangup();
            i = 1;
          }
          i locali2 = new i((String)localObject1);
          locali2.a = locale;
          locali2.c = -1;
          locali2.setListener(c.f(c.this));
          c.a(c.this).g.put(locali2.e, locali2);
          c.this.setRtc((String)localObject1, paramAnonymousJSONObject);
          if (i != 0)
          {
            c.c().onLog(c.c.a.ordinal(), "reopen rtc " + locali2.e);
            if ((localObject4 != null) && (localObject3 != null)) {
              locali2.setViews((com.superrtc.sdk.g)localObject4, (com.superrtc.sdk.g)localObject3);
            }
            for (;;)
            {
              if (localObject2 != null)
              {
                locali2.b = ((View)localObject2);
                locali2.setCaptureFromView((View)localObject2);
              }
              locali2.f = locali1.f;
              locali2.c = locali1.c;
              locali2.d = locali1.d;
              i = j;
              break;
              if (localObject3 != null) {
                locali2.setViews(null, (com.superrtc.sdk.g)localObject3);
              } else if (localObject4 != null) {
                locali2.setViews((com.superrtc.sdk.g)localObject4, null);
              }
            }
          }
          c.c().onLog(c.c.a.ordinal(), "new rtc " + locali2.e);
          i = j;
        }
        else if (l == 1044L)
        {
          c.a(c.this).a = ((String)localObject1);
          c.c().onLog(c.c.a.ordinal(), "set myRtcId: " + c.a(c.this).a);
          if (c.a(c.this).a != null)
          {
            c.a(c.this).k = locale;
            i = j;
            if (c.a(c.this).d != null)
            {
              paramAnonymousJSONObject = (i)c.a(c.this).g.get(localObject1);
              i = j;
              if (paramAnonymousJSONObject != null)
              {
                paramAnonymousJSONObject.setListener(c.f(c.this));
                paramAnonymousJSONObject.setViews(c.a(c.this).d, null);
                i = j;
              }
            }
          }
          else
          {
            c.a(c.this).k = null;
            i = j;
          }
        }
        else if (l == 1043L)
        {
          c.a(c.this).c = ((String)localObject1);
          i = j;
        }
        else if (l == 1041L)
        {
          localObject1 = (i)c.a(c.this).g.get(localObject1);
          paramAnonymousJSONObject = paramAnonymousJSONObject.optString("config");
          i = j;
          if (localObject1 != null)
          {
            i = j;
            if (!TextUtils.isEmpty(paramAnonymousJSONObject))
            {
              ((i)localObject1).setConfigure(paramAnonymousJSONObject);
              i = j;
            }
          }
        }
        else if (l == 1050L)
        {
          paramAnonymousJSONObject = (i)c.a(c.this).g.get(localObject1);
          if (paramAnonymousJSONObject != null) {
            paramAnonymousJSONObject.createOffer();
          }
          c.c().onLog(c.c.a.ordinal(), "creating offer...");
          i = j;
        }
        else if (l == 1042L)
        {
          paramAnonymousJSONObject = (i)c.a(c.this).g.get(localObject1);
          if (paramAnonymousJSONObject != null) {
            paramAnonymousJSONObject.hangup();
          }
          c.a(c.this).g.remove(localObject1);
          if (paramAnonymousJSONObject.e.equals(c.a(c.this).a))
          {
            c.a(c.this).a = null;
            c.a(c.this).k = null;
          }
          i = j;
          if (paramAnonymousJSONObject.e.equals(c.a(c.this).c))
          {
            c.a(c.this).c = null;
            i = j;
          }
        }
        else if (l == 1008L)
        {
          c.this.closeSession(locale);
          i = j;
        }
        else if ((l == 1053L) || (l == 1054L))
        {
          localObject2 = null;
          if (paramAnonymousJSONObject.has("rtcId")) {
            localObject2 = paramAnonymousJSONObject.getString("rtcId");
          }
          localObject3 = null;
          if (paramAnonymousJSONObject.has("sdp")) {
            localObject3 = paramAnonymousJSONObject.getString("sdp");
          }
          localObject1 = null;
          if (paramAnonymousJSONObject.has("cand")) {
            localObject1 = paramAnonymousJSONObject.getString("cand");
          }
          localObject2 = (i)c.a(c.this).g.get(localObject2);
          if ((localObject3 != null) && (localObject2 != null)) {}
          try
          {
            ((i)localObject2).setRemoteJson((String)localObject3);
            i = j;
            if (localObject1 != null)
            {
              i = j;
              if (localObject2 != null)
              {
                paramAnonymousJSONObject = (JSONObject)localObject1;
                if (c.g(c.this) != null) {
                  paramAnonymousJSONObject = ((String)localObject1).replaceAll("\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}", c.g(c.this));
                }
                try
                {
                  ((i)localObject2).setRemoteJson(paramAnonymousJSONObject);
                  i = j;
                }
                catch (Exception paramAnonymousJSONObject)
                {
                  paramAnonymousJSONObject.printStackTrace();
                  i = j;
                }
              }
            }
          }
          catch (Exception paramAnonymousJSONObject)
          {
            for (;;)
            {
              paramAnonymousJSONObject.printStackTrace();
            }
          }
        }
      }
      if (l == 1004L) {
        if (i == 0) {
          break label3267;
        }
      }
      for (;;)
      {
        if (i == 0) {
          c.this.b.invokeBlock(locale.h, localObject1, null, locale);
        }
        for (;;)
        {
          locale.h = null;
          i = j;
          break;
          c.this.closeSession(locale);
          paramAnonymousJSONObject = c.a(c.this, i, (String)localObject1);
          c.this.b.invokeBlock(locale.h, locale, paramAnonymousJSONObject, locale);
        }
        if (l == 1005L)
        {
          c.this.b.invokeOnExitConference(i, (String)localObject1, locale);
          i = j;
          break;
        }
        if (l == 1020L)
        {
          paramAnonymousJSONObject = new b.c((String)localObject1, paramAnonymousJSONObject.optString("memId"), paramAnonymousJSONObject.optString("ext"));
          c.this.b.invokeOnMemberJoin(paramAnonymousJSONObject, locale);
          i = j;
          break;
        }
        if (l == 1022L) {
          if (i == 0) {
            break label3262;
          }
        }
        for (;;)
        {
          paramAnonymousJSONObject = new b.c((String)localObject1, paramAnonymousJSONObject.optString("memId"), paramAnonymousJSONObject.optString("ext"));
          c.this.b.invokeOnMemberExit(paramAnonymousJSONObject, locale, i);
          i = j;
          break;
          boolean bool1;
          if ((l == 1030L) || (l == 1032L) || (l == 1034L))
          {
            localObject2 = paramAnonymousJSONObject.optString("memName");
            localObject3 = wrapStreamType(paramAnonymousJSONObject.optInt("streamType"));
            localObject4 = paramAnonymousJSONObject.optString("streamName");
            if (paramAnonymousJSONObject.optInt("voff") == 0)
            {
              bool1 = false;
              label1881:
              if (paramAnonymousJSONObject.optInt("aoff") != 0) {
                break label2074;
              }
            }
            label2074:
            for (boolean bool2 = false;; bool2 = true)
            {
              paramAnonymousJSONObject = new g((String)localObject1, (String)localObject2, (a.c)localObject3, (String)localObject4, bool1, bool2, paramAnonymousJSONObject.optString("ext"), paramAnonymousJSONObject.optInt("csrc"));
              if (l != 1030L) {
                break label2080;
              }
              c.a(c.this).l.put(localObject1, paramAnonymousJSONObject);
              if (paramAnonymousJSONObject.h != 0)
              {
                c.a(c.this).m.put(Integer.valueOf(paramAnonymousJSONObject.h), paramAnonymousJSONObject);
                c.c().onLog(c.c.a.ordinal(), "add stream csrc " + paramAnonymousJSONObject.h + ", streamId " + paramAnonymousJSONObject.a + ", memberName " + paramAnonymousJSONObject.c);
              }
              c.this.b.invokeOnStreamPublish(paramAnonymousJSONObject, locale);
              i = j;
              break;
              bool1 = true;
              break label1881;
            }
            label2080:
            if (l == 1032L)
            {
              c.a(c.this).l.remove(localObject1);
              if (paramAnonymousJSONObject.h != 0)
              {
                c.a(c.this).m.remove(Integer.valueOf(paramAnonymousJSONObject.h));
                c.c().onLog(c.c.a.ordinal(), "remove stream csrc " + paramAnonymousJSONObject.h + ", streamId " + paramAnonymousJSONObject.a + ", memberName " + paramAnonymousJSONObject.c);
              }
              c.this.b.invokeOnStopStream(paramAnonymousJSONObject, locale);
              i = j;
              break;
            }
            i = j;
            if (l != 1034L) {
              break;
            }
            c.a(c.this).l.put(localObject1, paramAnonymousJSONObject);
            localObject1 = (g)c.a(c.this).l.get(localObject1);
            if ((localObject1 != null) && (((g)localObject1).h != 0)) {
              c.a(c.this).m.remove(Integer.valueOf(paramAnonymousJSONObject.h));
            }
            if (paramAnonymousJSONObject.h != 0) {
              c.a(c.this).m.put(Integer.valueOf(paramAnonymousJSONObject.h), paramAnonymousJSONObject);
            }
            c.this.b.invokeOnUpdateStream(paramAnonymousJSONObject, locale);
            i = j;
            break;
          }
          if (l == 1046L)
          {
            paramAnonymousJSONObject = paramAnonymousJSONObject.optString("subsrId");
            c.a(c.this).j.put(paramAnonymousJSONObject, localObject1);
            if (localObject1 != null)
            {
              localObject1 = (i)c.a(c.this).g.get(localObject1);
              ((i)localObject1).setListener(c.f(c.this));
              paramAnonymousJSONObject = (b.d)c.a(c.this).i.get(paramAnonymousJSONObject);
              i = j;
              if (localObject1 == null) {
                break;
              }
              i = j;
              if (paramAnonymousJSONObject == null) {
                break;
              }
              i = j;
              if (paramAnonymousJSONObject.b == null) {
                break;
              }
              ((i)localObject1).setViews(null, paramAnonymousJSONObject.b);
              i = j;
              break;
            }
            c.a(c.this).i.remove(paramAnonymousJSONObject);
            i = j;
            break;
          }
          if (l == 1047L)
          {
            paramAnonymousJSONObject = paramAnonymousJSONObject.optString("subsrId");
            if (!TextUtils.isEmpty((CharSequence)localObject1))
            {
              localObject1 = (i)c.a(c.this).g.get(localObject1);
              if (localObject1 != null) {
                ((i)localObject1).setViews(null, null);
              }
            }
            i = j;
            if (TextUtils.isEmpty(paramAnonymousJSONObject)) {
              break;
            }
            c.a(c.this).i.remove(paramAnonymousJSONObject);
            i = j;
            break;
          }
          if (l == 1056L)
          {
            localObject1 = paramAnonymousJSONObject.optString("rtcId");
            int k = paramAnonymousJSONObject.optInt("x");
            int m = paramAnonymousJSONObject.optInt("y");
            i = paramAnonymousJSONObject.optInt("focus");
            j = paramAnonymousJSONObject.optInt("expo");
            int n = paramAnonymousJSONObject.optInt("zoom");
            int i1 = paramAnonymousJSONObject.optInt("pic");
            int i2 = paramAnonymousJSONObject.optInt("frz");
            int i3 = paramAnonymousJSONObject.optInt("tor");
            paramAnonymousJSONObject = (i)c.a(c.this).g.get(c.a(c.this).a);
            if ((!((String)localObject1).endsWith(c.a(c.this).a)) || (paramAnonymousJSONObject == null)) {
              break label3257;
            }
            if ((i >= 0) || (j >= 0))
            {
              if (i > 0)
              {
                i = 1;
                label2752:
                if (j <= 0) {
                  break label2979;
                }
                j = 1;
                label2758:
                c.c().onLog(c.c.a.ordinal(), "remote-camera: interestAt x=[" + k + "], y=[" + m + "], focus=" + i + ", expo=" + j);
                paramAnonymousJSONObject.interestAt(k, m, i, j, true);
              }
            }
            else
            {
              if (n >= 0)
              {
                localObject1 = Float.valueOf((float)(n / 10000.0D));
                c.c().onLog(c.c.a.ordinal(), "remote-camera: zoom factor [" + localObject1 + "]");
                paramAnonymousJSONObject.zoomWithFactor((Float)localObject1);
              }
              if (i1 > 0)
              {
                c.c().onLog(c.c.b.ordinal(), "Take picture -- command --");
                paramAnonymousJSONObject.takeCameraPicture(new com.superrtc.a.g()
                {
                  public void onDone(Object paramAnonymous2Object)
                  {
                    c.c().onLog(c.c.b.ordinal(), "Take picture -- success --" + paramAnonymous2Object);
                    locale.e.notice(locale, a.b.h, null, null, paramAnonymous2Object);
                  }
                });
              }
              if ((i2 >= 0) && (i3 < 0)) {
                break label3257;
              }
              if (!c.this.isSupportFlashLight()) {
                break label2990;
              }
              if (i3 <= 0) {
                break label2984;
              }
              bool1 = true;
              label2963:
              paramAnonymousJSONObject.handleFlashLight(bool1);
              i = 0;
            }
          }
          for (;;)
          {
            break;
            i = 0;
            break label2752;
            label2979:
            j = 0;
            break label2758;
            label2984:
            bool1 = false;
            break label2963;
            label2990:
            i = a.a.b.D;
            continue;
            if (l == 1058L)
            {
              localObject2 = paramAnonymousJSONObject.optString("arg2");
              paramAnonymousJSONObject = paramAnonymousJSONObject.optString("arg3");
              c.this.b.invokeOnNotice(c.wrapENoticeCode(i), (String)localObject1, (String)localObject2, paramAnonymousJSONObject, locale);
              if (i == a.b.f.n)
              {
                paramAnonymousJSONObject = (i)c.a(c.this).g.get(localObject1);
                localObject1 = localObject2;
              }
            }
            for (;;)
            {
              i = j;
              if (paramAnonymousJSONObject == null) {
                break;
              }
              paramAnonymousJSONObject.f = ((String)localObject1);
              c.c().onLog(c.c.b.ordinal(), "stream setup rtc " + paramAnonymousJSONObject.e + ", streamId " + paramAnonymousJSONObject.f);
              i = j;
              break;
              if (i == a.b.g.n)
              {
                paramAnonymousJSONObject = (i)c.a(c.this).g.get(localObject2);
                continue;
                i = j;
                if (l != 1048L) {
                  break;
                }
                localObject1 = paramAnonymousJSONObject.optString("rtcId");
                localObject1 = (i)c.a(c.this).g.get(localObject1);
                i = j;
                if (localObject1 == null) {
                  break;
                }
                ((i)localObject1).d = paramAnonymousJSONObject.optInt("csrc");
                i = j;
                break;
              }
              localObject1 = null;
              paramAnonymousJSONObject = null;
            }
            label3257:
            i = 0;
          }
          label3262:
          i = 0;
        }
        label3267:
        i = 0;
      }
    }
    
    public int onJsonSendWithConn(String paramAnonymousString1, String paramAnonymousString2)
    {
      paramAnonymousString1 = (e)c.a(c.this).h.get(paramAnonymousString1);
      c.c().onLog(c.c.a.ordinal(), "onJsonSendWithConn  send msg:" + paramAnonymousString2);
      paramAnonymousString1.g.send(paramAnonymousString2);
      return 0;
    }
    
    public a.c wrapStreamType(int paramAnonymousInt)
    {
      a.c[] arrayOfc = a.c.values();
      int j = arrayOfc.length;
      int i = 0;
      while (i < j)
      {
        a.c localc = arrayOfc[i];
        if (localc.d == paramAnonymousInt) {
          return localc;
        }
        i += 1;
      }
      throw new RuntimeException("Json str. error on = " + paramAnonymousInt);
    }
  };
  
  public c()
  {
    this.g.f = d;
    this.g.e = new XClientBridger(this.w);
    this.g.a = null;
    this.b = new f();
    setNetworkChangedListener();
    e();
    d.execute(new Runnable()
    {
      public void run()
      {
        JSONObject localJSONObject = new JSONObject();
        try
        {
          localJSONObject.put("op", "enableXest");
          localJSONObject.put("code", 1);
          c.a(c.this).e.invokeWithDict(localJSONObject.toString(), null);
          return;
        }
        catch (JSONException localJSONException)
        {
          localJSONException.printStackTrace();
        }
      }
    });
  }
  
  private b.a a(int paramInt, String paramString)
  {
    Object localObject;
    if (paramString != null)
    {
      localObject = paramString;
      if (paramString.length() != 0) {}
    }
    else
    {
      localObject = new JSONObject();
    }
    try
    {
      ((JSONObject)localObject).put("code", paramInt);
      ((JSONObject)localObject).put("op", "errDesc");
      String[] arrayOfString = new String[1];
      this.g.e.invokeWithDict(((JSONObject)localObject).toString(), arrayOfString);
      localObject = new JSONTokener(arrayOfString[0]);
    }
    catch (JSONException localJSONException2)
    {
      try
      {
        localObject = ((JSONObject)((JSONTokener)localObject).nextValue()).optString("desc");
        return b.a.newError(wrap(paramInt), (String)localObject);
        localJSONException2 = localJSONException2;
        localJSONException2.printStackTrace();
      }
      catch (JSONException localJSONException1)
      {
        for (;;)
        {
          localJSONException1.printStackTrace();
          String str = paramString;
        }
      }
    }
  }
  
  private e a(k paramk, String paramString)
  {
    e locale = (e)this.g.h.get(paramk.b);
    if ((locale != null) && (locale.g == paramk)) {
      return locale;
    }
    x.onLog(c.b.ordinal(), "NOT same websocket [" + paramk.b + "], origin=[" + paramString + "%@]");
    return null;
  }
  
  private void a(final e parame, final int paramInt)
  {
    d.execute(new Runnable()
    {
      public void run()
      {
        if (parame.k > 0) {}
        try
        {
          Thread.sleep(paramInt);
          Map localMap = com.superrtc.sdk.d.getAudioVolumeOfRTCMap(c.a(c.this).g);
          if ((localMap != null) && (localMap.size() > 0)) {
            c.a(c.this, parame, localMap);
          }
          c.a(c.this, parame, parame.k);
          return;
        }
        catch (InterruptedException localInterruptedException)
        {
          for (;;)
          {
            localInterruptedException.printStackTrace();
          }
        }
      }
    });
  }
  
  private void a(e parame, Map<String, Map<Integer, Integer>> paramMap)
  {
    HashMap localHashMap = new HashMap();
    Iterator localIterator = paramMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject1 = (String)localIterator.next();
      Object localObject2 = (Map)paramMap.get(localObject1);
      localObject1 = (i)this.g.g.get(localObject1);
      if ((localObject1 != null) && (((i)localObject1).a == parame))
      {
        int i1 = ((Integer)((Map)localObject2).get(Integer.valueOf(-1))).intValue();
        int i2 = ((Integer)((Map)localObject2).get(Integer.valueOf(-2))).intValue();
        Object localObject3;
        if (((i)localObject1).c == a.c.c.d)
        {
          localObject2 = ((Map)localObject2).keySet().iterator();
          while (((Iterator)localObject2).hasNext())
          {
            i2 = ((Integer)((Iterator)localObject2).next()).intValue();
            if (i2 >= 0)
            {
              localObject3 = (g)this.g.m.get(Integer.valueOf(i2));
              if (localObject3 != null)
              {
                h localh = new h(((g)localObject3).a);
                localHashMap.put(((g)localObject3).a, localh);
              }
              else if ((((i)localObject1).d != 0) && (((i)localObject1).d == i2))
              {
                localObject3 = new h(((i)localObject1).e);
                localHashMap.put(((i)localObject1).e, localObject3);
              }
              else
              {
                x.onLog(c.c.ordinal(), String.format("csrc:" + i2 + " incoming:" + i1, new Object[0]));
              }
            }
          }
        }
        else
        {
          localObject2 = (g)this.g.l.get(((i)localObject1).f);
          if ((i1 >= 800) && (localObject2 != null))
          {
            localObject3 = new h(((g)localObject2).a);
            localHashMap.put(((g)localObject2).a, localObject3);
          }
          if ((!this.i) && (i2 >= 800))
          {
            localObject2 = new h(((i)localObject1).e);
            localHashMap.put(((i)localObject1).e, localObject2);
          }
        }
      }
    }
    this.b.invokeOnNotice(a.b.j, "", "", localHashMap, parame);
  }
  
  private void a(boolean paramBoolean)
  {
    this.m.getAndSet(paramBoolean);
  }
  
  private boolean a(e parame, int paramInt, Object paramObject, b.b paramb)
  {
    if (paramInt != 0)
    {
      paramObject = b.a.newError(wrap(paramInt), null);
      this.b.invokeBlock(paramb, null, (b.a)paramObject, parame);
      return false;
    }
    this.b.invokeBlock(paramb, paramObject, null, parame);
    return true;
  }
  
  private boolean a(e parame, b.b paramb, boolean paramBoolean, String paramString)
  {
    if (parame == null)
    {
      x.onLog(c.c.ordinal(), "null  session , origin=" + paramString);
      this.b.invokeBlock(paramb, null, a(a.a.c.D, ""), parame);
      return false;
    }
    paramString = (e)this.g.h.get(parame.a);
    if ((paramString == null) && (paramBoolean))
    {
      x.onLog(c.c.ordinal(), "NOT join session[" + parame.a + "]");
      this.b.invokeBlock(paramb, null, a(a.a.l.D, null), parame);
      return false;
    }
    if ((paramString != null) && (!paramBoolean))
    {
      x.onLog(c.c.ordinal(), "already join session[" + parame.a + "]");
      this.b.invokeBlock(paramb, null, a(a.a.i.D, null), parame);
      return false;
    }
    return true;
  }
  
  private boolean a(e parame, b.b paramb, boolean paramBoolean, String paramString1, String paramString2)
  {
    Object localObject = this.g.i.get(paramString2);
    if ((localObject != null) && (!paramBoolean))
    {
      x.onLog(c.c.ordinal(), "already subscribed, session[" + parame.a + "], streamId[" + paramString1 + "], subsrId[" + paramString2 + "]");
      this.b.invokeBlock(paramb, parame, a(a.a.k.D, null), parame);
      return false;
    }
    if ((localObject == null) && (paramBoolean))
    {
      x.onLog(c.c.ordinal(), "NO subscribed, session[" + parame.a + "], streamId[" + paramString1 + "], subsrId[" + paramString2 + "]");
      this.b.invokeBlock(paramb, parame, a(a.a.n.D, null), parame);
      return false;
    }
    return true;
  }
  
  private boolean a(i parami, String paramString)
  {
    if ((i)this.g.g.get(parami.e) == parami) {
      return true;
    }
    x.onLog(c.b.ordinal(), "NOT same rtc [" + parami.e + "], origin=[" + paramString + "%@]");
    return false;
  }
  
  private void e()
  {
    com.superrtc.sdk.d.setRtcListener(new com.superrtc.sdk.e()
    {
      public void onError(com.superrtc.sdk.e.a paramAnonymousa)
      {
        switch (c.32.a[paramAnonymousa.ordinal()])
        {
        default: 
          return;
        case 1: 
          c.b(c.this).e.notice(c.b(c.this), a.b.l, null, null, null);
          return;
        }
        c.b(c.this).e.notice(c.b(c.this), a.b.m, null, null, null);
      }
    });
  }
  
  public static c getInstance()
  {
    if (a == null) {
      a = new c();
    }
    return a;
  }
  
  public static void initGlobal(Context paramContext)
  {
    if (e) {
      return;
    }
    l = paramContext;
    d = new com.superrtc.a.f();
    d.setPriority(10);
    d.requestStart();
    try
    {
      com.superrtc.sdk.d.initGlobal(paramContext, d);
      e = true;
      getInstance();
      return;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        paramContext.printStackTrace();
      }
    }
  }
  
  public static boolean isInit()
  {
    return e;
  }
  
  public static void setCameraFacing(int paramInt)
  {
    x.onLog(c.c.ordinal(), "[EMediaapi]++ setCameraFacing");
    d.execute(new Runnable()
    {
      public void run()
      {
        if (c.d() != this.a) {
          c.a(this.a);
        }
        i.setCameraFacing(this.a);
        c.c().onLog(c.c.c.ordinal(), "[EMediaapi]-- setCameraFacing");
      }
    });
  }
  
  public static void setLoggerDelegate(XClientBridger.a parama)
  {
    x = parama;
    com.superrtc.sdk.d.registerLogListener(new d.d()
    {
      public void onLog(int paramAnonymousInt, String paramAnonymousString)
      {
        c.c().onLog(paramAnonymousInt, paramAnonymousString);
      }
    });
  }
  
  public static void setManagerListener(a parama)
  {
    o = parama;
  }
  
  public static a.a wrap(int paramInt)
  {
    a.a[] arrayOfa = a.a.values();
    int i2 = arrayOfa.length;
    int i1 = 0;
    while (i1 < i2)
    {
      a.a locala = arrayOfa[i1];
      if (locala.D == paramInt) {
        return locala;
      }
      i1 += 1;
    }
    throw new RuntimeException("Json str. error on = " + paramInt);
  }
  
  public static a.b wrapENoticeCode(int paramInt)
  {
    a.b[] arrayOfb = a.b.values();
    int i2 = arrayOfb.length;
    int i1 = 0;
    while (i1 < i2)
    {
      a.b localb = arrayOfb[i1];
      if (localb.n == paramInt) {
        return localb;
      }
      i1 += 1;
    }
    throw new RuntimeException("Json str. error on = " + paramInt);
  }
  
  String a(String paramString)
  {
    return "rtc-" + paramString;
  }
  
  public void closeSession(e parame)
  {
    x.onLog(c.c.ordinal(), "[EMediaapi] closeSession");
    this.g.h.remove(parame.a);
    if (parame.g != null)
    {
      x.onLog(c.b.ordinal(), "close websocket [" + parame.a + "] -> [" + parame.g.a + "]");
      parame.g.close();
      parame.g = null;
    }
    if (parame == this.g.k) {
      this.g.k = null;
    }
    if (this.g.h.size() == 0) {
      stopTimer();
    }
  }
  
  public void computeFrameRate()
  {
    this.n.add(Long.valueOf(System.currentTimeMillis()));
    if (((Long)this.n.get(this.n.size() - 1)).longValue() - ((Long)this.n.get(0)).longValue() > 1000L)
    {
      removeFirst();
      long l1 = ((Long)this.n.get(this.n.size() - 1)).longValue();
      long l2 = ((Long)this.n.get(0)).longValue();
      float f1 = this.n.size() / (float)(l1 - l2);
      x.onLog(c.b.ordinal(), "Input frame rate: " + f1 * 1000.0F);
    }
  }
  
  public void enableStatistics(e parame, boolean paramBoolean)
  {
    parame.j = paramBoolean;
  }
  
  public void exit(final e parame, final int paramInt, final b.b paramb)
  {
    x.onLog(c.c.ordinal(), "[EMediaapi]++ exit");
    d.execute(new Runnable()
    {
      public void run()
      {
        if (!c.a(c.this, parame, paramb, true, "exit")) {
          return;
        }
        JSONObject localJSONObject = new JSONObject();
        try
        {
          localJSONObject.put("connId", parame.a);
          localJSONObject.put("reason", paramInt);
          localJSONObject.put("op", "exitTicket");
          int i = c.a(c.this).e.invokeWithDict(localJSONObject.toString(), null);
          c.a(c.this, parame, i, parame, paramb);
          c.c().onLog(c.c.c.ordinal(), "[EMediaapi]-- exit");
          return;
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            localJSONException.printStackTrace();
          }
        }
      }
    });
  }
  
  public void exit(e parame, b.b paramb)
  {
    exit(parame, 0, paramb);
  }
  
  public int getCameraFacing()
  {
    i locali = (i)this.g.g.get(this.g.a);
    if (locali == null) {
      return 0;
    }
    return locali.getCameraFacing();
  }
  
  public String getVersion()
  {
    return com.superrtc.sdk.d.getVersion();
  }
  
  public void inputExternalVideoData(final Bitmap paramBitmap)
  {
    if (this.m.get())
    {
      computeFrameRate();
      a(false);
      x.onLog(c.b.ordinal(), "input external video data -0- fps size " + this.n.size());
      d.execute(new Runnable()
      {
        public void run()
        {
          i locali = (i)c.a(c.this).g.get(c.a(c.this).b);
          if (locali != null)
          {
            int i = paramBitmap.getWidth();
            int j = paramBitmap.getHeight();
            locali.inputExternalVideoData(locali.rgb2yuv(paramBitmap, i, j), i, j, 0);
          }
          c.a(c.this, true);
          c.c().onLog(c.c.b.ordinal(), "input external video data -1-");
        }
      });
    }
  }
  
  public void inputExternalVideoData(final byte[] paramArrayOfByte, final int paramInt1, final int paramInt2, final int paramInt3)
  {
    d.execute(new Runnable()
    {
      public void run()
      {
        i locali = (i)c.a(c.this).g.get(c.a(c.this).c);
        if (locali != null) {
          locali.inputExternalVideoData(paramArrayOfByte, paramInt1, paramInt2, paramInt3);
        }
      }
    });
  }
  
  public boolean isSupportFlashLight()
  {
    if (getCameraFacing() == 1) {}
    for (;;)
    {
      return false;
      FeatureInfo[] arrayOfFeatureInfo = l.getPackageManager().getSystemAvailableFeatures();
      if (arrayOfFeatureInfo != null)
      {
        int i2 = arrayOfFeatureInfo.length;
        int i1 = 0;
        while (i1 < i2)
        {
          FeatureInfo localFeatureInfo = arrayOfFeatureInfo[i1];
          if ((localFeatureInfo != null) && ("android.hardware.camera.flash".equals(localFeatureInfo.name))) {
            return true;
          }
          i1 += 1;
        }
      }
    }
  }
  
  public void join(final e parame, final d paramd, final b.b paramb)
  {
    x.onLog(c.c.ordinal(), "[EMediaapi]++ join");
    d.execute(new Runnable()
    {
      public void run()
      {
        if (!c.a(c.this, parame, paramb, false, "join")) {
          return;
        }
        JSONObject localJSONObject = new JSONObject();
        if (paramd != null) {
          c.this.makePubArg(parame, a.c.a, paramd, localJSONObject);
        }
        parame.h = paramb;
        c.a(c.this).h.put(parame.a, parame);
        c.c().onLog(c.c.c.ordinal(), "startTimer");
        c.this.startTimer();
        try
        {
          localJSONObject.put("connId", parame.a);
          localJSONObject.put("ticket", parame.c);
          if (parame.i != null) {
            localJSONObject.put("ext", parame.i);
          }
          if (parame.d != null) {
            localJSONObject.put("nickName", parame.d);
          }
          localJSONObject.put("op", "tryTicket");
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            localJSONException.printStackTrace();
          }
        }
        c.a(c.this).e.invokeWithDict(localJSONObject.toString(), null);
        c.c().onLog(c.c.c.ordinal(), "[EMediaapi]-- join");
      }
    });
  }
  
  public void makePubArg(e parame, a.c paramc, d paramd, JSONObject paramJSONObject)
  {
    parame = paramd;
    if (paramd == null) {
      parame = new d();
    }
    try
    {
      paramJSONObject.put("pubtype", paramc.d);
      paramJSONObject.put("voff", parame.b);
      paramJSONObject.put("aoff", parame.c);
      paramJSONObject.put("useBackCamera", parame.e);
      paramJSONObject.put("vwidth", parame.f);
      paramJSONObject.put("vheight", parame.g);
      paramJSONObject.put("extVideoSrc", parame.j);
      if (parame.d != null) {
        paramJSONObject.put("streamExt", parame.d);
      }
      if (parame.a != null) {
        paramJSONObject.put("pubname", parame.a);
      }
      return;
    }
    catch (JSONException parame)
    {
      parame.printStackTrace();
    }
  }
  
  public void manualFocus(final float paramFloat1, final float paramFloat2, final int paramInt1, final int paramInt2)
  {
    x.onLog(c.c.ordinal(), "manualFocus -start- x:" + paramFloat1 + ", y:" + paramFloat2);
    d.execute(new Runnable()
    {
      public void run()
      {
        i locali = (i)c.a(c.this).g.get(c.a(c.this).a);
        if (locali != null) {
          locali.handleManualFocus(paramFloat1, paramFloat2, paramInt1, paramInt2);
        }
        c.c().onLog(c.c.c.ordinal(), "manualFocus -end- ");
      }
    });
  }
  
  public void manualZoom(final boolean paramBoolean, final int paramInt)
  {
    x.onLog(c.c.ordinal(), "manualZoom -start- zoomIn:" + paramBoolean + ", scale:" + paramInt);
    d.execute(new Runnable()
    {
      public void run()
      {
        i locali = (i)c.a(c.this).g.get(c.a(c.this).a);
        if (locali != null) {
          locali.handleManualZoom(paramBoolean, paramInt);
        }
        c.c().onLog(c.c.c.ordinal(), "manualZoom -start- ");
      }
    });
  }
  
  public e newSessionWithTicket(String paramString1, String paramString2, e.a parama)
    throws JSONException
  {
    x.onLog(c.c.ordinal(), "[EMediaapi]++ newSessionWithTicket ,aTicket=[" + paramString1 + "]");
    if (paramString1 == null) {
      Log.i("EMediaManager", "ticket is null");
    }
    this.h = new e(this, paramString1, (JSONObject)new JSONTokener(paramString1).nextValue(), paramString2);
    this.h.e = parama;
    paramString1 = this.h;
    e.f = d;
    x.onLog(c.c.ordinal(), "[EMediaapi]-- newSessionWithTicket ");
    return this.h;
  }
  
  public void publish(final e parame, final d paramd, final b.b paramb)
  {
    x.onLog(c.a.ordinal(), "publish config=" + paramd);
    if (!a(parame, paramb, true, "pub")) {
      return;
    }
    d.execute(new Runnable()
    {
      public void run()
      {
        Object localObject1 = new JSONObject();
        c.this.makePubArg(parame, paramd.i, paramd, (JSONObject)localObject1);
        try
        {
          ((JSONObject)localObject1).put("connId", parame.a);
          ((JSONObject)localObject1).put("op", "publish");
          Object localObject2 = new String[1];
          int i = c.a(c.this).e.invokeWithDict(((JSONObject)localObject1).toString(), (String[])localObject2);
          localObject1 = "";
          try
          {
            localObject2 = new JSONObject(localObject2[0]);
            if (((JSONObject)localObject2).has("pubId")) {
              localObject1 = ((JSONObject)localObject2).getString("pubId");
            }
          }
          catch (JSONException localJSONException1)
          {
            for (;;)
            {
              localJSONException1.printStackTrace();
              String str = "";
            }
          }
          if ((i == 0) && (paramd.isExternalVideoSource()))
          {
            localObject2 = (i)c.a(c.this).g.get(localObject1);
            if (localObject2 != null)
            {
              ((i)localObject2).setEnableExternalVideoData(true);
              if (paramd.h != null)
              {
                ((i)localObject2).b = paramd.h;
                ((i)localObject2).setCaptureFromView(((i)localObject2).b);
              }
            }
          }
          c.a(c.this, parame, i, localObject1, paramb);
          c.c().onLog(c.c.c.ordinal(), "[EMediaapi]-- publish");
          return;
        }
        catch (JSONException localJSONException2)
        {
          for (;;)
          {
            localJSONException2.printStackTrace();
          }
        }
      }
    });
  }
  
  public void remoteCameraZoomWith(final e parame, final String paramString, final float paramFloat, final b.b paramb)
  {
    x.onLog(c.c.ordinal(), "[EMediaapi]++ remoteCameraZoomWith ,streamId=[" + paramString + "] ,zoomFactor=[" + paramFloat + "]");
    d.execute(new Runnable()
    {
      public void run()
      {
        if (!c.a(c.this, parame, paramb, true, "remote-zoom")) {
          return;
        }
        int i = (int)(paramFloat * 10000.0F);
        JSONObject localJSONObject = new JSONObject();
        try
        {
          localJSONObject.put("zoom", i);
          localJSONObject.put("streamId", paramString);
          localJSONObject.put("connId", parame.a);
          localJSONObject.put("op", "cameraCtrl");
          c.a(c.this).e.invokeWithDict(localJSONObject.toString(), null);
          c.c().onLog(c.c.c.ordinal(), "[EMediaapi]-- remoteCameraZoomWith");
          return;
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            localJSONException.printStackTrace();
          }
        }
      }
    });
  }
  
  public void remoteCamerafocus(final e parame, final String paramString, final boolean paramBoolean1, final boolean paramBoolean2, final Point paramPoint, final b.b paramb)
  {
    x.onLog(c.c.ordinal(), "[EMediaapi]++ remoteCamerafocus ,streamId=[" + paramString + "] ,focus=[" + paramBoolean1 + "] ,exposure=[" + paramBoolean2 + "]");
    d.execute(new Runnable()
    {
      public void run()
      {
        int j = 1;
        if (!c.a(c.this, parame, paramb, true, "remote-focus")) {
          return;
        }
        int k = paramPoint.x;
        int m = paramPoint.y;
        int i;
        if (paramBoolean1 == true) {
          i = 1;
        }
        for (;;)
        {
          JSONObject localJSONObject;
          if (paramBoolean2 == true) {
            localJSONObject = new JSONObject();
          }
          try
          {
            localJSONObject.put("x", k * 10000);
            localJSONObject.put("y", m * 10000);
            localJSONObject.put("focus", i);
            localJSONObject.put("expo", j);
            localJSONObject.put("streamId", paramString);
            localJSONObject.put("connId", parame.a);
            localJSONObject.put("op", "cameraCtrl");
            c.a(c.this).e.invokeWithDict(localJSONObject.toString(), null);
            c.c().onLog(c.c.c.ordinal(), "[EMediaapi]-- remoteCamerafocus");
            return;
            i = 0;
            continue;
            j = 0;
          }
          catch (JSONException localJSONException)
          {
            for (;;)
            {
              localJSONException.printStackTrace();
            }
          }
        }
      }
    });
  }
  
  public void removeFirst()
  {
    this.n.remove(0);
    if (((Long)this.n.get(this.n.size() - 1)).longValue() - ((Long)this.n.get(0)).longValue() > 1000L) {
      removeFirst();
    }
  }
  
  public void sendCustomByMemberId(final e parame, final String paramString1, final String paramString2, final b.b paramb)
  {
    x.onLog(c.c.ordinal(), "sendCustomByMemberId -start- " + paramString1);
    d.execute(new Runnable()
    {
      public void run()
      {
        if (!c.a(c.this, parame, paramb, true, "send-custom")) {
          return;
        }
        JSONObject localJSONObject = new JSONObject();
        try
        {
          localJSONObject.put("memId", paramString1);
          localJSONObject.put("msg", paramString2);
          localJSONObject.put("connId", parame.a);
          localJSONObject.put("op", "sendCustom");
          c.a(c.this).e.invokeWithDict(localJSONObject.toString(), null);
          c.c().onLog(c.c.c.ordinal(), "sendCustomByMemberId -end- " + paramString1);
          return;
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            localJSONException.printStackTrace();
          }
        }
      }
    });
  }
  
  public void sendCustomByStreamId(final e parame, final String paramString1, final String paramString2, final b.b paramb)
  {
    x.onLog(c.c.ordinal(), "sendCustomByStreamId -start- " + paramString1);
    d.execute(new Runnable()
    {
      public void run()
      {
        if (!c.a(c.this, parame, paramb, true, "send-custom")) {
          return;
        }
        JSONObject localJSONObject = new JSONObject();
        try
        {
          localJSONObject.put("streamId", paramString1);
          localJSONObject.put("msg", paramString2);
          localJSONObject.put("connId", parame.a);
          localJSONObject.put("op", "sendCustom");
          c.a(c.this).e.invokeWithDict(localJSONObject.toString(), null);
          c.c().onLog(c.c.c.ordinal(), "sendCustomByStreamId -end- " + paramString1);
          return;
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            localJSONException.printStackTrace();
          }
        }
      }
    });
  }
  
  public void setAudioTalkerInterval(final int paramInt, b.b paramb)
  {
    if (!a(this.h, paramb, true, "set-audio-talker")) {
      return;
    }
    d.execute(new Runnable()
    {
      public void run()
      {
        int j = paramInt;
        int i = j;
        if (j < 50) {
          i = 300;
        }
        if ((i > 0) && (c.b(c.this).k <= 0)) {
          c.a(c.this, c.b(c.this), i);
        }
        c.b(c.this).k = i;
      }
    });
  }
  
  public void setDocDirectory(String paramString)
  {
    com.superrtc.sdk.d.setDocDirectory(paramString);
  }
  
  public void setLocalPreviewView(final com.superrtc.sdk.g paramg)
  {
    x.onLog(c.c.ordinal(), "[EMediaapi]++ setLocalPreviewView  ,localview=[" + paramg + "]");
    d.execute(new Runnable()
    {
      public void run()
      {
        c.a(c.this).d = paramg;
        if (c.a(c.this).a != null)
        {
          i locali = (i)c.a(c.this).g.get(c.a(c.this).a);
          if (locali != null) {
            locali.setViews(c.a(c.this).d, null);
          }
        }
        c.c().onLog(c.c.c.ordinal(), "[EMediaapi]-- setLocalPreviewView");
      }
    });
  }
  
  public void setMuteEnabled(final boolean paramBoolean)
  {
    this.i = paramBoolean;
    x.onLog(c.c.ordinal(), "[EMediaapi]++ setMuteEnabled ,enable=[" + paramBoolean + "]");
    d.execute(new Runnable()
    {
      public void run()
      {
        if (TextUtils.isEmpty(c.a(c.this).c)) {}
        i locali;
        do
        {
          return;
          locali = (i)c.a(c.this).g.get(c.a(c.this).c);
        } while (locali == null);
        locali.setMute(paramBoolean);
        JSONObject localJSONObject = new JSONObject();
        try
        {
          localJSONObject.put("rtcId", locali.e);
          localJSONObject.put("aoff", paramBoolean);
          localJSONObject.put("op", "rtcUpd");
          c.a(c.this).e.invokeWithDict(localJSONObject.toString(), null);
          c.c().onLog(c.c.c.ordinal(), "[EMediaapi]-- setMuteEnabled");
          return;
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            localJSONException.printStackTrace();
          }
        }
      }
    });
  }
  
  public void setNetworkChangedListener()
  {
    x.onLog(c.c.ordinal(), "Register network change receiver!");
    RTCNetworkReceiver localRTCNetworkReceiver = new RTCNetworkReceiver();
    localRTCNetworkReceiver.setNetworkListener(new RTCNetworkReceiver.b()
    {
      public void onNetworkChanged(int paramAnonymousInt)
      {
        c.c().onLog(c.c.c.ordinal(), "Network changed " + paramAnonymousInt);
        JSONObject localJSONObject = new JSONObject();
        try
        {
          localJSONObject.put("netStatus", paramAnonymousInt);
          localJSONObject.put("op", "netChanged");
          c.a(c.this).e.invokeWithDict(localJSONObject.toString(), null);
          return;
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            localJSONException.printStackTrace();
          }
        }
      }
    });
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
    l.registerReceiver(localRTCNetworkReceiver, localIntentFilter);
  }
  
  public void setRtc(String paramString, JSONObject paramJSONObject)
  {
    i locali = (i)this.g.g.get(paramString);
    if (this.q)
    {
      this.q = false;
      if (this.r != -1) {
        i.setCameraFacing(this.r);
      }
    }
    for (;;)
    {
      String str = null;
      if (paramJSONObject.has("config")) {
        str = paramJSONObject.optString("config");
      }
      if (str != null) {
        locali.setConfigure(str);
      }
      if (paramJSONObject.optInt("voff") != 0) {
        locali.stopCapture();
      }
      if (paramJSONObject.optInt("aoff") != 0) {
        locali.setMute(true);
      }
      if (paramJSONObject.optInt("useBackCamera") != 0) {
        i.setCameraFacing(0);
      }
      int i1 = paramJSONObject.optInt("pubType");
      locali.c = i1;
      if (i1 == a.c.b.d)
      {
        Logging.d("EMediaManager", "this is share view Rtc");
        locali.setEnableExternalVideoData(true);
        this.g.b = paramString;
      }
      return;
      i.setCameraFacing(p);
    }
  }
  
  public void setSession(final e parame, final String paramString)
  {
    d.execute(new Runnable()
    {
      public void run()
      {
        parame.d = paramString;
      }
    });
  }
  
  public void setSpecificServerUrl(final String paramString1, final String paramString2)
  {
    d.execute(new Runnable()
    {
      public void run()
      {
        c.a(c.this, paramString1);
        c.b(c.this, paramString2);
      }
    });
  }
  
  public void setSubscribeAudioMixEnabled(final boolean paramBoolean)
  {
    d.execute(new Runnable()
    {
      public void run()
      {
        int i;
        if (paramBoolean) {
          i = 1;
        }
        for (;;)
        {
          JSONObject localJSONObject = new JSONObject();
          try
          {
            localJSONObject.put("op", "enableSubsrAudioMix");
            localJSONObject.put("code", i);
            c.a(c.this).e.invokeWithDict(localJSONObject.toString(), null);
            return;
            i = 0;
          }
          catch (JSONException localJSONException)
          {
            for (;;)
            {
              localJSONException.printStackTrace();
            }
          }
        }
      }
    });
  }
  
  public void setVideoEnabled(final boolean paramBoolean)
  {
    x.onLog(c.c.ordinal(), "[EMediaapi]++ setVideoEnabled ,enable=[" + paramBoolean + "]");
    d.execute(new Runnable()
    {
      public void run()
      {
        if (c.a(c.this).a == null) {}
        i locali;
        do
        {
          return;
          locali = (i)c.a(c.this).g.get(c.a(c.this).a);
        } while (locali == null);
        JSONObject localJSONObject;
        if (paramBoolean)
        {
          locali.startCapture();
          localJSONObject = new JSONObject();
        }
        for (;;)
        {
          try
          {
            localJSONObject.put("rtcId", locali.e);
            if (paramBoolean) {
              continue;
            }
            bool = true;
            localJSONObject.put("voff", bool);
            localJSONObject.put("op", "rtcUpd");
          }
          catch (JSONException localJSONException)
          {
            boolean bool;
            localJSONException.printStackTrace();
            continue;
          }
          c.a(c.this).e.invokeWithDict(localJSONObject.toString(), null);
          c.c().onLog(c.c.c.ordinal(), "[EMediaapi]++ setVideoEnabled");
          return;
          locali.stopCapture();
          break;
          bool = false;
        }
      }
    });
  }
  
  public void setVideoViews(final String paramString, final com.superrtc.sdk.g paramg1, final com.superrtc.sdk.g paramg2, final boolean paramBoolean)
  {
    x.onLog(c.c.ordinal(), "[EMediaapi]++ setVideoViews ,streamId=[" + paramString + "] ,localview=[" + paramg1 + "] ,remoteview=[" + paramg2 + "] ,islocal=[" + paramBoolean + "]");
    d.execute(new Runnable()
    {
      public void run()
      {
        Object localObject1;
        if (paramBoolean)
        {
          c.a(c.this).d = paramg1;
          if (c.a(c.this).a != null)
          {
            localObject1 = (i)c.a(c.this).g.get(c.a(c.this).a);
            if (localObject1 != null) {
              ((i)localObject1).setViews(paramg2, null);
            }
          }
        }
        for (;;)
        {
          c.c().onLog(c.c.c.ordinal(), "[EMediaapi]-- setVideoViews ");
          return;
          localObject1 = c.this.a(paramString);
          Object localObject2;
          if (c.a(c.this).i.get(localObject1) != null)
          {
            if (paramg1 != paramg2)
            {
              c.a(c.this).i.remove(localObject1);
              localObject2 = (String)c.a(c.this).j.get(localObject1);
              if (localObject2 == null)
              {
                c.c().onLog(c.c.a.ordinal(), "rtcId is not exit");
                return;
              }
              localObject2 = (i)c.a(c.this).g.get(localObject2);
              if (localObject2 != null)
              {
                ((i)localObject2).setViews(null, paramg2);
                localObject2 = new b.d();
                ((b.d)localObject2).a = ((String)localObject1);
                ((b.d)localObject2).b = paramg2;
                c.a(c.this).i.put(localObject1, localObject2);
              }
            }
          }
          else
          {
            localObject2 = new b.d();
            ((b.d)localObject2).a = ((String)localObject1);
            ((b.d)localObject2).b = paramg2;
            c.a(c.this).i.put(localObject1, localObject2);
          }
        }
      }
    });
  }
  
  public boolean startRecordPlayout()
  {
    return com.superrtc.sdk.d.startRecordPlayout();
  }
  
  public void startTimer()
  {
    if (this.j == null) {
      this.j = new Timer();
    }
    try
    {
      this.j.schedule(new TimerTask()
      {
        public void run()
        {
          c.a().execute(new Runnable()
          {
            public void run()
            {
              c.this.timerDidFire();
            }
          });
        }
      }, 0L, 1000L);
      return;
    }
    catch (Exception localException)
    {
      x.onLog(c.c.ordinal(), "::: Can not schedule statistics timer " + localException);
    }
  }
  
  public void stopAudioTalker()
  {
    if (this.h != null) {
      this.h.k = 0;
    }
  }
  
  public String stopRecordPlayout()
  {
    return com.superrtc.sdk.d.stopRecordPlayout();
  }
  
  public void stopTimer()
  {
    d.execute(new Runnable()
    {
      public void run()
      {
        c.c().onLog(c.c.a.ordinal(), "stop timer");
        if (c.h(c.this) != null)
        {
          c.h(c.this).cancel();
          c.h(c.this).purge();
          c.a(c.this, null);
        }
      }
    });
  }
  
  public void subscribe(final e parame, final String paramString, final com.superrtc.sdk.g paramg, final b.b paramb)
  {
    x.onLog(c.c.ordinal(), "[EMediaapi]++ subscribe ,streamId=" + paramString + " ,remoteview=[" + paramg + "]");
    d.execute(new Runnable()
    {
      public void run()
      {
        boolean bool = false;
        if (!c.a(c.this, parame, paramb, true, "sub")) {}
        String str;
        do
        {
          return;
          str = c.this.a(paramString);
          c.c().onLog(c.c.b.ordinal(), "subscribing stream [" + paramString + "]with subsrId[" + str + "]");
        } while (!c.a(c.this, parame, paramb, false, paramString, str));
        Object localObject;
        if (c.a(c.this).i.get(str) == null)
        {
          localObject = new b.d();
          ((b.d)localObject).a = str;
          ((b.d)localObject).b = paramg;
          c.a(c.this).i.put(str, localObject);
        }
        for (;;)
        {
          if (paramg != null) {
            bool = true;
          }
          localObject = new JSONObject();
          try
          {
            ((JSONObject)localObject).put("subsrId", str);
            ((JSONObject)localObject).put("connId", parame.a);
            ((JSONObject)localObject).put("streamId", paramString);
            ((JSONObject)localObject).put("subSVideo", bool);
            ((JSONObject)localObject).put("op", "subscribe");
            i = c.a(c.this).e.invokeWithDict(((JSONObject)localObject).toString(), null);
            if (i != 0)
            {
              c.a(c.this).i.remove(str);
              c.a(c.this, parame, i, null, paramb);
              c.c().onLog(c.c.c.ordinal(), "[EMediaapi]-- subscribe");
              return;
              localObject = (b.d)c.a(c.this).i.get(str);
              ((b.d)localObject).a = str;
              ((b.d)localObject).b = paramg;
              c.a(c.this).i.put(str, localObject);
            }
          }
          catch (JSONException localJSONException)
          {
            for (;;)
            {
              int i;
              localJSONException.printStackTrace();
              continue;
              c.a(c.this, parame, i, str, paramb);
            }
          }
        }
      }
    });
  }
  
  public void switchCamera()
  {
    x.onLog(c.c.ordinal(), "[EMediaapi]++ switchCamera");
    d.execute(new Runnable()
    {
      public void run()
      {
        if (c.a(c.this).a == null) {}
        i locali;
        do
        {
          return;
          locali = (i)c.a(c.this).g.get(c.a(c.this).a);
        } while (locali == null);
        locali.switchCamera();
        c.c().onLog(c.c.c.ordinal(), "[EMediaapi]-- switchCamera");
      }
    });
  }
  
  public void switchTorchOn(final boolean paramBoolean)
  {
    x.onLog(c.c.ordinal(), "[EMediaapi]++ switchTorchOn ,on=[" + paramBoolean + "]");
    d.execute(new Runnable()
    {
      public void run()
      {
        if (c.a(c.this).a == null) {}
        i locali;
        do
        {
          return;
          locali = (i)c.a(c.this).g.get(c.a(c.this).a);
        } while (locali == null);
        locali.switchTorchOn(paramBoolean);
        c.c().onLog(c.c.c.ordinal(), "[EMediaapi]-- switchTorchOn");
      }
    });
  }
  
  public void timerDidFire()
  {
    d.execute(new Runnable()
    {
      public void run()
      {
        JSONObject localJSONObject = new JSONObject();
        try
        {
          localJSONObject.put("op", "timerCheck");
          int i = c.a(c.this).e.invokeWithDict(localJSONObject.toString(), null);
          if (i != 0) {
            c.c().onLog(c.c.c.ordinal(), "::: timerDidFire: fail with " + i);
          }
          return;
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            localJSONException.printStackTrace();
          }
        }
      }
    });
  }
  
  public void unpublish(final e parame, final String paramString, final b.b paramb)
  {
    x.onLog(c.c.ordinal(), "[EMediaapi]++ unpublish");
    d.execute(new Runnable()
    {
      public void run()
      {
        if (!c.a(c.this, parame, paramb, true, "unpub")) {
          return;
        }
        Object localObject1 = new JSONObject();
        try
        {
          ((JSONObject)localObject1).put("rtcId", paramString);
          ((JSONObject)localObject1).put("connId", parame.a);
          ((JSONObject)localObject1).put("op", "unpublish");
          Object localObject2 = (i)c.a(c.this).g.get(c.a(c.this).a);
          if (localObject2 == null)
          {
            localObject2 = new String[1];
            i = c.a(c.this).e.invokeWithDict(((JSONObject)localObject1).toString(), (String[])localObject2);
            localObject1 = new JSONTokener(localObject2[0]);
            new JSONObject();
          }
        }
        catch (JSONException localJSONException2)
        {
          try
          {
            for (;;)
            {
              int i;
              localObject1 = (JSONObject)((JSONTokener)localObject1).nextValue();
              c.a(c.this, parame, i, ((JSONObject)localObject1).optString("pubId"), paramb);
              c.c().onLog(c.c.c.ordinal(), "[EMediaapi]-- unpublish");
              return;
              localJSONException2 = localJSONException2;
              localJSONException2.printStackTrace();
            }
            c.b(c.this, true);
            c.a(c.this, localJSONException2.getCameraFacing());
          }
          catch (JSONException localJSONException1)
          {
            for (;;)
            {
              localJSONException1.printStackTrace();
            }
          }
        }
      }
    });
  }
  
  public void unsubscribe(final e parame, final String paramString, final b.b paramb)
  {
    x.onLog(c.c.ordinal(), "[EMediaapi]++ unsubscribe ,streamId=[" + paramString + "]");
    d.execute(new Runnable()
    {
      public void run()
      {
        if (!c.a(c.this, parame, paramb, true, "unsub")) {
          return;
        }
        String str = c.this.a(paramString);
        c.c().onLog(c.c.a.ordinal(), "unsubscribing  stream [" + paramString + "]with subsrId[" + str + "]");
        JSONObject localJSONObject = new JSONObject();
        try
        {
          localJSONObject.put("subsrId", str);
          localJSONObject.put("connId", parame.a);
          localJSONObject.put("op", "unsubscribe");
          int i = c.a(c.this).e.invokeWithDict(localJSONObject.toString(), null);
          c.a(c.this, parame, i, str, paramb);
          c.c().onLog(c.c.c.ordinal(), "[EMediaapi]-- unsubscribe");
          return;
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            localJSONException.printStackTrace();
          }
        }
      }
    });
  }
  
  public static abstract interface a
  {
    public abstract void onConnected(String paramString);
    
    public abstract void onConnectionsetup(String paramString);
    
    public abstract void onDisconnected(String paramString);
  }
  
  private class b
  {
    public String a;
    public String b;
    public String c;
    public com.superrtc.sdk.g d;
    public XClientBridger e;
    public com.superrtc.a.f f;
    public Map<String, i> g = new HashMap();
    public Map<String, e> h = new HashMap();
    public Map<String, b.d> i = new HashMap();
    public Map<String, String> j = new HashMap();
    public e k;
    public Map<String, g> l = new HashMap();
    public Map<Integer, g> m = new HashMap();
    
    public b() {}
  }
  
  private static enum c
  {
    private c() {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/superrtc/mediamanager/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */