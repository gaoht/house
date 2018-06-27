package com.pgyersdk.views;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import java.util.Timer;
import java.util.TimerTask;

class k
  implements MediaPlayer.OnCompletionListener
{
  k(g paramg) {}
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    this.a.o.cancel();
    this.a.p.cancel();
    this.a.k.a(3);
    g.k(this.a).setEnabled(true);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/pgyersdk/views/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */