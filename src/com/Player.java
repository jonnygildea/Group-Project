package com;

class Player
{
	int health=100;
	int stamina=100;
	
	public int getHealth()
	{
		return health;
	}
	public void setHealth(int i)
	{
		if (i>100)
			health=100;
		if (i<0)
			health =0;			
		else
			health=i;
	}
	public int getStamina()
	{
		return stamina;
	}
	public void setStamina(int i)
	{
		if (i>100)
			stamina=100;
		if (i<0)
			stamina =0;			
		else
			stamina=i;
	}
}