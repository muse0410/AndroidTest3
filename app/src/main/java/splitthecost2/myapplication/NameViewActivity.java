package splitthecost2.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.os.Bundle;
import android.widget.TextView;

public class NameViewActivity extends AppCompatActivity {
    private EditText editText;
    private String message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name_view);
        final Button button01 = (Button)findViewById(R.id.buttonBack);
        button01.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
        String home = getIntent().getStringExtra("test");
        if (home != null) {// 定義されている
            Intent intent = getIntent();
            //intentから指定キーの文字列を取得する
            String data = intent.getStringExtra("test");

            TextView textView = (TextView)findViewById(R.id.textView3);
            textView.setText(data);
        } else {//まだ定義されていない
        }
    }
}
