
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class ResumeAnalyzer {

    // Modern color theme
    static final Color BACKGROUND = new Color(240, 245, 250);
    static final Color NAVY = new Color(25, 55, 100);
    static final Color BLUE = new Color(35, 90, 160);
    static final Color WHITE = Color.WHITE;
    static final Color TEXT = new Color(45, 55, 70);

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> createAndShowGUI());

    }

    public static void createAndShowGUI() {

        // Main Window
        JFrame frame = new JFrame("Resume Analyzer");

        frame.setSize(950, 750);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout(15, 15));
        frame.getContentPane().setBackground(BACKGROUND);

        // ================= HEADER =================

        JPanel header = new JPanel();
        header.setBackground(NAVY);
        header.setLayout(new BoxLayout(header, BoxLayout.Y_AXIS));
        header.setBorder(new EmptyBorder(20, 25, 20, 25));

        JLabel title = new JLabel("RESUME ANALYZER");
        title.setFont(new Font("Arial", Font.BOLD, 28));
        title.setForeground(WHITE);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel subtitle = new JLabel(
            "Analyze your skills and discover career opportunities"
        );
        subtitle.setFont(new Font("Arial", Font.PLAIN, 14));
        subtitle.setForeground(new Color(220, 230, 245));
        subtitle.setAlignmentX(Component.CENTER_ALIGNMENT);

        header.add(title);
        header.add(Box.createVerticalStrut(8));
        header.add(subtitle);

        frame.add(header, BorderLayout.NORTH);

        // ================= MAIN CONTENT =================

        JPanel mainPanel = new JPanel(new GridLayout(1, 2, 20, 0));
        mainPanel.setBackground(BACKGROUND);
        mainPanel.setBorder(new EmptyBorder(10, 20, 20, 20));

        // ================= INPUT CARD =================

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        inputPanel.setBackground(WHITE);
        inputPanel.setBorder(new EmptyBorder(25, 25, 25, 25));

        JLabel inputTitle = new JLabel("Enter Resume Details");
        inputTitle.setFont(new Font("Arial", Font.BOLD, 20));
        inputTitle.setForeground(NAVY);

        JLabel nameLabel = new JLabel("Full Name");
        nameLabel.setFont(new Font("Arial", Font.BOLD, 14));

        JTextField nameField = new JTextField();
        nameField.setFont(new Font("Arial", Font.PLAIN, 14));
        nameField.setMaximumSize(new Dimension(Integer.MAX_VALUE, 38));

        JLabel emailLabel = new JLabel("Email Address");
        emailLabel.setFont(new Font("Arial", Font.BOLD, 14));

        JTextField emailField = new JTextField();
        emailField.setFont(new Font("Arial", Font.PLAIN, 14));
        emailField.setMaximumSize(new Dimension(Integer.MAX_VALUE, 38));

        JLabel skillsLabel = new JLabel("Enter Your Skills");
        skillsLabel.setFont(new Font("Arial", Font.BOLD, 14));

        JTextArea skillsArea = new JTextArea(8, 20);
        skillsArea.setFont(new Font("Arial", Font.PLAIN, 14));
        skillsArea.setLineWrap(true);
        skillsArea.setWrapStyleWord(true);

        JScrollPane skillsScroll = new JScrollPane(skillsArea);
        skillsScroll.setPreferredSize(new Dimension(300, 160));
        skillsScroll.setMaximumSize(
            new Dimension(Integer.MAX_VALUE, 160)
        );

        JLabel hintLabel = new JLabel(
            "Example: Java, Python, SQL, HTML, Communication"
        );
        hintLabel.setFont(new Font("Arial", Font.ITALIC, 11));
        hintLabel.setForeground(Color.GRAY);

        // Buttons
        JButton analyzeButton = new JButton("Analyze Resume");
        styleButton(analyzeButton, BLUE, WHITE);

        JButton resetButton = new JButton("Reset");
        styleButton(resetButton, new Color(225, 232, 242), NAVY);

        JPanel buttonPanel = new JPanel(new GridLayout(1, 2, 10, 0));
        buttonPanel.setBackground(WHITE);
        buttonPanel.add(analyzeButton);
        buttonPanel.add(resetButton);

        // Add components to input card
        inputPanel.add(inputTitle);
        inputPanel.add(Box.createVerticalStrut(25));

        inputPanel.add(nameLabel);
        inputPanel.add(Box.createVerticalStrut(8));
        inputPanel.add(nameField);
        inputPanel.add(Box.createVerticalStrut(20));

        inputPanel.add(emailLabel);
        inputPanel.add(Box.createVerticalStrut(8));
        inputPanel.add(emailField);
        inputPanel.add(Box.createVerticalStrut(20));

        inputPanel.add(skillsLabel);
        inputPanel.add(Box.createVerticalStrut(8));
        inputPanel.add(skillsScroll);
        inputPanel.add(Box.createVerticalStrut(8));
        inputPanel.add(hintLabel);
        inputPanel.add(Box.createVerticalStrut(25));

        inputPanel.add(buttonPanel);

        // ================= RESULTS CARD =================

        JPanel resultPanel = new JPanel();
        resultPanel.setLayout(new BoxLayout(resultPanel, BoxLayout.Y_AXIS));
        resultPanel.setBackground(WHITE);
        resultPanel.setBorder(new EmptyBorder(25, 25, 25, 25));

        JLabel resultTitle = new JLabel("Analysis Results");
        resultTitle.setFont(new Font("Arial", Font.BOLD, 20));
        resultTitle.setForeground(NAVY);

        JLabel scoreHeading = new JLabel("YOUR RESUME REPORT");
        scoreHeading.setFont(new Font("Arial", Font.BOLD, 13));
        scoreHeading.setForeground(BLUE);

        JTextArea resultArea = new JTextArea();
        resultArea.setFont(new Font("Arial", Font.PLAIN, 14));
        resultArea.setEditable(false);
        resultArea.setLineWrap(true);
        resultArea.setWrapStyleWord(true);
        resultArea.setText(
            "Welcome to Resume Analyzer!\n\n" +
            "Enter your details and skills.\n\n" +
            "Click Analyze Resume to see your report."
        );

        resultArea.setBackground(new Color(248, 250, 253));
        resultArea.setMargin(new Insets(12, 12, 12, 12));

        JScrollPane resultScroll = new JScrollPane(resultArea);
        resultScroll.setPreferredSize(new Dimension(350, 400));
        resultScroll.setBorder(
            new LineBorder(new Color(220, 228, 238), 1)
        );

        resultPanel.add(resultTitle);
        resultPanel.add(Box.createVerticalStrut(25));
        resultPanel.add(scoreHeading);
        resultPanel.add(Box.createVerticalStrut(12));
        resultPanel.add(resultScroll);

        // Add both cards
        mainPanel.add(inputPanel);
        mainPanel.add(resultPanel);

        frame.add(mainPanel, BorderLayout.CENTER);

        // ================= ANALYZE BUTTON ACTION =================

        analyzeButton.addActionListener(e -> {

            String name = nameField.getText().trim();
            String email = emailField.getText().trim();
            String skills = skillsArea.getText().trim();

            // Input validation
            if (name.isEmpty() || email.isEmpty() || skills.isEmpty()) {
                JOptionPane.showMessageDialog(
                    frame,
                    "Please fill in all the fields.",
                    "Missing Information",
                    JOptionPane.WARNING_MESSAGE
                );
                return;
            }

            if (!Pattern.matches(
                "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$",
                email
            )) {
                JOptionPane.showMessageDialog(
                    frame,
                    "Please enter a valid email address.",
                    "Invalid Email",
                    JOptionPane.WARNING_MESSAGE
                );
                return;
            }

            // Skills list
            String[] skillList = {
                "Java",
                "Python",
                "SQL",
                "HTML",
                "CSS",
                "JavaScript",
                "DBMS",
                "DSA",
                "Communication",
                "Git"
            };

            List<String> foundSkills = new ArrayList<>();

            for (String skill : skillList) {

                if (hasSkill(skills, skill)) {
                    foundSkills.add(skill);
                }
            }

            // Score calculation
            int count = foundSkills.size();
            int score = count * 10;

            // Build report
            StringBuilder result = new StringBuilder();

            result.append("RESUME ANALYSIS REPORT\n");
            result.append("==============================\n\n");

            result.append("Name: ").append(name).append("\n");
            result.append("Email: ").append(email).append("\n\n");

            result.append("DETECTED SKILLS\n");
            result.append("------------------------------\n");

            if (count == 0) {
                result.append("No matching skills detected.\n");
            } else {
                for (String skill : foundSkills) {
                    result.append("[+] ").append(skill).append(" Found\n");
                }
            }

            result.append("\nSkills Count: ").append(count).append("/10\n");
            result.append("Resume Score: ").append(score).append("/100\n");

            result.append("\nCAREER SUGGESTION\n");
            result.append("------------------------------\n");

            // Career suggestions
            if (hasSkill(skills, "Java")) {

                result.append("Career Path: Java Developer\n");
                result.append(
                    "Reason: You have Java programming skills."
                );

            } else if (hasSkill(skills, "Python")) {

                result.append("Career Path: Python Developer\n");
                result.append(
                    "Reason: You have Python programming skills."
                );

            } else if (
                hasSkill(skills, "HTML") &&
                hasSkill(skills, "CSS") &&
                hasSkill(skills, "JavaScript")
            ) {

                result.append("Career Path: Front-End Developer\n");
                result.append(
                    "Reason: You have web development skills."
                );

            } else if (
                hasSkill(skills, "SQL") &&
                hasSkill(skills, "DBMS")
            ) {

                result.append("Career Path: Database Developer\n");
                result.append(
                    "Reason: You have database-related skills."
                );

            } else {

                result.append("Career Path: Software Engineer\n");
                result.append(
                    "Reason: Continue developing your technical skills."
                );
            }

            resultArea.setText(result.toString());
            resultArea.setCaretPosition(0);

        });

        // ================= RESET BUTTON ACTION =================

        resetButton.addActionListener(e -> {

            nameField.setText("");
            emailField.setText("");
            skillsArea.setText("");

            resultArea.setText(
                "Welcome to Resume Analyzer!\n\n" +
                "Enter your details and skills.\n\n" +
                "Click Analyze Resume to see your report."
            );

        });

        // Show application
        frame.setVisible(true);

    }

    // ================= HELPER METHODS =================

    public static void styleButton(
        JButton button, Color background, Color foreground
    ) {

        button.setBackground(background);
        button.setForeground(foreground);
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setFocusPainted(false);
        button.setOpaque(true);
        button.setBorderPainted(false);
        button.setPreferredSize(new Dimension(150, 42));

    }

    // Check for complete skill names
    public static boolean hasSkill(String text, String skill) {

        String regex = "(?i)(?<![a-z0-9])" +
            Pattern.quote(skill) +
            "(?![a-z0-9])";

        return Pattern.compile(regex).matcher(text).find();

    }
}
