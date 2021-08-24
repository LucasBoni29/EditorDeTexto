import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.*;
public class TextEditor extends JFrame{
	private JLabel label1, label2;
	private JButton btSalvar, btAbrir, btLimpar;
	private JTextField tfTexto;
	private TextArea taTexto;
	private FileDialog fdAbrir, fdSalvar;
	private String nome_do_arquivo;
	private JMenuBar mnBarra;
	private JMenu mnFonte, mnTamanho, mnEstilo, mnCor, mnLimpar;
	private JMenuItem miArial, mi12, miNegrito, miRed, miLimpar;
	
	public static void main(String args[]) {
		JFrame frame = new TextEditor();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	public TextEditor() {
		InicializarComponentes();
		DefinirEventos();
	}
	
	public void InicializarComponentes() {
		setTitle("Editor de Texto!");
		setLayout(null);
		setBounds(250, 50, 600, 350);
		setResizable(true);
		mnBarra = new JMenuBar();
		mnFonte = new JMenu("Fonte");
		mnFonte.setMnemonic('F');
		mnEstilo = new JMenu("Estilo da fonte");
		mnEstilo.setMnemonic('o');
		mnTamanho = new JMenu("Tamanho");
		mnTamanho.setMnemonic('a');
		mnLimpar = new JMenu("Limpar Text Area");
		mnLimpar.setMnemonic('L');
		mnCor = new JMenu("Cor da fonte");
		mnCor.setMnemonic('e');
		
		miArial = new JMenuItem("Arial");
		mi12 = new JMenuItem("12");
		miNegrito = new JMenuItem("Negrito");
		miRed = new JMenuItem("Vermelho");
		miLimpar = new JMenuItem("Limpar");
		
		miLimpar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_BACK_SPACE, ActionEvent.CTRL_MASK));
		
		
		label1 = new JLabel("Digite o texto aqui: ");
		label1.setBounds(5, 20, 200, 20);
		btSalvar = new JButton("Salvar");
		btSalvar.setBounds(475, 250, 100, 25);
		btAbrir = new JButton("Abrir");
		btAbrir.setBounds(360, 250, 100, 25);
		btLimpar = new JButton("Limpar");
		btLimpar.setBounds(410, 250, 80, 25);
		taTexto = new TextArea();
		taTexto.setBounds(5, 40, 350, 240);
		fdAbrir = new FileDialog(this, "Abrir arquivo", FileDialog.LOAD);
		fdSalvar = new FileDialog(this, "Salvar arquivo", FileDialog.SAVE);
		
		mnFonte.add(miArial);
		mnEstilo.add(miNegrito);
		mnTamanho.add(mi12);
		mnCor.add(miRed);
		mnLimpar.add(miLimpar);
		mnBarra.add(mnFonte);
		mnBarra.add(mnEstilo);
		mnBarra.add(mnTamanho);
		mnBarra.add(mnCor);
		mnBarra.add(mnLimpar);
		add(taTexto);
		add(btSalvar);
		add(btAbrir);
		add(label1);
		
		setJMenuBar(mnBarra);
		
	}
	
	public void DefinirEventos() {
		miLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				taTexto.setText("");
			}
		});
	}
}
