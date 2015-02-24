package org.androidtown.opengltest;

import javax.microedition.khronos.opengles.GL10;

import android.content.Context;
import android.opengl.GLSurfaceView.Renderer;
import android.opengl.Matrix;
import android.renderscript.Matrix3f;

public class MyRenderer implements Renderer 
{
    int inputButtonTapped = 0;
    static int BUTTON_TAPPED = 1;

    private Context mContext;
    private Line mLine;
	private float yAngle; 
	private float xAngle; 
	private float mAngle;
    private float mDx;
    private float mDy;
    private float mDz;
    private float posX = 0.0f;
    private float posY = 0.0f;
    private float posZ = 0.0f;

	@Override
	public void onSurfaceCreated(GL10 gl, javax.microedition.khronos.egl.EGLConfig config)
	{
		gl.glClearColor(0.3f, 0.3f, 0.3f, 1.0f);
	}

    public MyRenderer(Context context)
    {
        mContext = context;
        mLine = new Line();
    }
	
	public void onDrawFrame(GL10 gl)
	{
        if(inputButtonTapped == BUTTON_TAPPED)
        {
            mLine.insertVertex(posX, posY, posZ);
            inputButtonTapped = 0;
        }
		gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);
		gl.glLoadIdentity();
		gl.glTranslatef(mDx, mDy, mDz);
		gl.glLineWidth(5.0f);
		gl.glRotatef(xAngle, 0.0f, 1.0f, 0.0f);
		gl.glRotatef(yAngle, 1.0f, 0.0f, 0.0f);

		mLine.listToArray();

		mLine.draw(gl);
	}

    public void onSurfaceChanged(GL10 gl, int width, int height)
	{
		gl.glViewport(0, 0, width, height);
		gl.glOrthof(-10.0f, 10.0f, -10.0f, 10.0f, -10.0f, 10.0f);
	}
	
	public void inputButtonTapped(float x, float y, float z)
	{
		posX = x;
        posY = y;
        posZ = z;
        inputButtonTapped = 1;
	}


	public void insertVertexInLine(float x, float y, float z)
    {
        mLine.insertVertex(x,y,z);
    }
	public void setYAngle(float Y)
	{
		yAngle = Y;
	}
	public void setXAngle(float X)
	{
		xAngle = X;
	}
    public void setAngle(float f)
    {
        mAngle = f;
    }
	public float getXAngle()
	{
		return xAngle;
	}
	public float getYAngle()
	{
		return yAngle;
	}
	public float getAngle()
	{
		return mAngle;
	}

    public void setDx(float dx)
    {
        mDx = dx;
    }
    public void setDy(float dy)
    {
        mDy = dy;
    }
    public void setDz(float dz)
    {
        mDz = dz;
    }
    public float getDx()
    {
        return mDx;
    }
    public float getDy()
    {
        return mDy;
    }
    public float getDz()
    {
        return mDz;
    }


}
