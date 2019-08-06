package ThreeDTransform;

import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.io.PrintStream;
import java.text.NumberFormat;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JApplet;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JSpinner.DefaultEditor;
import javax.swing.border.TitledBorder;





public class ThreeDImageTransformApplet
  extends JApplet
{
  private static final long serialVersionUID = 1L;
  private AbstractInput input;
  private AbstractOutput output;
  private AirplanePanel airPanel;
  private static NumberFormat nf = ;
  
  public boolean SCALE = true;
  
  public static final String AIRPLANE_TITLE = "Airplane";
  
  public static final String INPUTS_TITLE = "Inputs";
  
  public static final int NONE = 0;
  public static final int EULER = 1;
  public static final int AXIS_ANGLE = 2;
  public static final int QUATERNION = 3;
  public static final int MATRIX = 4;
  public int INPUT = 1;
  public int OUTPUT = 0;
  private double[][] matrix;
  private double scale;
  private JPanel Aeroplane_Panel;
  private JPanel Display_Panel;
  private JPanel Inputs_panel;
  private JPanel jPanel1;
  
  public ThreeDImageTransformApplet() {}
  
  public void init() { initSettings();
    initVariables();
    initComponents();
    if (output != null) { Display_Panel.add(output.getOutputPanel());
    }
  }
  
  private void initSettings()
  {
    String temp = getParameter("SCALE");
    if (temp == null) temp = "TRUE";
    if (temp.equals("FALSE")) {
      SCALE = false;
    } else {
      SCALE = true;
    }
    
    temp = getParameter("INPUT");
    if (temp == null) temp = "EULER";
    if (temp.equals("EULER")) {
      INPUT = 1;
    } else if (temp.equals("AXIS_ANGLE")) {
      INPUT = 2;
    } else if (temp.equals("QUATERNION")) {
      INPUT = 3;
    } else if (temp.equals("MATRIX")) {
      INPUT = 4;
    } else {
      INPUT = 1;
    }
    
    temp = "NONE";
    temp = getParameter("OUTPUT");
    if (temp == null) temp = "NONE";
    if (temp.equals("NONE")) {
      OUTPUT = 0;
    } else if (temp.equals("EULER")) {
      OUTPUT = 1;
    } else if (temp.equals("AXIS_ANGLE")) {
      OUTPUT = 2;
    } else if (temp.equals("QUATERNION")) {
      OUTPUT = 3;
    } else if (temp.equals("MATRIX")) {
      OUTPUT = 4;
    } else {
      OUTPUT = 0;
    }
  }
  
  private void initVariables()
  {
    matrix = new double[][] {
      { 1.0D, 0.0D, 0.0D }, 
      { 0.0D, 1.0D, 0.0D }, 
      { 0.0D, 0.0D, 1.0D } };
    scale = 0.0D;
    
    switch (INPUT) {
    case 1:  input = new EulerInput(this); break;
    case 2:  input = new AngleInput(this); break;
    case 3:  input = new QuaternionInput(this); break;
    case 4:  input = new MatrixInput(this); break;
    default:  input = new EulerInput(this);
    }
    
    switch (OUTPUT) {
    case 1:  output = new EulerOutput(); break;
    case 2:  output = new AngleOutput(); break;
    case 3:  output = new QuaternionOutput(); break;
    case 4:  output = new MatrixOutput(); break;
    default:  output = null;
    }
    
    airPanel = new AirplanePanel(this);
    update();
  }
  
  public void paint(Graphics g) {
    super.paint(g);
    update();
  }
  
  public void updateMatrix(double[][] m) {
    matrix = m;
  }
  
  public void update() {
    update(matrix, 1.0D);
  }
  
  public void update(double[][] m) {
    update(m, 1.0D);
  }
  
  public void update(double s) {
    update(matrix, s);
  }
  
  public void update(double[][] m, double s) {
    matrix = m;
    scale = s;
    
    refreshUI();
  }
  
  private void refreshUI() {
    if (airPanel != null)
      airPanel.update();
    if ((OUTPUT != 0) && (output != null)) {
      output.update(matrix);
    }
  }
  






  private void initComponents()
  {
    jPanel1 = new JPanel();
    Inputs_panel = new JPanel();
    Display_Panel = new JPanel();
    Aeroplane_Panel = new JPanel();
    
    jPanel1.setLayout(new BorderLayout());
    
    Inputs_panel.setLayout(new BoxLayout(Inputs_panel, 0));
    
    Inputs_panel.setBorder(new TitledBorder("Inputs"));
    Inputs_panel.setMaximumSize(new Dimension(700, 75));
    Inputs_panel.setMinimumSize(new Dimension(260, 75));
    Inputs_panel.add(input.getInputPanel());
    jPanel1.add(Inputs_panel, "North");
    
    Display_Panel.setLayout(new BoxLayout(Display_Panel, 0));
    
    Aeroplane_Panel.setLayout(new BorderLayout());
    
    Aeroplane_Panel.setBorder(new TitledBorder("Airplane"));
    Aeroplane_Panel.setMinimumSize(new Dimension(200, 200));
    Aeroplane_Panel.setPreferredSize(new Dimension(300, 300));
    Aeroplane_Panel.add(airPanel);
    
    Display_Panel.add(Aeroplane_Panel);
    
    jPanel1.add(Display_Panel, "Center");
    
    getContentPane().add(jPanel1, "Center");
  }
  


  public Double deg2rad(double d)
  {
    return new Double(d * 3.141592653589793D / 180.0D);
  }
  
  public Double rad2deg(double d) {
    return new Double(d * 57.29577951308232D);
  }
  






  public static String concact(double d, int l)
  {
    nf.setMaximumFractionDigits(l);
    nf.setMinimumFractionDigits(1);
    String s = nf.format(d);
    

    int len = d >= 0.0D ? l : l + 1;
    String n; String n; if (s.length() > len)
      n = s.substring(0, len); else
      n = s;
    if (n.equals("-0.0")) n = "0.0";
    if (n.equals("NaN")) n = "Error";
    return n;
  }
  




  public static String concact(double d)
  {
    return concact(d, 7);
  }
  
  public JFormattedTextField getTextField(JSpinner spinner)
  {
    JComponent editor = spinner.getEditor();
    if ((editor instanceof JSpinner.DefaultEditor)) {
      return ((JSpinner.DefaultEditor)editor).getTextField();
    }
    System.err.println("Unexpected editor type: " + 
      spinner.getEditor().getClass() + 
      " isn't a descendant of DefaultEditor");
    return null;
  }
  




  public ArrayList updatePoints(ArrayList points)
  {
    ArrayList t = points;
    int count = t.size();
    

    for (int x = 0; x < count; x++) {
      Point p = (Point)t.get(x);
      Point n = new Point();
      double ox = p.getX();
      double oy = p.getY();
      double oz = p.getZ();
      n.setX((matrix[0][0] * ox + matrix[1][0] * oy + matrix[2][0] * oz) * scale);
      n.setY((matrix[0][1] * ox + matrix[1][1] * oy + matrix[2][1] * oz) * scale);
      n.setZ((matrix[0][2] * ox + matrix[1][2] * oy + matrix[2][2] * oz) * scale);
      t.set(x, n);
    }
    return t;
  }
}
