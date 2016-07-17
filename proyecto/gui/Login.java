/* Login.java
 * Interfaz del inicio de sesion
 */

package 

import java.awt.*;
import javax.imageio.ImageIO;
import java.io.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

public class Login extends JFrame implements ActionListener
{
	public JButton boton, boton2, boton3, boton4, continuar, continuarEl, regresar, regresar1, regresar2, consulta1, consulta2, consulta3, bm, eliminar;
	public JPanel panel;
	public JTextField user;
	public JPasswordField pas;
	public JLabel x, y, a, j, t, e, i, z;
	public JComboBox CmbUser_Type, tablaInser, ofptions;
	public Container contenedor, contenedor2, contenedor3;
	private JRadioButton r1,r2;
	private ButtonGroup grupo;
	public JTextField inserta,insertb,insertc,insertd,inserte,insertf, insertg, inserth;
	public JLabel insertx, inserty, insertz, insertw, insertww, insertu, insertv, insertt, insertr, inserts;
	public JComboBox insertTipo, insertRif;
	public String sql = "", sql2 = "", prueba;
	JFrame ventana;

	//Listas de opciones desplegables
	String[] usertype = {"Administrador", "Trabajador"};
	String[] opciones = {"Insertar", "Eliminar"};
	String[] tablas = {"SELECCIONE LA TABLA","PRODUCTO", "EMPRESA", "MAQUINARIA", "CLIENTE", "CURSO", "MAESTRO", "FACTURA"};
	String[] tipos = {"CHOCOLATERA", "TIENDA", "PROCESADORA"};
	String[] rifemp = {"abcd", "acdb", "bdgs"};

	/*************************************************************/

	public Home base;

	public static final int W_WIDTH  = 800;
	public static final int W_HEIGHT = 500;

	/* Constructor */
	public Login(Home base) {
		this.base = base;
		inicio();
	}

	void ventana() {
		this.setBounds(100, 100, W_WIDTH, W_HEIGHT);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		// setOpacity(0.9f); /* Poner transparente la ventana */
	}

	void inicio() {
		ventana();
		contenedor = new Container();
		setContentPane(contenedor);
		try {
			this.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("img/6.jpg")))));
		}
		catch(IOException e) {
			e.printStackTrace();
		}

		setTitle("--.Inicio.--"); 									/// Coloca el nombre a la ventana
		a = new JLabel ("Ingrese Sus Datos de Acceso");
		a.setBounds(210, 90, 400,60);
		a.setForeground(Color.white); 								/// CAMBIAR COLOR DE LETRA
		a.setFont(new java.awt.Font ("Times New Roman", 1, 24)); 	/// CAMBIAR TIPO LETRA
		this.getContentPane().add(a);

		t = new JLabel ("Tipo de usuario ");
		t.setBounds(222, 170, 150,25);
		t.setForeground(Color.white); 								/// CAMBIAR COLOR DE LETRA
		t.setFont(new java.awt.Font ("Times New Roman", 1, 16)); 	/// CAMBIAR TIPO LETRA
		this.getContentPane().add(t);

		CmbUser_Type = new JComboBox(usertype);
		CmbUser_Type.setBounds(360, 170, 150,25);
		CmbUser_Type.setForeground(Color.red); 								/// CAMBIAR COLOR DE LETRA
		CmbUser_Type.setFont(new java.awt.Font ("Times New Roman", 1, 16)); /// CAMBIAR TIPO LETRA
		this.getContentPane().add(CmbUser_Type);

		x = new JLabel ("Nombre de usuario");
		x.setBounds(190, 200, 180,25);
		x.setForeground(Color.white); 								/// CAMBIAR COLOR DE LETRA
		x.setFont(new java.awt.Font ("Times New Roman",1 , 16)); 	/// CAMBIAR TIPO LETRA
		this.getContentPane().add(x);

		user = new JTextField();
		user.setBounds(360, 200, 150,25);
		this.getContentPane().add(user);

		y = new JLabel ("Contrase\u00f1a "); 						// \u00f1 para la 'ñ'
		y.setBounds(256, 230, 140,25);
		y.setForeground(Color.white); 								// CAMBIAR COLOR DE LETRA
		y.setFont(new java.awt.Font ("Times New Roman",1 , 16)); 	// CAMBIAR TIPO LETRA
		this.getContentPane().add(y);

		pas = new JPasswordField();
		pas.setBounds(360, 230, 150,25);
		this.getContentPane().add(pas);

		boton3 = new JButton("Iniciar"); 							// Crea el boton
		boton3.setBounds(300,270,110,40);
		boton3.setForeground(Color.black);
		//boton3.setBackground(java.awt.Color.red);
		this.getContentPane().add(boton3); 							// Agrega el boton a la ventana
		boton3.addActionListener(this);

		boton = new JButton("Salir"); 								// Crea el boton
		boton.setBounds(420,270,110,40);
		boton.setForeground(Color.black);
		//boton.setBackground(java.awt.Color.red);
		this.getContentPane().add(boton); 							// Agrega el boton a la ventana
		boton.addActionListener(this);

		z = new JLabel ("G.J.W.O.");
		z.setBounds(720, 448, 180,25);
		z.setForeground(Color.white); 								/// CAMBIAR COLOR DE LETRA
		z.setFont(new java.awt.Font ("Times New Roman",1 , 16)); 	/// CAMBIAR TIPO LETRA
		this.getContentPane().add(z);
		repaint();
	}

	public void actionPerformed(ActionEvent e) {
		System.out.println("Detect!");
	}



	/*************************************************************/



	
	ResultSet Conexion(String sql)
	{
		ResultSet x = null;
		Connection conexion;
		Model con;
		con = new Model();

		try
		{
			conexion=con.obtConexion("proyecto_bd","postgres","josegregorio");
			Statement st;
			st = conexion.createStatement();
			ResultSet rs;
			rs = st.executeQuery(sql);
			x = rs;
		}
		catch(SQLException e)
		{
			JOptionPane.showMessageDialog (null, "Error: "+e.getMessage(), "Error Conexion", JOptionPane.ERROR_MESSAGE);
		}
		return x;
	}

	void borrar (String sql)
	{
		Connection conexion;
		Model con;
		con = new Model();
		try
		{
			conexion=con.obtConexion("proyecto_bd","postgres","josegregorio");
			Statement st;
			st = conexion.createStatement();
			st.executeQuery(sql);
		}
		catch(SQLException e)
		{
			JOptionPane.showMessageDialog (null,"Eliminacion Correcta");
		}
	}

	void guardar (String sql)
	{
		Connection conexion;
		Model con;
		con = new Model();
		try
		{
			conexion=con.obtConexion("proyecto_bd","postgres","josegregorio");
			Statement st;
			st = conexion.createStatement();
			st.executeQuery(sql);
		}
		catch(SQLException e)
		{
			JOptionPane.showMessageDialog (null,"Insercion Correcta");
		}
	}

	// CHECK
  	void homeTrabajador()
	{
		contenedor2 = new Container();
		setContentPane(contenedor2);
		try
		{
			this.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("img/6.jpg")))));
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}

		String k = user.getText();
		setTitle("Sesion iniciada como: " + k); 				// Coloca el nombre a la ventana
		this.setVisible(true);

		j = new JLabel ("Realizar Consultas del trabajador");
		j.setBounds(265, 55, 250,25);
		j.setForeground(Color.white);
		this.getContentPane().add(j);

		consulta1 = new JButton("CONSULTA Nº1"); 				// Crea el boton
		consulta1.setBounds(33,100,200,40);
		consulta1.setForeground(Color.black);
		//boton.setBackground(java.awt.Color.red);
		this.getContentPane().add(consulta1); 					// Agrega el boton a la ventana
		consulta1.addActionListener(this);

    	consulta2 = new JButton("CONSULTA Nº2"); 				// Crea el boton
		consulta2.setBounds(300,100,200,40);
		consulta2.setForeground(Color.black);
		//boton.setBackground(java.awt.Color.red);
		this.getContentPane().add(consulta2); 					// Agrega el boton a la ventana
		consulta2.addActionListener(this);

    	consulta3 = new JButton("CONSULTA Nº3"); 				// Crea el boton
		consulta3.setBounds(565,100,200,40);
		consulta3.setForeground(Color.black);
		//boton.setBackground(java.awt.Color.red);
		this.getContentPane().add(consulta3); 					// Agrega el boton a la ventana
		consulta3.addActionListener(this);

		boton2 = new JButton("Cerrar Sesion"); 					// Crea el boton
		boton2.setBounds(325,270,150,40);
		//boton2.setBackground(java.awt.Color.blue);
		this.getContentPane().add(boton2); 						// Agrega el boton a la ventana
		boton2.addActionListener(this);

		z = new JLabel ("G.J.W.O.");
		z.setBounds(720, 448, 180,25);
		z.setForeground(Color.white); 								/// CAMBIAR COLOR DE LETRA
		z.setFont(new java.awt.Font ("Times New Roman",1 , 16));	/// CAMBIAR TIPO LETRA
		this.getContentPane().add(z);

		repaint();
	}

	void homeAdministrador()
	{
		contenedor3 = new Container();
		setContentPane(contenedor3);

		try
		{
			this.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("img/8.jpg")))));
		}
		catch(IOException e)
		{
		  	e.printStackTrace();
		}

		String k = user.getText();
		setTitle("Sesion iniciada como: "+k); //coloca el nombre a la ventana
		this.setVisible(true);

		j = new JLabel ("Bienvenido");
		j.setBounds(50, 100, 150,80);
		j.setForeground(Color.white);
		j.setFont(new java.awt.Font ("Times New Roman",1 , 24)); /// CAMBIAR TIPO LETRA
		this.getContentPane().add(j);

		r1=new JRadioButton("Insertar");
		r1.setBounds(360,200,100,30);
		//r1.setBackground(java.awt.Color.gray);
		r1.setForeground(Color.red);
		r1.setFont(new java.awt.Font ("Times New Roman",1 , 16)); /// CAMBIAR TIPO LETRA
		this.getContentPane().add(r1);
		r1.addActionListener(this);

		r2=new JRadioButton("Eliminar");
		r2.setBounds(360,230,100,30);
		r2.setForeground(Color.red);
		//r2.setBackground(java.awt.Color.gray);
		r2.setFont(new java.awt.Font ("Times New Roman",1 , 16)); /// CAMBIAR TIPO LETRA
		this.getContentPane().add(r2);
		r2.addActionListener(this);

		grupo = new ButtonGroup();
		grupo.add(r1);
		grupo.add(r2);

		boton4 = new JButton("Continuar"); //crea el boton
		boton4.setBounds(280,300,110,40);
		boton4.setForeground(Color.black);
		//boton4.setBackground(java.awt.Color.blue);
		this.getContentPane().add(boton4); //agrega el boton a la ventana
		boton4.addActionListener(this);

		boton2 = new JButton("Cerrar sesion"); //crea el boton
		boton2.setBounds(420,300,130,40);
		boton2.setForeground(Color.black);
		//boton.setBackground(java.awt.Color.blue);
		this.getContentPane().add(boton2); //agrega el boton a la ventana
		boton2.addActionListener(this);

		z = new JLabel ("G.J.W.O.");
		z.setBounds(720, 448, 180,25);
		z.setForeground(Color.white); /// CAMBIAR COLOR DE LETRA
		z.setFont(new java.awt.Font ("Times New Roman",1 , 16)); /// CAMBIAR TIPO LETRA
		this.getContentPane().add(z);
	}

  	void insercion ()
	{
		insertw = new JLabel ("Seleccione Donde Desea Insertar");
		insertw.setBounds(145, 170, 600,60);
		insertw.setForeground(Color.white); /// CAMBIAR COLOR DE LETRA
		insertw.setFont(new java.awt.Font ("Times New Roman",1 , 24)); /// CAMBIAR TIPO LETRA
		this.getContentPane().add(insertw);
		insertw.setVisible(true);

    	tablaInser = new JComboBox(tablas);
		tablaInser.setBounds(300, 270, 150,25);
		tablaInser.setForeground(Color.red); /// CAMBIAR COLOR DE LETRA
		tablaInser.setFont(new java.awt.Font ("Times New Roman",1 , 16)); /// CAMBIAR TIPO LETRA
		this.getContentPane().add(tablaInser);
		tablaInser.addActionListener(this);

		regresar1 = new JButton("Regresar"); //crea el boton
		regresar1.setBounds(300,300,110,40);
		regresar1.setForeground(Color.black);
		//boton4.setBackground(java.awt.Color.blue);
		this.getContentPane().add(regresar1); //agrega el boton a la ventana
		regresar1.addActionListener(this);
	}

  	void eliminacion ()
	{
		insertw = new JLabel ("Seleccione Donde Desea eliminar");
		insertw.setBounds(145, 170, 600,60);
		insertw.setForeground(Color.white); 							/// CAMBIAR COLOR DE LETRA
		insertw.setFont(new java.awt.Font ("Times New Roman",1 , 24)); 	/// CAMBIAR TIPO LETRA
		this.getContentPane().add(insertw);
		insertw.setVisible(true);

    	tablaInser = new JComboBox(tablas);
		tablaInser.setBounds(300, 270, 150,25);
		tablaInser.setForeground(Color.red); 								/// CAMBIAR COLOR DE LETRA
		tablaInser.setFont(new java.awt.Font ("Times New Roman",1 , 16)); 	/// CAMBIAR TIPO LETRA
		this.getContentPane().add(tablaInser);
		tablaInser.addActionListener(this);

	    regresar1 = new JButton("Regresar"); 	// Crea el boton
	    regresar1.setBounds(300,300,110,40);
	    regresar1.setForeground(Color.black);
	    //boton4.setBackground(java.awt.Color.blue);
	    this.getContentPane().add(regresar1); 	// Agrega el boton a la ventana
	    regresar1.addActionListener(this);
	}

  	void maquinaria ()
	{
		regresar1.setVisible(false);

		insertw = new JLabel ("Ingrese todos los datos");
		insertw.setBounds(200, 110, 600,60);
		insertw.setForeground(Color.white); /// CAMBIAR COLOR DE LETRA
		insertw.setFont(new java.awt.Font ("Times New Roman",1 , 24)); /// CAMBIAR TIPO LETRA
		this.getContentPane().add(insertw);
		insertw.setVisible(true);

		insertx = new JLabel ("Serial");
		insertx.setBounds(50, 210, 100,25);
		insertx.setForeground(Color.white); /// CAMBIAR COLOR DE LETRA
		insertx.setFont(new java.awt.Font ("Times New Roman",1 , 16)); /// CAMBIAR TIPO LETRA
		this.getContentPane().add(insertx);
		inserta = new JTextField();
		inserta.setBounds(110, 210, 150,25);
		this.getContentPane().add(inserta);

		inserty = new JLabel ("Precio");
		inserty.setBounds(280, 210, 100,25);
		inserty.setForeground(Color.white); /// CAMBIAR COLOR DE LETRA
		inserty.setFont(new java.awt.Font ("Times New Roman",1 , 16)); /// CAMBIAR TIPO LETRA
		this.getContentPane().add(inserty);
		insertb = new JTextField();
		insertb.setBounds(340, 210, 150,25);
		this.getContentPane().add(insertb);

		insertz = new JLabel ("Pais");
		insertz.setBounds(520, 210, 100,25);
		insertz.setForeground(Color.white); /// CAMBIAR COLOR DE LETRA
		insertz.setFont(new java.awt.Font ("Times New Roman",1 , 16)); /// CAMBIAR TIPO LETRA
		this.getContentPane().add(insertz);
		insertc = new JTextField();
		insertc.setBounds(570, 210, 150,25);
		this.getContentPane().add(insertc);

		continuar = new JButton("Continuar"); //crea el boton
		continuar.setBounds(280,300,110,40);
		continuar.setForeground(Color.black);
		//boton4.setBackground(java.awt.Color.blue);
		this.getContentPane().add(continuar); //agrega el boton a la ventana
		continuar.addActionListener(this);

		regresar = new JButton("Regresar"); //crea el boton
		regresar.setBounds(430,300,110,40);
		regresar.setForeground(Color.black);
		//boton4.setBackground(java.awt.Color.blue);
		this.getContentPane().add(regresar); //agrega el boton a la ventana
		regresar.addActionListener(this);
	}

  	void producto ()
	{
		regresar1.setVisible(false);

		insertw = new JLabel ("Ingrese todos los datos");
		insertw.setBounds(220, 110, 600,60);
		insertw.setForeground(Color.white); /// CAMBIAR COLOR DE LETRA
		insertw.setFont(new java.awt.Font ("Times New Roman",1 , 24)); /// CAMBIAR TIPO LETRA
		this.getContentPane().add(insertw);
		insertw.setVisible(true);

		insertx = new JLabel ("Codigo");
		insertx.setBounds(45, 200, 100,25);
		insertx.setForeground(Color.white); /// CAMBIAR COLOR DE LETRA
		insertx.setFont(new java.awt.Font ("Times New Roman",1 , 16)); /// CAMBIAR TIPO LETRA
		this.getContentPane().add(insertx);
		inserta = new JTextField();
		inserta.setBounds(110, 200, 150,25);
		this.getContentPane().add(inserta);

		inserty = new JLabel ("Nombre");
		inserty.setBounds(275, 200, 100,25);
		inserty.setForeground(Color.white); /// CAMBIAR COLOR DE LETRA
		inserty.setFont(new java.awt.Font ("Times New Roman",1 , 16)); /// CAMBIAR TIPO LETRA
		this.getContentPane().add(inserty);
		insertb = new JTextField();
		insertb.setBounds(350, 200, 150,25);
		this.getContentPane().add(insertb);

		insertz = new JLabel ("Peso");
		insertz.setBounds(520, 200, 100,25);
		insertz.setForeground(Color.white); /// CAMBIAR COLOR DE LETRA
		insertz.setFont(new java.awt.Font ("Times New Roman",1 , 16)); /// CAMBIAR TIPO LETRA
		this.getContentPane().add(insertz);
		insertc = new JTextField();
		insertc.setBounds(570, 200, 150,25);
		this.getContentPane().add(insertc);

		insertu = new JLabel ("Precio");
		insertu.setBounds(185, 250, 100,25);
		insertu.setForeground(Color.white); /// CAMBIAR COLOR DE LETRA
		insertu.setFont(new java.awt.Font ("Times New Roman",1 , 16)); /// CAMBIAR TIPO LETRA
		this.getContentPane().add(insertu);
		insertd = new JTextField();
		insertd.setBounds(260, 250, 150,25);
		this.getContentPane().add(insertd);

		insertv = new JLabel ("Tipo");
		insertv.setBounds(435, 250, 100,25);
		insertv.setForeground(Color.white); /// CAMBIAR COLOR DE LETRA
		insertv.setFont(new java.awt.Font ("Times New Roman",1 , 16)); /// CAMBIAR TIPO LETRA
		this.getContentPane().add(insertv);
		inserte = new JTextField();
		inserte.setBounds(480, 250, 150,25);
		this.getContentPane().add(inserte);

		continuar = new JButton("Continuar"); //crea el boton
		continuar.setBounds(280,300,110,40);
		continuar.setForeground(Color.black);
		//boton4.setBackground(java.awt.Color.blue);
		this.getContentPane().add(continuar); //agrega el boton a la ventana
		continuar.addActionListener(this);

		regresar = new JButton("Regresar"); //crea el boton
		regresar.setBounds(430,300,110,40);
		regresar.setForeground(Color.black);
		//boton4.setBackground(java.awt.Color.blue);
		this.getContentPane().add(regresar); //agrega el boton a la ventana
		regresar.addActionListener(this);
	}

  	void empresa()
	{
		regresar1.setVisible(false);

		insertw = new JLabel ("Ingrese todos los datos");
		insertw.setBounds(250, 110, 600,60);
		insertw.setForeground(Color.white); /// CAMBIAR COLOR DE LETRA
		insertw.setFont(new java.awt.Font ("Times New Roman",1 , 24)); /// CAMBIAR TIPO LETRA
		this.getContentPane().add(insertw);
		insertw.setVisible(true);

		insertx = new JLabel ("RIF");
		insertx.setBounds(60, 200, 100,25);
		insertx.setForeground(Color.white); /// CAMBIAR COLOR DE LETRA
		insertx.setFont(new java.awt.Font ("Times New Roman",1 , 16)); /// CAMBIAR TIPO LETRA
		this.getContentPane().add(insertx);
		inserta = new JTextField();
		inserta.setBounds(110, 200, 150,25);
		this.getContentPane().add(inserta);

		inserty = new JLabel ("Tipo");
		inserty.setBounds(280, 200, 100,25);
		inserty.setForeground(Color.white); /// CAMBIAR COLOR DE LETRA
		inserty.setFont(new java.awt.Font ("Times New Roman",1 , 16)); /// CAMBIAR TIPO LETRA
		this.getContentPane().add(inserty);
		insertTipo = new JComboBox(tipos);
		insertTipo.setBounds(325, 200, 170,25);
		insertTipo.setForeground(Color.red); /// CAMBIAR COLOR DE LETRA
		insertTipo.setFont(new java.awt.Font ("Times New Roman",1 , 16)); /// CAMBIAR TIPO LETRA
		this.getContentPane().add(insertTipo);
		insertTipo.addActionListener(this);

		insertz = new JLabel ("Nombre");
		insertz.setBounds(510, 200, 100,25);
		insertz.setForeground(Color.white); /// CAMBIAR COLOR DE LETRA
		insertz.setFont(new java.awt.Font ("Times New Roman",1 , 16)); /// CAMBIAR TIPO LETRA
		this.getContentPane().add(insertz);
		insertc = new JTextField();
		insertc.setBounds(590, 200, 150,25);
		this.getContentPane().add(insertc);

		insertu = new JLabel ("Direccion");
		insertu.setBounds(50, 250, 100,25);
		insertu.setForeground(Color.white); /// CAMBIAR COLOR DE LETRA
		insertu.setFont(new java.awt.Font ("Times New Roman",1 , 16)); /// CAMBIAR TIPO LETRA
		this.getContentPane().add(insertu);
		insertd = new JTextField();
		insertd.setBounds(140, 250, 150,25);
		this.getContentPane().add(insertd);

		insertv = new JLabel ("Ciudad");
		insertv.setBounds(300, 250, 100,25);
		insertv.setForeground(Color.white); /// CAMBIAR COLOR DE LETRA
		insertv.setFont(new java.awt.Font ("Times New Roman",1 , 16)); /// CAMBIAR TIPO LETRA
		this.getContentPane().add(insertv);
		inserte = new JTextField();
		inserte.setBounds(370, 250, 150,25);
		this.getContentPane().add(inserte);

		insertt = new JLabel ("Estado");
		insertt.setBounds(540, 250, 100,25);
		insertt.setForeground(Color.white); /// CAMBIAR COLOR DE LETRA
		insertt.setFont(new java.awt.Font ("Times New Roman",1 , 16)); /// CAMBIAR TIPO LETRA
		this.getContentPane().add(insertt);
		insertf = new JTextField();
		insertf.setBounds(605, 250, 150,25);
		this.getContentPane().add(insertf);

		continuar = new JButton("Continuar"); //crea el boton
		continuar.setBounds(280,300,110,40);
		continuar.setForeground(Color.black);
		//boton4.setBackground(java.awt.Color.blue);
		this.getContentPane().add(continuar); //agrega el boton a la ventana
		continuar.addActionListener(this);

		regresar = new JButton("Regresar"); //crea el boton
		regresar.setBounds(430,300,110,40);
		regresar.setForeground(Color.black);
		//boton4.setBackground(java.awt.Color.blue);
		this.getContentPane().add(regresar); //agrega el boton a la ventana
		regresar.addActionListener(this);
	}

  	void cliente ()
	{
		regresar1.setVisible(false);

		insertw = new JLabel ("Ingrese todos los datos");
		insertw.setBounds(250, 110, 600,60);
		insertw.setForeground(Color.white); /// CAMBIAR COLOR DE LETRA
		insertw.setFont(new java.awt.Font ("Times New Roman",1 , 24)); /// CAMBIAR TIPO LETRA
		this.getContentPane().add(insertw);
		insertw.setVisible(true);

		insertx = new JLabel ("Cedula");
		insertx.setBounds(30, 210, 100,25);
		insertx.setForeground(Color.white); /// CAMBIAR COLOR DE LETRA
		insertx.setFont(new java.awt.Font ("Times New Roman",1 , 16)); /// CAMBIAR TIPO LETRA
		this.getContentPane().add(insertx);
		inserta = new JTextField();
		inserta.setBounds(95, 210, 150,25);
		this.getContentPane().add(inserta);

		inserty = new JLabel ("Nombre");
		inserty.setBounds(255, 210, 100,25);
		inserty.setForeground(Color.white); /// CAMBIAR COLOR DE LETRA
		inserty.setFont(new java.awt.Font ("Times New Roman",1 , 16)); /// CAMBIAR TIPO LETRA
		this.getContentPane().add(inserty);
		insertb = new JTextField();
		insertb.setBounds(330, 210, 150,25);
		this.getContentPane().add(insertb);

		insertz = new JLabel ("Fecha Ncto");
		insertz.setBounds(495, 210, 100,25);
		insertz.setForeground(Color.white); /// CAMBIAR COLOR DE LETRA
		insertz.setFont(new java.awt.Font ("Times New Roman",1 , 16)); /// CAMBIAR TIPO LETRA
		this.getContentPane().add(insertz);
		insertc = new JTextField();
		insertc.setBounds(600, 210, 150,25);
		this.getContentPane().add(insertc);

		continuar = new JButton("Continuar"); //crea el boton
		continuar.setBounds(280,300,110,40);
		continuar.setForeground(Color.black);
		//boton4.setBackground(java.awt.Color.blue);
		this.getContentPane().add(continuar); //agrega el boton a la ventana
		continuar.addActionListener(this);

		regresar = new JButton("Regresar"); //crea el boton
		regresar.setBounds(430,300,110,40);
		regresar.setForeground(Color.black);
		//boton4.setBackground(java.awt.Color.blue);
		this.getContentPane().add(regresar); //agrega el boton a la ventana
		regresar.addActionListener(this);
	}

  	void curso ()
	{
		regresar1.setVisible(false);

		insertw = new JLabel ("Ingrese todos los datos");
		insertw.setBounds(250, 110, 600,60);
		insertw.setForeground(Color.white); /// CAMBIAR COLOR DE LETRA
		insertw.setFont(new java.awt.Font ("Times New Roman",1 , 24)); /// CAMBIAR TIPO LETRA
		this.getContentPane().add(insertw);
		insertw.setVisible(true);

		insertx = new JLabel ("Codigo");
		insertx.setBounds(50, 200, 100,25);
		insertx.setForeground(Color.white); /// CAMBIAR COLOR DE LETRA
		insertx.setFont(new java.awt.Font ("Times New Roman",1 , 16)); /// CAMBIAR TIPO LETRA
		this.getContentPane().add(insertx);
		inserta = new JTextField();
		inserta.setBounds(115, 200, 150,25);
		this.getContentPane().add(inserta);

		inserty = new JLabel ("Nombre");
		inserty.setBounds(280, 200, 100,25);
		inserty.setForeground(Color.white); /// CAMBIAR COLOR DE LETRA
		inserty.setFont(new java.awt.Font ("Times New Roman",1 , 16)); /// CAMBIAR TIPO LETRA
		this.getContentPane().add(inserty);
		insertb = new JTextField();
		insertb.setBounds(355, 200, 150,25);
		this.getContentPane().add(insertb);

		insertz = new JLabel ("Horario");
		insertz.setBounds(510, 200, 100,25);
		insertz.setForeground(Color.white); /// CAMBIAR COLOR DE LETRA
		insertz.setFont(new java.awt.Font ("Times New Roman",1 , 16)); /// CAMBIAR TIPO LETRA
		this.getContentPane().add(insertz);
		insertc = new JTextField();
		insertc.setBounds(585, 200, 150,25);
		this.getContentPane().add(insertc);

		insertv = new JLabel ("Ci Maestro");
		insertv.setBounds(270, 250, 120,25);
		insertv.setForeground(Color.white); /// CAMBIAR COLOR DE LETRA
		insertv.setFont(new java.awt.Font ("Times New Roman",1 , 16)); /// CAMBIAR TIPO LETRA
		this.getContentPane().add(insertv);
		insertd = new JTextField();
		insertd.setBounds(370, 250, 150,25);
		this.getContentPane().add(insertd);

		continuar = new JButton("Continuar"); //crea el boton
		continuar.setBounds(280,320,110,40);
		continuar.setForeground(Color.black);
		//boton4.setBackground(java.awt.Color.blue);
		this.getContentPane().add(continuar); //agrega el boton a la ventana
		continuar.addActionListener(this);

		regresar = new JButton("Regresar"); //crea el boton
		regresar.setBounds(430,320,110,40);
		regresar.setForeground(Color.black);
		//boton4.setBackground(java.awt.Color.blue);
		this.getContentPane().add(regresar); //agrega el boton a la ventana
		regresar.addActionListener(this);
	}

  	void factura()
	{
		regresar1.setVisible(false);

		insertw = new JLabel ("Ingrese todos los datos");
		insertw.setBounds(250, 110, 600,60);
		insertw.setForeground(Color.white); /// CAMBIAR COLOR DE LETRA
		insertw.setFont(new java.awt.Font ("Times New Roman",1 , 24)); /// CAMBIAR TIPO LETRA
		this.getContentPane().add(insertw);
		insertw.setVisible(true);

		insertx = new JLabel ("RIF");
		insertx.setBounds(65, 200, 100,25);
		insertx.setForeground(Color.white); /// CAMBIAR COLOR DE LETRA
		insertx.setFont(new java.awt.Font ("Times New Roman",1 , 16)); /// CAMBIAR TIPO LETRA
		this.getContentPane().add(insertx);

		insertRif = new JComboBox(rifemp);
		insertRif.setBounds(110, 200, 150,25);
		insertRif.setForeground(Color.red); /// CAMBIAR COLOR DE LETRA
		insertRif.setFont(new java.awt.Font ("Times New Roman",1 , 16)); /// CAMBIAR TIPO LETRA
		this.getContentPane().add(insertRif);

		inserty = new JLabel ("Codigo");
		inserty.setBounds(280, 200, 100,25);
		inserty.setForeground(Color.white); /// CAMBIAR COLOR DE LETRA
		inserty.setFont(new java.awt.Font ("Times New Roman",1 , 16)); /// CAMBIAR TIPO LETRA
		this.getContentPane().add(inserty);
		insertb = new JTextField();
		insertb.setBounds(350, 200, 150,25);
		this.getContentPane().add(insertb);

		insertz = new JLabel ("Cedula");
		insertz.setBounds(510, 200, 100,25);
		insertz.setForeground(Color.white); /// CAMBIAR COLOR DE LETRA
		insertz.setFont(new java.awt.Font ("Times New Roman",1 , 16)); /// CAMBIAR TIPO LETRA
		this.getContentPane().add(insertz);
		insertc = new JTextField();
		insertc.setBounds(575, 200, 150,25);
		this.getContentPane().add(insertc);

		insertu = new JLabel ("Cantidad");
		insertu.setBounds(45, 250, 100,25);
		insertu.setForeground(Color.white); /// CAMBIAR COLOR DE LETRA
		insertu.setFont(new java.awt.Font ("Times New Roman",1 , 16)); /// CAMBIAR TIPO LETRA
		this.getContentPane().add(insertu);
		insertd = new JTextField();
		insertd.setBounds(130, 250, 150,25);
		this.getContentPane().add(insertd);

		insertv = new JLabel ("Fecha");
		insertv.setBounds(290, 250, 100,25);
		insertv.setForeground(Color.white); /// CAMBIAR COLOR DE LETRA
		insertv.setFont(new java.awt.Font ("Times New Roman",1 , 16)); /// CAMBIAR TIPO LETRA
		this.getContentPane().add(insertv);
		inserte = new JTextField();
		inserte.setBounds(350, 250, 150,25);
		this.getContentPane().add(inserte);

		insertt = new JLabel ("Costo");
		insertt.setBounds(520, 250, 100,25);
		insertt.setForeground(Color.white); /// CAMBIAR COLOR DE LETRA
		insertt.setFont(new java.awt.Font ("Times New Roman",1 , 16)); /// CAMBIAR TIPO LETRA
		this.getContentPane().add(insertt);
		insertf = new JTextField();
		insertf.setBounds(580, 250, 150,25);
		this.getContentPane().add(insertf);

		continuar = new JButton("Continuar"); //crea el boton
		continuar.setBounds(280,330,110,40);
		continuar.setForeground(Color.black);
		//boton4.setBackground(java.awt.Color.blue);
		this.getContentPane().add(continuar); //agrega el boton a la ventana
		continuar.addActionListener(this);

		regresar = new JButton("Regresar"); //crea el boton
		regresar.setBounds(430,330,110,40);
		regresar.setForeground(Color.black);
		//boton4.setBackground(java.awt.Color.blue);
		this.getContentPane().add(regresar); //agrega el boton a la ventana
		regresar.addActionListener(this);
	}

  void trabajador()
	{
		regresar1.setVisible(false);

		insertw = new JLabel ("Ingrese todos los datos");
		insertw.setBounds(250, 100, 600,60);
		insertw.setForeground(Color.white); /// CAMBIAR COLOR DE LETRA
		insertw.setFont(new java.awt.Font ("Times New Roman",1 , 24)); /// CAMBIAR TIPO LETRA
		this.getContentPane().add(insertw);
		insertw.setVisible(true);

		insertx = new JLabel ("Cedula");
		insertx.setBounds(40, 190, 100,25);
		insertx.setForeground(Color.white); /// CAMBIAR COLOR DE LETRA
		insertx.setFont(new java.awt.Font ("Times New Roman",1 , 16)); /// CAMBIAR TIPO LETRA
		this.getContentPane().add(insertx);
		inserta = new JTextField();
		inserta.setBounds(105, 190, 150,25);
		this.getContentPane().add(inserta);

		inserty = new JLabel ("Nombre");
		inserty.setBounds(270, 190, 100,25);
		inserty.setForeground(Color.white); /// CAMBIAR COLOR DE LETRA
		inserty.setFont(new java.awt.Font ("Times New Roman",1 , 16)); /// CAMBIAR TIPO LETRA
		this.getContentPane().add(inserty);
		insertb = new JTextField();
		insertb.setBounds(345, 190, 150,25);
		this.getContentPane().add(insertb);

		insertz = new JLabel ("Fecha Nac.");
		insertz.setBounds(500, 190, 100,25);
		insertz.setForeground(Color.white); /// CAMBIAR COLOR DE LETRA
		insertz.setFont(new java.awt.Font ("Times New Roman",1 , 16)); /// CAMBIAR TIPO LETRA
		this.getContentPane().add(insertz);
		insertc = new JTextField();
		insertc.setBounds(600, 190, 150,25);
		this.getContentPane().add(insertc);

		insertu = new JLabel ("Cargo");
		insertu.setBounds(50, 240, 100,25);
		insertu.setForeground(Color.white); /// CAMBIAR COLOR DE LETRA
		insertu.setFont(new java.awt.Font ("Times New Roman",1 , 16)); /// CAMBIAR TIPO LETRA
		this.getContentPane().add(insertu);
		insertd = new JTextField();
		insertd.setBounds(110, 240, 150,25);
		this.getContentPane().add(insertd);

		insertv = new JLabel ("Sueldo");
		insertv.setBounds(280, 240, 100,25);
		insertv.setForeground(Color.white); /// CAMBIAR COLOR DE LETRA
		insertv.setFont(new java.awt.Font ("Times New Roman",1 , 16)); /// CAMBIAR TIPO LETRA
		this.getContentPane().add(insertv);
		inserte = new JTextField();
		inserte.setBounds(345, 240, 150,25);
		this.getContentPane().add(inserte);

		insertt = new JLabel ("Fecha In.");
		insertt.setBounds(510, 240, 100,25);
		insertt.setForeground(Color.white); /// CAMBIAR COLOR DE LETRA
		insertt.setFont(new java.awt.Font ("Times New Roman",1 , 16)); /// CAMBIAR TIPO LETRA
		this.getContentPane().add(insertt);
		insertf = new JTextField();
		insertf.setBounds(590, 240, 150,25);
		this.getContentPane().add(insertf);

		insertr = new JLabel ("Fecha Fin");
		insertr.setBounds(150, 290, 100,25);
		insertr.setForeground(Color.white); /// CAMBIAR COLOR DE LETRA
		insertr.setFont(new java.awt.Font ("Times New Roman",1 , 16)); /// CAMBIAR TIPO LETRA
		this.getContentPane().add(insertr);
		insertg = new JTextField();
		insertg.setBounds(250, 290, 150,25);
		this.getContentPane().add(insertg);

		inserts = new JLabel ("RIF");
		inserts.setBounds(430, 290, 100,25);
		inserts.setForeground(Color.white); /// CAMBIAR COLOR DE LETRA
		inserts.setFont(new java.awt.Font ("Times New Roman",1 , 16)); /// CAMBIAR TIPO LETRA
		this.getContentPane().add(inserts);

		insertRif = new JComboBox(rifemp);
		insertRif.setBounds(470, 290, 150,25);
		insertRif.setForeground(Color.red); /// CAMBIAR COLOR DE LETRA
		insertRif.setFont(new java.awt.Font ("Times New Roman",1 , 16)); /// CAMBIAR TIPO LETRA
		this.getContentPane().add(insertRif);

		continuar = new JButton("Continuar"); //crea el boton
		continuar.setBounds(280,350,110,40);
		continuar.setForeground(Color.black);
		//boton4.setBackground(java.awt.Color.blue);
		this.getContentPane().add(continuar); //agrega el boton a la ventana
		continuar.addActionListener(this);

		regresar = new JButton("Regresar"); //crea el boton
		regresar.setBounds(430,350,110,40);
		regresar.setForeground(Color.black);
		//boton4.setBackground(java.awt.Color.blue);
		this.getContentPane().add(regresar); //agrega el boton a la ventana
		regresar.addActionListener(this);
	}


	void consultaEliminar(String sql)
	{
		System.out.println("S"+sql);
		JTable tabla = new JTable();
		DefaultTableModel modelo = new DefaultTableModel();
		//para mquinaria
		if (prueba == "MAQUINARIA")
		{
			String[] columnas = {"serial", "precio", "pais"};

			modelo.setColumnIdentifiers(columnas);
			tabla.setModel(modelo);

			ResultSet st = Conexion(sql);
			String serial, precio, pais;
	    try
			{
				while(st.next())
				{
						serial = st.getString("serial");
						precio = st.getString("precio");
						pais = st.getString("pais");
						modelo.addRow(new Object[]{serial, precio, pais});
				}
			}
			catch(Exception ex)
			{
				int ERROR_MESSAGE = 0;
				JOptionPane.showMessageDialog(null, ex, "ERROR", ERROR_MESSAGE);
			}
		}
		//para PRODUCTO
		if (prueba == "PRODUCTO")
		{
			String[] columnas = {"codigo", "nombre", "peso", "precio", "tipo"};

			modelo.setColumnIdentifiers(columnas);
			tabla.setModel(modelo);
			System.out.println("SQL"+sql);
			ResultSet st = Conexion(sql);
			System.out.println("hola");
			String codigo, nombre, peso, precio, tipo;
	    try
			{
				while(st.next())
				{
						codigo = st.getString("codigo");
						nombre = st.getString("nombre");
						peso = st.getString("peso");
						precio = st.getString("precio");
						tipo = st.getString("tipo");
						modelo.addRow(new Object[]{codigo, nombre, peso, precio, tipo});
				}
			}
			catch(Exception ex)
			{
				int ERROR_MESSAGE = 0;
				JOptionPane.showMessageDialog(null, ex, "ERROR", ERROR_MESSAGE);
			}
		}
		//para EMPRESA
		if (prueba == "EMPRESA")
		{
				String[] columnas = {"rif", "tipo", "nombre", "direccion", "ciudad", "estado"};
				modelo.setColumnIdentifiers(columnas);
				tabla.setModel(modelo);
				ResultSet st = Conexion(sql);
				String rif, tipo, nombre, direccion, ciudad, estado;
		    try
				{
						while(st.next())
						{
							rif = st.getString("rif");
							tipo = st.getString("tipo");
							nombre = st.getString("nombre");
							direccion = st.getString("direccion");
							ciudad = st.getString("ciudad");
							estado = st.getString("estado");
							modelo.addRow(new Object[]{rif, tipo, nombre, direccion, ciudad, estado});
						}
				}
				catch(Exception ex)
				{
					int ERROR_MESSAGE = 0;
					JOptionPane.showMessageDialog(null, ex, "ERROR", ERROR_MESSAGE);
				}
		}
		if (prueba == "CURSO")
		{
			String[] columnas = {"codigo", "nombre", "horario", "ci_maestro"};
			modelo.setColumnIdentifiers(columnas);
			tabla.setModel(modelo);
			ResultSet st = Conexion(sql);
			String codigo, nombre, horario, ci_maestro;
			try
			{
					while(st.next())
					{
						codigo = st.getString("codigo");
						nombre = st.getString("nombre");
						horario = st.getString("horario");
						ci_maestro = st.getString("ci_maestro");
						modelo.addRow(new Object[]{codigo, nombre, horario, ci_maestro});
					}
			}
			catch(Exception ex)
			{
				int ERROR_MESSAGE = 0;
				JOptionPane.showMessageDialog(null, ex, "ERROR", ERROR_MESSAGE);
			}
		}

		//para CLIENTE
		if (prueba == "CLIENTE")
		{
			String[] columnas = {"ci", "nombre", "fecha_nacimiento"};
			modelo.setColumnIdentifiers(columnas);
			tabla.setModel(modelo);
			ResultSet st = Conexion(sql);
			String ci, nombre, fecha_nacimiento;
			try
			{
					while(st.next())
					{
						ci = st.getString("ci");
						nombre = st.getString("nombre");
						fecha_nacimiento = st.getString("fecha_nacimiento");
						modelo.addRow(new Object[]{ci, nombre,fecha_nacimiento});
					}
			}
			catch(Exception ex)
			{
				int ERROR_MESSAGE = 0;
				JOptionPane.showMessageDialog(null, ex, "ERROR", ERROR_MESSAGE);
			}
		}
		if (prueba == "MAESTRO")
		{
			String[] columnas = {"ci", "nombre", "fecha_nacimiento", "cargo", "sueldo", "fecha_inicio", "fecha_fin", "rif"};
			modelo.setColumnIdentifiers(columnas);
			tabla.setModel(modelo);
			ResultSet st = Conexion(sql);
			String ci, nombre, fecha_nacimiento,cargo,sueldo,fecha_inicio,fecha_fin,rif;
			try
			{
					while(st.next())
					{
						ci = st.getString("ci");
						nombre = st.getString("nombre");
						fecha_nacimiento = st.getString("fecha_nacimiento");
						cargo = st.getString("cargo");
						sueldo = st.getString("sueldo");
						fecha_inicio = st.getString("fecha_inicio");
						fecha_fin = st.getString("fecha_fin");
						rif = st.getString("rif");
						modelo.addRow(new Object[]{ci, nombre,fecha_nacimiento,cargo,sueldo,fecha_inicio,fecha_fin,rif});
					}
			}
			catch(Exception ex)
			{
				int ERROR_MESSAGE = 0;
				JOptionPane.showMessageDialog(null, ex, "ERROR", ERROR_MESSAGE);
			}
		}

		if (prueba == "FACTURA")
		{
			String[] columnas = {"rif", "codigo", "ci", "cantidad", "fecha", "costo"};
			modelo.setColumnIdentifiers(columnas);
			tabla.setModel(modelo);
			ResultSet st = Conexion(sql);
			String rif, codigo, ci, cantidad, fecha, costo;
			try
			{
					while(st.next())
					{
						rif = st.getString("rif");
						codigo = st.getString("codigo");
						ci = st.getString("ci");
						cantidad = st.getString("cantidad");
					 	fecha = st.getString("fecha");
						costo = st.getString("costo");
						modelo.addRow(new Object[]{rif,codigo,ci,cantidad,fecha,costo});
					}
			}
			catch(Exception ex)
			{
				int ERROR_MESSAGE = 0;
				JOptionPane.showMessageDialog(null, ex, "ERROR", ERROR_MESSAGE);
			}
		}

		ventana = new JFrame("Tablas");
		ventana.setLayout(new FlowLayout());
		ventana.setSize(1500,500);
		ventana.setVisible(true);
		JScrollPane scroll = new JScrollPane(tabla);
		scroll.setPreferredSize(new Dimension(800,500));
		ventana.add(scroll);

		insertw = new JLabel ("Ingrese todos los datos");
		insertw.setBounds(250, 110, 600,60);
		insertw.setForeground(Color.white); /// CAMBIAR COLOR DE LETRA
		insertw.setFont(new java.awt.Font ("Times New Roman",1 , 24)); /// CAMBIAR TIPO LETRA
		ventana.getContentPane().add(insertw);
		insertw.setVisible(true);

		//botn para elminar en la ventana de las tablas
	 	eliminar= new JButton("Eliminar"); //crea el boton
		eliminar.setBounds(0,0,110,40);
		eliminar.setForeground(Color.black);
		//boton4.setBackground(java.awt.Color.blue);
		ventana.getContentPane().add(eliminar); //agrega el boton a la ventana
		eliminar.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
    String u = user.getText();
		String p = pas.getText();

		// elimina de una tabla
		if(e.getSource()==eliminar)
		{
			borrar(sql2);
			ventana.setVisible(false);
		}

		/// salida del programa
    if(e.getSource()==boton)
			System.exit(0);

	  //validacion de campos de inicio de sesion
    if(e.getSource()== boton3)
  	{
  		if (u.equals("") && p.equals(""))
  			JOptionPane.showMessageDialog(rootPane, "Ingrese el nombre de usuario y Contase\u00f1a");
  		else
  		{
  			if(u.equals("")||u == null)
  				JOptionPane.showMessageDialog(rootPane, "Ingrese el nombre del usuario");
  			else
  			{
  				if(p.equals("")||p == null)
  					JOptionPane.showMessageDialog(rootPane, "Ingrese la contrase\u00f1a");
  			}
  		}
  	}

		/// inicio como Administrador
    if (e.getSource() == boton3 && CmbUser_Type.getSelectedItem().equals("Administrador"))
  	{
  		if(user.getText().equals("a") && pas.getText().equals("a"))
  		{
  			homeAdministrador();
  			repaint();
  		}
  		else
  		{
  			if (!u.equals("") && !p.equals(""))
  				JOptionPane.showMessageDialog(null, "Datos Incorrectos, Verifique");
  		}
  	}

		/// inicio como trabajador
  	if (e.getSource() == boton3 && CmbUser_Type.getSelectedItem().equals("Trabajador"))
  	{
  		if(!u.equals("") && !p.equals(""))
  		{
  			homeTrabajador();
  			repaint();
  			}
		}

    /// cierre de sesion
    if(e.getSource() == boton2)
		{
      j.setVisible(false);
			boton2.setVisible(false);
			if(CmbUser_Type.getSelectedItem().equals("Administrador"))
			{
				r1.setVisible(false);
				r2.setVisible(false);
				boton4.setVisible(false);
			}
      if(CmbUser_Type.getSelectedItem().equals("Trabajador"))
			{

				consulta1.setVisible(false);
        consulta2.setVisible(false);
        consulta3.setVisible(false);
			}

			setTitle("Inicio"); //coloca el nombre a la ventana
			add(a);
			a.setVisible(true);
			add(x);
			x.setVisible(true);
			add(user);
			user.setText(null);
			user.setVisible(true);
			add(y);
			y.setVisible(true);
			add(pas);
			pas.setText(null);
			pas.setVisible(true);
			add(boton);
			boton.setVisible(true);
			add(boton3);
			boton3.setVisible(true);
			add(CmbUser_Type);
			CmbUser_Type.setVisible(true);
			repaint();
		}

    /// continuar en la insercion o eliminacion
    if (e.getSource()== boton4)
		{
      if(!r1.isSelected() && !r2.isSelected())
        JOptionPane.showMessageDialog(rootPane, "Debe seleccionar una opcion");
      else
      {
        if(r1.isSelected())
        {
          j.setVisible(false);
    			boton2.setVisible(false);
    			boton4.setVisible(false);
    			r1.setVisible(false);
    			r2.setVisible(false);
    			insercion();
    			repaint();
        }
        if(r2.isSelected())
        {
          j.setVisible(false);
    			boton2.setVisible(false);
    			boton4.setVisible(false);
    			r1.setVisible(false);
    			r2.setVisible(false);
    			eliminacion();
    			repaint();
        }
      }
		}

    /// regresar en insercion o eliminacion
    if (e.getSource() == regresar1)
    {
      tablaInser.setVisible(false);
      regresar1.setVisible(false);
      r1.setVisible(true);
      r2.setVisible(true);
      //grupo.setVisible(true);
      z.setVisible(true);
      z.setVisible(true);
      boton4.setVisible(true);
      boton2.setVisible(true);
      homeAdministrador();
      repaint();
    }

		/// regresar a seleccion de tabla a eliminar
		if (e.getSource() == regresar2)
    {
			String prueba = (String)tablaInser.getSelectedItem();
			if (prueba == "MAQUINARIA" || prueba == "PRODUCTO" || prueba == "EMPRESA" || prueba == "CURSO" || prueba == "CLIENTE" || prueba == "MAESTRO")
			{
				insertww.setVisible(false);
				insertx.setVisible(false);
				inserta.setVisible(false);
				bm.setVisible(false);
				regresar2.setVisible(false);

				insertw.setVisible(true);
				tablaInser.setVisible(true);
				regresar1.setVisible(true);
				repaint();
			}
			if (prueba == "FACTURA")
			{
				insertww.setVisible(false);
				bm.setVisible(false);
				regresar2.setVisible(false);
				insertx.setVisible(false);
				insertRif.setVisible(false);
				inserty.setVisible(false);
				insertb.setVisible(false);
				insertz.setVisible(false);
				insertc.setVisible(false);

				insertw.setVisible(true);
				tablaInser.setVisible(true);
				regresar1.setVisible(true);
				repaint();

			}

    }


    /// Seleccion de tabla a Insertar
    if (e.getSource()== tablaInser && r1.isSelected())
		{
			String prueba = (String)tablaInser.getSelectedItem();
			if (prueba == "MAQUINARIA")
			{
				insertw.setVisible(false);
				tablaInser.setVisible(false);
				maquinaria();
				repaint();
			}
			if (prueba == "PRODUCTO")
			{
				insertw.setVisible(false);
				tablaInser.setVisible(false);
				producto();
				repaint();
			}
			if (prueba == "EMPRESA")
			{
				insertw.setVisible(false);
				tablaInser.setVisible(false);
				empresa();
				repaint();
			}
			if (prueba == "CURSO")
			{
				insertw.setVisible(false);
				tablaInser.setVisible(false);
				curso();
				repaint();
			}
			if (prueba == "CLIENTE")
			{
				insertw.setVisible(false);
				insertw.setVisible(false);
				tablaInser.setVisible(false);
				cliente();
				repaint();
			}
			if (prueba == "FACTURA")
			{
				insertw.setVisible(false);
				tablaInser.setVisible(false);
				factura();
				repaint();
			}
			if (prueba == "TRABAJADOR")
			{
				//regresar1.setVisible(false);
				insertw.setVisible(false);
				tablaInser.setVisible(false);
				trabajador();
				repaint();
			}
		}

    /// seleccion de tabla a Eliminar
    if (e.getSource()== tablaInser && r2.isSelected())
		{
			prueba = (String)tablaInser.getSelectedItem();
			if (prueba == "MAQUINARIA")
			{
				regresar1.setVisible(false);
				insertw.setVisible(false);
				tablaInser.setVisible(false);
				insertww = new JLabel ("Ingrese todos los datos");
				insertww.setBounds(200, 110, 600,60);
				insertww.setForeground(Color.white); /// CAMBIAR COLOR DE LETRA
				insertww.setFont(new java.awt.Font ("Times New Roman",1 , 24)); /// CAMBIAR TIPO LETRA
				this.getContentPane().add(insertww);
				insertww.setVisible(true);

				insertx = new JLabel ("Serial");
				insertx.setBounds(50, 210, 100,25);
				insertx.setForeground(Color.white); /// CAMBIAR COLOR DE LETRA
				insertx.setFont(new java.awt.Font ("Times New Roman",1 , 16)); /// CAMBIAR TIPO LETRA
				this.getContentPane().add(insertx);
				inserta = new JTextField();
				inserta.setBounds(110, 210, 150,25);
				this.getContentPane().add(inserta);

				bm = new JButton("continuar"); //crea el boton
				bm.setBounds(430,350,110,40);
				bm.setForeground(Color.black);
				//boton4.setBackground(java.awt.Color.blue);
				this.getContentPane().add(bm); //agrega el boton a la ventana
				bm.addActionListener(this);

				regresar2 = new JButton("Regresar"); //crea el boton
				regresar2.setBounds(300,300,110,40);
				regresar2.setForeground(Color.black);
				//boton4.setBackground(java.awt.Color.blue);
				this.getContentPane().add(regresar2); //agrega el boton a la ventana
				regresar2.addActionListener(this);
				repaint();
			}
			if (prueba == "PRODUCTO")
			{
				regresar1.setVisible(false);
				insertw.setVisible(false);
				tablaInser.setVisible(false);
				insertww = new JLabel ("Ingrese todos los datos");
				insertww.setBounds(200, 110, 600,60);
				insertww.setForeground(Color.white); /// CAMBIAR COLOR DE LETRA
				insertww.setFont(new java.awt.Font ("Times New Roman",1 , 24)); /// CAMBIAR TIPO LETRA
				this.getContentPane().add(insertww);
				insertww.setVisible(true);

				insertx = new JLabel ("Codigo");
				insertx.setBounds(50, 210, 100,25);
				insertx.setForeground(Color.white); /// CAMBIAR COLOR DE LETRA
				insertx.setFont(new java.awt.Font ("Times New Roman",1 , 16)); /// CAMBIAR TIPO LETRA
				this.getContentPane().add(insertx);
				inserta = new JTextField();
				inserta.setBounds(110, 210, 150,25);
				this.getContentPane().add(inserta);

				bm = new JButton("continuar"); //crea el boton
				bm.setBounds(430,350,110,40);
				bm.setForeground(Color.black);
				//boton4.setBackground(java.awt.Color.blue);
				this.getContentPane().add(bm); //agrega el boton a la ventana
				bm.addActionListener(this);

				regresar2 = new JButton("Regresar"); //crea el boton
				regresar2.setBounds(300,300,110,40);
				regresar2.setForeground(Color.black);
				//boton4.setBackground(java.awt.Color.blue);
				this.getContentPane().add(regresar2); //agrega el boton a la ventana
				regresar2.addActionListener(this);
				repaint();
			}
			if (prueba == "EMPRESA")
			{
				regresar1.setVisible(false);
				insertw.setVisible(false);
				tablaInser.setVisible(false);
				insertww = new JLabel ("Ingrese todos los datos");
				insertww.setBounds(200, 110, 600,60);
				insertww.setForeground(Color.white); /// CAMBIAR COLOR DE LETRA
				insertww.setFont(new java.awt.Font ("Times New Roman",1 , 24)); /// CAMBIAR TIPO LETRA
				this.getContentPane().add(insertww);
				insertww.setVisible(true);

				insertx = new JLabel ("rif");
				insertx.setBounds(50, 210, 100,25);
				insertx.setForeground(Color.white); /// CAMBIAR COLOR DE LETRA
				insertx.setFont(new java.awt.Font ("Times New Roman",1 , 16)); /// CAMBIAR TIPO LETRA
				this.getContentPane().add(insertx);
				inserta = new JTextField();
				inserta.setBounds(110, 210, 150,25);
				this.getContentPane().add(inserta);

				bm = new JButton("continuar"); //crea el boton
				bm.setBounds(430,350,110,40);
				bm.setForeground(Color.black);
				//boton4.setBackground(java.awt.Color.blue);
				this.getContentPane().add(bm); //agrega el boton a la ventana
				bm.addActionListener(this);

				regresar2 = new JButton("Regresar"); //crea el boton
				regresar2.setBounds(300,300,110,40);
				regresar2.setForeground(Color.black);
				//boton4.setBackground(java.awt.Color.blue);
				this.getContentPane().add(regresar2); //agrega el boton a la ventana
				regresar2.addActionListener(this);
				repaint();
			}
			if (prueba == "CURSO")
			{
				regresar1.setVisible(false);
				insertw.setVisible(false);
				tablaInser.setVisible(false);
				insertww = new JLabel ("Ingrese todos los datos");
				insertww.setBounds(200, 110, 600,60);
				insertww.setForeground(Color.white); /// CAMBIAR COLOR DE LETRA
				insertww.setFont(new java.awt.Font ("Times New Roman",1 , 24)); /// CAMBIAR TIPO LETRA
				this.getContentPane().add(insertww);
				insertww.setVisible(true);

				insertx = new JLabel ("Codigo");
				insertx.setBounds(50, 210, 100,25);
				insertx.setForeground(Color.white); /// CAMBIAR COLOR DE LETRA
				insertx.setFont(new java.awt.Font ("Times New Roman",1 , 16)); /// CAMBIAR TIPO LETRA
				this.getContentPane().add(insertx);
				inserta = new JTextField();
				inserta.setBounds(110, 210, 150,25);
				this.getContentPane().add(inserta);

				bm = new JButton("continuar"); //crea el boton
				bm.setBounds(430,350,110,40);
				bm.setForeground(Color.black);
				//boton4.setBackground(java.awt.Color.blue);
				this.getContentPane().add(bm); //agrega el boton a la ventana
				bm.addActionListener(this);

				regresar2 = new JButton("Regresar"); //crea el boton
				regresar2.setBounds(300,300,110,40);
				regresar2.setForeground(Color.black);
				//boton4.setBackground(java.awt.Color.blue);
				this.getContentPane().add(regresar2); //agrega el boton a la ventana
				regresar2.addActionListener(this);
				repaint();
			}
			if (prueba == "CLIENTE")
			{
				regresar1.setVisible(false);
				insertw.setVisible(false);
				tablaInser.setVisible(false);
				insertww = new JLabel ("Ingrese todos los datos");
				insertww.setBounds(200, 110, 600,60);
				insertww.setForeground(Color.white); /// CAMBIAR COLOR DE LETRA
				insertww.setFont(new java.awt.Font ("Times New Roman",1 , 24)); /// CAMBIAR TIPO LETRA
				this.getContentPane().add(insertww);
				insertww.setVisible(true);

				insertx = new JLabel ("CI");
				insertx.setBounds(50, 210, 100,25);
				insertx.setForeground(Color.white); /// CAMBIAR COLOR DE LETRA
				insertx.setFont(new java.awt.Font ("Times New Roman",1 , 16)); /// CAMBIAR TIPO LETRA
				this.getContentPane().add(insertx);
				inserta = new JTextField();
				inserta.setBounds(110, 210, 150,25);
				this.getContentPane().add(inserta);

				bm = new JButton("continuar"); //crea el boton
				bm.setBounds(430,350,110,40);
				bm.setForeground(Color.black);
				//boton4.setBackground(java.awt.Color.blue);
				this.getContentPane().add(bm); //agrega el boton a la ventana
				bm.addActionListener(this);

				regresar2 = new JButton("Regresar"); //crea el boton
				regresar2.setBounds(300,300,110,40);
				regresar2.setForeground(Color.black);
				//boton4.setBackground(java.awt.Color.blue);
				this.getContentPane().add(regresar2); //agrega el boton a la ventana
				regresar2.addActionListener(this);
				repaint();
			}
			if (prueba == "FACTURA")
			{
				regresar1.setVisible(false);
				insertw.setVisible(false);
				tablaInser.setVisible(false);

				insertww = new JLabel ("Ingrese todos los datos");
				insertww.setBounds(250, 110, 600,60);
				insertww.setForeground(Color.white); /// CAMBIAR COLOR DE LETRA
				insertww.setFont(new java.awt.Font ("Times New Roman",1 , 24)); /// CAMBIAR TIPO LETRA
				this.getContentPane().add(insertww);
				insertww.setVisible(true);

				insertx = new JLabel ("RIF");
				insertx.setBounds(65, 200, 100,25);
				insertx.setForeground(Color.white); /// CAMBIAR COLOR DE LETRA
				insertx.setFont(new java.awt.Font ("Times New Roman",1 , 16)); /// CAMBIAR TIPO LETRA
				this.getContentPane().add(insertx);

				insertRif = new JComboBox(rifemp);
				insertRif.setBounds(110, 200, 150,25);
				insertRif.setForeground(Color.red); /// CAMBIAR COLOR DE LETRA
				insertRif.setFont(new java.awt.Font ("Times New Roman",1 , 16)); /// CAMBIAR TIPO LETRA
				this.getContentPane().add(insertRif);

				inserty = new JLabel ("Codigo");
				inserty.setBounds(280, 200, 100,25);
				inserty.setForeground(Color.white); /// CAMBIAR COLOR DE LETRA
				inserty.setFont(new java.awt.Font ("Times New Roman",1 , 16)); /// CAMBIAR TIPO LETRA
				this.getContentPane().add(inserty);
				insertb = new JTextField();
				insertb.setBounds(350, 200, 150,25);
				this.getContentPane().add(insertb);

				insertz = new JLabel ("Cedula");
				insertz.setBounds(510, 200, 100,25);
				insertz.setForeground(Color.white); /// CAMBIAR COLOR DE LETRA
				insertz.setFont(new java.awt.Font ("Times New Roman",1 , 16)); /// CAMBIAR TIPO LETRA
				this.getContentPane().add(insertz);
				insertc = new JTextField();
				insertc.setBounds(575, 200, 150,25);
				this.getContentPane().add(insertc);

				bm = new JButton("continuar"); //crea el boton
				bm.setBounds(430,350,110,40);
				bm.setForeground(Color.black);
				//boton4.setBackground(java.awt.Color.blue);
				this.getContentPane().add(bm); //agrega el boton a la ventana
				bm.addActionListener(this);

				regresar2 = new JButton("Regresar"); //crea el boton
				regresar2.setBounds(300,300,110,40);
				regresar2.setForeground(Color.black);
				//boton4.setBackground(java.awt.Color.blue);
				this.getContentPane().add(regresar2); //agrega el boton a la ventana
				regresar2.addActionListener(this);
				repaint();
			}
			if (prueba == "MAESTRO")
			{
				regresar1.setVisible(false);
				insertw.setVisible(false);
				tablaInser.setVisible(false);
				insertww = new JLabel ("Ingrese todos los datos");
				insertww.setBounds(200, 110, 600,60);
				insertww.setForeground(Color.white); /// CAMBIAR COLOR DE LETRA
				insertww.setFont(new java.awt.Font ("Times New Roman",1 , 24)); /// CAMBIAR TIPO LETRA
				this.getContentPane().add(insertww);
				insertww.setVisible(true);

				insertx = new JLabel ("CI");
				insertx.setBounds(50, 210, 100,25);
				insertx.setForeground(Color.white); /// CAMBIAR COLOR DE LETRA
				insertx.setFont(new java.awt.Font ("Times New Roman",1 , 16)); /// CAMBIAR TIPO LETRA
				this.getContentPane().add(insertx);
				inserta = new JTextField();
				inserta.setBounds(110, 210, 150,25);
				this.getContentPane().add(inserta);

				bm = new JButton("continuar"); //crea el boton
				bm.setBounds(430,350,110,40);
				bm.setForeground(Color.black);
				//boton4.setBackground(java.awt.Color.blue);
				this.getContentPane().add(bm); //agrega el boton a la ventana
				bm.addActionListener(this);

				regresar2 = new JButton("Regresar"); //crea el boton
				regresar2.setBounds(300,300,110,40);
				regresar2.setForeground(Color.black);
				//boton4.setBackground(java.awt.Color.blue);
				this.getContentPane().add(regresar2); //agrega el boton a la ventana
				regresar2.addActionListener(this);
				repaint();
			}
		}

		/// muestra de insercion de valores para eliminar tablas
		if (e.getSource() == bm)
		{
			if (prueba == "MAQUINARIA")
			{
				String a = inserta.getText();
				sql="SELECT * FROM p."+prueba+" WHERE serial ='"+a+"'";
				sql2 = "DELETE FROM p."+prueba+" WHERE serial ='"+a+"'";
				System.out.println(sql);
				consultaEliminar(sql);
			}
			if (prueba == "PRODUCTO")
			{
				String b = inserta.getText();
				System.out.println(b);
				sql ="SELECT * FROM p."+prueba+" WHERE codigo = '"+b+"'";
				sql2 = "DELETE FROM p."+prueba+" WHERE codigo = '"+b+"'";
				consultaEliminar(sql);
			}
			if (prueba == "EMPRESA")
			{
				String a = inserta.getText();
				sql="SELECT * FROM p."+prueba+" WHERE rif = '"+a+"'";
				sql2 = "DELETE FROM p."+prueba+" WHERE rif = '"+a+"'";
				System.out.println(sql);
				consultaEliminar(sql);
			}
			if (prueba == "CURSO")
			{
				String a = inserta.getText();
				sql="SELECT * FROM p."+prueba+" WHERE codigo = '"+a+"'";
				sql2 = "DELETE FROM p."+prueba+" WHERE codigo = '"+a+"'";
				System.out.println(sql);
				consultaEliminar(sql);
			}
			if (prueba == "CLIENTE")
			{
				String a = inserta.getText();
				sql="SELECT * FROM p.persona WHERE ci = '"+a+"'";
				sql2 = "DELETE FROM p.persona WHERE ci = '"+a+"'";
				System.out.println(sql);
				consultaEliminar(sql);
			}
			if (prueba == "MAESTRO")
			{
				String a = inserta.getText();
				sql="SELECT * FROM p.trabajador WHERE ci = '"+a+"'";
				sql2 = "DELETE FROM p.trabajador WHERE ci = '"+a+"'";
				System.out.println(sql);
				consultaEliminar(sql);
			}
			if (prueba == "FACTURA")
			{
				String a = (String)insertRif.getSelectedItem();
				String b = insertb.getText();
				String c = insertc.getText();

				sql="SELECT * FROM p.vende WHERE rif = '"+a+"'" + "and codigo = '"+b+"'"+ "and ci = '"+c+"'";
				sql2 = "DELETE FROM p.vende WHERE rif = '"+a+"'" + "and codigo = '"+b+"'"+ "and ci = '"+c+"'";
				consultaEliminar(sql);
			}
		}

	  /// regresar a seleccion de tabla
    if (e.getSource() == regresar)
		{
			String prueba = (String)tablaInser.getSelectedItem();
			if (prueba == "MAQUINARIA")
			{
				insertw.setVisible(false);
				regresar.setVisible(false);
				continuar.setVisible(false);
				insertx.setVisible(false);
				inserta.setVisible(false);
				inserty.setVisible(false);
				insertb.setVisible(false);
				insertc.setVisible(false);
				insertz.setVisible(false);
				insercion();
				repaint();
			}
			if (prueba == "PRODUCTO")
			{
				insertw.setVisible(false);
				regresar.setVisible(false);
				continuar.setVisible(false);
				insertx.setVisible(false);
				inserta.setVisible(false);
				insertb.setVisible(false);
				inserty.setVisible(false);
				insertc.setVisible(false);
				insertz.setVisible(false);
				insertu.setVisible(false);
				insertd.setVisible(false);
				insertv.setVisible(false);
				inserte.setVisible(false);
				insercion();
				repaint();
			}
			if (prueba == "EMPRESA")
			{
				insertw.setVisible(false);
				regresar.setVisible(false);
				continuar.setVisible(false);
				insertx.setVisible(false);
				inserta.setVisible(false);
				insertTipo.setVisible(false);
				inserty.setVisible(false);
				insertc.setVisible(false);
				insertz.setVisible(false);
				insertu.setVisible(false);
				insertd.setVisible(false);
				insertv.setVisible(false);
				inserte.setVisible(false);
				insertt.setVisible(false);
				insertf.setVisible(false);
				insercion();
				repaint();
			}
			if (prueba == "CURSO")
			{
				insertw.setVisible(false);
				regresar.setVisible(false);
				continuar.setVisible(false);
				insertx.setVisible(false);
				inserta.setVisible(false);
				insertb.setVisible(false);
				inserty.setVisible(false);
				insertc.setVisible(false);
				insertz.setVisible(false);
				insertd.setVisible(false);
				insertv.setVisible(false);
				insercion();
				repaint();
			}
			if (prueba == "CLIENTE")
			{
				insertw.setVisible(false);
				regresar.setVisible(false);
				continuar.setVisible(false);
				insertx.setVisible(false);
				inserta.setVisible(false);
				inserty.setVisible(false);
				insertb.setVisible(false);
				insertc.setVisible(false);
				insertz.setVisible(false);
				insercion();
				repaint();
			}
			if (prueba == "FACTURA")
			{
				insertw.setVisible(false);
				regresar.setVisible(false);
				continuar.setVisible(false);
				insertx.setVisible(false);
				insertRif.setVisible(false);
				inserty.setVisible(false);
				insertb.setVisible(false);
				insertc.setVisible(false);
				insertz.setVisible(false);
				insertu.setVisible(false);
				insertd.setVisible(false);
				insertv.setVisible(false);
				inserte.setVisible(false);
				insertt.setVisible(false);
				insertf.setVisible(false);
				insercion();
				repaint();
			}
			if (prueba == "TRABAJADOR")
			{
				insertw.setVisible(false);
				regresar.setVisible(false);
				continuar.setVisible(false);
				insertx.setVisible(false);
				inserta.setVisible(false);
				inserty.setVisible(false);
				insertb.setVisible(false);
				insertc.setVisible(false);
				insertz.setVisible(false);
				insertu.setVisible(false);
				insertd.setVisible(false);
				insertv.setVisible(false);
				inserte.setVisible(false);
				insertt.setVisible(false);
				insertf.setVisible(false);
				insertr.setVisible(false);
				inserts.setVisible(false);
				insertg.setVisible(false);
				insertRif.setVisible(false);
				insercion();
				repaint();
			}
		}

    /// continuar con el llenado de tablas
    if (e.getSource() == continuar)
		{
			String prueba = (String)tablaInser.getSelectedItem();

			if (prueba == "MAQUINARIA")
			{
				if ((inserta.getText().length() > 0) && (insertb.getText().length() > 0) && (insertc.getText().length() > 0))
				{
					String a = inserta.getText();
					String b = insertb.getText();
					String c = insertc.getText();
					JOptionPane.showMessageDialog(rootPane, "Los datos a ingresar son:");
					JOptionPane.showMessageDialog(rootPane, inserta.getText());
					JOptionPane.showMessageDialog(rootPane, insertb.getText());
					JOptionPane.showMessageDialog(rootPane, insertc.getText());
					sql = "INSERT INTO p."+prueba+" VALUES ("+a+","+b+",'"+c+"')";
					System.out.println("sql a insertar: "+sql);
					guardar(sql);
				}
				else
				{
					if(inserta.getText().length() == 0)
						JOptionPane.showMessageDialog(rootPane, "Por Favor, llenar el campo Serial");

					if (insertb.getText().length() == 0)
						JOptionPane.showMessageDialog(rootPane, "PorFavor, llenar el campo Precio");

					if (insertc.getText().length() == 0)
						JOptionPane.showMessageDialog(rootPane, "Por Favor, llenar el campo Pais");
				}
			}
			if (prueba == "PRODUCTO")
			{
				if ((inserta.getText().length() > 0) && (insertb.getText().length() > 0) && (insertc.getText().length() > 0) && (insertd.getText().length() > 0) && (inserte.getText().length() > 0))
				{
					String a = inserta.getText();
					String b = insertb.getText();
					String c = insertc.getText();
					String d = insertd.getText();
					String f = inserte.getText();

					JOptionPane.showMessageDialog(rootPane, "Los datos a ingresar son:");
					JOptionPane.showMessageDialog(rootPane, inserta.getText());
					JOptionPane.showMessageDialog(rootPane, insertb.getText());
					JOptionPane.showMessageDialog(rootPane, insertc.getText());
					JOptionPane.showMessageDialog(rootPane, insertd.getText());
					JOptionPane.showMessageDialog(rootPane, inserte.getText());
					sql = "INSERT INTO p."+prueba+" VALUES ('"+a+"','"+b+"',"+c+","+d+",'"+f+"')";
					System.out.println("sql a insertar: "+sql);
					guardar(sql);
				}
				else
				{
					if(inserta.getText().length() == 0)
						 JOptionPane.showMessageDialog(rootPane, "Por Favor, llenar el campo Codigo");

					if (insertb.getText().length() == 0)
						JOptionPane.showMessageDialog(rootPane, "Por Favor, llenar el campo Nombre");

					if (insertc.getText().length() == 0)
						JOptionPane.showMessageDialog(rootPane, "Por Favor, llenar el campo Peso");

					if (insertd.getText().length() == 0)
						JOptionPane.showMessageDialog(rootPane, "Por Favor, llenar el campo Precio");

					if (inserte.getText().length() == 0)
						JOptionPane.showMessageDialog(rootPane, "Por Favor, llenar el campo Tipo");
				}
			}

			if (prueba == "EMPRESA")
			{
				if ((inserta.getText().length() > 0) && (insertc.getText().length() > 0) && (insertd.getText().length() > 0) && (inserte.getText().length() > 0) && (insertf.getText().length() > 0))
				{
					JOptionPane.showMessageDialog(rootPane, "Los datos a ingresar son:");
					JOptionPane.showMessageDialog(rootPane, inserta.getText());
					JOptionPane.showMessageDialog(rootPane, insertTipo.getSelectedItem());
					JOptionPane.showMessageDialog(rootPane, insertc.getText());
					JOptionPane.showMessageDialog(rootPane, insertd.getText());
					JOptionPane.showMessageDialog(rootPane, inserte.getText());
					JOptionPane.showMessageDialog(rootPane, insertf.getText());
				}
				else
				{
					if(inserta.getText().length() == 0)
						JOptionPane.showMessageDialog(rootPane, "Por Favor, llenar el campo RIF");

					if (insertc.getText().length() == 0)
						JOptionPane.showMessageDialog(rootPane, "Por Favor, llenar el campo Nombre");

					if (insertd.getText().length() == 0)
						JOptionPane.showMessageDialog(rootPane, "Por Favor, llenar el campo Direccion");

					if (inserte.getText().length() == 0)
						JOptionPane.showMessageDialog(rootPane, "Por Favor, llenar el campo Ciudad");

					if (insertf.getText().length() == 0)
						JOptionPane.showMessageDialog(rootPane, "Por Favor, llenar el campo Estado");
				}
			}

			if (prueba == "CURSO")
			{
				if ((inserta.getText().length() > 0) && (insertb.getText().length() > 0) && (insertc.getText().length() > 0) && (insertd.getText().length() > 0) )
				{
					JOptionPane.showMessageDialog(rootPane, "Los datos a ingresar son:");
					JOptionPane.showMessageDialog(rootPane, inserta.getText());
					JOptionPane.showMessageDialog(rootPane, insertb.getText());
					JOptionPane.showMessageDialog(rootPane, insertc.getText());
					JOptionPane.showMessageDialog(rootPane, insertd.getText());
				}
				else
				{
					if(inserta.getText().length() == 0)
						JOptionPane.showMessageDialog(rootPane, "Por Favor, llenar el campo Codigo");

					if (insertb.getText().length() == 0)
						JOptionPane.showMessageDialog(rootPane, "Por Favor, llenar el campo Nombre");

					if (insertc.getText().length() == 0)
						JOptionPane.showMessageDialog(rootPane, "Por Favor, llenar el campo Horario");

					if (insertd.getText().length() == 0)
						JOptionPane.showMessageDialog(rootPane, "Por Favor, llenar el campo ci Maestro");
				}
			}
			if (prueba == "CLIENTE")
			{
				if ((inserta.getText().length() > 0) && (insertb.getText().length() > 0) && (insertc.getText().length() > 0))
				{
					JOptionPane.showMessageDialog(rootPane, "Los datos a ingresar son:");
					JOptionPane.showMessageDialog(rootPane, inserta.getText());
					JOptionPane.showMessageDialog(rootPane, insertb.getText());
					JOptionPane.showMessageDialog(rootPane, insertc.getText());
				}
				else
				{
					if(inserta.getText().length() == 0)
					{
					 JOptionPane.showMessageDialog(rootPane, "Por Favor, llenar el campo Cedula");
					}
					if (insertb.getText().length() == 0)
					{
					 JOptionPane.showMessageDialog(rootPane, "Por Favor, llenar el campo Nombre");
					}
					if (insertc.getText().length() == 0)
					{
					 JOptionPane.showMessageDialog(rootPane, "Por Favor, llenar el campo Fecha Nac.");
					}
				}

			}
			if (prueba == "FACTURA")
			{
				if ((insertb.getText().length() > 0) && (insertc.getText().length() > 0) && (insertd.getText().length() > 0) && (inserte.getText().length() > 0) && (insertf.getText().length() > 0))
				{
					JOptionPane.showMessageDialog(rootPane, "Los datos a ingresar son:");
					JOptionPane.showMessageDialog(rootPane, insertRif.getSelectedItem());
					JOptionPane.showMessageDialog(rootPane, insertb.getText());
					JOptionPane.showMessageDialog(rootPane, insertc.getText());
					JOptionPane.showMessageDialog(rootPane, insertd.getText());
					JOptionPane.showMessageDialog(rootPane, inserte.getText());
					JOptionPane.showMessageDialog(rootPane, insertf.getText());
				}
				else
				{
					if(insertb.getText().length() == 0)
						JOptionPane.showMessageDialog(rootPane, "Por Favor, llenar el campo Codigo");

					if (insertc.getText().length() == 0)
						JOptionPane.showMessageDialog(rootPane, "Por Favor, llenar el campo Cedula");

					if (insertd.getText().length() == 0)
						JOptionPane.showMessageDialog(rootPane, "Por Favor, llenar el campo Cantidad");

					if (inserte.getText().length() == 0)
						JOptionPane.showMessageDialog(rootPane, "Por Favor, llenar el campo Fecha");

					if (insertf.getText().length() == 0)
						JOptionPane.showMessageDialog(rootPane, "Por Favor, llenar el campo Costo");
				}
			}
			if (prueba == "TRABAJADOR")
			{
				if ((inserta.getText().length() > 0) && (insertb.getText().length() > 0) && (insertc.getText().length() > 0) && (insertd.getText().length() > 0) && (inserte.getText().length() > 0) && (insertf.getText().length() > 0) && (insertg.getText().length() > 0))
				{
					JOptionPane.showMessageDialog(rootPane, "Los datos a ingresar son:");
					JOptionPane.showMessageDialog(rootPane, inserta.getText());
					JOptionPane.showMessageDialog(rootPane, insertb.getText());
					JOptionPane.showMessageDialog(rootPane, insertc.getText());
					JOptionPane.showMessageDialog(rootPane, insertd.getText());
					JOptionPane.showMessageDialog(rootPane, inserte.getText());
					JOptionPane.showMessageDialog(rootPane, insertf.getText());
					JOptionPane.showMessageDialog(rootPane, insertg.getText());
					JOptionPane.showMessageDialog(rootPane, insertRif.getSelectedItem());
				}
				else
				{
					if(inserta.getText().length() == 0)
						JOptionPane.showMessageDialog(rootPane, "Por Favor, llenar el campo Cedula");

					if(insertb.getText().length() == 0)
						JOptionPane.showMessageDialog(rootPane, "Por Favor, llenar el campo Nombre");

					if (insertc.getText().length() == 0)
						JOptionPane.showMessageDialog(rootPane, "Por Favor, llenar el campo Fecha Nac.");

					if (insertd.getText().length() == 0)
						JOptionPane.showMessageDialog(rootPane, "Por Favor, llenar el campo Cargo");

					if (inserte.getText().length() == 0)
						JOptionPane.showMessageDialog(rootPane, "Por Favor, llenar el campo Sueldo");

					if (insertf.getText().length() == 0)
						JOptionPane.showMessageDialog(rootPane, "Por Favor, llenar el campo Fecha In.");

					if(insertg.getText().length() == 0)
						JOptionPane.showMessageDialog(rootPane, "Por Favor, llenar el campo Fecha Fin");
				}
			}
		}


    /// consulta 1
		if (e.getSource() == consulta1)
		{
			String sql="SELECT * FROM p.persona";
			ResultSet result = Conexion(sql);
			try
			{
				Jtable1 tabla = new Jtable1();
				String campos[] = {"ci", "nombre", "fecha de nacimiento"};
				String  datos[][] = new String[3][3];
				int i = 0;
				while(result.next())
				{
					datos[i][0] = result.getString("ci");
					datos[i][1] = result.getString("nombre");
					datos[i][2] = result.getString("fecha_nacimiento");
					//System.out.print(datos[i][0]);
					//System.out.print(datos[i][1]);
					//System.out.print(datos[i][2]);
					i++;
				}
				tabla.set_Table(datos,campos);
				}catch(Exception tet){

			}
		}

    //consulta 2
		if (e.getSource() == consulta2)
		{

		}

    //consulta 3
    if (e.getSource() == consulta3)
    {

    }


  }
}
