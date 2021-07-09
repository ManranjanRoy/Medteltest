package com.dca.medteltest.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import com.dca.medteltest.PresenterImp.UserPresenterImp;
import com.dca.medteltest.R;
import com.dca.medteltest.adaptor.UserListAdaptor;
import com.dca.medteltest.model.UserModel;
import com.dca.medteltest.presenter.UserPresenter;
import com.dca.medteltest.view.UserView;
import com.github.ybq.android.spinkit.sprite.Sprite;
import com.github.ybq.android.spinkit.style.FoldingCube;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements UserView{
    UserPresenter userPresenter;
    RecyclerView addressrecyclerview;
    ProgressBar progressBar;
    UserListAdaptor useradaptor;
    List<UserModel> userModelList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userPresenter = new UserPresenterImp(MainActivity.this,getApplicationContext());

        progressBar = findViewById(R.id.spin_kit);
        Sprite doubleBounce = new FoldingCube();
        progressBar.setIndeterminateDrawable(doubleBounce);
        addressrecyclerview = findViewById(R.id.recyclerview);
        addressrecyclerview.setHasFixedSize(true);
        addressrecyclerview.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        userPresenter.getdata();

    }


    @Override
    public void Showprogess() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void dismissproggress() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void getuserlist(List<UserModel> userModelList) {
        this.userModelList=userModelList;
        useradaptor = new UserListAdaptor(getApplicationContext(), userModelList);
        addressrecyclerview.setAdapter(useradaptor);

    }


}