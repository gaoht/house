package android.support.v7.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.Observable;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.os.SystemClock;
import android.support.v4.os.TraceCompat;
import android.support.v4.view.AbsSavedState;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.NestedScrollingChild2;
import android.support.v4.view.NestedScrollingChildHelper;
import android.support.v4.view.ScrollingView;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewConfigurationCompat;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.CollectionInfoCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.CollectionItemInfoCompat;
import android.support.v4.widget.EdgeEffectCompat;
import android.support.v7.recyclerview.R.dimen;
import android.support.v7.recyclerview.R.styleable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.Display;
import android.view.FocusFinder;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.OverScroller;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RecyclerView
  extends ViewGroup
  implements NestedScrollingChild2, ScrollingView
{
  static final boolean ALLOW_SIZE_IN_UNSPECIFIED_SPEC;
  private static final boolean ALLOW_THREAD_GAP_WORK;
  private static final int[] CLIP_TO_PADDING_ATTR;
  static final boolean DEBUG = false;
  static final boolean DISPATCH_TEMP_DETACH = false;
  private static final boolean FORCE_ABS_FOCUS_SEARCH_DIRECTION;
  static final boolean FORCE_INVALIDATE_DISPLAY_LIST;
  static final long FOREVER_NS = Long.MAX_VALUE;
  public static final int HORIZONTAL = 0;
  private static final boolean IGNORE_DETACHED_FOCUSED_CHILD;
  private static final int INVALID_POINTER = -1;
  public static final int INVALID_TYPE = -1;
  private static final Class<?>[] LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE;
  static final int MAX_SCROLL_DURATION = 2000;
  private static final int[] NESTED_SCROLLING_ATTRS = { 16843830 };
  public static final long NO_ID = -1L;
  public static final int NO_POSITION = -1;
  static final boolean POST_UPDATES_ON_ANIMATION;
  public static final int SCROLL_STATE_DRAGGING = 1;
  public static final int SCROLL_STATE_IDLE = 0;
  public static final int SCROLL_STATE_SETTLING = 2;
  static final String TAG = "RecyclerView";
  public static final int TOUCH_SLOP_DEFAULT = 0;
  public static final int TOUCH_SLOP_PAGING = 1;
  static final String TRACE_BIND_VIEW_TAG = "RV OnBindView";
  static final String TRACE_CREATE_VIEW_TAG = "RV CreateView";
  private static final String TRACE_HANDLE_ADAPTER_UPDATES_TAG = "RV PartialInvalidate";
  static final String TRACE_NESTED_PREFETCH_TAG = "RV Nested Prefetch";
  private static final String TRACE_ON_DATA_SET_CHANGE_LAYOUT_TAG = "RV FullInvalidate";
  private static final String TRACE_ON_LAYOUT_TAG = "RV OnLayout";
  static final String TRACE_PREFETCH_TAG = "RV Prefetch";
  static final String TRACE_SCROLL_TAG = "RV Scroll";
  static final boolean VERBOSE_TRACING = false;
  public static final int VERTICAL = 1;
  static final Interpolator sQuinticInterpolator;
  ag mAccessibilityDelegate;
  private final AccessibilityManager mAccessibilityManager;
  private k mActiveOnItemTouchListener;
  a mAdapter;
  d mAdapterHelper;
  boolean mAdapterUpdateDuringMeasure;
  private EdgeEffect mBottomGlow;
  private d mChildDrawingOrderCallback;
  s mChildHelper;
  boolean mClipToPadding;
  boolean mDataSetHasChangedAfterLayout = false;
  private int mDispatchScrollCounter = 0;
  private int mEatRequestLayout = 0;
  private int mEatenAccessibilityChangeFlags;
  boolean mEnableFastScroller;
  boolean mFirstLayoutComplete;
  aa mGapWorker;
  boolean mHasFixedSize;
  private boolean mIgnoreMotionEventTillDown;
  private int mInitialTouchX;
  private int mInitialTouchY;
  boolean mIsAttached;
  e mItemAnimator = new v();
  private RecyclerView.e.b mItemAnimatorListener;
  private Runnable mItemAnimatorRunner;
  final ArrayList<g> mItemDecorations = new ArrayList();
  boolean mItemsAddedOrRemoved;
  boolean mItemsChanged;
  private int mLastTouchX;
  private int mLastTouchY;
  h mLayout;
  boolean mLayoutFrozen;
  private int mLayoutOrScrollCounter = 0;
  boolean mLayoutRequestEaten;
  private EdgeEffect mLeftGlow;
  private final int mMaxFlingVelocity;
  private final int mMinFlingVelocity;
  private final int[] mMinMaxLayoutPositions;
  private final int[] mNestedOffsets;
  private final p mObserver = new p();
  private List<i> mOnChildAttachStateListeners;
  private j mOnFlingListener;
  private final ArrayList<k> mOnItemTouchListeners = new ArrayList();
  final List<u> mPendingAccessibilityImportanceChange;
  private SavedState mPendingSavedState;
  boolean mPostedAnimatorRunner;
  aa.a mPrefetchRegistry;
  private boolean mPreserveFocusAfterLayout = true;
  final n mRecycler = new n();
  o mRecyclerListener;
  private EdgeEffect mRightGlow;
  private float mScaledHorizontalScrollFactor = Float.MIN_VALUE;
  private float mScaledVerticalScrollFactor = Float.MIN_VALUE;
  private final int[] mScrollConsumed;
  private l mScrollListener;
  private List<l> mScrollListeners;
  private final int[] mScrollOffset;
  private int mScrollPointerId = -1;
  private int mScrollState = 0;
  private NestedScrollingChildHelper mScrollingChildHelper;
  final r mState;
  final Rect mTempRect = new Rect();
  private final Rect mTempRect2 = new Rect();
  final RectF mTempRectF = new RectF();
  private EdgeEffect mTopGlow;
  private int mTouchSlop;
  final Runnable mUpdateChildViewsRunnable = new Runnable()
  {
    public void run()
    {
      if ((!RecyclerView.this.mFirstLayoutComplete) || (RecyclerView.this.isLayoutRequested())) {
        return;
      }
      if (!RecyclerView.this.mIsAttached)
      {
        RecyclerView.this.requestLayout();
        return;
      }
      if (RecyclerView.this.mLayoutFrozen)
      {
        RecyclerView.this.mLayoutRequestEaten = true;
        return;
      }
      RecyclerView.this.consumePendingUpdateOperations();
    }
  };
  private VelocityTracker mVelocityTracker;
  final t mViewFlinger = new t();
  private final ba.b mViewInfoProcessCallback;
  final ba mViewInfoStore = new ba();
  
  static
  {
    CLIP_TO_PADDING_ATTR = new int[] { 16842987 };
    if ((Build.VERSION.SDK_INT == 18) || (Build.VERSION.SDK_INT == 19) || (Build.VERSION.SDK_INT == 20))
    {
      bool = true;
      FORCE_INVALIDATE_DISPLAY_LIST = bool;
      if (Build.VERSION.SDK_INT < 23) {
        break label171;
      }
      bool = true;
      label64:
      ALLOW_SIZE_IN_UNSPECIFIED_SPEC = bool;
      if (Build.VERSION.SDK_INT < 16) {
        break label176;
      }
      bool = true;
      label78:
      POST_UPDATES_ON_ANIMATION = bool;
      if (Build.VERSION.SDK_INT < 21) {
        break label181;
      }
      bool = true;
      label92:
      ALLOW_THREAD_GAP_WORK = bool;
      if (Build.VERSION.SDK_INT > 15) {
        break label186;
      }
      bool = true;
      label106:
      FORCE_ABS_FOCUS_SEARCH_DIRECTION = bool;
      if (Build.VERSION.SDK_INT > 15) {
        break label191;
      }
    }
    label171:
    label176:
    label181:
    label186:
    label191:
    for (boolean bool = true;; bool = false)
    {
      IGNORE_DETACHED_FOCUSED_CHILD = bool;
      LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE = new Class[] { Context.class, AttributeSet.class, Integer.TYPE, Integer.TYPE };
      sQuinticInterpolator = new Interpolator()
      {
        public float getInterpolation(float paramAnonymousFloat)
        {
          paramAnonymousFloat -= 1.0F;
          return paramAnonymousFloat * (paramAnonymousFloat * paramAnonymousFloat * paramAnonymousFloat * paramAnonymousFloat) + 1.0F;
        }
      };
      return;
      bool = false;
      break;
      bool = false;
      break label64;
      bool = false;
      break label78;
      bool = false;
      break label92;
      bool = false;
      break label106;
    }
  }
  
  public RecyclerView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public RecyclerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public RecyclerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    Object localObject;
    label338:
    boolean bool1;
    if (ALLOW_THREAD_GAP_WORK)
    {
      localObject = new aa.a();
      this.mPrefetchRegistry = ((aa.a)localObject);
      this.mState = new r();
      this.mItemsAddedOrRemoved = false;
      this.mItemsChanged = false;
      this.mItemAnimatorListener = new f();
      this.mPostedAnimatorRunner = false;
      this.mMinMaxLayoutPositions = new int[2];
      this.mScrollOffset = new int[2];
      this.mScrollConsumed = new int[2];
      this.mNestedOffsets = new int[2];
      this.mPendingAccessibilityImportanceChange = new ArrayList();
      this.mItemAnimatorRunner = new Runnable()
      {
        public void run()
        {
          if (RecyclerView.this.mItemAnimator != null) {
            RecyclerView.this.mItemAnimator.runPendingAnimations();
          }
          RecyclerView.this.mPostedAnimatorRunner = false;
        }
      };
      this.mViewInfoProcessCallback = new ba.b()
      {
        public void processAppeared(RecyclerView.u paramAnonymousu, RecyclerView.e.c paramAnonymousc1, RecyclerView.e.c paramAnonymousc2)
        {
          RecyclerView.this.animateAppearance(paramAnonymousu, paramAnonymousc1, paramAnonymousc2);
        }
        
        public void processDisappeared(RecyclerView.u paramAnonymousu, RecyclerView.e.c paramAnonymousc1, RecyclerView.e.c paramAnonymousc2)
        {
          RecyclerView.this.mRecycler.c(paramAnonymousu);
          RecyclerView.this.animateDisappearance(paramAnonymousu, paramAnonymousc1, paramAnonymousc2);
        }
        
        public void processPersistent(RecyclerView.u paramAnonymousu, RecyclerView.e.c paramAnonymousc1, RecyclerView.e.c paramAnonymousc2)
        {
          paramAnonymousu.setIsRecyclable(false);
          if (RecyclerView.this.mDataSetHasChangedAfterLayout) {
            if (RecyclerView.this.mItemAnimator.animateChange(paramAnonymousu, paramAnonymousu, paramAnonymousc1, paramAnonymousc2)) {
              RecyclerView.this.postAnimationRunner();
            }
          }
          while (!RecyclerView.this.mItemAnimator.animatePersistence(paramAnonymousu, paramAnonymousc1, paramAnonymousc2)) {
            return;
          }
          RecyclerView.this.postAnimationRunner();
        }
        
        public void unused(RecyclerView.u paramAnonymousu)
        {
          RecyclerView.this.mLayout.removeAndRecycleView(paramAnonymousu.itemView, RecyclerView.this.mRecycler);
        }
      };
      if (paramAttributeSet == null) {
        break label649;
      }
      localObject = paramContext.obtainStyledAttributes(paramAttributeSet, CLIP_TO_PADDING_ATTR, paramInt, 0);
      this.mClipToPadding = ((TypedArray)localObject).getBoolean(0, true);
      ((TypedArray)localObject).recycle();
      setScrollContainer(true);
      setFocusableInTouchMode(true);
      localObject = ViewConfiguration.get(paramContext);
      this.mTouchSlop = ((ViewConfiguration)localObject).getScaledTouchSlop();
      this.mScaledHorizontalScrollFactor = ViewConfigurationCompat.getScaledHorizontalScrollFactor((ViewConfiguration)localObject, paramContext);
      this.mScaledVerticalScrollFactor = ViewConfigurationCompat.getScaledVerticalScrollFactor((ViewConfiguration)localObject, paramContext);
      this.mMinFlingVelocity = ((ViewConfiguration)localObject).getScaledMinimumFlingVelocity();
      this.mMaxFlingVelocity = ((ViewConfiguration)localObject).getScaledMaximumFlingVelocity();
      if (getOverScrollMode() != 2) {
        break label657;
      }
      bool1 = true;
      label412:
      setWillNotDraw(bool1);
      this.mItemAnimator.a(this.mItemAnimatorListener);
      initAdapterManager();
      initChildrenHelper();
      if (ViewCompat.getImportantForAccessibility(this) == 0) {
        ViewCompat.setImportantForAccessibility(this, 1);
      }
      this.mAccessibilityManager = ((AccessibilityManager)getContext().getSystemService("accessibility"));
      setAccessibilityDelegateCompat(new ag(this));
      if (paramAttributeSet == null) {
        break label663;
      }
      localObject = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.RecyclerView, paramInt, 0);
      String str = ((TypedArray)localObject).getString(R.styleable.RecyclerView_layoutManager);
      if (((TypedArray)localObject).getInt(R.styleable.RecyclerView_android_descendantFocusability, -1) == -1) {
        setDescendantFocusability(262144);
      }
      this.mEnableFastScroller = ((TypedArray)localObject).getBoolean(R.styleable.RecyclerView_fastScrollEnabled, false);
      if (this.mEnableFastScroller) {
        initFastScroller((StateListDrawable)((TypedArray)localObject).getDrawable(R.styleable.RecyclerView_fastScrollVerticalThumbDrawable), ((TypedArray)localObject).getDrawable(R.styleable.RecyclerView_fastScrollVerticalTrackDrawable), (StateListDrawable)((TypedArray)localObject).getDrawable(R.styleable.RecyclerView_fastScrollHorizontalThumbDrawable), ((TypedArray)localObject).getDrawable(R.styleable.RecyclerView_fastScrollHorizontalTrackDrawable));
      }
      ((TypedArray)localObject).recycle();
      createLayoutManager(paramContext, str, paramAttributeSet, paramInt, 0);
      bool1 = bool2;
      if (Build.VERSION.SDK_INT >= 21)
      {
        paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, NESTED_SCROLLING_ATTRS, paramInt, 0);
        bool1 = paramContext.getBoolean(0, true);
        paramContext.recycle();
      }
    }
    for (;;)
    {
      setNestedScrollingEnabled(bool1);
      return;
      localObject = null;
      break;
      label649:
      this.mClipToPadding = true;
      break label338;
      label657:
      bool1 = false;
      break label412;
      label663:
      setDescendantFocusability(262144);
      bool1 = bool2;
    }
  }
  
  private void addAnimatingView(u paramu)
  {
    View localView = paramu.itemView;
    if (localView.getParent() == this) {}
    for (int i = 1;; i = 0)
    {
      this.mRecycler.c(getChildViewHolder(localView));
      if (!paramu.isTmpDetached()) {
        break;
      }
      this.mChildHelper.a(localView, -1, localView.getLayoutParams(), true);
      return;
    }
    if (i == 0)
    {
      this.mChildHelper.a(localView, true);
      return;
    }
    this.mChildHelper.d(localView);
  }
  
  private void animateChange(u paramu1, u paramu2, RecyclerView.e.c paramc1, RecyclerView.e.c paramc2, boolean paramBoolean1, boolean paramBoolean2)
  {
    paramu1.setIsRecyclable(false);
    if (paramBoolean1) {
      addAnimatingView(paramu1);
    }
    if (paramu1 != paramu2)
    {
      if (paramBoolean2) {
        addAnimatingView(paramu2);
      }
      paramu1.mShadowedHolder = paramu2;
      addAnimatingView(paramu1);
      this.mRecycler.c(paramu1);
      paramu2.setIsRecyclable(false);
      paramu2.mShadowingHolder = paramu1;
    }
    if (this.mItemAnimator.animateChange(paramu1, paramu2, paramc1, paramc2)) {
      postAnimationRunner();
    }
  }
  
  private void cancelTouch()
  {
    resetTouch();
    setScrollState(0);
  }
  
  static void clearNestedRecyclerViewIfNotNested(u paramu)
  {
    Object localObject;
    if (paramu.mNestedRecyclerView != null) {
      localObject = (View)paramu.mNestedRecyclerView.get();
    }
    while (localObject != null)
    {
      if (localObject == paramu.itemView) {
        return;
      }
      localObject = ((View)localObject).getParent();
      if ((localObject instanceof View)) {
        localObject = (View)localObject;
      } else {
        localObject = null;
      }
    }
    paramu.mNestedRecyclerView = null;
  }
  
  private void createLayoutManager(Context paramContext, String paramString, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    if (paramString != null)
    {
      paramString = paramString.trim();
      if (!paramString.isEmpty())
      {
        String str = getFullClassName(paramContext, paramString);
        try
        {
          if (isInEditMode()) {}
          Class localClass;
          for (paramString = getClass().getClassLoader();; paramString = paramContext.getClassLoader())
          {
            localClass = paramString.loadClass(str).asSubclass(h.class);
            try
            {
              paramString = localClass.getConstructor(LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE);
              Object[] arrayOfObject = new Object[4];
              arrayOfObject[0] = paramContext;
              arrayOfObject[1] = paramAttributeSet;
              arrayOfObject[2] = Integer.valueOf(paramInt1);
              arrayOfObject[3] = Integer.valueOf(paramInt2);
              paramContext = arrayOfObject;
            }
            catch (NoSuchMethodException paramContext)
            {
              try
              {
                paramString = localClass.getConstructor(new Class[0]);
                paramContext = null;
              }
              catch (NoSuchMethodException paramString)
              {
                paramString.initCause(paramContext);
                throw new IllegalStateException(paramAttributeSet.getPositionDescription() + ": Error creating LayoutManager " + str, paramString);
              }
            }
            paramString.setAccessible(true);
            setLayoutManager((h)paramString.newInstance(paramContext));
            return;
          }
          return;
        }
        catch (ClassNotFoundException paramContext)
        {
          throw new IllegalStateException(paramAttributeSet.getPositionDescription() + ": Unable to find LayoutManager " + str, paramContext);
        }
        catch (InvocationTargetException paramContext)
        {
          throw new IllegalStateException(paramAttributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + str, paramContext);
        }
        catch (InstantiationException paramContext)
        {
          throw new IllegalStateException(paramAttributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + str, paramContext);
        }
        catch (IllegalAccessException paramContext)
        {
          throw new IllegalStateException(paramAttributeSet.getPositionDescription() + ": Cannot access non-public constructor " + str, paramContext);
        }
        catch (ClassCastException paramContext)
        {
          throw new IllegalStateException(paramAttributeSet.getPositionDescription() + ": Class is not a LayoutManager " + str, paramContext);
        }
      }
    }
  }
  
  private boolean didChildRangeChange(int paramInt1, int paramInt2)
  {
    boolean bool = false;
    findMinMaxChildLayoutPositions(this.mMinMaxLayoutPositions);
    if ((this.mMinMaxLayoutPositions[0] != paramInt1) || (this.mMinMaxLayoutPositions[1] != paramInt2)) {
      bool = true;
    }
    return bool;
  }
  
  private void dispatchContentChangedIfNecessary()
  {
    int i = this.mEatenAccessibilityChangeFlags;
    this.mEatenAccessibilityChangeFlags = 0;
    if ((i != 0) && (isAccessibilityEnabled()))
    {
      AccessibilityEvent localAccessibilityEvent = AccessibilityEvent.obtain();
      localAccessibilityEvent.setEventType(2048);
      AccessibilityEventCompat.setContentChangeTypes(localAccessibilityEvent, i);
      sendAccessibilityEventUnchecked(localAccessibilityEvent);
    }
  }
  
  private void dispatchLayoutStep1()
  {
    boolean bool = true;
    this.mState.a(1);
    fillRemainingScrollValues(this.mState);
    this.mState.h = false;
    eatRequestLayout();
    this.mViewInfoStore.a();
    onEnterLayoutOrScroll();
    processAdapterUpdatesAndSetAnimationFlags();
    saveFocusInfo();
    Object localObject = this.mState;
    int j;
    int i;
    if ((this.mState.i) && (this.mItemsChanged))
    {
      ((r)localObject).g = bool;
      this.mItemsChanged = false;
      this.mItemsAddedOrRemoved = false;
      this.mState.f = this.mState.j;
      this.mState.d = this.mAdapter.getItemCount();
      findMinMaxChildLayoutPositions(this.mMinMaxLayoutPositions);
      if (!this.mState.i) {
        break label303;
      }
      j = this.mChildHelper.b();
      i = 0;
      label146:
      if (i >= j) {
        break label303;
      }
      localObject = getChildViewHolderInt(this.mChildHelper.b(i));
      if ((!((u)localObject).shouldIgnore()) && ((!((u)localObject).isInvalid()) || (this.mAdapter.hasStableIds()))) {
        break label203;
      }
    }
    label203:
    RecyclerView.e.c localc;
    for (;;)
    {
      i += 1;
      break label146;
      bool = false;
      break;
      localc = this.mItemAnimator.recordPreLayoutInformation(this.mState, (u)localObject, e.b((u)localObject), ((u)localObject).getUnmodifiedPayloads());
      this.mViewInfoStore.a((u)localObject, localc);
      if ((this.mState.g) && (((u)localObject).isUpdated()) && (!((u)localObject).isRemoved()) && (!((u)localObject).shouldIgnore()) && (!((u)localObject).isInvalid()))
      {
        long l = getChangedHolderKey((u)localObject);
        this.mViewInfoStore.a(l, (u)localObject);
      }
    }
    label303:
    if (this.mState.j)
    {
      saveOldPositions();
      bool = this.mState.e;
      this.mState.e = false;
      this.mLayout.onLayoutChildren(this.mRecycler, this.mState);
      this.mState.e = bool;
      i = 0;
      if (i < this.mChildHelper.b())
      {
        localObject = getChildViewHolderInt(this.mChildHelper.b(i));
        if (((u)localObject).shouldIgnore()) {}
        for (;;)
        {
          i += 1;
          break;
          if (!this.mViewInfoStore.d((u)localObject))
          {
            int k = e.b((u)localObject);
            bool = ((u)localObject).hasAnyOfTheFlags(8192);
            j = k;
            if (!bool) {
              j = k | 0x1000;
            }
            localc = this.mItemAnimator.recordPreLayoutInformation(this.mState, (u)localObject, j, ((u)localObject).getUnmodifiedPayloads());
            if (bool) {
              recordAnimationInfoIfBouncedHiddenView((u)localObject, localc);
            } else {
              this.mViewInfoStore.b((u)localObject, localc);
            }
          }
        }
      }
      clearOldPositions();
    }
    for (;;)
    {
      onExitLayoutOrScroll();
      resumeRequestLayout(false);
      this.mState.c = 2;
      return;
      clearOldPositions();
    }
  }
  
  private void dispatchLayoutStep2()
  {
    eatRequestLayout();
    onEnterLayoutOrScroll();
    this.mState.a(6);
    this.mAdapterHelper.e();
    this.mState.d = this.mAdapter.getItemCount();
    this.mState.b = 0;
    this.mState.f = false;
    this.mLayout.onLayoutChildren(this.mRecycler, this.mState);
    this.mState.e = false;
    this.mPendingSavedState = null;
    r localr = this.mState;
    if ((this.mState.i) && (this.mItemAnimator != null)) {}
    for (boolean bool = true;; bool = false)
    {
      localr.i = bool;
      this.mState.c = 4;
      onExitLayoutOrScroll();
      resumeRequestLayout(false);
      return;
    }
  }
  
  private void dispatchLayoutStep3()
  {
    this.mState.a(4);
    eatRequestLayout();
    onEnterLayoutOrScroll();
    this.mState.c = 1;
    if (this.mState.i)
    {
      int i = this.mChildHelper.b() - 1;
      if (i >= 0)
      {
        u localu1 = getChildViewHolderInt(this.mChildHelper.b(i));
        if (localu1.shouldIgnore()) {}
        for (;;)
        {
          i -= 1;
          break;
          long l = getChangedHolderKey(localu1);
          RecyclerView.e.c localc2 = this.mItemAnimator.recordPostLayoutInformation(this.mState, localu1);
          u localu2 = this.mViewInfoStore.a(l);
          if ((localu2 != null) && (!localu2.shouldIgnore()))
          {
            boolean bool1 = this.mViewInfoStore.a(localu2);
            boolean bool2 = this.mViewInfoStore.a(localu1);
            if ((bool1) && (localu2 == localu1))
            {
              this.mViewInfoStore.c(localu1, localc2);
            }
            else
            {
              RecyclerView.e.c localc1 = this.mViewInfoStore.b(localu2);
              this.mViewInfoStore.c(localu1, localc2);
              localc2 = this.mViewInfoStore.c(localu1);
              if (localc1 == null) {
                handleMissingPreInfoForChangeError(l, localu1, localu2);
              } else {
                animateChange(localu2, localu1, localc1, localc2, bool1, bool2);
              }
            }
          }
          else
          {
            this.mViewInfoStore.c(localu1, localc2);
          }
        }
      }
      this.mViewInfoStore.a(this.mViewInfoProcessCallback);
    }
    this.mLayout.a(this.mRecycler);
    this.mState.a = this.mState.d;
    this.mDataSetHasChangedAfterLayout = false;
    this.mState.i = false;
    this.mState.j = false;
    this.mLayout.u = false;
    if (this.mRecycler.b != null) {
      this.mRecycler.b.clear();
    }
    if (this.mLayout.y)
    {
      this.mLayout.x = 0;
      this.mLayout.y = false;
      this.mRecycler.a();
    }
    this.mLayout.onLayoutCompleted(this.mState);
    onExitLayoutOrScroll();
    resumeRequestLayout(false);
    this.mViewInfoStore.a();
    if (didChildRangeChange(this.mMinMaxLayoutPositions[0], this.mMinMaxLayoutPositions[1])) {
      dispatchOnScrolled(0, 0);
    }
    recoverFocusFromState();
    resetFocusInfo();
  }
  
  private boolean dispatchOnItemTouch(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    int j;
    if (this.mActiveOnItemTouchListener != null)
    {
      if (i == 0) {
        this.mActiveOnItemTouchListener = null;
      }
    }
    else
    {
      if (i == 0) {
        break label108;
      }
      j = this.mOnItemTouchListeners.size();
      i = 0;
    }
    while (i < j)
    {
      k localk = (k)this.mOnItemTouchListeners.get(i);
      if (localk.onInterceptTouchEvent(this, paramMotionEvent))
      {
        this.mActiveOnItemTouchListener = localk;
        return true;
        this.mActiveOnItemTouchListener.onTouchEvent(this, paramMotionEvent);
        if ((i == 3) || (i == 1)) {
          this.mActiveOnItemTouchListener = null;
        }
        return true;
      }
      i += 1;
    }
    label108:
    return false;
  }
  
  private boolean dispatchOnItemTouchIntercept(MotionEvent paramMotionEvent)
  {
    int j = paramMotionEvent.getAction();
    if ((j == 3) || (j == 0)) {
      this.mActiveOnItemTouchListener = null;
    }
    int k = this.mOnItemTouchListeners.size();
    int i = 0;
    while (i < k)
    {
      k localk = (k)this.mOnItemTouchListeners.get(i);
      if ((localk.onInterceptTouchEvent(this, paramMotionEvent)) && (j != 3))
      {
        this.mActiveOnItemTouchListener = localk;
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  private void findMinMaxChildLayoutPositions(int[] paramArrayOfInt)
  {
    int i1 = this.mChildHelper.b();
    if (i1 == 0)
    {
      paramArrayOfInt[0] = -1;
      paramArrayOfInt[1] = -1;
      return;
    }
    int i = Integer.MAX_VALUE;
    int m = Integer.MIN_VALUE;
    int k = 0;
    u localu;
    if (k < i1)
    {
      localu = getChildViewHolderInt(this.mChildHelper.b(k));
      if (!localu.shouldIgnore()) {}
    }
    for (;;)
    {
      k += 1;
      break;
      int n = localu.getLayoutPosition();
      int j = i;
      if (n < i) {
        j = n;
      }
      if (n > m)
      {
        m = n;
        i = j;
        continue;
        paramArrayOfInt[0] = i;
        paramArrayOfInt[1] = m;
      }
      else
      {
        i = j;
      }
    }
  }
  
  static RecyclerView findNestedRecyclerView(View paramView)
  {
    if (!(paramView instanceof ViewGroup)) {
      return null;
    }
    if ((paramView instanceof RecyclerView)) {
      return (RecyclerView)paramView;
    }
    paramView = (ViewGroup)paramView;
    int j = paramView.getChildCount();
    int i = 0;
    while (i < j)
    {
      RecyclerView localRecyclerView = findNestedRecyclerView(paramView.getChildAt(i));
      if (localRecyclerView != null) {
        return localRecyclerView;
      }
      i += 1;
    }
    return null;
  }
  
  private View findNextViewToFocus()
  {
    int i;
    int j;
    label29:
    u localu;
    if (this.mState.k != -1)
    {
      i = this.mState.k;
      int k = this.mState.getItemCount();
      j = i;
      if (j < k)
      {
        localu = findViewHolderForAdapterPosition(j);
        if (localu != null) {
          break label77;
        }
      }
      i = Math.min(k, i) - 1;
    }
    for (;;)
    {
      if (i < 0) {
        break label125;
      }
      localu = findViewHolderForAdapterPosition(i);
      if (localu == null)
      {
        return null;
        i = 0;
        break;
        label77:
        if (localu.itemView.hasFocusable()) {
          return localu.itemView;
        }
        j += 1;
        break label29;
      }
      if (localu.itemView.hasFocusable()) {
        return localu.itemView;
      }
      i -= 1;
    }
    label125:
    return null;
  }
  
  static u getChildViewHolderInt(View paramView)
  {
    if (paramView == null) {
      return null;
    }
    return ((LayoutParams)paramView.getLayoutParams()).c;
  }
  
  static void getDecoratedBoundsWithMarginsInt(View paramView, Rect paramRect)
  {
    LayoutParams localLayoutParams = (LayoutParams)paramView.getLayoutParams();
    Rect localRect = localLayoutParams.d;
    int i = paramView.getLeft();
    int j = localRect.left;
    int k = localLayoutParams.leftMargin;
    int m = paramView.getTop();
    int n = localRect.top;
    int i1 = localLayoutParams.topMargin;
    int i2 = paramView.getRight();
    int i3 = localRect.right;
    int i4 = localLayoutParams.rightMargin;
    int i5 = paramView.getBottom();
    int i6 = localRect.bottom;
    paramRect.set(i - j - k, m - n - i1, i2 + i3 + i4, localLayoutParams.bottomMargin + (i6 + i5));
  }
  
  private int getDeepestFocusedViewWithId(View paramView)
  {
    int i = paramView.getId();
    if ((!paramView.isFocused()) && ((paramView instanceof ViewGroup)) && (paramView.hasFocus()))
    {
      paramView = ((ViewGroup)paramView).getFocusedChild();
      if (paramView.getId() == -1) {
        break label52;
      }
      i = paramView.getId();
    }
    label52:
    for (;;)
    {
      break;
      return i;
    }
  }
  
  private String getFullClassName(Context paramContext, String paramString)
  {
    if (paramString.charAt(0) == '.') {
      paramContext = paramContext.getPackageName() + paramString;
    }
    do
    {
      return paramContext;
      paramContext = paramString;
    } while (paramString.contains("."));
    return RecyclerView.class.getPackage().getName() + '.' + paramString;
  }
  
  private NestedScrollingChildHelper getScrollingChildHelper()
  {
    if (this.mScrollingChildHelper == null) {
      this.mScrollingChildHelper = new NestedScrollingChildHelper(this);
    }
    return this.mScrollingChildHelper;
  }
  
  private void handleMissingPreInfoForChangeError(long paramLong, u paramu1, u paramu2)
  {
    int j = this.mChildHelper.b();
    int i = 0;
    if (i < j)
    {
      u localu = getChildViewHolderInt(this.mChildHelper.b(i));
      if (localu == paramu1) {}
      while (getChangedHolderKey(localu) != paramLong)
      {
        i += 1;
        break;
      }
      if ((this.mAdapter != null) && (this.mAdapter.hasStableIds())) {
        throw new IllegalStateException("Two different ViewHolders have the same stable ID. Stable IDs in your adapter MUST BE unique and SHOULD NOT change.\n ViewHolder 1:" + localu + " \n View Holder 2:" + paramu1 + exceptionLabel());
      }
      throw new IllegalStateException("Two different ViewHolders have the same change ID. This might happen due to inconsistent Adapter update events or if the LayoutManager lays out the same View multiple times.\n ViewHolder 1:" + localu + " \n View Holder 2:" + paramu1 + exceptionLabel());
    }
    Log.e("RecyclerView", "Problem while matching changed view holders with the newones. The pre-layout information for the change holder " + paramu2 + " cannot be found but it is necessary for " + paramu1 + exceptionLabel());
  }
  
  private boolean hasUpdatedView()
  {
    boolean bool2 = false;
    int j = this.mChildHelper.b();
    int i = 0;
    boolean bool1 = bool2;
    if (i < j)
    {
      u localu = getChildViewHolderInt(this.mChildHelper.b(i));
      if ((localu == null) || (localu.shouldIgnore())) {}
      while (!localu.isUpdated())
      {
        i += 1;
        break;
      }
      bool1 = true;
    }
    return bool1;
  }
  
  private void initChildrenHelper()
  {
    this.mChildHelper = new s(new s.b()
    {
      public void addView(View paramAnonymousView, int paramAnonymousInt)
      {
        RecyclerView.this.addView(paramAnonymousView, paramAnonymousInt);
        RecyclerView.this.dispatchChildAttached(paramAnonymousView);
      }
      
      public void attachViewToParent(View paramAnonymousView, int paramAnonymousInt, ViewGroup.LayoutParams paramAnonymousLayoutParams)
      {
        RecyclerView.u localu = RecyclerView.getChildViewHolderInt(paramAnonymousView);
        if (localu != null)
        {
          if ((!localu.isTmpDetached()) && (!localu.shouldIgnore())) {
            throw new IllegalArgumentException("Called attach on a child which is not detached: " + localu + RecyclerView.this.exceptionLabel());
          }
          localu.clearTmpDetachFlag();
        }
        RecyclerView.this.attachViewToParent(paramAnonymousView, paramAnonymousInt, paramAnonymousLayoutParams);
      }
      
      public void detachViewFromParent(int paramAnonymousInt)
      {
        Object localObject = getChildAt(paramAnonymousInt);
        if (localObject != null)
        {
          localObject = RecyclerView.getChildViewHolderInt((View)localObject);
          if (localObject != null)
          {
            if ((((RecyclerView.u)localObject).isTmpDetached()) && (!((RecyclerView.u)localObject).shouldIgnore())) {
              throw new IllegalArgumentException("called detach on an already detached child " + localObject + RecyclerView.this.exceptionLabel());
            }
            ((RecyclerView.u)localObject).addFlags(256);
          }
        }
        RecyclerView.this.detachViewFromParent(paramAnonymousInt);
      }
      
      public View getChildAt(int paramAnonymousInt)
      {
        return RecyclerView.this.getChildAt(paramAnonymousInt);
      }
      
      public int getChildCount()
      {
        return RecyclerView.this.getChildCount();
      }
      
      public RecyclerView.u getChildViewHolder(View paramAnonymousView)
      {
        return RecyclerView.getChildViewHolderInt(paramAnonymousView);
      }
      
      public int indexOfChild(View paramAnonymousView)
      {
        return RecyclerView.this.indexOfChild(paramAnonymousView);
      }
      
      public void onEnteredHiddenState(View paramAnonymousView)
      {
        paramAnonymousView = RecyclerView.getChildViewHolderInt(paramAnonymousView);
        if (paramAnonymousView != null) {
          RecyclerView.u.access$200(paramAnonymousView, RecyclerView.this);
        }
      }
      
      public void onLeftHiddenState(View paramAnonymousView)
      {
        paramAnonymousView = RecyclerView.getChildViewHolderInt(paramAnonymousView);
        if (paramAnonymousView != null) {
          RecyclerView.u.access$300(paramAnonymousView, RecyclerView.this);
        }
      }
      
      public void removeAllViews()
      {
        int j = getChildCount();
        int i = 0;
        while (i < j)
        {
          View localView = getChildAt(i);
          RecyclerView.this.dispatchChildDetached(localView);
          localView.clearAnimation();
          i += 1;
        }
        RecyclerView.this.removeAllViews();
      }
      
      public void removeViewAt(int paramAnonymousInt)
      {
        View localView = RecyclerView.this.getChildAt(paramAnonymousInt);
        if (localView != null)
        {
          RecyclerView.this.dispatchChildDetached(localView);
          localView.clearAnimation();
        }
        RecyclerView.this.removeViewAt(paramAnonymousInt);
      }
    });
  }
  
  private boolean isPreferredNextFocus(View paramView1, View paramView2, int paramInt)
  {
    int j = 0;
    if ((paramView2 == null) || (paramView2 == this)) {
      return false;
    }
    if (paramView1 == null) {
      return true;
    }
    if ((paramInt == 2) || (paramInt == 1))
    {
      if (this.mLayout.getLayoutDirection() == 1)
      {
        i = 1;
        if (paramInt == 2) {
          j = 1;
        }
        if ((j ^ i) == 0) {
          break label83;
        }
      }
      label83:
      for (int i = 66;; i = 17)
      {
        if (!isPreferredNextFocusAbsolute(paramView1, paramView2, i)) {
          break label90;
        }
        return true;
        i = 0;
        break;
      }
      label90:
      if (paramInt == 2) {
        return isPreferredNextFocusAbsolute(paramView1, paramView2, 130);
      }
      return isPreferredNextFocusAbsolute(paramView1, paramView2, 33);
    }
    return isPreferredNextFocusAbsolute(paramView1, paramView2, paramInt);
  }
  
  private boolean isPreferredNextFocusAbsolute(View paramView1, View paramView2, int paramInt)
  {
    this.mTempRect.set(0, 0, paramView1.getWidth(), paramView1.getHeight());
    this.mTempRect2.set(0, 0, paramView2.getWidth(), paramView2.getHeight());
    offsetDescendantRectToMyCoords(paramView1, this.mTempRect);
    offsetDescendantRectToMyCoords(paramView2, this.mTempRect2);
    switch (paramInt)
    {
    default: 
      throw new IllegalArgumentException("direction must be absolute. received:" + paramInt + exceptionLabel());
    case 17: 
      if (((this.mTempRect.right <= this.mTempRect2.right) && (this.mTempRect.left < this.mTempRect2.right)) || (this.mTempRect.left <= this.mTempRect2.left)) {
        break;
      }
    }
    do
    {
      do
      {
        do
        {
          return true;
          return false;
        } while (((this.mTempRect.left < this.mTempRect2.left) || (this.mTempRect.right <= this.mTempRect2.left)) && (this.mTempRect.right < this.mTempRect2.right));
        return false;
      } while (((this.mTempRect.bottom > this.mTempRect2.bottom) || (this.mTempRect.top >= this.mTempRect2.bottom)) && (this.mTempRect.top > this.mTempRect2.top));
      return false;
    } while (((this.mTempRect.top < this.mTempRect2.top) || (this.mTempRect.bottom <= this.mTempRect2.top)) && (this.mTempRect.bottom < this.mTempRect2.bottom));
    return false;
  }
  
  private void onPointerUp(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getActionIndex();
    if (paramMotionEvent.getPointerId(i) == this.mScrollPointerId) {
      if (i != 0) {
        break label75;
      }
    }
    label75:
    for (i = 1;; i = 0)
    {
      this.mScrollPointerId = paramMotionEvent.getPointerId(i);
      int j = (int)(paramMotionEvent.getX(i) + 0.5F);
      this.mLastTouchX = j;
      this.mInitialTouchX = j;
      i = (int)(paramMotionEvent.getY(i) + 0.5F);
      this.mLastTouchY = i;
      this.mInitialTouchY = i;
      return;
    }
  }
  
  private boolean predictiveItemAnimationsEnabled()
  {
    return (this.mItemAnimator != null) && (this.mLayout.supportsPredictiveItemAnimations());
  }
  
  private void processAdapterUpdatesAndSetAnimationFlags()
  {
    boolean bool2 = true;
    if (this.mDataSetHasChangedAfterLayout)
    {
      this.mAdapterHelper.a();
      this.mLayout.onItemsChanged(this);
    }
    int i;
    label54:
    r localr;
    if (predictiveItemAnimationsEnabled())
    {
      this.mAdapterHelper.b();
      if ((!this.mItemsAddedOrRemoved) && (!this.mItemsChanged)) {
        break label173;
      }
      i = 1;
      localr = this.mState;
      if ((!this.mFirstLayoutComplete) || (this.mItemAnimator == null) || ((!this.mDataSetHasChangedAfterLayout) && (i == 0) && (!this.mLayout.u)) || ((this.mDataSetHasChangedAfterLayout) && (!this.mAdapter.hasStableIds()))) {
        break label178;
      }
      bool1 = true;
      label114:
      localr.i = bool1;
      localr = this.mState;
      if ((!this.mState.i) || (i == 0) || (this.mDataSetHasChangedAfterLayout) || (!predictiveItemAnimationsEnabled())) {
        break label183;
      }
    }
    label173:
    label178:
    label183:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localr.j = bool1;
      return;
      this.mAdapterHelper.e();
      break;
      i = 0;
      break label54;
      bool1 = false;
      break label114;
    }
  }
  
  private void pullGlows(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    int j = 1;
    int i = 0;
    if (paramFloat2 < 0.0F)
    {
      ensureLeftGlow();
      EdgeEffectCompat.onPull(this.mLeftGlow, -paramFloat2 / getWidth(), 1.0F - paramFloat3 / getHeight());
      i = 1;
      if (paramFloat4 >= 0.0F) {
        break label141;
      }
      ensureTopGlow();
      EdgeEffectCompat.onPull(this.mTopGlow, -paramFloat4 / getHeight(), paramFloat1 / getWidth());
      i = j;
    }
    for (;;)
    {
      if ((i != 0) || (paramFloat2 != 0.0F) || (paramFloat4 != 0.0F)) {
        ViewCompat.postInvalidateOnAnimation(this);
      }
      return;
      if (paramFloat2 <= 0.0F) {
        break;
      }
      ensureRightGlow();
      EdgeEffectCompat.onPull(this.mRightGlow, paramFloat2 / getWidth(), paramFloat3 / getHeight());
      i = 1;
      break;
      label141:
      if (paramFloat4 > 0.0F)
      {
        ensureBottomGlow();
        EdgeEffectCompat.onPull(this.mBottomGlow, paramFloat4 / getHeight(), 1.0F - paramFloat1 / getWidth());
        i = j;
      }
    }
  }
  
  private void recoverFocusFromState()
  {
    View localView = null;
    if ((!this.mPreserveFocusAfterLayout) || (this.mAdapter == null) || (!hasFocus()) || (getDescendantFocusability() == 393216) || ((getDescendantFocusability() == 131072) && (isFocused()))) {}
    do
    {
      return;
      if (isFocused()) {
        break;
      }
      localObject = getFocusedChild();
      if ((IGNORE_DETACHED_FOCUSED_CHILD) && ((((View)localObject).getParent() == null) || (!((View)localObject).hasFocus())))
      {
        if (this.mChildHelper.b() != 0) {
          break;
        }
        requestFocus();
        return;
      }
    } while (!this.mChildHelper.c((View)localObject));
    if ((this.mState.l != -1L) && (this.mAdapter.hasStableIds())) {}
    for (Object localObject = findViewHolderForItemId(this.mState.l);; localObject = null)
    {
      if ((localObject == null) || (this.mChildHelper.c(((u)localObject).itemView)) || (!((u)localObject).itemView.hasFocusable()))
      {
        localObject = localView;
        if (this.mChildHelper.b() > 0) {
          localObject = findNextViewToFocus();
        }
        label191:
        if (localObject == null) {
          break label247;
        }
        if (this.mState.m == -1L) {
          break label249;
        }
        localView = ((View)localObject).findViewById(this.mState.m);
        if ((localView == null) || (!localView.isFocusable())) {
          break label249;
        }
        localObject = localView;
      }
      label247:
      label249:
      for (;;)
      {
        ((View)localObject).requestFocus();
        return;
        localObject = ((u)localObject).itemView;
        break label191;
        break;
      }
    }
  }
  
  private void releaseGlows()
  {
    boolean bool2 = false;
    if (this.mLeftGlow != null)
    {
      this.mLeftGlow.onRelease();
      bool2 = this.mLeftGlow.isFinished();
    }
    boolean bool1 = bool2;
    if (this.mTopGlow != null)
    {
      this.mTopGlow.onRelease();
      bool1 = bool2 | this.mTopGlow.isFinished();
    }
    bool2 = bool1;
    if (this.mRightGlow != null)
    {
      this.mRightGlow.onRelease();
      bool2 = bool1 | this.mRightGlow.isFinished();
    }
    bool1 = bool2;
    if (this.mBottomGlow != null)
    {
      this.mBottomGlow.onRelease();
      bool1 = bool2 | this.mBottomGlow.isFinished();
    }
    if (bool1) {
      ViewCompat.postInvalidateOnAnimation(this);
    }
  }
  
  private void requestChildOnScreen(View paramView1, View paramView2)
  {
    boolean bool2 = true;
    Object localObject;
    Rect localRect;
    boolean bool1;
    if (paramView2 != null)
    {
      localObject = paramView2;
      this.mTempRect.set(0, 0, ((View)localObject).getWidth(), ((View)localObject).getHeight());
      localObject = ((View)localObject).getLayoutParams();
      if ((localObject instanceof LayoutParams))
      {
        localObject = (LayoutParams)localObject;
        if (!((LayoutParams)localObject).e)
        {
          localObject = ((LayoutParams)localObject).d;
          localRect = this.mTempRect;
          localRect.left -= ((Rect)localObject).left;
          localRect = this.mTempRect;
          localRect.right += ((Rect)localObject).right;
          localRect = this.mTempRect;
          localRect.top -= ((Rect)localObject).top;
          localRect = this.mTempRect;
          int i = localRect.bottom;
          localRect.bottom = (((Rect)localObject).bottom + i);
        }
      }
      if (paramView2 != null)
      {
        offsetDescendantRectToMyCoords(paramView2, this.mTempRect);
        offsetRectIntoDescendantCoords(paramView1, this.mTempRect);
      }
      localObject = this.mLayout;
      localRect = this.mTempRect;
      if (this.mFirstLayoutComplete) {
        break label225;
      }
      bool1 = true;
      label200:
      if (paramView2 != null) {
        break label231;
      }
    }
    for (;;)
    {
      ((h)localObject).requestChildRectangleOnScreen(this, paramView1, localRect, bool1, bool2);
      return;
      localObject = paramView1;
      break;
      label225:
      bool1 = false;
      break label200;
      label231:
      bool2 = false;
    }
  }
  
  private void resetFocusInfo()
  {
    this.mState.l = -1L;
    this.mState.k = -1;
    this.mState.m = -1;
  }
  
  private void resetTouch()
  {
    if (this.mVelocityTracker != null) {
      this.mVelocityTracker.clear();
    }
    stopNestedScroll(0);
    releaseGlows();
  }
  
  private void saveFocusInfo()
  {
    if ((this.mPreserveFocusAfterLayout) && (hasFocus()) && (this.mAdapter != null)) {}
    for (Object localObject = getFocusedChild();; localObject = null)
    {
      if (localObject == null) {}
      for (localObject = null; localObject == null; localObject = findContainingViewHolder((View)localObject))
      {
        resetFocusInfo();
        return;
      }
      r localr = this.mState;
      long l;
      int i;
      if (this.mAdapter.hasStableIds())
      {
        l = ((u)localObject).getItemId();
        localr.l = l;
        localr = this.mState;
        if (!this.mDataSetHasChangedAfterLayout) {
          break label129;
        }
        i = -1;
      }
      for (;;)
      {
        localr.k = i;
        this.mState.m = getDeepestFocusedViewWithId(((u)localObject).itemView);
        return;
        l = -1L;
        break;
        label129:
        if (((u)localObject).isRemoved()) {
          i = ((u)localObject).mOldPosition;
        } else {
          i = ((u)localObject).getAdapterPosition();
        }
      }
    }
  }
  
  private void setAdapterInternal(a parama, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.mAdapter != null)
    {
      this.mAdapter.unregisterAdapterDataObserver(this.mObserver);
      this.mAdapter.onDetachedFromRecyclerView(this);
    }
    if ((!paramBoolean1) || (paramBoolean2)) {
      removeAndRecycleViews();
    }
    this.mAdapterHelper.a();
    a locala = this.mAdapter;
    this.mAdapter = parama;
    if (parama != null)
    {
      parama.registerAdapterDataObserver(this.mObserver);
      parama.onAttachedToRecyclerView(this);
    }
    if (this.mLayout != null) {
      this.mLayout.onAdapterChanged(locala, this.mAdapter);
    }
    this.mRecycler.a(locala, this.mAdapter, paramBoolean1);
    this.mState.e = true;
    setDataSetChangedAfterLayout();
  }
  
  private void stopScrollersInternal()
  {
    this.mViewFlinger.stop();
    if (this.mLayout != null) {
      this.mLayout.f();
    }
  }
  
  void absorbGlows(int paramInt1, int paramInt2)
  {
    if (paramInt1 < 0)
    {
      ensureLeftGlow();
      this.mLeftGlow.onAbsorb(-paramInt1);
      if (paramInt2 >= 0) {
        break label66;
      }
      ensureTopGlow();
      this.mTopGlow.onAbsorb(-paramInt2);
    }
    for (;;)
    {
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        ViewCompat.postInvalidateOnAnimation(this);
      }
      return;
      if (paramInt1 <= 0) {
        break;
      }
      ensureRightGlow();
      this.mRightGlow.onAbsorb(paramInt1);
      break;
      label66:
      if (paramInt2 > 0)
      {
        ensureBottomGlow();
        this.mBottomGlow.onAbsorb(paramInt2);
      }
    }
  }
  
  public void addFocusables(ArrayList<View> paramArrayList, int paramInt1, int paramInt2)
  {
    if ((this.mLayout == null) || (!this.mLayout.onAddFocusables(this, paramArrayList, paramInt1, paramInt2))) {
      super.addFocusables(paramArrayList, paramInt1, paramInt2);
    }
  }
  
  public void addItemDecoration(g paramg)
  {
    addItemDecoration(paramg, -1);
  }
  
  public void addItemDecoration(g paramg, int paramInt)
  {
    if (this.mLayout != null) {
      this.mLayout.assertNotInLayoutOrScroll("Cannot add item decoration during a scroll  or layout");
    }
    if (this.mItemDecorations.isEmpty()) {
      setWillNotDraw(false);
    }
    if (paramInt < 0) {
      this.mItemDecorations.add(paramg);
    }
    for (;;)
    {
      markItemDecorInsetsDirty();
      requestLayout();
      return;
      this.mItemDecorations.add(paramInt, paramg);
    }
  }
  
  public void addOnChildAttachStateChangeListener(i parami)
  {
    if (this.mOnChildAttachStateListeners == null) {
      this.mOnChildAttachStateListeners = new ArrayList();
    }
    this.mOnChildAttachStateListeners.add(parami);
  }
  
  public void addOnItemTouchListener(k paramk)
  {
    this.mOnItemTouchListeners.add(paramk);
  }
  
  public void addOnScrollListener(l paraml)
  {
    if (this.mScrollListeners == null) {
      this.mScrollListeners = new ArrayList();
    }
    this.mScrollListeners.add(paraml);
  }
  
  void animateAppearance(u paramu, RecyclerView.e.c paramc1, RecyclerView.e.c paramc2)
  {
    paramu.setIsRecyclable(false);
    if (this.mItemAnimator.animateAppearance(paramu, paramc1, paramc2)) {
      postAnimationRunner();
    }
  }
  
  void animateDisappearance(u paramu, RecyclerView.e.c paramc1, RecyclerView.e.c paramc2)
  {
    addAnimatingView(paramu);
    paramu.setIsRecyclable(false);
    if (this.mItemAnimator.animateDisappearance(paramu, paramc1, paramc2)) {
      postAnimationRunner();
    }
  }
  
  void assertInLayoutOrScroll(String paramString)
  {
    if (!isComputingLayout())
    {
      if (paramString == null) {
        throw new IllegalStateException("Cannot call this method unless RecyclerView is computing a layout or scrolling" + exceptionLabel());
      }
      throw new IllegalStateException(paramString + exceptionLabel());
    }
  }
  
  void assertNotInLayoutOrScroll(String paramString)
  {
    if (isComputingLayout())
    {
      if (paramString == null) {
        throw new IllegalStateException("Cannot call this method while RecyclerView is computing a layout or scrolling" + exceptionLabel());
      }
      throw new IllegalStateException(paramString);
    }
    if (this.mDispatchScrollCounter > 0) {
      Log.w("RecyclerView", "Cannot call this method in a scroll callback. Scroll callbacks mightbe run during a measure & layout pass where you cannot change theRecyclerView data. Any method call that might change the structureof the RecyclerView or the adapter contents should be postponed tothe next frame.", new IllegalStateException("" + exceptionLabel()));
    }
  }
  
  boolean canReuseUpdatedViewHolder(u paramu)
  {
    return (this.mItemAnimator == null) || (this.mItemAnimator.canReuseUpdatedViewHolder(paramu, paramu.getUnmodifiedPayloads()));
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return ((paramLayoutParams instanceof LayoutParams)) && (this.mLayout.checkLayoutParams((LayoutParams)paramLayoutParams));
  }
  
  void clearOldPositions()
  {
    int j = this.mChildHelper.c();
    int i = 0;
    while (i < j)
    {
      u localu = getChildViewHolderInt(this.mChildHelper.d(i));
      if (!localu.shouldIgnore()) {
        localu.clearOldPosition();
      }
      i += 1;
    }
    this.mRecycler.g();
  }
  
  public void clearOnChildAttachStateChangeListeners()
  {
    if (this.mOnChildAttachStateListeners != null) {
      this.mOnChildAttachStateListeners.clear();
    }
  }
  
  public void clearOnScrollListeners()
  {
    if (this.mScrollListeners != null) {
      this.mScrollListeners.clear();
    }
  }
  
  public int computeHorizontalScrollExtent()
  {
    if (this.mLayout == null) {}
    while (!this.mLayout.canScrollHorizontally()) {
      return 0;
    }
    return this.mLayout.computeHorizontalScrollExtent(this.mState);
  }
  
  public int computeHorizontalScrollOffset()
  {
    if (this.mLayout == null) {}
    while (!this.mLayout.canScrollHorizontally()) {
      return 0;
    }
    return this.mLayout.computeHorizontalScrollOffset(this.mState);
  }
  
  public int computeHorizontalScrollRange()
  {
    if (this.mLayout == null) {}
    while (!this.mLayout.canScrollHorizontally()) {
      return 0;
    }
    return this.mLayout.computeHorizontalScrollRange(this.mState);
  }
  
  public int computeVerticalScrollExtent()
  {
    if (this.mLayout == null) {}
    while (!this.mLayout.canScrollVertically()) {
      return 0;
    }
    return this.mLayout.computeVerticalScrollExtent(this.mState);
  }
  
  public int computeVerticalScrollOffset()
  {
    if (this.mLayout == null) {}
    while (!this.mLayout.canScrollVertically()) {
      return 0;
    }
    return this.mLayout.computeVerticalScrollOffset(this.mState);
  }
  
  public int computeVerticalScrollRange()
  {
    if (this.mLayout == null) {}
    while (!this.mLayout.canScrollVertically()) {
      return 0;
    }
    return this.mLayout.computeVerticalScrollRange(this.mState);
  }
  
  void considerReleasingGlowsOnScroll(int paramInt1, int paramInt2)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.mLeftGlow != null)
    {
      bool1 = bool2;
      if (!this.mLeftGlow.isFinished())
      {
        bool1 = bool2;
        if (paramInt1 > 0)
        {
          this.mLeftGlow.onRelease();
          bool1 = this.mLeftGlow.isFinished();
        }
      }
    }
    bool2 = bool1;
    if (this.mRightGlow != null)
    {
      bool2 = bool1;
      if (!this.mRightGlow.isFinished())
      {
        bool2 = bool1;
        if (paramInt1 < 0)
        {
          this.mRightGlow.onRelease();
          bool2 = bool1 | this.mRightGlow.isFinished();
        }
      }
    }
    bool1 = bool2;
    if (this.mTopGlow != null)
    {
      bool1 = bool2;
      if (!this.mTopGlow.isFinished())
      {
        bool1 = bool2;
        if (paramInt2 > 0)
        {
          this.mTopGlow.onRelease();
          bool1 = bool2 | this.mTopGlow.isFinished();
        }
      }
    }
    bool2 = bool1;
    if (this.mBottomGlow != null)
    {
      bool2 = bool1;
      if (!this.mBottomGlow.isFinished())
      {
        bool2 = bool1;
        if (paramInt2 < 0)
        {
          this.mBottomGlow.onRelease();
          bool2 = bool1 | this.mBottomGlow.isFinished();
        }
      }
    }
    if (bool2) {
      ViewCompat.postInvalidateOnAnimation(this);
    }
  }
  
  void consumePendingUpdateOperations()
  {
    if ((!this.mFirstLayoutComplete) || (this.mDataSetHasChangedAfterLayout))
    {
      TraceCompat.beginSection("RV FullInvalidate");
      dispatchLayout();
      TraceCompat.endSection();
    }
    label111:
    do
    {
      do
      {
        return;
      } while (!this.mAdapterHelper.d());
      if ((this.mAdapterHelper.a(4)) && (!this.mAdapterHelper.a(11)))
      {
        TraceCompat.beginSection("RV PartialInvalidate");
        eatRequestLayout();
        onEnterLayoutOrScroll();
        this.mAdapterHelper.b();
        if (!this.mLayoutRequestEaten)
        {
          if (!hasUpdatedView()) {
            break label111;
          }
          dispatchLayout();
        }
        for (;;)
        {
          resumeRequestLayout(true);
          onExitLayoutOrScroll();
          TraceCompat.endSection();
          return;
          this.mAdapterHelper.c();
        }
      }
    } while (!this.mAdapterHelper.d());
    TraceCompat.beginSection("RV FullInvalidate");
    dispatchLayout();
    TraceCompat.endSection();
  }
  
  void defaultOnMeasure(int paramInt1, int paramInt2)
  {
    setMeasuredDimension(h.chooseSize(paramInt1, getPaddingLeft() + getPaddingRight(), ViewCompat.getMinimumWidth(this)), h.chooseSize(paramInt2, getPaddingTop() + getPaddingBottom(), ViewCompat.getMinimumHeight(this)));
  }
  
  void dispatchChildAttached(View paramView)
  {
    u localu = getChildViewHolderInt(paramView);
    onChildAttachedToWindow(paramView);
    if ((this.mAdapter != null) && (localu != null)) {
      this.mAdapter.onViewAttachedToWindow(localu);
    }
    if (this.mOnChildAttachStateListeners != null)
    {
      int i = this.mOnChildAttachStateListeners.size() - 1;
      while (i >= 0)
      {
        ((i)this.mOnChildAttachStateListeners.get(i)).onChildViewAttachedToWindow(paramView);
        i -= 1;
      }
    }
  }
  
  void dispatchChildDetached(View paramView)
  {
    u localu = getChildViewHolderInt(paramView);
    onChildDetachedFromWindow(paramView);
    if ((this.mAdapter != null) && (localu != null)) {
      this.mAdapter.onViewDetachedFromWindow(localu);
    }
    if (this.mOnChildAttachStateListeners != null)
    {
      int i = this.mOnChildAttachStateListeners.size() - 1;
      while (i >= 0)
      {
        ((i)this.mOnChildAttachStateListeners.get(i)).onChildViewDetachedFromWindow(paramView);
        i -= 1;
      }
    }
  }
  
  void dispatchLayout()
  {
    if (this.mAdapter == null)
    {
      Log.e("RecyclerView", "No adapter attached; skipping layout");
      return;
    }
    if (this.mLayout == null)
    {
      Log.e("RecyclerView", "No layout manager attached; skipping layout");
      return;
    }
    this.mState.h = false;
    if (this.mState.c == 1)
    {
      dispatchLayoutStep1();
      this.mLayout.c(this);
      dispatchLayoutStep2();
    }
    for (;;)
    {
      dispatchLayoutStep3();
      return;
      if ((this.mAdapterHelper.f()) || (this.mLayout.getWidth() != getWidth()) || (this.mLayout.getHeight() != getHeight()))
      {
        this.mLayout.c(this);
        dispatchLayoutStep2();
      }
      else
      {
        this.mLayout.c(this);
      }
    }
  }
  
  public boolean dispatchNestedFling(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    return getScrollingChildHelper().dispatchNestedFling(paramFloat1, paramFloat2, paramBoolean);
  }
  
  public boolean dispatchNestedPreFling(float paramFloat1, float paramFloat2)
  {
    return getScrollingChildHelper().dispatchNestedPreFling(paramFloat1, paramFloat2);
  }
  
  public boolean dispatchNestedPreScroll(int paramInt1, int paramInt2, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    return getScrollingChildHelper().dispatchNestedPreScroll(paramInt1, paramInt2, paramArrayOfInt1, paramArrayOfInt2);
  }
  
  public boolean dispatchNestedPreScroll(int paramInt1, int paramInt2, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt3)
  {
    return getScrollingChildHelper().dispatchNestedPreScroll(paramInt1, paramInt2, paramArrayOfInt1, paramArrayOfInt2, paramInt3);
  }
  
  public boolean dispatchNestedScroll(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt)
  {
    return getScrollingChildHelper().dispatchNestedScroll(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfInt);
  }
  
  public boolean dispatchNestedScroll(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt, int paramInt5)
  {
    return getScrollingChildHelper().dispatchNestedScroll(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfInt, paramInt5);
  }
  
  void dispatchOnScrollStateChanged(int paramInt)
  {
    if (this.mLayout != null) {
      this.mLayout.onScrollStateChanged(paramInt);
    }
    onScrollStateChanged(paramInt);
    if (this.mScrollListener != null) {
      this.mScrollListener.onScrollStateChanged(this, paramInt);
    }
    if (this.mScrollListeners != null)
    {
      int i = this.mScrollListeners.size() - 1;
      while (i >= 0)
      {
        ((l)this.mScrollListeners.get(i)).onScrollStateChanged(this, paramInt);
        i -= 1;
      }
    }
  }
  
  void dispatchOnScrolled(int paramInt1, int paramInt2)
  {
    this.mDispatchScrollCounter += 1;
    int i = getScrollX();
    int j = getScrollY();
    onScrollChanged(i, j, i, j);
    onScrolled(paramInt1, paramInt2);
    if (this.mScrollListener != null) {
      this.mScrollListener.onScrolled(this, paramInt1, paramInt2);
    }
    if (this.mScrollListeners != null)
    {
      i = this.mScrollListeners.size() - 1;
      while (i >= 0)
      {
        ((l)this.mScrollListeners.get(i)).onScrolled(this, paramInt1, paramInt2);
        i -= 1;
      }
    }
    this.mDispatchScrollCounter -= 1;
  }
  
  void dispatchPendingImportantForAccessibilityChanges()
  {
    int i = this.mPendingAccessibilityImportanceChange.size() - 1;
    if (i >= 0)
    {
      u localu = (u)this.mPendingAccessibilityImportanceChange.get(i);
      if ((localu.itemView.getParent() != this) || (localu.shouldIgnore())) {}
      for (;;)
      {
        i -= 1;
        break;
        int j = localu.mPendingAccessibilityState;
        if (j != -1)
        {
          ViewCompat.setImportantForAccessibility(localu.itemView, j);
          localu.mPendingAccessibilityState = -1;
        }
      }
    }
    this.mPendingAccessibilityImportanceChange.clear();
  }
  
  protected void dispatchRestoreInstanceState(SparseArray<Parcelable> paramSparseArray)
  {
    dispatchThawSelfOnly(paramSparseArray);
  }
  
  protected void dispatchSaveInstanceState(SparseArray<Parcelable> paramSparseArray)
  {
    dispatchFreezeSelfOnly(paramSparseArray);
  }
  
  public void draw(Canvas paramCanvas)
  {
    int k = 1;
    int m = 0;
    super.draw(paramCanvas);
    int j = this.mItemDecorations.size();
    int i = 0;
    while (i < j)
    {
      ((g)this.mItemDecorations.get(i)).onDrawOver(paramCanvas, this, this.mState);
      i += 1;
    }
    int n;
    if ((this.mLeftGlow != null) && (!this.mLeftGlow.isFinished()))
    {
      n = paramCanvas.save();
      if (this.mClipToPadding)
      {
        i = getPaddingBottom();
        paramCanvas.rotate(270.0F);
        paramCanvas.translate(i + -getHeight(), 0.0F);
        if ((this.mLeftGlow == null) || (!this.mLeftGlow.draw(paramCanvas))) {
          break label456;
        }
        j = 1;
        label128:
        paramCanvas.restoreToCount(n);
      }
    }
    for (;;)
    {
      i = j;
      if (this.mTopGlow != null)
      {
        i = j;
        if (!this.mTopGlow.isFinished())
        {
          n = paramCanvas.save();
          if (this.mClipToPadding) {
            paramCanvas.translate(getPaddingLeft(), getPaddingTop());
          }
          if ((this.mTopGlow == null) || (!this.mTopGlow.draw(paramCanvas))) {
            break label461;
          }
          i = 1;
          label202:
          i = j | i;
          paramCanvas.restoreToCount(n);
        }
      }
      j = i;
      if (this.mRightGlow != null)
      {
        j = i;
        if (!this.mRightGlow.isFinished())
        {
          n = paramCanvas.save();
          int i1 = getWidth();
          if (!this.mClipToPadding) {
            break label466;
          }
          j = getPaddingTop();
          label257:
          paramCanvas.rotate(90.0F);
          paramCanvas.translate(-j, -i1);
          if ((this.mRightGlow == null) || (!this.mRightGlow.draw(paramCanvas))) {
            break label471;
          }
          j = 1;
          label295:
          j = i | j;
          paramCanvas.restoreToCount(n);
        }
      }
      i = j;
      if (this.mBottomGlow != null)
      {
        i = j;
        if (!this.mBottomGlow.isFinished())
        {
          n = paramCanvas.save();
          paramCanvas.rotate(180.0F);
          if (!this.mClipToPadding) {
            break label476;
          }
          paramCanvas.translate(-getWidth() + getPaddingRight(), -getHeight() + getPaddingBottom());
          label372:
          i = m;
          if (this.mBottomGlow != null)
          {
            i = m;
            if (this.mBottomGlow.draw(paramCanvas)) {
              i = 1;
            }
          }
          i = j | i;
          paramCanvas.restoreToCount(n);
        }
      }
      if ((i == 0) && (this.mItemAnimator != null) && (this.mItemDecorations.size() > 0) && (this.mItemAnimator.isRunning())) {
        i = k;
      }
      for (;;)
      {
        if (i != 0) {
          ViewCompat.postInvalidateOnAnimation(this);
        }
        return;
        i = 0;
        break;
        label456:
        j = 0;
        break label128;
        label461:
        i = 0;
        break label202;
        label466:
        j = 0;
        break label257;
        label471:
        j = 0;
        break label295;
        label476:
        paramCanvas.translate(-getWidth(), -getHeight());
        break label372;
      }
      j = 0;
    }
  }
  
  public boolean drawChild(Canvas paramCanvas, View paramView, long paramLong)
  {
    return super.drawChild(paramCanvas, paramView, paramLong);
  }
  
  void eatRequestLayout()
  {
    this.mEatRequestLayout += 1;
    if ((this.mEatRequestLayout == 1) && (!this.mLayoutFrozen)) {
      this.mLayoutRequestEaten = false;
    }
  }
  
  void ensureBottomGlow()
  {
    if (this.mBottomGlow != null) {
      return;
    }
    this.mBottomGlow = new EdgeEffect(getContext());
    if (this.mClipToPadding)
    {
      this.mBottomGlow.setSize(getMeasuredWidth() - getPaddingLeft() - getPaddingRight(), getMeasuredHeight() - getPaddingTop() - getPaddingBottom());
      return;
    }
    this.mBottomGlow.setSize(getMeasuredWidth(), getMeasuredHeight());
  }
  
  void ensureLeftGlow()
  {
    if (this.mLeftGlow != null) {
      return;
    }
    this.mLeftGlow = new EdgeEffect(getContext());
    if (this.mClipToPadding)
    {
      this.mLeftGlow.setSize(getMeasuredHeight() - getPaddingTop() - getPaddingBottom(), getMeasuredWidth() - getPaddingLeft() - getPaddingRight());
      return;
    }
    this.mLeftGlow.setSize(getMeasuredHeight(), getMeasuredWidth());
  }
  
  void ensureRightGlow()
  {
    if (this.mRightGlow != null) {
      return;
    }
    this.mRightGlow = new EdgeEffect(getContext());
    if (this.mClipToPadding)
    {
      this.mRightGlow.setSize(getMeasuredHeight() - getPaddingTop() - getPaddingBottom(), getMeasuredWidth() - getPaddingLeft() - getPaddingRight());
      return;
    }
    this.mRightGlow.setSize(getMeasuredHeight(), getMeasuredWidth());
  }
  
  void ensureTopGlow()
  {
    if (this.mTopGlow != null) {
      return;
    }
    this.mTopGlow = new EdgeEffect(getContext());
    if (this.mClipToPadding)
    {
      this.mTopGlow.setSize(getMeasuredWidth() - getPaddingLeft() - getPaddingRight(), getMeasuredHeight() - getPaddingTop() - getPaddingBottom());
      return;
    }
    this.mTopGlow.setSize(getMeasuredWidth(), getMeasuredHeight());
  }
  
  String exceptionLabel()
  {
    return " " + super.toString() + ", adapter:" + this.mAdapter + ", layout:" + this.mLayout + ", context:" + getContext();
  }
  
  final void fillRemainingScrollValues(r paramr)
  {
    if (getScrollState() == 2)
    {
      OverScroller localOverScroller = t.a(this.mViewFlinger);
      paramr.n = (localOverScroller.getFinalX() - localOverScroller.getCurrX());
      paramr.o = (localOverScroller.getFinalY() - localOverScroller.getCurrY());
      return;
    }
    paramr.n = 0;
    paramr.o = 0;
  }
  
  public View findChildViewUnder(float paramFloat1, float paramFloat2)
  {
    int i = this.mChildHelper.b() - 1;
    while (i >= 0)
    {
      View localView = this.mChildHelper.b(i);
      float f1 = localView.getTranslationX();
      float f2 = localView.getTranslationY();
      if ((paramFloat1 >= localView.getLeft() + f1) && (paramFloat1 <= f1 + localView.getRight()) && (paramFloat2 >= localView.getTop() + f2) && (paramFloat2 <= localView.getBottom() + f2)) {
        return localView;
      }
      i -= 1;
    }
    return null;
  }
  
  public View findContainingItemView(View paramView)
  {
    for (ViewParent localViewParent = paramView.getParent(); (localViewParent != null) && (localViewParent != this) && ((localViewParent instanceof View)); localViewParent = paramView.getParent()) {
      paramView = (View)localViewParent;
    }
    if (localViewParent == this) {
      return paramView;
    }
    return null;
  }
  
  public u findContainingViewHolder(View paramView)
  {
    paramView = findContainingItemView(paramView);
    if (paramView == null) {
      return null;
    }
    return getChildViewHolder(paramView);
  }
  
  public u findViewHolderForAdapterPosition(int paramInt)
  {
    Object localObject = null;
    if (this.mDataSetHasChangedAfterLayout) {}
    int i;
    u localu;
    do
    {
      return (u)localObject;
      int j = this.mChildHelper.c();
      i = 0;
      localObject = null;
      if (i >= j) {
        break;
      }
      localu = getChildViewHolderInt(this.mChildHelper.d(i));
      if ((localu == null) || (localu.isRemoved()) || (getAdapterPositionFor(localu) != paramInt)) {
        break label100;
      }
      localObject = localu;
    } while (!this.mChildHelper.c(localu.itemView));
    localObject = localu;
    label100:
    for (;;)
    {
      i += 1;
      break;
      return (u)localObject;
    }
  }
  
  public u findViewHolderForItemId(long paramLong)
  {
    u localu2 = null;
    u localu1 = localu2;
    if (this.mAdapter != null)
    {
      if (this.mAdapter.hasStableIds()) {
        break label31;
      }
      localu1 = localu2;
    }
    label31:
    int i;
    do
    {
      return localu1;
      int j = this.mChildHelper.c();
      i = 0;
      localu1 = null;
      if (i >= j) {
        break;
      }
      localu2 = getChildViewHolderInt(this.mChildHelper.d(i));
      if ((localu2 == null) || (localu2.isRemoved()) || (localu2.getItemId() != paramLong)) {
        break label120;
      }
      localu1 = localu2;
    } while (!this.mChildHelper.c(localu2.itemView));
    localu1 = localu2;
    label120:
    for (;;)
    {
      i += 1;
      break;
      return localu1;
    }
  }
  
  public u findViewHolderForLayoutPosition(int paramInt)
  {
    return findViewHolderForPosition(paramInt, false);
  }
  
  @Deprecated
  public u findViewHolderForPosition(int paramInt)
  {
    return findViewHolderForPosition(paramInt, false);
  }
  
  u findViewHolderForPosition(int paramInt, boolean paramBoolean)
  {
    int j = this.mChildHelper.c();
    int i = 0;
    Object localObject1 = null;
    if (i < j)
    {
      u localu = getChildViewHolderInt(this.mChildHelper.d(i));
      Object localObject2 = localObject1;
      if (localu != null)
      {
        localObject2 = localObject1;
        if (!localu.isRemoved())
        {
          if (!paramBoolean) {
            break label82;
          }
          if (localu.mPosition == paramInt) {
            break label95;
          }
          localObject2 = localObject1;
        }
      }
      for (;;)
      {
        i += 1;
        localObject1 = localObject2;
        break;
        label82:
        localObject2 = localObject1;
        if (localu.getLayoutPosition() == paramInt)
        {
          label95:
          localObject1 = localu;
          if (!this.mChildHelper.c(localu.itemView)) {
            break label121;
          }
          localObject2 = localu;
        }
      }
    }
    label121:
    return (u)localObject1;
  }
  
  public boolean fling(int paramInt1, int paramInt2)
  {
    if (this.mLayout == null) {
      Log.e("RecyclerView", "Cannot fling without a LayoutManager set. Call setLayoutManager with a non-null argument.");
    }
    boolean bool2;
    boolean bool3;
    int i;
    int j;
    boolean bool1;
    do
    {
      do
      {
        do
        {
          return false;
        } while (this.mLayoutFrozen);
        bool2 = this.mLayout.canScrollHorizontally();
        bool3 = this.mLayout.canScrollVertically();
        if (bool2)
        {
          i = paramInt1;
          if (Math.abs(paramInt1) >= this.mMinFlingVelocity) {}
        }
        else
        {
          i = 0;
        }
        if (bool3)
        {
          j = paramInt2;
          if (Math.abs(paramInt2) >= this.mMinFlingVelocity) {}
        }
        else
        {
          j = 0;
        }
      } while (((i == 0) && (j == 0)) || (dispatchNestedPreFling(i, j)));
      if ((bool2) || (bool3)) {}
      for (bool1 = true;; bool1 = false)
      {
        dispatchNestedFling(i, j, bool1);
        if ((this.mOnFlingListener == null) || (!this.mOnFlingListener.onFling(i, j))) {
          break;
        }
        return true;
      }
    } while (!bool1);
    if (bool2) {}
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      paramInt2 = paramInt1;
      if (bool3) {
        paramInt2 = paramInt1 | 0x2;
      }
      startNestedScroll(paramInt2, 1);
      paramInt1 = Math.max(-this.mMaxFlingVelocity, Math.min(i, this.mMaxFlingVelocity));
      paramInt2 = Math.max(-this.mMaxFlingVelocity, Math.min(j, this.mMaxFlingVelocity));
      this.mViewFlinger.fling(paramInt1, paramInt2);
      return true;
    }
  }
  
  public View focusSearch(View paramView, int paramInt)
  {
    int k = 1;
    Object localObject = this.mLayout.onInterceptFocusSearch(paramView, paramInt);
    if (localObject != null) {
      return (View)localObject;
    }
    int i;
    int j;
    if ((this.mAdapter != null) && (this.mLayout != null) && (!isComputingLayout()) && (!this.mLayoutFrozen))
    {
      i = 1;
      localObject = FocusFinder.getInstance();
      if ((i == 0) || ((paramInt != 2) && (paramInt != 1))) {
        break label313;
      }
      if (!this.mLayout.canScrollVertically()) {
        break label423;
      }
      if (paramInt != 2) {
        break label214;
      }
      j = 130;
      label91:
      if (((FocusFinder)localObject).findNextFocus(this, paramView, j) != null) {
        break label221;
      }
      i = 1;
      label105:
      if (!FORCE_ABS_FOCUS_SEARCH_DIRECTION) {
        break label420;
      }
      paramInt = j;
    }
    for (;;)
    {
      if ((i == 0) && (this.mLayout.canScrollHorizontally())) {
        if (this.mLayout.getLayoutDirection() == 1)
        {
          i = 1;
          label141:
          if (paramInt != 2) {
            break label231;
          }
          j = 1;
          label149:
          if ((j ^ i) == 0) {
            break label237;
          }
          i = 66;
          label159:
          if (((FocusFinder)localObject).findNextFocus(this, paramView, i) != null) {
            break label243;
          }
          j = k;
          label174:
          k = j;
          if (FORCE_ABS_FOCUS_SEARCH_DIRECTION) {
            paramInt = i;
          }
        }
      }
      for (k = j;; k = i)
      {
        if (k != 0)
        {
          consumePendingUpdateOperations();
          if (findContainingItemView(paramView) == null)
          {
            return null;
            i = 0;
            break;
            label214:
            j = 33;
            break label91;
            label221:
            i = 0;
            break label105;
            i = 0;
            break label141;
            label231:
            j = 0;
            break label149;
            label237:
            i = 17;
            break label159;
            label243:
            j = 0;
            break label174;
          }
          eatRequestLayout();
          this.mLayout.onFocusSearchFailed(paramView, paramInt, this.mRecycler, this.mState);
          resumeRequestLayout(false);
        }
        localObject = ((FocusFinder)localObject).findNextFocus(this, paramView, paramInt);
        for (;;)
        {
          if ((localObject != null) && (!((View)localObject).hasFocusable()))
          {
            if (getFocusedChild() == null)
            {
              return super.focusSearch(paramView, paramInt);
              label313:
              localObject = ((FocusFinder)localObject).findNextFocus(this, paramView, paramInt);
              if ((localObject == null) && (i != 0))
              {
                consumePendingUpdateOperations();
                if (findContainingItemView(paramView) == null) {
                  return null;
                }
                eatRequestLayout();
                localObject = this.mLayout.onFocusSearchFailed(paramView, paramInt, this.mRecycler, this.mState);
                resumeRequestLayout(false);
              }
            }
            else
            {
              requestChildOnScreen((View)localObject, null);
              return paramView;
            }
          }
          else
          {
            if (isPreferredNextFocus(paramView, (View)localObject, paramInt)) {}
            for (;;)
            {
              return (View)localObject;
              localObject = super.focusSearch(paramView, paramInt);
            }
          }
        }
      }
      label420:
      continue;
      label423:
      i = 0;
    }
  }
  
  protected ViewGroup.LayoutParams generateDefaultLayoutParams()
  {
    if (this.mLayout == null) {
      throw new IllegalStateException("RecyclerView has no LayoutManager" + exceptionLabel());
    }
    return this.mLayout.generateDefaultLayoutParams();
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    if (this.mLayout == null) {
      throw new IllegalStateException("RecyclerView has no LayoutManager" + exceptionLabel());
    }
    return this.mLayout.generateLayoutParams(getContext(), paramAttributeSet);
  }
  
  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    if (this.mLayout == null) {
      throw new IllegalStateException("RecyclerView has no LayoutManager" + exceptionLabel());
    }
    return this.mLayout.generateLayoutParams(paramLayoutParams);
  }
  
  public a getAdapter()
  {
    return this.mAdapter;
  }
  
  int getAdapterPositionFor(u paramu)
  {
    if ((paramu.hasAnyOfTheFlags(524)) || (!paramu.isBound())) {
      return -1;
    }
    return this.mAdapterHelper.applyPendingUpdatesToPosition(paramu.mPosition);
  }
  
  public int getBaseline()
  {
    if (this.mLayout != null) {
      return this.mLayout.getBaseline();
    }
    return super.getBaseline();
  }
  
  long getChangedHolderKey(u paramu)
  {
    if (this.mAdapter.hasStableIds()) {
      return paramu.getItemId();
    }
    return paramu.mPosition;
  }
  
  public int getChildAdapterPosition(View paramView)
  {
    paramView = getChildViewHolderInt(paramView);
    if (paramView != null) {
      return paramView.getAdapterPosition();
    }
    return -1;
  }
  
  protected int getChildDrawingOrder(int paramInt1, int paramInt2)
  {
    if (this.mChildDrawingOrderCallback == null) {
      return super.getChildDrawingOrder(paramInt1, paramInt2);
    }
    return this.mChildDrawingOrderCallback.onGetChildDrawingOrder(paramInt1, paramInt2);
  }
  
  public long getChildItemId(View paramView)
  {
    if ((this.mAdapter == null) || (!this.mAdapter.hasStableIds())) {}
    do
    {
      return -1L;
      paramView = getChildViewHolderInt(paramView);
    } while (paramView == null);
    return paramView.getItemId();
  }
  
  public int getChildLayoutPosition(View paramView)
  {
    paramView = getChildViewHolderInt(paramView);
    if (paramView != null) {
      return paramView.getLayoutPosition();
    }
    return -1;
  }
  
  @Deprecated
  public int getChildPosition(View paramView)
  {
    return getChildAdapterPosition(paramView);
  }
  
  public u getChildViewHolder(View paramView)
  {
    ViewParent localViewParent = paramView.getParent();
    if ((localViewParent != null) && (localViewParent != this)) {
      throw new IllegalArgumentException("View " + paramView + " is not a direct child of " + this);
    }
    return getChildViewHolderInt(paramView);
  }
  
  public boolean getClipToPadding()
  {
    return this.mClipToPadding;
  }
  
  public ag getCompatAccessibilityDelegate()
  {
    return this.mAccessibilityDelegate;
  }
  
  public void getDecoratedBoundsWithMargins(View paramView, Rect paramRect)
  {
    getDecoratedBoundsWithMarginsInt(paramView, paramRect);
  }
  
  public e getItemAnimator()
  {
    return this.mItemAnimator;
  }
  
  Rect getItemDecorInsetsForChild(View paramView)
  {
    LayoutParams localLayoutParams = (LayoutParams)paramView.getLayoutParams();
    if (!localLayoutParams.e) {
      return localLayoutParams.d;
    }
    if ((this.mState.isPreLayout()) && ((localLayoutParams.isItemChanged()) || (localLayoutParams.isViewInvalid()))) {
      return localLayoutParams.d;
    }
    Rect localRect = localLayoutParams.d;
    localRect.set(0, 0, 0, 0);
    int j = this.mItemDecorations.size();
    int i = 0;
    while (i < j)
    {
      this.mTempRect.set(0, 0, 0, 0);
      ((g)this.mItemDecorations.get(i)).getItemOffsets(this.mTempRect, paramView, this, this.mState);
      localRect.left += this.mTempRect.left;
      localRect.top += this.mTempRect.top;
      localRect.right += this.mTempRect.right;
      localRect.bottom += this.mTempRect.bottom;
      i += 1;
    }
    localLayoutParams.e = false;
    return localRect;
  }
  
  public g getItemDecorationAt(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.mItemDecorations.size())) {
      return null;
    }
    return (g)this.mItemDecorations.get(paramInt);
  }
  
  public h getLayoutManager()
  {
    return this.mLayout;
  }
  
  public int getMaxFlingVelocity()
  {
    return this.mMaxFlingVelocity;
  }
  
  public int getMinFlingVelocity()
  {
    return this.mMinFlingVelocity;
  }
  
  long getNanoTime()
  {
    if (ALLOW_THREAD_GAP_WORK) {
      return System.nanoTime();
    }
    return 0L;
  }
  
  public j getOnFlingListener()
  {
    return this.mOnFlingListener;
  }
  
  public boolean getPreserveFocusAfterLayout()
  {
    return this.mPreserveFocusAfterLayout;
  }
  
  public m getRecycledViewPool()
  {
    return this.mRecycler.e();
  }
  
  public int getScrollState()
  {
    return this.mScrollState;
  }
  
  public boolean hasFixedSize()
  {
    return this.mHasFixedSize;
  }
  
  public boolean hasNestedScrollingParent()
  {
    return getScrollingChildHelper().hasNestedScrollingParent();
  }
  
  public boolean hasNestedScrollingParent(int paramInt)
  {
    return getScrollingChildHelper().hasNestedScrollingParent(paramInt);
  }
  
  public boolean hasPendingAdapterUpdates()
  {
    return (!this.mFirstLayoutComplete) || (this.mDataSetHasChangedAfterLayout) || (this.mAdapterHelper.d());
  }
  
  void initAdapterManager()
  {
    this.mAdapterHelper = new d(new d.a()
    {
      void a(d.b paramAnonymousb)
      {
        switch (paramAnonymousb.a)
        {
        case 3: 
        case 5: 
        case 6: 
        case 7: 
        default: 
          return;
        case 1: 
          RecyclerView.this.mLayout.onItemsAdded(RecyclerView.this, paramAnonymousb.b, paramAnonymousb.d);
          return;
        case 2: 
          RecyclerView.this.mLayout.onItemsRemoved(RecyclerView.this, paramAnonymousb.b, paramAnonymousb.d);
          return;
        case 4: 
          RecyclerView.this.mLayout.onItemsUpdated(RecyclerView.this, paramAnonymousb.b, paramAnonymousb.d, paramAnonymousb.c);
          return;
        }
        RecyclerView.this.mLayout.onItemsMoved(RecyclerView.this, paramAnonymousb.b, paramAnonymousb.d, 1);
      }
      
      public RecyclerView.u findViewHolder(int paramAnonymousInt)
      {
        RecyclerView.u localu = RecyclerView.this.findViewHolderForPosition(paramAnonymousInt, true);
        if (localu == null) {}
        while (RecyclerView.this.mChildHelper.c(localu.itemView)) {
          return null;
        }
        return localu;
      }
      
      public void markViewHoldersUpdated(int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject)
      {
        RecyclerView.this.viewRangeUpdate(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousObject);
        RecyclerView.this.mItemsChanged = true;
      }
      
      public void offsetPositionsForAdd(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        RecyclerView.this.offsetPositionRecordsForInsert(paramAnonymousInt1, paramAnonymousInt2);
        RecyclerView.this.mItemsAddedOrRemoved = true;
      }
      
      public void offsetPositionsForMove(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        RecyclerView.this.offsetPositionRecordsForMove(paramAnonymousInt1, paramAnonymousInt2);
        RecyclerView.this.mItemsAddedOrRemoved = true;
      }
      
      public void offsetPositionsForRemovingInvisible(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        RecyclerView.this.offsetPositionRecordsForRemove(paramAnonymousInt1, paramAnonymousInt2, true);
        RecyclerView.this.mItemsAddedOrRemoved = true;
        RecyclerView.r localr = RecyclerView.this.mState;
        localr.b += paramAnonymousInt2;
      }
      
      public void offsetPositionsForRemovingLaidOutOrNewView(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        RecyclerView.this.offsetPositionRecordsForRemove(paramAnonymousInt1, paramAnonymousInt2, false);
        RecyclerView.this.mItemsAddedOrRemoved = true;
      }
      
      public void onDispatchFirstPass(d.b paramAnonymousb)
      {
        a(paramAnonymousb);
      }
      
      public void onDispatchSecondPass(d.b paramAnonymousb)
      {
        a(paramAnonymousb);
      }
    });
  }
  
  void initFastScroller(StateListDrawable paramStateListDrawable1, Drawable paramDrawable1, StateListDrawable paramStateListDrawable2, Drawable paramDrawable2)
  {
    if ((paramStateListDrawable1 == null) || (paramDrawable1 == null) || (paramStateListDrawable2 == null) || (paramDrawable2 == null)) {
      throw new IllegalArgumentException("Trying to set fast scroller without both required drawables." + exceptionLabel());
    }
    Resources localResources = getContext().getResources();
    new x(this, paramStateListDrawable1, paramDrawable1, paramStateListDrawable2, paramDrawable2, localResources.getDimensionPixelSize(R.dimen.fastscroll_default_thickness), localResources.getDimensionPixelSize(R.dimen.fastscroll_minimum_range), localResources.getDimensionPixelOffset(R.dimen.fastscroll_margin));
  }
  
  void invalidateGlows()
  {
    this.mBottomGlow = null;
    this.mTopGlow = null;
    this.mRightGlow = null;
    this.mLeftGlow = null;
  }
  
  public void invalidateItemDecorations()
  {
    if (this.mItemDecorations.size() == 0) {
      return;
    }
    if (this.mLayout != null) {
      this.mLayout.assertNotInLayoutOrScroll("Cannot invalidate item decorations during a scroll or layout");
    }
    markItemDecorInsetsDirty();
    requestLayout();
  }
  
  boolean isAccessibilityEnabled()
  {
    return (this.mAccessibilityManager != null) && (this.mAccessibilityManager.isEnabled());
  }
  
  public boolean isAnimating()
  {
    return (this.mItemAnimator != null) && (this.mItemAnimator.isRunning());
  }
  
  public boolean isAttachedToWindow()
  {
    return this.mIsAttached;
  }
  
  public boolean isComputingLayout()
  {
    return this.mLayoutOrScrollCounter > 0;
  }
  
  public boolean isLayoutFrozen()
  {
    return this.mLayoutFrozen;
  }
  
  public boolean isNestedScrollingEnabled()
  {
    return getScrollingChildHelper().isNestedScrollingEnabled();
  }
  
  void jumpToPositionForSmoothScroller(int paramInt)
  {
    if (this.mLayout == null) {
      return;
    }
    this.mLayout.scrollToPosition(paramInt);
    awakenScrollBars();
  }
  
  void markItemDecorInsetsDirty()
  {
    int j = this.mChildHelper.c();
    int i = 0;
    while (i < j)
    {
      ((LayoutParams)this.mChildHelper.d(i).getLayoutParams()).e = true;
      i += 1;
    }
    this.mRecycler.h();
  }
  
  void markKnownViewsInvalid()
  {
    int j = this.mChildHelper.c();
    int i = 0;
    while (i < j)
    {
      u localu = getChildViewHolderInt(this.mChildHelper.d(i));
      if ((localu != null) && (!localu.shouldIgnore())) {
        localu.addFlags(6);
      }
      i += 1;
    }
    markItemDecorInsetsDirty();
    this.mRecycler.f();
  }
  
  public void offsetChildrenHorizontal(int paramInt)
  {
    int j = this.mChildHelper.b();
    int i = 0;
    while (i < j)
    {
      this.mChildHelper.b(i).offsetLeftAndRight(paramInt);
      i += 1;
    }
  }
  
  public void offsetChildrenVertical(int paramInt)
  {
    int j = this.mChildHelper.b();
    int i = 0;
    while (i < j)
    {
      this.mChildHelper.b(i).offsetTopAndBottom(paramInt);
      i += 1;
    }
  }
  
  void offsetPositionRecordsForInsert(int paramInt1, int paramInt2)
  {
    int j = this.mChildHelper.c();
    int i = 0;
    while (i < j)
    {
      u localu = getChildViewHolderInt(this.mChildHelper.d(i));
      if ((localu != null) && (!localu.shouldIgnore()) && (localu.mPosition >= paramInt1))
      {
        localu.offsetPosition(paramInt2, false);
        this.mState.e = true;
      }
      i += 1;
    }
    this.mRecycler.b(paramInt1, paramInt2);
    requestLayout();
  }
  
  void offsetPositionRecordsForMove(int paramInt1, int paramInt2)
  {
    int n = this.mChildHelper.c();
    int i;
    int j;
    if (paramInt1 < paramInt2)
    {
      i = -1;
      j = paramInt2;
    }
    u localu;
    for (int k = paramInt1;; k = paramInt2)
    {
      int m = 0;
      for (;;)
      {
        if (m >= n) {
          break label130;
        }
        localu = getChildViewHolderInt(this.mChildHelper.d(m));
        if ((localu != null) && (localu.mPosition >= k) && (localu.mPosition <= j)) {
          break;
        }
        m += 1;
      }
      i = 1;
      j = paramInt1;
    }
    if (localu.mPosition == paramInt1) {
      localu.offsetPosition(paramInt2 - paramInt1, false);
    }
    for (;;)
    {
      this.mState.e = true;
      break;
      localu.offsetPosition(i, false);
    }
    label130:
    this.mRecycler.a(paramInt1, paramInt2);
    requestLayout();
  }
  
  void offsetPositionRecordsForRemove(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    int j = this.mChildHelper.c();
    int i = 0;
    if (i < j)
    {
      u localu = getChildViewHolderInt(this.mChildHelper.d(i));
      if ((localu != null) && (!localu.shouldIgnore()))
      {
        if (localu.mPosition < paramInt1 + paramInt2) {
          break label82;
        }
        localu.offsetPosition(-paramInt2, paramBoolean);
        this.mState.e = true;
      }
      for (;;)
      {
        i += 1;
        break;
        label82:
        if (localu.mPosition >= paramInt1)
        {
          localu.flagRemovedAndOffsetPosition(paramInt1 - 1, -paramInt2, paramBoolean);
          this.mState.e = true;
        }
      }
    }
    this.mRecycler.a(paramInt1, paramInt2, paramBoolean);
    requestLayout();
  }
  
  protected void onAttachedToWindow()
  {
    boolean bool = true;
    super.onAttachedToWindow();
    this.mLayoutOrScrollCounter = 0;
    this.mIsAttached = true;
    float f;
    if ((this.mFirstLayoutComplete) && (!isLayoutRequested()))
    {
      this.mFirstLayoutComplete = bool;
      if (this.mLayout != null) {
        this.mLayout.b(this);
      }
      this.mPostedAnimatorRunner = false;
      if (ALLOW_THREAD_GAP_WORK)
      {
        this.mGapWorker = ((aa)aa.a.get());
        if (this.mGapWorker == null)
        {
          this.mGapWorker = new aa();
          Display localDisplay = ViewCompat.getDisplay(this);
          if ((isInEditMode()) || (localDisplay == null)) {
            break label158;
          }
          f = localDisplay.getRefreshRate();
          if (f < 30.0F) {
            break label158;
          }
        }
      }
    }
    for (;;)
    {
      this.mGapWorker.d = ((1.0E9F / f));
      aa.a.set(this.mGapWorker);
      this.mGapWorker.add(this);
      return;
      bool = false;
      break;
      label158:
      f = 60.0F;
    }
  }
  
  public void onChildAttachedToWindow(View paramView) {}
  
  public void onChildDetachedFromWindow(View paramView) {}
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (this.mItemAnimator != null) {
      this.mItemAnimator.endAnimations();
    }
    stopScroll();
    this.mIsAttached = false;
    if (this.mLayout != null) {
      this.mLayout.a(this, this.mRecycler);
    }
    this.mPendingAccessibilityImportanceChange.clear();
    removeCallbacks(this.mItemAnimatorRunner);
    this.mViewInfoStore.b();
    if (ALLOW_THREAD_GAP_WORK)
    {
      this.mGapWorker.remove(this);
      this.mGapWorker = null;
    }
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int j = this.mItemDecorations.size();
    int i = 0;
    while (i < j)
    {
      ((g)this.mItemDecorations.get(i)).onDraw(paramCanvas, this, this.mState);
      i += 1;
    }
  }
  
  void onEnterLayoutOrScroll()
  {
    this.mLayoutOrScrollCounter += 1;
  }
  
  void onExitLayoutOrScroll()
  {
    onExitLayoutOrScroll(true);
  }
  
  void onExitLayoutOrScroll(boolean paramBoolean)
  {
    this.mLayoutOrScrollCounter -= 1;
    if (this.mLayoutOrScrollCounter < 1)
    {
      this.mLayoutOrScrollCounter = 0;
      if (paramBoolean)
      {
        dispatchContentChangedIfNecessary();
        dispatchPendingImportantForAccessibilityChanges();
      }
    }
  }
  
  public boolean onGenericMotionEvent(MotionEvent paramMotionEvent)
  {
    if (this.mLayout == null) {}
    label114:
    label184:
    for (;;)
    {
      return false;
      if ((!this.mLayoutFrozen) && (paramMotionEvent.getAction() == 8))
      {
        float f1;
        float f2;
        if ((paramMotionEvent.getSource() & 0x2) != 0) {
          if (this.mLayout.canScrollVertically())
          {
            f1 = -paramMotionEvent.getAxisValue(9);
            if (!this.mLayout.canScrollHorizontally()) {
              break label114;
            }
            float f3 = paramMotionEvent.getAxisValue(10);
            f2 = f1;
            f1 = f3;
          }
        }
        for (;;)
        {
          if ((f2 == 0.0F) && (f1 == 0.0F)) {
            break label184;
          }
          scrollByInternal((int)(f1 * this.mScaledHorizontalScrollFactor), (int)(this.mScaledVerticalScrollFactor * f2), paramMotionEvent);
          return false;
          f1 = 0.0F;
          break;
          f2 = f1;
          f1 = 0.0F;
          continue;
          if ((paramMotionEvent.getSource() & 0x400000) != 0)
          {
            f1 = paramMotionEvent.getAxisValue(26);
            if (this.mLayout.canScrollVertically())
            {
              f2 = -f1;
              f1 = 0.0F;
            }
            else if (this.mLayout.canScrollHorizontally())
            {
              f2 = 0.0F;
            }
            else
            {
              f1 = 0.0F;
              f2 = 0.0F;
            }
          }
          else
          {
            f1 = 0.0F;
            f2 = 0.0F;
          }
        }
      }
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.mLayoutFrozen) {}
    do
    {
      return false;
      if (dispatchOnItemTouchIntercept(paramMotionEvent))
      {
        cancelTouch();
        return true;
      }
    } while (this.mLayout == null);
    boolean bool1 = this.mLayout.canScrollHorizontally();
    boolean bool2 = this.mLayout.canScrollVertically();
    if (this.mVelocityTracker == null) {
      this.mVelocityTracker = VelocityTracker.obtain();
    }
    this.mVelocityTracker.addMovement(paramMotionEvent);
    int j = paramMotionEvent.getActionMasked();
    int i = paramMotionEvent.getActionIndex();
    switch (j)
    {
    case 4: 
    default: 
      if (this.mScrollState == 1)
      {
        bool1 = true;
        return bool1;
      }
      break;
    case 0: 
      label135:
      if (this.mIgnoreMotionEventTillDown) {
        this.mIgnoreMotionEventTillDown = false;
      }
      this.mScrollPointerId = paramMotionEvent.getPointerId(0);
      i = (int)(paramMotionEvent.getX() + 0.5F);
      this.mLastTouchX = i;
      this.mInitialTouchX = i;
      i = (int)(paramMotionEvent.getY() + 0.5F);
      this.mLastTouchY = i;
      this.mInitialTouchY = i;
      if (this.mScrollState == 2)
      {
        getParent().requestDisallowInterceptTouchEvent(true);
        setScrollState(1);
      }
      paramMotionEvent = this.mNestedOffsets;
      this.mNestedOffsets[1] = 0;
      paramMotionEvent[0] = 0;
      if (!bool1) {}
      break;
    }
    for (i = 1;; i = 0)
    {
      j = i;
      if (bool2) {
        j = i | 0x2;
      }
      startNestedScroll(j, 0);
      break;
      this.mScrollPointerId = paramMotionEvent.getPointerId(i);
      j = (int)(paramMotionEvent.getX(i) + 0.5F);
      this.mLastTouchX = j;
      this.mInitialTouchX = j;
      i = (int)(paramMotionEvent.getY(i) + 0.5F);
      this.mLastTouchY = i;
      this.mInitialTouchY = i;
      break;
      j = paramMotionEvent.findPointerIndex(this.mScrollPointerId);
      if (j < 0)
      {
        Log.e("RecyclerView", "Error processing scroll; pointer index for id " + this.mScrollPointerId + " not found. Did any MotionEvents get skipped?");
        return false;
      }
      i = (int)(paramMotionEvent.getX(j) + 0.5F);
      int k = (int)(paramMotionEvent.getY(j) + 0.5F);
      if (this.mScrollState == 1) {
        break;
      }
      j = this.mInitialTouchX;
      int m = this.mInitialTouchY;
      if ((bool1) && (Math.abs(i - j) > this.mTouchSlop)) {
        this.mLastTouchX = i;
      }
      for (i = 1;; i = 0)
      {
        j = i;
        if (bool2)
        {
          j = i;
          if (Math.abs(k - m) > this.mTouchSlop)
          {
            this.mLastTouchY = k;
            j = 1;
          }
        }
        if (j == 0) {
          break;
        }
        setScrollState(1);
        break;
        onPointerUp(paramMotionEvent);
        break;
        this.mVelocityTracker.clear();
        stopNestedScroll(0);
        break;
        cancelTouch();
        break;
        bool1 = false;
        break label135;
      }
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    TraceCompat.beginSection("RV OnLayout");
    dispatchLayout();
    TraceCompat.endSection();
    this.mFirstLayoutComplete = true;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int j = 0;
    if (this.mLayout == null) {
      defaultOnMeasure(paramInt1, paramInt2);
    }
    do
    {
      int i;
      do
      {
        return;
        if (!this.mLayout.w) {
          break;
        }
        int k = View.MeasureSpec.getMode(paramInt1);
        int m = View.MeasureSpec.getMode(paramInt2);
        i = j;
        if (k == 1073741824)
        {
          i = j;
          if (m == 1073741824) {
            i = 1;
          }
        }
        this.mLayout.onMeasure(this.mRecycler, this.mState, paramInt1, paramInt2);
      } while ((i != 0) || (this.mAdapter == null));
      if (this.mState.c == 1) {
        dispatchLayoutStep1();
      }
      this.mLayout.c(paramInt1, paramInt2);
      this.mState.h = true;
      dispatchLayoutStep2();
      this.mLayout.d(paramInt1, paramInt2);
    } while (!this.mLayout.e());
    this.mLayout.c(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
    this.mState.h = true;
    dispatchLayoutStep2();
    this.mLayout.d(paramInt1, paramInt2);
    return;
    if (this.mHasFixedSize)
    {
      this.mLayout.onMeasure(this.mRecycler, this.mState, paramInt1, paramInt2);
      return;
    }
    if (this.mAdapterUpdateDuringMeasure)
    {
      eatRequestLayout();
      onEnterLayoutOrScroll();
      processAdapterUpdatesAndSetAnimationFlags();
      onExitLayoutOrScroll();
      if (this.mState.j)
      {
        this.mState.f = true;
        this.mAdapterUpdateDuringMeasure = false;
        resumeRequestLayout(false);
        label271:
        if (this.mAdapter == null) {
          break label368;
        }
      }
    }
    label368:
    for (this.mState.d = this.mAdapter.getItemCount();; this.mState.d = 0)
    {
      eatRequestLayout();
      this.mLayout.onMeasure(this.mRecycler, this.mState, paramInt1, paramInt2);
      resumeRequestLayout(false);
      this.mState.f = false;
      return;
      this.mAdapterHelper.e();
      this.mState.f = false;
      break;
      if (!this.mState.j) {
        break label271;
      }
      setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
      return;
    }
  }
  
  protected boolean onRequestFocusInDescendants(int paramInt, Rect paramRect)
  {
    if (isComputingLayout()) {
      return false;
    }
    return super.onRequestFocusInDescendants(paramInt, paramRect);
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof SavedState)) {
      super.onRestoreInstanceState(paramParcelable);
    }
    do
    {
      return;
      this.mPendingSavedState = ((SavedState)paramParcelable);
      super.onRestoreInstanceState(this.mPendingSavedState.getSuperState());
    } while ((this.mLayout == null) || (this.mPendingSavedState.a == null));
    this.mLayout.onRestoreInstanceState(this.mPendingSavedState.a);
  }
  
  protected Parcelable onSaveInstanceState()
  {
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    if (this.mPendingSavedState != null)
    {
      localSavedState.a(this.mPendingSavedState);
      return localSavedState;
    }
    if (this.mLayout != null)
    {
      localSavedState.a = this.mLayout.onSaveInstanceState();
      return localSavedState;
    }
    localSavedState.a = null;
    return localSavedState;
  }
  
  public void onScrollStateChanged(int paramInt) {}
  
  public void onScrolled(int paramInt1, int paramInt2) {}
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if ((paramInt1 != paramInt3) || (paramInt2 != paramInt4)) {
      invalidateGlows();
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i2 = 0;
    if ((this.mLayoutFrozen) || (this.mIgnoreMotionEventTillDown)) {}
    do
    {
      return false;
      if (dispatchOnItemTouch(paramMotionEvent))
      {
        cancelTouch();
        return true;
      }
    } while (this.mLayout == null);
    boolean bool1 = this.mLayout.canScrollHorizontally();
    boolean bool2 = this.mLayout.canScrollVertically();
    if (this.mVelocityTracker == null) {
      this.mVelocityTracker = VelocityTracker.obtain();
    }
    MotionEvent localMotionEvent = MotionEvent.obtain(paramMotionEvent);
    int k = paramMotionEvent.getActionMasked();
    int j = paramMotionEvent.getActionIndex();
    if (k == 0)
    {
      int[] arrayOfInt = this.mNestedOffsets;
      this.mNestedOffsets[1] = 0;
      arrayOfInt[0] = 0;
    }
    localMotionEvent.offsetLocation(this.mNestedOffsets[0], this.mNestedOffsets[1]);
    int i = i2;
    switch (k)
    {
    default: 
      i = i2;
    case 4: 
      if (i == 0) {
        this.mVelocityTracker.addMovement(localMotionEvent);
      }
      localMotionEvent.recycle();
      return true;
    case 0: 
      this.mScrollPointerId = paramMotionEvent.getPointerId(0);
      i = (int)(paramMotionEvent.getX() + 0.5F);
      this.mLastTouchX = i;
      this.mInitialTouchX = i;
      i = (int)(paramMotionEvent.getY() + 0.5F);
      this.mLastTouchY = i;
      this.mInitialTouchY = i;
      if (!bool1) {
        break;
      }
    }
    for (i = 1;; i = 0)
    {
      j = i;
      if (bool2) {
        j = i | 0x2;
      }
      startNestedScroll(j, 0);
      i = i2;
      break;
      this.mScrollPointerId = paramMotionEvent.getPointerId(j);
      i = (int)(paramMotionEvent.getX(j) + 0.5F);
      this.mLastTouchX = i;
      this.mInitialTouchX = i;
      i = (int)(paramMotionEvent.getY(j) + 0.5F);
      this.mLastTouchY = i;
      this.mInitialTouchY = i;
      i = i2;
      break;
      i = paramMotionEvent.findPointerIndex(this.mScrollPointerId);
      if (i < 0)
      {
        Log.e("RecyclerView", "Error processing scroll; pointer index for id " + this.mScrollPointerId + " not found. Did any MotionEvents get skipped?");
        return false;
      }
      int i3 = (int)(paramMotionEvent.getX(i) + 0.5F);
      int i4 = (int)(paramMotionEvent.getY(i) + 0.5F);
      int m = this.mLastTouchX - i3;
      k = this.mLastTouchY - i4;
      j = m;
      i = k;
      if (dispatchNestedPreScroll(m, k, this.mScrollConsumed, this.mScrollOffset, 0))
      {
        j = m - this.mScrollConsumed[0];
        i = k - this.mScrollConsumed[1];
        localMotionEvent.offsetLocation(this.mScrollOffset[0], this.mScrollOffset[1]);
        paramMotionEvent = this.mNestedOffsets;
        paramMotionEvent[0] += this.mScrollOffset[0];
        paramMotionEvent = this.mNestedOffsets;
        paramMotionEvent[1] += this.mScrollOffset[1];
      }
      k = j;
      m = i;
      if (this.mScrollState != 1)
      {
        if ((!bool1) || (Math.abs(j) <= this.mTouchSlop)) {
          break label986;
        }
        if (j <= 0) {
          break label819;
        }
        j -= this.mTouchSlop;
      }
      label613:
      label663:
      label743:
      label819:
      label831:
      label849:
      label909:
      label970:
      label986:
      for (k = 1;; k = 0)
      {
        int i1 = k;
        int n = i;
        if (bool2)
        {
          i1 = k;
          n = i;
          if (Math.abs(i) > this.mTouchSlop)
          {
            if (i <= 0) {
              break label831;
            }
            i -= this.mTouchSlop;
            i1 = 1;
            n = i;
          }
        }
        k = j;
        m = n;
        if (i1 != 0)
        {
          setScrollState(1);
          m = n;
          k = j;
        }
        i = i2;
        if (this.mScrollState != 1) {
          break;
        }
        this.mLastTouchX = (i3 - this.mScrollOffset[0]);
        this.mLastTouchY = (i4 - this.mScrollOffset[1]);
        if (bool1)
        {
          i = k;
          if (!bool2) {
            break label849;
          }
        }
        for (j = m;; j = 0)
        {
          if (scrollByInternal(i, j, localMotionEvent)) {
            getParent().requestDisallowInterceptTouchEvent(true);
          }
          i = i2;
          if (this.mGapWorker == null) {
            break;
          }
          if (k == 0)
          {
            i = i2;
            if (m == 0) {
              break;
            }
          }
          this.mGapWorker.a(this, k, m);
          i = i2;
          break;
          j = this.mTouchSlop + j;
          break label613;
          i = this.mTouchSlop + i;
          break label663;
          i = 0;
          break label743;
        }
        onPointerUp(paramMotionEvent);
        i = i2;
        break;
        this.mVelocityTracker.addMovement(localMotionEvent);
        this.mVelocityTracker.computeCurrentVelocity(1000, this.mMaxFlingVelocity);
        float f1;
        if (bool1)
        {
          f1 = -this.mVelocityTracker.getXVelocity(this.mScrollPointerId);
          if (!bool2) {
            break label970;
          }
        }
        for (float f2 = -this.mVelocityTracker.getYVelocity(this.mScrollPointerId);; f2 = 0.0F)
        {
          if (((f1 == 0.0F) && (f2 == 0.0F)) || (!fling((int)f1, (int)f2))) {
            setScrollState(0);
          }
          resetTouch();
          i = 1;
          break;
          f1 = 0.0F;
          break label909;
        }
        cancelTouch();
        i = i2;
        break;
      }
    }
  }
  
  void postAnimationRunner()
  {
    if ((!this.mPostedAnimatorRunner) && (this.mIsAttached))
    {
      ViewCompat.postOnAnimation(this, this.mItemAnimatorRunner);
      this.mPostedAnimatorRunner = true;
    }
  }
  
  void recordAnimationInfoIfBouncedHiddenView(u paramu, RecyclerView.e.c paramc)
  {
    paramu.setFlags(0, 8192);
    if ((this.mState.g) && (paramu.isUpdated()) && (!paramu.isRemoved()) && (!paramu.shouldIgnore()))
    {
      long l = getChangedHolderKey(paramu);
      this.mViewInfoStore.a(l, paramu);
    }
    this.mViewInfoStore.a(paramu, paramc);
  }
  
  void removeAndRecycleViews()
  {
    if (this.mItemAnimator != null) {
      this.mItemAnimator.endAnimations();
    }
    if (this.mLayout != null)
    {
      this.mLayout.removeAndRecycleAllViews(this.mRecycler);
      this.mLayout.a(this.mRecycler);
    }
    this.mRecycler.clear();
  }
  
  boolean removeAnimatingView(View paramView)
  {
    eatRequestLayout();
    boolean bool2 = this.mChildHelper.f(paramView);
    if (bool2)
    {
      paramView = getChildViewHolderInt(paramView);
      this.mRecycler.c(paramView);
      this.mRecycler.b(paramView);
    }
    if (!bool2) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      resumeRequestLayout(bool1);
      return bool2;
    }
  }
  
  protected void removeDetachedView(View paramView, boolean paramBoolean)
  {
    u localu = getChildViewHolderInt(paramView);
    if (localu != null)
    {
      if (!localu.isTmpDetached()) {
        break label36;
      }
      localu.clearTmpDetachFlag();
    }
    label36:
    while (localu.shouldIgnore())
    {
      paramView.clearAnimation();
      dispatchChildDetached(paramView);
      super.removeDetachedView(paramView, paramBoolean);
      return;
    }
    throw new IllegalArgumentException("Called removeDetachedView with a view which is not flagged as tmp detached." + localu + exceptionLabel());
  }
  
  public void removeItemDecoration(g paramg)
  {
    if (this.mLayout != null) {
      this.mLayout.assertNotInLayoutOrScroll("Cannot remove item decoration during a scroll  or layout");
    }
    this.mItemDecorations.remove(paramg);
    if (this.mItemDecorations.isEmpty()) {
      if (getOverScrollMode() != 2) {
        break label60;
      }
    }
    label60:
    for (boolean bool = true;; bool = false)
    {
      setWillNotDraw(bool);
      markItemDecorInsetsDirty();
      requestLayout();
      return;
    }
  }
  
  public void removeOnChildAttachStateChangeListener(i parami)
  {
    if (this.mOnChildAttachStateListeners == null) {
      return;
    }
    this.mOnChildAttachStateListeners.remove(parami);
  }
  
  public void removeOnItemTouchListener(k paramk)
  {
    this.mOnItemTouchListeners.remove(paramk);
    if (this.mActiveOnItemTouchListener == paramk) {
      this.mActiveOnItemTouchListener = null;
    }
  }
  
  public void removeOnScrollListener(l paraml)
  {
    if (this.mScrollListeners != null) {
      this.mScrollListeners.remove(paraml);
    }
  }
  
  void repositionShadowingViews()
  {
    int j = this.mChildHelper.b();
    int i = 0;
    while (i < j)
    {
      View localView = this.mChildHelper.b(i);
      Object localObject = getChildViewHolder(localView);
      if ((localObject != null) && (((u)localObject).mShadowingHolder != null))
      {
        localObject = ((u)localObject).mShadowingHolder.itemView;
        int k = localView.getLeft();
        int m = localView.getTop();
        if ((k != ((View)localObject).getLeft()) || (m != ((View)localObject).getTop())) {
          ((View)localObject).layout(k, m, ((View)localObject).getWidth() + k, ((View)localObject).getHeight() + m);
        }
      }
      i += 1;
    }
  }
  
  public void requestChildFocus(View paramView1, View paramView2)
  {
    if ((!this.mLayout.onRequestChildFocus(this, this.mState, paramView1, paramView2)) && (paramView2 != null)) {
      requestChildOnScreen(paramView1, paramView2);
    }
    super.requestChildFocus(paramView1, paramView2);
  }
  
  public boolean requestChildRectangleOnScreen(View paramView, Rect paramRect, boolean paramBoolean)
  {
    return this.mLayout.requestChildRectangleOnScreen(this, paramView, paramRect, paramBoolean);
  }
  
  public void requestDisallowInterceptTouchEvent(boolean paramBoolean)
  {
    int j = this.mOnItemTouchListeners.size();
    int i = 0;
    while (i < j)
    {
      ((k)this.mOnItemTouchListeners.get(i)).onRequestDisallowInterceptTouchEvent(paramBoolean);
      i += 1;
    }
    super.requestDisallowInterceptTouchEvent(paramBoolean);
  }
  
  public void requestLayout()
  {
    if ((this.mEatRequestLayout == 0) && (!this.mLayoutFrozen))
    {
      super.requestLayout();
      return;
    }
    this.mLayoutRequestEaten = true;
  }
  
  void resumeRequestLayout(boolean paramBoolean)
  {
    if (this.mEatRequestLayout < 1) {
      this.mEatRequestLayout = 1;
    }
    if (!paramBoolean) {
      this.mLayoutRequestEaten = false;
    }
    if (this.mEatRequestLayout == 1)
    {
      if ((paramBoolean) && (this.mLayoutRequestEaten) && (!this.mLayoutFrozen) && (this.mLayout != null) && (this.mAdapter != null)) {
        dispatchLayout();
      }
      if (!this.mLayoutFrozen) {
        this.mLayoutRequestEaten = false;
      }
    }
    this.mEatRequestLayout -= 1;
  }
  
  void saveOldPositions()
  {
    int j = this.mChildHelper.c();
    int i = 0;
    while (i < j)
    {
      u localu = getChildViewHolderInt(this.mChildHelper.d(i));
      if (!localu.shouldIgnore()) {
        localu.saveOldPosition();
      }
      i += 1;
    }
  }
  
  public void scrollBy(int paramInt1, int paramInt2)
  {
    if (this.mLayout == null) {}
    boolean bool1;
    boolean bool2;
    do
    {
      Log.e("RecyclerView", "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
      do
      {
        return;
      } while (this.mLayoutFrozen);
      bool1 = this.mLayout.canScrollHorizontally();
      bool2 = this.mLayout.canScrollVertically();
    } while ((!bool1) && (!bool2));
    if (bool1) {
      if (!bool2) {
        break label73;
      }
    }
    for (;;)
    {
      scrollByInternal(paramInt1, paramInt2, null);
      return;
      paramInt1 = 0;
      break;
      label73:
      paramInt2 = 0;
    }
  }
  
  boolean scrollByInternal(int paramInt1, int paramInt2, MotionEvent paramMotionEvent)
  {
    boolean bool = false;
    consumePendingUpdateOperations();
    int j;
    int i;
    int k;
    int m;
    if (this.mAdapter != null)
    {
      eatRequestLayout();
      onEnterLayoutOrScroll();
      TraceCompat.beginSection("RV Scroll");
      fillRemainingScrollValues(this.mState);
      if (paramInt1 != 0)
      {
        j = this.mLayout.scrollHorizontallyBy(paramInt1, this.mRecycler, this.mState);
        i = paramInt1 - j;
        if (paramInt2 != 0)
        {
          k = this.mLayout.scrollVerticallyBy(paramInt2, this.mRecycler, this.mState);
          m = paramInt2 - k;
          label91:
          TraceCompat.endSection();
          repositionShadowingViews();
          onExitLayoutOrScroll();
          resumeRequestLayout(false);
          int n = k;
          k = i;
          i = n;
        }
      }
    }
    for (;;)
    {
      if (!this.mItemDecorations.isEmpty()) {
        invalidate();
      }
      if (dispatchNestedScroll(j, i, k, m, this.mScrollOffset, 0))
      {
        this.mLastTouchX -= this.mScrollOffset[0];
        this.mLastTouchY -= this.mScrollOffset[1];
        if (paramMotionEvent != null) {
          paramMotionEvent.offsetLocation(this.mScrollOffset[0], this.mScrollOffset[1]);
        }
        paramMotionEvent = this.mNestedOffsets;
        paramMotionEvent[0] += this.mScrollOffset[0];
        paramMotionEvent = this.mNestedOffsets;
        paramMotionEvent[1] += this.mScrollOffset[1];
      }
      for (;;)
      {
        if ((j != 0) || (i != 0)) {
          dispatchOnScrolled(j, i);
        }
        if (!awakenScrollBars()) {
          invalidate();
        }
        if ((j != 0) || (i != 0)) {
          bool = true;
        }
        return bool;
        if (getOverScrollMode() != 2)
        {
          if ((paramMotionEvent != null) && (!MotionEventCompat.isFromSource(paramMotionEvent, 8194))) {
            pullGlows(paramMotionEvent.getX(), k, paramMotionEvent.getY(), m);
          }
          considerReleasingGlowsOnScroll(paramInt1, paramInt2);
        }
      }
      k = 0;
      m = 0;
      break label91;
      j = 0;
      i = 0;
      break;
      i = 0;
      j = 0;
      m = 0;
      k = 0;
    }
  }
  
  public void scrollTo(int paramInt1, int paramInt2)
  {
    Log.w("RecyclerView", "RecyclerView does not support scrolling to an absolute position. Use scrollToPosition instead");
  }
  
  public void scrollToPosition(int paramInt)
  {
    if (this.mLayoutFrozen) {
      return;
    }
    stopScroll();
    if (this.mLayout == null)
    {
      Log.e("RecyclerView", "Cannot scroll to position a LayoutManager set. Call setLayoutManager with a non-null argument.");
      return;
    }
    this.mLayout.scrollToPosition(paramInt);
    awakenScrollBars();
  }
  
  public void sendAccessibilityEventUnchecked(AccessibilityEvent paramAccessibilityEvent)
  {
    if (shouldDeferAccessibilityEvent(paramAccessibilityEvent)) {
      return;
    }
    super.sendAccessibilityEventUnchecked(paramAccessibilityEvent);
  }
  
  public void setAccessibilityDelegateCompat(ag paramag)
  {
    this.mAccessibilityDelegate = paramag;
    ViewCompat.setAccessibilityDelegate(this, this.mAccessibilityDelegate);
  }
  
  public void setAdapter(a parama)
  {
    setLayoutFrozen(false);
    setAdapterInternal(parama, false, true);
    requestLayout();
  }
  
  public void setChildDrawingOrderCallback(d paramd)
  {
    if (paramd == this.mChildDrawingOrderCallback) {
      return;
    }
    this.mChildDrawingOrderCallback = paramd;
    if (this.mChildDrawingOrderCallback != null) {}
    for (boolean bool = true;; bool = false)
    {
      setChildrenDrawingOrderEnabled(bool);
      return;
    }
  }
  
  boolean setChildImportantForAccessibilityInternal(u paramu, int paramInt)
  {
    if (isComputingLayout())
    {
      paramu.mPendingAccessibilityState = paramInt;
      this.mPendingAccessibilityImportanceChange.add(paramu);
      return false;
    }
    ViewCompat.setImportantForAccessibility(paramu.itemView, paramInt);
    return true;
  }
  
  public void setClipToPadding(boolean paramBoolean)
  {
    if (paramBoolean != this.mClipToPadding) {
      invalidateGlows();
    }
    this.mClipToPadding = paramBoolean;
    super.setClipToPadding(paramBoolean);
    if (this.mFirstLayoutComplete) {
      requestLayout();
    }
  }
  
  void setDataSetChangedAfterLayout()
  {
    this.mDataSetHasChangedAfterLayout = true;
    markKnownViewsInvalid();
  }
  
  public void setHasFixedSize(boolean paramBoolean)
  {
    this.mHasFixedSize = paramBoolean;
  }
  
  public void setItemAnimator(e parame)
  {
    if (this.mItemAnimator != null)
    {
      this.mItemAnimator.endAnimations();
      this.mItemAnimator.a(null);
    }
    this.mItemAnimator = parame;
    if (this.mItemAnimator != null) {
      this.mItemAnimator.a(this.mItemAnimatorListener);
    }
  }
  
  public void setItemViewCacheSize(int paramInt)
  {
    this.mRecycler.setViewCacheSize(paramInt);
  }
  
  public void setLayoutFrozen(boolean paramBoolean)
  {
    if (paramBoolean != this.mLayoutFrozen)
    {
      assertNotInLayoutOrScroll("Do not setLayoutFrozen in layout or scroll");
      if (!paramBoolean)
      {
        this.mLayoutFrozen = false;
        if ((this.mLayoutRequestEaten) && (this.mLayout != null) && (this.mAdapter != null)) {
          requestLayout();
        }
        this.mLayoutRequestEaten = false;
      }
    }
    else
    {
      return;
    }
    long l = SystemClock.uptimeMillis();
    onTouchEvent(MotionEvent.obtain(l, l, 3, 0.0F, 0.0F, 0));
    this.mLayoutFrozen = true;
    this.mIgnoreMotionEventTillDown = true;
    stopScroll();
  }
  
  public void setLayoutManager(h paramh)
  {
    if (paramh == this.mLayout) {
      return;
    }
    stopScroll();
    if (this.mLayout != null)
    {
      if (this.mItemAnimator != null) {
        this.mItemAnimator.endAnimations();
      }
      this.mLayout.removeAndRecycleAllViews(this.mRecycler);
      this.mLayout.a(this.mRecycler);
      this.mRecycler.clear();
      if (this.mIsAttached) {
        this.mLayout.a(this, this.mRecycler);
      }
      this.mLayout.a(null);
      this.mLayout = null;
    }
    for (;;)
    {
      this.mChildHelper.a();
      this.mLayout = paramh;
      if (paramh == null) {
        break label195;
      }
      if (paramh.q == null) {
        break;
      }
      throw new IllegalArgumentException("LayoutManager " + paramh + " is already attached to a RecyclerView:" + paramh.q.exceptionLabel());
      this.mRecycler.clear();
    }
    this.mLayout.a(this);
    if (this.mIsAttached) {
      this.mLayout.b(this);
    }
    label195:
    this.mRecycler.a();
    requestLayout();
  }
  
  public void setNestedScrollingEnabled(boolean paramBoolean)
  {
    getScrollingChildHelper().setNestedScrollingEnabled(paramBoolean);
  }
  
  public void setOnFlingListener(j paramj)
  {
    this.mOnFlingListener = paramj;
  }
  
  @Deprecated
  public void setOnScrollListener(l paraml)
  {
    this.mScrollListener = paraml;
  }
  
  public void setPreserveFocusAfterLayout(boolean paramBoolean)
  {
    this.mPreserveFocusAfterLayout = paramBoolean;
  }
  
  public void setRecycledViewPool(m paramm)
  {
    this.mRecycler.a(paramm);
  }
  
  public void setRecyclerListener(o paramo)
  {
    this.mRecyclerListener = paramo;
  }
  
  void setScrollState(int paramInt)
  {
    if (paramInt == this.mScrollState) {
      return;
    }
    this.mScrollState = paramInt;
    if (paramInt != 2) {
      stopScrollersInternal();
    }
    dispatchOnScrollStateChanged(paramInt);
  }
  
  public void setScrollingTouchSlop(int paramInt)
  {
    ViewConfiguration localViewConfiguration = ViewConfiguration.get(getContext());
    switch (paramInt)
    {
    default: 
      Log.w("RecyclerView", "setScrollingTouchSlop(): bad argument constant " + paramInt + "; using default value");
    case 0: 
      this.mTouchSlop = localViewConfiguration.getScaledTouchSlop();
      return;
    }
    this.mTouchSlop = localViewConfiguration.getScaledPagingTouchSlop();
  }
  
  public void setViewCacheExtension(s params)
  {
    this.mRecycler.a(params);
  }
  
  boolean shouldDeferAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    boolean bool = false;
    int j = 0;
    if (isComputingLayout()) {
      if (paramAccessibilityEvent == null) {
        break label46;
      }
    }
    label46:
    for (int i = AccessibilityEventCompat.getContentChangeTypes(paramAccessibilityEvent);; i = 0)
    {
      if (i == 0) {
        i = j;
      }
      for (;;)
      {
        this.mEatenAccessibilityChangeFlags = (i | this.mEatenAccessibilityChangeFlags);
        bool = true;
        return bool;
      }
    }
  }
  
  public void smoothScrollBy(int paramInt1, int paramInt2)
  {
    smoothScrollBy(paramInt1, paramInt2, null);
  }
  
  public void smoothScrollBy(int paramInt1, int paramInt2, Interpolator paramInterpolator)
  {
    int i = 0;
    if (this.mLayout == null) {
      Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
    }
    for (;;)
    {
      return;
      if (!this.mLayoutFrozen)
      {
        if (!this.mLayout.canScrollHorizontally()) {
          paramInt1 = 0;
        }
        if (!this.mLayout.canScrollVertically()) {
          paramInt2 = i;
        }
        while ((paramInt1 != 0) || (paramInt2 != 0))
        {
          this.mViewFlinger.smoothScrollBy(paramInt1, paramInt2, paramInterpolator);
          return;
        }
      }
    }
  }
  
  public void smoothScrollToPosition(int paramInt)
  {
    if (this.mLayoutFrozen) {
      return;
    }
    if (this.mLayout == null)
    {
      Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
      return;
    }
    this.mLayout.smoothScrollToPosition(this, this.mState, paramInt);
  }
  
  public boolean startNestedScroll(int paramInt)
  {
    return getScrollingChildHelper().startNestedScroll(paramInt);
  }
  
  public boolean startNestedScroll(int paramInt1, int paramInt2)
  {
    return getScrollingChildHelper().startNestedScroll(paramInt1, paramInt2);
  }
  
  public void stopNestedScroll()
  {
    getScrollingChildHelper().stopNestedScroll();
  }
  
  public void stopNestedScroll(int paramInt)
  {
    getScrollingChildHelper().stopNestedScroll(paramInt);
  }
  
  public void stopScroll()
  {
    setScrollState(0);
    stopScrollersInternal();
  }
  
  public void swapAdapter(a parama, boolean paramBoolean)
  {
    setLayoutFrozen(false);
    setAdapterInternal(parama, true, paramBoolean);
    requestLayout();
  }
  
  void viewRangeUpdate(int paramInt1, int paramInt2, Object paramObject)
  {
    int j = this.mChildHelper.c();
    int i = 0;
    if (i < j)
    {
      View localView = this.mChildHelper.d(i);
      u localu = getChildViewHolderInt(localView);
      if ((localu == null) || (localu.shouldIgnore())) {}
      for (;;)
      {
        i += 1;
        break;
        if ((localu.mPosition >= paramInt1) && (localu.mPosition < paramInt1 + paramInt2))
        {
          localu.addFlags(2);
          localu.addChangePayload(paramObject);
          ((LayoutParams)localView.getLayoutParams()).e = true;
        }
      }
    }
    this.mRecycler.c(paramInt1, paramInt2);
  }
  
  public static class LayoutParams
    extends ViewGroup.MarginLayoutParams
  {
    RecyclerView.u c;
    final Rect d = new Rect();
    boolean e = true;
    boolean f = false;
    
    public LayoutParams(int paramInt1, int paramInt2)
    {
      super(paramInt2);
    }
    
    public LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
    }
    
    public LayoutParams(LayoutParams paramLayoutParams)
    {
      super();
    }
    
    public LayoutParams(ViewGroup.LayoutParams paramLayoutParams)
    {
      super();
    }
    
    public LayoutParams(ViewGroup.MarginLayoutParams paramMarginLayoutParams)
    {
      super();
    }
    
    public int getViewAdapterPosition()
    {
      return this.c.getAdapterPosition();
    }
    
    public int getViewLayoutPosition()
    {
      return this.c.getLayoutPosition();
    }
    
    @Deprecated
    public int getViewPosition()
    {
      return this.c.getPosition();
    }
    
    public boolean isItemChanged()
    {
      return this.c.isUpdated();
    }
    
    public boolean isItemRemoved()
    {
      return this.c.isRemoved();
    }
    
    public boolean isViewInvalid()
    {
      return this.c.isInvalid();
    }
    
    public boolean viewNeedsUpdate()
    {
      return this.c.needsUpdate();
    }
  }
  
  public static class SavedState
    extends AbsSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator()
    {
      public RecyclerView.SavedState createFromParcel(Parcel paramAnonymousParcel)
      {
        return new RecyclerView.SavedState(paramAnonymousParcel, null);
      }
      
      public RecyclerView.SavedState createFromParcel(Parcel paramAnonymousParcel, ClassLoader paramAnonymousClassLoader)
      {
        return new RecyclerView.SavedState(paramAnonymousParcel, paramAnonymousClassLoader);
      }
      
      public RecyclerView.SavedState[] newArray(int paramAnonymousInt)
      {
        return new RecyclerView.SavedState[paramAnonymousInt];
      }
    };
    Parcelable a;
    
    SavedState(Parcel paramParcel, ClassLoader paramClassLoader)
    {
      super(paramClassLoader);
      if (paramClassLoader != null) {}
      for (;;)
      {
        this.a = paramParcel.readParcelable(paramClassLoader);
        return;
        paramClassLoader = RecyclerView.h.class.getClassLoader();
      }
    }
    
    SavedState(Parcelable paramParcelable)
    {
      super();
    }
    
    void a(SavedState paramSavedState)
    {
      this.a = paramSavedState.a;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeParcelable(this.a, 0);
    }
  }
  
  public static abstract class a<VH extends RecyclerView.u>
  {
    private boolean mHasStableIds = false;
    private final RecyclerView.b mObservable = new RecyclerView.b();
    
    public final void bindViewHolder(VH paramVH, int paramInt)
    {
      paramVH.mPosition = paramInt;
      if (hasStableIds()) {
        paramVH.mItemId = getItemId(paramInt);
      }
      paramVH.setFlags(1, 519);
      TraceCompat.beginSection("RV OnBindView");
      onBindViewHolder(paramVH, paramInt, paramVH.getUnmodifiedPayloads());
      paramVH.clearPayload();
      paramVH = paramVH.itemView.getLayoutParams();
      if ((paramVH instanceof RecyclerView.LayoutParams)) {
        ((RecyclerView.LayoutParams)paramVH).e = true;
      }
      TraceCompat.endSection();
    }
    
    public final VH createViewHolder(ViewGroup paramViewGroup, int paramInt)
    {
      TraceCompat.beginSection("RV CreateView");
      paramViewGroup = onCreateViewHolder(paramViewGroup, paramInt);
      paramViewGroup.mItemViewType = paramInt;
      TraceCompat.endSection();
      return paramViewGroup;
    }
    
    public abstract int getItemCount();
    
    public long getItemId(int paramInt)
    {
      return -1L;
    }
    
    public int getItemViewType(int paramInt)
    {
      return 0;
    }
    
    public final boolean hasObservers()
    {
      return this.mObservable.hasObservers();
    }
    
    public final boolean hasStableIds()
    {
      return this.mHasStableIds;
    }
    
    public final void notifyDataSetChanged()
    {
      this.mObservable.notifyChanged();
    }
    
    public final void notifyItemChanged(int paramInt)
    {
      this.mObservable.notifyItemRangeChanged(paramInt, 1);
    }
    
    public final void notifyItemChanged(int paramInt, Object paramObject)
    {
      this.mObservable.notifyItemRangeChanged(paramInt, 1, paramObject);
    }
    
    public final void notifyItemInserted(int paramInt)
    {
      this.mObservable.notifyItemRangeInserted(paramInt, 1);
    }
    
    public final void notifyItemMoved(int paramInt1, int paramInt2)
    {
      this.mObservable.notifyItemMoved(paramInt1, paramInt2);
    }
    
    public final void notifyItemRangeChanged(int paramInt1, int paramInt2)
    {
      this.mObservable.notifyItemRangeChanged(paramInt1, paramInt2);
    }
    
    public final void notifyItemRangeChanged(int paramInt1, int paramInt2, Object paramObject)
    {
      this.mObservable.notifyItemRangeChanged(paramInt1, paramInt2, paramObject);
    }
    
    public final void notifyItemRangeInserted(int paramInt1, int paramInt2)
    {
      this.mObservable.notifyItemRangeInserted(paramInt1, paramInt2);
    }
    
    public final void notifyItemRangeRemoved(int paramInt1, int paramInt2)
    {
      this.mObservable.notifyItemRangeRemoved(paramInt1, paramInt2);
    }
    
    public final void notifyItemRemoved(int paramInt)
    {
      this.mObservable.notifyItemRangeRemoved(paramInt, 1);
    }
    
    public void onAttachedToRecyclerView(RecyclerView paramRecyclerView) {}
    
    public abstract void onBindViewHolder(VH paramVH, int paramInt);
    
    public void onBindViewHolder(VH paramVH, int paramInt, List<Object> paramList)
    {
      onBindViewHolder(paramVH, paramInt);
    }
    
    public abstract VH onCreateViewHolder(ViewGroup paramViewGroup, int paramInt);
    
    public void onDetachedFromRecyclerView(RecyclerView paramRecyclerView) {}
    
    public boolean onFailedToRecycleView(VH paramVH)
    {
      return false;
    }
    
    public void onViewAttachedToWindow(VH paramVH) {}
    
    public void onViewDetachedFromWindow(VH paramVH) {}
    
    public void onViewRecycled(VH paramVH) {}
    
    public void registerAdapterDataObserver(RecyclerView.c paramc)
    {
      this.mObservable.registerObserver(paramc);
    }
    
    public void setHasStableIds(boolean paramBoolean)
    {
      if (hasObservers()) {
        throw new IllegalStateException("Cannot change whether this adapter has stable IDs while the adapter has registered observers.");
      }
      this.mHasStableIds = paramBoolean;
    }
    
    public void unregisterAdapterDataObserver(RecyclerView.c paramc)
    {
      this.mObservable.unregisterObserver(paramc);
    }
  }
  
  static class b
    extends Observable<RecyclerView.c>
  {
    public boolean hasObservers()
    {
      return !this.mObservers.isEmpty();
    }
    
    public void notifyChanged()
    {
      int i = this.mObservers.size() - 1;
      while (i >= 0)
      {
        ((RecyclerView.c)this.mObservers.get(i)).onChanged();
        i -= 1;
      }
    }
    
    public void notifyItemMoved(int paramInt1, int paramInt2)
    {
      int i = this.mObservers.size() - 1;
      while (i >= 0)
      {
        ((RecyclerView.c)this.mObservers.get(i)).onItemRangeMoved(paramInt1, paramInt2, 1);
        i -= 1;
      }
    }
    
    public void notifyItemRangeChanged(int paramInt1, int paramInt2)
    {
      notifyItemRangeChanged(paramInt1, paramInt2, null);
    }
    
    public void notifyItemRangeChanged(int paramInt1, int paramInt2, Object paramObject)
    {
      int i = this.mObservers.size() - 1;
      while (i >= 0)
      {
        ((RecyclerView.c)this.mObservers.get(i)).onItemRangeChanged(paramInt1, paramInt2, paramObject);
        i -= 1;
      }
    }
    
    public void notifyItemRangeInserted(int paramInt1, int paramInt2)
    {
      int i = this.mObservers.size() - 1;
      while (i >= 0)
      {
        ((RecyclerView.c)this.mObservers.get(i)).onItemRangeInserted(paramInt1, paramInt2);
        i -= 1;
      }
    }
    
    public void notifyItemRangeRemoved(int paramInt1, int paramInt2)
    {
      int i = this.mObservers.size() - 1;
      while (i >= 0)
      {
        ((RecyclerView.c)this.mObservers.get(i)).onItemRangeRemoved(paramInt1, paramInt2);
        i -= 1;
      }
    }
  }
  
  public static abstract class c
  {
    public void onChanged() {}
    
    public void onItemRangeChanged(int paramInt1, int paramInt2) {}
    
    public void onItemRangeChanged(int paramInt1, int paramInt2, Object paramObject)
    {
      onItemRangeChanged(paramInt1, paramInt2);
    }
    
    public void onItemRangeInserted(int paramInt1, int paramInt2) {}
    
    public void onItemRangeMoved(int paramInt1, int paramInt2, int paramInt3) {}
    
    public void onItemRangeRemoved(int paramInt1, int paramInt2) {}
  }
  
  public static abstract interface d
  {
    public abstract int onGetChildDrawingOrder(int paramInt1, int paramInt2);
  }
  
  public static abstract class e
  {
    private b a = null;
    private ArrayList<a> b = new ArrayList();
    private long c = 120L;
    private long d = 120L;
    private long e = 250L;
    private long f = 250L;
    
    static int b(RecyclerView.u paramu)
    {
      int j = RecyclerView.u.access$1600(paramu) & 0xE;
      int i;
      if (paramu.isInvalid()) {
        i = 4;
      }
      int k;
      int m;
      do
      {
        do
        {
          do
          {
            do
            {
              return i;
              i = j;
            } while ((j & 0x4) != 0);
            k = paramu.getOldPosition();
            m = paramu.getAdapterPosition();
            i = j;
          } while (k == -1);
          i = j;
        } while (m == -1);
        i = j;
      } while (k == m);
      return j | 0x800;
    }
    
    void a(b paramb)
    {
      this.a = paramb;
    }
    
    public abstract boolean animateAppearance(RecyclerView.u paramu, c paramc1, c paramc2);
    
    public abstract boolean animateChange(RecyclerView.u paramu1, RecyclerView.u paramu2, c paramc1, c paramc2);
    
    public abstract boolean animateDisappearance(RecyclerView.u paramu, c paramc1, c paramc2);
    
    public abstract boolean animatePersistence(RecyclerView.u paramu, c paramc1, c paramc2);
    
    public boolean canReuseUpdatedViewHolder(RecyclerView.u paramu)
    {
      return true;
    }
    
    public boolean canReuseUpdatedViewHolder(RecyclerView.u paramu, List<Object> paramList)
    {
      return canReuseUpdatedViewHolder(paramu);
    }
    
    public final void dispatchAnimationFinished(RecyclerView.u paramu)
    {
      onAnimationFinished(paramu);
      if (this.a != null) {
        this.a.onAnimationFinished(paramu);
      }
    }
    
    public final void dispatchAnimationStarted(RecyclerView.u paramu)
    {
      onAnimationStarted(paramu);
    }
    
    public final void dispatchAnimationsFinished()
    {
      int j = this.b.size();
      int i = 0;
      while (i < j)
      {
        ((a)this.b.get(i)).onAnimationsFinished();
        i += 1;
      }
      this.b.clear();
    }
    
    public abstract void endAnimation(RecyclerView.u paramu);
    
    public abstract void endAnimations();
    
    public long getAddDuration()
    {
      return this.c;
    }
    
    public long getChangeDuration()
    {
      return this.f;
    }
    
    public long getMoveDuration()
    {
      return this.e;
    }
    
    public long getRemoveDuration()
    {
      return this.d;
    }
    
    public abstract boolean isRunning();
    
    public final boolean isRunning(a parama)
    {
      boolean bool = isRunning();
      if (parama != null)
      {
        if (!bool) {
          parama.onAnimationsFinished();
        }
      }
      else {
        return bool;
      }
      this.b.add(parama);
      return bool;
    }
    
    public c obtainHolderInfo()
    {
      return new c();
    }
    
    public void onAnimationFinished(RecyclerView.u paramu) {}
    
    public void onAnimationStarted(RecyclerView.u paramu) {}
    
    public c recordPostLayoutInformation(RecyclerView.r paramr, RecyclerView.u paramu)
    {
      return obtainHolderInfo().setFrom(paramu);
    }
    
    public c recordPreLayoutInformation(RecyclerView.r paramr, RecyclerView.u paramu, int paramInt, List<Object> paramList)
    {
      return obtainHolderInfo().setFrom(paramu);
    }
    
    public abstract void runPendingAnimations();
    
    public void setAddDuration(long paramLong)
    {
      this.c = paramLong;
    }
    
    public void setChangeDuration(long paramLong)
    {
      this.f = paramLong;
    }
    
    public void setMoveDuration(long paramLong)
    {
      this.e = paramLong;
    }
    
    public void setRemoveDuration(long paramLong)
    {
      this.d = paramLong;
    }
    
    public static abstract interface a
    {
      public abstract void onAnimationsFinished();
    }
    
    static abstract interface b
    {
      public abstract void onAnimationFinished(RecyclerView.u paramu);
    }
    
    public static class c
    {
      public int a;
      public int b;
      public int c;
      public int d;
      
      public c setFrom(RecyclerView.u paramu)
      {
        return setFrom(paramu, 0);
      }
      
      public c setFrom(RecyclerView.u paramu, int paramInt)
      {
        paramu = paramu.itemView;
        this.a = paramu.getLeft();
        this.b = paramu.getTop();
        this.c = paramu.getRight();
        this.d = paramu.getBottom();
        return this;
      }
    }
  }
  
  private class f
    implements RecyclerView.e.b
  {
    f() {}
    
    public void onAnimationFinished(RecyclerView.u paramu)
    {
      paramu.setIsRecyclable(true);
      if ((paramu.mShadowedHolder != null) && (paramu.mShadowingHolder == null)) {
        paramu.mShadowedHolder = null;
      }
      paramu.mShadowingHolder = null;
      if ((!RecyclerView.u.access$1500(paramu)) && (!RecyclerView.this.removeAnimatingView(paramu.itemView)) && (paramu.isTmpDetached())) {
        RecyclerView.this.removeDetachedView(paramu.itemView, false);
      }
    }
  }
  
  public static abstract class g
  {
    @Deprecated
    public void getItemOffsets(Rect paramRect, int paramInt, RecyclerView paramRecyclerView)
    {
      paramRect.set(0, 0, 0, 0);
    }
    
    public void getItemOffsets(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.r paramr)
    {
      getItemOffsets(paramRect, ((RecyclerView.LayoutParams)paramView.getLayoutParams()).getViewLayoutPosition(), paramRecyclerView);
    }
    
    @Deprecated
    public void onDraw(Canvas paramCanvas, RecyclerView paramRecyclerView) {}
    
    public void onDraw(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.r paramr)
    {
      onDraw(paramCanvas, paramRecyclerView);
    }
    
    @Deprecated
    public void onDrawOver(Canvas paramCanvas, RecyclerView paramRecyclerView) {}
    
    public void onDrawOver(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.r paramr)
    {
      onDrawOver(paramCanvas, paramRecyclerView);
    }
  }
  
  public static abstract class h
  {
    private final az.b a = new az.b()
    {
      public View getChildAt(int paramAnonymousInt)
      {
        return RecyclerView.h.this.getChildAt(paramAnonymousInt);
      }
      
      public int getChildCount()
      {
        return RecyclerView.h.this.getChildCount();
      }
      
      public int getChildEnd(View paramAnonymousView)
      {
        RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramAnonymousView.getLayoutParams();
        int i = RecyclerView.h.this.getDecoratedRight(paramAnonymousView);
        return localLayoutParams.rightMargin + i;
      }
      
      public int getChildStart(View paramAnonymousView)
      {
        RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramAnonymousView.getLayoutParams();
        return RecyclerView.h.this.getDecoratedLeft(paramAnonymousView) - localLayoutParams.leftMargin;
      }
      
      public View getParent()
      {
        return RecyclerView.h.this.q;
      }
      
      public int getParentEnd()
      {
        return RecyclerView.h.this.getWidth() - RecyclerView.h.this.getPaddingRight();
      }
      
      public int getParentStart()
      {
        return RecyclerView.h.this.getPaddingLeft();
      }
    };
    private final az.b b = new az.b()
    {
      public View getChildAt(int paramAnonymousInt)
      {
        return RecyclerView.h.this.getChildAt(paramAnonymousInt);
      }
      
      public int getChildCount()
      {
        return RecyclerView.h.this.getChildCount();
      }
      
      public int getChildEnd(View paramAnonymousView)
      {
        RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramAnonymousView.getLayoutParams();
        int i = RecyclerView.h.this.getDecoratedBottom(paramAnonymousView);
        return localLayoutParams.bottomMargin + i;
      }
      
      public int getChildStart(View paramAnonymousView)
      {
        RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramAnonymousView.getLayoutParams();
        return RecyclerView.h.this.getDecoratedTop(paramAnonymousView) - localLayoutParams.topMargin;
      }
      
      public View getParent()
      {
        return RecyclerView.h.this.q;
      }
      
      public int getParentEnd()
      {
        return RecyclerView.h.this.getHeight() - RecyclerView.h.this.getPaddingBottom();
      }
      
      public int getParentStart()
      {
        return RecyclerView.h.this.getPaddingTop();
      }
    };
    private boolean c = true;
    private boolean d = true;
    private int e;
    private int f;
    private int g;
    private int h;
    s p;
    RecyclerView q;
    az r = new az(this.a);
    az s = new az(this.b);
    RecyclerView.q t;
    boolean u = false;
    boolean v = false;
    boolean w = false;
    int x;
    boolean y;
    
    private void a(int paramInt, View paramView)
    {
      this.p.e(paramInt);
    }
    
    private void a(RecyclerView.n paramn, int paramInt, View paramView)
    {
      RecyclerView.u localu = RecyclerView.getChildViewHolderInt(paramView);
      if (localu.shouldIgnore()) {
        return;
      }
      if ((localu.isInvalid()) && (!localu.isRemoved()) && (!this.q.mAdapter.hasStableIds()))
      {
        removeViewAt(paramInt);
        paramn.b(localu);
        return;
      }
      detachViewAt(paramInt);
      paramn.b(paramView);
      this.q.mViewInfoStore.onViewDetached(localu);
    }
    
    private void a(RecyclerView.q paramq)
    {
      if (this.t == paramq) {
        this.t = null;
      }
    }
    
    private void a(View paramView, int paramInt, boolean paramBoolean)
    {
      RecyclerView.u localu = RecyclerView.getChildViewHolderInt(paramView);
      RecyclerView.LayoutParams localLayoutParams;
      if ((paramBoolean) || (localu.isRemoved()))
      {
        this.q.mViewInfoStore.e(localu);
        localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
        if ((!localu.wasReturnedFromScrap()) && (!localu.isScrap())) {
          break label128;
        }
        if (!localu.isScrap()) {
          break label120;
        }
        localu.unScrap();
        label68:
        this.p.a(paramView, paramInt, paramView.getLayoutParams(), false);
      }
      for (;;)
      {
        if (localLayoutParams.f)
        {
          localu.itemView.invalidate();
          localLayoutParams.f = false;
        }
        return;
        this.q.mViewInfoStore.f(localu);
        break;
        label120:
        localu.clearReturnedFromScrapFlag();
        break label68;
        label128:
        if (paramView.getParent() == this.q)
        {
          int j = this.p.b(paramView);
          int i = paramInt;
          if (paramInt == -1) {
            i = this.p.b();
          }
          if (j == -1) {
            throw new IllegalStateException("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:" + this.q.indexOfChild(paramView) + this.q.exceptionLabel());
          }
          if (j != i) {
            this.q.mLayout.moveView(j, i);
          }
        }
        else
        {
          this.p.a(paramView, paramInt, false);
          localLayoutParams.e = true;
          if ((this.t != null) && (this.t.isRunning())) {
            this.t.a(paramView);
          }
        }
      }
    }
    
    private static boolean a(int paramInt1, int paramInt2, int paramInt3)
    {
      boolean bool2 = true;
      int i = View.MeasureSpec.getMode(paramInt2);
      paramInt2 = View.MeasureSpec.getSize(paramInt2);
      boolean bool1;
      if ((paramInt3 > 0) && (paramInt1 != paramInt3)) {
        bool1 = false;
      }
      do
      {
        do
        {
          return bool1;
          bool1 = bool2;
          switch (i)
          {
          case 0: 
          default: 
            return false;
          case -2147483648: 
            bool1 = bool2;
          }
        } while (paramInt2 >= paramInt1);
        return false;
        bool1 = bool2;
      } while (paramInt2 == paramInt1);
      return false;
    }
    
    private boolean a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      paramRecyclerView = paramRecyclerView.getFocusedChild();
      if (paramRecyclerView == null) {}
      int i;
      int j;
      int k;
      int m;
      int n;
      int i1;
      Rect localRect;
      do
      {
        return false;
        i = getPaddingLeft();
        j = getPaddingTop();
        k = getWidth();
        m = getPaddingRight();
        n = getHeight();
        i1 = getPaddingBottom();
        localRect = this.q.mTempRect;
        getDecoratedBoundsWithMargins(paramRecyclerView, localRect);
      } while ((localRect.left - paramInt1 >= k - m) || (localRect.right - paramInt1 <= i) || (localRect.top - paramInt2 >= n - i1) || (localRect.bottom - paramInt2 <= j));
      return true;
    }
    
    private int[] a(RecyclerView paramRecyclerView, View paramView, Rect paramRect, boolean paramBoolean)
    {
      int i2 = getPaddingLeft();
      int m = getPaddingTop();
      int i3 = getWidth() - getPaddingRight();
      int i1 = getHeight();
      int i6 = getPaddingBottom();
      int i4 = paramView.getLeft() + paramRect.left - paramView.getScrollX();
      int n = paramView.getTop() + paramRect.top - paramView.getScrollY();
      int i5 = i4 + paramRect.width();
      int i7 = paramRect.height();
      int i = Math.min(0, i4 - i2);
      int j = Math.min(0, n - m);
      int k = Math.max(0, i5 - i3);
      i1 = Math.max(0, n + i7 - (i1 - i6));
      if (getLayoutDirection() == 1) {
        if (k != 0)
        {
          i = k;
          if (j == 0) {
            break label206;
          }
        }
      }
      for (;;)
      {
        return new int[] { i, j };
        i = Math.max(i, i5 - i3);
        break;
        if (i != 0) {
          break;
        }
        for (;;)
        {
          i = Math.min(i4 - i2, k);
        }
        label206:
        j = Math.min(n - m, i1);
      }
    }
    
    public static int chooseSize(int paramInt1, int paramInt2, int paramInt3)
    {
      int j = View.MeasureSpec.getMode(paramInt1);
      int i = View.MeasureSpec.getSize(paramInt1);
      paramInt1 = i;
      switch (j)
      {
      default: 
        paramInt1 = Math.max(paramInt2, paramInt3);
      case 1073741824: 
        return paramInt1;
      }
      return Math.min(i, Math.max(paramInt2, paramInt3));
    }
    
    public static int getChildMeasureSpec(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
    {
      int j = 0;
      int k = 0;
      int i = Math.max(0, paramInt1 - paramInt3);
      if (paramBoolean) {
        if (paramInt4 >= 0)
        {
          paramInt1 = 1073741824;
          paramInt3 = paramInt4;
        }
      }
      for (;;)
      {
        return View.MeasureSpec.makeMeasureSpec(paramInt3, paramInt1);
        if (paramInt4 == -1)
        {
          switch (paramInt2)
          {
          default: 
            paramInt2 = 0;
            paramInt1 = j;
          }
          for (;;)
          {
            paramInt3 = paramInt1;
            paramInt1 = paramInt2;
            break;
            paramInt1 = i;
            continue;
            paramInt2 = 0;
            paramInt1 = j;
          }
        }
        if (paramInt4 == -2)
        {
          paramInt3 = 0;
          paramInt1 = k;
          continue;
          if (paramInt4 >= 0)
          {
            paramInt1 = 1073741824;
            paramInt3 = paramInt4;
            continue;
          }
          if (paramInt4 == -1)
          {
            paramInt1 = paramInt2;
            paramInt3 = i;
            continue;
          }
          if (paramInt4 == -2)
          {
            if (paramInt2 != Integer.MIN_VALUE)
            {
              paramInt1 = k;
              paramInt3 = i;
              if (paramInt2 != 1073741824) {
                continue;
              }
            }
            paramInt1 = Integer.MIN_VALUE;
            paramInt3 = i;
            continue;
          }
        }
        paramInt3 = 0;
        paramInt1 = k;
      }
    }
    
    @Deprecated
    public static int getChildMeasureSpec(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
    {
      int j = 1073741824;
      int i = Math.max(0, paramInt1 - paramInt2);
      if (paramBoolean) {
        if (paramInt3 >= 0)
        {
          paramInt1 = paramInt3;
          paramInt2 = j;
        }
      }
      for (;;)
      {
        return View.MeasureSpec.makeMeasureSpec(paramInt1, paramInt2);
        paramInt2 = 0;
        paramInt1 = 0;
        continue;
        paramInt2 = j;
        paramInt1 = paramInt3;
        if (paramInt3 < 0) {
          if (paramInt3 == -1)
          {
            paramInt1 = i;
            paramInt2 = j;
          }
          else if (paramInt3 == -2)
          {
            paramInt2 = Integer.MIN_VALUE;
            paramInt1 = i;
          }
          else
          {
            paramInt2 = 0;
            paramInt1 = 0;
          }
        }
      }
    }
    
    public static b getProperties(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
    {
      b localb = new b();
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.RecyclerView, paramInt1, paramInt2);
      localb.a = paramContext.getInt(R.styleable.RecyclerView_android_orientation, 1);
      localb.b = paramContext.getInt(R.styleable.RecyclerView_spanCount, 1);
      localb.c = paramContext.getBoolean(R.styleable.RecyclerView_reverseLayout, false);
      localb.d = paramContext.getBoolean(R.styleable.RecyclerView_stackFromEnd, false);
      paramContext.recycle();
      return localb;
    }
    
    void a(AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
    {
      onInitializeAccessibilityNodeInfo(this.q.mRecycler, this.q.mState, paramAccessibilityNodeInfoCompat);
    }
    
    void a(RecyclerView.n paramn)
    {
      int j = paramn.c();
      int i = j - 1;
      if (i >= 0)
      {
        View localView = paramn.b(i);
        RecyclerView.u localu = RecyclerView.getChildViewHolderInt(localView);
        if (localu.shouldIgnore()) {}
        for (;;)
        {
          i -= 1;
          break;
          localu.setIsRecyclable(false);
          if (localu.isTmpDetached()) {
            this.q.removeDetachedView(localView, false);
          }
          if (this.q.mItemAnimator != null) {
            this.q.mItemAnimator.endAnimation(localu);
          }
          localu.setIsRecyclable(true);
          paramn.a(localView);
        }
      }
      paramn.d();
      if (j > 0) {
        this.q.invalidate();
      }
    }
    
    void a(RecyclerView paramRecyclerView)
    {
      if (paramRecyclerView == null)
      {
        this.q = null;
        this.p = null;
        this.g = 0;
      }
      for (this.h = 0;; this.h = paramRecyclerView.getHeight())
      {
        this.e = 1073741824;
        this.f = 1073741824;
        return;
        this.q = paramRecyclerView;
        this.p = paramRecyclerView.mChildHelper;
        this.g = paramRecyclerView.getWidth();
      }
    }
    
    void a(RecyclerView paramRecyclerView, RecyclerView.n paramn)
    {
      this.v = false;
      onDetachedFromWindow(paramRecyclerView, paramn);
    }
    
    void a(View paramView, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
    {
      RecyclerView.u localu = RecyclerView.getChildViewHolderInt(paramView);
      if ((localu != null) && (!localu.isRemoved()) && (!this.p.c(localu.itemView))) {
        onInitializeAccessibilityNodeInfoForItem(this.q.mRecycler, this.q.mState, paramView, paramAccessibilityNodeInfoCompat);
      }
    }
    
    boolean a(int paramInt, Bundle paramBundle)
    {
      return performAccessibilityAction(this.q.mRecycler, this.q.mState, paramInt, paramBundle);
    }
    
    boolean a(View paramView, int paramInt1, int paramInt2, RecyclerView.LayoutParams paramLayoutParams)
    {
      return (!this.c) || (!a(paramView.getMeasuredWidth(), paramInt1, paramLayoutParams.width)) || (!a(paramView.getMeasuredHeight(), paramInt2, paramLayoutParams.height));
    }
    
    boolean a(View paramView, int paramInt, Bundle paramBundle)
    {
      return performAccessibilityActionForItem(this.q.mRecycler, this.q.mState, paramView, paramInt, paramBundle);
    }
    
    public void addDisappearingView(View paramView)
    {
      addDisappearingView(paramView, -1);
    }
    
    public void addDisappearingView(View paramView, int paramInt)
    {
      a(paramView, paramInt, true);
    }
    
    public void addView(View paramView)
    {
      addView(paramView, -1);
    }
    
    public void addView(View paramView, int paramInt)
    {
      a(paramView, paramInt, false);
    }
    
    public void assertInLayoutOrScroll(String paramString)
    {
      if (this.q != null) {
        this.q.assertInLayoutOrScroll(paramString);
      }
    }
    
    public void assertNotInLayoutOrScroll(String paramString)
    {
      if (this.q != null) {
        this.q.assertNotInLayoutOrScroll(paramString);
      }
    }
    
    public void attachView(View paramView)
    {
      attachView(paramView, -1);
    }
    
    public void attachView(View paramView, int paramInt)
    {
      attachView(paramView, paramInt, (RecyclerView.LayoutParams)paramView.getLayoutParams());
    }
    
    public void attachView(View paramView, int paramInt, RecyclerView.LayoutParams paramLayoutParams)
    {
      RecyclerView.u localu = RecyclerView.getChildViewHolderInt(paramView);
      if (localu.isRemoved()) {
        this.q.mViewInfoStore.e(localu);
      }
      for (;;)
      {
        this.p.a(paramView, paramInt, paramLayoutParams, localu.isRemoved());
        return;
        this.q.mViewInfoStore.f(localu);
      }
    }
    
    void b(RecyclerView paramRecyclerView)
    {
      this.v = true;
      onAttachedToWindow(paramRecyclerView);
    }
    
    boolean b(View paramView, int paramInt1, int paramInt2, RecyclerView.LayoutParams paramLayoutParams)
    {
      return (paramView.isLayoutRequested()) || (!this.c) || (!a(paramView.getWidth(), paramInt1, paramLayoutParams.width)) || (!a(paramView.getHeight(), paramInt2, paramLayoutParams.height));
    }
    
    void c(int paramInt1, int paramInt2)
    {
      this.g = View.MeasureSpec.getSize(paramInt1);
      this.e = View.MeasureSpec.getMode(paramInt1);
      if ((this.e == 0) && (!RecyclerView.ALLOW_SIZE_IN_UNSPECIFIED_SPEC)) {
        this.g = 0;
      }
      this.h = View.MeasureSpec.getSize(paramInt2);
      this.f = View.MeasureSpec.getMode(paramInt2);
      if ((this.f == 0) && (!RecyclerView.ALLOW_SIZE_IN_UNSPECIFIED_SPEC)) {
        this.h = 0;
      }
    }
    
    void c(RecyclerView paramRecyclerView)
    {
      c(View.MeasureSpec.makeMeasureSpec(paramRecyclerView.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(paramRecyclerView.getHeight(), 1073741824));
    }
    
    public void calculateItemDecorationsForChild(View paramView, Rect paramRect)
    {
      if (this.q == null)
      {
        paramRect.set(0, 0, 0, 0);
        return;
      }
      paramRect.set(this.q.getItemDecorInsetsForChild(paramView));
    }
    
    public boolean canScrollHorizontally()
    {
      return false;
    }
    
    public boolean canScrollVertically()
    {
      return false;
    }
    
    public boolean checkLayoutParams(RecyclerView.LayoutParams paramLayoutParams)
    {
      return paramLayoutParams != null;
    }
    
    public void collectAdjacentPrefetchPositions(int paramInt1, int paramInt2, RecyclerView.r paramr, a parama) {}
    
    public void collectInitialPrefetchPositions(int paramInt, a parama) {}
    
    public int computeHorizontalScrollExtent(RecyclerView.r paramr)
    {
      return 0;
    }
    
    public int computeHorizontalScrollOffset(RecyclerView.r paramr)
    {
      return 0;
    }
    
    public int computeHorizontalScrollRange(RecyclerView.r paramr)
    {
      return 0;
    }
    
    public int computeVerticalScrollExtent(RecyclerView.r paramr)
    {
      return 0;
    }
    
    public int computeVerticalScrollOffset(RecyclerView.r paramr)
    {
      return 0;
    }
    
    public int computeVerticalScrollRange(RecyclerView.r paramr)
    {
      return 0;
    }
    
    void d(int paramInt1, int paramInt2)
    {
      int k = Integer.MAX_VALUE;
      int j = Integer.MIN_VALUE;
      int i5 = getChildCount();
      if (i5 == 0)
      {
        this.q.defaultOnMeasure(paramInt1, paramInt2);
        return;
      }
      int i = 0;
      int n = Integer.MIN_VALUE;
      int i3 = Integer.MAX_VALUE;
      while (i < i5)
      {
        View localView = getChildAt(i);
        Rect localRect = this.q.mTempRect;
        getDecoratedBoundsWithMargins(localView, localRect);
        int m = i3;
        if (localRect.left < i3) {
          m = localRect.left;
        }
        int i1 = n;
        if (localRect.right > n) {
          i1 = localRect.right;
        }
        int i2 = k;
        if (localRect.top < k) {
          i2 = localRect.top;
        }
        int i4 = j;
        if (localRect.bottom > j) {
          i4 = localRect.bottom;
        }
        i += 1;
        i3 = m;
        n = i1;
        k = i2;
        j = i4;
      }
      this.q.mTempRect.set(i3, k, n, j);
      setMeasuredDimension(this.q.mTempRect, paramInt1, paramInt2);
    }
    
    public void detachAndScrapAttachedViews(RecyclerView.n paramn)
    {
      int i = getChildCount() - 1;
      while (i >= 0)
      {
        a(paramn, i, getChildAt(i));
        i -= 1;
      }
    }
    
    public void detachAndScrapView(View paramView, RecyclerView.n paramn)
    {
      a(paramn, this.p.b(paramView), paramView);
    }
    
    public void detachAndScrapViewAt(int paramInt, RecyclerView.n paramn)
    {
      a(paramn, paramInt, getChildAt(paramInt));
    }
    
    public void detachView(View paramView)
    {
      int i = this.p.b(paramView);
      if (i >= 0) {
        a(i, paramView);
      }
    }
    
    public void detachViewAt(int paramInt)
    {
      a(paramInt, getChildAt(paramInt));
    }
    
    boolean e()
    {
      return false;
    }
    
    public void endAnimation(View paramView)
    {
      if (this.q.mItemAnimator != null) {
        this.q.mItemAnimator.endAnimation(RecyclerView.getChildViewHolderInt(paramView));
      }
    }
    
    void f()
    {
      if (this.t != null) {
        this.t.e();
      }
    }
    
    public View findContainingItemView(View paramView)
    {
      if (this.q == null) {}
      do
      {
        return null;
        paramView = this.q.findContainingItemView(paramView);
      } while ((paramView == null) || (this.p.c(paramView)));
      return paramView;
    }
    
    public View findViewByPosition(int paramInt)
    {
      int j = getChildCount();
      int i = 0;
      if (i < j)
      {
        View localView = getChildAt(i);
        RecyclerView.u localu = RecyclerView.getChildViewHolderInt(localView);
        if (localu == null) {}
        while ((localu.getLayoutPosition() != paramInt) || (localu.shouldIgnore()) || ((!this.q.mState.isPreLayout()) && (localu.isRemoved())))
        {
          i += 1;
          break;
        }
        return localView;
      }
      return null;
    }
    
    boolean g()
    {
      boolean bool2 = false;
      int j = getChildCount();
      int i = 0;
      for (;;)
      {
        boolean bool1 = bool2;
        if (i < j)
        {
          ViewGroup.LayoutParams localLayoutParams = getChildAt(i).getLayoutParams();
          if ((localLayoutParams.width < 0) && (localLayoutParams.height < 0)) {
            bool1 = true;
          }
        }
        else
        {
          return bool1;
        }
        i += 1;
      }
    }
    
    public abstract RecyclerView.LayoutParams generateDefaultLayoutParams();
    
    public RecyclerView.LayoutParams generateLayoutParams(Context paramContext, AttributeSet paramAttributeSet)
    {
      return new RecyclerView.LayoutParams(paramContext, paramAttributeSet);
    }
    
    public RecyclerView.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
    {
      if ((paramLayoutParams instanceof RecyclerView.LayoutParams)) {
        return new RecyclerView.LayoutParams((RecyclerView.LayoutParams)paramLayoutParams);
      }
      if ((paramLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
        return new RecyclerView.LayoutParams((ViewGroup.MarginLayoutParams)paramLayoutParams);
      }
      return new RecyclerView.LayoutParams(paramLayoutParams);
    }
    
    public int getBaseline()
    {
      return -1;
    }
    
    public int getBottomDecorationHeight(View paramView)
    {
      return ((RecyclerView.LayoutParams)paramView.getLayoutParams()).d.bottom;
    }
    
    public View getChildAt(int paramInt)
    {
      if (this.p != null) {
        return this.p.b(paramInt);
      }
      return null;
    }
    
    public int getChildCount()
    {
      if (this.p != null) {
        return this.p.b();
      }
      return 0;
    }
    
    public boolean getClipToPadding()
    {
      return (this.q != null) && (this.q.mClipToPadding);
    }
    
    public int getColumnCountForAccessibility(RecyclerView.n paramn, RecyclerView.r paramr)
    {
      if ((this.q == null) || (this.q.mAdapter == null)) {}
      while (!canScrollHorizontally()) {
        return 1;
      }
      return this.q.mAdapter.getItemCount();
    }
    
    public int getDecoratedBottom(View paramView)
    {
      return paramView.getBottom() + getBottomDecorationHeight(paramView);
    }
    
    public void getDecoratedBoundsWithMargins(View paramView, Rect paramRect)
    {
      RecyclerView.getDecoratedBoundsWithMarginsInt(paramView, paramRect);
    }
    
    public int getDecoratedLeft(View paramView)
    {
      return paramView.getLeft() - getLeftDecorationWidth(paramView);
    }
    
    public int getDecoratedMeasuredHeight(View paramView)
    {
      Rect localRect = ((RecyclerView.LayoutParams)paramView.getLayoutParams()).d;
      int i = paramView.getMeasuredHeight();
      int j = localRect.top;
      return localRect.bottom + (i + j);
    }
    
    public int getDecoratedMeasuredWidth(View paramView)
    {
      Rect localRect = ((RecyclerView.LayoutParams)paramView.getLayoutParams()).d;
      int i = paramView.getMeasuredWidth();
      int j = localRect.left;
      return localRect.right + (i + j);
    }
    
    public int getDecoratedRight(View paramView)
    {
      return paramView.getRight() + getRightDecorationWidth(paramView);
    }
    
    public int getDecoratedTop(View paramView)
    {
      return paramView.getTop() - getTopDecorationHeight(paramView);
    }
    
    public View getFocusedChild()
    {
      if (this.q == null) {}
      View localView;
      do
      {
        return null;
        localView = this.q.getFocusedChild();
      } while ((localView == null) || (this.p.c(localView)));
      return localView;
    }
    
    public int getHeight()
    {
      return this.h;
    }
    
    public int getHeightMode()
    {
      return this.f;
    }
    
    public int getItemCount()
    {
      if (this.q != null) {}
      for (RecyclerView.a locala = this.q.getAdapter(); locala != null; locala = null) {
        return locala.getItemCount();
      }
      return 0;
    }
    
    public int getItemViewType(View paramView)
    {
      return RecyclerView.getChildViewHolderInt(paramView).getItemViewType();
    }
    
    public int getLayoutDirection()
    {
      return ViewCompat.getLayoutDirection(this.q);
    }
    
    public int getLeftDecorationWidth(View paramView)
    {
      return ((RecyclerView.LayoutParams)paramView.getLayoutParams()).d.left;
    }
    
    public int getMinimumHeight()
    {
      return ViewCompat.getMinimumHeight(this.q);
    }
    
    public int getMinimumWidth()
    {
      return ViewCompat.getMinimumWidth(this.q);
    }
    
    public int getPaddingBottom()
    {
      if (this.q != null) {
        return this.q.getPaddingBottom();
      }
      return 0;
    }
    
    public int getPaddingEnd()
    {
      if (this.q != null) {
        return ViewCompat.getPaddingEnd(this.q);
      }
      return 0;
    }
    
    public int getPaddingLeft()
    {
      if (this.q != null) {
        return this.q.getPaddingLeft();
      }
      return 0;
    }
    
    public int getPaddingRight()
    {
      if (this.q != null) {
        return this.q.getPaddingRight();
      }
      return 0;
    }
    
    public int getPaddingStart()
    {
      if (this.q != null) {
        return ViewCompat.getPaddingStart(this.q);
      }
      return 0;
    }
    
    public int getPaddingTop()
    {
      if (this.q != null) {
        return this.q.getPaddingTop();
      }
      return 0;
    }
    
    public int getPosition(View paramView)
    {
      return ((RecyclerView.LayoutParams)paramView.getLayoutParams()).getViewLayoutPosition();
    }
    
    public int getRightDecorationWidth(View paramView)
    {
      return ((RecyclerView.LayoutParams)paramView.getLayoutParams()).d.right;
    }
    
    public int getRowCountForAccessibility(RecyclerView.n paramn, RecyclerView.r paramr)
    {
      if ((this.q == null) || (this.q.mAdapter == null)) {}
      while (!canScrollVertically()) {
        return 1;
      }
      return this.q.mAdapter.getItemCount();
    }
    
    public int getSelectionModeForAccessibility(RecyclerView.n paramn, RecyclerView.r paramr)
    {
      return 0;
    }
    
    public int getTopDecorationHeight(View paramView)
    {
      return ((RecyclerView.LayoutParams)paramView.getLayoutParams()).d.top;
    }
    
    public void getTransformedBoundingBox(View paramView, boolean paramBoolean, Rect paramRect)
    {
      Object localObject;
      if (paramBoolean)
      {
        localObject = ((RecyclerView.LayoutParams)paramView.getLayoutParams()).d;
        int i = -((Rect)localObject).left;
        int j = -((Rect)localObject).top;
        int k = paramView.getWidth();
        int m = ((Rect)localObject).right;
        int n = paramView.getHeight();
        paramRect.set(i, j, k + m, ((Rect)localObject).bottom + n);
      }
      for (;;)
      {
        if (this.q != null)
        {
          localObject = paramView.getMatrix();
          if ((localObject != null) && (!((Matrix)localObject).isIdentity()))
          {
            RectF localRectF = this.q.mTempRectF;
            localRectF.set(paramRect);
            ((Matrix)localObject).mapRect(localRectF);
            paramRect.set((int)Math.floor(localRectF.left), (int)Math.floor(localRectF.top), (int)Math.ceil(localRectF.right), (int)Math.ceil(localRectF.bottom));
          }
        }
        paramRect.offset(paramView.getLeft(), paramView.getTop());
        return;
        paramRect.set(0, 0, paramView.getWidth(), paramView.getHeight());
      }
    }
    
    public int getWidth()
    {
      return this.g;
    }
    
    public int getWidthMode()
    {
      return this.e;
    }
    
    public boolean hasFocus()
    {
      return (this.q != null) && (this.q.hasFocus());
    }
    
    public void ignoreView(View paramView)
    {
      if ((paramView.getParent() != this.q) || (this.q.indexOfChild(paramView) == -1)) {
        throw new IllegalArgumentException("View should be fully attached to be ignored" + this.q.exceptionLabel());
      }
      paramView = RecyclerView.getChildViewHolderInt(paramView);
      paramView.addFlags(128);
      this.q.mViewInfoStore.g(paramView);
    }
    
    public boolean isAttachedToWindow()
    {
      return this.v;
    }
    
    public boolean isAutoMeasureEnabled()
    {
      return this.w;
    }
    
    public boolean isFocused()
    {
      return (this.q != null) && (this.q.isFocused());
    }
    
    public final boolean isItemPrefetchEnabled()
    {
      return this.d;
    }
    
    public boolean isLayoutHierarchical(RecyclerView.n paramn, RecyclerView.r paramr)
    {
      return false;
    }
    
    public boolean isMeasurementCacheEnabled()
    {
      return this.c;
    }
    
    public boolean isSmoothScrolling()
    {
      return (this.t != null) && (this.t.isRunning());
    }
    
    public boolean isViewPartiallyVisible(View paramView, boolean paramBoolean1, boolean paramBoolean2)
    {
      boolean bool = true;
      if ((this.r.a(paramView, 24579)) && (this.s.a(paramView, 24579)))
      {
        paramBoolean2 = true;
        if (!paramBoolean1) {
          break label46;
        }
        paramBoolean1 = paramBoolean2;
      }
      label46:
      do
      {
        return paramBoolean1;
        paramBoolean2 = false;
        break;
        paramBoolean1 = bool;
      } while (!paramBoolean2);
      return false;
    }
    
    public void layoutDecorated(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      Rect localRect = ((RecyclerView.LayoutParams)paramView.getLayoutParams()).d;
      paramView.layout(localRect.left + paramInt1, localRect.top + paramInt2, paramInt3 - localRect.right, paramInt4 - localRect.bottom);
    }
    
    public void layoutDecoratedWithMargins(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
      Rect localRect = localLayoutParams.d;
      paramView.layout(localRect.left + paramInt1 + localLayoutParams.leftMargin, localRect.top + paramInt2 + localLayoutParams.topMargin, paramInt3 - localRect.right - localLayoutParams.rightMargin, paramInt4 - localRect.bottom - localLayoutParams.bottomMargin);
    }
    
    public void measureChild(View paramView, int paramInt1, int paramInt2)
    {
      RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
      Rect localRect = this.q.getItemDecorInsetsForChild(paramView);
      int k = localRect.left;
      int m = localRect.right;
      int i = localRect.top;
      int j = localRect.bottom;
      paramInt1 = getChildMeasureSpec(getWidth(), getWidthMode(), k + m + paramInt1 + (getPaddingLeft() + getPaddingRight()), localLayoutParams.width, canScrollHorizontally());
      paramInt2 = getChildMeasureSpec(getHeight(), getHeightMode(), j + i + paramInt2 + (getPaddingTop() + getPaddingBottom()), localLayoutParams.height, canScrollVertically());
      if (b(paramView, paramInt1, paramInt2, localLayoutParams)) {
        paramView.measure(paramInt1, paramInt2);
      }
    }
    
    public void measureChildWithMargins(View paramView, int paramInt1, int paramInt2)
    {
      RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
      Rect localRect = this.q.getItemDecorInsetsForChild(paramView);
      int k = localRect.left;
      int m = localRect.right;
      int i = localRect.top;
      int j = localRect.bottom;
      paramInt1 = getChildMeasureSpec(getWidth(), getWidthMode(), k + m + paramInt1 + (getPaddingLeft() + getPaddingRight() + localLayoutParams.leftMargin + localLayoutParams.rightMargin), localLayoutParams.width, canScrollHorizontally());
      paramInt2 = getChildMeasureSpec(getHeight(), getHeightMode(), j + i + paramInt2 + (getPaddingTop() + getPaddingBottom() + localLayoutParams.topMargin + localLayoutParams.bottomMargin), localLayoutParams.height, canScrollVertically());
      if (b(paramView, paramInt1, paramInt2, localLayoutParams)) {
        paramView.measure(paramInt1, paramInt2);
      }
    }
    
    public void moveView(int paramInt1, int paramInt2)
    {
      View localView = getChildAt(paramInt1);
      if (localView == null) {
        throw new IllegalArgumentException("Cannot move a child from non-existing index:" + paramInt1 + this.q.toString());
      }
      detachViewAt(paramInt1);
      attachView(localView, paramInt2);
    }
    
    public void offsetChildrenHorizontal(int paramInt)
    {
      if (this.q != null) {
        this.q.offsetChildrenHorizontal(paramInt);
      }
    }
    
    public void offsetChildrenVertical(int paramInt)
    {
      if (this.q != null) {
        this.q.offsetChildrenVertical(paramInt);
      }
    }
    
    public void onAdapterChanged(RecyclerView.a parama1, RecyclerView.a parama2) {}
    
    public boolean onAddFocusables(RecyclerView paramRecyclerView, ArrayList<View> paramArrayList, int paramInt1, int paramInt2)
    {
      return false;
    }
    
    public void onAttachedToWindow(RecyclerView paramRecyclerView) {}
    
    @Deprecated
    public void onDetachedFromWindow(RecyclerView paramRecyclerView) {}
    
    public void onDetachedFromWindow(RecyclerView paramRecyclerView, RecyclerView.n paramn)
    {
      onDetachedFromWindow(paramRecyclerView);
    }
    
    public View onFocusSearchFailed(View paramView, int paramInt, RecyclerView.n paramn, RecyclerView.r paramr)
    {
      return null;
    }
    
    public void onInitializeAccessibilityEvent(RecyclerView.n paramn, RecyclerView.r paramr, AccessibilityEvent paramAccessibilityEvent)
    {
      boolean bool2 = true;
      if ((this.q == null) || (paramAccessibilityEvent == null)) {
        return;
      }
      boolean bool1 = bool2;
      if (!this.q.canScrollVertically(1))
      {
        bool1 = bool2;
        if (!this.q.canScrollVertically(-1))
        {
          bool1 = bool2;
          if (!this.q.canScrollHorizontally(-1)) {
            if (!this.q.canScrollHorizontally(1)) {
              break label106;
            }
          }
        }
      }
      label106:
      for (bool1 = bool2;; bool1 = false)
      {
        paramAccessibilityEvent.setScrollable(bool1);
        if (this.q.mAdapter == null) {
          break;
        }
        paramAccessibilityEvent.setItemCount(this.q.mAdapter.getItemCount());
        return;
      }
    }
    
    public void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
    {
      onInitializeAccessibilityEvent(this.q.mRecycler, this.q.mState, paramAccessibilityEvent);
    }
    
    public void onInitializeAccessibilityNodeInfo(RecyclerView.n paramn, RecyclerView.r paramr, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
    {
      if ((this.q.canScrollVertically(-1)) || (this.q.canScrollHorizontally(-1)))
      {
        paramAccessibilityNodeInfoCompat.addAction(8192);
        paramAccessibilityNodeInfoCompat.setScrollable(true);
      }
      if ((this.q.canScrollVertically(1)) || (this.q.canScrollHorizontally(1)))
      {
        paramAccessibilityNodeInfoCompat.addAction(4096);
        paramAccessibilityNodeInfoCompat.setScrollable(true);
      }
      paramAccessibilityNodeInfoCompat.setCollectionInfo(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(getRowCountForAccessibility(paramn, paramr), getColumnCountForAccessibility(paramn, paramr), isLayoutHierarchical(paramn, paramr), getSelectionModeForAccessibility(paramn, paramr)));
    }
    
    public void onInitializeAccessibilityNodeInfoForItem(RecyclerView.n paramn, RecyclerView.r paramr, View paramView, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
    {
      int i;
      if (canScrollVertically())
      {
        i = getPosition(paramView);
        if (!canScrollHorizontally()) {
          break label51;
        }
      }
      label51:
      for (int j = getPosition(paramView);; j = 0)
      {
        paramAccessibilityNodeInfoCompat.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(i, 1, j, 1, false, false));
        return;
        i = 0;
        break;
      }
    }
    
    public View onInterceptFocusSearch(View paramView, int paramInt)
    {
      return null;
    }
    
    public void onItemsAdded(RecyclerView paramRecyclerView, int paramInt1, int paramInt2) {}
    
    public void onItemsChanged(RecyclerView paramRecyclerView) {}
    
    public void onItemsMoved(RecyclerView paramRecyclerView, int paramInt1, int paramInt2, int paramInt3) {}
    
    public void onItemsRemoved(RecyclerView paramRecyclerView, int paramInt1, int paramInt2) {}
    
    public void onItemsUpdated(RecyclerView paramRecyclerView, int paramInt1, int paramInt2) {}
    
    public void onItemsUpdated(RecyclerView paramRecyclerView, int paramInt1, int paramInt2, Object paramObject)
    {
      onItemsUpdated(paramRecyclerView, paramInt1, paramInt2);
    }
    
    public void onLayoutChildren(RecyclerView.n paramn, RecyclerView.r paramr)
    {
      Log.e("RecyclerView", "You must override onLayoutChildren(Recycler recycler, State state) ");
    }
    
    public void onLayoutCompleted(RecyclerView.r paramr) {}
    
    public void onMeasure(RecyclerView.n paramn, RecyclerView.r paramr, int paramInt1, int paramInt2)
    {
      this.q.defaultOnMeasure(paramInt1, paramInt2);
    }
    
    public boolean onRequestChildFocus(RecyclerView paramRecyclerView, RecyclerView.r paramr, View paramView1, View paramView2)
    {
      return onRequestChildFocus(paramRecyclerView, paramView1, paramView2);
    }
    
    @Deprecated
    public boolean onRequestChildFocus(RecyclerView paramRecyclerView, View paramView1, View paramView2)
    {
      return (isSmoothScrolling()) || (paramRecyclerView.isComputingLayout());
    }
    
    public void onRestoreInstanceState(Parcelable paramParcelable) {}
    
    public Parcelable onSaveInstanceState()
    {
      return null;
    }
    
    public void onScrollStateChanged(int paramInt) {}
    
    public boolean performAccessibilityAction(RecyclerView.n paramn, RecyclerView.r paramr, int paramInt, Bundle paramBundle)
    {
      if (this.q == null) {}
      int i;
      do
      {
        return false;
        switch (paramInt)
        {
        default: 
          paramInt = 0;
          i = 0;
        }
      } while ((i == 0) && (paramInt == 0));
      this.q.scrollBy(paramInt, i);
      return true;
      if (this.q.canScrollVertically(-1)) {}
      for (paramInt = -(getHeight() - getPaddingTop() - getPaddingBottom());; paramInt = 0)
      {
        i = paramInt;
        int j;
        if (this.q.canScrollHorizontally(-1))
        {
          j = -(getWidth() - getPaddingLeft() - getPaddingRight());
          i = paramInt;
          paramInt = j;
          break;
          if (!this.q.canScrollVertically(1)) {
            break label207;
          }
        }
        label207:
        for (paramInt = getHeight() - getPaddingTop() - getPaddingBottom();; paramInt = 0)
        {
          i = paramInt;
          if (this.q.canScrollHorizontally(1))
          {
            j = getWidth();
            int k = getPaddingLeft();
            int m = getPaddingRight();
            i = paramInt;
            paramInt = j - k - m;
            break;
          }
          paramInt = 0;
          break;
        }
      }
    }
    
    public boolean performAccessibilityActionForItem(RecyclerView.n paramn, RecyclerView.r paramr, View paramView, int paramInt, Bundle paramBundle)
    {
      return false;
    }
    
    public void postOnAnimation(Runnable paramRunnable)
    {
      if (this.q != null) {
        ViewCompat.postOnAnimation(this.q, paramRunnable);
      }
    }
    
    public void removeAllViews()
    {
      int i = getChildCount() - 1;
      while (i >= 0)
      {
        this.p.a(i);
        i -= 1;
      }
    }
    
    public void removeAndRecycleAllViews(RecyclerView.n paramn)
    {
      int i = getChildCount() - 1;
      while (i >= 0)
      {
        if (!RecyclerView.getChildViewHolderInt(getChildAt(i)).shouldIgnore()) {
          removeAndRecycleViewAt(i, paramn);
        }
        i -= 1;
      }
    }
    
    public void removeAndRecycleView(View paramView, RecyclerView.n paramn)
    {
      removeView(paramView);
      paramn.recycleView(paramView);
    }
    
    public void removeAndRecycleViewAt(int paramInt, RecyclerView.n paramn)
    {
      View localView = getChildAt(paramInt);
      removeViewAt(paramInt);
      paramn.recycleView(localView);
    }
    
    public boolean removeCallbacks(Runnable paramRunnable)
    {
      if (this.q != null) {
        return this.q.removeCallbacks(paramRunnable);
      }
      return false;
    }
    
    public void removeDetachedView(View paramView)
    {
      this.q.removeDetachedView(paramView, false);
    }
    
    public void removeView(View paramView)
    {
      this.p.a(paramView);
    }
    
    public void removeViewAt(int paramInt)
    {
      if (getChildAt(paramInt) != null) {
        this.p.a(paramInt);
      }
    }
    
    public boolean requestChildRectangleOnScreen(RecyclerView paramRecyclerView, View paramView, Rect paramRect, boolean paramBoolean)
    {
      return requestChildRectangleOnScreen(paramRecyclerView, paramView, paramRect, paramBoolean, false);
    }
    
    public boolean requestChildRectangleOnScreen(RecyclerView paramRecyclerView, View paramView, Rect paramRect, boolean paramBoolean1, boolean paramBoolean2)
    {
      boolean bool = false;
      paramView = a(paramRecyclerView, paramView, paramRect, paramBoolean1);
      int i = paramView[0];
      int j = paramView[1];
      if (paramBoolean2)
      {
        paramBoolean2 = bool;
        if (!a(paramRecyclerView, i, j)) {}
      }
      else if (i == 0)
      {
        paramBoolean2 = bool;
        if (j == 0) {}
      }
      else
      {
        if (!paramBoolean1) {
          break label77;
        }
        paramRecyclerView.scrollBy(i, j);
      }
      for (;;)
      {
        paramBoolean2 = true;
        return paramBoolean2;
        label77:
        paramRecyclerView.smoothScrollBy(i, j);
      }
    }
    
    public void requestLayout()
    {
      if (this.q != null) {
        this.q.requestLayout();
      }
    }
    
    public void requestSimpleAnimationsInNextLayout()
    {
      this.u = true;
    }
    
    public int scrollHorizontallyBy(int paramInt, RecyclerView.n paramn, RecyclerView.r paramr)
    {
      return 0;
    }
    
    public void scrollToPosition(int paramInt) {}
    
    public int scrollVerticallyBy(int paramInt, RecyclerView.n paramn, RecyclerView.r paramr)
    {
      return 0;
    }
    
    public void setAutoMeasureEnabled(boolean paramBoolean)
    {
      this.w = paramBoolean;
    }
    
    public final void setItemPrefetchEnabled(boolean paramBoolean)
    {
      if (paramBoolean != this.d)
      {
        this.d = paramBoolean;
        this.x = 0;
        if (this.q != null) {
          this.q.mRecycler.a();
        }
      }
    }
    
    public void setMeasuredDimension(int paramInt1, int paramInt2)
    {
      this.q.setMeasuredDimension(paramInt1, paramInt2);
    }
    
    public void setMeasuredDimension(Rect paramRect, int paramInt1, int paramInt2)
    {
      int i = paramRect.width();
      int j = getPaddingLeft();
      int k = getPaddingRight();
      int m = paramRect.height();
      int n = getPaddingTop();
      int i1 = getPaddingBottom();
      setMeasuredDimension(chooseSize(paramInt1, i + j + k, getMinimumWidth()), chooseSize(paramInt2, m + n + i1, getMinimumHeight()));
    }
    
    public void setMeasurementCacheEnabled(boolean paramBoolean)
    {
      this.c = paramBoolean;
    }
    
    public void smoothScrollToPosition(RecyclerView paramRecyclerView, RecyclerView.r paramr, int paramInt)
    {
      Log.e("RecyclerView", "You must override smoothScrollToPosition to support smooth scrolling");
    }
    
    public void startSmoothScroll(RecyclerView.q paramq)
    {
      if ((this.t != null) && (paramq != this.t) && (this.t.isRunning())) {
        this.t.e();
      }
      this.t = paramq;
      this.t.a(this.q, this);
    }
    
    public void stopIgnoringView(View paramView)
    {
      paramView = RecyclerView.getChildViewHolderInt(paramView);
      paramView.stopIgnoring();
      paramView.resetInternal();
      paramView.addFlags(4);
    }
    
    public boolean supportsPredictiveItemAnimations()
    {
      return false;
    }
    
    public static abstract interface a
    {
      public abstract void addPosition(int paramInt1, int paramInt2);
    }
    
    public static class b
    {
      public int a;
      public int b;
      public boolean c;
      public boolean d;
    }
  }
  
  public static abstract interface i
  {
    public abstract void onChildViewAttachedToWindow(View paramView);
    
    public abstract void onChildViewDetachedFromWindow(View paramView);
  }
  
  public static abstract class j
  {
    public abstract boolean onFling(int paramInt1, int paramInt2);
  }
  
  public static abstract interface k
  {
    public abstract boolean onInterceptTouchEvent(RecyclerView paramRecyclerView, MotionEvent paramMotionEvent);
    
    public abstract void onRequestDisallowInterceptTouchEvent(boolean paramBoolean);
    
    public abstract void onTouchEvent(RecyclerView paramRecyclerView, MotionEvent paramMotionEvent);
  }
  
  public static abstract class l
  {
    public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt) {}
    
    public void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2) {}
  }
  
  public static class m
  {
    SparseArray<a> a = new SparseArray();
    private int b = 0;
    
    private a a(int paramInt)
    {
      a locala2 = (a)this.a.get(paramInt);
      a locala1 = locala2;
      if (locala2 == null)
      {
        locala1 = new a();
        this.a.put(paramInt, locala1);
      }
      return locala1;
    }
    
    long a(long paramLong1, long paramLong2)
    {
      if (paramLong1 == 0L) {
        return paramLong2;
      }
      return paramLong1 / 4L * 3L + paramLong2 / 4L;
    }
    
    void a()
    {
      this.b -= 1;
    }
    
    void a(int paramInt, long paramLong)
    {
      a locala = a(paramInt);
      locala.c = a(locala.c, paramLong);
    }
    
    void a(RecyclerView.a parama)
    {
      this.b += 1;
    }
    
    void a(RecyclerView.a parama1, RecyclerView.a parama2, boolean paramBoolean)
    {
      if (parama1 != null) {
        a();
      }
      if ((!paramBoolean) && (this.b == 0)) {
        clear();
      }
      if (parama2 != null) {
        a(parama2);
      }
    }
    
    boolean a(int paramInt, long paramLong1, long paramLong2)
    {
      long l = a(paramInt).c;
      return (l == 0L) || (l + paramLong1 < paramLong2);
    }
    
    void b(int paramInt, long paramLong)
    {
      a locala = a(paramInt);
      locala.d = a(locala.d, paramLong);
    }
    
    boolean b(int paramInt, long paramLong1, long paramLong2)
    {
      long l = a(paramInt).d;
      return (l == 0L) || (l + paramLong1 < paramLong2);
    }
    
    public void clear()
    {
      int i = 0;
      while (i < this.a.size())
      {
        ((a)this.a.valueAt(i)).a.clear();
        i += 1;
      }
    }
    
    public RecyclerView.u getRecycledView(int paramInt)
    {
      Object localObject = (a)this.a.get(paramInt);
      if ((localObject != null) && (!((a)localObject).a.isEmpty()))
      {
        localObject = ((a)localObject).a;
        return (RecyclerView.u)((ArrayList)localObject).remove(((ArrayList)localObject).size() - 1);
      }
      return null;
    }
    
    public int getRecycledViewCount(int paramInt)
    {
      return a(paramInt).a.size();
    }
    
    public void putRecycledView(RecyclerView.u paramu)
    {
      int i = paramu.getItemViewType();
      ArrayList localArrayList = a(i).a;
      if (((a)this.a.get(i)).b <= localArrayList.size()) {
        return;
      }
      paramu.resetInternal();
      localArrayList.add(paramu);
    }
    
    public void setMaxRecycledViews(int paramInt1, int paramInt2)
    {
      Object localObject = a(paramInt1);
      ((a)localObject).b = paramInt2;
      localObject = ((a)localObject).a;
      if (localObject != null) {
        while (((ArrayList)localObject).size() > paramInt2) {
          ((ArrayList)localObject).remove(((ArrayList)localObject).size() - 1);
        }
      }
    }
    
    static class a
    {
      ArrayList<RecyclerView.u> a = new ArrayList();
      int b = 5;
      long c = 0L;
      long d = 0L;
    }
  }
  
  public final class n
  {
    final ArrayList<RecyclerView.u> a = new ArrayList();
    ArrayList<RecyclerView.u> b = null;
    final ArrayList<RecyclerView.u> c = new ArrayList();
    int d = 2;
    RecyclerView.m e;
    private final List<RecyclerView.u> g = Collections.unmodifiableList(this.a);
    private int h = 2;
    private RecyclerView.s i;
    
    public n() {}
    
    private void a(ViewGroup paramViewGroup, boolean paramBoolean)
    {
      int j = paramViewGroup.getChildCount() - 1;
      while (j >= 0)
      {
        View localView = paramViewGroup.getChildAt(j);
        if ((localView instanceof ViewGroup)) {
          a((ViewGroup)localView, true);
        }
        j -= 1;
      }
      if (!paramBoolean) {
        return;
      }
      if (paramViewGroup.getVisibility() == 4)
      {
        paramViewGroup.setVisibility(0);
        paramViewGroup.setVisibility(4);
        return;
      }
      j = paramViewGroup.getVisibility();
      paramViewGroup.setVisibility(4);
      paramViewGroup.setVisibility(j);
    }
    
    private boolean a(RecyclerView.u paramu, int paramInt1, int paramInt2, long paramLong)
    {
      paramu.mOwnerRecyclerView = RecyclerView.this;
      int j = paramu.getItemViewType();
      long l = RecyclerView.this.getNanoTime();
      if ((paramLong != Long.MAX_VALUE) && (!this.e.b(j, l, paramLong))) {
        return false;
      }
      RecyclerView.this.mAdapter.bindViewHolder(paramu, paramInt1);
      paramLong = RecyclerView.this.getNanoTime();
      this.e.b(paramu.getItemViewType(), paramLong - l);
      e(paramu);
      if (RecyclerView.this.mState.isPreLayout()) {
        paramu.mPreLayoutPosition = paramInt2;
      }
      return true;
    }
    
    private void e(RecyclerView.u paramu)
    {
      if (RecyclerView.this.isAccessibilityEnabled())
      {
        View localView = paramu.itemView;
        if (ViewCompat.getImportantForAccessibility(localView) == 0) {
          ViewCompat.setImportantForAccessibility(localView, 1);
        }
        if (!ViewCompat.hasAccessibilityDelegate(localView))
        {
          paramu.addFlags(16384);
          ViewCompat.setAccessibilityDelegate(localView, RecyclerView.this.mAccessibilityDelegate.getItemDelegate());
        }
      }
    }
    
    private void f(RecyclerView.u paramu)
    {
      if ((paramu.itemView instanceof ViewGroup)) {
        a((ViewGroup)paramu.itemView, false);
      }
    }
    
    RecyclerView.u a(int paramInt, boolean paramBoolean, long paramLong)
    {
      boolean bool = true;
      if ((paramInt < 0) || (paramInt >= RecyclerView.this.mState.getItemCount())) {
        throw new IndexOutOfBoundsException("Invalid item position " + paramInt + "(" + paramInt + "). Item count:" + RecyclerView.this.mState.getItemCount() + RecyclerView.this.exceptionLabel());
      }
      Object localObject2;
      int j;
      if (RecyclerView.this.mState.isPreLayout())
      {
        localObject2 = c(paramInt);
        if (localObject2 != null) {
          j = 1;
        }
      }
      for (int k = j;; k = 0)
      {
        Object localObject1 = localObject2;
        j = k;
        if (localObject2 == null)
        {
          localObject2 = b(paramInt, paramBoolean);
          localObject1 = localObject2;
          j = k;
          if (localObject2 != null)
          {
            if (a((RecyclerView.u)localObject2)) {
              break label339;
            }
            if (!paramBoolean)
            {
              ((RecyclerView.u)localObject2).addFlags(4);
              if (!((RecyclerView.u)localObject2).isScrap()) {
                break label323;
              }
              RecyclerView.this.removeDetachedView(((RecyclerView.u)localObject2).itemView, false);
              ((RecyclerView.u)localObject2).unScrap();
              label196:
              b((RecyclerView.u)localObject2);
            }
            localObject1 = null;
            j = k;
          }
        }
        for (;;)
        {
          if (localObject1 == null)
          {
            int m = RecyclerView.this.mAdapterHelper.b(paramInt);
            if ((m < 0) || (m >= RecyclerView.this.mAdapter.getItemCount()))
            {
              throw new IndexOutOfBoundsException("Inconsistency detected. Invalid item position " + paramInt + "(offset:" + m + ")." + "state:" + RecyclerView.this.mState.getItemCount() + RecyclerView.this.exceptionLabel());
              j = 0;
              break;
              label323:
              if (!((RecyclerView.u)localObject2).wasReturnedFromScrap()) {
                break label196;
              }
              ((RecyclerView.u)localObject2).clearReturnedFromScrapFlag();
              break label196;
              label339:
              j = 1;
              localObject1 = localObject2;
              continue;
            }
            k = RecyclerView.this.mAdapter.getItemViewType(m);
            if (RecyclerView.this.mAdapter.hasStableIds())
            {
              localObject2 = a(RecyclerView.this.mAdapter.getItemId(m), k, paramBoolean);
              localObject1 = localObject2;
              if (localObject2 != null)
              {
                ((RecyclerView.u)localObject2).mPosition = m;
                j = 1;
                localObject1 = localObject2;
                if (localObject2 == null)
                {
                  localObject1 = localObject2;
                  if (this.i != null)
                  {
                    View localView = this.i.getViewForPositionAndType(this, paramInt, k);
                    localObject1 = localObject2;
                    if (localView != null)
                    {
                      localObject2 = RecyclerView.this.getChildViewHolder(localView);
                      if (localObject2 == null) {
                        throw new IllegalArgumentException("getViewForPositionAndType returned a view which does not have a ViewHolder" + RecyclerView.this.exceptionLabel());
                      }
                      localObject1 = localObject2;
                      if (((RecyclerView.u)localObject2).shouldIgnore()) {
                        throw new IllegalArgumentException("getViewForPositionAndType returned a view that is ignored. You must call stopIgnoring before returning this view." + RecyclerView.this.exceptionLabel());
                      }
                    }
                  }
                }
                localObject2 = localObject1;
                if (localObject1 == null)
                {
                  localObject1 = e().getRecycledView(k);
                  localObject2 = localObject1;
                  if (localObject1 != null)
                  {
                    ((RecyclerView.u)localObject1).resetInternal();
                    localObject2 = localObject1;
                    if (RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST)
                    {
                      f((RecyclerView.u)localObject1);
                      localObject2 = localObject1;
                    }
                  }
                }
                localObject1 = localObject2;
                if (localObject2 == null)
                {
                  long l1 = RecyclerView.this.getNanoTime();
                  if ((paramLong != Long.MAX_VALUE) && (!this.e.a(k, l1, paramLong))) {
                    return null;
                  }
                  localObject1 = RecyclerView.this.mAdapter.createViewHolder(RecyclerView.this, k);
                  if (RecyclerView.ALLOW_THREAD_GAP_WORK)
                  {
                    localObject2 = RecyclerView.findNestedRecyclerView(((RecyclerView.u)localObject1).itemView);
                    if (localObject2 != null) {
                      ((RecyclerView.u)localObject1).mNestedRecyclerView = new WeakReference(localObject2);
                    }
                  }
                  long l2 = RecyclerView.this.getNanoTime();
                  this.e.a(k, l2 - l1);
                }
              }
            }
          }
        }
        for (localObject2 = localObject1;; localObject2 = localObject1)
        {
          if ((j != 0) && (!RecyclerView.this.mState.isPreLayout()) && (((RecyclerView.u)localObject2).hasAnyOfTheFlags(8192)))
          {
            ((RecyclerView.u)localObject2).setFlags(0, 8192);
            if (RecyclerView.this.mState.i)
            {
              k = RecyclerView.e.b((RecyclerView.u)localObject2);
              localObject1 = RecyclerView.this.mItemAnimator.recordPreLayoutInformation(RecyclerView.this.mState, (RecyclerView.u)localObject2, k | 0x1000, ((RecyclerView.u)localObject2).getUnmodifiedPayloads());
              RecyclerView.this.recordAnimationInfoIfBouncedHiddenView((RecyclerView.u)localObject2, (RecyclerView.e.c)localObject1);
            }
          }
          if ((RecyclerView.this.mState.isPreLayout()) && (((RecyclerView.u)localObject2).isBound()))
          {
            ((RecyclerView.u)localObject2).mPreLayoutPosition = paramInt;
            paramBoolean = false;
          }
          for (;;)
          {
            localObject1 = ((RecyclerView.u)localObject2).itemView.getLayoutParams();
            if (localObject1 == null)
            {
              localObject1 = (RecyclerView.LayoutParams)RecyclerView.this.generateDefaultLayoutParams();
              ((RecyclerView.u)localObject2).itemView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
              label898:
              ((RecyclerView.LayoutParams)localObject1).c = ((RecyclerView.u)localObject2);
              if ((j == 0) || (!paramBoolean)) {
                break label1022;
              }
            }
            label1022:
            for (paramBoolean = bool;; paramBoolean = false)
            {
              ((RecyclerView.LayoutParams)localObject1).f = paramBoolean;
              return (RecyclerView.u)localObject2;
              if ((((RecyclerView.u)localObject2).isBound()) && (!((RecyclerView.u)localObject2).needsUpdate()) && (!((RecyclerView.u)localObject2).isInvalid())) {
                break label1027;
              }
              paramBoolean = a((RecyclerView.u)localObject2, RecyclerView.this.mAdapterHelper.b(paramInt), paramInt, paramLong);
              break;
              if (!RecyclerView.this.checkLayoutParams((ViewGroup.LayoutParams)localObject1))
              {
                localObject1 = (RecyclerView.LayoutParams)RecyclerView.this.generateLayoutParams((ViewGroup.LayoutParams)localObject1);
                ((RecyclerView.u)localObject2).itemView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
                break label898;
              }
              localObject1 = (RecyclerView.LayoutParams)localObject1;
              break label898;
            }
            label1027:
            paramBoolean = false;
          }
          localObject2 = localObject1;
          break;
        }
        localObject2 = null;
      }
    }
    
    RecyclerView.u a(long paramLong, int paramInt, boolean paramBoolean)
    {
      int j = this.a.size() - 1;
      RecyclerView.u localu2;
      RecyclerView.u localu1;
      while (j >= 0)
      {
        localu2 = (RecyclerView.u)this.a.get(j);
        if ((localu2.getItemId() == paramLong) && (!localu2.wasReturnedFromScrap()))
        {
          if (paramInt == localu2.getItemViewType())
          {
            localu2.addFlags(32);
            localu1 = localu2;
            if (localu2.isRemoved())
            {
              localu1 = localu2;
              if (!RecyclerView.this.mState.isPreLayout())
              {
                localu2.setFlags(2, 14);
                localu1 = localu2;
              }
            }
            return localu1;
          }
          if (!paramBoolean)
          {
            this.a.remove(j);
            RecyclerView.this.removeDetachedView(localu2.itemView, false);
            a(localu2.itemView);
          }
        }
        j -= 1;
      }
      j = this.c.size() - 1;
      for (;;)
      {
        if (j < 0) {
          break label247;
        }
        localu2 = (RecyclerView.u)this.c.get(j);
        if (localu2.getItemId() == paramLong)
        {
          if (paramInt == localu2.getItemViewType())
          {
            localu1 = localu2;
            if (paramBoolean) {
              break;
            }
            this.c.remove(j);
            return localu2;
          }
          if (!paramBoolean)
          {
            a(j);
            return null;
          }
        }
        j -= 1;
      }
      label247:
      return null;
    }
    
    View a(int paramInt, boolean paramBoolean)
    {
      return a(paramInt, paramBoolean, Long.MAX_VALUE).itemView;
    }
    
    void a()
    {
      if (RecyclerView.this.mLayout != null) {}
      for (int j = RecyclerView.this.mLayout.x;; j = 0)
      {
        this.d = (j + this.h);
        j = this.c.size() - 1;
        while ((j >= 0) && (this.c.size() > this.d))
        {
          a(j);
          j -= 1;
        }
      }
    }
    
    void a(int paramInt)
    {
      a((RecyclerView.u)this.c.get(paramInt), true);
      this.c.remove(paramInt);
    }
    
    void a(int paramInt1, int paramInt2)
    {
      int j;
      int k;
      int m;
      int n;
      label25:
      RecyclerView.u localu;
      if (paramInt1 < paramInt2)
      {
        j = -1;
        k = paramInt2;
        m = paramInt1;
        int i1 = this.c.size();
        n = 0;
        if (n >= i1) {
          return;
        }
        localu = (RecyclerView.u)this.c.get(n);
        if ((localu != null) && (localu.mPosition >= m) && (localu.mPosition <= k)) {
          break label91;
        }
      }
      for (;;)
      {
        n += 1;
        break label25;
        j = 1;
        k = paramInt1;
        m = paramInt2;
        break;
        label91:
        if (localu.mPosition == paramInt1) {
          localu.offsetPosition(paramInt2 - paramInt1, false);
        } else {
          localu.offsetPosition(j, false);
        }
      }
    }
    
    void a(int paramInt1, int paramInt2, boolean paramBoolean)
    {
      int j = this.c.size() - 1;
      if (j >= 0)
      {
        RecyclerView.u localu = (RecyclerView.u)this.c.get(j);
        if (localu != null)
        {
          if (localu.mPosition < paramInt1 + paramInt2) {
            break label63;
          }
          localu.offsetPosition(-paramInt2, paramBoolean);
        }
        for (;;)
        {
          j -= 1;
          break;
          label63:
          if (localu.mPosition >= paramInt1)
          {
            localu.addFlags(8);
            a(j);
          }
        }
      }
    }
    
    void a(RecyclerView.a parama1, RecyclerView.a parama2, boolean paramBoolean)
    {
      clear();
      e().a(parama1, parama2, paramBoolean);
    }
    
    void a(RecyclerView.m paramm)
    {
      if (this.e != null) {
        this.e.a();
      }
      this.e = paramm;
      if (paramm != null) {
        this.e.a(RecyclerView.this.getAdapter());
      }
    }
    
    void a(RecyclerView.s params)
    {
      this.i = params;
    }
    
    void a(RecyclerView.u paramu, boolean paramBoolean)
    {
      RecyclerView.clearNestedRecyclerViewIfNotNested(paramu);
      if (paramu.hasAnyOfTheFlags(16384))
      {
        paramu.setFlags(0, 16384);
        ViewCompat.setAccessibilityDelegate(paramu.itemView, null);
      }
      if (paramBoolean) {
        d(paramu);
      }
      paramu.mOwnerRecyclerView = null;
      e().putRecycledView(paramu);
    }
    
    void a(View paramView)
    {
      paramView = RecyclerView.getChildViewHolderInt(paramView);
      RecyclerView.u.access$1002(paramView, null);
      RecyclerView.u.access$1102(paramView, false);
      paramView.clearReturnedFromScrapFlag();
      b(paramView);
    }
    
    boolean a(RecyclerView.u paramu)
    {
      boolean bool2 = true;
      boolean bool1;
      if (paramu.isRemoved()) {
        bool1 = RecyclerView.this.mState.isPreLayout();
      }
      do
      {
        do
        {
          return bool1;
          if ((paramu.mPosition < 0) || (paramu.mPosition >= RecyclerView.this.mAdapter.getItemCount())) {
            throw new IndexOutOfBoundsException("Inconsistency detected. Invalid view holder adapter position" + paramu + RecyclerView.this.exceptionLabel());
          }
          if ((!RecyclerView.this.mState.isPreLayout()) && (RecyclerView.this.mAdapter.getItemViewType(paramu.mPosition) != paramu.getItemViewType())) {
            return false;
          }
          bool1 = bool2;
        } while (!RecyclerView.this.mAdapter.hasStableIds());
        bool1 = bool2;
      } while (paramu.getItemId() == RecyclerView.this.mAdapter.getItemId(paramu.mPosition));
      return false;
    }
    
    RecyclerView.u b(int paramInt, boolean paramBoolean)
    {
      int k = 0;
      int m = this.a.size();
      int j = 0;
      Object localObject;
      while (j < m)
      {
        localObject = (RecyclerView.u)this.a.get(j);
        if ((!((RecyclerView.u)localObject).wasReturnedFromScrap()) && (((RecyclerView.u)localObject).getLayoutPosition() == paramInt) && (!((RecyclerView.u)localObject).isInvalid()) && ((RecyclerView.this.mState.f) || (!((RecyclerView.u)localObject).isRemoved())))
        {
          ((RecyclerView.u)localObject).addFlags(32);
          return (RecyclerView.u)localObject;
        }
        j += 1;
      }
      RecyclerView.u localu;
      if (!paramBoolean)
      {
        localObject = RecyclerView.this.mChildHelper.c(paramInt);
        if (localObject != null)
        {
          localu = RecyclerView.getChildViewHolderInt((View)localObject);
          RecyclerView.this.mChildHelper.e((View)localObject);
          paramInt = RecyclerView.this.mChildHelper.b((View)localObject);
          if (paramInt == -1) {
            throw new IllegalStateException("layout index should not be -1 after unhiding a view:" + localu + RecyclerView.this.exceptionLabel());
          }
          RecyclerView.this.mChildHelper.e(paramInt);
          b((View)localObject);
          localu.addFlags(8224);
          return localu;
        }
      }
      m = this.c.size();
      j = k;
      for (;;)
      {
        if (j >= m) {
          break label297;
        }
        localu = (RecyclerView.u)this.c.get(j);
        if ((!localu.isInvalid()) && (localu.getLayoutPosition() == paramInt))
        {
          localObject = localu;
          if (paramBoolean) {
            break;
          }
          this.c.remove(j);
          return localu;
        }
        j += 1;
      }
      label297:
      return null;
    }
    
    View b(int paramInt)
    {
      return ((RecyclerView.u)this.a.get(paramInt)).itemView;
    }
    
    void b()
    {
      int j = this.c.size() - 1;
      while (j >= 0)
      {
        a(j);
        j -= 1;
      }
      this.c.clear();
      if (RecyclerView.ALLOW_THREAD_GAP_WORK) {
        RecyclerView.this.mPrefetchRegistry.a();
      }
    }
    
    void b(int paramInt1, int paramInt2)
    {
      int k = this.c.size();
      int j = 0;
      while (j < k)
      {
        RecyclerView.u localu = (RecyclerView.u)this.c.get(j);
        if ((localu != null) && (localu.mPosition >= paramInt1)) {
          localu.offsetPosition(paramInt2, true);
        }
        j += 1;
      }
    }
    
    void b(RecyclerView.u paramu)
    {
      int m = 0;
      if ((paramu.isScrap()) || (paramu.itemView.getParent() != null))
      {
        StringBuilder localStringBuilder = new StringBuilder().append("Scrapped or attached views may not be recycled. isScrap:").append(paramu.isScrap()).append(" isAttached:");
        if (paramu.itemView.getParent() != null) {}
        for (bool = true;; bool = false) {
          throw new IllegalArgumentException(bool + RecyclerView.this.exceptionLabel());
        }
      }
      if (paramu.isTmpDetached()) {
        throw new IllegalArgumentException("Tmp detached view should be removed from RecyclerView before it can be recycled: " + paramu + RecyclerView.this.exceptionLabel());
      }
      if (paramu.shouldIgnore()) {
        throw new IllegalArgumentException("Trying to recycle an ignored view holder. You should first call stopIgnoringView(view) before calling recycle." + RecyclerView.this.exceptionLabel());
      }
      boolean bool = RecyclerView.u.access$900(paramu);
      int j;
      if ((RecyclerView.this.mAdapter != null) && (bool) && (RecyclerView.this.mAdapter.onFailedToRecycleView(paramu)))
      {
        j = 1;
        if ((j == 0) && (!paramu.isRecyclable())) {
          break label429;
        }
        if ((this.d <= 0) || (paramu.hasAnyOfTheFlags(526))) {
          break label424;
        }
        k = this.c.size();
        j = k;
        if (k >= this.d)
        {
          j = k;
          if (k > 0)
          {
            a(0);
            j = k - 1;
          }
        }
        k = j;
        if (RecyclerView.ALLOW_THREAD_GAP_WORK)
        {
          k = j;
          if (j > 0)
          {
            k = j;
            if (!RecyclerView.this.mPrefetchRegistry.a(paramu.mPosition))
            {
              j -= 1;
              label316:
              if (j >= 0)
              {
                k = ((RecyclerView.u)this.c.get(j)).mPosition;
                if (RecyclerView.this.mPrefetchRegistry.a(k)) {
                  break label417;
                }
              }
              k = j + 1;
            }
          }
        }
        this.c.add(k, paramu);
        j = 1;
        label364:
        k = j;
        if (j == 0)
        {
          a(paramu, true);
          m = 1;
        }
      }
      label417:
      label424:
      label429:
      for (int k = j;; k = 0)
      {
        RecyclerView.this.mViewInfoStore.g(paramu);
        if ((k == 0) && (m == 0) && (bool)) {
          paramu.mOwnerRecyclerView = null;
        }
        return;
        j = 0;
        break;
        j -= 1;
        break label316;
        j = 0;
        break label364;
      }
    }
    
    void b(View paramView)
    {
      paramView = RecyclerView.getChildViewHolderInt(paramView);
      if ((paramView.hasAnyOfTheFlags(12)) || (!paramView.isUpdated()) || (RecyclerView.this.canReuseUpdatedViewHolder(paramView)))
      {
        if ((paramView.isInvalid()) && (!paramView.isRemoved()) && (!RecyclerView.this.mAdapter.hasStableIds())) {
          throw new IllegalArgumentException("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool." + RecyclerView.this.exceptionLabel());
        }
        paramView.setScrapContainer(this, false);
        this.a.add(paramView);
        return;
      }
      if (this.b == null) {
        this.b = new ArrayList();
      }
      paramView.setScrapContainer(this, true);
      this.b.add(paramView);
    }
    
    public void bindViewToPosition(View paramView, int paramInt)
    {
      RecyclerView.u localu = RecyclerView.getChildViewHolderInt(paramView);
      if (localu == null) {
        throw new IllegalArgumentException("The view does not have a ViewHolder. You cannot pass arbitrary views to this method, they should be created by the Adapter" + RecyclerView.this.exceptionLabel());
      }
      int j = RecyclerView.this.mAdapterHelper.b(paramInt);
      if ((j < 0) || (j >= RecyclerView.this.mAdapter.getItemCount())) {
        throw new IndexOutOfBoundsException("Inconsistency detected. Invalid item position " + paramInt + "(offset:" + j + ")." + "state:" + RecyclerView.this.mState.getItemCount() + RecyclerView.this.exceptionLabel());
      }
      a(localu, j, paramInt, Long.MAX_VALUE);
      paramView = localu.itemView.getLayoutParams();
      if (paramView == null)
      {
        paramView = (RecyclerView.LayoutParams)RecyclerView.this.generateDefaultLayoutParams();
        localu.itemView.setLayoutParams(paramView);
        paramView.e = true;
        paramView.c = localu;
        if (localu.itemView.getParent() != null) {
          break label264;
        }
      }
      label264:
      for (boolean bool = true;; bool = false)
      {
        paramView.f = bool;
        return;
        if (!RecyclerView.this.checkLayoutParams(paramView))
        {
          paramView = (RecyclerView.LayoutParams)RecyclerView.this.generateLayoutParams(paramView);
          localu.itemView.setLayoutParams(paramView);
          break;
        }
        paramView = (RecyclerView.LayoutParams)paramView;
        break;
      }
    }
    
    int c()
    {
      return this.a.size();
    }
    
    RecyclerView.u c(int paramInt)
    {
      int k = 0;
      int m;
      if (this.b != null)
      {
        m = this.b.size();
        if (m != 0) {}
      }
      else
      {
        return null;
      }
      int j = 0;
      RecyclerView.u localu;
      while (j < m)
      {
        localu = (RecyclerView.u)this.b.get(j);
        if ((!localu.wasReturnedFromScrap()) && (localu.getLayoutPosition() == paramInt))
        {
          localu.addFlags(32);
          return localu;
        }
        j += 1;
      }
      if (RecyclerView.this.mAdapter.hasStableIds())
      {
        paramInt = RecyclerView.this.mAdapterHelper.b(paramInt);
        if ((paramInt > 0) && (paramInt < RecyclerView.this.mAdapter.getItemCount()))
        {
          long l = RecyclerView.this.mAdapter.getItemId(paramInt);
          paramInt = k;
          while (paramInt < m)
          {
            localu = (RecyclerView.u)this.b.get(paramInt);
            if ((!localu.wasReturnedFromScrap()) && (localu.getItemId() == l))
            {
              localu.addFlags(32);
              return localu;
            }
            paramInt += 1;
          }
        }
      }
      return null;
    }
    
    void c(int paramInt1, int paramInt2)
    {
      int j = this.c.size() - 1;
      if (j >= 0)
      {
        RecyclerView.u localu = (RecyclerView.u)this.c.get(j);
        if (localu == null) {}
        for (;;)
        {
          j -= 1;
          break;
          int k = localu.mPosition;
          if ((k >= paramInt1) && (k < paramInt1 + paramInt2))
          {
            localu.addFlags(2);
            a(j);
          }
        }
      }
    }
    
    void c(RecyclerView.u paramu)
    {
      if (RecyclerView.u.access$1100(paramu)) {
        this.b.remove(paramu);
      }
      for (;;)
      {
        RecyclerView.u.access$1002(paramu, null);
        RecyclerView.u.access$1102(paramu, false);
        paramu.clearReturnedFromScrapFlag();
        return;
        this.a.remove(paramu);
      }
    }
    
    public void clear()
    {
      this.a.clear();
      b();
    }
    
    public int convertPreLayoutPositionToPostLayout(int paramInt)
    {
      if ((paramInt < 0) || (paramInt >= RecyclerView.this.mState.getItemCount())) {
        throw new IndexOutOfBoundsException("invalid position " + paramInt + ". State " + "item count is " + RecyclerView.this.mState.getItemCount() + RecyclerView.this.exceptionLabel());
      }
      if (!RecyclerView.this.mState.isPreLayout()) {
        return paramInt;
      }
      return RecyclerView.this.mAdapterHelper.b(paramInt);
    }
    
    void d()
    {
      this.a.clear();
      if (this.b != null) {
        this.b.clear();
      }
    }
    
    void d(RecyclerView.u paramu)
    {
      if (RecyclerView.this.mRecyclerListener != null) {
        RecyclerView.this.mRecyclerListener.onViewRecycled(paramu);
      }
      if (RecyclerView.this.mAdapter != null) {
        RecyclerView.this.mAdapter.onViewRecycled(paramu);
      }
      if (RecyclerView.this.mState != null) {
        RecyclerView.this.mViewInfoStore.g(paramu);
      }
    }
    
    RecyclerView.m e()
    {
      if (this.e == null) {
        this.e = new RecyclerView.m();
      }
      return this.e;
    }
    
    void f()
    {
      int k;
      int j;
      if ((RecyclerView.this.mAdapter != null) && (RecyclerView.this.mAdapter.hasStableIds()))
      {
        k = this.c.size();
        j = 0;
      }
      while (j < k)
      {
        RecyclerView.u localu = (RecyclerView.u)this.c.get(j);
        if (localu != null)
        {
          localu.addFlags(6);
          localu.addChangePayload(null);
        }
        j += 1;
        continue;
        b();
      }
    }
    
    void g()
    {
      int k = 0;
      int m = this.c.size();
      int j = 0;
      while (j < m)
      {
        ((RecyclerView.u)this.c.get(j)).clearOldPosition();
        j += 1;
      }
      m = this.a.size();
      j = 0;
      while (j < m)
      {
        ((RecyclerView.u)this.a.get(j)).clearOldPosition();
        j += 1;
      }
      if (this.b != null)
      {
        m = this.b.size();
        j = k;
        while (j < m)
        {
          ((RecyclerView.u)this.b.get(j)).clearOldPosition();
          j += 1;
        }
      }
    }
    
    public List<RecyclerView.u> getScrapList()
    {
      return this.g;
    }
    
    public View getViewForPosition(int paramInt)
    {
      return a(paramInt, false);
    }
    
    void h()
    {
      int k = this.c.size();
      int j = 0;
      while (j < k)
      {
        RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)((RecyclerView.u)this.c.get(j)).itemView.getLayoutParams();
        if (localLayoutParams != null) {
          localLayoutParams.e = true;
        }
        j += 1;
      }
    }
    
    public void recycleView(View paramView)
    {
      RecyclerView.u localu = RecyclerView.getChildViewHolderInt(paramView);
      if (localu.isTmpDetached()) {
        RecyclerView.this.removeDetachedView(paramView, false);
      }
      if (localu.isScrap()) {
        localu.unScrap();
      }
      for (;;)
      {
        b(localu);
        return;
        if (localu.wasReturnedFromScrap()) {
          localu.clearReturnedFromScrapFlag();
        }
      }
    }
    
    public void setViewCacheSize(int paramInt)
    {
      this.h = paramInt;
      a();
    }
  }
  
  public static abstract interface o
  {
    public abstract void onViewRecycled(RecyclerView.u paramu);
  }
  
  private class p
    extends RecyclerView.c
  {
    p() {}
    
    void a()
    {
      if ((RecyclerView.POST_UPDATES_ON_ANIMATION) && (RecyclerView.this.mHasFixedSize) && (RecyclerView.this.mIsAttached))
      {
        ViewCompat.postOnAnimation(RecyclerView.this, RecyclerView.this.mUpdateChildViewsRunnable);
        return;
      }
      RecyclerView.this.mAdapterUpdateDuringMeasure = true;
      RecyclerView.this.requestLayout();
    }
    
    public void onChanged()
    {
      RecyclerView.this.assertNotInLayoutOrScroll(null);
      RecyclerView.this.mState.e = true;
      RecyclerView.this.setDataSetChangedAfterLayout();
      if (!RecyclerView.this.mAdapterHelper.d()) {
        RecyclerView.this.requestLayout();
      }
    }
    
    public void onItemRangeChanged(int paramInt1, int paramInt2, Object paramObject)
    {
      RecyclerView.this.assertNotInLayoutOrScroll(null);
      if (RecyclerView.this.mAdapterHelper.a(paramInt1, paramInt2, paramObject)) {
        a();
      }
    }
    
    public void onItemRangeInserted(int paramInt1, int paramInt2)
    {
      RecyclerView.this.assertNotInLayoutOrScroll(null);
      if (RecyclerView.this.mAdapterHelper.b(paramInt1, paramInt2)) {
        a();
      }
    }
    
    public void onItemRangeMoved(int paramInt1, int paramInt2, int paramInt3)
    {
      RecyclerView.this.assertNotInLayoutOrScroll(null);
      if (RecyclerView.this.mAdapterHelper.a(paramInt1, paramInt2, paramInt3)) {
        a();
      }
    }
    
    public void onItemRangeRemoved(int paramInt1, int paramInt2)
    {
      RecyclerView.this.assertNotInLayoutOrScroll(null);
      if (RecyclerView.this.mAdapterHelper.c(paramInt1, paramInt2)) {
        a();
      }
    }
  }
  
  public static abstract class q
  {
    private int a = -1;
    private RecyclerView b;
    private RecyclerView.h c;
    private boolean d;
    private boolean e;
    private View f;
    private final a g = new a(0, 0);
    
    private void a(int paramInt1, int paramInt2)
    {
      RecyclerView localRecyclerView = this.b;
      if ((!this.e) || (this.a == -1) || (localRecyclerView == null)) {
        e();
      }
      this.d = false;
      if (this.f != null)
      {
        if (getChildPosition(this.f) != this.a) {
          break label151;
        }
        a(this.f, localRecyclerView.mState, this.g);
        this.g.a(localRecyclerView);
        e();
      }
      for (;;)
      {
        if (this.e)
        {
          a(paramInt1, paramInt2, localRecyclerView.mState, this.g);
          boolean bool = this.g.a();
          this.g.a(localRecyclerView);
          if (bool)
          {
            if (!this.e) {
              break;
            }
            this.d = true;
            localRecyclerView.mViewFlinger.a();
          }
        }
        return;
        label151:
        Log.e("RecyclerView", "Passed over target position while smooth scrolling.");
        this.f = null;
      }
      e();
    }
    
    protected abstract void a();
    
    protected abstract void a(int paramInt1, int paramInt2, RecyclerView.r paramr, a parama);
    
    protected void a(PointF paramPointF)
    {
      float f1 = (float)Math.sqrt(paramPointF.x * paramPointF.x + paramPointF.y * paramPointF.y);
      paramPointF.x /= f1;
      paramPointF.y /= f1;
    }
    
    void a(RecyclerView paramRecyclerView, RecyclerView.h paramh)
    {
      this.b = paramRecyclerView;
      this.c = paramh;
      if (this.a == -1) {
        throw new IllegalArgumentException("Invalid target position");
      }
      RecyclerView.r.a(this.b.mState, this.a);
      this.e = true;
      this.d = true;
      this.f = findViewByPosition(getTargetPosition());
      a();
      this.b.mViewFlinger.a();
    }
    
    protected void a(View paramView)
    {
      if (getChildPosition(paramView) == getTargetPosition()) {
        this.f = paramView;
      }
    }
    
    protected abstract void a(View paramView, RecyclerView.r paramr, a parama);
    
    protected abstract void b();
    
    protected final void e()
    {
      if (!this.e) {
        return;
      }
      b();
      RecyclerView.r.a(this.b.mState, -1);
      this.f = null;
      this.a = -1;
      this.d = false;
      this.e = false;
      RecyclerView.h.a(this.c, this);
      this.c = null;
      this.b = null;
    }
    
    public View findViewByPosition(int paramInt)
    {
      return this.b.mLayout.findViewByPosition(paramInt);
    }
    
    public int getChildCount()
    {
      return this.b.mLayout.getChildCount();
    }
    
    public int getChildPosition(View paramView)
    {
      return this.b.getChildLayoutPosition(paramView);
    }
    
    public RecyclerView.h getLayoutManager()
    {
      return this.c;
    }
    
    public int getTargetPosition()
    {
      return this.a;
    }
    
    @Deprecated
    public void instantScrollToPosition(int paramInt)
    {
      this.b.scrollToPosition(paramInt);
    }
    
    public boolean isPendingInitialRun()
    {
      return this.d;
    }
    
    public boolean isRunning()
    {
      return this.e;
    }
    
    public void setTargetPosition(int paramInt)
    {
      this.a = paramInt;
    }
    
    public static class a
    {
      private int a;
      private int b;
      private int c;
      private int d = -1;
      private Interpolator e;
      private boolean f = false;
      private int g = 0;
      
      public a(int paramInt1, int paramInt2)
      {
        this(paramInt1, paramInt2, Integer.MIN_VALUE, null);
      }
      
      public a(int paramInt1, int paramInt2, int paramInt3)
      {
        this(paramInt1, paramInt2, paramInt3, null);
      }
      
      public a(int paramInt1, int paramInt2, int paramInt3, Interpolator paramInterpolator)
      {
        this.a = paramInt1;
        this.b = paramInt2;
        this.c = paramInt3;
        this.e = paramInterpolator;
      }
      
      private void b()
      {
        if ((this.e != null) && (this.c < 1)) {
          throw new IllegalStateException("If you provide an interpolator, you must set a positive duration");
        }
        if (this.c < 1) {
          throw new IllegalStateException("Scroll duration must be a positive number");
        }
      }
      
      void a(RecyclerView paramRecyclerView)
      {
        if (this.d >= 0)
        {
          int i = this.d;
          this.d = -1;
          paramRecyclerView.jumpToPositionForSmoothScroller(i);
          this.f = false;
          return;
        }
        if (this.f)
        {
          b();
          if (this.e == null) {
            if (this.c == Integer.MIN_VALUE) {
              paramRecyclerView.mViewFlinger.smoothScrollBy(this.a, this.b);
            }
          }
          for (;;)
          {
            this.g += 1;
            if (this.g > 10) {
              Log.e("RecyclerView", "Smooth Scroll action is being updated too frequently. Make sure you are not changing it unless necessary");
            }
            this.f = false;
            return;
            paramRecyclerView.mViewFlinger.smoothScrollBy(this.a, this.b, this.c);
            continue;
            paramRecyclerView.mViewFlinger.smoothScrollBy(this.a, this.b, this.c, this.e);
          }
        }
        this.g = 0;
      }
      
      boolean a()
      {
        return this.d >= 0;
      }
      
      public int getDuration()
      {
        return this.c;
      }
      
      public int getDx()
      {
        return this.a;
      }
      
      public int getDy()
      {
        return this.b;
      }
      
      public Interpolator getInterpolator()
      {
        return this.e;
      }
      
      public void jumpTo(int paramInt)
      {
        this.d = paramInt;
      }
      
      public void setDuration(int paramInt)
      {
        this.f = true;
        this.c = paramInt;
      }
      
      public void setDx(int paramInt)
      {
        this.f = true;
        this.a = paramInt;
      }
      
      public void setDy(int paramInt)
      {
        this.f = true;
        this.b = paramInt;
      }
      
      public void setInterpolator(Interpolator paramInterpolator)
      {
        this.f = true;
        this.e = paramInterpolator;
      }
      
      public void update(int paramInt1, int paramInt2, int paramInt3, Interpolator paramInterpolator)
      {
        this.a = paramInt1;
        this.b = paramInt2;
        this.c = paramInt3;
        this.e = paramInterpolator;
        this.f = true;
      }
    }
    
    public static abstract interface b
    {
      public abstract PointF computeScrollVectorForPosition(int paramInt);
    }
  }
  
  public static class r
  {
    int a = 0;
    int b = 0;
    int c = 1;
    int d = 0;
    boolean e = false;
    boolean f = false;
    boolean g = false;
    boolean h = false;
    boolean i = false;
    boolean j = false;
    int k;
    long l;
    int m;
    int n;
    int o;
    private int p = -1;
    private SparseArray<Object> q;
    
    void a(int paramInt)
    {
      if ((this.c & paramInt) == 0) {
        throw new IllegalStateException("Layout state should be one of " + Integer.toBinaryString(paramInt) + " but it is " + Integer.toBinaryString(this.c));
      }
    }
    
    void a(RecyclerView.a parama)
    {
      this.c = 1;
      this.d = parama.getItemCount();
      this.f = false;
      this.g = false;
      this.h = false;
    }
    
    public boolean didStructureChange()
    {
      return this.e;
    }
    
    public <T> T get(int paramInt)
    {
      if (this.q == null) {
        return null;
      }
      return (T)this.q.get(paramInt);
    }
    
    public int getItemCount()
    {
      if (this.f) {
        return this.a - this.b;
      }
      return this.d;
    }
    
    public int getRemainingScrollHorizontal()
    {
      return this.n;
    }
    
    public int getRemainingScrollVertical()
    {
      return this.o;
    }
    
    public int getTargetScrollPosition()
    {
      return this.p;
    }
    
    public boolean hasTargetScrollPosition()
    {
      return this.p != -1;
    }
    
    public boolean isMeasuring()
    {
      return this.h;
    }
    
    public boolean isPreLayout()
    {
      return this.f;
    }
    
    public void put(int paramInt, Object paramObject)
    {
      if (this.q == null) {
        this.q = new SparseArray();
      }
      this.q.put(paramInt, paramObject);
    }
    
    public void remove(int paramInt)
    {
      if (this.q == null) {
        return;
      }
      this.q.remove(paramInt);
    }
    
    public String toString()
    {
      return "State{mTargetPosition=" + this.p + ", mData=" + this.q + ", mItemCount=" + this.d + ", mPreviousLayoutItemCount=" + this.a + ", mDeletedInvisibleItemCountSincePreviousLayout=" + this.b + ", mStructureChanged=" + this.e + ", mInPreLayout=" + this.f + ", mRunSimpleAnimations=" + this.i + ", mRunPredictiveAnimations=" + this.j + '}';
    }
    
    public boolean willRunPredictiveAnimations()
    {
      return this.j;
    }
    
    public boolean willRunSimpleAnimations()
    {
      return this.i;
    }
  }
  
  public static abstract class s
  {
    public abstract View getViewForPositionAndType(RecyclerView.n paramn, int paramInt1, int paramInt2);
  }
  
  class t
    implements Runnable
  {
    Interpolator a = RecyclerView.sQuinticInterpolator;
    private int c;
    private int d;
    private OverScroller e = new OverScroller(RecyclerView.this.getContext(), RecyclerView.sQuinticInterpolator);
    private boolean f = false;
    private boolean g = false;
    
    t() {}
    
    private float a(float paramFloat)
    {
      return (float)Math.sin((paramFloat - 0.5F) * 0.47123894F);
    }
    
    private int a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      int j = Math.abs(paramInt1);
      int k = Math.abs(paramInt2);
      int i;
      if (j > k)
      {
        i = 1;
        paramInt3 = (int)Math.sqrt(paramInt3 * paramInt3 + paramInt4 * paramInt4);
        paramInt2 = (int)Math.sqrt(paramInt1 * paramInt1 + paramInt2 * paramInt2);
        if (i == 0) {
          break label140;
        }
      }
      label140:
      for (paramInt1 = RecyclerView.this.getWidth();; paramInt1 = RecyclerView.this.getHeight())
      {
        paramInt4 = paramInt1 / 2;
        float f3 = Math.min(1.0F, paramInt2 * 1.0F / paramInt1);
        float f1 = paramInt4;
        float f2 = paramInt4;
        f3 = a(f3);
        if (paramInt3 <= 0) {
          break label151;
        }
        paramInt1 = Math.round(1000.0F * Math.abs((f3 * f2 + f1) / paramInt3)) * 4;
        return Math.min(paramInt1, 2000);
        i = 0;
        break;
      }
      label151:
      if (i != 0) {}
      for (paramInt2 = j;; paramInt2 = k)
      {
        paramInt1 = (int)((paramInt2 / paramInt1 + 1.0F) * 300.0F);
        break;
      }
    }
    
    private void b()
    {
      this.g = false;
      this.f = true;
    }
    
    private void c()
    {
      this.f = false;
      if (this.g) {
        a();
      }
    }
    
    void a()
    {
      if (this.f)
      {
        this.g = true;
        return;
      }
      RecyclerView.this.removeCallbacks(this);
      ViewCompat.postOnAnimation(RecyclerView.this, this);
    }
    
    public void fling(int paramInt1, int paramInt2)
    {
      RecyclerView.this.setScrollState(2);
      this.d = 0;
      this.c = 0;
      this.e.fling(0, 0, paramInt1, paramInt2, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
      a();
    }
    
    public void run()
    {
      if (RecyclerView.this.mLayout == null)
      {
        stop();
        return;
      }
      b();
      RecyclerView.this.consumePendingUpdateOperations();
      OverScroller localOverScroller = this.e;
      RecyclerView.q localq = RecyclerView.this.mLayout.t;
      int i5;
      int i6;
      int i1;
      int n;
      int i;
      if (localOverScroller.computeScrollOffset())
      {
        int[] arrayOfInt = RecyclerView.this.mScrollConsumed;
        i5 = localOverScroller.getCurrX();
        i6 = localOverScroller.getCurrY();
        i1 = i5 - this.c;
        n = i6 - this.d;
        this.c = i5;
        this.d = i6;
        if (!RecyclerView.this.dispatchNestedPreScroll(i1, n, arrayOfInt, null, 1)) {
          break label891;
        }
        i = arrayOfInt[0];
        n -= arrayOfInt[1];
        i1 -= i;
      }
      label261:
      label426:
      label445:
      label571:
      label597:
      label617:
      label770:
      label807:
      label812:
      label817:
      label858:
      label891:
      for (;;)
      {
        int m;
        int j;
        int k;
        int i2;
        if (RecyclerView.this.mAdapter != null)
        {
          RecyclerView.this.eatRequestLayout();
          RecyclerView.this.onEnterLayoutOrScroll();
          TraceCompat.beginSection("RV Scroll");
          RecyclerView.this.fillRemainingScrollValues(RecyclerView.this.mState);
          if (i1 != 0)
          {
            i = RecyclerView.this.mLayout.scrollHorizontallyBy(i1, RecyclerView.this.mRecycler, RecyclerView.this.mState);
            m = i1 - i;
            if (n != 0)
            {
              j = RecyclerView.this.mLayout.scrollVerticallyBy(n, RecyclerView.this.mRecycler, RecyclerView.this.mState);
              k = n - j;
              TraceCompat.endSection();
              RecyclerView.this.repositionShadowingViews();
              RecyclerView.this.onExitLayoutOrScroll();
              RecyclerView.this.resumeRequestLayout(false);
              if ((localq != null) && (!localq.isPendingInitialRun()) && (localq.isRunning()))
              {
                i2 = RecyclerView.this.mState.getItemCount();
                if (i2 == 0)
                {
                  localq.e();
                  i2 = m;
                }
              }
            }
          }
        }
        for (;;)
        {
          if (!RecyclerView.this.mItemDecorations.isEmpty()) {
            RecyclerView.this.invalidate();
          }
          if (RecyclerView.this.getOverScrollMode() != 2) {
            RecyclerView.this.considerReleasingGlowsOnScroll(i1, n);
          }
          int i3;
          if ((!RecyclerView.this.dispatchNestedScroll(i, j, i2, k, null, 1)) && ((i2 != 0) || (k != 0)))
          {
            i3 = (int)localOverScroller.getCurrVelocity();
            if (i2 == i5) {
              break label858;
            }
            if (i2 >= 0) {
              break label770;
            }
            m = -i3;
          }
          for (int i4 = m;; i4 = 0)
          {
            if (k != i6) {
              if (k < 0) {
                m = -i3;
              }
            }
            for (;;)
            {
              if (RecyclerView.this.getOverScrollMode() != 2) {
                RecyclerView.this.absorbGlows(i4, m);
              }
              if (((i4 != 0) || (i2 == i5) || (localOverScroller.getFinalX() == 0)) && ((m != 0) || (k == i6) || (localOverScroller.getFinalY() == 0))) {
                localOverScroller.abortAnimation();
              }
              if ((i != 0) || (j != 0)) {
                RecyclerView.this.dispatchOnScrolled(i, j);
              }
              if (!RecyclerView.this.awakenScrollBars()) {
                RecyclerView.this.invalidate();
              }
              if ((n != 0) && (RecyclerView.this.mLayout.canScrollVertically()) && (j == n))
              {
                j = 1;
                if ((i1 == 0) || (!RecyclerView.this.mLayout.canScrollHorizontally()) || (i != i1)) {
                  break label807;
                }
                i = 1;
                if (((i1 != 0) || (n != 0)) && (i == 0) && (j == 0)) {
                  break label812;
                }
                i = 1;
                if ((!localOverScroller.isFinished()) && ((i != 0) || (RecyclerView.this.hasNestedScrollingParent(1)))) {
                  break label817;
                }
                RecyclerView.this.setScrollState(0);
                if (RecyclerView.ALLOW_THREAD_GAP_WORK) {
                  RecyclerView.this.mPrefetchRegistry.a();
                }
                RecyclerView.this.stopNestedScroll(1);
              }
              for (;;)
              {
                if (localq != null)
                {
                  if (localq.isPendingInitialRun()) {
                    RecyclerView.q.a(localq, 0, 0);
                  }
                  if (!this.g) {
                    localq.e();
                  }
                }
                c();
                return;
                if (localq.getTargetPosition() >= i2)
                {
                  localq.setTargetPosition(i2 - 1);
                  RecyclerView.q.a(localq, i1 - m, n - k);
                  i2 = m;
                  break;
                }
                RecyclerView.q.a(localq, i1 - m, n - k);
                i2 = m;
                break;
                if (i2 > 0)
                {
                  m = i3;
                  break label426;
                }
                m = 0;
                break label426;
                m = i3;
                if (k > 0) {
                  break label445;
                }
                m = 0;
                break label445;
                j = 0;
                break label571;
                i = 0;
                break label597;
                i = 0;
                break label617;
                a();
                if (RecyclerView.this.mGapWorker != null) {
                  RecyclerView.this.mGapWorker.a(RecyclerView.this, i1, n);
                }
              }
              m = 0;
            }
          }
          k = 0;
          j = 0;
          break label261;
          m = 0;
          i = 0;
          break;
          k = 0;
          i2 = 0;
          j = 0;
          i = 0;
        }
      }
    }
    
    public void smoothScrollBy(int paramInt1, int paramInt2)
    {
      smoothScrollBy(paramInt1, paramInt2, 0, 0);
    }
    
    public void smoothScrollBy(int paramInt1, int paramInt2, int paramInt3)
    {
      smoothScrollBy(paramInt1, paramInt2, paramInt3, RecyclerView.sQuinticInterpolator);
    }
    
    public void smoothScrollBy(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      smoothScrollBy(paramInt1, paramInt2, a(paramInt1, paramInt2, paramInt3, paramInt4));
    }
    
    public void smoothScrollBy(int paramInt1, int paramInt2, int paramInt3, Interpolator paramInterpolator)
    {
      if (this.a != paramInterpolator)
      {
        this.a = paramInterpolator;
        this.e = new OverScroller(RecyclerView.this.getContext(), paramInterpolator);
      }
      RecyclerView.this.setScrollState(2);
      this.d = 0;
      this.c = 0;
      this.e.startScroll(0, 0, paramInt1, paramInt2, paramInt3);
      if (Build.VERSION.SDK_INT < 23) {
        this.e.computeScrollOffset();
      }
      a();
    }
    
    public void smoothScrollBy(int paramInt1, int paramInt2, Interpolator paramInterpolator)
    {
      int i = a(paramInt1, paramInt2, 0, 0);
      Interpolator localInterpolator = paramInterpolator;
      if (paramInterpolator == null) {
        localInterpolator = RecyclerView.sQuinticInterpolator;
      }
      smoothScrollBy(paramInt1, paramInt2, i, localInterpolator);
    }
    
    public void stop()
    {
      RecyclerView.this.removeCallbacks(this);
      this.e.abortAnimation();
    }
  }
  
  public static abstract class u
  {
    static final int FLAG_ADAPTER_FULLUPDATE = 1024;
    static final int FLAG_ADAPTER_POSITION_UNKNOWN = 512;
    static final int FLAG_APPEARED_IN_PRE_LAYOUT = 4096;
    static final int FLAG_BOUNCED_FROM_HIDDEN_LIST = 8192;
    static final int FLAG_BOUND = 1;
    static final int FLAG_IGNORE = 128;
    static final int FLAG_INVALID = 4;
    static final int FLAG_MOVED = 2048;
    static final int FLAG_NOT_RECYCLABLE = 16;
    static final int FLAG_REMOVED = 8;
    static final int FLAG_RETURNED_FROM_SCRAP = 32;
    static final int FLAG_SET_A11Y_ITEM_DELEGATE = 16384;
    static final int FLAG_TMP_DETACHED = 256;
    static final int FLAG_UPDATE = 2;
    private static final List<Object> FULLUPDATE_PAYLOADS = Collections.EMPTY_LIST;
    static final int PENDING_ACCESSIBILITY_STATE_NOT_SET = -1;
    public final View itemView;
    private int mFlags;
    private boolean mInChangeScrap = false;
    private int mIsRecyclableCount = 0;
    long mItemId = -1L;
    int mItemViewType = -1;
    WeakReference<RecyclerView> mNestedRecyclerView;
    int mOldPosition = -1;
    RecyclerView mOwnerRecyclerView;
    List<Object> mPayloads = null;
    int mPendingAccessibilityState = -1;
    int mPosition = -1;
    int mPreLayoutPosition = -1;
    private RecyclerView.n mScrapContainer = null;
    u mShadowedHolder = null;
    u mShadowingHolder = null;
    List<Object> mUnmodifiedPayloads = null;
    private int mWasImportantForAccessibilityBeforeHidden = 0;
    
    public u(View paramView)
    {
      if (paramView == null) {
        throw new IllegalArgumentException("itemView may not be null");
      }
      this.itemView = paramView;
    }
    
    private void createPayloadsIfNeeded()
    {
      if (this.mPayloads == null)
      {
        this.mPayloads = new ArrayList();
        this.mUnmodifiedPayloads = Collections.unmodifiableList(this.mPayloads);
      }
    }
    
    private boolean doesTransientStatePreventRecycling()
    {
      return ((this.mFlags & 0x10) == 0) && (ViewCompat.hasTransientState(this.itemView));
    }
    
    private void onEnteredHiddenState(RecyclerView paramRecyclerView)
    {
      this.mWasImportantForAccessibilityBeforeHidden = ViewCompat.getImportantForAccessibility(this.itemView);
      paramRecyclerView.setChildImportantForAccessibilityInternal(this, 4);
    }
    
    private void onLeftHiddenState(RecyclerView paramRecyclerView)
    {
      paramRecyclerView.setChildImportantForAccessibilityInternal(this, this.mWasImportantForAccessibilityBeforeHidden);
      this.mWasImportantForAccessibilityBeforeHidden = 0;
    }
    
    private boolean shouldBeKeptAsChild()
    {
      return (this.mFlags & 0x10) != 0;
    }
    
    void addChangePayload(Object paramObject)
    {
      if (paramObject == null) {
        addFlags(1024);
      }
      while ((this.mFlags & 0x400) != 0) {
        return;
      }
      createPayloadsIfNeeded();
      this.mPayloads.add(paramObject);
    }
    
    void addFlags(int paramInt)
    {
      this.mFlags |= paramInt;
    }
    
    void clearOldPosition()
    {
      this.mOldPosition = -1;
      this.mPreLayoutPosition = -1;
    }
    
    void clearPayload()
    {
      if (this.mPayloads != null) {
        this.mPayloads.clear();
      }
      this.mFlags &= 0xFBFF;
    }
    
    void clearReturnedFromScrapFlag()
    {
      this.mFlags &= 0xFFFFFFDF;
    }
    
    void clearTmpDetachFlag()
    {
      this.mFlags &= 0xFEFF;
    }
    
    void flagRemovedAndOffsetPosition(int paramInt1, int paramInt2, boolean paramBoolean)
    {
      addFlags(8);
      offsetPosition(paramInt2, paramBoolean);
      this.mPosition = paramInt1;
    }
    
    public final int getAdapterPosition()
    {
      if (this.mOwnerRecyclerView == null) {
        return -1;
      }
      return this.mOwnerRecyclerView.getAdapterPositionFor(this);
    }
    
    public final long getItemId()
    {
      return this.mItemId;
    }
    
    public final int getItemViewType()
    {
      return this.mItemViewType;
    }
    
    public final int getLayoutPosition()
    {
      if (this.mPreLayoutPosition == -1) {
        return this.mPosition;
      }
      return this.mPreLayoutPosition;
    }
    
    public final int getOldPosition()
    {
      return this.mOldPosition;
    }
    
    @Deprecated
    public final int getPosition()
    {
      if (this.mPreLayoutPosition == -1) {
        return this.mPosition;
      }
      return this.mPreLayoutPosition;
    }
    
    List<Object> getUnmodifiedPayloads()
    {
      if ((this.mFlags & 0x400) == 0)
      {
        if ((this.mPayloads == null) || (this.mPayloads.size() == 0)) {
          return FULLUPDATE_PAYLOADS;
        }
        return this.mUnmodifiedPayloads;
      }
      return FULLUPDATE_PAYLOADS;
    }
    
    boolean hasAnyOfTheFlags(int paramInt)
    {
      return (this.mFlags & paramInt) != 0;
    }
    
    boolean isAdapterPositionUnknown()
    {
      return ((this.mFlags & 0x200) != 0) || (isInvalid());
    }
    
    boolean isBound()
    {
      return (this.mFlags & 0x1) != 0;
    }
    
    boolean isInvalid()
    {
      return (this.mFlags & 0x4) != 0;
    }
    
    public final boolean isRecyclable()
    {
      return ((this.mFlags & 0x10) == 0) && (!ViewCompat.hasTransientState(this.itemView));
    }
    
    boolean isRemoved()
    {
      return (this.mFlags & 0x8) != 0;
    }
    
    boolean isScrap()
    {
      return this.mScrapContainer != null;
    }
    
    boolean isTmpDetached()
    {
      return (this.mFlags & 0x100) != 0;
    }
    
    boolean isUpdated()
    {
      return (this.mFlags & 0x2) != 0;
    }
    
    boolean needsUpdate()
    {
      return (this.mFlags & 0x2) != 0;
    }
    
    void offsetPosition(int paramInt, boolean paramBoolean)
    {
      if (this.mOldPosition == -1) {
        this.mOldPosition = this.mPosition;
      }
      if (this.mPreLayoutPosition == -1) {
        this.mPreLayoutPosition = this.mPosition;
      }
      if (paramBoolean) {
        this.mPreLayoutPosition += paramInt;
      }
      this.mPosition += paramInt;
      if (this.itemView.getLayoutParams() != null) {
        ((RecyclerView.LayoutParams)this.itemView.getLayoutParams()).e = true;
      }
    }
    
    void resetInternal()
    {
      this.mFlags = 0;
      this.mPosition = -1;
      this.mOldPosition = -1;
      this.mItemId = -1L;
      this.mPreLayoutPosition = -1;
      this.mIsRecyclableCount = 0;
      this.mShadowedHolder = null;
      this.mShadowingHolder = null;
      clearPayload();
      this.mWasImportantForAccessibilityBeforeHidden = 0;
      this.mPendingAccessibilityState = -1;
      RecyclerView.clearNestedRecyclerViewIfNotNested(this);
    }
    
    void saveOldPosition()
    {
      if (this.mOldPosition == -1) {
        this.mOldPosition = this.mPosition;
      }
    }
    
    void setFlags(int paramInt1, int paramInt2)
    {
      this.mFlags = (this.mFlags & (paramInt2 ^ 0xFFFFFFFF) | paramInt1 & paramInt2);
    }
    
    public final void setIsRecyclable(boolean paramBoolean)
    {
      int i;
      if (paramBoolean)
      {
        i = this.mIsRecyclableCount - 1;
        this.mIsRecyclableCount = i;
        if (this.mIsRecyclableCount >= 0) {
          break label66;
        }
        this.mIsRecyclableCount = 0;
        Log.e("View", "isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for " + this);
      }
      label66:
      do
      {
        return;
        i = this.mIsRecyclableCount + 1;
        break;
        if ((!paramBoolean) && (this.mIsRecyclableCount == 1))
        {
          this.mFlags |= 0x10;
          return;
        }
      } while ((!paramBoolean) || (this.mIsRecyclableCount != 0));
      this.mFlags &= 0xFFFFFFEF;
    }
    
    void setScrapContainer(RecyclerView.n paramn, boolean paramBoolean)
    {
      this.mScrapContainer = paramn;
      this.mInChangeScrap = paramBoolean;
    }
    
    boolean shouldIgnore()
    {
      return (this.mFlags & 0x80) != 0;
    }
    
    void stopIgnoring()
    {
      this.mFlags &= 0xFF7F;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder1 = new StringBuilder("ViewHolder{" + Integer.toHexString(hashCode()) + " position=" + this.mPosition + " id=" + this.mItemId + ", oldPos=" + this.mOldPosition + ", pLpos:" + this.mPreLayoutPosition);
      StringBuilder localStringBuilder2;
      if (isScrap())
      {
        localStringBuilder2 = localStringBuilder1.append(" scrap ");
        if (!this.mInChangeScrap) {
          break label295;
        }
      }
      label295:
      for (String str = "[changeScrap]";; str = "[attachedScrap]")
      {
        localStringBuilder2.append(str);
        if (isInvalid()) {
          localStringBuilder1.append(" invalid");
        }
        if (!isBound()) {
          localStringBuilder1.append(" unbound");
        }
        if (needsUpdate()) {
          localStringBuilder1.append(" update");
        }
        if (isRemoved()) {
          localStringBuilder1.append(" removed");
        }
        if (shouldIgnore()) {
          localStringBuilder1.append(" ignored");
        }
        if (isTmpDetached()) {
          localStringBuilder1.append(" tmpDetached");
        }
        if (!isRecyclable()) {
          localStringBuilder1.append(" not recyclable(" + this.mIsRecyclableCount + ")");
        }
        if (isAdapterPositionUnknown()) {
          localStringBuilder1.append(" undefined adapter position");
        }
        if (this.itemView.getParent() == null) {
          localStringBuilder1.append(" no parent");
        }
        localStringBuilder1.append("}");
        return localStringBuilder1.toString();
      }
    }
    
    void unScrap()
    {
      this.mScrapContainer.c(this);
    }
    
    boolean wasReturnedFromScrap()
    {
      return (this.mFlags & 0x20) != 0;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/android/support/v7/widget/RecyclerView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */