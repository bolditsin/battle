package battle2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Battle extends JFrame {
    Villain villain = new Villain("Siggi", 4, 6, 6, 50);
    Hero hero = new Hero("Gork", 5, 4, 4, 60);

    private JButton btn2;
    private JButton btn3;

    private JTextField battleText;

    String display = "";

    public Battle() {

        JPanel p1 = new JPanel();
        p1.setLayout(new BorderLayout());
        p1.setBounds(650, 100, 1000, 1000);
        p1.add(btn3 = new JButton("Безрассудный выпад"));

        JPanel p2 = new JPanel();
        p2.setLayout(new BorderLayout());
        p2.setBounds(300, 300, 1000, 1000);
        p2.add(battleText = new JTextField(100));
        battleText.setHorizontalAlignment(JTextField.CENTER);
        battleText.setEditable(false);


        JPanel p3 = new JPanel();
        p3.setLayout(new BorderLayout());
        p3.setBounds(300, 300, 1000, 1000);
        p3.add(btn2 = new JButton("Атака"));

        JPanel p = new JPanel();
        p.setLayout(new BorderLayout());
        p.setBounds(650, 100, 1000, 1000);
        p.add(p2, BorderLayout.CENTER);
        p.add(p1, BorderLayout.EAST);
        p.add(p3, BorderLayout.WEST);

        add(p);

        btn2.addActionListener(new ListenToAttack());
        btn3.addActionListener(new ListenToCharge());

    }
    class ListenToAttack implements ActionListener {

        public void actionPerformed(ActionEvent e) {
           if(villain.hp>15 && hero.hp>0) {
               battleText.setText("");
               display = battleText.getText();
               battleText.setText(display + "Атака на " + hero.meleeAttack() + " У "+villain.name+" осталось " + villain.hp+ "hp   Он делает выпад в ответ и наносит "+villain.meleeAttack()+" ед. урона. У вас осталось "+hero.hp+ " hp");
               villain.hp = villain.hp - hero.meleeAttack();
               hero.hp=hero.hp- villain.meleeAttack();
           }
           else if(villain.hp<=0){
               battleText.setText("Враг повержен!");
           }
           else if(hero.hp<=0){
               battleText.setText("Вы проиграли!");
           }
           else if(villain.hp>0&&villain.hp<15){
               battleText.setText("");
               display = battleText.getText();
               battleText.setText(display + "Атака на " + hero.meleeAttack() + " У "+villain.name+" осталось " + villain.hp+ "hp   Он вскидывает руку и использует поджигание!!!! нанося "+villain.castCombustion()+" ед. урона. У вас осталось "+hero.hp+ " hp");
               villain.hp = villain.hp - hero.meleeAttack();
               hero.hp=hero.hp- villain.castCombustion();
           }

        }
    }
    class ListenToCharge implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if(villain.hp>15 && hero.hp>0) {
                battleText.setText("");
                display = battleText.getText();
                battleText.setText(display + "Безрассудный выпад! Вы теряете "+hero.meleeAttack()+" hp! Урон " + hero.castCharge() + " У "+villain.name+" осталось " + villain.hp+ "hp   Он делает выпад в ответ и наносит "+villain.meleeAttack()+" ед. урона. У вас осталось "+hero.hp+ " hp");
                villain.hp = villain.hp - hero.meleeAttack();
                hero.hp=hero.hp- villain.meleeAttack()-hero.meleeAttack();
            }
            else if(villain.hp<=0){
                battleText.setText("Враг повержен!");
            }
            else if(villain.hp>0&&villain.hp<15){
                battleText.setText("");
                display = battleText.getText();
                battleText.setText(display + "Безрассудный выпад! Вы теряете "+hero.meleeAttack()+" hp! Урон " + hero.castCharge() + " У "+villain.name+" осталось " + villain.hp+ "hp   Он вскидывает руку и использует поджигание!!!! нанося "+villain.castCombustion()+" ед. урона. У вас осталось "+hero.hp+ " hp");
                villain.hp = villain.hp - hero.meleeAttack()-5;
                hero.hp=hero.hp- villain.castCombustion()-hero.meleeAttack();
            }
            else {
                battleText.setText("Вы проиграли!");
            }
        }
        }

    public static void main(String[] args) {

        Battle b1 = new Battle();
        b1.pack();
        b1.setLocationRelativeTo(null);
        b1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        b1.setVisible(true);

    }
}