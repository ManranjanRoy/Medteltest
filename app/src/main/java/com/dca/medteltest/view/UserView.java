package com.dca.medteltest.view;

import com.dca.medteltest.model.UserModel;

import java.util.List;

public interface UserView {
    void Showprogess();
    void dismissproggress();
    void getuserlist(List<UserModel> userModelList);


}

