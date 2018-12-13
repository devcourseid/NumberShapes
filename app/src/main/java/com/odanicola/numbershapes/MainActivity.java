package com.odanicola.numbershapes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    class Number{
        int number;

        public boolean isTriangle(){
            int x = 1;
            int triangleNumbers = 1;

            while (triangleNumbers < number){
                x++;
                triangleNumbers = triangleNumbers + x;
            }

            if(triangleNumbers == number){
                return true;
            }else{
                return false;
            }
        }

        public boolean isSquare(){
            double squareRoot = Math.sqrt(number);

            if(squareRoot == Math.floor(squareRoot)){
                return true;
            }else{
                return false;
            }

        }
    }

    public void makeToast(String string){
        Toast.makeText(MainActivity.this, string, Toast.LENGTH_SHORT).show();
    }

    public void resetField(EditText text){
        text.setText("");
    }

    public void testNumber(View view){
        Number user = new Number();
        EditText userNumber = (EditText) findViewById(R.id.usersNumber);
        String message = "";

        if(userNumber.getText().toString() != ""){
            user.number = Integer.parseInt(userNumber.getText().toString());

            if(user.isTriangle()){
                if(user.isSquare()){
                    message = user.number + " is both triangle and square number";
                    makeToast(message);
                    resetField(userNumber);
                }else{
                    message = user.number + " is triangle but not square number";
                    makeToast(message);
                    resetField(userNumber);
                }
            }else{
                if(user.isSquare()){
                    message = user.number + " is square but not triangle number";
                    makeToast(message);
                    resetField(userNumber);
                }else{
                    message = user.number + " is neither triangle nor square";
                    makeToast(message);
                    resetField(userNumber);
                }
            }
        }else{
            makeToast("Please input a number to test");
        }


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
