abstract class Media implements Comparable<Media>
{
    protected String title;
	public String getTitle()  { return title; }
	
	public int compareTo(Media other) {
	   int i = toString().compareTo(other.toString());
	}
}
