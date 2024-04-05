package mandel.dictionary;

import com.opencsv.exceptions.CsvValidationException;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.io.IOException;
import java.util.List;

public class EnglishDictionaryFrame extends JFrame {
    private final EnglishDictionary dictionary = new EnglishDictionary();
    private final JTextField word;
    private final JTextArea defs;

    public EnglishDictionaryFrame() throws CsvValidationException, IOException {
        setSize(1000, 800);
        setTitle("English Dictionary");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel main = new JPanel();
        main.setLayout(new BorderLayout());
        main.setBackground(Color.WHITE);

        setContentPane(main);

        word = new JTextField();
        word.setFont(new Font("Sans-Serif", Font.PLAIN, 20));
        word.setBorder(new CompoundBorder(BorderFactory.createLineBorder(Color.decode("#6495ED"),
                2, true), BorderFactory.createEmptyBorder(5, 10, 5, 10)));

        main.add(word, BorderLayout.NORTH);
        main.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        defs = new JTextArea();
        defs.setEditable(false);
        defs.setWrapStyleWord(true);
        defs.setLineWrap(true);

        word.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                definitions();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                definitions();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                definitions();
            }
        });

        main.add(defs, BorderLayout.CENTER);
        defs.setFont(new Font("Sans-Serif", Font.PLAIN, 14));
        defs.setBorder(new CompoundBorder(BorderFactory.createLineBorder(Color.WHITE),
                BorderFactory.createEmptyBorder(10, 0, 10, 0)));
    }

    public void definitions()
    {
        List<String> allDefs = dictionary.getDefinition(word.getText());
        StringBuilder defText = new StringBuilder();
        for (String def : allDefs)
        {
            defText.append(def + "\n");
        }
        defs.setText(defText.toString());
    }
}
