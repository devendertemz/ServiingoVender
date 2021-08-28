package com.webmingo.serviingovendors.ViewPrersenter;


import android.content.Context;

import com.webmingo.serviingovendors.Rtrofit.API.ApiManager;
import com.webmingo.serviingovendors.Rtrofit.ModalRepo.StatesRepo;

import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StatesPresenter {

    private StatesPresenterView view;

    public StatesPresenter(StatesPresenterView view) {
        this.view = view;
    }


    public void StatesPresenterRepo(Context context) {
        Call<StatesRepo> loginCall = ApiManager.getApi(context).GetStatee();
        //    Call<StatesRepo> loginCall = ApiManager.getApi(context).GetCart( "38","47,48");
        view.showHideProgress(true);

        loginCall.enqueue(new Callback<StatesRepo>() {
            @Override
            public void onResponse(Call<StatesRepo> call, Response<StatesRepo> response) {
                view.showHideProgress(false);

                if (response.isSuccessful() && response.body() != null && response.code() == 200) {
                    try {

                        view.onStatesRepoSuccess(response.body(), response.message());
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else if (response.code() == 500) {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1 = jsonObject.getJSONObject("message");

                        view.onStatesRepoError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onStatesRepoError(String.valueOf(response.code()));
                    }

                } else if (response.code() == 401) {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1 = jsonObject.getJSONObject("message");

                        view.onStatesRepoError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onStatesRepoError(String.valueOf(response.code()));
                    }
                }
            }

            @Override
            public void onFailure(Call<StatesRepo> call, Throwable t) {
                view.onStatesRepoFailure(t);
                view.showHideProgress(false);

            }
        });

    }

    public interface StatesPresenterView {

        void onStatesRepoError(String message);

        void onStatesRepoSuccess(StatesRepo response, String message);

        void showHideProgress(boolean isShow);

        void onStatesRepoFailure(Throwable t);
    }
}
