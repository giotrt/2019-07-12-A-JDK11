package it.polito.tdp.food.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

import it.polito.tdp.food.db.FoodDao;

public class Model {
	
	private Graph<Food, DefaultWeightedEdge> grafo;
	private FoodDao dao;
	private Map<Integer, Food> idMap;
	private List<Food> vertici;
	
	public Model() {
		dao = new FoodDao();
		idMap = new HashMap<>();
		dao.listAllFoods(idMap);
	}
	
	public void creaGrafo(int nPorzioni) {
		
		this.grafo = new SimpleWeightedGraph<Food, DefaultWeightedEdge>(DefaultWeightedEdge.class);
		
		this.vertici = new ArrayList<Food>();
		
		this.vertici = dao.getAllVertici(idMap, nPorzioni);
		
		Graphs.addAllVertices(this.grafo, vertici);
		
		System.out.println("#VERTICI: " + this.grafo.vertexSet().size());
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	

	public List<Food> getVertici() {
		return vertici;
	}
	public int getNumeroVertici() {
		return this.grafo.vertexSet().size();
	}
	public int getNumeroArchi() {
		return this.grafo.edgeSet().size();
	}
}
