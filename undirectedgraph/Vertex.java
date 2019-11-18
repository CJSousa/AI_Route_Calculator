package undirectedgraph;
import java.util.ArrayList;

public class Vertex {
	private ArrayList<Edge> neighborhood;
	private String label;
	private double lng, lat;
	
	public Vertex(String label) {
		this.label = label;
		this.neighborhood = new ArrayList<Edge>();
		this.lng = 0;
		this.lat = 0;
	}
	
	
	public void setCoordinates(double lat, double lng) {
		this.lng = lng;
		this.lat = lat;		
	}
	
	public double straightLineDistance(Vertex v) {
		double lat1 = this.lat;
		double lng1 = this.lng;
		double lat2 = v.lat;
		double lng2 = v.lng;
        double theta = (lng1 - lng2)* Math.PI / 180.0;
        double dist = Math.sin(lat1* Math.PI / 180.0) * Math.sin(lat2* Math.PI / 180.0) + Math.cos(lat1* Math.PI / 180.0) * Math.cos(lat2* Math.PI / 180.0) * Math.cos(theta);
        dist = Math.acos(dist);
        dist = dist* 180.0 / Math.PI;
        dist = dist * 60 * 1.1515 * 1.609344;
        return (int) dist;
    }
	
	public void addNeighbor(Edge edge) {
		if (this.neighborhood.contains(edge)) return;
		this.neighborhood.add(edge);
	}
	
	public boolean containsNeighbor(Edge edge) {
		return this.neighborhood.contains(edge);
	}
	
	public int getNeigborCount() {
		return this.neighborhood.size();
	}
	
	public ArrayList<Edge> getNeighbors() {
		return new ArrayList<Edge>(this.neighborhood);
	}
	
	public String getLabel() {
		return this.label;
	}

	public double getLatitude() {
		return this.lat;
	}
	
	public double getLongitude() {
		return this.lng;
	}
	
	public String toString() {
		return label;
	}
	
	public int hashcode() {
		return this.label.hashCode();
	}
	
	public boolean equals(Object other) {
		if (!(other instanceof Vertex)) return false;
		Vertex v = (Vertex)other;
		return this.label.equals(v.label);
	}

}
