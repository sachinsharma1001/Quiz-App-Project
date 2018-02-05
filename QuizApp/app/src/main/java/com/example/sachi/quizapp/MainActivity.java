package com.example.sachi.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int grade = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /*
    *  EditText box
     */

    public void editTextEnterAnswer(View view) {
        EditText et = findViewById(R.id.enterAns);
        String ansTyped = et.getText().toString();
        checkAnswerForEditText(ansTyped);
    }

    // checking answer for edit text box

    public void checkAnswerForEditText(String value) {
        String actualAnswer = "yes";
        if(actualAnswer.equalsIgnoreCase(value)) {
            grade += 1;
        }
    }

    /*
    * grading method for calculating the total marks obtained
     */

    public void grading(View view) {

        EditText editName =  findViewById(R.id.entername);
        String nameEnter = editName.getText().toString();

        /*
        *  radio button 1
         */

        RadioGroup rg1 = findViewById(R.id.radiogroup1);
        if(rg1.getCheckedRadioButtonId() != -1) {
            String value1 = ((RadioButton) findViewById(rg1.getCheckedRadioButtonId())).getText().toString();
            String actualAnswer1 = ((RadioButton)findViewById(R.id.boolean_radio_button)).getText().toString();
            if(actualAnswer1.equals(value1)) {
                grade += 1;
            }
        }

        /*
        *  radio button 2
         */

        RadioGroup rg2 = findViewById(R.id.radiogroup2);
        if(rg2.getCheckedRadioButtonId() != -1) {
            String value2 = ((RadioButton) findViewById(rg2.getCheckedRadioButtonId())).getText().toString();
            String actualAnswer2 = ((RadioButton)findViewById(R.id.public_radio_button)).getText().toString();
            if(actualAnswer2.equals(value2)) {
                grade += 1;
            }
        }

        /*
        *  radio button 4
         */

        RadioGroup rg4 = findViewById(R.id.radiogroup4);
        if(rg4.getCheckedRadioButtonId() != -1) {
            String value4 = ((RadioButton) findViewById(rg4.getCheckedRadioButtonId())).getText().toString();
            String actualAnswer4 = ((RadioButton)findViewById(R.id.this_radio_button)).getText().toString();
            if(actualAnswer4.equals(value4)) {
                grade += 1;
            }
        }

        CheckBox variableCheckBox = findViewById(R.id.variables_checkbox);
        boolean isVariableCheck = variableCheckBox.isChecked();
        CheckBox methodsCheckBox = findViewById(R.id.methods_checkbox);
        boolean isMethodCheck = methodsCheckBox.isChecked();
        CheckBox packageCheckBox = findViewById(R.id.packages_checkbox);
        boolean isPackageCheck = !(packageCheckBox.isChecked());
        CheckBox objectsCheckBox = findViewById(R.id.objects_checkbox);
        boolean isObjectCheck = objectsCheckBox.isChecked();

        if(isVariableCheck && isMethodCheck && isPackageCheck && isObjectCheck ) {
            grade = grade + 1;
        }


        /*
        * CheckBox for question 5
         */

        CheckBox inheritanceCheckBox = findViewById(R.id.inheritance_checkbox);
        boolean isInheritanceCheck = inheritanceCheckBox.isChecked();
        CheckBox exceptionCheckBox = findViewById(R.id.exception_checkbox);
        boolean isExceptionCheck = !(exceptionCheckBox.isChecked());
        CheckBox encapsulationCheckBox = findViewById(R.id.encapsulation_checkbox);
        boolean isEncapsulationCheck = encapsulationCheckBox.isChecked();
        CheckBox swingCheckBox = findViewById(R.id.swing_checkbox);
        boolean isSwingCheck = !(swingCheckBox.isChecked());

        if(isInheritanceCheck && isExceptionCheck && isEncapsulationCheck  && isSwingCheck ) {
            grade = grade + 1;
        }

        // calling editTextEnterAnswer
        editTextEnterAnswer(view);

        Toast.makeText(this,nameEnter + " Your Score is " + grade ,Toast.LENGTH_SHORT).show();

        if(grade >=3)
        {
            Toast.makeText(this,"Congratulations " + nameEnter + " You are Passed !!" ,Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(this,"You Failed !!" ,Toast.LENGTH_SHORT).show();
        }

    grade = 0;
    }
}

