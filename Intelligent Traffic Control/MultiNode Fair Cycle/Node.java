import java.util.ArrayList;
import java.util.Random;

class Node extends Thread{
	private String id;
	private int numberOfCycles = 5;
	public ArrayList<SubNode> subnodes;
	
	public Node(String id){
		this.id = id;
	}
	
	public String getNodeId(){
		return id;
	}
	
	public void run(){
		try {long currentTime = 0;
		final int totalCycleTime = 120;   	//in seconds
		final int flowRatePerSec = 1;		//vehicles passing per second
		
		for(int i=0;i<numberOfCycles;i++) {
			Random r = new Random(1234);
			long totalTraffic = 0;
			for(SubNode subnode : this.subnodes){
				subnode.updateCurrentTraffic(currentTime);
				totalTraffic += subnode.currentTraffic;
			}
			for(SubNode subnode : this.subnodes){
				int cycleTime = (int)((((float)subnode.currentTraffic)/totalTraffic)*totalCycleTime);
				//System.out.println(this.getNodeId()+" "+subnode.getId()+" "+cycleTime);
				int flowPerCycle = cycleTime*flowRatePerSec;
				int n1,n2,n3;
				if(subnode.currentTraffic >= flowPerCycle){
					n1 = (int)(r.nextInt(100)*flowPerCycle)/100;
					n2 = (int)(r.nextInt(100)*flowPerCycle)/100;
					if(n1 + n2 > flowPerCycle) 
						n2 = flowPerCycle - n1;
					n3 = flowPerCycle - (n1+n2);
					subnode.currentTraffic -= flowPerCycle;
				}
					
				else{
					n1 = (int)(r.nextInt(100)*(int)subnode.currentTraffic)/100;
					n2 = (int)(r.nextInt(100)*(int)subnode.currentTraffic)/100;
					if(n1 + n2 > (int)subnode.currentTraffic)
						n2 = (int)subnode.currentTraffic - n1;
					n3 = (int)subnode.currentTraffic - (n1+n2);
					subnode.currentTraffic = 0;
				}
				
				subnode.left.addTraffic(new Traffic(currentTime+30,n1));
				subnode.right.addTraffic(new Traffic(currentTime+30,n2));
				subnode.straight.addTraffic(new Traffic(currentTime+30,n3));
				
				Thread.sleep(cycleTime*1000);
				//System.out.println("Current Time: "+cycleTime+currentTime)
			}
			currentTime += totalCycleTime;
			}
		} catch(Exception e) {
			System.out.println("Exception Caught : Here"+e.getMessage());
		}
	}
	public int getCurrentTraffic(long currentTime) {
		int currentTraffic = 0;
		for(SubNode sNode : subnodes) {
			currentTraffic += sNode.currentTraffic;
		}
		return currentTraffic;
	}
}


