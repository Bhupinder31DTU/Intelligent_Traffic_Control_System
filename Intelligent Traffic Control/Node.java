import java.util.ArrayList;

class Node implements Runnable{
	private String id;
	public ArrayList<SubNode> subnodes;
	
	public Node(String id){
		this.id = id;
	}
	
	public String getId(){
		return id;
	}
	
	public void run(){
		long currentTime = 0;
		final int totalCycleTime = 120;   	//in seconds
		final int flowRatePerSec = 1;		//vehicles passing per second
		
		int OnecyclePeriod = totalCycleTime/4;   //time alloted to one subnode
		int flowPerCycle = OnecyclePeriod*flowRatePerSec;
		
		Random r = new Random(1234);
		for(SubNode subnode : this.subnodes){
			subnode.updateCurrentTraffic(currentTime);
			
			if(subnode.currentTraffic >= flowPerCycle){
				int n1 = r.nextInt()*flowPerCycle;
				int n2 = r.nextInt()*flowPerCycle;
				int n3 = flowPerCycle - (n1+n2);
				subnode.currentTraffic -= flowPerCycle;
			}
				
			else{
				int n1 = r.nextInt()*subnode.currentTraffic;
				int n2 = r.nextInt()*subnode.currentTraffic;
				int n3 = subnode.currentTraffic - (n1+n2);
				subnode.currentTraffic = 0;
			}
			
			subnode.left.traffic.add(new Traffic(currentTime+30,n1));
			subnode.right.traffic.add(new Traffic(currentTime+30,n2));
			subnode.straight.traffic.add(new Traffic(currentTime+30,n3));
			
			Thread.sleep(OnecyclePeriod*1000);
		}
		
		currentTime += totalCycleTime;
		
	}
	
	public void run2(){
		long currentTime = 0;
		final int totalCycleTime = 120;   	//in seconds
		final int flowRatePerSec = 1;		//vehicles passing per second
		
		Random r = new Random(1234);
		
		long totalTraffic = 0;
		for(SubNode subnode : this.subnodes){
			subnode.updateCurrentTraffic(currentTime);
			totalTraffic += subnode.currentTraffic;
		}
		
		for(SubNode subnode : this.subnodes){
			int cycleTime = (int)(((float)subnode.currentTraffic/totalTraffic)*totalCycleTime);
			int flowPerCycle = cycleTime*flowRatePerSec;
			if(subnode.currentTraffic >= flowPerCycle){
				int n1 = r.nextInt()*flowPerCycle;
				int n2 = r.nextInt()*flowPerCycle;
				int n3 = flowPerCycle - (n1+n2);
				subnode.currentTraffic -= flowPerCycle;
			}
				
			else{
				int n1 = r.nextInt()*subnode.currentTraffic;
				int n2 = r.nextInt()*subnode.currentTraffic;
				int n3 = subnode.currentTraffic - (n1+n2);
				subnode.currentTraffic = 0;
			}
			
			subnode.left.traffic.add(new Traffic(currentTime+30,n1));
			subnode.right.traffic.add(new Traffic(currentTime+30,n2));
			subnode.straight.traffic.add(new Traffic(currentTime+30,n3));
			
			Thread.sleep(OnecyclePeriod*1000);
		}
		currentTime += totalCycleTime;
	}
}


