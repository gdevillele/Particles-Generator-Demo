//////////////////////////////////////////////////////////
///
///	@file 			: HomeActivity.java
///	@description 	: main activity
///	@project		: Particles Engine Demo
///	@author			: Ga‘tan de Villle - Icecore 2011
///					: gdevillele@gmail.com
///
//////////////////////////////////////////////////////////

package com.icecore.android.demo.particlesengine;

import android.app.Activity;
import android.os.Bundle;
import android.widget.LinearLayout;


public class HomeActivity extends Activity
{
	//-----------------------------------------------------
	//	ATTRIBUTES
	//-----------------------------------------------------
	//--
	
	//------------------------------------------------------
	//	METHODS
	//------------------------------------------------------
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        
        // On dŽfni la hierarchie de Views / LinearLayout -> ParticlesView
        LinearLayout linear = new LinearLayout(this);
        ParticlesView pView = new ParticlesView(this);
        linear.addView(pView);
        setContentView(linear);
    }
}


















