package c.sakshi.lab5;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String usernameKey = "username";

        SharedPreferences sharedPreferences = getSharedPreferences("c.sakshi.lab5", Context.MODE_PRIVATE);

        if(!sharedPreferences.getString(usernameKey, "").equals("")){
            Intent intent = new Intent(this, Main2Activity.class);
            startActivity(intent);
        }
        else{
            setContentView(R.layout.activity_main);
            configureLoginButton();
        }
    }

    public void configureLoginButton(){
        Button loginButton = (Button) findViewById(R.id.button);

        final Intent intent = new Intent(this, Main2Activity.class);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText myTextField = (EditText) findViewById(R.id.editText);
                String username = myTextField.getText().toString();
                SharedPreferences sharedPreferences = getSharedPreferences("c.sakshi.lab5", Context.MODE_PRIVATE);
                sharedPreferences.edit().putString("username", username).apply();
                startActivity(intent);
            }
        });
    }
}
