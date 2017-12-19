import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Board extends JComponent implements KeyListener {
  int testBoxX;
  int testBoxY;
  static Hero hero;
  static Map map;
  static Monster monster;
  static Monster monster2;
  static Monster monster3;
  static Boss boss;


  public Board() {
    testBoxX = 0;
    testBoxY = 0;
    setPreferredSize(new Dimension(720, 720));
    setVisible(true);
  }

  public static void main(String[] args) {
    JFrame frame = new JFrame("RPG Game");
    Board board = new Board();
    map = new Map();
    hero = new Hero();
    monster = new Monster(map);
    monster2 = new Monster(map);
    monster3 = new Monster(map);
    boss = new Boss(map);
    frame.add(board);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
    frame.pack();
    frame.addKeyListener(board);
  }

  @Override
  public void paint(Graphics g) {
    super.paint(g);
    g.fillRect(0, 0, 720, 720);
    for (int i = 0; i < 10; i++) {
      for (int j = 0; j < 10; j++) {
        g.drawImage(map.getTile(i, j).getTexture(), i * 72, j * 72, null);
      }
    }
    boss.draw(g);
    monster.draw(g);
    monster2.draw(g);
    monster3.draw(g);
    hero.draw(g);
  }

  @Override
  public void keyTyped(KeyEvent e) {
  }

  @Override
  public void keyPressed(KeyEvent e) {
  }

  @Override
  public void keyReleased(KeyEvent e) {
    if (e.getKeyCode() == KeyEvent.VK_UP) {
      hero.move(map,Hero.Directions.UP);
    } else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
      hero.move(map,Hero.Directions.DOWN);
    } else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
      hero.move(map,Hero.Directions.LEFT);
    } else if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
      hero.move(map,Hero.Directions.RIGHT);
    }
    repaint();
  }
}