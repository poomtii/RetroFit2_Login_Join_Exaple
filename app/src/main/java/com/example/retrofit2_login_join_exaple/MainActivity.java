package com.example.retrofit2_login_join_exaple;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.retrofit2_login_join_exaple.common.retrofit.RetrofitBuilder;
import com.example.retrofit2_login_join_exaple.common.retrofit.RetrofitService;
import com.example.retrofit2_login_join_exaple.model.common.CommonResult;
import com.example.retrofit2_login_join_exaple.model.user.UserDTO;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import lombok.NonNull;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class MainActivity extends AppCompatActivity
{
    EditText et_id;
    EditText et_pwd;
    EditText et_user_code;
    EditText et_dept_code;
    Button btn_register;

    UserDTO userDTO;
    RetrofitService service;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;
        et_id = findViewById(R.id.et_id);
        et_pwd = findViewById(R.id.et_pwd);
        et_user_code = findViewById(R.id.et_user_code);
        et_dept_code = findViewById(R.id.et_dept_code);
        btn_register = findViewById(R.id.btn_register);

        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userDTO.setUser_id(et_id.getText().toString());
                userDTO.setUser_pwd(et_pwd.getText().toString());
                userDTO.setUser_code(et_user_code.getText().toString());
                userDTO.setDept_code(et_dept_code.getText().toString());

                RetrofitBuilder retrofitBuilder = RetrofitBuilder.getInstance("http://222.100.239.140:11005/");
                service = retrofitBuilder.getService();
                Call<CommonResult> rs = service.getUserRegister(userDTO);

                rs.enqueue(new Callback<CommonResult>() {
                    @Override
                    public void onResponse(Call<CommonResult> call, Response<CommonResult> response) {
                        if(response.isSuccessful()) {
                            CommonResult commonResult = response.body();
                            if(commonResult.getResult() == 0) {
                                Toast.makeText(context, "회원가입 실패", Toast.LENGTH_LONG).show();
                            } else if(commonResult.getResult() == 1) {
                                Toast.makeText(context, "회원가입 성공", Toast.LENGTH_LONG).show();
                                Intent intent = new Intent(context,LoginActivity.class);
                                startActivity(intent);
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<CommonResult> call, Throwable t) {

                    }
                });

            }
        });

    }
}