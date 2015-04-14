class SwimRandomlyFishStrategy extends FishStrategy{
	public void move(Fish fish, Pond pond, double x, double y)
	{
		// A big enough fish won't worry about being eaten. swim randomly
		fish.swimRandomly();
	}
}