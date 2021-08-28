package com.webmingo.serviingovendors.Rtrofit.API;



import com.webmingo.serviingovendors.Rtrofit.ModalRepo.StatesRepo;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface UserService {


    @GET("states")
    Call<StatesRepo> GetStatee(

    );

    @GET("states")
    Call<ResponseBody> GetState(

    );
    @GET("cities/{state_id}")
    Call<ResponseBody> GetCity(
            @Path("state_id") String state_id
    );
    @GET("vendor/states")
    Call<ResponseBody> GetServeState(

    );
    @GET("vendor/cities/{state_id}")
    Call<ResponseBody> GetServeCity(
            @Path("state_id") String state_id
    );

    //--------------------------------Devender Singh
    //                                 8287018255
    //                                 ---------------------//





}