package android.support.v4.app;

import android.app.Notification;
import android.app.Notification.Builder;
import android.app.Notification.DecoratedCustomViewStyle;
import android.app.PendingIntent;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.SystemClock;
import android.support.compat.R.color;
import android.support.compat.R.dimen;
import android.support.compat.R.drawable;
import android.support.compat.R.id;
import android.support.compat.R.integer;
import android.support.compat.R.layout;
import android.support.compat.R.string;
import android.support.v4.text.BidiFormatter;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.TextAppearanceSpan;
import android.widget.RemoteViews;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class NotificationCompat
{
  public static final int BADGE_ICON_LARGE = 2;
  public static final int BADGE_ICON_NONE = 0;
  public static final int BADGE_ICON_SMALL = 1;
  public static final String CATEGORY_ALARM = "alarm";
  public static final String CATEGORY_CALL = "call";
  public static final String CATEGORY_EMAIL = "email";
  public static final String CATEGORY_ERROR = "err";
  public static final String CATEGORY_EVENT = "event";
  public static final String CATEGORY_MESSAGE = "msg";
  public static final String CATEGORY_PROGRESS = "progress";
  public static final String CATEGORY_PROMO = "promo";
  public static final String CATEGORY_RECOMMENDATION = "recommendation";
  public static final String CATEGORY_REMINDER = "reminder";
  public static final String CATEGORY_SERVICE = "service";
  public static final String CATEGORY_SOCIAL = "social";
  public static final String CATEGORY_STATUS = "status";
  public static final String CATEGORY_SYSTEM = "sys";
  public static final String CATEGORY_TRANSPORT = "transport";
  public static final int COLOR_DEFAULT = 0;
  public static final int DEFAULT_ALL = -1;
  public static final int DEFAULT_LIGHTS = 4;
  public static final int DEFAULT_SOUND = 1;
  public static final int DEFAULT_VIBRATE = 2;
  public static final String EXTRA_AUDIO_CONTENTS_URI = "android.audioContents";
  public static final String EXTRA_BACKGROUND_IMAGE_URI = "android.backgroundImageUri";
  public static final String EXTRA_BIG_TEXT = "android.bigText";
  public static final String EXTRA_COMPACT_ACTIONS = "android.compactActions";
  public static final String EXTRA_CONVERSATION_TITLE = "android.conversationTitle";
  public static final String EXTRA_INFO_TEXT = "android.infoText";
  public static final String EXTRA_LARGE_ICON = "android.largeIcon";
  public static final String EXTRA_LARGE_ICON_BIG = "android.largeIcon.big";
  public static final String EXTRA_MEDIA_SESSION = "android.mediaSession";
  public static final String EXTRA_MESSAGES = "android.messages";
  public static final String EXTRA_PEOPLE = "android.people";
  public static final String EXTRA_PICTURE = "android.picture";
  public static final String EXTRA_PROGRESS = "android.progress";
  public static final String EXTRA_PROGRESS_INDETERMINATE = "android.progressIndeterminate";
  public static final String EXTRA_PROGRESS_MAX = "android.progressMax";
  public static final String EXTRA_REMOTE_INPUT_HISTORY = "android.remoteInputHistory";
  public static final String EXTRA_SELF_DISPLAY_NAME = "android.selfDisplayName";
  public static final String EXTRA_SHOW_CHRONOMETER = "android.showChronometer";
  public static final String EXTRA_SHOW_WHEN = "android.showWhen";
  public static final String EXTRA_SMALL_ICON = "android.icon";
  public static final String EXTRA_SUB_TEXT = "android.subText";
  public static final String EXTRA_SUMMARY_TEXT = "android.summaryText";
  public static final String EXTRA_TEMPLATE = "android.template";
  public static final String EXTRA_TEXT = "android.text";
  public static final String EXTRA_TEXT_LINES = "android.textLines";
  public static final String EXTRA_TITLE = "android.title";
  public static final String EXTRA_TITLE_BIG = "android.title.big";
  public static final int FLAG_AUTO_CANCEL = 16;
  public static final int FLAG_FOREGROUND_SERVICE = 64;
  public static final int FLAG_GROUP_SUMMARY = 512;
  @Deprecated
  public static final int FLAG_HIGH_PRIORITY = 128;
  public static final int FLAG_INSISTENT = 4;
  public static final int FLAG_LOCAL_ONLY = 256;
  public static final int FLAG_NO_CLEAR = 32;
  public static final int FLAG_ONGOING_EVENT = 2;
  public static final int FLAG_ONLY_ALERT_ONCE = 8;
  public static final int FLAG_SHOW_LIGHTS = 1;
  public static final int GROUP_ALERT_ALL = 0;
  public static final int GROUP_ALERT_CHILDREN = 2;
  public static final int GROUP_ALERT_SUMMARY = 1;
  static final NotificationCompatImpl IMPL = new NotificationCompatBaseImpl();
  public static final int PRIORITY_DEFAULT = 0;
  public static final int PRIORITY_HIGH = 1;
  public static final int PRIORITY_LOW = -1;
  public static final int PRIORITY_MAX = 2;
  public static final int PRIORITY_MIN = -2;
  public static final int STREAM_DEFAULT = -1;
  public static final int VISIBILITY_PRIVATE = 0;
  public static final int VISIBILITY_PUBLIC = 1;
  public static final int VISIBILITY_SECRET = -1;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 26)
    {
      IMPL = new NotificationCompatApi26Impl();
      return;
    }
    if (Build.VERSION.SDK_INT >= 24)
    {
      IMPL = new NotificationCompatApi24Impl();
      return;
    }
    if (Build.VERSION.SDK_INT >= 21)
    {
      IMPL = new NotificationCompatApi21Impl();
      return;
    }
    if (Build.VERSION.SDK_INT >= 20)
    {
      IMPL = new NotificationCompatApi20Impl();
      return;
    }
    if (Build.VERSION.SDK_INT >= 19)
    {
      IMPL = new NotificationCompatApi19Impl();
      return;
    }
    if (Build.VERSION.SDK_INT >= 16)
    {
      IMPL = new NotificationCompatApi16Impl();
      return;
    }
  }
  
  static void addActionsToBuilder(NotificationBuilderWithActions paramNotificationBuilderWithActions, ArrayList<Action> paramArrayList)
  {
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext()) {
      paramNotificationBuilderWithActions.addAction((Action)paramArrayList.next());
    }
  }
  
  public static Action getAction(Notification paramNotification, int paramInt)
  {
    return IMPL.getAction(paramNotification, paramInt);
  }
  
  public static int getActionCount(Notification paramNotification)
  {
    int i = 0;
    if (Build.VERSION.SDK_INT >= 19) {
      if (paramNotification.actions != null) {
        i = paramNotification.actions.length;
      }
    }
    while (Build.VERSION.SDK_INT < 16) {
      return i;
    }
    return NotificationCompatJellybean.getActionCount(paramNotification);
  }
  
  public static int getBadgeIconType(Notification paramNotification)
  {
    if (Build.VERSION.SDK_INT >= 26) {
      return paramNotification.getBadgeIconType();
    }
    return 0;
  }
  
  public static String getCategory(Notification paramNotification)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return paramNotification.category;
    }
    return null;
  }
  
  public static String getChannelId(Notification paramNotification)
  {
    if (Build.VERSION.SDK_INT >= 26) {
      return paramNotification.getChannelId();
    }
    return null;
  }
  
  public static Bundle getExtras(Notification paramNotification)
  {
    if (Build.VERSION.SDK_INT >= 19) {
      return paramNotification.extras;
    }
    if (Build.VERSION.SDK_INT >= 16) {
      return NotificationCompatJellybean.getExtras(paramNotification);
    }
    return null;
  }
  
  public static String getGroup(Notification paramNotification)
  {
    if (Build.VERSION.SDK_INT >= 20) {
      return paramNotification.getGroup();
    }
    if (Build.VERSION.SDK_INT >= 19) {
      return paramNotification.extras.getString("android.support.groupKey");
    }
    if (Build.VERSION.SDK_INT >= 16) {
      return NotificationCompatJellybean.getExtras(paramNotification).getString("android.support.groupKey");
    }
    return null;
  }
  
  public static int getGroupAlertBehavior(Notification paramNotification)
  {
    if (Build.VERSION.SDK_INT >= 26) {
      return paramNotification.getGroupAlertBehavior();
    }
    return 0;
  }
  
  public static boolean getLocalOnly(Notification paramNotification)
  {
    boolean bool = false;
    if (Build.VERSION.SDK_INT >= 20) {
      if ((paramNotification.flags & 0x100) != 0) {
        bool = true;
      }
    }
    do
    {
      return bool;
      if (Build.VERSION.SDK_INT >= 19) {
        return paramNotification.extras.getBoolean("android.support.localOnly");
      }
    } while (Build.VERSION.SDK_INT < 16);
    return NotificationCompatJellybean.getExtras(paramNotification).getBoolean("android.support.localOnly");
  }
  
  static Notification[] getNotificationArrayFromBundle(Bundle paramBundle, String paramString)
  {
    Parcelable[] arrayOfParcelable = paramBundle.getParcelableArray(paramString);
    if (((arrayOfParcelable instanceof Notification[])) || (arrayOfParcelable == null)) {
      return (Notification[])arrayOfParcelable;
    }
    Notification[] arrayOfNotification = new Notification[arrayOfParcelable.length];
    int i = 0;
    while (i < arrayOfParcelable.length)
    {
      arrayOfNotification[i] = ((Notification)arrayOfParcelable[i]);
      i += 1;
    }
    paramBundle.putParcelableArray(paramString, arrayOfNotification);
    return arrayOfNotification;
  }
  
  public static String getShortcutId(Notification paramNotification)
  {
    if (Build.VERSION.SDK_INT >= 26) {
      return paramNotification.getShortcutId();
    }
    return null;
  }
  
  public static String getSortKey(Notification paramNotification)
  {
    if (Build.VERSION.SDK_INT >= 20) {
      return paramNotification.getSortKey();
    }
    if (Build.VERSION.SDK_INT >= 19) {
      return paramNotification.extras.getString("android.support.sortKey");
    }
    if (Build.VERSION.SDK_INT >= 16) {
      return NotificationCompatJellybean.getExtras(paramNotification).getString("android.support.sortKey");
    }
    return null;
  }
  
  public static long getTimeoutAfter(Notification paramNotification)
  {
    if (Build.VERSION.SDK_INT >= 26) {
      return paramNotification.getTimeoutAfter();
    }
    return 0L;
  }
  
  public static boolean isGroupSummary(Notification paramNotification)
  {
    boolean bool = false;
    if (Build.VERSION.SDK_INT >= 20) {
      if ((paramNotification.flags & 0x200) != 0) {
        bool = true;
      }
    }
    do
    {
      return bool;
      if (Build.VERSION.SDK_INT >= 19) {
        return paramNotification.extras.getBoolean("android.support.isGroupSummary");
      }
    } while (Build.VERSION.SDK_INT < 16);
    return NotificationCompatJellybean.getExtras(paramNotification).getBoolean("android.support.isGroupSummary");
  }
  
  public static class Action
    extends NotificationCompatBase.Action
  {
    public static final NotificationCompatBase.Action.Factory FACTORY = new NotificationCompatBase.Action.Factory()
    {
      public NotificationCompatBase.Action build(int paramAnonymousInt, CharSequence paramAnonymousCharSequence, PendingIntent paramAnonymousPendingIntent, Bundle paramAnonymousBundle, RemoteInputCompatBase.RemoteInput[] paramAnonymousArrayOfRemoteInput1, RemoteInputCompatBase.RemoteInput[] paramAnonymousArrayOfRemoteInput2, boolean paramAnonymousBoolean)
      {
        return new NotificationCompat.Action(paramAnonymousInt, paramAnonymousCharSequence, paramAnonymousPendingIntent, paramAnonymousBundle, (RemoteInput[])paramAnonymousArrayOfRemoteInput1, (RemoteInput[])paramAnonymousArrayOfRemoteInput2, paramAnonymousBoolean);
      }
      
      public NotificationCompat.Action[] newArray(int paramAnonymousInt)
      {
        return new NotificationCompat.Action[paramAnonymousInt];
      }
    };
    public PendingIntent actionIntent;
    public int icon;
    private boolean mAllowGeneratedReplies;
    private final RemoteInput[] mDataOnlyRemoteInputs;
    final Bundle mExtras;
    private final RemoteInput[] mRemoteInputs;
    public CharSequence title;
    
    public Action(int paramInt, CharSequence paramCharSequence, PendingIntent paramPendingIntent)
    {
      this(paramInt, paramCharSequence, paramPendingIntent, new Bundle(), null, null, true);
    }
    
    Action(int paramInt, CharSequence paramCharSequence, PendingIntent paramPendingIntent, Bundle paramBundle, RemoteInput[] paramArrayOfRemoteInput1, RemoteInput[] paramArrayOfRemoteInput2, boolean paramBoolean)
    {
      this.icon = paramInt;
      this.title = NotificationCompat.Builder.limitCharSequenceLength(paramCharSequence);
      this.actionIntent = paramPendingIntent;
      if (paramBundle != null) {}
      for (;;)
      {
        this.mExtras = paramBundle;
        this.mRemoteInputs = paramArrayOfRemoteInput1;
        this.mDataOnlyRemoteInputs = paramArrayOfRemoteInput2;
        this.mAllowGeneratedReplies = paramBoolean;
        return;
        paramBundle = new Bundle();
      }
    }
    
    public PendingIntent getActionIntent()
    {
      return this.actionIntent;
    }
    
    public boolean getAllowGeneratedReplies()
    {
      return this.mAllowGeneratedReplies;
    }
    
    public RemoteInput[] getDataOnlyRemoteInputs()
    {
      return this.mDataOnlyRemoteInputs;
    }
    
    public Bundle getExtras()
    {
      return this.mExtras;
    }
    
    public int getIcon()
    {
      return this.icon;
    }
    
    public RemoteInput[] getRemoteInputs()
    {
      return this.mRemoteInputs;
    }
    
    public CharSequence getTitle()
    {
      return this.title;
    }
    
    public static final class Builder
    {
      private boolean mAllowGeneratedReplies = true;
      private final Bundle mExtras;
      private final int mIcon;
      private final PendingIntent mIntent;
      private ArrayList<RemoteInput> mRemoteInputs;
      private final CharSequence mTitle;
      
      public Builder(int paramInt, CharSequence paramCharSequence, PendingIntent paramPendingIntent)
      {
        this(paramInt, paramCharSequence, paramPendingIntent, new Bundle(), null, true);
      }
      
      private Builder(int paramInt, CharSequence paramCharSequence, PendingIntent paramPendingIntent, Bundle paramBundle, RemoteInput[] paramArrayOfRemoteInput, boolean paramBoolean)
      {
        this.mIcon = paramInt;
        this.mTitle = NotificationCompat.Builder.limitCharSequenceLength(paramCharSequence);
        this.mIntent = paramPendingIntent;
        this.mExtras = paramBundle;
        if (paramArrayOfRemoteInput == null) {}
        for (paramCharSequence = null;; paramCharSequence = new ArrayList(Arrays.asList(paramArrayOfRemoteInput)))
        {
          this.mRemoteInputs = paramCharSequence;
          this.mAllowGeneratedReplies = paramBoolean;
          return;
        }
      }
      
      public Builder(NotificationCompat.Action paramAction)
      {
        this(paramAction.icon, paramAction.title, paramAction.actionIntent, new Bundle(paramAction.mExtras), paramAction.getRemoteInputs(), paramAction.getAllowGeneratedReplies());
      }
      
      public Builder addExtras(Bundle paramBundle)
      {
        if (paramBundle != null) {
          this.mExtras.putAll(paramBundle);
        }
        return this;
      }
      
      public Builder addRemoteInput(RemoteInput paramRemoteInput)
      {
        if (this.mRemoteInputs == null) {
          this.mRemoteInputs = new ArrayList();
        }
        this.mRemoteInputs.add(paramRemoteInput);
        return this;
      }
      
      public NotificationCompat.Action build()
      {
        Object localObject1 = new ArrayList();
        Object localObject2 = new ArrayList();
        if (this.mRemoteInputs != null)
        {
          Iterator localIterator = this.mRemoteInputs.iterator();
          while (localIterator.hasNext())
          {
            RemoteInput localRemoteInput = (RemoteInput)localIterator.next();
            if (localRemoteInput.isDataOnly()) {
              ((List)localObject1).add(localRemoteInput);
            } else {
              ((List)localObject2).add(localRemoteInput);
            }
          }
        }
        if (((List)localObject1).isEmpty())
        {
          localObject1 = null;
          if (!((List)localObject2).isEmpty()) {
            break label157;
          }
        }
        label157:
        for (localObject2 = null;; localObject2 = (RemoteInput[])((List)localObject2).toArray(new RemoteInput[((List)localObject2).size()]))
        {
          return new NotificationCompat.Action(this.mIcon, this.mTitle, this.mIntent, this.mExtras, (RemoteInput[])localObject2, (RemoteInput[])localObject1, this.mAllowGeneratedReplies);
          localObject1 = (RemoteInput[])((List)localObject1).toArray(new RemoteInput[((List)localObject1).size()]);
          break;
        }
      }
      
      public Builder extend(NotificationCompat.Action.Extender paramExtender)
      {
        paramExtender.extend(this);
        return this;
      }
      
      public Bundle getExtras()
      {
        return this.mExtras;
      }
      
      public Builder setAllowGeneratedReplies(boolean paramBoolean)
      {
        this.mAllowGeneratedReplies = paramBoolean;
        return this;
      }
    }
    
    public static abstract interface Extender
    {
      public abstract NotificationCompat.Action.Builder extend(NotificationCompat.Action.Builder paramBuilder);
    }
    
    public static final class WearableExtender
      implements NotificationCompat.Action.Extender
    {
      private static final int DEFAULT_FLAGS = 1;
      private static final String EXTRA_WEARABLE_EXTENSIONS = "android.wearable.EXTENSIONS";
      private static final int FLAG_AVAILABLE_OFFLINE = 1;
      private static final int FLAG_HINT_DISPLAY_INLINE = 4;
      private static final int FLAG_HINT_LAUNCHES_ACTIVITY = 2;
      private static final String KEY_CANCEL_LABEL = "cancelLabel";
      private static final String KEY_CONFIRM_LABEL = "confirmLabel";
      private static final String KEY_FLAGS = "flags";
      private static final String KEY_IN_PROGRESS_LABEL = "inProgressLabel";
      private CharSequence mCancelLabel;
      private CharSequence mConfirmLabel;
      private int mFlags = 1;
      private CharSequence mInProgressLabel;
      
      public WearableExtender() {}
      
      public WearableExtender(NotificationCompat.Action paramAction)
      {
        paramAction = paramAction.getExtras().getBundle("android.wearable.EXTENSIONS");
        if (paramAction != null)
        {
          this.mFlags = paramAction.getInt("flags", 1);
          this.mInProgressLabel = paramAction.getCharSequence("inProgressLabel");
          this.mConfirmLabel = paramAction.getCharSequence("confirmLabel");
          this.mCancelLabel = paramAction.getCharSequence("cancelLabel");
        }
      }
      
      private void setFlag(int paramInt, boolean paramBoolean)
      {
        if (paramBoolean)
        {
          this.mFlags |= paramInt;
          return;
        }
        this.mFlags &= (paramInt ^ 0xFFFFFFFF);
      }
      
      public WearableExtender clone()
      {
        WearableExtender localWearableExtender = new WearableExtender();
        localWearableExtender.mFlags = this.mFlags;
        localWearableExtender.mInProgressLabel = this.mInProgressLabel;
        localWearableExtender.mConfirmLabel = this.mConfirmLabel;
        localWearableExtender.mCancelLabel = this.mCancelLabel;
        return localWearableExtender;
      }
      
      public NotificationCompat.Action.Builder extend(NotificationCompat.Action.Builder paramBuilder)
      {
        Bundle localBundle = new Bundle();
        if (this.mFlags != 1) {
          localBundle.putInt("flags", this.mFlags);
        }
        if (this.mInProgressLabel != null) {
          localBundle.putCharSequence("inProgressLabel", this.mInProgressLabel);
        }
        if (this.mConfirmLabel != null) {
          localBundle.putCharSequence("confirmLabel", this.mConfirmLabel);
        }
        if (this.mCancelLabel != null) {
          localBundle.putCharSequence("cancelLabel", this.mCancelLabel);
        }
        paramBuilder.getExtras().putBundle("android.wearable.EXTENSIONS", localBundle);
        return paramBuilder;
      }
      
      public CharSequence getCancelLabel()
      {
        return this.mCancelLabel;
      }
      
      public CharSequence getConfirmLabel()
      {
        return this.mConfirmLabel;
      }
      
      public boolean getHintDisplayActionInline()
      {
        return (this.mFlags & 0x4) != 0;
      }
      
      public boolean getHintLaunchesActivity()
      {
        return (this.mFlags & 0x2) != 0;
      }
      
      public CharSequence getInProgressLabel()
      {
        return this.mInProgressLabel;
      }
      
      public boolean isAvailableOffline()
      {
        return (this.mFlags & 0x1) != 0;
      }
      
      public WearableExtender setAvailableOffline(boolean paramBoolean)
      {
        setFlag(1, paramBoolean);
        return this;
      }
      
      public WearableExtender setCancelLabel(CharSequence paramCharSequence)
      {
        this.mCancelLabel = paramCharSequence;
        return this;
      }
      
      public WearableExtender setConfirmLabel(CharSequence paramCharSequence)
      {
        this.mConfirmLabel = paramCharSequence;
        return this;
      }
      
      public WearableExtender setHintDisplayActionInline(boolean paramBoolean)
      {
        setFlag(4, paramBoolean);
        return this;
      }
      
      public WearableExtender setHintLaunchesActivity(boolean paramBoolean)
      {
        setFlag(2, paramBoolean);
        return this;
      }
      
      public WearableExtender setInProgressLabel(CharSequence paramCharSequence)
      {
        this.mInProgressLabel = paramCharSequence;
        return this;
      }
    }
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface BadgeIconType {}
  
  public static class BigPictureStyle
    extends NotificationCompat.Style
  {
    private Bitmap mBigLargeIcon;
    private boolean mBigLargeIconSet;
    private Bitmap mPicture;
    
    public BigPictureStyle() {}
    
    public BigPictureStyle(NotificationCompat.Builder paramBuilder)
    {
      setBuilder(paramBuilder);
    }
    
    public void apply(NotificationBuilderWithBuilderAccessor paramNotificationBuilderWithBuilderAccessor)
    {
      if (Build.VERSION.SDK_INT >= 16) {
        NotificationCompatJellybean.addBigPictureStyle(paramNotificationBuilderWithBuilderAccessor, this.mBigContentTitle, this.mSummaryTextSet, this.mSummaryText, this.mPicture, this.mBigLargeIcon, this.mBigLargeIconSet);
      }
    }
    
    public BigPictureStyle bigLargeIcon(Bitmap paramBitmap)
    {
      this.mBigLargeIcon = paramBitmap;
      this.mBigLargeIconSet = true;
      return this;
    }
    
    public BigPictureStyle bigPicture(Bitmap paramBitmap)
    {
      this.mPicture = paramBitmap;
      return this;
    }
    
    public BigPictureStyle setBigContentTitle(CharSequence paramCharSequence)
    {
      this.mBigContentTitle = NotificationCompat.Builder.limitCharSequenceLength(paramCharSequence);
      return this;
    }
    
    public BigPictureStyle setSummaryText(CharSequence paramCharSequence)
    {
      this.mSummaryText = NotificationCompat.Builder.limitCharSequenceLength(paramCharSequence);
      this.mSummaryTextSet = true;
      return this;
    }
  }
  
  public static class BigTextStyle
    extends NotificationCompat.Style
  {
    private CharSequence mBigText;
    
    public BigTextStyle() {}
    
    public BigTextStyle(NotificationCompat.Builder paramBuilder)
    {
      setBuilder(paramBuilder);
    }
    
    public void apply(NotificationBuilderWithBuilderAccessor paramNotificationBuilderWithBuilderAccessor)
    {
      if (Build.VERSION.SDK_INT >= 16) {
        NotificationCompatJellybean.addBigTextStyle(paramNotificationBuilderWithBuilderAccessor, this.mBigContentTitle, this.mSummaryTextSet, this.mSummaryText, this.mBigText);
      }
    }
    
    public BigTextStyle bigText(CharSequence paramCharSequence)
    {
      this.mBigText = NotificationCompat.Builder.limitCharSequenceLength(paramCharSequence);
      return this;
    }
    
    public BigTextStyle setBigContentTitle(CharSequence paramCharSequence)
    {
      this.mBigContentTitle = NotificationCompat.Builder.limitCharSequenceLength(paramCharSequence);
      return this;
    }
    
    public BigTextStyle setSummaryText(CharSequence paramCharSequence)
    {
      this.mSummaryText = NotificationCompat.Builder.limitCharSequenceLength(paramCharSequence);
      this.mSummaryTextSet = true;
      return this;
    }
  }
  
  public static class Builder
  {
    private static final int MAX_CHARSEQUENCE_LENGTH = 5120;
    public ArrayList<NotificationCompat.Action> mActions = new ArrayList();
    int mBadgeIcon = 0;
    RemoteViews mBigContentView;
    String mCategory;
    String mChannelId;
    int mColor = 0;
    boolean mColorized;
    boolean mColorizedSet;
    public CharSequence mContentInfo;
    PendingIntent mContentIntent;
    public CharSequence mContentText;
    public CharSequence mContentTitle;
    RemoteViews mContentView;
    public Context mContext;
    Bundle mExtras;
    PendingIntent mFullScreenIntent;
    private int mGroupAlertBehavior = 0;
    String mGroupKey;
    boolean mGroupSummary;
    RemoteViews mHeadsUpContentView;
    public Bitmap mLargeIcon;
    boolean mLocalOnly = false;
    public Notification mNotification = new Notification();
    public int mNumber;
    public ArrayList<String> mPeople;
    int mPriority;
    int mProgress;
    boolean mProgressIndeterminate;
    int mProgressMax;
    Notification mPublicVersion;
    public CharSequence[] mRemoteInputHistory;
    String mShortcutId;
    boolean mShowWhen = true;
    String mSortKey;
    public NotificationCompat.Style mStyle;
    public CharSequence mSubText;
    RemoteViews mTickerView;
    long mTimeout;
    public boolean mUseChronometer;
    int mVisibility = 0;
    
    @Deprecated
    public Builder(Context paramContext)
    {
      this(paramContext, null);
    }
    
    public Builder(Context paramContext, String paramString)
    {
      this.mContext = paramContext;
      this.mChannelId = paramString;
      this.mNotification.when = System.currentTimeMillis();
      this.mNotification.audioStreamType = -1;
      this.mPriority = 0;
      this.mPeople = new ArrayList();
    }
    
    protected static CharSequence limitCharSequenceLength(CharSequence paramCharSequence)
    {
      if (paramCharSequence == null) {}
      while (paramCharSequence.length() <= 5120) {
        return paramCharSequence;
      }
      return paramCharSequence.subSequence(0, 5120);
    }
    
    private void setFlag(int paramInt, boolean paramBoolean)
    {
      if (paramBoolean)
      {
        localNotification = this.mNotification;
        localNotification.flags |= paramInt;
        return;
      }
      Notification localNotification = this.mNotification;
      localNotification.flags &= (paramInt ^ 0xFFFFFFFF);
    }
    
    public Builder addAction(int paramInt, CharSequence paramCharSequence, PendingIntent paramPendingIntent)
    {
      this.mActions.add(new NotificationCompat.Action(paramInt, paramCharSequence, paramPendingIntent));
      return this;
    }
    
    public Builder addAction(NotificationCompat.Action paramAction)
    {
      this.mActions.add(paramAction);
      return this;
    }
    
    public Builder addExtras(Bundle paramBundle)
    {
      if (paramBundle != null)
      {
        if (this.mExtras == null) {
          this.mExtras = new Bundle(paramBundle);
        }
      }
      else {
        return this;
      }
      this.mExtras.putAll(paramBundle);
      return this;
    }
    
    public Builder addPerson(String paramString)
    {
      this.mPeople.add(paramString);
      return this;
    }
    
    public Notification build()
    {
      return NotificationCompat.IMPL.build(this, getExtender());
    }
    
    public Builder extend(NotificationCompat.Extender paramExtender)
    {
      paramExtender.extend(this);
      return this;
    }
    
    public RemoteViews getBigContentView()
    {
      return this.mBigContentView;
    }
    
    public int getColor()
    {
      return this.mColor;
    }
    
    public RemoteViews getContentView()
    {
      return this.mContentView;
    }
    
    protected NotificationCompat.BuilderExtender getExtender()
    {
      return new NotificationCompat.BuilderExtender();
    }
    
    public Bundle getExtras()
    {
      if (this.mExtras == null) {
        this.mExtras = new Bundle();
      }
      return this.mExtras;
    }
    
    public RemoteViews getHeadsUpContentView()
    {
      return this.mHeadsUpContentView;
    }
    
    @Deprecated
    public Notification getNotification()
    {
      return build();
    }
    
    public int getPriority()
    {
      return this.mPriority;
    }
    
    public long getWhenIfShowing()
    {
      if (this.mShowWhen) {
        return this.mNotification.when;
      }
      return 0L;
    }
    
    public Builder setAutoCancel(boolean paramBoolean)
    {
      setFlag(16, paramBoolean);
      return this;
    }
    
    public Builder setBadgeIconType(int paramInt)
    {
      this.mBadgeIcon = paramInt;
      return this;
    }
    
    public Builder setCategory(String paramString)
    {
      this.mCategory = paramString;
      return this;
    }
    
    public Builder setChannelId(String paramString)
    {
      this.mChannelId = paramString;
      return this;
    }
    
    public Builder setColor(int paramInt)
    {
      this.mColor = paramInt;
      return this;
    }
    
    public Builder setColorized(boolean paramBoolean)
    {
      this.mColorized = paramBoolean;
      this.mColorizedSet = true;
      return this;
    }
    
    public Builder setContent(RemoteViews paramRemoteViews)
    {
      this.mNotification.contentView = paramRemoteViews;
      return this;
    }
    
    public Builder setContentInfo(CharSequence paramCharSequence)
    {
      this.mContentInfo = limitCharSequenceLength(paramCharSequence);
      return this;
    }
    
    public Builder setContentIntent(PendingIntent paramPendingIntent)
    {
      this.mContentIntent = paramPendingIntent;
      return this;
    }
    
    public Builder setContentText(CharSequence paramCharSequence)
    {
      this.mContentText = limitCharSequenceLength(paramCharSequence);
      return this;
    }
    
    public Builder setContentTitle(CharSequence paramCharSequence)
    {
      this.mContentTitle = limitCharSequenceLength(paramCharSequence);
      return this;
    }
    
    public Builder setCustomBigContentView(RemoteViews paramRemoteViews)
    {
      this.mBigContentView = paramRemoteViews;
      return this;
    }
    
    public Builder setCustomContentView(RemoteViews paramRemoteViews)
    {
      this.mContentView = paramRemoteViews;
      return this;
    }
    
    public Builder setCustomHeadsUpContentView(RemoteViews paramRemoteViews)
    {
      this.mHeadsUpContentView = paramRemoteViews;
      return this;
    }
    
    public Builder setDefaults(int paramInt)
    {
      this.mNotification.defaults = paramInt;
      if ((paramInt & 0x4) != 0)
      {
        Notification localNotification = this.mNotification;
        localNotification.flags |= 0x1;
      }
      return this;
    }
    
    public Builder setDeleteIntent(PendingIntent paramPendingIntent)
    {
      this.mNotification.deleteIntent = paramPendingIntent;
      return this;
    }
    
    public Builder setExtras(Bundle paramBundle)
    {
      this.mExtras = paramBundle;
      return this;
    }
    
    public Builder setFullScreenIntent(PendingIntent paramPendingIntent, boolean paramBoolean)
    {
      this.mFullScreenIntent = paramPendingIntent;
      setFlag(128, paramBoolean);
      return this;
    }
    
    public Builder setGroup(String paramString)
    {
      this.mGroupKey = paramString;
      return this;
    }
    
    public Builder setGroupAlertBehavior(int paramInt)
    {
      this.mGroupAlertBehavior = paramInt;
      return this;
    }
    
    public Builder setGroupSummary(boolean paramBoolean)
    {
      this.mGroupSummary = paramBoolean;
      return this;
    }
    
    public Builder setLargeIcon(Bitmap paramBitmap)
    {
      this.mLargeIcon = paramBitmap;
      return this;
    }
    
    public Builder setLights(int paramInt1, int paramInt2, int paramInt3)
    {
      int i = 1;
      this.mNotification.ledARGB = paramInt1;
      this.mNotification.ledOnMS = paramInt2;
      this.mNotification.ledOffMS = paramInt3;
      Notification localNotification;
      if ((this.mNotification.ledOnMS != 0) && (this.mNotification.ledOffMS != 0))
      {
        paramInt1 = 1;
        localNotification = this.mNotification;
        paramInt2 = this.mNotification.flags;
        if (paramInt1 == 0) {
          break label88;
        }
      }
      label88:
      for (paramInt1 = i;; paramInt1 = 0)
      {
        localNotification.flags = (paramInt2 & 0xFFFFFFFE | paramInt1);
        return this;
        paramInt1 = 0;
        break;
      }
    }
    
    public Builder setLocalOnly(boolean paramBoolean)
    {
      this.mLocalOnly = paramBoolean;
      return this;
    }
    
    public Builder setNumber(int paramInt)
    {
      this.mNumber = paramInt;
      return this;
    }
    
    public Builder setOngoing(boolean paramBoolean)
    {
      setFlag(2, paramBoolean);
      return this;
    }
    
    public Builder setOnlyAlertOnce(boolean paramBoolean)
    {
      setFlag(8, paramBoolean);
      return this;
    }
    
    public Builder setPriority(int paramInt)
    {
      this.mPriority = paramInt;
      return this;
    }
    
    public Builder setProgress(int paramInt1, int paramInt2, boolean paramBoolean)
    {
      this.mProgressMax = paramInt1;
      this.mProgress = paramInt2;
      this.mProgressIndeterminate = paramBoolean;
      return this;
    }
    
    public Builder setPublicVersion(Notification paramNotification)
    {
      this.mPublicVersion = paramNotification;
      return this;
    }
    
    public Builder setRemoteInputHistory(CharSequence[] paramArrayOfCharSequence)
    {
      this.mRemoteInputHistory = paramArrayOfCharSequence;
      return this;
    }
    
    public Builder setShortcutId(String paramString)
    {
      this.mShortcutId = paramString;
      return this;
    }
    
    public Builder setShowWhen(boolean paramBoolean)
    {
      this.mShowWhen = paramBoolean;
      return this;
    }
    
    public Builder setSmallIcon(int paramInt)
    {
      this.mNotification.icon = paramInt;
      return this;
    }
    
    public Builder setSmallIcon(int paramInt1, int paramInt2)
    {
      this.mNotification.icon = paramInt1;
      this.mNotification.iconLevel = paramInt2;
      return this;
    }
    
    public Builder setSortKey(String paramString)
    {
      this.mSortKey = paramString;
      return this;
    }
    
    public Builder setSound(Uri paramUri)
    {
      this.mNotification.sound = paramUri;
      this.mNotification.audioStreamType = -1;
      return this;
    }
    
    public Builder setSound(Uri paramUri, int paramInt)
    {
      this.mNotification.sound = paramUri;
      this.mNotification.audioStreamType = paramInt;
      return this;
    }
    
    public Builder setStyle(NotificationCompat.Style paramStyle)
    {
      if (this.mStyle != paramStyle)
      {
        this.mStyle = paramStyle;
        if (this.mStyle != null) {
          this.mStyle.setBuilder(this);
        }
      }
      return this;
    }
    
    public Builder setSubText(CharSequence paramCharSequence)
    {
      this.mSubText = limitCharSequenceLength(paramCharSequence);
      return this;
    }
    
    public Builder setTicker(CharSequence paramCharSequence)
    {
      this.mNotification.tickerText = limitCharSequenceLength(paramCharSequence);
      return this;
    }
    
    public Builder setTicker(CharSequence paramCharSequence, RemoteViews paramRemoteViews)
    {
      this.mNotification.tickerText = limitCharSequenceLength(paramCharSequence);
      this.mTickerView = paramRemoteViews;
      return this;
    }
    
    public Builder setTimeoutAfter(long paramLong)
    {
      this.mTimeout = paramLong;
      return this;
    }
    
    public Builder setUsesChronometer(boolean paramBoolean)
    {
      this.mUseChronometer = paramBoolean;
      return this;
    }
    
    public Builder setVibrate(long[] paramArrayOfLong)
    {
      this.mNotification.vibrate = paramArrayOfLong;
      return this;
    }
    
    public Builder setVisibility(int paramInt)
    {
      this.mVisibility = paramInt;
      return this;
    }
    
    public Builder setWhen(long paramLong)
    {
      this.mNotification.when = paramLong;
      return this;
    }
  }
  
  protected static class BuilderExtender
  {
    public Notification build(NotificationCompat.Builder paramBuilder, NotificationBuilderWithBuilderAccessor paramNotificationBuilderWithBuilderAccessor)
    {
      RemoteViews localRemoteViews;
      Notification localNotification;
      if (paramBuilder.mStyle != null)
      {
        localRemoteViews = paramBuilder.mStyle.makeContentView(paramNotificationBuilderWithBuilderAccessor);
        localNotification = paramNotificationBuilderWithBuilderAccessor.build();
        if (localRemoteViews == null) {
          break label110;
        }
        localNotification.contentView = localRemoteViews;
      }
      for (;;)
      {
        if ((Build.VERSION.SDK_INT >= 16) && (paramBuilder.mStyle != null))
        {
          localRemoteViews = paramBuilder.mStyle.makeBigContentView(paramNotificationBuilderWithBuilderAccessor);
          if (localRemoteViews != null) {
            localNotification.bigContentView = localRemoteViews;
          }
        }
        if ((Build.VERSION.SDK_INT >= 21) && (paramBuilder.mStyle != null))
        {
          paramBuilder = paramBuilder.mStyle.makeHeadsUpContentView(paramNotificationBuilderWithBuilderAccessor);
          if (paramBuilder != null) {
            localNotification.headsUpContentView = paramBuilder;
          }
        }
        return localNotification;
        localRemoteViews = null;
        break;
        label110:
        if (paramBuilder.mContentView != null) {
          localNotification.contentView = paramBuilder.mContentView;
        }
      }
    }
  }
  
  public static final class CarExtender
    implements NotificationCompat.Extender
  {
    private static final String EXTRA_CAR_EXTENDER = "android.car.EXTENSIONS";
    private static final String EXTRA_COLOR = "app_color";
    private static final String EXTRA_CONVERSATION = "car_conversation";
    private static final String EXTRA_LARGE_ICON = "large_icon";
    private static final String TAG = "CarExtender";
    private int mColor = 0;
    private Bitmap mLargeIcon;
    private UnreadConversation mUnreadConversation;
    
    public CarExtender() {}
    
    public CarExtender(Notification paramNotification)
    {
      if (Build.VERSION.SDK_INT < 21) {}
      for (;;)
      {
        return;
        if (NotificationCompat.getExtras(paramNotification) == null) {}
        for (paramNotification = null; paramNotification != null; paramNotification = NotificationCompat.getExtras(paramNotification).getBundle("android.car.EXTENSIONS"))
        {
          this.mLargeIcon = ((Bitmap)paramNotification.getParcelable("large_icon"));
          this.mColor = paramNotification.getInt("app_color", 0);
          paramNotification = paramNotification.getBundle("car_conversation");
          this.mUnreadConversation = ((UnreadConversation)NotificationCompat.IMPL.getUnreadConversationFromBundle(paramNotification, UnreadConversation.FACTORY, RemoteInput.FACTORY));
          return;
        }
      }
    }
    
    public NotificationCompat.Builder extend(NotificationCompat.Builder paramBuilder)
    {
      if (Build.VERSION.SDK_INT < 21) {
        return paramBuilder;
      }
      Bundle localBundle = new Bundle();
      if (this.mLargeIcon != null) {
        localBundle.putParcelable("large_icon", this.mLargeIcon);
      }
      if (this.mColor != 0) {
        localBundle.putInt("app_color", this.mColor);
      }
      if (this.mUnreadConversation != null) {
        localBundle.putBundle("car_conversation", NotificationCompat.IMPL.getBundleForUnreadConversation(this.mUnreadConversation));
      }
      paramBuilder.getExtras().putBundle("android.car.EXTENSIONS", localBundle);
      return paramBuilder;
    }
    
    public int getColor()
    {
      return this.mColor;
    }
    
    public Bitmap getLargeIcon()
    {
      return this.mLargeIcon;
    }
    
    public UnreadConversation getUnreadConversation()
    {
      return this.mUnreadConversation;
    }
    
    public CarExtender setColor(int paramInt)
    {
      this.mColor = paramInt;
      return this;
    }
    
    public CarExtender setLargeIcon(Bitmap paramBitmap)
    {
      this.mLargeIcon = paramBitmap;
      return this;
    }
    
    public CarExtender setUnreadConversation(UnreadConversation paramUnreadConversation)
    {
      this.mUnreadConversation = paramUnreadConversation;
      return this;
    }
    
    public static class UnreadConversation
      extends NotificationCompatBase.UnreadConversation
    {
      static final NotificationCompatBase.UnreadConversation.Factory FACTORY = new NotificationCompatBase.UnreadConversation.Factory()
      {
        public NotificationCompat.CarExtender.UnreadConversation build(String[] paramAnonymousArrayOfString1, RemoteInputCompatBase.RemoteInput paramAnonymousRemoteInput, PendingIntent paramAnonymousPendingIntent1, PendingIntent paramAnonymousPendingIntent2, String[] paramAnonymousArrayOfString2, long paramAnonymousLong)
        {
          return new NotificationCompat.CarExtender.UnreadConversation(paramAnonymousArrayOfString1, (RemoteInput)paramAnonymousRemoteInput, paramAnonymousPendingIntent1, paramAnonymousPendingIntent2, paramAnonymousArrayOfString2, paramAnonymousLong);
        }
      };
      private final long mLatestTimestamp;
      private final String[] mMessages;
      private final String[] mParticipants;
      private final PendingIntent mReadPendingIntent;
      private final RemoteInput mRemoteInput;
      private final PendingIntent mReplyPendingIntent;
      
      UnreadConversation(String[] paramArrayOfString1, RemoteInput paramRemoteInput, PendingIntent paramPendingIntent1, PendingIntent paramPendingIntent2, String[] paramArrayOfString2, long paramLong)
      {
        this.mMessages = paramArrayOfString1;
        this.mRemoteInput = paramRemoteInput;
        this.mReadPendingIntent = paramPendingIntent2;
        this.mReplyPendingIntent = paramPendingIntent1;
        this.mParticipants = paramArrayOfString2;
        this.mLatestTimestamp = paramLong;
      }
      
      public long getLatestTimestamp()
      {
        return this.mLatestTimestamp;
      }
      
      public String[] getMessages()
      {
        return this.mMessages;
      }
      
      public String getParticipant()
      {
        if (this.mParticipants.length > 0) {
          return this.mParticipants[0];
        }
        return null;
      }
      
      public String[] getParticipants()
      {
        return this.mParticipants;
      }
      
      public PendingIntent getReadPendingIntent()
      {
        return this.mReadPendingIntent;
      }
      
      public RemoteInput getRemoteInput()
      {
        return this.mRemoteInput;
      }
      
      public PendingIntent getReplyPendingIntent()
      {
        return this.mReplyPendingIntent;
      }
      
      public static class Builder
      {
        private long mLatestTimestamp;
        private final List<String> mMessages = new ArrayList();
        private final String mParticipant;
        private PendingIntent mReadPendingIntent;
        private RemoteInput mRemoteInput;
        private PendingIntent mReplyPendingIntent;
        
        public Builder(String paramString)
        {
          this.mParticipant = paramString;
        }
        
        public Builder addMessage(String paramString)
        {
          this.mMessages.add(paramString);
          return this;
        }
        
        public NotificationCompat.CarExtender.UnreadConversation build()
        {
          String[] arrayOfString = (String[])this.mMessages.toArray(new String[this.mMessages.size()]);
          String str = this.mParticipant;
          RemoteInput localRemoteInput = this.mRemoteInput;
          PendingIntent localPendingIntent1 = this.mReplyPendingIntent;
          PendingIntent localPendingIntent2 = this.mReadPendingIntent;
          long l = this.mLatestTimestamp;
          return new NotificationCompat.CarExtender.UnreadConversation(arrayOfString, localRemoteInput, localPendingIntent1, localPendingIntent2, new String[] { str }, l);
        }
        
        public Builder setLatestTimestamp(long paramLong)
        {
          this.mLatestTimestamp = paramLong;
          return this;
        }
        
        public Builder setReadPendingIntent(PendingIntent paramPendingIntent)
        {
          this.mReadPendingIntent = paramPendingIntent;
          return this;
        }
        
        public Builder setReplyAction(PendingIntent paramPendingIntent, RemoteInput paramRemoteInput)
        {
          this.mRemoteInput = paramRemoteInput;
          this.mReplyPendingIntent = paramPendingIntent;
          return this;
        }
      }
    }
  }
  
  public static class DecoratedCustomViewStyle
    extends NotificationCompat.Style
  {
    private static final int MAX_ACTION_BUTTONS = 3;
    
    private RemoteViews createRemoteViews(RemoteViews paramRemoteViews, boolean paramBoolean)
    {
      RemoteViews localRemoteViews1 = applyStandardTemplate(true, R.layout.notification_template_custom_big, false);
      localRemoteViews1.removeAllViews(R.id.actions);
      if ((paramBoolean) && (this.mBuilder.mActions != null))
      {
        int j = Math.min(this.mBuilder.mActions.size(), 3);
        if (j > 0)
        {
          i = 0;
          while (i < j)
          {
            RemoteViews localRemoteViews2 = generateActionButton((NotificationCompat.Action)this.mBuilder.mActions.get(i));
            localRemoteViews1.addView(R.id.actions, localRemoteViews2);
            i += 1;
          }
        }
      }
      for (int i = 1;; i = 0)
      {
        if (i != 0) {}
        for (i = 0;; i = 8)
        {
          localRemoteViews1.setViewVisibility(R.id.actions, i);
          localRemoteViews1.setViewVisibility(R.id.action_divider, i);
          buildIntoRemoteViews(localRemoteViews1, paramRemoteViews);
          return localRemoteViews1;
        }
      }
    }
    
    private RemoteViews generateActionButton(NotificationCompat.Action paramAction)
    {
      int i;
      Object localObject;
      if (paramAction.actionIntent == null)
      {
        i = 1;
        localObject = this.mBuilder.mContext.getPackageName();
        if (i == 0) {
          break label129;
        }
      }
      label129:
      for (int j = R.layout.notification_action_tombstone;; j = R.layout.notification_action)
      {
        localObject = new RemoteViews((String)localObject, j);
        ((RemoteViews)localObject).setImageViewBitmap(R.id.action_image, createColoredBitmap(paramAction.getIcon(), this.mBuilder.mContext.getResources().getColor(R.color.notification_action_color_filter)));
        ((RemoteViews)localObject).setTextViewText(R.id.action_text, paramAction.title);
        if (i == 0) {
          ((RemoteViews)localObject).setOnClickPendingIntent(R.id.action_container, paramAction.actionIntent);
        }
        if (Build.VERSION.SDK_INT >= 15) {
          ((RemoteViews)localObject).setContentDescription(R.id.action_container, paramAction.title);
        }
        return (RemoteViews)localObject;
        i = 0;
        break;
      }
    }
    
    public void apply(NotificationBuilderWithBuilderAccessor paramNotificationBuilderWithBuilderAccessor)
    {
      if (Build.VERSION.SDK_INT >= 24) {
        paramNotificationBuilderWithBuilderAccessor.getBuilder().setStyle(new Notification.DecoratedCustomViewStyle());
      }
    }
    
    public RemoteViews makeBigContentView(NotificationBuilderWithBuilderAccessor paramNotificationBuilderWithBuilderAccessor)
    {
      if (Build.VERSION.SDK_INT >= 24) {}
      for (;;)
      {
        return null;
        paramNotificationBuilderWithBuilderAccessor = this.mBuilder.getBigContentView();
        if (paramNotificationBuilderWithBuilderAccessor != null) {}
        while (paramNotificationBuilderWithBuilderAccessor != null)
        {
          return createRemoteViews(paramNotificationBuilderWithBuilderAccessor, true);
          paramNotificationBuilderWithBuilderAccessor = this.mBuilder.getContentView();
        }
      }
    }
    
    public RemoteViews makeContentView(NotificationBuilderWithBuilderAccessor paramNotificationBuilderWithBuilderAccessor)
    {
      if (Build.VERSION.SDK_INT >= 24) {}
      while (this.mBuilder.getContentView() == null) {
        return null;
      }
      return createRemoteViews(this.mBuilder.getContentView(), false);
    }
    
    public RemoteViews makeHeadsUpContentView(NotificationBuilderWithBuilderAccessor paramNotificationBuilderWithBuilderAccessor)
    {
      if (Build.VERSION.SDK_INT >= 24) {}
      for (;;)
      {
        return null;
        RemoteViews localRemoteViews = this.mBuilder.getHeadsUpContentView();
        if (localRemoteViews != null) {}
        for (paramNotificationBuilderWithBuilderAccessor = localRemoteViews; localRemoteViews != null; paramNotificationBuilderWithBuilderAccessor = this.mBuilder.getContentView()) {
          return createRemoteViews(paramNotificationBuilderWithBuilderAccessor, true);
        }
      }
    }
  }
  
  public static abstract interface Extender
  {
    public abstract NotificationCompat.Builder extend(NotificationCompat.Builder paramBuilder);
  }
  
  public static class InboxStyle
    extends NotificationCompat.Style
  {
    private ArrayList<CharSequence> mTexts = new ArrayList();
    
    public InboxStyle() {}
    
    public InboxStyle(NotificationCompat.Builder paramBuilder)
    {
      setBuilder(paramBuilder);
    }
    
    public InboxStyle addLine(CharSequence paramCharSequence)
    {
      this.mTexts.add(NotificationCompat.Builder.limitCharSequenceLength(paramCharSequence));
      return this;
    }
    
    public void apply(NotificationBuilderWithBuilderAccessor paramNotificationBuilderWithBuilderAccessor)
    {
      if (Build.VERSION.SDK_INT >= 16) {
        NotificationCompatJellybean.addInboxStyle(paramNotificationBuilderWithBuilderAccessor, this.mBigContentTitle, this.mSummaryTextSet, this.mSummaryText, this.mTexts);
      }
    }
    
    public InboxStyle setBigContentTitle(CharSequence paramCharSequence)
    {
      this.mBigContentTitle = NotificationCompat.Builder.limitCharSequenceLength(paramCharSequence);
      return this;
    }
    
    public InboxStyle setSummaryText(CharSequence paramCharSequence)
    {
      this.mSummaryText = NotificationCompat.Builder.limitCharSequenceLength(paramCharSequence);
      this.mSummaryTextSet = true;
      return this;
    }
  }
  
  public static class MessagingStyle
    extends NotificationCompat.Style
  {
    public static final int MAXIMUM_RETAINED_MESSAGES = 25;
    CharSequence mConversationTitle;
    List<Message> mMessages = new ArrayList();
    CharSequence mUserDisplayName;
    
    MessagingStyle() {}
    
    public MessagingStyle(CharSequence paramCharSequence)
    {
      this.mUserDisplayName = paramCharSequence;
    }
    
    public static MessagingStyle extractMessagingStyleFromNotification(Notification paramNotification)
    {
      paramNotification = NotificationCompat.getExtras(paramNotification);
      if ((paramNotification != null) && (!paramNotification.containsKey("android.selfDisplayName"))) {
        return null;
      }
      try
      {
        MessagingStyle localMessagingStyle = new MessagingStyle();
        localMessagingStyle.restoreFromCompatExtras(paramNotification);
        return localMessagingStyle;
      }
      catch (ClassCastException paramNotification) {}
      return null;
    }
    
    private Message findLatestIncomingMessage()
    {
      int i = this.mMessages.size() - 1;
      while (i >= 0)
      {
        Message localMessage = (Message)this.mMessages.get(i);
        if (!TextUtils.isEmpty(localMessage.getSender())) {
          return localMessage;
        }
        i -= 1;
      }
      if (!this.mMessages.isEmpty()) {
        return (Message)this.mMessages.get(this.mMessages.size() - 1);
      }
      return null;
    }
    
    private boolean hasMessagesWithoutSender()
    {
      int i = this.mMessages.size() - 1;
      while (i >= 0)
      {
        if (((Message)this.mMessages.get(i)).getSender() == null) {
          return true;
        }
        i -= 1;
      }
      return false;
    }
    
    private TextAppearanceSpan makeFontColorSpan(int paramInt)
    {
      return new TextAppearanceSpan(null, 0, 0, ColorStateList.valueOf(paramInt), null);
    }
    
    private CharSequence makeMessageLine(Message paramMessage)
    {
      BidiFormatter localBidiFormatter = BidiFormatter.getInstance();
      SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
      int k;
      int i;
      label33:
      Object localObject;
      if (Build.VERSION.SDK_INT >= 21)
      {
        k = 1;
        if (k == 0) {
          break label170;
        }
        i = -16777216;
        localObject = paramMessage.getSender();
        if (!TextUtils.isEmpty(paramMessage.getSender())) {
          break label192;
        }
        if (this.mUserDisplayName != null) {
          break label175;
        }
        localObject = "";
        label60:
        j = i;
        if (k != 0)
        {
          j = i;
          if (this.mBuilder.getColor() == 0) {}
        }
      }
      label170:
      label175:
      label192:
      for (int j = this.mBuilder.getColor();; j = i)
      {
        localObject = localBidiFormatter.unicodeWrap((CharSequence)localObject);
        localSpannableStringBuilder.append((CharSequence)localObject);
        localSpannableStringBuilder.setSpan(makeFontColorSpan(j), localSpannableStringBuilder.length() - ((CharSequence)localObject).length(), localSpannableStringBuilder.length(), 33);
        if (paramMessage.getText() == null) {}
        for (paramMessage = "";; paramMessage = paramMessage.getText())
        {
          localSpannableStringBuilder.append("  ").append(localBidiFormatter.unicodeWrap(paramMessage));
          return localSpannableStringBuilder;
          k = 0;
          break;
          i = -1;
          break label33;
          localObject = this.mUserDisplayName;
          break label60;
        }
      }
    }
    
    public void addCompatExtras(Bundle paramBundle)
    {
      super.addCompatExtras(paramBundle);
      if (this.mUserDisplayName != null) {
        paramBundle.putCharSequence("android.selfDisplayName", this.mUserDisplayName);
      }
      if (this.mConversationTitle != null) {
        paramBundle.putCharSequence("android.conversationTitle", this.mConversationTitle);
      }
      if (!this.mMessages.isEmpty()) {
        paramBundle.putParcelableArray("android.messages", Message.getBundleArrayForMessages(this.mMessages));
      }
    }
    
    public MessagingStyle addMessage(Message paramMessage)
    {
      this.mMessages.add(paramMessage);
      if (this.mMessages.size() > 25) {
        this.mMessages.remove(0);
      }
      return this;
    }
    
    public MessagingStyle addMessage(CharSequence paramCharSequence1, long paramLong, CharSequence paramCharSequence2)
    {
      this.mMessages.add(new Message(paramCharSequence1, paramLong, paramCharSequence2));
      if (this.mMessages.size() > 25) {
        this.mMessages.remove(0);
      }
      return this;
    }
    
    public void apply(NotificationBuilderWithBuilderAccessor paramNotificationBuilderWithBuilderAccessor)
    {
      if (Build.VERSION.SDK_INT >= 24)
      {
        localObject1 = new ArrayList();
        localObject2 = new ArrayList();
        ArrayList localArrayList1 = new ArrayList();
        ArrayList localArrayList2 = new ArrayList();
        ArrayList localArrayList3 = new ArrayList();
        Iterator localIterator = this.mMessages.iterator();
        while (localIterator.hasNext())
        {
          Message localMessage = (Message)localIterator.next();
          ((List)localObject1).add(localMessage.getText());
          ((List)localObject2).add(Long.valueOf(localMessage.getTimestamp()));
          localArrayList1.add(localMessage.getSender());
          localArrayList2.add(localMessage.getDataMimeType());
          localArrayList3.add(localMessage.getDataUri());
        }
        NotificationCompatApi24.addMessagingStyle(paramNotificationBuilderWithBuilderAccessor, this.mUserDisplayName, this.mConversationTitle, (List)localObject1, (List)localObject2, localArrayList1, localArrayList2, localArrayList3);
      }
      label235:
      do
      {
        return;
        localObject1 = findLatestIncomingMessage();
        if (this.mConversationTitle == null) {
          break;
        }
        paramNotificationBuilderWithBuilderAccessor.getBuilder().setContentTitle(this.mConversationTitle);
        if (localObject1 != null)
        {
          localObject2 = paramNotificationBuilderWithBuilderAccessor.getBuilder();
          if (this.mConversationTitle == null) {
            break label382;
          }
          localObject1 = makeMessageLine((Message)localObject1);
          ((Notification.Builder)localObject2).setContentText((CharSequence)localObject1);
        }
      } while (Build.VERSION.SDK_INT < 16);
      Object localObject2 = new SpannableStringBuilder();
      int i;
      label276:
      int j;
      if ((this.mConversationTitle != null) || (hasMessagesWithoutSender()))
      {
        i = 1;
        j = this.mMessages.size() - 1;
        label288:
        if (j < 0) {
          break label407;
        }
        localObject1 = (Message)this.mMessages.get(j);
        if (i == 0) {
          break label397;
        }
      }
      label382:
      label397:
      for (Object localObject1 = makeMessageLine((Message)localObject1);; localObject1 = ((Message)localObject1).getText())
      {
        if (j != this.mMessages.size() - 1) {
          ((SpannableStringBuilder)localObject2).insert(0, "\n");
        }
        ((SpannableStringBuilder)localObject2).insert(0, (CharSequence)localObject1);
        j -= 1;
        break label288;
        if (localObject1 == null) {
          break;
        }
        paramNotificationBuilderWithBuilderAccessor.getBuilder().setContentTitle(((Message)localObject1).getSender());
        break;
        localObject1 = ((Message)localObject1).getText();
        break label235;
        i = 0;
        break label276;
      }
      label407:
      NotificationCompatJellybean.addBigTextStyle(paramNotificationBuilderWithBuilderAccessor, null, false, null, (CharSequence)localObject2);
    }
    
    public CharSequence getConversationTitle()
    {
      return this.mConversationTitle;
    }
    
    public List<Message> getMessages()
    {
      return this.mMessages;
    }
    
    public CharSequence getUserDisplayName()
    {
      return this.mUserDisplayName;
    }
    
    protected void restoreFromCompatExtras(Bundle paramBundle)
    {
      this.mMessages.clear();
      this.mUserDisplayName = paramBundle.getString("android.selfDisplayName");
      this.mConversationTitle = paramBundle.getString("android.conversationTitle");
      paramBundle = paramBundle.getParcelableArray("android.messages");
      if (paramBundle != null) {
        this.mMessages = Message.getMessagesFromBundleArray(paramBundle);
      }
    }
    
    public MessagingStyle setConversationTitle(CharSequence paramCharSequence)
    {
      this.mConversationTitle = paramCharSequence;
      return this;
    }
    
    public static final class Message
    {
      static final String KEY_DATA_MIME_TYPE = "type";
      static final String KEY_DATA_URI = "uri";
      static final String KEY_EXTRAS_BUNDLE = "extras";
      static final String KEY_SENDER = "sender";
      static final String KEY_TEXT = "text";
      static final String KEY_TIMESTAMP = "time";
      private String mDataMimeType;
      private Uri mDataUri;
      private Bundle mExtras = new Bundle();
      private final CharSequence mSender;
      private final CharSequence mText;
      private final long mTimestamp;
      
      public Message(CharSequence paramCharSequence1, long paramLong, CharSequence paramCharSequence2)
      {
        this.mText = paramCharSequence1;
        this.mTimestamp = paramLong;
        this.mSender = paramCharSequence2;
      }
      
      static Bundle[] getBundleArrayForMessages(List<Message> paramList)
      {
        Bundle[] arrayOfBundle = new Bundle[paramList.size()];
        int j = paramList.size();
        int i = 0;
        while (i < j)
        {
          arrayOfBundle[i] = ((Message)paramList.get(i)).toBundle();
          i += 1;
        }
        return arrayOfBundle;
      }
      
      static Message getMessageFromBundle(Bundle paramBundle)
      {
        try
        {
          if ((paramBundle.containsKey("text")) && (paramBundle.containsKey("time")))
          {
            Message localMessage = new Message(paramBundle.getCharSequence("text"), paramBundle.getLong("time"), paramBundle.getCharSequence("sender"));
            if ((paramBundle.containsKey("type")) && (paramBundle.containsKey("uri"))) {
              localMessage.setData(paramBundle.getString("type"), (Uri)paramBundle.getParcelable("uri"));
            }
            if (paramBundle.containsKey("extras")) {
              localMessage.getExtras().putAll(paramBundle.getBundle("extras"));
            }
            return localMessage;
          }
        }
        catch (ClassCastException paramBundle)
        {
          return null;
        }
        return null;
      }
      
      static List<Message> getMessagesFromBundleArray(Parcelable[] paramArrayOfParcelable)
      {
        ArrayList localArrayList = new ArrayList(paramArrayOfParcelable.length);
        int i = 0;
        while (i < paramArrayOfParcelable.length)
        {
          if ((paramArrayOfParcelable[i] instanceof Bundle))
          {
            Message localMessage = getMessageFromBundle((Bundle)paramArrayOfParcelable[i]);
            if (localMessage != null) {
              localArrayList.add(localMessage);
            }
          }
          i += 1;
        }
        return localArrayList;
      }
      
      private Bundle toBundle()
      {
        Bundle localBundle = new Bundle();
        if (this.mText != null) {
          localBundle.putCharSequence("text", this.mText);
        }
        localBundle.putLong("time", this.mTimestamp);
        if (this.mSender != null) {
          localBundle.putCharSequence("sender", this.mSender);
        }
        if (this.mDataMimeType != null) {
          localBundle.putString("type", this.mDataMimeType);
        }
        if (this.mDataUri != null) {
          localBundle.putParcelable("uri", this.mDataUri);
        }
        if (this.mExtras != null) {
          localBundle.putBundle("extras", this.mExtras);
        }
        return localBundle;
      }
      
      public String getDataMimeType()
      {
        return this.mDataMimeType;
      }
      
      public Uri getDataUri()
      {
        return this.mDataUri;
      }
      
      public Bundle getExtras()
      {
        return this.mExtras;
      }
      
      public CharSequence getSender()
      {
        return this.mSender;
      }
      
      public CharSequence getText()
      {
        return this.mText;
      }
      
      public long getTimestamp()
      {
        return this.mTimestamp;
      }
      
      public Message setData(String paramString, Uri paramUri)
      {
        this.mDataMimeType = paramString;
        this.mDataUri = paramUri;
        return this;
      }
    }
  }
  
  static class NotificationCompatApi16Impl
    extends NotificationCompat.NotificationCompatBaseImpl
  {
    public Notification build(NotificationCompat.Builder paramBuilder, NotificationCompat.BuilderExtender paramBuilderExtender)
    {
      Object localObject = new NotificationCompatJellybean.Builder(paramBuilder.mContext, paramBuilder.mNotification, paramBuilder.mContentTitle, paramBuilder.mContentText, paramBuilder.mContentInfo, paramBuilder.mTickerView, paramBuilder.mNumber, paramBuilder.mContentIntent, paramBuilder.mFullScreenIntent, paramBuilder.mLargeIcon, paramBuilder.mProgressMax, paramBuilder.mProgress, paramBuilder.mProgressIndeterminate, paramBuilder.mUseChronometer, paramBuilder.mPriority, paramBuilder.mSubText, paramBuilder.mLocalOnly, paramBuilder.mExtras, paramBuilder.mGroupKey, paramBuilder.mGroupSummary, paramBuilder.mSortKey, paramBuilder.mContentView, paramBuilder.mBigContentView);
      NotificationCompat.addActionsToBuilder((NotificationBuilderWithActions)localObject, paramBuilder.mActions);
      if (paramBuilder.mStyle != null) {
        paramBuilder.mStyle.apply((NotificationBuilderWithBuilderAccessor)localObject);
      }
      paramBuilderExtender = paramBuilderExtender.build(paramBuilder, (NotificationBuilderWithBuilderAccessor)localObject);
      if (paramBuilder.mStyle != null)
      {
        localObject = NotificationCompat.getExtras(paramBuilderExtender);
        if (localObject != null) {
          paramBuilder.mStyle.addCompatExtras((Bundle)localObject);
        }
      }
      return paramBuilderExtender;
    }
    
    public NotificationCompat.Action getAction(Notification paramNotification, int paramInt)
    {
      return (NotificationCompat.Action)NotificationCompatJellybean.getAction(paramNotification, paramInt, NotificationCompat.Action.FACTORY, RemoteInput.FACTORY);
    }
    
    public NotificationCompat.Action[] getActionsFromParcelableArrayList(ArrayList<Parcelable> paramArrayList)
    {
      return (NotificationCompat.Action[])NotificationCompatJellybean.getActionsFromParcelableArrayList(paramArrayList, NotificationCompat.Action.FACTORY, RemoteInput.FACTORY);
    }
    
    public ArrayList<Parcelable> getParcelableArrayListForActions(NotificationCompat.Action[] paramArrayOfAction)
    {
      return NotificationCompatJellybean.getParcelableArrayListForActions(paramArrayOfAction);
    }
  }
  
  static class NotificationCompatApi19Impl
    extends NotificationCompat.NotificationCompatApi16Impl
  {
    public Notification build(NotificationCompat.Builder paramBuilder, NotificationCompat.BuilderExtender paramBuilderExtender)
    {
      NotificationCompatKitKat.Builder localBuilder = new NotificationCompatKitKat.Builder(paramBuilder.mContext, paramBuilder.mNotification, paramBuilder.mContentTitle, paramBuilder.mContentText, paramBuilder.mContentInfo, paramBuilder.mTickerView, paramBuilder.mNumber, paramBuilder.mContentIntent, paramBuilder.mFullScreenIntent, paramBuilder.mLargeIcon, paramBuilder.mProgressMax, paramBuilder.mProgress, paramBuilder.mProgressIndeterminate, paramBuilder.mShowWhen, paramBuilder.mUseChronometer, paramBuilder.mPriority, paramBuilder.mSubText, paramBuilder.mLocalOnly, paramBuilder.mPeople, paramBuilder.mExtras, paramBuilder.mGroupKey, paramBuilder.mGroupSummary, paramBuilder.mSortKey, paramBuilder.mContentView, paramBuilder.mBigContentView);
      NotificationCompat.addActionsToBuilder(localBuilder, paramBuilder.mActions);
      if (paramBuilder.mStyle != null) {
        paramBuilder.mStyle.apply(localBuilder);
      }
      return paramBuilderExtender.build(paramBuilder, localBuilder);
    }
    
    public NotificationCompat.Action getAction(Notification paramNotification, int paramInt)
    {
      return (NotificationCompat.Action)NotificationCompatKitKat.getAction(paramNotification, paramInt, NotificationCompat.Action.FACTORY, RemoteInput.FACTORY);
    }
  }
  
  static class NotificationCompatApi20Impl
    extends NotificationCompat.NotificationCompatApi19Impl
  {
    public Notification build(NotificationCompat.Builder paramBuilder, NotificationCompat.BuilderExtender paramBuilderExtender)
    {
      NotificationCompatApi20.Builder localBuilder = new NotificationCompatApi20.Builder(paramBuilder.mContext, paramBuilder.mNotification, paramBuilder.mContentTitle, paramBuilder.mContentText, paramBuilder.mContentInfo, paramBuilder.mTickerView, paramBuilder.mNumber, paramBuilder.mContentIntent, paramBuilder.mFullScreenIntent, paramBuilder.mLargeIcon, paramBuilder.mProgressMax, paramBuilder.mProgress, paramBuilder.mProgressIndeterminate, paramBuilder.mShowWhen, paramBuilder.mUseChronometer, paramBuilder.mPriority, paramBuilder.mSubText, paramBuilder.mLocalOnly, paramBuilder.mPeople, paramBuilder.mExtras, paramBuilder.mGroupKey, paramBuilder.mGroupSummary, paramBuilder.mSortKey, paramBuilder.mContentView, paramBuilder.mBigContentView, paramBuilder.mGroupAlertBehavior);
      NotificationCompat.addActionsToBuilder(localBuilder, paramBuilder.mActions);
      if (paramBuilder.mStyle != null) {
        paramBuilder.mStyle.apply(localBuilder);
      }
      paramBuilderExtender = paramBuilderExtender.build(paramBuilder, localBuilder);
      if (paramBuilder.mStyle != null) {
        paramBuilder.mStyle.addCompatExtras(NotificationCompat.getExtras(paramBuilderExtender));
      }
      return paramBuilderExtender;
    }
    
    public NotificationCompat.Action getAction(Notification paramNotification, int paramInt)
    {
      return (NotificationCompat.Action)NotificationCompatApi20.getAction(paramNotification, paramInt, NotificationCompat.Action.FACTORY, RemoteInput.FACTORY);
    }
    
    public NotificationCompat.Action[] getActionsFromParcelableArrayList(ArrayList<Parcelable> paramArrayList)
    {
      return (NotificationCompat.Action[])NotificationCompatApi20.getActionsFromParcelableArrayList(paramArrayList, NotificationCompat.Action.FACTORY, RemoteInput.FACTORY);
    }
    
    public ArrayList<Parcelable> getParcelableArrayListForActions(NotificationCompat.Action[] paramArrayOfAction)
    {
      return NotificationCompatApi20.getParcelableArrayListForActions(paramArrayOfAction);
    }
  }
  
  static class NotificationCompatApi21Impl
    extends NotificationCompat.NotificationCompatApi20Impl
  {
    public Notification build(NotificationCompat.Builder paramBuilder, NotificationCompat.BuilderExtender paramBuilderExtender)
    {
      NotificationCompatApi21.Builder localBuilder = new NotificationCompatApi21.Builder(paramBuilder.mContext, paramBuilder.mNotification, paramBuilder.mContentTitle, paramBuilder.mContentText, paramBuilder.mContentInfo, paramBuilder.mTickerView, paramBuilder.mNumber, paramBuilder.mContentIntent, paramBuilder.mFullScreenIntent, paramBuilder.mLargeIcon, paramBuilder.mProgressMax, paramBuilder.mProgress, paramBuilder.mProgressIndeterminate, paramBuilder.mShowWhen, paramBuilder.mUseChronometer, paramBuilder.mPriority, paramBuilder.mSubText, paramBuilder.mLocalOnly, paramBuilder.mCategory, paramBuilder.mPeople, paramBuilder.mExtras, paramBuilder.mColor, paramBuilder.mVisibility, paramBuilder.mPublicVersion, paramBuilder.mGroupKey, paramBuilder.mGroupSummary, paramBuilder.mSortKey, paramBuilder.mContentView, paramBuilder.mBigContentView, paramBuilder.mHeadsUpContentView, paramBuilder.mGroupAlertBehavior);
      NotificationCompat.addActionsToBuilder(localBuilder, paramBuilder.mActions);
      if (paramBuilder.mStyle != null) {
        paramBuilder.mStyle.apply(localBuilder);
      }
      paramBuilderExtender = paramBuilderExtender.build(paramBuilder, localBuilder);
      if (paramBuilder.mStyle != null) {
        paramBuilder.mStyle.addCompatExtras(NotificationCompat.getExtras(paramBuilderExtender));
      }
      return paramBuilderExtender;
    }
    
    public Bundle getBundleForUnreadConversation(NotificationCompatBase.UnreadConversation paramUnreadConversation)
    {
      return NotificationCompatApi21.getBundleForUnreadConversation(paramUnreadConversation);
    }
    
    public NotificationCompatBase.UnreadConversation getUnreadConversationFromBundle(Bundle paramBundle, NotificationCompatBase.UnreadConversation.Factory paramFactory, RemoteInputCompatBase.RemoteInput.Factory paramFactory1)
    {
      return NotificationCompatApi21.getUnreadConversationFromBundle(paramBundle, paramFactory, paramFactory1);
    }
  }
  
  static class NotificationCompatApi24Impl
    extends NotificationCompat.NotificationCompatApi21Impl
  {
    public Notification build(NotificationCompat.Builder paramBuilder, NotificationCompat.BuilderExtender paramBuilderExtender)
    {
      NotificationCompatApi24.Builder localBuilder = new NotificationCompatApi24.Builder(paramBuilder.mContext, paramBuilder.mNotification, paramBuilder.mContentTitle, paramBuilder.mContentText, paramBuilder.mContentInfo, paramBuilder.mTickerView, paramBuilder.mNumber, paramBuilder.mContentIntent, paramBuilder.mFullScreenIntent, paramBuilder.mLargeIcon, paramBuilder.mProgressMax, paramBuilder.mProgress, paramBuilder.mProgressIndeterminate, paramBuilder.mShowWhen, paramBuilder.mUseChronometer, paramBuilder.mPriority, paramBuilder.mSubText, paramBuilder.mLocalOnly, paramBuilder.mCategory, paramBuilder.mPeople, paramBuilder.mExtras, paramBuilder.mColor, paramBuilder.mVisibility, paramBuilder.mPublicVersion, paramBuilder.mGroupKey, paramBuilder.mGroupSummary, paramBuilder.mSortKey, paramBuilder.mRemoteInputHistory, paramBuilder.mContentView, paramBuilder.mBigContentView, paramBuilder.mHeadsUpContentView, paramBuilder.mGroupAlertBehavior);
      NotificationCompat.addActionsToBuilder(localBuilder, paramBuilder.mActions);
      if (paramBuilder.mStyle != null) {
        paramBuilder.mStyle.apply(localBuilder);
      }
      paramBuilderExtender = paramBuilderExtender.build(paramBuilder, localBuilder);
      if (paramBuilder.mStyle != null) {
        paramBuilder.mStyle.addCompatExtras(NotificationCompat.getExtras(paramBuilderExtender));
      }
      return paramBuilderExtender;
    }
    
    public NotificationCompat.Action getAction(Notification paramNotification, int paramInt)
    {
      return (NotificationCompat.Action)NotificationCompatApi24.getAction(paramNotification, paramInt, NotificationCompat.Action.FACTORY, RemoteInput.FACTORY);
    }
    
    public NotificationCompat.Action[] getActionsFromParcelableArrayList(ArrayList<Parcelable> paramArrayList)
    {
      return (NotificationCompat.Action[])NotificationCompatApi24.getActionsFromParcelableArrayList(paramArrayList, NotificationCompat.Action.FACTORY, RemoteInput.FACTORY);
    }
    
    public ArrayList<Parcelable> getParcelableArrayListForActions(NotificationCompat.Action[] paramArrayOfAction)
    {
      return NotificationCompatApi24.getParcelableArrayListForActions(paramArrayOfAction);
    }
  }
  
  static class NotificationCompatApi26Impl
    extends NotificationCompat.NotificationCompatApi24Impl
  {
    public Notification build(NotificationCompat.Builder paramBuilder, NotificationCompat.BuilderExtender paramBuilderExtender)
    {
      NotificationCompatApi26.Builder localBuilder = new NotificationCompatApi26.Builder(paramBuilder.mContext, paramBuilder.mNotification, paramBuilder.mContentTitle, paramBuilder.mContentText, paramBuilder.mContentInfo, paramBuilder.mTickerView, paramBuilder.mNumber, paramBuilder.mContentIntent, paramBuilder.mFullScreenIntent, paramBuilder.mLargeIcon, paramBuilder.mProgressMax, paramBuilder.mProgress, paramBuilder.mProgressIndeterminate, paramBuilder.mShowWhen, paramBuilder.mUseChronometer, paramBuilder.mPriority, paramBuilder.mSubText, paramBuilder.mLocalOnly, paramBuilder.mCategory, paramBuilder.mPeople, paramBuilder.mExtras, paramBuilder.mColor, paramBuilder.mVisibility, paramBuilder.mPublicVersion, paramBuilder.mGroupKey, paramBuilder.mGroupSummary, paramBuilder.mSortKey, paramBuilder.mRemoteInputHistory, paramBuilder.mContentView, paramBuilder.mBigContentView, paramBuilder.mHeadsUpContentView, paramBuilder.mChannelId, paramBuilder.mBadgeIcon, paramBuilder.mShortcutId, paramBuilder.mTimeout, paramBuilder.mColorized, paramBuilder.mColorizedSet, paramBuilder.mGroupAlertBehavior);
      NotificationCompat.addActionsToBuilder(localBuilder, paramBuilder.mActions);
      if (paramBuilder.mStyle != null) {
        paramBuilder.mStyle.apply(localBuilder);
      }
      paramBuilderExtender = paramBuilderExtender.build(paramBuilder, localBuilder);
      if (paramBuilder.mStyle != null) {
        paramBuilder.mStyle.addCompatExtras(NotificationCompat.getExtras(paramBuilderExtender));
      }
      return paramBuilderExtender;
    }
  }
  
  static class NotificationCompatBaseImpl
    implements NotificationCompat.NotificationCompatImpl
  {
    public Notification build(NotificationCompat.Builder paramBuilder, NotificationCompat.BuilderExtender paramBuilderExtender)
    {
      return paramBuilderExtender.build(paramBuilder, new BuilderBase(paramBuilder.mContext, paramBuilder.mNotification, paramBuilder.mContentTitle, paramBuilder.mContentText, paramBuilder.mContentInfo, paramBuilder.mTickerView, paramBuilder.mNumber, paramBuilder.mContentIntent, paramBuilder.mFullScreenIntent, paramBuilder.mLargeIcon, paramBuilder.mProgressMax, paramBuilder.mProgress, paramBuilder.mProgressIndeterminate));
    }
    
    public NotificationCompat.Action getAction(Notification paramNotification, int paramInt)
    {
      return null;
    }
    
    public NotificationCompat.Action[] getActionsFromParcelableArrayList(ArrayList<Parcelable> paramArrayList)
    {
      return null;
    }
    
    public Bundle getBundleForUnreadConversation(NotificationCompatBase.UnreadConversation paramUnreadConversation)
    {
      return null;
    }
    
    public ArrayList<Parcelable> getParcelableArrayListForActions(NotificationCompat.Action[] paramArrayOfAction)
    {
      return null;
    }
    
    public NotificationCompatBase.UnreadConversation getUnreadConversationFromBundle(Bundle paramBundle, NotificationCompatBase.UnreadConversation.Factory paramFactory, RemoteInputCompatBase.RemoteInput.Factory paramFactory1)
    {
      return null;
    }
    
    public static class BuilderBase
      implements NotificationBuilderWithBuilderAccessor
    {
      private Notification.Builder mBuilder;
      
      BuilderBase(Context paramContext, Notification paramNotification, CharSequence paramCharSequence1, CharSequence paramCharSequence2, CharSequence paramCharSequence3, RemoteViews paramRemoteViews, int paramInt1, PendingIntent paramPendingIntent1, PendingIntent paramPendingIntent2, Bitmap paramBitmap, int paramInt2, int paramInt3, boolean paramBoolean)
      {
        paramContext = new Notification.Builder(paramContext).setWhen(paramNotification.when).setSmallIcon(paramNotification.icon, paramNotification.iconLevel).setContent(paramNotification.contentView).setTicker(paramNotification.tickerText, paramRemoteViews).setSound(paramNotification.sound, paramNotification.audioStreamType).setVibrate(paramNotification.vibrate).setLights(paramNotification.ledARGB, paramNotification.ledOnMS, paramNotification.ledOffMS);
        if ((paramNotification.flags & 0x2) != 0)
        {
          bool = true;
          paramContext = paramContext.setOngoing(bool);
          if ((paramNotification.flags & 0x8) == 0) {
            break label224;
          }
          bool = true;
          label112:
          paramContext = paramContext.setOnlyAlertOnce(bool);
          if ((paramNotification.flags & 0x10) == 0) {
            break label230;
          }
          bool = true;
          label132:
          paramContext = paramContext.setAutoCancel(bool).setDefaults(paramNotification.defaults).setContentTitle(paramCharSequence1).setContentText(paramCharSequence2).setContentInfo(paramCharSequence3).setContentIntent(paramPendingIntent1).setDeleteIntent(paramNotification.deleteIntent);
          if ((paramNotification.flags & 0x80) == 0) {
            break label236;
          }
        }
        label224:
        label230:
        label236:
        for (boolean bool = true;; bool = false)
        {
          this.mBuilder = paramContext.setFullScreenIntent(paramPendingIntent2, bool).setLargeIcon(paramBitmap).setNumber(paramInt1).setProgress(paramInt2, paramInt3, paramBoolean);
          return;
          bool = false;
          break;
          bool = false;
          break label112;
          bool = false;
          break label132;
        }
      }
      
      public Notification build()
      {
        return this.mBuilder.getNotification();
      }
      
      public Notification.Builder getBuilder()
      {
        return this.mBuilder;
      }
    }
  }
  
  static abstract interface NotificationCompatImpl
  {
    public abstract Notification build(NotificationCompat.Builder paramBuilder, NotificationCompat.BuilderExtender paramBuilderExtender);
    
    public abstract NotificationCompat.Action getAction(Notification paramNotification, int paramInt);
    
    public abstract NotificationCompat.Action[] getActionsFromParcelableArrayList(ArrayList<Parcelable> paramArrayList);
    
    public abstract Bundle getBundleForUnreadConversation(NotificationCompatBase.UnreadConversation paramUnreadConversation);
    
    public abstract ArrayList<Parcelable> getParcelableArrayListForActions(NotificationCompat.Action[] paramArrayOfAction);
    
    public abstract NotificationCompatBase.UnreadConversation getUnreadConversationFromBundle(Bundle paramBundle, NotificationCompatBase.UnreadConversation.Factory paramFactory, RemoteInputCompatBase.RemoteInput.Factory paramFactory1);
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface NotificationVisibility {}
  
  public static abstract class Style
  {
    CharSequence mBigContentTitle;
    protected NotificationCompat.Builder mBuilder;
    CharSequence mSummaryText;
    boolean mSummaryTextSet = false;
    
    private int calculateTopPadding()
    {
      Resources localResources = this.mBuilder.mContext.getResources();
      int i = localResources.getDimensionPixelSize(R.dimen.notification_top_pad);
      int j = localResources.getDimensionPixelSize(R.dimen.notification_top_pad_large_text);
      float f1 = (constrain(localResources.getConfiguration().fontScale, 1.0F, 1.3F) - 1.0F) / 0.29999995F;
      float f2 = i;
      return Math.round(f1 * j + f2 * (1.0F - f1));
    }
    
    private static float constrain(float paramFloat1, float paramFloat2, float paramFloat3)
    {
      if (paramFloat1 < paramFloat2) {
        return paramFloat2;
      }
      if (paramFloat1 > paramFloat3) {
        return paramFloat3;
      }
      return paramFloat1;
    }
    
    private Bitmap createColoredBitmap(int paramInt1, int paramInt2, int paramInt3)
    {
      Drawable localDrawable = this.mBuilder.mContext.getResources().getDrawable(paramInt1);
      if (paramInt3 == 0) {}
      for (paramInt1 = localDrawable.getIntrinsicWidth();; paramInt1 = paramInt3)
      {
        int i = paramInt3;
        if (paramInt3 == 0) {
          i = localDrawable.getIntrinsicHeight();
        }
        Bitmap localBitmap = Bitmap.createBitmap(paramInt1, i, Bitmap.Config.ARGB_8888);
        localDrawable.setBounds(0, 0, paramInt1, i);
        if (paramInt2 != 0) {
          localDrawable.mutate().setColorFilter(new PorterDuffColorFilter(paramInt2, PorterDuff.Mode.SRC_IN));
        }
        localDrawable.draw(new Canvas(localBitmap));
        return localBitmap;
      }
    }
    
    private Bitmap createIconWithBackground(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      int j = R.drawable.notification_icon_background;
      int i = paramInt4;
      if (paramInt4 == 0) {
        i = 0;
      }
      Bitmap localBitmap = createColoredBitmap(j, i, paramInt2);
      Canvas localCanvas = new Canvas(localBitmap);
      Drawable localDrawable = this.mBuilder.mContext.getResources().getDrawable(paramInt1).mutate();
      localDrawable.setFilterBitmap(true);
      paramInt1 = (paramInt2 - paramInt3) / 2;
      localDrawable.setBounds(paramInt1, paramInt1, paramInt3 + paramInt1, paramInt3 + paramInt1);
      localDrawable.setColorFilter(new PorterDuffColorFilter(-1, PorterDuff.Mode.SRC_ATOP));
      localDrawable.draw(localCanvas);
      return localBitmap;
    }
    
    private void hideNormalContent(RemoteViews paramRemoteViews)
    {
      paramRemoteViews.setViewVisibility(R.id.title, 8);
      paramRemoteViews.setViewVisibility(R.id.text2, 8);
      paramRemoteViews.setViewVisibility(R.id.text, 8);
    }
    
    public void addCompatExtras(Bundle paramBundle) {}
    
    public void apply(NotificationBuilderWithBuilderAccessor paramNotificationBuilderWithBuilderAccessor) {}
    
    public RemoteViews applyStandardTemplate(boolean paramBoolean1, int paramInt, boolean paramBoolean2)
    {
      Resources localResources = this.mBuilder.mContext.getResources();
      RemoteViews localRemoteViews = new RemoteViews(this.mBuilder.mContext.getPackageName(), paramInt);
      label91:
      label133:
      int i;
      Object localObject;
      if (this.mBuilder.getPriority() < -1)
      {
        paramInt = 1;
        if ((Build.VERSION.SDK_INT >= 16) && (Build.VERSION.SDK_INT < 21))
        {
          if (paramInt == 0) {
            break label585;
          }
          localRemoteViews.setInt(R.id.notification_background, "setBackgroundResource", R.drawable.notification_bg_low);
          localRemoteViews.setInt(R.id.icon, "setBackgroundResource", R.drawable.notification_template_icon_low_bg);
        }
        if (this.mBuilder.mLargeIcon == null) {
          break label653;
        }
        if (Build.VERSION.SDK_INT < 16) {
          break label614;
        }
        localRemoteViews.setViewVisibility(R.id.icon, 0);
        localRemoteViews.setImageViewBitmap(R.id.icon, this.mBuilder.mLargeIcon);
        if ((paramBoolean1) && (this.mBuilder.mNotification.icon != 0))
        {
          paramInt = localResources.getDimensionPixelSize(R.dimen.notification_right_icon_size);
          i = localResources.getDimensionPixelSize(R.dimen.notification_small_icon_background_padding);
          if (Build.VERSION.SDK_INT < 21) {
            break label627;
          }
          localObject = createIconWithBackground(this.mBuilder.mNotification.icon, paramInt, paramInt - i * 2, this.mBuilder.getColor());
          localRemoteViews.setImageViewBitmap(R.id.right_icon, (Bitmap)localObject);
          label217:
          localRemoteViews.setViewVisibility(R.id.right_icon, 0);
        }
        label226:
        if (this.mBuilder.mContentTitle != null) {
          localRemoteViews.setTextViewText(R.id.title, this.mBuilder.mContentTitle);
        }
        if (this.mBuilder.mContentText == null) {
          break label963;
        }
        localRemoteViews.setTextViewText(R.id.text, this.mBuilder.mContentText);
      }
      label299:
      label338:
      label408:
      label536:
      label549:
      label585:
      label614:
      label627:
      label653:
      label790:
      label905:
      label915:
      label921:
      label951:
      label957:
      label963:
      for (paramInt = 1;; paramInt = 0)
      {
        int j;
        if ((Build.VERSION.SDK_INT < 21) && (this.mBuilder.mLargeIcon != null))
        {
          i = 1;
          if (this.mBuilder.mContentInfo == null) {
            break label790;
          }
          localRemoteViews.setTextViewText(R.id.info, this.mBuilder.mContentInfo);
          localRemoteViews.setViewVisibility(R.id.info, 0);
          paramInt = 1;
          i = 1;
          if ((this.mBuilder.mSubText == null) || (Build.VERSION.SDK_INT < 16)) {
            break label915;
          }
          localRemoteViews.setTextViewText(R.id.text, this.mBuilder.mSubText);
          if (this.mBuilder.mContentText == null) {
            break label905;
          }
          localRemoteViews.setTextViewText(R.id.text2, this.mBuilder.mContentText);
          localRemoteViews.setViewVisibility(R.id.text2, 0);
          j = 1;
          if ((j != 0) && (Build.VERSION.SDK_INT >= 16))
          {
            if (paramBoolean2)
            {
              float f = localResources.getDimensionPixelSize(R.dimen.notification_subtext_size);
              localRemoteViews.setTextViewTextSize(R.id.text, 0, f);
            }
            localRemoteViews.setViewPadding(R.id.line1, 0, 0, 0, 0);
          }
          if (this.mBuilder.getWhenIfShowing() != 0L)
          {
            if ((!this.mBuilder.mUseChronometer) || (Build.VERSION.SDK_INT < 16)) {
              break label921;
            }
            localRemoteViews.setViewVisibility(R.id.chronometer, 0);
            localRemoteViews.setLong(R.id.chronometer, "setBase", this.mBuilder.getWhenIfShowing() + (SystemClock.elapsedRealtime() - System.currentTimeMillis()));
            localRemoteViews.setBoolean(R.id.chronometer, "setStarted", true);
            paramInt = 1;
          }
          j = R.id.right_side;
          if (paramInt == 0) {
            break label951;
          }
          paramInt = 0;
          localRemoteViews.setViewVisibility(j, paramInt);
          j = R.id.line3;
          if (i == 0) {
            break label957;
          }
        }
        for (paramInt = 0;; paramInt = 8)
        {
          localRemoteViews.setViewVisibility(j, paramInt);
          return localRemoteViews;
          paramInt = 0;
          break;
          localRemoteViews.setInt(R.id.notification_background, "setBackgroundResource", R.drawable.notification_bg);
          localRemoteViews.setInt(R.id.icon, "setBackgroundResource", R.drawable.notification_template_icon_bg);
          break label91;
          localRemoteViews.setViewVisibility(R.id.icon, 8);
          break label133;
          localRemoteViews.setImageViewBitmap(R.id.right_icon, createColoredBitmap(this.mBuilder.mNotification.icon, -1));
          break label217;
          if ((!paramBoolean1) || (this.mBuilder.mNotification.icon == 0)) {
            break label226;
          }
          localRemoteViews.setViewVisibility(R.id.icon, 0);
          if (Build.VERSION.SDK_INT >= 21)
          {
            paramInt = localResources.getDimensionPixelSize(R.dimen.notification_large_icon_width);
            i = localResources.getDimensionPixelSize(R.dimen.notification_big_circle_margin);
            j = localResources.getDimensionPixelSize(R.dimen.notification_small_icon_size_as_large);
            localObject = createIconWithBackground(this.mBuilder.mNotification.icon, paramInt - i, j, this.mBuilder.getColor());
            localRemoteViews.setImageViewBitmap(R.id.icon, (Bitmap)localObject);
            break label226;
          }
          localRemoteViews.setImageViewBitmap(R.id.icon, createColoredBitmap(this.mBuilder.mNotification.icon, -1));
          break label226;
          i = 0;
          break label299;
          if (this.mBuilder.mNumber > 0)
          {
            paramInt = localResources.getInteger(R.integer.status_bar_notification_info_maxnum);
            if (this.mBuilder.mNumber > paramInt) {
              localRemoteViews.setTextViewText(R.id.info, localResources.getString(R.string.status_bar_notification_info_overflow));
            }
            for (;;)
            {
              localRemoteViews.setViewVisibility(R.id.info, 0);
              paramInt = 1;
              i = 1;
              break;
              localObject = NumberFormat.getIntegerInstance();
              localRemoteViews.setTextViewText(R.id.info, ((NumberFormat)localObject).format(this.mBuilder.mNumber));
            }
          }
          localRemoteViews.setViewVisibility(R.id.info, 8);
          j = paramInt;
          paramInt = i;
          i = j;
          break label338;
          localRemoteViews.setViewVisibility(R.id.text2, 8);
          j = 0;
          break label408;
          localRemoteViews.setViewVisibility(R.id.time, 0);
          localRemoteViews.setLong(R.id.time, "setTime", this.mBuilder.getWhenIfShowing());
          break label536;
          paramInt = 8;
          break label549;
        }
      }
    }
    
    public Notification build()
    {
      Notification localNotification = null;
      if (this.mBuilder != null) {
        localNotification = this.mBuilder.build();
      }
      return localNotification;
    }
    
    public void buildIntoRemoteViews(RemoteViews paramRemoteViews1, RemoteViews paramRemoteViews2)
    {
      hideNormalContent(paramRemoteViews1);
      paramRemoteViews1.removeAllViews(R.id.notification_main_column);
      paramRemoteViews1.addView(R.id.notification_main_column, paramRemoteViews2.clone());
      paramRemoteViews1.setViewVisibility(R.id.notification_main_column, 0);
      if (Build.VERSION.SDK_INT >= 21) {
        paramRemoteViews1.setViewPadding(R.id.notification_main_column_container, 0, calculateTopPadding(), 0, 0);
      }
    }
    
    public Bitmap createColoredBitmap(int paramInt1, int paramInt2)
    {
      return createColoredBitmap(paramInt1, paramInt2, 0);
    }
    
    public RemoteViews makeBigContentView(NotificationBuilderWithBuilderAccessor paramNotificationBuilderWithBuilderAccessor)
    {
      return null;
    }
    
    public RemoteViews makeContentView(NotificationBuilderWithBuilderAccessor paramNotificationBuilderWithBuilderAccessor)
    {
      return null;
    }
    
    public RemoteViews makeHeadsUpContentView(NotificationBuilderWithBuilderAccessor paramNotificationBuilderWithBuilderAccessor)
    {
      return null;
    }
    
    protected void restoreFromCompatExtras(Bundle paramBundle) {}
    
    public void setBuilder(NotificationCompat.Builder paramBuilder)
    {
      if (this.mBuilder != paramBuilder)
      {
        this.mBuilder = paramBuilder;
        if (this.mBuilder != null) {
          this.mBuilder.setStyle(this);
        }
      }
    }
  }
  
  public static final class WearableExtender
    implements NotificationCompat.Extender
  {
    private static final int DEFAULT_CONTENT_ICON_GRAVITY = 8388613;
    private static final int DEFAULT_FLAGS = 1;
    private static final int DEFAULT_GRAVITY = 80;
    private static final String EXTRA_WEARABLE_EXTENSIONS = "android.wearable.EXTENSIONS";
    private static final int FLAG_BIG_PICTURE_AMBIENT = 32;
    private static final int FLAG_CONTENT_INTENT_AVAILABLE_OFFLINE = 1;
    private static final int FLAG_HINT_AVOID_BACKGROUND_CLIPPING = 16;
    private static final int FLAG_HINT_CONTENT_INTENT_LAUNCHES_ACTIVITY = 64;
    private static final int FLAG_HINT_HIDE_ICON = 2;
    private static final int FLAG_HINT_SHOW_BACKGROUND_ONLY = 4;
    private static final int FLAG_START_SCROLL_BOTTOM = 8;
    private static final String KEY_ACTIONS = "actions";
    private static final String KEY_BACKGROUND = "background";
    private static final String KEY_BRIDGE_TAG = "bridgeTag";
    private static final String KEY_CONTENT_ACTION_INDEX = "contentActionIndex";
    private static final String KEY_CONTENT_ICON = "contentIcon";
    private static final String KEY_CONTENT_ICON_GRAVITY = "contentIconGravity";
    private static final String KEY_CUSTOM_CONTENT_HEIGHT = "customContentHeight";
    private static final String KEY_CUSTOM_SIZE_PRESET = "customSizePreset";
    private static final String KEY_DISMISSAL_ID = "dismissalId";
    private static final String KEY_DISPLAY_INTENT = "displayIntent";
    private static final String KEY_FLAGS = "flags";
    private static final String KEY_GRAVITY = "gravity";
    private static final String KEY_HINT_SCREEN_TIMEOUT = "hintScreenTimeout";
    private static final String KEY_PAGES = "pages";
    public static final int SCREEN_TIMEOUT_LONG = -1;
    public static final int SCREEN_TIMEOUT_SHORT = 0;
    public static final int SIZE_DEFAULT = 0;
    public static final int SIZE_FULL_SCREEN = 5;
    public static final int SIZE_LARGE = 4;
    public static final int SIZE_MEDIUM = 3;
    public static final int SIZE_SMALL = 2;
    public static final int SIZE_XSMALL = 1;
    public static final int UNSET_ACTION_INDEX = -1;
    private ArrayList<NotificationCompat.Action> mActions = new ArrayList();
    private Bitmap mBackground;
    private String mBridgeTag;
    private int mContentActionIndex = -1;
    private int mContentIcon;
    private int mContentIconGravity = 8388613;
    private int mCustomContentHeight;
    private int mCustomSizePreset = 0;
    private String mDismissalId;
    private PendingIntent mDisplayIntent;
    private int mFlags = 1;
    private int mGravity = 80;
    private int mHintScreenTimeout;
    private ArrayList<Notification> mPages = new ArrayList();
    
    public WearableExtender() {}
    
    public WearableExtender(Notification paramNotification)
    {
      paramNotification = NotificationCompat.getExtras(paramNotification);
      if (paramNotification != null) {}
      for (paramNotification = paramNotification.getBundle("android.wearable.EXTENSIONS");; paramNotification = null)
      {
        if (paramNotification != null)
        {
          Object localObject = NotificationCompat.IMPL.getActionsFromParcelableArrayList(paramNotification.getParcelableArrayList("actions"));
          if (localObject != null) {
            Collections.addAll(this.mActions, (Object[])localObject);
          }
          this.mFlags = paramNotification.getInt("flags", 1);
          this.mDisplayIntent = ((PendingIntent)paramNotification.getParcelable("displayIntent"));
          localObject = NotificationCompat.getNotificationArrayFromBundle(paramNotification, "pages");
          if (localObject != null) {
            Collections.addAll(this.mPages, (Object[])localObject);
          }
          this.mBackground = ((Bitmap)paramNotification.getParcelable("background"));
          this.mContentIcon = paramNotification.getInt("contentIcon");
          this.mContentIconGravity = paramNotification.getInt("contentIconGravity", 8388613);
          this.mContentActionIndex = paramNotification.getInt("contentActionIndex", -1);
          this.mCustomSizePreset = paramNotification.getInt("customSizePreset", 0);
          this.mCustomContentHeight = paramNotification.getInt("customContentHeight");
          this.mGravity = paramNotification.getInt("gravity", 80);
          this.mHintScreenTimeout = paramNotification.getInt("hintScreenTimeout");
          this.mDismissalId = paramNotification.getString("dismissalId");
          this.mBridgeTag = paramNotification.getString("bridgeTag");
        }
        return;
      }
    }
    
    private void setFlag(int paramInt, boolean paramBoolean)
    {
      if (paramBoolean)
      {
        this.mFlags |= paramInt;
        return;
      }
      this.mFlags &= (paramInt ^ 0xFFFFFFFF);
    }
    
    public WearableExtender addAction(NotificationCompat.Action paramAction)
    {
      this.mActions.add(paramAction);
      return this;
    }
    
    public WearableExtender addActions(List<NotificationCompat.Action> paramList)
    {
      this.mActions.addAll(paramList);
      return this;
    }
    
    public WearableExtender addPage(Notification paramNotification)
    {
      this.mPages.add(paramNotification);
      return this;
    }
    
    public WearableExtender addPages(List<Notification> paramList)
    {
      this.mPages.addAll(paramList);
      return this;
    }
    
    public WearableExtender clearActions()
    {
      this.mActions.clear();
      return this;
    }
    
    public WearableExtender clearPages()
    {
      this.mPages.clear();
      return this;
    }
    
    public WearableExtender clone()
    {
      WearableExtender localWearableExtender = new WearableExtender();
      localWearableExtender.mActions = new ArrayList(this.mActions);
      localWearableExtender.mFlags = this.mFlags;
      localWearableExtender.mDisplayIntent = this.mDisplayIntent;
      localWearableExtender.mPages = new ArrayList(this.mPages);
      localWearableExtender.mBackground = this.mBackground;
      localWearableExtender.mContentIcon = this.mContentIcon;
      localWearableExtender.mContentIconGravity = this.mContentIconGravity;
      localWearableExtender.mContentActionIndex = this.mContentActionIndex;
      localWearableExtender.mCustomSizePreset = this.mCustomSizePreset;
      localWearableExtender.mCustomContentHeight = this.mCustomContentHeight;
      localWearableExtender.mGravity = this.mGravity;
      localWearableExtender.mHintScreenTimeout = this.mHintScreenTimeout;
      localWearableExtender.mDismissalId = this.mDismissalId;
      localWearableExtender.mBridgeTag = this.mBridgeTag;
      return localWearableExtender;
    }
    
    public NotificationCompat.Builder extend(NotificationCompat.Builder paramBuilder)
    {
      Bundle localBundle = new Bundle();
      if (!this.mActions.isEmpty()) {
        localBundle.putParcelableArrayList("actions", NotificationCompat.IMPL.getParcelableArrayListForActions((NotificationCompat.Action[])this.mActions.toArray(new NotificationCompat.Action[this.mActions.size()])));
      }
      if (this.mFlags != 1) {
        localBundle.putInt("flags", this.mFlags);
      }
      if (this.mDisplayIntent != null) {
        localBundle.putParcelable("displayIntent", this.mDisplayIntent);
      }
      if (!this.mPages.isEmpty()) {
        localBundle.putParcelableArray("pages", (Parcelable[])this.mPages.toArray(new Notification[this.mPages.size()]));
      }
      if (this.mBackground != null) {
        localBundle.putParcelable("background", this.mBackground);
      }
      if (this.mContentIcon != 0) {
        localBundle.putInt("contentIcon", this.mContentIcon);
      }
      if (this.mContentIconGravity != 8388613) {
        localBundle.putInt("contentIconGravity", this.mContentIconGravity);
      }
      if (this.mContentActionIndex != -1) {
        localBundle.putInt("contentActionIndex", this.mContentActionIndex);
      }
      if (this.mCustomSizePreset != 0) {
        localBundle.putInt("customSizePreset", this.mCustomSizePreset);
      }
      if (this.mCustomContentHeight != 0) {
        localBundle.putInt("customContentHeight", this.mCustomContentHeight);
      }
      if (this.mGravity != 80) {
        localBundle.putInt("gravity", this.mGravity);
      }
      if (this.mHintScreenTimeout != 0) {
        localBundle.putInt("hintScreenTimeout", this.mHintScreenTimeout);
      }
      if (this.mDismissalId != null) {
        localBundle.putString("dismissalId", this.mDismissalId);
      }
      if (this.mBridgeTag != null) {
        localBundle.putString("bridgeTag", this.mBridgeTag);
      }
      paramBuilder.getExtras().putBundle("android.wearable.EXTENSIONS", localBundle);
      return paramBuilder;
    }
    
    public List<NotificationCompat.Action> getActions()
    {
      return this.mActions;
    }
    
    public Bitmap getBackground()
    {
      return this.mBackground;
    }
    
    public String getBridgeTag()
    {
      return this.mBridgeTag;
    }
    
    public int getContentAction()
    {
      return this.mContentActionIndex;
    }
    
    public int getContentIcon()
    {
      return this.mContentIcon;
    }
    
    public int getContentIconGravity()
    {
      return this.mContentIconGravity;
    }
    
    public boolean getContentIntentAvailableOffline()
    {
      return (this.mFlags & 0x1) != 0;
    }
    
    public int getCustomContentHeight()
    {
      return this.mCustomContentHeight;
    }
    
    public int getCustomSizePreset()
    {
      return this.mCustomSizePreset;
    }
    
    public String getDismissalId()
    {
      return this.mDismissalId;
    }
    
    public PendingIntent getDisplayIntent()
    {
      return this.mDisplayIntent;
    }
    
    public int getGravity()
    {
      return this.mGravity;
    }
    
    public boolean getHintAmbientBigPicture()
    {
      return (this.mFlags & 0x20) != 0;
    }
    
    public boolean getHintAvoidBackgroundClipping()
    {
      return (this.mFlags & 0x10) != 0;
    }
    
    public boolean getHintContentIntentLaunchesActivity()
    {
      return (this.mFlags & 0x40) != 0;
    }
    
    public boolean getHintHideIcon()
    {
      return (this.mFlags & 0x2) != 0;
    }
    
    public int getHintScreenTimeout()
    {
      return this.mHintScreenTimeout;
    }
    
    public boolean getHintShowBackgroundOnly()
    {
      return (this.mFlags & 0x4) != 0;
    }
    
    public List<Notification> getPages()
    {
      return this.mPages;
    }
    
    public boolean getStartScrollBottom()
    {
      return (this.mFlags & 0x8) != 0;
    }
    
    public WearableExtender setBackground(Bitmap paramBitmap)
    {
      this.mBackground = paramBitmap;
      return this;
    }
    
    public WearableExtender setBridgeTag(String paramString)
    {
      this.mBridgeTag = paramString;
      return this;
    }
    
    public WearableExtender setContentAction(int paramInt)
    {
      this.mContentActionIndex = paramInt;
      return this;
    }
    
    public WearableExtender setContentIcon(int paramInt)
    {
      this.mContentIcon = paramInt;
      return this;
    }
    
    public WearableExtender setContentIconGravity(int paramInt)
    {
      this.mContentIconGravity = paramInt;
      return this;
    }
    
    public WearableExtender setContentIntentAvailableOffline(boolean paramBoolean)
    {
      setFlag(1, paramBoolean);
      return this;
    }
    
    public WearableExtender setCustomContentHeight(int paramInt)
    {
      this.mCustomContentHeight = paramInt;
      return this;
    }
    
    public WearableExtender setCustomSizePreset(int paramInt)
    {
      this.mCustomSizePreset = paramInt;
      return this;
    }
    
    public WearableExtender setDismissalId(String paramString)
    {
      this.mDismissalId = paramString;
      return this;
    }
    
    public WearableExtender setDisplayIntent(PendingIntent paramPendingIntent)
    {
      this.mDisplayIntent = paramPendingIntent;
      return this;
    }
    
    public WearableExtender setGravity(int paramInt)
    {
      this.mGravity = paramInt;
      return this;
    }
    
    public WearableExtender setHintAmbientBigPicture(boolean paramBoolean)
    {
      setFlag(32, paramBoolean);
      return this;
    }
    
    public WearableExtender setHintAvoidBackgroundClipping(boolean paramBoolean)
    {
      setFlag(16, paramBoolean);
      return this;
    }
    
    public WearableExtender setHintContentIntentLaunchesActivity(boolean paramBoolean)
    {
      setFlag(64, paramBoolean);
      return this;
    }
    
    public WearableExtender setHintHideIcon(boolean paramBoolean)
    {
      setFlag(2, paramBoolean);
      return this;
    }
    
    public WearableExtender setHintScreenTimeout(int paramInt)
    {
      this.mHintScreenTimeout = paramInt;
      return this;
    }
    
    public WearableExtender setHintShowBackgroundOnly(boolean paramBoolean)
    {
      setFlag(4, paramBoolean);
      return this;
    }
    
    public WearableExtender setStartScrollBottom(boolean paramBoolean)
    {
      setFlag(8, paramBoolean);
      return this;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/android/support/v4/app/NotificationCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */