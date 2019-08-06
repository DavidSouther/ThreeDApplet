package ThreeDTransform;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Collections;

















public class ThreeDAirplane
{
  private ArrayList components;
  private ThreeDImageTransformApplet transformer;
  
  public ThreeDAirplane(int x, int y, ThreeDImageTransformApplet t)
  {
    transformer = t;
    components = new ArrayList();
    

























    ThreeDComponent bodyPiece = new ThreeDComponent(Color.BLACK, new double[][] {
    
      { -61.0D, 0.0D, 0.0D }, 
      { -56.0D, 0.0D, 5.0D }, 
      { -56.0D, 5.0D, 0.0D } }, x, y);
    components.add(bodyPiece);
    bodyPiece = new ThreeDComponent(Color.BLACK, new double[][] {
    
      { -61.0D, 0.0D, 0.0D }, 
      { -56.0D, 5.0D, 0.0D }, 
      { -56.0D, 0.0D, -5.0D } }, x, y);
    components.add(bodyPiece);
    bodyPiece = new ThreeDComponent(Color.BLACK, new double[][] {
    
      { -61.0D, 0.0D, 0.0D }, 
      { -56.0D, 0.0D, -5.0D }, 
      { -56.0D, -5.0D, 0.0D } }, x, y);
    components.add(bodyPiece);
    bodyPiece = new ThreeDComponent(Color.BLACK, new double[][] {
    
      { -61.0D, 1.0D, 0.0D }, 
      { -56.0D, -5.0D, 0.0D }, 
      { -56.0D, 0.0D, 5.0D } }, x, y);
    components.add(bodyPiece);
    



    bodyPiece = new ThreeDComponent(Color.BLUE, new double[][] {
    
      { 50.0D, -5.0D, 0.0D }, 
      { 56.0D, 0.0D, -5.0D }, 
      { 61.0D, 0.0D, -2.0D } }, x, y);
    components.add(bodyPiece);
    bodyPiece = new ThreeDComponent(Color.BLUE, new double[][] {
    
      { 50.0D, -5.0D, 0.0D }, 
      { 61.0D, 0.0D, -2.0D }, 
      { 61.0D, 0.0D, 2.0D } }, x, y);
    components.add(bodyPiece);
    bodyPiece = new ThreeDComponent(Color.BLUE, new double[][] {
    
      { 50.0D, -5.0D, 0.0D }, 
      { 56.0D, 0.0D, 5.0D }, 
      { 61.0D, 0.0D, 2.0D } }, x, y);
    components.add(bodyPiece);
    
    bodyPiece = new ThreeDComponent(Color.BLACK, new double[][] {
    
      { 50.0D, 5.0D, 0.0D }, 
      { 56.0D, 0.0D, -5.0D }, 
      { 61.0D, 0.0D, -2.0D } }, x, y);
    components.add(bodyPiece);
    bodyPiece = new ThreeDComponent(Color.BLACK, new double[][] {
    
      { 50.0D, 5.0D, 0.0D }, 
      { 61.0D, 0.0D, -2.0D }, 
      { 61.0D, 0.0D, 2.0D } }, x, y);
    components.add(bodyPiece);
    bodyPiece = new ThreeDComponent(Color.BLACK, new double[][] {
    
      { 50.0D, 5.0D, 0.0D }, 
      { 56.0D, 0.0D, 5.0D }, 
      { 61.0D, 0.0D, 2.0D } }, x, y);
    components.add(bodyPiece);
    
    bodyPiece = new ThreeDComponent(Color.BLACK, new double[][] {
    
      { 50.0D, 5.0D, 0.0D }, 
      { 61.0D, 0.0D, 0.0D }, 
      { 50.0D, -5.0D, 0.0D } }, x, y);
    components.add(bodyPiece);
    bodyPiece = new ThreeDComponent(Color.BLACK, new double[][] {
    
      { 61.0D, 0.0D, -5.0D }, 
      { 50.0D, 0.0D, 0.0D }, 
      { 50.0D, 0.0D, 5.0D } }, x, y);
    components.add(bodyPiece);
    


    bodyPiece = new ThreeDComponent(Color.BLACK, new double[][] {
      { -56.0D, 0.0D, -5.0D }, 
      { -56.0D, 0.0D, 5.0D }, 
      { -50.0D, 0.0D, 5.0D }, 
      { -50.0D, 0.0D, -5.0D } }, x, y);
    components.add(bodyPiece);
    bodyPiece = new ThreeDComponent(Color.BLACK, new double[][] {
      { -56.0D, -5.0D, 0.0D }, 
      { -56.0D, 5.0D, 0.0D }, 
      { -50.0D, 5.0D, 0.0D }, 
      { -50.0D, -5.0D, 0.0D } }, x, y);
    components.add(bodyPiece);
    
    bodyPiece = new ThreeDComponent(Color.BLACK, new double[][] {
      { -50.0D, 0.0D, -5.0D }, 
      { -50.0D, 0.0D, 5.0D }, 
      { -35.0D, 0.0D, 5.0D }, 
      { -35.0D, 0.0D, -5.0D } }, x, y);
    components.add(bodyPiece);
    bodyPiece = new ThreeDComponent(Color.BLACK, new double[][] {
      { -50.0D, -5.0D, 0.0D }, 
      { -50.0D, 5.0D, 0.0D }, 
      { -35.0D, 5.0D, 0.0D }, 
      { -35.0D, -5.0D, 0.0D } }, x, y);
    components.add(bodyPiece);
    
    bodyPiece = new ThreeDComponent(Color.BLACK, new double[][] {
      { -35.0D, 0.0D, -5.0D }, 
      { -35.0D, 0.0D, 5.0D }, 
      { 0.0D, 0.0D, 5.0D }, 
      { 0.0D, 0.0D, -5.0D } }, x, y);
    components.add(bodyPiece);
    bodyPiece = new ThreeDComponent(Color.BLACK, new double[][] {
      { -35.0D, -5.0D, 0.0D }, 
      { -35.0D, 5.0D, 0.0D }, 
      { 0.0D, 5.0D, 0.0D }, 
      { 0.0D, -5.0D, 0.0D } }, x, y);
    components.add(bodyPiece);
    
    bodyPiece = new ThreeDComponent(Color.BLACK, new double[][] {
      { 0.0D, 0.0D, -5.0D }, 
      { 0.0D, 0.0D, 5.0D }, 
      { 30.0D, 0.0D, 5.0D }, 
      { 30.0D, 0.0D, -5.0D } }, x, y);
    components.add(bodyPiece);
    bodyPiece = new ThreeDComponent(Color.BLACK, new double[][] {
      { 0.0D, -5.0D, 0.0D }, 
      { 0.0D, 5.0D, 0.0D }, 
      { 30.0D, 5.0D, 0.0D }, 
      { 30.0D, -5.0D, 0.0D } }, x, y);
    components.add(bodyPiece);
    
    bodyPiece = new ThreeDComponent(Color.BLACK, new double[][] {
      { 30.0D, 0.0D, -5.0D }, 
      { 30.0D, 0.0D, 5.0D }, 
      { 56.0D, 0.0D, 5.0D }, 
      { 56.0D, 0.0D, -5.0D } }, x, y);
    components.add(bodyPiece);
    bodyPiece = new ThreeDComponent(Color.BLACK, new double[][] {
      { 30.0D, -5.0D, 0.0D }, 
      { 30.0D, 5.0D, 0.0D }, 
      { 50.0D, 5.0D, 0.0D }, 
      { 50.0D, -5.0D, 0.0D } }, x, y);
    components.add(bodyPiece);
    



    ThreeDComponent rightWing = new ThreeDComponent(Color.GRAY, new double[][] {
    
      { 0.0D, 1.0D, 5.0D }, 
      { 30.0D, 1.0D, 5.0D }, 
      { 5.0D, 0.0D, 75.0D }, 
      { -5.0D, 0.0D, 75.0D } }, x, y);
    components.add(rightWing);
    ThreeDComponent leftWing = new ThreeDComponent(Color.GRAY, new double[][] {
    
      { 0.0D, 1.0D, -5.0D }, 
      { 30.0D, 1.0D, -5.0D }, 
      { 5.0D, 0.0D, -75.0D }, 
      { -5.0D, 0.0D, -75.0D } }, x, y);
    components.add(leftWing);
    ThreeDComponent rightTailWing = new ThreeDComponent(Color.LIGHT_GRAY, new double[][] {
    
      { -50.0D, -1.0D, 5.0D }, 
      { -35.0D, -1.0D, 5.0D }, 
      { -40.0D, 0.0D, 25.0D }, 
      { -50.0D, 0.0D, 25.0D } }, x, y);
    components.add(rightTailWing);
    ThreeDComponent leftTailWing = new ThreeDComponent(Color.LIGHT_GRAY, new double[][] {
    
      { -50.0D, -1.0D, -5.0D }, 
      { -35.0D, -1.0D, -5.0D }, 
      { -40.0D, 0.0D, -25.0D }, 
      { -50.0D, 0.0D, -25.0D } }, x, y);
    components.add(leftTailWing);
    ThreeDComponent tail = new ThreeDComponent(Color.DARK_GRAY, new double[][] {
    
      { -54.0D, -19.0D, 0.0D }, 
      { -40.0D, -18.0D, 0.0D }, 
      { -34.0D, -6.0D, 0.0D }, 
      { -55.0D, -6.0D, 0.0D } }, x, y);
    components.add(tail);
  }
  






  public Graphics2D draw(Graphics2D g, int width, int height)
  {
    int x_off = width / 2;
    int y_off = height / 2;
    



    int count = components.size();
    for (int x = 0; x < count; x++) {
      ThreeDComponent c = (ThreeDComponent)components.get(x);
      c.updatePoints(update(c.getPoints()));
      components.set(x, c);
    }
    Collections.sort(components);
    for (x = 0; x < count; x++) {
      ThreeDComponent c = (ThreeDComponent)components.get(x);
      g = c.draw(g, x_off, y_off);
    }
    return g;
  }
  




  public ArrayList update(ArrayList points)
  {
    return transformer.updatePoints(points);
  }
}
