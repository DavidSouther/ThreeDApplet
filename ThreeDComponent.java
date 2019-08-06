package ThreeDTransform;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.GeneralPath;
import java.util.ArrayList;
import java.util.Collections;






















public class ThreeDComponent
  implements Comparable
{
  ArrayList origPoints;
  ArrayList tempPoints;
  private double avgZ;
  Color color;
  
  public ThreeDComponent(Color c, double[][] ps)
  {
    this(c, ps, 0, 0);
  }
  
  public ThreeDComponent(Color c, double[][] ps, int x, int y) {
    origPoints = new ArrayList();
    tempPoints = new ArrayList();
    

    int count = ps.length;
    for (int i = 0; i < count; i++) {
      double[] d = ps[i];
      Point p = new Point(d[0], d[1], d[2]);
      
      origPoints.add(p);
      tempPoints.add(p);
    }
    color = c;
  }
  
  public int compareTo(Object o) {
    if ((o instanceof ThreeDComponent)) {
      ThreeDComponent c = (ThreeDComponent)o;
      computeAverageZ();
      c.computeAverageZ();
      if (getAvgZ() >= c.getAvgZ()) {
        return 1;
      }
      return -1;
    }
    return -1;
  }
  
  private void computeAverageZ() {
    double t = 0.0D;
    
    int count = tempPoints.size();
    for (int x = 0; x < count; x++) {
      Point point = (Point)tempPoints.get(x);
      t += point.getZ();
    }
    setAvgZ(t / count);
  }
  
  public double getAvgZ() {
    return avgZ;
  }
  
  public void setAvgZ(double avgZ) {
    this.avgZ = avgZ;
  }
  
  public Graphics2D draw(Graphics2D g, int X_OFFSET, int Y_OFFSET) {
    int count = tempPoints.size();
    Point basePoint = (Point)tempPoints.get(0);
    
    GeneralPath polygon = new GeneralPath();
    polygon.moveTo((float)basePoint.getX() + X_OFFSET, (float)basePoint.getY() + Y_OFFSET);
    
    for (int x = 1; x < count; x++) {
      Point p = (Point)tempPoints.get(x);
      polygon.lineTo((float)p.getX() + X_OFFSET, (float)p.getY() + Y_OFFSET);
    }
    
    polygon.closePath();
    
    g.setPaint(color);
    
    g.draw(polygon);
    g.fill(polygon);
    
    return g;
  }
  
  public ArrayList getPoints() {
    ArrayList temp = new ArrayList(origPoints.size());
    for (int x = 0; x < origPoints.size(); x++) {
      temp.add(new Integer(0));
    }
    Collections.copy(temp, origPoints);
    return temp;
  }
  
  public void updatePoints(ArrayList points) {
    tempPoints = points;
  }
}
