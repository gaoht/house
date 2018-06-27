package android.support.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Path;
import android.graphics.Rect;
import android.support.v4.content.res.TypedArrayUtils;
import android.support.v4.util.ArrayMap;
import android.support.v4.util.LongSparseArray;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.InflateException;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ListAdapter;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public abstract class Transition
  implements Cloneable
{
  static final boolean DBG = false;
  private static final int[] DEFAULT_MATCH_ORDER = { 2, 1, 3, 4 };
  private static final String LOG_TAG = "Transition";
  private static final int MATCH_FIRST = 1;
  public static final int MATCH_ID = 3;
  private static final String MATCH_ID_STR = "id";
  public static final int MATCH_INSTANCE = 1;
  private static final String MATCH_INSTANCE_STR = "instance";
  public static final int MATCH_ITEM_ID = 4;
  private static final String MATCH_ITEM_ID_STR = "itemId";
  private static final int MATCH_LAST = 4;
  public static final int MATCH_NAME = 2;
  private static final String MATCH_NAME_STR = "name";
  private static final PathMotion STRAIGHT_PATH_MOTION = new PathMotion()
  {
    public Path getPath(float paramAnonymousFloat1, float paramAnonymousFloat2, float paramAnonymousFloat3, float paramAnonymousFloat4)
    {
      Path localPath = new Path();
      localPath.moveTo(paramAnonymousFloat1, paramAnonymousFloat2);
      localPath.lineTo(paramAnonymousFloat3, paramAnonymousFloat4);
      return localPath;
    }
  };
  private static ThreadLocal<ArrayMap<Animator, a>> sRunningAnimators = new ThreadLocal();
  private ArrayList<Animator> mAnimators = new ArrayList();
  boolean mCanRemoveViews = false;
  private ArrayList<Animator> mCurrentAnimators = new ArrayList();
  long mDuration = -1L;
  private ah mEndValues = new ah();
  private ArrayList<ag> mEndValuesList;
  private boolean mEnded = false;
  private c mEpicenterCallback;
  private TimeInterpolator mInterpolator = null;
  private ArrayList<d> mListeners = null;
  private int[] mMatchOrder = DEFAULT_MATCH_ORDER;
  private String mName = getClass().getName();
  private ArrayMap<String, String> mNameOverrides;
  private int mNumInstances = 0;
  TransitionSet mParent = null;
  private PathMotion mPathMotion = STRAIGHT_PATH_MOTION;
  private boolean mPaused = false;
  ae mPropagation;
  private ViewGroup mSceneRoot = null;
  private long mStartDelay = -1L;
  private ah mStartValues = new ah();
  private ArrayList<ag> mStartValuesList;
  private ArrayList<View> mTargetChildExcludes = null;
  private ArrayList<View> mTargetExcludes = null;
  private ArrayList<Integer> mTargetIdChildExcludes = null;
  private ArrayList<Integer> mTargetIdExcludes = null;
  ArrayList<Integer> mTargetIds = new ArrayList();
  private ArrayList<String> mTargetNameExcludes = null;
  private ArrayList<String> mTargetNames = null;
  private ArrayList<Class> mTargetTypeChildExcludes = null;
  private ArrayList<Class> mTargetTypeExcludes = null;
  private ArrayList<Class> mTargetTypes = null;
  ArrayList<View> mTargets = new ArrayList();
  
  public Transition() {}
  
  public Transition(Context paramContext, AttributeSet paramAttributeSet)
  {
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, ab.c);
    paramAttributeSet = (XmlResourceParser)paramAttributeSet;
    long l = TypedArrayUtils.getNamedInt(localTypedArray, paramAttributeSet, "duration", 1, -1);
    if (l >= 0L) {
      setDuration(l);
    }
    l = TypedArrayUtils.getNamedInt(localTypedArray, paramAttributeSet, "startDelay", 2, -1);
    if (l > 0L) {
      setStartDelay(l);
    }
    int i = TypedArrayUtils.getNamedResourceId(localTypedArray, paramAttributeSet, "interpolator", 0, 0);
    if (i > 0) {
      setInterpolator(AnimationUtils.loadInterpolator(paramContext, i));
    }
    paramContext = TypedArrayUtils.getNamedString(localTypedArray, paramAttributeSet, "matchOrder", 3);
    if (paramContext != null) {
      setMatchOrder(parseMatchOrder(paramContext));
    }
    localTypedArray.recycle();
  }
  
  private void addUnmatched(ArrayMap<View, ag> paramArrayMap1, ArrayMap<View, ag> paramArrayMap2)
  {
    int k = 0;
    int i = 0;
    int j;
    for (;;)
    {
      j = k;
      if (i >= paramArrayMap1.size()) {
        break;
      }
      ag localag = (ag)paramArrayMap1.valueAt(i);
      if (isValidTarget(localag.b))
      {
        this.mStartValuesList.add(localag);
        this.mEndValuesList.add(null);
      }
      i += 1;
    }
    while (j < paramArrayMap2.size())
    {
      paramArrayMap1 = (ag)paramArrayMap2.valueAt(j);
      if (isValidTarget(paramArrayMap1.b))
      {
        this.mEndValuesList.add(paramArrayMap1);
        this.mStartValuesList.add(null);
      }
      j += 1;
    }
  }
  
  private static void addViewValues(ah paramah, View paramView, ag paramag)
  {
    paramah.a.put(paramView, paramag);
    int i = paramView.getId();
    if (i >= 0)
    {
      if (paramah.b.indexOfKey(i) >= 0) {
        paramah.b.put(i, null);
      }
    }
    else
    {
      paramag = ViewCompat.getTransitionName(paramView);
      if (paramag != null)
      {
        if (!paramah.d.containsKey(paramag)) {
          break label167;
        }
        paramah.d.put(paramag, null);
      }
    }
    long l;
    for (;;)
    {
      if ((paramView.getParent() instanceof ListView))
      {
        paramag = (ListView)paramView.getParent();
        if (paramag.getAdapter().hasStableIds())
        {
          l = paramag.getItemIdAtPosition(paramag.getPositionForView(paramView));
          if (paramah.c.indexOfKey(l) < 0) {
            break label180;
          }
          paramView = (View)paramah.c.get(l);
          if (paramView != null)
          {
            ViewCompat.setHasTransientState(paramView, false);
            paramah.c.put(l, null);
          }
        }
      }
      return;
      paramah.b.put(i, paramView);
      break;
      label167:
      paramah.d.put(paramag, paramView);
    }
    label180:
    ViewCompat.setHasTransientState(paramView, true);
    paramah.c.put(l, paramView);
  }
  
  private static boolean alreadyContains(int[] paramArrayOfInt, int paramInt)
  {
    boolean bool2 = false;
    int j = paramArrayOfInt[paramInt];
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < paramInt)
      {
        if (paramArrayOfInt[i] == j) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  private void captureHierarchy(View paramView, boolean paramBoolean)
  {
    if (paramView == null) {}
    for (;;)
    {
      return;
      int j = paramView.getId();
      if (((this.mTargetIdExcludes == null) || (!this.mTargetIdExcludes.contains(Integer.valueOf(j)))) && ((this.mTargetExcludes == null) || (!this.mTargetExcludes.contains(paramView))))
      {
        if (this.mTargetTypeExcludes != null)
        {
          int k = this.mTargetTypeExcludes.size();
          i = 0;
          for (;;)
          {
            if (i >= k) {
              break label100;
            }
            if (((Class)this.mTargetTypeExcludes.get(i)).isInstance(paramView)) {
              break;
            }
            i += 1;
          }
        }
        label100:
        ag localag;
        if ((paramView.getParent() instanceof ViewGroup))
        {
          localag = new ag();
          localag.b = paramView;
          if (!paramBoolean) {
            break label261;
          }
          captureStartValues(localag);
          label135:
          localag.c.add(this);
          capturePropagationValues(localag);
          if (!paramBoolean) {
            break label270;
          }
          addViewValues(this.mStartValues, paramView, localag);
        }
        for (;;)
        {
          if ((!(paramView instanceof ViewGroup)) || ((this.mTargetIdChildExcludes != null) && (this.mTargetIdChildExcludes.contains(Integer.valueOf(j)))) || ((this.mTargetChildExcludes != null) && (this.mTargetChildExcludes.contains(paramView)))) {
            break label281;
          }
          if (this.mTargetTypeChildExcludes == null) {
            break label283;
          }
          j = this.mTargetTypeChildExcludes.size();
          i = 0;
          for (;;)
          {
            if (i >= j) {
              break label283;
            }
            if (((Class)this.mTargetTypeChildExcludes.get(i)).isInstance(paramView)) {
              break;
            }
            i += 1;
          }
          label261:
          captureEndValues(localag);
          break label135;
          label270:
          addViewValues(this.mEndValues, paramView, localag);
        }
        label281:
        continue;
        label283:
        paramView = (ViewGroup)paramView;
        int i = 0;
        while (i < paramView.getChildCount())
        {
          captureHierarchy(paramView.getChildAt(i), paramBoolean);
          i += 1;
        }
      }
    }
  }
  
  private ArrayList<Integer> excludeId(ArrayList<Integer> paramArrayList, int paramInt, boolean paramBoolean)
  {
    Object localObject = paramArrayList;
    if (paramInt > 0)
    {
      if (paramBoolean) {
        localObject = b.a(paramArrayList, Integer.valueOf(paramInt));
      }
    }
    else {
      return (ArrayList<Integer>)localObject;
    }
    return b.b(paramArrayList, Integer.valueOf(paramInt));
  }
  
  private static <T> ArrayList<T> excludeObject(ArrayList<T> paramArrayList, T paramT, boolean paramBoolean)
  {
    Object localObject = paramArrayList;
    if (paramT != null)
    {
      if (paramBoolean) {
        localObject = b.a(paramArrayList, paramT);
      }
    }
    else {
      return (ArrayList<T>)localObject;
    }
    return b.b(paramArrayList, paramT);
  }
  
  private ArrayList<Class> excludeType(ArrayList<Class> paramArrayList, Class paramClass, boolean paramBoolean)
  {
    Object localObject = paramArrayList;
    if (paramClass != null)
    {
      if (paramBoolean) {
        localObject = b.a(paramArrayList, paramClass);
      }
    }
    else {
      return (ArrayList<Class>)localObject;
    }
    return b.b(paramArrayList, paramClass);
  }
  
  private ArrayList<View> excludeView(ArrayList<View> paramArrayList, View paramView, boolean paramBoolean)
  {
    Object localObject = paramArrayList;
    if (paramView != null)
    {
      if (paramBoolean) {
        localObject = b.a(paramArrayList, paramView);
      }
    }
    else {
      return (ArrayList<View>)localObject;
    }
    return b.b(paramArrayList, paramView);
  }
  
  private static ArrayMap<Animator, a> getRunningAnimators()
  {
    ArrayMap localArrayMap2 = (ArrayMap)sRunningAnimators.get();
    ArrayMap localArrayMap1 = localArrayMap2;
    if (localArrayMap2 == null)
    {
      localArrayMap1 = new ArrayMap();
      sRunningAnimators.set(localArrayMap1);
    }
    return localArrayMap1;
  }
  
  private static boolean isValidMatch(int paramInt)
  {
    return (paramInt >= 1) && (paramInt <= 4);
  }
  
  private static boolean isValueChanged(ag paramag1, ag paramag2, String paramString)
  {
    boolean bool2 = true;
    paramag1 = paramag1.a.get(paramString);
    paramag2 = paramag2.a.get(paramString);
    boolean bool1;
    if ((paramag1 == null) && (paramag2 == null)) {
      bool1 = false;
    }
    do
    {
      do
      {
        do
        {
          return bool1;
          bool1 = bool2;
        } while (paramag1 == null);
        bool1 = bool2;
      } while (paramag2 == null);
      bool1 = bool2;
    } while (!paramag1.equals(paramag2));
    return false;
  }
  
  private void matchIds(ArrayMap<View, ag> paramArrayMap1, ArrayMap<View, ag> paramArrayMap2, SparseArray<View> paramSparseArray1, SparseArray<View> paramSparseArray2)
  {
    int j = paramSparseArray1.size();
    int i = 0;
    while (i < j)
    {
      View localView1 = (View)paramSparseArray1.valueAt(i);
      if ((localView1 != null) && (isValidTarget(localView1)))
      {
        View localView2 = (View)paramSparseArray2.get(paramSparseArray1.keyAt(i));
        if ((localView2 != null) && (isValidTarget(localView2)))
        {
          ag localag1 = (ag)paramArrayMap1.get(localView1);
          ag localag2 = (ag)paramArrayMap2.get(localView2);
          if ((localag1 != null) && (localag2 != null))
          {
            this.mStartValuesList.add(localag1);
            this.mEndValuesList.add(localag2);
            paramArrayMap1.remove(localView1);
            paramArrayMap2.remove(localView2);
          }
        }
      }
      i += 1;
    }
  }
  
  private void matchInstances(ArrayMap<View, ag> paramArrayMap1, ArrayMap<View, ag> paramArrayMap2)
  {
    int i = paramArrayMap1.size() - 1;
    while (i >= 0)
    {
      Object localObject = (View)paramArrayMap1.keyAt(i);
      if ((localObject != null) && (isValidTarget((View)localObject)))
      {
        localObject = (ag)paramArrayMap2.remove(localObject);
        if ((localObject != null) && (((ag)localObject).b != null) && (isValidTarget(((ag)localObject).b)))
        {
          ag localag = (ag)paramArrayMap1.removeAt(i);
          this.mStartValuesList.add(localag);
          this.mEndValuesList.add(localObject);
        }
      }
      i -= 1;
    }
  }
  
  private void matchItemIds(ArrayMap<View, ag> paramArrayMap1, ArrayMap<View, ag> paramArrayMap2, LongSparseArray<View> paramLongSparseArray1, LongSparseArray<View> paramLongSparseArray2)
  {
    int j = paramLongSparseArray1.size();
    int i = 0;
    while (i < j)
    {
      View localView1 = (View)paramLongSparseArray1.valueAt(i);
      if ((localView1 != null) && (isValidTarget(localView1)))
      {
        View localView2 = (View)paramLongSparseArray2.get(paramLongSparseArray1.keyAt(i));
        if ((localView2 != null) && (isValidTarget(localView2)))
        {
          ag localag1 = (ag)paramArrayMap1.get(localView1);
          ag localag2 = (ag)paramArrayMap2.get(localView2);
          if ((localag1 != null) && (localag2 != null))
          {
            this.mStartValuesList.add(localag1);
            this.mEndValuesList.add(localag2);
            paramArrayMap1.remove(localView1);
            paramArrayMap2.remove(localView2);
          }
        }
      }
      i += 1;
    }
  }
  
  private void matchNames(ArrayMap<View, ag> paramArrayMap1, ArrayMap<View, ag> paramArrayMap2, ArrayMap<String, View> paramArrayMap3, ArrayMap<String, View> paramArrayMap4)
  {
    int j = paramArrayMap3.size();
    int i = 0;
    while (i < j)
    {
      View localView1 = (View)paramArrayMap3.valueAt(i);
      if ((localView1 != null) && (isValidTarget(localView1)))
      {
        View localView2 = (View)paramArrayMap4.get(paramArrayMap3.keyAt(i));
        if ((localView2 != null) && (isValidTarget(localView2)))
        {
          ag localag1 = (ag)paramArrayMap1.get(localView1);
          ag localag2 = (ag)paramArrayMap2.get(localView2);
          if ((localag1 != null) && (localag2 != null))
          {
            this.mStartValuesList.add(localag1);
            this.mEndValuesList.add(localag2);
            paramArrayMap1.remove(localView1);
            paramArrayMap2.remove(localView2);
          }
        }
      }
      i += 1;
    }
  }
  
  private void matchStartAndEnd(ah paramah1, ah paramah2)
  {
    ArrayMap localArrayMap1 = new ArrayMap(paramah1.a);
    ArrayMap localArrayMap2 = new ArrayMap(paramah2.a);
    int i = 0;
    if (i < this.mMatchOrder.length)
    {
      switch (this.mMatchOrder[i])
      {
      }
      for (;;)
      {
        i += 1;
        break;
        matchInstances(localArrayMap1, localArrayMap2);
        continue;
        matchNames(localArrayMap1, localArrayMap2, paramah1.d, paramah2.d);
        continue;
        matchIds(localArrayMap1, localArrayMap2, paramah1.b, paramah2.b);
        continue;
        matchItemIds(localArrayMap1, localArrayMap2, paramah1.c, paramah2.c);
      }
    }
    addUnmatched(localArrayMap1, localArrayMap2);
  }
  
  private static int[] parseMatchOrder(String paramString)
  {
    StringTokenizer localStringTokenizer = new StringTokenizer(paramString, ",");
    paramString = new int[localStringTokenizer.countTokens()];
    int i = 0;
    if (localStringTokenizer.hasMoreTokens())
    {
      Object localObject = localStringTokenizer.nextToken().trim();
      if ("id".equalsIgnoreCase((String)localObject)) {
        paramString[i] = 3;
      }
      for (;;)
      {
        i += 1;
        break;
        if ("instance".equalsIgnoreCase((String)localObject))
        {
          paramString[i] = 1;
        }
        else if ("name".equalsIgnoreCase((String)localObject))
        {
          paramString[i] = 2;
        }
        else if ("itemId".equalsIgnoreCase((String)localObject))
        {
          paramString[i] = 4;
        }
        else
        {
          if (!((String)localObject).isEmpty()) {
            break label135;
          }
          localObject = new int[paramString.length - 1];
          System.arraycopy(paramString, 0, localObject, 0, i);
          i -= 1;
          paramString = (String)localObject;
        }
      }
      label135:
      throw new InflateException("Unknown match type in matchOrder: '" + (String)localObject + "'");
    }
    return paramString;
  }
  
  private void runAnimator(Animator paramAnimator, final ArrayMap<Animator, a> paramArrayMap)
  {
    if (paramAnimator != null)
    {
      paramAnimator.addListener(new AnimatorListenerAdapter()
      {
        public void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          paramArrayMap.remove(paramAnonymousAnimator);
          Transition.this.mCurrentAnimators.remove(paramAnonymousAnimator);
        }
        
        public void onAnimationStart(Animator paramAnonymousAnimator)
        {
          Transition.this.mCurrentAnimators.add(paramAnonymousAnimator);
        }
      });
      animate(paramAnimator);
    }
  }
  
  public Transition addListener(d paramd)
  {
    if (this.mListeners == null) {
      this.mListeners = new ArrayList();
    }
    this.mListeners.add(paramd);
    return this;
  }
  
  public Transition addTarget(int paramInt)
  {
    if (paramInt > 0) {
      this.mTargetIds.add(Integer.valueOf(paramInt));
    }
    return this;
  }
  
  public Transition addTarget(View paramView)
  {
    this.mTargets.add(paramView);
    return this;
  }
  
  public Transition addTarget(Class paramClass)
  {
    if (this.mTargetTypes == null) {
      this.mTargetTypes = new ArrayList();
    }
    this.mTargetTypes.add(paramClass);
    return this;
  }
  
  public Transition addTarget(String paramString)
  {
    if (this.mTargetNames == null) {
      this.mTargetNames = new ArrayList();
    }
    this.mTargetNames.add(paramString);
    return this;
  }
  
  protected void animate(Animator paramAnimator)
  {
    if (paramAnimator == null)
    {
      end();
      return;
    }
    if (getDuration() >= 0L) {
      paramAnimator.setDuration(getDuration());
    }
    if (getStartDelay() >= 0L) {
      paramAnimator.setStartDelay(getStartDelay());
    }
    if (getInterpolator() != null) {
      paramAnimator.setInterpolator(getInterpolator());
    }
    paramAnimator.addListener(new AnimatorListenerAdapter()
    {
      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        Transition.this.end();
        paramAnonymousAnimator.removeListener(this);
      }
    });
    paramAnimator.start();
  }
  
  protected void cancel()
  {
    int i = this.mCurrentAnimators.size() - 1;
    while (i >= 0)
    {
      ((Animator)this.mCurrentAnimators.get(i)).cancel();
      i -= 1;
    }
    if ((this.mListeners != null) && (this.mListeners.size() > 0))
    {
      ArrayList localArrayList = (ArrayList)this.mListeners.clone();
      int j = localArrayList.size();
      i = 0;
      while (i < j)
      {
        ((d)localArrayList.get(i)).onTransitionCancel(this);
        i += 1;
      }
    }
  }
  
  public abstract void captureEndValues(ag paramag);
  
  void capturePropagationValues(ag paramag)
  {
    int j = 0;
    String[] arrayOfString;
    if ((this.mPropagation != null) && (!paramag.a.isEmpty()))
    {
      arrayOfString = this.mPropagation.getPropagationProperties();
      if (arrayOfString != null) {
        break label36;
      }
    }
    label36:
    label86:
    for (;;)
    {
      return;
      int i = 0;
      if (i < arrayOfString.length) {
        if (paramag.a.containsKey(arrayOfString[i])) {}
      }
      for (i = j;; i = 1)
      {
        if (i != 0) {
          break label86;
        }
        this.mPropagation.captureValues(paramag);
        return;
        i += 1;
        break;
      }
    }
  }
  
  public abstract void captureStartValues(ag paramag);
  
  void captureValues(ViewGroup paramViewGroup, boolean paramBoolean)
  {
    int k = 0;
    clearValues(paramBoolean);
    int i;
    Object localObject1;
    Object localObject2;
    if (((this.mTargetIds.size() > 0) || (this.mTargets.size() > 0)) && ((this.mTargetNames == null) || (this.mTargetNames.isEmpty())) && ((this.mTargetTypes == null) || (this.mTargetTypes.isEmpty())))
    {
      i = 0;
      if (i < this.mTargetIds.size())
      {
        localObject1 = paramViewGroup.findViewById(((Integer)this.mTargetIds.get(i)).intValue());
        if (localObject1 != null)
        {
          localObject2 = new ag();
          ((ag)localObject2).b = ((View)localObject1);
          if (!paramBoolean) {
            break label164;
          }
          captureStartValues((ag)localObject2);
          label126:
          ((ag)localObject2).c.add(this);
          capturePropagationValues((ag)localObject2);
          if (!paramBoolean) {
            break label173;
          }
          addViewValues(this.mStartValues, (View)localObject1, (ag)localObject2);
        }
        for (;;)
        {
          i += 1;
          break;
          label164:
          captureEndValues((ag)localObject2);
          break label126;
          label173:
          addViewValues(this.mEndValues, (View)localObject1, (ag)localObject2);
        }
      }
      i = 0;
      if (i < this.mTargets.size())
      {
        paramViewGroup = (View)this.mTargets.get(i);
        localObject1 = new ag();
        ((ag)localObject1).b = paramViewGroup;
        if (paramBoolean)
        {
          captureStartValues((ag)localObject1);
          label237:
          ((ag)localObject1).c.add(this);
          capturePropagationValues((ag)localObject1);
          if (!paramBoolean) {
            break label283;
          }
          addViewValues(this.mStartValues, paramViewGroup, (ag)localObject1);
        }
        for (;;)
        {
          i += 1;
          break;
          captureEndValues((ag)localObject1);
          break label237;
          label283:
          addViewValues(this.mEndValues, paramViewGroup, (ag)localObject1);
        }
      }
    }
    else
    {
      captureHierarchy(paramViewGroup, paramBoolean);
    }
    if ((!paramBoolean) && (this.mNameOverrides != null))
    {
      int m = this.mNameOverrides.size();
      paramViewGroup = new ArrayList(m);
      i = 0;
      int j;
      for (;;)
      {
        j = k;
        if (i >= m) {
          break;
        }
        localObject1 = (String)this.mNameOverrides.keyAt(i);
        paramViewGroup.add(this.mStartValues.d.remove(localObject1));
        i += 1;
      }
      while (j < m)
      {
        localObject1 = (View)paramViewGroup.get(j);
        if (localObject1 != null)
        {
          localObject2 = (String)this.mNameOverrides.valueAt(j);
          this.mStartValues.d.put(localObject2, localObject1);
        }
        j += 1;
      }
    }
  }
  
  void clearValues(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.mStartValues.a.clear();
      this.mStartValues.b.clear();
      this.mStartValues.c.clear();
      return;
    }
    this.mEndValues.a.clear();
    this.mEndValues.b.clear();
    this.mEndValues.c.clear();
  }
  
  public Transition clone()
  {
    try
    {
      Transition localTransition = (Transition)super.clone();
      localTransition.mAnimators = new ArrayList();
      localTransition.mStartValues = new ah();
      localTransition.mEndValues = new ah();
      localTransition.mStartValuesList = null;
      localTransition.mEndValuesList = null;
      return localTransition;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException) {}
    return null;
  }
  
  public Animator createAnimator(ViewGroup paramViewGroup, ag paramag1, ag paramag2)
  {
    return null;
  }
  
  protected void createAnimators(ViewGroup paramViewGroup, ah paramah1, ah paramah2, ArrayList<ag> paramArrayList1, ArrayList<ag> paramArrayList2)
  {
    ArrayMap localArrayMap = getRunningAnimators();
    long l1 = Long.MAX_VALUE;
    SparseIntArray localSparseIntArray = new SparseIntArray();
    int k = paramArrayList1.size();
    int i = 0;
    ag localag1;
    ag localag2;
    if (i < k)
    {
      localag1 = (ag)paramArrayList1.get(i);
      localag2 = (ag)paramArrayList2.get(i);
      if ((localag1 == null) || (localag1.c.contains(this))) {
        break label632;
      }
      localag1 = null;
    }
    label307:
    label317:
    label516:
    label620:
    label632:
    for (;;)
    {
      if ((localag2 != null) && (!localag2.c.contains(this))) {
        localag2 = null;
      }
      for (;;)
      {
        long l2;
        if ((localag1 == null) && (localag2 == null))
        {
          l2 = l1;
          i += 1;
          l1 = l2;
          break;
        }
        if ((localag1 == null) || (localag2 == null) || (isTransitionRequired(localag1, localag2))) {}
        Object localObject2;
        View localView;
        Object localObject1;
        for (int j = 1;; j = 0)
        {
          l2 = l1;
          if (j == 0) {
            break;
          }
          paramah1 = createAnimator(paramViewGroup, localag1, localag2);
          l2 = l1;
          if (paramah1 == null) {
            break;
          }
          localObject2 = null;
          if (localag2 == null) {
            break label516;
          }
          localView = localag2.b;
          String[] arrayOfString = getTransitionProperties();
          if ((localView == null) || (arrayOfString == null) || (arrayOfString.length <= 0)) {
            break label620;
          }
          localObject1 = new ag();
          ((ag)localObject1).b = localView;
          localObject2 = (ag)paramah2.a.get(localView);
          if (localObject2 == null) {
            break label307;
          }
          j = 0;
          while (j < arrayOfString.length)
          {
            ((ag)localObject1).a.put(arrayOfString[j], ((ag)localObject2).a.get(arrayOfString[j]));
            j += 1;
          }
        }
        int m = localArrayMap.size();
        j = 0;
        if (j < m)
        {
          localObject2 = (a)localArrayMap.get((Animator)localArrayMap.keyAt(j));
          if ((((a)localObject2).c != null) && (((a)localObject2).a == localView) && (((a)localObject2).b.equals(getName())) && (((a)localObject2).c.equals(localObject1)))
          {
            localObject2 = null;
            paramah1 = (ah)localObject1;
            localObject1 = localObject2;
          }
        }
        for (;;)
        {
          localObject2 = localObject1;
          localObject1 = localView;
          for (;;)
          {
            l2 = l1;
            if (localObject2 == null) {
              break;
            }
            l2 = l1;
            if (this.mPropagation != null)
            {
              l2 = this.mPropagation.getStartDelay(paramViewGroup, this, localag1, localag2);
              localSparseIntArray.put(this.mAnimators.size(), (int)l2);
              l2 = Math.min(l2, l1);
            }
            localArrayMap.put(localObject2, new a((View)localObject1, getName(), this, as.b(paramViewGroup), paramah1));
            this.mAnimators.add(localObject2);
            break;
            j += 1;
            break label317;
            localObject1 = localag1.b;
            localView = null;
            localObject2 = paramah1;
            paramah1 = localView;
          }
          if (l1 != 0L)
          {
            i = 0;
            while (i < localSparseIntArray.size())
            {
              j = localSparseIntArray.keyAt(i);
              paramViewGroup = (Animator)this.mAnimators.get(j);
              paramViewGroup.setStartDelay(localSparseIntArray.valueAt(i) - l1 + paramViewGroup.getStartDelay());
              i += 1;
            }
          }
          return;
          localObject2 = paramah1;
          paramah1 = (ah)localObject1;
          localObject1 = localObject2;
          continue;
          localObject1 = paramah1;
          paramah1 = (ah)localObject2;
        }
      }
    }
  }
  
  protected void end()
  {
    this.mNumInstances -= 1;
    if (this.mNumInstances == 0)
    {
      Object localObject;
      if ((this.mListeners != null) && (this.mListeners.size() > 0))
      {
        localObject = (ArrayList)this.mListeners.clone();
        int j = ((ArrayList)localObject).size();
        i = 0;
        while (i < j)
        {
          ((d)((ArrayList)localObject).get(i)).onTransitionEnd(this);
          i += 1;
        }
      }
      int i = 0;
      while (i < this.mStartValues.c.size())
      {
        localObject = (View)this.mStartValues.c.valueAt(i);
        if (localObject != null) {
          ViewCompat.setHasTransientState((View)localObject, false);
        }
        i += 1;
      }
      i = 0;
      while (i < this.mEndValues.c.size())
      {
        localObject = (View)this.mEndValues.c.valueAt(i);
        if (localObject != null) {
          ViewCompat.setHasTransientState((View)localObject, false);
        }
        i += 1;
      }
      this.mEnded = true;
    }
  }
  
  public Transition excludeChildren(int paramInt, boolean paramBoolean)
  {
    this.mTargetIdChildExcludes = excludeId(this.mTargetIdChildExcludes, paramInt, paramBoolean);
    return this;
  }
  
  public Transition excludeChildren(View paramView, boolean paramBoolean)
  {
    this.mTargetChildExcludes = excludeView(this.mTargetChildExcludes, paramView, paramBoolean);
    return this;
  }
  
  public Transition excludeChildren(Class paramClass, boolean paramBoolean)
  {
    this.mTargetTypeChildExcludes = excludeType(this.mTargetTypeChildExcludes, paramClass, paramBoolean);
    return this;
  }
  
  public Transition excludeTarget(int paramInt, boolean paramBoolean)
  {
    this.mTargetIdExcludes = excludeId(this.mTargetIdExcludes, paramInt, paramBoolean);
    return this;
  }
  
  public Transition excludeTarget(View paramView, boolean paramBoolean)
  {
    this.mTargetExcludes = excludeView(this.mTargetExcludes, paramView, paramBoolean);
    return this;
  }
  
  public Transition excludeTarget(Class paramClass, boolean paramBoolean)
  {
    this.mTargetTypeExcludes = excludeType(this.mTargetTypeExcludes, paramClass, paramBoolean);
    return this;
  }
  
  public Transition excludeTarget(String paramString, boolean paramBoolean)
  {
    this.mTargetNameExcludes = excludeObject(this.mTargetNameExcludes, paramString, paramBoolean);
    return this;
  }
  
  void forceToEnd(ViewGroup paramViewGroup)
  {
    ArrayMap localArrayMap = getRunningAnimators();
    int i = localArrayMap.size();
    if (paramViewGroup != null)
    {
      paramViewGroup = as.b(paramViewGroup);
      i -= 1;
      while (i >= 0)
      {
        a locala = (a)localArrayMap.valueAt(i);
        if ((locala.a != null) && (paramViewGroup != null) && (paramViewGroup.equals(locala.d))) {
          ((Animator)localArrayMap.keyAt(i)).end();
        }
        i -= 1;
      }
    }
  }
  
  public long getDuration()
  {
    return this.mDuration;
  }
  
  public Rect getEpicenter()
  {
    if (this.mEpicenterCallback == null) {
      return null;
    }
    return this.mEpicenterCallback.onGetEpicenter(this);
  }
  
  public c getEpicenterCallback()
  {
    return this.mEpicenterCallback;
  }
  
  public TimeInterpolator getInterpolator()
  {
    return this.mInterpolator;
  }
  
  ag getMatchedTransitionValues(View paramView, boolean paramBoolean)
  {
    Object localObject2 = null;
    Object localObject1;
    if (this.mParent != null) {
      localObject1 = this.mParent.getMatchedTransitionValues(paramView, paramBoolean);
    }
    ArrayList localArrayList;
    int i;
    label52:
    ag localag;
    do
    {
      do
      {
        return (ag)localObject1;
        if (!paramBoolean) {
          break;
        }
        localArrayList = this.mStartValuesList;
        localObject1 = localObject2;
      } while (localArrayList == null);
      int j = localArrayList.size();
      i = 0;
      if (i >= j) {
        break label140;
      }
      localag = (ag)localArrayList.get(i);
      localObject1 = localObject2;
    } while (localag == null);
    if (localag.b == paramView) {}
    for (;;)
    {
      if (i >= 0) {
        if (paramBoolean) {
          paramView = this.mEndValuesList;
        }
      }
      label100:
      for (paramView = (ag)paramView.get(i);; paramView = null)
      {
        return paramView;
        localArrayList = this.mEndValuesList;
        break;
        i += 1;
        break label52;
        paramView = this.mStartValuesList;
        break label100;
      }
      label140:
      i = -1;
    }
  }
  
  public String getName()
  {
    return this.mName;
  }
  
  public PathMotion getPathMotion()
  {
    return this.mPathMotion;
  }
  
  public ae getPropagation()
  {
    return this.mPropagation;
  }
  
  public long getStartDelay()
  {
    return this.mStartDelay;
  }
  
  public List<Integer> getTargetIds()
  {
    return this.mTargetIds;
  }
  
  public List<String> getTargetNames()
  {
    return this.mTargetNames;
  }
  
  public List<Class> getTargetTypes()
  {
    return this.mTargetTypes;
  }
  
  public List<View> getTargets()
  {
    return this.mTargets;
  }
  
  public String[] getTransitionProperties()
  {
    return null;
  }
  
  public ag getTransitionValues(View paramView, boolean paramBoolean)
  {
    if (this.mParent != null) {
      return this.mParent.getTransitionValues(paramView, paramBoolean);
    }
    if (paramBoolean) {}
    for (ah localah = this.mStartValues;; localah = this.mEndValues) {
      return (ag)localah.a.get(paramView);
    }
  }
  
  public boolean isTransitionRequired(ag paramag1, ag paramag2)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    Object localObject;
    int i;
    if (paramag1 != null)
    {
      bool1 = bool2;
      if (paramag2 != null)
      {
        localObject = getTransitionProperties();
        if (localObject == null) {
          break label68;
        }
        int j = localObject.length;
        i = 0;
        if (i >= j) {
          break label118;
        }
        if (!isValueChanged(paramag1, paramag2, localObject[i])) {
          break label61;
        }
        bool1 = true;
      }
    }
    for (;;)
    {
      return bool1;
      label61:
      i += 1;
      break;
      label68:
      localObject = paramag1.a.keySet().iterator();
      do
      {
        bool1 = bool2;
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
      } while (!isValueChanged(paramag1, paramag2, (String)((Iterator)localObject).next()));
      return true;
      label118:
      bool1 = false;
    }
  }
  
  boolean isValidTarget(View paramView)
  {
    int j = paramView.getId();
    if ((this.mTargetIdExcludes != null) && (this.mTargetIdExcludes.contains(Integer.valueOf(j)))) {}
    for (;;)
    {
      return false;
      if ((this.mTargetExcludes == null) || (!this.mTargetExcludes.contains(paramView)))
      {
        int i;
        if (this.mTargetTypeExcludes != null)
        {
          int k = this.mTargetTypeExcludes.size();
          i = 0;
          for (;;)
          {
            if (i >= k) {
              break label95;
            }
            if (((Class)this.mTargetTypeExcludes.get(i)).isInstance(paramView)) {
              break;
            }
            i += 1;
          }
        }
        label95:
        if ((this.mTargetNameExcludes == null) || (ViewCompat.getTransitionName(paramView) == null) || (!this.mTargetNameExcludes.contains(ViewCompat.getTransitionName(paramView))))
        {
          if ((this.mTargetIds.size() == 0) && (this.mTargets.size() == 0) && ((this.mTargetTypes == null) || (this.mTargetTypes.isEmpty())) && ((this.mTargetNames == null) || (this.mTargetNames.isEmpty()))) {
            return true;
          }
          if ((this.mTargetIds.contains(Integer.valueOf(j))) || (this.mTargets.contains(paramView))) {
            return true;
          }
          if ((this.mTargetNames != null) && (this.mTargetNames.contains(ViewCompat.getTransitionName(paramView)))) {
            return true;
          }
          if (this.mTargetTypes != null)
          {
            i = 0;
            while (i < this.mTargetTypes.size())
            {
              if (((Class)this.mTargetTypes.get(i)).isInstance(paramView)) {
                return true;
              }
              i += 1;
            }
          }
        }
      }
    }
  }
  
  public void pause(View paramView)
  {
    if (!this.mEnded)
    {
      ArrayMap localArrayMap = getRunningAnimators();
      int i = localArrayMap.size();
      paramView = as.b(paramView);
      i -= 1;
      while (i >= 0)
      {
        a locala = (a)localArrayMap.valueAt(i);
        if ((locala.a != null) && (paramView.equals(locala.d))) {
          a.a((Animator)localArrayMap.keyAt(i));
        }
        i -= 1;
      }
      if ((this.mListeners != null) && (this.mListeners.size() > 0))
      {
        paramView = (ArrayList)this.mListeners.clone();
        int j = paramView.size();
        i = 0;
        while (i < j)
        {
          ((d)paramView.get(i)).onTransitionPause(this);
          i += 1;
        }
      }
      this.mPaused = true;
    }
  }
  
  void playTransition(ViewGroup paramViewGroup)
  {
    this.mStartValuesList = new ArrayList();
    this.mEndValuesList = new ArrayList();
    matchStartAndEnd(this.mStartValues, this.mEndValues);
    ArrayMap localArrayMap = getRunningAnimators();
    int i = localArrayMap.size();
    bc localbc = as.b(paramViewGroup);
    i -= 1;
    if (i >= 0)
    {
      Animator localAnimator = (Animator)localArrayMap.keyAt(i);
      int j;
      if (localAnimator != null)
      {
        a locala = (a)localArrayMap.get(localAnimator);
        if ((locala != null) && (locala.a != null) && (localbc.equals(locala.d)))
        {
          ag localag1 = locala.c;
          Object localObject = locala.a;
          ag localag2 = getTransitionValues((View)localObject, true);
          localObject = getMatchedTransitionValues((View)localObject, true);
          if (((localag2 == null) && (localObject == null)) || (!locala.e.isTransitionRequired(localag1, (ag)localObject))) {
            break label204;
          }
          j = 1;
          label172:
          if (j != 0)
          {
            if ((!localAnimator.isRunning()) && (!localAnimator.isStarted())) {
              break label209;
            }
            localAnimator.cancel();
          }
        }
      }
      for (;;)
      {
        i -= 1;
        break;
        label204:
        j = 0;
        break label172;
        label209:
        localArrayMap.remove(localAnimator);
      }
    }
    createAnimators(paramViewGroup, this.mStartValues, this.mEndValues, this.mStartValuesList, this.mEndValuesList);
    runAnimators();
  }
  
  public Transition removeListener(d paramd)
  {
    if (this.mListeners == null) {}
    do
    {
      return this;
      this.mListeners.remove(paramd);
    } while (this.mListeners.size() != 0);
    this.mListeners = null;
    return this;
  }
  
  public Transition removeTarget(int paramInt)
  {
    if (paramInt > 0) {
      this.mTargetIds.remove(Integer.valueOf(paramInt));
    }
    return this;
  }
  
  public Transition removeTarget(View paramView)
  {
    this.mTargets.remove(paramView);
    return this;
  }
  
  public Transition removeTarget(Class paramClass)
  {
    if (this.mTargetTypes != null) {
      this.mTargetTypes.remove(paramClass);
    }
    return this;
  }
  
  public Transition removeTarget(String paramString)
  {
    if (this.mTargetNames != null) {
      this.mTargetNames.remove(paramString);
    }
    return this;
  }
  
  public void resume(View paramView)
  {
    if (this.mPaused)
    {
      if (!this.mEnded)
      {
        ArrayMap localArrayMap = getRunningAnimators();
        int i = localArrayMap.size();
        paramView = as.b(paramView);
        i -= 1;
        while (i >= 0)
        {
          a locala = (a)localArrayMap.valueAt(i);
          if ((locala.a != null) && (paramView.equals(locala.d))) {
            a.b((Animator)localArrayMap.keyAt(i));
          }
          i -= 1;
        }
        if ((this.mListeners != null) && (this.mListeners.size() > 0))
        {
          paramView = (ArrayList)this.mListeners.clone();
          int j = paramView.size();
          i = 0;
          while (i < j)
          {
            ((d)paramView.get(i)).onTransitionResume(this);
            i += 1;
          }
        }
      }
      this.mPaused = false;
    }
  }
  
  protected void runAnimators()
  {
    start();
    ArrayMap localArrayMap = getRunningAnimators();
    Iterator localIterator = this.mAnimators.iterator();
    while (localIterator.hasNext())
    {
      Animator localAnimator = (Animator)localIterator.next();
      if (localArrayMap.containsKey(localAnimator))
      {
        start();
        runAnimator(localAnimator, localArrayMap);
      }
    }
    this.mAnimators.clear();
    end();
  }
  
  void setCanRemoveViews(boolean paramBoolean)
  {
    this.mCanRemoveViews = paramBoolean;
  }
  
  public Transition setDuration(long paramLong)
  {
    this.mDuration = paramLong;
    return this;
  }
  
  public void setEpicenterCallback(c paramc)
  {
    this.mEpicenterCallback = paramc;
  }
  
  public Transition setInterpolator(TimeInterpolator paramTimeInterpolator)
  {
    this.mInterpolator = paramTimeInterpolator;
    return this;
  }
  
  public void setMatchOrder(int... paramVarArgs)
  {
    if ((paramVarArgs == null) || (paramVarArgs.length == 0))
    {
      this.mMatchOrder = DEFAULT_MATCH_ORDER;
      return;
    }
    int i = 0;
    while (i < paramVarArgs.length)
    {
      if (!isValidMatch(paramVarArgs[i])) {
        throw new IllegalArgumentException("matches contains invalid value");
      }
      if (alreadyContains(paramVarArgs, i)) {
        throw new IllegalArgumentException("matches contains a duplicate value");
      }
      i += 1;
    }
    this.mMatchOrder = ((int[])paramVarArgs.clone());
  }
  
  public void setPathMotion(PathMotion paramPathMotion)
  {
    if (paramPathMotion == null)
    {
      this.mPathMotion = STRAIGHT_PATH_MOTION;
      return;
    }
    this.mPathMotion = paramPathMotion;
  }
  
  public void setPropagation(ae paramae)
  {
    this.mPropagation = paramae;
  }
  
  Transition setSceneRoot(ViewGroup paramViewGroup)
  {
    this.mSceneRoot = paramViewGroup;
    return this;
  }
  
  public Transition setStartDelay(long paramLong)
  {
    this.mStartDelay = paramLong;
    return this;
  }
  
  protected void start()
  {
    if (this.mNumInstances == 0)
    {
      if ((this.mListeners != null) && (this.mListeners.size() > 0))
      {
        ArrayList localArrayList = (ArrayList)this.mListeners.clone();
        int j = localArrayList.size();
        int i = 0;
        while (i < j)
        {
          ((d)localArrayList.get(i)).onTransitionStart(this);
          i += 1;
        }
      }
      this.mEnded = false;
    }
    this.mNumInstances += 1;
  }
  
  public String toString()
  {
    return toString("");
  }
  
  String toString(String paramString)
  {
    int j = 0;
    String str = paramString + getClass().getSimpleName() + "@" + Integer.toHexString(hashCode()) + ": ";
    paramString = str;
    if (this.mDuration != -1L) {
      paramString = str + "dur(" + this.mDuration + ") ";
    }
    str = paramString;
    if (this.mStartDelay != -1L) {
      str = paramString + "dly(" + this.mStartDelay + ") ";
    }
    paramString = str;
    if (this.mInterpolator != null) {
      paramString = str + "interp(" + this.mInterpolator + ") ";
    }
    if (this.mTargetIds.size() <= 0)
    {
      str = paramString;
      if (this.mTargets.size() <= 0) {}
    }
    else
    {
      paramString = paramString + "tgts(";
      int i;
      if (this.mTargetIds.size() > 0)
      {
        i = 0;
        for (;;)
        {
          str = paramString;
          if (i >= this.mTargetIds.size()) {
            break;
          }
          str = paramString;
          if (i > 0) {
            str = paramString + ", ";
          }
          paramString = str + this.mTargetIds.get(i);
          i += 1;
        }
      }
      str = paramString;
      paramString = str;
      if (this.mTargets.size() > 0)
      {
        i = j;
        for (;;)
        {
          paramString = str;
          if (i >= this.mTargets.size()) {
            break;
          }
          paramString = str;
          if (i > 0) {
            paramString = str + ", ";
          }
          str = paramString + this.mTargets.get(i);
          i += 1;
        }
      }
      str = paramString + ")";
    }
    return str;
  }
  
  private static class a
  {
    View a;
    String b;
    ag c;
    bc d;
    Transition e;
    
    a(View paramView, String paramString, Transition paramTransition, bc parambc, ag paramag)
    {
      this.a = paramView;
      this.b = paramString;
      this.c = paramag;
      this.d = parambc;
      this.e = paramTransition;
    }
  }
  
  private static class b
  {
    static <T> ArrayList<T> a(ArrayList<T> paramArrayList, T paramT)
    {
      Object localObject = paramArrayList;
      if (paramArrayList == null) {
        localObject = new ArrayList();
      }
      if (!((ArrayList)localObject).contains(paramT)) {
        ((ArrayList)localObject).add(paramT);
      }
      return (ArrayList<T>)localObject;
    }
    
    static <T> ArrayList<T> b(ArrayList<T> paramArrayList, T paramT)
    {
      ArrayList<T> localArrayList = paramArrayList;
      if (paramArrayList != null)
      {
        paramArrayList.remove(paramT);
        localArrayList = paramArrayList;
        if (paramArrayList.isEmpty()) {
          localArrayList = null;
        }
      }
      return localArrayList;
    }
  }
  
  public static abstract class c
  {
    public abstract Rect onGetEpicenter(Transition paramTransition);
  }
  
  public static abstract interface d
  {
    public abstract void onTransitionCancel(Transition paramTransition);
    
    public abstract void onTransitionEnd(Transition paramTransition);
    
    public abstract void onTransitionPause(Transition paramTransition);
    
    public abstract void onTransitionResume(Transition paramTransition);
    
    public abstract void onTransitionStart(Transition paramTransition);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/android/support/transition/Transition.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */