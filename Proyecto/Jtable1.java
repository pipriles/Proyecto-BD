import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.*;
import javax.swing.*;
import java.lang.Object;

public class Jtable1
{
  public JFrame ventana;
  private JTable tabla;

  public Jtable1()
  {
      ventana = new JFrame("Tablas");
      ventana.setLayout(new FlowLayout());
      ventana.setSize(700,200);
      //this.set_Table(datos,cabezera);
      //ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      ventana.setVisible(true);
  }

  public void set_Table(String datos[][], String cabecera[])
  {
      tabla = new JTable(datos,cabecera);
      JScrollPane js = new JScrollPane(tabla);
      js.setPreferredSize(new Dimension(400,150));
      ventana.add(js);
  }

  public static void main(String[] args)
  {
    Jtable1 tabla = new Jtable1();
  }
}
