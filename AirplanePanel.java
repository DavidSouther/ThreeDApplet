package ThreeDTransform;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.PrintStream;
import javax.swing.JComponent;
import javax.swing.JPanel;









public class AirplanePanel
  extends JPanel
{
  private static final long serialVersionUID = -3807080793486629559L;
  private static int PWIDTH = 250;
  private static int PHEIGHT = 250;
  


  private ThreeDImageTransformApplet owner;
  


  private ThreeDAirplane airplane;
  

  private Graphics2D dbg;
  

  private Image dbImage = null;
  


  private Color bgColor = Color.WHITE;
  


  private boolean FORCE_REDRAW = false;
  
  public AirplanePanel(ThreeDImageTransformApplet o) {
    owner = o;
    setBackground(bgColor);
    setPreferredSize(new Dimension(PWIDTH, PHEIGHT));
  }
  
  public void addNotify()
  {
    super.addNotify();
    buildAirplane();
  }
  
  public void buildAirplane() {
    airplane = new ThreeDAirplane(PWIDTH / 2, PHEIGHT / 2, owner);
  }
  

  public void stopAnim() {}
  
  public void update()
  {
    PWIDTH = getWidth();
    PHEIGHT = getHeight();
    FORCE_REDRAW = true;
    animRender();
    animDraw();
  }
  



  private void animRender()
  {
    if ((dbImage == null) || (FORCE_REDRAW)) {
      FORCE_REDRAW = false;
      if (PWIDTH <= 0) PWIDTH = 1;
      if (PHEIGHT <= 0) PHEIGHT = 1;
      dbImage = createImage(PWIDTH, PHEIGHT);
      if (dbImage == null) {
        System.err.println("dbImage is null: airplanePanelBean::animUpdate::1");
        return;
      }
      dbg = ((Graphics2D)dbImage.getGraphics());
    }
    
    dbg.setColor(bgColor);
    dbg.fillRect(0, 0, PWIDTH, PHEIGHT);
    
    dbg.setPaint(Color.BLACK);
    dbg.setStroke(new BasicStroke(2.0F, 1, 1, 10.0F));
    
    drawAirplane();
  }
  
  private void drawAirplane() {
    dbg = airplane.draw(dbg, getWidth(), getHeight());
  }
  



  private void animDraw()
  {
    try
    {
      Graphics g = getGraphics();
      if ((g != null) && (dbImage != null)) {
        g.drawImage(dbImage, 0, 0, null);
        g.dispose();
      }
    } catch (Exception e) {
      System.err.println("Graphics exception in airplanePanelBean::animDraw::1");
    }
  }
}
