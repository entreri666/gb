package HW7;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window extends JFrame {

    private int winWidth = 800;
    private int winHeight = 700;
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private int winPosX = (screenSize.width - winWidth) / 2;
    private int winPosY = (screenSize.height - winHeight) / 2;

    private int minMapSize = 3;
    private int maxMapSize = 10;
    private int minWinLength = 3;

    private String mapSizeSettingsPrefix = "Map size now: ";
    private String mapWinLengthPrefix = "Win Length now: ";

    private JButton Start;
    private JButton Exit;
    private JButton ClearLog;

    private JPanel panelSettings;
    private JPanel panelControls;

    private JTextArea gameLog;
    private JScrollPane scrollPanel;

    private JSlider sliderMapSizeSetup;
    private JLabel labelMapSize;

    private JSlider sliderWinLengthSetup;
    private JLabel labelWinLength;



    Window() {
        prepareAppWindow();
        prepareGameSetting();
        prepareButtons();
        prepareSettingsControls();
        prepareGameLog();


        panelSettings.add(panelControls, BorderLayout.NORTH);
        panelSettings.add(scrollPanel, BorderLayout.SOUTH);

        add(panelSettings, BorderLayout.EAST);

        setVisible(true);
    }

    private void prepareAppWindow() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(winWidth, winHeight);
        setLocation(winPosX, winPosY);
        setTitle("Tic-tac-toe");
        setResizable(false);
    }

    private void prepareGameSetting() {
        panelSettings = new JPanel();
        panelSettings.setLayout(new GridLayout(2, 1));
    }

    private void prepareButtons() {
        Start = new JButton("Start");
        Start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                collectGameSetup();
            }
        });

        Exit = new JButton("Exit");
        Exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        ClearLog = new JButton("Clear Log");
        ClearLog.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameLog.setText("");
            }
        });
    }

    private void prepareSettingsControls() {
        panelControls = new JPanel();

        labelMapSize = new JLabel(mapSizeSettingsPrefix + minMapSize);

        sliderMapSizeSetup = new JSlider(minMapSize, maxMapSize, minMapSize);
        sliderMapSizeSetup.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int currentMapSizeValue = sliderMapSizeSetup.getValue();
                labelMapSize.setText(mapSizeSettingsPrefix + currentMapSizeValue);
                sliderWinLengthSetup.setMaximum(currentMapSizeValue);
            }
        });

        labelWinLength = new JLabel(mapWinLengthPrefix + minWinLength);
        sliderWinLengthSetup = new JSlider(minWinLength, minMapSize, minMapSize);
        sliderWinLengthSetup.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                labelWinLength.setText(mapWinLengthPrefix + sliderWinLengthSetup.getValue());
            }
        });


        panelControls.setLayout(new GridLayout(10, 1));
        panelControls.add(labelMapSize);
        panelControls.add(sliderMapSizeSetup);
        panelControls.add(labelWinLength);
        panelControls.add(sliderWinLengthSetup);
        panelControls.add(Start);
        panelControls.add(Exit);
        panelControls.add(ClearLog);

    }

    private void prepareGameLog() {
        gameLog = new JTextArea();
        scrollPanel = new JScrollPane(gameLog);
        gameLog.setEditable(false);
        gameLog.setLineWrap(true);
    }

    private void putLog(String msg) {
        gameLog.append(msg + "\n");
    }

    private void collectGameSetup() {
        int mapSize = sliderMapSizeSetup.getValue();
        int winLen = sliderWinLengthSetup.getValue();

        putLog("Map size is " + mapSize + "x" + mapSize + ". Win length is " + winLen);
    }


}
