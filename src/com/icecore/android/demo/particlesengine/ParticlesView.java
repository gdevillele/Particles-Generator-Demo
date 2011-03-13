package com.icecore.android.demo.particlesengine;

import java.util.ArrayList;

import android.view.MotionEvent;
import android.view.View;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.PaintDrawable;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;


public class ParticlesView extends View
{
	// ATTRIBUTES
	//---------------------------------------------------	
	private ArrayList<Particle>		particlesArray		= new ArrayList<Particle>();
	private RefreshHandler 			myRefreshHandler	= new RefreshHandler();

	
	
	
	// CONSTRUCTOR
	public ParticlesView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		this.init();
	}
	public ParticlesView(Context context, AttributeSet attrs) {
		super(context, attrs);
		this.init();
	}
	public ParticlesView(Context context) {
		super(context);
		this.init();
	}
	
	
	
	
	// INIT - just after the instanciation
	//-------------------------------------------------------------
	protected void init()
	{
		//Particle p = new Particle(100, 100);
		//this.particlesArray.add(p);
	}
	
	
	// ON TOUCH
	//--------------------------------------------------------------
	 public boolean onTouchEvent(MotionEvent event)
	    {	
	    	Particle p = new Particle(event.getX(), event.getY());
			this.particlesArray.add(p);
	    	
	    	// si evenement gŽrŽ -> TRUE // sinon FALSE
			return true;
	    }
	
	// ON MEASURE
	//-------------------------------------------------------------
	@Override
	protected void onMeasure(int widthSpec, int heightSpec)
	{
		int specWidth=MeasureSpec.getSize(widthSpec);
		int specHeight=MeasureSpec.getSize(heightSpec);
		setMeasuredDimension(specWidth,specHeight);
	}
	
	
	// ON DRAW
	//---------------------------------------------------------------
	@Override
	protected void onDraw(Canvas canvas)
	{		
			for( int i=0 ; i < this.particlesArray.size() ; i++ )
			{
				if(this.particlesArray.get(i) != null)
				{
					this.particlesArray.get(i).update();
					if(this.particlesArray.get(i).getLife() == 0)
					{
						this.particlesArray.remove(i);
					}
					else
					{
						PaintDrawable d = this.particlesArray.get(i).getDrawable();
						int x = (int)this.particlesArray.get(i).getPositionX();
						int y = (int)this.particlesArray.get(i).getPositionY();
						d.setBounds( x, y, x+10, y+10);
						if(this.particlesArray.get(i).getLife() >= 0 && this.particlesArray.get(i).getLife() < 255)
							d.setAlpha(this.particlesArray.get(i).getLife());
						else
							d.setAlpha(255);
						d.draw(canvas);
					}
				}
			}
		this.myRefreshHandler.sleep(20);
	}
	
	
	//-------------------------------------------
	//	REFRESH HANDLER CLASS
	//
	class RefreshHandler extends Handler
	{
	    @Override
	    public void handleMessage(Message msg)
		{
	       	// TODO - EFFECTUE LA MAJ DES PARTICLES
	    	// en fonction de la vitesse et de la gravitŽ
	       	ParticlesView.this.invalidate();
	    }

	    public void sleep(long delayMillis)
		{
	        this.removeMessages(0);
	        sendMessageDelayed(obtainMessage(0), delayMillis);
	    }
	};// HANDLER CLASS END
	
	
}// VIEW CLASS END
