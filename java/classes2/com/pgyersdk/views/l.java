package com.pgyersdk.views;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;

class l
  implements MediaPlayer.OnPreparedListener
{
  l(g paramg) {}
  
  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    g.k(this.a).setEnabled(false);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/pgyersdk/views/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */