class AvoidBigFishFishStrategy extends FishStrategy{
	public void move(Fish fish, Pond pond,  double x, double y)
	{
		// Want to avoid the nearest big fish
        double[] location = pond.findNearestBigFish(x, y);
        fish.swimAway(location[0], location[1]);
	}
}