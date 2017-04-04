
public class BrownieStore {
	int numberOfBrownies = 10;
	String name = "A store";
	
	int cookies = 100;
	
	BrownieStore(String aName) {
		name = aName;
	}
	public int getCookies() { return cookies; }
	
	public void gotClicked() {
		System.out.println(name+" got clicked");
	}
}
