package com.hyphenate.chat;

import android.graphics.Bitmap;
import com.hyphenate.EMConferenceListener;
import com.hyphenate.EMConferenceListener.ConferenceMode;
import com.hyphenate.EMConferenceListener.ConferenceState;
import com.hyphenate.EMValueCallBack;
import com.hyphenate.chat.adapter.EMACallConferenceListener;
import com.hyphenate.chat.adapter.EMACallManager;
import com.hyphenate.chat.adapter.EMAError;
import com.hyphenate.media.EMCallSurfaceView;
import com.hyphenate.util.EMLog;
import com.superrtc.mediamanager.a.a;
import com.superrtc.mediamanager.a.b;
import com.superrtc.mediamanager.b.a;
import com.superrtc.mediamanager.b.b;
import com.superrtc.mediamanager.b.c;
import com.superrtc.mediamanager.c;
import com.superrtc.mediamanager.d;
import com.superrtc.mediamanager.e;
import com.superrtc.mediamanager.e.a;
import com.superrtc.mediamanager.g;
import com.superrtc.sdk.VideoViewRenderer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONException;
import org.json.JSONObject;

public class EMConferenceManager
{
  private final String TAG = getClass().getSimpleName();
  private Map<String, EMConferenceStream> availableStreamMap = new ConcurrentHashMap();
  private List<EMConferenceListener> conferenceListeners = Collections.synchronizedList(new ArrayList());
  private EMConferenceListener.ConferenceMode conferenceMode = EMConferenceListener.ConferenceMode.NORMAL;
  private EMACallManager emaCallManager;
  private ExecutorService executorService;
  private c mediaManager = null;
  private e mediaSession = null;
  private List<String> memberList = Collections.synchronizedList(new ArrayList());
  e.a sessionDelegate = new e.a()
  {
    public void addStream(e paramAnonymouse, g arg2)
    {
      EMLog.d(EMConferenceManager.this.TAG, "onStreamAdded() memberName: " + ???.c + ", extension: " + ???.g + ", streamId: " + ???.a + ", streamName: " + ???.b + ", streamType: " + ???.d + ", audioOff: " + ???.f + ", videoOff: " + ???.e);
      paramAnonymouse = new EMConferenceStream();
      paramAnonymouse.init(???);
      EMConferenceManager.this.availableStreamMap.put(paramAnonymouse.getStreamId(), paramAnonymouse);
      synchronized (EMConferenceManager.this.conferenceListeners)
      {
        Iterator localIterator = EMConferenceManager.this.conferenceListeners.subList(0, EMConferenceManager.this.conferenceListeners.size()).iterator();
        if (localIterator.hasNext()) {
          ((EMConferenceListener)localIterator.next()).onStreamAdded(paramAnonymouse);
        }
      }
    }
    
    public void exitMember(e arg1, b.c paramAnonymousc)
    {
      EMLog.d(EMConferenceManager.this.TAG, "onMemberExited() memberName: " + paramAnonymousc.a + ", extension: " + paramAnonymousc.c);
      ??? = paramAnonymousc.a;
      paramAnonymousc = ???.substring(???.indexOf("_") + 1, ???.indexOf("@"));
      if (EMConferenceManager.this.memberList.contains(paramAnonymousc)) {
        EMConferenceManager.this.memberList.remove(paramAnonymousc);
      }
      synchronized (EMConferenceManager.this.conferenceListeners)
      {
        Iterator localIterator = EMConferenceManager.this.conferenceListeners.subList(0, EMConferenceManager.this.conferenceListeners.size()).iterator();
        if (localIterator.hasNext()) {
          ((EMConferenceListener)localIterator.next()).onMemberExited(paramAnonymousc);
        }
      }
    }
    
    public void joinMember(e arg1, b.c paramAnonymousc)
    {
      EMLog.d(EMConferenceManager.this.TAG, "onMemberJoined() memberName: " + paramAnonymousc.a + ", extension: " + paramAnonymousc.c);
      ??? = paramAnonymousc.a;
      paramAnonymousc = ???.substring(???.indexOf("_") + 1, ???.indexOf("@"));
      if (!EMConferenceManager.this.memberList.contains(paramAnonymousc)) {
        EMConferenceManager.this.memberList.add(paramAnonymousc);
      }
      synchronized (EMConferenceManager.this.conferenceListeners)
      {
        Iterator localIterator = EMConferenceManager.this.conferenceListeners.subList(0, EMConferenceManager.this.conferenceListeners.size()).iterator();
        if (localIterator.hasNext()) {
          ((EMConferenceListener)localIterator.next()).onMemberJoined(paramAnonymousc);
        }
      }
    }
    
    public void notice(e arg1, a.b paramAnonymousb, String paramAnonymousString1, String paramAnonymousString2, Object paramAnonymousObject)
    {
      EMLog.d(EMConferenceManager.this.TAG, "Notice code: " + paramAnonymousb + ", arg1=" + paramAnonymousString1 + ", arg2=" + paramAnonymousString2 + ", arg3=" + paramAnonymousObject);
      for (;;)
      {
        EMConferenceListener localEMConferenceListener;
        EMConferenceListener.ConferenceState localConferenceState;
        synchronized (EMConferenceManager.this.conferenceListeners)
        {
          Iterator localIterator = EMConferenceManager.this.conferenceListeners.subList(0, EMConferenceManager.this.conferenceListeners.size()).iterator();
          if (!localIterator.hasNext()) {
            break;
          }
          localEMConferenceListener = (EMConferenceListener)localIterator.next();
          localConferenceState = EMConferenceManager.this.stateMap(paramAnonymousb.n);
          if (localConferenceState == EMConferenceListener.ConferenceState.STATE_PUBLISH_SETUP) {
            localEMConferenceListener.onStreamSetup(paramAnonymousString1);
          }
        }
        if (localConferenceState == EMConferenceListener.ConferenceState.STATE_SUBSCRIBE_SETUP) {
          localEMConferenceListener.onStreamSetup(paramAnonymousString1);
        } else if (localConferenceState == EMConferenceListener.ConferenceState.STATE_STATISTICS) {
          EMLog.d(EMConferenceManager.this.TAG, "Notice state: " + localConferenceState + ", arg1=" + paramAnonymousString1 + ", arg2=" + paramAnonymousString2 + ", arg3=" + paramAnonymousObject);
        } else if ((localConferenceState != EMConferenceListener.ConferenceState.STATE_CUSTOM_MSG) && (localConferenceState != EMConferenceListener.ConferenceState.STATE_P2P_PEER_EXIT) && (localConferenceState != EMConferenceListener.ConferenceState.STATE_TAKE_CAMERA_PICTURE)) {
          if (localConferenceState == EMConferenceListener.ConferenceState.STATE_AUDIO_TALKERS) {
            localEMConferenceListener.onSpeakers(new ArrayList(((Map)paramAnonymousObject).keySet()));
          } else {
            localEMConferenceListener.onConferenceState(localConferenceState);
          }
        }
      }
    }
    
    public void passiveCloseReason(e arg1, int paramAnonymousInt, String paramAnonymousString)
    {
      EMLog.d(EMConferenceManager.this.TAG, "onPassiveLeave() code: " + paramAnonymousInt + ", reason: " + paramAnonymousString);
      synchronized (EMConferenceManager.this.conferenceListeners)
      {
        Iterator localIterator = EMConferenceManager.this.conferenceListeners.subList(0, EMConferenceManager.this.conferenceListeners.size()).iterator();
        if (localIterator.hasNext()) {
          ((EMConferenceListener)localIterator.next()).onPassiveLeave(paramAnonymousInt, paramAnonymousString);
        }
      }
    }
    
    public void removeStream(e arg1, g paramAnonymousg)
    {
      EMLog.d(EMConferenceManager.this.TAG, "onStreamRemoved() memberName: " + paramAnonymousg.c + ", extension: " + paramAnonymousg.g + ", streamId: " + paramAnonymousg.a + ", streamName: " + paramAnonymousg.b + ", streamType: " + paramAnonymousg.d + ", audioOff: " + paramAnonymousg.f + ", videoOff: " + paramAnonymousg.e);
      EMConferenceStream localEMConferenceStream;
      if (EMConferenceManager.this.availableStreamMap.containsKey(paramAnonymousg.a))
      {
        localEMConferenceStream = (EMConferenceStream)EMConferenceManager.this.availableStreamMap.get(paramAnonymousg.a);
        EMConferenceManager.this.availableStreamMap.remove(paramAnonymousg.a);
      }
      for (;;)
      {
        localEMConferenceStream.init(paramAnonymousg);
        EMConferenceManager.this.mediaManager.unsubscribe(???, paramAnonymousg.a, null);
        synchronized (EMConferenceManager.this.conferenceListeners)
        {
          paramAnonymousg = EMConferenceManager.this.conferenceListeners.subList(0, EMConferenceManager.this.conferenceListeners.size()).iterator();
          if (!paramAnonymousg.hasNext()) {
            break;
          }
          ((EMConferenceListener)paramAnonymousg.next()).onStreamRemoved(localEMConferenceStream);
        }
        if (EMConferenceManager.this.subscribedStreamMap.containsKey(paramAnonymousg.a))
        {
          localEMConferenceStream = (EMConferenceStream)EMConferenceManager.this.subscribedStreamMap.get(paramAnonymousg.a);
          EMConferenceManager.this.subscribedStreamMap.remove(paramAnonymousg.a);
        }
        else
        {
          localEMConferenceStream = new EMConferenceStream();
        }
      }
    }
    
    public void updateStream(e paramAnonymouse, g arg2)
    {
      EMLog.d(EMConferenceManager.this.TAG, "onStreamUpdate() memberName: " + ???.c + ", extension: " + ???.g + ", streamId: " + ???.a + ", streamName: " + ???.b + ", streamType: " + ???.d + ", audioOff: " + ???.f + ", videoOff: " + ???.e);
      if (EMConferenceManager.this.availableStreamMap.containsKey(???.a)) {
        paramAnonymouse = (EMConferenceStream)EMConferenceManager.this.availableStreamMap.get(???.a);
      }
      for (;;)
      {
        paramAnonymouse.init(???);
        synchronized (EMConferenceManager.this.conferenceListeners)
        {
          Iterator localIterator = EMConferenceManager.this.conferenceListeners.subList(0, EMConferenceManager.this.conferenceListeners.size()).iterator();
          if (!localIterator.hasNext()) {
            break;
          }
          ((EMConferenceListener)localIterator.next()).onStreamUpdate(paramAnonymouse);
        }
        if (EMConferenceManager.this.subscribedStreamMap.containsKey(???.a)) {
          paramAnonymouse = (EMConferenceStream)EMConferenceManager.this.subscribedStreamMap.get(???.a);
        } else {
          paramAnonymouse = new EMConferenceStream();
        }
      }
    }
  };
  private Map<String, EMConferenceStream> subscribedStreamMap = new ConcurrentHashMap();
  
  protected EMConferenceManager(EMACallManager paramEMACallManager)
  {
    this.emaCallManager = paramEMACallManager;
    if (!c.isInit()) {
      c.initGlobal(EMClient.getInstance().getContext());
    }
    this.mediaManager = c.getInstance();
    this.executorService = Executors.newCachedThreadPool();
    this.emaCallManager.setCallConferenceListener(new EMACallConferenceListener()
    {
      public void onReceiveInvite(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3)
      {
        synchronized (EMConferenceManager.this.conferenceListeners)
        {
          try
          {
            Iterator localIterator = EMConferenceManager.this.conferenceListeners.iterator();
            while (localIterator.hasNext()) {
              ((EMConferenceListener)localIterator.next()).onReceiveInvite(paramAnonymousString1, paramAnonymousString2, paramAnonymousString3);
            }
            paramAnonymousString1 = finally;
          }
          catch (Exception paramAnonymousString1)
          {
            paramAnonymousString1.printStackTrace();
            return;
          }
        }
      }
    });
    setSubscribeAudioMixEnable();
  }
  
  private d configWrap(EMStreamParam paramEMStreamParam)
  {
    if (paramEMStreamParam == null) {
      return null;
    }
    d locald;
    if (paramEMStreamParam.streamType == EMConferenceStream.StreamType.NORMAL) {
      if (this.conferenceMode == EMConferenceListener.ConferenceMode.LARGE) {
        locald = d.initAudioMixConfig();
      }
    }
    for (;;)
    {
      locald.setExtension(paramEMStreamParam.extension);
      locald.setMute(paramEMStreamParam.audioOff);
      locald.setVideoOff(paramEMStreamParam.videoOff);
      locald.setVwidth(paramEMStreamParam.videoWidth);
      locald.setVheight(paramEMStreamParam.videoHeight);
      locald.setPubView(paramEMStreamParam.shareView);
      locald.setUseBackCamera(paramEMStreamParam.useBackCamera);
      return locald;
      locald = d.initNormalConfig();
      continue;
      locald = d.initDesktopConfig();
    }
  }
  
  private int errorMap(int paramInt)
  {
    switch (paramInt)
    {
    case -1: 
    default: 
      return 1;
    case 0: 
      return 0;
    case -102: 
      return 818;
    case -106: 
      return 805;
    case -108: 
      return 2;
    case -109: 
      return 803;
    case -112: 
      return 819;
    case -113: 
      return 820;
    case -122: 
      return 806;
    case -123: 
      return 807;
    case -124: 
      return 808;
    case -142: 
      return 809;
    case -143: 
      return 810;
    case -144: 
      return 811;
    case -145: 
      return 812;
    case -404: 
      return 803;
    case -410: 
      return 821;
    case -411: 
      return 822;
    case -500: 
      return 813;
    case -502: 
      return 814;
    case -504: 
      return 815;
    }
    return 816;
  }
  
  private void setSubscribeAudioMixEnable()
  {
    if (this.conferenceMode == EMConferenceListener.ConferenceMode.LARGE)
    {
      this.mediaManager.setSubscribeAudioMixEnabled(false);
      return;
    }
    this.mediaManager.setSubscribeAudioMixEnabled(true);
  }
  
  private EMConferenceListener.ConferenceState stateMap(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return EMConferenceListener.ConferenceState.STATE_NORMAL;
    case 0: 
      return EMConferenceListener.ConferenceState.STATE_NORMAL;
    case 120: 
      return EMConferenceListener.ConferenceState.STATE_DISCONNECTION;
    case 121: 
      return EMConferenceListener.ConferenceState.STATE_RECONNECTION;
    case 122: 
      return EMConferenceListener.ConferenceState.STATE_POOR_QUALITY;
    case 123: 
      return EMConferenceListener.ConferenceState.STATE_PUBLISH_SETUP;
    case 124: 
      return EMConferenceListener.ConferenceState.STATE_SUBSCRIBE_SETUP;
    case 125: 
      return EMConferenceListener.ConferenceState.STATE_TAKE_CAMERA_PICTURE;
    case 126: 
      return EMConferenceListener.ConferenceState.STATE_CUSTOM_MSG;
    case 131: 
      return EMConferenceListener.ConferenceState.STATE_AUDIO_TALKERS;
    case 181: 
      return EMConferenceListener.ConferenceState.STATE_P2P_PEER_EXIT;
    case 201: 
      return EMConferenceListener.ConferenceState.STATE_OPEN_CAMERA_FAIL;
    }
    return EMConferenceListener.ConferenceState.STATE_OPEN_MIC_FAIL;
  }
  
  public void addConferenceListener(EMConferenceListener paramEMConferenceListener)
  {
    if ((paramEMConferenceListener != null) && (!this.conferenceListeners.contains(paramEMConferenceListener))) {
      this.conferenceListeners.add(paramEMConferenceListener);
    }
  }
  
  public void closeVideoTransfer()
  {
    this.mediaManager.setVideoEnabled(false);
  }
  
  public void closeVoiceTransfer()
  {
    this.mediaManager.setMuteEnabled(true);
  }
  
  public void createAndJoinConference(String paramString, EMValueCallBack<EMConference> paramEMValueCallBack)
  {
    createAndJoinConference(paramString, null, paramEMValueCallBack);
  }
  
  public void createAndJoinConference(final String paramString, final EMStreamParam paramEMStreamParam, final EMValueCallBack<EMConference> paramEMValueCallBack)
  {
    EMLog.d(this.TAG, "createAndJoinConference");
    this.executorService.execute(new Runnable()
    {
      public void run()
      {
        final Object localObject1 = new EMAError();
        Object localObject2 = EMConferenceManager.this.emaCallManager.creatorGetTicketFromServer("", paramString, (EMAError)localObject1);
        EMLog.d(EMConferenceManager.this.TAG, "Create conference result: " + (String)localObject2);
        if (((EMAError)localObject1).errCode() != 0)
        {
          paramEMValueCallBack.onError(((EMAError)localObject1).errCode(), ((EMAError)localObject1).errMsg());
          return;
        }
        localObject1 = new EMConference();
        try
        {
          localObject2 = new JSONObject((String)localObject2);
          String str = ((JSONObject)localObject2).optString("ticket");
          ((EMConference)localObject1).setConferenceId(((JSONObject)localObject2).optString("confId"));
          ((EMConference)localObject1).setPassword(paramString);
          EMLog.d(EMConferenceManager.this.TAG, "Join conference");
          EMConferenceManager.access$302(EMConferenceManager.this, EMConferenceManager.this.mediaManager.newSessionWithTicket(str, "{'extension':'creator'}", EMConferenceManager.this.sessionDelegate));
          EMConferenceManager.this.mediaManager.setSession(EMConferenceManager.this.mediaSession, EMClient.getInstance().getCurrentUser());
          EMConferenceManager.this.mediaManager.join(EMConferenceManager.this.mediaSession, EMConferenceManager.this.configWrap(paramEMStreamParam), new b.b()
          {
            public void onDone(Object paramAnonymous2Object, b.a paramAnonymous2a)
            {
              if (paramAnonymous2a != null)
              {
                EMLog.d(EMConferenceManager.this.TAG, "Join conference failed code=" + paramAnonymous2a.a + ", desc=" + paramAnonymous2a.b);
                if (EMConferenceManager.2.this.val$callback != null) {
                  EMConferenceManager.2.this.val$callback.onError(EMConferenceManager.this.errorMap(paramAnonymous2a.a.D), paramAnonymous2a.b);
                }
              }
              do
              {
                return;
                EMLog.d(EMConferenceManager.this.TAG, "Join conference success!");
              } while (EMConferenceManager.2.this.val$callback == null);
              localObject1.setPubStreamId((String)paramAnonymous2Object, EMConferenceStream.StreamType.NORMAL);
              EMConferenceManager.2.this.val$callback.onSuccess(localObject1);
            }
          });
          return;
        }
        catch (JSONException localJSONException)
        {
          localJSONException.printStackTrace();
          paramEMValueCallBack.onError(804, localJSONException.getMessage());
        }
      }
    });
  }
  
  public void enableStatistics(boolean paramBoolean)
  {
    this.mediaManager.enableStatistics(this.mediaSession, paramBoolean);
  }
  
  public void exitConference(final EMValueCallBack paramEMValueCallBack)
  {
    EMLog.d(this.TAG, "Exit conference - async");
    this.mediaManager.exit(this.mediaSession, new b.b()
    {
      public void onDone(Object paramAnonymousObject, b.a paramAnonymousa)
      {
        if (paramAnonymousa != null)
        {
          EMLog.d(EMConferenceManager.this.TAG, "Exit conference failed code=" + paramAnonymousa.a + ", desc=" + paramAnonymousa.b);
          if (paramEMValueCallBack != null) {
            paramEMValueCallBack.onError(EMConferenceManager.this.errorMap(paramAnonymousa.a.D), paramAnonymousa.b);
          }
        }
        for (;;)
        {
          EMConferenceManager.this.memberList.clear();
          EMConferenceManager.this.subscribedStreamMap.clear();
          EMConferenceManager.this.availableStreamMap.clear();
          return;
          EMLog.d(EMConferenceManager.this.TAG, "Exit conference success");
          if (paramEMValueCallBack != null) {
            paramEMValueCallBack.onSuccess(null);
          }
        }
      }
    });
  }
  
  public Map<String, EMConferenceStream> getAvailableStreamMap()
  {
    return this.availableStreamMap;
  }
  
  public int getCameraId()
  {
    return this.mediaManager.getCameraFacing();
  }
  
  public List<String> getConferenceMemberList()
  {
    return this.memberList;
  }
  
  public Map<String, EMConferenceStream> getSubscribedStreamMap()
  {
    return this.subscribedStreamMap;
  }
  
  public void inputExternalVideoData(Bitmap paramBitmap)
  {
    this.mediaManager.inputExternalVideoData(paramBitmap);
  }
  
  public void inputExternalVideoData(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    this.mediaManager.inputExternalVideoData(paramArrayOfByte, paramInt1, paramInt2, paramInt3);
  }
  
  public void inviteUserToJoinConference(final String paramString1, final String paramString2, final String paramString3, final String paramString4, final EMValueCallBack paramEMValueCallBack)
  {
    this.executorService.execute(new Runnable()
    {
      public void run()
      {
        EMLog.d(EMConferenceManager.this.TAG, "inviteUserToJoinConference");
        EMAError localEMAError = new EMAError();
        EMConferenceManager.this.emaCallManager.inviteUserToJoinConference(paramString1, paramString2, paramString3, paramString4, localEMAError);
        if (localEMAError.errCode() != 0)
        {
          EMLog.d(EMConferenceManager.this.TAG, "inviteUserToJoinConference failed " + localEMAError.errCode() + ", " + localEMAError.errMsg());
          paramEMValueCallBack.onError(localEMAError.errCode(), localEMAError.errMsg());
          return;
        }
        paramEMValueCallBack.onSuccess(null);
      }
    });
  }
  
  public void joinConference(String paramString1, String paramString2, EMValueCallBack<EMConference> paramEMValueCallBack)
  {
    joinConference(paramString1, paramString2, null, paramEMValueCallBack);
  }
  
  public void joinConference(final String paramString1, final String paramString2, final EMStreamParam paramEMStreamParam, final EMValueCallBack<EMConference> paramEMValueCallBack)
  {
    EMLog.d(this.TAG, "joinConference");
    this.executorService.execute(new Runnable()
    {
      public void run()
      {
        final Object localObject = new EMAError();
        String str = EMConferenceManager.this.emaCallManager.memberGetTicketFromServer(paramString1, paramString2, (EMAError)localObject);
        EMLog.d(EMConferenceManager.this.TAG, "Get conference result: " + str);
        if (((EMAError)localObject).errCode() != 0)
        {
          paramEMValueCallBack.onError(((EMAError)localObject).errCode(), ((EMAError)localObject).errMsg());
          return;
        }
        localObject = new EMConference();
        ((EMConference)localObject).setConferenceId(paramString1);
        ((EMConference)localObject).setPassword(paramString2);
        try
        {
          EMLog.d(EMConferenceManager.this.TAG, "Join conference");
          EMConferenceManager.access$302(EMConferenceManager.this, EMConferenceManager.this.mediaManager.newSessionWithTicket(str, "{'extension':'member'}", EMConferenceManager.this.sessionDelegate));
          EMConferenceManager.this.mediaManager.setSession(EMConferenceManager.this.mediaSession, EMClient.getInstance().getCurrentUser());
          EMConferenceManager.this.mediaManager.join(EMConferenceManager.this.mediaSession, EMConferenceManager.this.configWrap(paramEMStreamParam), new b.b()
          {
            public void onDone(Object paramAnonymous2Object, b.a paramAnonymous2a)
            {
              if (paramAnonymous2a != null)
              {
                EMLog.d(EMConferenceManager.this.TAG, "Join conference failed code=" + paramAnonymous2a.a + ", desc=" + paramAnonymous2a.b);
                if (EMConferenceManager.3.this.val$callback != null) {
                  EMConferenceManager.3.this.val$callback.onError(EMConferenceManager.this.errorMap(paramAnonymous2a.a.D), paramAnonymous2a.b);
                }
              }
              do
              {
                return;
                EMLog.d(EMConferenceManager.this.TAG, "Join conference success!");
              } while (EMConferenceManager.3.this.val$callback == null);
              localObject.setPubStreamId((String)paramAnonymous2Object, EMConferenceStream.StreamType.NORMAL);
              EMConferenceManager.3.this.val$callback.onSuccess(localObject);
            }
          });
          return;
        }
        catch (JSONException localJSONException)
        {
          localJSONException.printStackTrace();
          paramEMValueCallBack.onError(804, localJSONException.getMessage());
        }
      }
    });
  }
  
  public void openVideoTransfer()
  {
    this.mediaManager.setVideoEnabled(true);
  }
  
  public void openVoiceTransfer()
  {
    this.mediaManager.setMuteEnabled(false);
  }
  
  public void publish(EMStreamParam paramEMStreamParam, final EMValueCallBack<String> paramEMValueCallBack)
  {
    EMLog.d(this.TAG, "Publish local stream");
    this.mediaManager.publish(this.mediaSession, configWrap(paramEMStreamParam), new b.b()
    {
      public void onDone(Object paramAnonymousObject, b.a paramAnonymousa)
      {
        if (paramAnonymousa != null)
        {
          EMLog.d(EMConferenceManager.this.TAG, "Publish failed code=" + paramAnonymousa.a + ", desc=" + paramAnonymousa.b);
          if (paramEMValueCallBack != null) {
            paramEMValueCallBack.onError(EMConferenceManager.this.errorMap(paramAnonymousa.a.D), paramAnonymousa.b);
          }
        }
        do
        {
          return;
          EMLog.d(EMConferenceManager.this.TAG, "Publish success Stream id - " + paramAnonymousObject);
        } while (paramEMValueCallBack == null);
        paramEMValueCallBack.onSuccess((String)paramAnonymousObject);
      }
    });
  }
  
  public void removeConferenceListener(EMConferenceListener paramEMConferenceListener)
  {
    if (paramEMConferenceListener != null) {
      this.conferenceListeners.remove(paramEMConferenceListener);
    }
  }
  
  public void setConferenceMode(EMConferenceListener.ConferenceMode paramConferenceMode)
  {
    this.conferenceMode = paramConferenceMode;
    setSubscribeAudioMixEnable();
  }
  
  public void setLocalSurfaceView(EMCallSurfaceView paramEMCallSurfaceView)
  {
    VideoViewRenderer localVideoViewRenderer = null;
    if (paramEMCallSurfaceView != null) {
      localVideoViewRenderer = paramEMCallSurfaceView.getRenderer();
    }
    this.mediaManager.setLocalPreviewView(localVideoViewRenderer);
  }
  
  public void startMonitorSpeaker(int paramInt)
  {
    this.mediaManager.setAudioTalkerInterval(paramInt, new b.b()
    {
      public void onDone(Object paramAnonymousObject, b.a paramAnonymousa)
      {
        EMLog.d(EMConferenceManager.this.TAG, "error: " + paramAnonymousa.a + " desc:" + paramAnonymousa.b);
      }
    });
  }
  
  public void stopMonitorSpeaker()
  {
    this.mediaManager.stopAudioTalker();
  }
  
  public void subscribe(final EMConferenceStream paramEMConferenceStream, EMCallSurfaceView paramEMCallSurfaceView, final EMValueCallBack<String> paramEMValueCallBack)
  {
    EMLog.d(this.TAG, "Subscribe stream - async " + paramEMConferenceStream.toString());
    if (paramEMCallSurfaceView != null) {}
    for (paramEMCallSurfaceView = paramEMCallSurfaceView.getRenderer();; paramEMCallSurfaceView = null)
    {
      this.mediaManager.subscribe(this.mediaSession, paramEMConferenceStream.getStreamId(), paramEMCallSurfaceView, new b.b()
      {
        public void onDone(Object paramAnonymousObject, b.a paramAnonymousa)
        {
          if (paramAnonymousa != null)
          {
            EMLog.d(EMConferenceManager.this.TAG, "Subscribe failed code=" + paramAnonymousa.a + ", desc=" + paramAnonymousa.b);
            if (paramEMValueCallBack != null) {
              paramEMValueCallBack.onError(EMConferenceManager.this.errorMap(paramAnonymousa.a.D), paramAnonymousa.b);
            }
          }
          do
          {
            return;
            EMLog.d(EMConferenceManager.this.TAG, "Subscribe success Stream id - " + paramAnonymousObject);
            EMConferenceManager.this.subscribedStreamMap.put(paramEMConferenceStream.getStreamId(), paramEMConferenceStream);
            EMConferenceManager.this.availableStreamMap.remove(paramEMConferenceStream.getStreamId());
          } while (paramEMValueCallBack == null);
          paramEMValueCallBack.onSuccess((String)paramAnonymousObject);
        }
      });
      return;
    }
  }
  
  public void switchCamera()
  {
    this.mediaManager.switchCamera();
  }
  
  public void unpublish(String paramString, final EMValueCallBack<String> paramEMValueCallBack)
  {
    EMLog.d(this.TAG, "UNPublish local stream - async");
    this.mediaManager.unpublish(this.mediaSession, paramString, new b.b()
    {
      public void onDone(Object paramAnonymousObject, b.a paramAnonymousa)
      {
        if (paramAnonymousa != null)
        {
          EMLog.d(EMConferenceManager.this.TAG, "Unpublish failed code=" + paramAnonymousa.a + ", desc=" + paramAnonymousa.b);
          if (paramEMValueCallBack != null) {
            paramEMValueCallBack.onError(EMConferenceManager.this.errorMap(paramAnonymousa.a.D), paramAnonymousa.b);
          }
        }
        do
        {
          return;
          EMLog.d(EMConferenceManager.this.TAG, "Unpublish success Stream id - " + paramAnonymousObject);
        } while (paramEMValueCallBack == null);
        paramEMValueCallBack.onSuccess((String)paramAnonymousObject);
      }
    });
  }
  
  public void unsubscribe(final EMConferenceStream paramEMConferenceStream, final EMValueCallBack<String> paramEMValueCallBack)
  {
    EMLog.d(this.TAG, "UNSubscribe stream - async " + paramEMConferenceStream.toString());
    this.mediaManager.unsubscribe(this.mediaSession, paramEMConferenceStream.getStreamId(), new b.b()
    {
      public void onDone(Object paramAnonymousObject, b.a paramAnonymousa)
      {
        if (paramAnonymousa != null)
        {
          EMLog.d(EMConferenceManager.this.TAG, "Unsubscribe failed code=" + paramAnonymousa.a + ", desc=" + paramAnonymousa.b);
          if (paramEMValueCallBack != null) {
            paramEMValueCallBack.onError(EMConferenceManager.this.errorMap(paramAnonymousa.a.D), paramAnonymousa.b);
          }
        }
        do
        {
          return;
          EMLog.d(EMConferenceManager.this.TAG, "Unsubscribe success Stream id - " + paramAnonymousObject);
          EMConferenceManager.this.availableStreamMap.put(paramEMConferenceStream.getStreamId(), paramEMConferenceStream);
          EMConferenceManager.this.subscribedStreamMap.remove(paramEMConferenceStream.getStreamId());
        } while (paramEMValueCallBack == null);
        paramEMValueCallBack.onSuccess((String)paramAnonymousObject);
      }
    });
  }
  
  public void updateLocalSurfaceView(EMCallSurfaceView paramEMCallSurfaceView)
  {
    this.mediaManager.setVideoViews(null, paramEMCallSurfaceView.getRenderer(), null, true);
  }
  
  public void updateRemoteSurfaceView(String paramString, EMCallSurfaceView paramEMCallSurfaceView)
  {
    this.mediaManager.setVideoViews(paramString, null, paramEMCallSurfaceView.getRenderer(), false);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/hyphenate/chat/EMConferenceManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */