import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.*;

public class TextEditor extends JFrame {
	private JButton btSalvar, btAbrir, btLimpar;
	private JTextField tfTexto;
	private TextArea taTexto;
	private FileDialog fdAbrir, fdSalvar;
	private String nome_do_arquivo;
	private JMenuBar mnBarra;
	private JMenu mnFonte, mnTamanho, mnEstilo, mnCor, mnLimpar;
	private JMenuItem miArial, mi12, miNegrito, miRed, miLimpar, miCalibri, miComicsans, migreen, miblue;

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
		miCalibri = new JMenuItem("Calibri");
		miComicsans = new JMenuItem("Comic sans");
		mi12 = new JMenuItem("12");
		miNegrito = new JMenuItem("Negrito");
		miRed = new JMenuItem("Vermelho");
		migreen = new JMenuItem("Verde");
		miblue = new JMenuItem("Azul");
		miLimpar = new JMenuItem("Limpar");

		miLimpar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_BACK_SPACE, ActionEvent.CTRL_MASK));

		tfTexto = new JTextField("Um Belo Editor =)");
		tfTexto.setBounds(5, 20, 200, 20);
		tfTexto.setEditable(false);
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
		mnFonte.add(miCalibri);
		mnFonte.add(miComicsans);
		mnEstilo.add(miNegrito);
		mnTamanho.add(mi12);
		mnCor.add(miRed);
		mnCor.add(migreen);
		mnCor.add(miblue);
		mnLimpar.add(miLimpar);
		mnBarra.add(mnFonte);
		mnBarra.add(mnEstilo);
		mnBarra.add(mnTamanho);
		mnBarra.add(mnCor);
		mnBarra.add(mnLimpar);
		add(taTexto);
		add(btSalvar);
		add(btAbrir);
		add(tfTexto);

		setJMenuBar(mnBarra);

	}

	public void DefinirEventos() {
		miArial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				taTexto.setFont(new Font("Arial", 0, 12));
			}
		});
		miCalibri.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				taTexto.setFont(new Font("Calibri", 0, 12));
			}
		});
		miComicsans.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				taTexto.setFont(new Font("Comic sans ms", 0, 12));
			}
		});
		miRed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				taTexto.setForeground(Color.red);
			}
		});
		migreen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				taTexto.setForeground(Color.green);
			}
		});
		miblue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				taTexto.setForeground(Color.blue);
			}
		});
		miLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				taTexto.setText("");
			}
		});

		btSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					fdSalvar.setVisible(true);
					if (fdSalvar.getFile() == null) {
						return;
					}
					nome_do_arquivo = fdSalvar.getDirectory() + fdSalvar.getFile();
					FileWriter out = new FileWriter(nome_do_arquivo);
					out.write(taTexto.getText());
					out.close();
					tfTexto.setText("Arquivo gravado com sucesso");
				} catch (IOException erro) {
					tfTexto.setText("Erro ao gravar no arquivo" + erro.toString());
				}

			}
		});
		btAbrir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					fdAbrir.setVisible(true);
					if (fdAbrir.getFile() == null) {
						return;
					}
					nome_do_arquivo = fdAbrir.getDirectory() + fdAbrir.getFile();
					FileReader in = new FileReader(nome_do_arquivo);
					String s = "";
					int i = in.read();
					while (i != -1) {
						s = s + (char) i;
						i = in.read();
					}
					taTexto.setText(s);
					in.close();
					tfTexto.setText("Arquivo aberto com sucesso");
				} catch (IOException erro) {
					tfTexto.setText("Erro ao abrir no arquivo" + erro.toString());
				}

			}
		});
	}
}
