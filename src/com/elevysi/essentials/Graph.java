package com.elevysi.essentials;

public class Graph {
	public GraphNode[] nodes;
	
	public void dfs(GraphNode root){
		visit(root);
		root.visited = true;
		for(GraphNode gn : root.adjacents){
			if(gn.visited == false){
				visit(gn);
				dfs(gn);
			}
		}
	}
	
	public void bfs(GraphNode root){
		Queue queue = new Queue();
		visit(root);
		root.visited = true;
		queue.add(root);
		while(!queue.isEmpty()){
			QueueNode toq = queue.remove();
			visit(toq);
			foreach(QueueNode qn : top.adjacents){
				if(qn.visited == false){
					visit(qn);
					qn.visited = true;
					queue.add(qn);
				}
			}
			
			
		}
	}
	
	public void visit(GraphNode gn){
		
	}
	
}
