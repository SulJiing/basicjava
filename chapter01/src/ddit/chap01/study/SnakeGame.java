package ddit.chap01.study;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;

public class SnakeGame extends JPanel implements ActionListener {
    private final int WIDTH = 800;
    private final int HEIGHT = 600;
    private final int UNIT_SIZE = 20;
    private final int GAME_UNITS = (WIDTH * HEIGHT) / (UNIT_SIZE * UNIT_SIZE);
    private ArrayList<Point> snake;
    private Point food;
    private boolean isRunning = false;
    private boolean isMovingRight = true;
    private boolean isMovingLeft = false;
    private boolean isMovingUp = false;
    private boolean isMovingDown = false;
    private Timer timer;
    private Random random;

    public SnakeGame() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(Color.black);
        setFocusable(true);
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int key = e.getKeyCode();
                if (key == KeyEvent.VK_LEFT && !isMovingRight) {
                    isMovingLeft = true;
                    isMovingUp = false;
                    isMovingDown = false;
                }
                if (key == KeyEvent.VK_RIGHT && !isMovingLeft) {
                    isMovingRight = true;
                    isMovingUp = false;
                    isMovingDown = false;
                }
                if (key == KeyEvent.VK_UP && !isMovingDown) {
                    isMovingUp = true;
                    isMovingRight = false;
                    isMovingLeft = false;
                }
                if (key == KeyEvent.VK_DOWN && !isMovingUp) {
                    isMovingDown = true;
                    isMovingRight = false;
                    isMovingLeft = false;
                }
            }
        });
        initGame();
    }

    public void initGame() {
        snake = new ArrayList<>();
        random = new Random();
        snake.add(new Point(WIDTH / 2, HEIGHT / 2));
        spawnFood();
        timer = new Timer(100, this);
        timer.start();
        isRunning = true;
    }

    public void spawnFood() {
        int x = random.nextInt(WIDTH / UNIT_SIZE) * UNIT_SIZE;
        int y = random.nextInt(HEIGHT / UNIT_SIZE) * UNIT_SIZE;
        food = new Point(x, y);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (isRunning) {
            move();
            checkFoodCollision();
            checkCollision();
            repaint();
        }
    }

    public void move() {
        for (int i = snake.size() - 1; i > 0; i--) {
            snake.set(i, new Point(snake.get(i - 1)));
        }

        Point head = snake.get(0);
        if (isMovingRight) {
            head.x += UNIT_SIZE;
        }
        if (isMovingLeft) {
            head.x -= UNIT_SIZE;
        }
        if (isMovingUp) {
            head.y -= UNIT_SIZE;
        }
        if (isMovingDown) {
            head.y += UNIT_SIZE;
        }
    }

    public void checkFoodCollision() {
        if (snake.get(0).equals(food)) {
            snake.add(new Point(-1, -1)); // Add a new tail segment
            spawnFood();
        }
    }

    public void checkCollision() {
        for (int i = 1; i < snake.size(); i++) {
            if (snake.get(0).equals(snake.get(i))) {
                isRunning = false;
                timer.stop();
                break;
            }
        }
        if (snake.get(0).x < 0 || snake.get(0).x >= WIDTH || snake.get(0).y < 0 || snake.get(0).y >= HEIGHT) {
            isRunning = false;
            timer.stop();
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g) {
        if (isRunning) {
            g.setColor(Color.green);
            g.fillRect(food.x, food.y, UNIT_SIZE, UNIT_SIZE);

            for (Point point : snake) {
                g.setColor(Color.white);
                g.fillRect(point.x, point.y, UNIT_SIZE, UNIT_SIZE);
            }

            Toolkit.getDefaultToolkit().sync();
        } else {
            gameOver(g);
        }
    }

    public void gameOver(Graphics g) {
        String message = "게임 오버";
        Font font = new Font("Helvetica", Font.BOLD, 40);
        FontMetrics metrics = getFontMetrics(font);

        g.setColor(Color.white);
        g.setFont(font);
        g.drawString(message, (WIDTH - metrics.stringWidth(message)) / 2, HEIGHT / 2);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("지렁이 게임");
        SnakeGame snakeGame = new SnakeGame();
        frame.add(snakeGame);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}


