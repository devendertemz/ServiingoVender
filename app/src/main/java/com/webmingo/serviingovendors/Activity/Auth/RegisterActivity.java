package com.webmingo.serviingovendors.Activity.Auth;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.Toast;

import com.irozon.sneaker.Sneaker;
import com.rjesture.startupkit.AppTools;
import com.webmingo.serviingovendors.Adapter.CitySpinnerAdapter;
import com.webmingo.serviingovendors.Adapter.StateSpinnerAdapter;
import com.webmingo.serviingovendors.R;
import com.webmingo.serviingovendors.Rtrofit.API.ApiManager;
import com.webmingo.serviingovendors.Rtrofit.ModalRepo.StatesRepo;
import com.webmingo.serviingovendors.ViewPrersenter.StatesPresenter;
import com.webmingo.serviingovendors.databinding.ActivityRegisterBinding;
import com.webmingo.serviingovendors.model.CityModel;
import com.webmingo.serviingovendors.model.StateModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {

    ActivityRegisterBinding binding;

    private View view;
    String firstname, lastname, email, mobileno, dob, gender, address, state, city, pincode, password, cpassword;
    StatesPresenter presenter;

    StateModel stateModel;
    ArrayList<StateModel> stateModelList;
    ArrayList<CityModel> cityModelList;
    String state_id, city_id, category_id;
    String Servestate_id, Servecity_id, Servecategory_id;


    ArrayList<StateModel> stateServeModelList;
    ArrayList<CityModel> cityServeModelList;
    String[] Gender = {"Select Gender", "Male", "Female", "Others"};//array of strings used to populate the spinner

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_register);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_register);
        view = binding.getRoot();
        setContentView(view);
        getState();
        ArrayAdapter<String> aa = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, Gender);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//Setting the ArrayAdapter data on the Spinner
        binding.basicinformation.GenderSpinner.setAdapter(aa);

        binding.basicinformation.GenderSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


                //  Toast.makeText(getActivity(), parent.getItemAtPosition(position).toString().trim()+"", Toast.LENGTH_SHORT).show();


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        binding.basicinformation.submitgernalform.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GetBasicinformationData();

            }
        });
        binding.basicinformation.startDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPickerDialog();

            }
        });


    }

    private void GetBasicinformationData() {


        firstname = binding.basicinformation.firstName.getText().toString();
        lastname = binding.basicinformation.ETLastName.getText().toString();
        email = binding.basicinformation.ETEmail.getText().toString();
        mobileno = binding.basicinformation.ETMobile.getText().toString();
        dob = binding.basicinformation.startDate.getText().toString();
        address = binding.basicinformation.ETAddress.getText().toString();
        pincode = binding.basicinformation.ETPincode.getText().toString();
        password = binding.basicinformation.etPassword.getText().toString();
        cpassword = binding.basicinformation.etCpassword.getText().toString();

        if (firstname.isEmpty()) {
            Sneaker.with(this)
                    .setTitle(" Enter First Name ")
                    .setMessage("")
                    .sneakWarning();
        } /*else if (lastname.isEmpty()) {
            Sneaker.with(this)
                    .setTitle(" Enter Last Name ")
                    .setMessage("")
                    .sneakWarning();
        } else if (email.isEmpty()) {
            Sneaker.with(this)
                    .setTitle(" Enter Email ")
                    .setMessage("")
                    .sneakWarning();
        } else if (mobileno.length() != 10) {
            Sneaker.with(this)
                    .setTitle("Please enter your 10 digit of mobile")
                    .setMessage("")
                    .sneakWarning();
        } else if (dob.isEmpty()) {
            Sneaker.with(this)
                    .setTitle("Select Date of Birth")
                    .setMessage("")
                    .sneakWarning();
        }

        else if(binding.basicinformation.GenderSpinner.getSelectedItem().toString().equalsIgnoreCase("Select Gender")) {

            Sneaker.with(this)
                    .setTitle("Select Gender")
                    .setMessage("")
                    .sneakWarning();
        }
        else if (address.isEmpty()) {
            Sneaker.with(this)
                    .setTitle("Enter Address")
                    .setMessage("")
                    .sneakWarning();
        }
        else if (state_id.equalsIgnoreCase("00")) {
            Sneaker.with(this)
                    .setTitle("Select  State!")
                    .setMessage("")
                    .sneakWarning();
        } else if (city_id.equalsIgnoreCase("00")) {
            Sneaker.with(this)
                    .setTitle("Select  City!")
                    .setMessage("")
                    .sneakWarning();
        }
       else if (pincode.isEmpty()) {
            Sneaker.with(this)
                    .setTitle("Enter Pincode")
                    .setMessage("")
                    .sneakWarning();
        } else if (password.isEmpty()) {
            Sneaker.with(this)
                    .setTitle("Enter password !")
                    .setMessage("")
                    .sneakWarning();
        } else if (!cpassword.equals(password)) {
            Sneaker.with(this)
                    .setTitle("confirm password not match!")
                    .setMessage("")
                    .sneakWarning();
        }*/
        else {
           binding.viewflipperRegistration.setDisplayedChild(1);
            getServeState();



        }


    }


    private void getState() {
        AppTools.showRequestDialog(this);

        stateModelList = new ArrayList<StateModel>();
        stateModel = new StateModel();


        Call<ResponseBody> bodyCall = ApiManager.getApi(this).GetState();

        bodyCall.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

                // Log.e("response", String.valueOf(response.body().toString()));

                //Toast.makeText(VenderReg.this, response.code(), Toast.LENGTH_SHORT).show();
                // Toast.makeText(VenderReg.this, response.body().getLocale()+"", Toast.LENGTH_SHORT).show();

                String s = null;


                if (response.isSuccessful() && response.body() != null && response.code() == 200) {
                    try {
                        s = response.body().string();
                        Log.e("response", s);
                        stateModel.setId("00");
                        stateModel.setName("Select State");

                        stateModelList.add(0, stateModel);

                        JSONObject jsonObject = new JSONObject(s);
                        JSONObject jsonObject1 = jsonObject.getJSONObject("data");
                        JSONArray jsonArray = jsonObject1.getJSONArray("states");
                        for (int i = 0; i <= jsonArray.length(); i++) {

                            JSONObject jsonObject2 = jsonArray.getJSONObject(i);

                            stateModel = new StateModel();
                            stateModel.setId(jsonObject2.getString("id"));
                            stateModel.setName(jsonObject2.getString("name"));
                            stateModel.setCountry_id(jsonObject2.getString("country_id"));

                            stateModelList.add(stateModel);
                            AppTools.hideDialog();

                            //   Toast.makeText(VenderReg.this, jsonObject2.getString("id") + "", Toast.LENGTH_SHORT).show();

                        }
                        /*
                         */
                    } catch (IOException | JSONException e) {
                        e.printStackTrace();
                    }

                    StateSpinnerAdapter coinSpinnerAdapter = new StateSpinnerAdapter(RegisterActivity.this, stateModelList);
                    binding.basicinformation.spinnerState.setAdapter(coinSpinnerAdapter);
                    binding.basicinformation.spinnerState.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


                            //  spinnertextview.setTextColor(Color.WHITE);
                            state_id = stateModelList.get(position).getId();


                            GetCity(state_id);

                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {
                        }
                    });

                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                //  loadingDialogs.dismissDialog();
                Toast.makeText(RegisterActivity.this, t.getLocalizedMessage() + "", Toast.LENGTH_SHORT).show();

            }
        });


    }

    private void GetCity(String id) {
        cityModelList = new ArrayList<>();
        CityModel stateModel = new CityModel();

        Call<ResponseBody> bodyCall = ApiManager.getApi(RegisterActivity.this).GetCity(id);

        bodyCall.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                Log.e("responseee", String.valueOf(response.code()));
//       Toast.makeText(VenderReg.this, response.code(), Toast.LENGTH_SHORT).show();
                // Toast.makeText(VenderReg.this, response.body().getLocale()+"", Toast.LENGTH_SHORT).show();

                String s = null;
                cityModelList.clear();

                if (response.isSuccessful() && response.body() != null && response.code() == 200) {
                    try {
                        s = response.body().string();
                        Log.e("response", s);
                        stateModel.setName("Select City");
                        stateModel.setId("00");

                        cityModelList.add(0, stateModel);

                        //    Toast.makeText(VenderReg.this, s + "", Toast.LENGTH_SHORT).show();
                        JSONObject jsonObject = new JSONObject(s);
                        JSONObject jsonObject1 = jsonObject.getJSONObject("data");
                        JSONArray jsonArray = jsonObject1.getJSONArray("cities");
                        for (int i = 0; i <= jsonArray.length(); i++) {
                            JSONObject jsonObject2 = jsonArray.getJSONObject(i);
                            CityModel stateModel = new CityModel();
                            stateModel.setId(jsonObject2.getString("id"));
                            stateModel.setName(jsonObject2.getString("name"));
                            cityModelList.add(stateModel);
                        }
                        /*
                         */
                    } catch (IOException | JSONException e) {
                        e.printStackTrace();
                    }
                    AppTools.hideDialog();

                    CitySpinnerAdapter coinSpinnerAdapter = new CitySpinnerAdapter(getApplicationContext(), cityModelList);

                    binding.basicinformation.cityspinner.setAdapter(coinSpinnerAdapter);
                    binding.basicinformation.cityspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


                            city_id = cityModelList.get(position).getId();


                            // GetCity(state_id);

                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {
                        }
                    });
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                //  loadingDialogs.dismissDialog();
                Toast.makeText(RegisterActivity.this, t.getLocalizedMessage() + "", Toast.LENGTH_SHORT).show();

            }
        });


    }

    private void showPickerDialog() {

        DatePickerDialog dtPickerDlg = new DatePickerDialog(this, android.R.style.Theme_Holo_Dialog, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                Calendar c = Calendar.getInstance();
                c.set(Calendar.YEAR, year);
                c.set(Calendar.MONTH, month);
                c.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                String mDate = DateFormat.format("yyyy-MM-dd", c).toString();
                binding.basicinformation.startDate.setText(mDate);
            }
        }, 2020, 01, 01);
        dtPickerDlg.getDatePicker().setSpinnersShown(true);
        dtPickerDlg.getDatePicker().setCalendarViewShown(false);
        dtPickerDlg.setTitle("Select  Date");
        dtPickerDlg.show();
    }

    private void getServeState() {
        AppTools.showRequestDialog(this);

        stateServeModelList = new ArrayList<StateModel>();
        stateModel = new StateModel();


        Call<ResponseBody> bodyCall = ApiManager.getApi(this).GetServeState();

        bodyCall.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

                // Log.e("response", String.valueOf(response.body().toString()));

                //Toast.makeText(VenderReg.this, response.code(), Toast.LENGTH_SHORT).show();
                // Toast.makeText(VenderReg.this, response.body().getLocale()+"", Toast.LENGTH_SHORT).show();

                String s = null;


                if (response.isSuccessful() && response.body() != null && response.code() == 200) {
                    try {
                        s = response.body().string();
                        Log.e("response", s);
                        stateModel.setId("00");
                        stateModel.setName("Select State");

                        stateServeModelList.add(0, stateModel);

                        JSONObject jsonObject = new JSONObject(s);
                        JSONObject jsonObject1 = jsonObject.getJSONObject("data");
                        JSONArray jsonArray = jsonObject1.getJSONArray("states");
                        for (int i = 0; i <= jsonArray.length(); i++) {

                            JSONObject jsonObject2 = jsonArray.getJSONObject(i);

                            stateModel = new StateModel();
                            stateModel.setId(jsonObject2.getString("id"));
                            stateModel.setName(jsonObject2.getString("name"));
                            stateModel.setCountry_id(jsonObject2.getString("country_id"));

                            stateServeModelList.add(stateModel);
                            AppTools.hideDialog();

                            //   Toast.makeText(VenderReg.this, jsonObject2.getString("id") + "", Toast.LENGTH_SHORT).show();

                        }
                        /*
                         */
                    } catch (IOException | JSONException e) {
                        e.printStackTrace();
                    }

                    StateSpinnerAdapter coinSpinnerAdapter = new StateSpinnerAdapter(RegisterActivity.this, stateServeModelList);
                    binding.servicelocation.ServeStateSpinner.setAdapter(coinSpinnerAdapter);
                    binding.servicelocation.ServeStateSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


                            //  spinnertextview.setTextColor(Color.WHITE);
                            Servestate_id = stateServeModelList.get(position).getId();


                            getServeCity(Servestate_id);

                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {
                        }
                    });

                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                //  loadingDialogs.dismissDialog();
                Toast.makeText(RegisterActivity.this, t.getLocalizedMessage() + "", Toast.LENGTH_SHORT).show();

            }
        });


    }
    private void getServeCity(String id) {
        cityServeModelList = new ArrayList<>();
        CityModel stateModel = new CityModel();

        Call<ResponseBody> bodyCall = ApiManager.getApi(RegisterActivity.this).GetServeCity(id);

        bodyCall.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                Log.e("responseee", String.valueOf(response.code()));
//       Toast.makeText(VenderReg.this, response.code(), Toast.LENGTH_SHORT).show();
                // Toast.makeText(VenderReg.this, response.body().getLocale()+"", Toast.LENGTH_SHORT).show();

                String s = null;
                cityServeModelList.clear();

                if (response.isSuccessful() && response.body() != null && response.code() == 200) {
                    try {
                        s = response.body().string();
                        Log.e("response", s);
                        stateModel.setName("Select City");
                        stateModel.setId("00");

                        cityServeModelList.add(0, stateModel);

                        //    Toast.makeText(VenderReg.this, s + "", Toast.LENGTH_SHORT).show();
                        JSONObject jsonObject = new JSONObject(s);
                        JSONObject jsonObject1 = jsonObject.getJSONObject("data");
                        JSONArray jsonArray = jsonObject1.getJSONArray("cities");
                        for (int i = 0; i <= jsonArray.length(); i++) {
                            JSONObject jsonObject2 = jsonArray.getJSONObject(i);
                            CityModel stateModel = new CityModel();
                            stateModel.setId(jsonObject2.getString("id"));
                            stateModel.setName(jsonObject2.getString("name"));
                            cityServeModelList.add(stateModel);
                        }
                        /*
                         */
                    } catch (IOException | JSONException e) {
                        e.printStackTrace();
                    }
                    AppTools.hideDialog();

                    CitySpinnerAdapter coinSpinnerAdapter = new CitySpinnerAdapter(getApplicationContext(), cityServeModelList);

                    binding.servicelocation.ServeCitySpinner.setAdapter(coinSpinnerAdapter);
                    binding.servicelocation.ServeCitySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


                            Servecity_id = cityServeModelList.get(position).getId();


                            // GetCity(state_id);

                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {
                        }
                    });
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                //  loadingDialogs.dismissDialog();
                Toast.makeText(RegisterActivity.this, t.getLocalizedMessage() + "", Toast.LENGTH_SHORT).show();

            }
        });


    }

}