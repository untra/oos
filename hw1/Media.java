abstract class Media implements Comparable<Media>
{
    protected String title;
	public String getTitle()  { return title; }
	
	public int compareTo(Media other) {
		if((this instanceof DVD && other instanceof DVD) || this instanceof Book && other instanceof Book){
			if(this.getTitle().equals(other.getTitle()))
				return this.toString().compareTo(other.toString());
			else{
				return this.getTitle().compareTo(other.getTitle());
			}
		}
		else if(this instanceof DVD && other instanceof Book){
			return -1;
		}
		else
			return 1;
	}
}
