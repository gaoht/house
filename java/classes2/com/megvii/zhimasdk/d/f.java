package com.megvii.zhimasdk.d;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import com.megvii.livenessdetection.Detector.DetectionType;
import com.megvii.zhimasdk.R.anim;
import com.megvii.zhimasdk.R.drawable;
import com.megvii.zhimasdk.R.id;
import com.megvii.zhimasdk.view.CircleProgressBar;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class f
{
  public View[] a;
  public int b = -1;
  public ArrayList<Detector.DetectionType> c;
  private View d;
  private Context e;
  private int f = 3;
  private HashMap<Integer, Drawable> g;
  
  public f(Context paramContext, View paramView)
  {
    this.e = paramContext;
    this.d = paramView;
    this.g = new HashMap();
  }
  
  private void a(Detector.DetectionType paramDetectionType, View paramView)
  {
    ImageView localImageView = (ImageView)paramView.findViewById(R.id.detection_step_image);
    localImageView.setImageDrawable(b(paramDetectionType));
    ((AnimationDrawable)localImageView.getDrawable()).start();
    ((TextView)paramView.findViewById(R.id.detection_step_name)).setText(c(paramDetectionType));
  }
  
  private Drawable b(Detector.DetectionType paramDetectionType)
  {
    int i;
    switch (1.a[paramDetectionType.ordinal()])
    {
    default: 
      i = -1;
    }
    for (;;)
    {
      paramDetectionType = (Drawable)this.g.get(Integer.valueOf(i));
      if (paramDetectionType == null) {
        break;
      }
      return paramDetectionType;
      i = R.drawable.mg_liveness_head_pitch;
      continue;
      i = R.drawable.mg_liveness_head_yaw;
      continue;
      i = R.drawable.mg_liveness_mouth_open_closed;
      continue;
      i = R.drawable.mg_liveness_eye_open_closed;
    }
    paramDetectionType = this.e.getResources().getDrawable(i);
    this.g.put(Integer.valueOf(i), paramDetectionType);
    return paramDetectionType;
  }
  
  private Detector.DetectionType b(String paramString)
  {
    Detector.DetectionType localDetectionType = Detector.DetectionType.NONE;
    int i = -1;
    switch (paramString.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        return localDetectionType;
        if (paramString.equals("nod"))
        {
          i = 0;
          continue;
          if (paramString.equals("shake"))
          {
            i = 1;
            continue;
            if (paramString.equals("blink"))
            {
              i = 2;
              continue;
              if (paramString.equals("mouth")) {
                i = 3;
              }
            }
          }
        }
        break;
      }
    }
    return Detector.DetectionType.POS_PITCH;
    return Detector.DetectionType.POS_YAW;
    return Detector.DetectionType.BLINK;
    return Detector.DetectionType.MOUTH;
  }
  
  private String c(Detector.DetectionType paramDetectionType)
  {
    switch (1.a[paramDetectionType.ordinal()])
    {
    case 2: 
    case 3: 
    default: 
      return null;
    case 1: 
      return "缓慢点头";
    case 6: 
      return "左右摇头";
    case 7: 
      return "张嘴";
    case 8: 
      return "眨眼";
    case 4: 
      return "左转";
    }
    return "右转";
  }
  
  public String a(Detector.DetectionType paramDetectionType)
  {
    switch (1.a[paramDetectionType.ordinal()])
    {
    case 2: 
    case 3: 
    default: 
      return "SHAKE";
    case 1: 
      return "NOD";
    case 4: 
    case 5: 
    case 6: 
      return "SHAKE";
    case 7: 
      return "MOUTH";
    }
    return "BLINK";
  }
  
  public void a()
  {
    int i = 0;
    int[] arrayOfInt = new int[4];
    arrayOfInt[0] = R.drawable.mg_liveness_head_pitch;
    arrayOfInt[1] = R.drawable.mg_liveness_head_yaw;
    arrayOfInt[2] = R.drawable.mg_liveness_mouth_open_closed;
    arrayOfInt[3] = R.drawable.mg_liveness_eye_open_closed;
    int j = arrayOfInt.length;
    while (i < j)
    {
      int k = arrayOfInt[i];
      this.g.put(Integer.valueOf(k), this.e.getResources().getDrawable(k));
      i += 1;
    }
  }
  
  public void a(long paramLong)
  {
    int i = 0;
    if (this.b == -1) {}
    for (;;)
    {
      this.b = i;
      CircleProgressBar localCircleProgressBar = (CircleProgressBar)this.a[this.b].findViewById(R.id.liveness_layout_timeout_progressBar);
      ((TextView)this.a[this.b].findViewById(R.id.liveness_layout_timeout_garden)).setText(paramLong / 1000L + "");
      localCircleProgressBar.setProgress((int)(paramLong / 100L));
      return;
      if (this.b == 0) {
        i = 1;
      }
    }
  }
  
  public void a(Detector.DetectionType paramDetectionType, long paramLong)
  {
    Animation localAnimation1 = AnimationUtils.loadAnimation(this.e, R.anim.mg_liveness_rightin);
    Animation localAnimation2 = AnimationUtils.loadAnimation(this.e, R.anim.mg_liveness_leftout);
    int i;
    if (this.b != -1)
    {
      this.a[this.b].setVisibility(4);
      this.a[this.b].setAnimation(localAnimation2);
      if (this.b != -1) {
        break label142;
      }
      i = 0;
    }
    for (;;)
    {
      this.b = i;
      a(paramDetectionType, this.a[this.b]);
      this.a[this.b].setVisibility(0);
      this.a[this.b].startAnimation(localAnimation1);
      return;
      this.a[0].setVisibility(4);
      this.a[0].startAnimation(localAnimation2);
      break;
      label142:
      if (this.b == 0) {
        i = 1;
      } else {
        i = 0;
      }
    }
  }
  
  public void a(String paramString)
  {
    int j = 0;
    HashMap localHashMap = new HashMap();
    int i = 1;
    Object localObject;
    label46:
    double d1;
    label92:
    Map.Entry localEntry;
    if ((paramString == null) || (paramString.isEmpty()))
    {
      i = 0;
      localObject = new ArrayList();
      if (i == 0) {
        break label309;
      }
      i = 0;
      if (i >= this.f) {
        break label345;
      }
      d1 = b.a(localHashMap.values());
      double d2 = new Random().nextDouble();
      paramString = localHashMap.entrySet().iterator();
      d1 *= d2;
      if (!paramString.hasNext()) {
        break label403;
      }
      localEntry = (Map.Entry)paramString.next();
      if (d1 >= ((Double)localEntry.getValue()).doubleValue() + 1.0E-5D) {
        break label290;
      }
    }
    label290:
    label309:
    label345:
    label403:
    for (paramString = (String)localEntry.getKey();; paramString = "")
    {
      if (!paramString.isEmpty())
      {
        localHashMap.remove(paramString);
        ((ArrayList)localObject).add(b(paramString));
      }
      i += 1;
      break label46;
      try
      {
        paramString = new JSONObject(paramString);
        localObject = paramString.getJSONObject("action_probability");
        localHashMap.put("nod", Double.valueOf(((JSONObject)localObject).getDouble("nod")));
        localHashMap.put("shake", Double.valueOf(((JSONObject)localObject).getDouble("shake")));
        localHashMap.put("blink", Double.valueOf(((JSONObject)localObject).getDouble("blink")));
        localHashMap.put("mouth", Double.valueOf(((JSONObject)localObject).getDouble("mouth")));
        this.f = paramString.getInt("action_number");
      }
      catch (JSONException paramString)
      {
        i = 0;
      }
      break;
      d1 -= ((Double)localEntry.getValue()).doubleValue();
      break label92;
      ((ArrayList)localObject).add(Detector.DetectionType.BLINK);
      ((ArrayList)localObject).add(Detector.DetectionType.MOUTH);
      ((ArrayList)localObject).add(Detector.DetectionType.POS_PITCH);
      ((ArrayList)localObject).add(Detector.DetectionType.POS_YAW);
      Collections.shuffle((List)localObject);
      this.c = new ArrayList(this.f);
      i = j;
      while (i < this.f)
      {
        this.c.add(((ArrayList)localObject).get(i));
        i += 1;
      }
      return;
    }
  }
  
  public void b()
  {
    int i = 0;
    this.a = new View[2];
    this.a[0] = this.d.findViewById(R.id.liveness_layout_first_layout);
    this.a[1] = this.d.findViewById(R.id.liveness_layout_second_layout);
    View[] arrayOfView = this.a;
    int j = arrayOfView.length;
    while (i < j)
    {
      arrayOfView[i].setVisibility(4);
      i += 1;
    }
  }
  
  public void c()
  {
    this.d = null;
    this.e = null;
    if (this.g != null) {
      this.g.clear();
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/megvii/zhimasdk/d/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */