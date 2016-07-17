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

public class home extends JFrame implements ActionListener
{
	public JButton boton, boton2, boton3, boton4, continuar, regresar, regresar1, consulta;
	public JPanel panel;
	public JTextField user;
	public JPasswordField pas;
	public JLabel x, y, a, j, t, e, i, z;
	public JComboBox CmbUser_Type, tablaInser, options;
	public Container contenedor, contenedor2, contenedor3;
	private JRadioButton r1,r2;
	private ButtonGroup grupo;
	public JTextField inserta,insertb,insertc,insertd,inserte,insertf, insertg, inserth;
	public JLabel insertx, inserty, insertz, insertw, insertu, insertv, insertt, insertr, inserts;
	public JComboBox insertTipo, insertRif;


	//Listas de opciones desplegables
	String[] usertype = {"Administrador", "Trabajador"};
	String[] opciones = {"Insertar", "Eliminar"};
	String[] tablas = {"SELECCIONE LA TABLA","PRODUCTO", "EMPRESA", "MAQUINARIA", "CLIENTE", "CURSO", "MAESTRO", "FACTURA"};
	String[] tipos = {"CHOCOLATERA", "TIENDA", "PROCESADORA"};
	String[] rifemp = {"01", "02", "03"};


	public static void main(String args[])
	{
		home ventana = new home();
		ventana.setVisible(true);
	}

	public home()
	{
		inicio();
	}

	void ventana ()
	{
		this.setBounds(100,100,800,500); //tamaño de la ventana(eje x, eje y, ancho, largo)
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		//setOpacity(0.9f); //poner transparente la ventana
	}

	ResultSet Conexion(String sql)
	{
		ResultSet x = null;
		Connection conexion;
		ConexionBD con;
		con = new ConexionBD();

		try{
			conexion=con.obtConexion("proyecto_bd","choco","1234");
			Statement st;
			st = conexion.createStatement();
			ResultSet rs;
			rs = st.executeQuery(sql);
			x = rs;

		} catch (SQLException e) {

			JOptionPane.showMessageDialog (null, "Error: "+e.getMessage(), "Error Conexion", JOptionPane.ERROR_MESSAGE);
		}
		return x;
	}

	void inicio ()
	{
		String sql="select usename from pg_user where usesuper='f' and userepl='f' and usecreatedb='f'";
		ResultSet resultado;
		resultado = Conexion(sql);
		ventana();
		contenedor = new Container();
		setContentPane(contenedor);
		try
		{
			this.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("6.jpg")))));
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}

		setTitle("--.Inicio.--"); ///coloca el nombre a la ventana
		a= new JLabel ("Ingrese Sus Datos de Acceso");
		a.setBounds(210, 90, 400,60);
		a.setForeground(Color.white); /// CAMBIAR COLOR DE LETRA
		a.setFont(new java.awt.Font ("Times New Roman",1 , 24)); /// CAMBIAR TIPO LETRA
		this.getContentPane().add(a);

		t = new JLabel ("Tipo de usuario ");
		t.setBounds(222, 170, 150,25);
		t.setForeground(Color.white); /// CAMBIAR COLOR DE LETRA
		t.setFont(new java.awt.Font ("Times New Roman",1 , 16)); /// CAMBIAR TIPO LETRA
		this.getContentPane().add(t);

		CmbUser_Type = new JComboBox(usertype);
		CmbUser_Type.setBounds(360, 170, 150,25);
		CmbUser_Type.setForeground(Color.red); /// CAMBIAR COLOR DE LETRA
		CmbUser_Type.setFont(new java.awt.Font ("Times New Roman",1 , 16)); /// CAMBIAR TIPO LETRA
		this.getContentPane().add(CmbUser_Type);

		x = new JLabel ("Nombre de usuario");
		x.setBounds(190, 200, 180,25);
		x.setForeground(Color.white); /// CAMBIAR COLOR DE LETRA
		x.setFont(new java.awt.Font ("Times New Roman",1 , 16)); /// CAMBIAR TIPO LETRA
		this.getContentPane().add(x);

		user = new JTextField();
		user.setBounds(360, 200, 150,25);
		this.getContentPane().add(user);

		y = new JLabel ("Contrase\u00f1a "); 							//\u00f1 para la 'ñ'
		y.setBounds(256, 230, 140,25);
		y.setForeground(Color.white); /// CAMBIAR COLOR DE LETRA
		y.setFont(new java.awt.Font ("Times New Roman",1 , 16)); /// CAMBIAR TIPO LETRA
		this.getContentPane().add(y);

		pas = new JPasswordField();
		pas.setBounds(360, 230, 150,25);
		this.getContentPane().add(pas);

		boton3 = new JButton("Iniciar"); 								//crea el boton
		boton3.setBounds(300,270,110,40);
		boton3.setForeground(Color.black);
		//boton3.setBackground(java.awt.Color.red);
		this.getContentPane().add(boton3); 								//agrega el boton a la ventana
		boton3.addActionListener(this);

		boton = new JButton("Salir"); 									//crea el boton
		boton.setBounds(420,270,110,40);
		boton.setForeground(Color.black);
		//boton.setBackground(java.awt.Color.red);
		this.getContentPane().add(boton); 								//agrega el boton a la ventana
		boton.addActionListener(this);

		z = new JLabel ("G.J.W.O.");
		z.setBounds(720, 448, 180,25);
		z.setForeground(Color.white); /// CAMBIAR COLOR DE LETRA
		z.setFont(new java.awt.Font ("Times New Roman",1 , 16)); /// CAMBIAR TIPO LETRA
		this.getContentPane().add(z);
		repaint();
	}

	void principal ()
	{
		contenedor2=new Container();
		setContentPane(contenedor2);
		try
		{
			this.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("6.jpg")))));
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}

		String k = user.getText();
		setTitle("Sesion iniciada como: "+k); 							//coloca el nombre a la ventana
		this.setVisible(true);

		j = new JLabel ("Realizar Consultas del trabajador");
		j.setBounds(300, 130, 200,25);
		this.getContentPane().add(j);


		consulta = new JButton("CONSULATA Nº3"); 									//crea el boton
		consulta.setBounds(100,100,200,40);
		consulta.setForeground(Color.black);
		//boton.setBackground(java.awt.Color.red);
		this.getContentPane().add(consulta); 								//agrega el boton a la ventana
		consulta.addActionListener(this);

		boton2 = new JButton("Cerrar Sesion"); //crea el boton
		boton2.setBounds(300,270,150,40);
		//boton2.setBackground(java.awt.Color.blue);
		this.getContentPane().add(boton2); //agrega el boton a la ventana
		boton2.addActionListener(this);

		z = new JLabel ("G.J.W.O.");
		z.setBounds(720, 448, 180,25);
		z.setForeground(Color.white); /// CAMBIAR COLOR DE LETRA
		z.setFont(new java.awt.Font ("Times New Roman",1 , 16)); /// CAMBIAR TIPO LETRA
		this.getContentPane().add(z);

		repaint();
	}

	void administrador()
	{
		contenedor3 = new Container();
		setContentPane(contenedor3);

		try
		{
			this.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("8.jpg")))));
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

	public void actionPerformed(ActionEvent e)
	{
		String u = user.getText();
		String p = pas.getText();

		if (e.getSource() == continuar)
		{
			String prueba = (String)tablaInser.getSelectedItem();

			if (prueba == "MAQUINARIA")
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
					JOptionPane.showMessageDialog(rootPane, "Los datos a ingresar son:");
					JOptionPane.showMessageDialog(rootPane, inserta.getText());
					JOptionPane.showMessageDialog(rootPane, insertb.getText());
					JOptionPane.showMessageDialog(rootPane, insertc.getText());
					JOptionPane.showMessageDialog(rootPane, insertd.getText());
					JOptionPane.showMessageDialog(rootPane, inserte.getText());
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
			administrador();
			repaint();

		}
		if (e.getSource()== tablaInser)
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

		if (e.getSource()== boton4 && r1.isSelected()==true)
		{
			j.setVisible(false);
			boton2.setVisible(false);
			boton4.setVisible(false);
			r1.setVisible(false);
			r2.setVisible(false);
			insercion();
			repaint();
		}

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

		if(e.getSource()==boton)
			System.exit(0);

		if (e.getSource() == boton3 && CmbUser_Type.getSelectedItem().equals("Administrador"))
		{
			if(user.getText().equals("jose") && pas.getText().equals("abreu"))
			{
				administrador();
				repaint();
			}
			else
			{
				if (!u.equals("") && !p.equals(""))
					JOptionPane.showMessageDialog(null, "Datos Incorrectos, Verifique");
			}
		}

		if (e.getSource() == boton3 && CmbUser_Type.getSelectedItem().equals("Trabajador"))
		{
			if(!u.equals("") && !p.equals(""))
			{
				principal();
				repaint();
		
			}
		}
		
		if (e.getSource() == consulta)
		{
			System.out.println("hola");
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

		if(e.getSource() == boton2)
		{
			consulta.setVisible(false);
			j.setVisible(false);
			boton2.setVisible(false);
			if(CmbUser_Type.getSelectedItem().equals("Administrador"))
			{
				r1.setVisible(false);
				r2.setVisible(false);
				boton4.setVisible(false);
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

		if(e.getSource() == boton4)
		{
			if(!r1.isSelected() && !r2.isSelected())
				JOptionPane.showMessageDialog(rootPane, "Debe seleccionar una opcion");
			else
			{
				if(r1.isSelected())
					System.out.println("Insertar");
				if(r2.isSelected())
					System.out.println("Eliminar");
			}
		}
	}
}
