package es.source.code.activity;

import android.content.Intent;
import android.os.Handler;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.example.scos.R;

import java.io.Serializable;
import java.util.regex.Pattern;

import es.source.code.model.User;

public class LoginOrRegister extends AppCompatActivity {

    private ProgressBar progressBar;
    private EditText logStr;
    private EditText passwdStr;
    private EditText errText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_or_register);
        Button logMS = (Button)findViewById(R.id.log);
        Button regMS = (Button)findViewById(R.id.register);
        Button retMS = (Button)findViewById(R.id.ret);
        progressBar = (ProgressBar)findViewById(R.id.progress_bar);
        logStr = (EditText)findViewById(R.id.edit_login);
        passwdStr = (EditText)findViewById(R.id.edit_passwd);
        errText = (EditText)findViewById(R.id.error_text);

        progressBar.setVisibility(View.INVISIBLE);

        logMS.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

              //  switch(v.getId()) {
                    //case R.id.log2:
                        progressBar.setVisibility(View.VISIBLE);
                        new Handler().postDelayed(new Runnable() {
                           @Override
                           public void run() {
                               progressBar.setVisibility(View.GONE);
                           }
                       },2000);

                        String str1 = logStr.getText().toString();
                        String str2 = passwdStr.getText().toString();
                        String pattern = "^[A-Za-z0-9]+";
                        boolean isMatch1 = Pattern.matches(pattern, str1);
                        boolean isMatch2 = Pattern.matches(pattern, str2);
                        if (isMatch1 && isMatch2 ) {
                            //创建User对象
                            //User loginUser=User(str1, str2, false);
                            User loginUser = new User();
                            loginUser.setUserName(str1);
                            loginUser.setPasswd(str2);
                            loginUser.setOldUser(true);
                            String data = "LoginSuccess";
                            //发送三个对象
                            Intent intent = new Intent(LoginOrRegister.this, MainScreen.class);
                            intent.putExtra("activity", "LoginRegister");
                            intent.putExtra("extra_data",data);
                            Intent user = intent.putExtra("User", (Serializable)loginUser);
                            startActivity(intent);
                        } else {
                            errText.setError("输入内容不符合规则");
                        }
            }
        });
        regMS.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                progressBar.setVisibility(View.VISIBLE);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        progressBar.setVisibility(View.GONE);
                    }
                },2000);

                String str1 = logStr.getText().toString();
                String str2 = passwdStr.getText().toString();
                String pattern = "^[A-Za-z0-9]+";
                boolean isMatch1 = Pattern.matches(pattern, str1);
                boolean isMatch2 = Pattern.matches(pattern, str2);
                if (isMatch1 && isMatch2 ) {
                    User loginUser = new User();
                    loginUser.setUserName(str1);
                    loginUser.setPasswd(str2);
                    loginUser.setOldUser(false);
                    String data = "RegisterSuccess";
                    Intent intent = new Intent(LoginOrRegister.this, MainScreen.class);
                    //发送三个对象
                    intent.putExtra("activity", "LoginRegister");
                    intent.putExtra("extra_data",data);
                    intent.putExtra("User", (Serializable) loginUser);
                    startActivity(intent);
                } else {
                    errText.setError("输入内容不符合规则");
                }
            }
        });
        retMS.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String data = "Return";
                Intent intent = new Intent(LoginOrRegister.this, MainScreen.class);
                //发送两个对象
                intent.putExtra("activity", "LoginRegister");
                intent.putExtra("extra_data",data);
                startActivity(intent);
            }
        });
    }
}
