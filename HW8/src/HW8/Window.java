package HW8;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window extends JFrame {

    private int winWidth = 750;
    private int winHeight = 600;
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private int winPosX = (screenSize.width - winWidth) / 2;
    private int winPosY = (screenSize.height - winHeight) / 2;

    private int minMapSize = 3;
    private int maxMapSize = 10;
    private int minWinLength = 3;

    private String mapSizeSettingsPrefix = "Map size now: ";
    private String mapWinLengthPrefix = "Win Length now: ";

    private JButton btnStart;
    private JButton btnExit;
    private JButton btnClearLog;

    private JPanel panelSettings;
    private JPanel panelControls;

    private JTextArea gameLog;
    private JScrollPane scrollPanel;

    private JSlider sliderMapSizeSetup;
    private JLabel labelMapSize;

    private JSlider sliderWinLengthSetup;
    private JLabel labelWinLength;

    private Map gameMap;
    private int round = 0;

    Window() {
        prepareAppWindow();
        prepareGameSetting();
        prepareButtons();
        prepareSettingsControls();
        prepareGameLog();

        gameMap = new Map(this);

        panelSettings.add(panelControls, BorderLayout.NORTH);
        panelSettings.add(scrollPanel, BorderLayout.SOUTH);

        add(panelSettings, BorderLayout.EAST);
        add(gameMap);

        setVisible(true);
    }

    private void prepareAppWindow() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(winWidth, winHeight);
        setLocation(winPosX, winPosY);
        setTitle("tic-tac-toe");
        setResizable(false);
    }

    private void prepareGameSetting() {
        panelSettings = new JPanel();
        panelSettings.setLayout(new GridLayout(2, 1));
    }

    private void prepareButtons() {
        btnStart = new JButton("Start");
        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                collectGameSetupAndLaunch();
            }
        });

        btnExit = new JButton("Exit");
        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        btnClearLog = new JButton("Clear Log");
        btnClearLog.addActionListener(new ActionListener() {
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
        panelControls.add(btnStart);
        panelControls.add(btnExit);
        panelControls.add(btnClearLog);

    }

    private void prepareGameLog() {
        gameLog = new JTextArea();
        scrollPanel = new JScrollPane(gameLog);
        gameLog.setEditable(false);
        gameLog.setLineWrap(true);
    }

    void putLog(String msg) {
        gameLog.append(msg + "\n");
    }

    private void collectGameSetupAndLaunch() {
        int mapSize = sliderMapSizeSetup.getValue();
        int winLen = sliderWinLengthSetup.getValue();
        ++round;
        putLog("--- Round " + round + " ---");
        putLog("Map size is " + mapSize + "x" + mapSize + ". Win length is " + winLen);
        gameMap.startGame(mapSize, mapSize, winLen);
    }

}
