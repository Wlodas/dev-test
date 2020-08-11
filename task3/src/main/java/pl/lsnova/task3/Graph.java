package pl.lsnova.task3;

import java.util.BitSet;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Set;

final class Graph {
	private final Set<SubGraph> subGraphs = Collections.newSetFromMap(new IdentityHashMap<>());
	
	void addEdge(int vertice1, int vertice2) {
		SubGraph subGraphToMerge1 = null;
		SubGraph subGraphToMerge2 = null;
		
		for (SubGraph subGraph : subGraphs) {
			if (subGraph.hasVertice(vertice1) || subGraph.hasVertice(vertice2)) {
				if (subGraphToMerge1 == null) {
					subGraph.addVertice(vertice1);
					subGraph.addVertice(vertice2);
					subGraphToMerge1 = subGraph;
				} else {
					subGraphToMerge2 = subGraph;
					break;
				}
			}
		}
		
		if (subGraphToMerge1 == null) {
			SubGraph subGraph = new SubGraph();
			subGraph.addVertice(vertice1);
			subGraph.addVertice(vertice2);
			subGraphs.add(subGraph);
		} else if (subGraphToMerge2 != null) {
			subGraphToMerge1.addAllVerticesFromSubGraph(subGraphToMerge2);
			subGraphs.remove(subGraphToMerge2);
		}
	}
	
	int countSubGraphs() {
		return subGraphs.size();
	}
	
	@Override
	public String toString() {
		return subGraphs.toString();
	}
	
	private static final class SubGraph {
		private final BitSet vertices = new BitSet();
		
		boolean hasVertice(int vertice) {
			return vertices.get(vertice);
		}
		
		void addVertice(int vertice) {
			vertices.set(vertice);
		}
		
		void addAllVerticesFromSubGraph(SubGraph other) {
			vertices.or(other.vertices);
		}
		
		@Override
		public String toString() {
			return vertices.toString();
		}
	}
}
