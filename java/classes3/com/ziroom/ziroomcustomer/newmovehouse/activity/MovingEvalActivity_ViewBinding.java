package com.ziroom.ziroomcustomer.newmovehouse.activity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.facebook.drawee.view.SimpleDraweeView;

public class MovingEvalActivity_ViewBinding<T extends MovingEvalActivity>
  implements Unbinder
{
  protected T a;
  
  public MovingEvalActivity_ViewBinding(T paramT, View paramView)
  {
    this.a = paramT;
    paramT.mSdvAvatar = ((SimpleDraweeView)Utils.findRequiredViewAsType(paramView, 2131690070, "field 'mSdvAvatar'", SimpleDraweeView.class));
    paramT.mTvName = ((TextView)Utils.findRequiredViewAsType(paramView, 2131690049, "field 'mTvName'", TextView.class));
    paramT.mTvSubtitle = ((TextView)Utils.findRequiredViewAsType(paramView, 2131690071, "field 'mTvSubtitle'", TextView.class));
    paramT.mRbRating = ((RatingBar)Utils.findRequiredViewAsType(paramView, 2131690072, "field 'mRbRating'", RatingBar.class));
    paramT.mEtEval = ((EditText)Utils.findRequiredViewAsType(paramView, 2131690075, "field 'mEtEval'", EditText.class));
    paramT.mTvEvalNum = ((TextView)Utils.findRequiredViewAsType(paramView, 2131690076, "field 'mTvEvalNum'", TextView.class));
    paramT.mTvDesc = ((TextView)Utils.findRequiredViewAsType(paramView, 2131690073, "field 'mTvDesc'", TextView.class));
    paramT.mBtnSubmit = ((Button)Utils.findRequiredViewAsType(paramView, 2131689816, "field 'mBtnSubmit'", Button.class));
  }
  
  public void unbind()
  {
    MovingEvalActivity localMovingEvalActivity = this.a;
    if (localMovingEvalActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localMovingEvalActivity.mSdvAvatar = null;
    localMovingEvalActivity.mTvName = null;
    localMovingEvalActivity.mTvSubtitle = null;
    localMovingEvalActivity.mRbRating = null;
    localMovingEvalActivity.mEtEval = null;
    localMovingEvalActivity.mTvEvalNum = null;
    localMovingEvalActivity.mTvDesc = null;
    localMovingEvalActivity.mBtnSubmit = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newmovehouse/activity/MovingEvalActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */