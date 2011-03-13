package com.icecore.android.demo.particlesengine;

import android.graphics.Color;
import android.graphics.drawable.PaintDrawable;


public class Particle
{
	//--------------------------------------------------------
	//	ATTRIBUTES
	//--------------------------------------------------------
	// Position actuelle
	private float 	position_x;
	private float 	position_y;
	// Vitesse actuelle
	private float 	speed_x;
	private float 	speed_y;
	// Durée de vie restante en Ms
	private int		life;
	// Objet Drawable représentant visuellement la particule
	private PaintDrawable drawable;
	
	
	
	//--------------------------------------------------------
	//	CONSTRUCTOR
	//--------------------------------------------------------
	// params : position en X et en Y
	public Particle( float newPositionX, float newPositionY )
	{
		// On défini la position initiale de la particule
		this.setPositionX(newPositionX);
		this.setPositionY(newPositionY);
		
		// On défini la vitesse initiale de la particule
		this.speed_x = (int)( (Math.random()*200*(-1))+100 );	// entre -100 et +100
		this.speed_y = (int)( (Math.random()*200*(-1))+100 );
		
		// On défini aléatoirement la durée de vie de la particule ( entre 500 et 1500 Ms )
		this.life = (int)( (Math.random()*1000)+500 );
		
		// On crée le Drawable avec une couleur aléatoire
		this.drawable = new PaintDrawable( Color.rgb((int)(Math.random()*255), (int)(Math.random()*255), (int)(Math.random()*255)) ); 
	}

	
	
	
	
	//--------------------------------------------------------
	//	METHODS
	//--------------------------------------------------------
	// TODO   : ajouter le GAP en Ms en paramètre
	// TODO 2 : ajouter le vecteur gravité en paramètre (change avec l'orientation du téléphone) 
	// TMP    : 20ms de gap
	public void update()
	{
		if(this.life >= 20)
		{
			this.life = this.life - 20;
		}
		else
		{
			this.life = 0;
		}
		// MAJ de la vitesse en fonction de la gravité
		//this.speed_x = this.speed_x + 0;
		this.speed_y = this.speed_y + 10; // gravité
		// MAJ de la position en fonction de la vitesse
		this.position_x = this.position_x + ((this.speed_x*20)/1000);
		this.position_y = this.position_y + ((this.speed_y*20)/1000);
	}
	
	
	
	
	//-----------------------------------------------------------------------
	// GETTER / SETTER
	//-----------------------------------------------------------------------
	public void setPositionX(float position_x) {
		this.position_x = position_x;
	}
	public float getPositionX() {
		return position_x;
	}
	public void setPositionY(float position_y) {
		this.position_y = position_y;
	}
	public float getPositionY() {
		return position_y;
	}
	public int getLife() {
		return life;
	}
	public PaintDrawable getDrawable() {
		return drawable;
	}


	
}
