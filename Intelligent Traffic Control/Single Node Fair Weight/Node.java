import java.util.ArrayList;

class Node{
	private String id;
	public ArrayList<SubNode> subnodes;
	public ArrayList<Integer> traffic;
	
	public Node(String id){
		this.id = id;
	}
	
	public String getId(){
		return id;
	}
}

class SubNode{
	private String id;
	public SubNode left;
	public SubNode right;
	public SubNode straight;
	
	public SubNode(String id){
		this.id = id;
	}
	
	public String getId(){
		return id;
	}
}
