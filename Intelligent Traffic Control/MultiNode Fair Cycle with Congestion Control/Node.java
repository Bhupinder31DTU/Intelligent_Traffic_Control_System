import java.util.*;

class Node extends Thread{
	private String id;
	public int numberOfCycles = 5;
	public ArrayList<SubNode> subnodes;
	
	public Node(String id){
		this.id = id;
	}
	
	public String getNodeId(){
		return id;
	}
		
	public void run(){
		try {
		long currentTime = 0;
		final int totalCycleTime = 120;   	//in seconds
		final int flowRatePerSec = 1;		//vehicles passing per second
		
		for(int i=0;i<numberOfCycles;i++) {
		Random r = new Random(1234);
		
		long totalTraffic = 0;
		for(SubNode subnode : this.subnodes){
			subnode.updateCurrentTraffic(currentTime);
			totalTraffic += subnode.currentTraffic;
		}
		
		int temp = 0;
		for(SubNode subnode : this.subnodes){
			
			//Now cycle time will also depend upon the congestion at neighbour subnodes
			int cycleTime = (int)((((float)subnode.currentTraffic)/totalTraffic)*totalCycleTime);
			
			int ctLeft=cycleTime,ctRight=cycleTime,ctStraight=cycleTime;
			if(subnode.left.currentTraffic > 120 && subnode.left.currentTraffic <= 150)
				ctLeft = (int)(cycleTime*0.9);
			else if(subnode.left.currentTraffic > 150 && subnode.left.currentTraffic <= 200)
				ctLeft = (int)(cycleTime*0.8);
			else if(subnode.left.currentTraffic > 200 && subnode.left.currentTraffic <= 250)
				ctLeft = (int)(cycleTime*0.7);
			else if(subnode.left.currentTraffic > 250 && subnode.left.currentTraffic <= 300)
				ctLeft = (int)(cycleTime*0.6);
			else if(subnode.left.currentTraffic > 300 && subnode.left.currentTraffic <= 350)
				ctLeft = (int)(cycleTime*0.5);
			else if(subnode.left.currentTraffic > 350)
				ctLeft = 0;

			if(subnode.right.currentTraffic > 120 && subnode.right.currentTraffic <= 150)
				ctRight = (int)(cycleTime*0.9);
			else if(subnode.right.currentTraffic > 150 && subnode.right.currentTraffic <= 200)
				ctRight = (int)(cycleTime*0.8);
			else if(subnode.right.currentTraffic > 200 && subnode.right.currentTraffic <= 250)
				ctRight = (int)(cycleTime*0.7);
			else if(subnode.right.currentTraffic > 250 && subnode.right.currentTraffic <= 300)
				ctRight = (int)(cycleTime*0.6);
			else if(subnode.right.currentTraffic > 300 && subnode.right.currentTraffic <= 350)
				ctRight = (int)(cycleTime*0.5);
			else if(subnode.right.currentTraffic > 350)
				ctRight = 0;
			
			if(subnode.straight.currentTraffic > 120 && subnode.straight.currentTraffic <= 150)
				ctStraight = (int)(cycleTime*0.9);
			else if(subnode.straight.currentTraffic > 150 && subnode.straight.currentTraffic <= 200)
				ctStraight = (int)(cycleTime*0.8);
			else if(subnode.straight.currentTraffic > 200 && subnode.straight.currentTraffic <= 250)
				ctStraight = (int)(cycleTime*0.7);
			else if(subnode.straight.currentTraffic > 250 && subnode.straight.currentTraffic <= 300)
				ctStraight = (int)(cycleTime*0.6);
			else if(subnode.straight.currentTraffic > 300 && subnode.straight.currentTraffic <= 350)
				ctStraight = (int)(cycleTime*0.5);
			else if(subnode.straight.currentTraffic > 350)
				ctStraight = 0;
			
			int n1,n2,n3;
			n1 = (int)(r.nextInt(100)*subnode.currentTraffic)/100;
					n2 = (int)(r.nextInt(100)*subnode.currentTraffic)/100;
					if(n1 + n2 > subnode.currentTraffic) 
						n2 = (int)(subnode.currentTraffic - n1);
					n3 = (int)(subnode.currentTraffic - (n1+n2));
			
			int flowPerCycle = (int)((ctLeft + ctRight + ctStraight)/3.0 * flowRatePerSec);
			if(subnode.currentTraffic >= flowPerCycle){
				subnode.currentTraffic -= flowPerCycle;
			}
				
			else{
				subnode.currentTraffic = 0;
			}
			
			subnode.left.addTraffic(new Traffic(currentTime+30,(int)(ctLeft*flowRatePerSec/3.0)));
			subnode.right.addTraffic(new Traffic(currentTime+30,(int)(ctRight*flowRatePerSec/3.0)));
			subnode.straight.addTraffic(new Traffic(currentTime+30,(int)(ctRight*flowRatePerSec/3.0)));
			
			int maxCT = (ctLeft>ctRight)?(ctLeft>ctStraight?ctLeft:ctStraight):(ctRight>ctStraight?ctRight:ctStraight);
			Thread.sleep(maxCT*1000);
			temp += maxCT;
		}
		currentTime += temp;
	}
		}catch(Exception e) {
			System.out.println("Exception Caught : "+e.getMessage());
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


