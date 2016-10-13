import java.util.ArrayList;

class SubNode{
	private String id;
	public SubNode left;
	public SubNode right;
	public SubNode straight;
	public ArrayList<Traffic> traffic;
	public long currentTraffic;
	
	public SubNode(String id){
		this.id = id;
	}
	
	public String getId(){
		return id;
	}
	
	public void updateCurrentTraffic(long currentTime){
		long ct = currentTraffic;
		for(Traffic t : traffic){
			if(t.time <= currentTime){
				ct += t.traffic;
				traffic.remove(t);
			}
		}
		currentTraffic = ct;
	}
}

class Traffic{
	public long time;
	public long traffic;
	
	public Traffic(long ct, long t){
		time = ct;
		traffic = t;
	}
}