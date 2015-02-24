package org.androidtown.opengltest;

import android.app.Activity;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class OpenGLTest0Activity extends Activity 
{
	private MyGLSurfaceView mGLView;
	private MyRenderer mRenderer;

    EditText editText1;
    EditText editText2;
    EditText editText3;

    RadioButton radioButton1;
    RadioButton radioButton2;
	LinearLayout linearLayout1;

	protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_gltest0);

        linearLayout1 = (LinearLayout) findViewById(R.id.linearLayout1);
        editText1 = (EditText) findViewById(R.id.editText1);
        editText2 = (EditText) findViewById(R.id.editText2);
        editText3 = (EditText) findViewById(R.id.editText3);

        mRenderer = new MyRenderer(this);
        mGLView = new MyGLSurfaceView(this);
        mGLView.setRenderer(mRenderer);

        linearLayout1.addView(mGLView);

        radioButton1 = (RadioButton)findViewById(R.id.radioButton1);
        radioButton2 = (RadioButton)findViewById(R.id.radioButton2);

        radioButton1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if(radioButton1.isChecked())
                {
                    mGLView.setMoveMode(mGLView.ROTATE_BUTTON);
                }
            }
        });

        radioButton2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if(radioButton2.isChecked())
                {
                    mGLView.setMoveMode(mGLView.MOVE_BUTTON);
                }
            }
        });

        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                float x = Float.parseFloat(editText1.getText().toString());
                float y = Float.parseFloat(editText2.getText().toString());
                float z = Float.parseFloat(editText3.getText().toString());

                mRenderer.inputButtonTapped(x,y,z);
            }
        });
    }

	
    @Override
    protected void onPause() {
        super.onPause();
        mGLView.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mGLView.onResume();
    }
}

