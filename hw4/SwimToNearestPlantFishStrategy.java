

class SwimToNearestPlantFishStrategy extends FishStrategy{
	public void move(Fish fish, Pond pond,  double x, double y)
	{
		// Smaller fish only eat plants
        double[] location = pond.findNearestPlant(x, y);
        fish.swimTowards(location[0], location[1]);
	}
}
