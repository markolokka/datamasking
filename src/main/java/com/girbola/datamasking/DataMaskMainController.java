package com.girbola.datamasking;

import com.girbola.utils.MaskingData;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataMaskMainController {
    private ModelMain modelMain;

    //@formatter:off
    @FXML private Button runBlurDataButton;
    @FXML private Button blurSelectedDataButton;
    @FXML private TextArea dataTextArea;
    @FXML private Button findSimilarButton;
    @FXML private Button loadFileButton;
    @FXML private Label actionText;
    @FXML private CheckBox regexAZUpperCaseCheckBox;
    @FXML private CheckBox regexAZLowerCaseCheckBox;
    @FXML private CheckBox regex09CheckBox;
    @FXML private TextField regexSpecialCharactersTextField;
    @FXML private TextField regexExcludeTextField;
    //@formatter:on

    @FXML
    void regexAZUpperCaseCheckBoxAction(ActionEvent event) {
        actionText.setText("A-Z activated");
    }


    @FXML
    void regexAZLowerCaseCheckBoxAction(ActionEvent event) {
        actionText.setText("a-z activated");
    }

    @FXML
    void regex09CheckBoxAction(ActionEvent event) {
        actionText.setText("0-9 activated");
    }

    @FXML
    void blurSelectedDataButtonAction(ActionEvent event) {
        String selectedText = dataTextArea.getSelectedText();
        IndexRange selection = dataTextArea.getSelection();
        int start = selection.getStart();
        int end = selection.getEnd();
        String blurData = MaskingData.maskData(selectedText, "1");

        dataTextArea.replaceText(start, end, blurData);

        actionText.setText("blurrying data: " + selectedText);

    }

    @FXML
    void runBlurDataButtonAction(ActionEvent event) {
        String regexExclude = splitAsList(regexExcludeTextField.getText());
        String regex = "";
        if(regexAZUpperCaseCheckBox.isSelected()) {
            regex += "A-Z";
        }
        if(regexAZLowerCaseCheckBox.isSelected()) {
            regex += "|a-z";
        }
        if(regex09CheckBox.isSelected()) {
            regex += "|0-9";
        }

        String text = dataTextArea.getText();
        for (int i = 0; i < text.length(); i++) {
            String currentChar = String.valueOf(text.charAt(i));
//            if(containsExclude())  {
//
//            }
            // Luodaan Pattern-olio regexin perusteella
            Pattern pattern = Pattern.compile(regex);

            // Luodaan Matcher-olio, joka vertailee merkkijonoa ja regexiä
            Matcher matcher = pattern.matcher(currentChar);
            if(matcher.matches()) {
                //logger.info("CurrentCHAT: " + "");
                System.out.println(currentChar);

            } else {
                System.out.println(currentChar);

            }
        }


    }

    private String splitAsList(String text) {
        List<String> list = new ArrayList<>();

        String[] split = text.split(",");

        return split.toString();
    }

    @FXML
    void findSimilarButtonAction(ActionEvent event) {
        
    }

    @FXML
    void loadFileButtonAction(ActionEvent event) {

    }

    public void initialize(ModelMain modelMain) {
        this.modelMain = modelMain;
    }
}
