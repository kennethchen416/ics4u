package mastermind.gui.scenes;

import javax.swing.*;
import java.awt.*;

public class GameModeSelector extends Scene {
    private final JPanel selectorPanel = new JPanel();
    private final JRadioButton codeBreakerButton = new JRadioButton("Code Breaker", true);
    private final JRadioButton codeMakerButton = new JRadioButton("Code Maker");
    private final JButton proceedButton = new JButton("Proceed");

    /**
     * Creates a new GameModeSelector object that represents a scene for selecting the game mode.
     *
     * <p>
     * This constructor initializes the UI components required for the game mode selection. It configures
     * the selector panel and the proceed button, adds them to the provided JFrame, and refreshes the frame
     * to ensure the UI is updated.
     * </p>
     *
     * @param frame The JFrame to which the game mode selection UI components will be added.
     */
    public GameModeSelector(final JFrame frame) {
        super(frame);

        drawSelectorPanel();
        drawProceedButton();

        frame.add(selectorPanel);
        frame.add(proceedButton);

        refreshFrame();
    }

    /**
     * Configures and sets up the selector panel for game mode selection.
     *
     * <p>
     * This method initializes the layout, alignment, and border for the selector panel.
     * It adds the game mode radio buttons (Code Breaker and Code Maker) to the panel
     * and groups these buttons using a ButtonGroup to ensure only one can be selected
     * at a time.
     * </p>
     *
     * <p>
     * The selector panel is visually structured to display the game modes vertically
     * with a centered alignment, and labeled with a titled border named "Game Modes".
     * </p>
     */
    private void drawSelectorPanel() {
        selectorPanel.setLayout(new BoxLayout(selectorPanel, BoxLayout.Y_AXIS));
        selectorPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        selectorPanel.setBorder(BorderFactory.createTitledBorder("Game Modes"));

        selectorPanel.add(codeBreakerButton);
        selectorPanel.add(codeMakerButton);

        final ButtonGroup gameModeButtonGroup = new ButtonGroup();
        gameModeButtonGroup.add(codeBreakerButton);
        gameModeButtonGroup.add(codeMakerButton);
    }

    /**
     * Configures and initializes the "Proceed" button for the game mode selection screen.
     *
     * <p>
     * This method sets the alignment of the "Proceed" button and attaches an event listener to it.
     * The button's action listener determines which game mode has been selected
     * by the user (Code Breaker or Code Maker) and performs the appropriate action:
     * - If the "Code Breaker" mode is selected, a new instance of `CodeBreakerSelector` is created.
     * - If the "Code Maker" mode is selected, a new instance of `CodeMaker` is created.
     * - If no mode is selected, an `IllegalArgumentException` is thrown.
     * </p>
     *
     * <p>
     * The "Proceed" button is aligned to the center for consistency with the overall UI design.
     * </p>
     */
    private void drawProceedButton() {
        proceedButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        proceedButton.addActionListener(_ -> {
            if (codeBreakerButton.isSelected()) {
                new CodeBreakerSelector(frame);
            } else if (codeMakerButton.isSelected()) {
                new CodeMaker(frame);
            } else {
                throw new IllegalArgumentException("A game mode has to be selected.");
            }
        });
    }
}