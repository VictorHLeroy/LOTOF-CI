
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random; 


public class Lotofacil extends JFrame implements ActionListener {

    private JButton bttApostaNum, bttApostaltt, bttApostaParImpar; 
    private JTextField resultado; 


    public Lotofacil () {
        
        setTitle("Menu _Lotofácil");
        setSize(900,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel painel = new JPanel();
        painel.setLayout(new GridLayout(5,1));
        JLabel label = new JLabel("Menu Lotofácil", SwingConstants.CENTER );
        painel.add(label); 
        
        bttApostaNum = new JButton("Aposta de 0 a 100");
        bttApostaNum.addActionListener(this);
        painel.add(bttApostaNum);

        bttApostaltt = new JButton("Aposta de A a Z");
        bttApostaltt.addActionListener(this);
        painel.add(bttApostaltt);

        bttApostaParImpar = new JButton("Aposta de Impar ou Par");
        bttApostaParImpar.addActionListener(this);
        painel.add(bttApostaParImpar);

        resultado = new JTextField(); 
        resultado.setEditable(false);
        painel.add(resultado);

        add(painel); 
        setVisible(true);
    }

    public void actionPerformed (ActionEvent evento) {
        
        Random rd = new Random(); 
        if (evento.getSource() == bttApostaNum) {
            int escolhaNum = Integer.parseInt (JOptionPane.showInputDialog("Digite o número que deseja apostar de 0 a 100: "));
            int numeroSorteado = rd.nextInt(0,100); 
            
            if (numeroSorteado == escolhaNum) {
                resultado.setText("Parabéns, você ganhou R$1.000,00");
            }
            else {
                resultado.setText("Que pena! o número era: " +numeroSorteado);
            }
        }
        else if (evento.getSource() == bttApostaltt) {
            char escolhaLtt = JOptionPane.showInputDialog("Digite a letra que deseja apostar de A a Z: ").toUpperCase().charAt(0);
            char letraSorteada = Character.toUpperCase ((char)rd.nextInt(65,90));
            if (letraSorteada == escolhaLtt) {
                resultado.setText("Parabéns, você ganhou R$500,00.");
            }
            else {
                resultado.setText("Que pena! O número era: " +letraSorteada);
            }
            
        }
        else if (evento.getSource() == bttApostaParImpar) {
            String escolha = JOptionPane.showInputDialog("Digite entre PAR ou IMPAR: ").toUpperCase();
            int parOuImpar = rd.nextInt(0,1); 
            String certo = (parOuImpar == 0) ? "PAR" : "IMPAR"; //alterador ternario
            // if (parOuImpar == 0) {
            //     certo = "PAR";
            // }
            // else{
            //     certo = "IMPAR";
            // }
            if (escolha .equals(certo)) {
                resultado.setText("Parabéns, você ganhou R$100,00");
            } else {
                resultado.setText("Que pena, o certo era: "+certo);
            } 
        }
    } 



    public static void main(String[] args) {
        SwingUtilities.invokeLater(()-> {new Lotofacil();});
    }
}
