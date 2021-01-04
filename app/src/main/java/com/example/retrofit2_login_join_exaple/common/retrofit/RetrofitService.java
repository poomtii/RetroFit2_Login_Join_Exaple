package com.example.retrofit2_login_join_exaple.common.retrofit;

import com.example.retrofit2_login_join_exaple.model.common.CommonResult;
import com.example.retrofit2_login_join_exaple.model.user.UserDTO;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface RetrofitService {

    @POST("user/register")
    Call<CommonResult> getUserRegister(
            @Body UserDTO dto
    );
}
