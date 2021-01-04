package com.example.retrofit2_login_join_exaple.model.user;

import lombok.Data;

@Data
public class UserDTO {
    private String user_id;
    private String user_pwd;
    private String user_code;
    private String dept_code;
    private String create_date;
    private String update_date;
}
