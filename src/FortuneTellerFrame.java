import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Random;

public class FortuneTellerFrame extends JFrame {
    private final JTextArea fortuneTextArea;
    private final ArrayList<String> fortunes;
    private int lastIndex = -1;

    public FortuneTellerFrame() {
        setTitle("Fortune Teller");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize((int) (Toolkit.getDefaultToolkit().getScreenSize().width * 0.75), 500);
        setLocationRelativeTo(null);

        // Top Panel
        JPanel topPanel = new JPanel();
        ImageIcon icon = new ImageIcon(new ImageIcon("src/fortune_teller.jpg").getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH));        JLabel titleLabel = new JLabel("Fortune Teller", icon, JLabel.CENTER);
        titleLabel.setFont(new Font("Serif", Font.BOLD, 36));
        titleLabel.setHorizontalTextPosition(JLabel.CENTER);
        titleLabel.setVerticalTextPosition(JLabel.BOTTOM);
        topPanel.add(titleLabel);

        // Middle Panel
        JPanel middlePanel = new JPanel();
        fortuneTextArea = new JTextArea(10, 40);
        fortuneTextArea.setFont(new Font("SansSerif", Font.PLAIN, 18));
        fortuneTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(fortuneTextArea);
        middlePanel.add(scrollPane);

        // Bottom Panel
        JPanel bottomPanel = new JPanel();
        JButton readFortuneButton = new JButton("Read My Fortune!");
        JButton quitButton = new JButton("Quit");
        readFortuneButton.setFont(new Font("SansSerif", Font.BOLD, 20));
        quitButton.setFont(new Font("SansSerif", Font.BOLD, 20));
        bottomPanel.add(readFortuneButton);
        bottomPanel.add(quitButton);

        // Add panels to frame
        add(topPanel, BorderLayout.NORTH);
        add(middlePanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        // Initialize fortunes
        fortunes = new ArrayList<>();
        fortunes.add("You will have a great day!");
        fortunes.add("Something unexpected will make you smile.");
        fortunes.add("A pleasant surprise is waiting for you.");
        fortunes.add("You will find a lost item today.");
        fortunes.add("An opportunity will present itself soon.");
        fortunes.add("Someone will appreciate your kindness.");
        fortunes.add("You will receive good news soon.");
        fortunes.add("A small act of generosity will bring great joy.");
        fortunes.add("Today is a perfect day for a new beginning.");
        fortunes.add("You will accomplish something great today.");
        fortunes.add("Adventure is on the horizon.");
        fortunes.add("You will make a new friend soon.");

        // Button Actions
        readFortuneButton.addActionListener((ActionEvent e) -> showNewFortune());
        quitButton.addActionListener((ActionEvent e) -> System.exit(0));
    }

    private void showNewFortune() {
        Random random = new Random();
        int newIndex;
        do {
            newIndex = random.nextInt(fortunes.size());
        } while (newIndex == lastIndex);
        lastIndex = newIndex;
        fortuneTextArea.append(fortunes.get(newIndex) + "\n");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            FortuneTellerFrame frame = new FortuneTellerFrame();
            frame.setVisible(true);
        });
    }
}
