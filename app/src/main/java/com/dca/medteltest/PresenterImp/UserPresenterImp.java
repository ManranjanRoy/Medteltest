package com.dca.medteltest.PresenterImp;


import android.content.Context;
import android.widget.Toast;

import com.dca.medteltest.model.UserModel;
import com.dca.medteltest.presenter.UserPresenter;
import com.dca.medteltest.service.CountryService;
import com.dca.medteltest.view.UserView;


import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserPresenterImp implements UserPresenter {

    UserView userView;
    Context context;

    public UserPresenterImp(UserView userView, Context applicationContext) {
        this.userView = userView;
        this.context=applicationContext;
    }

    @Override
    public void getdata() {
            userView.Showprogess();
            CountryService countryService = new CountryService();
            countryService.getAPI().userlist().enqueue(new Callback<List<UserModel>>() {
                @Override
                public void onResponse(Call<List<UserModel>> call, Response<List<UserModel>> response) {
                    if (response.isSuccessful()){
                        userView.dismissproggress();
                        userView.getuserlist(response.body());

                    }
                    else{
                        Toast.makeText(context, "Data not Found", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<List<UserModel>> call, Throwable t) {
                    userView.dismissproggress();
                    Toast.makeText(context, "Network Problem", Toast.LENGTH_SHORT).show();
                }
            });
        }


}
