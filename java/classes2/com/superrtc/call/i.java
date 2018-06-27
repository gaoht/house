package com.superrtc.call;

import android.opengl.GLES20;
import java.nio.FloatBuffer;

public class i
{
  private int a;
  
  public i(String paramString1, String paramString2)
  {
    int i = a(35633, paramString1);
    int j = a(35632, paramString2);
    this.a = GLES20.glCreateProgram();
    if (this.a == 0) {
      throw new RuntimeException("glCreateProgram() failed. GLES20 error: " + GLES20.glGetError());
    }
    GLES20.glAttachShader(this.a, i);
    GLES20.glAttachShader(this.a, j);
    GLES20.glLinkProgram(this.a);
    paramString1 = new int[1];
    paramString1[0] = 0;
    GLES20.glGetProgramiv(this.a, 35714, paramString1, 0);
    if (paramString1[0] != 1)
    {
      Logging.e("GlShader", "Could not link program: " + GLES20.glGetProgramInfoLog(this.a));
      throw new RuntimeException(GLES20.glGetProgramInfoLog(this.a));
    }
    GLES20.glDeleteShader(i);
    GLES20.glDeleteShader(j);
    k.checkNoGLES2Error("Creating GlShader");
  }
  
  private static int a(int paramInt, String paramString)
  {
    int i = GLES20.glCreateShader(paramInt);
    if (i == 0) {
      throw new RuntimeException("glCreateShader() failed. GLES20 error: " + GLES20.glGetError());
    }
    GLES20.glShaderSource(i, paramString);
    GLES20.glCompileShader(i);
    paramString = new int[1];
    paramString[0] = 0;
    GLES20.glGetShaderiv(i, 35713, paramString, 0);
    if (paramString[0] != 1)
    {
      Logging.e("GlShader", "Could not compile shader " + paramInt + ":" + GLES20.glGetShaderInfoLog(i));
      throw new RuntimeException(GLES20.glGetShaderInfoLog(i));
    }
    k.checkNoGLES2Error("compileShader");
    return i;
  }
  
  public int getAttribLocation(String paramString)
  {
    if (this.a == -1) {
      throw new RuntimeException("The program has been released");
    }
    int i = GLES20.glGetAttribLocation(this.a, paramString);
    if (i < 0) {
      throw new RuntimeException("Could not locate '" + paramString + "' in program");
    }
    return i;
  }
  
  public int getUniformLocation(String paramString)
  {
    if (this.a == -1) {
      throw new RuntimeException("The program has been released");
    }
    int i = GLES20.glGetUniformLocation(this.a, paramString);
    if (i < 0) {
      throw new RuntimeException("Could not locate uniform '" + paramString + "' in program");
    }
    return i;
  }
  
  public void release()
  {
    Logging.d("GlShader", "Deleting shader.");
    if (this.a != -1)
    {
      GLES20.glDeleteProgram(this.a);
      this.a = -1;
    }
  }
  
  public void setVertexAttribArray(String paramString, int paramInt, FloatBuffer paramFloatBuffer)
  {
    if (this.a == -1) {
      throw new RuntimeException("The program has been released");
    }
    int i = getAttribLocation(paramString);
    GLES20.glEnableVertexAttribArray(i);
    GLES20.glVertexAttribPointer(i, paramInt, 5126, false, 0, paramFloatBuffer);
    k.checkNoGLES2Error("setVertexAttribArray");
  }
  
  public void useProgram()
  {
    if (this.a == -1) {
      throw new RuntimeException("The program has been released");
    }
    GLES20.glUseProgram(this.a);
    k.checkNoGLES2Error("glUseProgram");
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/superrtc/call/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */