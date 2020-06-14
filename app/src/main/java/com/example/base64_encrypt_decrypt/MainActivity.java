package com.example.base64_encrypt_decrypt;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {

    EditText editText, editText1;
    Button button, button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        editText = findViewById( R.id.editOne );
        editText1 = findViewById( R.id.editTwo );
        button = findViewById( R.id.encrypt );
        button1 = findViewById( R.id.decrypt );
        
        button.setOnClickListener( view -> {
            
            String s1 = editText.getText().toString();
            
            if (s1.isEmpty()) {
                Toast.makeText( this, "Please type here sufficient value", Toast.LENGTH_SHORT ).show();
            } else {
                byte[] base64Data = s1.getBytes();
                String base64Str = "";
                try {
                    base64Str = base64.ecryptBase64( base64Data );
                } catch (Exception e) {
                    e.printStackTrace();
                }
                editText1.setText( base64Str );
            }

        } );
        
        button1.setOnClickListener( view -> {
            
            String base64Str = editText.getText().toString();
            
            if (base64Str.isEmpty()) {
                Toast.makeText( this, "Please type here sufficient value", Toast.LENGTH_SHORT ).show();
            } else {
                byte[] base64Byte = null;
                try {
                    base64Byte = base64.decryptBase64( base64Str );
                } catch (Exception e) {
                    e.printStackTrace();
                }
                String output =  new String( base64Byte );
                editText1.setText( output);
            }
        } );
    }
    //com.github.gcacace:signature-pad;1.2.1
}
