import java.util.*;


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
	
	public synchronized void addTraffic(Traffic t){
		traffic.add(t);
	}
	
	public synchronized void updateCurrentTraffic(long currentTime){
		long ct = currentTraffic;
		Iterator it = traffic.iterator();
		while(it.hasNext()){
			Traffic t = (Traffic)it.next();
			if(t.time <= currentTime){
				ct += t.traffic;
				it.remove();
			}
		}
		/*for(Traffic t : traffic) {
			if(t.time <= currentTime){
				ct += t.traffic;
				traffic.remove(t);
			}
		}*/
		currentTraffic = ct;
	}
	
	public int getCurrentTraffic(long currentTime){
		int ct = (int)currentTraffic;
		Iterator it = traffic.iterator();
		while(it.hasNext()){
			Traffic t = (Traffic)it.next();
			if(t.time <= currentTime){
				ct += t.traffic;
				//it.remove();
			}
		}
		return ct;
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