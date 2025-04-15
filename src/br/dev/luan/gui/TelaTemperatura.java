package br.dev.luan.gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import br.dev.luan.model.Temperatura;

public class TelaTemperatura {
	private JTextField textCelcius;
	private JLabel labelCelsius;
	private JButton buttonKelvin;
	private JButton buttonFehreinhelt;
	private JLabel labelResultado;
	private JLabel labelMensagemErro;
    private Font fonte = new Font("SansSerif", Font.BOLD, 15);
	
	public void criarTela(){
		JFrame tela = new JFrame();
		tela.setSize(400, 300);
		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tela.setTitle("Conversor Temperatura");
		tela.setLocationRelativeTo(null);
		tela.setLayout(null);
		tela.setResizable(false);
		
		textCelcius = new JTextField();
		labelCelsius = new JLabel();

		labelCelsius.setText("Informe a Temperatura:");
		labelCelsius.setBounds(50, 30, 180, 20);
		textCelcius.setBounds(50, 50, 280, 30);
		
		labelResultado = new JLabel();
		labelResultado.setBounds(120, 100, 160, 100);
		labelResultado.setFont(fonte);
		
		labelMensagemErro = new JLabel();
		labelMensagemErro.setBounds(110, 130, 200, 100);
		labelResultado.setFont(fonte);
		
		buttonKelvin = new JButton();
		buttonKelvin.setText("Kelvin");
		buttonKelvin.setBounds(50, 85, 138, 30);
		buttonKelvin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String txtCelsius = textCelcius.getText();
				try {

					double celsius = Double.parseDouble(txtCelsius);
					
					Temperatura kelvin = new Temperatura();
					kelvin.setCelsius(celsius);
					celsius = kelvin.converterParaKelvin();

					labelResultado.setText(String.valueOf(Math.round(celsius) + " KELVIN"));
				} catch (NumberFormatException e2) {
					System.out.println("Erro! Texto na caixa de entrada");
					labelMensagemErro.setText("Insira números somente!");
				}
				
			}
		});

		buttonFehreinhelt = new JButton();
		buttonFehreinhelt.setText("Fehreinhelt");
		buttonFehreinhelt.setBounds(190, 85, 138, 30);
		buttonFehreinhelt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					String txtCelsius = textCelcius.getText();
					double celsius = Double.parseDouble(txtCelsius);
					
					Temperatura fehreinhelt = new Temperatura();
					fehreinhelt.setCelsius(celsius);
					celsius = fehreinhelt.converterParaFahreinhelt();
					
					labelResultado.setText(String.valueOf(celsius + " FEHREINHELT"));
				} catch (NumberFormatException e2) {
					System.out.println("Erro! Texto na caixa de entrada");
					labelMensagemErro.setText("Insira números somente!");
				}
			}
		});

		
		
		//Adicionar os componentes ao painel de conteudo
		tela.getContentPane().add(textCelcius);
		tela.getContentPane().add(labelCelsius);
		
		tela.getContentPane().add(buttonFehreinhelt);
		tela.getContentPane().add(buttonKelvin);
		
	
		tela.getContentPane().add(labelResultado);
		tela.getContentPane().add(labelMensagemErro);
		
		tela.setVisible(true);
	}
}
