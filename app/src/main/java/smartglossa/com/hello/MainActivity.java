package smartglossa.com.hello;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    EditText editname,editpass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editname = (EditText) findViewById(R.id.editName);
        editpass= (EditText) findViewById(R.id.editPass);
    }

    public void  save(View view)  // SAVE
    {
        File file= null;
        String name = editname.getText().toString();
        String password = editpass.getText().toString();

        FileOutputStream fileOutputStream = null;
        try {
            name = name + " ";
            file = getFilesDir();
            fileOutputStream = openFileOutput("Code.txt", Context.MODE_PRIVATE); //MODE PRIVATE
            fileOutputStream.write(name.getBytes());
            fileOutputStream.write(password.getBytes());
            Toast.makeText(this, "Saved \n" + "Path --" + file + "\tCode.txt", Toast.LENGTH_SHORT).show();
            editname.setText("");
            editpass.setText("");
            return;
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    } // hello project

    public void  next( View view)   //NEXT
    {
        Toast.makeText(this,"NEXT", Toast.LENGTH_SHORT).show();
        Intent intent= new Intent(this, MainActivity2.class);
        startActivity(intent);

    }
}




