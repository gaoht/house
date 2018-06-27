package com.superrtc.call;

import android.opengl.GLES20;
import java.nio.FloatBuffer;
import java.util.Collection;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.Map;

public class h
  implements o.a
{
  private static final FloatBuffer a = k.createFloatBuffer(new float[] { -1.0F, -1.0F, 1.0F, -1.0F, -1.0F, 1.0F, 1.0F, 1.0F });
  private static final FloatBuffer b = k.createFloatBuffer(new float[] { 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F });
  private final Map<String, a> c = new IdentityHashMap();
  
  private void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    GLES20.glViewport(paramInt1, paramInt2, paramInt3, paramInt4);
    GLES20.glDrawArrays(5, 0, 4);
  }
  
  private void a(String paramString, float[] paramArrayOfFloat)
  {
    if (this.c.containsKey(paramString))
    {
      paramString = (a)this.c.get(paramString);
      paramString.a.useProgram();
      GLES20.glUniformMatrix4fv(paramString.b, 1, false, paramArrayOfFloat, 0);
      return;
    }
    a locala = new a(paramString);
    this.c.put(paramString, locala);
    locala.a.useProgram();
    if (paramString == "precision mediump float;\nvarying vec2 interp_tc;\n\nuniform sampler2D y_tex;\nuniform sampler2D u_tex;\nuniform sampler2D v_tex;\n\nvoid main() {\n  float y = texture2D(y_tex, interp_tc).r;\n  float u = texture2D(u_tex, interp_tc).r - 0.5;\n  float v = texture2D(v_tex, interp_tc).r - 0.5;\n  gl_FragColor = vec4(y + 1.403 * v,                       y - 0.344 * u - 0.714 * v,                       y + 1.77 * u, 1);\n}\n")
    {
      GLES20.glUniform1i(locala.a.getUniformLocation("y_tex"), 0);
      GLES20.glUniform1i(locala.a.getUniformLocation("u_tex"), 1);
      GLES20.glUniform1i(locala.a.getUniformLocation("v_tex"), 2);
    }
    for (;;)
    {
      k.checkNoGLES2Error("Initialize fragment shader uniform values.");
      locala.a.setVertexAttribArray("in_pos", 2, a);
      locala.a.setVertexAttribArray("in_tc", 2, b);
      paramString = locala;
      break;
      if (paramString == "precision mediump float;\nvarying vec2 interp_tc;\n\nuniform sampler2D rgb_tex;\n\nvoid main() {\n  gl_FragColor = texture2D(rgb_tex, interp_tc);\n}\n")
      {
        GLES20.glUniform1i(locala.a.getUniformLocation("rgb_tex"), 0);
      }
      else
      {
        if (paramString != "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 interp_tc;\n\nuniform samplerExternalOES oes_tex;\n\nvoid main() {\n  gl_FragColor = texture2D(oes_tex, interp_tc);\n}\n") {
          break label199;
        }
        GLES20.glUniform1i(locala.a.getUniformLocation("oes_tex"), 0);
      }
    }
    label199:
    throw new IllegalStateException("Unknown fragment shader: " + paramString);
  }
  
  public void drawOes(int paramInt1, float[] paramArrayOfFloat, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    a("#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 interp_tc;\n\nuniform samplerExternalOES oes_tex;\n\nvoid main() {\n  gl_FragColor = texture2D(oes_tex, interp_tc);\n}\n", paramArrayOfFloat);
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(36197, paramInt1);
    a(paramInt2, paramInt3, paramInt4, paramInt5);
    GLES20.glBindTexture(36197, 0);
  }
  
  public void drawRgb(int paramInt1, float[] paramArrayOfFloat, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    a("precision mediump float;\nvarying vec2 interp_tc;\n\nuniform sampler2D rgb_tex;\n\nvoid main() {\n  gl_FragColor = texture2D(rgb_tex, interp_tc);\n}\n", paramArrayOfFloat);
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(3553, paramInt1);
    a(paramInt2, paramInt3, paramInt4, paramInt5);
    GLES20.glBindTexture(3553, 0);
  }
  
  public void drawYuv(int[] paramArrayOfInt, float[] paramArrayOfFloat, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    a("precision mediump float;\nvarying vec2 interp_tc;\n\nuniform sampler2D y_tex;\nuniform sampler2D u_tex;\nuniform sampler2D v_tex;\n\nvoid main() {\n  float y = texture2D(y_tex, interp_tc).r;\n  float u = texture2D(u_tex, interp_tc).r - 0.5;\n  float v = texture2D(v_tex, interp_tc).r - 0.5;\n  gl_FragColor = vec4(y + 1.403 * v,                       y - 0.344 * u - 0.714 * v,                       y + 1.77 * u, 1);\n}\n", paramArrayOfFloat);
    int i = 0;
    while (i < 3)
    {
      GLES20.glActiveTexture(33984 + i);
      GLES20.glBindTexture(3553, paramArrayOfInt[i]);
      i += 1;
    }
    a(paramInt1, paramInt2, paramInt3, paramInt4);
    paramInt1 = 0;
    while (paramInt1 < 3)
    {
      GLES20.glActiveTexture(33984 + paramInt1);
      GLES20.glBindTexture(3553, 0);
      paramInt1 += 1;
    }
  }
  
  public void release()
  {
    Iterator localIterator = this.c.values().iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).a.release();
    }
    this.c.clear();
  }
  
  private static class a
  {
    public final i a;
    public final int b;
    
    public a(String paramString)
    {
      this.a = new i("varying vec2 interp_tc;\nattribute vec4 in_pos;\nattribute vec4 in_tc;\n\nuniform mat4 texMatrix;\n\nvoid main() {\n    gl_Position = in_pos;\n    interp_tc = (texMatrix * in_tc).xy;\n}\n", paramString);
      this.b = this.a.getUniformLocation("texMatrix");
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/superrtc/call/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */