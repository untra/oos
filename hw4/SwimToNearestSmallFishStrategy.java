	class SwimToNearestSmallFishFishStrategy extends FishStrategy{
	public void move(Fish fish, Pond pond,  double x, double y)
	{
		// Really big fish like to eat other fish
        double[] location = pond.findNearestSmallFish(x, y);
        fish.swimTowards(location[0], location[1]);
	}
	}