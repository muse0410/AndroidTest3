package splitthecost2.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import static splitthecost2.myapplication.R.id.checkBox2;

public class MainActivity extends AppCompatActivity {
    private static final int REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button button01 = (Button)findViewById(R.id.Next);
        button01.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                Intent intent = new Intent(getApplicationContext(), NextActivity.class);
                startActivity(intent);
            }
        });
        final Button button02 = (Button)findViewById(R.id.buttonSend);
        button02.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                Intent intent = new Intent(getApplicationContext(), NameViewActivity.class);
                final EditText editText= (EditText)findViewById(R.id.editText);
                if(editText.getText() != null){
                    String str = editText.getText().toString();
                    intent.putExtra("test", str);
                }
                int requestCode = REQUEST_CODE;
                startActivityForResult( intent, requestCode );
                startActivity(intent);
                // in order to clear the edittext
                editText.setText("");
            }
        });
        Log.v("Lifesycle", "OnCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.v("Lifesycle", "OnStart");
    }

    public void onCheckboxClicked(View view) {
        final boolean checked = ((CheckBox) view).isChecked();
        switch(view.getId()) {
            case checkBox2:
                if (checked) {
                    // チェックボックス1がチェックされる
                    Toast.makeText(MainActivity.this, "チェックされました！", Toast.LENGTH_LONG).show();
                } else {
                    // チェックボックス1のチェックが外される
                    Toast.makeText(MainActivity.this, "外されました！", Toast.LENGTH_LONG).show();
                }
                break;
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            //SecondActivityから戻ってきた場合
            case (REQUEST_CODE):
                if (resultCode == RESULT_OK) {
                    //OKボタンを押して戻ってきたときの処理
                    Toast.makeText(MainActivity.this, "OK！", Toast.LENGTH_LONG).show();
                } else if (resultCode == RESULT_CANCELED) {
                    //キャンセルボタンを押して戻ってきたときの処理
                } else {
                    //その他
                }
                break;
            default:
                break;
        }
    }
}

