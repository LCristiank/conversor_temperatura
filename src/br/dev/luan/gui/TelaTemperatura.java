package br.dev.luan.gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import br.dev.luan.model.Temperatura;
import java.awt.Color;
import java.awt.Color;
import java.awt.Color;
import java.awt.Color;

public class TelaTemperatura {
	private JTextField textCelcius;
	private JLabel labelCelsius;
	private JButton buttonKelvin;
	private JButton buttonFehreinhelt;
	private JLabel labelResultado;
	private JLabel labelMensagemErro;
    private Font fonte = new Font("SansSerif", Font.BOLD, 15);


	public void criarTela(){

		
		// Criando o formato da tela.
		JFrame tela = new JFrame();
		tela.setSize(400, 300);
		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tela.setTitle("Conversor Temperatura");
		tela.setLocationRelativeTo(null);
		tela.setLayout(null);
		tela.setResizable(false);
		
		
		// Mensagem de Entrada
		labelCelsius = new JLabel();
		labelCelsius.setText("Informe a Temperatura:");
		labelCelsius.setBounds(50, 30, 180, 20);
		// caixa de entrada (input).
		textCelcius = new JTextField();
		textCelcius.setBounds(50, 50, 280, 30);
		
		// Formato da mensagem de erro.
		labelResultado = new JLabel();
		labelResultado.setBounds(120, 100, 160, 100);
		labelResultado.setFont(fonte);
		
		// Formato da mensagem de erro
		labelMensagemErro = new JLabel();
		labelMensagemErro.setBounds(110, 130, 200, 100);
		labelMensagemErro.setFont(fonte);
        labelMensagemErro.setForeground(Color.red);
		
		// Botão Conversor de Celsius para Kelvin
		buttonKelvin = new JButton();
		buttonKelvin.setText("Kelvin");
		buttonKelvin.setBounds(50, 85, 138, 30);
		buttonKelvin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Pega o conteúdo da caixa de entrada.
				String txtCelsius = textCelcius.getText();
				/**
				 *  Tratando o erro: 
				 *  converter uma string em um número, 
				 *  sendo que, caso o conteúdo da string não seja um número válido. 
				 *  retorna um erro 
				*/
				try {
					double celsius = Double.parseDouble(txtCelsius);
					
					Temperatura kelvin = new Temperatura();
					kelvin.setCelsius(celsius);
					celsius = kelvin.converterParaKelvin();

					labelResultado.setText(String.valueOf(Math.round(celsius) + " KELVIN"));
				} catch (NumberFormatException e2) {
					// mensagem de erro que será exibida na tela
					labelMensagemErro.setText("Insira números somente!");
				}
				
			}
		});

		// Botão Conversor de Celsius para Fehreinhelt
		buttonFehreinhelt = new JButton();
		buttonFehreinhelt.setText("Fehreinhelt");
		buttonFehreinhelt.setBounds(190, 85, 138, 30);
		buttonFehreinhelt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Pega o contéudo da caixa de entrada
				String txtCelsius = textCelcius.getText();
				try {
					double celsius = Double.parseDouble(txtCelsius);
					
					Temperatura fehreinhelt = new Temperatura();
					fehreinhelt.setCelsius(celsius);
					celsius = fehreinhelt.converterParaFahreinhelt();
					
					labelResultado.setText(String.valueOf(celsius + " FEHREINHELT"));				
				} catch (NumberFormatException e2) {
					labelMensagemErro.setText("Insira números somente!");
				}
			}
		});

		
		
		//Adicionar os componentes ao painel de conteudo
		
		// Texto acima da caixa de entrada
		tela.getContentPane().add(textCelcius);
		// Caixa de Entrada
		tela.getContentPane().add(labelCelsius);
		
		// Botões de conversões
		tela.getContentPane().add(buttonFehreinhelt);
		tela.getContentPane().add(buttonKelvin);
	
		tela.getContentPane().add(labelResultado);
		tela.getContentPane().add(labelMensagemErro);

		// Deixa a Tela vísivel
		tela.setVisible(true);
	}
}
