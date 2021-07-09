package com.dca.medteltest.service;


import com.dca.medteltest.model.UserModel;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;


public interface ApiService {

    @GET("users")
    Call<List<UserModel>> userlist();

}
