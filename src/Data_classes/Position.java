package Data_classes;

import java.util.Deque;

public class Position {
	private double LAT,LON,ALT=0;
	public Position(String lat, String lon, String alt){
		LAT = Double.parseDouble(lat);
		LON = Double.parseDouble(lon);
		ALT = Double.parseDouble(alt);
	}
	public Position(String lon, String lat){
		LAT = Double.parseDouble(lat);
		LON = Double.parseDouble(lon);
		ALT = 0;
	}
	public Position(Position other){
		this.LAT = other.getLAT();
		this.LON = other.getLON();
		this.ALT = other.getALT();
	}

	public double getLAT(){
		return LAT;
	}
	public double getLON(){
		return LON;
	}
	public double getALT(){
		return ALT;
	}
	
	public String toString(){
		return LON+","+LAT;
	}

	public boolean equals(Position p1) {
		return(p1.getLAT()==this.getLAT()&&p1.getLON()==this.getLON()&&p1.getALT()==this.getALT());
	}
	/**
	 * learned the calculating method and implementation from:
	 *  https://www.movable-type.co.uk/scripts/latlong.html
	 * @param p
	 * @return distance between 2 positions
	 * R = earth�s radius
	 * L1 = this latitude
	 * L2 = parameter's latitude
	 * dL = latitudes delta
	 * dG = longitudes delta
	 * @author BarJan
	 */
	public double dist2D(Position p){
		double R = 6371*1000; // metres 
		double L1 = Math.toRadians(LAT);
		double L2 = Math.toRadians(p.getLAT());
		double lon1 = LON;
		double lon2 = p.getLON();		
		
		double dL = Math.toRadians(p.getLAT()-LAT);
		double dG = Math.toRadians(lon2-lon1);

		double a = (Math.sin(dL/2) * Math.sin(dL/2)) + Math.cos(L1) * Math.cos(L2) * Math.sin(dG/2) * Math.sin(dG/2);
		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));

		double d = R * c;
		return d;
	}


}



