import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
	static Map <Integer, VertexCoord> hashVertices =  new HashMap<Integer, VertexCoord>();
	static Double[] sideLengths = new Double [3];
	
	public static void main(String[] args) {
		
		int i = 1;
		do {
			System.out.print("Enter [x,y] coordinates for vertex ["
					+ i + "] of your triangle: ");
			if (parseStoreInput(i)) {
				i++;
			} else {
				System.err.println("Unable to parse input. "
						+ "Enter two numeric values, separated by a comma.");
				continue;
			}
		} while (i <= 3); 
		calcSideLength(1,2); 
		calcSideLength(2,3);
		calcSideLength(3,1);
		System.out.print("Is this a real triangle?  " + isRealTriangle() + "!");
		
	}
	
	public static boolean parseStoreInput(int intVertexID) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			try {
			String[] tempArray = reader.readLine().split(",");
			if (tempArray.length != 2) {
				return false;
			} else {
				Double[] arrayInput = new Double [tempArray.length];
				for (int i = 0; i < tempArray.length; i++) {
					try {
						arrayInput[i] = Double.parseDouble(tempArray[i]);
					}catch (NumberFormatException e){
						return false;
					}
				}
				hashVertices.put(intVertexID, new VertexCoord(arrayInput[0], arrayInput[1]));
//				VertexCoord thisVertex = hashVertices.get(intVertexID);
//				System.out.println("x: " + hashVertices.get(intVertexID).getx() + 
//						"  y: " + hashVertices.get(intVertexID).gety());
				return true;
			}
		} catch (IOException e) {
			return false;
		}
	}
	
	public static void calcSideLength(int VertexID1, int VertexID2) {
		//sqrt((x2-x1)^2+(y2-y1)^2)
		Double xDiff = hashVertices.get(VertexID2).getx()-hashVertices.get(VertexID1).getx();
		Double yDiff = hashVertices.get(VertexID2).gety()-hashVertices.get(VertexID1).gety();
		sideLengths[VertexID1-1] = Math.sqrt((Math.pow(xDiff, 2))+ (Math.pow(yDiff, 2)));
		System.out.println("Length of side " + VertexID1 +" = " + sideLengths[VertexID1-1]);
			
	}

	public static boolean isRealTriangle() {
		
		if ((sideLengths[0] + sideLengths[1]) > sideLengths[2]
		&& (sideLengths[1] + sideLengths[2]) > sideLengths[0]
		&& (sideLengths[2] + sideLengths[0]) > sideLengths[1]){
			return true;
		} else {
			return false;
		}
	}
	
    static class VertexCoord { // because I couldn't figure out how to access an array element nested in a map!
	Double x;
    Double y;
    public VertexCoord (Double x, Double y) { //setter
        this.x = x;
        this.y = y;
    }
    public Double getx() {
        return x;
    }
    public Double gety() {
        return y;
    }
}
}